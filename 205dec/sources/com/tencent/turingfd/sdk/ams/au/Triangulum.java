package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Triangulum {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f52176a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f52177b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Method>> f52178c = new HashMap<>();

    public static Object a(String str, String str2) {
        try {
            Class<?> cls = f52176a.get(str);
            if (cls == null) {
                cls = Class.forName(str);
            }
            f52176a.put(str, cls);
            return a(cls, str2, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #2 {all -> 0x003c, blocks: (B:20:0x0037, B:5:0x0004, B:7:0x000e, B:8:0x0018, B:10:0x0020, B:13:0x0027), top: B:25:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(java.lang.Class<?> r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            goto L33
        L4:
            java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.reflect.Field>> r1 = com.tencent.turingfd.sdk.ams.au.Triangulum.f52177b     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L2f
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L2f
            if (r1 != 0) goto L18
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L2f
            r1.<init>()     // Catch: java.lang.Throwable -> L2f
            java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.reflect.Field>> r2 = com.tencent.turingfd.sdk.ams.au.Triangulum.f52177b     // Catch: java.lang.Throwable -> L2f
            r2.put(r3, r1)     // Catch: java.lang.Throwable -> L2f
        L18:
            java.lang.Object r2 = r1.get(r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L24
            java.lang.reflect.Field r2 = r3.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L2f
        L24:
            if (r2 != 0) goto L27
            goto L33
        L27:
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Throwable -> L2f
            r1.put(r4, r2)     // Catch: java.lang.Throwable -> L2f
            goto L34
        L2f:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3c
        L33:
            r2 = r0
        L34:
            if (r2 != 0) goto L37
            return r0
        L37:
            java.lang.Object r3 = r2.get(r5)     // Catch: java.lang.Throwable -> L3c
            return r3
        L3c:
            r3 = move-exception
            r3.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Triangulum.a(java.lang.Class, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer(str);
                    if (clsArr != null) {
                        for (Class<?> cls2 : clsArr) {
                            stringBuffer.append("+");
                            stringBuffer.append(cls2.getName());
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    HashMap<String, Method> hashMap = f52178c.get(cls);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                        f52178c.put(cls, hashMap);
                    }
                    Method method = hashMap.get(stringBuffer2);
                    if (method == null) {
                        method = cls.getDeclaredMethod(str, clsArr);
                    }
                    if (method == null) {
                        return null;
                    }
                    method.setAccessible(true);
                    hashMap.put(stringBuffer2, method);
                    return method;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
