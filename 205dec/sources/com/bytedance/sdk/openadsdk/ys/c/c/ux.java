package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux implements DownloadStatusController {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36419c;

    public ux(Bridge bridge) {
        this.f36419c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.f36419c.call(222102, b.b(0).l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.f36419c.call(222101, b.b(0).l(), Void.class);
    }
}
