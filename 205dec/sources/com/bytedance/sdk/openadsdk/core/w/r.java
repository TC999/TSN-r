package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class r extends c {
    public r(Context context, me meVar, String str, int i4) {
        super(context, meVar, str, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
    public void c(View view, gd gdVar) {
        super.c(view, gdVar);
        com.bytedance.sdk.openadsdk.core.w.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.w) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.w.class);
        if (wVar == null || !wVar.w(view)) {
            return;
        }
        w(view, gdVar);
    }

    protected abstract void w(View view, gd gdVar);
}
