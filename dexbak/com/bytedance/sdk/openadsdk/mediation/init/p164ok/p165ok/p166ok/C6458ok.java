package com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6458ok {
    /* renamed from: ok */
    public static final ValueSet m36235ok(final IMediationConfig iMediationConfig) {
        C5930a m37925b = C5930a.m37925b();
        if (iMediationConfig == null) {
            return null;
        }
        m37925b.m37919h(264101, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.1
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.getPublisherDid();
            }
        });
        m37925b.m37919h(264102, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.3
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isOpenAdnTest());
            }
        });
        m37925b.m37919h(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? C6457bl.m36236ok(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        m37925b.m37919h(264104, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.4
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Map get() {
                return IMediationConfig.this.getLocalExtra();
            }
        });
        m37925b.m37919h(264105, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.5
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.getHttps());
            }
        });
        m37925b.m37919h(264106, new ValueSet.ValueGetter<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.6
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public JSONObject get() {
                return IMediationConfig.this.getCustomLocalConfig();
            }
        });
        m37925b.m37919h(264107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.7
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.getOpensdkVer();
            }
        });
        m37925b.m37919h(264108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.8
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isWxInstalled());
            }
        });
        m37925b.m37919h(264109, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.9
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportH265());
            }
        });
        m37925b.m37919h(264110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.10
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportSplashZoomout());
            }
        });
        m37925b.m37919h(264111, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.2
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return IMediationConfig.this.wxAppId();
            }
        });
        return m37925b.m37926a();
    }
}
