package javax.mail.internet;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MimeUtility.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class AsciiOutputStream extends OutputStream {
    private boolean breakOnNonAscii;
    private boolean checkEOL;
    private int ascii = 0;
    private int non_ascii = 0;
    private int linelen = 0;
    private boolean longLine = false;
    private boolean badEOL = false;
    private int lastb = 0;
    private int ret = 0;

    public AsciiOutputStream(boolean z3, boolean z4) {
        boolean z5 = false;
        this.checkEOL = false;
        this.breakOnNonAscii = z3;
        if (z4 && z3) {
            z5 = true;
        }
        this.checkEOL = z5;
    }

    private final void check(int i4) throws IOException {
        int i5;
        int i6 = i4 & 255;
        if (this.checkEOL && (((i5 = this.lastb) == 13 && i6 != 10) || (i5 != 13 && i6 == 10))) {
            this.badEOL = true;
        }
        if (i6 != 13 && i6 != 10) {
            int i7 = this.linelen + 1;
            this.linelen = i7;
            if (i7 > 998) {
                this.longLine = true;
            }
        } else {
            this.linelen = 0;
        }
        if (MimeUtility.nonascii(i6)) {
            this.non_ascii++;
            if (this.breakOnNonAscii) {
                this.ret = 3;
                throw new EOFException();
            }
        } else {
            this.ascii++;
        }
        this.lastb = i6;
    }

    public int getAscii() {
        int i4 = this.ret;
        if (i4 != 0) {
            return i4;
        }
        if (this.badEOL) {
            return 3;
        }
        int i5 = this.non_ascii;
        return i5 == 0 ? this.longLine ? 2 : 1 : this.ascii > i5 ? 2 : 3;
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        check(i4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = i5 + i4;
        while (i4 < i6) {
            check(bArr[i4]);
            i4++;
        }
    }
}
