package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public abstract EventLoop next();
}
