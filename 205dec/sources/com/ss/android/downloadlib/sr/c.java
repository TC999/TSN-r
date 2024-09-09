package com.ss.android.downloadlib.sr;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.xv;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.downloadlib.addownload.w.gd;
import com.ss.android.downloadlib.addownload.w.ux;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.appdownloader.ux.sr;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.sr.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class C0959c {

        /* renamed from: c  reason: collision with root package name */
        private static c f48942c = new c();
    }

    public static c c() {
        return C0959c.f48942c;
    }

    public void w(long j4, int i4) {
        c(j4, i4, (DownloadInfo) null);
    }

    private c() {
    }

    public void c(long j4, int i4) {
        ux ux = f.c().ux(j4);
        if (ux.ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("sendClickEvent ModelBox notValid");
        } else if (ux.xv.isEnableClickEvent()) {
            int i5 = 1;
            DownloadEventConfig downloadEventConfig = ux.xv;
            String clickItemTag = i4 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String c4 = a.c(ux.xv.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i4));
                jSONObject.putOpt("permission_notification", Integer.valueOf(sr.c() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.gd.f.xv(k.getContext())) {
                    i5 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i5));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            c(clickItemTag, c4, jSONObject, ux);
            if (!"click".equals(c4) || ux.f48723w == null) {
                return;
            }
            xv.c().c(j4, ux.f48723w.getLogExtra());
        }
    }

    public void w(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.c.w c4 = f.c().c(downloadInfo);
        if (c4 == null) {
            com.ss.android.downloadlib.ux.xv.c().c("sendDownloadFailedEvent nativeModel null");
        } else if (c4.xv.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
                com.ss.android.downloadlib.c.c(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    c4.sr(baseException.getErrorCode());
                    c4.c(baseException.getErrorMessage());
                }
                c4.gb();
                jSONObject.put("download_failed_times", c4.ls());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                int i4 = 1;
                jSONObject.put("has_send_download_failed_finally", c4.sr.get() ? 1 : 2);
                com.ss.android.downloadlib.r.f.c(c4, jSONObject);
                if (!c4.bm()) {
                    i4 = 2;
                }
                jSONObject.put("is_update_download", i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            c(c4.p(), "download_failed", jSONObject, c4);
            gd.c().c(c4);
        }
    }

    public void c(long j4, int i4, DownloadInfo downloadInfo) {
        ux ux = f.c().ux(j4);
        if (ux.ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, "download_scene", Integer.valueOf(ux.u()));
        if (i4 == 1) {
            str = a.c(ux.xv.getStorageDenyLabel(), "storage_deny");
        } else if (i4 == 2) {
            str = a.c(ux.xv.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.r.f.c(downloadInfo, jSONObject);
        } else if (i4 == 3) {
            str = a.c(ux.xv.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.r.f.w(downloadInfo, jSONObject);
        } else if (i4 == 4) {
            str = a.c(ux.xv.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
        } else if (i4 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.r.f.c(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.c.w(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = a.c(ux.xv.getClickInstallLabel(), "click_install");
        }
        c(null, str, jSONObject, 0L, 1, ux);
    }

    public void w(String str, com.ss.android.downloadad.api.c.c cVar) {
        c((String) null, str, cVar);
    }

    public void w(String str, JSONObject jSONObject, com.ss.android.downloadad.api.c.c cVar) {
        c((String) null, str, jSONObject, cVar);
    }

    public void c(String str, int i4, ux uxVar) {
        c(null, str, null, i4, 0, uxVar);
    }

    public void c(long j4, boolean z3, int i4) {
        ux ux = f.c().ux(j4);
        if (ux.ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("sendQuickAppEvent ModelBox notValid");
        } else if (ux.f48723w.getQuickAppModel() == null) {
        } else {
            DownloadModel downloadModel = ux.f48723w;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i4));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            w(z3 ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, ux);
        }
    }

    public void c(long j4, BaseException baseException) {
        ux ux = f.c().ux(j4);
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
        w("download_failed", jSONObject, ux);
    }

    public void c(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.c.w c4 = f.c().c(downloadInfo);
        if (c4 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
            c4.c(System.currentTimeMillis());
            c(c4.p(), "download_resume", jSONObject, c4);
            gd.c().c(c4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.c.w wVar) {
        c(wVar.p(), "install_finish", jSONObject, wVar);
    }

    public void c(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.c.w c4;
        if (downloadInfo == null || (c4 = f.c().c(downloadInfo)) == null || c4.xv.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.c.c(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(c4.eq()));
            jSONObject.putOpt("fail_msg", c4.me());
            jSONObject.put("download_failed_times", c4.ls());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (c4.xk() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - c4.xk());
            }
            if (c4.z() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - c4.z());
            }
            int i4 = 1;
            jSONObject.put("is_update_download", c4.bm() ? 1 : 2);
            jSONObject.put("can_show_notification", sr.c() ? 1 : 2);
            if (!c4.sr.get()) {
                i4 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c(c4.p(), "download_cancel", jSONObject, c4);
    }

    public void c(String str, com.ss.android.downloadad.api.c.c cVar) {
        c(str, (JSONObject) null, cVar);
    }

    public void c(String str, JSONObject jSONObject, long j4) {
        com.ss.android.downloadad.api.c.c sr = f.c().sr(j4);
        if (sr != null) {
            c(str, jSONObject, sr);
            return;
        }
        ux ux = f.c().ux(j4);
        if (ux.ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("sendUnityEvent ModelBox notValid");
        } else {
            c(str, jSONObject, ux);
        }
    }

    public void c(String str, JSONObject jSONObject, com.ss.android.downloadad.api.c.c cVar) {
        JSONObject jSONObject2 = new JSONObject();
        a.c(jSONObject2, "unity_label", str);
        c("embeded_ad", "ttdownloader_unity", a.c(jSONObject, jSONObject2), cVar);
    }

    public void c(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        w(str, new ux(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void c(String str, long j4) {
        com.ss.android.downloadad.api.c.w sr = f.c().sr(j4);
        if (sr != null) {
            w(str, sr);
        } else {
            w(str, f.c().ux(j4));
        }
    }

    public void c(String str, String str2, com.ss.android.downloadad.api.c.c cVar) {
        c(str, str2, (JSONObject) null, cVar);
    }

    public void c(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.c.c cVar) {
        c(str, str2, jSONObject, 0L, 0, cVar);
    }

    private void c(String str, String str2, JSONObject jSONObject, long j4, int i4, com.ss.android.downloadad.api.c.c cVar) {
        if (cVar == null) {
            com.ss.android.downloadlib.ux.xv.c().c("onEvent data null");
        } else if ((cVar instanceof ux) && ((ux) cVar).ls()) {
            com.ss.android.downloadlib.ux.xv.c().c("onEvent ModelBox notValid");
        } else {
            try {
                xv.c xv = new xv.c().c(a.c(str, cVar.p(), "embeded_ad")).w(str2).w(cVar.xv()).c(cVar.w()).xv(cVar.sr());
                if (j4 <= 0) {
                    j4 = cVar.a();
                }
                xv.c c4 = xv.w(j4).sr(cVar.gd()).c(cVar.t()).c(a.c(c(cVar), jSONObject)).w(cVar.k()).c(cVar.ys());
                if (i4 <= 0) {
                    i4 = 2;
                }
                c(c4.c(i4).c(cVar.bk()).c());
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "onEvent");
            }
        }
    }

    private JSONObject c(com.ss.android.downloadad.api.c.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            a.c(cVar.r(), jSONObject);
            a.c(cVar.fp(), jSONObject);
            jSONObject.putOpt(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL, cVar.c());
            jSONObject.putOpt("package_name", cVar.ux());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.ux.ev());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.ux.gd());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(cVar.ev()));
            if (cVar.ev() == 2) {
                com.ss.android.downloadlib.r.f.w(jSONObject, cVar);
            }
            if (com.ss.android.socialbase.appdownloader.f.ux.fp()) {
                com.ss.android.downloadlib.r.f.c(jSONObject);
            }
        } catch (Exception e4) {
            k.u().c(e4, "getBaseJson");
        }
        return jSONObject;
    }

    private void c(com.ss.android.download.api.model.xv xvVar) {
        if (k.c() == null) {
            return;
        }
        if (xvVar.bk()) {
            k.c().c(xvVar);
        } else {
            k.c().w(xvVar);
        }
    }
}
