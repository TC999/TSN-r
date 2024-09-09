package cn.jiguang.f;

import android.app.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {
    public static Application a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(b(), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        a(obj);
        a(clsArr, objArr);
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void a(Class<?>[] clsArr, Object[] objArr) {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }

    public static Object b() {
        Object d4 = d();
        return d4 != null ? d4 : e();
    }

    public static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReflectUtils", "getCurrentProcessNameByActivityThread: " + th.getMessage());
            return null;
        }
    }

    private static Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReflectUtils", "getActivityThreadInActivityThreadStaticField: " + th.getMessage());
            return null;
        }
    }

    private static Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReflectUtils", "getActivityThreadInActivityThreadStaticMethod: " + th.getMessage());
            return null;
        }
    }
}
