package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* renamed from: com.umeng.common.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SPHelper {

    /* renamed from: a */
    private static SPHelper f38599a;

    /* renamed from: b */
    private static Context f38600b;

    /* renamed from: c */
    private static String f38601c;

    /* renamed from: d */
    private static final String f38602d = PathCenter.m14695b().m14694b(PathCenter.f37694m);

    /* compiled from: SPHelper.java */
    /* renamed from: com.umeng.common.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class C13194a {

        /* renamed from: a */
        private static final SPHelper f38603a = new SPHelper();

        private C13194a() {
        }
    }

    /* renamed from: a */
    public static synchronized SPHelper m14059a(Context context) {
        SPHelper sPHelper;
        synchronized (SPHelper.class) {
            if (f38600b == null && context != null) {
                f38600b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (f38600b != null) {
                f38601c = context.getPackageName();
            }
            sPHelper = C13194a.f38603a;
        }
        return sPHelper;
    }

    /* renamed from: e */
    private SharedPreferences m14050e() {
        Context context = f38600b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f38602d + f38601c, 0);
    }

    /* renamed from: b */
    public void m14053b() {
        SharedPreferences m14050e = m14050e();
        if (m14050e != null) {
            m14050e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    /* renamed from: c */
    public String m14052c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38600b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: d */
    public int m14051d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38600b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: a */
    public void m14054a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m14050e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    /* renamed from: a */
    public String[] m14061a() {
        SharedPreferences m14050e = m14050e();
        if (m14050e != null) {
            String string = m14050e.getString("au_p", null);
            String string2 = m14050e.getString("au_u", null);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            return new String[]{string, string2};
        }
        return null;
    }

    /* renamed from: a */
    public void m14055a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38600b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m14060a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38600b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    /* renamed from: a */
    public static String m14057a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    /* renamed from: a */
    public static void m14056a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a */
    public static void m14058a(Context context, String str) {
        SharedPreferences.Editor edit = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0).edit();
        edit.remove(AnalyticsConfig.DEBUG_KEY);
        edit.remove(AnalyticsConfig.RTD_PERIOD);
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
