package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.ba;
import com.bytedance.sdk.component.xv.w.fp;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.u;
import java.io.IOException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r implements u.c {

    /* renamed from: a  reason: collision with root package name */
    private int f30957a;

    /* renamed from: c  reason: collision with root package name */
    private final List<u> f30958c;
    private final fp ev;

    /* renamed from: f  reason: collision with root package name */
    private final n f30959f;
    private final int gd;

    /* renamed from: k  reason: collision with root package name */
    private final int f30960k;

    /* renamed from: p  reason: collision with root package name */
    private final int f30961p;

    /* renamed from: r  reason: collision with root package name */
    private final com.bytedance.sdk.component.xv.w.ux f30962r;
    private final com.bytedance.sdk.component.xv.w.c.w.xv sr;
    private final int ux;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.sdk.component.xv.w.c.w.r f30963w;
    private final xv xv;

    public r(List<u> list, com.bytedance.sdk.component.xv.w.c.w.r rVar, xv xvVar, com.bytedance.sdk.component.xv.w.c.w.xv xvVar2, int i4, n nVar, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar, int i5, int i6, int i7) {
        this.f30958c = list;
        this.sr = xvVar2;
        this.f30963w = rVar;
        this.xv = xvVar;
        this.ux = i4;
        this.f30959f = nVar;
        this.f30962r = uxVar;
        this.ev = fpVar;
        this.gd = i5;
        this.f30961p = i6;
        this.f30960k = i7;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public n c() {
        return this.f30959f;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public com.bytedance.sdk.component.xv.w.ux call() {
        return this.f30962r;
    }

    public fp ev() {
        return this.ev;
    }

    public com.bytedance.sdk.component.xv.w.c.w.r f() {
        return this.f30963w;
    }

    public xv r() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public int sr() {
        return this.f30960k;
    }

    public com.bytedance.sdk.component.xv.w.gd ux() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public int w() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public int xv() {
        return this.f30961p;
    }

    @Override // com.bytedance.sdk.component.xv.w.u.c
    public ba c(n nVar) throws IOException {
        return c(nVar, this.f30963w, this.xv, this.sr);
    }

    public ba c(n nVar, com.bytedance.sdk.component.xv.w.c.w.r rVar, xv xvVar, com.bytedance.sdk.component.xv.w.c.w.xv xvVar2) throws IOException {
        if (this.ux < this.f30958c.size()) {
            this.f30957a++;
            if (this.xv != null && !this.sr.c(nVar.c())) {
                throw new IllegalStateException("network interceptor " + this.f30958c.get(this.ux - 1) + " must retain the same host and port");
            } else if (this.xv != null && this.f30957a > 1) {
                throw new IllegalStateException("network interceptor " + this.f30958c.get(this.ux - 1) + " must call proceed() exactly once");
            } else {
                r rVar2 = new r(this.f30958c, rVar, xvVar, xvVar2, this.ux + 1, nVar, this.f30962r, this.ev, this.gd, this.f30961p, this.f30960k);
                u uVar = this.f30958c.get(this.ux);
                try {
                    ba c4 = uVar.c(rVar2);
                    if (xvVar != null && this.ux + 1 < this.f30958c.size() && rVar2.f30957a != 1) {
                        throw new IllegalStateException("network interceptor " + uVar + " must call proceed() exactly once");
                    } else if (c4 != null) {
                        if (c4.ev() != null) {
                            return c4;
                        }
                        throw new IllegalStateException("interceptor " + uVar + " returned a response with no body");
                    } else {
                        throw new NullPointerException("interceptor " + uVar + " returned a null response");
                    }
                } catch (Exception e4) {
                    throw e4;
                }
            }
        }
        throw new AssertionError();
    }
}
