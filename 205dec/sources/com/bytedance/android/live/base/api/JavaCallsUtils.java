package com.bytedance.android.live.base.api;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class JavaCallsUtils {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t3) {
            this.clazz = cls;
            this.obj = t3;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_MAP = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class cls4 = Long.TYPE;
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
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj, e4);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) {
        return (T) getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T callStaticMethod(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e4);
            return null;
        }
    }

    public static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) {
        return (T) getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodOrThrow(String str, String str2, Object... objArr) {
        return (T) getDeclaredMethod(Class.forName(str), str2, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodWithClassLoader(String str, String str2, ClassLoader classLoader, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str, true, classLoader), str2, objArr);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e4);
            return null;
        }
    }

    private static boolean compareClassLists(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i4 = 0; i4 < clsArr.length; i4++) {
                if (!clsArr[i4].isAssignableFrom(clsArr2[i4])) {
                    Map<Class<?>, Class<?>> map = PRIMITIVE_MAP;
                    if (!map.containsKey(clsArr[i4]) || !map.get(clsArr[i4]).equals(map.get(clsArr2[i4]))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    private static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method findMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
        if (findMethodByName != null) {
            findMethodByName.setAccessible(true);
            return findMethodByName;
        } else if (cls.getSuperclass() != null) {
            return getDeclaredMethod(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    private static Object getDefaultValue(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) getFieldOrThrow(obj, str);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static <T> T getFieldOrThrow(Object obj, String str) {
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

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj == null || !(obj instanceof JavaParam)) {
                clsArr[i4] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i4] = ((JavaParam) obj).clazz;
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj == null || !(obj instanceof JavaParam)) {
                objArr2[i4] = obj;
            } else {
                objArr2[i4] = ((JavaParam) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T newEmptyInstance(Class<?> cls) {
        try {
            return (T) newEmptyInstanceOrThrow(cls);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when make instance as a " + cls.getSimpleName(), e4);
            return null;
        }
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
            objArr[i4] = getDefaultValue(parameterTypes[i4]);
        }
        return (T) constructor.newInstance(objArr);
    }

    public static <T> T newInstance(Class<?> cls, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when make instance as a " + cls.getSimpleName(), e4);
            return null;
        }
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (Exception e4) {
            Log.w("JavaCalls", "Meet exception when make instance as a " + str, e4);
            return null;
        }
    }

    public static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) {
        Constructor<?> constructor = cls.getConstructor(getParameterTypes(objArr));
        constructor.setAccessible(true);
        return (T) constructor.newInstance(getParameters(objArr));
    }

    public static Object newInstanceOrThrow(String str, Object... objArr) {
        return newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
    }

    public static void setFieldOrThrow(Object obj, String str, Object obj2) {
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
}
