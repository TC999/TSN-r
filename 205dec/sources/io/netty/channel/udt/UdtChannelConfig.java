package io.netty.channel.udt;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface UdtChannelConfig extends ChannelConfig {
    int getProtocolReceiveBufferSize();

    int getProtocolSendBufferSize();

    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getSystemReceiveBufferSize();

    int getSystemSendBufferSize();

    boolean isReuseAddress();

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAutoClose(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAutoRead(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setConnectTimeoutMillis(int i4);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    UdtChannelConfig setMaxMessagesPerRead(int i4);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    UdtChannelConfig setProtocolReceiveBufferSize(int i4);

    UdtChannelConfig setProtocolSendBufferSize(int i4);

    UdtChannelConfig setReceiveBufferSize(int i4);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    UdtChannelConfig setReuseAddress(boolean z3);

    UdtChannelConfig setSendBufferSize(int i4);

    UdtChannelConfig setSoLinger(int i4);

    UdtChannelConfig setSystemReceiveBufferSize(int i4);

    UdtChannelConfig setSystemSendBufferSize(int i4);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    UdtChannelConfig setWriteBufferHighWaterMark(int i4);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    UdtChannelConfig setWriteBufferLowWaterMark(int i4);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteSpinCount(int i4);
}
