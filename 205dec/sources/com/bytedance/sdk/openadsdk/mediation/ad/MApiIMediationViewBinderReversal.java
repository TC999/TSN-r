package com.bytedance.sdk.openadsdk.mediation.ad;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35991c;

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.f35991c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        return ((Integer) this.f35991c.call(271024, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        return ((Integer) this.f35991c.call(271023, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        return (Map) this.f35991c.call(271034, b.b(0).l(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        return ((Integer) this.f35991c.call(271029, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        return ((Integer) this.f35991c.call(271030, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        return ((Integer) this.f35991c.call(271031, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        return ((Integer) this.f35991c.call(271025, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        return ((Integer) this.f35991c.call(271021, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        return ((Integer) this.f35991c.call(271032, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        return ((Integer) this.f35991c.call(271026, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        return ((Integer) this.f35991c.call(271027, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        return ((Integer) this.f35991c.call(271033, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        return ((Integer) this.f35991c.call(271028, b.b(0).l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        return ((Integer) this.f35991c.call(271022, b.b(0).l(), Integer.TYPE)).intValue();
    }
}
