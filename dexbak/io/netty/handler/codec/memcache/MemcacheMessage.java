package io.netty.handler.codec.memcache;

import io.netty.util.ReferenceCounted;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface MemcacheMessage extends MemcacheObject, ReferenceCounted {
    MemcacheMessage retain();

    MemcacheMessage retain(int i);

    MemcacheMessage touch();

    MemcacheMessage touch(Object obj);
}
