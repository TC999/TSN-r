package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {

    /* renamed from: a */
    private AdSlot f22622a;

    /* renamed from: bl */
    private List<String> f22623bl;

    /* renamed from: ok */
    private int f22624ok;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.f22624ok = i;
        this.f22622a = adSlot;
        this.f22623bl = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.f22622a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f22624ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.f22623bl;
    }
}
