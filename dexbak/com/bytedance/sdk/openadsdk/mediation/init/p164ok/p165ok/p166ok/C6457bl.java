package com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6457bl {
    /* renamed from: ok */
    public static final ValueSet m36236ok(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        C5930a m37925b = C5930a.m37925b();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        m37925b.m37919h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        m37925b.m37918i(265001, mediationConfigUserInfoForSegment.getUserId());
        m37925b.m37918i(265002, mediationConfigUserInfoForSegment.getChannel());
        m37925b.m37918i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        m37925b.m37921f(265004, mediationConfigUserInfoForSegment.getAge());
        m37925b.m37918i(265005, mediationConfigUserInfoForSegment.getGender());
        m37925b.m37918i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return m37925b.m37926a();
    }
}
