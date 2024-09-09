package com.mbridge.msdk.foundation.download;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface OnDownloadStateListener<T> {
    void onCancelDownload(DownloadMessage<T> downloadMessage);

    void onDownloadComplete(DownloadMessage<T> downloadMessage);

    void onDownloadError(DownloadMessage<T> downloadMessage, DownloadError downloadError);

    void onDownloadStart(DownloadMessage<T> downloadMessage);
}
