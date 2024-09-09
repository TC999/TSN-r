package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.core.w.c {

    /* renamed from: a  reason: collision with root package name */
    protected int f34204a;
    protected int bk;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.u f34205c;

    /* renamed from: k  reason: collision with root package name */
    protected int f34206k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f34207p;

    public ux(Context context, me meVar, String str, int i4) {
        super(context, meVar, str, i4);
        this.f34206k = 0;
        this.f34204a = -1;
        this.bk = -1;
        this.f34207p = true;
        ((com.bytedance.sdk.openadsdk.core.w.c.w.r) c(com.bytedance.sdk.openadsdk.core.w.c.w.r.class)).c(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
    public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
        com.bytedance.sdk.openadsdk.core.w.c.xv.c cVar = (com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class);
        cVar.c(c(cVar.xv()));
        super.c(view, gdVar);
    }

    public void sr() {
        this.bk = 1;
        this.f34207p = false;
    }

    public void xv() {
        this.f34204a = 1;
        this.f34207p = false;
    }

    public void sr(int i4) {
        this.f34206k = i4;
    }

    protected com.bytedance.sdk.openadsdk.core.u.ev c(String str) {
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        int i6;
        int i7;
        View f4 = this.f35366r.f();
        int[] c4 = xk.c(f4);
        if (c4 == null || c4.length != 2) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = c4[0];
            i5 = c4[1];
            if (this.f34206k == 0 && this.f34207p) {
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
        int[] iArr = {-1, -1};
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.u.u uVar = this.f34205c;
        String str5 = "";
        if (uVar == null || !this.f34207p) {
            str2 = str;
            str3 = "";
            str4 = str3;
        } else {
            this.f35366r.c(uVar.ux);
            this.f35366r.w(this.f34205c.f34828f);
            if (this.f34206k == 0) {
                iArr[0] = ((int) xk.xv(this.f35365f, this.f34205c.f34831r)) + i4;
                iArr[1] = ((int) xk.xv(this.f35365f, this.f34205c.ev)) + i5;
                i7 = (int) xk.xv(this.f35365f, this.f34205c.gd);
                i6 = (int) xk.xv(this.f35365f, this.f34205c.f34830p);
            } else {
                com.bytedance.sdk.openadsdk.core.u.u uVar2 = this.f34205c;
                iArr[0] = uVar2.f34831r;
                iArr[1] = uVar2.ev;
                int i8 = uVar2.gd;
                i6 = uVar2.f34830p;
                i7 = i8;
            }
            str2 = TextUtils.isEmpty(str) ? this.f34205c.f34829k : str;
            com.bytedance.sdk.openadsdk.core.u.u uVar3 = this.f34205c;
            str4 = uVar3.f34826a;
            String str6 = uVar3.bk;
            String str7 = uVar3.f34833t;
            iArr2[0] = i7;
            iArr2[1] = i6;
            View ux = this.f35366r.ux();
            if (i7 == 0 && i6 == 0 && ux != null) {
                iArr = xk.c(ux);
                iArr2 = xk.xv(ux);
            }
            str3 = str7;
            str5 = str6;
        }
        this.f34206k = 0;
        return new ev.c().f(this.f35366r.bk()).ux(this.f35366r.t()).sr(this.f35366r.ys()).xv(this.f35366r.fp()).w(this.f35366r.k()).c(this.f35366r.a()).w(c4).c(iArr).xv(xk.xv(f4)).sr(iArr2).xv(this.f35366r.c()).sr(this.f35366r.w()).ux(this.f35366r.xv()).w(com.bytedance.sdk.openadsdk.core.k.sr().w() ? 1 : 2).c(this.f35366r.gd()).c(str2).w(str5).xv(str4).sr(str3).c(xk.f(this.f35365f)).c(xk.ev(this.f35365f)).f(this.f34204a).r(this.bk).w(xk.r(this.f35365f)).ux(this.f35366r.ia()).ev(this.f35366r.s()).c();
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.u uVar) {
        this.f34205c = uVar;
    }
}
