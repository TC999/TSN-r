package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i4, ByteBuf byteBuf) {
        this(i4, true, byteBuf);
    }

    private void fail(long j4) {
        if (j4 > 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j4 + " - discarded");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < byteBuf.writerIndex(); readerIndex++) {
            int i4 = 0;
            int i5 = readerIndex;
            while (i4 < byteBuf2.capacity() && byteBuf.getByte(i5) == byteBuf2.getByte(i4)) {
                i5++;
                if (i5 == byteBuf.writerIndex() && i4 != byteBuf2.capacity() - 1) {
                    return -1;
                }
                i4++;
            }
            if (i4 == byteBuf2.capacity()) {
                return readerIndex - byteBuf.readerIndex();
            }
        }
        return -1;
    }

    private static boolean isLineBased(ByteBuf[] byteBufArr) {
        if (byteBufArr.length != 2) {
            return false;
        }
        ByteBuf byteBuf = byteBufArr[0];
        ByteBuf byteBuf2 = byteBufArr[1];
        if (byteBuf.capacity() < byteBuf2.capacity()) {
            byteBuf = byteBufArr[1];
            byteBuf2 = byteBufArr[0];
        }
        return byteBuf.capacity() == 2 && byteBuf2.capacity() == 1 && byteBuf.getByte(0) == 13 && byteBuf.getByte(1) == 10 && byteBuf2.getByte(0) == 10;
    }

    private boolean isSubclass() {
        return getClass() != DelimiterBasedFrameDecoder.class;
    }

    private static void validateDelimiter(ByteBuf byteBuf) {
        if (byteBuf != null) {
            if (!byteBuf.isReadable()) {
                throw new IllegalArgumentException("empty delimiter");
            }
            return;
        }
        throw new NullPointerException("delimiter");
    }

    private static void validateMaxFrameLength(int i4) {
        if (i4 > 0) {
            return;
        }
        throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public DelimiterBasedFrameDecoder(int i4, boolean z3, ByteBuf byteBuf) {
        this(i4, z3, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i4, boolean z3, boolean z4, ByteBuf byteBuf) {
        this(i4, z3, z4, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf[] byteBufArr;
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        int i4 = Integer.MAX_VALUE;
        ByteBuf byteBuf2 = null;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int indexOf = indexOf(byteBuf, byteBuf3);
            if (indexOf >= 0 && indexOf < i4) {
                byteBuf2 = byteBuf3;
                i4 = indexOf;
            }
        }
        if (byteBuf2 != null) {
            int capacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i4 + capacity);
                int i5 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i5);
                }
                return null;
            } else if (i4 > this.maxFrameLength) {
                byteBuf.skipBytes(capacity + i4);
                fail(i4);
                return null;
            } else if (this.stripDelimiter) {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(i4);
                byteBuf.skipBytes(capacity);
                return readRetainedSlice;
            } else {
                return byteBuf.readRetainedSlice(i4 + capacity);
            }
        }
        if (!this.discardingTooLongFrame) {
            if (byteBuf.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength += byteBuf.readableBytes();
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        return null;
    }

    public DelimiterBasedFrameDecoder(int i4, ByteBuf... byteBufArr) {
        this(i4, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i4, boolean z3, ByteBuf... byteBufArr) {
        this(i4, z3, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i4, boolean z3, boolean z4, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i4);
        if (byteBufArr != null) {
            if (byteBufArr.length != 0) {
                if (isLineBased(byteBufArr) && !isSubclass()) {
                    this.lineBasedDecoder = new LineBasedFrameDecoder(i4, z3, z4);
                    this.delimiters = null;
                } else {
                    this.delimiters = new ByteBuf[byteBufArr.length];
                    for (int i5 = 0; i5 < byteBufArr.length; i5++) {
                        ByteBuf byteBuf = byteBufArr[i5];
                        validateDelimiter(byteBuf);
                        this.delimiters[i5] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
                    }
                    this.lineBasedDecoder = null;
                }
                this.maxFrameLength = i4;
                this.stripDelimiter = z3;
                this.failFast = z4;
                return;
            }
            throw new IllegalArgumentException("empty delimiters");
        }
        throw new NullPointerException("delimiters");
    }
}
