package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class ANRewardVideoAdAdapter extends BaseRewardAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private c mDelegate;
    private ADListener mListener;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ANRewardVideoAdAdapter.this.mListener != null) {
                ANRewardVideoAdAdapter.this.mListener.onADEvent(aDEvent);
            }
        }
    }

    public ANRewardVideoAdAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.mDelegate = new c(context, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, com.qq.e.comm.plugin.b.l.f42028e, "", new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getAdapterPriority() {
        return this.mDelegate.l();
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

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public String getECPMLevel() {
        return this.mDelegate.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public long getExpireTimestamp() {
        return this.mDelegate.getExpireTimestamp();
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

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getVideoDuration() {
        return this.mDelegate.getVideoDuration();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public boolean hasShown() {
        return this.mDelegate.hasShown();
    }

    public boolean isContractAd() {
        return this.mDelegate.o();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public boolean isValid() {
        return this.mDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void loadAD() {
        this.mDelegate.loadAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.mDelegate.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setVolumeOn(boolean z3) {
        this.mDelegate.setVolumeOn(z3);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD() {
        this.mDelegate.showAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD(Activity activity) {
        this.mDelegate.showAD(activity);
    }
}
