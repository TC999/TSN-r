package com.tencent.turingfd.sdk.ams.au;

import android.util.SparseArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Norma {
    public static <E> E a(SparseArray<Object> sparseArray, int i4, Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(i4);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static int b(SparseArray<Object> sparseArray) {
        Integer num = (Integer) a(sparseArray, 0, Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static byte[] a(SparseArray<Object> sparseArray) {
        byte[] bArr = (byte[]) a(sparseArray, 1, byte[].class);
        return bArr == null ? new byte[0] : bArr;
    }
}
