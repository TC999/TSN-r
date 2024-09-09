package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class KQueueServerSocketChannelConfig extends KQueueServerChannelConfig implements ServerSocketChannelConfig {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueServerSocketChannelConfig(KQueueServerSocketChannel kQueueServerSocketChannel) {
        super(kQueueServerSocketChannel);
        mo103setReuseAddress(true);
    }

    public AcceptFilter getAcceptFilter() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.getAcceptFilter();
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            return (T) Boolean.valueOf(isReusePort());
        }
        if (channelOption == KQueueChannelOption.SO_ACCEPTFILTER) {
            return (T) getAcceptFilter();
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.SO_REUSEPORT, KQueueChannelOption.SO_ACCEPTFILTER);
    }

    public boolean isReusePort() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    public KQueueServerSocketChannelConfig setAcceptFilter(AcceptFilter acceptFilter) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setAcceptFilter(acceptFilter);
            return this;
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t3) {
        validate(channelOption, t3);
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == KQueueChannelOption.SO_ACCEPTFILTER) {
            setAcceptFilter((AcceptFilter) t3);
            return true;
        } else {
            return super.setOption(channelOption, t3);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setPerformancePreferences(int i4, int i5, int i6) {
        return this;
    }

    public KQueueServerSocketChannelConfig setReusePort(boolean z3) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setReusePort(z3);
            return this;
        } catch (IOException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setBacklog */
    public KQueueServerSocketChannelConfig mo101setBacklog(int i4) {
        super.mo101setBacklog(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueServerSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean z3) {
        super.setRcvAllocTransportProvidesGuess(z3);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setReceiveBufferSize */
    public KQueueServerSocketChannelConfig mo102setReceiveBufferSize(int i4) {
        super.mo102setReceiveBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setReuseAddress */
    public KQueueServerSocketChannelConfig mo103setReuseAddress(boolean z3) {
        super.mo103setReuseAddress(z3);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAutoRead(boolean z3) {
        super.setAutoRead(z3);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setConnectTimeoutMillis(int i4) {
        super.setConnectTimeoutMillis(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setMaxMessagesPerRead(int i4) {
        super.setMaxMessagesPerRead(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferHighWaterMark(int i4) {
        super.setWriteBufferHighWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferLowWaterMark(int i4) {
        super.setWriteBufferLowWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteSpinCount(int i4) {
        super.setWriteSpinCount(i4);
        return this;
    }
}
