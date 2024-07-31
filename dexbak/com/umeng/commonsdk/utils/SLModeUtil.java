package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* renamed from: com.umeng.commonsdk.utils.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SLModeUtil {

    /* renamed from: b */
    private static final String f39145b = "lastReqTime";

    /* renamed from: c */
    private static final int f39146c = 48;

    /* renamed from: d */
    private static final int f39147d = 1;

    /* renamed from: e */
    private static final int f39148e = 720;

    /* renamed from: f */
    private static final String f39149f = "iss";

    /* renamed from: g */
    private static final String f39150g = "sinr";

    /* renamed from: h */
    private static final String f39151h = "clean";

    /* renamed from: i */
    private static boolean f39152i;

    /* renamed from: j */
    private static int f39153j;

    /* renamed from: a */
    private static final String f39144a = PathCenter.m14695b().m14694b(PathCenter.f37707z);

    /* renamed from: k */
    private static Object f39154k = new Object();

    static {
        f39152i = false;
        f39153j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f39149f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f39154k) {
                f39152i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f39150g, "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                try {
                    f39153j = m13462a(Integer.parseInt(imprintProperty2));
                    return;
                } catch (Throwable unused) {
                    f39153j = 48;
                    return;
                }
            }
            f39153j = 48;
        }
    }

    /* renamed from: a */
    private static int m13462a(int i) {
        if (i > 720) {
            return 720;
        }
        if (i < 1) {
            return 1;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m13463a() {
        boolean z;
        synchronized (f39154k) {
            z = f39152i;
        }
        return z;
    }

    /* renamed from: b */
    public static long m13458b(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f39144a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f39145b, 0L);
        }
        return 0L;
    }

    /* renamed from: c */
    public static void m13457c(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f39144a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f39151h, true).commit();
        }
    }

    /* renamed from: d */
    public static void m13456d(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f39144a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f39151h, false).commit();
        }
    }

    /* renamed from: e */
    public static boolean m13455e(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f39144a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f39151h, false);
        }
        return false;
    }

    /* renamed from: a */
    public static int m13460a(Context context) {
        int i;
        synchronized (f39154k) {
            i = f39153j;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m13461a(long j, long j2, int i) {
        Date date = new Date(j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.add(10, i);
        return date.after(calendar.getTime());
    }

    /* renamed from: a */
    public static void m13459a(Context context, long j) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f39144a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f39145b, j).commit();
        }
    }
}
