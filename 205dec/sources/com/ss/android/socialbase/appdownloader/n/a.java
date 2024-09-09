package com.ss.android.socialbase.appdownloader.n;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends com.ss.android.socialbase.downloader.depend.s {

    /* renamed from: a  reason: collision with root package name */
    private int f49147a;
    private String bl;

    /* renamed from: h  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.notification.ok f49148h;
    private String kf;

    /* renamed from: n  reason: collision with root package name */
    private String f49149n;
    private Context ok;

    /* renamed from: s  reason: collision with root package name */
    private String f49150s;

    public a(Context context, int i4, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.ok = com.ss.android.socialbase.downloader.downloader.bl.l();
        }
        this.f49147a = i4;
        this.bl = str;
        this.f49150s = str2;
        this.f49149n = str3;
        this.kf = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.s
    public com.ss.android.socialbase.downloader.notification.ok ok() {
        Context context;
        com.ss.android.socialbase.downloader.notification.ok okVar = this.f49148h;
        return (okVar != null || (context = this.ok) == null) ? okVar : new ok(context, this.f49147a, this.bl, this.f49150s, this.f49149n, this.kf);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.ok == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.ok == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.kf.a.ok(downloadInfo);
        }
    }

    public a(com.ss.android.socialbase.downloader.notification.ok okVar) {
        this.ok = com.ss.android.socialbase.downloader.downloader.bl.l();
        this.f49148h = okVar;
    }
}
