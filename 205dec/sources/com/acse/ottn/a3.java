package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4583a = "ad_preference";

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4584b;

    /* renamed from: c  reason: collision with root package name */
    public static a3 f4585c;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences.Editor f4586d;

    public a3(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ad_preference", 4);
        f4584b = sharedPreferences;
        f4586d = sharedPreferences.edit();
    }

    public static synchronized void a(Context context) {
        synchronized (a3.class) {
            if (f4585c == null) {
                f4585c = new a3(context);
            }
        }
    }

    public boolean b() {
        return f4584b.getBoolean("show_request_ad", false);
    }

    public String c() {
        return f4584b.getString("show_ad_time", "0");
    }

    public boolean d() {
        return f4584b.getBoolean("show_log", false);
    }

    public void e() {
        f4585c = null;
    }

    public void b(String str) {
        f4586d.putString("show_ad_time", str);
        f4586d.commit();
    }

    public void a(boolean z3) {
        f4586d.putBoolean("show_request_ad", z3);
        f4586d.commit();
    }

    public static synchronized a3 b(Context context) {
        a3 a3Var;
        synchronized (a3.class) {
            a3Var = new a3(context);
            f4585c = a3Var;
        }
        return a3Var;
    }

    public static synchronized a3 a() {
        a3 a3Var;
        synchronized (a3.class) {
            if (f4585c == null) {
                a(HelpShopAppUtil.getContext());
            }
            a3Var = f4585c;
        }
        return a3Var;
    }

    public void b(boolean z3) {
        f4586d.putBoolean("show_log", z3);
        f4586d.commit();
    }

    public void a(String str, boolean z3) {
        f4586d.putBoolean(str, z3).commit();
    }

    public boolean a(String str) {
        return f4584b.getBoolean(str, false);
    }
}
