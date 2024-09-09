package com.bytedance.sdk.openadsdk.core.fz;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ls;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {
    public static boolean c(String str, double d4) {
        JSONObject oo = ls.w().oo();
        if (oo != null && !TextUtils.isEmpty(str)) {
            try {
                double optDouble = oo.optDouble(str, d4);
                if (optDouble == 1.0d) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.sr.w.c((float) optDouble, false);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
