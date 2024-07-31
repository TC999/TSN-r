package io.netty.channel.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.AbstractNioChannel;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    boolean inputShutdown;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Object> readBuf;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public void read() {
            boolean z;
            boolean z2;
            ChannelConfig config = AbstractNioMessageChannel.this.config();
            ChannelPipeline pipeline = AbstractNioMessageChannel.this.pipeline();
            RecvByteBufAllocator.Handle recvBufAllocHandle = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
            recvBufAllocHandle.reset(config);
            Throwable th = null;
            do {
                try {
                    int doReadMessages = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
                    if (doReadMessages == 0) {
                        break;
                    } else if (doReadMessages < 0) {
                        z = true;
                        break;
                    } else {
                        recvBufAllocHandle.incMessagesRead(doReadMessages);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (recvBufAllocHandle.continueReading());
            z = false;
            try {
                int size = this.readBuf.size();
                for (int i = 0; i < size; i++) {
                    AbstractNioMessageChannel.this.readPending = false;
                    pipeline.fireChannelRead(this.readBuf.get(i));
                }
                this.readBuf.clear();
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    if ((th instanceof IOException) && !(th instanceof PortUnreachableException)) {
                        z = !(AbstractNioMessageChannel.this instanceof ServerChannel);
                    }
                    pipeline.fireExceptionCaught(th);
                }
                if (z) {
                    AbstractNioMessageChannel abstractNioMessageChannel = AbstractNioMessageChannel.this;
                    abstractNioMessageChannel.inputShutdown = true;
                    if (abstractNioMessageChannel.isOpen()) {
                        close(voidPromise());
                    }
                }
                if (z2) {
                    return;
                }
            } finally {
                if (!AbstractNioMessageChannel.this.readPending && !config.isAutoRead()) {
                    removeReadOp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNioMessageChannel(Channel channel, SelectableChannel selectableChannel, int i) {
        super(channel, selectableChannel, i);
    }

    protected boolean continueOnWriteError() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    public void doBeginRead() throws Exception {
        if (this.inputShutdown) {
            return;
        }
        super.doBeginRead();
    }

    protected abstract int doReadMessages(List<Object> list) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        SelectionKey selectionKey = selectionKey();
        int interestOps = selectionKey.interestOps();
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                if ((interestOps & 4) != 0) {
                    selectionKey.interestOps(interestOps & (-5));
                    return;
                }
                return;
            }
            boolean z = false;
            try {
                int writeSpinCount = config().getWriteSpinCount() - 1;
                while (true) {
                    if (writeSpinCount < 0) {
                        break;
                    } else if (doWriteMessage(current, channelOutboundBuffer)) {
                        z = true;
                        break;
                    } else {
                        writeSpinCount--;
                    }
                }
            } catch (IOException e) {
                if (!continueOnWriteError()) {
                    throw e;
                }
                channelOutboundBuffer.remove(e);
            }
            if (!z) {
                if ((interestOps & 4) == 0) {
                    selectionKey.interestOps(interestOps | 4);
                    return;
                }
                return;
            }
            channelOutboundBuffer.remove();
        }
    }

    protected abstract boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe();
    }
}
