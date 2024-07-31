package com.baidu.mobads.sdk.api;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface CPUDramaListener {
    void onADExposed(CPUAdType cPUAdType);

    void onADExposureFailed(CPUAdType cPUAdType);

    void onAdClick(CPUAdType cPUAdType);

    void onContentFailed(int i, String str);

    void onContentLoaded();

    void onVideoCollect(CPUDramaResponse cPUDramaResponse);

    void onVideoPlay(CPUDramaResponse cPUDramaResponse);
}
