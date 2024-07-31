package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i) {
        this(i, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i) {
        fail(channelHandlerContext, String.valueOf(i));
    }

    private static int findEndOfLine(ByteBuf byteBuf) {
        int forEachByte = byteBuf.forEachByte(ByteProcessor.FIND_LF);
        return (forEachByte <= 0 || byteBuf.getByte(forEachByte + (-1)) != 13) ? forEachByte : forEachByte - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public LineBasedFrameDecoder(int i, boolean z, boolean z2) {
        this.maxLength = i;
        this.failFast = z2;
        this.stripDelimiter = z;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException("frame length (" + str + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int findEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (findEndOfLine >= 0) {
                int readerIndex = (this.discardedBytes + findEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(findEndOfLine + (byteBuf.getByte(findEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, readerIndex);
                }
            } else {
                this.discardedBytes += byteBuf.readableBytes();
                byteBuf.readerIndex(byteBuf.writerIndex());
            }
            return null;
        } else if (findEndOfLine >= 0) {
            int readerIndex2 = findEndOfLine - byteBuf.readerIndex();
            int i = byteBuf.getByte(findEndOfLine) != 13 ? 1 : 2;
            if (readerIndex2 > this.maxLength) {
                byteBuf.readerIndex(findEndOfLine + i);
                fail(channelHandlerContext, readerIndex2);
                return null;
            } else if (this.stripDelimiter) {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(readerIndex2);
                byteBuf.skipBytes(i);
                return readRetainedSlice;
            } else {
                return byteBuf.readRetainedSlice(readerIndex2 + i);
            }
        } else {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes > this.maxLength) {
                this.discardedBytes = readableBytes;
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.discarding = true;
                if (this.failFast) {
                    fail(channelHandlerContext, "over " + this.discardedBytes);
                }
            }
            return null;
        }
    }
}
