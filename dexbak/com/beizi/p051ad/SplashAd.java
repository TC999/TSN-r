package com.beizi.p051ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.p051ad.AdRequest;
import com.beizi.p051ad.internal.view.BannerAdViewImpl;
import com.beizi.p051ad.p056c.ClickPositionModel;
import com.kuaishou.weapon.p205p0.C7282g;

/* renamed from: com.beizi.ad.SplashAd */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SplashAd implements AdLifeControl {

    /* renamed from: a */
    private final BannerAdViewImpl f9383a;

    @RequiresPermission(C7282g.f24943a)
    public SplashAd(Context context, ViewGroup viewGroup, View view, AdListener adListener, String str) {
        viewGroup.setPadding(0, 0, 0, 0);
        BannerAdViewImpl bannerAdViewImpl = new BannerAdViewImpl(context, viewGroup, view);
        this.f9383a = bannerAdViewImpl;
        bannerAdViewImpl.setAdListener(adListener);
        bannerAdViewImpl.setAdUnitId(str);
        bannerAdViewImpl.loadAd(new AdRequest.Builder().build().impl());
    }

    public void adClick() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.clickArea();
        }
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    public void closeAd() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.closeAd();
        }
    }

    public void disableFullClick(View.OnTouchListener onTouchListener) {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl == null || onTouchListener == null) {
            return;
        }
        bannerAdViewImpl.disableFullClick(onTouchListener);
    }

    public String getAdId() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getAdId();
    }

    public AdListener getAdListener() {
        return this.f9383a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f9383a.getAdUnitId();
    }

    public String getPrice() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getPrice();
    }

    public boolean isLoaded() {
        return this.f9383a.isLoaded();
    }

    public boolean isLoading() {
        return this.f9383a.isLoading();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onCreateLifeCycle() {
        this.f9383a.onCreateLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onDestoryLifeCycle() {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.onDestoryLifeCycle();
        }
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onPauseLifeCycle() {
        this.f9383a.onPauseLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onRestartLifeCycle() {
        this.f9383a.onRestartLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onResumeLifeCycle() {
        this.f9383a.onResumeLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStartLifeCycle() {
        this.f9383a.onStartLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f9383a.onStopLifeCycle();
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z) {
        this.f9383a.openAdInNativeBrowser(z);
    }

    public void setAdUnitId(String str) {
        this.f9383a.setAdUnitId(str);
    }

    public void setCloseButtonPadding(int i, int i2, int i3, int i4) {
        this.f9383a.setCloseButtonPadding(i, i2, i3, i4);
    }

    public void setCloseMarketDialog(boolean z) {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.setCloseMarketDialog(z);
        }
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        BannerAdViewImpl bannerAdViewImpl = this.f9383a;
        if (bannerAdViewImpl == null || onTouchListener == null) {
            return;
        }
        bannerAdViewImpl.setScrollClick(onTouchListener);
    }

    public void showAd() {
        this.f9383a.showAd();
    }

    public void adClick(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        if (this.f9383a != null) {
            ClickPositionModel clickPositionModel = new ClickPositionModel();
            if (!TextUtils.isEmpty(str)) {
                clickPositionModel.m49862a(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                clickPositionModel.m49860b(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                clickPositionModel.m49858c(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                clickPositionModel.m49856d(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                clickPositionModel.m49854e(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                clickPositionModel.m49852f(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                clickPositionModel.m49850g(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                clickPositionModel.m49848h(str8);
            }
            this.f9383a.clickArea(clickPositionModel, i);
        }
    }
}
