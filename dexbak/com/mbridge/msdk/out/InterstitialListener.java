package com.mbridge.msdk.out;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterstitialListener {
    void onInterstitialAdClick(MBridgeIds mBridgeIds);

    void onInterstitialClosed(MBridgeIds mBridgeIds);

    void onInterstitialLoadFail(MBridgeIds mBridgeIds, String str);

    void onInterstitialLoadSuccess(MBridgeIds mBridgeIds);

    void onInterstitialShowFail(MBridgeIds mBridgeIds, String str);

    void onInterstitialShowSuccess(MBridgeIds mBridgeIds);
}
