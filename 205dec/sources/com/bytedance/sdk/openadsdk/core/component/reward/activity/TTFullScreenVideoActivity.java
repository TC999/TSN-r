package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.ev;
import com.bytedance.sdk.openadsdk.core.component.reward.sr;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.m;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean c(long j4, boolean z3) {
        a.w("TTFullScreenVideoActivity", "bindVideoAd execute");
        this.ls.c(this.wx);
        this.ls.c(this.ck.s(), this.f32151c, c());
        this.ls.c(a());
        if (this.ck.f()) {
            this.fz.c(this.ls.x());
        }
        this.ls.c(this.pr);
        return w(j4, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void up() {
        int me;
        String str;
        if (m.ia(this.ba) || this.f32159q.eq()) {
            return;
        }
        if (this.ls.yu()) {
            this.f32153i.c(false, null, "\u8df3\u8fc7", false, true);
            return;
        }
        String str2 = this.ck.f(false) + "s";
        boolean z3 = ((int) this.ls.me()) / 1000 >= this.yu;
        if (z3) {
            str = "\u8df3\u8fc7";
        } else if (ls.w().f(String.valueOf(this.f32166y))) {
            str = (this.yu - me) + "s\u540e\u53ef\u8df3\u8fc7";
        } else {
            str = null;
        }
        this.f32153i.c(false, str2, str, false, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void w() {
        if (this.fp) {
            return;
        }
        sr.c(ls.getContext()).f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void xv() {
        if (this.xv.getAndSet(true)) {
            return;
        }
        c("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void c(String str) {
        ev.c(1, this.eq, str, null);
    }
}
