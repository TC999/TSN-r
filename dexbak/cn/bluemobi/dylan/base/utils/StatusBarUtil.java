package cn.bluemobi.dylan.base.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: cn.bluemobi.dylan.base.utils.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class StatusBarUtil {
    /* renamed from: a */
    public static boolean m57694a(Window window, boolean z) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (i ^ (-1)) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m57693b(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: c */
    public static void m57692c(Activity activity, int i) {
        if (i == 1) {
            m57693b(activity.getWindow(), false);
        } else if (i == 2) {
            m57694a(activity.getWindow(), false);
        } else if (i == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* renamed from: d */
    public static int m57691d(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (m57693b(activity.getWindow(), true)) {
                return 1;
            }
            if (m57694a(activity.getWindow(), true)) {
                return 2;
            }
            if (i >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8448);
                return 3;
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static void m57690e(Activity activity, int i) {
        if (i == 1) {
            m57693b(activity.getWindow(), true);
        } else if (i == 2) {
            m57694a(activity.getWindow(), true);
        } else if (i == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    /* renamed from: f */
    public static void m57689f(Activity activity, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(i));
        } else if (i2 >= 19) {
            m57688g(activity);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
            systemBarTintManager.m57675m(true);
            systemBarTintManager.m57674n(i);
        }
    }

    @TargetApi(19)
    /* renamed from: g */
    public static void m57688g(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            if (i >= 19) {
                activity.getWindow().setFlags(67108864, 67108864);
                return;
            }
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
