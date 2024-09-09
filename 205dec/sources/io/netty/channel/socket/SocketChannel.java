package io.netty.channel.socket;

import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SocketChannel extends DuplexChannel {
    @Override // io.netty.channel.Channel
    SocketChannelConfig config();

    @Override // io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    ServerSocketChannel parent();

    @Override // io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}
