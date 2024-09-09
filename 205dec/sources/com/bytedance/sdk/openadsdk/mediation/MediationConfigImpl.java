package com.bytedance.sdk.openadsdk.mediation;

import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationConfigImpl implements Bridge, IMediationConfig {

    /* renamed from: c  reason: collision with root package name */
    private IMediationConfig f35974c;

    public MediationConfigImpl(IMediationConfig iMediationConfig) {
        this.f35974c = iMediationConfig;
    }

    private Bridge c() {
        if (this.f35974c.getMediationConfigUserInfoForSegment() != null) {
            return new MediationUserInfoForSegmentImpl(this.f35974c.getMediationConfigUserInfoForSegment());
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8460) {
            return (T) String.valueOf(getPublisherDid());
        }
        if (i4 == 8461) {
            return (T) Boolean.valueOf(isOpenAdnTest());
        }
        if (i4 == 8310) {
            return (T) c();
        }
        if (i4 == 8462) {
            return (T) getLocalExtra();
        }
        if (i4 == 8458) {
            return (T) Boolean.valueOf(getHttps());
        }
        if (i4 == 8463) {
            return (T) getCustomLocalConfig();
        }
        if (i4 == 8464) {
            return (T) String.valueOf(getOpensdkVer());
        }
        if (i4 == 8465) {
            return (T) Boolean.valueOf(isWxInstalled());
        }
        if (i4 == 8466) {
            return (T) Boolean.valueOf(isSupportH265());
        }
        if (i4 == 8467) {
            return (T) Boolean.valueOf(isSupportSplashZoomout());
        }
        if (i4 == 8459) {
            return (T) String.valueOf(wxAppId());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public JSONObject getCustomLocalConfig() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.getCustomLocalConfig();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.getHttps();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public Map<String, Object> getLocalExtra() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.getLocalExtra();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public String getOpensdkVer() {
        IMediationConfig iMediationConfig = this.f35974c;
        return iMediationConfig != null ? iMediationConfig.getOpensdkVer() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public String getPublisherDid() {
        IMediationConfig iMediationConfig = this.f35974c;
        return iMediationConfig != null ? iMediationConfig.getPublisherDid() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.isOpenAdnTest();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportH265();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportSplashZoomout();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        IMediationConfig iMediationConfig = this.f35974c;
        if (iMediationConfig != null) {
            return iMediationConfig.isWxInstalled();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public String wxAppId() {
        IMediationConfig iMediationConfig = this.f35974c;
        return iMediationConfig != null ? iMediationConfig.wxAppId() : "";
    }
}
