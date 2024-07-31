package com.bytedance.sdk.openadsdk.mediation.p159ad;

import androidx.annotation.Nullable;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IMediationAdSlot {
    @Nullable
    Map<String, Object> getExtraObject();

    @Nullable
    IMediationNativeToBannerListener getMediationNativeToBannerListener();

    @Nullable
    IMediationSplashRequestInfo getMediationSplashRequestInfo();

    int getRewardAmount();

    @Nullable
    String getRewardName();

    @Nullable
    String getScenarioId();

    float getShakeViewHeight();

    float getShakeViewWidth();

    float getVolume();

    @Nullable
    String getWxAppId();

    boolean isAllowShowCloseBtn();

    boolean isBidNotify();

    boolean isMuted();

    boolean isSplashPreLoad();

    boolean isSplashShakeButton();

    boolean isUseSurfaceView();
}
