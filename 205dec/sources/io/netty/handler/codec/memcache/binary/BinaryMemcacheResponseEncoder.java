package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BinaryMemcacheResponseEncoder extends AbstractBinaryMemcacheEncoder<BinaryMemcacheResponse> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheEncoder
    public void encodeHeader(ByteBuf byteBuf, BinaryMemcacheResponse binaryMemcacheResponse) {
        byteBuf.writeByte(binaryMemcacheResponse.magic());
        byteBuf.writeByte(binaryMemcacheResponse.opcode());
        byteBuf.writeShort(binaryMemcacheResponse.keyLength());
        byteBuf.writeByte(binaryMemcacheResponse.extrasLength());
        byteBuf.writeByte(binaryMemcacheResponse.dataType());
        byteBuf.writeShort(binaryMemcacheResponse.status());
        byteBuf.writeInt(binaryMemcacheResponse.totalBodyLength());
        byteBuf.writeInt(binaryMemcacheResponse.opaque());
        byteBuf.writeLong(binaryMemcacheResponse.cas());
    }
}
