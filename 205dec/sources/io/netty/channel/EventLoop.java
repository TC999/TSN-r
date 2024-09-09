package io.netty.channel;

import io.netty.util.concurrent.OrderedEventExecutor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface EventLoop extends OrderedEventExecutor, EventLoopGroup {
    @Override // 
    EventLoopGroup parent();
}
