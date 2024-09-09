package com.bytedance.embed_dr;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class MethodUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    private static Map<String, Method> sMethodCache = new HashMap();
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        sPrimitiveToWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] declaredMethods;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
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
                                    if (!isAssignableFrom(clsArr[i4], parameterTypes[i4])) {
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
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
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

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) {
        return (T) invokeConstructor(cls, objArr, toClass(objArr));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) {
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArr);
        }
        return null;
    }

    public static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                clsArr[i4] = objArr[i4] == null ? null : objArr[i4].getClass();
            }
            return clsArr;
        }
        return EMPTY_CLASS_ARRAY;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
        if (matchingAccessibleConstructor != null) {
            return (T) matchingAccessibleConstructor.newInstance(objArr);
        }
        return null;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) {
        return invokeStaticMethod(cls, str, objArr, toClass(objArr));
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        return invokeMethod(obj, str, objArr, toClass(objArr));
    }
}
