package com.beizi.fusion;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface DrawAdListener extends a {
    void onAdClick();

    void onAdFailed(int i4);

    void onAdLoaded(View view);

    void onAdShown();

    void onVideoComplete();

    void onVideoPlayError();
}
