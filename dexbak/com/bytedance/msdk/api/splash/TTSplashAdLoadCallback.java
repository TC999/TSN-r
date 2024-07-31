package com.bytedance.msdk.api.splash;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTSplashAdLoadCallback {
    void onAdLoadTimeout();

    void onSplashAdLoadFail(AdError adError);

    void onSplashAdLoadSuccess();
}
