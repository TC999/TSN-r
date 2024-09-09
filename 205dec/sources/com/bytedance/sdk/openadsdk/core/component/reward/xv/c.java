package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends w {

    /* renamed from: c  reason: collision with root package name */
    protected int f32765c;
    protected boolean sr;
    protected boolean ux;

    /* renamed from: w  reason: collision with root package name */
    protected int f32766w;
    protected boolean xv;

    public c(Activity activity, me meVar) {
        super(activity, meVar);
    }

    public void c(int i4) {
        this.f32765c = i4;
    }

    public void w(int i4) {
        this.f32766w = i4;
    }

    public void xv(boolean z3) {
        this.ux = z3;
    }

    public c(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    public void c(boolean z3) {
        this.xv = z3;
    }

    public void w(boolean z3) {
        this.sr = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c w(p pVar) {
        bk bkVar = new bk(this.f32778r, this.f32775f);
        bkVar.w(this.sr);
        bkVar.c(this.xv);
        bkVar.c(this.f32765c);
        bkVar.w(this.f32766w);
        bkVar.sr(this.f32777p);
        bkVar.xv(this.f32776k);
        bkVar.c(this.ys);
        bkVar.w(this.f32779t);
        bkVar.xv(this.ux);
        return bkVar.w(pVar);
    }
}
