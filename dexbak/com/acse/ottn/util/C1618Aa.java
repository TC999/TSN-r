package com.acse.ottn.util;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.acse.ottn.util.Aa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1618Aa {

    /* renamed from: a */
    public static final String f3129a = "ad_preference";

    /* renamed from: b */
    private static SharedPreferences f3130b;

    /* renamed from: c */
    private static C1618Aa f3131c;

    /* renamed from: d */
    private static SharedPreferences.Editor f3132d;

    private C1618Aa(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f3129a, 4);
        f3130b = sharedPreferences;
        f3132d = sharedPreferences.edit();
    }

    /* renamed from: a */
    public static synchronized C1618Aa m56313a() {
        C1618Aa c1618Aa;
        synchronized (C1618Aa.class) {
            if (f3131c == null) {
                m56312a(HelpShopAppUtil.getContext());
            }
            c1618Aa = f3131c;
        }
        return c1618Aa;
    }

    /* renamed from: a */
    public static synchronized void m56312a(Context context) {
        synchronized (C1618Aa.class) {
            if (f3131c == null) {
                f3131c = new C1618Aa(context);
            }
        }
    }

    /* renamed from: b */
    public static synchronized C1618Aa m56307b(Context context) {
        C1618Aa c1618Aa;
        synchronized (C1618Aa.class) {
            c1618Aa = new C1618Aa(context);
            f3131c = c1618Aa;
        }
        return c1618Aa;
    }

    /* renamed from: a */
    public void m56310a(String str, boolean z) {
        f3132d.putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public void m56309a(boolean z) {
        f3132d.putBoolean("show_request_ad", z);
        f3132d.commit();
    }

    /* renamed from: a */
    public boolean m56311a(String str) {
        return f3130b.getBoolean(str, false);
    }

    /* renamed from: b */
    public void m56306b(String str) {
        f3132d.putString("show_ad_time", str);
        f3132d.commit();
    }

    /* renamed from: b */
    public void m56305b(boolean z) {
        f3132d.putBoolean("show_log", z);
        f3132d.commit();
    }

    /* renamed from: b */
    public boolean m56308b() {
        return f3130b.getBoolean("show_request_ad", false);
    }

    /* renamed from: c */
    public String m56304c() {
        return f3130b.getString("show_ad_time", "0");
    }

    /* renamed from: d */
    public boolean m56303d() {
        return f3130b.getBoolean("show_log", false);
    }

    /* renamed from: e */
    public void m56302e() {
        f3131c = null;
    }
}
