package com.bytedance.sdk.component.w.c.w;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev extends sr {
    final transient int[] ev;

    /* renamed from: r  reason: collision with root package name */
    final transient byte[][] f30438r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(c cVar, int i4) {
        super(null);
        p.c(cVar.f30437w, 0L, i4);
        f fVar = cVar.f30436c;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = fVar.xv;
            int i9 = fVar.f30442w;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                fVar = fVar.f30440f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f30438r = new byte[i7];
        this.ev = new int[i7 * 2];
        f fVar2 = cVar.f30436c;
        int i10 = 0;
        while (i5 < i4) {
            byte[][] bArr = this.f30438r;
            bArr[i10] = fVar2.f30439c;
            int i11 = fVar2.xv;
            int i12 = fVar2.f30442w;
            i5 += i11 - i12;
            if (i5 > i4) {
                i5 = i4;
            }
            int[] iArr = this.ev;
            iArr[i10] = i5;
            iArr[bArr.length + i10] = i12;
            fVar2.sr = true;
            i10++;
            fVar2 = fVar2.f30440f;
        }
    }

    private sr ux() {
        return new sr(sr());
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public String c() {
        return ux().c();
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sr) {
            sr srVar = (sr) obj;
            if (srVar.xv() == xv() && c(0, srVar, 0, xv())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public int hashCode() {
        int i4 = this.ux;
        if (i4 != 0) {
            return i4;
        }
        int length = this.f30438r.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < length) {
            byte[] bArr = this.f30438r[i5];
            int[] iArr = this.ev;
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
        this.ux = i7;
        return i7;
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public byte[] sr() {
        int[] iArr = this.ev;
        byte[][] bArr = this.f30438r;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = this.ev;
            int i6 = iArr2[length + i4];
            int i7 = iArr2[i4];
            System.arraycopy(this.f30438r[i4], i6, bArr2, i5, i7 - i5);
            i4++;
            i5 = i7;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public String toString() {
        return ux().toString();
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public String w() {
        return ux().w();
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public int xv() {
        return this.ev[this.f30438r.length - 1];
    }

    private int w(int i4) {
        int binarySearch = Arrays.binarySearch(this.ev, 0, this.f30438r.length, i4 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public sr c(int i4, int i5) {
        return ux().c(i4, i5);
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public byte c(int i4) {
        p.c(this.ev[this.f30438r.length - 1], i4, 1L);
        int w3 = w(i4);
        int i5 = w3 == 0 ? 0 : this.ev[w3 - 1];
        int[] iArr = this.ev;
        byte[][] bArr = this.f30438r;
        return bArr[w3][(i4 - i5) + iArr[bArr.length + w3]];
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public boolean c(int i4, sr srVar, int i5, int i6) {
        if (i4 < 0 || i4 > xv() - i6) {
            return false;
        }
        int w3 = w(i4);
        while (i6 > 0) {
            int i7 = w3 == 0 ? 0 : this.ev[w3 - 1];
            int min = Math.min(i6, ((this.ev[w3] - i7) + i7) - i4);
            int[] iArr = this.ev;
            byte[][] bArr = this.f30438r;
            if (!srVar.c(i5, bArr[w3], (i4 - i7) + iArr[bArr.length + w3], min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            w3++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.w.c.w.sr
    public boolean c(int i4, byte[] bArr, int i5, int i6) {
        if (i4 < 0 || i4 > xv() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int w3 = w(i4);
        while (i6 > 0) {
            int i7 = w3 == 0 ? 0 : this.ev[w3 - 1];
            int min = Math.min(i6, ((this.ev[w3] - i7) + i7) - i4);
            int[] iArr = this.ev;
            byte[][] bArr2 = this.f30438r;
            if (!p.c(bArr2[w3], (i4 - i7) + iArr[bArr2.length + w3], bArr, i5, min)) {
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
