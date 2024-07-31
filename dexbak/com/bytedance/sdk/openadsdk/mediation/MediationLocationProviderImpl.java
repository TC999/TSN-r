package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationLocationProviderImpl implements Bridge, LocationProvider {

    /* renamed from: ok */
    private LocationProvider f22618ok;

    public MediationLocationProviderImpl(LocationProvider locationProvider) {
        this.f22618ok = locationProvider;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8481) {
            return (T) Double.valueOf(getLatitude());
        }
        if (i == 8482) {
            return (T) Double.valueOf(getLongitude());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        LocationProvider locationProvider = this.f22618ok;
        return locationProvider != null ? locationProvider.getLatitude() : Utils.DOUBLE_EPSILON;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        LocationProvider locationProvider = this.f22618ok;
        return locationProvider != null ? locationProvider.getLongitude() : Utils.DOUBLE_EPSILON;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
