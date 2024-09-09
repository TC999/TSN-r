package com.baidu.liantian;

import android.app.Activity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ReflectionUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {
    public static boolean a(Activity activity, Activity activity2) {
        Field[] declaredFields;
        if (activity == null || activity2 == null) {
            return false;
        }
        for (Class<Activity> cls = Activity.class; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (field.getName().equals("mWindow")) {
                        field.set(activity2, activity.getWindow());
                    } else {
                        field.set(activity2, field.get(activity));
                    }
                } catch (Throwable unused) {
                    com.baidu.liantian.b.e.a();
                }
            }
        }
        return true;
    }

    private static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                com.baidu.liantian.b.e.a();
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    private static Field b(Class<?> cls, String str) {
        try {
            Field field = cls.getField(str);
            if (field != null) {
                return field;
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused2) {
                com.baidu.liantian.b.e.a();
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException();
    }

    public static boolean a(Class<?> cls, Object obj, Object obj2) {
        Field[] declaredFields;
        if (obj == null || obj2 == null) {
            return false;
        }
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    field.set(obj2, field.get(obj));
                } catch (Throwable unused) {
                    com.baidu.liantian.b.e.a();
                }
            }
            cls = cls.getSuperclass();
        }
        return true;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        try {
            method = b(cls, str, clsArr);
            try {
                method.setAccessible(true);
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return method;
            }
        } catch (Throwable unused2) {
            method = null;
        }
        return method;
    }

    public static Field a(Class<?> cls, String str) {
        try {
            return b(cls, str);
        } catch (NoSuchFieldException unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }
}
