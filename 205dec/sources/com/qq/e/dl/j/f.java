package com.qq.e.dl.j;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Configuration f47005a;

    /* renamed from: b  reason: collision with root package name */
    private static Pair<Integer, Integer> f47006b;

    /* renamed from: c  reason: collision with root package name */
    private static float f47007c;

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        Configuration configuration = applicationContext.getResources().getConfiguration();
        Configuration configuration2 = f47005a;
        if (configuration2 == null || configuration != configuration2) {
            f47005a = configuration;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            if (f47005a.orientation == 1) {
                f47006b = new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            } else {
                f47006b = new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
            }
            f47007c = displayMetrics.density;
        }
    }

    public static int b() {
        return ((Integer) (c() ? f47006b.first : f47006b.second)).intValue();
    }

    public static boolean c() {
        return f47005a.orientation == 1;
    }

    public static int b(double d4) {
        int i4 = (d4 > 0.0d ? 1 : (d4 == 0.0d ? 0 : -1));
        if (i4 == 0) {
            return 0;
        }
        float f4 = f47007c;
        if (f4 < 0.0f) {
            f4 = 1.0f;
        }
        if (i4 > 0) {
            double d5 = f4;
            Double.isNaN(d5);
            return (int) ((d4 / d5) + 0.5d);
        }
        double d6 = f4;
        Double.isNaN(d6);
        return -((int) (((-d4) / d6) + 0.5d));
    }

    public static int a() {
        return ((Integer) (c() ? f47006b.second : f47006b.first)).intValue();
    }

    public static int a(double d4) {
        int i4 = (d4 > 0.0d ? 1 : (d4 == 0.0d ? 0 : -1));
        if (i4 == 0) {
            return 0;
        }
        float f4 = f47007c;
        if (f4 < 0.0f) {
            f4 = 1.0f;
        }
        if (i4 > 0) {
            double d5 = f4;
            Double.isNaN(d5);
            return (int) ((d4 * d5) + 0.5d);
        }
        double d6 = f4;
        Double.isNaN(d6);
        return -((int) (((-d4) * d6) + 0.5d));
    }
}
