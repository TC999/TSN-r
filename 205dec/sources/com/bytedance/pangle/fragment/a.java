package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class a {
    public static void a(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) a(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field a4 = a(Fragment.class, "sClassMap");
            if (a4 != null) {
                ((SimpleArrayMap) a4.get(null)).put(cls.getName(), cls);
                return;
            }
            Class a5 = a("androidx.fragment.app.FragmentFactory");
            if (a5 == null) {
                return;
            }
            Field a6 = a(a5, "sClassMap");
            if (a6 != null) {
                ((SimpleArrayMap) a6.get(null)).put(cls.getName(), cls);
                return;
            }
            Field a7 = a(a5, "sClassCacheMap");
            if (a7 != null) {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                simpleArrayMap.put(cls.getName(), cls);
                ((SimpleArrayMap) a7.get(null)).put(cls.getClassLoader(), simpleArrayMap);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static Field a(Class cls, String str) {
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

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
