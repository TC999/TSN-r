package com.bytedance.msdk.api.interstitial;

import android.app.Activity;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterAdInterstitialManager;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTInterstitialAd extends TTLoadBase {

    /* renamed from: a */
    private TTInterAdInterstitialManager f21718a;

    public TTInterstitialAd(Activity activity, String str) {
        this.f21718a = new TTInterAdInterstitialManager(activity, str);
    }

    public void destroy() {
        TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
        if (tTInterAdInterstitialManager != null) {
            tTInterAdInterstitialManager.mo37382o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
        if (tTInterAdInterstitialManager != null) {
            return tTInterAdInterstitialManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
            if (tTInterAdInterstitialManager != null) {
                return tTInterAdInterstitialManager.mo37380q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
            return tTInterAdInterstitialManager != null ? tTInterAdInterstitialManager.mo37379r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
            return tTInterAdInterstitialManager != null ? tTInterAdInterstitialManager.mo37378s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
        if (tTInterAdInterstitialManager != null) {
            return tTInterAdInterstitialManager.m37331A();
        }
        return false;
    }

    public void loadAd(AdSlot adSlot, TTInterstitialAdLoadCallback tTInterstitialAdLoadCallback) {
        if (this.f21718a != null) {
            if (!InternalContainer.m59943f().m59762a(this.f21718a.m37343e(), 2) && tTInterstitialAdLoadCallback != null) {
                tTInterstitialAdLoadCallback.onInterstitialLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (InternalContainer.m59943f().m59727t()) {
                this.f21718a.m59883a(adSlot, tTInterstitialAdLoadCallback);
            } else if (tTInterstitialAdLoadCallback != null) {
                tTInterstitialAdLoadCallback.onInterstitialLoadFail(new AdError(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_INTERACTION_MODULE_UNABLE)));
            }
        }
    }

    public void setTTAdInterstitialListener(TTInterstitialAdListener tTInterstitialAdListener) {
        TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
        if (tTInterAdInterstitialManager != null) {
            tTInterAdInterstitialManager.m59882a(tTInterstitialAdListener);
        }
    }

    public void showAd(Activity activity) {
        TTInterAdInterstitialManager tTInterAdInterstitialManager = this.f21718a;
        if (tTInterAdInterstitialManager != null) {
            if (activity == null) {
                Logger.m37557e("TTMediationSDK", "activity can not be null !");
            } else {
                tTInterAdInterstitialManager.m59886a(activity);
            }
        }
    }
}
