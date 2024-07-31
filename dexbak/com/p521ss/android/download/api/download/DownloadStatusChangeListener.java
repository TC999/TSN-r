package com.p521ss.android.download.api.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.model.DownloadShortInfo;

/* renamed from: com.ss.android.download.api.download.DownloadStatusChangeListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface DownloadStatusChangeListener {
    void onDownloadActive(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadFailed(DownloadShortInfo downloadShortInfo);

    void onDownloadFinished(DownloadShortInfo downloadShortInfo);

    void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController);

    void onIdle();

    void onInstalled(DownloadShortInfo downloadShortInfo);
}
