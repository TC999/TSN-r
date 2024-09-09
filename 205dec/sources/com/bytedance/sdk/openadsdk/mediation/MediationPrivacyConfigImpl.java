package com.bytedance.sdk.openadsdk.mediation;

import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationPrivacyConfigImpl extends MediationPrivacyConfig implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private IMediationPrivacyConfig f35986c;

    public MediationPrivacyConfigImpl(IMediationPrivacyConfig iMediationPrivacyConfig) {
        this.f35986c = iMediationPrivacyConfig;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomAppList() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f35986c;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomAppList();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomDevImeis() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f35986c;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomDevImeis();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isCanUseOaid() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f35986c;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isCanUseOaid();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isLimitPersonalAds() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f35986c;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isLimitPersonalAds();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isProgrammaticRecommend() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.f35986c;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isProgrammaticRecommend();
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8476, getCustomAppList());
        create.add(8477, getCustomDevImeis());
        create.add(8478, isCanUseOaid());
        create.add(8027, isLimitPersonalAds());
        create.add(8028, isProgrammaticRecommend());
        return create.build();
    }
}
