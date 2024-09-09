package com.bytedance.msdk.api.banner;

import android.content.Context;
import android.view.View;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.base.TTLoadBase;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTBannerView extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private b f27442a;

    public TTBannerView(Context context, String str) {
        this.f27442a = new b(context, str);
    }

    public void destroy() {
        b bVar = this.f27442a;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        b bVar = this.f27442a;
        if (bVar != null) {
            return bVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            b bVar = this.f27442a;
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
            b bVar = this.f27442a;
            return bVar != null ? bVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public View getBannerView() {
        b bVar = this.f27442a;
        if (bVar != null) {
            return bVar.A();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            b bVar = this.f27442a;
            return bVar != null ? bVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public void loadAd(AdSlot adSlot, TTAdBannerLoadCallBack tTAdBannerLoadCallBack) {
        b bVar = this.f27442a;
        if (bVar != null) {
            bVar.a(adSlot, tTAdBannerLoadCallBack);
        }
    }

    public void setAllowShowCloseBtn(boolean z3) {
        b bVar = this.f27442a;
        if (bVar != null) {
            bVar.b(z3);
        }
    }

    public void setRefreshTime(int i4) {
        b bVar = this.f27442a;
        if (bVar != null) {
            bVar.c(i4);
        }
    }

    public void setTTAdBannerListener(TTAdBannerListener tTAdBannerListener) {
        b bVar = this.f27442a;
        if (bVar != null) {
            bVar.a(tTAdBannerListener);
        }
    }
}
