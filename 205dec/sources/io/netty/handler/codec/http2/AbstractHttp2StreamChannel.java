package io.netty.handler.codec.http2;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.VoidChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.ThrowableUtil;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractHttp2StreamChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARBITRARY_MESSAGE_SIZE = 9;
    private boolean closed;
    private final ChannelConfig config;
    private final Runnable fireChildReadCompleteTask;
    private final Queue<Object> inboundBuffer;
    private boolean readInProgress;
    protected static final Object CLOSE_MESSAGE = new Object();
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final ClosedChannelException CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), AbstractHttp2StreamChannel.class, "doWrite(...)");

    /* renamed from: io.netty.handler.codec.http2.AbstractHttp2StreamChannel$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus;

        static {
            int[] iArr = new int[ReadStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus = iArr;
            try {
                iArr[ReadStatus.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus[ReadStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class FlowControlledFrameSizeEstimator implements MessageSizeEstimator {
        static final FlowControlledFrameSizeEstimator INSTANCE = new FlowControlledFrameSizeEstimator();
        private static final MessageSizeEstimator.Handle HANDLE_INSTANCE = new MessageSizeEstimator.Handle() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.FlowControlledFrameSizeEstimator.1
            @Override // io.netty.channel.MessageSizeEstimator.Handle
            public int size(Object obj) {
                if (obj instanceof Http2DataFrame) {
                    return (int) Math.min(2147483647L, ((Http2DataFrame) obj).initialFlowControlledBytes() + 9);
                }
                return 9;
            }
        };

        private FlowControlledFrameSizeEstimator() {
        }

        @Override // io.netty.channel.MessageSizeEstimator
        public MessageSizeEstimator.Handle newHandle() {
            return HANDLE_INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public final class Http2ChannelUnsafe implements Channel.Unsafe {
        private boolean closeInitiated;
        private boolean readEOS;
        private RecvByteBufAllocator.Handle recvHandle;
        private final VoidChannelPromise unsafeVoidPromise;
        private boolean writeDoneAndNoFlush;

        private Http2ChannelUnsafe() {
            this.unsafeVoidPromise = new VoidChannelPromise(AbstractHttp2StreamChannel.this, false);
        }

        private void fireChannelInactiveAndDeregister(final ChannelPromise channelPromise, final boolean z3) {
            if (channelPromise.setUncancellable()) {
                if (!AbstractHttp2StreamChannel.access$300(AbstractHttp2StreamChannel.this)) {
                    channelPromise.setSuccess();
                } else {
                    invokeLater(new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z3) {
                                AbstractHttp2StreamChannel.access$900(AbstractHttp2StreamChannel.this).fireChannelInactive();
                            }
                            if (AbstractHttp2StreamChannel.access$300(AbstractHttp2StreamChannel.this)) {
                                AbstractHttp2StreamChannel.access$302(AbstractHttp2StreamChannel.this, false);
                                AbstractHttp2StreamChannel.access$900(AbstractHttp2StreamChannel.this).fireChannelUnregistered();
                            }
                            Http2ChannelUnsafe.this.safeSetSuccess(channelPromise);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void firstWriteComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable cause = channelFuture.cause();
            if (cause == null) {
                channelPromise.setSuccess();
                return;
            }
            closeForcibly();
            channelPromise.setFailure(wrapStreamClosedError(cause));
        }

        private void invokeLater(Runnable runnable) {
            try {
                AbstractHttp2StreamChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e4) {
                AbstractChannel.FLUSH0_NOT_YET_CONNECTED_EXCEPTION.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e4);
            }
        }

        private Object pollQueuedMessage() {
            if (AbstractHttp2StreamChannel.access$700(AbstractHttp2StreamChannel.this) == null) {
                return null;
            }
            return AbstractHttp2StreamChannel.access$700(AbstractHttp2StreamChannel.this).poll();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void safeSetSuccess(ChannelPromise channelPromise) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
                return;
            }
            AbstractChannel.FLUSH0_NOT_YET_CONNECTED_EXCEPTION.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
        }

        private void updateLocalWindowIfNeeded() {
            if (AbstractHttp2StreamChannel.access$1400(AbstractHttp2StreamChannel.this) != 0) {
                int access$1400 = AbstractHttp2StreamChannel.access$1400(AbstractHttp2StreamChannel.this);
                AbstractHttp2StreamChannel.access$1402(AbstractHttp2StreamChannel.this, 0);
                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), new DefaultHttp2WindowUpdateFrame(access$1400).stream(AbstractHttp2StreamChannel.access$600(AbstractHttp2StreamChannel.this)));
                this.writeDoneAndNoFlush = true;
            }
        }

        private Http2StreamFrame validateStreamFrame(Http2StreamFrame http2StreamFrame) {
            if (http2StreamFrame.stream() == null || http2StreamFrame.stream() == AbstractHttp2StreamChannel.access$600(AbstractHttp2StreamChannel.this)) {
                return http2StreamFrame;
            }
            String obj = http2StreamFrame.toString();
            ReferenceCountUtil.release(http2StreamFrame);
            throw new IllegalArgumentException("Stream " + http2StreamFrame.stream() + " must not be set on the frame: " + obj);
        }

        private Throwable wrapStreamClosedError(Throwable th) {
            return ((th instanceof Http2Exception) && ((Http2Exception) th).error() == Http2Error.STREAM_CLOSED) ? new ClosedChannelException().initCause(th) : th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeComplete(ChannelFuture channelFuture, ChannelPromise channelPromise) {
            Throwable cause = channelFuture.cause();
            if (cause == null) {
                channelPromise.setSuccess();
                return;
            }
            Throwable wrapStreamClosedError = wrapStreamClosedError(cause);
            if (wrapStreamClosedError instanceof IOException) {
                if (AbstractHttp2StreamChannel.access$1900(AbstractHttp2StreamChannel.this).isAutoClose()) {
                    closeForcibly();
                } else {
                    AbstractHttp2StreamChannel.access$802(AbstractHttp2StreamChannel.this, true);
                }
            }
            channelPromise.setFailure(wrapStreamClosedError);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void beginRead() {
            if (AbstractHttp2StreamChannel.this.isActive()) {
                int i4 = AnonymousClass4.$SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus[AbstractHttp2StreamChannel.access$1200(AbstractHttp2StreamChannel.this).ordinal()];
                if (i4 == 1) {
                    AbstractHttp2StreamChannel.access$1202(AbstractHttp2StreamChannel.this, ReadStatus.IN_PROGRESS);
                    doBeginRead();
                } else if (i4 != 2) {
                } else {
                    AbstractHttp2StreamChannel.access$1202(AbstractHttp2StreamChannel.this, ReadStatus.REQUESTED);
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void close(final ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                if (this.closeInitiated) {
                    if (AbstractHttp2StreamChannel.access$400(AbstractHttp2StreamChannel.this).isDone()) {
                        channelPromise.setSuccess();
                        return;
                    } else if (channelPromise instanceof VoidChannelPromise) {
                        return;
                    } else {
                        AbstractHttp2StreamChannel.access$400(AbstractHttp2StreamChannel.this).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                }
                this.closeInitiated = true;
                AbstractHttp2StreamChannel.access$502(AbstractHttp2StreamChannel.this, false);
                boolean isActive = AbstractHttp2StreamChannel.this.isActive();
                updateLocalWindowIfNeeded();
                if (AbstractHttp2StreamChannel.this.parent().isActive() && !this.readEOS && Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.access$600(AbstractHttp2StreamChannel.this).id())) {
                    write(new DefaultHttp2ResetFrame(Http2Error.CANCEL).stream(AbstractHttp2StreamChannel.this.stream()), AbstractHttp2StreamChannel.this.unsafe().voidPromise());
                    flush();
                }
                if (AbstractHttp2StreamChannel.access$700(AbstractHttp2StreamChannel.this) != null) {
                    while (true) {
                        Object poll = AbstractHttp2StreamChannel.access$700(AbstractHttp2StreamChannel.this).poll();
                        if (poll == null) {
                            break;
                        }
                        ReferenceCountUtil.release(poll);
                    }
                    AbstractHttp2StreamChannel.access$702(AbstractHttp2StreamChannel.this, null);
                }
                AbstractHttp2StreamChannel.access$802(AbstractHttp2StreamChannel.this, true);
                AbstractHttp2StreamChannel.access$400(AbstractHttp2StreamChannel.this).setSuccess();
                channelPromise.setSuccess();
                fireChannelInactiveAndDeregister(voidPromise(), isActive);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void closeForcibly() {
            close(AbstractHttp2StreamChannel.this.unsafe().voidPromise());
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                channelPromise.setFailure((Throwable) new UnsupportedOperationException());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void deregister(ChannelPromise channelPromise) {
            fireChannelInactiveAndDeregister(channelPromise, false);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void disconnect(ChannelPromise channelPromise) {
            close(channelPromise);
        }

        void doBeginRead() {
            boolean z3;
            while (AbstractHttp2StreamChannel.access$1200(AbstractHttp2StreamChannel.this) != ReadStatus.IDLE) {
                Object pollQueuedMessage = pollQueuedMessage();
                if (pollQueuedMessage == null) {
                    if (this.readEOS) {
                        AbstractHttp2StreamChannel.access$1300(AbstractHttp2StreamChannel.this).closeForcibly();
                        return;
                    }
                    return;
                }
                RecvByteBufAllocator.Handle recvBufAllocHandle = recvBufAllocHandle();
                recvBufAllocHandle.reset(AbstractHttp2StreamChannel.this.config());
                boolean z4 = false;
                while (true) {
                    AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                    AbstractHttp2StreamChannel.access$1402(abstractHttp2StreamChannel, AbstractHttp2StreamChannel.access$1400(abstractHttp2StreamChannel) + doRead0((Http2Frame) pollQueuedMessage, recvBufAllocHandle));
                    if (!this.readEOS) {
                        z3 = recvBufAllocHandle.continueReading();
                        if (!z3) {
                            break;
                        }
                        z4 = z3;
                    }
                    pollQueuedMessage = pollQueuedMessage();
                    if (pollQueuedMessage == null) {
                        z3 = z4;
                        break;
                    }
                }
                if (z3 && AbstractHttp2StreamChannel.this.isParentReadInProgress() && !this.readEOS) {
                    if (!AbstractHttp2StreamChannel.access$500(AbstractHttp2StreamChannel.this)) {
                        AbstractHttp2StreamChannel.access$502(AbstractHttp2StreamChannel.this, true);
                        AbstractHttp2StreamChannel.this.addChannelToReadCompletePendingQueue();
                    }
                } else {
                    notifyReadComplete(recvBufAllocHandle, true);
                }
            }
        }

        int doRead0(Http2Frame http2Frame, RecvByteBufAllocator.Handle handle) {
            AbstractHttp2StreamChannel.this.pipeline().fireChannelRead((Object) http2Frame);
            handle.incMessagesRead(1);
            if (http2Frame instanceof Http2DataFrame) {
                int initialFlowControlledBytes = ((Http2DataFrame) http2Frame).initialFlowControlledBytes();
                handle.attemptedBytesRead(initialFlowControlledBytes);
                handle.lastBytesRead(initialFlowControlledBytes);
                return initialFlowControlledBytes;
            }
            handle.attemptedBytesRead(9);
            handle.lastBytesRead(9);
            return 0;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void flush() {
            if (!this.writeDoneAndNoFlush || AbstractHttp2StreamChannel.this.isParentReadInProgress()) {
                return;
            }
            try {
                AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                abstractHttp2StreamChannel.flush0(abstractHttp2StreamChannel.parentContext());
            } finally {
                this.writeDoneAndNoFlush = false;
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress localAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().localAddress();
        }

        void notifyReadComplete(RecvByteBufAllocator.Handle handle, boolean z3) {
            if (AbstractHttp2StreamChannel.access$500(AbstractHttp2StreamChannel.this) || z3) {
                AbstractHttp2StreamChannel.access$502(AbstractHttp2StreamChannel.this, false);
                if (AbstractHttp2StreamChannel.access$1200(AbstractHttp2StreamChannel.this) == ReadStatus.REQUESTED) {
                    AbstractHttp2StreamChannel.access$1202(AbstractHttp2StreamChannel.this, ReadStatus.IN_PROGRESS);
                } else {
                    AbstractHttp2StreamChannel.access$1202(AbstractHttp2StreamChannel.this, ReadStatus.IDLE);
                }
                updateLocalWindowIfNeeded();
                handle.readComplete();
                AbstractHttp2StreamChannel.this.pipeline().fireChannelReadComplete();
                flush();
                if (this.readEOS) {
                    AbstractHttp2StreamChannel.access$1300(AbstractHttp2StreamChannel.this).closeForcibly();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelOutboundBuffer outboundBuffer() {
            return null;
        }

        void readEOS() {
            this.readEOS = true;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                RecvByteBufAllocator.Handle newHandle = AbstractHttp2StreamChannel.this.config().getRecvByteBufAllocator().newHandle();
                this.recvHandle = newHandle;
                newHandle.reset(AbstractHttp2StreamChannel.this.config());
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void register(EventLoop eventLoop, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable()) {
                if (AbstractHttp2StreamChannel.access$300(AbstractHttp2StreamChannel.this)) {
                    channelPromise.setFailure((Throwable) new UnsupportedOperationException("Re-register is not supported"));
                    return;
                }
                AbstractHttp2StreamChannel.access$302(AbstractHttp2StreamChannel.this, true);
                channelPromise.setSuccess();
                AbstractHttp2StreamChannel.this.pipeline().fireChannelRegistered();
                if (AbstractHttp2StreamChannel.this.isActive()) {
                    AbstractHttp2StreamChannel.this.pipeline().fireChannelActive();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public SocketAddress remoteAddress() {
            return AbstractHttp2StreamChannel.this.parent().unsafe().remoteAddress();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public ChannelPromise voidPromise() {
            return this.unsafeVoidPromise;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void write(Object obj, final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                ReferenceCountUtil.release(obj);
            } else if (AbstractHttp2StreamChannel.this.isActive() && (!AbstractHttp2StreamChannel.access$800(AbstractHttp2StreamChannel.this) || (!(obj instanceof Http2HeadersFrame) && !(obj instanceof Http2DataFrame)))) {
                try {
                    if (obj instanceof Http2StreamFrame) {
                        Http2StreamFrame stream = validateStreamFrame((Http2StreamFrame) obj).stream(AbstractHttp2StreamChannel.this.stream());
                        if (!AbstractHttp2StreamChannel.access$1500(AbstractHttp2StreamChannel.this) && !Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream().id())) {
                            if (!(stream instanceof Http2HeadersFrame)) {
                                ReferenceCountUtil.release(stream);
                                channelPromise.setFailure((Throwable) new IllegalArgumentException("The first frame must be a headers frame. Was: " + stream.name()));
                                return;
                            }
                            AbstractHttp2StreamChannel.access$1502(AbstractHttp2StreamChannel.this, true);
                            AbstractHttp2StreamChannel abstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
                            ChannelFuture write0 = abstractHttp2StreamChannel.write0(abstractHttp2StreamChannel.parentContext(), stream);
                            if (write0.isDone()) {
                                firstWriteComplete(write0, channelPromise);
                                return;
                            }
                            final long size = FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(obj);
                            AbstractHttp2StreamChannel.access$100(AbstractHttp2StreamChannel.this, size, false);
                            write0.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.3
                                @Override // io.netty.util.concurrent.GenericFutureListener
                                public void operationComplete(ChannelFuture channelFuture) {
                                    Http2ChannelUnsafe.this.firstWriteComplete(channelFuture, channelPromise);
                                    AbstractHttp2StreamChannel.access$200(AbstractHttp2StreamChannel.this, size, false);
                                }
                            });
                            this.writeDoneAndNoFlush = true;
                            return;
                        }
                        AbstractHttp2StreamChannel abstractHttp2StreamChannel2 = AbstractHttp2StreamChannel.this;
                        ChannelFuture write02 = abstractHttp2StreamChannel2.write0(abstractHttp2StreamChannel2.parentContext(), obj);
                        if (write02.isDone()) {
                            writeComplete(write02, channelPromise);
                            return;
                        }
                        final long size2 = FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(obj);
                        AbstractHttp2StreamChannel.access$100(AbstractHttp2StreamChannel.this, size2, false);
                        write02.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.Http2ChannelUnsafe.4
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                Http2ChannelUnsafe.this.writeComplete(channelFuture, channelPromise);
                                AbstractHttp2StreamChannel.access$200(AbstractHttp2StreamChannel.this, size2, false);
                            }
                        });
                        this.writeDoneAndNoFlush = true;
                        return;
                    }
                    String obj2 = obj.toString();
                    ReferenceCountUtil.release(obj);
                    channelPromise.setFailure((Throwable) new IllegalArgumentException("Message must be an " + StringUtil.simpleClassName((Class<?>) Http2StreamFrame.class) + ": " + obj2));
                } catch (Throwable th) {
                    channelPromise.tryFailure(th);
                }
            } else {
                ReferenceCountUtil.release(obj);
                channelPromise.setFailure((Throwable) new ClosedChannelException());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class Http2StreamChannelConfig extends DefaultChannelConfig {
        Http2StreamChannelConfig(Channel channel) {
            super(channel);
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public MessageSizeEstimator getMessageSizeEstimator() {
            return FlowControlledFrameSizeEstimator.INSTANCE;
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
            if (recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle) {
                super.setRecvByteBufAllocator(recvByteBufAllocator);
                return this;
            }
            throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public enum ReadStatus {
        IDLE,
        IN_PROGRESS,
        REQUESTED
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class Unsafe extends AbstractChannel.AbstractUnsafe {
        private Unsafe() {
            super();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }
    }

    public AbstractHttp2StreamChannel(Channel channel) {
        super(channel);
        this.config = new DefaultChannelConfig(this);
        this.inboundBuffer = new ArrayDeque(4);
        this.fireChildReadCompleteTask = new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractHttp2StreamChannel.this.readInProgress) {
                    AbstractHttp2StreamChannel.this.readInProgress = false;
                    AbstractHttp2StreamChannel.this.unsafe().recvBufAllocHandle().readComplete();
                    AbstractHttp2StreamChannel.this.pipeline().fireChannelReadComplete();
                }
            }
        };
    }

    private boolean doRead0(Object obj, RecvByteBufAllocator.Handle handle) {
        int i4 = 0;
        if (obj == CLOSE_MESSAGE) {
            handle.readComplete();
            pipeline().fireChannelReadComplete();
            unsafe().close(voidPromise());
            return false;
        }
        if (obj instanceof Http2DataFrame) {
            Http2DataFrame http2DataFrame = (Http2DataFrame) obj;
            i4 = http2DataFrame.content().readableBytes() + http2DataFrame.padding();
            handle.lastBytesRead(i4);
        } else {
            handle.lastBytesRead(9);
        }
        handle.incMessagesRead(1);
        pipeline().fireChannelRead(obj);
        if (i4 != 0) {
            bytesConsumed(i4);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireChildRead0(Object obj) {
        if (this.closed) {
            ReferenceCountUtil.release(obj);
        } else if (this.readInProgress) {
            RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
            this.readInProgress = doRead0(ObjectUtil.checkNotNull(obj, "msg"), recvBufAllocHandle);
            if (recvBufAllocHandle.continueReading()) {
                return;
            }
            this.fireChildReadCompleteTask.run();
        } else {
            this.inboundBuffer.add(obj);
        }
    }

    protected abstract void bytesConsumed(int i4);

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() {
        if (this.readInProgress) {
            return;
        }
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.reset(config());
        if (this.inboundBuffer.isEmpty()) {
            this.readInProgress = true;
            return;
        }
        do {
            Object poll = this.inboundBuffer.poll();
            if (poll == null) {
                break;
            } else if (!doRead0(poll, recvBufAllocHandle)) {
                return;
            }
        } while (recvBufAllocHandle.continueReading());
        recvBufAllocHandle.readComplete();
        pipeline().fireChannelReadComplete();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        this.closed = true;
        while (!this.inboundBuffer.isEmpty()) {
            ReferenceCountUtil.release(this.inboundBuffer.poll());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (!this.closed) {
            EventExecutor preferredEventExecutor = preferredEventExecutor();
            if (!preferredEventExecutor.inEventLoop()) {
                int size = channelOutboundBuffer.size();
                final Object[] objArr = new Object[size];
                for (int i4 = 0; i4 < size; i4++) {
                    objArr[i4] = ReferenceCountUtil.retain(channelOutboundBuffer.current());
                    channelOutboundBuffer.remove();
                }
                preferredEventExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Object obj : objArr) {
                            try {
                                AbstractHttp2StreamChannel.this.doWrite(obj);
                            } catch (Throwable th) {
                                AbstractHttp2StreamChannel.this.pipeline().fireExceptionCaught(th);
                            }
                        }
                        AbstractHttp2StreamChannel.this.doWriteComplete();
                    }
                });
                return;
            }
            while (true) {
                Object current = channelOutboundBuffer.current();
                if (current == null) {
                    doWriteComplete();
                    return;
                }
                try {
                    doWrite(ReferenceCountUtil.retain(current));
                } catch (Throwable th) {
                    pipeline().fireExceptionCaught(th);
                }
                channelOutboundBuffer.remove();
            }
        } else {
            throw CLOSED_CHANNEL_EXCEPTION;
        }
    }

    protected abstract void doWrite(Object obj) throws Exception;

    protected abstract void doWriteComplete();

    /* JADX INFO: Access modifiers changed from: protected */
    public void fireChildRead(final Object obj) {
        if (eventLoop().inEventLoop()) {
            fireChildRead0(obj);
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.handler.codec.http2.AbstractHttp2StreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractHttp2StreamChannel.this.fireChildRead0(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fireChildReadComplete() {
        if (eventLoop().inEventLoop()) {
            this.fireChildReadCompleteTask.run();
        } else {
            eventLoop().execute(this.fireChildReadCompleteTask);
        }
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return !this.closed;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return true;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return parent().localAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    protected AbstractChannel.AbstractUnsafe newUnsafe() {
        return new Unsafe();
    }

    protected abstract EventExecutor preferredEventExecutor();

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return parent().remoteAddress();
    }
}
