package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: CollectPreconditions.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4, String str) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z3) {
        com.bumptech.glide.repackaged.com.google.common.base.d.o(z3, "no calls to next() since the last call to remove()");
    }
}
