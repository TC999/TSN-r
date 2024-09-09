package com.acse.ottn.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Aa {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6702a = "ad_preference";

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f6703b;

    /* renamed from: c  reason: collision with root package name */
    private static Aa f6704c;

    /* renamed from: d  reason: collision with root package name */
    private static SharedPreferences.Editor f6705d;

    private Aa(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ad_preference", 4);
        f6703b = sharedPreferences;
        f6705d = sharedPreferences.edit();
    }

    public static synchronized Aa a() {
        Aa aa;
        synchronized (Aa.class) {
            if (f6704c == null) {
                a(HelpShopAppUtil.getContext());
            }
            aa = f6704c;
        }
        return aa;
    }

    public static synchronized void a(Context context) {
        synchronized (Aa.class) {
            if (f6704c == null) {
                f6704c = new Aa(context);
            }
        }
    }

    public static synchronized Aa b(Context context) {
        Aa aa;
        synchronized (Aa.class) {
            aa = new Aa(context);
            f6704c = aa;
        }
        return aa;
    }

    public void a(String str, boolean z3) {
        f6705d.putBoolean(str, z3).commit();
    }

    public void a(boolean z3) {
        f6705d.putBoolean("show_request_ad", z3);
        f6705d.commit();
    }

    public boolean a(String str) {
        return f6703b.getBoolean(str, false);
    }

    public void b(String str) {
        f6705d.putString("show_ad_time", str);
        f6705d.commit();
    }

    public void b(boolean z3) {
        f6705d.putBoolean("show_log", z3);
        f6705d.commit();
    }

    public boolean b() {
        return f6703b.getBoolean("show_request_ad", false);
    }

    public String c() {
        return f6703b.getString("show_ad_time", "0");
    }

    public boolean d() {
        return f6703b.getBoolean("show_log", false);
    }

    public void e() {
        f6704c = null;
    }
}
