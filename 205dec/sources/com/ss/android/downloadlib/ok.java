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
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.a.s;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.fl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements com.ss.android.downloadad.api.ok, a.bl, fl, ok.InterfaceC1022ok {
    private static String ok = "ok";

    /* renamed from: s  reason: collision with root package name */
    private static volatile ok f48856s;

    /* renamed from: a  reason: collision with root package name */
    private long f48857a;
    private a bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f48862a;
        private long bl;

        /* renamed from: n  reason: collision with root package name */
        private long f48863n;
        private long ok;

        /* renamed from: s  reason: collision with root package name */
        private int f48864s;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f48863n = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ok()) {
                    ok.ok().ok(this.ok, this.f48862a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(long j4, int i4, long j5, int i5) {
            this.ok = j4;
            this.f48862a = i4;
            this.bl = j5;
            this.f48864s = i5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
            if (r9 < r1) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean ok() {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.ok.a.ok():boolean");
        }

        private int ok(boolean z3, com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, boolean z4, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
            int i4 = 1;
            if (ok.ok("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.q.kf.ok(checkMd5Status)) {
                    return 2005;
                }
            }
            int i5 = this.f48864s;
            if (i5 != 2000) {
                return i5;
            }
            if (ok.ok("install_failed_check_signature", 1) == 1 && j.n(com.ss.android.downloadlib.addownload.r.getContext(), aVar.n())) {
                if (!j.ok(j.q(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo.getTargetFilePath()), j.p(com.ss.android.downloadlib.addownload.r.getContext(), aVar.n()))) {
                    return 2006;
                }
            }
            if (z3) {
                long j4 = this.f48863n;
                long j5 = this.bl;
                if (j4 > j5) {
                    try {
                        jSONObject.put("install_time", j4 - j5);
                        if (aVar.er() <= this.bl) {
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
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class bl implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.ss.android.downloadad.api.ok.a f48865a;

        public bl(com.ss.android.downloadad.api.ok.a aVar) {
            this.f48865a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f48865a.k(true);
                    ok.this.bl(this.f48865a);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } finally {
                this.f48865a.k(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class RunnableC0952ok implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f48866a;

        public RunnableC0952ok(int i4) {
            this.f48866a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.a.kf.ok().a();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> bl = com.ss.android.downloadlib.addownload.a.kf.ok().bl();
                if (bl == null || bl.isEmpty()) {
                    return;
                }
                ok.this.ok(bl, this.f48866a);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private ok() {
        com.ss.android.socialbase.appdownloader.a.ok(this);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(this);
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long a4 = j.a(0L);
            double d4 = a4;
            Double.isNaN(d4);
            jSONObject.put("available_space", d4 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d5 = totalBytes;
            Double.isNaN(d5);
            jSONObject.put("apk_size", d5 / 1048576.0d);
            if (a4 > 0 && totalBytes > 0) {
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
    public void bl(com.ss.android.downloadad.api.ok.a aVar) {
        SystemClock.sleep(20000L);
        int i4 = 15;
        while (i4 > 0) {
            if (j.a(aVar)) {
                ok(aVar.n());
                return;
            }
            i4--;
            if (i4 == 0) {
                return;
            }
            SystemClock.sleep(20000L);
        }
    }

    synchronized void s() {
        a aVar = this.bl;
        if (aVar != null) {
            aVar.a();
            this.bl = null;
        }
    }

    public static ok ok() {
        if (f48856s == null) {
            synchronized (ok.class) {
                if (f48856s == null) {
                    f48856s = new ok();
                }
            }
        }
        return f48856s;
    }

    public static String bl(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = com.ss.android.downloadlib.addownload.r.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.bl.ok());
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
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "package_name_error", jSONObject, aVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    private int s(com.ss.android.downloadad.api.ok.a aVar) {
        int realStatus;
        double ok2 = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("download_failed_finally_hours", 48.0d);
        if (ok2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - aVar.e() < ok2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (aVar.f48318s.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && aVar.f48318s.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                ok(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.g()));
                jSONObject.putOpt("fail_msg", aVar.v());
                jSONObject.put("download_failed_times", aVar.y());
                if (downloadInfo.getTotalBytes() > 0) {
                    double curBytes = downloadInfo.getCurBytes();
                    double totalBytes = downloadInfo.getTotalBytes();
                    Double.isNaN(curBytes);
                    Double.isNaN(totalBytes);
                    jSONObject.put("download_percent", curBytes / totalBytes);
                }
                jSONObject.put("is_update_download", aVar.cs() ? 1 : 2);
                com.ss.android.downloadlib.s.ok.ok().ok(aVar.k(), "download_failed_finally", jSONObject, aVar);
                q.ok().ok(aVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public static synchronized void ok(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ok.a aVar) {
        synchronized (ok.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.n.bl.ok().ok("onDownloadFinish info null");
            } else if (aVar == null) {
                com.ss.android.downloadlib.n.bl.ok().ok("onDownloadFinish nativeModel null");
            } else if (aVar.fl() != 1) {
            } else {
                com.ss.android.downloadlib.bl.p.ok().s(aVar);
                String bl2 = bl(downloadInfo, aVar);
                com.ss.android.downloadlib.addownload.a.kf.ok().a(downloadInfo.getUrl(), bl2);
                Map<Long, com.ss.android.downloadad.api.ok.a> ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo.getUrl(), bl2);
                aVar.kf(System.currentTimeMillis());
                aVar.n(2);
                aVar.a(bl2);
                ok2.put(Long.valueOf(aVar.a()), aVar);
                q.ok().ok(ok2.values());
                a(aVar);
                h.ok().ok(downloadInfo, bl2);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    ok().ok(aVar);
                    ok().a(downloadInfo, aVar);
                    if (aVar.qu()) {
                        com.ss.android.downloadlib.addownload.ok.ok.ok().ok(downloadInfo.getId(), aVar.a(), aVar.j(), bl2, downloadInfo.getTitle(), aVar.s(), downloadInfo.getTargetFilePath());
                    }
                    com.ss.android.downloadlib.addownload.n.ok.ok(downloadInfo, aVar.a(), aVar.s(), bl2);
                }
            }
        }
    }

    public void a(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ok.a aVar) {
        if (downloadInfo == null || aVar == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        s.ok().a(new Runnable() { // from class: com.ss.android.downloadlib.ok.3
            @Override // java.lang.Runnable
            public void run() {
                String ok2 = com.ss.android.downloadlib.h.ok.ok(targetFilePath);
                if (TextUtils.isEmpty(ok2)) {
                    return;
                }
                com.ss.android.downloadlib.addownload.r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(aVar.a()), ok2).apply();
            }
        });
    }

    private static void a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        String wv = TextUtils.isEmpty(aVar.wv()) ? "" : aVar.wv();
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz());
        aVar.j("");
        q.ok().ok(aVar);
        JSONObject ok2 = ok(new JSONObject(), downloadInfo);
        int i4 = 1;
        try {
            ok2.putOpt("finish_reason", wv);
            ok2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadad.api.ok.a ok3 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        com.ss.android.downloadlib.h.kf.ok(ok2, downloadInfo.getId());
        try {
            ok2.put("download_failed_times", ok3.y());
            ok2.put("can_show_notification", com.ss.android.socialbase.appdownloader.n.s.ok() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                ok2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            ok2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            ok2.put("has_send_download_failed_finally", ok3.f48318s.get() ? 1 : 2);
            if (!ok3.cs()) {
                i4 = 2;
            }
            ok2.put("is_update_download", i4);
            com.ss.android.downloadlib.h.kf.ok(ok3, ok2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("download_finish", ok2, aVar);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void bl() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAppBackground()");
        ok(6);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void a() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAppForeground()");
        s();
        ok(5);
    }

    @WorkerThread
    public synchronized void ok(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!j.a()) {
            final com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(str);
            if (ok2 == null) {
                com.ss.android.downloadlib.addownload.a.s.ok().ok(str);
                return;
            }
            com.ss.android.downloadlib.addownload.n ok3 = h.ok().ok(ok2.ok());
            if (ok3 != null) {
                ok3.kf();
            }
            if (ok2.bl.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.h.ok.ok(ok2.zz()).a("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(ok2.zz());
            }
            new com.ss.android.downloadlib.a.a().ok(ok2, new com.ss.android.downloadlib.a.h() { // from class: com.ss.android.downloadlib.ok.1
                @Override // com.ss.android.downloadlib.a.h
                public void ok(boolean z3) {
                    String str2 = ok.ok;
                    com.ss.android.socialbase.downloader.bl.ok.a(str2, "appBackForeground->" + z3);
                    if (z3) {
                        if (!(com.ss.android.downloadlib.a.kf.bl(ok2) ? com.ss.android.downloadlib.a.ok.ok(str, ok2) : false) && com.ss.android.downloadlib.a.kf.s(ok2) && ok2.sg() == 4) {
                            com.ss.android.downloadlib.addownload.ok.ok.ok().ok(ok2);
                        }
                    } else if (com.ss.android.downloadlib.a.ok.ok(str, ok2) || ok2.sg() != 4) {
                    } else {
                        com.ss.android.downloadlib.addownload.ok.ok.ok().ok(ok2);
                    }
                }
            }, com.ss.android.downloadlib.h.n.ok(ok2).ok("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.bl.p.ok().kf(ok2);
            ok(str, ok2);
            com.ss.android.downloadlib.addownload.ok.ok.ok().a(str);
            DownloadInfo ok4 = ok(Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (ok4 != null) {
                if (com.ss.android.socialbase.downloader.h.ok.ok(ok4.getId()).a("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(ok4.getId());
                }
                h.ok().a(ok4, str);
                com.ss.android.downloadlib.addownload.bl.s.ok(ok4);
            } else {
                h.ok().a(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar) {
        com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (ok2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        okVar.ok(jSONObject);
        try {
            jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.h.kf.ok(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, ok2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ok.a aVar, int i4) {
        long max;
        if (downloadInfo == null || aVar == null) {
            return;
        }
        s();
        long currentTimeMillis = System.currentTimeMillis();
        aVar.a(currentTimeMillis);
        aVar.h(j.ok(Environment.getDataDirectory(), -1L));
        if (i4 != 2000) {
            max = 2000;
        } else {
            long ok2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("check_install_failed_delay_time", PolicyConfig.THREAD_BLOCK_TIMEOUT);
            if (ok2 < 0) {
                return;
            }
            max = Math.max(ok2, (long) PolicyConfig.mServerBusyRetryBaseInternal);
        }
        long j4 = max;
        a aVar2 = new a(aVar.a(), downloadInfo.getId(), currentTimeMillis, i4);
        s.ok().ok(aVar2, j4);
        this.bl = aVar2;
        q.ok().ok(aVar);
    }

    public void ok(final long j4, int i4) {
        long ok2 = com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("check_install_finish_hijack_delay_time", 900000L);
        if (ok2 < 0) {
            return;
        }
        s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.ok.2
            @Override // java.lang.Runnable
            public void run() {
                ok.ok().ok(j4);
            }
        }, Math.max(ok2, 300000L));
    }

    public void ok(long j4) {
        s.ok ok2;
        int i4;
        try {
            com.ss.android.downloadad.api.ok.a s3 = com.ss.android.downloadlib.addownload.a.kf.ok().s(j4);
            if (s3 != null && !j.a(s3) && !s3.bl.get()) {
                Pair<s.ok, Integer> a4 = com.ss.android.downloadlib.addownload.a.s.ok().a(s3);
                if (a4 != null) {
                    ok2 = (s.ok) a4.first;
                    i4 = ((Integer) a4.second).intValue();
                } else {
                    ok2 = com.ss.android.downloadlib.addownload.a.s.ok().ok(s3);
                    i4 = -1;
                }
                if (ok2 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.a.s.ok().a(ok2.ok);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", ok2.f48385s);
                jSONObject.put("installed_pkg_name", ok2.ok);
                if (i4 != -1) {
                    jSONObject.put("error_code", i4);
                    com.ss.android.downloadlib.h.kf.ok(jSONObject, s3.zz());
                    com.ss.android.downloadlib.s.ok.ok().a("install_finish_hijack", jSONObject, s3);
                    return;
                }
                com.ss.android.downloadlib.s.ok.ok().a("install_finish_may_hijack", jSONObject, s3);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.n.bl.ok().ok(th, "trySendInstallFinishHijack");
        }
    }

    public void ok(String str, com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar != null && j.a(aVar) && aVar.bl.compareAndSet(false, true)) {
            com.ss.android.downloadlib.s.ok.ok().ok(aVar.k(), "install_finish", ok(aVar, str, aVar.sg() != 4 ? 3 : 4), aVar);
            q.ok().ok(aVar);
        }
    }

    private static DownloadInfo ok(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (j.ok(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject ok(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i4 = 1;
            if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(DownloadModel.DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadModel.TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.r.ok().a().name());
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
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, "download speed : " + d6 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.bl.s.ok().a(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.q.kf.bl(com.ss.android.downloadlib.addownload.r.getContext())) {
                    i4 = 2;
                }
                jSONObject.put("network_available", i4);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                a(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int ok(com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int a4 = com.ss.android.socialbase.appdownloader.bl.a(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo);
        int a5 = j.a(com.ss.android.downloadlib.addownload.r.getContext(), str);
        if (a4 > 0 && a5 > 0 && a4 != a5) {
            return a5 > a4 ? 3011 : 3010;
        } else if (com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("install_finish_check_ttmd5", 1) == 1) {
            String string = com.ss.android.downloadlib.addownload.r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(aVar.a()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = com.ss.android.downloadlib.h.ok.ok(downloadInfo.getTargetFilePath());
            }
            int ok2 = com.ss.android.downloadlib.h.ok.ok(string, com.ss.android.downloadlib.h.ok.a(str));
            try {
                jSONObject.put("ttmd5_status", ok2);
            } catch (Throwable unused) {
            }
            if (ok2 == 0) {
                return 3000;
            }
            return ok2 == 1 ? 3002 : 3001;
        } else {
            return 3001;
        }
    }

    @Override // com.ss.android.downloadad.api.ok
    public void ok(int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48857a < PolicyConfig.THREAD_BLOCK_TIMEOUT) {
            return;
        }
        s.ok().ok(new RunnableC0952ok(i4), this.f48857a > 0 ? 2000L : 8000L);
        this.f48857a = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void ok(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> concurrentHashMap, int i4) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.ok.a aVar : concurrentHashMap.values()) {
            if (aVar.bl.get()) {
                if (currentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            } else if (aVar.fl() == 1) {
                if (s(aVar) <= 0 && currentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            } else if (aVar.fl() == 2) {
                if (!aVar.dx()) {
                    if (j.a(aVar)) {
                        if (aVar.sg() == 4) {
                            i4 = aVar.sg();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok(ok(aVar, aVar.n(), i4), aVar);
                        arrayList.add(Long.valueOf(aVar.a()));
                        com.ss.android.downloadlib.addownload.bl.s.ok(aVar);
                    } else if (currentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(aVar.a()));
                    } else if (TextUtils.isEmpty(aVar.n())) {
                        arrayList.add(Long.valueOf(aVar.a()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(aVar.a()));
            }
        }
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.bl
    public void ok(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar) {
        JSONObject a4;
        if (downloadInfo == null || okVar == null) {
            return;
        }
        JSONArray n4 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).n("ah_report_config");
        if (okVar.f49159a != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (n4 == null || (a4 = a(downloadInfo, okVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", a4);
    }

    @Override // com.ss.android.socialbase.downloader.depend.fl
    public void ok(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("info is null");
        } else if ((com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo).a("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.a.n.ok().a(new com.ss.android.downloadlib.a.s() { // from class: com.ss.android.downloadlib.ok.4
                @Override // com.ss.android.downloadlib.a.s
                public void ok(boolean z3) {
                    if (!z3) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.bl.ok(com.ss.android.downloadlib.addownload.r.getContext(), intent);
                            j.ok(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            j.ok(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                    if (ok2 != null) {
                        com.ss.android.downloadlib.s.ok.ok().ok(z3 ? "installer_delay_success" : "installer_delay_failed", jSONObject, ok2);
                    } else {
                        com.ss.android.downloadlib.n.bl.ok().a("ah nativeModel=null");
                    }
                    if (z3) {
                        com.ss.android.downloadlib.addownload.r.io().ok(com.ss.android.downloadlib.addownload.r.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        s.ok().ok(new bl(aVar));
    }

    private JSONObject ok(com.ss.android.downloadad.api.ok.a aVar, String str, int i4) {
        com.ss.android.socialbase.appdownloader.ok ok2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz());
            jSONObject.putOpt("scene", Integer.valueOf(i4));
            com.ss.android.downloadlib.h.kf.ok(jSONObject, aVar.zz());
            com.ss.android.downloadlib.h.kf.ok(aVar, jSONObject);
            jSONObject.put("is_update_download", aVar.cs() ? 1 : 2);
            jSONObject.put("install_after_back_app", aVar.ry() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", aVar.yt() ? "1" : "2");
            if (downloadInfo != null) {
                ok(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (aVar.er() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - aVar.er();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String ok3 = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(ok3) && (ok2 = com.ss.android.socialbase.appdownloader.ok.ok(ok3)) != null) {
                    ok2.ok(jSONObject);
                }
            }
            int ok4 = ok(aVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", ok4);
            if (ok4 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (ok4 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void ok(DownloadInfo downloadInfo, long j4, long j5, long j6, long j7, long j8, boolean z3) {
        com.ss.android.downloadad.api.ok.a ok2 = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (ok2 == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("trySendClearSpaceEvent nativeModel null");
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
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            com.ss.android.downloadlib.s.ok.ok().ok("cleanup", jSONObject, ok2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
