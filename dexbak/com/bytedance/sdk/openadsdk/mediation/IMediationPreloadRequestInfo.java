package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IMediationPreloadRequestInfo {
    AdSlot getAdSlot();

    int getAdType();

    List<String> getPrimeRitList();
}
