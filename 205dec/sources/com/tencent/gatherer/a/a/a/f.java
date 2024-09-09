package com.tencent.gatherer.a.a.a;

import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {
    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null && (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
        } catch (Exception e4) {
            d.a("invokeStaticMethod got Exception:", e4);
        }
        return null;
    }
}
