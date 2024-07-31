package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class CompressionUtil {
    private CompressionUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkChecksum(ByteBufChecksum byteBufChecksum, ByteBuf byteBuf, int i) {
        byteBufChecksum.reset();
        byteBufChecksum.update(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
        int value = (int) byteBufChecksum.getValue();
        if (value != i) {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer safeNioBuffer(ByteBuf byteBuf) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
    }
}
