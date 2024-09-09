package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok {
    public static final ValueSet ok(final IMediationConfig iMediationConfig) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (iMediationConfig == null) {
            return null;
        }
        b4.h(264101, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.getPublisherDid();
            }
        });
        b4.h(264102, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isOpenAdnTest());
            }
        });
        b4.h(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? bl.ok(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        b4.h(264104, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Map get() {
                return IMediationConfig.this.getLocalExtra();
            }
        });
        b4.h(264105, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.getHttps());
            }
        });
        b4.h(264106, new ValueSet.ValueGetter<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public JSONObject get() {
                return IMediationConfig.this.getCustomLocalConfig();
            }
        });
        b4.h(264107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.getOpensdkVer();
            }
        });
        b4.h(264108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isWxInstalled());
            }
        });
        b4.h(264109, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportH265());
            }
        });
        b4.h(264110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportSplashZoomout());
            }
        });
        b4.h(264111, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.wxAppId();
            }
        });
        return b4.a();
    }
}
