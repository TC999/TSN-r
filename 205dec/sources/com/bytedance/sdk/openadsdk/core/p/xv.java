package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p.xv.p;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static com.bytedance.sdk.openadsdk.core.p.w.xv c(Context context, me meVar, String str) {
        if (wv.f(context)) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.ev(context, meVar, str);
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.w(context, meVar, str);
    }

    public static com.bytedance.sdk.openadsdk.core.p.w.sr w(Context context, me meVar, String str) {
        if (wv.f(context)) {
            return new com.bytedance.sdk.openadsdk.core.p.xv.ux(context, meVar, str);
        }
        return new com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, str);
    }

    public static com.bytedance.sdk.openadsdk.core.p.w.xv c(Context context, String str, me meVar, String str2) {
        return new p(context, str, meVar, str2);
    }

    public static String c() {
        String str = "0.0.0";
        try {
            Bridge u3 = k.sr().u();
            if (u3 != null) {
                str = (String) u3.call(1, b.f24740c, String.class);
            } else {
                a.w("TTDownloadFactory", "bridge is null !!! get download sdk version error");
            }
        } catch (Exception e4) {
            a.c("TTDownloadFactory", "get download sdk version error", e4);
        }
        return str;
    }
}
