package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.acse.ottn.f3;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class z1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46766a = "z1";

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f46767b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f46768c;

    static {
        try {
            b();
        } catch (Throwable th) {
            d1.a(f46766a, "init Exception", th);
        }
    }

    public static int a() {
        return f46768c;
    }

    private static void b() {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        boolean a5 = a(a4);
        int i4 = (a5 ? 1 : 2) * 1000;
        boolean b4 = b(a4);
        int i5 = i4 + ((b4 ? 1 : 2) * 100) + ((c(a4) ? 1 : 2) * 10);
        boolean d4 = d();
        int i6 = i5 + (d4 ? 1 : 2);
        f46767b = a5 || b4 || d4;
        f46768c = i6;
        d1.a(f46766a, "isTablet: %s, code: %s ", Boolean.valueOf(f46767b), Integer.valueOf(f46768c));
        String str = com.qq.e.comm.plugin.d0.a.d().c().f42280j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().b("tdml", "").contains(str.toLowerCase())) {
            f46767b = true;
        }
        if (com.qq.e.comm.plugin.d0.a.d().f().b("ntdml", "").contains(str.toLowerCase())) {
            f46767b = false;
        }
    }

    public static boolean c() {
        return f46767b;
    }

    private static boolean d() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, "ro.build.characteristics", "unknown");
            d1.a(f46766a, "ro.build.characteristics: %s ", str);
            return "tablet".equals(str);
        } catch (Exception e4) {
            d1.a(f46766a, "isTablet4 Exception", e4);
            return false;
        }
    }

    private static boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @Deprecated
    private static boolean c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        double pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
        double pow2 = Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d);
        double sqrt = Math.sqrt(pow + pow2);
        d1.a(f46766a, "widthPixels: %s, heightPixels: %s, x: %s, y: %s, screenInches: %s ", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Double.valueOf(pow), Double.valueOf(pow2), Double.valueOf(sqrt));
        return sqrt >= 7.0d;
    }

    private static boolean b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        d1.a(f46766a, "smallestScreenWidthDp: %s ", Integer.valueOf(configuration.smallestScreenWidthDp));
        return configuration.smallestScreenWidthDp >= 600;
    }
}
