package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationLocationProviderImpl implements Bridge, LocationProvider {

    /* renamed from: c  reason: collision with root package name */
    private LocationProvider f35981c;

    public MediationLocationProviderImpl(LocationProvider locationProvider) {
        this.f35981c = locationProvider;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8481) {
            return (T) Double.valueOf(getLatitude());
        }
        if (i4 == 8482) {
            return (T) Double.valueOf(getLongitude());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        LocationProvider locationProvider = this.f35981c;
        if (locationProvider != null) {
            return locationProvider.getLatitude();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        LocationProvider locationProvider = this.f35981c;
        if (locationProvider != null) {
            return locationProvider.getLongitude();
        }
        return 0.0d;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
