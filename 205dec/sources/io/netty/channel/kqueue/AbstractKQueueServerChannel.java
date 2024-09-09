package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class AbstractKQueueServerChannel extends AbstractKQueueChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public final class KQueueServerSocketUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress;

        KQueueServerSocketUnsafe() {
            super();
            this.acceptedAddress = new byte[26];
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            KQueueChannelConfig config = AbstractKQueueServerChannel.this.config();
            if (AbstractKQueueServerChannel.this.shouldBreakReadReady(config)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline pipeline = AbstractKQueueServerChannel.this.pipeline();
            kQueueRecvByteAllocatorHandle.reset(config);
            kQueueRecvByteAllocatorHandle.attemptedBytesRead(1);
            readReadyBefore();
            Throwable th = null;
            do {
                try {
                    int accept = AbstractKQueueServerChannel.this.socket.accept(this.acceptedAddress);
                    if (accept == -1) {
                        kQueueRecvByteAllocatorHandle.lastBytesRead(-1);
                        break;
                    }
                    kQueueRecvByteAllocatorHandle.lastBytesRead(1);
                    kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                    this.readPending = false;
                    AbstractKQueueServerChannel abstractKQueueServerChannel = AbstractKQueueServerChannel.this;
                    byte[] bArr = this.acceptedAddress;
                    pipeline.fireChannelRead((Object) abstractKQueueServerChannel.newChildChannel(accept, bArr, 1, bArr[0]));
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (kQueueRecvByteAllocatorHandle.continueReading());
            try {
                kQueueRecvByteAllocatorHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                readReadyFinally(config);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractKQueueServerChannel(BsdSocket bsdSocket) {
        this(bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    abstract Channel newChildChannel(int i4, byte[] bArr, int i5, int i6) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractKQueueServerChannel(BsdSocket bsdSocket, boolean z3) {
        super((Channel) null, bsdSocket, z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueServerSocketUnsafe();
    }
}
