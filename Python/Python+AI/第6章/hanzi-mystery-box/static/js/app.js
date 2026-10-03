/* ============================================================
   汉字谜盒 - 前端逻辑
   ============================================================ */

(function () {
    'use strict';

    /* ---------- 配置 ---------- */
    const API = {
        sessions: '/api/sessions',
        session: (id) => `/api/sessions/${id}`,
        chat: '/api/chat'
    };

    /* ---------- 状态 ---------- */
    const state = {
        currentSessionId: null,
        sessions: [],          // [{ id, title }]
        sending: false         // 是否正在等待 AI 响应
    };

    /* ---------- DOM ---------- */
    const $ = (sel) => document.querySelector(sel);
    const dom = {
        sidebar: $('#sidebar'),
        sessionList: $('#sessionList'),
        newSessionBtn: $('#newSessionBtn'),
        searchInput: $('#searchInput'),
        topbarTitle: $('#topbarTitle'),
        messages: $('#messages'),
        welcomeScreen: $('#welcomeScreen'),
        startBtn: $('#startBtn'),
        quickActions: $('#quickActions'),
        messageInput: $('#messageInput'),
        sendBtn: $('#sendBtn'),
        toastWrap: $('#toastWrap'),
        confirmMask: $('#confirmMask'),
        confirmTitle: $('#confirmTitle'),
        confirmText: $('#confirmText'),
        confirmOk: $('#confirmOk'),
        confirmCancel: $('#confirmCancel')
    };

    /* ============================================================
       工具函数
       ============================================================ */

    /** 统一 fetch 封装，自动处理 ApiResponse 结构与异常 */
    async function request(url, options = {}) {
        const opts = Object.assign(
            {
                headers: { 'Content-Type': 'application/json' }
            },
            options
        );
        let res;
        try {
            res = await fetch(url, opts);
        } catch (e) {
            throw new Error('网络连接失败，请检查网络后重试');
        }

        let body;
        try {
            body = await res.json();
        } catch (e) {
            throw new Error('服务器返回了无效的数据');
        }

        if (!res.ok || body.code !== 200) {
            const msg = (body && body.message) || `请求失败（HTTP ${res.status}）`;
            throw new Error(msg);
        }
        return body.data;
    }

    /** 轻提示 Toast */
    function toast(message, type = '') {
        const el = document.createElement('div');
        el.className = `toast ${type}`;
        el.textContent = message;
        dom.toastWrap.appendChild(el);
        setTimeout(() => {
            el.classList.add('fade-out');
            setTimeout(() => el.remove(), 300);
        }, 2600);
    }

    /** 转义 HTML，防止注入 */
    function escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text == null ? '' : String(text);
        return div.innerHTML;
    }

    /** 将文本中的换行符转为 <br>，并保留转义 */
    function formatText(text) {
        return escapeHtml(text).replace(/\n/g, '<br>');
    }

    /** 把 session_id（如 2026-04-21_22-20-30）格式化为友好标题 */
    function sessionTitle(id) {
        if (!id) return '新会话';
        // 2026-04-21_22-20-30 -> 04-21 22:20
        const m = id.match(/^(\d{4})-(\d{2})-(\d{2})_(\d{2})-(\d{2})-(\d{2})$/);
        if (m) {
            return `${m[2]}-${m[3]} ${m[4]}:${m[5]}`;
        }
        return id;
    }

    /** 滚动消息区到底部 */
    function scrollBottom() {
        requestAnimationFrame(() => {
            dom.messages.scrollTop = dom.messages.scrollHeight;
        });
    }

    /** 自动调整输入框高度 */
    function autoGrow() {
        const ta = dom.messageInput;
        ta.style.height = 'auto';
        ta.style.height = Math.min(ta.scrollHeight, 140) + 'px';
    }

    /* ============================================================
       会话列表
       ============================================================ */

    /** 加载会话列表 */
    async function loadSessions() {
        try {
            const ids = await request(API.sessions);
            state.sessions = (ids || []).map((id) => ({ id, title: sessionTitle(id) }));
        } catch (e) {
            state.sessions = [];
            toast(e.message, 'error');
        }
        renderSessionList();
    }

    /** 渲染会话列表 */
    function renderSessionList() {
        const keyword = (dom.searchInput.value || '').trim().toLowerCase();

        let list = state.sessions;
        if (keyword) {
            list = list.filter((s) => s.id.toLowerCase().includes(keyword) || s.title.toLowerCase().includes(keyword));
        }

        dom.sessionList.innerHTML = '';

        if (state.sessions.length === 0) {
            dom.sessionList.innerHTML = '<div class="empty-hint">点击「新建会话」开始猜谜</div>';
            return;
        }

        if (list.length === 0) {
            dom.sessionList.innerHTML = '<div class="empty-hint">没有匹配的会话</div>';
            return;
        }

        const frag = document.createDocumentFragment();
        list.forEach((s) => {
            const item = document.createElement('div');
            item.className = 'session-item' + (s.id === state.currentSessionId ? ' active' : '');
            item.dataset.id = s.id;
            item.title = s.title;   // 悬停显示完整标题
            item.innerHTML = `
                <div class="session-item-icon">谜</div>
                <span class="session-item-text">${escapeHtml(s.title)}</span>
                <button class="session-item-delete" title="删除" aria-label="删除会话">
                    <svg viewBox="0 0 24 24" width="15" height="15" fill="none" stroke="currentColor" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"><polyline points="3 6 5 6 21 6"/><path d="M19 6l-1 14a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2L5 6"/><path d="M10 11v6M14 11v6"/><path d="M9 6V4a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2"/></svg>
                </button>
            `;
            // 点击切换会话
            item.addEventListener('click', (e) => {
                if (e.target.closest('.session-item-delete')) return;
                if (state.sending) {
                    toast('AI 正在回复，请稍候…');
                    return;
                }
                switchSession(s.id);
            });
            // 删除按钮
            item.querySelector('.session-item-delete').addEventListener('click', (e) => {
                e.stopPropagation();
                if (state.sending) {
                    toast('AI 正在回复，请稍候…');
                    return;
                }
                confirmDelete(s.id);
            });
            frag.appendChild(item);
        });
        dom.sessionList.appendChild(frag);
    }

    /* ============================================================
       新建 / 切换 / 删除 会话
       ============================================================ */

    /** 新建会话 */
    async function createSession() {
        try {
            const id = await request(API.sessions, { method: 'POST' });
            state.sessions.unshift({ id, title: sessionTitle(id) });
            state.currentSessionId = id;
            dom.topbarTitle.textContent = sessionTitle(id);
            renderSessionList();
            clearMessages(true);
            // 新会话创建后，主动让 AI 开场（发送一个开场白）
            await sendOpeningMessage();
        } catch (e) {
            toast(e.message, 'error');
        }
    }

    /** 确保存在当前会话；若无则静默创建一个（不发送开场白） */
    async function ensureSession() {
        if (state.currentSessionId) return true;
        try {
            const id = await request(API.sessions, { method: 'POST' });
            state.sessions.unshift({ id, title: sessionTitle(id) });
            state.currentSessionId = id;
            dom.topbarTitle.textContent = sessionTitle(id);
            renderSessionList();
            clearMessages(true);
            return true;
        } catch (e) {
            toast(e.message, 'error');
            return false;
        }
    }

    /** 切换到指定会话并加载历史 */
    async function switchSession(id) {
        if (id === state.currentSessionId) {
            return;
        }
        try {
            const data = await request(API.session(id));
            state.currentSessionId = id;
            dom.topbarTitle.textContent = sessionTitle(id);
            renderSessionList();
            renderHistory(data.messages || []);
        } catch (e) {
            toast(e.message, 'error');
        }
    }

    /** 确认删除会话（居中模态弹窗） */
    let pendingDeleteId = null;

    function confirmDelete(id) {
        pendingDeleteId = id;
        const isCurrent = id === state.currentSessionId;
        dom.confirmTitle.textContent = isCurrent ? '删除当前会话' : '删除会话';
        dom.confirmText.textContent = isCurrent
            ? '删除后将无法恢复，且当前会话会被清空。'
            : '删除后将无法恢复，确定继续吗？';
        dom.confirmMask.classList.add('show');
    }

    function hideConfirmPop() {
        dom.confirmMask.classList.remove('show');
        pendingDeleteId = null;
    }

    /** 执行删除 */
    async function doDelete(id) {
        try {
            await request(API.session(id), { method: 'DELETE' });
            state.sessions = state.sessions.filter((s) => s.id !== id);
            if (state.currentSessionId === id) {
                state.currentSessionId = null;
                dom.topbarTitle.textContent = '新会话';
                clearMessages(true);
            }
            renderSessionList();
            toast('会话已删除', 'error');
        } catch (e) {
            toast(e.message, 'error');
        }
    }

    /* ============================================================
       消息渲染
       ============================================================ */

    /** 清空消息区，显示/隐藏欢迎屏 */
    function clearMessages(showWelcome) {
        // 移除所有 .msg，保留欢迎屏
        Array.from(dom.messages.querySelectorAll('.msg')).forEach((el) => el.remove());
        dom.welcomeScreen.style.display = showWelcome ? 'grid' : 'none';
        dom.quickActions.style.display = showWelcome ? 'none' : 'flex';
    }

    /** 根据历史 messages 渲染 */
    function renderHistory(messages) {
        clearMessages(messages.length === 0);
        messages.forEach((m) => {
            if (m.role === 'user' || m.role === 'assistant') {
                appendMessage(m.role === 'user' ? 'user' : 'ai', m.content, false);
            }
        });
        scrollBottom();
    }

    /** 追加一条消息气泡，返回该节点 */
    function appendMessage(who, content, scroll = true) {
        const wrap = document.createElement('div');
        wrap.className = 'message-wrap';

        const msg = document.createElement('div');
        msg.className = `msg ${who}`;
        const avatar = who === 'ai' ? '谜' : '我';
        msg.innerHTML = `
            <div class="msg-avatar">${avatar}</div>
            <div>
                <div class="msg-bubble lg">${formatText(content)}</div>
            </div>
        `;
        wrap.appendChild(msg);
        dom.messages.appendChild(wrap);
        if (scroll) scrollBottom();
        return msg;
    }

    /** 显示 AI 正在输入气泡 */
    function showTyping() {
        const wrap = document.createElement('div');
        wrap.className = 'message-wrap typing-wrap';
        const msg = document.createElement('div');
        msg.className = 'msg ai';
        msg.innerHTML = `
            <div class="msg-avatar">谜</div>
            <div>
                <div class="msg-bubble lg">
                    <span class="typing"><span></span><span></span><span></span></span>
                </div>
            </div>
        `;
        wrap.appendChild(msg);
        dom.messages.appendChild(wrap);
        scrollBottom();
        return wrap;
    }

    /** 将正在输入气泡替换为真实内容 */
    function fillTyping(typingWrap, content) {
        const bubble = typingWrap.querySelector('.msg-bubble');
        if (bubble) bubble.innerHTML = formatText(content);
        scrollBottom();
    }

    /* ============================================================
       发送消息
       ============================================================ */

    /** 发送消息核心逻辑 */
    async function sendMessage(text) {
        text = (text || '').trim();
        if (!text) return;
        if (state.sending) return;
        // 没有会话时自动创建一个，避免提示用户手动创建
        if (!state.currentSessionId) {
            const ok = await ensureSession();
            if (!ok) return;
        }

        // 隐藏欢迎屏
        if (dom.welcomeScreen.style.display !== 'none') {
            clearMessages(false);
        }

        // 先把用户消息显示出来
        appendMessage('user', text);

        // 锁定
        state.sending = true;
        dom.sendBtn.disabled = true;
        dom.messageInput.value = '';
        autoGrow();

        const typingWrap = showTyping();

        try {
            const reply = await request(API.chat, {
                method: 'POST',
                body: JSON.stringify({ session_id: state.currentSessionId, message: text })
            });
            fillTyping(typingWrap, reply);
        } catch (e) {
            typingWrap.remove();
            toast(e.message, 'error');
        } finally {
            state.sending = false;
            dom.sendBtn.disabled = false;
            dom.messageInput.focus();
        }
    }

    /** 新会话开场：自动发送一句问候让 AI 出第一道题 */
    async function sendOpeningMessage() {
        if (state.sending) return;
        state.sending = true;
        dom.sendBtn.disabled = true;
        const typingWrap = showTyping();
        try {
            const reply = await request(API.chat, {
                method: 'POST',
                body: JSON.stringify({
                    session_id: state.currentSessionId,
                    message: '你好，请出一道字谜考考我吧！'
                })
            });
            fillTyping(typingWrap, reply);
        } catch (e) {
            typingWrap.remove();
            toast(e.message, 'error');
        } finally {
            state.sending = false;
            dom.sendBtn.disabled = false;
            dom.messageInput.focus();
        }
    }

    /* ============================================================
       确认弹窗逻辑
       ============================================================ */
    function bindConfirm() {
        dom.confirmCancel.addEventListener('click', hideConfirmPop);
        dom.confirmOk.addEventListener('click', async () => {
            const id = pendingDeleteId;
            hideConfirmPop();
            if (id) await doDelete(id);
        });
        // 点击遮罩层关闭
        dom.confirmMask.addEventListener('click', (e) => {
            if (e.target === dom.confirmMask) hideConfirmPop();
        });
        // Esc 关闭
        document.addEventListener('keydown', (e) => {
            if (e.key === 'Escape') hideConfirmPop();
        });
    }

    /* ============================================================
       鼠标跟随高光绑定
       通过事件委托，为所有 .lg 元素动态更新光晕位置
       ============================================================ */
    function bindGlassGlow() {
        let ticking = false;
        let lastX = 0, lastY = 0;
        document.addEventListener('mousemove', (e) => {
            lastX = e.clientX;
            lastY = e.clientY;
            if (ticking) return;
            ticking = true;
            requestAnimationFrame(() => {
                const el = document.elementFromPoint(lastX, lastY);
                if (el) {
                    const glass = el.closest('.lg');
                    if (glass) {
                        const r = glass.getBoundingClientRect();
                        glass.style.setProperty('--mx', (lastX - r.left) + 'px');
                        glass.style.setProperty('--my', (lastY - r.top) + 'px');
                    }
                }
                ticking = false;
            });
        }, { passive: true });
    }

    /* ============================================================
       事件绑定
       ============================================================ */
    function bindEvents() {
        // 新建会话
        dom.newSessionBtn.addEventListener('click', () => {
            if (state.sending) {
                toast('AI 正在回复，请稍候…');
                return;
            }
            createSession();
        });

        // 开始按钮
        dom.startBtn.addEventListener('click', () => {
            if (state.currentSessionId) {
                // 已有会话，直接开场
                dom.messageInput.focus();
            } else {
                createSession();
            }
        });

        // 输入框
        dom.messageInput.addEventListener('input', autoGrow);
        dom.messageInput.addEventListener('keydown', (e) => {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                sendMessage(dom.messageInput.value);
            }
        });

        // 发送按钮
        dom.sendBtn.addEventListener('click', () => sendMessage(dom.messageInput.value));

        // 快捷操作
        dom.quickActions.addEventListener('click', (e) => {
            const chip = e.target.closest('.chip');
            if (!chip) return;
            const text = chip.dataset.text;
            sendMessage(text);
        });

        // 搜索
        dom.searchInput.addEventListener('input', renderSessionList);

        // 确认弹窗
        bindConfirm();
    }

    /* ============================================================
       初始化
       ============================================================ */
    async function init() {
        bindEvents();
        bindGlassGlow();
        autoGrow();
        await loadSessions();
        // 自动选中最新会话
        if (state.sessions.length > 0) {
            switchSession(state.sessions[0].id);
        }
    }

    document.addEventListener('DOMContentLoaded', init);
})();
