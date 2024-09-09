package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QEncoderStream extends QPEncoderStream {
    private static String TEXT_SPECIALS = "=_?";
    private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
    private String specials;

    public QEncoderStream(OutputStream outputStream, boolean z3) {
        super(outputStream, Integer.MAX_VALUE);
        this.specials = z3 ? WORD_SPECIALS : TEXT_SPECIALS;
    }

    public static int encodedLength(byte[] bArr, boolean z3) {
        String str = z3 ? WORD_SPECIALS : TEXT_SPECIALS;
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = b4 & 255;
            i4 = (i5 < 32 || i5 >= 127 || str.indexOf(i5) >= 0) ? i4 + 3 : i4 + 1;
        }
        return i4;
    }

    @Override // com.sun.mail.util.QPEncoderStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        int i5 = i4 & 255;
        if (i5 == 32) {
            output(95, false);
        } else if (i5 >= 32 && i5 < 127 && this.specials.indexOf(i5) < 0) {
            output(i5, false);
        } else {
            output(i5, true);
        }
    }
}
