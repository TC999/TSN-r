package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.p066d.InterstitialAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InterstitialAd {

    /* renamed from: a */
    private InterstitialAdManager f10839a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j) {
        this.f10839a = new InterstitialAdManager(context, str, interstitialAdListener, j, 0);
    }

    public void destroy() {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            interstitialAdManager.m48630C();
        }
    }

    public int getECPM() {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            return interstitialAdManager.m48631B();
        }
        return -1;
    }

    public boolean isLoaded() {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            return interstitialAdManager.m48628b();
        }
        return false;
    }

    public void loadAd() {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            interstitialAdManager.m48626c();
        }
    }

    public void setAdVersion(int i) {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            interstitialAdManager.m48627b(i);
        }
    }

    public void showAd(@NonNull Activity activity) {
        InterstitialAdManager interstitialAdManager = this.f10839a;
        if (interstitialAdManager != null) {
            interstitialAdManager.m48629a(activity);
        }
    }

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j, int i) {
        Log.d("BeiZis", " request InterstitialAd adUnitId:" + str);
        this.f10839a = new InterstitialAdManager(context, str, interstitialAdListener, j, i);
    }
}
