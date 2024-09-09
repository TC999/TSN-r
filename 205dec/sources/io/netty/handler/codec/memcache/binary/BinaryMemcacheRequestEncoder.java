package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BinaryMemcacheRequestEncoder extends AbstractBinaryMemcacheEncoder<BinaryMemcacheRequest> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.memcache.binary.AbstractBinaryMemcacheEncoder
    public void encodeHeader(ByteBuf byteBuf, BinaryMemcacheRequest binaryMemcacheRequest) {
        byteBuf.writeByte(binaryMemcacheRequest.magic());
        byteBuf.writeByte(binaryMemcacheRequest.opcode());
        byteBuf.writeShort(binaryMemcacheRequest.keyLength());
        byteBuf.writeByte(binaryMemcacheRequest.extrasLength());
        byteBuf.writeByte(binaryMemcacheRequest.dataType());
        byteBuf.writeShort(binaryMemcacheRequest.reserved());
        byteBuf.writeInt(binaryMemcacheRequest.totalBodyLength());
        byteBuf.writeInt(binaryMemcacheRequest.opaque());
        byteBuf.writeLong(binaryMemcacheRequest.cas());
    }
}
