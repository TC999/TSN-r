package com.bytedance.sdk.component.widget.recycler.c.xv;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static Field f30585c;
    private static Field sr;
    private static boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private static Method f30586w;
    private static boolean xv;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f30586w = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int c(View view) {
        return view.getLayoutDirection();
    }

    public static boolean ev(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean f(View view) {
        return view.hasTransientState();
    }

    public static int gd(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof w) {
            ((w) view).stopNestedScroll();
        }
    }

    public static Display r(View view) {
        return view.getDisplay();
    }

    public static int sr(View view) {
        return view.getMinimumWidth();
    }

    public static int ux(View view) {
        return view.getMinimumHeight();
    }

    public static float w(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : xv(viewConfiguration, context);
    }

    private static float xv(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f30586w) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static void c(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int w(View view) {
        return view.getImportantForAccessibility();
    }

    public static void c(View view, Runnable runnable, long j4) {
        view.postOnAnimationDelayed(runnable, j4);
    }

    public static void w(View view, int i4) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i4);
        }
    }

    public static float c(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : xv(viewConfiguration, context);
    }

    public static void c(View view, int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i4);
            return;
        }
        if (i4 == 4) {
            i4 = 2;
        }
        view.setImportantForAccessibility(i4);
    }

    public static void xv(View view) {
        view.postInvalidateOnAnimation();
    }

    public static boolean c(MotionEvent motionEvent, int i4) {
        return (motionEvent.getSource() & i4) == i4;
    }
}
