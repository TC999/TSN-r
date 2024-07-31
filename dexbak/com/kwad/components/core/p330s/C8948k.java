package com.kwad.components.core.p330s;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.C11124s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.kwad.components.core.s.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8948k {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

    /* renamed from: Ti */
    private static Method f28863Ti;

    /* renamed from: Tj */
    private static Method f28864Tj;

    /* renamed from: Tk */
    private static Field f28865Tk;

    static {
        try {
            f28863Ti = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            f28864Tj = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            f28865Tk = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) C11124s.m23696c(View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m29545a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            int intValue = ((Integer) C11124s.getField(layoutParams, str)).intValue();
            int intValue2 = ((Integer) C11124s.getField(layoutParams, "meizuFlags")).intValue();
            int i = z ? intValue | intValue2 : (intValue ^ (-1)) & intValue2;
            if (intValue2 != i) {
                C11124s.m23707a(layoutParams, "meizuFlags", Integer.valueOf(i));
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static void m29544b(Activity activity, boolean z) {
        m29547a(activity, true, true);
    }

    /* renamed from: g */
    private static void m29543g(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i = (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    private static void setStatusBarColor(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f28865Tk;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    f28865Tk.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m29546a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            m29545a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            m29543g(decorView, z);
            setStatusBarColor(window, 0);
        }
    }

    /* renamed from: a */
    private static void m29547a(Activity activity, boolean z, boolean z2) {
        Method method = f28864Tj;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z));
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return;
            }
        }
        m29546a(activity.getWindow(), z);
    }
}
