package com.sun.mail.imap;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: IMAPFolder.java */
/* renamed from: com.sun.mail.imap.l */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12754l extends OutputStream {

    /* renamed from: a */
    private int f36049a = 0;

    /* renamed from: b */
    private byte[] f36050b = new byte[8192];

    /* renamed from: c */
    private int f36051c;

    public C12754l(int i) {
        this.f36051c = i;
    }

    /* renamed from: a */
    public byte[] m16240a() {
        return this.f36050b;
    }

    /* renamed from: b */
    public int m16239b() {
        return this.f36049a;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        int i2 = this.f36049a;
        int i3 = i2 + 1;
        byte[] bArr = this.f36050b;
        if (bArr != null) {
            int i4 = this.f36051c;
            if (i3 > i4 && i4 >= 0) {
                this.f36050b = null;
            } else if (i3 > bArr.length) {
                byte[] bArr2 = new byte[Math.max(bArr.length << 1, i3)];
                System.arraycopy(this.f36050b, 0, bArr2, 0, this.f36049a);
                this.f36050b = bArr2;
                bArr2[this.f36049a] = (byte) i;
            } else {
                bArr[i2] = (byte) i;
            }
        }
        this.f36049a = i3;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.f36049a;
        int i5 = i4 + i2;
        byte[] bArr2 = this.f36050b;
        if (bArr2 != null) {
            int i6 = this.f36051c;
            if (i5 > i6 && i6 >= 0) {
                this.f36050b = null;
            } else if (i5 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i5)];
                System.arraycopy(this.f36050b, 0, bArr3, 0, this.f36049a);
                this.f36050b = bArr3;
                System.arraycopy(bArr, i, bArr3, this.f36049a, i2);
            } else {
                System.arraycopy(bArr, i, bArr2, i4, i2);
            }
        }
        this.f36049a = i5;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
