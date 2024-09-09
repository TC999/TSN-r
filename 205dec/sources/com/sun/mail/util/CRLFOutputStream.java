package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = {13, 10};
    protected boolean atBOL;
    protected int lastb;

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        if (i4 == 13) {
            writeln();
        } else if (i4 == 10) {
            if (this.lastb != 13) {
                writeln();
            }
        } else {
            ((FilterOutputStream) this).out.write(i4);
            this.atBOL = false;
        }
        this.lastb = i4;
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = i5 + i4;
        int i7 = i4;
        while (i4 < i6) {
            if (bArr[i4] == 13) {
                ((FilterOutputStream) this).out.write(bArr, i7, i4 - i7);
                writeln();
            } else if (bArr[i4] == 10) {
                if (this.lastb != 13) {
                    ((FilterOutputStream) this).out.write(bArr, i7, i4 - i7);
                    writeln();
                }
            } else {
                this.lastb = bArr[i4];
                i4++;
            }
            i7 = i4 + 1;
            this.lastb = bArr[i4];
            i4++;
        }
        int i8 = i6 - i7;
        if (i8 > 0) {
            ((FilterOutputStream) this).out.write(bArr, i7, i8);
            this.atBOL = false;
        }
    }
}
