package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.channel.PendingWriteQueue;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile long closeNotifyTimeoutMillis;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private final SSLEngine engine;
    private boolean firedChannelRead;
    private boolean flushedBeforeHandshake;
    private Promise<Channel> handshakePromise;
    private volatile long handshakeTimeoutMillis;
    private final int maxPacketBufferSize;
    private boolean needsFlush;
    private boolean outboundClosed;
    private int packetLength;
    private PendingWriteQueue pendingUnencryptedWrites;
    private boolean readDuringHandshake;
    private boolean sentFirstMessage;
    private final ByteBuffer[] singleBuffer;
    private final LazyChannelPromise sslCloseFuture;
    private final boolean startTls;
    private final boolean wantsDirectBuffer;
    private final boolean wantsLargeOutboundNetworkBuffer;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslHandler.class);
    private static final Pattern IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
    private static final Pattern IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);
    private static final SSLException SSLENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("SSLEngine closed already"), SslHandler.class, "wrap(...)");
    private static final SSLException HANDSHAKE_TIMED_OUT = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("handshake timed out"), SslHandler.class, "handshake(...)");
    private static final ClosedChannelException CHANNEL_CLOSED = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), SslHandler.class, "channelInactive(...)");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.SslHandler$9 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C139579 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
            if (SslHandler.this.ctx == null) {
                return;
            }
            super.checkDeadLock();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if (SslHandler.this.ctx != null) {
                return SslHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCloseListener(ChannelFuture channelFuture, ChannelPromise channelPromise) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise));
    }

    private ByteBuf allocate(ChannelHandlerContext channelHandlerContext, int i) {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        if (this.wantsDirectBuffer) {
            return alloc.directBuffer(i);
        }
        return alloc.buffer(i);
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext channelHandlerContext, int i) {
        if (this.wantsLargeOutboundNetworkBuffer) {
            return allocate(channelHandlerContext, this.maxPacketBufferSize);
        }
        return allocate(channelHandlerContext, Math.min(i + 2329, this.maxPacketBufferSize));
    }

    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, boolean z) throws Exception {
        if (!channelHandlerContext.channel().isActive()) {
            if (z) {
                channelHandlerContext.disconnect(channelPromise);
                return;
            } else {
                channelHandlerContext.close(channelPromise);
                return;
            }
        }
        this.outboundClosed = true;
        this.engine.closeOutbound();
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        try {
            write(channelHandlerContext, Unpooled.EMPTY_BUFFER, newPromise);
            flush(channelHandlerContext);
        } finally {
            safeClose(channelHandlerContext, newPromise, channelPromise);
        }
    }

    private void finishWrap(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ChannelPromise channelPromise, boolean z, boolean z2) {
        if (byteBuf == null) {
            byteBuf = Unpooled.EMPTY_BUFFER;
        } else if (!byteBuf.isReadable()) {
            byteBuf.release();
            byteBuf = Unpooled.EMPTY_BUFFER;
        }
        if (channelPromise != null) {
            channelHandlerContext.write(byteBuf, channelPromise);
        } else {
            channelHandlerContext.write(byteBuf);
        }
        if (z) {
            this.needsFlush = true;
        }
        if (z2) {
            readIfNeeded(channelHandlerContext);
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.needsFlush) {
            this.needsFlush = false;
            channelHandlerContext.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handshake(final Promise<Channel> promise) {
        if (promise != null) {
            Promise<Channel> promise2 = this.handshakePromise;
            if (!promise2.isDone()) {
                promise2.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.4
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) throws Exception {
                        if (future.isSuccess()) {
                            promise.setSuccess(future.getNow());
                        } else {
                            promise.setFailure(future.cause());
                        }
                    }
                });
                return;
            }
            this.handshakePromise = promise;
        } else if (this.engine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        } else {
            promise = this.handshakePromise;
        }
        ChannelHandlerContext channelHandlerContext = this.ctx;
        try {
            this.engine.beginHandshake();
            wrapNonAppData(channelHandlerContext, false);
            channelHandlerContext.flush();
        } catch (Exception e) {
            notifyHandshakeFailure(e);
        }
        long j = this.handshakeTimeoutMillis;
        if (j <= 0 || promise.isDone()) {
            return;
        }
        final ScheduledFuture<?> schedule = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.5
            @Override // java.lang.Runnable
            public void run() {
                if (promise.isDone()) {
                    return;
                }
                SslHandler.this.notifyHandshakeFailure(SslHandler.HANDSHAKE_TIMED_OUT);
            }
        }, j, TimeUnit.MILLISECONDS);
        promise.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.6
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Channel> future) throws Exception {
                schedule.cancel(false);
            }
        });
    }

    private boolean ignoreException(Throwable th) {
        StackTraceElement[] stackTrace;
        if (!(th instanceof SSLException) && (th instanceof IOException) && this.sslCloseFuture.isDone()) {
            if (IGNORABLE_ERROR_MESSAGE.matcher(String.valueOf(th.getMessage()).toLowerCase()).matches()) {
                return true;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                if (!className.startsWith("io.netty.") && "read".equals(methodName)) {
                    if (IGNORABLE_CLASS_IN_STACK.matcher(className).matches()) {
                        return true;
                    }
                    try {
                        Class<?> loadClass = PlatformDependent.getClassLoader(getClass()).loadClass(className);
                        if (!SocketChannel.class.isAssignableFrom(loadClass)) {
                            if (!DatagramChannel.class.isAssignableFrom(loadClass)) {
                                if (PlatformDependent.javaVersion() >= 7 && "com.sun.nio.sctp.SctpChannel".equals(loadClass.getSuperclass().getName())) {
                                }
                            }
                        }
                        return true;
                    } catch (ClassNotFoundException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEncrypted(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() >= 5) {
            return SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex()) != -1;
        }
        throw new IllegalArgumentException("buffer must have at least 5 readable bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHandshakeFailure(Throwable th) {
        if (this.handshakePromise.tryFailure(th)) {
            SslUtils.notifyHandshakeFailure(this.ctx, th);
        }
    }

    private void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().config().isAutoRead()) {
            return;
        }
        if (this.firedChannelRead && this.handshakePromise.isDone()) {
            return;
        }
        channelHandlerContext.read();
    }

    private void runDelegatedTasks() {
        if (this.delegatedTaskExecutor != ImmediateExecutor.INSTANCE) {
            final ArrayList arrayList = new ArrayList(2);
            while (true) {
                Runnable delegatedTask = this.engine.getDelegatedTask();
                if (delegatedTask == null) {
                    break;
                }
                arrayList.add(delegatedTask);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.delegatedTaskExecutor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            for (Runnable runnable : arrayList) {
                                runnable.run();
                            }
                        } catch (Exception e) {
                            SslHandler.this.ctx.fireExceptionCaught((Throwable) e);
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            boolean z = false;
            while (countDownLatch.getCount() != 0) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
                return;
            }
            return;
        }
        while (true) {
            Runnable delegatedTask2 = this.engine.getDelegatedTask();
            if (delegatedTask2 == null) {
                return;
            }
            delegatedTask2.run();
        }
    }

    private void safeClose(final ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        final ScheduledFuture<?> schedule = this.closeNotifyTimeoutMillis > 0 ? channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.7
            @Override // java.lang.Runnable
            public void run() {
                SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", channelHandlerContext.channel());
                ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
            }
        }, this.closeNotifyTimeoutMillis, TimeUnit.MILLISECONDS) : null;
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.8
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                java.util.concurrent.ScheduledFuture scheduledFuture = schedule;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
            }
        });
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        setHandshakeFailure(channelHandlerContext, th, true);
    }

    private void setHandshakeSuccess() {
        this.handshakePromise.trySuccess(this.ctx.channel());
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} HANDSHAKEN: {}", this.ctx.channel(), this.engine.getSession().getCipherSuite());
        }
        this.ctx.fireUserEventTriggered((Object) SslHandshakeCompletionEvent.SUCCESS);
        if (!this.readDuringHandshake || this.ctx.channel().config().isAutoRead()) {
            return;
        }
        this.readDuringHandshake = false;
        this.ctx.read();
    }

    private boolean setHandshakeSuccessIfStillHandshaking() {
        if (this.handshakePromise.isDone()) {
            return false;
        }
        setHandshakeSuccess();
        return true;
    }

    private static ByteBuffer toByteBuffer(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(i, i2) : byteBuf.nioBuffer(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
        if (r3 != javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
        readIfNeeded(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
        if (r13 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
        wrap(r18, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
        if (r14 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
        r17.sslCloseFuture.trySuccess(r18.channel());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
        if (r12.isReadable() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
        r18.fireChannelRead((java.lang.Object) r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
        r12.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return true;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean unwrap(io.netty.channel.ChannelHandlerContext r18, io.netty.buffer.ByteBuf r19, int r20, int r21) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.unwrap(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, int, int):boolean");
    }

    private void unwrapNonAppData(ChannelHandlerContext channelHandlerContext) throws SSLException {
        unwrap(channelHandlerContext, Unpooled.EMPTY_BUFFER, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r10.pendingUnencryptedWrites.removeAndFailAll(io.netty.handler.ssl.SslHandler.SSLENGINE_CLOSED);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r6 = false;
        r1 = r10;
        r2 = r11;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r1 == 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r1 == 3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
        if (r1 == 4) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r1 != 5) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
        r6 = true;
        r1 = r10;
        r2 = r11;
        r3 = r8;
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
        throw new java.lang.IllegalStateException("Unknown handshake status: " + r2.getHandshakeStatus());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
        setHandshakeSuccess();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
        setHandshakeSuccessIfStillHandshaking();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void wrap(io.netty.channel.ChannelHandlerContext r11, boolean r12) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        throw new java.lang.IllegalStateException("Unknown handshake status: " + r3.getHandshakeStatus());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void wrapNonAppData(io.netty.channel.ChannelHandlerContext r8, boolean r9) throws javax.net.ssl.SSLException {
        /*
            r7 = this;
            io.netty.buffer.ByteBufAllocator r0 = r8.alloc()
            r1 = 0
            r2 = r1
        L6:
            if (r2 != 0) goto Ld
            r3 = 0
            io.netty.buffer.ByteBuf r2 = r7.allocateOutNetBuf(r8, r3)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
        Ld:
            javax.net.ssl.SSLEngine r3 = r7.engine     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            io.netty.buffer.ByteBuf r4 = io.netty.buffer.Unpooled.EMPTY_BUFFER     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            javax.net.ssl.SSLEngineResult r3 = r7.wrap(r0, r3, r4, r2)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            int r4 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            r5 = 1
            if (r4 <= 0) goto L24
            r8.write(r2)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r9 == 0) goto L23
            r7.needsFlush = r5     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
        L23:
            r2 = r1
        L24:
            int[] r4 = io.netty.handler.ssl.SslHandler.C139579.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            javax.net.ssl.SSLEngineResult$HandshakeStatus r6 = r3.getHandshakeStatus()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            r4 = r4[r6]     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r4 == r5) goto L6c
            r5 = 2
            if (r4 == r5) goto L68
            r5 = 3
            if (r4 == r5) goto L5f
            r5 = 4
            if (r4 == r5) goto L6f
            r5 = 5
            if (r4 != r5) goto L44
            if (r9 != 0) goto L6f
            r7.unwrapNonAppData(r8)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            goto L6f
        L44:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            r0.<init>()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            java.lang.String r1 = "Unknown handshake status: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = r3.getHandshakeStatus()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            r0.append(r1)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            throw r9     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
        L5f:
            r7.setHandshakeSuccessIfStillHandshaking()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r9 != 0) goto L6f
            r7.unwrapNonAppData(r8)     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            goto L6f
        L68:
            r7.setHandshakeSuccess()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            goto L6f
        L6c:
            r7.runDelegatedTasks()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
        L6f:
            int r4 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r4 != 0) goto L76
            goto L84
        L76:
            int r4 = r3.bytesConsumed()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r4 != 0) goto L6
            javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = r3.getHandshakeStatus()     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch: java.lang.Throwable -> L8a javax.net.ssl.SSLException -> L8c
            if (r3 != r4) goto L6
        L84:
            if (r2 == 0) goto L89
            r2.release()
        L89:
            return
        L8a:
            r8 = move-exception
            goto L94
        L8c:
            r9 = move-exception
            r7.setHandshakeFailure(r8, r9)     // Catch: java.lang.Throwable -> L8a
            r7.flushIfNeeded(r8)     // Catch: java.lang.Throwable -> L8a
            throw r9     // Catch: java.lang.Throwable -> L8a
        L94:
            if (r2 == 0) goto L99
            r2.release()
        L99:
            goto L9b
        L9a:
            throw r8
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrapNonAppData(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    public String applicationProtocol() {
        SSLSession session = engine().getSession();
        if (session instanceof ApplicationProtocolAccessor) {
            return ((ApplicationProtocolAccessor) session).getApplicationProtocol();
        }
        return null;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.startTls && this.engine.getUseClientMode()) {
            handshake(null);
        }
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        setHandshakeFailure(channelHandlerContext, CHANNEL_CLOSED, !this.outboundClosed);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        discardSomeReadBytes();
        flushIfNeeded(channelHandlerContext);
        readIfNeeded(channelHandlerContext);
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    public ChannelFuture close() {
        return close(this.ctx.newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws SSLException {
        int i;
        int i2;
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        int i3 = this.packetLength;
        boolean z = false;
        if (i3 <= 0) {
            i = readerIndex;
            i3 = 0;
        } else if (writerIndex - readerIndex < i3) {
            return;
        } else {
            i = readerIndex + i3;
            this.packetLength = 0;
        }
        while (true) {
            if (i3 >= 18713 || (i2 = writerIndex - i) < 5) {
                break;
            }
            int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, i);
            if (encryptedPacketLength == -1) {
                z = true;
                break;
            } else if (encryptedPacketLength > i2) {
                this.packetLength = encryptedPacketLength;
                break;
            } else {
                int i4 = i3 + encryptedPacketLength;
                if (i4 > 18713) {
                    break;
                }
                i += encryptedPacketLength;
                i3 = i4;
            }
        }
        if (i3 > 0) {
            byteBuf.skipBytes(i3);
            boolean unwrap = unwrap(channelHandlerContext, byteBuf, readerIndex, i3);
            if (!this.firedChannelRead) {
                this.firedChannelRead = unwrap;
            }
        }
        if (z) {
            NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
            byteBuf.skipBytes(byteBuf.readableBytes());
            channelHandlerContext.fireExceptionCaught((Throwable) notSslRecordException);
            setHandshakeFailure(channelHandlerContext, notSslRecordException);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, true);
    }

    public SSLEngine engine() {
        return this.engine;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (ignoreException(th)) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("{} Swallowing a harmless 'connection reset by peer / broken pipe' error that occurred while writing close_notify in response to the peer's close_notify", channelHandlerContext.channel(), th);
            }
            if (channelHandlerContext.channel().isActive()) {
                channelHandlerContext.close();
                return;
            }
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.startTls && !this.sentFirstMessage) {
            this.sentFirstMessage = true;
            this.pendingUnencryptedWrites.removeAndWriteAll();
            return;
        }
        if (this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, channelHandlerContext.newPromise());
        }
        if (!this.handshakePromise.isDone()) {
            this.flushedBeforeHandshake = true;
        }
        try {
            wrap(channelHandlerContext, false);
        } finally {
            try {
            } finally {
            }
        }
    }

    public long getCloseNotifyTimeoutMillis() {
        return this.closeNotifyTimeoutMillis;
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.pendingUnencryptedWrites = new PendingWriteQueue(channelHandlerContext);
        if (channelHandlerContext.channel().isActive() && this.engine.getUseClientMode()) {
            handshake(null);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.removeAndFailAll(new ChannelException("Pending write on removal of SslHandler"));
        }
        SSLEngine sSLEngine = this.engine;
        if (sSLEngine instanceof ReferenceCountedOpenSslEngine) {
            ((ReferenceCountedOpenSslEngine) sSLEngine).release();
        }
    }

    public Future<Channel> handshakeFuture() {
        return this.handshakePromise;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.handshakePromise.isDone()) {
            this.readDuringHandshake = true;
        }
        channelHandlerContext.read();
    }

    public Future<Channel> renegotiate() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return renegotiate(channelHandlerContext.executor().newPromise());
        }
        throw new IllegalStateException();
    }

    public void setCloseNotifyTimeout(long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            setCloseNotifyTimeoutMillis(timeUnit.toMillis(j));
            return;
        }
        throw new NullPointerException("unit");
    }

    public void setCloseNotifyTimeoutMillis(long j) {
        if (j >= 0) {
            this.closeNotifyTimeoutMillis = j;
            return;
        }
        throw new IllegalArgumentException("closeNotifyTimeoutMillis: " + j + " (expected: >= 0)");
    }

    public void setHandshakeTimeout(long j, TimeUnit timeUnit) {
        if (timeUnit != null) {
            setHandshakeTimeoutMillis(timeUnit.toMillis(j));
            return;
        }
        throw new NullPointerException("unit");
    }

    public void setHandshakeTimeoutMillis(long j) {
        if (j >= 0) {
            this.handshakeTimeoutMillis = j;
            return;
        }
        throw new IllegalArgumentException("handshakeTimeoutMillis: " + j + " (expected: >= 0)");
    }

    public Future<Channel> sslCloseFuture() {
        return this.sslCloseFuture;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            channelPromise.setFailure((Throwable) new UnsupportedMessageTypeException(obj, ByteBuf.class));
        } else {
            this.pendingUnencryptedWrites.add(obj, channelPromise);
        }
    }

    public SslHandler(SSLEngine sSLEngine, boolean z) {
        this(sSLEngine, z, ImmediateExecutor.INSTANCE);
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z) {
        this.engine.closeOutbound();
        if (z) {
            try {
                this.engine.closeInbound();
            } catch (SSLException e) {
                String message = e.getMessage();
                if (message == null || !message.contains("possible truncation attack")) {
                    logger.debug("{} SSLEngine.closeInbound() raised an exception.", channelHandlerContext.channel(), e);
                }
            }
        }
        notifyHandshakeFailure(th);
        this.pendingUnencryptedWrites.removeAndFailAll(th);
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SslHandler.this.outboundClosed = true;
                SslHandler.this.engine.closeOutbound();
                try {
                    SslHandler.this.write(channelHandlerContext, Unpooled.EMPTY_BUFFER, channelPromise);
                    SslHandler.this.flush(channelHandlerContext);
                } catch (Exception e) {
                    if (channelPromise.tryFailure(e)) {
                        return;
                    }
                    SslHandler.logger.warn("{} flush() raised a masked exception.", channelHandlerContext.channel(), e);
                }
            }
        });
        return channelPromise;
    }

    @Deprecated
    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, false, executor);
    }

    @Deprecated
    public SslHandler(SSLEngine sSLEngine, boolean z, Executor executor) {
        this.singleBuffer = new ByteBuffer[1];
        this.handshakePromise = new LazyChannelPromise();
        this.sslCloseFuture = new LazyChannelPromise();
        this.handshakeTimeoutMillis = 10000L;
        this.closeNotifyTimeoutMillis = 3000L;
        if (sSLEngine == null) {
            throw new NullPointerException("engine");
        }
        if (executor != null) {
            this.engine = sSLEngine;
            this.delegatedTaskExecutor = executor;
            this.startTls = z;
            this.maxPacketBufferSize = sSLEngine.getSession().getPacketBufferSize();
            boolean z2 = sSLEngine instanceof OpenSslEngine;
            this.wantsDirectBuffer = z2;
            this.wantsLargeOutboundNetworkBuffer = !z2;
            setCumulator(z2 ? ByteToMessageDecoder.COMPOSITE_CUMULATOR : ByteToMessageDecoder.MERGE_CUMULATOR);
            return;
        }
        throw new NullPointerException("delegatedTaskExecutor");
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, false);
    }

    public Future<Channel> renegotiate(final Promise<Channel> promise) {
        if (promise != null) {
            ChannelHandlerContext channelHandlerContext = this.ctx;
            if (channelHandlerContext != null) {
                EventExecutor executor = channelHandlerContext.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SslHandler.this.handshake(promise);
                        }
                    });
                    return promise;
                }
                handshake(promise);
                return promise;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("promise");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[Catch: all -> 0x0026, LOOP:0: B:20:0x0041->B:26:0x007c, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0026, blocks: (B:9:0x001a, B:20:0x0041, B:26:0x007c), top: B:37:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072 A[EDGE_INSN: B:39:0x0072->B:22:0x0072 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.net.ssl.SSLEngineResult wrap(io.netty.buffer.ByteBufAllocator r8, javax.net.ssl.SSLEngine r9, io.netty.buffer.ByteBuf r10, io.netty.buffer.ByteBuf r11) throws javax.net.ssl.SSLException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            int r2 = r10.readerIndex()     // Catch: java.lang.Throwable -> L82
            int r3 = r10.readableBytes()     // Catch: java.lang.Throwable -> L82
            boolean r4 = r10.isDirect()     // Catch: java.lang.Throwable -> L82
            r5 = 1
            if (r4 != 0) goto L28
            boolean r4 = r7.wantsDirectBuffer     // Catch: java.lang.Throwable -> L82
            if (r4 != 0) goto L16
            goto L28
        L16:
            io.netty.buffer.ByteBuf r8 = r8.directBuffer(r3)     // Catch: java.lang.Throwable -> L82
            r8.writeBytes(r10, r2, r3)     // Catch: java.lang.Throwable -> L26
            java.nio.ByteBuffer[] r2 = r7.singleBuffer     // Catch: java.lang.Throwable -> L26
            java.nio.ByteBuffer r3 = r8.internalNioBuffer(r1, r3)     // Catch: java.lang.Throwable -> L26
            r2[r1] = r3     // Catch: java.lang.Throwable -> L26
            goto L41
        L26:
            r9 = move-exception
            goto L84
        L28:
            boolean r8 = r10 instanceof io.netty.buffer.CompositeByteBuf     // Catch: java.lang.Throwable -> L82
            if (r8 != 0) goto L3c
            int r8 = r10.nioBufferCount()     // Catch: java.lang.Throwable -> L82
            if (r8 != r5) goto L3c
            java.nio.ByteBuffer[] r8 = r7.singleBuffer     // Catch: java.lang.Throwable -> L82
            java.nio.ByteBuffer r2 = r10.internalNioBuffer(r2, r3)     // Catch: java.lang.Throwable -> L82
            r8[r1] = r2     // Catch: java.lang.Throwable -> L82
            r2 = r8
            goto L40
        L3c:
            java.nio.ByteBuffer[] r2 = r10.nioBuffers()     // Catch: java.lang.Throwable -> L82
        L40:
            r8 = r0
        L41:
            int r3 = r11.writerIndex()     // Catch: java.lang.Throwable -> L26
            int r4 = r11.writableBytes()     // Catch: java.lang.Throwable -> L26
            java.nio.ByteBuffer r3 = r11.nioBuffer(r3, r4)     // Catch: java.lang.Throwable -> L26
            javax.net.ssl.SSLEngineResult r3 = r9.wrap(r2, r3)     // Catch: java.lang.Throwable -> L26
            int r4 = r3.bytesConsumed()     // Catch: java.lang.Throwable -> L26
            r10.skipBytes(r4)     // Catch: java.lang.Throwable -> L26
            int r4 = r11.writerIndex()     // Catch: java.lang.Throwable -> L26
            int r6 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L26
            int r4 = r4 + r6
            r11.writerIndex(r4)     // Catch: java.lang.Throwable -> L26
            int[] r4 = io.netty.handler.ssl.SslHandler.C139579.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch: java.lang.Throwable -> L26
            javax.net.ssl.SSLEngineResult$Status r6 = r3.getStatus()     // Catch: java.lang.Throwable -> L26
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L26
            r4 = r4[r6]     // Catch: java.lang.Throwable -> L26
            if (r4 == r5) goto L7c
            java.nio.ByteBuffer[] r9 = r7.singleBuffer
            r9[r1] = r0
            if (r8 == 0) goto L7b
            r8.release()
        L7b:
            return r3
        L7c:
            int r3 = r7.maxPacketBufferSize     // Catch: java.lang.Throwable -> L26
            r11.ensureWritable(r3)     // Catch: java.lang.Throwable -> L26
            goto L41
        L82:
            r9 = move-exception
            r8 = r0
        L84:
            java.nio.ByteBuffer[] r10 = r7.singleBuffer
            r10[r1] = r0
            if (r8 == 0) goto L8d
            r8.release()
        L8d:
            goto L8f
        L8e:
            throw r9
        L8f:
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.buffer.ByteBufAllocator, javax.net.ssl.SSLEngine, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):javax.net.ssl.SSLEngineResult");
    }

    private SSLEngineResult unwrap(SSLEngine sSLEngine, ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2) throws SSLException {
        SSLEngineResult unwrap;
        int nioBufferCount = byteBuf.nioBufferCount();
        int writerIndex = byteBuf2.writerIndex();
        if ((sSLEngine instanceof OpenSslEngine) && nioBufferCount > 1) {
            OpenSslEngine openSslEngine = (OpenSslEngine) sSLEngine;
            try {
                this.singleBuffer[0] = toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                unwrap = openSslEngine.unwrap(byteBuf.nioBuffers(i, i2), this.singleBuffer);
                byteBuf2.writerIndex(unwrap.bytesProduced() + writerIndex);
            } finally {
                this.singleBuffer[0] = null;
            }
        } else {
            unwrap = sSLEngine.unwrap(toByteBuffer(byteBuf, i, i2), toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
        }
        byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
        return unwrap;
    }
}
