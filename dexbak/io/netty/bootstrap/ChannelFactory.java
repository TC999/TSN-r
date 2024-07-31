package io.netty.bootstrap;

import io.netty.channel.Channel;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ChannelFactory<T extends Channel> {
    T newChannel();
}
