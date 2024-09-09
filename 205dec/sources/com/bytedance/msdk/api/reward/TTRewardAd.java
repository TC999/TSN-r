package com.bytedance.msdk.api.reward;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTRewardAd extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private e f27482a;

    public TTRewardAd(Activity activity, String str) {
        this.f27482a = new e(activity, str);
    }

    public void destroy() {
        e eVar = this.f27482a;
        if (eVar != null) {
            eVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        e eVar = this.f27482a;
        if (eVar != null) {
            return eVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            e eVar = this.f27482a;
            if (eVar != null) {
                return eVar.q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            e eVar = this.f27482a;
            return eVar != null ? eVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            e eVar = this.f27482a;
            return eVar != null ? eVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        e eVar = this.f27482a;
        if (eVar != null) {
            return eVar.A();
        }
        return false;
    }

    public void loadRewardAd(AdSlot adSlot, @NonNull TTRewardedAdLoadCallback tTRewardedAdLoadCallback) {
        if (this.f27482a != null) {
            if (!a.f().a(this.f27482a.e(), 7) && tTRewardedAdLoadCallback != null) {
                tTRewardedAdLoadCallback.onRewardVideoLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (a.f().w()) {
                this.f27482a.a(adSlot, tTRewardedAdLoadCallback);
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
        e eVar = this.f27482a;
        if (eVar != null) {
            eVar.a(activity, map, tTRewardedAdListener);
        }
    }
}
