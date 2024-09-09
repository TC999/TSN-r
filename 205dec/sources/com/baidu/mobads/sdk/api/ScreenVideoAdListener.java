package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f4);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f4);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
