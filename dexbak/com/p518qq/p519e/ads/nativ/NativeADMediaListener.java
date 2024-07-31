package com.p518qq.p519e.ads.nativ;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADMediaListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NativeADMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
