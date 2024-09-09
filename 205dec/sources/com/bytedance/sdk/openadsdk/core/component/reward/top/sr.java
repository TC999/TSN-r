package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.xv.p;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends xv {
    public sr(TTBaseVideoActivity tTBaseVideoActivity, me meVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, wVar, uxVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.ux.bm().w();
        if (this.xv.x()) {
            this.ux.ux();
        } else if (m.ia(this.f32600w)) {
            w();
        } else {
            xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void f(View view) {
        super.f(view);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void w(View view) {
        super.w(view);
        this.ux.yu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void xv(View view) {
        super.xv(view);
        this.ux.sr(this.xv.pr());
    }

    private void w() {
        p pVar = new p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.sr.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xv.p
            public void w() {
                sr.this.ux.ux();
            }
        };
        if (this.ux.c(pVar)) {
            this.f32599f--;
        } else {
            pVar.w();
        }
    }

    private void xv() {
        this.ux.ux();
    }
}
