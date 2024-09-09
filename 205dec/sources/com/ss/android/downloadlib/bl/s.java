package com.ss.android.downloadlib.bl;

import androidx.annotation.WorkerThread;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s implements com.ss.android.socialbase.appdownloader.bl.h, r {
    @Override // com.ss.android.socialbase.downloader.depend.r
    public void a() {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.s.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.a.kf.ok().a();
                for (com.ss.android.downloadad.api.ok.a aVar : com.ss.android.downloadlib.addownload.a.kf.ok().bl().values()) {
                    int zz = aVar.zz();
                    if (zz != 0) {
                        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(zz);
                        if (ok.a("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(zz)) != null) {
                            if (j.a(aVar) && !j.bl(aVar.n())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < ok.ok("noti_open_restart_times", 1)) {
                                    p.ok().n(aVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < ok.ok("noti_continue_restart_times", 1)) {
                                    p.ok().ok(aVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.q.kf.bl(downloadInfo) && !j.a(aVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < ok.ok("noti_install_restart_times", 1)) {
                                p.ok().bl(aVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public void ok() {
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.h
    public void ok(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        ok(downloadInfo, downloadInfo.getRealStatus(), z3);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.h
    public void ok(List<DownloadInfo> list) {
    }

    @WorkerThread
    public void ok(DownloadInfo downloadInfo, int i4, boolean z3) {
        com.ss.android.downloadlib.addownload.a.kf.ok().a();
        com.ss.android.downloadad.api.ok.a ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (ok == null) {
            return;
        }
        try {
            if (z3) {
                ok.bl(downloadInfo.getFailedResumeCount());
            } else if (ok.fb() == -1) {
                return;
            } else {
                ok.bl(-1);
            }
            q.ok().ok(ok);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i4);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
            int i5 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z3) {
                i5 = 2;
            }
            jSONObject.put("launch_resumed", i5);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "download_uncompleted", jSONObject, ok);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
