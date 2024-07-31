package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.FullMemcacheMessage;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface FullBinaryMemcacheRequest extends BinaryMemcacheRequest, FullMemcacheMessage {
    FullBinaryMemcacheRequest copy();

    FullBinaryMemcacheRequest duplicate();

    FullBinaryMemcacheRequest replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheRequest retain();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheRequest retain(int i);

    FullBinaryMemcacheRequest retainedDuplicate();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheRequest touch();

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheRequest, io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage, io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    FullBinaryMemcacheRequest touch(Object obj);
}
