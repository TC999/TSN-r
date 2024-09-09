package com.bytedance.sdk.openadsdk.mediation.init.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {
    public static final ValueSet c(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        b a4 = b.a();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        a4.h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        a4.i(265001, mediationConfigUserInfoForSegment.getUserId());
        a4.i(265002, mediationConfigUserInfoForSegment.getChannel());
        a4.i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        a4.e(265004, mediationConfigUserInfoForSegment.getAge());
        a4.i(265005, mediationConfigUserInfoForSegment.getGender());
        a4.i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return a4.l();
    }
}
