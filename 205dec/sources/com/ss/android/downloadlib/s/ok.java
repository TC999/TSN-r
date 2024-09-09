package com.ss.android.downloadlib.s;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.bl;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.a.n;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.n.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.s.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C0958ok {
        private static ok ok = new ok();
    }

    public static ok ok() {
        return C0958ok.ok;
    }

    public void a(long j4, int i4) {
        ok(j4, i4, (DownloadInfo) null);
    }

    private ok() {
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.ok.a ok = kf.ok().ok(downloadInfo);
        if (ok == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendDownloadFailedEvent nativeModel null");
        } else if (ok.bl.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
                com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    ok.s(baseException.getErrorCode());
                    ok.ok(baseException.getErrorMessage());
                }
                ok.m();
                jSONObject.put("download_failed_times", ok.y());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                int i4 = 1;
                jSONObject.put("has_send_download_failed_finally", ok.f48318s.get() ? 1 : 2);
                com.ss.android.downloadlib.h.kf.ok(ok, jSONObject);
                if (!ok.cs()) {
                    i4 = 2;
                }
                jSONObject.put("is_update_download", i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            ok(ok.k(), "download_failed", jSONObject, ok);
            q.ok().ok(ok);
        }
    }

    public void ok(long j4, int i4) {
        n n4 = kf.ok().n(j4);
        if (n4.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendClickEvent ModelBox notValid");
        } else if (n4.bl.isEnableClickEvent()) {
            int i5 = 1;
            DownloadEventConfig downloadEventConfig = n4.bl;
            String clickItemTag = i4 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String ok = j.ok(n4.bl.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i4));
                jSONObject.putOpt("permission_notification", Integer.valueOf(s.ok() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.q.kf.bl(r.getContext())) {
                    i5 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i5));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            ok(clickItemTag, ok, jSONObject, n4);
            if (!"click".equals(ok) || n4.f48371a == null) {
                return;
            }
            bl.ok().ok(j4, n4.f48371a.getLogExtra());
        }
    }

    public void ok(long j4, int i4, DownloadInfo downloadInfo) {
        n n4 = kf.ok().n(j4);
        if (n4.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "download_scene", Integer.valueOf(n4.u()));
        if (i4 == 1) {
            str = j.ok(n4.bl.getStorageDenyLabel(), "storage_deny");
        } else if (i4 == 2) {
            str = j.ok(n4.bl.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.h.kf.ok(downloadInfo, jSONObject);
        } else if (i4 == 3) {
            str = j.ok(n4.bl.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.h.kf.a(downloadInfo, jSONObject);
        } else if (i4 == 4) {
            str = j.ok(n4.bl.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
        } else if (i4 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.h.kf.ok(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.ok.a(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = j.ok(n4.bl.getClickInstallLabel(), "click_install");
        }
        ok(null, str, jSONObject, 0L, 1, n4);
    }

    public void a(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        ok((String) null, str, okVar);
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        ok((String) null, str, jSONObject, okVar);
    }

    public void ok(String str, int i4, n nVar) {
        ok(null, str, null, i4, 0, nVar);
    }

    public void ok(long j4, boolean z3, int i4) {
        n n4 = kf.ok().n(j4);
        if (n4.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendQuickAppEvent ModelBox notValid");
        } else if (n4.f48371a.getQuickAppModel() == null) {
        } else {
            DownloadModel downloadModel = n4.f48371a;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i4));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            a(z3 ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, n4);
        }
    }

    public void ok(long j4, BaseException baseException) {
        n n4 = kf.ok().n(j4);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        a("download_failed", jSONObject, n4);
    }

    public void ok(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.ok.a ok = kf.ok().ok(downloadInfo);
        if (ok == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            ok.ok(System.currentTimeMillis());
            ok(ok.k(), "download_resume", jSONObject, ok);
            q.ok().ok(ok);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ok(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        ok(aVar.k(), "install_finish", jSONObject, aVar);
    }

    public void ok(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.ok.a ok;
        if (downloadInfo == null || (ok = kf.ok().ok(downloadInfo)) == null || ok.bl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(ok.g()));
            jSONObject.putOpt("fail_msg", ok.v());
            jSONObject.put("download_failed_times", ok.y());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (ok.e() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - ok.e());
            }
            if (ok.kz() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - ok.kz());
            }
            int i4 = 1;
            jSONObject.put("is_update_download", ok.cs() ? 1 : 2);
            jSONObject.put("can_show_notification", s.ok() ? 1 : 2);
            if (!ok.f48318s.get()) {
                i4 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        ok(ok.k(), "download_cancel", jSONObject, ok);
    }

    public void ok(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, (JSONObject) null, okVar);
    }

    public void ok(String str, JSONObject jSONObject, long j4) {
        com.ss.android.downloadad.api.ok.ok s3 = kf.ok().s(j4);
        if (s3 != null) {
            ok(str, jSONObject, s3);
            return;
        }
        n n4 = kf.ok().n(j4);
        if (n4.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendUnityEvent ModelBox notValid");
        } else {
            ok(str, jSONObject, n4);
        }
    }

    public void ok(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        JSONObject jSONObject2 = new JSONObject();
        j.ok(jSONObject2, "unity_label", str);
        ok("embeded_ad", "ttdownloader_unity", j.ok(jSONObject, jSONObject2), okVar);
    }

    public void ok(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        a(str, new n(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void ok(String str, long j4) {
        com.ss.android.downloadad.api.ok.a s3 = kf.ok().s(j4);
        if (s3 != null) {
            a(str, s3);
        } else {
            a(str, kf.ok().n(j4));
        }
    }

    public void ok(String str, String str2, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, str2, (JSONObject) null, okVar);
    }

    public void ok(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, str2, jSONObject, 0L, 0, okVar);
    }

    private void ok(String str, String str2, JSONObject jSONObject, long j4, int i4, com.ss.android.downloadad.api.ok.ok okVar) {
        if (okVar == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("onEvent data null");
        } else if ((okVar instanceof n) && ((n) okVar).y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("onEvent ModelBox notValid");
        } else {
            try {
                bl.ok bl = new bl.ok().ok(j.ok(str, okVar.k(), "embeded_ad")).a(str2).a(okVar.bl()).ok(okVar.a()).bl(okVar.s());
                if (j4 <= 0) {
                    j4 = okVar.j();
                }
                bl.ok ok = bl.a(j4).s(okVar.q()).ok(okVar.rh()).ok(j.ok(ok(okVar), jSONObject)).a(okVar.r()).ok(okVar.t());
                if (i4 <= 0) {
                    i4 = 2;
                }
                ok(ok.ok(i4).ok(okVar.z()).ok());
            } catch (Exception e4) {
                com.ss.android.downloadlib.n.bl.ok().ok(e4, "onEvent");
            }
        }
    }

    private JSONObject ok(com.ss.android.downloadad.api.ok.ok okVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            j.ok(okVar.h(), jSONObject);
            j.ok(okVar.i(), jSONObject);
            jSONObject.putOpt(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL, okVar.ok());
            jSONObject.putOpt("package_name", okVar.n());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.kf.n.p());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.kf.n.q());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(okVar.p()));
            if (okVar.p() == 2) {
                com.ss.android.downloadlib.h.kf.a(jSONObject, okVar);
            }
            if (com.ss.android.socialbase.appdownloader.kf.n.i()) {
                com.ss.android.downloadlib.h.kf.ok(jSONObject);
            }
        } catch (Exception e4) {
            r.u().ok(e4, "getBaseJson");
        }
        return jSONObject;
    }

    private void ok(com.ss.android.download.api.model.bl blVar) {
        if (r.ok() == null) {
            return;
        }
        if (blVar.z()) {
            r.ok().ok(blVar);
        } else {
            r.ok().a(blVar);
        }
    }
}
