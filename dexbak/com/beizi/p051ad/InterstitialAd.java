package com.beizi.p051ad;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;
import com.kuaishou.weapon.p205p0.C7282g;

/* renamed from: com.beizi.ad.InterstitialAd */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InterstitialAd implements AdLifeControl {

    /* renamed from: a */
    private final InterstitialAdViewImpl f9364a;

    public InterstitialAd(Context context) {
        this.f9364a = new InterstitialAdViewImpl(context, false, false);
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void cancel() {
        this.f9364a.cancel();
    }

    public String getAdId() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9364a;
        if (interstitialAdViewImpl == null) {
            return null;
        }
        return interstitialAdViewImpl.getAdId();
    }

    public AdListener getAdListener() {
        return this.f9364a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f9364a.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.f9364a.getMediationAdapterClassName();
    }

    public String getPrice() {
        return this.f9364a.getPrice();
    }

    public boolean isLoaded() {
        return this.f9364a.isLoaded();
    }

    public boolean isLoading() {
        return this.f9364a.isLoading();
    }

    @RequiresPermission(C7282g.f24943a)
    public void loadAd(AdRequest adRequest) {
        this.f9364a.loadAd(adRequest.impl());
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onDestoryLifeCycle() {
        this.f9364a.onDestoryLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z) {
        this.f9364a.setOpensNativeBrowser(z);
    }

    public void setAdBuyerBean(AdSpacesBean.BuyerBean buyerBean) {
        this.f9364a.setAdBuyerBean(buyerBean);
    }

    public void setAdListener(AdListener adListener) {
        this.f9364a.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.f9364a.setAdUnitId(str);
    }

    public void setCloseMarketDialog(boolean z) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f9364a;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setCloseMarketDialog(z);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f9364a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public void show() {
        this.f9364a.show();
    }

    public void show(Context context) {
        this.f9364a.showInterstitial(context);
    }

    public InterstitialAd(Context context, boolean z) {
        this.f9364a = new InterstitialAdViewImpl(context, false, z);
    }
}
