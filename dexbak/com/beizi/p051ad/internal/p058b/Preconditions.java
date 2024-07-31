package com.beizi.p051ad.internal.p058b;

/* renamed from: com.beizi.ad.internal.b.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Preconditions {
    /* renamed from: a */
    public static <T> T m49572a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: a */
    public static void m49568a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    /* renamed from: a */
    public static <T> T m49571a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m49570a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m49569a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
