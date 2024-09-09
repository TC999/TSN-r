package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gb {
    public static Method c(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> c4 = c(str);
            if (c4 != null) {
                return c4.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            a.c("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    public static Class<?> c(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, c());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, gb.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader c() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? gb.class.getClassLoader() : contextClassLoader;
    }
}
