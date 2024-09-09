package com.kwad.sdk.export.proxy;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DownloadParams;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    @Nullable
    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
