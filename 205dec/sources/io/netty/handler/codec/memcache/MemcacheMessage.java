package io.netty.handler.codec.memcache;

import io.netty.util.ReferenceCounted;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface MemcacheMessage extends MemcacheObject, ReferenceCounted {
    MemcacheMessage retain();

    MemcacheMessage retain(int i4);

    MemcacheMessage touch();

    MemcacheMessage touch(Object obj);
}
