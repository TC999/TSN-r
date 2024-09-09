package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultBinaryMemcacheRequest extends AbstractBinaryMemcacheMessage implements BinaryMemcacheRequest {
    public static final byte REQUEST_MAGIC_BYTE = Byte.MIN_VALUE;
    private short reserved;

    public DefaultBinaryMemcacheRequest() {
        this(null, null);
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest
    public short reserved() {
        return this.reserved;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest
    public BinaryMemcacheRequest setReserved(short s3) {
        this.reserved = s3;
        return this;
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf) {
        this(byteBuf, null);
    }

    public DefaultBinaryMemcacheRequest(ByteBuf byteBuf, ByteBuf byteBuf2) {
        super(byteBuf, byteBuf2);
        setMagic(Byte.MIN_VALUE);
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheMessage, io.netty.util.ReferenceCounted
    public BinaryMemcacheRequest touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
