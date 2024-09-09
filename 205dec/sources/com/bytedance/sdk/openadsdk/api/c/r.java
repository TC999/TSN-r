package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.a;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.api.w implements OnItemClickListener {
    public r(EventListener eventListener) {
        this.f31497c = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        c(223200, c() ? null : a.a().c(b.a().h(223201, new xv(downloadModel)).h(223202, new w(downloadEventConfig)).h(223203, new c(downloadController)).l()).f());
    }
}
