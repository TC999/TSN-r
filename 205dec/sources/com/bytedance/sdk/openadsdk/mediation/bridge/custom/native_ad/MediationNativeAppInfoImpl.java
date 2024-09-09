package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationNativeAppInfoImpl implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private MediationNativeAdAppInfo f36086c;

    /* renamed from: w  reason: collision with root package name */
    private MediationValueSetBuilder f36087w = MediationValueSetBuilder.create();

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f36086c = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f36086c;
        if (mediationNativeAdAppInfo != null) {
            this.f36087w.add(8505, mediationNativeAdAppInfo.getAppName());
            this.f36087w.add(8506, this.f36086c.getAuthorName());
            this.f36087w.add(8507, this.f36086c.getPackageSizeBytes());
            this.f36087w.add(8508, this.f36086c.getPermissionsUrl());
            this.f36087w.add(8509, this.f36086c.getPermissionsMap());
            this.f36087w.add(8510, this.f36086c.getPrivacyAgreement());
            this.f36087w.add(8511, this.f36086c.getVersionName());
            this.f36087w.add(8512, this.f36086c.getAppInfoExtra());
        }
        return this.f36087w.build();
    }
}
