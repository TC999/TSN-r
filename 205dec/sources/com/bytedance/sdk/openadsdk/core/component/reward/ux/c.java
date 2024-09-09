package com.bytedance.sdk.openadsdk.core.component.reward.ux;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static String c(String str) {
        if (a.xv() && !TextUtils.isEmpty(str)) {
            f fVar = new f(k.sr().t());
            StringBuilder sb = new StringBuilder(str);
            for (String str2 : fVar.w()) {
                if (sb.toString().contains(str2)) {
                    if (sb.toString().contains("?")) {
                        sb.append("&");
                        sb.append(fVar.c());
                    } else {
                        sb.append("?");
                        sb.append(fVar.c());
                    }
                }
            }
            return sb.toString();
        }
        return str;
    }
}
