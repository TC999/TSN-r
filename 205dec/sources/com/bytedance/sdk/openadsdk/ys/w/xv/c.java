package com.bytedance.sdk.openadsdk.ys.w.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public final ValueSet f36548c;

    public c(ValueSet valueSet) {
        this.f36548c = valueSet == null ? b.f24740c : valueSet;
    }

    public sr a() {
        ValueSet valueSet = (ValueSet) this.f36548c.objectValue(261012, ValueSet.class);
        if (valueSet != null) {
            return new sr(valueSet);
        }
        return null;
    }

    public int bk() {
        return this.f36548c.intValue(261013);
    }

    public String c() {
        return (String) this.f36548c.objectValue(261001, String.class);
    }

    public boolean ev() {
        return this.f36548c.booleanValue(261008);
    }

    public int f() {
        return this.f36548c.intValue(261006);
    }

    public boolean fp() {
        return this.f36548c.booleanValue(261017);
    }

    public int[] gd() {
        return (int[]) this.f36548c.objectValue(261009, int[].class);
    }

    public boolean k() {
        return this.f36548c.booleanValue(261011);
    }

    public boolean p() {
        return this.f36548c.booleanValue(261010);
    }

    public boolean r() {
        return this.f36548c.booleanValue(261007);
    }

    public String sr() {
        return (String) this.f36548c.objectValue(261004, String.class);
    }

    public int t() {
        return this.f36548c.intValue(261014);
    }

    public String ux() {
        return (String) this.f36548c.objectValue(261005, String.class);
    }

    public String w() {
        return (String) this.f36548c.objectValue(261002, String.class);
    }

    public boolean xv() {
        return this.f36548c.booleanValue(261003);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c ys() {
        ValueSet valueSet = (ValueSet) this.f36548c.objectValue(261016, ValueSet.class);
        if (valueSet != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c(valueSet);
        }
        return null;
    }

    public static final ValueSet c(final AdConfig adConfig) {
        b a4 = b.a();
        if (adConfig == null) {
            return null;
        }
        a4.i(261001, adConfig.getAppId());
        a4.i(261002, adConfig.getAppName());
        a4.j(261003, adConfig.isPaid());
        a4.i(261004, adConfig.getKeywords());
        a4.i(261005, adConfig.getData());
        a4.e(261006, adConfig.getTitleBarTheme());
        a4.j(261007, adConfig.isAllowShowNotify());
        a4.j(261008, adConfig.isDebug());
        a4.h(261009, adConfig.getDirectDownloadNetworkType());
        a4.j(261010, adConfig.isUseTextureView());
        a4.j(261011, adConfig.isSupportMultiProcess());
        a4.h(261012, adConfig.getCustomController() != null ? sr.c(adConfig.getCustomController()) : null);
        a4.h(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        a4.h(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.c.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        a4.h(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.c.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        a4.h(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.c.w.c.c.c(adConfig.getMediationConfig()) : null);
        a4.j(261017, adConfig.isUseMediation());
        return a4.l();
    }
}
