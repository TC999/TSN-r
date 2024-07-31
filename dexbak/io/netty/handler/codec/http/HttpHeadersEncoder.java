package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HttpHeadersEncoder {
    private HttpHeadersEncoder() {
    }

    public static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) throws Exception {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int writerIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, writerIndex, charSequence, length);
        int i = writerIndex + length;
        int i2 = i + 1;
        byteBuf.setByte(i, 58);
        int i3 = i2 + 1;
        byteBuf.setByte(i2, 32);
        writeAscii(byteBuf, i3, charSequence2, length2);
        int i4 = i3 + length2;
        int i5 = i4 + 1;
        byteBuf.setByte(i4, 13);
        byteBuf.setByte(i5, 10);
        byteBuf.writerIndex(i5 + 1);
    }

    private static void writeAscii(ByteBuf byteBuf, int i, CharSequence charSequence, int i2) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i, i2);
        } else {
            writeCharSequence(byteBuf, i, charSequence, i2);
        }
    }

    private static void writeCharSequence(ByteBuf byteBuf, int i, CharSequence charSequence, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            byteBuf.setByte(i, AsciiString.c2b(charSequence.charAt(i3)));
            i3++;
            i++;
        }
    }
}
