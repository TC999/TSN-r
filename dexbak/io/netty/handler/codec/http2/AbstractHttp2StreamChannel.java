package io.netty.handler.codec.http2;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        int i = 0;
        if (obj == CLOSE_MESSAGE) {
            handle.readComplete();
            pipeline().fireChannelReadComplete();
            unsafe().close(voidPromise());
            return false;
        }
        if (obj instanceof Http2DataFrame) {
            Http2DataFrame http2DataFrame = (Http2DataFrame) obj;
            i = http2DataFrame.content().readableBytes() + http2DataFrame.padding();
            handle.lastBytesRead(i);
        } else {
            handle.lastBytesRead(9);
        }
        handle.incMessagesRead(1);
        pipeline().fireChannelRead(obj);
        if (i != 0) {
            bytesConsumed(i);
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

    protected abstract void bytesConsumed(int i);

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
                for (int i = 0; i < size; i++) {
                    objArr[i] = ReferenceCountUtil.retain(channelOutboundBuffer.current());
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
