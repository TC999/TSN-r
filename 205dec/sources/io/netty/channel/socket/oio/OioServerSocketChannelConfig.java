package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface OioServerSocketChannelConfig extends ServerSocketChannelConfig {
    int getSoTimeout();

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoClose(boolean z3);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoRead(boolean z3);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setBacklog */
    OioServerSocketChannelConfig mo101setBacklog(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setConnectTimeoutMillis(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioServerSocketChannelConfig setMaxMessagesPerRead(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setPerformancePreferences(int i4, int i5, int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setReceiveBufferSize */
    OioServerSocketChannelConfig mo102setReceiveBufferSize(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    /* renamed from: setReuseAddress */
    OioServerSocketChannelConfig mo103setReuseAddress(boolean z3);

    OioServerSocketChannelConfig setSoTimeout(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioServerSocketChannelConfig setWriteBufferHighWaterMark(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioServerSocketChannelConfig setWriteBufferLowWaterMark(int i4);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteSpinCount(int i4);
}
