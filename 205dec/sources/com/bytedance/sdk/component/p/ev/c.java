package com.bytedance.sdk.component.p.ev;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if (charAt >= 'A' && charAt <= 'Z') {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (charAt + ' '));
                }
                sb.append(charAt);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z3) {
            str = str.substring(1);
        }
        return c(str);
    }
}
