package com.amap.api.col.p0003l;

import android.content.Context;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthLogUtil.java */
/* renamed from: com.amap.api.col.3l.h2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h2 {

    /* renamed from: a  reason: collision with root package name */
    static String f7959a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 80; i4++) {
            sb.append("=");
        }
        f7959a = sb.toString();
    }

    public static void a() {
        e(f7959a);
        e("\u5f53\u524d\u4f7f\u7528\u7684\u81ea\u5b9a\u4e49\u5730\u56fe\u6837\u5f0f\u6587\u4ef6\u548c\u76ee\u524d\u7248\u672c\u4e0d\u5339\u914d\uff0c\u8bf7\u5230\u5b98\u7f51(lbs.amap.com)\u66f4\u65b0\u65b0\u7248\u6837\u5f0f\u6587\u4ef6");
        e(f7959a);
    }

    public static void b(Context context, String str) {
        e(f7959a);
        if (context != null) {
            d("key:" + e4.j(context));
        }
        e(str);
        e(f7959a);
    }

    public static void c(String str) {
        e(f7959a);
        e(str);
        e(f7959a);
    }

    private static void d(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            sb.append(str);
            for (int i4 = 0; i4 < 78 - str.length(); i4++) {
                sb.append(" ");
            }
            sb.append("|");
            e(sb.toString());
            return;
        }
        String substring = str.substring(0, 78);
        e("|" + substring + "|");
        d(str.substring(78));
    }

    private static void e(String str) {
        Log.i("authErrLog", str);
    }
}
