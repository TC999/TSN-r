package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.nio.ByteOrder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i4, int i5, int i6) {
        this(i4, i5, i6, 0, 0);
    }

    private void fail(long j4) {
        if (j4 > 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j4 + " - discarded");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private void failIfNecessary(boolean z3) {
        if (this.bytesToDiscard == 0) {
            long j4 = this.tooLongFrameLength;
            this.tooLongFrameLength = 0L;
            this.discardingTooLongFrame = false;
            boolean z4 = this.failFast;
            if (!z4 || (z4 && z3)) {
                fail(j4);
            }
        } else if (this.failFast && z3) {
            fail(this.tooLongFrameLength);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    protected ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i4, int i5) {
        return byteBuf.retainedSlice(i4, i5);
    }

    protected long getUnadjustedFrameLength(ByteBuf byteBuf, int i4, int i5, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf order = byteBuf.order(byteOrder);
        if (i5 == 1) {
            unsignedByte = order.getUnsignedByte(i4);
        } else if (i5 == 2) {
            unsignedByte = order.getUnsignedShort(i4);
        } else if (i5 != 3) {
            if (i5 != 4) {
                if (i5 == 8) {
                    return order.getLong(i4);
                }
                throw new DecoderException("unsupported lengthFieldLength: " + this.lengthFieldLength + " (expected: 1, 2, 3, 4, or 8)");
            }
            return order.getUnsignedInt(i4);
        } else {
            unsignedByte = order.getUnsignedMedium(i4);
        }
        return unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(int i4, int i5, int i6, int i7, int i8) {
        this(i4, i5, i6, i7, i8, true);
    }

    public LengthFieldBasedFrameDecoder(int i4, int i5, int i6, int i7, int i8, boolean z3) {
        this(ByteOrder.BIG_ENDIAN, i4, i5, i6, i7, i8, z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.discardingTooLongFrame) {
            long j4 = this.bytesToDiscard;
            int min = (int) Math.min(j4, byteBuf.readableBytes());
            byteBuf.skipBytes(min);
            this.bytesToDiscard = j4 - min;
            failIfNecessary(false);
        }
        if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
            return null;
        }
        long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
        if (unadjustedFrameLength >= 0) {
            int i4 = this.lengthAdjustment;
            int i5 = this.lengthFieldEndOffset;
            long j5 = unadjustedFrameLength + i4 + i5;
            if (j5 >= i5) {
                if (j5 > this.maxFrameLength) {
                    long readableBytes = j5 - byteBuf.readableBytes();
                    this.tooLongFrameLength = j5;
                    if (readableBytes < 0) {
                        byteBuf.skipBytes((int) j5);
                    } else {
                        this.discardingTooLongFrame = true;
                        this.bytesToDiscard = readableBytes;
                        byteBuf.skipBytes(byteBuf.readableBytes());
                    }
                    failIfNecessary(true);
                    return null;
                }
                int i6 = (int) j5;
                if (byteBuf.readableBytes() < i6) {
                    return null;
                }
                int i7 = this.initialBytesToStrip;
                if (i7 <= i6) {
                    byteBuf.skipBytes(i7);
                    int readerIndex = byteBuf.readerIndex();
                    int i8 = i6 - this.initialBytesToStrip;
                    ByteBuf extractFrame = extractFrame(channelHandlerContext, byteBuf, readerIndex, i8);
                    byteBuf.readerIndex(readerIndex + i8);
                    return extractFrame;
                }
                byteBuf.skipBytes(i6);
                throw new CorruptedFrameException("Adjusted frame length (" + j5 + ") is less than initialBytesToStrip: " + this.initialBytesToStrip);
            }
            byteBuf.skipBytes(i5);
            throw new CorruptedFrameException("Adjusted frame length (" + j5 + ") is less than lengthFieldEndOffset: " + this.lengthFieldEndOffset);
        }
        byteBuf.skipBytes(this.lengthFieldEndOffset);
        throw new CorruptedFrameException("negative pre-adjustment length field: " + unadjustedFrameLength);
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i4, int i5, int i6, int i7, int i8, boolean z3) {
        if (byteOrder == null) {
            throw new NullPointerException("byteOrder");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i4);
        } else if (i5 < 0) {
            throw new IllegalArgumentException("lengthFieldOffset must be a non-negative integer: " + i5);
        } else if (i8 < 0) {
            throw new IllegalArgumentException("initialBytesToStrip must be a non-negative integer: " + i8);
        } else if (i5 <= i4 - i6) {
            this.byteOrder = byteOrder;
            this.maxFrameLength = i4;
            this.lengthFieldOffset = i5;
            this.lengthFieldLength = i6;
            this.lengthAdjustment = i7;
            this.lengthFieldEndOffset = i5 + i6;
            this.initialBytesToStrip = i8;
            this.failFast = z3;
        } else {
            throw new IllegalArgumentException("maxFrameLength (" + i4 + ") must be equal to or greater than lengthFieldOffset (" + i5 + ") + lengthFieldLength (" + i6 + ").");
        }
    }
}
