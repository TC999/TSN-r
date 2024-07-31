package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface MemcacheContent extends MemcacheObject, ByteBufHolder {
    MemcacheContent copy();

    MemcacheContent duplicate();

    MemcacheContent replace(ByteBuf byteBuf);

    MemcacheContent retain();

    MemcacheContent retain(int i);

    MemcacheContent retainedDuplicate();

    MemcacheContent touch();

    MemcacheContent touch(Object obj);
}
