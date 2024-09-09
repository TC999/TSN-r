package com.bytedance.msdk.api.banner;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTAdBannerListener extends ITTAdatperCallback {
    void onAdClicked();

    void onAdClosed();

    void onAdLeftApplication();

    void onAdOpened();

    void onAdShow();

    void onAdShowFail(AdError adError);
}
