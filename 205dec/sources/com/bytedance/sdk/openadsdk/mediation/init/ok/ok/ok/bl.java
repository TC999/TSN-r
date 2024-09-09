package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl {
    public static final ValueSet ok(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        b4.h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        b4.i(265001, mediationConfigUserInfoForSegment.getUserId());
        b4.i(265002, mediationConfigUserInfoForSegment.getChannel());
        b4.i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        b4.f(265004, mediationConfigUserInfoForSegment.getAge());
        b4.i(265005, mediationConfigUserInfoForSegment.getGender());
        b4.i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return b4.a();
    }
}
