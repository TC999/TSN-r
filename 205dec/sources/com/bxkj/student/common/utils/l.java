package com.bxkj.student.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.acse.ottn.f3;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StatusBarUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f19643a = 0;

    private static int a(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float f4 = 1.0f - (alpha / 255.0f);
        double d4 = ((color >> 16) & 255) * f4;
        Double.isNaN(d4);
        int i4 = (int) (d4 + 0.5d);
        double d5 = ((color >> 8) & 255) * f4;
        Double.isNaN(d5);
        double d6 = (color & 255) * f4;
        Double.isNaN(d6);
        return ((int) (d6 + 0.5d)) | (i4 << 16) | (-16777216) | (((int) (d5 + 0.5d)) << 8);
    }

    @TargetApi(23)
    private static void b(Window window, boolean dark) {
        if (e()) {
            l(window, dark);
        } else if (f()) {
            m(window, dark);
        }
        c(window, dark);
    }

    @RequiresApi(23)
    private static void c(Window window, boolean dark) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(dark ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private static int d(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static boolean e() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    private static boolean f() {
        try {
            return Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod(f3.f5657f, String.class).invoke(null, "ro.miui.ui.version.name")).replaceAll("[vV]", "")) >= 6;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void g(@NonNull Activity activity, @ColorInt int color) {
        h(activity, color, 0);
    }

    public static void h(@NonNull Activity activity, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(a(color, alpha));
        } else if (i4 >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            p((ViewGroup) activity.getWindow().getDecorView(), color, alpha);
            o(activity, true);
        }
    }

    public static void i(@NonNull Activity activity) {
        b(activity.getWindow(), true);
    }

    public static void j(@NonNull Activity activity, View view) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(16908331);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        o(activity, false);
        q(activity);
        n(activity, view);
    }

    public static void k(@NonNull Activity activity) {
        b(activity.getWindow(), false);
    }

    private static void l(Window window, boolean dark) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i4 = declaredField.getInt(null);
            int i5 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, dark ? i5 | i4 : (i4 ^ (-1)) & i5);
            window.setAttributes(attributes);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    private static void m(Window window, boolean dark) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i4 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(dark ? i4 : 0);
            objArr[1] = Integer.valueOf(i4);
            method.invoke(window, objArr);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    public static void n(Context context, @NonNull View view) {
        ViewGroup.LayoutParams layoutParams;
        if (Build.VERSION.SDK_INT < 19 || (layoutParams = view.getLayoutParams()) == null || layoutParams.height <= 0 || view.getPaddingTop() != 0) {
            return;
        }
        layoutParams.height += d(context);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + d(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    private static void o(Activity activity, boolean fitSystemWindows) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(fitSystemWindows);
                ((ViewGroup) childAt).setClipToPadding(fitSystemWindows);
            }
        }
    }

    private static void p(ViewGroup viewGroup, @ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        if (Build.VERSION.SDK_INT >= 19) {
            int a4 = a(color, alpha);
            View findViewById = viewGroup.findViewById(16908331);
            if (findViewById == null && a4 != 0) {
                findViewById = new View(viewGroup.getContext());
                findViewById.setId(16908331);
                viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, d(viewGroup.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(a4);
            }
        }
    }

    public static void q(@NonNull Activity activity) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (i4 >= 19) {
            activity.getWindow().setFlags(TTAdConstant.KEY_CLICK_AREA, TTAdConstant.KEY_CLICK_AREA);
        }
    }
}
