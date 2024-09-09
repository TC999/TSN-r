package com.bytedance.sdk.component.ux.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c {
    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        if (TextUtils.isEmpty(xvVar.r())) {
            com.bytedance.sdk.component.ux.a ux = xvVar.u().ux();
            xvVar.w(ux.c(xvVar));
            xvVar.c(ux.w(xvVar));
        }
        xvVar.c(new r());
    }
}
