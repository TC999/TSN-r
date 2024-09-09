package com.bytedance.sdk.openadsdk.core.q;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements fp<Bitmap> {

    /* renamed from: c  reason: collision with root package name */
    private boolean f34507c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.fz.c.xv f34508w;

    public xv(boolean z3) {
        this.f34507c = z3;
        if (z3) {
            this.f34508w = com.bytedance.sdk.openadsdk.core.fz.c.xv.w();
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.xv(str);
    }

    public void sr(String str) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.ev(str);
    }

    public void w(String str) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.f(str);
    }

    public void xv(String str) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.sr(str);
    }

    public void c(int i4) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.c(i4);
    }

    @Override // com.bytedance.sdk.component.ux.fp
    @ATSMethod(1)
    public void c(k<Bitmap> kVar) {
        if (!this.f34507c || this.f34508w == null) {
            return;
        }
        if (kVar == null || kVar.xv() == null) {
            this.f34508w.w(202).r(p.c(202));
            a.c().c(this.f34508w);
        }
    }

    @Override // com.bytedance.sdk.component.ux.fp
    @ATSMethod(2)
    public void c(int i4, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.fz.c.xv xvVar;
        if (!this.f34507c || (xvVar = this.f34508w) == null) {
            return;
        }
        xvVar.w(201).r(p.c(201));
        a.c().c(this.f34508w);
    }
}
