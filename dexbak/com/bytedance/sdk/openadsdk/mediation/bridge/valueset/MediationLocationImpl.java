package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationLocationImpl implements Bridge {

    /* renamed from: ok */
    private IMediationLocation f22756ok;

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.f22756ok = iMediationLocation;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.f22756ok;
        double d = Utils.DOUBLE_EPSILON;
        create.add(8481, iMediationLocation != null ? iMediationLocation.getLatitude() : 0.0d);
        IMediationLocation iMediationLocation2 = this.f22756ok;
        if (iMediationLocation2 != null) {
            d = iMediationLocation2.getLongitude();
        }
        create.add(8482, d);
        return create.build();
    }
}
