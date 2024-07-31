package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* renamed from: com.umeng.analytics.pro.bw */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TEnumHelper {
    /* renamed from: a */
    public static TEnum m14506a(Class<? extends TEnum> cls, int i) {
        try {
            return (TEnum) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
