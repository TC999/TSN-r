package com.bytedance.sdk.openadsdk.api.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.c.c.c.c.a;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.api.w implements DownloadStatusChangeListener {
    public ux(EventListener eventListener) {
        this.f31497c = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i4) {
        c(223602, c() ? null : a.a().c(b.a().h(223607, new sr(downloadShortInfo)).e(223608, i4).l()).f());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        c(223604, c() ? null : a.a().c(b.a().h(223607, new sr(downloadShortInfo)).l()).f());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        c(223606, c() ? null : a.a().c(b.a().h(223607, new sr(downloadShortInfo)).l()).f());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i4) {
        c(223603, c() ? null : a.a().c(b.a().h(223607, new sr(downloadShortInfo)).e(223608, i4).l()).f());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        c(223601, c() ? null : a.a().c(b.a().h(223201, new xv(downloadModel)).h(223203, new c(downloadController)).l()).f());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        c(223600);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        c(223605, c() ? null : a.a().c(b.a().h(223607, new sr(downloadShortInfo)).l()).f());
    }
}
