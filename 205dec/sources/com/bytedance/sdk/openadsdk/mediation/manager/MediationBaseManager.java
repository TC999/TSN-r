package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface MediationBaseManager {
    List<MediationAdLoadInfo> getAdLoadInfo();

    MediationAdEcpmInfo getBestEcpm();

    List<MediationAdEcpmInfo> getCacheList();

    List<MediationAdEcpmInfo> getMultiBiddingEcpm();

    MediationAdEcpmInfo getShowEcpm();

    boolean isReady();
}
