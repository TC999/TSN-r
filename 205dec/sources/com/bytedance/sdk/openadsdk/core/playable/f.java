package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.n.gd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.openadsdk.core.video.w.c {
    private boolean me;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context, ViewGroup viewGroup, me meVar, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        super(context, viewGroup, meVar, cVar);
        this.me = true;
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.w.c
    protected boolean G_() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.w.c
    public void f(boolean z3) {
        super.f(z3);
        if (this.me) {
            if (gd.c(this.f35110f)) {
                if (ux()) {
                    w();
                    return;
                }
                return;
            }
            w();
        }
    }

    public void gb() {
        bm();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.w.c
    protected int ls() {
        return 5;
    }

    public void r(boolean z3) {
        this.me = z3;
    }
}
