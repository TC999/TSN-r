package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class CompressionUtil {
    private CompressionUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkChecksum(ByteBufChecksum byteBufChecksum, ByteBuf byteBuf, int i4) {
        byteBufChecksum.reset();
        byteBufChecksum.update(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
        int value = (int) byteBufChecksum.getValue();
        if (value != i4) {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(i4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer safeNioBuffer(ByteBuf byteBuf) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
    }
}
