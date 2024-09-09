package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FieldMetaData.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class cd implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends br>, Map<? extends by, cd>> f52753d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f52754a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f52755b;

    /* renamed from: c  reason: collision with root package name */
    public final ce f52756c;

    public cd(String str, byte b4, ce ceVar) {
        this.f52754a = str;
        this.f52755b = b4;
        this.f52756c = ceVar;
    }

    public static void a(Class<? extends br> cls, Map<? extends by, cd> map) {
        f52753d.put(cls, map);
    }

    public static Map<? extends by, cd> a(Class<? extends br> cls) {
        if (!f52753d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e4.getMessage());
            } catch (InstantiationException e5) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e5.getMessage());
            }
        }
        return f52753d.get(cls);
    }
}
