package com.bytedance.msdk.api.nativeAd;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.TTInterNativeAdManager;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTUnifiedNativeAd {

    /* renamed from: a */
    private TTInterNativeAdManager f21725a;

    public TTUnifiedNativeAd(Context context, String str) {
        this.f21725a = new TTInterNativeAdManager(context, str);
    }

    public void destroy() {
        TTInterNativeAdManager tTInterNativeAdManager = this.f21725a;
        if (tTInterNativeAdManager != null) {
            tTInterNativeAdManager.mo37382o();
        }
    }

    public List<AdLoadInfo> getAdLoadInfoList() {
        TTInterNativeAdManager tTInterNativeAdManager = this.f21725a;
        if (tTInterNativeAdManager != null) {
            return tTInterNativeAdManager.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    public void loadAd(AdSlot adSlot, TTNativeAdLoadCallback tTNativeAdLoadCallback) {
        if (this.f21725a != null) {
            if (!InternalContainer.m59943f().m59762a(this.f21725a.m37343e(), 5) && tTNativeAdLoadCallback != null) {
                tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
                return;
            }
            if (adSlot != null) {
                if (adSlot.getAdStyleType() == 1) {
                    if (!InternalContainer.m59943f().m59729r()) {
                        if (tTNativeAdLoadCallback != null) {
                            tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_FEED_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FEED_MODULE_UNABLE)));
                            return;
                        }
                        return;
                    }
                } else if (adSlot.getAdStyleType() == 2 && !InternalContainer.m59943f().m59726u()) {
                    if (tTNativeAdLoadCallback != null) {
                        tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE)));
                        return;
                    }
                    return;
                }
            }
            this.f21725a.m59862a(adSlot, tTNativeAdLoadCallback);
        }
    }
}
