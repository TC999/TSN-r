package com.umeng.socialize.p569a;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.umeng.socialize.a.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMReflectUtils {
    /* renamed from: a */
    public static Method m13376a(String str, String str2, Class<?>... clsArr) {
        Class<?> m13379a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m13379a = m13379a(str)) == null) {
            return null;
        }
        try {
            return m13379a.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            UPLog.m13359d("", "getMethod failed, cls:", str, " method:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m13372a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            UPLog.m13359d("", "invoke failed:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m13375a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method m13376a = m13376a(str, str2, clsArr);
        if (m13376a != null) {
            return m13372a(m13376a, obj, objArr);
        }
        return null;
    }

    /* renamed from: a */
    public static Field m13378a(String str, String str2) {
        Class<?> m13379a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m13379a = m13379a(str)) == null) {
            return null;
        }
        try {
            return m13379a.getField(str2);
        } catch (Throwable th) {
            UPLog.m13359d("", "getFiled failed, cls:", str, " filed:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m13377a(String str, String str2, Object obj) {
        return m13373a(m13378a(str, str2), obj);
    }

    /* renamed from: a */
    public static Object m13373a(Field field, Object obj) {
        if (field != null) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field.get(obj);
            } catch (Throwable th) {
                UPLog.m13359d("", "getFiledValue failed:", th.getMessage());
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Object m13374a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> m13379a = m13379a(str);
        if (m13379a != null) {
            try {
                return m13379a.getConstructor(clsArr).newInstance(objArr);
            } catch (Throwable th) {
                UPLog.m13359d("", "newInstance failed, cls:", str, " msg:", th.getMessage());
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Class<?> m13379a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = UMReflectUtils.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Class.forName(str, true, UMReflectUtils.class.getClassLoader());
        }
    }
}
