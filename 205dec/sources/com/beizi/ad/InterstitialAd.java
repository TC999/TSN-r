package com.beizi.ad;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import com.beizi.fusion.model.AdSpacesBean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class InterstitialAd implements AdLifeControl {

    /* renamed from: a  reason: collision with root package name */
    private final InterstitialAdViewImpl f13081a;

    public InterstitialAd(Context context) {
        this.f13081a = new InterstitialAdViewImpl(context, false, false);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void cancel() {
        this.f13081a.cancel();
    }

    public String getAdId() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13081a;
        if (interstitialAdViewImpl == null) {
            return null;
        }
        return interstitialAdViewImpl.getAdId();
    }

    public AdListener getAdListener() {
        return this.f13081a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f13081a.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.f13081a.getMediationAdapterClassName();
    }

    public String getPrice() {
        return this.f13081a.getPrice();
    }

    public boolean isDownloadApp() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13081a;
        if (interstitialAdViewImpl == null) {
            return false;
        }
        return interstitialAdViewImpl.isDownloadApp();
    }

    public boolean isLoaded() {
        return this.f13081a.isLoaded();
    }

    public boolean isLoading() {
        return this.f13081a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.f13081a.loadAd(adRequest.impl());
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onDestoryLifeCycle() {
        this.f13081a.onDestoryLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z3) {
        this.f13081a.setOpensNativeBrowser(z3);
    }

    public void setAdBuyerBean(AdSpacesBean.BuyerBean buyerBean) {
        this.f13081a.setAdBuyerBean(buyerBean);
    }

    public void setAdListener(AdListener adListener) {
        this.f13081a.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.f13081a.setAdUnitId(str);
    }

    public void setCloseMarketDialog(boolean z3) {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f13081a;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setCloseMarketDialog(z3);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f13081a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public void show() {
        this.f13081a.show();
    }

    public void show(Context context) {
        this.f13081a.showInterstitial(context);
    }

    public InterstitialAd(Context context, boolean z3) {
        this.f13081a = new InterstitialAdViewImpl(context, false, z3);
    }
}
