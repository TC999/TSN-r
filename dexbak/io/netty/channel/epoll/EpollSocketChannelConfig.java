package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollSocketChannelConfig extends EpollChannelConfig implements SocketChannelConfig {
    private static final long MAX_UINT32_T = 4294967295L;
    private volatile boolean allowHalfClosure;
    private final EpollSocketChannel channel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollSocketChannelConfig(EpollSocketChannel epollSocketChannel) {
        super(epollSocketChannel);
        this.channel = epollSocketChannel;
        if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
            setTcpNoDelay(true);
        }
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        if (channelOption == ChannelOption.TCP_NODELAY) {
            return (T) Boolean.valueOf(isTcpNoDelay());
        }
        if (channelOption == ChannelOption.SO_KEEPALIVE) {
            return (T) Boolean.valueOf(isKeepAlive());
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (channelOption == ChannelOption.SO_LINGER) {
            return (T) Integer.valueOf(getSoLinger());
        }
        if (channelOption == ChannelOption.IP_TOS) {
            return (T) Integer.valueOf(getTrafficClass());
        }
        if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            return (T) Boolean.valueOf(isAllowHalfClosure());
        }
        if (channelOption == EpollChannelOption.TCP_CORK) {
            return (T) Boolean.valueOf(isTcpCork());
        }
        if (channelOption == EpollChannelOption.TCP_NOTSENT_LOWAT) {
            return (T) Long.valueOf(getTcpNotSentLowAt());
        }
        if (channelOption == EpollChannelOption.TCP_KEEPIDLE) {
            return (T) Integer.valueOf(getTcpKeepIdle());
        }
        if (channelOption == EpollChannelOption.TCP_KEEPINTVL) {
            return (T) Integer.valueOf(getTcpKeepIntvl());
        }
        if (channelOption == EpollChannelOption.TCP_KEEPCNT) {
            return (T) Integer.valueOf(getTcpKeepCnt());
        }
        if (channelOption == EpollChannelOption.TCP_USER_TIMEOUT) {
            return (T) Integer.valueOf(getTcpUserTimeout());
        }
        if (channelOption == EpollChannelOption.TCP_QUICKACK) {
            return (T) Boolean.valueOf(isTcpQuickAck());
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, EpollChannelOption.TCP_CORK, EpollChannelOption.TCP_NOTSENT_LOWAT, EpollChannelOption.TCP_KEEPCNT, EpollChannelOption.TCP_KEEPIDLE, EpollChannelOption.TCP_KEEPINTVL, EpollChannelOption.TCP_MD5SIG, EpollChannelOption.TCP_QUICKACK);
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.channel.mo12687fd().getReceiveBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return this.channel.mo12687fd().getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return this.channel.mo12687fd().getSoLinger();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepCnt() {
        try {
            return Native.getTcpKeepCnt(this.channel.mo12687fd().intValue());
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepIdle() {
        try {
            return Native.getTcpKeepIdle(this.channel.mo12687fd().intValue());
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpKeepIntvl() {
        try {
            return Native.getTcpKeepIntvl(this.channel.mo12687fd().intValue());
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public long getTcpNotSentLowAt() {
        try {
            return Native.getTcpNotSentLowAt(this.channel.mo12687fd().intValue()) & 4294967295L;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public int getTcpUserTimeout() {
        try {
            return Native.getTcpUserTimeout(this.channel.mo12687fd().intValue());
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return Native.getTrafficClass(this.channel.mo12687fd().intValue());
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return this.channel.mo12687fd().isKeepAlive();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return Native.isReuseAddress(this.channel.mo12687fd().intValue()) == 1;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isTcpCork() {
        try {
            return this.channel.mo12687fd().isTcpCork();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return this.channel.mo12687fd().isTcpNoDelay();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public boolean isTcpQuickAck() {
        try {
            return this.channel.mo12687fd().isTcpQuickAck();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t).intValue());
            return true;
        } else if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_CORK) {
            setTcpCork(((Boolean) t).booleanValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_NOTSENT_LOWAT) {
            setTcpNotSentLowAt(((Long) t).longValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_KEEPIDLE) {
            setTcpKeepIdle(((Integer) t).intValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_KEEPCNT) {
            setTcpKeepCntl(((Integer) t).intValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_KEEPINTVL) {
            setTcpKeepIntvl(((Integer) t).intValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_USER_TIMEOUT) {
            setTcpUserTimeout(((Integer) t).intValue());
            return true;
        } else if (channelOption == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) t);
            return true;
        } else if (channelOption == EpollChannelOption.TCP_QUICKACK) {
            setTcpQuickAck(((Boolean) t).booleanValue());
            return true;
        } else {
            return super.setOption(channelOption, t);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setPerformancePreferences(int i, int i2, int i3) {
        return this;
    }

    public EpollSocketChannelConfig setTcpCork(boolean z) {
        try {
            this.channel.mo12687fd().setTcpCork(z);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpKeepCntl(int i) {
        try {
            Native.setTcpKeepCnt(this.channel.mo12687fd().intValue(), i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIdle(int i) {
        try {
            Native.setTcpKeepIdle(this.channel.mo12687fd().intValue(), i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIntvl(int i) {
        try {
            Native.setTcpKeepIntvl(this.channel.mo12687fd().intValue(), i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> map) {
        try {
            this.channel.setTcpMd5Sig(map);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpNotSentLowAt(long j) {
        if (j >= 0 && j <= 4294967295L) {
            try {
                Native.setTcpNotSentLowAt(this.channel.mo12687fd().intValue(), (int) j);
                return this;
            } catch (IOException e) {
                throw new ChannelException(e);
            }
        }
        throw new IllegalArgumentException("tcpNotSentLowAt must be a uint32_t");
    }

    public EpollSocketChannelConfig setTcpQuickAck(boolean z) {
        try {
            this.channel.mo12687fd().setTcpQuickAck(z);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public EpollSocketChannelConfig setTcpUserTimeout(int i) {
        try {
            Native.setTcpUserTimeout(this.channel.mo12687fd().intValue(), i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setAllowHalfClosure(boolean z) {
        this.allowHalfClosure = z;
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig
    public EpollSocketChannelConfig setEpollMode(EpollMode epollMode) {
        super.setEpollMode(epollMode);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setKeepAlive(boolean z) {
        try {
            this.channel.mo12687fd().setKeepAlive(z);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReceiveBufferSize(int i) {
        try {
            this.channel.mo12687fd().setReceiveBufferSize(i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReuseAddress(boolean z) {
        try {
            Native.setReuseAddress(this.channel.mo12687fd().intValue(), z ? 1 : 0);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSendBufferSize(int i) {
        try {
            this.channel.mo12687fd().setSendBufferSize(i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSoLinger(int i) {
        try {
            this.channel.mo12687fd().setSoLinger(i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTcpNoDelay(boolean z) {
        try {
            this.channel.mo12687fd().setTcpNoDelay(z);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTrafficClass(int i) {
        try {
            Native.setTrafficClass(this.channel.mo12687fd().intValue(), i);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }
}
