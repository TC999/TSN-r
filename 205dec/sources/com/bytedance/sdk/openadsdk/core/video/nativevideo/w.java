package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends xv {
    public w(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        super(context, viewGroup, meVar, str, z3, z4, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xv
    protected com.bykv.vk.openvk.component.video.api.renderview.w ls() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            return uxVar.ia();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xv
    public void w(int i4, int i5) {
        super.w(i4, i5);
        ux uxVar = this.ux;
        if (uxVar == null || i4 <= 0 || i5 <= 0) {
            return;
        }
        uxVar.xv(i4, i5);
        this.ux.c(i4, i5);
        xv(-1, -1);
    }
}
