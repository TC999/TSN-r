package com.bytedance.msdk.api.fullVideo;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterFullVideoAdManager;
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
public class TTFullVideoAd extends TTLoadBase {

    /* renamed from: a */
    private TTInterFullVideoAdManager f21717a;

    public TTFullVideoAd(Activity activity, String str) {
        this.f21717a = new TTInterFullVideoAdManager(activity, str);
    }

    public void destroy() {
        TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
        if (tTInterFullVideoAdManager != null) {
            tTInterFullVideoAdManager.mo37382o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
        if (tTInterFullVideoAdManager != null) {
            return tTInterFullVideoAdManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
            if (tTInterFullVideoAdManager != null) {
                return tTInterFullVideoAdManager.mo37380q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
            return tTInterFullVideoAdManager != null ? tTInterFullVideoAdManager.mo37379r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
            return tTInterFullVideoAdManager != null ? tTInterFullVideoAdManager.mo37378s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
        if (tTInterFullVideoAdManager != null) {
            return tTInterFullVideoAdManager.m37331A();
        }
        return false;
    }

    public void loadFullAd(AdSlot adSlot, @NonNull TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback) {
        if (this.f21717a != null) {
            if (!InternalContainer.m59943f().m59762a(this.f21717a.m37343e(), 8) && tTFullVideoAdLoadCallback != null) {
                tTFullVideoAdLoadCallback.onFullVideoLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (InternalContainer.m59943f().m59728s()) {
                this.f21717a.m59867a(adSlot, tTFullVideoAdLoadCallback);
            } else if (tTFullVideoAdLoadCallback != null) {
                tTFullVideoAdLoadCallback.onFullVideoLoadFail(new AdError(AdError.ERROR_CODE_FULL_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FULL_MODULE_UNABLE)));
            }
        }
    }

    @MainThread
    public void showFullAd(Activity activity, TTFullVideoAdListener tTFullVideoAdListener) {
        showFullAd(activity, null, tTFullVideoAdListener);
    }

    @MainThread
    public void showFullAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTFullVideoAdListener tTFullVideoAdListener) {
        TTInterFullVideoAdManager tTInterFullVideoAdManager = this.f21717a;
        if (tTInterFullVideoAdManager != null) {
            tTInterFullVideoAdManager.m59870a(activity, map, tTFullVideoAdListener);
        }
    }
}
