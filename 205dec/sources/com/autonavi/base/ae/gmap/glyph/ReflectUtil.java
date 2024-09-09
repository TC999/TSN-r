package com.autonavi.base.ae.gmap.glyph;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ReflectUtil {
    public static Object getField(String str, Object obj, String str2) {
        if (str != null && !str.equals("")) {
            if (str2 != null && !str2.equals("")) {
                try {
                    Field declaredField = Class.forName(str).getDeclaredField(str2);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            throw new IllegalArgumentException("fieldName \u4e0d\u80fd\u4e3a\u7a7a");
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static Object getInstance(String str, Object... objArr) {
        if (str != null && !str.equals("")) {
            try {
                Class<?> cls = Class.forName(str);
                if (objArr != null) {
                    int length = objArr.length;
                    Class<?>[] clsArr = new Class[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        clsArr[i4] = objArr[i4].getClass();
                    }
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(objArr);
                }
                Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor2.setAccessible(true);
                return declaredConstructor2.newInstance(new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        if (str != null && !str.equals("")) {
            if (str2 != null && !str2.equals("")) {
                try {
                    return Class.forName(str).getDeclaredMethod(str2, clsArr);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            throw new IllegalArgumentException("methodName\u4e0d\u80fd\u4e3a\u7a7a");
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static Object invoke(String str, Object obj, String str2, Object... objArr) {
        if (str != null && !str.equals("")) {
            if (str2 != null && !str2.equals("")) {
                try {
                    Class<?> cls = Class.forName(str);
                    if (objArr != null) {
                        int length = objArr.length;
                        Class<?>[] clsArr = new Class[length];
                        for (int i4 = 0; i4 < length; i4++) {
                            clsArr[i4] = objArr[i4].getClass();
                        }
                        Method declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                        declaredMethod.setAccessible(true);
                        return declaredMethod.invoke(obj, objArr);
                    }
                    Method declaredMethod2 = cls.getDeclaredMethod(str2, new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return declaredMethod2.invoke(obj, new Object[0]);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            throw new IllegalArgumentException("methodName\u4e0d\u80fd\u4e3a\u7a7a");
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static Object invokeMethod(Object obj, Method method, Object... objArr) {
        if (method != null) {
            method.setAccessible(true);
            try {
                return method.invoke(obj, objArr);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("method \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static Object newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
        if (str != null && !str.equals("")) {
            try {
                Class<?> cls = Class.forName(str);
                if (clsArr != null) {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(objArr);
                }
                Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor2.setAccessible(true);
                return declaredConstructor2.newInstance(new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }

    public static void setField(String str, Object obj, String str2, Object obj2) {
        if (str != null && !str.equals("")) {
            if (str2 != null && !str2.equals("")) {
                try {
                    Field declaredField = Class.forName(str).getDeclaredField(str2);
                    declaredField.setAccessible(true);
                    declaredField.set(obj, obj2);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            throw new IllegalArgumentException("fieldName \u4e0d\u80fd\u4e3a\u7a7a");
        }
        throw new IllegalArgumentException("className \u4e0d\u80fd\u4e3a\u7a7a");
    }
}
