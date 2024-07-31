package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.p341tk.IOfflineApkLoader;
import com.kwad.sdk.components.InterfaceC9867h;
import com.kwad.sdk.components.InterfaceC9868i;

/* renamed from: com.kwad.components.offline.c.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9407d implements IOfflineApkLoader {
    InterfaceC9868i adm;

    public C9407d(InterfaceC9868i interfaceC9868i) {
        this.adm = interfaceC9868i;
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void addLoadStatusListener(final IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
        this.adm.mo27493a(new InterfaceC9867h() { // from class: com.kwad.components.offline.c.a.d.1
            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onDownloadFailed() {
                iOfflineApkLoadStatusListener.onDownloadFailed();
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onDownloadFinished() {
                iOfflineApkLoadStatusListener.onDownloadFinished();
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onDownloadStarted() {
                iOfflineApkLoadStatusListener.onDownloadStarted();
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onIdle() {
                iOfflineApkLoadStatusListener.onIdle();
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onInstalled() {
                iOfflineApkLoadStatusListener.onInstalled();
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onPaused(int i) {
                iOfflineApkLoadStatusListener.onPaused(i);
            }

            @Override // com.kwad.sdk.components.InterfaceC9867h
            public final void onProgressUpdate(int i) {
                iOfflineApkLoadStatusListener.onProgressUpdate(i);
            }
        });
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void cancelDownload() {
        this.adm.cancelDownload();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void clearFileCache() {
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void installApp() {
        this.adm.installApp();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void openApp() {
        this.adm.openApp();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void pauseDownload() {
        this.adm.pauseDownload();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void resumeDownload() {
        this.adm.resumeDownload();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void setCustomReportParam(String str) {
        this.adm.setCustomReportParam(str);
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void startDownload() {
        this.adm.startDownload();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void stopDownload() {
        this.adm.stopDownload();
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoader
    public final void uninstallApp() {
    }
}
