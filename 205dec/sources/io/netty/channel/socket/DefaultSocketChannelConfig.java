package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    protected final Socket javaSocket;

    public DefaultSocketChannelConfig(SocketChannel socketChannel, Socket socket) {
        super(socketChannel);
        if (socket != null) {
            this.javaSocket = socket;
            if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
                try {
                    setTcpNoDelay(true);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("javaSocket");
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE);
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return this.javaSocket.getSoLinger();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return this.javaSocket.getKeepAlive();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return this.javaSocket.getTcpNoDelay();
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllowHalfClosure(boolean z3) {
        this.allowHalfClosure = z3;
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setKeepAlive(boolean z3) {
        try {
            this.javaSocket.setKeepAlive(z3);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t3) {
        validate(channelOption, t3);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t3).booleanValue());
            return true;
        } else {
            return super.setOption(channelOption, t3);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setPerformancePreferences(int i4, int i5, int i6) {
        this.javaSocket.setPerformancePreferences(i4, i5, i6);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReceiveBufferSize(int i4) {
        try {
            this.javaSocket.setReceiveBufferSize(i4);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReuseAddress(boolean z3) {
        try {
            this.javaSocket.setReuseAddress(z3);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSendBufferSize(int i4) {
        try {
            this.javaSocket.setSendBufferSize(i4);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSoLinger(int i4) {
        try {
            if (i4 < 0) {
                this.javaSocket.setSoLinger(false, 0);
            } else {
                this.javaSocket.setSoLinger(true, i4);
            }
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTcpNoDelay(boolean z3) {
        try {
            this.javaSocket.setTcpNoDelay(z3);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTrafficClass(int i4) {
        try {
            this.javaSocket.setTrafficClass(i4);
            return this;
        } catch (SocketException e4) {
            throw new ChannelException(e4);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAutoClose(boolean z3) {
        super.setAutoClose(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setAutoRead(boolean z3) {
        super.setAutoRead(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setConnectTimeoutMillis(int i4) {
        super.setConnectTimeoutMillis(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public SocketChannelConfig setMaxMessagesPerRead(int i4) {
        super.setMaxMessagesPerRead(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public SocketChannelConfig setWriteBufferHighWaterMark(int i4) {
        super.setWriteBufferHighWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public SocketChannelConfig setWriteBufferLowWaterMark(int i4) {
        super.setWriteBufferLowWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SocketChannelConfig setWriteSpinCount(int i4) {
        super.setWriteSpinCount(i4);
        return this;
    }
}
