package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultChannelPipeline implements ChannelPipeline {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Channel channel;
    private Map<EventExecutorGroup, EventExecutor> childExecutors;
    private MessageSizeEstimator.Handle estimatorHandle;
    final AbstractChannelHandlerContext head;
    private PendingHandlerCallback pendingHandlerCallbackHead;
    private boolean registered;
    private final ChannelFuture succeededFuture;
    final AbstractChannelHandlerContext tail;
    private final VoidChannelPromise voidPromise;
    static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
    private static final String HEAD_NAME = generateName0(HeadContext.class);
    private static final String TAIL_NAME = generateName0(TailContext.class);
    private static final FastThreadLocal<Map<Class<?>, String>> nameCaches = new FastThreadLocal<Map<Class<?>, String>>() { // from class: io.netty.channel.DefaultChannelPipeline.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Map<Class<?>, String> initialValue() throws Exception {
            return new WeakHashMap();
        }
    };
    private final boolean touch = ResourceLeakDetector.isEnabled();
    private boolean firstRegistration = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    final class HeadContext extends AbstractChannelHandlerContext implements ChannelOutboundHandler, ChannelInboundHandler {
        private final Channel.Unsafe unsafe;

        HeadContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, DefaultChannelPipeline.HEAD_NAME, false, true);
            this.unsafe = defaultChannelPipeline.channel().unsafe();
            setAddComplete();
        }

        private void readIfIsAutoRead() {
            if (DefaultChannelPipeline.this.channel.config().isAutoRead()) {
                DefaultChannelPipeline.this.channel.read();
            }
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
            this.unsafe.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            channelHandlerContext.fireChannelActive();
            readIfIsAutoRead();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            channelHandlerContext.fireChannelInactive();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            channelHandlerContext.fireChannelRead(obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
            channelHandlerContext.fireChannelReadComplete();
            readIfIsAutoRead();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
            DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
            channelHandlerContext.fireChannelRegistered();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
            channelHandlerContext.fireChannelUnregistered();
            if (DefaultChannelPipeline.this.channel.isOpen()) {
                return;
            }
            DefaultChannelPipeline.this.destroy();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
            channelHandlerContext.fireChannelWritabilityChanged();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.unsafe.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
            this.unsafe.connect(socketAddress, socketAddress2, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.unsafe.deregister(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
            this.unsafe.disconnect(channelPromise);
        }

        @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            channelHandlerContext.fireExceptionCaught(th);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
            this.unsafe.flush();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void read(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.beginRead();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            channelHandlerContext.fireUserEventTriggered(obj);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
            this.unsafe.write(obj, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class PendingHandlerAddedTask extends PendingHandlerCallback {
        PendingHandlerAddedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        @Override // io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e4) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e4);
                }
                DefaultChannelPipeline.remove0(this.ctx);
                this.ctx.setRemoved();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class PendingHandlerCallback implements Runnable {
        final AbstractChannelHandlerContext ctx;
        PendingHandlerCallback next;

        PendingHandlerCallback(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.ctx = abstractChannelHandlerContext;
        }

        abstract void execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class PendingHandlerRemovedTask extends PendingHandlerCallback {
        PendingHandlerRemovedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        @Override // io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor executor = this.ctx.executor();
            if (executor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
                return;
            }
            try {
                executor.execute(this);
            } catch (RejectedExecutionException e4) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", executor, this.ctx.name(), e4);
                }
                this.ctx.setRemoved();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        TailContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, DefaultChannelPipeline.TAIL_NAME, true, false);
            setAddComplete();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            DefaultChannelPipeline.this.onUnhandledInboundMessage(obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            DefaultChannelPipeline.this.onUnhandledInboundException(th);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            ReferenceCountUtil.release(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultChannelPipeline(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
        this.succeededFuture = new SucceededChannelFuture(channel, null);
        this.voidPromise = new VoidChannelPromise(channel, true);
        TailContext tailContext = new TailContext(this);
        this.tail = tailContext;
        HeadContext headContext = new HeadContext(this);
        this.head = headContext;
        headContext.next = tailContext;
        tailContext.prev = headContext;
    }

    private static void addAfter0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext.next.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
    }

    private static void addBefore0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext.prev;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext.prev.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
    }

    private void addFirst0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head.next;
        abstractChannelHandlerContext.prev = this.head;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
        this.head.next = abstractChannelHandlerContext;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext;
    }

    private void addLast0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail.prev;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = this.tail;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        this.tail.prev = abstractChannelHandlerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerAdded0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.handler().handlerAdded(abstractChannelHandlerContext);
            abstractChannelHandlerContext.setAddComplete();
        } catch (Throwable th) {
            boolean z3 = false;
            try {
                remove0(abstractChannelHandlerContext);
                abstractChannelHandlerContext.handler().handlerRemoved(abstractChannelHandlerContext);
                abstractChannelHandlerContext.setRemoved();
                z3 = true;
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isWarnEnabled()) {
                    internalLogger.warn("Failed to remove a handler: " + abstractChannelHandlerContext.name(), th2);
                }
            }
            if (z3) {
                fireExceptionCaught((Throwable) new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", th));
                return;
            }
            fireExceptionCaught((Throwable) new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", th));
        }
    }

    private void callHandlerAddedForAllHandlers() {
        PendingHandlerCallback pendingHandlerCallback;
        synchronized (this) {
            this.registered = true;
            this.pendingHandlerCallbackHead = null;
        }
        for (pendingHandlerCallback = this.pendingHandlerCallbackHead; pendingHandlerCallback != null; pendingHandlerCallback = pendingHandlerCallback.next) {
            pendingHandlerCallback.execute();
        }
    }

    private void callHandlerCallbackLater(AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z3) {
        PendingHandlerCallback pendingHandlerAddedTask = z3 ? new PendingHandlerAddedTask(abstractChannelHandlerContext) : new PendingHandlerRemovedTask(abstractChannelHandlerContext);
        PendingHandlerCallback pendingHandlerCallback = this.pendingHandlerCallbackHead;
        if (pendingHandlerCallback == null) {
            this.pendingHandlerCallbackHead = pendingHandlerAddedTask;
            return;
        }
        while (true) {
            PendingHandlerCallback pendingHandlerCallback2 = pendingHandlerCallback.next;
            if (pendingHandlerCallback2 == null) {
                pendingHandlerCallback.next = pendingHandlerAddedTask;
                return;
            }
            pendingHandlerCallback = pendingHandlerCallback2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerRemoved0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.handler().handlerRemoved(abstractChannelHandlerContext);
            abstractChannelHandlerContext.setRemoved();
        } catch (Throwable th) {
            fireExceptionCaught((Throwable) new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
        }
    }

    private void checkDuplicateName(String str) {
        if (context0(str) == null) {
            return;
        }
        throw new IllegalArgumentException("Duplicate handler name: " + str);
    }

    private static void checkMultiplicity(ChannelHandler channelHandler) {
        if (channelHandler instanceof ChannelHandlerAdapter) {
            ChannelHandlerAdapter channelHandlerAdapter = (ChannelHandlerAdapter) channelHandler;
            if (!channelHandlerAdapter.isSharable() && channelHandlerAdapter.added) {
                throw new ChannelPipelineException(channelHandlerAdapter.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
            }
            channelHandlerAdapter.added = true;
        }
    }

    private EventExecutor childExecutor(EventExecutorGroup eventExecutorGroup) {
        if (eventExecutorGroup == null) {
            return null;
        }
        Boolean bool = (Boolean) this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
        if (bool != null && !bool.booleanValue()) {
            return eventExecutorGroup.next();
        }
        Map map = this.childExecutors;
        if (map == null) {
            map = new IdentityHashMap(4);
            this.childExecutors = map;
        }
        EventExecutor eventExecutor = (EventExecutor) map.get(eventExecutorGroup);
        if (eventExecutor == null) {
            EventExecutor next = eventExecutorGroup.next();
            map.put(eventExecutorGroup, next);
            return next;
        }
        return eventExecutor;
    }

    private AbstractChannelHandlerContext context0(String str) {
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.name().equals(str)) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroy() {
        destroyUp(this.head.next, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyDown(Thread thread, final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z3) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (!z3 && !executor.inEventLoop(thread)) {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.9
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), abstractChannelHandlerContext, true);
                    }
                });
                return;
            }
            synchronized (this) {
                remove0(abstractChannelHandlerContext);
            }
            callHandlerRemoved0(abstractChannelHandlerContext);
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
            z3 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyUp(final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z3) {
        Thread currentThread = Thread.currentThread();
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (!z3 && !executor.inEventLoop(currentThread)) {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.8
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyUp(abstractChannelHandlerContext, true);
                    }
                });
                return;
            } else {
                abstractChannelHandlerContext = abstractChannelHandlerContext.next;
                z3 = false;
            }
        }
        destroyDown(currentThread, abstractChannelHandlerContext2.prev, z3);
    }

    private String filterName(String str, ChannelHandler channelHandler) {
        if (str == null) {
            return generateName(channelHandler);
        }
        checkDuplicateName(str);
        return str;
    }

    private String generateName(ChannelHandler channelHandler) {
        Map<Class<?>, String> map = nameCaches.get();
        Class<?> cls = channelHandler.getClass();
        String str = map.get(cls);
        if (str == null) {
            str = generateName0(cls);
            map.put(cls, str);
        }
        if (context0(str) != null) {
            int i4 = 1;
            String substring = str.substring(0, str.length() - 1);
            while (true) {
                str = substring + i4;
                if (context0(str) == null) {
                    break;
                }
                i4++;
            }
        }
        return str;
    }

    private static String generateName0(Class<?> cls) {
        return StringUtil.simpleClassName(cls) + "#0";
    }

    private AbstractChannelHandlerContext getContextOrDie(String str) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(str);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(str);
    }

    private AbstractChannelHandlerContext newContext(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        return new DefaultChannelHandlerContext(this, childExecutor(eventExecutorGroup), str, channelHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void remove0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext2;
    }

    private static void replace0(AbstractChannelHandlerContext abstractChannelHandlerContext, AbstractChannelHandlerContext abstractChannelHandlerContext2) {
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext4 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.prev = abstractChannelHandlerContext3;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext4;
        abstractChannelHandlerContext3.next = abstractChannelHandlerContext2;
        abstractChannelHandlerContext4.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = abstractChannelHandlerContext2;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(String str, String str2, ChannelHandler channelHandler) {
        return addAfter(null, str, str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(String str, String str2, ChannelHandler channelHandler) {
        return addBefore(null, str, str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(String str, ChannelHandler channelHandler) {
        return addFirst(null, str, channelHandler);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(String str, ChannelHandler channelHandler) {
        return addLast(null, str, channelHandler);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress socketAddress) {
        return this.tail.bind(socketAddress);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final Channel channel() {
        return this.channel;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return this.tail.close();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress) {
        return this.tail.connect(socketAddress);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(String str) {
        if (str != null) {
            return context0(str);
        }
        throw new NullPointerException("name");
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister() {
        return this.tail.deregister();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect() {
        return this.tail.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MessageSizeEstimator.Handle estimatorHandle() {
        if (this.estimatorHandle == null) {
            this.estimatorHandle = this.channel.config().getMessageSizeEstimator().newHandle();
        }
        return this.estimatorHandle;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler first() {
        ChannelHandlerContext firstContext = firstContext();
        if (firstContext == null) {
            return null;
        }
        return firstContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext firstContext() {
        if (this.head.next == this.tail) {
            return null;
        }
        return this.head.next;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler get(String str) {
        ChannelHandlerContext context = context(str);
        if (context == null) {
            return null;
        }
        return context.handler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void invokeHandlerAddedIfNeeded() {
        if (this.firstRegistration) {
            this.firstRegistration = false;
            callHandlerAddedForAllHandlers();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<String, ChannelHandler>> iterator() {
        return toMap().entrySet().iterator();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler last() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext lastContext() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.tail.prev;
        if (abstractChannelHandlerContext == this.head) {
            return null;
        }
        return abstractChannelHandlerContext;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final List<String> names() {
        ArrayList arrayList = new ArrayList();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            arrayList.add(abstractChannelHandlerContext.name());
        }
        return arrayList;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(this.channel, null, th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this.channel);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newSucceededFuture() {
        return this.succeededFuture;
    }

    protected void onUnhandledInboundException(Throwable th) {
        try {
            logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
        } finally {
            ReferenceCountUtil.release(th);
        }
    }

    protected void onUnhandledInboundMessage(Object obj) {
        try {
            logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", obj);
        } finally {
            ReferenceCountUtil.release(obj);
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline remove(ChannelHandler channelHandler) {
        remove(getContextOrDie(channelHandler));
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeFirst() {
        if (this.head.next != this.tail) {
            return remove(this.head.next).handler();
        }
        throw new NoSuchElementException();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeLast() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        if (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            return remove(abstractChannelHandlerContext2.prev).handler();
        }
        throw new NoSuchElementException();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) {
        replace(getContextOrDie(channelHandler), str, channelHandler2);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            linkedHashMap.put(abstractChannelHandlerContext.name(), abstractChannelHandlerContext.handler());
        }
        return linkedHashMap;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append('{');
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        while (abstractChannelHandlerContext != this.tail) {
            sb.append('(');
            sb.append(abstractChannelHandlerContext.name());
            sb.append(" = ");
            sb.append(abstractChannelHandlerContext.handler().getClass().getName());
            sb.append(')');
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
            if (abstractChannelHandlerContext == this.tail) {
                break;
            }
            sb.append(", ");
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object touch(Object obj, AbstractChannelHandlerContext abstractChannelHandlerContext) {
        return this.touch ? ReferenceCountUtil.touch(obj, abstractChannelHandlerContext) : obj;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object obj) {
        return this.tail.write(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        return this.tail.writeAndFlush(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        synchronized (this) {
            checkMultiplicity(channelHandler);
            String filterName = filterName(str2, channelHandler);
            AbstractChannelHandlerContext contextOrDie = getContextOrDie(str);
            final AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName, channelHandler);
            addAfter0(contextOrDie, newContext);
            if (!this.registered) {
                newContext.setAddPending();
                callHandlerCallbackLater(newContext, true);
                return this;
            }
            EventExecutor executor = newContext.executor();
            if (!executor.inEventLoop()) {
                newContext.setAddPending();
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.5
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                    }
                });
                return this;
            }
            callHandlerAdded0(newContext);
            return this;
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(EventExecutorGroup eventExecutorGroup, String str, String str2, ChannelHandler channelHandler) {
        synchronized (this) {
            checkMultiplicity(channelHandler);
            String filterName = filterName(str2, channelHandler);
            AbstractChannelHandlerContext contextOrDie = getContextOrDie(str);
            final AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName, channelHandler);
            addBefore0(contextOrDie, newContext);
            if (!this.registered) {
                newContext.setAddPending();
                callHandlerCallbackLater(newContext, true);
                return this;
            }
            EventExecutor executor = newContext.executor();
            if (!executor.inEventLoop()) {
                newContext.setAddPending();
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                    }
                });
                return this;
            }
            callHandlerAdded0(newContext);
            return this;
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            checkMultiplicity(channelHandler);
            final AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName(str, channelHandler), channelHandler);
            addFirst0(newContext);
            if (!this.registered) {
                newContext.setAddPending();
                callHandlerCallbackLater(newContext, true);
                return this;
            }
            EventExecutor executor = newContext.executor();
            if (!executor.inEventLoop()) {
                newContext.setAddPending();
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                    }
                });
                return this;
            }
            callHandlerAdded0(newContext);
            return this;
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            checkMultiplicity(channelHandler);
            final AbstractChannelHandlerContext newContext = newContext(eventExecutorGroup, filterName(str, channelHandler), channelHandler);
            addLast0(newContext);
            if (!this.registered) {
                newContext.setAddPending();
                callHandlerCallbackLater(newContext, true);
                return this;
            }
            EventExecutor executor = newContext.executor();
            if (!executor.inEventLoop()) {
                newContext.setAddPending();
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                    }
                });
                return this;
            }
            callHandlerAdded0(newContext);
            return this;
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise channelPromise) {
        return this.tail.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return this.tail.connect(socketAddress, socketAddress2);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister(ChannelPromise channelPromise) {
        return this.tail.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        return this.tail.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelRead(Object obj) {
        AbstractChannelHandlerContext.invokeChannelRead(this.head, obj);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireExceptionCaught(Throwable th) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.head, th);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public final ChannelPipeline fireUserEventTriggered(Object obj) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, obj);
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler remove(String str) {
        return remove(getContextOrDie(str)).handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        return replace(getContextOrDie(str), str2, channelHandler);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        return this.tail.write(obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object obj) {
        return this.tail.writeAndFlush(obj);
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(channelHandler);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(channelHandler.getClass().getName());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(ChannelHandler channelHandler) {
        if (channelHandler != null) {
            for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
                if (abstractChannelHandlerContext.handler() == channelHandler) {
                    return abstractChannelHandlerContext;
                }
            }
            return null;
        }
        throw new NullPointerException("handler");
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext context = context(cls);
        if (context == null) {
            return null;
        }
        return (T) context.handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T remove(Class<T> cls) {
        return (T) remove(getContextOrDie(cls)).handler();
    }

    @Override // io.netty.channel.ChannelPipeline
    public final <T extends ChannelHandler> T replace(Class<T> cls, String str, ChannelHandler channelHandler) {
        return (T) replace(getContextOrDie(cls), str, channelHandler);
    }

    private AbstractChannelHandlerContext remove(final AbstractChannelHandlerContext abstractChannelHandlerContext) {
        synchronized (this) {
            remove0(abstractChannelHandlerContext);
            if (!this.registered) {
                callHandlerCallbackLater(abstractChannelHandlerContext, false);
                return abstractChannelHandlerContext;
            }
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (!executor.inEventLoop()) {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.6
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                    }
                });
                return abstractChannelHandlerContext;
            }
            callHandlerRemoved0(abstractChannelHandlerContext);
            return abstractChannelHandlerContext;
        }
    }

    private ChannelHandler replace(final AbstractChannelHandlerContext abstractChannelHandlerContext, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            checkMultiplicity(channelHandler);
            if (str == null) {
                str = generateName(channelHandler);
            } else if (!abstractChannelHandlerContext.name().equals(str)) {
                checkDuplicateName(str);
            }
            final AbstractChannelHandlerContext newContext = newContext(abstractChannelHandlerContext.executor, str, channelHandler);
            replace0(abstractChannelHandlerContext, newContext);
            if (!this.registered) {
                callHandlerCallbackLater(newContext, true);
                callHandlerCallbackLater(abstractChannelHandlerContext, false);
                return abstractChannelHandlerContext.handler();
            }
            EventExecutor executor = abstractChannelHandlerContext.executor();
            if (!executor.inEventLoop()) {
                executor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.7
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(newContext);
                        DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                    }
                });
                return abstractChannelHandlerContext.handler();
            }
            callHandlerAdded0(newContext);
            callHandlerRemoved0(abstractChannelHandlerContext);
            return abstractChannelHandlerContext.handler();
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        return this.tail.connect(socketAddress, socketAddress2, channelPromise);
    }

    private AbstractChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> cls) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(cls);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(cls.getName());
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(Class<? extends ChannelHandler> cls) {
        if (cls != null) {
            for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
                if (cls.isAssignableFrom(abstractChannelHandlerContext.handler().getClass())) {
                    return abstractChannelHandlerContext;
                }
            }
            return null;
        }
        throw new NullPointerException("handlerType");
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandler... channelHandlerArr) {
        return addLast((EventExecutorGroup) null, channelHandlerArr);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandler... channelHandlerArr) {
        return addFirst((EventExecutorGroup) null, channelHandlerArr);
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr != null) {
            for (ChannelHandler channelHandler : channelHandlerArr) {
                if (channelHandler == null) {
                    break;
                }
                addLast(eventExecutorGroup, null, channelHandler);
            }
            return this;
        }
        throw new NullPointerException("handlers");
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr != null) {
            if (channelHandlerArr.length != 0 && channelHandlerArr[0] != null) {
                int i4 = 1;
                while (i4 < channelHandlerArr.length && channelHandlerArr[i4] != null) {
                    i4++;
                }
                for (int i5 = i4 - 1; i5 >= 0; i5--) {
                    addFirst(eventExecutorGroup, null, channelHandlerArr[i5]);
                }
            }
            return this;
        }
        throw new NullPointerException("handlers");
    }
}
