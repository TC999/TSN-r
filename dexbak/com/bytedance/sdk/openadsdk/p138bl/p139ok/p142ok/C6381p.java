package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.p155kf.p156ok.p157ok.p158ok.C6423ok;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6381p implements TTAdDislike {

    /* renamed from: ok */
    private final Bridge f22523ok;

    public C6381p(Bridge bridge) {
        this.f22523ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.f22523ok.call(240105, C5930a.m37924c(0).m37926a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.f22523ok.call(240104, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6423ok(dislikeInteractionCallback));
        this.f22523ok.call(240102, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37918i(0, str);
        this.f22523ok.call(240103, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.f22523ok.call(240101, C5930a.m37924c(0).m37926a(), Void.class);
    }
}
