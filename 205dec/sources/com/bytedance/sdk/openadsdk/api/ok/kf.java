package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.ok.ok.ok.ok.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.config.IDownloadButtonClickListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class kf extends com.bytedance.sdk.openadsdk.api.a implements IDownloadButtonClickListener {
    public kf(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z3) {
        ok(223100, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().j(223101, z3).a()).a());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        ok(223110);
    }
}
