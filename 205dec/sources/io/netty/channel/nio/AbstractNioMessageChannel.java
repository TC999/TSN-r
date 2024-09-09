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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    boolean inputShutdown;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Object> readBuf;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public void read() {
            boolean z3;
            boolean z4;
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
                        z3 = true;
                        break;
                    } else {
                        recvBufAllocHandle.incMessagesRead(doReadMessages);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (recvBufAllocHandle.continueReading());
            z3 = false;
            try {
                int size = this.readBuf.size();
                for (int i4 = 0; i4 < size; i4++) {
                    AbstractNioMessageChannel.this.readPending = false;
                    pipeline.fireChannelRead(this.readBuf.get(i4));
                }
                this.readBuf.clear();
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    if ((th instanceof IOException) && !(th instanceof PortUnreachableException)) {
                        z3 = !(AbstractNioMessageChannel.this instanceof ServerChannel);
                    }
                    pipeline.fireExceptionCaught(th);
                }
                if (z3) {
                    AbstractNioMessageChannel abstractNioMessageChannel = AbstractNioMessageChannel.this;
                    abstractNioMessageChannel.inputShutdown = true;
                    if (abstractNioMessageChannel.isOpen()) {
                        close(voidPromise());
                    }
                }
                if (z4) {
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
    public AbstractNioMessageChannel(Channel channel, SelectableChannel selectableChannel, int i4) {
        super(channel, selectableChannel, i4);
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
            boolean z3 = false;
            try {
                int writeSpinCount = config().getWriteSpinCount() - 1;
                while (true) {
                    if (writeSpinCount < 0) {
                        break;
                    } else if (doWriteMessage(current, channelOutboundBuffer)) {
                        z3 = true;
                        break;
                    } else {
                        writeSpinCount--;
                    }
                }
            } catch (IOException e4) {
                if (!continueOnWriteError()) {
                    throw e4;
                }
                channelOutboundBuffer.remove(e4);
            }
            if (!z3) {
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
