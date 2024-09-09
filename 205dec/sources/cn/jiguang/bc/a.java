package cn.jiguang.bc;

import java.math.BigInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger f2563d = BigInteger.ONE.shiftLeft(64);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f2564a;

    /* renamed from: b  reason: collision with root package name */
    private int f2565b;

    /* renamed from: c  reason: collision with root package name */
    private int f2566c;

    public a() {
        this(32);
    }

    public a(int i4) {
        this.f2564a = new byte[i4];
        this.f2565b = 0;
        this.f2566c = -1;
    }

    private void a(long j4, int i4) {
        long j5 = 1 << i4;
        if (j4 < 0 || j4 > j5) {
            cn.jiguang.w.a.f("JCommonPackager", j4 + " out of range for " + i4 + " bit value max:" + j5);
        }
    }

    private void b(int i4) {
        byte[] bArr = this.f2564a;
        int length = bArr.length;
        int i5 = this.f2565b;
        if (length - i5 >= i4) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i5 + i4) {
            length2 = i5 + i4;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        this.f2564a = bArr2;
    }

    public void a(int i4) {
        a(i4, 16);
        b(2);
        byte[] bArr = this.f2564a;
        int i5 = this.f2565b;
        int i6 = i5 + 1;
        this.f2565b = i6;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        this.f2565b = i6 + 1;
        bArr[i6] = (byte) (i4 & 255);
    }

    public void a(long j4) {
        b(8);
        byte[] bArr = this.f2564a;
        int i4 = this.f2565b;
        int i5 = i4 + 1;
        this.f2565b = i5;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        int i6 = i5 + 1;
        this.f2565b = i6;
        bArr[i5] = (byte) ((j4 >>> 48) & 255);
        int i7 = i6 + 1;
        this.f2565b = i7;
        bArr[i6] = (byte) ((j4 >>> 40) & 255);
        int i8 = i7 + 1;
        this.f2565b = i8;
        bArr[i7] = (byte) ((j4 >>> 32) & 255);
        int i9 = i8 + 1;
        this.f2565b = i9;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i9 + 1;
        this.f2565b = i10;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i10 + 1;
        this.f2565b = i11;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        this.f2565b = i11 + 1;
        bArr[i11] = (byte) (j4 & 255);
    }

    public void a(byte[] bArr) {
        a(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i4, int i5) {
        b(i5);
        System.arraycopy(bArr, i4, this.f2564a, this.f2565b, i5);
        this.f2565b += i5;
    }

    public byte[] a() {
        int i4 = this.f2565b;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f2564a, 0, bArr, 0, i4);
        return bArr;
    }
}
