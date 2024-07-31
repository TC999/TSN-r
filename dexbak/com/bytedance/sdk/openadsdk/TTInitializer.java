package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTInitializer {
    TTAdManager getAdManager();

    @Deprecated
    TTAdManager init(Context context, AdConfig adConfig);

    void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
