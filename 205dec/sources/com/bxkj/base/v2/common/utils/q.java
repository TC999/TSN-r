package com.bxkj.base.v2.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ReflectionUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class q {
    public static Class<?> a(Type type) throws ClassNotFoundException {
        String b4 = b(type);
        if (b4 == null || b4.isEmpty()) {
            return null;
        }
        return Class.forName(b4);
    }

    public static String b(Type type) {
        if (type == null) {
            return "";
        }
        String obj = type.toString();
        return obj.startsWith("class") ? obj.substring(5) : obj;
    }

    public static Type c(Object obj) {
        return obj.getClass().getGenericInterfaces()[0];
    }

    public static Type d(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (ParameterizedType.class.isAssignableFrom(genericSuperclass.getClass())) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
        return null;
    }

    public static boolean e(Class<?> cls) throws SecurityException {
        try {
            cls.getConstructor(new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static Object f(Type type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> a4 = a(type);
        if (a4 == null) {
            return null;
        }
        return a4.newInstance();
    }
}
