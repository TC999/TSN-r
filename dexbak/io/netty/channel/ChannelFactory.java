package io.netty.channel;

import io.netty.channel.Channel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ChannelFactory<T extends Channel> extends io.netty.bootstrap.ChannelFactory<T> {
    @Override // io.netty.bootstrap.ChannelFactory
    T newChannel();
}
