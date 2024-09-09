package com.bytedance.sdk.openadsdk.mediation.init.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public final ValueSet f36173c;

    public c(ValueSet valueSet) {
        this.f36173c = valueSet == null ? b.f24740c : valueSet;
    }

    public String c() {
        return (String) this.f36173c.objectValue(264101, String.class);
    }

    public boolean ev() {
        return this.f36173c.booleanValue(264108);
    }

    public JSONObject f() {
        return (JSONObject) this.f36173c.objectValue(264106, JSONObject.class);
    }

    public boolean gd() {
        return this.f36173c.booleanValue(264109);
    }

    public String k() {
        return (String) this.f36173c.objectValue(264111, String.class);
    }

    public boolean p() {
        return this.f36173c.booleanValue(264110);
    }

    public String r() {
        return (String) this.f36173c.objectValue(264107, String.class);
    }

    public Map<String, Object> sr() {
        return (Map) this.f36173c.objectValue(264104, Map.class);
    }

    public boolean ux() {
        return this.f36173c.booleanValue(264105);
    }

    public boolean w() {
        return this.f36173c.booleanValue(264102);
    }

    public xv xv() {
        ValueSet valueSet = (ValueSet) this.f36173c.objectValue(264103, ValueSet.class);
        if (valueSet != null) {
            return new xv(valueSet);
        }
        return null;
    }

    public static final ValueSet c(final IMediationConfig iMediationConfig) {
        b a4 = b.a();
        if (iMediationConfig == null) {
            return null;
        }
        a4.h(264101, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return IMediationConfig.this.getPublisherDid();
            }
        });
        a4.h(264102, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isOpenAdnTest());
            }
        });
        a4.h(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? xv.c(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        a4.h(264104, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map get() {
                return IMediationConfig.this.getLocalExtra();
            }
        });
        a4.h(264105, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.getHttps());
            }
        });
        a4.h(264106, new ValueSet.ValueGetter<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public JSONObject get() {
                return IMediationConfig.this.getCustomLocalConfig();
            }
        });
        a4.h(264107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return IMediationConfig.this.getOpensdkVer();
            }
        });
        a4.h(264108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isWxInstalled());
            }
        });
        a4.h(264109, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportH265());
            }
        });
        a4.h(264110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationConfig.this.isSupportSplashZoomout());
            }
        });
        a4.h(264111, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return IMediationConfig.this.wxAppId();
            }
        });
        return a4.l();
    }
}
