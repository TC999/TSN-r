package com.p521ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.p521ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        C12490bl.m17799ok(this);
        if (C12490bl.m17756tr() == null) {
            C12490bl.m17792ok(new C12520ul());
        }
        InterfaceC12517t m17751vz = C12490bl.m17751vz();
        this.f35054ok = m17751vz;
        m17751vz.mo17630ok(new WeakReference(this));
    }
}
