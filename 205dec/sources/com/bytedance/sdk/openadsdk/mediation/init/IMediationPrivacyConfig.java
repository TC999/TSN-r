package com.bytedance.sdk.openadsdk.mediation.init;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IMediationPrivacyConfig {
    @Nullable
    List<String> getCustomAppList();

    @Nullable
    List<String> getCustomDevImeis();

    boolean isCanUseOaid();

    boolean isLimitPersonalAds();

    boolean isProgrammaticRecommend();
}
