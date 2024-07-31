package com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.bl.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6342a {
    /* renamed from: a */
    public static final ValueSet m36536a(final AdSlot adSlot) {
        C5930a m37925b = C5930a.m37925b();
        if (adSlot == null) {
            return null;
        }
        m37925b.m37918i(260001, adSlot.getAdId());
        m37925b.m37918i(260002, adSlot.getCreativeId());
        m37925b.m37918i(260003, adSlot.getExt());
        m37925b.m37918i(260004, adSlot.getCodeId());
        m37925b.m37917j(260005, adSlot.isAutoPlay());
        m37925b.m37921f(260006, adSlot.getImgAcceptedWidth());
        m37925b.m37921f(260007, adSlot.getImgAcceptedHeight());
        m37925b.m37922e(260008, adSlot.getExpressViewAcceptedWidth());
        m37925b.m37922e(260009, adSlot.getExpressViewAcceptedHeight());
        m37925b.m37917j(260010, adSlot.isSupportDeepLink());
        m37925b.m37917j(260011, adSlot.isSupportRenderConrol());
        m37925b.m37921f(2600012, adSlot.getAdCount());
        m37925b.m37918i(260013, adSlot.getMediaExtra());
        m37925b.m37918i(260014, adSlot.getUserID());
        m37925b.m37921f(260015, adSlot.getOrientation());
        m37925b.m37921f(260016, adSlot.getNativeAdType());
        m37925b.m37919h(260017, adSlot.getExternalABVid());
        m37925b.m37921f(260018, adSlot.getAdloadSeq());
        m37925b.m37918i(260019, adSlot.getPrimeRit());
        m37925b.m37921f(260020, adSlot.getAdType());
        m37925b.m37918i(260021, adSlot.getBidAdm());
        m37925b.m37918i(260022, adSlot.getUserData());
        m37925b.m37919h(260023, adSlot.getAdLoadType());
        m37925b.m37919h(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.1
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        m37925b.m37919h(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.2
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        m37925b.m37919h(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.a.3
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        m37925b.m37919h(260026, adSlot.getMediationAdSlot());
        return m37925b.m37926a();
    }
}
