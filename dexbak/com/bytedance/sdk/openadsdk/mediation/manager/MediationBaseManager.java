package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MediationBaseManager {
    List<MediationAdLoadInfo> getAdLoadInfo();

    MediationAdEcpmInfo getBestEcpm();

    List<MediationAdEcpmInfo> getCacheList();

    List<MediationAdEcpmInfo> getMultiBiddingEcpm();

    MediationAdEcpmInfo getShowEcpm();

    boolean isReady();
}
