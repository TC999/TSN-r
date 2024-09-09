package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s {
    private static final Map<Class<?>, Class<?>> aQf;
    private static Map<String, Method> aQg;
    private static final HashMap<Class<?>, Class<?>> aQh;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a<T> {
        public final Class<? extends T> aPf;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        aQf = hashMap;
        aQg = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap2 = new HashMap<>();
        aQh = hashMap2;
        Class<?> cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class<?> cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class<?> cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class<?> cls4 = Long.TYPE;
        hashMap.put(Long.class, cls4);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(cls, cls);
        Class cls5 = Byte.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
        hashMap2.put(cls, Boolean.class);
        hashMap2.put(Byte.TYPE, Byte.class);
        hashMap2.put(Character.TYPE, Character.class);
        hashMap2.put(Short.TYPE, Short.class);
        hashMap2.put(cls2, Integer.class);
        hashMap2.put(cls4, Long.class);
        hashMap2.put(Double.TYPE, Double.class);
        hashMap2.put(cls3, Float.class);
        hashMap2.put(Void.TYPE, Void.class);
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            s(th);
        }
    }

    public static <T> T ap(String str, String str2) {
        try {
            return (T) aq(str, str2);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T aq(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                continue;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) f(obj, str, objArr);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) b(cls, str, objArr);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static boolean classExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    private static Object[] e(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj != null && (obj instanceof a)) {
                objArr2[i4] = ((a) obj).obj;
            } else {
                objArr2[i4] = obj;
            }
        }
        return objArr2;
    }

    public static <T> T f(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T gF(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) f(obj, str);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T h(String str, Object... objArr) {
        try {
            return (T) j(str, objArr);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null && declaredConstructors.length != 0) {
            Constructor<?> constructor = declaredConstructors[0];
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                    objArr[i4] = k(parameterTypes[i4]);
                }
                return (T) constructor.newInstance(objArr);
            }
            return (T) constructor.newInstance(new Object[0]);
        }
        throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
    }

    private static Object k(Class<?> cls) {
        if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls) && !Byte.TYPE.equals(cls) && !Byte.class.equals(cls) && !Short.TYPE.equals(cls) && !Short.class.equals(cls) && !Long.TYPE.equals(cls) && !Long.class.equals(cls) && !Double.TYPE.equals(cls) && !Double.class.equals(cls) && !Float.TYPE.equals(cls) && !Float.class.equals(cls)) {
            if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
                return Boolean.FALSE;
            }
            return (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
        }
        return 0;
    }

    private static void s(Throwable th) {
        if (!com.kwad.library.a.a.md.booleanValue()) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new RuntimeException(th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    private static boolean c(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = aQh.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = aQh.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    private static Class<?>[] d(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj != null && (obj instanceof a)) {
                cls = ((a) obj).aQi;
            } else {
                cls = obj == null ? null : obj.getClass();
            }
            clsArr[i4] = cls;
        }
        return clsArr;
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        return (T) f(cls, str, d(objArr)).invoke(null, e(objArr));
    }

    private static String e(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static <T> T f(Object obj, String str, Object... objArr) {
        return (T) f(obj.getClass(), str, d(objArr)).invoke(obj, e(objArr));
    }

    private static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(d(objArr)).newInstance(e(objArr));
    }

    private static Method f(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] declaredMethods;
        String e4 = e(cls, str, clsArr);
        synchronized (aQg) {
            method = aQg.get(e4);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            com.kwad.sdk.core.e.c.d("JavaCalls_", "in new get method from cache: key\uff1a" + e4 + " method:" + method.getName());
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z3 = true;
                                for (int i4 = 0; i4 < clsArr.length; i4++) {
                                    if (!c(clsArr[i4], parameterTypes[i4])) {
                                        z3 = false;
                                    }
                                }
                                if (z3) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (aQg) {
                    aQg.put(e4, method);
                    com.kwad.sdk.core.e.c.d("JavaCalls_", "in new get method:" + method.getName());
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) b(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }

    private static <T> T j(String str, Object... objArr) {
        return (T) b(Class.forName(str), e(objArr));
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            s(th);
            return null;
        }
    }
}
