package com.bytedance.sdk.openadsdk.core.component.reward.c.w.c;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends com.bytedance.sdk.openadsdk.core.component.reward.xv.w {

    /* renamed from: c  reason: collision with root package name */
    protected String f32243c;

    public c(Activity activity, me meVar) {
        super(activity, meVar);
    }

    public void c(String str) {
        this.f32243c = str;
    }

    public c(Activity activity, me meVar, ox oxVar) {
        super(activity, meVar, oxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.w
    public w.c c(p pVar) {
        sr srVar = new sr(this.f32778r, this.f32775f);
        srVar.sr(this.f32777p);
        srVar.xv(this.f32776k);
        srVar.w(this.f32779t);
        srVar.c(this.f32243c);
        return srVar.c(pVar);
    }
}
