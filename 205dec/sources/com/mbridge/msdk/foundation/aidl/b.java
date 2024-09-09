package com.mbridge.msdk.foundation.aidl;

import java.lang.reflect.Method;

/* compiled from: ReflectUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static Object a(String str, Object obj, String str2, Object... objArr) {
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            try {
                Class<?> cls = Class.forName(str);
                if (objArr != null && objArr.length > 0) {
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
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }
}
