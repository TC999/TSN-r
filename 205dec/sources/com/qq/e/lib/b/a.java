package com.qq.e.lib.b;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f47363a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f47364b;

    public a(int i4) {
        this.f47363a = i4;
        int i5 = 1;
        if (i4 > 8) {
            if (i4 % 8 == 0) {
                i5 = i4 / 8;
            } else {
                i5 = 1 + (i4 / 8);
            }
        }
        this.f47364b = new byte[i5];
    }

    public void a(int i4, boolean z3) {
        if (i4 < 0 || i4 >= this.f47363a) {
            return;
        }
        if (z3) {
            byte[] bArr = this.f47364b;
            int b4 = b(i4);
            bArr[b4] = (byte) ((1 << a(i4)) | bArr[b4]);
            return;
        }
        byte[] bArr2 = this.f47364b;
        int b5 = b(i4);
        bArr2[b5] = (byte) (((1 << a(i4)) ^ (-1)) & bArr2[b5]);
    }

    public int b() {
        return this.f47363a;
    }

    public boolean c(int i4) {
        if (i4 < 0 || i4 >= this.f47363a) {
            return false;
        }
        return ((1 << a(i4)) & this.f47364b[b(i4)]) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i4 = 0; i4 < this.f47363a; i4++) {
            sb.append(c(i4) ? "1" : "0");
            if (i4 < this.f47363a - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private int b(int i4) {
        return i4 / 8;
    }

    public int a() {
        byte[] bArr;
        int i4 = 0;
        for (byte b4 : this.f47364b) {
            while (b4 != 0) {
                b4 = (byte) (b4 & (b4 - 1));
                i4++;
            }
        }
        return i4;
    }

    private int a(int i4) {
        return i4 % 8;
    }
}
