package com.bytedance.sdk.component.ux.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {
    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        com.bytedance.sdk.component.ux.w i4 = xvVar.i();
        if (i4 != null) {
            if (i4.xv()) {
                xvVar.c(new p());
                return;
            } else if (i4.sr()) {
                xvVar.c(new f());
                return;
            }
        }
        xvVar.c(new k());
    }
}
