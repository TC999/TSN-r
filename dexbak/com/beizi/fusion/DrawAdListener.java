package com.beizi.fusion;

import android.view.View;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface DrawAdListener extends BaseAdListener {
    void onAdClick();

    void onAdFailed(int i);

    void onAdLoaded(View view);

    void onAdShown();

    void onVideoComplete();

    void onVideoPlayError();
}
