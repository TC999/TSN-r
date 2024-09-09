package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.a;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.config.IDownloadButtonClickListener;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.sdk.openadsdk.api.w implements IDownloadButtonClickListener {
    public f(EventListener eventListener) {
        this.f31497c = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z3) {
        c(223100, c() ? null : a.a().c(b.a().j(223101, z3).l()).f());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        c(223110);
    }
}
