package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectAggregator;
import io.netty.handler.codec.memcache.FullMemcacheMessage;
import io.netty.handler.codec.memcache.MemcacheObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BinaryMemcacheObjectAggregator extends AbstractMemcacheObjectAggregator<BinaryMemcacheMessage> {
    public BinaryMemcacheObjectAggregator(int i4) {
        super(i4);
    }

    private static FullBinaryMemcacheRequest toFullRequest(BinaryMemcacheRequest binaryMemcacheRequest, ByteBuf byteBuf) {
        DefaultFullBinaryMemcacheRequest defaultFullBinaryMemcacheRequest = new DefaultFullBinaryMemcacheRequest(binaryMemcacheRequest.key() == null ? null : binaryMemcacheRequest.key().retain(), binaryMemcacheRequest.extras() != null ? binaryMemcacheRequest.extras().retain() : null, byteBuf);
        defaultFullBinaryMemcacheRequest.setMagic(binaryMemcacheRequest.magic());
        defaultFullBinaryMemcacheRequest.setOpcode(binaryMemcacheRequest.opcode());
        defaultFullBinaryMemcacheRequest.setKeyLength(binaryMemcacheRequest.keyLength());
        defaultFullBinaryMemcacheRequest.setExtrasLength(binaryMemcacheRequest.extrasLength());
        defaultFullBinaryMemcacheRequest.setDataType(binaryMemcacheRequest.dataType());
        defaultFullBinaryMemcacheRequest.setTotalBodyLength(binaryMemcacheRequest.totalBodyLength());
        defaultFullBinaryMemcacheRequest.setOpaque(binaryMemcacheRequest.opaque());
        defaultFullBinaryMemcacheRequest.setCas(binaryMemcacheRequest.cas());
        defaultFullBinaryMemcacheRequest.setReserved(binaryMemcacheRequest.reserved());
        return defaultFullBinaryMemcacheRequest;
    }

    private static FullBinaryMemcacheResponse toFullResponse(BinaryMemcacheResponse binaryMemcacheResponse, ByteBuf byteBuf) {
        DefaultFullBinaryMemcacheResponse defaultFullBinaryMemcacheResponse = new DefaultFullBinaryMemcacheResponse(binaryMemcacheResponse.key() == null ? null : binaryMemcacheResponse.key().retain(), binaryMemcacheResponse.extras() != null ? binaryMemcacheResponse.extras().retain() : null, byteBuf);
        defaultFullBinaryMemcacheResponse.setMagic(binaryMemcacheResponse.magic());
        defaultFullBinaryMemcacheResponse.setOpcode(binaryMemcacheResponse.opcode());
        defaultFullBinaryMemcacheResponse.setKeyLength(binaryMemcacheResponse.keyLength());
        defaultFullBinaryMemcacheResponse.setExtrasLength(binaryMemcacheResponse.extrasLength());
        defaultFullBinaryMemcacheResponse.setDataType(binaryMemcacheResponse.dataType());
        defaultFullBinaryMemcacheResponse.setTotalBodyLength(binaryMemcacheResponse.totalBodyLength());
        defaultFullBinaryMemcacheResponse.setOpaque(binaryMemcacheResponse.opaque());
        defaultFullBinaryMemcacheResponse.setCas(binaryMemcacheResponse.cas());
        defaultFullBinaryMemcacheResponse.setStatus(binaryMemcacheResponse.status());
        return defaultFullBinaryMemcacheResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public FullMemcacheMessage beginAggregation(BinaryMemcacheMessage binaryMemcacheMessage, ByteBuf byteBuf) throws Exception {
        if (binaryMemcacheMessage instanceof BinaryMemcacheRequest) {
            return toFullRequest((BinaryMemcacheRequest) binaryMemcacheMessage, byteBuf);
        }
        if (binaryMemcacheMessage instanceof BinaryMemcacheResponse) {
            return toFullResponse((BinaryMemcacheResponse) binaryMemcacheMessage, byteBuf);
        }
        throw new Error();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof BinaryMemcacheMessage;
    }
}
