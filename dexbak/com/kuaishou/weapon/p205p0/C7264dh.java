package com.kuaishou.weapon.p205p0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.kuaishou.weapon.p0.dh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7264dh {
    /* renamed from: a */
    public static Object m33966a(String str, String str2) {
        return m33970a(Class.forName(str), (Object) null, str2);
    }

    /* renamed from: a */
    public static Object m33970a(Class<?> cls, Object obj, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    /* renamed from: a */
    public static Object m33967a(String str, Object obj, String str2, Object... objArr) {
        return m33969a(Class.forName(str), obj, str2, objArr);
    }

    /* renamed from: a */
    private static Object m33969a(Class<?> cls, Object obj, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        } else {
            clsArr = null;
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    /* renamed from: a */
    public static Method m33968a(Class cls, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            try {
                clsArr = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
            } catch (Exception unused) {
                return null;
            }
        } else {
            clsArr = null;
        }
        return cls.getDeclaredMethod(str, clsArr);
    }
}
