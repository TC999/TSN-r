package com.bytedance.sdk.openadsdk.core.ugeno.c;

import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements w {
    private int sr(me meVar) {
        if (meVar == null) {
            return -1;
        }
        return meVar.tz();
    }

    private static int ux(me meVar) {
        int ev;
        if (meVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo = meVar.oo();
        int q3 = oo != null ? oo.q() : -1;
        return ((q3 <= 0 || q3 >= 10) && (ev = wv.ev(meVar)) > 0 && ev < 10) ? ev : q3;
    }

    public static boolean w(me meVar) {
        if (meVar == null) {
            return false;
        }
        return (meVar.nb() == 2) && xv(meVar);
    }

    public static boolean xv(me meVar) {
        return ux(meVar) == 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.w
    public String c(me meVar) {
        int ux = ux(meVar);
        int sr = sr(meVar);
        if (ux < 1 || ux > 9 || sr == -1) {
            return null;
        }
        return c(meVar, ux, sr);
    }

    protected abstract String c(me meVar, int i4, int i5);

    public static w c(me meVar, bk bkVar) {
        if (meVar != null && ux(meVar) == 5) {
            if ((bkVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.c) && ((com.bytedance.sdk.openadsdk.core.ugeno.w.c) bkVar).ck()) {
                return new com.bytedance.sdk.openadsdk.core.ugeno.c.w.c();
            }
            return new com.bytedance.sdk.openadsdk.core.ugeno.c.c.c();
        }
        return null;
    }
}
