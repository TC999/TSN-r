package com.bytedance.sdk.openadsdk.mediation.manager.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements MediationAdLoadInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36203c;

    public w(Bridge bridge) {
        this.f36203c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return (String) this.f36203c.values().objectValue(271003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return (String) this.f36203c.values().objectValue(271002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.f36203c.values().intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return (String) this.f36203c.values().objectValue(271005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return (String) this.f36203c.values().objectValue(271001, String.class);
    }
}
