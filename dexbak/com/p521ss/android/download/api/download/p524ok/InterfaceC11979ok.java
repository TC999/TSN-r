package com.p521ss.android.download.api.download.p524ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.download.api.download.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC11979ok {
    /* renamed from: a */
    void mo19615a(@Nullable DownloadInfo downloadInfo, String str);

    /* renamed from: ok */
    void mo19614ok(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    /* renamed from: ok */
    void mo19613ok(@NonNull DownloadInfo downloadInfo);

    /* renamed from: ok */
    void mo19612ok(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    /* renamed from: ok */
    void mo19611ok(@NonNull DownloadInfo downloadInfo, String str);
}
