package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {
    public static void c(fp fpVar) {
        ls.c(fpVar);
    }

    public static boolean f(Context context) {
        return xv(context) == 6;
    }

    public static String r(Context context) {
        int xv = xv(context);
        return xv != 2 ? xv != 3 ? xv != 4 ? xv != 5 ? xv != 6 ? "mobile" : "5g" : "4g" : "wifi" : "3g" : "2g";
    }

    public static boolean sr(Context context) {
        return xv(context) == 4;
    }

    public static boolean ux(Context context) {
        return xv(context) == 5;
    }

    public static int w(Context context) {
        int xv = xv(context);
        if (xv != 1) {
            if (xv != 4) {
                if (xv != 5) {
                    if (xv != 6) {
                        return xv;
                    }
                    return 6;
                }
                return 4;
            }
            return 1;
        }
        return 0;
    }

    public static int xv(Context context) {
        return ls.c(context, 60000L);
    }

    public static boolean c(Context context) {
        return xv(context) != 0;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE));
    }
}
