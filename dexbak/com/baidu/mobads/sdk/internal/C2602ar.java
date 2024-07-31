package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.mobads.sdk.internal.ar */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2602ar {

    /* renamed from: c */
    private static volatile Map<String, C2602ar> f8608c = new HashMap();

    /* renamed from: a */
    private Class<?> f8609a;

    /* renamed from: b */
    private Method[] f8610b;

    private C2602ar(Context context, String str) {
        this.f8610b = null;
        try {
            Class<?> cls = Class.forName(str, true, C2632br.m50753a(context));
            this.f8609a = cls;
            this.f8610b = cls.getMethods();
        } catch (Throwable th) {
            C2634bs.m50744a().m50738a(th);
        }
    }

    /* renamed from: a */
    public static C2602ar m50968a(Context context, String str) {
        if (!f8608c.containsKey(str) || f8608c.get(str).f8609a == null) {
            synchronized (C2602ar.class) {
                if (!f8608c.containsKey(str) || f8608c.get(str).f8609a == null) {
                    f8608c.put(str, new C2602ar(context, str));
                }
            }
        }
        return f8608c.get(str);
    }

    /* renamed from: b */
    public Object m50964b(Object obj, String str, Object... objArr) {
        try {
            Method m50966a = m50966a(str);
            if (m50966a != null) {
                if (objArr != null && objArr.length != 0) {
                    return m50966a.invoke(obj, objArr);
                }
                return m50966a.invoke(obj, new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            C2634bs.m50744a().m50738a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:5:0x0008, B:8:0x000c, B:10:0x0018, B:12:0x001c, B:9:0x0011), top: B:18:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m50963c(java.lang.Object r2, java.lang.String r3, java.lang.Object... r4) {
        /*
            r1 = this;
            java.lang.reflect.Method r3 = r1.m50966a(r3)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L27
            if (r4 == 0) goto L11
            int r0 = r4.length     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto Lc
            goto L11
        Lc:
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L1f
            goto L18
        L11:
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L1f
        L18:
            boolean r3 = r2 instanceof java.lang.String     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L27
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1f
            return r2
        L1f:
            r2 = move-exception
            com.baidu.mobads.sdk.internal.bs r3 = com.baidu.mobads.sdk.internal.C2634bs.m50744a()
            r3.m50738a(r2)
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.C2602ar.m50963c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    /* renamed from: a */
    public Object m50965a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f8609a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                C2634bs.m50744a().m50738a(th);
                return null;
            }
        }
        constructor = this.f8609a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    /* renamed from: a */
    public void m50967a(Object obj, String str, Object... objArr) {
        try {
            Method m50966a = m50966a(str);
            if (m50966a != null) {
                if (objArr != null && objArr.length != 0) {
                    m50966a.invoke(obj, objArr);
                }
                m50966a.invoke(obj, new Object[0]);
            }
        } catch (Throwable th) {
            C2634bs.m50744a().m50738a(th);
        }
    }

    /* renamed from: a */
    private Method m50966a(String str) {
        Method[] methodArr = this.f8610b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
