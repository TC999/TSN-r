package com.bytedance.sdk.openadsdk.mediation;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IMediationNativeAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationNativeTokenInfo iMediationNativeTokenInfo);

    void onAdTokenLoadedFail(int i, String str);
}
