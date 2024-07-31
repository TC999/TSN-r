package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        int i = 0;
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
                    int i2 = i + 128;
                    char[] cArr2 = new char[i2];
                    System.arraycopy(this.lineBuffer, 0, cArr2, 0, i);
                    this.lineBuffer = cArr2;
                    length = (i2 - i) - 1;
                    cArr = cArr2;
                }
                cArr[i] = (char) read;
                i++;
            }
        }
        if (read == -1 && i == 0) {
            return null;
        }
        return String.copyValueOf(cArr, 0, i);
    }
}
