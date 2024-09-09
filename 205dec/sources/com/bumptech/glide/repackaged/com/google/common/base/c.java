package com.bumptech.glide.repackaged.com.google.common.base;

import java.util.Arrays;

/* compiled from: Objects.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class c {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
