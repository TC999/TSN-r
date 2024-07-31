package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.List;
import kotlin.jvm.internal.C14354n;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i;
        if (byteBuf.isReadable()) {
            byteBuf.markReaderIndex();
            byte readByte = byteBuf.readByte();
            if (readByte >= 0) {
                return readByte;
            }
            int i2 = readByte & C14354n.f41155b;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte readByte2 = byteBuf.readByte();
            if (readByte2 >= 0) {
                i = readByte2 << 7;
            } else {
                i2 |= (readByte2 & C14354n.f41155b) << 7;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte readByte3 = byteBuf.readByte();
                if (readByte3 >= 0) {
                    i = readByte3 << 14;
                } else {
                    i2 |= (readByte3 & C14354n.f41155b) << 14;
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte readByte4 = byteBuf.readByte();
                    if (readByte4 < 0) {
                        int i3 = i2 | ((readByte4 & C14354n.f41155b) << 21);
                        if (!byteBuf.isReadable()) {
                            byteBuf.resetReaderIndex();
                            return 0;
                        }
                        byte readByte5 = byteBuf.readByte();
                        int i4 = i3 | (readByte5 << BinaryMemcacheOpcodes.TOUCH);
                        if (readByte5 >= 0) {
                            return i4;
                        }
                        throw new CorruptedFrameException("malformed varint.");
                    }
                    i = readByte4 << BinaryMemcacheOpcodes.INCREMENTQ;
                }
            }
            return i | i2;
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
