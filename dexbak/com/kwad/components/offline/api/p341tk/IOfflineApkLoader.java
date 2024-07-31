package com.kwad.components.offline.api.p341tk;

/* renamed from: com.kwad.components.offline.api.tk.IOfflineApkLoader */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineApkLoader {
    void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener);

    void cancelDownload();

    void clearFileCache();

    void installApp();

    void openApp();

    void pauseDownload();

    void resumeDownload();

    void setCustomReportParam(String str);

    void startDownload();

    void stopDownload();

    void uninstallApp();
}
