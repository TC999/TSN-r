package com.sun.mail.imap;

import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPFolder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class l extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f50461a = 0;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f50462b = new byte[8192];

    /* renamed from: c  reason: collision with root package name */
    private int f50463c;

    public l(int i4) {
        this.f50463c = i4;
    }

    public byte[] a() {
        return this.f50462b;
    }

    public int b() {
        return this.f50461a;
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        int i5 = this.f50461a;
        int i6 = i5 + 1;
        byte[] bArr = this.f50462b;
        if (bArr != null) {
            int i7 = this.f50463c;
            if (i6 > i7 && i7 >= 0) {
                this.f50462b = null;
            } else if (i6 > bArr.length) {
                byte[] bArr2 = new byte[Math.max(bArr.length << 1, i6)];
                System.arraycopy(this.f50462b, 0, bArr2, 0, this.f50461a);
                this.f50462b = bArr2;
                bArr2[this.f50461a] = (byte) i4;
            } else {
                bArr[i5] = (byte) i4;
            }
        }
        this.f50461a = i6;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) {
        int i6;
        if (i4 < 0 || i4 > bArr.length || i5 < 0 || (i6 = i4 + i5) > bArr.length || i6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 == 0) {
            return;
        }
        int i7 = this.f50461a;
        int i8 = i7 + i5;
        byte[] bArr2 = this.f50462b;
        if (bArr2 != null) {
            int i9 = this.f50463c;
            if (i8 > i9 && i9 >= 0) {
                this.f50462b = null;
            } else if (i8 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i8)];
                System.arraycopy(this.f50462b, 0, bArr3, 0, this.f50461a);
                this.f50462b = bArr3;
                System.arraycopy(bArr, i4, bArr3, this.f50461a, i5);
            } else {
                System.arraycopy(bArr, i4, bArr2, i7, i5);
            }
        }
        this.f50461a = i8;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
