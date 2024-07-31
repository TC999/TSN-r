package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.p066d.BannerAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BannerAd {

    /* renamed from: a */
    private BannerAdManager f10830a;

    public BannerAd(Context context, String str, BannerAdListener bannerAdListener, long j) {
        Log.d("BeiZis", " request BannerAd adUnitId:" + str);
        this.f10830a = new BannerAdManager(context, str, bannerAdListener, j);
    }

    public void destroy() {
        BannerAdManager bannerAdManager = this.f10830a;
        if (bannerAdManager != null) {
            bannerAdManager.m48770c();
        }
    }

    public int getECPM() {
        BannerAdManager bannerAdManager = this.f10830a;
        if (bannerAdManager != null) {
            return bannerAdManager.m48771b();
        }
        return -1;
    }

    public void loadAd(float f, float f2, ViewGroup viewGroup) {
        BannerAdManager bannerAdManager = this.f10830a;
        if (bannerAdManager != null) {
            bannerAdManager.m48772a(f, f2, viewGroup);
        }
    }
}
