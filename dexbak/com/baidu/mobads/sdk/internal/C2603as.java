package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.baidu.mobads.sdk.internal.as */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2603as {

    /* renamed from: a */
    static C2634bs f8611a = C2634bs.m50744a();

    /* renamed from: b */
    private static final String f8612b = "com.baidu.mobads.sdk.internal.as";

    /* renamed from: a */
    public static Class<?> m50953a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e) {
                f8611a.m50740a(f8612b, Log.getStackTraceString(e));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Field m50942b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
                f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Class<?> m50954a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50952a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> m50953a = m50953a(str, classLoader);
            if (m50953a != null) {
                Method declaredMethod = m50953a.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
            return null;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: b */
    public static Field m50944b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
                f8611a.m50735b(f8612b, Log.getStackTraceString(e));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m50959a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return false;
        }
    }

    /* renamed from: b */
    public static Method m50943b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50957a(Object obj, String str) {
        Field m50942b = m50942b(obj, str);
        if (m50942b != null) {
            m50942b.setAccessible(true);
            try {
                return m50942b.get(obj);
            } catch (Exception e) {
                f8611a.m50735b(f8612b, Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Object m50960a(Class cls, String str) {
        Field m50944b = m50944b((Class<?>) cls, str);
        if (m50944b != null) {
            m50944b.setAccessible(true);
            try {
                return m50944b.get(cls);
            } catch (Exception e) {
                f8611a.m50735b(f8612b, Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Object m50955a(Object obj, String str, Object... objArr) {
        try {
            return m50961a(obj.getClass(), obj, str, m50945a(objArr), objArr);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?>[] m50945a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return clsArr;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50956a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return m50961a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50961a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (m50959a(cls, str, clsArr)) {
                return m50943b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50950a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> m50953a = m50953a(str, classLoader);
            if (m50953a != null) {
                return m50953a.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50946a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> m50954a = m50954a(str);
            if (m50954a != null) {
                return m50954a.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50951a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> m50953a = m50953a(str, classLoader);
        if (m50953a != null) {
            return Proxy.newProxyInstance(m50953a.getClassLoader(), new Class[]{m50953a}, invocationHandler);
        }
        return null;
    }

    /* renamed from: a */
    public static Object m50947a(String str, InvocationHandler invocationHandler) {
        Class<?> m50954a = m50954a(str);
        if (m50954a != null) {
            return Proxy.newProxyInstance(m50954a.getClassLoader(), new Class[]{m50954a}, invocationHandler);
        }
        return null;
    }

    /* renamed from: a */
    public static Object m50949a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> m50953a = m50953a(str, classLoader);
            if (m50953a == null || (declaredMethod = m50953a.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50948a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> m50954a = m50954a(str);
            if (m50954a == null || (declaredMethod = m50954a.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static Object m50958a(ClassLoader classLoader, String str, String str2) {
        try {
            return m50960a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e) {
            f8611a.m50735b(f8612b, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    public static ClassLoader m50962a(Context context) {
        return C2598ao.m50987a(C2640by.m50705a(context), context.getFilesDir().getAbsolutePath(), (String) null, C2603as.class.getClassLoader());
    }
}
