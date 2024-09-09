package com.bytedance.sdk.openadsdk.api.ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.ok.ok.ok.ok.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n extends com.bytedance.sdk.openadsdk.api.a implements DownloadStatusChangeListener {
    public n(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i4) {
        ok(223602, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223607, new s(downloadShortInfo)).f(223608, i4).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        ok(223604, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223607, new s(downloadShortInfo)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        ok(223606, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223607, new s(downloadShortInfo)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i4) {
        ok(223603, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223607, new s(downloadShortInfo)).f(223608, i4).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        ok(223601, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223201, new bl(downloadModel)).h(223203, new ok(downloadController)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        ok(223600);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        ok(223605, ok() ? null : b.b().d(com.bykv.ok.ok.ok.ok.a.b().h(223607, new s(downloadShortInfo)).a()).a());
    }
}
