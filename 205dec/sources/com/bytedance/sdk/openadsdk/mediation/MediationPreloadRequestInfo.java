package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {

    /* renamed from: c  reason: collision with root package name */
    private int f35984c;

    /* renamed from: w  reason: collision with root package name */
    private AdSlot f35985w;
    private List<String> xv;

    public MediationPreloadRequestInfo(int i4, AdSlot adSlot, List<String> list) {
        this.f35984c = i4;
        this.f35985w = adSlot;
        this.xv = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.f35985w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f35984c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.xv;
    }
}
