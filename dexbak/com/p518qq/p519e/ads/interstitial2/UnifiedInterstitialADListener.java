package com.p518qq.p519e.ads.interstitial2;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialADListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onRenderFail();

    void onRenderSuccess();

    void onVideoCached();
}
