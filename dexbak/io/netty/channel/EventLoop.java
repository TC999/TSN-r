package io.netty.channel;

import io.netty.util.concurrent.OrderedEventExecutor;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface EventLoop extends OrderedEventExecutor, EventLoopGroup {
    @Override // 
    EventLoopGroup parent();
}
