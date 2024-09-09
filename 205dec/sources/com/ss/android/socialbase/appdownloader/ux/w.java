package com.ss.android.socialbase.appdownloader.ux;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w extends com.ss.android.socialbase.downloader.depend.sr {

    /* renamed from: c  reason: collision with root package name */
    private Context f49230c;

    /* renamed from: f  reason: collision with root package name */
    private String f49231f;

    /* renamed from: r  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.c f49232r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f49233w;
    private String xv;

    public w(Context context, int i4, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f49230c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.f49230c = com.ss.android.socialbase.downloader.downloader.xv.gw();
        }
        this.f49233w = i4;
        this.xv = str;
        this.sr = str2;
        this.ux = str3;
        this.f49231f = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr
    public com.ss.android.socialbase.downloader.notification.c c() {
        Context context;
        com.ss.android.socialbase.downloader.notification.c cVar = this.f49232r;
        return (cVar != null || (context = this.f49230c) == null) ? cVar : new c(context, this.f49233w, this.xv, this.sr, this.ux, this.f49231f);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f49230c == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.sr, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f49230c == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.f.w.c(downloadInfo);
        }
    }

    public w(com.ss.android.socialbase.downloader.notification.c cVar) {
        this.f49230c = com.ss.android.socialbase.downloader.downloader.xv.gw();
        this.f49232r = cVar;
    }
}
