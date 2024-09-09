package io.netty.channel.udt;

import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultUdtServerChannelConfig extends DefaultUdtChannelConfig implements UdtServerChannelConfig {
    private volatile int backlog;

    public DefaultUdtServerChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z3) throws IOException {
        super(udtChannel, channelUDT, z3);
        this.backlog = 64;
        if (z3) {
            apply(channelUDT);
        }
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig
    protected void apply(ChannelUDT channelUDT) throws IOException {
    }

    @Override // io.netty.channel.udt.UdtServerChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == ChannelOption.SO_BACKLOG) {
            return (T) Integer.valueOf(getBacklog());
        }
        return (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BACKLOG);
    }

    @Override // io.netty.channel.udt.UdtServerChannelConfig
    public UdtServerChannelConfig setBacklog(int i4) {
        this.backlog = i4;
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t3) {
        validate(channelOption, t3);
        if (channelOption == ChannelOption.SO_BACKLOG) {
            setBacklog(((Integer) t3).intValue());
            return true;
        }
        return super.setOption(channelOption, t3);
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setProtocolReceiveBufferSize(int i4) {
        super.setProtocolReceiveBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setProtocolSendBufferSize(int i4) {
        super.setProtocolSendBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setReceiveBufferSize(int i4) {
        super.setReceiveBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setReuseAddress(boolean z3) {
        super.setReuseAddress(z3);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSendBufferSize(int i4) {
        super.setSendBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSoLinger(int i4) {
        super.setSoLinger(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSystemReceiveBufferSize(int i4) {
        super.setSystemReceiveBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSystemSendBufferSize(int i4) {
        super.setSystemSendBufferSize(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAutoClose(boolean z3) {
        super.setAutoClose(z3);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAutoRead(boolean z3) {
        super.setAutoRead(z3);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setConnectTimeoutMillis(int i4) {
        super.setConnectTimeoutMillis(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtServerChannelConfig setMaxMessagesPerRead(int i4) {
        super.setMaxMessagesPerRead(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtServerChannelConfig setWriteBufferHighWaterMark(int i4) {
        super.setWriteBufferHighWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtServerChannelConfig setWriteBufferLowWaterMark(int i4) {
        super.setWriteBufferLowWaterMark(i4);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteSpinCount(int i4) {
        super.setWriteSpinCount(i4);
        return this;
    }
}
