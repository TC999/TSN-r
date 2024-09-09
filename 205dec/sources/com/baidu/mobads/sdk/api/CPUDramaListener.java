package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface CPUDramaListener {
    void onADExposed(CPUAdType cPUAdType);

    void onADExposureFailed(CPUAdType cPUAdType);

    void onAdClick(CPUAdType cPUAdType);

    void onContentFailed(int i4, String str);

    void onContentLoaded();

    void onVideoCollect(CPUDramaResponse cPUDramaResponse);

    void onVideoPlay(CPUDramaResponse cPUDramaResponse);
}
