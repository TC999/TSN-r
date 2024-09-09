package cn.bluemobi.dylan.base.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StatusBarUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class s {
    public static boolean a(Window window, boolean z3) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i4 = declaredField.getInt(null);
                int i5 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z3 ? i5 | i4 : (i4 ^ (-1)) & i5);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean b(Window window, boolean z3) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i4 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z3) {
                    method.invoke(window, Integer.valueOf(i4), Integer.valueOf(i4));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i4));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void c(Activity activity, int i4) {
        if (i4 == 1) {
            b(activity.getWindow(), false);
        } else if (i4 == 2) {
            a(activity.getWindow(), false);
        } else if (i4 == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public static int d(Activity activity) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 19) {
            if (b(activity.getWindow(), true)) {
                return 1;
            }
            if (a(activity.getWindow(), true)) {
                return 2;
            }
            if (i4 >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8448);
                return 3;
            }
        }
        return 0;
    }

    public static void e(Activity activity, int i4) {
        if (i4 == 1) {
            b(activity.getWindow(), true);
        } else if (i4 == 2) {
            a(activity.getWindow(), true);
        } else if (i4 == 3) {
            activity.getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
        }
    }

    public static void f(Activity activity, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(i4));
        } else if (i5 >= 19) {
            g(activity);
            t tVar = new t(activity);
            tVar.m(true);
            tVar.n(i4);
        }
    }

    @TargetApi(19)
    public static void g(Activity activity) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 21) {
            if (i4 >= 19) {
                activity.getWindow().setFlags(TTAdConstant.KEY_CLICK_AREA, TTAdConstant.KEY_CLICK_AREA);
                return;
            }
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
