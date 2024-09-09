package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTImage;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class bk extends TTImage {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36402c;

    public bk(Bridge bridge) {
        this.f36402c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.f36402c.values().doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.f36402c.values().intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return (String) this.f36402c.values().objectValue(230003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.f36402c.values().intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.f36402c.values().booleanValue(230005);
    }
}
