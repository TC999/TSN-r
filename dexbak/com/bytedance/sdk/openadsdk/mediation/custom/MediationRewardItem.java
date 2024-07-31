package com.bytedance.sdk.openadsdk.mediation.custom;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MediationRewardItem {
    float getAmount();

    Map<String, Object> getCustomData();

    String getRewardName();

    boolean rewardVerify();
}
