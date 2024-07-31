package com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok.C6451a;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.bl.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6351s {
    /* renamed from: ok */
    public static final ValueSet m36527ok(final TTCustomController tTCustomController) {
        C5930a m37925b = C5930a.m37925b();
        if (tTCustomController == null) {
            return null;
        }
        m37925b.m37919h(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.1
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseLocation());
            }
        });
        m37925b.m37919h(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.5
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public ValueSet get() {
                return C6346bl.m36532ok(TTCustomController.this.getTTLocation());
            }
        });
        m37925b.m37919h(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.6
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.alist());
            }
        });
        m37925b.m37919h(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.7
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePhoneState());
            }
        });
        m37925b.m37919h(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.8
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getDevImei();
            }
        });
        m37925b.m37919h(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.9
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWifiState());
            }
        });
        m37925b.m37919h(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.10
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getMacAddress();
            }
        });
        m37925b.m37919h(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.11
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseWriteExternal());
            }
        });
        m37925b.m37919h(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.12
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getDevOaid();
            }
        });
        m37925b.m37919h(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.2
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUseAndroidId());
            }
        });
        m37925b.m37919h(262113, tTCustomController.getMediationPrivacyConfig() != null ? C6451a.m36242ok(tTCustomController.getMediationPrivacyConfig()) : null);
        m37925b.m37919h(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.3
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public String get() {
                return TTCustomController.this.getAndroidId();
            }
        });
        m37925b.m37919h(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.4
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(TTCustomController.this.isCanUsePermissionRecordAudio());
            }
        });
        return m37925b.m37926a();
    }
}
