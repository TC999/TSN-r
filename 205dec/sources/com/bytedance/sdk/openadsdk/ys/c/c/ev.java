package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ev implements TTAdDislike {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36407c;

    public ev(Bridge bridge) {
        this.f36407c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.f36407c.call(240105, b.b(0).l(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.f36407c.call(240104, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b b4 = b.b(1);
        b4.h(0, new com.bytedance.sdk.openadsdk.s.c.c.c.c(dislikeInteractionCallback));
        this.f36407c.call(240102, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        b b4 = b.b(1);
        b4.i(0, str);
        this.f36407c.call(240103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.f36407c.call(240101, b.b(0).l(), Void.class);
    }
}
