package com.bytedance.sdk.component.adexpress.sr;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.i;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f29391c;

    public static float c(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        return (f4 * ux(context)) + 0.5f;
    }

    public static int c(float f4, float f5, float f6, float f7) {
        return (((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f5 * 255.0f) + 0.5f)) << 16) | (((int) ((f6 * 255.0f) + 0.5f)) << 8) | ((int) ((f7 * 255.0f) + 0.5f));
    }

    public static String sr(Context context) {
        Locale locale;
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = i.c(context).getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            str = locale.getLanguage();
            if (locale.getCountry().equals("TW")) {
                str = "zhHant";
            }
        } catch (Throwable unused) {
        }
        return c(str);
    }

    private static float ux(Context context) {
        try {
            if (f29391c) {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = loadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(loadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int w(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        float ux = ux(context);
        if (ux <= 0.0f) {
            ux = 1.0f;
        }
        return (int) ((f4 / ux) + 0.5f);
    }

    public static float xv(Context context, float f4) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        return f4 * ux(context);
    }

    public static int c(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int w(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int xv(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static String c(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 3121:
                if (str.equals("ar")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    c4 = 3;
                    break;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "aa";
            case 1:
                return "japan";
            case 2:
                return "korea";
            case 3:
                return "my";
            case 4:
                return "cn";
            default:
                return str;
        }
    }
}
