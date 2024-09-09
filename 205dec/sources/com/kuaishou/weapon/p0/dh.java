package com.kuaishou.weapon.p0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dh {
    public static Object a(String str, String str2) {
        return a(Class.forName(str), (Object) null, str2);
    }

    public static Object a(Class<?> cls, Object obj, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object a(String str, Object obj, String str2, Object... objArr) {
        return a(Class.forName(str), obj, str2, objArr);
    }

    private static Object a(Class<?> cls, Object obj, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            clsArr = new Class[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                clsArr[i4] = objArr[i4].getClass();
            }
        } else {
            clsArr = null;
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Method a(Class cls, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            try {
                clsArr = new Class[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    clsArr[i4] = objArr[i4].getClass();
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
