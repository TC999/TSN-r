package xyz.adscope.ad.advertisings.interstitial;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InterstitialAdViewSingleton {
    private static InterstitialAdViewSingleton instance;
    private View interstitialAdView;

    private InterstitialAdViewSingleton() {
    }

    public static InterstitialAdViewSingleton getInstance() {
        if (instance == null) {
            instance = new InterstitialAdViewSingleton();
        }
        return instance;
    }

    public void clear() {
        this.interstitialAdView = null;
        instance = null;
    }

    public View getInterstitialAdView() {
        return this.interstitialAdView;
    }

    public void setInterstitialAdView(View view) {
        this.interstitialAdView = view;
    }
}
