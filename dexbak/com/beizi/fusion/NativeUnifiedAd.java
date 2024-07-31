package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import com.beizi.fusion.p066d.NativeUnifiedAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeUnifiedAd {

    /* renamed from: a */
    private NativeUnifiedAdManager f10843a;

    public NativeUnifiedAd(Context context, String str, NativeUnifiedAdListener nativeUnifiedAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeUnifiedAd adUnitId:" + str);
        this.f10843a = new NativeUnifiedAdManager(context, str, nativeUnifiedAdListener, j, i);
    }

    public void destroy() {
        NativeUnifiedAdManager nativeUnifiedAdManager = this.f10843a;
        if (nativeUnifiedAdManager != null) {
            nativeUnifiedAdManager.m48614C();
        }
    }

    public int getECPM() {
        NativeUnifiedAdManager nativeUnifiedAdManager = this.f10843a;
        if (nativeUnifiedAdManager != null) {
            return nativeUnifiedAdManager.m48615B();
        }
        return -1;
    }

    public boolean isLoaded() {
        NativeUnifiedAdManager nativeUnifiedAdManager = this.f10843a;
        if (nativeUnifiedAdManager != null) {
            return nativeUnifiedAdManager.m48611c();
        }
        return false;
    }

    public void loadAd() {
        NativeUnifiedAdManager nativeUnifiedAdManager = this.f10843a;
        if (nativeUnifiedAdManager != null) {
            nativeUnifiedAdManager.m48612b();
        }
    }

    public void resume() {
        NativeUnifiedAdManager nativeUnifiedAdManager = this.f10843a;
        if (nativeUnifiedAdManager != null) {
            nativeUnifiedAdManager.m48613D();
        }
    }
}
