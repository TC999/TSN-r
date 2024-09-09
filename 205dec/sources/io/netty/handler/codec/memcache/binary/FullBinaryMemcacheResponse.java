package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.FullMemcacheMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface FullBinaryMemcacheResponse extends BinaryMemcacheResponse, FullMemcacheMessage {
    FullBinaryMemcacheResponse copy();

    FullBinaryMemcacheResponse duplicate();

    FullBinaryMemcacheResponse replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheResponse retain();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheResponse retain(int i4);

    FullBinaryMemcacheResponse retainedDuplicate();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheResponse touch();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheResponse, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheResponse touch(Object obj);
}
