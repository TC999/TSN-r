package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j4);

    void onADPresent();

    void onADTick(long j4);

    void onNoAD(AdError adError);
}
