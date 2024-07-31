package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.library.p354a.C9585a;
import com.kwad.sdk.core.p397e.C10331c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C11124s {
    private static final Map<Class<?>, Class<?>> aPc;
    private static Map<String, Method> aPd;
    private static final HashMap<Class<?>, Class<?>> aPe;

    /* renamed from: com.kwad.sdk.utils.s$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11125a<T> {
        public final Class<? extends T> aPf;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        aPc = hashMap;
        aPd = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap2 = new HashMap<>();
        aPe = hashMap2;
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

    /* renamed from: a */
    public static void m23707a(Object obj, String str, Object obj2) {
        try {
            m23698b(obj, str, obj2);
        } catch (Throwable th) {
            m23682s(th);
        }
    }

    /* renamed from: aq */
    public static <T> T m23702aq(String str, String str2) {
        try {
            return (T) m23701ar(str, str2);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: ar */
    private static <T> T m23701ar(String str, String str2) {
        return (T) m23695d(Class.forName(str), str2);
    }

    /* renamed from: b */
    public static void m23698b(Object obj, String str, Object obj2) {
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

    /* renamed from: c */
    public static <T> T m23696c(Class<?> cls, String str) {
        try {
            return (T) m23695d(cls, str);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) m23689f(obj, str, objArr);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) m23700b(cls, str, objArr);
        } catch (Throwable th) {
            m23682s(th);
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
            C10331c.printStackTraceOnly(th);
            return false;
        }
    }

    /* renamed from: d */
    private static <T> T m23695d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    /* renamed from: e */
    private static Object[] m23692e(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof C11125a)) {
                objArr2[i] = ((C11125a) obj).obj;
            } else {
                objArr2[i] = obj;
            }
        }
        return objArr2;
    }

    /* renamed from: f */
    public static <T> T m23690f(Object obj, String str) {
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

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) m23690f(obj, str);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: gw */
    public static <T> T m23688gw(String str) {
        try {
            return (T) m23685j(Class.forName(str));
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: h */
    public static <T> T m23687h(String str, Object... objArr) {
        try {
            return (T) m23684j(str, objArr);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: i */
    public static <T> T m23686i(Class<?> cls) {
        try {
            return (T) m23685j(cls);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: j */
    private static <T> T m23685j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null && declaredConstructors.length != 0) {
            Constructor<?> constructor = declaredConstructors[0];
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    objArr[i] = m23683k(parameterTypes[i]);
                }
                return (T) constructor.newInstance(objArr);
            }
            return (T) constructor.newInstance(new Object[0]);
        }
        throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
    }

    /* renamed from: k */
    private static Object m23683k(Class<?> cls) {
        if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls) && !Byte.TYPE.equals(cls) && !Byte.class.equals(cls) && !Short.TYPE.equals(cls) && !Short.class.equals(cls) && !Long.TYPE.equals(cls) && !Long.class.equals(cls) && !Double.TYPE.equals(cls) && !Double.class.equals(cls) && !Float.TYPE.equals(cls) && !Float.class.equals(cls)) {
            if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
                return Boolean.FALSE;
            }
            return (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
        }
        return 0;
    }

    /* renamed from: s */
    private static void m23682s(Throwable th) {
        if (!C9585a.f29487md.booleanValue()) {
            C10331c.printStackTrace(th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new RuntimeException(th);
        }
    }

    public static void setStaticField(Class<?> cls, String str, Object obj) {
        try {
            m23709a(cls, str, obj);
        } catch (Throwable th) {
            m23682s(th);
        }
    }

    /* renamed from: a */
    public static void m23703a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private static boolean m23697c(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = aPe.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = aPe.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    /* renamed from: d */
    private static Class<?>[] m23694d(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof C11125a)) {
                cls = ((C11125a) obj).aPf;
            } else {
                cls = obj == null ? null : obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    /* renamed from: a */
    public static Object m23704a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: b */
    public static <T> T m23700b(Class<?> cls, String str, Object... objArr) {
        return (T) m23691f(cls, str, m23694d(objArr)).invoke(null, m23692e(objArr));
    }

    /* renamed from: e */
    private static String m23693e(Class<?> cls, String str, Class<?>... clsArr) {
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

    /* renamed from: f */
    public static <T> T m23689f(Object obj, String str, Object... objArr) {
        return (T) m23691f(obj.getClass(), str, m23694d(objArr)).invoke(obj, m23692e(objArr));
    }

    /* renamed from: b */
    private static <T> T m23699b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(m23694d(objArr)).newInstance(m23692e(objArr));
    }

    /* renamed from: f */
    private static Method m23691f(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] declaredMethods;
        String m23693e = m23693e(cls, str, clsArr);
        synchronized (aPd) {
            method = aPd.get(m23693e);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            C10331c.m26254d("JavaCalls_", "in new get method from cache: key：" + m23693e + " method:" + method.getName());
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
                                boolean z = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!m23697c(clsArr[i], parameterTypes[i])) {
                                        z = false;
                                    }
                                }
                                if (z) {
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
                synchronized (aPd) {
                    aPd.put(m23693e, method);
                    C10331c.m26254d("JavaCalls_", "in new get method:" + method.getName());
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    /* renamed from: a */
    private static void m23709a(Class<?> cls, String str, Object obj) {
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
        field.set(null, obj);
    }

    /* renamed from: j */
    private static <T> T m23684j(String str, Object... objArr) {
        return (T) m23699b(Class.forName(str), m23692e(objArr));
    }

    /* renamed from: a */
    public static <T> T m23705a(String str, String str2, Object... objArr) {
        try {
            return (T) m23700b(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m23706a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m23708a(Class<?> cls, Object... objArr) {
        try {
            return (T) m23699b(cls, objArr);
        } catch (Throwable th) {
            m23682s(th);
            return null;
        }
    }
}
