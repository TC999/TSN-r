package com.bytedance.msdk.api.fullVideo;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTFullVideoAdListener extends ITTAdatperCallback {
    void onFullVideoAdClick();

    void onFullVideoAdClosed();

    void onFullVideoAdShow();

    void onFullVideoAdShowFail(AdError adError);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError();
}
