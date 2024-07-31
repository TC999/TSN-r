package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6379n implements DownloadStatusController {

    /* renamed from: ok */
    private final Bridge f22521ok;

    public C6379n(Bridge bridge) {
        this.f22521ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.f22521ok.call(222102, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.f22521ok.call(222101, C5930a.m37924c(0).m37926a(), Void.class);
    }
}
