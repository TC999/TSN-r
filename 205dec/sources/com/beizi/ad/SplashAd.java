package com.beizi.ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.AdRequest;
import com.beizi.ad.c.c;
import com.beizi.ad.internal.view.BannerAdViewImpl;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class SplashAd implements AdLifeControl {

    /* renamed from: a  reason: collision with root package name */
    private final BannerAdViewImpl f13099a;

    @RequiresPermission("android.permission.INTERNET")
    public SplashAd(Context context, ViewGroup viewGroup, View view, AdListener adListener, String str) {
        viewGroup.setPadding(0, 0, 0, 0);
        BannerAdViewImpl bannerAdViewImpl = new BannerAdViewImpl(context, viewGroup, view);
        this.f13099a = bannerAdViewImpl;
        bannerAdViewImpl.setAdListener(adListener);
        bannerAdViewImpl.setAdUnitId(str);
        bannerAdViewImpl.loadAd(new AdRequest.Builder().build().impl());
    }

    public void adClick() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.clickArea();
        }
    }

    @Override // com.beizi.ad.AdLifeControl
    public void cancel() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.cancel();
        }
    }

    public void closeAd() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.closeAd();
        }
    }

    public void disableFullClick(View.OnTouchListener onTouchListener) {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl == null || onTouchListener == null) {
            return;
        }
        bannerAdViewImpl.disableFullClick(onTouchListener);
    }

    public String getAdId() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getAdId();
    }

    public AdListener getAdListener() {
        return this.f13099a.getAdListener();
    }

    public String getAdUnitId() {
        return this.f13099a.getAdUnitId();
    }

    public String getPrice() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl == null) {
            return null;
        }
        return bannerAdViewImpl.getPrice();
    }

    public boolean isDownloadApp() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl == null) {
            return false;
        }
        return bannerAdViewImpl.isDownloadApp();
    }

    public boolean isLoaded() {
        return this.f13099a.isLoaded();
    }

    public boolean isLoading() {
        return this.f13099a.isLoading();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onCreateLifeCycle() {
        this.f13099a.onCreateLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onDestoryLifeCycle() {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.onDestoryLifeCycle();
        }
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onPauseLifeCycle() {
        this.f13099a.onPauseLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onRestartLifeCycle() {
        this.f13099a.onRestartLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onResumeLifeCycle() {
        this.f13099a.onResumeLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStartLifeCycle() {
        this.f13099a.onStartLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f13099a.onStopLifeCycle();
    }

    @Override // com.beizi.ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z3) {
        this.f13099a.openAdInNativeBrowser(z3);
    }

    public void setAdUnitId(String str) {
        this.f13099a.setAdUnitId(str);
    }

    public void setCloseButtonPadding(int i4, int i5, int i6, int i7) {
        this.f13099a.setCloseButtonPadding(i4, i5, i6, i7);
    }

    public void setCloseMarketDialog(boolean z3) {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl != null) {
            bannerAdViewImpl.setCloseMarketDialog(z3);
        }
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        BannerAdViewImpl bannerAdViewImpl = this.f13099a;
        if (bannerAdViewImpl == null || onTouchListener == null) {
            return;
        }
        bannerAdViewImpl.setScrollClick(onTouchListener);
    }

    public void showAd() {
        this.f13099a.showAd();
    }

    public void adClick(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4) {
        if (this.f13099a != null) {
            c cVar = new c();
            if (!TextUtils.isEmpty(str)) {
                cVar.a(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                cVar.b(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                cVar.c(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.d(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                cVar.e(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                cVar.f(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                cVar.g(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                cVar.h(str8);
            }
            this.f13099a.clickArea(cVar, i4);
        }
    }
}
