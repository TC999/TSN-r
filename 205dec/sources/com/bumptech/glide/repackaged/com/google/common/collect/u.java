package com.bumptech.glide.repackaged.com.google.common.collect;

import java.lang.reflect.Array;

/* compiled from: Platform.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class u {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr, int i4) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i4));
    }
}
