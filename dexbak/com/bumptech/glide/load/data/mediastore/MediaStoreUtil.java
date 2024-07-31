package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* renamed from: com.bumptech.glide.load.data.mediastore.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MediaStoreUtil {

    /* renamed from: a */
    private static final int f13506a = 512;

    /* renamed from: b */
    private static final int f13507b = 384;

    private MediaStoreUtil() {
    }

    /* renamed from: a */
    public static boolean m45456a(Uri uri) {
        return m45455b(uri) && !m45452e(uri);
    }

    /* renamed from: b */
    public static boolean m45455b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static boolean m45454c(Uri uri) {
        return m45455b(uri) && m45452e(uri);
    }

    /* renamed from: d */
    public static boolean m45453d(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= f13507b;
    }

    /* renamed from: e */
    private static boolean m45452e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
