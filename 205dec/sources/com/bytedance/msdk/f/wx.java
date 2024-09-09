package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wx {
    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.core.k.p pVar, com.bytedance.msdk.api.c.w wVar, boolean z3) {
        if (uxVar == null || !uxVar.isMultiBiddingAd()) {
            return;
        }
        if (pVar == null) {
            uxVar.setCpm(0.0d);
        }
        String levelTag = uxVar.getLevelTag();
        Map<String, String> z4 = pVar.z();
        if (TextUtils.isEmpty(levelTag)) {
            if (z3) {
                com.bytedance.msdk.xv.r.c(pVar, wVar, uxVar, 40061, com.bytedance.msdk.api.c.c(40061));
            }
            uxVar.setErrorMsg(com.bytedance.msdk.api.c.c(40061));
            uxVar.setCpm(0.0d);
        } else if (z4 == null) {
            if (z3) {
                com.bytedance.msdk.xv.r.c(pVar, wVar, uxVar, 40062, com.bytedance.msdk.api.c.c(40062));
            }
            uxVar.setErrorMsg(com.bytedance.msdk.api.c.c(40062));
            uxVar.setCpm(0.0d);
        } else {
            String str = z4.get(levelTag);
            if (TextUtils.isEmpty(str)) {
                if (z3) {
                    com.bytedance.msdk.xv.r.c(pVar, wVar, uxVar, 40062, com.bytedance.msdk.api.c.c(40062));
                }
                uxVar.setCpm(0.0d);
                return;
            }
            try {
                uxVar.setCpm(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                uxVar.setCpm(0.0d);
            }
        }
    }
}
