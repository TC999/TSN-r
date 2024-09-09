package com.autonavi.aps.amapapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Reflect.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {
    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static int b(String str, String str2) throws Exception {
        return ((Integer) a(str, str2)).intValue();
    }

    public static int b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) a(obj, str, objArr)).intValue();
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return a(Class.forName(str), str2, objArr, clsArr);
    }

    private static Object a(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static Object a(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            clsArr[i4] = objArr[i4].getClass();
            if (clsArr[i4] == Integer.class) {
                clsArr[i4] = Integer.TYPE;
            }
            if (clsArr[i4] == Boolean.class) {
                clsArr[i4] = Boolean.TYPE;
            }
            if (clsArr[i4] == Double.class) {
                clsArr[i4] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            try {
                if (th instanceof InvocationTargetException) {
                    b.a(th.getTargetException(), "Reflect", "invokeMethod ".concat(String.valueOf(str)));
                    return null;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
