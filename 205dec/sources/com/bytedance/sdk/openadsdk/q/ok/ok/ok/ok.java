package com.bytedance.sdk.openadsdk.q.ok.ok.ok;

import com.bykv.ok.ok.ok.ok.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements TTFeedAd.CustomizeVideo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.ok.call(162101, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.ok.call(162107, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j4) {
        a c4 = a.c(1);
        c4.g(0, j4);
        this.ok.call(162106, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j4) {
        a c4 = a.c(1);
        c4.g(0, j4);
        this.ok.call(162104, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j4, int i4, int i5) {
        a c4 = a.c(3);
        c4.g(0, j4);
        c4.f(1, i4);
        c4.f(2, i5);
        this.ok.call(162109, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.ok.call(162105, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j4) {
        a c4 = a.c(1);
        c4.g(0, j4);
        this.ok.call(162103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.ok.call(162102, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i4, int i5) {
        a c4 = a.c(2);
        c4.f(0, i4);
        c4.f(1, i5);
        this.ok.call(162108, c4.a(), Void.class);
    }
}
