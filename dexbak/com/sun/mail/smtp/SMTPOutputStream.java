package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SMTPOutputStream extends CRLFOutputStream {
    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void ensureAtBOL() throws IOException {
        if (this.atBOL) {
            return;
        }
        super.writeln();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        int i2 = this.lastb;
        if ((i2 == 10 || i2 == 13 || i2 == -1) && i == 46) {
            ((FilterOutputStream) this).out.write(46);
        }
        super.write(i);
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.lastb;
        int i4 = i3;
        if (i3 == -1) {
            i4 = 10;
        }
        int i5 = i2 + i;
        int i6 = i4;
        int i7 = i;
        while (i < i5) {
            if ((i6 == 10 || i6 == 13) && bArr[i] == 46) {
                super.write(bArr, i7, i - i7);
                ((FilterOutputStream) this).out.write(46);
                i7 = i;
            }
            i6 = bArr[i];
            i++;
        }
        int i8 = i5 - i7;
        if (i8 > 0) {
            super.write(bArr, i7, i8);
        }
    }
}
