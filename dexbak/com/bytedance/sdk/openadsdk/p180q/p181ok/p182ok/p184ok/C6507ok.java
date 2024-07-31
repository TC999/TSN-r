package com.bytedance.sdk.openadsdk.p180q.p181ok.p182ok.p184ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* renamed from: com.bytedance.sdk.openadsdk.q.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6507ok implements TTFeedAd.CustomizeVideo {

    /* renamed from: ok */
    private final Bridge f22886ok;

    public C6507ok(Bridge bridge) {
        this.f22886ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.f22886ok.call(162101, C5930a.m37924c(0).m37926a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.f22886ok.call(162107, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37920g(0, j);
        this.f22886ok.call(162106, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37920g(0, j);
        this.f22886ok.call(162104, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37920g(0, j);
        m37924c.m37921f(1, i);
        m37924c.m37921f(2, i2);
        this.f22886ok.call(162109, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.f22886ok.call(162105, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37920g(0, j);
        this.f22886ok.call(162103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.f22886ok.call(162102, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37921f(0, i);
        m37924c.m37921f(1, i2);
        this.f22886ok.call(162108, m37924c.m37926a(), Void.class);
    }
}
