package com.bxkj.base.p085v2.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.bxkj.base.v2.common.utils.q */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ReflectionUtil {
    /* renamed from: a */
    public static Class<?> m43743a(Type type) throws ClassNotFoundException {
        String m43742b = m43742b(type);
        if (m43742b == null || m43742b.isEmpty()) {
            return null;
        }
        return Class.forName(m43742b);
    }

    /* renamed from: b */
    public static String m43742b(Type type) {
        if (type == null) {
            return "";
        }
        String obj = type.toString();
        return obj.startsWith("class") ? obj.substring(5) : obj;
    }

    /* renamed from: c */
    public static Type m43741c(Object obj) {
        return obj.getClass().getGenericInterfaces()[0];
    }

    /* renamed from: d */
    public static Type m43740d(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (ParameterizedType.class.isAssignableFrom(genericSuperclass.getClass())) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
        return null;
    }

    /* renamed from: e */
    public static boolean m43739e(Class<?> cls) throws SecurityException {
        try {
            cls.getConstructor(new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static Object m43738f(Type type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> m43743a = m43743a(type);
        if (m43743a == null) {
            return null;
        }
        return m43743a.newInstance();
    }
}
