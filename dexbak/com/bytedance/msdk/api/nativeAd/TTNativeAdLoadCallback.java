package com.bytedance.msdk.api.nativeAd;

import com.bytedance.msdk.api.AdError;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTNativeAdLoadCallback {
    void onAdLoaded(List<TTNativeAd> list);

    void onAdLoadedFial(AdError adError);
}
