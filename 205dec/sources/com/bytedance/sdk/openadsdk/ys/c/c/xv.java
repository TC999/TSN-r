package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements ComplianceInfo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36421c;

    public xv(Bridge bridge) {
        this.f36421c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppName() {
        return (String) this.f36421c.values().objectValue(250001, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppVersion() {
        return (String) this.f36421c.values().objectValue(250002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getDeveloperName() {
        return (String) this.f36421c.values().objectValue(250003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getFunctionDescUrl() {
        return (String) this.f36421c.values().objectValue(250007, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPermissionUrl() {
        return (String) this.f36421c.values().objectValue(250005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f36421c.values().objectValue(250006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPrivacyUrl() {
        return (String) this.f36421c.values().objectValue(250004, String.class);
    }
}
