package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u {

    /* renamed from: c  reason: collision with root package name */
    private static Object f30228c;

    /* renamed from: w  reason: collision with root package name */
    private static Method f30229w;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            f30229w = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f30228c = ((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]);
        } catch (Throwable th) {
            a.w("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean c(String... strArr) {
        Method method;
        Object obj = f30228c;
        if (obj != null && (method = f30229w) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean c() {
        return c("L");
    }
}
