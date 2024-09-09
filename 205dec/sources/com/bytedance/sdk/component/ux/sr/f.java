package com.bytedance.sdk.component.ux.sr;

import java.util.Collection;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private byte[] w(com.bytedance.sdk.component.ux.xv.xv xvVar, String str) {
        com.bytedance.sdk.component.ux.xv xv = xvVar.u().xv(xvVar.i());
        if (xv == null) {
            return null;
        }
        return xv.c((com.bytedance.sdk.component.ux.xv) str);
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        byte[] c4;
        String f4 = xvVar.f();
        if (!xvVar.q() && !xvVar.i().f()) {
            c4 = w(xvVar, f4);
        } else {
            c4 = c(xvVar, f4);
        }
        if (c4 == null) {
            xvVar.c(new k());
            return;
        }
        xvVar.c(new w(c4, null));
        xvVar.u().w(xvVar.i()).c(f4, c4);
    }

    private byte[] c(com.bytedance.sdk.component.ux.xv.xv xvVar, String str) {
        xvVar.u().xv(xvVar.i());
        Collection<com.bytedance.sdk.component.ux.xv> xv = xvVar.u().xv();
        if (xv == null) {
            return null;
        }
        for (com.bytedance.sdk.component.ux.xv xvVar2 : xv) {
            byte[] c4 = xvVar2.c((com.bytedance.sdk.component.ux.xv) str);
            if (c4 != null) {
                return c4;
            }
        }
        return null;
    }
}
