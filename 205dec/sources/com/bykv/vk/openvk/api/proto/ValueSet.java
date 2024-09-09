package com.bykv.vk.openvk.api.proto;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ValueSet {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i4, Class<T> cls);

    boolean booleanValue(int i4);

    boolean booleanValue(int i4, boolean z3);

    boolean containsKey(int i4);

    double doubleValue(int i4);

    float floatValue(int i4);

    float floatValue(int i4, float f4);

    int intValue(int i4);

    int intValue(int i4, int i5);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i4);

    long longValue(int i4, long j4);

    <T> T objectValue(int i4, Class<T> cls);

    int size();

    String stringValue(int i4);

    String stringValue(int i4, String str);
}
