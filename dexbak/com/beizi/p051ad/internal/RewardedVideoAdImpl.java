package com.beizi.p051ad.internal;

import android.content.Context;
import com.beizi.p051ad.AdRequest;
import com.beizi.p051ad.RewardedVideoAd;
import com.beizi.p051ad.RewardedVideoAdListener;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RewardedVideoAdImpl implements RewardedVideoAd {

    /* renamed from: a */
    private final InterstitialAdViewImpl f10407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RewardedVideoAdImpl(Context context) {
        this.f10407a = new InterstitialAdViewImpl(context, true, false);
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void destroy(Context context) {
        this.f10407a.destroy();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public String getPrice() {
        return this.f10407a.getPrice();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.f10407a.getRewaredVideoAdListener();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public boolean isLoaded() {
        return this.f10407a.isLoaded();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void loadAd(String str, AdRequest adRequest) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f10407a.setAdUnitId(str);
        this.f10407a.loadAd(adRequest.impl());
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void pause(Context context) {
        this.f10407a.activityOnPause();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void resume(Context context) {
        this.f10407a.activityOnResume();
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f10407a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    @Override // com.beizi.p051ad.RewardedVideoAd
    public void show() {
        this.f10407a.show();
    }
}
