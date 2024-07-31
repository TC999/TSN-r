package io.netty.channel.unix;

import io.netty.channel.ServerChannel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ServerDomainSocketChannel extends ServerChannel, UnixChannel {
    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
