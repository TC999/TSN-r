package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultLastMemcacheContent extends DefaultMemcacheContent implements LastMemcacheContent {
    public DefaultLastMemcacheContent() {
        super(Unpooled.buffer());
    }

    public DefaultLastMemcacheContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public LastMemcacheContent copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public LastMemcacheContent duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public LastMemcacheContent replace(ByteBuf byteBuf) {
        return new DefaultLastMemcacheContent(byteBuf);
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.handler.codec.memcache.MemcacheContent, io.netty.buffer.ByteBufHolder
    public LastMemcacheContent retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public LastMemcacheContent retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public LastMemcacheContent touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public LastMemcacheContent retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.handler.codec.memcache.DefaultMemcacheContent, io.netty.util.ReferenceCounted
    public LastMemcacheContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
