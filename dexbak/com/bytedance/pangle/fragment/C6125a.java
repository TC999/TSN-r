package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;

/* renamed from: com.bytedance.pangle.fragment.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6125a {
    /* renamed from: a */
    public static void m37144a(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) m37143a(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field m37143a = m37143a(Fragment.class, "sClassMap");
            if (m37143a != null) {
                ((SimpleArrayMap) m37143a.get(null)).put(cls.getName(), cls);
                return;
            }
            Class m37142a = m37142a("androidx.fragment.app.FragmentFactory");
            if (m37142a == null) {
                return;
            }
            Field m37143a2 = m37143a(m37142a, "sClassMap");
            if (m37143a2 != null) {
                ((SimpleArrayMap) m37143a2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field m37143a3 = m37143a(m37142a, "sClassCacheMap");
            if (m37143a3 != null) {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                simpleArrayMap.put(cls.getName(), cls);
                ((SimpleArrayMap) m37143a3.get(null)).put(cls.getClassLoader(), simpleArrayMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Field m37143a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Class m37142a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
