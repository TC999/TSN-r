package com.bytedance.sdk.component.xv.c;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ia extends f {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f30686f;

    /* renamed from: r  reason: collision with root package name */
    final transient int[] f30687r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ia(xv xvVar, int i4) {
        super(null);
        i.c(xvVar.f30701w, 0L, i4);
        ys ysVar = xvVar.f30700c;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = ysVar.xv;
            int i9 = ysVar.f30706w;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                ysVar = ysVar.f30704f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f30686f = new byte[i7];
        this.f30687r = new int[i7 * 2];
        ys ysVar2 = xvVar.f30700c;
        int i10 = 0;
        while (i5 < i4) {
            byte[][] bArr = this.f30686f;
            bArr[i10] = ysVar2.f30703c;
            int i11 = ysVar2.xv;
            int i12 = ysVar2.f30706w;
            i5 += i11 - i12;
            if (i5 > i4) {
                i5 = i4;
            }
            int[] iArr = this.f30687r;
            iArr[i10] = i5;
            iArr[bArr.length + i10] = i12;
            ysVar2.sr = true;
            i10++;
            ysVar2 = ysVar2.f30704f;
        }
    }

    private f gd() {
        return new f(ev());
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public String c() {
        return gd().c();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.r() == r() && c(0, fVar, 0, r())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public byte[] ev() {
        int[] iArr = this.f30687r;
        byte[][] bArr = this.f30686f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = this.f30687r;
            int i6 = iArr2[length + i4];
            int i7 = iArr2[i4];
            System.arraycopy(this.f30686f[i4], i6, bArr2, i5, i7 - i5);
            i4++;
            i5 = i7;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public f f() {
        return gd().f();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public int hashCode() {
        int i4 = this.sr;
        if (i4 != 0) {
            return i4;
        }
        int length = this.f30686f.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < length) {
            byte[] bArr = this.f30686f[i5];
            int[] iArr = this.f30687r;
            int i8 = iArr[length + i5];
            int i9 = iArr[i5];
            int i10 = (i9 - i6) + i8;
            while (i8 < i10) {
                i7 = (i7 * 31) + bArr[i8];
                i8++;
            }
            i5++;
            i6 = i9;
        }
        this.sr = i7;
        return i7;
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public int r() {
        return this.f30687r[this.f30686f.length - 1];
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public f sr() {
        return gd().sr();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public String toString() {
        return gd().toString();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public String ux() {
        return gd().ux();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public String w() {
        return gd().w();
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public f xv() {
        return gd().xv();
    }

    private int w(int i4) {
        int binarySearch = Arrays.binarySearch(this.f30687r, 0, this.f30686f.length, i4 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public f c(int i4, int i5) {
        return gd().c(i4, i5);
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public byte c(int i4) {
        i.c(this.f30687r[this.f30686f.length - 1], i4, 1L);
        int w3 = w(i4);
        int i5 = w3 == 0 ? 0 : this.f30687r[w3 - 1];
        int[] iArr = this.f30687r;
        byte[][] bArr = this.f30686f;
        return bArr[w3][(i4 - i5) + iArr[bArr.length + w3]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.component.xv.c.f
    public void c(xv xvVar) {
        int length = this.f30686f.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr = this.f30687r;
            int i6 = iArr[length + i4];
            int i7 = iArr[i4];
            ys ysVar = new ys(this.f30686f[i4], i6, (i6 + i7) - i5, true, false);
            ys ysVar2 = xvVar.f30700c;
            if (ysVar2 == null) {
                ysVar.f30705r = ysVar;
                ysVar.f30704f = ysVar;
                xvVar.f30700c = ysVar;
            } else {
                ysVar2.f30705r.c(ysVar);
            }
            i4++;
            i5 = i7;
        }
        xvVar.f30701w += i5;
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public boolean c(int i4, f fVar, int i5, int i6) {
        if (i4 < 0 || i4 > r() - i6) {
            return false;
        }
        int w3 = w(i4);
        while (i6 > 0) {
            int i7 = w3 == 0 ? 0 : this.f30687r[w3 - 1];
            int min = Math.min(i6, ((this.f30687r[w3] - i7) + i7) - i4);
            int[] iArr = this.f30687r;
            byte[][] bArr = this.f30686f;
            if (!fVar.c(i5, bArr[w3], (i4 - i7) + iArr[bArr.length + w3], min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            w3++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.xv.c.f
    public boolean c(int i4, byte[] bArr, int i5, int i6) {
        if (i4 < 0 || i4 > r() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int w3 = w(i4);
        while (i6 > 0) {
            int i7 = w3 == 0 ? 0 : this.f30687r[w3 - 1];
            int min = Math.min(i6, ((this.f30687r[w3] - i7) + i7) - i4);
            int[] iArr = this.f30687r;
            byte[][] bArr2 = this.f30686f;
            if (!i.c(bArr2[w3], (i4 - i7) + iArr[bArr2.length + w3], bArr, i5, min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            w3++;
        }
        return true;
    }
}
