package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements com.ss.android.socialbase.appdownloader.bl.p {
    private static String ok = "bl";

    /* renamed from: a  reason: collision with root package name */
    private Handler f48746a = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.bl.p
    public void ok(DownloadInfo downloadInfo, BaseException baseException, int i4) {
        final DownloadModel ok2;
        if (downloadInfo == null) {
            return;
        }
        if (i4 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            ok.ok(jSONObject, downloadInfo);
            com.ss.android.downloadlib.h.r.ok("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.ok.a ok3 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (ok3 == null) {
            return;
        }
        try {
            if (i4 != -1) {
                if (i4 == -3) {
                    ok.ok(downloadInfo, ok3);
                    return;
                } else if (i4 == 2001) {
                    ok.ok().ok(downloadInfo, ok3, 2001);
                    return;
                } else if (i4 == 11) {
                    ok.ok().ok(downloadInfo, ok3, 2000);
                    if (ok3.ej()) {
                        return;
                    }
                    ok(downloadInfo, ok3);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f48746a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.r.bl().ok(5, com.ss.android.downloadlib.addownload.r.getContext(), null, "\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.q.kf.p(baseException)) {
                    if (com.ss.android.downloadlib.addownload.r.z() != null) {
                        com.ss.android.downloadlib.addownload.r.z().ok(ok3.a());
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok("download_failed_for_space", ok3);
                    if (!ok3.vk()) {
                        com.ss.android.downloadlib.s.ok.ok().ok("download_can_restart", ok3);
                        ok(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.r.z() == null || !com.ss.android.downloadlib.addownload.r.z().s()) && (ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(ok3.a())) != null && ok2.isShowToast()) {
                        final com.ss.android.socialbase.downloader.h.ok ok4 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
                        if (ok4.ok("show_no_enough_space_toast", 0) == 1) {
                            this.f48746a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.r.bl().ok(2, com.ss.android.downloadlib.addownload.r.getContext(), ok2, ok4.ok("no_enough_space_toast_text", "\u60a8\u7684\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u8bf7\u6e05\u7406\u540e\u518d\u8bd5"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), j.ok(baseException.getMessage(), com.ss.android.downloadlib.addownload.r.q().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.s.ok.ok().a(downloadInfo, baseException2);
            h.ok().ok(downloadInfo, baseException, "");
        } catch (Exception e4) {
            com.ss.android.downloadlib.addownload.r.u().ok(e4, "onAppDownloadMonitorSend");
        }
    }

    private void ok(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ok.a aVar) {
        final long ok2 = j.ok(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, j.ok(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        double d4 = min;
        double d5 = totalBytes;
        Double.isNaN(d5);
        Double.isNaN(d4);
        final double d6 = (d5 * 2.5d) + d4;
        if (ok2 > -1 && totalBytes > -1) {
            double d7 = ok2;
            if (d7 < d6) {
                Double.isNaN(d7);
                if (d6 - d7 > com.ss.android.downloadlib.addownload.s.a()) {
                    com.ss.android.downloadlib.addownload.s.ok(downloadInfo.getId());
                }
            }
        }
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC1022ok() { // from class: com.ss.android.downloadlib.bl.3
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void a() {
                if (!j.a(aVar)) {
                    long j4 = ok2;
                    if (j4 <= -1 || totalBytes <= -1 || j4 >= d6) {
                        return;
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok("clean_space_install", com.ss.android.downloadlib.addownload.s.ok("install_no_enough_space"), aVar);
                    if (com.ss.android.downloadlib.addownload.s.ok(downloadInfo, ((long) d6) - ok2)) {
                        com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                        aVar.h(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void bl() {
            }
        });
    }

    private void ok(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.h.n.kf(downloadInfo.getId())) {
            s.ok().a(new com.ss.android.downloadlib.addownload.bl.a(downloadInfo));
        }
    }
}
