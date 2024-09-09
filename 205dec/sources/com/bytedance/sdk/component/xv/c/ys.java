package com.bytedance.sdk.component.xv.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ys {

    /* renamed from: c  reason: collision with root package name */
    final byte[] f30703c;

    /* renamed from: f  reason: collision with root package name */
    ys f30704f;

    /* renamed from: r  reason: collision with root package name */
    ys f30705r;
    boolean sr;
    boolean ux;

    /* renamed from: w  reason: collision with root package name */
    int f30706w;
    int xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ys() {
        this.f30703c = new byte[8192];
        this.ux = true;
        this.sr = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ys c() {
        this.sr = true;
        return new ys(this.f30703c, this.f30706w, this.xv, true, false);
    }

    public final ys w() {
        ys ysVar = this.f30704f;
        ys ysVar2 = ysVar != this ? ysVar : null;
        ys ysVar3 = this.f30705r;
        if (ysVar3 != null) {
            ysVar3.f30704f = ysVar;
        }
        ys ysVar4 = this.f30704f;
        if (ysVar4 != null) {
            ysVar4.f30705r = ysVar3;
        }
        this.f30704f = null;
        this.f30705r = null;
        return ysVar2;
    }

    public final void xv() {
        ys ysVar = this.f30705r;
        if (ysVar != this) {
            if (ysVar.ux) {
                int i4 = this.xv - this.f30706w;
                if (i4 > (8192 - ysVar.xv) + (ysVar.sr ? 0 : ysVar.f30706w)) {
                    return;
                }
                c(ysVar, i4);
                w();
                fp.c(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final ys c(ys ysVar) {
        ysVar.f30705r = this;
        ysVar.f30704f = this.f30704f;
        this.f30704f.f30705r = ysVar;
        this.f30704f = ysVar;
        return ysVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ys(byte[] bArr, int i4, int i5, boolean z3, boolean z4) {
        this.f30703c = bArr;
        this.f30706w = i4;
        this.xv = i5;
        this.sr = z3;
        this.ux = z4;
    }

    public final ys c(int i4) {
        ys c4;
        if (i4 > 0 && i4 <= this.xv - this.f30706w) {
            if (i4 >= 1024) {
                c4 = c();
            } else {
                c4 = fp.c();
                System.arraycopy(this.f30703c, this.f30706w, c4.f30703c, 0, i4);
            }
            c4.xv = c4.f30706w + i4;
            this.f30706w += i4;
            this.f30705r.c(c4);
            return c4;
        }
        throw new IllegalArgumentException();
    }

    public final void c(ys ysVar, int i4) {
        if (ysVar.ux) {
            int i5 = ysVar.xv;
            if (i5 + i4 > 8192) {
                if (!ysVar.sr) {
                    int i6 = ysVar.f30706w;
                    if ((i5 + i4) - i6 <= 8192) {
                        byte[] bArr = ysVar.f30703c;
                        System.arraycopy(bArr, i6, bArr, 0, i5 - i6);
                        ysVar.xv -= ysVar.f30706w;
                        ysVar.f30706w = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f30703c, this.f30706w, ysVar.f30703c, ysVar.xv, i4);
            ysVar.xv += i4;
            this.f30706w += i4;
            return;
        }
        throw new IllegalArgumentException();
    }
}
