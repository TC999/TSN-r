package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TEnumHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bw {
    public static bv a(Class<? extends bv> cls, int i4) {
        try {
            return (bv) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i4));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
