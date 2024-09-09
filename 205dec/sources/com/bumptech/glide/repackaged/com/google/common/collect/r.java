package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: ObjectArrays.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    static final Object[] f17708a = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr, int i4) {
        T[] tArr2 = (T[]) e(tArr, i4);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i4));
        return tArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Object obj, int i4) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Object... objArr) {
        return d(objArr, objArr.length);
    }

    static Object[] d(Object[] objArr, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            b(objArr[i5], i5);
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i4) {
        return (T[]) u.a(tArr, i4);
    }
}
