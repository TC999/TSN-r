package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentedByteString.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class q extends f {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f837f;

    /* renamed from: g  reason: collision with root package name */
    final transient int[] f838g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i4) {
        super(null);
        u.a(cVar.f798b, 0L, i4);
        o oVar = cVar.f797a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            int i8 = oVar.f830c;
            int i9 = oVar.f829b;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                oVar = oVar.f833f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f837f = new byte[i7];
        this.f838g = new int[i7 * 2];
        o oVar2 = cVar.f797a;
        int i10 = 0;
        while (i5 < i4) {
            byte[][] bArr = this.f837f;
            bArr[i10] = oVar2.f828a;
            int i11 = oVar2.f830c;
            int i12 = oVar2.f829b;
            i5 += i11 - i12;
            if (i5 > i4) {
                i5 = i4;
            }
            int[] iArr = this.f838g;
            iArr[i10] = i5;
            iArr[bArr.length + i10] = i12;
            oVar2.f831d = true;
            i10++;
            oVar2 = oVar2.f833f;
        }
    }

    private f i() {
        return new f(g());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String a() {
        return i().a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String b() {
        return i().b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f c() {
        return i().c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f d() {
        return i().d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int e() {
        return this.f838g[this.f837f.length - 1];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.e() == e() && a(0, fVar, 0, e())) {
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f f() {
        return i().f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte[] g() {
        int[] iArr = this.f838g;
        byte[][] bArr = this.f837f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = this.f838g;
            int i6 = iArr2[length + i4];
            int i7 = iArr2[i4];
            System.arraycopy(this.f837f[i4], i6, bArr2, i5, i7 - i5);
            i4++;
            i5 = i7;
        }
        return bArr2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String h() {
        return i().h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int hashCode() {
        int i4 = this.f802b;
        if (i4 != 0) {
            return i4;
        }
        int length = this.f837f.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < length) {
            byte[] bArr = this.f837f[i5];
            int[] iArr = this.f838g;
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
        this.f802b = i7;
        return i7;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String toString() {
        return i().toString();
    }

    private int b(int i4) {
        int binarySearch = Arrays.binarySearch(this.f838g, 0, this.f837f.length, i4 + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f a(int i4, int i5) {
        return i().a(i4, i5);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte a(int i4) {
        u.a(this.f838g[this.f837f.length - 1], i4, 1L);
        int b4 = b(i4);
        int i5 = b4 == 0 ? 0 : this.f838g[b4 - 1];
        int[] iArr = this.f838g;
        byte[][] bArr = this.f837f;
        return bArr[b4][(i4 - i5) + iArr[bArr.length + b4]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public void a(c cVar) {
        int length = this.f837f.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr = this.f838g;
            int i6 = iArr[length + i4];
            int i7 = iArr[i4];
            o oVar = new o(this.f837f[i4], i6, (i6 + i7) - i5, true, false);
            o oVar2 = cVar.f797a;
            if (oVar2 == null) {
                oVar.f834g = oVar;
                oVar.f833f = oVar;
                cVar.f797a = oVar;
            } else {
                oVar2.f834g.a(oVar);
            }
            i4++;
            i5 = i7;
        }
        cVar.f798b += i5;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i4, f fVar, int i5, int i6) {
        if (i4 < 0 || i4 > e() - i6) {
            return false;
        }
        int b4 = b(i4);
        while (i6 > 0) {
            int i7 = b4 == 0 ? 0 : this.f838g[b4 - 1];
            int min = Math.min(i6, ((this.f838g[b4] - i7) + i7) - i4);
            int[] iArr = this.f838g;
            byte[][] bArr = this.f837f;
            if (!fVar.a(i5, bArr[b4], (i4 - i7) + iArr[bArr.length + b4], min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            b4++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i4, byte[] bArr, int i5, int i6) {
        if (i4 < 0 || i4 > e() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int b4 = b(i4);
        while (i6 > 0) {
            int i7 = b4 == 0 ? 0 : this.f838g[b4 - 1];
            int min = Math.min(i6, ((this.f838g[b4] - i7) + i7) - i4);
            int[] iArr = this.f838g;
            byte[][] bArr2 = this.f837f;
            if (!u.a(bArr2[b4], (i4 - i7) + iArr[bArr2.length + b4], bArr, i5, min)) {
                return false;
            }
            i4 += min;
            i5 += min;
            i6 -= min;
            b4++;
        }
        return true;
    }
}
