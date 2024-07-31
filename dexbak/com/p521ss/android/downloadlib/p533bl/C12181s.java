package com.p521ss.android.downloadlib.p533bl;

import androidx.annotation.WorkerThread;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12298h;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.bl.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12181s implements InterfaceC12298h, InterfaceC12468r {
    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r
    /* renamed from: a */
    public void mo17855a() {
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.s.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                C12032kf.m19324ok().m19333a();
                for (C11998a c11998a : C12032kf.m19324ok().m19328bl().values()) {
                    int mo19285zz = c11998a.mo19285zz();
                    if (mo19285zz != 0) {
                        C12534ok m17599ok = C12534ok.m17599ok(mo19285zz);
                        if (m17599ok.m17607a("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(mo19285zz)) != null) {
                            if (C12197j.m18805a(c11998a) && !C12197j.m18800bl(c11998a.mo19300n())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < m17599ok.m17593ok("noti_open_restart_times", 1)) {
                                    C12176p.m18851ok().m18852n(c11998a);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < m17599ok.m17593ok("noti_continue_restart_times", 1)) {
                                    C12176p.m18851ok().m18848ok(c11998a);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && C12713kf.m16600bl(downloadInfo) && !C12197j.m18805a(c11998a) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < m17599ok.m17593ok("noti_install_restart_times", 1)) {
                                C12176p.m18851ok().m18855bl(c11998a);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r
    /* renamed from: ok */
    public void mo17854ok() {
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12298h
    /* renamed from: ok */
    public void mo18403ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        m18843ok(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12298h
    /* renamed from: ok */
    public void mo18402ok(List<DownloadInfo> list) {
    }

    @WorkerThread
    /* renamed from: ok */
    public void m18843ok(DownloadInfo downloadInfo, int i, boolean z) {
        C12032kf.m19324ok().m19333a();
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            return;
        }
        try {
            if (z) {
                m19315ok.m19520bl(downloadInfo.getFailedResumeCount());
            } else if (m19315ok.m19503fb() == -1) {
                return;
            } else {
                m19315ok.m19520bl(-1);
            }
            C12038q.m19278ok().m19277ok(m19315ok);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            C12270ok.m18539ok().m18523ok("embeded_ad", "download_uncompleted", jSONObject, m19315ok);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
