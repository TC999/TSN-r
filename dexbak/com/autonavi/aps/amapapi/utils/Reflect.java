package com.autonavi.aps.amapapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.autonavi.aps.amapapi.utils.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Reflect {
    /* renamed from: a */
    public static Object m51260a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    /* renamed from: b */
    public static int m51257b(String str, String str2) throws Exception {
        return ((Integer) m51260a(str, str2)).intValue();
    }

    /* renamed from: b */
    public static int m51258b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) m51261a(obj, str, objArr)).intValue();
    }

    /* renamed from: a */
    public static Object m51261a(Object obj, String str, Object... objArr) {
        try {
            return m51262a(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m51259a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return m51263a(Class.forName(str), str2, objArr, clsArr);
    }

    /* renamed from: a */
    private static Object m51263a(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    /* renamed from: a */
    public static Object m51262a(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
            if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
            if (clsArr[i] == Double.class) {
                clsArr[i] = Double.TYPE;
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
                    C2428b.m51299a(th.getTargetException(), "Reflect", "invokeMethod ".concat(String.valueOf(str)));
                    return null;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
