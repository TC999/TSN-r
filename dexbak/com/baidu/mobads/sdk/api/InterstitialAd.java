package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2671cq;
import com.baidu.mobads.sdk.internal.C2699dq;
import com.baidu.mobads.sdk.internal.InterfaceC2738z;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InterstitialAd {
    public static final String TAG = "InterstitialAd";
    private boolean initialized;
    private InterstitialAdListener listener;
    private final C2634bs mAdLogger;
    private InterfaceC2738z mXInterstitial;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    private boolean isInterstitial(AdSize adSize) {
        return adSize.getValue() <= AdSize.InterstitialOther.getValue() && adSize.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean isInterstitialPause(AdSize adSize) {
        return adSize.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && adSize.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public void destroy() {
        this.mXInterstitial.m50217e();
    }

    public boolean isAdReady() {
        return this.mXInterstitial.mo50218c();
    }

    public void loadAd() {
        if (!this.initialized) {
            this.mXInterstitial.mo50216f();
            this.initialized = true;
        }
        this.mXInterstitial.mo50219b();
    }

    public void loadAdForVideoApp(int i, int i2) {
        if (!this.initialized) {
            this.mXInterstitial.mo50216f();
            this.initialized = true;
        }
        this.mXInterstitial.mo50225a(i, i2);
    }

    public void setAppSid(String str) {
        this.mXInterstitial.mo50221a(str);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener != null) {
            this.listener = interstitialAdListener;
            this.mXInterstitial.mo50222a(interstitialAdListener);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void showAd() {
        this.mXInterstitial.mo50220a_();
    }

    public void showAdInParentForVideoApp(RelativeLayout relativeLayout) {
        this.mXInterstitial.mo50223a(relativeLayout);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.initialized = false;
        this.mAdLogger = C2634bs.m50744a();
        this.listener = new InterstitialAdListener() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.1
            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdClick(InterstitialAd interstitialAd) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdReady() {
            }
        };
        C2671cq c2671cq = new C2671cq(context);
        c2671cq.m50591a(new C2671cq.InterfaceC2672a() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.2
            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return InterstitialAd.this.mXInterstitial.m50224a(i, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onLayoutComplete(int i, int i2) {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.C2671cq.InterfaceC2672a
            public void onWindowVisibilityChanged(int i) {
            }
        });
        if (isInterstitial(adSize)) {
            this.mXInterstitial = new C2699dq(context, c2671cq, this, str);
        } else if (isInterstitialPause(adSize)) {
            this.mXInterstitial = new C2699dq(context, c2671cq, this, adSize, str);
        }
        this.mXInterstitial.mo50222a(this.listener);
    }

    @Deprecated
    public void showAd(Activity activity) {
        this.mXInterstitial.mo50220a_();
    }

    @Deprecated
    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            this.mXInterstitial.mo50223a(relativeLayout);
            return;
        }
        throw new IllegalArgumentException();
    }
}
