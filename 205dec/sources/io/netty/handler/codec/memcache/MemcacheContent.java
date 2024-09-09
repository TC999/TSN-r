package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface MemcacheContent extends MemcacheObject, ByteBufHolder {
    MemcacheContent copy();

    MemcacheContent duplicate();

    MemcacheContent replace(ByteBuf byteBuf);

    MemcacheContent retain();

    MemcacheContent retain(int i4);

    MemcacheContent retainedDuplicate();

    MemcacheContent touch();

    MemcacheContent touch(Object obj);
}
