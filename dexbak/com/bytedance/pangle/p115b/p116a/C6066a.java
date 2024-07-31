package com.bytedance.pangle.p115b.p116a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.pangle.b.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6066a {

    /* renamed from: a */
    private static Map<String, Field> f21854a = new HashMap();

    /* renamed from: b */
    private static Map<String, Method> f21855b = new HashMap();

    /* renamed from: c */
    private static Map<String, Constructor> f21856c = new HashMap();

    /* renamed from: d */
    private static Map<String, Class> f21857d = new HashMap();

    static {
        try {
            FieldUtils.writeField(C6067b.class, "classLoader", (Object) null);
            ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    /* renamed from: a */
    public static Method m37265a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String m37263b = m37263b(cls, str, clsArr);
        synchronized (f21855b) {
            method = f21855b.get(m37263b);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method m37261a = C6067b.m37261a(cls, str, clsArr);
            if (m37261a != null) {
                synchronized (f21855b) {
                    f21855b.put(m37263b, m37261a);
                }
            }
            return m37261a;
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    /* renamed from: b */
    private static String m37263b(Class<?> cls, String str, Class<?>... clsArr) {
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

    /* renamed from: a */
    public static Constructor m37264a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String m37263b = m37263b(cls, "clinit", clsArr);
        synchronized (f21856c) {
            constructor = f21856c.get(m37263b);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor m37260a = C6067b.m37260a(cls, clsArr);
            if (m37260a != null) {
                synchronized (f21856c) {
                    f21856c.put(m37263b, m37260a);
                }
            }
            return m37260a;
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    /* renamed from: a */
    public static Field m37266a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f21854a) {
            field = f21854a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field m37262a = C6067b.m37262a(cls, str);
            if (m37262a != null) {
                synchronized (f21854a) {
                    f21854a.put(str2, m37262a);
                }
            }
            return m37262a;
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
