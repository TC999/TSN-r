package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.w.gd;
import com.ss.android.downloadlib.addownload.w.sr;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.wv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements com.ss.android.downloadad.api.c, w.xv, c.InterfaceC0974c, wv {

    /* renamed from: c  reason: collision with root package name */
    private static String f48758c = "c";
    private static volatile c sr;

    /* renamed from: w  reason: collision with root package name */
    private long f48759w;
    private w xv;

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class RunnableC0946c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private final int f48769w;

        public RunnableC0946c(int i4) {
            this.f48769w = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.w.f.c().w();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> xv = com.ss.android.downloadlib.addownload.w.f.c().xv();
                if (xv == null || xv.isEmpty()) {
                    return;
                }
                c.this.c(xv, this.f48769w);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class w implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private long f48786c;
        private int sr;
        private long ux;

        /* renamed from: w  reason: collision with root package name */
        private int f48787w;
        private long xv;

        /* JADX INFO: Access modifiers changed from: private */
        public void w() {
            this.ux = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c()) {
                    c.c().c(this.f48786c, this.f48787w);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private w(long j4, int i4, long j5, int i5) {
            this.f48786c = j4;
            this.f48787w = i4;
            this.xv = j5;
            this.sr = i5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
            if (r9 < r1) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean c() {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.c.w.c():boolean");
        }

        private int c(boolean z3, com.ss.android.downloadad.api.c.w wVar, DownloadInfo downloadInfo, boolean z4, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
            int i4 = 1;
            if (c4.c("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.gd.f.c(checkMd5Status)) {
                    return 2005;
                }
            }
            int i5 = this.sr;
            if (i5 != 2000) {
                return i5;
            }
            if (c4.c("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.r.a.ux(k.getContext(), wVar.ux())) {
                if (!com.ss.android.downloadlib.r.a.c(com.ss.android.downloadlib.r.a.gd(k.getContext(), downloadInfo.getTargetFilePath()), com.ss.android.downloadlib.r.a.ev(k.getContext(), wVar.ux()))) {
                    return 2006;
                }
            }
            if (z3) {
                long j4 = this.ux;
                long j5 = this.xv;
                if (j4 > j5) {
                    try {
                        jSONObject.put("install_time", j4 - j5);
                        if (wVar.ba() <= this.xv) {
                            i4 = 0;
                        }
                        jSONObject.put("install_again", i4);
                    } catch (Throwable unused2) {
                    }
                    return !z4 ? 2003 : 2004;
                }
                return 2000;
            }
            return 2002;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class xv implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private final com.ss.android.downloadad.api.c.w f48789w;

        public xv(com.ss.android.downloadad.api.c.w wVar) {
            this.f48789w = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f48789w.p(true);
                    c.this.xv(this.f48789w);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.f48789w.p(false);
            }
        }
    }

    private c() {
        com.ss.android.socialbase.appdownloader.w.c(this);
        com.ss.android.socialbase.downloader.c.c.c().c(this);
    }

    public static JSONObject w(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long w3 = com.ss.android.downloadlib.r.a.w(0L);
            double d4 = w3;
            Double.isNaN(d4);
            jSONObject.put("available_space", d4 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d5 = totalBytes;
            Double.isNaN(d5);
            jSONObject.put("apk_size", d5 / 1048576.0d);
            if (w3 > 0 && totalBytes > 0) {
                Double.isNaN(d4);
                Double.isNaN(d5);
                jSONObject.put("available_space_ratio", d4 / d5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void xv(com.ss.android.downloadad.api.c.w wVar) {
        SystemClock.sleep(20000L);
        int i4 = 15;
        while (i4 > 0) {
            if (com.ss.android.downloadlib.r.a.w(wVar)) {
                c(wVar.ux());
                return;
            }
            i4--;
            if (i4 == 0) {
                return;
            }
            SystemClock.sleep(20000L);
        }
    }

    synchronized void sr() {
        w wVar = this.xv;
        if (wVar != null) {
            wVar.w();
            this.xv = null;
        }
    }

    public static c c() {
        if (sr == null) {
            synchronized (c.class) {
                if (sr == null) {
                    sr = new c();
                }
            }
        }
        return sr;
    }

    private int sr(com.ss.android.downloadad.api.c.w wVar) {
        int realStatus;
        double c4 = com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("download_failed_finally_hours", 48.0d);
        if (c4 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - wVar.xk() < c4 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (wVar.sr.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(wVar.fz());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && wVar.sr.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                c(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(wVar.eq()));
                jSONObject.putOpt("fail_msg", wVar.me());
                jSONObject.put("download_failed_times", wVar.ls());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                jSONObject.put("is_update_download", wVar.bm() ? 1 : 2);
                com.ss.android.downloadlib.sr.c.c().c(wVar.p(), "download_failed_finally", jSONObject, wVar);
                gd.c().c(wVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    public static String xv(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.c.w wVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = k.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.xv.c());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            com.ss.android.downloadlib.sr.c.c().c("embeded_ad", "package_name_error", jSONObject, wVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @WorkerThread
    public static synchronized void c(DownloadInfo downloadInfo, com.ss.android.downloadad.api.c.w wVar) {
        synchronized (c.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.ux.xv.c().c("onDownloadFinish info null");
            } else if (wVar == null) {
                com.ss.android.downloadlib.ux.xv.c().c("onDownloadFinish nativeModel null");
            } else if (wVar.wv() != 1) {
            } else {
                com.ss.android.downloadlib.xv.ev.c().sr(wVar);
                String xv2 = xv(downloadInfo, wVar);
                com.ss.android.downloadlib.addownload.w.f.c().w(downloadInfo.getUrl(), xv2);
                Map<Long, com.ss.android.downloadad.api.c.w> c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo.getUrl(), xv2);
                wVar.f(System.currentTimeMillis());
                wVar.ux(2);
                wVar.w(xv2);
                c4.put(Long.valueOf(wVar.w()), wVar);
                gd.c().c(c4.values());
                w(wVar);
                r.c().c(downloadInfo, xv2);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    c().c(wVar);
                    c().w(downloadInfo, wVar);
                    if (wVar.bw()) {
                        com.ss.android.downloadlib.addownload.c.c.c().c(downloadInfo.getId(), wVar.w(), wVar.a(), xv2, downloadInfo.getTitle(), wVar.sr(), downloadInfo.getTargetFilePath());
                    }
                    com.ss.android.downloadlib.addownload.ux.c.c(downloadInfo, wVar.w(), wVar.sr(), xv2);
                }
            }
        }
    }

    public void w(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.c.w wVar) {
        if (downloadInfo == null || wVar == null || com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        sr.c().w(new Runnable() { // from class: com.ss.android.downloadlib.c.3
            @Override // java.lang.Runnable
            public void run() {
                String c4 = com.ss.android.downloadlib.r.c.c(targetFilePath);
                if (TextUtils.isEmpty(c4)) {
                    return;
                }
                k.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(wVar.w()), c4).apply();
            }
        });
    }

    private static void w(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return;
        }
        String vc = TextUtils.isEmpty(wVar.vc()) ? "" : wVar.vc();
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(wVar.fz());
        wVar.a("");
        gd.c().c(wVar);
        JSONObject c4 = c(new JSONObject(), downloadInfo);
        int i4 = 1;
        try {
            c4.putOpt("finish_reason", vc);
            c4.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadad.api.c.w c5 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        com.ss.android.downloadlib.r.f.c(c4, downloadInfo.getId());
        try {
            c4.put("download_failed_times", c5.ls());
            c4.put("can_show_notification", com.ss.android.socialbase.appdownloader.ux.sr.c() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                c4.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            c4.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            c4.put("has_send_download_failed_finally", c5.sr.get() ? 1 : 2);
            if (!c5.bm()) {
                i4 = 2;
            }
            c4.put("is_update_download", i4);
            com.ss.android.downloadlib.r.f.c(c5, c4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().w("download_finish", c4, wVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
    public void xv() {
        com.ss.android.socialbase.downloader.xv.c.w(f48758c, "onAppBackground()");
        c(6);
    }

    @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
    public void w() {
        com.ss.android.socialbase.downloader.xv.c.w(f48758c, "onAppForeground()");
        sr();
        c(5);
    }

    @WorkerThread
    public synchronized void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!com.ss.android.downloadlib.r.a.w()) {
            final com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(str);
            if (c4 == null) {
                com.ss.android.downloadlib.addownload.w.sr.c().c(str);
                return;
            }
            com.ss.android.downloadlib.addownload.ux c5 = r.c().c(c4.c());
            if (c5 != null) {
                c5.f();
            }
            if (c4.xv.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.r.c.c(c4.fz()).w("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.w.c().f(c4.fz());
            }
            new com.ss.android.downloadlib.w.w().c(c4, new com.ss.android.downloadlib.w.r() { // from class: com.ss.android.downloadlib.c.1
                @Override // com.ss.android.downloadlib.w.r
                public void c(boolean z3) {
                    String str2 = c.f48758c;
                    com.ss.android.socialbase.downloader.xv.c.w(str2, "appBackForeground->" + z3);
                    if (z3) {
                        if (!(com.ss.android.downloadlib.w.f.xv(c4) ? com.ss.android.downloadlib.w.c.c(str, c4) : false) && com.ss.android.downloadlib.w.f.sr(c4) && c4.pr() == 4) {
                            com.ss.android.downloadlib.addownload.c.c.c().c(c4);
                        }
                    } else if (com.ss.android.downloadlib.w.c.c(str, c4) || c4.pr() != 4) {
                    } else {
                        com.ss.android.downloadlib.addownload.c.c.c().c(c4);
                    }
                }
            }, com.ss.android.downloadlib.r.ux.c(c4).c("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.xv.ev.c().f(c4);
            c(str, c4);
            com.ss.android.downloadlib.addownload.c.c.c().w(str);
            DownloadInfo c6 = c(Downloader.getInstance(k.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (c6 != null) {
                if (com.ss.android.socialbase.downloader.r.c.c(c6.getId()).w("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.w.c().c(c6.getId());
                }
                r.c().w(c6, str);
                com.ss.android.downloadlib.addownload.xv.sr.c(c6);
            } else {
                r.c().w(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject w(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c cVar) {
        com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        if (c4 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        cVar.c(jSONObject);
        try {
            jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.r.f.c(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.sr.c.c().c("embeded_ad", "ah_result", jSONObject, c4);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(DownloadInfo downloadInfo, com.ss.android.downloadad.api.c.w wVar, int i4) {
        long max;
        if (downloadInfo == null || wVar == null) {
            return;
        }
        sr();
        long currentTimeMillis = System.currentTimeMillis();
        wVar.w(currentTimeMillis);
        wVar.r(com.ss.android.downloadlib.r.a.c(Environment.getDataDirectory(), -1L));
        if (i4 != 2000) {
            max = 2000;
        } else {
            long c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("check_install_failed_delay_time", PolicyConfig.THREAD_BLOCK_TIMEOUT);
            if (c4 < 0) {
                return;
            }
            max = Math.max(c4, (long) PolicyConfig.mServerBusyRetryBaseInternal);
        }
        long j4 = max;
        w wVar2 = new w(wVar.w(), downloadInfo.getId(), currentTimeMillis, i4);
        sr.c().c(wVar2, j4);
        this.xv = wVar2;
        gd.c().c(wVar);
    }

    public void c(final long j4, int i4) {
        long c4 = com.ss.android.socialbase.downloader.r.c.c(i4).c("check_install_finish_hijack_delay_time", 900000L);
        if (c4 < 0) {
            return;
        }
        sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.c().c(j4);
            }
        }, Math.max(c4, 300000L));
    }

    public void c(long j4) {
        sr.c c4;
        int i4;
        try {
            com.ss.android.downloadad.api.c.w sr2 = com.ss.android.downloadlib.addownload.w.f.c().sr(j4);
            if (sr2 != null && !com.ss.android.downloadlib.r.a.w(sr2) && !sr2.xv.get()) {
                Pair<sr.c, Integer> w3 = com.ss.android.downloadlib.addownload.w.sr.c().w(sr2);
                if (w3 != null) {
                    c4 = (sr.c) w3.first;
                    i4 = ((Integer) w3.second).intValue();
                } else {
                    c4 = com.ss.android.downloadlib.addownload.w.sr.c().c(sr2);
                    i4 = -1;
                }
                if (c4 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.w.sr.c().w(c4.f48720c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", c4.sr);
                jSONObject.put("installed_pkg_name", c4.f48720c);
                if (i4 != -1) {
                    jSONObject.put("error_code", i4);
                    com.ss.android.downloadlib.r.f.c(jSONObject, sr2.fz());
                    com.ss.android.downloadlib.sr.c.c().w("install_finish_hijack", jSONObject, sr2);
                    return;
                }
                com.ss.android.downloadlib.sr.c.c().w("install_finish_may_hijack", jSONObject, sr2);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.ux.xv.c().c(th, "trySendInstallFinishHijack");
        }
    }

    public void c(String str, com.ss.android.downloadad.api.c.w wVar) {
        if (wVar != null && com.ss.android.downloadlib.r.a.w(wVar) && wVar.xv.compareAndSet(false, true)) {
            com.ss.android.downloadlib.sr.c.c().c(wVar.p(), "install_finish", c(wVar, str, wVar.pr() != 4 ? 3 : 4), wVar);
            gd.c().c(wVar);
        }
    }

    private static DownloadInfo c(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (com.ss.android.downloadlib.r.a.c(k.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
    public static JSONObject c(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i4 = 1;
            if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.k.c().w().name());
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
                double d4 = curBytes / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime();
                Double.isNaN(realDownloadTime);
                double d5 = realDownloadTime / 1000.0d;
                if (d4 > 0.0d && d5 > 0.0d) {
                    double d6 = d4 / d5;
                    try {
                        jSONObject.put("download_speed", d6);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.xv.c.w(f48758c, "download speed : " + d6 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(k.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.xv.sr.c().w(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.gd.f.xv(k.getContext())) {
                    i4 = 2;
                }
                jSONObject.put("network_available", i4);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                w(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int c(com.ss.android.downloadad.api.c.w wVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int w3 = com.ss.android.socialbase.appdownloader.xv.w(k.getContext(), downloadInfo);
        int w4 = com.ss.android.downloadlib.r.a.w(k.getContext(), str);
        if (w3 > 0 && w4 > 0 && w3 != w4) {
            return w4 > w3 ? 3011 : 3010;
        } else if (com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("install_finish_check_ttmd5", 1) == 1) {
            String string = k.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(wVar.w()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = com.ss.android.downloadlib.r.c.c(downloadInfo.getTargetFilePath());
            }
            int c4 = com.ss.android.downloadlib.r.c.c(string, com.ss.android.downloadlib.r.c.w(str));
            try {
                jSONObject.put("ttmd5_status", c4);
            } catch (Throwable unused) {
            }
            if (c4 == 0) {
                return 3000;
            }
            return c4 == 1 ? 3002 : 3001;
        } else {
            return 3001;
        }
    }

    @Override // com.ss.android.downloadad.api.c
    public void c(int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48759w < PolicyConfig.THREAD_BLOCK_TIMEOUT) {
            return;
        }
        sr.c().c(new RunnableC0946c(i4), this.f48759w > 0 ? 2000L : 8000L);
        this.f48759w = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> concurrentHashMap, int i4) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.c.w wVar : concurrentHashMap.values()) {
            if (wVar.xv.get()) {
                if (currentTimeMillis - wVar.xk() >= com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(wVar.w()));
                }
            } else if (wVar.wv() == 1) {
                if (sr(wVar) <= 0 && currentTimeMillis - wVar.xk() >= com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(wVar.w()));
                }
            } else if (wVar.wv() == 2) {
                if (!wVar.ox()) {
                    if (com.ss.android.downloadlib.r.a.w(wVar)) {
                        if (wVar.pr() == 4) {
                            i4 = wVar.pr();
                        }
                        com.ss.android.downloadlib.sr.c.c().c(c(wVar, wVar.ux(), i4), wVar);
                        arrayList.add(Long.valueOf(wVar.w()));
                        com.ss.android.downloadlib.addownload.xv.sr.c(wVar);
                    } else if (currentTimeMillis - wVar.xk() >= com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(wVar.w()));
                    } else if (TextUtils.isEmpty(wVar.ux())) {
                        arrayList.add(Long.valueOf(wVar.w()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(wVar.w()));
            }
        }
        com.ss.android.downloadlib.addownload.w.f.c().c(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.w.xv
    public void c(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c cVar) {
        JSONObject w3;
        if (downloadInfo == null || cVar == null) {
            return;
        }
        JSONArray ux = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).ux("ah_report_config");
        if (cVar.f49036w != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (ux == null || (w3 = w(downloadInfo, cVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", w3);
    }

    @Override // com.ss.android.socialbase.downloader.depend.wv
    public void c(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.ux.xv.c().c("info is null");
        } else if ((com.ss.android.socialbase.downloader.r.c.c(downloadInfo).w("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.w.ux.c().w(new com.ss.android.downloadlib.w.sr() { // from class: com.ss.android.downloadlib.c.4
                @Override // com.ss.android.downloadlib.w.sr
                public void c(boolean z3) {
                    if (!z3) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.xv.c(k.getContext(), intent);
                            com.ss.android.downloadlib.r.a.c(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            com.ss.android.downloadlib.r.a.c(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
                    if (c4 != null) {
                        com.ss.android.downloadlib.sr.c.c().c(z3 ? "installer_delay_success" : "installer_delay_failed", jSONObject, c4);
                    } else {
                        com.ss.android.downloadlib.ux.xv.c().w("ah nativeModel=null");
                    }
                    if (z3) {
                        k.i().c(k.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public void c(com.ss.android.downloadad.api.c.w wVar) {
        sr.c().c(new xv(wVar));
    }

    private JSONObject c(com.ss.android.downloadad.api.c.w wVar, String str, int i4) {
        com.ss.android.socialbase.appdownloader.c c4;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(wVar.fz());
            jSONObject.putOpt("scene", Integer.valueOf(i4));
            com.ss.android.downloadlib.r.f.c(jSONObject, wVar.fz());
            com.ss.android.downloadlib.r.f.c(wVar, jSONObject);
            jSONObject.put("is_update_download", wVar.bm() ? 1 : 2);
            jSONObject.put("install_after_back_app", wVar.ok() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", wVar.mt() ? "1" : "2");
            if (downloadInfo != null) {
                c(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (wVar.ba() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - wVar.ba();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String c5 = com.ss.android.socialbase.downloader.gd.f.c(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(c5) && (c4 = com.ss.android.socialbase.appdownloader.c.c(c5)) != null) {
                    c4.c(jSONObject);
                }
            }
            int c6 = c(wVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", c6);
            if (c6 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (c6 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void c(DownloadInfo downloadInfo, long j4, long j5, long j6, long j7, long j8, boolean z3) {
        com.ss.android.downloadad.api.c.w c4 = com.ss.android.downloadlib.addownload.w.f.c().c(downloadInfo);
        if (c4 == null) {
            com.ss.android.downloadlib.ux.xv.c().c("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            double d4 = j4;
            Double.isNaN(d4);
            jSONObject.putOpt("space_before", Double.valueOf(d4 / 1048576.0d));
            double d5 = j5 - j4;
            Double.isNaN(d5);
            jSONObject.putOpt("space_cleaned", Double.valueOf(d5 / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j7));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z3 ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j6));
            double d6 = j6 - j5;
            Double.isNaN(d6);
            jSONObject.putOpt("byte_required_after", Double.valueOf(d6 / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j8));
            com.ss.android.downloadlib.r.f.xv(downloadInfo, jSONObject);
            com.ss.android.downloadlib.sr.c.c().c("cleanup", jSONObject, c4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
