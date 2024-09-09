package com.bytedance.pangle.b.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Field> f28623a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Method> f28624b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Constructor> f28625c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private static Map<String, Class> f28626d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w("Zeus/init_pangle", "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e4) {
            ZeusLogger.errReport("Zeus/init_pangle", "HackHelperinit failed", e4);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b4 = b(cls, str, clsArr);
        synchronized (f28624b) {
            method = f28624b.get(b4);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a4 = b.a(cls, str, clsArr);
            if (a4 != null) {
                synchronized (f28624b) {
                    f28624b.put(b4, a4);
                }
            }
            return a4;
        } catch (Throwable th) {
            ZeusLogger.w("Zeus_pangle", "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b4 = b(cls, "clinit", clsArr);
        synchronized (f28625c) {
            constructor = f28625c.get(b4);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a4 = b.a(cls, clsArr);
            if (a4 != null) {
                synchronized (f28625c) {
                    f28625c.put(b4, a4);
                }
            }
            return a4;
        } catch (Throwable th) {
            ZeusLogger.w("Zeus_pangle", "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f28623a) {
            field = f28623a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a4 = b.a(cls, str);
            if (a4 != null) {
                synchronized (f28623a) {
                    f28623a.put(str2, a4);
                }
            }
            return a4;
        } catch (Throwable th) {
            ZeusLogger.w("Zeus_pangle", "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
