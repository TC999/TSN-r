package com.bykv.p110vk.openvk.api.proto;

import java.util.Set;

/* renamed from: com.bykv.vk.openvk.api.proto.ValueSet */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ValueSet {

    /* renamed from: com.bykv.vk.openvk.api.proto.ValueSet$ValueGetter */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i, Class<T> cls);

    boolean booleanValue(int i);

    boolean booleanValue(int i, boolean z);

    boolean containsKey(int i);

    double doubleValue(int i);

    float floatValue(int i);

    float floatValue(int i, float f);

    int intValue(int i);

    int intValue(int i, int i2);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i);

    long longValue(int i, long j);

    <T> T objectValue(int i, Class<T> cls);

    int size();

    String stringValue(int i);

    String stringValue(int i, String str);
}
