package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IMediationInterstitialFullAdListener extends TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialFullShowFail(int i4, String str);

    void onRewardVerify(Bundle bundle);

    void onVideoError();
}
