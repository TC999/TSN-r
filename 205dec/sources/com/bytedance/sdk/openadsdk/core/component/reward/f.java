package com.bytedance.sdk.openadsdk.core.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends p {
    private boolean me;

    public f(Context context, ViewGroup viewGroup, me meVar) {
        super(context, viewGroup, meVar, null);
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.p, com.bytedance.sdk.openadsdk.core.video.w.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public void ev() {
        if (this.me) {
            return;
        }
        super.ev();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.w.c
    public void f(boolean z3) {
        super.f(z3);
        w();
    }

    public boolean gb() {
        return ia() != null && ia().t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.p, com.bytedance.sdk.openadsdk.core.video.w.c
    protected int ls() {
        return 4;
    }

    public boolean n() {
        return this.me;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.w.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public void p() {
        this.me = false;
        super.p();
    }

    public void r(boolean z3) {
        this.me = z3;
    }
}
