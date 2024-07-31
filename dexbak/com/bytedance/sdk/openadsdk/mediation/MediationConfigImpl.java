package com.bytedance.sdk.openadsdk.mediation;

import androidx.annotation.Nullable;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationConfigImpl implements Bridge, IMediationConfig {

    /* renamed from: ok */
    private IMediationConfig f22611ok;

    public MediationConfigImpl(IMediationConfig iMediationConfig) {
        this.f22611ok = iMediationConfig;
    }

    /* renamed from: ok */
    private Bridge m36296ok() {
        if (this.f22611ok.getMediationConfigUserInfoForSegment() != null) {
            return new MediationUserInfoForSegmentImpl(this.f22611ok.getMediationConfigUserInfoForSegment());
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8460) {
            return (T) String.valueOf(getPublisherDid());
        }
        if (i == 8461) {
            return (T) Boolean.valueOf(isOpenAdnTest());
        }
        if (i == 8310) {
            return (T) m36296ok();
        }
        if (i == 8462) {
            return (T) getLocalExtra();
        }
        if (i == 8458) {
            return (T) Boolean.valueOf(getHttps());
        }
        if (i == 8463) {
            return (T) getCustomLocalConfig();
        }
        if (i == 8464) {
            return (T) String.valueOf(getOpensdkVer());
        }
        if (i == 8465) {
            return (T) Boolean.valueOf(isWxInstalled());
        }
        if (i == 8466) {
            return (T) Boolean.valueOf(isSupportH265());
        }
        if (i == 8467) {
            return (T) Boolean.valueOf(isSupportSplashZoomout());
        }
        if (i == 8459) {
            return (T) String.valueOf(wxAppId());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public JSONObject getCustomLocalConfig() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.getCustomLocalConfig();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.getHttps();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public Map<String, Object> getLocalExtra() {
        IMediationConfig iMediationConfig = this.f22611ok;
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
        IMediationConfig iMediationConfig = this.f22611ok;
        return iMediationConfig != null ? iMediationConfig.getOpensdkVer() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public String getPublisherDid() {
        IMediationConfig iMediationConfig = this.f22611ok;
        return iMediationConfig != null ? iMediationConfig.getPublisherDid() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.isOpenAdnTest();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportH265();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.isSupportSplashZoomout();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        IMediationConfig iMediationConfig = this.f22611ok;
        if (iMediationConfig != null) {
            return iMediationConfig.isWxInstalled();
        }
        return false;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    @Nullable
    public String wxAppId() {
        IMediationConfig iMediationConfig = this.f22611ok;
        return iMediationConfig != null ? iMediationConfig.wxAppId() : "";
    }
}
