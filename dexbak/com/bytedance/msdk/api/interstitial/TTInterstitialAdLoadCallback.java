package com.bytedance.msdk.api.interstitial;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTInterstitialAdLoadCallback {
    void onInterstitialLoad();

    void onInterstitialLoadFail(AdError adError);
}
