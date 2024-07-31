package com.bytedance.sdk.openadsdk.mediation.p159ad;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MApiIMediationViewBinderReversal */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {

    /* renamed from: ok */
    private final Bridge f22630ok;

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.f22630ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        return ((Integer) this.f22630ok.call(271024, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        return ((Integer) this.f22630ok.call(271023, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        return (Map) this.f22630ok.call(271034, C5930a.m37924c(0).m37926a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        return ((Integer) this.f22630ok.call(271029, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        return ((Integer) this.f22630ok.call(271030, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        return ((Integer) this.f22630ok.call(271031, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getIconImageId() {
        return ((Integer) this.f22630ok.call(271025, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getLayoutId() {
        return ((Integer) this.f22630ok.call(271021, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        return ((Integer) this.f22630ok.call(271032, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getMainImageId() {
        return ((Integer) this.f22630ok.call(271026, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        return ((Integer) this.f22630ok.call(271027, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        return ((Integer) this.f22630ok.call(271033, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getSourceId() {
        return ((Integer) this.f22630ok.call(271028, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationViewBinderReversal
    public int getTitleId() {
        return ((Integer) this.f22630ok.call(271022, C5930a.m37924c(0).m37926a(), Integer.TYPE)).intValue();
    }
}
