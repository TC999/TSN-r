package com.bytedance.msdk.api.nativeAd;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.AdSlot;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTUnifiedNativeAd {

    /* renamed from: a  reason: collision with root package name */
    private d f27468a;

    public TTUnifiedNativeAd(Context context, String str) {
        this.f27468a = new d(context, str);
    }

    public void destroy() {
        d dVar = this.f27468a;
        if (dVar != null) {
            dVar.o();
        }
    }

    public List<AdLoadInfo> getAdLoadInfoList() {
        d dVar = this.f27468a;
        if (dVar != null) {
            return dVar.getAdLoadInfoList();
        }
        return new ArrayList();
    }

    public void loadAd(AdSlot adSlot, TTNativeAdLoadCallback tTNativeAdLoadCallback) {
        if (this.f27468a != null) {
            if (!a.f().a(this.f27468a.e(), 5) && tTNativeAdLoadCallback != null) {
                tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME, AdError.getMessage(AdError.ERROR_CODE_RIT_ADTYPE_NO_SAME)));
                return;
            }
            if (adSlot != null) {
                if (adSlot.getAdStyleType() == 1) {
                    if (!a.f().r()) {
                        if (tTNativeAdLoadCallback != null) {
                            tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_FEED_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_FEED_MODULE_UNABLE)));
                            return;
                        }
                        return;
                    }
                } else if (adSlot.getAdStyleType() == 2 && !a.f().u()) {
                    if (tTNativeAdLoadCallback != null) {
                        tTNativeAdLoadCallback.onAdLoadedFial(new AdError(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE, AdError.getMessage(AdError.ERROR_CODE_NATIVE_MODULE_UNABLE)));
                        return;
                    }
                    return;
                }
            }
            this.f27468a.a(adSlot, tTNativeAdLoadCallback);
        }
    }
}
