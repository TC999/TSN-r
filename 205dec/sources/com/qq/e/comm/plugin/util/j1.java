package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j1 {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e4) {
            d1.a(e4.toString(), new Object[0]);
            return null;
        }
    }

    public static Object a(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (InstantiationException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static Method a(Class cls, String str, boolean z3, Class... clsArr) {
        Method method = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            method = z3 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            return method;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return method;
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return a(cls, str, true, clsArr);
    }

    public static Object a(Object obj, Method method, boolean z3, Object... objArr) {
        if (obj == null || method == null) {
            return null;
        }
        if (!z3) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        return a(obj, method, true, objArr);
    }

    public static Field a(Class cls, String str, boolean z3) {
        Field field = null;
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            field = z3 ? cls.getField(str) : cls.getDeclaredField(str);
            return field;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return field;
        }
    }

    public static Field a(Class cls, String str) {
        return a(cls, str, true);
    }

    public static boolean a(Class cls, String str, Object obj, boolean z3, Object obj2) throws a {
        Field a4 = a(cls, str, z3);
        if (a4 != null) {
            if (a(a4, obj, z3, obj2)) {
                return true;
            }
            throw new a("Set field failed");
        }
        throw new a("Field is null");
    }

    public static boolean a(Field field, Object obj, boolean z3, Object obj2) {
        if (field != null && obj != null) {
            if (!z3) {
                try {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                }
            }
            field.set(obj, obj2);
            return true;
        }
        return false;
    }

    public static boolean a(Field field, Object obj, Object obj2) {
        return a(field, obj, true, obj2);
    }
}
