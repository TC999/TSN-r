package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(this);
        if (bl.tr() == null) {
            bl.ok(new ul());
        }
        t vz = bl.vz();
        this.ok = vz;
        vz.ok(new WeakReference(this));
    }
}
