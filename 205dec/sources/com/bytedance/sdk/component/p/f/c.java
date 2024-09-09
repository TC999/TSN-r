package com.bytedance.sdk.component.p.f;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    private c() {
    }

    public static c c() {
        if (w.f29960c != null) {
            return w.f29960c;
        }
        synchronized (c.class) {
            if (w.f29960c != null) {
                return w.f29960c;
            }
            w.f29960c = new c();
            return w.f29960c;
        }
    }

    public com.bytedance.sdk.component.p.c.c.c c(com.bytedance.sdk.component.p.c.c.c cVar) {
        try {
            Class<?> cls = cVar.getClass();
            return (cls.isAnnotationPresent(com.bytedance.sdk.component.p.w.w.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.p.w.w) cls.getAnnotation(com.bytedance.sdk.component.p.w.w.class)).c())) ? (com.bytedance.sdk.component.p.c.c.c) cls.newInstance() : cVar;
        } catch (Throwable unused) {
            return cVar;
        }
    }

    public void c(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.p.w.w.class)) {
            c(obj, map, cls);
        }
    }

    private static void c(Object obj, Map<String, Object> map, Class<?> cls) {
        Field[] c4;
        com.bytedance.sdk.component.p.w.c cVar;
        for (Field field : c(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.p.w.c.class) && (cVar = (com.bytedance.sdk.component.p.w.c) field.getAnnotation(com.bytedance.sdk.component.p.w.c.class)) != null) {
                field.setAccessible(true);
                String c5 = cVar.c();
                if (TextUtils.isEmpty(c5)) {
                    c5 = com.bytedance.sdk.component.p.ev.c.c(field.getName(), true);
                }
                if (!TextUtils.isEmpty(c5)) {
                    com.bytedance.sdk.component.p.ux.c.w.c(obj, map, field, c5);
                }
            }
        }
    }

    public static Field[] c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
