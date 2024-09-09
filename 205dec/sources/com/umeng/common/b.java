package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SPHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f53270a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f53271b;

    /* renamed from: c  reason: collision with root package name */
    private static String f53272c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f53273d = au.b().b("user");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: SPHelper.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f53274a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f53271b == null && context != null) {
                f53271b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (f53271b != null) {
                f53272c = context.getPackageName();
            }
            bVar = a.f53274a;
        }
        return bVar;
    }

    private SharedPreferences e() {
        Context context = f53271b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f53273d + f53272c, 0);
    }

    public void b() {
        SharedPreferences e4 = e();
        if (e4 != null) {
            e4.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53271b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53271b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e4 = e();
        if (e4 != null) {
            String string = e4.getString("au_p", null);
            String string2 = e4.getString("au_u", null);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            return new String[]{string, string2};
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53271b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i4) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53271b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i4).commit();
        }
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0).edit();
        edit.remove("debugkey");
        edit.remove("period");
        edit.remove("startTime");
        edit.clear();
        edit.commit();
    }
}
