package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements IOfflineApkLoader {
    com.kwad.sdk.components.i adm;

    public d(com.kwad.sdk.components.i iVar) {
        this.adm = iVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void addLoadStatusListener(final IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
        this.adm.a(new com.kwad.sdk.components.h() { // from class: com.kwad.components.offline.c.a.d.1
            @Override // com.kwad.sdk.components.h
            public final void onDownloadFailed() {
                iOfflineApkLoadStatusListener.onDownloadFailed();
            }

            @Override // com.kwad.sdk.components.h
            public final void onDownloadFinished() {
                iOfflineApkLoadStatusListener.onDownloadFinished();
            }

            @Override // com.kwad.sdk.components.h
            public final void onDownloadStarted() {
                iOfflineApkLoadStatusListener.onDownloadStarted();
            }

            @Override // com.kwad.sdk.components.h
            public final void onIdle() {
                iOfflineApkLoadStatusListener.onIdle();
            }

            @Override // com.kwad.sdk.components.h
            public final void onInstalled() {
                iOfflineApkLoadStatusListener.onInstalled();
            }

            @Override // com.kwad.sdk.components.h
            public final void onPaused(int i4) {
                iOfflineApkLoadStatusListener.onPaused(i4);
            }

            @Override // com.kwad.sdk.components.h
            public final void onProgressUpdate(int i4) {
                iOfflineApkLoadStatusListener.onProgressUpdate(i4);
            }
        });
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void cancelDownload() {
        this.adm.cancelDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void clearFileCache() {
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void installApp() {
        this.adm.installApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void openApp() {
        this.adm.openApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void pauseDownload() {
        this.adm.pauseDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void resumeDownload() {
        this.adm.resumeDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void setCustomReportParam(String str) {
        this.adm.setCustomReportParam(str);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void startDownload() {
        this.adm.startDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void stopDownload() {
        this.adm.stopDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void uninstallApp() {
    }
}
