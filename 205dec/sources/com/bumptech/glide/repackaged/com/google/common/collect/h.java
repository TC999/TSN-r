package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: Hashing.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f17681a = 1073741824;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4) {
        return Integer.rotateLeft(i4 * (-862048943), 15) * 461845907;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
