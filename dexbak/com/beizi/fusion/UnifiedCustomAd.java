package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.p066d.UnifiedCustomAdManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UnifiedCustomAd {

    /* renamed from: a */
    private UnifiedCustomAdManager f10852a;

    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        this.f10852a = new UnifiedCustomAdManager(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        UnifiedCustomAdManager unifiedCustomAdManager = this.f10852a;
        if (unifiedCustomAdManager != null) {
            unifiedCustomAdManager.m48584B();
        }
    }

    public boolean isLoaded() {
        UnifiedCustomAdManager unifiedCustomAdManager = this.f10852a;
        if (unifiedCustomAdManager != null) {
            return unifiedCustomAdManager.m48578c();
        }
        return false;
    }

    public void loadAd() {
        UnifiedCustomAdManager unifiedCustomAdManager = this.f10852a;
        if (unifiedCustomAdManager != null) {
            unifiedCustomAdManager.m48579b();
        }
    }

    public void resume() {
        UnifiedCustomAdManager unifiedCustomAdManager = this.f10852a;
        if (unifiedCustomAdManager != null) {
            unifiedCustomAdManager.m48583C();
        }
    }

    public void showAd(@NonNull Activity activity) {
        UnifiedCustomAdManager unifiedCustomAdManager = this.f10852a;
        if (unifiedCustomAdManager != null) {
            unifiedCustomAdManager.m48581a(activity);
        }
    }
}
