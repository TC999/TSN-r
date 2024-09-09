package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
class ANSplashAdViewAdapter extends BaseSplashAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private e mANSplash;

    public ANSplashAdViewAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.mANSplash = new e(context, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, "", com.qq.e.comm.plugin.b.l.f42028e);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchAdOnly() {
        this.mANSplash.fetchAdOnly();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchFullScreenAdOnly() {
        this.mANSplash.fetchFullScreenAdOnly();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public int getAdapterPriority() {
        return this.mANSplash.v();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.mANSplash.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.mANSplash.getCompetitionWinUrls();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.mANSplash.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public String getECPMLevel() {
        return this.mANSplash.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.mANSplash.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.mANSplash.getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.mANSplash.getExtraInfo().get(ConstantAd.KEY_CACHE_AD);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public Bitmap getZoomOutBitmap() {
        return this.mANSplash.getZoomOutBitmap();
    }

    public boolean isContractAd() {
        return this.mANSplash.x();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public boolean isValid() {
        return this.mANSplash.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setADListener(ADListener aDListener) {
        this.mANSplash.setAdListener(aDListener);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setDeveloperLogo(int i4) {
        this.mANSplash.setDeveloperLogo(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setFetchDelay(int i4) {
        this.mANSplash.setFetchDelay(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.mANSplash.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.mANSplash.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mANSplash.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setSkipView(View view) {
        this.mANSplash.setSkipView(view);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setSupportZoomOut(boolean z3) {
        this.mANSplash.setSupportZoomOut(z3);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void showAd(ViewGroup viewGroup) {
        this.mANSplash.showAd(viewGroup);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void showFullScreenAd(ViewGroup viewGroup) {
        this.mANSplash.showFullScreenAd(viewGroup);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void zoomOutAnimationFinish() {
        this.mANSplash.zoomOutAnimationFinish();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setDeveloperLogo(byte[] bArr) {
        this.mANSplash.setDeveloperLogo(bArr);
    }
}
