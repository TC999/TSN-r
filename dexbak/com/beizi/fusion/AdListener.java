package com.beizi.fusion;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface AdListener extends BaseAdListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdLoaded();

    void onAdShown();

    void onAdTick(long j);
}
