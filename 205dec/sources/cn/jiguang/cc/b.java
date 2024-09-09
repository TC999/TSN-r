package cn.jiguang.cc;

import cn.jiguang.f.g;
import java.math.BigInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f3257d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3258a;

    /* renamed from: b  reason: collision with root package name */
    private int f3259b;

    /* renamed from: c  reason: collision with root package name */
    private int f3260c;

    public b() {
        this(32);
    }

    public b(int i4) {
        this.f3258a = new byte[i4];
        this.f3259b = 0;
        this.f3260c = -1;
    }

    private void a(long j4, int i4) {
        long j5 = 1 << i4;
        if (j4 < 0 || j4 > j5) {
            cn.jiguang.bq.d.i("Outputer", j4 + " out of range for " + i4 + " bit value max:" + j5);
        }
    }

    private void c(int i4) {
        byte[] bArr = this.f3258a;
        int length = bArr.length;
        int i5 = this.f3259b;
        if (length - i5 >= i4) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i5 + i4) {
            length2 = i5 + i4;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        this.f3258a = bArr2;
    }

    public int a() {
        return this.f3259b;
    }

    public void a(int i4) {
        a(i4, 8);
        c(1);
        byte[] bArr = this.f3258a;
        int i5 = this.f3259b;
        this.f3259b = i5 + 1;
        bArr[i5] = (byte) (i4 & 255);
    }

    public void a(int i4, int i5) {
        a(i4, 8);
        if (i5 > this.f3259b - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.f3258a[i5] = (byte) (i4 & 255);
    }

    public void a(long j4) {
        a(j4, 32);
        c(4);
        byte[] bArr = this.f3258a;
        int i4 = this.f3259b;
        int i5 = i4 + 1;
        this.f3259b = i5;
        bArr[i4] = (byte) ((j4 >>> 24) & 255);
        int i6 = i5 + 1;
        this.f3259b = i6;
        bArr[i5] = (byte) ((j4 >>> 16) & 255);
        int i7 = i6 + 1;
        this.f3259b = i7;
        bArr[i6] = (byte) ((j4 >>> 8) & 255);
        this.f3259b = i7 + 1;
        bArr[i7] = (byte) (j4 & 255);
    }

    public void a(String str) {
        byte[] i4 = g.i(str);
        b(i4.length);
        a(i4, 0, i4.length);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i4, int i5) {
        c(i5);
        System.arraycopy(bArr, i4, this.f3258a, this.f3259b, i5);
        this.f3259b += i5;
    }

    public void b(int i4) {
        a(i4, 16);
        c(2);
        byte[] bArr = this.f3258a;
        int i5 = this.f3259b;
        int i6 = i5 + 1;
        this.f3259b = i6;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        this.f3259b = i6 + 1;
        bArr[i6] = (byte) (i4 & 255);
    }

    public void b(int i4, int i5) {
        a(i4, 16);
        if (i5 > this.f3259b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f3258a;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
    }

    public void b(long j4) {
        c(8);
        byte[] bArr = this.f3258a;
        int i4 = this.f3259b;
        int i5 = i4 + 1;
        this.f3259b = i5;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        int i6 = i5 + 1;
        this.f3259b = i6;
        bArr[i5] = (byte) ((j4 >>> 48) & 255);
        int i7 = i6 + 1;
        this.f3259b = i7;
        bArr[i6] = (byte) ((j4 >>> 40) & 255);
        int i8 = i7 + 1;
        this.f3259b = i8;
        bArr[i7] = (byte) ((j4 >>> 32) & 255);
        int i9 = i8 + 1;
        this.f3259b = i9;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i9 + 1;
        this.f3259b = i10;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i10 + 1;
        this.f3259b = i11;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        this.f3259b = i11 + 1;
        bArr[i11] = (byte) (j4 & 255);
    }

    public byte[] b() {
        int i4 = this.f3259b;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f3258a, 0, bArr, 0, i4);
        return bArr;
    }
}
