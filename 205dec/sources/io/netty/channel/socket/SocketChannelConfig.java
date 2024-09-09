package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SocketChannelConfig extends ChannelConfig {
    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getTrafficClass();

    boolean isAllowHalfClosure();

    boolean isKeepAlive();

    boolean isReuseAddress();

    boolean isTcpNoDelay();

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    SocketChannelConfig setAllowHalfClosure(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoClose(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoRead(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setConnectTimeoutMillis(int i4);

    SocketChannelConfig setKeepAlive(boolean z3);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int i4);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SocketChannelConfig setPerformancePreferences(int i4, int i5, int i6);

    SocketChannelConfig setReceiveBufferSize(int i4);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SocketChannelConfig setReuseAddress(boolean z3);

    SocketChannelConfig setSendBufferSize(int i4);

    SocketChannelConfig setSoLinger(int i4);

    SocketChannelConfig setTcpNoDelay(boolean z3);

    SocketChannelConfig setTrafficClass(int i4);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteSpinCount(int i4);
}
