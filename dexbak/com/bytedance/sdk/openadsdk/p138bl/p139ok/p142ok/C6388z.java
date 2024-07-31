package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTImage;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.z */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6388z extends TTImage {

    /* renamed from: ok */
    private final Bridge f22531ok;

    public C6388z(Bridge bridge) {
        this.f22531ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.f22531ok.values().doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.f22531ok.values().intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return (String) this.f22531ok.values().objectValue(230003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.f22531ok.values().intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.f22531ok.values().booleanValue(230005);
    }
}
