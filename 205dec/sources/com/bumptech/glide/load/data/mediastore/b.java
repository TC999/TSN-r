package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MediaStoreUtil.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f16829a = 512;

    /* renamed from: b  reason: collision with root package name */
    private static final int f16830b = 384;

    private b() {
    }

    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i4, int i5) {
        return i4 != Integer.MIN_VALUE && i5 != Integer.MIN_VALUE && i4 <= 512 && i5 <= 384;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
