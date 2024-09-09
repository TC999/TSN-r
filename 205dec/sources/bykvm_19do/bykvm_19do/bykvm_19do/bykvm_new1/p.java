package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;

/* compiled from: Predicate.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class p {
    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(str2);
            throw null;
        }
    }

    private static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}
