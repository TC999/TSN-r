package com.ss.android.download.api.download.ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ok {
    void a(@Nullable DownloadInfo downloadInfo, String str);

    void ok(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void ok(@NonNull DownloadInfo downloadInfo);

    void ok(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void ok(@NonNull DownloadInfo downloadInfo, String str);
}
