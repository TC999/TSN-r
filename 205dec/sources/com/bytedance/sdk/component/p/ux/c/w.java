package com.bytedance.sdk.component.p.ux.c;

import com.bytedance.sdk.component.p.ux.c.c.ev;
import com.bytedance.sdk.component.p.ux.c.c.f;
import com.bytedance.sdk.component.p.ux.c.c.r;
import com.bytedance.sdk.component.p.ux.c.c.sr;
import com.bytedance.sdk.component.p.ux.c.c.ux;
import com.bytedance.sdk.component.p.ux.c.c.xv;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class, c> f29965c;

    static {
        HashMap hashMap = new HashMap();
        f29965c = hashMap;
        f fVar = new f();
        ev evVar = new ev();
        r rVar = new r();
        com.bytedance.sdk.component.p.ux.c.c.w wVar = new com.bytedance.sdk.component.p.ux.c.c.w();
        sr srVar = new sr();
        ux uxVar = new ux();
        com.bytedance.sdk.component.p.ux.c.c.c cVar = new com.bytedance.sdk.component.p.ux.c.c.c();
        xv xvVar = new xv();
        hashMap.put(Integer.class, fVar);
        hashMap.put(Integer.TYPE, fVar);
        hashMap.put(Short.class, evVar);
        hashMap.put(Short.TYPE, evVar);
        hashMap.put(Long.class, rVar);
        hashMap.put(Long.TYPE, rVar);
        hashMap.put(Byte.class, wVar);
        hashMap.put(Byte.TYPE, wVar);
        hashMap.put(Double.class, srVar);
        hashMap.put(Double.TYPE, srVar);
        hashMap.put(Float.class, uxVar);
        hashMap.put(Float.TYPE, uxVar);
        hashMap.put(Boolean.class, cVar);
        hashMap.put(Boolean.TYPE, cVar);
        hashMap.put(Character.class, xvVar);
        hashMap.put(Character.TYPE, xvVar);
    }

    public static void c(Object obj, Field field, Object obj2) {
        Object c4;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            c4 = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            c4 = c(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, c4);
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void c(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            c(obj, field, obj2);
        }
    }

    public static Object c(Class cls, Object obj) {
        c cVar = f29965c.get(cls);
        return cVar == null ? obj : cVar.c(cls, String.valueOf(obj));
    }
}
