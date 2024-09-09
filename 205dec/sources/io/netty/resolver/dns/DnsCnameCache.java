package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DnsCnameCache {
    void cache(String str, String str2, long j4, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    String get(String str);
}
