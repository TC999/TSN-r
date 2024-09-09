package com.bytedance.sdk.openadsdk.core.eq;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class j {

    /* renamed from: c  reason: collision with root package name */
    private static Method f33265c;

    /* renamed from: w  reason: collision with root package name */
    private static Method f33266w;
    private static Method xv;

    static {
        try {
            f33265c = Class.class.getDeclaredMethod("forName", String.class);
            f33266w = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            xv = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object c(Object obj, String str, String str2, Object obj2) {
        try {
            Field c4 = c(str, str2);
            if (c4 == null) {
                return obj2;
            }
            c4.setAccessible(true);
            return c4.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field c(String str, String str2) {
        if (c()) {
            try {
                Field field = (Field) xv.invoke((Class) f33265c.invoke(null, str), str2);
                try {
                    field.setAccessible(true);
                } catch (Throwable unused) {
                }
                return field;
            } catch (Throwable unused2) {
                return null;
            }
        }
        return null;
    }

    private static boolean c() {
        return (f33265c == null || f33266w == null || xv == null) ? false : true;
    }
}
