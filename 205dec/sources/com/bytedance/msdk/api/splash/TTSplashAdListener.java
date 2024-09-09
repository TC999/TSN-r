package com.bytedance.msdk.api.splash;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTSplashAdListener extends ITTAdatperCallback {
    void onAdClicked();

    void onAdDismiss();

    void onAdShow();

    void onAdShowFail(AdError adError);

    void onAdSkip();
}
