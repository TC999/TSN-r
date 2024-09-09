package com.bytedance.msdk.api.fullVideo;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c;
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
public class TTFullVideoAd extends TTLoadBase {

    /* renamed from: a  reason: collision with root package name */
    private c f27460a;

    public TTFullVideoAd(Activity activity, String str) {
        this.f27460a = new c(activity, str);
    }

    public void destroy() {
        c cVar = this.f27460a;
        if (cVar != null) {
            cVar.o();
        }
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public List<AdLoadInfo> getAdLoadInfoList() {
        c cVar = this.f27460a;
        if (cVar != null) {
            return cVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public int getAdNetworkPlatformId() {
        if (hasPlatFormPermission()) {
            c cVar = this.f27460a;
            if (cVar != null) {
                return cVar.q();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getAdNetworkRitId() {
        if (hasPlatFormPermission()) {
            c cVar = this.f27460a;
            return cVar != null ? cVar.r() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.base.TTLoadBase
    public String getPreEcpm() {
        if (hasPlatFormPermission()) {
            c cVar = this.f27460a;
            return cVar != null ? cVar.s() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    public boolean isReady() {
        c cVar = this.f27460a;
        if (cVar != null) {
            return cVar.A();
        }
        return false;
    }

    public void loadFullAd(AdSlot adSlot, @NonNull TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback) {
        if (this.f27460a != null) {
            if (!a.f().a(this.f27460a.e(), 8) && tTFullVideoAdLoadCallback != null) {
                tTFullVideoAdLoadCallback.onFullVideoLoadFail(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
            } else if (a.f().s()) {
                this.f27460a.a(adSlot, tTFullVideoAdLoadCallback);
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
        c cVar = this.f27460a;
        if (cVar != null) {
            cVar.a(activity, map, tTFullVideoAdListener);
        }
    }
}
