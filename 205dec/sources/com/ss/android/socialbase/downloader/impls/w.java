package com.ss.android.socialbase.downloader.impls;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements com.ss.android.socialbase.downloader.downloader.r {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
    public int c(int i4, com.ss.android.socialbase.downloader.network.a aVar) {
        if (aVar.ordinal() <= com.ss.android.socialbase.downloader.network.a.w.ordinal()) {
            return 1;
        }
        return aVar == com.ss.android.socialbase.downloader.network.a.xv ? i4 - 1 : i4;
    }
}
