package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i4;
        if (byteBuf.isReadable()) {
            byteBuf.markReaderIndex();
            byte readByte = byteBuf.readByte();
            if (readByte >= 0) {
                return readByte;
            }
            int i5 = readByte & Byte.MAX_VALUE;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte readByte2 = byteBuf.readByte();
            if (readByte2 >= 0) {
                i4 = readByte2 << 7;
            } else {
                i5 |= (readByte2 & Byte.MAX_VALUE) << 7;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte readByte3 = byteBuf.readByte();
                if (readByte3 >= 0) {
                    i4 = readByte3 << 14;
                } else {
                    i5 |= (readByte3 & Byte.MAX_VALUE) << 14;
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte readByte4 = byteBuf.readByte();
                    if (readByte4 < 0) {
                        int i6 = i5 | ((readByte4 & Byte.MAX_VALUE) << 21);
                        if (!byteBuf.isReadable()) {
                            byteBuf.resetReaderIndex();
                            return 0;
                        }
                        byte readByte5 = byteBuf.readByte();
                        int i7 = i6 | (readByte5 << 28);
                        if (readByte5 >= 0) {
                            return i7;
                        }
                        throw new CorruptedFrameException("malformed varint.");
                    }
                    i4 = readByte4 << 21;
                }
            }
            return i4 | i5;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byteBuf.markReaderIndex();
        int readerIndex = byteBuf.readerIndex();
        int readRawVarint32 = readRawVarint32(byteBuf);
        if (readerIndex == byteBuf.readerIndex()) {
            return;
        }
        if (readRawVarint32 >= 0) {
            if (byteBuf.readableBytes() < readRawVarint32) {
                byteBuf.resetReaderIndex();
                return;
            } else {
                list.add(byteBuf.readRetainedSlice(readRawVarint32));
                return;
            }
        }
        throw new CorruptedFrameException("negative length: " + readRawVarint32);
    }
}
