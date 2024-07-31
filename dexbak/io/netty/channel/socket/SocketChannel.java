package io.netty.channel.socket;

import java.net.InetSocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
