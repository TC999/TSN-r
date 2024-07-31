package com.danikula.videocache;

/* compiled from: Preconditions.java */
/* renamed from: com.danikula.videocache.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6567n {
    /* renamed from: a */
    public static void m35861a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m35860b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m35859c(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: d */
    public static <T> T m35858d(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: e */
    public static <T> T m35857e(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
