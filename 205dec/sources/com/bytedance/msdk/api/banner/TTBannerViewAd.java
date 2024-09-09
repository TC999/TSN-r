package com.bytedance.msdk.api.banner;

import android.app.Activity;
import android.view.View;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTBannerViewAd extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private b f27443a;

    public TTBannerViewAd(Activity activity, String str) {
        this.f27443a = new b(activity, str);
    }

    public void destroy() {
        b bVar = this.f27443a;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        b bVar = this.f27443a;
        if (bVar != null) {
            return bVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            b bVar = this.f27443a;
            if (bVar != null) {
                return bVar.q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            b bVar = this.f27443a;
            return bVar != null ? bVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public View getBannerView() {
        b bVar = this.f27443a;
        if (bVar != null) {
            return bVar.A();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            b bVar = this.f27443a;
            return bVar != null ? bVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public void loadAd(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        if (this.f27443a != null) {
            if (!a.f().a(this.f27443a.e(), 1) && tTAdBannerLoadCallBack != null) {
                tTAdBannerLoadCallBack.onAdFailedToLoad(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (a.f().o()) {
                this.f27443a.a(adSlot, tTAdBannerLoadCallBack);
            } else if (tTAdBannerLoadCallBack != null) {
                tTAdBannerLoadCallBack.onAdFailedToLoad(new AdError(AdError.ERROR_CODE_BANNER_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_BANNER_MODULE_UNABLE)));
            }
        }
    }

    public void setAllowShowCloseBtn(boolean z3) {
        b bVar = this.f27443a;
        if (bVar != null) {
            bVar.b(z3);
        }
    }

    public void setRefreshTime(int i4) {
        b bVar = this.f27443a;
        if (bVar != null) {
            bVar.c(i4);
        }
    }

    public void setTTAdBannerListener(TTAdBannerListener tTAdBannerListener) {
        b bVar = this.f27443a;
        if (bVar != null) {
            bVar.a(tTAdBannerListener);
        }
    }
}
