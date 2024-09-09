package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv implements w {

    /* renamed from: c  reason: collision with root package name */
    protected boolean f32598c;

    /* renamed from: f  reason: collision with root package name */
    protected int f32599f = 0;
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.ux sr;
    protected TTBaseVideoActivity ux;

    /* renamed from: w  reason: collision with root package name */
    protected me f32600w;
    protected com.bytedance.sdk.openadsdk.core.component.reward.w.w xv;

    public xv(TTBaseVideoActivity tTBaseVideoActivity, me meVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, boolean z3) {
        this.ux = tTBaseVideoActivity;
        this.f32600w = meVar;
        this.xv = wVar;
        this.sr = uxVar;
        this.f32598c = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void c(View view) {
        c(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void f(View view) {
        c(6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void sr(View view) {
        c(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void ux(View view) {
        c(5);
        this.ux.gd(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void w(View view) {
        c(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void xv(View view) {
        c(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        if (fp.k(this.f32600w)) {
            return false;
        }
        int i4 = this.f32599f;
        this.f32599f = i4 + 1;
        if (i4 >= m.w()) {
            a.c().c(this.f32600w, "stats_reward_full_close_force", this.ux.bm().c(new JSONObject()));
            this.ux.finish();
            return true;
        }
        return false;
    }

    protected void c(int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i4);
        } catch (Throwable unused) {
        }
        a.c().c(this.f32600w, "stats_reward_full_top_handle", jSONObject);
    }
}
