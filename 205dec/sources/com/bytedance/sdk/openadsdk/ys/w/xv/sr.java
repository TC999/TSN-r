package com.bytedance.sdk.openadsdk.ys.w.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr {

    /* renamed from: w  reason: collision with root package name */
    public final ValueSet f36552w;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private final b f36565c = b.a();

        public c c(boolean z3) {
            this.f36565c.j(262101, z3);
            return this;
        }

        public c f(boolean z3) {
            this.f36565c.j(262110, z3);
            return this;
        }

        public c r(boolean z3) {
            this.f36565c.j(262111, z3);
            return this;
        }

        public c sr(boolean z3) {
            this.f36565c.j(262106, z3);
            return this;
        }

        public c ux(boolean z3) {
            this.f36565c.j(262108, z3);
            return this;
        }

        public c w(boolean z3) {
            this.f36565c.j(262103, z3);
            return this;
        }

        public c xv(boolean z3) {
            this.f36565c.j(262104, z3);
            return this;
        }

        public c c(xv xvVar) {
            this.f36565c.h(262102, xvVar);
            return this;
        }

        public c sr(String str) {
            this.f36565c.i(262112, str);
            return this;
        }

        public c w(String str) {
            this.f36565c.i(262107, str);
            return this;
        }

        public c xv(String str) {
            this.f36565c.i(262109, str);
            return this;
        }

        public c c(String str) {
            this.f36565c.i(262105, str);
            return this;
        }

        public sr c() {
            return new sr(this.f36565c.l());
        }
    }

    public sr(ValueSet valueSet) {
        this.f36552w = valueSet == null ? b.f24740c : valueSet;
    }

    public String a() {
        return (String) this.f36552w.objectValue(262112, String.class);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w bk() {
        ValueSet valueSet = (ValueSet) this.f36552w.objectValue(262113, ValueSet.class);
        if (valueSet != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w(valueSet);
        }
        return null;
    }

    public boolean c() {
        return this.f36552w.booleanValue(262101);
    }

    public xv ev() {
        ValueSet valueSet = (ValueSet) this.f36552w.objectValue(262102, ValueSet.class);
        if (valueSet != null) {
            return new xv(valueSet);
        }
        return null;
    }

    public boolean f() {
        return this.f36552w.booleanValue(262110);
    }

    public String gd() {
        return (String) this.f36552w.objectValue(262105, String.class);
    }

    public String k() {
        return (String) this.f36552w.objectValue(262109, String.class);
    }

    public String p() {
        return (String) this.f36552w.objectValue(262107, String.class);
    }

    public boolean r() {
        return this.f36552w.booleanValue(262111);
    }

    public boolean sr() {
        return this.f36552w.booleanValue(262106);
    }

    public boolean ux() {
        return this.f36552w.booleanValue(262108);
    }

    public boolean w() {
        return this.f36552w.booleanValue(262103);
    }

    public boolean xv() {
        return this.f36552w.booleanValue(262104);
    }

    public static final ValueSet c(final TTCustomController tTCustomController) {
        b a4 = b.a();
        if (tTCustomController == null) {
            return null;
        }
        a4.h(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        a4.h(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public ValueSet get() {
                return xv.c(TTCustomController.this.getTTLocation());
            }
        });
        a4.h(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        a4.h(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        a4.h(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        a4.h(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        a4.h(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        a4.h(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        a4.h(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        a4.h(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        a4.h(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.c(tTCustomController.getMediationPrivacyConfig()) : null);
        a4.h(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        a4.h(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.xv.sr.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        return a4.l();
    }
}
