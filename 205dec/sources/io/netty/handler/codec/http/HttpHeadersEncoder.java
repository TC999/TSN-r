package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class HttpHeadersEncoder {
    private HttpHeadersEncoder() {
    }

    public static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) throws Exception {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int writerIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, writerIndex, charSequence, length);
        int i4 = writerIndex + length;
        int i5 = i4 + 1;
        byteBuf.setByte(i4, 58);
        int i6 = i5 + 1;
        byteBuf.setByte(i5, 32);
        writeAscii(byteBuf, i6, charSequence2, length2);
        int i7 = i6 + length2;
        int i8 = i7 + 1;
        byteBuf.setByte(i7, 13);
        byteBuf.setByte(i8, 10);
        byteBuf.writerIndex(i8 + 1);
    }

    private static void writeAscii(ByteBuf byteBuf, int i4, CharSequence charSequence, int i5) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i4, i5);
        } else {
            writeCharSequence(byteBuf, i4, charSequence, i5);
        }
    }

    private static void writeCharSequence(ByteBuf byteBuf, int i4, CharSequence charSequence, int i5) {
        int i6 = 0;
        while (i6 < i5) {
            byteBuf.setByte(i4, AsciiString.c2b(charSequence.charAt(i6)));
            i6++;
            i4++;
        }
    }
}
