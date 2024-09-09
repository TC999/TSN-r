package com.ss.android.downloadlib.xv;

import androidx.annotation.WorkerThread;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.downloadlib.addownload.w.gd;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr implements com.ss.android.socialbase.appdownloader.xv.r, k {
    public void c() {
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.r
    public void c(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        c(downloadInfo, downloadInfo.getRealStatus(), z3);
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.r
    public void c(List<DownloadInfo> list) {
    }

    public void w() {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.xv.sr.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.w.f.c().w();
                for (com.ss.android.downloadad.api.c.w wVar : com.ss.android.downloadlib.addownload.w.f.c().xv().values()) {
                    int fz = wVar.fz();
                    if (fz != 0) {
                        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(fz);
                        if (c4.w("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.getContext()).getDownloadInfo(fz)) != null) {
                            if (a.w(wVar) && !a.xv(wVar.ux())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < c4.c("noti_open_restart_times", 1)) {
                                    ev.c().ux(wVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < c4.c("noti_continue_restart_times", 1)) {
                                    ev.c().c(wVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.gd.f.xv(downloadInfo) && !a.w(wVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < c4.c("noti_install_restart_times", 1)) {
                                ev.c().xv(wVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @WorkerThread
    public void c(DownloadInfo downloadInfo, int i4, boolean z3) {
        com.ss.android.downloadlib.addownload.w.f.c().w();
        com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        if (c4 == null) {
            return;
        }
        try {
            if (z3) {
                c4.xv(downloadInfo.getFailedResumeCount());
            } else if (c4.y() == -1) {
                return;
            } else {
                c4.xv(-1);
            }
            gd.c().c(c4);
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
            com.ss.android.downloadlib.sr.c.c().c("embeded_ad", "download_uncompleted", jSONObject, c4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
