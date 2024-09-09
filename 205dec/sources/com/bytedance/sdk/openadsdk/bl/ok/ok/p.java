package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class p implements TTAdDislike {
    private final Bridge ok;

    public p(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.ok.call(240105, com.bykv.ok.ok.ok.ok.a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.ok.call(240104, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.kf.ok.ok.ok.ok(dislikeInteractionCallback));
        this.ok.call(240102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.i(0, str);
        this.ok.call(240103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.ok.call(240101, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }
}
