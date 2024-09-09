package com.bytedance.msdk.api.nativeAd;

import com.bytedance.msdk.api.AdError;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTNativeAdLoadCallback {
    void onAdLoaded(List<TTNativeAd> list);

    void onAdLoadedFial(AdError adError);
}
