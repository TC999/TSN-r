package cn.jiguang.bw;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3022a;

    /* renamed from: b  reason: collision with root package name */
    private int f3023b;

    /* renamed from: c  reason: collision with root package name */
    private int f3024c;

    public c() {
        this(32);
    }

    public c(int i4) {
        this.f3022a = new byte[i4];
        this.f3023b = 0;
        this.f3024c = -1;
    }

    private void a(long j4, int i4) {
        long j5 = 1 << i4;
        if (j4 < 0 || j4 > j5) {
            throw new IllegalArgumentException(j4 + " out of range for " + i4 + " bit value");
        }
    }

    private void d(int i4) {
        byte[] bArr = this.f3022a;
        int length = bArr.length;
        int i5 = this.f3023b;
        if (length - i5 >= i4) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i5 + i4) {
            length2 = i5 + i4;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        this.f3022a = bArr2;
    }

    public int a() {
        return this.f3023b;
    }

    public void a(int i4) {
        if (i4 > this.f3023b) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.f3023b = i4;
    }

    public void a(int i4, int i5) {
        a(i4, 16);
        if (i5 > this.f3023b - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.f3022a;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
    }

    public void a(long j4) {
        a(j4, 32);
        d(4);
        byte[] bArr = this.f3022a;
        int i4 = this.f3023b;
        int i5 = i4 + 1;
        this.f3023b = i5;
        bArr[i4] = (byte) ((j4 >>> 24) & 255);
        int i6 = i5 + 1;
        this.f3023b = i6;
        bArr[i5] = (byte) ((j4 >>> 16) & 255);
        int i7 = i6 + 1;
        this.f3023b = i7;
        bArr[i6] = (byte) ((j4 >>> 8) & 255);
        this.f3023b = i7 + 1;
        bArr[i7] = (byte) (j4 & 255);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i4, int i5) {
        d(i5);
        System.arraycopy(bArr, i4, this.f3022a, this.f3023b, i5);
        this.f3023b += i5;
    }

    public void b(int i4) {
        a(i4, 8);
        d(1);
        byte[] bArr = this.f3022a;
        int i5 = this.f3023b;
        this.f3023b = i5 + 1;
        bArr[i5] = (byte) (i4 & 255);
    }

    public byte[] b() {
        int i4 = this.f3023b;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f3022a, 0, bArr, 0, i4);
        return bArr;
    }

    public void c(int i4) {
        a(i4, 16);
        d(2);
        byte[] bArr = this.f3022a;
        int i5 = this.f3023b;
        int i6 = i5 + 1;
        this.f3023b = i6;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        this.f3023b = i6 + 1;
        bArr[i6] = (byte) (i4 & 255);
    }
}
