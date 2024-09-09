package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.openadsdk.core.w.w {

    /* renamed from: a  reason: collision with root package name */
    protected int f34054a;
    protected int bk;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.u f34055c;

    /* renamed from: k  reason: collision with root package name */
    protected int f34056k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f34057p;

    public f(Context context, me meVar, String str, int i4) {
        super(context, meVar, str, i4);
        this.f34056k = 0;
        this.f34054a = -1;
        this.bk = -1;
        this.f34057p = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
    public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
        com.bytedance.sdk.openadsdk.core.w.c.xv.c cVar = (com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class);
        cVar.c(c(cVar.xv()));
        super.c(view, gdVar);
    }

    public void sr(int i4) {
        this.f34056k = i4;
    }

    public void xv() {
        this.f34054a = 1;
        this.f34057p = false;
    }

    public void sr() {
        this.bk = 1;
        this.f34057p = false;
    }

    private com.bytedance.sdk.openadsdk.core.u.ev c(String str) {
        int i4;
        int i5;
        char c4;
        int i6;
        int i7;
        View f4 = this.f35366r.f();
        int[] c5 = xk.c(f4);
        if (c5 == null || c5.length != 2) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = c5[0];
            i5 = c5[1];
            if (this.f34056k == 0 && this.f34057p) {
                com.bytedance.sdk.openadsdk.core.u.gd gdVar = this.f35366r;
                float f5 = i4;
                gdVar.c((xk.xv(this.f35365f, gdVar.bk()) + f5) - 0.5f);
                com.bytedance.sdk.openadsdk.core.u.gd gdVar2 = this.f35366r;
                float f6 = i5;
                gdVar2.w((xk.xv(this.f35365f, gdVar2.t()) + f6) - 0.5f);
                com.bytedance.sdk.openadsdk.core.u.gd gdVar3 = this.f35366r;
                gdVar3.xv((xk.xv(this.f35365f, gdVar3.ys()) + f5) - 0.5f);
                com.bytedance.sdk.openadsdk.core.u.gd gdVar4 = this.f35366r;
                gdVar4.sr((xk.xv(this.f35365f, gdVar4.fp()) + f6) - 0.5f);
            }
        }
        float f7 = xk.f(this.f35365f);
        int ev = xk.ev(this.f35365f);
        float r3 = xk.r(this.f35365f);
        int[] iArr = {-1, -1};
        int[] iArr2 = {-1, -1};
        com.bytedance.sdk.openadsdk.core.u.u uVar = this.f34055c;
        if (uVar != null && this.f34057p) {
            this.f35366r.c(uVar.ux);
            this.f35366r.w(this.f34055c.f34828f);
            if (this.f34056k == 0) {
                iArr[0] = ((int) xk.xv(this.f35365f, this.f34055c.f34831r)) + i4;
                iArr[1] = ((int) xk.xv(this.f35365f, this.f34055c.ev)) + i5;
                i7 = (int) xk.xv(this.f35365f, this.f34055c.gd);
                i6 = (int) xk.xv(this.f35365f, this.f34055c.f34830p);
                c4 = 1;
            } else {
                com.bytedance.sdk.openadsdk.core.u.u uVar2 = this.f34055c;
                iArr[0] = uVar2.f34831r;
                c4 = 1;
                iArr[1] = uVar2.ev;
                int i8 = uVar2.gd;
                i6 = uVar2.f34830p;
                i7 = i8;
            }
            iArr2[0] = i7;
            iArr2[c4] = i6;
            View ux = this.f35366r.ux();
            if (i7 == 0 && i6 == 0 && ux != null) {
                iArr = xk.c(ux);
                iArr2 = xk.xv(ux);
            }
        }
        this.f34056k = 0;
        return new ev.c().f(this.f35366r.bk()).ux(this.f35366r.t()).sr(this.f35366r.ys()).xv(this.f35366r.fp()).w(this.f35366r.k()).c(this.f35366r.a()).w(c5).c(iArr).xv(xk.xv(f4)).sr(iArr2).xv(this.f35366r.c()).sr(this.f35366r.w()).ux(this.f35366r.xv()).w(com.bytedance.sdk.openadsdk.core.k.sr().w() ? 1 : 2).c(this.f35366r.gd()).c(str).c(f7).c(ev).f(this.f34054a).r(this.bk).w(r3).c();
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.u uVar) {
        this.f34055c = uVar;
    }
}
