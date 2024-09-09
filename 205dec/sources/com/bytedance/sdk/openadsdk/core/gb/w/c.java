package com.bytedance.sdk.openadsdk.core.gb.w;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Field> f33709c = new HashMap();

    public static Field c(Class<?> cls, String str) {
        Field field;
        String w3 = w(cls, str);
        synchronized (f33709c) {
            field = f33709c.get(w3);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (f33709c) {
                    f33709c.put(w3, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static String w(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
    }

    public static Object c(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object c(Object obj, String str) throws IllegalAccessException {
        Field c4 = c(obj.getClass(), str);
        if (c4 != null) {
            return c(c4, obj);
        }
        return null;
    }
}
