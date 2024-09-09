package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
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
