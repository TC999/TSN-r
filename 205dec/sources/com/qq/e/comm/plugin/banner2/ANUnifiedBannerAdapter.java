package com.qq.e.comm.plugin.banner2;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
class ANUnifiedBannerAdapter extends BaseBannerAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private ADListener mADListener;
    private f mDelegate;
    private final UnifiedBannerView mUnifiedBannerView;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANUnifiedBannerAdapter.this.mADListener != null) {
                ANUnifiedBannerAdapter.this.mADListener.onADEvent(aDEvent);
            }
        }
    }

    public ANUnifiedBannerAdapter(Activity activity, String str, String str2, String str3) {
        super(activity, str, str2, str3);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(activity, str2, null);
        this.mUnifiedBannerView = unifiedBannerView;
        f fVar = new f(unifiedBannerView, activity, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, "", new a(), l.f42028e);
        this.mDelegate = fVar;
        fVar.setRefresh(0);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void destroy() {
        this.mDelegate.destroy();
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public View getAdView() {
        return this.mUnifiedBannerView;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.mDelegate.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.mDelegate.getCompetitionWinUrls();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.mDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.mDelegate.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.mDelegate.getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.mDelegate.getExtraInfo().get(ConstantAd.KEY_CACHE_AD);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public boolean isContractAd() {
        return false;
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public boolean isValid() {
        return this.mDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void loadAD() {
        this.mDelegate.fetchAd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onWindowFocusChanged(boolean z3) {
        this.mDelegate.onWindowFocusChanged(z3);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setAdListener(ADListener aDListener) {
        this.mADListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setAdSize(int i4, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.mDelegate.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.mDelegate.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseBannerAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
