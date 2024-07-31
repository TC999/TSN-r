package com.kwad.components.offline.api.p341tk;

/* renamed from: com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IOfflineApkLoadStatusListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i);

    void onProgressUpdate(int i);
}
