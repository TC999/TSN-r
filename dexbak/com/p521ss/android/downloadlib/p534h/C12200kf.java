package com.p521ss.android.downloadlib.p534h;

import androidx.annotation.NonNull;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.socialbase.appdownloader.C12284a;
import com.p521ss.android.socialbase.appdownloader.C12310h;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12318ok;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12329s;
import com.p521ss.android.socialbase.appdownloader.p545n.C12336s;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.h.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12200kf {
    /* renamed from: a */
    public static void m18761a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        C11998a m19315ok;
        double d;
        if (jSONObject == null || (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) == null) {
            return;
        }
        try {
            m18759bl(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - m19315ok.m19460qx()));
            jSONObject.putOpt("click_download_size", Long.valueOf(m19315ok.m19443tr()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            m19315ok.m19438vz();
            C12038q.m19278ok().m19277ok(m19315ok);
            jSONObject.put("click_pause_times", m19315ok.m19506ep());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes < 0 || totalBytes <= 0) {
                d = Utils.DOUBLE_EPSILON;
            } else {
                double d2 = curBytes;
                double d3 = totalBytes;
                Double.isNaN(d2);
                Double.isNaN(d3);
                d = d2 / d3;
            }
            jSONObject.put("download_percent", d);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long m19509e = m19315ok.m19509e();
            if (m19509e > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - m19509e);
            }
            long m19482kz = m19315ok.m19482kz();
            if (m19482kz > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - m19482kz);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(m19315ok.m19500g()));
            jSONObject.putOpt("fail_msg", m19315ok.m19440v());
            jSONObject.put("download_failed_times", m19315ok.m19433y());
            jSONObject.put("can_show_notification", C12336s.m18119ok() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: bl */
    public static void m18759bl(DownloadInfo downloadInfo, JSONObject jSONObject) {
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
                C11998a m19323ok = C12032kf.m19324ok().m19323ok(downloadInfo.getId());
                if (m19323ok != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(m19323ok.m19460qx()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(m19323ok.m19443tr()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(C12336s.m18119ok() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(C12713kf.m16602bl(C12128r.getContext()) ? 1 : 2));
        if (!C12713kf.m16620a(C12128r.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    /* renamed from: ok */
    public static void m18757ok(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            m18759bl(downloadInfo, jSONObject);
            C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
            if (m19315ok == null) {
                return;
            }
            jSONObject.put("is_update_download", m19315ok.m19514cs() ? 1 : 2);
            m18758ok(m19315ok, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    public static void m18758ok(C11998a c11998a, JSONObject jSONObject) {
        if (jSONObject == null || c11998a == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", c11998a.m19445tg() ? 1 : 0);
            jSONObject.put("origin_mime_type", c11998a.m19437w());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    public static void m18755ok(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray m17601n = C12534ok.m17599ok(i).m17601n("ah_report_config");
        if (m17601n != null) {
            for (int i2 = 0; i2 < m17601n.length(); i2++) {
                try {
                    String string = m17601n.getString(i2);
                    C12310h.C12311ok m18219ok = C12318ok.m18219ok(string);
                    if (m18219ok != null) {
                        String replaceAll = string.replaceAll("\\.", "_");
                        jSONObject.put(replaceAll, m18219ok.m18371kf() + "_" + m18219ok.m18372h());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", C12284a.m18470ok(C12490bl.m17807l()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ok */
    public static JSONObject m18754ok(@NonNull JSONObject jSONObject, InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, "open_url", C12197j.m18774ok(interfaceC11999ok.mo19302kf(), "open_url_not_exist"));
        return jSONObject;
    }

    /* renamed from: ok */
    public static void m18756ok(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", C12329s.m18164ok());
            jSONObject.putOpt("harmony_release_type", C12329s.m18169bl());
            jSONObject.putOpt("harmony_build_version", C12329s.m18159s());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(C12329s.m18162ok(C12128r.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(C12329s.m18165n() ? 1 : 2));
            jSONObject.putOpt("harmony_version", C12329s.m18172a());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(C12329s.m18171a(C12128r.getContext()) ? 1 : 2));
            if (!C12329s.m18166kf()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static JSONObject m18760a(@NonNull JSONObject jSONObject, InterfaceC11999ok interfaceC11999ok) {
        C12197j.m18778ok(jSONObject, C12317n.m18239k().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(C12197j.m18806a(C12128r.getContext(), C12317n.m18239k())));
        C12197j.m18778ok(jSONObject, C12317n.m18239k().replaceAll("\\.", "_") + " versionName", C12197j.m18801bl(C12128r.getContext(), C12317n.m18239k()));
        return jSONObject;
    }
}
