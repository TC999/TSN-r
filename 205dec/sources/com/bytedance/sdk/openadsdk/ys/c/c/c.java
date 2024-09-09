package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c extends CSJAdError {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36403c;

    public c(Bridge bridge) {
        this.f36403c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.f36403c.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.f36403c.values().objectValue(263002, String.class);
    }
}
