package com.amap.api.col.p0463l;

import android.content.Context;
import android.util.Log;

/* renamed from: com.amap.api.col.3l.h2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AuthLogUtil {

    /* renamed from: a */
    static String f4390a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f4390a = sb.toString();
    }

    /* renamed from: a */
    public static void m54857a() {
        m54853e(f4390a);
        m54853e("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        m54853e(f4390a);
    }

    /* renamed from: b */
    public static void m54856b(Context context, String str) {
        m54853e(f4390a);
        if (context != null) {
            m54854d("key:" + C1780e4.m55240j(context));
        }
        m54853e(str);
        m54853e(f4390a);
    }

    /* renamed from: c */
    public static void m54855c(String str) {
        m54853e(f4390a);
        m54853e(str);
        m54853e(f4390a);
    }

    /* renamed from: d */
    private static void m54854d(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            sb.append(str);
            for (int i = 0; i < 78 - str.length(); i++) {
                sb.append(" ");
            }
            sb.append("|");
            m54853e(sb.toString());
            return;
        }
        String substring = str.substring(0, 78);
        m54853e("|" + substring + "|");
        m54854d(str.substring(78));
    }

    /* renamed from: e */
    private static void m54853e(String str) {
        Log.i("authErrLog", str);
    }
}
