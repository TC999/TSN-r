package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SnappyFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_COMPRESSIBLE_LENGTH = 18;
    private static final byte[] STREAM_START = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private final Snappy snappy = new Snappy();
    private boolean started;

    private static void calculateAndWriteChecksum(ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf2.writeIntLE(Snappy.calculateChecksum(byteBuf));
    }

    private static void setChunkLength(ByteBuf byteBuf, int i) {
        int writerIndex = (byteBuf.writerIndex() - i) - 3;
        if ((writerIndex >>> 24) == 0) {
            byteBuf.setMediumLE(i, writerIndex);
            return;
        }
        throw new CompressionException("compressed data too large: " + writerIndex);
    }

    private static void writeChunkLength(ByteBuf byteBuf, int i) {
        byteBuf.writeMediumLE(i);
    }

    private static void writeUnencodedChunk(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        byteBuf2.writeByte(1);
        writeChunkLength(byteBuf2, i + 4);
        calculateAndWriteChecksum(byteBuf, byteBuf2);
        byteBuf2.writeBytes(byteBuf, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        if (!byteBuf.isReadable()) {
            return;
        }
        if (!this.started) {
            this.started = true;
            byteBuf2.writeBytes(STREAM_START);
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes <= 18) {
            writeUnencodedChunk(byteBuf, byteBuf2, readableBytes);
            return;
        }
        while (true) {
            int writerIndex = byteBuf2.writerIndex() + 1;
            if (readableBytes < 18) {
                writeUnencodedChunk(byteBuf.readSlice(readableBytes), byteBuf2, readableBytes);
                return;
            }
            byteBuf2.writeInt(0);
            if (readableBytes > 32767) {
                ByteBuf readSlice = byteBuf.readSlice(32767);
                calculateAndWriteChecksum(readSlice, byteBuf2);
                this.snappy.encode(readSlice, byteBuf2, 32767);
                setChunkLength(byteBuf2, writerIndex);
                readableBytes -= 32767;
            } else {
                ByteBuf readSlice2 = byteBuf.readSlice(readableBytes);
                calculateAndWriteChecksum(readSlice2, byteBuf2);
                this.snappy.encode(readSlice2, byteBuf2, readableBytes);
                setChunkLength(byteBuf2, writerIndex);
                return;
            }
        }
    }
}
