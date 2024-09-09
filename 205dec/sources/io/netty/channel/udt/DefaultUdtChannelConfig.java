package io.netty.channel.udt;

import com.barchart.udt.OptionUDT;
import com.barchart.udt.SocketUDT;
import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultUdtChannelConfig extends DefaultChannelConfig implements UdtChannelConfig {
    private static final int K = 1024;
    private static final int M = 1048576;
    private volatile int allocatorReceiveBufferSize;
    private volatile int allocatorSendBufferSize;
    private volatile int protocolReceiveBufferSize;
    private volatile int protocolSendBufferSize;
    private volatile boolean reuseAddress;
    private volatile int soLinger;
    private volatile int systemReceiveBufferSize;
    private volatile int systemSendBufferSize;

    public DefaultUdtChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z3) throws IOException {
        super(udtChannel);
        this.protocolReceiveBufferSize = 10485760;
        this.protocolSendBufferSize = 10485760;
        this.systemReceiveBufferSize = 1048576;
        this.systemSendBufferSize = 1048576;
        this.allocatorReceiveBufferSize = 131072;
        this.allocatorSendBufferSize = 131072;
        this.reuseAddress = true;
        if (z3) {
            apply(channelUDT);
        }
    }

    protected void apply(ChannelUDT channelUDT) throws IOException {
        SocketUDT socketUDT = channelUDT.socketUDT();
        socketUDT.setReuseAddress(isReuseAddress());
        socketUDT.setSendBufferSize(getSendBufferSize());
        if (getSoLinger() <= 0) {
            socketUDT.setSoLinger(false, 0);
        } else {
            socketUDT.setSoLinger(true, getSoLinger());
        }
        socketUDT.setOption(OptionUDT.Protocol_Receive_Buffer_Size, Integer.valueOf(getProtocolReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.Protocol_Send_Buffer_Size, Integer.valueOf(getProtocolSendBufferSize()));
        socketUDT.setOption(OptionUDT.System_Receive_Buffer_Size, Integer.valueOf(getSystemReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.System_Send_Buffer_Size, Integer.valueOf(getSystemSendBufferSize()));
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE) {
            return (T) Integer.valueOf(getProtocolReceiveBufferSize());
        }
        if (channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE) {
            return (T) Integer.valueOf(getProtocolSendBufferSize());
        }
        if (channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE) {
            return (T) Integer.valueOf(getSystemReceiveBufferSize());
        }
        if (channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE) {
            return (T) Integer.valueOf(getSystemSendBufferSize());
        }
        if (channelOption == ChannelOption.SO_RCVBUF) {
            return (T) Integer.valueOf(getReceiveBufferSize());
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            return (T) Boolean.valueOf(isReuseAddress());
        }
        if (channelOption == ChannelOption.SO_LINGER) {
            return (T) Integer.valueOf(getSoLinger());
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE, UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE, UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE, UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER);
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getProtocolReceiveBufferSize() {
        return this.protocolReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getProtocolSendBufferSize() {
        return this.protocolSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getReceiveBufferSize() {
        return this.allocatorReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSendBufferSize() {
        return this.allocatorSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSoLinger() {
        return this.soLinger;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSystemReceiveBufferSize() {
        return this.systemReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSystemSendBufferSize() {
        return this.systemSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public boolean isReuseAddress() {
        return this.reuseAddress;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t3) {
        validate(channelOption, t3);
        if (channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE) {
            setProtocolReceiveBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE) {
            setProtocolSendBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE) {
            setSystemReceiveBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE) {
            setSystemSendBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t3).intValue());
            return true;
        } else if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t3).booleanValue());
            return true;
        } else if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t3).intValue());
            return true;
        } else {
            return super.setOption(channelOption, t3);
        }
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setProtocolReceiveBufferSize(int i4) {
        this.protocolReceiveBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setProtocolSendBufferSize(int i4) {
        this.protocolSendBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setReceiveBufferSize(int i4) {
        this.allocatorReceiveBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setReuseAddress(boolean z3) {
        this.reuseAddress = z3;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSendBufferSize(int i4) {
        this.allocatorSendBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSoLinger(int i4) {
        this.soLinger = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSystemReceiveBufferSize(int i4) {
        this.systemSendBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSystemSendBufferSize(int i4) {
        this.systemReceiveBufferSize = i4;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAutoClose(boolean z3) {
        super.setAutoClose(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAutoRead(boolean z3) {
        super.setAutoRead(z3);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setConnectTimeoutMillis(int i4) {
        super.setConnectTimeoutMillis(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtChannelConfig setMaxMessagesPerRead(int i4) {
        super.setMaxMessagesPerRead(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtChannelConfig setWriteBufferHighWaterMark(int i4) {
        super.setWriteBufferHighWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtChannelConfig setWriteBufferLowWaterMark(int i4) {
        super.setWriteBufferLowWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteSpinCount(int i4) {
        super.setWriteSpinCount(i4);
        return this;
    }
}
