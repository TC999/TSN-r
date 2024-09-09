package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method Ti;
    private static Method Tj;
    private static Field Tk;

    static {
        try {
            Ti = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
        try {
            Tj = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
        try {
            Tk = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) s.c(View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z3) {
        try {
            int intValue = ((Integer) s.getField(layoutParams, str)).intValue();
            int intValue2 = ((Integer) s.getField(layoutParams, "meizuFlags")).intValue();
            int i4 = z3 ? intValue | intValue2 : (intValue ^ (-1)) & intValue2;
            if (intValue2 != i4) {
                s.a(layoutParams, "meizuFlags", Integer.valueOf(i4));
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z3) {
        a(activity, true, true);
    }

    private static void g(View view, boolean z3) {
        int i4;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z3) {
            i4 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i4 = (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        }
        if (i4 != systemUiVisibility) {
            view.setSystemUiVisibility(i4);
        }
    }

    private static void setStatusBarColor(Window window, int i4) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = Tk;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    Tk.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
    }

    private static void a(Window window, boolean z3) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z3);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z3);
            setStatusBarColor(window, 0);
        }
    }

    private static void a(Activity activity, boolean z3, boolean z4) {
        Method method = Tj;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z3));
                return;
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                return;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return;
            }
        }
        a(activity.getWindow(), z3);
    }
}
