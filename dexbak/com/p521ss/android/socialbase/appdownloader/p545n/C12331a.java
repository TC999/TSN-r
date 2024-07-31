package com.p521ss.android.socialbase.appdownloader.p545n;

import android.content.Context;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12313a;
import com.p521ss.android.socialbase.downloader.depend.AbstractC12470s;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.appdownloader.n.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12331a extends AbstractC12470s {

    /* renamed from: a */
    private int f34777a;

    /* renamed from: bl */
    private String f34778bl;

    /* renamed from: h */
    private AbstractC12645ok f34779h;

    /* renamed from: kf */
    private String f34780kf;

    /* renamed from: n */
    private String f34781n;

    /* renamed from: ok */
    private Context f34782ok;

    /* renamed from: s */
    private String f34783s;

    public C12331a(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f34782ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.f34782ok = C12490bl.m17807l();
        }
        this.f34777a = i;
        this.f34778bl = str;
        this.f34783s = str2;
        this.f34781n = str3;
        this.f34780kf = str4;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s
    /* renamed from: ok */
    public AbstractC12645ok mo17851ok() {
        Context context;
        AbstractC12645ok abstractC12645ok = this.f34779h;
        return (abstractC12645ok != null || (context = this.f34782ok) == null) ? abstractC12645ok : new C12335ok(context, this.f34777a, this.f34778bl, this.f34783s, this.f34781n, this.f34780kf);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f34782ok == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12470s, com.p521ss.android.socialbase.downloader.depend.AbsDownloadListener, com.p521ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f34782ok == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            C12313a.m18262ok(downloadInfo);
        }
    }

    public C12331a(AbstractC12645ok abstractC12645ok) {
        this.f34782ok = C12490bl.m17807l();
        this.f34779h = abstractC12645ok;
    }
}
