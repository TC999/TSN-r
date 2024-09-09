package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationLocationImpl implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private IMediationLocation f36095c;

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.f36095c = iMediationLocation;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.f36095c;
        create.add(8481, iMediationLocation != null ? iMediationLocation.getLatitude() : 0.0d);
        IMediationLocation iMediationLocation2 = this.f36095c;
        create.add(8482, iMediationLocation2 != null ? iMediationLocation2.getLongitude() : 0.0d);
        return create.build();
    }
}
