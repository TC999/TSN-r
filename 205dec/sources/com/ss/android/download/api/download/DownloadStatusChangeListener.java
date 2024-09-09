package com.ss.android.download.api.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface DownloadStatusChangeListener {
    void onDownloadActive(DownloadShortInfo downloadShortInfo, int i4);

    void onDownloadFailed(DownloadShortInfo downloadShortInfo);

    void onDownloadFinished(DownloadShortInfo downloadShortInfo);

    void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i4);

    void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController);

    void onIdle();

    void onInstalled(DownloadShortInfo downloadShortInfo);
}
