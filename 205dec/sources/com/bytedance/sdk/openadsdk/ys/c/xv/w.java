package com.bytedance.sdk.openadsdk.ys.c.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {
    public static final ValueSet w(final AdSlot adSlot) {
        b a4 = b.a();
        if (adSlot == null) {
            return null;
        }
        a4.i(260001, adSlot.getAdId());
        a4.i(260002, adSlot.getCreativeId());
        a4.i(260003, adSlot.getExt());
        a4.i(260004, adSlot.getCodeId());
        a4.j(260005, adSlot.isAutoPlay());
        a4.e(260006, adSlot.getImgAcceptedWidth());
        a4.e(260007, adSlot.getImgAcceptedHeight());
        a4.d(260008, adSlot.getExpressViewAcceptedWidth());
        a4.d(260009, adSlot.getExpressViewAcceptedHeight());
        a4.j(260010, adSlot.isSupportDeepLink());
        a4.j(260011, adSlot.isSupportRenderConrol());
        a4.e(2600012, adSlot.getAdCount());
        a4.i(260013, adSlot.getMediaExtra());
        a4.i(260014, adSlot.getUserID());
        a4.e(260015, adSlot.getOrientation());
        a4.e(260016, adSlot.getNativeAdType());
        a4.h(260017, adSlot.getExternalABVid());
        a4.e(260018, adSlot.getAdloadSeq());
        a4.i(260019, adSlot.getPrimeRit());
        a4.e(260020, adSlot.getAdType());
        a4.i(260021, adSlot.getBidAdm());
        a4.i(260022, adSlot.getUserData());
        a4.h(260023, adSlot.getAdLoadType());
        a4.h(260024, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.w.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return AdSlot.this.getRewardName();
            }
        });
        a4.h(260025, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.w.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdSlot.this.getRewardAmount());
            }
        });
        a4.h(260026, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.w.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(AdSlot.this.isSupportIconStyle());
            }
        });
        a4.h(8260028, adSlot.getMediationAdSlot());
        return a4.l();
    }
}
