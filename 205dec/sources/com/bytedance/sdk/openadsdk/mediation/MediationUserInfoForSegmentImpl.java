package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationUserInfoForSegmentImpl implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private MediationConfigUserInfoForSegment f35990c;

    public MediationUserInfoForSegmentImpl(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        this.f35990c = mediationConfigUserInfoForSegment;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = this.f35990c;
        create.add(8468, mediationConfigUserInfoForSegment != null ? mediationConfigUserInfoForSegment.getCustomInfos() : new HashMap<>());
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment2 = this.f35990c;
        create.add(8469, mediationConfigUserInfoForSegment2 != null ? mediationConfigUserInfoForSegment2.getAge() : 0);
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment3 = this.f35990c;
        create.add(8470, mediationConfigUserInfoForSegment3 != null ? mediationConfigUserInfoForSegment3.getChannel() : "");
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment4 = this.f35990c;
        create.add(8471, mediationConfigUserInfoForSegment4 != null ? mediationConfigUserInfoForSegment4.getSubChannel() : "");
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment5 = this.f35990c;
        create.add(8472, mediationConfigUserInfoForSegment5 != null ? mediationConfigUserInfoForSegment5.getUserId() : "");
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment6 = this.f35990c;
        create.add(8473, mediationConfigUserInfoForSegment6 != null ? mediationConfigUserInfoForSegment6.getGender() : "");
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment7 = this.f35990c;
        create.add(8474, mediationConfigUserInfoForSegment7 != null ? mediationConfigUserInfoForSegment7.getUserValueGroup() : "");
        return create.build();
    }
}
