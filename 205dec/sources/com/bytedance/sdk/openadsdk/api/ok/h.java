package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.ok.ok.ok.ok.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h extends com.bytedance.sdk.openadsdk.api.a implements OnItemClickListener {
    public h(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ok(223200, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223201, new bl(downloadModel)).h(223202, new a(downloadEventConfig)).h(223203, new ok(downloadController)).a()).a());
    }
}
