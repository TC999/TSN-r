package io.netty.channel.udt;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface UdtServerChannelConfig extends UdtChannelConfig {
    int getBacklog();

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAutoClose(boolean z3);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAutoRead(boolean z3);

    UdtServerChannelConfig setBacklog(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setConnectTimeoutMillis(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    UdtServerChannelConfig setMaxMessagesPerRead(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setProtocolReceiveBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setProtocolSendBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setReceiveBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setReuseAddress(boolean z3);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSendBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSoLinger(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSystemReceiveBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSystemSendBufferSize(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    UdtServerChannelConfig setWriteBufferHighWaterMark(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    UdtServerChannelConfig setWriteBufferLowWaterMark(int i4);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteSpinCount(int i4);
}
