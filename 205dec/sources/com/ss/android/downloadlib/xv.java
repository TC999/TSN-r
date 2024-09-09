package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.r.k;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements com.ss.android.socialbase.appdownloader.xv.ev {

    /* renamed from: c  reason: collision with root package name */
    private static String f48987c = "xv";

    /* renamed from: w  reason: collision with root package name */
    private Handler f48988w = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.xv.ev
    public void c(DownloadInfo downloadInfo, BaseException baseException, int i4) {
        final DownloadModel c4;
        if (downloadInfo == null) {
            return;
        }
        if (i4 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
            c.c(jSONObject, downloadInfo);
            k.c("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.c.w c5 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        if (c5 == null) {
            return;
        }
        try {
            if (i4 != -1) {
                if (i4 == -3) {
                    c.c(downloadInfo, c5);
                    return;
                } else if (i4 == 2001) {
                    c.c().c(downloadInfo, c5, 2001);
                    return;
                } else if (i4 == 11) {
                    c.c().c(downloadInfo, c5, 2000);
                    if (c5.oo()) {
                        return;
                    }
                    c(downloadInfo, c5);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f48988w.post(new Runnable() { // from class: com.ss.android.downloadlib.xv.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.k.xv().c(5, com.ss.android.downloadlib.addownload.k.getContext(), null, "\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.gd.f.ev(baseException)) {
                    if (com.ss.android.downloadlib.addownload.k.bk() != null) {
                        com.ss.android.downloadlib.addownload.k.bk().c(c5.w());
                    }
                    com.ss.android.downloadlib.sr.c.c().c("download_failed_for_space", c5);
                    if (!c5.up()) {
                        com.ss.android.downloadlib.sr.c.c().c("download_can_restart", c5);
                        c(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.k.bk() == null || !com.ss.android.downloadlib.addownload.k.bk().sr()) && (c4 = com.ss.android.downloadlib.addownload.w.f.c().c(c5.w())) != null && c4.isShowToast()) {
                        final com.ss.android.socialbase.downloader.r.c c6 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
                        if (c6.c("show_no_enough_space_toast", 0) == 1) {
                            this.f48988w.post(new Runnable() { // from class: com.ss.android.downloadlib.xv.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.k.xv().c(2, com.ss.android.downloadlib.addownload.k.getContext(), c4, c6.c("no_enough_space_toast_text", "\u60a8\u7684\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u8bf7\u6e05\u7406\u540e\u518d\u8bd5"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), com.ss.android.downloadlib.r.a.c(baseException.getMessage(), com.ss.android.downloadlib.addownload.k.gd().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.sr.c.c().w(downloadInfo, baseException2);
            r.c().c(downloadInfo, baseException, "");
        } catch (Exception e4) {
            com.ss.android.downloadlib.addownload.k.u().c(e4, "onAppDownloadMonitorSend");
        }
    }

    private void c(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.c.w wVar) {
        final long c4 = com.ss.android.downloadlib.r.a.c(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, com.ss.android.downloadlib.r.a.c(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        double d4 = min;
        double d5 = totalBytes;
        Double.isNaN(d5);
        Double.isNaN(d4);
        final double d6 = (d5 * 2.5d) + d4;
        if (c4 > -1 && totalBytes > -1) {
            double d7 = c4;
            if (d7 < d6) {
                Double.isNaN(d7);
                if (d6 - d7 > com.ss.android.downloadlib.addownload.sr.w()) {
                    com.ss.android.downloadlib.addownload.sr.c(downloadInfo.getId());
                }
            }
        }
        com.ss.android.socialbase.downloader.c.c.c().c(new c.InterfaceC0974c() { // from class: com.ss.android.downloadlib.xv.3
            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void w() {
                if (!com.ss.android.downloadlib.r.a.w(wVar)) {
                    long j4 = c4;
                    if (j4 <= -1 || totalBytes <= -1 || j4 >= d6) {
                        return;
                    }
                    com.ss.android.downloadlib.sr.c.c().c("clean_space_install", com.ss.android.downloadlib.addownload.sr.c("install_no_enough_space"), wVar);
                    if (com.ss.android.downloadlib.addownload.sr.c(downloadInfo, ((long) d6) - c4)) {
                        com.ss.android.socialbase.downloader.c.c.c().w(this);
                        wVar.r(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.c.c.c().w(this);
            }

            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void xv() {
            }
        });
    }

    private void c(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.r.ux.f(downloadInfo.getId())) {
            sr.c().w(new com.ss.android.downloadlib.addownload.xv.w(downloadInfo));
        }
    }
}
