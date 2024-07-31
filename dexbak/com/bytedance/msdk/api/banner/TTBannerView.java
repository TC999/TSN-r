package com.bytedance.msdk.api.banner;

import android.content.Context;
import android.view.View;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterBannerAdManager;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTBannerView extends TTLoadBase {

    /* renamed from: a */
    private TTInterBannerAdManager f21711a;

    public TTBannerView(Context context, String str) {
        this.f21711a = new TTInterBannerAdManager(context, str);
    }

    public void destroy() {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            tTInterBannerAdManager.mo37382o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            return tTInterBannerAdManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
            if (tTInterBannerAdManager != null) {
                return tTInterBannerAdManager.mo37380q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
            return tTInterBannerAdManager != null ? tTInterBannerAdManager.mo37379r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public View getBannerView() {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            return tTInterBannerAdManager.m59880A();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
            return tTInterBannerAdManager != null ? tTInterBannerAdManager.mo37378s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public void loadAd(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            tTInterBannerAdManager.m59877a(adSlot, tTAdBannerLoadCallBack);
        }
    }

    public void setAllowShowCloseBtn(boolean z) {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            tTInterBannerAdManager.m59874b(z);
        }
    }

    public void setRefreshTime(int i) {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            tTInterBannerAdManager.m59873c(i);
        }
    }

    public void setTTAdBannerListener(TTAdBannerListener tTAdBannerListener) {
        TTInterBannerAdManager tTInterBannerAdManager = this.f21711a;
        if (tTInterBannerAdManager != null) {
            tTInterBannerAdManager.m59876a(tTAdBannerListener);
        }
    }
}
