package com.ss.android.socialbase.downloader.impls;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements com.ss.android.socialbase.downloader.downloader.h {
    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int ok(int i4, com.ss.android.socialbase.downloader.network.j jVar) {
        if (jVar.ordinal() <= com.ss.android.socialbase.downloader.network.j.MODERATE.ordinal()) {
            return 1;
        }
        return jVar == com.ss.android.socialbase.downloader.network.j.GOOD ? i4 - 1 : i4;
    }
}
