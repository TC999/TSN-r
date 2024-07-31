package com.p518qq.p519e.ads.banner2;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.banner2.UnifiedBannerADListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADReceive();

    void onNoAD(AdError adError);
}
