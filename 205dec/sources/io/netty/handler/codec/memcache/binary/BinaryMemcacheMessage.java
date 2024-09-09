package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.MemcacheMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface BinaryMemcacheMessage extends MemcacheMessage {
    long cas();

    byte dataType();

    ByteBuf extras();

    byte extrasLength();

    ByteBuf key();

    short keyLength();

    byte magic();

    int opaque();

    byte opcode();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage retain();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage retain(int i4);

    BinaryMemcacheMessage setCas(long j4);

    BinaryMemcacheMessage setDataType(byte b4);

    BinaryMemcacheMessage setExtras(ByteBuf byteBuf);

    BinaryMemcacheMessage setKey(ByteBuf byteBuf);

    BinaryMemcacheMessage setMagic(byte b4);

    BinaryMemcacheMessage setOpaque(int i4);

    BinaryMemcacheMessage setOpcode(byte b4);

    BinaryMemcacheMessage setTotalBodyLength(int i4);

    int totalBodyLength();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage touch();

    @Override // io.netty.handler.codec.memcache.MemcacheMessage, io.netty.util.ReferenceCounted
    BinaryMemcacheMessage touch(Object obj);
}
