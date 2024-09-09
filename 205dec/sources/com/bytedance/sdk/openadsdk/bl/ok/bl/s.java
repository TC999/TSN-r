package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s {
    public static final ValueSet ok(final TTCustomController tTCustomController) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (tTCustomController == null) {
            return null;
        }
        b4.h(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        b4.h(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public ValueSet get() {
                return bl.ok(TTCustomController.this.getTTLocation());
            }
        });
        b4.h(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        b4.h(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        b4.h(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        b4.h(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        b4.h(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        b4.h(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        b4.h(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        b4.h(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        b4.h(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.ok(tTCustomController.getMediationPrivacyConfig()) : null);
        b4.h(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        b4.h(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        return b4.a();
    }
}
