package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f828a;

    /* renamed from: b  reason: collision with root package name */
    int f829b;

    /* renamed from: c  reason: collision with root package name */
    int f830c;

    /* renamed from: d  reason: collision with root package name */
    boolean f831d;

    /* renamed from: e  reason: collision with root package name */
    boolean f832e;

    /* renamed from: f  reason: collision with root package name */
    o f833f;

    /* renamed from: g  reason: collision with root package name */
    o f834g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f828a = new byte[8192];
        this.f832e = true;
        this.f831d = false;
    }

    public final o a(o oVar) {
        oVar.f834g = this;
        oVar.f833f = this.f833f;
        this.f833f.f834g = oVar;
        this.f833f = oVar;
        return oVar;
    }

    public final o b() {
        o oVar = this.f833f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f834g;
        oVar3.f833f = oVar;
        this.f833f.f834g = oVar3;
        this.f833f = null;
        this.f834g = null;
        return oVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o c() {
        this.f831d = true;
        return new o(this.f828a, this.f829b, this.f830c, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i4, int i5, boolean z3, boolean z4) {
        this.f828a = bArr;
        this.f829b = i4;
        this.f830c = i5;
        this.f831d = z3;
        this.f832e = z4;
    }

    public final o a(int i4) {
        o a4;
        if (i4 > 0 && i4 <= this.f830c - this.f829b) {
            if (i4 >= 1024) {
                a4 = c();
            } else {
                a4 = p.a();
                System.arraycopy(this.f828a, this.f829b, a4.f828a, 0, i4);
            }
            a4.f830c = a4.f829b + i4;
            this.f829b += i4;
            this.f834g.a(a4);
            return a4;
        }
        throw new IllegalArgumentException();
    }

    public final void a() {
        o oVar = this.f834g;
        if (oVar != this) {
            if (oVar.f832e) {
                int i4 = this.f830c - this.f829b;
                if (i4 > (8192 - oVar.f830c) + (oVar.f831d ? 0 : oVar.f829b)) {
                    return;
                }
                a(oVar, i4);
                b();
                p.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void a(o oVar, int i4) {
        if (oVar.f832e) {
            int i5 = oVar.f830c;
            int i6 = i5 + i4;
            if (i6 > 8192) {
                if (!oVar.f831d) {
                    int i7 = oVar.f829b;
                    if (i6 - i7 <= 8192) {
                        byte[] bArr = oVar.f828a;
                        System.arraycopy(bArr, i7, bArr, 0, i5 - i7);
                        oVar.f830c -= oVar.f829b;
                        oVar.f829b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f828a, this.f829b, oVar.f828a, oVar.f830c, i4);
            oVar.f830c += i4;
            this.f829b += i4;
            return;
        }
        throw new IllegalArgumentException();
    }
}
