package com.beizi.fusion;

import android.view.View;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface NativeAdListener extends BaseAdListener {
    void onAdClick();

    void onAdClosed();

    void onAdClosed(View view);

    void onAdFailed(int i);

    void onAdLoaded(View view);

    void onAdShown();
}
