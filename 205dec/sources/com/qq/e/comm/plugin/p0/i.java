package com.qq.e.comm.plugin.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t3) throws k {
        if (t3 != null) {
            return t3;
        }
        throw new k("argument is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t3, String str) throws k {
        if (t3 != null) {
            return t3;
        }
        throw new k(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, String str) throws k {
        if (!z3) {
            throw new k(str);
        }
    }
}
