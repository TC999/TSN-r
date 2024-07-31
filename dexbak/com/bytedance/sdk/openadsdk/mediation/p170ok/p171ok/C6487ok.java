package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6342a;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6487ok extends C6342a {
    /* renamed from: ok */
    public static AdSlot m36217ok(ValueSet valueSet) {
        AdSlot.Builder builder = new AdSlot.Builder();
        if (valueSet != null) {
            builder.setAdId(valueSet.stringValue(260001)).setCodeId(valueSet.stringValue(260002)).setExt(valueSet.stringValue(260003)).setCodeId(valueSet.stringValue(260004)).setIsAutoPlay(valueSet.booleanValue(260005)).setImageAcceptedSize(valueSet.intValue(260006), valueSet.intValue(260007)).setExpressViewAcceptedSize(valueSet.floatValue(260008), valueSet.floatValue(260009)).setSupportDeepLink(valueSet.booleanValue(260010)).setAdCount(valueSet.intValue(2600012)).setMediaExtra(valueSet.stringValue(260013)).setUserID(valueSet.stringValue(260014)).setExternalABVid((int[]) valueSet.objectValue(260017, int[].class)).setAdloadSeq(valueSet.intValue(260018)).setPrimeRit(valueSet.stringValue(260019)).setAdType(valueSet.intValue(260020)).withBid(valueSet.stringValue(260021)).setUserData(valueSet.stringValue(260022)).setAdLoadType((TTAdLoadType) valueSet.objectValue(260023, TTAdLoadType.class)).setMediationAdSlot((IMediationAdSlot) valueSet.objectValue(260027, IMediationAdSlot.class)).setOrientation(valueSet.intValue(260015)).setRewardName(valueSet.stringValue(260024)).setRewardAmount(valueSet.intValue(260025));
            if (valueSet.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    /* renamed from: ok */
    public static final ValueSet m36216ok(AdSlot adSlot) {
        C5930a m37916k = C5930a.m37916k(C6342a.m36536a(adSlot));
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            m37916k.m37919h(260026, new C6486n(adSlot.getMediationAdSlot()));
        }
        return m37916k.m37926a();
    }
}
