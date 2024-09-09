package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: StoreHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f53589a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f53590b;

    /* renamed from: c  reason: collision with root package name */
    private static String f53591c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f53592d = au.b().b("user");

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f53590b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f53591c = context.getPackageName();
            if (f53589a == null) {
                f53589a = new d(context);
            }
            dVar = f53589a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = f53590b;
        return context.getSharedPreferences(f53592d + f53591c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53590b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f53590b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f4 = f();
            String string = f4.getString("au_p", null);
            String string2 = f4.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i4) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53590b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i4).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53590b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f53590b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
