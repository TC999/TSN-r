package com.bytedance.msdk.api.splash;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTSplashAdLoadCallback {
    void onAdLoadTimeout();

    void onSplashAdLoadFail(AdError adError);

    void onSplashAdLoadSuccess();
}
