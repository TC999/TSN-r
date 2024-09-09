package com.ss.android.download.api.download.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface c {
    void c(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void c(@NonNull DownloadInfo downloadInfo);

    void c(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void c(@NonNull DownloadInfo downloadInfo, String str);

    void w(@Nullable DownloadInfo downloadInfo, String str);
}
