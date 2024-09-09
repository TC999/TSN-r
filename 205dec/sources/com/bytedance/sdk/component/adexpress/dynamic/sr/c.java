package com.bytedance.sdk.component.adexpress.dynamic.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(".") > 0) {
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.append(".png");
        return sb.toString();
    }
}
