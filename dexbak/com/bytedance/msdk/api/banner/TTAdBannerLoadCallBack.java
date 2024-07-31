package com.bytedance.msdk.api.banner;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTAdBannerLoadCallBack {
    void onAdFailedToLoad(AdError adError);

    void onAdLoaded();
}
