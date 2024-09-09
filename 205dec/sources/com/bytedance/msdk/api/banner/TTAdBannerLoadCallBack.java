package com.bytedance.msdk.api.banner;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTAdBannerLoadCallBack {
    void onAdFailedToLoad(AdError adError);

    void onAdLoaded();
}
