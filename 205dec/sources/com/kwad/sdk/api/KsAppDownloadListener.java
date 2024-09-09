package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onDownloadFailed();

    @KsAdSdkApi
    @Keep
    void onDownloadFinished();

    @KsAdSdkApi
    @Keep
    void onDownloadStarted();

    @KsAdSdkApi
    @Keep
    void onIdle();

    @KsAdSdkApi
    @Keep
    void onInstalled();

    @KsAdSdkApi
    @Keep
    void onProgressUpdate(int i4);
}
