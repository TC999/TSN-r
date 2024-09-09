package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class ANInterstitialAdAdapter extends BaseInterstitialAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private ADListener mListener;
    private f unifiedInterstitialADDelegate;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANInterstitialAdAdapter.this.mListener != null) {
                ANInterstitialAdAdapter.this.mListener.onADEvent(aDEvent);
            }
        }
    }

    public ANInterstitialAdAdapter(Activity activity, String str, String str2, String str3) {
        super(activity, str, str2, str3);
        this.unifiedInterstitialADDelegate = new f(activity, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, "", l.f42028e, new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void close() {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.close();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void destory() {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.destroy();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdPatternType() {
        return this.unifiedInterstitialADDelegate.getAdPatternType();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdapterPriority() {
        return this.unifiedInterstitialADDelegate.a();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        return this.unifiedInterstitialADDelegate.getCompetitionFailureUrls();
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        return this.unifiedInterstitialADDelegate.getCompetitionWinUrls();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        return this.unifiedInterstitialADDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public String getECPMLevel() {
        return this.unifiedInterstitialADDelegate.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        return this.unifiedInterstitialADDelegate.getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.unifiedInterstitialADDelegate.getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj = this.unifiedInterstitialADDelegate.getExtraInfo().get(ConstantAd.KEY_CACHE_AD);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getVideoDuration() {
        return this.unifiedInterstitialADDelegate.getVideoDuration();
    }

    public boolean isContractAd() {
        return this.unifiedInterstitialADDelegate.b();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public boolean isValid() {
        return this.unifiedInterstitialADDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void loadAd() {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.loadAd();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void loadFullScreenAD() {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.loadFullScreenAD();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMaxVideoDuration(int i4) {
        this.unifiedInterstitialADDelegate.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.unifiedInterstitialADDelegate.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMinVideoDuration(int i4) {
        this.unifiedInterstitialADDelegate.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.unifiedInterstitialADDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setVideoOption(VideoOption videoOption) {
        this.unifiedInterstitialADDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show() {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.show();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void showFullScreenAD(Activity activity) {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.showFullScreenAD(activity);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show(Activity activity) {
        f fVar = this.unifiedInterstitialADDelegate;
        if (fVar != null) {
            fVar.show(activity);
        }
    }
}
