package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationNativeAppInfoImpl implements Bridge {

    /* renamed from: a */
    private MediationValueSetBuilder f22743a = MediationValueSetBuilder.create();

    /* renamed from: ok */
    private MediationNativeAdAppInfo f22744ok;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f22744ok = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f22744ok;
        if (mediationNativeAdAppInfo != null) {
            this.f22743a.add(8505, mediationNativeAdAppInfo.getAppName());
            this.f22743a.add(8506, this.f22744ok.getAuthorName());
            this.f22743a.add(8507, this.f22744ok.getPackageSizeBytes());
            this.f22743a.add(8508, this.f22744ok.getPermissionsUrl());
            this.f22743a.add(8509, this.f22744ok.getPermissionsMap());
            this.f22743a.add(8510, this.f22744ok.getPrivacyAgreement());
            this.f22743a.add(8511, this.f22744ok.getVersionName());
            this.f22743a.add(8512, this.f22744ok.getAppInfoExtra());
        }
        return this.f22743a.build();
    }
}
