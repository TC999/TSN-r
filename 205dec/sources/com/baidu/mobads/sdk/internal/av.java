package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    static bv f12427a = bv.a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f12428b = "com.baidu.mobads.sdk.internal.av";

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e4) {
                f12427a.a(f12428b, Log.getStackTraceString(e4));
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e4) {
                f12427a.b(f12428b, Log.getStackTraceString(e4));
            }
        }
        return null;
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> a4 = a(str, classLoader);
            if (a4 != null) {
                Method declaredMethod = a4.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
            return null;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e4) {
                f12427a.b(f12428b, Log.getStackTraceString(e4));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return false;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field b4 = b(obj, str);
        if (b4 != null) {
            b4.setAccessible(true);
            try {
                return b4.get(obj);
            } catch (Exception e4) {
                f12427a.b(f12428b, Log.getStackTraceString(e4));
                return null;
            }
        }
        return null;
    }

    public static Object a(Class cls, String str) {
        Field b4 = b((Class<?>) cls, str);
        if (b4 != null) {
            b4.setAccessible(true);
            try {
                return b4.get(cls);
            } catch (Exception e4) {
                f12427a.b(f12428b, Log.getStackTraceString(e4));
                return null;
            }
        }
        return null;
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i4 = 0; i4 < length; i4++) {
                clsArr[i4] = objArr[i4].getClass();
            }
            return clsArr;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a4 = a(str, classLoader);
            if (a4 != null) {
                return a4.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a4 = a(str);
            if (a4 != null) {
                return a4.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> a4 = a(str, classLoader);
        if (a4 != null) {
            return Proxy.newProxyInstance(a4.getClassLoader(), new Class[]{a4}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class<?> a4 = a(str);
        if (a4 != null) {
            return Proxy.newProxyInstance(a4.getClassLoader(), new Class[]{a4}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a4 = a(str, classLoader);
            if (a4 == null || (declaredMethod = a4.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a4 = a(str);
            if (a4 == null || (declaredMethod = a4.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e4) {
            f12427a.b(f12428b, Log.getStackTraceString(e4));
            return null;
        }
    }

    public static ClassLoader a(Context context) {
        return ao.a(cb.a(context), context.getFilesDir().getAbsolutePath(), (String) null, av.class.getClassLoader());
    }
}
