package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n implements DownloadStatusController {
    private final Bridge ok;

    public n(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.ok.call(222102, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.ok.call(222101, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }
}
