package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.p066d.NativeAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeAd {

    /* renamed from: a */
    private NativeAdManager f10840a;

    public NativeAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeAd adUnitId:" + str);
        this.f10840a = new NativeAdManager(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        NativeAdManager nativeAdManager = this.f10840a;
        if (nativeAdManager != null) {
            nativeAdManager.m48616c();
        }
    }

    public int getECPM() {
        NativeAdManager nativeAdManager = this.f10840a;
        if (nativeAdManager != null) {
            return nativeAdManager.m48617b();
        }
        return -1;
    }

    public void loadAd(float f, float f2) {
        NativeAdManager nativeAdManager = this.f10840a;
        if (nativeAdManager != null) {
            nativeAdManager.m48618a(f, f2);
        }
    }

    public void resume() {
        NativeAdManager nativeAdManager = this.f10840a;
        if (nativeAdManager != null) {
            nativeAdManager.m48619B();
        }
    }
}
