package com.bytedance.sdk.openadsdk.r;

import com.bytedance.sdk.component.ux.p;
import com.bytedance.sdk.component.ux.ys;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.eq.me;
import com.bytedance.sdk.openadsdk.core.u.gb;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {
    public static p c(String str) {
        return c(c().c(str));
    }

    public static p c(gb gbVar) {
        return c(c().c(gbVar.c()).c(gbVar.w()).w(gbVar.xv()).w(gbVar.r()));
    }

    public static InputStream c(String str, String str2) {
        return c().c(str, str2);
    }

    public static ys c() {
        return (ys) AutoService.c(ys.class);
    }

    private static p c(p pVar) {
        return me.c() ? pVar.c(new xv()) : pVar;
    }
}
