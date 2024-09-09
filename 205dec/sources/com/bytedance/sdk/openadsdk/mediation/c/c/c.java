package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c extends com.bytedance.sdk.openadsdk.ys.c.xv.w {
    public static AdSlot c(ValueSet valueSet) {
        AdSlot.Builder builder = new AdSlot.Builder();
        if (valueSet != null) {
            builder.setAdId(valueSet.stringValue(260001)).setCodeId(valueSet.stringValue(260002)).setExt(valueSet.stringValue(260003)).setCodeId(valueSet.stringValue(260004)).setIsAutoPlay(valueSet.booleanValue(260005)).setImageAcceptedSize(valueSet.intValue(260006), valueSet.intValue(260007)).setExpressViewAcceptedSize(valueSet.floatValue(260008), valueSet.floatValue(260009)).setSupportDeepLink(valueSet.booleanValue(260010)).setAdCount(valueSet.intValue(2600012)).setMediaExtra(valueSet.stringValue(260013)).setUserID(valueSet.stringValue(260014)).setExternalABVid((int[]) valueSet.objectValue(260017, int[].class)).setAdloadSeq(valueSet.intValue(260018)).setPrimeRit(valueSet.stringValue(260019)).setAdType(valueSet.intValue(260020)).withBid(valueSet.stringValue(260021)).setUserData(valueSet.stringValue(260022)).setAdLoadType((TTAdLoadType) valueSet.objectValue(260023, TTAdLoadType.class)).setMediationAdSlot((IMediationAdSlot) valueSet.objectValue(260027, IMediationAdSlot.class)).setOrientation(valueSet.intValue(260015)).setRewardName((String) valueSet.objectValue(260024, String.class)).setRewardAmount(valueSet.intValue(260025));
            if (valueSet.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    public static final ValueSet c(AdSlot adSlot) {
        b k4 = b.k(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot));
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            k4.h(8260028, new ux(adSlot.getMediationAdSlot()));
        }
        return k4.l();
    }
}
