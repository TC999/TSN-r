package com.bytedance.sdk.openadsdk.core.ev.c.c.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.openadsdk.core.p.w.ux;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements DownloadStatusChangeListener {
    private c sr;
    private String ux;
    private final String xv;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicInteger f33418c = new AtomicInteger(1);

    /* renamed from: w  reason: collision with root package name */
    private ux f33419w = new ux();

    public w(String str, String str2) {
        this.xv = str;
        this.ux = str2;
    }

    private void c(String str, long j4, long j5, String str2) {
        c cVar = this.sr;
        if (cVar == null) {
            this.sr = new c(str, j4, j5, str2, this.ux, this.xv);
        } else {
            cVar.c(str);
            this.sr.c(j4);
            this.sr.w(j5);
            this.sr.w(str2);
            this.sr.xv(this.ux);
        }
        ev.xv().execute(this.sr);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i4) {
        this.f33418c.set(3);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onDownloadActive", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.c(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, this.ux);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        this.f33418c.set(5);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onDownloadFailed", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.xv(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, this.ux);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        this.f33418c.set(6);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onDownloadFinished", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.c(downloadShortInfo.totalBytes, downloadShortInfo.fileName, this.ux);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i4) {
        this.f33418c.set(4);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onDownloadPaused", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.w(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName, this.ux);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        this.f33418c.set(2);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onIdle", 0L, 0L, null);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.c();
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        this.f33418c.set(1);
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onIdle", 0L, 0L, null);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.c();
        }
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        this.f33418c.set(7);
        String str = !TextUtils.isEmpty(downloadShortInfo.fileName) ? downloadShortInfo.fileName : "";
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            c("onInstalled", downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str);
            return;
        }
        ux uxVar = this.f33419w;
        if (uxVar != null) {
            uxVar.c(str, this.ux);
        }
    }

    public void w() {
        ux uxVar = this.f33419w;
        if (uxVar == null) {
            return;
        }
        uxVar.w();
    }

    public int c() {
        return this.f33418c.get();
    }

    public void c(com.bytedance.sdk.openadsdk.core.p.w.c cVar) {
        ux uxVar = this.f33419w;
        if (uxVar == null) {
            return;
        }
        uxVar.c(cVar);
    }
}
