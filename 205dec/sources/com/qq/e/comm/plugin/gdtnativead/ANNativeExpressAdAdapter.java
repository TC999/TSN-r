package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
class ANNativeExpressAdAdapter extends BaseNativeExpressAd implements com.qq.e.comm.plugin.e0.b, com.qq.e.comm.plugin.e0.a {
    private List<NativeExpressADView> mAdViews;
    private g mDelegate;
    private NativeExpressADView mExpressADView;
    private ADListener mListener;

    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent != null && aDEvent.getType() == 100) {
                try {
                    ANNativeExpressAdAdapter.this.mAdViews = (List) aDEvent.getParam(List.class);
                    if (ANNativeExpressAdAdapter.this.mAdViews != null && ANNativeExpressAdAdapter.this.mAdViews.size() > 0) {
                        ANNativeExpressAdAdapter.this.mExpressADView = (NativeExpressADView) ANNativeExpressAdAdapter.this.mAdViews.get(0);
                    }
                } catch (Exception e4) {
                    d1.a("ANNativeExpressAdAdapter cast exception", e4);
                }
            }
            if (ANNativeExpressAdAdapter.this.mListener == null || aDEvent == null) {
                return;
            }
            ANNativeExpressAdAdapter.this.mListener.onADEvent(aDEvent);
        }
    }

    public ANNativeExpressAdAdapter(Context context, ADSize aDSize, String str, String str2, String str3) {
        super(context, aDSize, str, str2, str3);
        this.mDelegate = new g(context, aDSize, com.qq.e.comm.plugin.d0.a.d().b().a(), str2, com.qq.e.comm.plugin.b.l.f42028e, "", new a());
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
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || nativeExpressADView.getBoundData() == null) {
            return -1;
        }
        return this.mExpressADView.getBoundData().getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView != null && nativeExpressADView.getBoundData() != null) {
            return this.mExpressADView.getBoundData().getExtraInfo();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || !(nativeExpressADView.getBoundData() instanceof com.qq.e.comm.plugin.b.n)) {
            return -1;
        }
        return ((com.qq.e.comm.plugin.b.n) this.mExpressADView.getBoundData()).getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj;
        Map<String, Object> extraInfo = getExtraInfo();
        if (extraInfo == null || (obj = extraInfo.get(ConstantAd.KEY_CACHE_AD)) == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean isContractAd() {
        NativeExpressADView nativeExpressADView = this.mExpressADView;
        if (nativeExpressADView == null || !(nativeExpressADView.getBoundData() instanceof com.qq.e.comm.plugin.b.n)) {
            return false;
        }
        return ((com.qq.e.comm.plugin.b.n) this.mExpressADView.getBoundData()).a();
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i4) {
        this.mDelegate.loadAd(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setECPMLevel(String str) {
        List<NativeExpressADView> list = this.mAdViews;
        if (list != null) {
            for (NativeExpressADView nativeExpressADView : list) {
                ((com.qq.e.comm.plugin.b.n) nativeExpressADView.getBoundData()).setECPMLevel(str);
            }
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMaxVideoDuration(int i4) {
        this.mDelegate.setMaxVideoDuration(i4);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
        this.mDelegate.setMediationId(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMinVideoDuration(int i4) {
        this.mDelegate.setMinVideoDuration(i4);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.mDelegate.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setVideoOption(VideoOption videoOption) {
        this.mDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i4, LoadAdParams loadAdParams) {
        this.mDelegate.loadAd(i4, loadAdParams);
    }
}
