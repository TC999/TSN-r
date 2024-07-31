package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private void failIfNecessary(boolean z) {
        if (this.bytesToDiscard == 0) {
            long j = this.tooLongFrameLength;
            this.tooLongFrameLength = 0L;
            this.discardingTooLongFrame = false;
            boolean z2 = this.failFast;
            if (!z2 || (z2 && z)) {
                fail(j);
            }
        } else if (this.failFast && z) {
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

    protected ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.retainedSlice(i, i2);
    }

    protected long getUnadjustedFrameLength(ByteBuf byteBuf, int i, int i2, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf order = byteBuf.order(byteOrder);
        if (i2 == 1) {
            unsignedByte = order.getUnsignedByte(i);
        } else if (i2 == 2) {
            unsignedByte = order.getUnsignedShort(i);
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 8) {
                    return order.getLong(i);
                }
                throw new DecoderException("unsupported lengthFieldLength: " + this.lengthFieldLength + " (expected: 1, 2, 3, 4, or 8)");
            }
            return order.getUnsignedInt(i);
        } else {
            unsignedByte = order.getUnsignedMedium(i);
        }
        return unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, true);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, i3, i4, i5, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.discardingTooLongFrame) {
            long j = this.bytesToDiscard;
            int min = (int) Math.min(j, byteBuf.readableBytes());
            byteBuf.skipBytes(min);
            this.bytesToDiscard = j - min;
            failIfNecessary(false);
        }
        if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
            return null;
        }
        long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
        if (unadjustedFrameLength >= 0) {
            int i = this.lengthAdjustment;
            int i2 = this.lengthFieldEndOffset;
            long j2 = unadjustedFrameLength + i + i2;
            if (j2 >= i2) {
                if (j2 > this.maxFrameLength) {
                    long readableBytes = j2 - byteBuf.readableBytes();
                    this.tooLongFrameLength = j2;
                    if (readableBytes < 0) {
                        byteBuf.skipBytes((int) j2);
                    } else {
                        this.discardingTooLongFrame = true;
                        this.bytesToDiscard = readableBytes;
                        byteBuf.skipBytes(byteBuf.readableBytes());
                    }
                    failIfNecessary(true);
                    return null;
                }
                int i3 = (int) j2;
                if (byteBuf.readableBytes() < i3) {
                    return null;
                }
                int i4 = this.initialBytesToStrip;
                if (i4 <= i3) {
                    byteBuf.skipBytes(i4);
                    int readerIndex = byteBuf.readerIndex();
                    int i5 = i3 - this.initialBytesToStrip;
                    ByteBuf extractFrame = extractFrame(channelHandlerContext, byteBuf, readerIndex, i5);
                    byteBuf.readerIndex(readerIndex + i5);
                    return extractFrame;
                }
                byteBuf.skipBytes(i3);
                throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than initialBytesToStrip: " + this.initialBytesToStrip);
            }
            byteBuf.skipBytes(i2);
            throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than lengthFieldEndOffset: " + this.lengthFieldEndOffset);
        }
        byteBuf.skipBytes(this.lengthFieldEndOffset);
        throw new CorruptedFrameException("negative pre-adjustment length field: " + unadjustedFrameLength);
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (byteOrder == null) {
            throw new NullPointerException("byteOrder");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("lengthFieldOffset must be a non-negative integer: " + i2);
        } else if (i5 < 0) {
            throw new IllegalArgumentException("initialBytesToStrip must be a non-negative integer: " + i5);
        } else if (i2 <= i - i3) {
            this.byteOrder = byteOrder;
            this.maxFrameLength = i;
            this.lengthFieldOffset = i2;
            this.lengthFieldLength = i3;
            this.lengthAdjustment = i4;
            this.lengthFieldEndOffset = i2 + i3;
            this.initialBytesToStrip = i5;
            this.failFast = z;
        } else {
            throw new IllegalArgumentException("maxFrameLength (" + i + ") must be equal to or greater than lengthFieldOffset (" + i2 + ") + lengthFieldLength (" + i3 + ").");
        }
    }
}
