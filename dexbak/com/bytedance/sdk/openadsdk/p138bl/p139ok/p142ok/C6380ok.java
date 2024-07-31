package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6380ok extends CSJAdError {

    /* renamed from: ok */
    private final Bridge f22522ok;

    public C6380ok(Bridge bridge) {
        this.f22522ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.f22522ok.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.f22522ok.values().objectValue(263002, String.class);
    }
}
