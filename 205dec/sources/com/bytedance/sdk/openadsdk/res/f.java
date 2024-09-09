package com.bytedance.sdk.openadsdk.res;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {
    public static void c(ProgressBar progressBar, Drawable drawable) {
        c(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void c(Object obj, String str, Object obj2) {
        try {
            Field c4 = c(obj, str);
            if (c4 != null) {
                c(c4);
                c4.set(obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
        } catch (Throwable unused) {
        }
    }

    private static Field c(Object obj, String str) {
        return c((Class) obj.getClass(), str);
    }

    private static Field c(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void c(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
