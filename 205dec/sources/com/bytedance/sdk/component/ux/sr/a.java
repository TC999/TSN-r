package com.bytedance.sdk.component.ux.sr;

import com.bytedance.sdk.component.ux.fz;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends c {
    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        byte[] c4 = xvVar.u().w(xvVar.i()).c((fz) xvVar.f());
        if (c4 == null) {
            xvVar.c(new f());
        } else {
            xvVar.c(new w(c4, null));
        }
    }
}
