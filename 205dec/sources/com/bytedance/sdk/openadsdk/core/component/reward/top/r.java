package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.gd;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends xv {
    public r(TTBaseVideoActivity tTBaseVideoActivity, me meVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, wVar, uxVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void c(View view) {
        super.c(view);
        this.ux.bm().c();
        if (m.ia(this.f32600w)) {
            w();
        } else {
            xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void f(View view) {
        super.f(view);
        this.ux.onSkipBorderClick(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void w(View view) {
        super.w(view);
        if (this.ux.b() instanceof gd) {
            this.ux.yu();
        }
        this.ux.xk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void xv(View view) {
        super.xv(view);
        this.ux.sr("video_player");
    }

    private void xv() {
        p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.r.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                r.this.ux.f();
            }
        };
        if (this.ux.c(pVar)) {
            return;
        }
        pVar.w();
    }

    private void w() {
        p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.r.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                r.this.ux.fz();
                r.this.ux.wx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.r.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.this.ux.ux();
                    }
                }, 100L);
            }
        };
        int i4 = 2;
        int ux = this.ux.ux(2);
        if (this.f32600w.sc() != 7) {
            i4 = ux;
        } else if (ls.w().ev(String.valueOf(wv.gd(this.f32600w))) && !this.ux.wo()) {
            i4 = 1;
        }
        if (i4 == 1) {
            if (this.ux.c(pVar)) {
                return;
            }
            pVar.w();
            return;
        }
        this.ux.f();
    }
}
