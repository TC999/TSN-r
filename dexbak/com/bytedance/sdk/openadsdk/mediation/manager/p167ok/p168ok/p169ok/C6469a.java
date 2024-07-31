package com.bytedance.sdk.openadsdk.mediation.manager.p167ok.p168ok.p169ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6469a implements MediationAdLoadInfo {

    /* renamed from: ok */
    private final Bridge f22832ok;

    public C6469a(Bridge bridge) {
        this.f22832ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return (String) this.f22832ok.values().objectValue(271003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return (String) this.f22832ok.values().objectValue(271002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.f22832ok.values().intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return (String) this.f22832ok.values().objectValue(271005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return (String) this.f22832ok.values().objectValue(271001, String.class);
    }
}
