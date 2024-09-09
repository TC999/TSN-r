package com.ss.android.socialbase.downloader.network;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface k {

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f50034c;

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
        static {
            int[] iArr = new int[a.values().length];
            f50034c = iArr;
            try {
                iArr[a.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50034c[a.w.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50034c[a.xv.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50034c[a.sr.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        public static final k f50035c = new k(null);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface w {
        void c(a aVar);
    }

    void ok(Map<String, String> map);
}
