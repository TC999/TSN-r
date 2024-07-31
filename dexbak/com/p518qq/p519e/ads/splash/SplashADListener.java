package com.p518qq.p519e.ads.splash;

import com.p518qq.p519e.comm.util.AdError;

/* renamed from: com.qq.e.ads.splash.SplashADListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j);

    void onADPresent();

    void onADTick(long j);

    void onNoAD(AdError adError);
}
