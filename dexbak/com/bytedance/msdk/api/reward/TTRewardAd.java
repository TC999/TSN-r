package com.bytedance.msdk.api.reward;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterRewardVideoAdManager;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTRewardAd extends TTLoadBase {

    /* renamed from: a */
    private TTInterRewardVideoAdManager f21739a;

    public TTRewardAd(Activity activity, String str) {
        this.f21739a = new TTInterRewardVideoAdManager(activity, str);
    }

    public void destroy() {
        TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
        if (tTInterRewardVideoAdManager != null) {
            tTInterRewardVideoAdManager.mo37382o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
        if (tTInterRewardVideoAdManager != null) {
            return tTInterRewardVideoAdManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
            if (tTInterRewardVideoAdManager != null) {
                return tTInterRewardVideoAdManager.mo37380q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
            return tTInterRewardVideoAdManager != null ? tTInterRewardVideoAdManager.mo37379r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
            return tTInterRewardVideoAdManager != null ? tTInterRewardVideoAdManager.mo37378s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
        if (tTInterRewardVideoAdManager != null) {
            return tTInterRewardVideoAdManager.m37331A();
        }
        return false;
    }

    public void loadRewardAd(AdSlot adSlot, @NonNull TTRewardedAdLoadCallback tTRewardedAdLoadCallback) {
        if (this.f21739a != null) {
            if (!InternalContainer.m59943f().m59762a(this.f21739a.m37343e(), 7) && tTRewardedAdLoadCallback != null) {
                tTRewardedAdLoadCallback.onRewardVideoLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (InternalContainer.m59943f().m59724w()) {
                this.f21739a.m59852a(adSlot, tTRewardedAdLoadCallback);
            } else if (tTRewardedAdLoadCallback != null) {
                tTRewardedAdLoadCallback.onRewardVideoLoadFail(new AdError(AdError.ERROR_CODE_REWARD_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_REWARD_MODULE_UNABLE)));
            }
        }
    }

    @MainThread
    public void showRewardAd(Activity activity, TTRewardedAdListener tTRewardedAdListener) {
        showRewardAd(activity, null, tTRewardedAdListener);
    }

    @MainThread
    public void showRewardAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTRewardedAdListener tTRewardedAdListener) {
        TTInterRewardVideoAdManager tTInterRewardVideoAdManager = this.f21739a;
        if (tTInterRewardVideoAdManager != null) {
            tTInterRewardVideoAdManager.m59855a(activity, map, tTRewardedAdListener);
        }
    }
}
