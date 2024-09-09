package io.netty.channel.unix;

import io.netty.channel.socket.DuplexChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DomainSocketChannel extends UnixChannel, DuplexChannel {
    @Override // io.netty.channel.Channel
    DomainSocketChannelConfig config();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
