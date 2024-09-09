package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gb {

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<HashMap> f33688c = new SparseArray<>();

    public static <T> void c(String str, T t3) {
        if (t3 == null) {
            return;
        }
        int hashCode = t3.getClass().hashCode();
        SparseArray<HashMap> sparseArray = f33688c;
        HashMap hashMap = sparseArray.get(hashCode);
        if (hashMap == null) {
            hashMap = new HashMap();
            sparseArray.put(hashCode, hashMap);
        }
        hashMap.put(str, t3);
    }

    public static <T> void c(String str) {
        int size = f33688c.size();
        for (int i4 = 0; i4 < size; i4++) {
            SparseArray<HashMap> sparseArray = f33688c;
            HashMap hashMap = sparseArray.get(sparseArray.keyAt(i4));
            if (hashMap != null) {
                hashMap.remove(str);
            }
        }
    }

    public static <T> T c(String str, Class<T> cls) {
        HashMap hashMap;
        if (cls == null || str == null || (hashMap = f33688c.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) hashMap.get(str);
    }
}
