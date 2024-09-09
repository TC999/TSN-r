package com.qq.e.comm.plugin.r;

import android.content.SharedPreferences;
import com.qq.e.comm.plugin.util.s0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SharedPreferences f45668a = com.qq.e.comm.plugin.d0.a.d().a().getSharedPreferences(s0.a("com.qq.e.enhance"), 0);

    public static void a(String str, int i4) {
        SharedPreferences.Editor edit = f45668a.edit();
        edit.remove(str + "_uce");
        String str2 = str + "_fc";
        if (i4 <= 0) {
            edit.remove(str2);
        } else {
            edit.putInt(str2, i4);
        }
        edit.apply();
    }

    public static int b(String str) {
        SharedPreferences sharedPreferences = f45668a;
        return sharedPreferences.getInt(str + "_fc", 0);
    }

    public static void c(String str) {
        SharedPreferences.Editor edit = f45668a.edit();
        edit.putBoolean(str + "_uce", true).apply();
    }

    public static boolean a(String str) {
        String str2 = str + "_uce";
        boolean z3 = f45668a.getBoolean(str2, false);
        if (z3) {
            f45668a.edit().remove(str2).putInt(str + "_fc", Integer.MAX_VALUE).apply();
        }
        return z3;
    }
}
