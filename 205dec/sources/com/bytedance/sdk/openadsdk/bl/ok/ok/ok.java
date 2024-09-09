package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok extends CSJAdError {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.ok.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.ok.values().objectValue(263002, String.class);
    }
}
