package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends xv {
    public f(TTBaseVideoActivity tTBaseVideoActivity, me meVar, com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, wVar, uxVar, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.ux.bm().c();
        if (this.ux.ys()) {
            this.f32599f--;
            return;
        }
        this.xv.c(true);
        this.xv.i();
        this.ux.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void sr(View view) {
        super.sr(view);
        this.ux.n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void w(View view) {
        super.w(view);
        this.ux.yu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xv, com.bytedance.sdk.openadsdk.core.component.reward.top.w
    public void xv(View view) {
        super.xv(view);
        this.ux.sr("playable");
    }
}
