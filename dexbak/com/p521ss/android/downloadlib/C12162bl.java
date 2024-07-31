package com.p521ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.C12134s;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p529bl.RunnableC12047a;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12200kf;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12304p;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12162bl implements InterfaceC12304p {

    /* renamed from: ok */
    private static String f34403ok = "bl";

    /* renamed from: a */
    private Handler f34404a = new Handler(Looper.getMainLooper());

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12304p
    /* renamed from: ok */
    public void mo18389ok(DownloadInfo downloadInfo, BaseException baseException, int i) {
        final DownloadModel m19322ok;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            C12200kf.m18759bl(downloadInfo, jSONObject);
            C12238ok.m18610ok(jSONObject, downloadInfo);
            C12216r.m18674ok("download_failed", jSONObject.toString());
        }
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    C12238ok.m18616ok(downloadInfo, m19315ok);
                    return;
                } else if (i == 2001) {
                    C12238ok.m18626ok().m18615ok(downloadInfo, m19315ok, 2001);
                    return;
                } else if (i == 11) {
                    C12238ok.m18626ok().m18615ok(downloadInfo, m19315ok, 2000);
                    if (m19315ok.m19508ej()) {
                        return;
                    }
                    m18868ok(downloadInfo, m19315ok);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f34404a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C12128r.m18968bl().mo19528ok(5, C12128r.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (C12713kf.m16528p(baseException)) {
                    if (C12128r.m18937z() != null) {
                        C12128r.m18937z().m19640ok(m19315ok.mo19309a());
                    }
                    C12270ok.m18539ok().m18526ok("download_failed_for_space", m19315ok);
                    if (!m19315ok.m19439vk()) {
                        C12270ok.m18539ok().m18526ok("download_can_restart", m19315ok);
                        m18869ok(downloadInfo);
                    }
                    if ((C12128r.m18937z() == null || !C12128r.m18937z().m19639s()) && (m19322ok = C12032kf.m19324ok().m19322ok(m19315ok.mo19309a())) != null && m19322ok.isShowToast()) {
                        final C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
                        if (m17599ok.m17593ok("show_no_enough_space_toast", 0) == 1) {
                            this.f34404a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    C12128r.m18968bl().mo19528ok(2, C12128r.getContext(), m19322ok, m17599ok.m17591ok("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), C12197j.m18783ok(baseException.getMessage(), C12128r.m18946q().optInt("exception_msg_length", 500)));
            }
            C12270ok.m18539ok().m18542a(downloadInfo, baseException2);
            C12184h.m18835ok().m18828ok(downloadInfo, baseException, "");
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "onAppDownloadMonitorSend");
        }
    }

    /* renamed from: ok */
    private void m18868ok(final DownloadInfo downloadInfo, final C11998a c11998a) {
        final long m18785ok = C12197j.m18785ok(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, C12197j.m18786ok(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        double d = min;
        double d2 = totalBytes;
        Double.isNaN(d2);
        Double.isNaN(d);
        final double d3 = (d2 * 2.5d) + d;
        if (m18785ok > -1 && totalBytes > -1) {
            double d4 = m18785ok;
            if (d4 < d3) {
                Double.isNaN(d4);
                if (d3 - d4 > C12134s.m18931a()) {
                    C12134s.m18927ok(downloadInfo.getId());
                }
            }
        }
        C12646ok.m16846ok().m16843ok(new C12646ok.InterfaceC12650ok() { // from class: com.ss.android.downloadlib.bl.3
            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: a */
            public void mo16836a() {
                if (!C12197j.m18805a(c11998a)) {
                    long j = m18785ok;
                    if (j <= -1 || totalBytes <= -1 || j >= d3) {
                        return;
                    }
                    C12270ok.m18539ok().m18521ok("clean_space_install", C12134s.m18916ok("install_no_enough_space"), c11998a);
                    if (C12134s.m18917ok(downloadInfo, ((long) d3) - m18785ok)) {
                        C12646ok.m16846ok().m16853a(this);
                        c11998a.m19496h(true);
                        return;
                    }
                    return;
                }
                C12646ok.m16846ok().m16853a(this);
            }

            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: bl */
            public void mo16835bl() {
            }
        });
    }

    /* renamed from: ok */
    private void m18869ok(@NonNull DownloadInfo downloadInfo) {
        if (C12201n.m18743kf(downloadInfo.getId())) {
            C12265s.m18554ok().m18558a(new RunnableC12047a(downloadInfo));
        }
    }
}
