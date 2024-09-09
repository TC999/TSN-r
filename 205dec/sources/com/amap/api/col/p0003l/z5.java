package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SPConfig.java */
/* renamed from: com.amap.api.col.3l.z5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z5 {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f9584a = new HashMap<>();

    public static String a(Context context, p4 p4Var, String str) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return null;
        }
        String str2 = f9584a.get(p4Var.a() + str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = str + p4Var.a();
            return (context == null || TextUtils.isEmpty(str3)) ? "" : q4.g(d4.e(q4.y(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
        }
        return str2;
    }

    public static void b(Context context, p4 p4Var, String str, String str2) {
        if (p4Var == null || TextUtils.isEmpty(p4Var.a())) {
            return;
        }
        String str3 = str + p4Var.a();
        f9584a.put(p4Var.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String E = q4.E(d4.c(q4.o(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, E);
        edit.commit();
    }
}
