package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* renamed from: com.umeng.commonsdk.statistics.common.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class StoreHelper {

    /* renamed from: a */
    private static StoreHelper f38954a;

    /* renamed from: b */
    private static Context f38955b;

    /* renamed from: c */
    private static String f38956c;

    /* renamed from: d */
    private static final String f38957d = PathCenter.m14695b().m14694b(PathCenter.f37694m);

    public StoreHelper(Context context) {
    }

    /* renamed from: a */
    public static synchronized StoreHelper m13749a(Context context) {
        StoreHelper storeHelper;
        synchronized (StoreHelper.class) {
            f38955b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f38956c = context.getPackageName();
            if (f38954a == null) {
                f38954a = new StoreHelper(context);
            }
            storeHelper = f38954a;
        }
        return storeHelper;
    }

    /* renamed from: f */
    private SharedPreferences m13742f() {
        Context context = f38955b;
        return context.getSharedPreferences(f38957d + f38956c, 0);
    }

    /* renamed from: b */
    public String m13746b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38955b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m13745c() {
        return UMFrUtils.envelopeFileNumber(f38955b) > 0;
    }

    /* renamed from: d */
    public String[] m13744d() {
        try {
            SharedPreferences m13742f = m13742f();
            String string = m13742f.getString("au_p", null);
            String string2 = m13742f.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: e */
    public void m13743e() {
        m13742f().edit().remove("au_p").remove("au_u").commit();
    }

    /* renamed from: a */
    public void m13750a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38955b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    /* renamed from: a */
    public int m13751a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38955b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: a */
    public void m13748a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f38955b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m13747a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m13742f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
