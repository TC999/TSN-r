package com.bytedance.sdk.openadsdk.ats;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w {

    /* renamed from: c  reason: collision with root package name */
    static final Map<ClassLoader, Map<String, Class>> f31507c = new HashMap();

    public static String c(Class cls) {
        try {
            if (cls.getClassLoader() == ATSApi.class.getClassLoader()) {
                ATSApi aTSApi = (ATSApi) cls.getAnnotation(ATSApi.class);
                if (aTSApi != null) {
                    return aTSApi.value();
                }
                return null;
            }
            Annotation w3 = w(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
            if (w3 == null) {
                return null;
            }
            return String.valueOf(c(w3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Annotation w(Class cls) {
        try {
            if (cls.getClassLoader() == ATSApi.class.getClassLoader()) {
                return cls.getAnnotation(ATSApi.class);
            }
            return w(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class xv(Class cls) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return ATSMethod.class;
        }
        return c(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
    }

    private static Annotation w(Class cls, String str) {
        Class<? extends Annotation> c4 = c(cls, str);
        if (c4 != null) {
            return cls.getAnnotation(c4);
        }
        return null;
    }

    public static Annotation c(Class cls, Method method) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return method.getAnnotation(ATSMethod.class);
        }
        Class<? extends Annotation> c4 = c(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
        if (c4 == null) {
            return null;
        }
        return method.getAnnotation(c4);
    }

    private static Class<? extends Annotation> c(Class cls, String str) {
        Class<? extends Annotation> cls2;
        try {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                return null;
            }
            Map<String, Class> map = f31507c.get(classLoader);
            if (map == null) {
                map = new HashMap<>(8);
                cls2 = null;
            } else {
                cls2 = map.get(str);
            }
            if (cls2 != null) {
                return cls2;
            }
            Class loadClass = classLoader.loadClass(str);
            if (loadClass != null) {
                map.put(str, loadClass);
            }
            return loadClass;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object c(Annotation annotation) {
        try {
            Method method = annotation.getClass().getMethod("value", new Class[0]);
            if (method == null) {
                return null;
            }
            return method.invoke(annotation, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
