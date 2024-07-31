package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.analytics.pro.cd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FieldMetaData implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends TBase>, Map<? extends TFieldIdEnum, FieldMetaData>> f37967d = new HashMap();

    /* renamed from: a */
    public final String f37968a;

    /* renamed from: b */
    public final byte f37969b;

    /* renamed from: c */
    public final FieldValueMetaData f37970c;

    public FieldMetaData(String str, byte b, FieldValueMetaData fieldValueMetaData) {
        this.f37968a = str;
        this.f37969b = b;
        this.f37970c = fieldValueMetaData;
    }

    /* renamed from: a */
    public static void m14474a(Class<? extends TBase> cls, Map<? extends TFieldIdEnum, FieldMetaData> map) {
        f37967d.put(cls, map);
    }

    /* renamed from: a */
    public static Map<? extends TFieldIdEnum, FieldMetaData> m14475a(Class<? extends TBase> cls) {
        if (!f37967d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (InstantiationException e2) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return f37967d.get(cls);
    }
}
