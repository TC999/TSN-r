package com.bytedance.sdk.openadsdk.ys.c.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr {
    public static final ValueSet c(final TTCustomController tTCustomController) {
        b a4 = b.a();
        if (tTCustomController == null) {
            return null;
        }
        a4.h(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        a4.h(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public ValueSet get() {
                return xv.c(TTCustomController.this.getTTLocation());
            }
        });
        a4.h(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        a4.h(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        a4.h(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        a4.h(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        a4.h(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        a4.h(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        a4.h(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        a4.h(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        a4.h(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.c.c.c.w.c(tTCustomController.getMediationPrivacyConfig()) : null);
        a4.h(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        a4.h(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.sr.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        return a4.l();
    }
}
