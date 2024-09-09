package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: SLModeUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f53780b = "lastReqTime";

    /* renamed from: c  reason: collision with root package name */
    private static final int f53781c = 48;

    /* renamed from: d  reason: collision with root package name */
    private static final int f53782d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f53783e = 720;

    /* renamed from: f  reason: collision with root package name */
    private static final String f53784f = "iss";

    /* renamed from: g  reason: collision with root package name */
    private static final String f53785g = "sinr";

    /* renamed from: h  reason: collision with root package name */
    private static final String f53786h = "clean";

    /* renamed from: i  reason: collision with root package name */
    private static boolean f53787i;

    /* renamed from: j  reason: collision with root package name */
    private static int f53788j;

    /* renamed from: a  reason: collision with root package name */
    private static final String f53779a = au.b().b("sli");

    /* renamed from: k  reason: collision with root package name */
    private static Object f53789k = new Object();

    static {
        f53787i = false;
        f53788j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, "iss", "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f53789k) {
                f53787i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, "sinr", "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                try {
                    f53788j = a(Integer.parseInt(imprintProperty2));
                    return;
                } catch (Throwable unused) {
                    f53788j = 48;
                    return;
                }
            }
            f53788j = 48;
        }
    }

    private static int a(int i4) {
        if (i4 > 720) {
            return 720;
        }
        if (i4 < 1) {
            return 1;
        }
        return i4;
    }

    public static boolean a() {
        boolean z3;
        synchronized (f53789k) {
            z3 = f53787i;
        }
        return z3;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53779a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("lastReqTime", 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53779a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("clean", true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53779a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("clean", false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53779a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("clean", false);
        }
        return false;
    }

    public static int a(Context context) {
        int i4;
        synchronized (f53789k) {
            i4 = f53788j;
        }
        return i4;
    }

    public static boolean a(long j4, long j5, int i4) {
        Date date = new Date(j5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.add(10, i4);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j4) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53779a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastReqTime", j4).commit();
        }
    }
}
