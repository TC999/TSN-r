package com.ss.android.downloadlib.r;

import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.socialbase.appdownloader.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {
    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            xv(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
            if (c4 == null) {
                return;
            }
            jSONObject.put("is_update_download", c4.bm() ? 1 : 2);
            c(c4, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void w(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.c.w c4;
        double d4;
        if (jSONObject == null || (c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo)) == null) {
            return;
        }
        try {
            xv(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - c4.au()));
            jSONObject.putOpt("click_download_size", Long.valueOf(c4.bj()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            c4.ck();
            com.ss.android.downloadlib.addownload.w.gd.c().c(c4);
            jSONObject.put("click_pause_times", c4.n());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes < 0 || totalBytes <= 0) {
                d4 = 0.0d;
            } else {
                double d5 = curBytes;
                double d6 = totalBytes;
                Double.isNaN(d5);
                Double.isNaN(d6);
                d4 = d5 / d6;
            }
            jSONObject.put("download_percent", d4);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long xk = c4.xk();
            if (xk > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - xk);
            }
            long z3 = c4.z();
            if (z3 > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - z3);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(c4.eq()));
            jSONObject.putOpt("fail_msg", c4.me());
            jSONObject.put("download_failed_times", c4.ls());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.ux.sr.c() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void xv(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt(DownloadModel.TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt(DownloadModel.FILE_NAME, downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo.getId());
                if (c4 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(c4.au()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(c4.bj()));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        int i4 = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.ux.sr.c() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.gd.f.xv(com.ss.android.downloadlib.addownload.k.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.gd.f.w(com.ss.android.downloadlib.addownload.k.getContext())) {
            i4 = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i4));
    }

    public static void c(com.ss.android.downloadad.api.c.w wVar, JSONObject jSONObject) {
        if (jSONObject == null || wVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", wVar.wo() ? 1 : 0);
            jSONObject.put("origin_mime_type", wVar.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(JSONObject jSONObject, int i4) {
        if (jSONObject == null) {
            return;
        }
        JSONArray ux = com.ss.android.socialbase.downloader.r.c.c(i4).ux("ah_report_config");
        if (ux != null) {
            for (int i5 = 0; i5 < ux.length(); i5++) {
                try {
                    String string = ux.getString(i5);
                    r.c c4 = com.ss.android.socialbase.appdownloader.f.c.c(string);
                    if (c4 != null) {
                        String replaceAll = string.replaceAll("\\.", "_");
                        jSONObject.put(replaceAll, c4.f() + "_" + c4.r());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.w.c(com.ss.android.socialbase.downloader.downloader.xv.gw()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, "open_url", a.c(cVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void c(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.f.sr.c());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.f.sr.xv());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.f.sr.sr());
            int i4 = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.sr.c(com.ss.android.downloadlib.addownload.k.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.sr.ux() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.f.sr.w());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.sr.w(com.ss.android.downloadlib.addownload.k.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.f.sr.f()) {
                i4 = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static JSONObject w(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.c.c cVar) {
        a.c(jSONObject, com.ss.android.socialbase.appdownloader.f.ux.p().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(a.w(com.ss.android.downloadlib.addownload.k.getContext(), com.ss.android.socialbase.appdownloader.f.ux.p())));
        a.c(jSONObject, com.ss.android.socialbase.appdownloader.f.ux.p().replaceAll("\\.", "_") + " versionName", a.xv(com.ss.android.downloadlib.addownload.k.getContext(), com.ss.android.socialbase.appdownloader.f.ux.p()));
        return jSONObject;
    }
}
