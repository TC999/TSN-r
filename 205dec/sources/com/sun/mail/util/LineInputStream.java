package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LineInputStream extends FilterInputStream {
    private char[] lineBuffer;

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
        this.lineBuffer = null;
    }

    public String readLine() throws IOException {
        int read;
        InputStream inputStream = ((FilterInputStream) this).in;
        char[] cArr = this.lineBuffer;
        if (cArr == null) {
            cArr = new char[128];
            this.lineBuffer = cArr;
        }
        int length = cArr.length;
        int i4 = 0;
        while (true) {
            read = inputStream.read();
            if (read == -1 || read == 10) {
                break;
            } else if (read == 13) {
                int read2 = inputStream.read();
                if (read2 == 13) {
                    read2 = inputStream.read();
                }
                if (read2 != 10) {
                    if (!(inputStream instanceof PushbackInputStream)) {
                        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                        ((FilterInputStream) this).in = pushbackInputStream;
                        inputStream = pushbackInputStream;
                    }
                    ((PushbackInputStream) inputStream).unread(read2);
                }
            } else {
                length--;
                if (length < 0) {
                    int i5 = i4 + 128;
                    char[] cArr2 = new char[i5];
                    System.arraycopy(this.lineBuffer, 0, cArr2, 0, i4);
                    this.lineBuffer = cArr2;
                    length = (i5 - i4) - 1;
                    cArr = cArr2;
                }
                cArr[i4] = (char) read;
                i4++;
            }
        }
        if (read == -1 && i4 == 0) {
            return null;
        }
        return String.copyValueOf(cArr, 0, i4);
    }
}
