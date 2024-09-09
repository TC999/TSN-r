package com.ss.android.downloadlib.h;

import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {
    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ok.a ok;
        double d4;
        if (jSONObject == null || (ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo)) == null) {
            return;
        }
        try {
            bl(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - ok.qx()));
            jSONObject.putOpt("click_download_size", Long.valueOf(ok.tr()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            ok.vz();
            com.ss.android.downloadlib.addownload.a.q.ok().ok(ok);
            jSONObject.put("click_pause_times", ok.ep());
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
            long e4 = ok.e();
            if (e4 > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - e4);
            }
            long kz = ok.kz();
            if (kz > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - kz);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(ok.g()));
            jSONObject.putOpt("fail_msg", ok.v());
            jSONObject.put("download_failed_times", ok.y());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.n.s.ok() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void bl(DownloadInfo downloadInfo, JSONObject jSONObject) {
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
                com.ss.android.downloadad.api.ok.a ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo.getId());
                if (ok != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(ok.qx()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(ok.tr()));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        int i4 = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.n.s.ok() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.q.kf.bl(com.ss.android.downloadlib.addownload.r.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.downloadlib.addownload.r.getContext())) {
            i4 = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i4));
    }

    public static void ok(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            bl(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.ok.a ok = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
            if (ok == null) {
                return;
            }
            jSONObject.put("is_update_download", ok.cs() ? 1 : 2);
            ok(ok, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void ok(com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", aVar.tg() ? 1 : 0);
            jSONObject.put("origin_mime_type", aVar.w());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void ok(JSONObject jSONObject, int i4) {
        if (jSONObject == null) {
            return;
        }
        JSONArray n4 = com.ss.android.socialbase.downloader.h.ok.ok(i4).n("ah_report_config");
        if (n4 != null) {
            for (int i5 = 0; i5 < n4.length(); i5++) {
                try {
                    String string = n4.getString(i5);
                    h.ok ok = com.ss.android.socialbase.appdownloader.kf.ok.ok(string);
                    if (ok != null) {
                        String replaceAll = string.replaceAll("\\.", "_");
                        jSONObject.put(replaceAll, ok.kf() + "_" + ok.h());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.a.ok(com.ss.android.socialbase.downloader.downloader.bl.l()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject ok(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "open_url", j.ok(okVar.kf(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void ok(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.kf.s.ok());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.kf.s.bl());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.kf.s.s());
            int i4 = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.kf.s.ok(com.ss.android.downloadlib.addownload.r.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.kf.s.n() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.kf.s.a());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.kf.s.a(com.ss.android.downloadlib.addownload.r.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.kf.s.kf()) {
                i4 = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static JSONObject a(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, com.ss.android.socialbase.appdownloader.kf.n.k().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(j.a(com.ss.android.downloadlib.addownload.r.getContext(), com.ss.android.socialbase.appdownloader.kf.n.k())));
        j.ok(jSONObject, com.ss.android.socialbase.appdownloader.kf.n.k().replaceAll("\\.", "_") + " versionName", j.bl(com.ss.android.downloadlib.addownload.r.getContext(), com.ss.android.socialbase.appdownloader.kf.n.k()));
        return jSONObject;
    }
}
