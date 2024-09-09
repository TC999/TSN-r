package com.danikula.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Preconditions.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class n {
    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z3, String str) {
        if (!z3) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T d(T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T e(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}
