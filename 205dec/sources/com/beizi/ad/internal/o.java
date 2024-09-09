package com.beizi.ad.internal;

import android.content.Context;
import com.beizi.ad.AdRequest;
import com.beizi.ad.RewardedVideoAd;
import com.beizi.ad.RewardedVideoAdListener;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RewardedVideoAdImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o implements RewardedVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private final InterstitialAdViewImpl f14016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context) {
        this.f14016a = new InterstitialAdViewImpl(context, true, false);
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void destroy(Context context) {
        this.f14016a.destroy();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public String getPrice() {
        return this.f14016a.getPrice();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.f14016a.getRewaredVideoAdListener();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public boolean isLoaded() {
        return this.f14016a.isLoaded();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void loadAd(String str, AdRequest adRequest) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f14016a.setAdUnitId(str);
        this.f14016a.loadAd(adRequest.impl());
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void pause(Context context) {
        this.f14016a.activityOnPause();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void resume(Context context) {
        this.f14016a.activityOnResume();
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f14016a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    @Override // com.beizi.ad.RewardedVideoAd
    public void show() {
        this.f14016a.show();
    }
}
