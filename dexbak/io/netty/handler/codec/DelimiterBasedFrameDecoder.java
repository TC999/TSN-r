package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i, ByteBuf byteBuf) {
        this(i, true, byteBuf);
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < byteBuf.writerIndex(); readerIndex++) {
            int i = 0;
            int i2 = readerIndex;
            while (i < byteBuf2.capacity() && byteBuf.getByte(i2) == byteBuf2.getByte(i)) {
                i2++;
                if (i2 == byteBuf.writerIndex() && i != byteBuf2.capacity() - 1) {
                    return -1;
                }
                i++;
            }
            if (i == byteBuf2.capacity()) {
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

    private static void validateMaxFrameLength(int i) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf byteBuf) {
        this(i, z, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf byteBuf) {
        this(i, z, z2, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        ByteBuf[] byteBufArr;
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        int i = Integer.MAX_VALUE;
        ByteBuf byteBuf2 = null;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int indexOf = indexOf(byteBuf, byteBuf3);
            if (indexOf >= 0 && indexOf < i) {
                byteBuf2 = byteBuf3;
                i = indexOf;
            }
        }
        if (byteBuf2 != null) {
            int capacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i + capacity);
                int i2 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i2);
                }
                return null;
            } else if (i > this.maxFrameLength) {
                byteBuf.skipBytes(capacity + i);
                fail(i);
                return null;
            } else if (this.stripDelimiter) {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(i);
                byteBuf.skipBytes(capacity);
                return readRetainedSlice;
            } else {
                return byteBuf.readRetainedSlice(i + capacity);
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

    public DelimiterBasedFrameDecoder(int i, ByteBuf... byteBufArr) {
        this(i, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf... byteBufArr) {
        this(i, z, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i);
        if (byteBufArr != null) {
            if (byteBufArr.length != 0) {
                if (isLineBased(byteBufArr) && !isSubclass()) {
                    this.lineBasedDecoder = new LineBasedFrameDecoder(i, z, z2);
                    this.delimiters = null;
                } else {
                    this.delimiters = new ByteBuf[byteBufArr.length];
                    for (int i2 = 0; i2 < byteBufArr.length; i2++) {
                        ByteBuf byteBuf = byteBufArr[i2];
                        validateDelimiter(byteBuf);
                        this.delimiters[i2] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
                    }
                    this.lineBasedDecoder = null;
                }
                this.maxFrameLength = i;
                this.stripDelimiter = z;
                this.failFast = z2;
                return;
            }
            throw new IllegalArgumentException("empty delimiters");
        }
        throw new NullPointerException("delimiters");
    }
}
