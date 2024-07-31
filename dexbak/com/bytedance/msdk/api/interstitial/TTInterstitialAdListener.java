package com.bytedance.msdk.api.interstitial;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTInterstitialAdListener extends ITTAdatperCallback {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialAdClick();

    void onInterstitialClosed();

    void onInterstitialShow();

    void onInterstitialShowFail(AdError adError);
}
