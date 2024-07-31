package com.p521ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.p521ss.android.downloadad.api.InterfaceC11997ok;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12095n;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.addownload.p528a.C12042s;
import com.p521ss.android.downloadlib.addownload.p529bl.C12052s;
import com.p521ss.android.downloadlib.addownload.p530n.C12108ok;
import com.p521ss.android.downloadlib.addownload.p531ok.C12117ok;
import com.p521ss.android.downloadlib.p527a.C12004a;
import com.p521ss.android.downloadlib.p527a.C12011kf;
import com.p521ss.android.downloadlib.p527a.C12015n;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p527a.InterfaceC12009h;
import com.p521ss.android.downloadlib.p527a.InterfaceC12024s;
import com.p521ss.android.downloadlib.p533bl.C12176p;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12200kf;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p534h.C12202ok;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.C12284a;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12340ok;
import com.p521ss.android.socialbase.appdownloader.p545n.C12336s;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12431fl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.C12636r;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12238ok implements InterfaceC11997ok, C12284a.InterfaceC12288bl, InterfaceC12431fl, C12646ok.InterfaceC12650ok {

    /* renamed from: ok */
    private static String f34517ok = "ok";

    /* renamed from: s */
    private static volatile C12238ok f34518s;

    /* renamed from: a */
    private long f34519a;

    /* renamed from: bl */
    private RunnableC12243a f34520bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.ok$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class RunnableC12243a implements Runnable {

        /* renamed from: a */
        private int f34532a;

        /* renamed from: bl */
        private long f34533bl;

        /* renamed from: n */
        private long f34534n;

        /* renamed from: ok */
        private long f34535ok;

        /* renamed from: s */
        private int f34536s;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m18605a() {
            this.f34534n = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (m18604ok()) {
                    C12238ok.m18626ok().m18623ok(this.f34535ok, this.f34532a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private RunnableC12243a(long j, int i, long j2, int i2) {
            this.f34535ok = j;
            this.f34532a = i;
            this.f34533bl = j2;
            this.f34536s = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
            if (r9 < r1) goto L18;
         */
        /* renamed from: ok */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean m18604ok() {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.C12238ok.RunnableC12243a.m18604ok():boolean");
        }

        /* renamed from: ok */
        private int m18602ok(boolean z, C11998a c11998a, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
            int i = 1;
            if (m17599ok.m17593ok("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!C12713kf.m16574ok(checkMd5Status)) {
                    return PluginError.ERROR_UPD_CAPACITY;
                }
            }
            int i2 = this.f34536s;
            if (i2 != 2000) {
                return i2;
            }
            if (m17599ok.m17593ok("install_failed_check_signature", 1) == 1 && C12197j.m18796n(C12128r.getContext(), c11998a.mo19300n())) {
                if (!C12197j.m18776ok(C12197j.m18771q(C12128r.getContext(), downloadInfo.getTargetFilePath()), C12197j.m18772p(C12128r.getContext(), c11998a.mo19300n()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (z) {
                long j = this.f34534n;
                long j2 = this.f34533bl;
                if (j > j2) {
                    try {
                        jSONObject.put("install_time", j - j2);
                        if (c11998a.m19505er() <= this.f34533bl) {
                            i = 0;
                        }
                        jSONObject.put("install_again", i);
                    } catch (Throwable unused2) {
                    }
                    if (z2) {
                        return PluginError.ERROR_UPD_EXTRACT;
                    }
                    return 2003;
                }
                return 2000;
            }
            return 2002;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.ok$bl */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC12244bl implements Runnable {

        /* renamed from: a */
        private final C11998a f34537a;

        public RunnableC12244bl(C11998a c11998a) {
            this.f34537a = c11998a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f34537a.m19487k(true);
                    C12238ok.this.m18629bl(this.f34537a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.f34537a.m19487k(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC12245ok implements Runnable {

        /* renamed from: a */
        private final int f34539a;

        public RunnableC12245ok(int i) {
            this.f34539a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C12032kf.m19324ok().m19333a();
                ConcurrentHashMap<Long, C11998a> m19328bl = C12032kf.m19324ok().m19328bl();
                if (m19328bl == null || m19328bl.isEmpty()) {
                    return;
                }
                C12238ok.this.m18611ok(m19328bl, this.f34539a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private C12238ok() {
        C12284a.m18460ok(this);
        C12646ok.m16846ok().m16843ok(this);
    }

    /* renamed from: a */
    public static JSONObject m18630a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || C12534ok.m17599ok(downloadInfo.getId()).m17593ok("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long m18808a = C12197j.m18808a(0L);
            double d = m18808a;
            Double.isNaN(d);
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            Double.isNaN(d2);
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (m18808a > 0 && totalBytes > 0) {
                Double.isNaN(d);
                Double.isNaN(d2);
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: bl */
    public void m18629bl(C11998a c11998a) {
        SystemClock.sleep(20000L);
        int i = 15;
        while (i > 0) {
            if (C12197j.m18805a(c11998a)) {
                m18614ok(c11998a.mo19300n());
                return;
            }
            i--;
            if (i == 0) {
                return;
            }
            SystemClock.sleep(20000L);
        }
    }

    /* renamed from: s */
    synchronized void m18609s() {
        RunnableC12243a runnableC12243a = this.f34520bl;
        if (runnableC12243a != null) {
            runnableC12243a.m18605a();
            this.f34520bl = null;
        }
    }

    /* renamed from: ok */
    public static C12238ok m18626ok() {
        if (f34518s == null) {
            synchronized (C12238ok.class) {
                if (f34518s == null) {
                    f34518s = new C12238ok();
                }
            }
        }
        return f34518s;
    }

    /* renamed from: bl */
    public static String m18628bl(@NonNull DownloadInfo downloadInfo, @NonNull C11998a c11998a) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = C12128r.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), C12293bl.m18433ok());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            C12270ok.m18539ok().m18523ok("embeded_ad", "package_name_error", jSONObject, c11998a);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    /* renamed from: s */
    private int m18608s(C11998a c11998a) {
        int realStatus;
        double m17594ok = C12534ok.m17599ok(c11998a.mo19285zz()).m17594ok("download_failed_finally_hours", 48.0d);
        if (m17594ok <= Utils.DOUBLE_EPSILON) {
            return -1;
        }
        if (System.currentTimeMillis() - c11998a.m19509e() < m17594ok * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (c11998a.f33965s.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && c11998a.f33965s.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                m18610ok(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(c11998a.m19500g()));
                jSONObject.putOpt("fail_msg", c11998a.m19440v());
                jSONObject.put("download_failed_times", c11998a.m19433y());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                jSONObject.put("is_update_download", c11998a.m19514cs() ? 1 : 2);
                C12270ok.m18539ok().m18523ok(c11998a.mo19303k(), "download_failed_finally", jSONObject, c11998a);
                C12038q.m19278ok().m19277ok(c11998a);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    /* renamed from: ok */
    public static synchronized void m18616ok(DownloadInfo downloadInfo, C11998a c11998a) {
        synchronized (C12238ok.class) {
            if (downloadInfo == null) {
                C12235bl.m18640ok().m18639ok("onDownloadFinish info null");
            } else if (c11998a == null) {
                C12235bl.m18640ok().m18639ok("onDownloadFinish nativeModel null");
            } else if (c11998a.m19501fl() != 1) {
            } else {
                C12176p.m18851ok().m18845s(c11998a);
                String m18628bl = m18628bl(downloadInfo, c11998a);
                C12032kf.m19324ok().m19329a(downloadInfo.getUrl(), m18628bl);
                Map<Long, C11998a> m19313ok = C12032kf.m19324ok().m19313ok(downloadInfo.getUrl(), m18628bl);
                c11998a.m19485kf(System.currentTimeMillis());
                c11998a.m19478n(2);
                c11998a.m19524a(m18628bl);
                m19313ok.put(Long.valueOf(c11998a.mo19309a()), c11998a);
                C12038q.m19278ok().m19275ok(m19313ok.values());
                m18633a(c11998a);
                C12184h.m18835ok().m18827ok(downloadInfo, m18628bl);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    m18626ok().m18622ok(c11998a);
                    m18626ok().m18632a(downloadInfo, c11998a);
                    if (c11998a.m19461qu()) {
                        C12117ok.m19022ok().m19021ok(downloadInfo.getId(), c11998a.mo19309a(), c11998a.mo19304j(), m18628bl, downloadInfo.getTitle(), c11998a.mo19293s(), downloadInfo.getTargetFilePath());
                    }
                    C12108ok.m19047ok(downloadInfo, c11998a.mo19309a(), c11998a.mo19293s(), m18628bl);
                }
            }
        }
    }

    /* renamed from: a */
    public void m18632a(DownloadInfo downloadInfo, final C11998a c11998a) {
        if (downloadInfo == null || c11998a == null || C12534ok.m17599ok(downloadInfo.getId()).m17593ok("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        C12265s.m18554ok().m18558a(new Runnable() { // from class: com.ss.android.downloadlib.ok.3
            @Override // java.lang.Runnable
            public void run() {
                String m18729ok = C12202ok.m18729ok(targetFilePath);
                if (TextUtils.isEmpty(m18729ok)) {
                    return;
                }
                C12128r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(c11998a.mo19309a()), m18729ok).apply();
            }
        });
    }

    /* renamed from: a */
    private static void m18633a(C11998a c11998a) {
        if (c11998a == null) {
            return;
        }
        String m19436wv = TextUtils.isEmpty(c11998a.m19436wv()) ? "" : c11998a.m19436wv();
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz());
        c11998a.m19492j("");
        C12038q.m19278ok().m19277ok(c11998a);
        JSONObject m18610ok = m18610ok(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            m18610ok.putOpt("finish_reason", m19436wv);
            m18610ok.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        C12200kf.m18755ok(m18610ok, downloadInfo.getId());
        try {
            m18610ok.put("download_failed_times", m19315ok.m19433y());
            m18610ok.put("can_show_notification", C12336s.m18119ok() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                m18610ok.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            m18610ok.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            m18610ok.put("has_send_download_failed_finally", m19315ok.f33965s.get() ? 1 : 2);
            if (!m19315ok.m19514cs()) {
                i = 2;
            }
            m18610ok.put("is_update_download", i);
            C12200kf.m18758ok(m19315ok, m18610ok);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        C12270ok.m18539ok().m18540a("download_finish", m18610ok, c11998a);
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: bl */
    public void mo16835bl() {
        C12409ok.m17904a(f34517ok, "onAppBackground()");
        mo18625ok(6);
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: a */
    public void mo16836a() {
        C12409ok.m17904a(f34517ok, "onAppForeground()");
        m18609s();
        mo18625ok(5);
    }

    @WorkerThread
    /* renamed from: ok */
    public synchronized void m18614ok(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!C12197j.m18809a()) {
            final C11998a m19314ok = C12032kf.m19324ok().m19314ok(str);
            if (m19314ok == null) {
                C12042s.m19268ok().m19266ok(str);
                return;
            }
            C12095n m18826ok = C12184h.m18835ok().m18826ok(m19314ok.mo19298ok());
            if (m18826ok != null) {
                m18826ok.m19090kf();
            }
            if (m19314ok.f33927bl.get()) {
                return;
            }
            if (C12534ok.m17599ok(m19314ok.mo19285zz()).m17607a("notification_opt_2") == 1) {
                C12644a.m16876ok().m16878kf(m19314ok.mo19285zz());
            }
            new C12004a().m19407ok(m19314ok, new InterfaceC12009h() { // from class: com.ss.android.downloadlib.ok.1
                @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12009h
                /* renamed from: ok */
                public void mo18607ok(boolean z) {
                    String str2 = C12238ok.f34517ok;
                    C12409ok.m17904a(str2, "appBackForeground->" + z);
                    if (z) {
                        if (!(C12011kf.m19402bl(m19314ok) ? C12018ok.m19377ok(str, m19314ok) : false) && C12011kf.m19392s(m19314ok) && m19314ok.m19449sg() == 4) {
                            C12117ok.m19022ok().m19015ok(m19314ok);
                        }
                    } else if (C12018ok.m19377ok(str, m19314ok) || m19314ok.m19449sg() != 4) {
                    } else {
                        C12117ok.m19022ok().m19015ok(m19314ok);
                    }
                }
            }, C12201n.m18737ok(m19314ok).m17593ok("try_applink_delay_after_installed", 0));
            C12176p.m18851ok().m18853kf(m19314ok);
            m18613ok(str, m19314ok);
            C12117ok.m19022ok().m19023a(str);
            DownloadInfo m18612ok = m18612ok(Downloader.getInstance(C12128r.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (m18612ok != null) {
                if (C12534ok.m17599ok(m18612ok.getId()).m17607a("no_hide_notification") != 1) {
                    C12644a.m16876ok().m16875ok(m18612ok.getId());
                }
                C12184h.m18835ok().m18838a(m18612ok, str);
                C12052s.m19243ok(m18612ok);
            } else {
                C12184h.m18835ok().m18838a(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    /* renamed from: a */
    private JSONObject m18631a(@NonNull DownloadInfo downloadInfo, C12340ok c12340ok) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        c12340ok.m18112ok(jSONObject);
        try {
            jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        C12200kf.m18755ok(jSONObject, downloadInfo.getId());
        C12270ok.m18539ok().m18523ok("embeded_ad", "ah_result", jSONObject, m19315ok);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m18615ok(DownloadInfo downloadInfo, C11998a c11998a, int i) {
        long max;
        if (downloadInfo == null || c11998a == null) {
            return;
        }
        m18609s();
        long currentTimeMillis = System.currentTimeMillis();
        c11998a.m19525a(currentTimeMillis);
        c11998a.m19498h(C12197j.m18785ok(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            max = 2000;
        } else {
            long m17592ok = C12534ok.m17599ok(downloadInfo.getId()).m17592ok("check_install_failed_delay_time", 120000L);
            if (m17592ok < 0) {
                return;
            }
            max = Math.max(m17592ok, 30000L);
        }
        long j = max;
        RunnableC12243a runnableC12243a = new RunnableC12243a(c11998a.mo19309a(), downloadInfo.getId(), currentTimeMillis, i);
        C12265s.m18554ok().m18552ok(runnableC12243a, j);
        this.f34520bl = runnableC12243a;
        C12038q.m19278ok().m19277ok(c11998a);
    }

    /* renamed from: ok */
    public void m18623ok(final long j, int i) {
        long m17592ok = C12534ok.m17599ok(i).m17592ok("check_install_finish_hijack_delay_time", 900000L);
        if (m17592ok < 0) {
            return;
        }
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.ok.2
            @Override // java.lang.Runnable
            public void run() {
                C12238ok.m18626ok().m18624ok(j);
            }
        }, Math.max(m17592ok, 300000L));
    }

    /* renamed from: ok */
    public void m18624ok(long j) {
        C12042s.C12044ok m19267ok;
        int i;
        try {
            C11998a m19311s = C12032kf.m19324ok().m19311s(j);
            if (m19311s != null && !C12197j.m18805a(m19311s) && !m19311s.f33927bl.get()) {
                Pair<C12042s.C12044ok, Integer> m19271a = C12042s.m19268ok().m19271a(m19311s);
                if (m19271a != null) {
                    m19267ok = (C12042s.C12044ok) m19271a.first;
                    i = ((Integer) m19271a.second).intValue();
                } else {
                    m19267ok = C12042s.m19268ok().m19267ok(m19311s);
                    i = -1;
                }
                if (m19267ok == null) {
                    return;
                }
                C12042s.m19268ok().m19270a(m19267ok.f34102ok);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", m19267ok.f34103s);
                jSONObject.put("installed_pkg_name", m19267ok.f34102ok);
                if (i != -1) {
                    jSONObject.put("error_code", i);
                    C12200kf.m18755ok(jSONObject, m19311s.mo19285zz());
                    C12270ok.m18539ok().m18540a("install_finish_hijack", jSONObject, m19311s);
                    return;
                }
                C12270ok.m18539ok().m18540a("install_finish_may_hijack", jSONObject, m19311s);
            }
        } catch (Throwable th) {
            C12235bl.m18640ok().mo18637ok(th, "trySendInstallFinishHijack");
        }
    }

    /* renamed from: ok */
    public void m18613ok(String str, C11998a c11998a) {
        if (c11998a != null && C12197j.m18805a(c11998a) && c11998a.f33927bl.compareAndSet(false, true)) {
            C12270ok.m18539ok().m18523ok(c11998a.mo19303k(), "install_finish", m18620ok(c11998a, str, c11998a.m19449sg() != 4 ? 3 : 4), c11998a);
            C12038q.m19278ok().m19277ok(c11998a);
        }
    }

    /* renamed from: ok */
    private static DownloadInfo m18612ok(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (C12197j.m18789ok(C12128r.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: ok */
    public static JSONObject m18610ok(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", C12636r.m16905ok().m16907a().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes();
                Double.isNaN(curBytes);
                double d = curBytes / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime();
                Double.isNaN(realDownloadTime);
                double d2 = realDownloadTime / 1000.0d;
                if (d > Utils.DOUBLE_EPSILON && d2 > Utils.DOUBLE_EPSILON) {
                    double d3 = d / d2;
                    try {
                        jSONObject.put("download_speed", d3);
                    } catch (Exception unused) {
                    }
                    C12409ok.m17904a(f34517ok, "download speed : " + d3 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(C12128r.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", C12052s.m19245ok().m19247a(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!C12713kf.m16602bl(C12128r.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                m18630a(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* renamed from: ok */
    private int m18621ok(C11998a c11998a, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int m18441a = C12293bl.m18441a(C12128r.getContext(), downloadInfo);
        int m18806a = C12197j.m18806a(C12128r.getContext(), str);
        if (m18441a > 0 && m18806a > 0 && m18441a != m18806a) {
            return m18806a > m18441a ? 3011 : 3010;
        } else if (C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("install_finish_check_ttmd5", 1) == 1) {
            String string = C12128r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(c11998a.mo19309a()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = C12202ok.m18729ok(downloadInfo.getTargetFilePath());
            }
            int m18728ok = C12202ok.m18728ok(string, C12202ok.m18732a(str));
            try {
                jSONObject.put("ttmd5_status", m18728ok);
            } catch (Throwable unused) {
            }
            if (m18728ok == 0) {
                return 3000;
            }
            return m18728ok == 1 ? 3002 : 3001;
        } else {
            return 3001;
        }
    }

    @Override // com.p521ss.android.downloadad.api.InterfaceC11997ok
    /* renamed from: ok */
    public void mo18625ok(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f34519a < 120000) {
            return;
        }
        C12265s.m18554ok().m18552ok(new RunnableC12245ok(i), this.f34519a > 0 ? 2000L : 8000L);
        this.f34519a = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: ok */
    public void m18611ok(@NonNull ConcurrentHashMap<Long, C11998a> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (C11998a c11998a : concurrentHashMap.values()) {
            if (c11998a.f33927bl.get()) {
                if (currentTimeMillis - c11998a.m19509e() >= C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(c11998a.mo19309a()));
                }
            } else if (c11998a.m19501fl() == 1) {
                if (m18608s(c11998a) <= 0 && currentTimeMillis - c11998a.m19509e() >= C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(c11998a.mo19309a()));
                }
            } else if (c11998a.m19501fl() == 2) {
                if (!c11998a.m19510dx()) {
                    if (C12197j.m18805a(c11998a)) {
                        if (c11998a.m19449sg() == 4) {
                            i = c11998a.m19449sg();
                        }
                        C12270ok.m18539ok().m18520ok(m18620ok(c11998a, c11998a.mo19300n(), i), c11998a);
                        arrayList.add(Long.valueOf(c11998a.mo19309a()));
                        C12052s.m19244ok(c11998a);
                    } else if (currentTimeMillis - c11998a.m19509e() >= C12534ok.m17599ok(c11998a.mo19285zz()).m17593ok("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(c11998a.mo19309a()));
                    } else if (TextUtils.isEmpty(c11998a.mo19300n())) {
                        arrayList.add(Long.valueOf(c11998a.mo19309a()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(c11998a.mo19309a()));
            }
        }
        C12032kf.m19324ok().m19312ok(arrayList);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.C12284a.InterfaceC12288bl
    /* renamed from: ok */
    public void mo18449ok(DownloadInfo downloadInfo, C12340ok c12340ok) {
        JSONObject m18631a;
        if (downloadInfo == null || c12340ok == null) {
            return;
        }
        JSONArray m17601n = C12534ok.m17599ok(downloadInfo.getId()).m17601n("ah_report_config");
        if (c12340ok.f34802a != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (m17601n == null || (m18631a = m18631a(downloadInfo, c12340ok)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", m18631a);
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12431fl
    /* renamed from: ok */
    public void mo17880ok(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            C12235bl.m18640ok().m18639ok("info is null");
        } else if ((C12534ok.m17596ok(downloadInfo).m17607a("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            C12015n.m19390ok().m19391a(new InterfaceC12024s() { // from class: com.ss.android.downloadlib.ok.4
                @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12024s
                /* renamed from: ok */
                public void mo18606ok(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            C12293bl.m18420ok(C12128r.getContext(), intent);
                            C12197j.m18778ok(jSONObject, "backup", (Object) 1);
                        } else {
                            C12197j.m18778ok(jSONObject, "backup", (Object) 2);
                        }
                    }
                    C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
                    if (m19315ok != null) {
                        C12270ok.m18539ok().m18521ok(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, m19315ok);
                    } else {
                        C12235bl.m18640ok().m18643a("ah nativeModel=null");
                    }
                    if (z) {
                        C12128r.m18965io().mo18932ok(C12128r.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    /* renamed from: ok */
    public void m18622ok(C11998a c11998a) {
        C12265s.m18554ok().m18553ok(new RunnableC12244bl(c11998a));
    }

    /* renamed from: ok */
    private JSONObject m18620ok(C11998a c11998a, String str, int i) {
        C12340ok m18113ok;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            C12200kf.m18755ok(jSONObject, c11998a.mo19285zz());
            C12200kf.m18758ok(c11998a, jSONObject);
            jSONObject.put("is_update_download", c11998a.m19514cs() ? 1 : 2);
            jSONObject.put("install_after_back_app", c11998a.m19454ry() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", c11998a.m19432yt() ? "1" : "2");
            if (downloadInfo != null) {
                m18610ok(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (c11998a.m19505er() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - c11998a.m19505er();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > C12534ok.m17599ok(downloadInfo.getId()).m17592ok("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String m16548ok = C12713kf.m16548ok(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(m16548ok) && (m18113ok = C12340ok.m18113ok(m16548ok)) != null) {
                    m18113ok.m18112ok(jSONObject);
                }
            }
            int m18621ok = m18621ok(c11998a, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", m18621ok);
            if (m18621ok == 3000) {
                jSONObject.put("hijack", 2);
            } else if (m18621ok == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ok */
    public void m18617ok(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        C11998a m19315ok = C12032kf.m19324ok().m19315ok(downloadInfo);
        if (m19315ok == null) {
            C12235bl.m18640ok().m18639ok("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            double d = j;
            Double.isNaN(d);
            jSONObject.putOpt("space_before", Double.valueOf(d / 1048576.0d));
            double d2 = j2 - j;
            Double.isNaN(d2);
            jSONObject.putOpt("space_cleaned", Double.valueOf(d2 / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            double d3 = j3 - j2;
            Double.isNaN(d3);
            jSONObject.putOpt("byte_required_after", Double.valueOf(d3 / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            C12200kf.m18759bl(downloadInfo, jSONObject);
            C12270ok.m18539ok().m18521ok("cleanup", jSONObject, m19315ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
