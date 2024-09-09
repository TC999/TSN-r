package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static volatile u f46614a;

    private u() {
    }

    private void a() {
        SharedPreferences.Editor edit = com.qq.e.comm.plugin.d0.a.d().a().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.remove("2c39b77689");
        edit.apply();
    }

    public static u b() {
        if (f46614a == null) {
            synchronized (u.class) {
                if (f46614a == null) {
                    f46614a = new u();
                }
            }
        }
        return f46614a;
    }

    private void d() {
        SharedPreferences.Editor edit = com.qq.e.comm.plugin.d0.a.d().a().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("2c39b77689", e1.c());
        edit.apply();
    }

    public void c() {
        try {
            if (com.qq.e.comm.plugin.d0.a.d().f().a("buglyRate", 0) > 0) {
                d();
            } else {
                a();
            }
        } catch (Exception e4) {
            d1.a("Bugly Init encounter exception: " + e4.getMessage(), new Object[0]);
        }
    }
}
