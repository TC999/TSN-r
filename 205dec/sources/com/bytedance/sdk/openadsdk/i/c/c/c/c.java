package com.bytedance.sdk.openadsdk.i.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements TTFeedAd.CustomizeVideo {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35893c;

    public c(Bridge bridge) {
        this.f35893c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.f35893c.call(162101, b.b(0).l(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.f35893c.call(162107, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j4) {
        b b4 = b.b(1);
        b4.f(0, j4);
        this.f35893c.call(162106, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j4) {
        b b4 = b.b(1);
        b4.f(0, j4);
        this.f35893c.call(162104, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j4, int i4, int i5) {
        b b4 = b.b(3);
        b4.f(0, j4);
        b4.e(1, i4);
        b4.e(2, i5);
        this.f35893c.call(162109, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.f35893c.call(162105, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j4) {
        b b4 = b.b(1);
        b4.f(0, j4);
        this.f35893c.call(162103, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.f35893c.call(162102, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i4, int i5) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.e(1, i5);
        this.f35893c.call(162108, b4.l(), Void.class);
    }
}
