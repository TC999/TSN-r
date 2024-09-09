package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends xv {
    public ux(TTBaseVideoActivity tTBaseVideoActivity, me meVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, wVar, uxVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.ux.bm().c();
        if (!fp.k(this.f32600w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32600w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32600w)) {
            p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.ux.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
                public void w() {
                    ux.this.ux.fz();
                    ux.this.ux.ux();
                }
            };
            if (this.ux.c(pVar)) {
                this.f32599f--;
                return;
            } else {
                pVar.w();
                return;
            }
        }
        this.ux.t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void f(View view) {
        super.f(view);
        if (!com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.f32600w) && !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.f32600w)) {
            c();
        } else {
            this.ux.t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void w(View view) {
        super.w(view);
        if (fp.sr(this.f32600w)) {
            this.ux.xk();
        } else {
            this.ux.yu();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void xv(View view) {
        super.xv(view);
        this.ux.sr("playable");
    }
}
