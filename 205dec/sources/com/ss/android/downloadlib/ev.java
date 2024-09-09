package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ev f48790c;

    /* renamed from: f  reason: collision with root package name */
    private long f48791f;
    private final com.ss.android.downloadad.api.c sr;
    private com.ss.android.downloadad.api.w ux;

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.download.api.c f48792w;
    private final r xv;

    /* JADX INFO: Access modifiers changed from: private */
    public r ev() {
        return this.xv;
    }

    public String f() {
        return k.t();
    }

    public void r() {
        sr.c().ux();
    }

    public com.ss.android.downloadad.api.c sr() {
        return this.sr;
    }

    public com.ss.android.downloadad.api.w ux() {
        if (this.ux == null) {
            this.ux = w.c();
        }
        return this.ux;
    }

    public void xv() {
        this.f48791f = System.currentTimeMillis();
    }

    private ev(Context context) {
        this.xv = r.c();
        this.f48792w = new ux();
        this.f48791f = System.currentTimeMillis();
        w(context);
        this.sr = c.c();
    }

    public static ev c(final Context context) {
        if (f48790c == null) {
            synchronized (ev.class) {
                if (f48790c == null) {
                    com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ev unused = ev.f48790c = new ev(context);
                        }
                    });
                }
            }
        }
        return f48790c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.downloadlib.addownload.a, com.ss.android.socialbase.downloader.downloader.s] */
    private void w(Context context) {
        k.c(context);
        Downloader.getInstance(k.getContext());
        com.ss.android.downloadlib.addownload.w.f.c().w();
        com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), "misc_config", new com.ss.android.downloadlib.xv.r(), new com.ss.android.downloadlib.xv.f(context), new xv());
        com.ss.android.downloadlib.xv.sr srVar = new com.ss.android.downloadlib.xv.sr();
        com.ss.android.socialbase.appdownloader.sr.p().c(srVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(srVar);
        com.ss.android.socialbase.appdownloader.sr.p().c((com.ss.android.socialbase.downloader.downloader.s) new com.ss.android.downloadlib.addownload.a());
        com.ss.android.socialbase.downloader.downloader.xv.c(new com.ss.android.downloadlib.xv.ux());
        com.ss.android.socialbase.appdownloader.sr.p().c(com.ss.android.downloadlib.f.xv.c());
    }

    public com.ss.android.download.api.c c() {
        return this.f48792w;
    }

    public com.ss.android.download.api.c c(String str) {
        com.ss.android.download.api.config.f w3 = f.c().w();
        if (w3 != null && w3.c(str)) {
            return w3.w(str);
        }
        return this.f48792w;
    }

    public long w() {
        return this.f48791f;
    }

    @MainThread
    public void c(final Context context, final int i4, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.4
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(context, i4, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext(), str);
    }

    @MainThread
    public void c(final String str, final long j4, final int i4, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.5
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(str, j4, i4, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void c(final String str, final long j4, final int i4, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.6
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(str, j4, i4, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void c(final String str, final long j4, final int i4, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.7
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(str, j4, i4, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void c(final String str, final int i4) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.2
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(str, i4);
            }
        });
    }

    @MainThread
    public void c(final String str, final boolean z3) {
        com.ss.android.downloadlib.ux.w.c(new Runnable() { // from class: com.ss.android.downloadlib.ev.3
            @Override // java.lang.Runnable
            public void run() {
                ev.this.ev().c(str, z3);
            }
        });
    }

    public void c(com.ss.android.download.api.download.c.c cVar) {
        ev().c(cVar);
    }

    public DownloadInfo c(String str, String str2, boolean z3) {
        if (TextUtils.isEmpty(str2) && z3) {
            return w(str);
        }
        return Downloader.getInstance(k.getContext()).getDownloadInfo(str, str2);
    }
}
