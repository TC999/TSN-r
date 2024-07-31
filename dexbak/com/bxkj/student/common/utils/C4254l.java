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
import androidx.core.view.ViewCompat;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* compiled from: StatusBarUtil.java */
/* renamed from: com.bxkj.student.common.utils.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C4254l {

    /* renamed from: a */
    private static final int f16241a = 0;

    /* renamed from: a */
    private static int m42817a(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float f = 1.0f - (alpha / 255.0f);
        double d = ((color >> 16) & 255) * f;
        Double.isNaN(d);
        int i = (int) (d + 0.5d);
        double d2 = ((color >> 8) & 255) * f;
        Double.isNaN(d2);
        double d3 = (color & 255) * f;
        Double.isNaN(d3);
        return ((int) (d3 + 0.5d)) | (i << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) (d2 + 0.5d)) << 8);
    }

    @TargetApi(23)
    /* renamed from: b */
    private static void m42816b(Window window, boolean dark) {
        if (m42813e()) {
            m42806l(window, dark);
        } else if (m42812f()) {
            m42805m(window, dark);
        }
        m42815c(window, dark);
    }

    @RequiresApi(23)
    /* renamed from: c */
    private static void m42815c(Window window, boolean dark) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(dark ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    /* renamed from: d */
    private static int m42814d(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: e */
    private static boolean m42813e() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    /* renamed from: f */
    private static boolean m42812f() {
        try {
            return Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.miui.ui.version.name")).replaceAll("[vV]", "")) >= 6;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: g */
    public static void m42811g(@NonNull Activity activity, @ColorInt int color) {
        m42810h(activity, color, 0);
    }

    /* renamed from: h */
    public static void m42810h(@NonNull Activity activity, @ColorInt int color, @IntRange(from = 0, m60035to = 255) int alpha) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(m42817a(color, alpha));
        } else if (i >= 19) {
            activity.getWindow().addFlags(67108864);
            m42802p((ViewGroup) activity.getWindow().getDecorView(), color, alpha);
            m42803o(activity, true);
        }
    }

    /* renamed from: i */
    public static void m42809i(@NonNull Activity activity) {
        m42816b(activity.getWindow(), true);
    }

    /* renamed from: j */
    public static void m42808j(@NonNull Activity activity, View view) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(16908331);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        m42803o(activity, false);
        m42801q(activity);
        m42804n(activity, view);
    }

    /* renamed from: k */
    public static void m42807k(@NonNull Activity activity) {
        m42816b(activity.getWindow(), false);
    }

    /* renamed from: l */
    private static void m42806l(Window window, boolean dark) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, dark ? i2 | i : (i ^ (-1)) & i2);
            window.setAttributes(attributes);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    /* renamed from: m */
    private static void m42805m(Window window, boolean dark) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(dark ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    /* renamed from: n */
    public static void m42804n(Context context, @NonNull View view) {
        ViewGroup.LayoutParams layoutParams;
        if (Build.VERSION.SDK_INT < 19 || (layoutParams = view.getLayoutParams()) == null || layoutParams.height <= 0 || view.getPaddingTop() != 0) {
            return;
        }
        layoutParams.height += m42814d(context);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + m42814d(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    /* renamed from: o */
    private static void m42803o(Activity activity, boolean fitSystemWindows) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(fitSystemWindows);
                ((ViewGroup) childAt).setClipToPadding(fitSystemWindows);
            }
        }
    }

    /* renamed from: p */
    private static void m42802p(ViewGroup viewGroup, @ColorInt int color, @IntRange(from = 0, m60035to = 255) int alpha) {
        if (Build.VERSION.SDK_INT >= 19) {
            int m42817a = m42817a(color, alpha);
            View findViewById = viewGroup.findViewById(16908331);
            if (findViewById == null && m42817a != 0) {
                findViewById = new View(viewGroup.getContext());
                findViewById.setId(16908331);
                viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, m42814d(viewGroup.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(m42817a);
            }
        }
    }

    /* renamed from: q */
    public static void m42801q(@NonNull Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
        } else if (i >= 19) {
            activity.getWindow().setFlags(67108864, 67108864);
        }
    }
}
