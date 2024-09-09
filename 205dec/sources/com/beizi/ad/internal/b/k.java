package com.beizi.ad.internal.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Preconditions.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k {
    public static <T> T a(T t3) {
        t3.getClass();
        return t3;
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    public static <T> T a(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, String str) {
        if (!z3) {
            throw new IllegalArgumentException(str);
        }
    }
}
