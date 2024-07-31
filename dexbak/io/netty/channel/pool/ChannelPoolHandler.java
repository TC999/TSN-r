package io.netty.channel.pool;

import io.netty.channel.Channel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ChannelPoolHandler {
    void channelAcquired(Channel channel) throws Exception;

    void channelCreated(Channel channel) throws Exception;

    void channelReleased(Channel channel) throws Exception;
}
