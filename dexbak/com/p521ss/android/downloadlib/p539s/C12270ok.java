package com.p521ss.android.downloadlib.p539s;

import android.os.Build;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.C11984bl;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12238ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12200kf;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.appdownloader.p545n.C12336s;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.s.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12270ok {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.s.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12272ok {

        /* renamed from: ok */
        private static C12270ok f34613ok = new C12270ok();
    }

    /* renamed from: ok */
    public static C12270ok m18539ok() {
        return C12272ok.f34613ok;
    }

    /* renamed from: a */
    public void m18543a(long j, int i) {
        m18536ok(j, i, (DownloadInfo) null);
    }

    private C12270ok() {
    }

    /* renamed from: a */
    public void m18542a(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            C12235bl.m18640ok().m18639ok("sendDownloadFailedEvent nativeModel null");
        } else if (m19315ok.f33927bl.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                C12200kf.m18759bl(downloadInfo, jSONObject);
                C12238ok.m18610ok(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    m19315ok.m19453s(baseException.getErrorCode());
                    m19315ok.m19472ok(baseException.getErrorMessage());
                }
                m19315ok.m19479m();
                jSONObject.put("download_failed_times", m19315ok.m19433y());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                int i = 1;
                jSONObject.put("has_send_download_failed_finally", m19315ok.f33965s.get() ? 1 : 2);
                C12200kf.m18758ok(m19315ok, jSONObject);
                if (!m19315ok.m19514cs()) {
                    i = 2;
                }
                jSONObject.put("is_update_download", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m18523ok(m19315ok.mo19303k(), "download_failed", jSONObject, m19315ok);
            C12038q.m19278ok().m19277ok(m19315ok);
        }
    }

    /* renamed from: ok */
    public void m18537ok(long j, int i) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        if (m19325n.m19287y()) {
            C12235bl.m18640ok().m18639ok("sendClickEvent ModelBox notValid");
        } else if (m19325n.f34077bl.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = m19325n.f34077bl;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String m18774ok = C12197j.m18774ok(m19325n.f34077bl.getClickLabel(), CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(C12336s.m18119ok() ? 1 : 2));
                if (!C12713kf.m16602bl(C12128r.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m18523ok(clickItemTag, m18774ok, jSONObject, m19325n);
            if (!CampaignEx.JSON_NATIVE_VIDEO_CLICK.equals(m18774ok) || m19325n.f34076a == null) {
                return;
            }
            C12269bl.m18545ok().m18544ok(j, m19325n.f34076a.getLogExtra());
        }
    }

    /* renamed from: ok */
    public void m18536ok(long j, int i, DownloadInfo downloadInfo) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        if (m19325n.m19287y()) {
            C12235bl.m18640ok().m18639ok("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(m19325n.mo19290u()));
        if (i == 1) {
            str = C12197j.m18774ok(m19325n.f34077bl.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            str = C12197j.m18774ok(m19325n.f34077bl.getClickStartLabel(), "click_start");
            C12200kf.m18757ok(downloadInfo, jSONObject);
        } else if (i == 3) {
            str = C12197j.m18774ok(m19325n.f34077bl.getClickPauseLabel(), "click_pause");
            C12200kf.m18761a(downloadInfo, jSONObject);
        } else if (i == 4) {
            str = C12197j.m18774ok(m19325n.f34077bl.getClickContinueLabel(), "click_continue");
            C12200kf.m18759bl(downloadInfo, jSONObject);
        } else if (i == 5) {
            if (downloadInfo != null) {
                try {
                    C12200kf.m18755ok(jSONObject, downloadInfo.getId());
                    C12238ok.m18630a(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = C12197j.m18774ok(m19325n.f34077bl.getClickInstallLabel(), "click_install");
        }
        m18524ok(null, str, jSONObject, 0L, 1, m19325n);
    }

    /* renamed from: a */
    public void m18541a(String str, InterfaceC11999ok interfaceC11999ok) {
        m18525ok((String) null, str, interfaceC11999ok);
    }

    /* renamed from: a */
    public void m18540a(String str, JSONObject jSONObject, InterfaceC11999ok interfaceC11999ok) {
        m18523ok((String) null, str, jSONObject, interfaceC11999ok);
    }

    /* renamed from: ok */
    public void m18529ok(String str, int i, C12035n c12035n) {
        m18524ok(null, str, null, i, 0, c12035n);
    }

    /* renamed from: ok */
    public void m18534ok(long j, boolean z, int i) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        if (m19325n.m19287y()) {
            C12235bl.m18640ok().m18639ok("sendQuickAppEvent ModelBox notValid");
        } else if (m19325n.f34076a.getQuickAppModel() == null) {
        } else {
            DownloadModel downloadModel = m19325n.f34076a;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m18540a(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, m19325n);
        }
    }

    /* renamed from: ok */
    public void m18535ok(long j, BaseException baseException) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m18540a("download_failed", jSONObject, m19325n);
    }

    /* renamed from: ok */
    public void m18531ok(DownloadInfo downloadInfo) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            C12200kf.m18759bl(downloadInfo, jSONObject);
            m19315ok.m19473ok(System.currentTimeMillis());
            m18523ok(m19315ok.mo19303k(), "download_resume", jSONObject, m19315ok);
            C12038q.m19278ok().m19277ok(m19315ok);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    public void m18520ok(JSONObject jSONObject, @NonNull C11998a c11998a) {
        m18523ok(c11998a.mo19303k(), "install_finish", jSONObject, c11998a);
    }

    /* renamed from: ok */
    public void m18530ok(DownloadInfo downloadInfo, BaseException baseException) {
        C11998a m19315ok;
        if (downloadInfo == null || (m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo)) == null || m19315ok.f33927bl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            C12238ok.m18610ok(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(m19315ok.m19500g()));
            jSONObject.putOpt("fail_msg", m19315ok.m19440v());
            jSONObject.put("download_failed_times", m19315ok.m19433y());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (m19315ok.m19509e() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - m19315ok.m19509e());
            }
            if (m19315ok.m19482kz() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - m19315ok.m19482kz());
            }
            int i = 1;
            jSONObject.put("is_update_download", m19315ok.m19514cs() ? 1 : 2);
            jSONObject.put("can_show_notification", C12336s.m18119ok() ? 1 : 2);
            if (!m19315ok.f33965s.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m18523ok(m19315ok.mo19303k(), "download_cancel", jSONObject, m19315ok);
    }

    /* renamed from: ok */
    public void m18526ok(String str, InterfaceC11999ok interfaceC11999ok) {
        m18521ok(str, (JSONObject) null, interfaceC11999ok);
    }

    /* renamed from: ok */
    public void m18522ok(String str, JSONObject jSONObject, long j) {
        InterfaceC11999ok m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19311s != null) {
            m18521ok(str, jSONObject, m19311s);
            return;
        }
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        if (m19325n.m19287y()) {
            C12235bl.m18640ok().m18639ok("sendUnityEvent ModelBox notValid");
        } else {
            m18521ok(str, jSONObject, m19325n);
        }
    }

    /* renamed from: ok */
    public void m18521ok(String str, JSONObject jSONObject, InterfaceC11999ok interfaceC11999ok) {
        JSONObject jSONObject2 = new JSONObject();
        C12197j.m18778ok(jSONObject2, "unity_label", str);
        m18523ok("embeded_ad", "ttdownloader_unity", C12197j.m18777ok(jSONObject, jSONObject2), interfaceC11999ok);
    }

    /* renamed from: ok */
    public void m18527ok(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        m18541a(str, new C12035n(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    /* renamed from: ok */
    public void m18528ok(String str, long j) {
        C11998a m19311s = C12032kf.m19324ok().m19311s(j);
        if (m19311s != null) {
            m18541a(str, m19311s);
        } else {
            m18541a(str, C12032kf.m19324ok().m19325n(j));
        }
    }

    /* renamed from: ok */
    public void m18525ok(String str, String str2, InterfaceC11999ok interfaceC11999ok) {
        m18523ok(str, str2, (JSONObject) null, interfaceC11999ok);
    }

    /* renamed from: ok */
    public void m18523ok(String str, String str2, JSONObject jSONObject, InterfaceC11999ok interfaceC11999ok) {
        m18524ok(str, str2, jSONObject, 0L, 0, interfaceC11999ok);
    }

    /* renamed from: ok */
    private void m18524ok(String str, String str2, JSONObject jSONObject, long j, int i, InterfaceC11999ok interfaceC11999ok) {
        if (interfaceC11999ok == null) {
            C12235bl.m18640ok().m18639ok("onEvent data null");
        } else if ((interfaceC11999ok instanceof C12035n) && ((C12035n) interfaceC11999ok).m19287y()) {
            C12235bl.m18640ok().m18639ok("onEvent ModelBox notValid");
        } else {
            try {
                C11984bl.C11985ok m19572bl = new C11984bl.C11985ok().m19560ok(C12197j.m18774ok(str, interfaceC11999ok.mo19303k(), "embeded_ad")).m19576a(str2).m19574a(interfaceC11999ok.mo19308bl()).m19563ok(interfaceC11999ok.mo19309a()).m19572bl(interfaceC11999ok.mo19293s());
                if (j <= 0) {
                    j = interfaceC11999ok.mo19304j();
                }
                C11984bl.C11985ok m19561ok = m19572bl.m19578a(j).m19551s(interfaceC11999ok.mo19296q()).m19559ok(interfaceC11999ok.mo19294rh()).m19558ok(C12197j.m18773ok(m18532ok(interfaceC11999ok), jSONObject)).m19575a(interfaceC11999ok.mo19295r()).m19561ok(interfaceC11999ok.mo19292t());
                if (i <= 0) {
                    i = 2;
                }
                m18533ok(m19561ok.m19564ok(i).m19557ok(interfaceC11999ok.mo19286z()).m19565ok());
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "onEvent");
            }
        }
    }

    /* renamed from: ok */
    private JSONObject m18532ok(InterfaceC11999ok interfaceC11999ok) {
        JSONObject jSONObject = new JSONObject();
        try {
            C12197j.m18777ok(interfaceC11999ok.mo19307h(), jSONObject);
            C12197j.m18777ok(interfaceC11999ok.mo19306i(), jSONObject);
            jSONObject.putOpt(com.mbridge.msdk.foundation.download.database.DownloadModel.DOWNLOAD_URL, interfaceC11999ok.mo19298ok());
            jSONObject.putOpt("package_name", interfaceC11999ok.mo19300n());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", C12317n.m18234p());
            jSONObject.putOpt("rom_version", C12317n.m18233q());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(interfaceC11999ok.mo19297p()));
            if (interfaceC11999ok.mo19297p() == 2) {
                C12200kf.m18760a(jSONObject, interfaceC11999ok);
            }
            if (C12317n.m18241i()) {
                C12200kf.m18756ok(jSONObject);
            }
        } catch (Exception e) {
            C12128r.m18940u().mo18637ok(e, "getBaseJson");
        }
        return jSONObject;
    }

    /* renamed from: ok */
    private void m18533ok(C11984bl c11984bl) {
        if (C12128r.m18959ok() == null) {
            return;
        }
        if (c11984bl.m19579z()) {
            C12128r.m18959ok().mo19654ok(c11984bl);
        } else {
            C12128r.m18959ok().mo19655a(c11984bl);
        }
    }
}
