package com.bytedance.msdk.api.interstitial;

import android.app.Activity;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTInterstitialAd extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private a f27461a;

    public TTInterstitialAd(Activity activity, String str) {
        this.f27461a = new a(activity, str);
    }

    public void destroy() {
        a aVar = this.f27461a;
        if (aVar != null) {
            aVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        a aVar = this.f27461a;
        if (aVar != null) {
            return aVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            a aVar = this.f27461a;
            if (aVar != null) {
                return aVar.q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            a aVar = this.f27461a;
            return aVar != null ? aVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            a aVar = this.f27461a;
            return aVar != null ? aVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        a aVar = this.f27461a;
        if (aVar != null) {
            return aVar.A();
        }
        return false;
    }

    public void loadAd(AdSlot adSlot, TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback) {
        if (this.f27461a != null) {
            if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a(this.f27461a.e(), 2) && tTInterstitialAdLoadCallback != null) {
                tTInterstitialAdLoadCallback.onInterstitialLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().t()) {
                this.f27461a.a(adSlot, tTInterstitialAdLoadCallback);
            } else if (tTInterstitialAdLoadCallback != null) {
                tTInterstitialAdLoadCallback.onInterstitialLoadFail(new AdError(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE)));
            }
        }
    }

    public void setTTAdInterstitialListener(TTInterstitialAdListener tTInterstitialAdListener) {
        a aVar = this.f27461a;
        if (aVar != null) {
            aVar.a(tTInterstitialAdListener);
        }
    }

    public void showAd(Activity activity) {
        a aVar = this.f27461a;
        if (aVar != null) {
            if (activity == null) {
                Logger.e("TTMediationSDK", "activity can not be null !");
            } else {
                aVar.a(activity);
            }
        }
    }
}
