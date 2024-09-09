package com.bytedance.sdk.openadsdk.core.component.splash.w.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.oo;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.c f33039a;
    private boolean bk;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f33040f;
    private com.bykv.vk.openvk.component.video.api.xv.xv gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f33041k;

    /* renamed from: p  reason: collision with root package name */
    private int f33042p;

    /* renamed from: r  reason: collision with root package name */
    private int f33043r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f33044t;
    private com.bytedance.sdk.openadsdk.a.w ux;

    public w(me meVar, boolean z3) {
        if (meVar == null) {
            return;
        }
        this.f33001w = meVar;
        this.f33044t = z3;
        this.bk = meVar.y() == 2;
        w(meVar);
    }

    private boolean c(me.c cVar) {
        return cVar != null && c(cVar.ev()) == 2;
    }

    private void f(me meVar) {
        this.gd = ng.bk(meVar);
        this.f33042p = wv.gd(meVar);
        this.f33041k = meVar.ps();
    }

    private void ux(me meVar) {
        gb gbVar;
        if (meVar.nc() == null || (gbVar = meVar.nc().get(0)) == null) {
            return;
        }
        String c4 = gbVar.c();
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        this.ev = oo.a(meVar);
        this.f33040f = gbVar.w();
        this.f33043r = gbVar.xv();
        this.ux = new com.bytedance.sdk.openadsdk.a.w(c4, gbVar.r());
    }

    private void w(me meVar) {
        int b4 = meVar.b();
        me.c rh = meVar.rh();
        if (TextUtils.isEmpty(ng.c(meVar))) {
            this.sr = 1;
        } else if (xv(meVar)) {
            if (c(rh)) {
                this.sr = 2;
            } else {
                if (w(rh)) {
                    meVar.ev(1);
                }
                this.sr = 1;
            }
        } else if (b4 == 1) {
            this.sr = 1;
        } else {
            this.sr = 2;
        }
        sr(meVar);
    }

    private boolean xv(me meVar) {
        return meVar.y() == 2;
    }

    public String a() {
        return this.ev;
    }

    public com.bytedance.sdk.openadsdk.core.u.c bk() {
        return this.f33039a;
    }

    public com.bykv.vk.openvk.component.video.api.xv.xv ev() {
        return this.gd;
    }

    public int gd() {
        return this.f33042p;
    }

    public int k() {
        return this.sr;
    }

    public boolean p() {
        return this.f33041k;
    }

    public int r() {
        return this.f33043r;
    }

    public boolean sr() {
        return this.sr == 2;
    }

    public boolean t() {
        return this.bk;
    }

    public boolean ys() {
        return this.f33044t;
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private void sr(me meVar) {
        ux(meVar);
        f(meVar);
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.c cVar) {
        this.f33039a = cVar;
    }

    public int f() {
        return this.f33040f;
    }

    public void c(boolean z3) {
        this.f33044t = z3;
    }

    public com.bytedance.sdk.openadsdk.a.w ux() {
        return this.ux;
    }

    private boolean w(me.c cVar) {
        return cVar != null && c(cVar.ev()) == 0;
    }
}
