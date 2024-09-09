package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdyHeaderBlockRawEncoder extends SpdyHeaderBlockEncoder {
    private final int version;

    public SpdyHeaderBlockRawEncoder(SpdyVersion spdyVersion) {
        if (spdyVersion != null) {
            this.version = spdyVersion.getVersion();
            return;
        }
        throw new NullPointerException("version");
    }

    private static void setLengthField(ByteBuf byteBuf, int i4, int i5) {
        byteBuf.setInt(i4, i5);
    }

    private static void writeLengthField(ByteBuf byteBuf, int i4) {
        byteBuf.writeInt(i4);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        Set<CharSequence> names = spdyHeadersFrame.headers().names();
        int size = names.size();
        if (size == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (size <= 65535) {
            ByteBuf heapBuffer = byteBufAllocator.heapBuffer();
            writeLengthField(heapBuffer, size);
            for (CharSequence charSequence : names) {
                writeLengthField(heapBuffer, charSequence.length());
                ByteBufUtil.writeAscii(heapBuffer, charSequence);
                int writerIndex = heapBuffer.writerIndex();
                writeLengthField(heapBuffer, 0);
                int i4 = 0;
                for (CharSequence charSequence2 : spdyHeadersFrame.headers().getAll(charSequence)) {
                    int length = charSequence2.length();
                    if (length > 0) {
                        ByteBufUtil.writeAscii(heapBuffer, charSequence2);
                        heapBuffer.writeByte(0);
                        i4 += length + 1;
                    }
                }
                if (i4 != 0) {
                    i4--;
                }
                if (i4 > 65535) {
                    throw new IllegalArgumentException("header exceeds allowable length: " + ((Object) charSequence));
                } else if (i4 > 0) {
                    setLengthField(heapBuffer, writerIndex, i4);
                    heapBuffer.writerIndex(heapBuffer.writerIndex() - 1);
                }
            }
            return heapBuffer;
        }
        throw new IllegalArgumentException("header block contains too many headers");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
    }
}
