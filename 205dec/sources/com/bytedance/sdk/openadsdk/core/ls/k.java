package com.bytedance.sdk.openadsdk.core.ls;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, a> f33882c = new HashMap<>();

    public static void c(me meVar) {
        xv xvVar = (xv) AutoService.c(xv.class);
        if (xvVar != null && xvVar.sr() && xvVar.xv() && p.w() && meVar != null && meVar.oo() != null) {
            String xq = meVar.xq();
            String zb = meVar.zb();
            String f4 = meVar.oo().f();
            if (TextUtils.isEmpty(f4)) {
                return;
            }
            a aVar = new a();
            aVar.c(1);
            aVar.c(xq);
            aVar.w(zb);
            f33882c.put(f4, aVar);
        }
    }
}
