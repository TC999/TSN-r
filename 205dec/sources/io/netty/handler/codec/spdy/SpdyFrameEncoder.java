package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.nio.ByteOrder;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdyFrameEncoder {
    private final int version;

    public SpdyFrameEncoder(SpdyVersion spdyVersion) {
        if (spdyVersion != null) {
            this.version = spdyVersion.getVersion();
            return;
        }
        throw new NullPointerException("spdyVersion");
    }

    private void writeControlFrameHeader(ByteBuf byteBuf, int i4, byte b4, int i5) {
        byteBuf.writeShort(this.version | 32768);
        byteBuf.writeShort(i4);
        byteBuf.writeByte(b4);
        byteBuf.writeMedium(i5);
    }

    public ByteBuf encodeDataFrame(ByteBufAllocator byteBufAllocator, int i4, boolean z3, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        ByteBuf order = byteBufAllocator.ioBuffer(readableBytes + 8).order(ByteOrder.BIG_ENDIAN);
        order.writeInt(i4 & Integer.MAX_VALUE);
        order.writeByte(z3 ? 1 : 0);
        order.writeMedium(readableBytes);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodeGoAwayFrame(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 7, (byte) 0, 8);
        order.writeInt(i4);
        order.writeInt(i5);
        return order;
    }

    public ByteBuf encodeHeadersFrame(ByteBufAllocator byteBufAllocator, int i4, boolean z3, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int i5 = readableBytes + 4;
        ByteBuf order = byteBufAllocator.ioBuffer(i5 + 8).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 8, z3 ? (byte) 1 : (byte) 0, i5);
        order.writeInt(i4);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodePingFrame(ByteBufAllocator byteBufAllocator, int i4) {
        ByteBuf order = byteBufAllocator.ioBuffer(12).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 6, (byte) 0, 4);
        order.writeInt(i4);
        return order;
    }

    public ByteBuf encodeRstStreamFrame(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 3, (byte) 0, 8);
        order.writeInt(i4);
        order.writeInt(i5);
        return order;
    }

    public ByteBuf encodeSettingsFrame(ByteBufAllocator byteBufAllocator, SpdySettingsFrame spdySettingsFrame) {
        Set<Integer> ids = spdySettingsFrame.ids();
        int size = ids.size();
        boolean clearPreviouslyPersistedSettings = spdySettingsFrame.clearPreviouslyPersistedSettings();
        int i4 = (size * 8) + 4;
        ByteBuf order = byteBufAllocator.ioBuffer(i4 + 8).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 4, clearPreviouslyPersistedSettings ? (byte) 1 : (byte) 0, i4);
        order.writeInt(size);
        for (Integer num : ids) {
            byte b4 = spdySettingsFrame.isPersistValue(num.intValue()) ? (byte) 1 : (byte) 0;
            if (spdySettingsFrame.isPersisted(num.intValue())) {
                b4 = (byte) (b4 | 2);
            }
            order.writeByte(b4);
            order.writeMedium(num.intValue());
            order.writeInt(spdySettingsFrame.getValue(num.intValue()));
        }
        return order;
    }

    public ByteBuf encodeSynReplyFrame(ByteBufAllocator byteBufAllocator, int i4, boolean z3, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int i5 = readableBytes + 4;
        ByteBuf order = byteBufAllocator.ioBuffer(i5 + 8).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 2, z3 ? (byte) 1 : (byte) 0, i5);
        order.writeInt(i4);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuf encodeSynStreamFrame(ByteBufAllocator byteBufAllocator, int i4, int i5, byte b4, boolean z3, boolean z4, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        byte b5 = z3;
        if (z4) {
            b5 = (byte) (z3 | 2);
        }
        int i6 = readableBytes + 10;
        ByteBuf order = byteBufAllocator.ioBuffer(i6 + 8).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 1, b5, i6);
        order.writeInt(i4);
        order.writeInt(i5);
        order.writeShort((b4 & 255) << 13);
        order.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return order;
    }

    public ByteBuf encodeWindowUpdateFrame(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        ByteBuf order = byteBufAllocator.ioBuffer(16).order(ByteOrder.BIG_ENDIAN);
        writeControlFrameHeader(order, 9, (byte) 0, 8);
        order.writeInt(i4);
        order.writeInt(i5);
        return order;
    }
}
