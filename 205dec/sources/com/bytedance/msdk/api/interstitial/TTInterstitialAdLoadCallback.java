package com.bytedance.msdk.api.interstitial;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTInterstitialAdLoadCallback {
    void onInterstitialLoad();

    void onInterstitialLoadFail(AdError adError);
}
