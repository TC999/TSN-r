package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.z;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.fb;
import com.ss.android.socialbase.downloader.depend.fl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static volatile s f49177a = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f49178h = false;
    private static boolean kf = false;
    private static final String ok = "s";

    /* renamed from: p  reason: collision with root package name */
    private static boolean f49179p;
    private String bl;

    /* renamed from: i  reason: collision with root package name */
    private z f49180i;

    /* renamed from: j  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.bl.bl f49181j;

    /* renamed from: k  reason: collision with root package name */
    private int f49182k;

    /* renamed from: q  reason: collision with root package name */
    private Future f49184q;
    private com.ss.android.socialbase.appdownloader.bl.p rh;

    /* renamed from: s  reason: collision with root package name */
    private String f49186s;

    /* renamed from: t  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.bl.h f49187t;
    private k td;

    /* renamed from: u  reason: collision with root package name */
    private fl f49188u;

    /* renamed from: x  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.bl.kf f49189x;

    /* renamed from: z  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.bl.s f49190z;
    private fb zz;

    /* renamed from: n  reason: collision with root package name */
    private DownloadReceiver f49183n = new DownloadReceiver();

    /* renamed from: r  reason: collision with root package name */
    private boolean f49185r = false;

    private s() {
    }

    private void io() {
        if (Build.VERSION.SDK_INT >= 21) {
            td.ok(new td.a() { // from class: com.ss.android.socialbase.appdownloader.s.2
                @Override // com.ss.android.socialbase.downloader.impls.td.a
                public void ok(DownloadInfo downloadInfo, long j4, boolean z3, int i4) {
                    RetryJobSchedulerService.ok(downloadInfo, j4, z3, i4);
                }
            });
        }
    }

    public static s k() {
        if (f49177a == null) {
            synchronized (s.class) {
                if (f49177a == null) {
                    f49177a = new s();
                }
            }
        }
        return f49177a;
    }

    private void u() {
        this.f49182k = com.ss.android.socialbase.downloader.h.ok.bl().a("app_install_keep_receiver_time_s");
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.f49182k);
        if (this.f49182k <= 0) {
            return;
        }
        Future future = this.f49184q;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f49184q = com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.bl.ok.a(s.ok, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                s.this.j();
                s.this.zz();
            }
        }, this.f49182k, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        synchronized (this.f49183n) {
            if (f49178h) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.f49183n, intentFilter);
                com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.f49183n, intentFilter2);
                f49178h = true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "registerDownloadReceiver mIsRegistered:" + f49178h);
        }
    }

    public com.ss.android.socialbase.appdownloader.bl.p bl() {
        return this.rh;
    }

    public k h() {
        return this.td;
    }

    public fb i() {
        return this.zz;
    }

    public void j() {
        synchronized (this.f49183n) {
            try {
                if (f49178h) {
                    com.ss.android.socialbase.downloader.downloader.bl.l().unregisterReceiver(this.f49183n);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            f49178h = false;
            f49179p = false;
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public boolean kf() {
        return com.ss.android.socialbase.downloader.h.ok.a().optInt("package_flag_config", 1) == 1;
    }

    public com.ss.android.socialbase.appdownloader.bl.kf n() {
        return this.f49189x;
    }

    public File p() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveDir();
    }

    public String q() {
        return this.bl;
    }

    public void r() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "disable app install receiver");
            return;
        }
        synchronized (this.f49183n) {
            if (f49179p) {
                u();
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.f49183n, intentFilter);
            f49179p = true;
            u();
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f49178h);
        }
    }

    public com.ss.android.socialbase.appdownloader.bl.h rh() {
        return this.f49187t;
    }

    public String s() {
        return this.f49186s;
    }

    public com.ss.android.socialbase.downloader.downloader.td t() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener();
    }

    public fl x() {
        return this.f49188u;
    }

    public z z() {
        return this.f49180i;
    }

    private void bl(Context context) {
        if (context == null || kf) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.n.ok("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.bl.ok(context);
        com.ss.android.socialbase.downloader.downloader.bl.ok(new com.ss.android.socialbase.appdownloader.s.a());
        zz();
        io();
        kf = true;
    }

    public com.ss.android.socialbase.appdownloader.bl.s a() {
        return this.f49190z;
    }

    public void a(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).setDefaultSavePath(str);
    }

    public com.ss.android.socialbase.appdownloader.bl.bl ok() {
        return this.f49181j;
    }

    private DownloadInfo a(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f49186s = str;
    }

    public void ok(k kVar) {
        this.td = kVar;
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    @Deprecated
    public void ok(Context context, String str, com.ss.android.socialbase.appdownloader.bl.bl blVar, com.ss.android.socialbase.appdownloader.bl.s sVar, com.ss.android.socialbase.appdownloader.bl.p pVar) {
        if (blVar != null) {
            this.f49181j = blVar;
        }
        if (sVar != null) {
            this.f49190z = sVar;
        }
        if (pVar != null) {
            this.rh = pVar;
        }
        bl(context);
    }

    public static boolean ok(Context context, int i4) {
        return bl.ok(context, i4, true) == 1;
    }

    public void ok(Context context, int i4, int i5) {
        try {
            switch (i5) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i4);
                    break;
                case -3:
                    bl.ok(context, i4, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i4);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i4);
                    break;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:37|(1:39)|40|(2:44|45)|48|(1:116)(1:55)|56|(2:62|(1:64)(19:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|77|78|(1:80)(1:113)|81|82|(6:87|(1:110)(1:91)|92|(1:96)|(1:(1:108)(1:107))|109)|111|(1:89)|110|92|(2:94|96)|(0)|109))|115|66|(0)|69|(0)|76|77|78|(0)(0)|81|82|(8:84|87|(0)|110|92|(0)|(0)|109)|111|(0)|110|92|(0)|(0)|109) */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0142 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:45:0x00cc, B:48:0x00e5, B:50:0x00eb, B:54:0x00fc, B:56:0x0102, B:58:0x0108, B:60:0x010e, B:62:0x0114, B:64:0x0122, B:65:0x013c, B:67:0x0142, B:68:0x0147, B:70:0x0151, B:71:0x0155, B:73:0x015b, B:74:0x0165, B:80:0x0190, B:82:0x0196, B:88:0x01a2, B:90:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:121:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0151 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:45:0x00cc, B:48:0x00e5, B:50:0x00eb, B:54:0x00fc, B:56:0x0102, B:58:0x0108, B:60:0x010e, B:62:0x0114, B:64:0x0122, B:65:0x013c, B:67:0x0142, B:68:0x0147, B:70:0x0151, B:71:0x0155, B:73:0x015b, B:74:0x0165, B:80:0x0190, B:82:0x0196, B:88:0x01a2, B:90:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:121:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016f A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:75:0x0169, B:77:0x016f, B:79:0x017a, B:78:0x0175), top: B:119:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0175 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:75:0x0169, B:77:0x016f, B:79:0x017a, B:78:0x0175), top: B:119:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a2 A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:45:0x00cc, B:48:0x00e5, B:50:0x00eb, B:54:0x00fc, B:56:0x0102, B:58:0x0108, B:60:0x010e, B:62:0x0114, B:64:0x0122, B:65:0x013c, B:67:0x0142, B:68:0x0147, B:70:0x0151, B:71:0x0155, B:73:0x015b, B:74:0x0165, B:80:0x0190, B:82:0x0196, B:88:0x01a2, B:90:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:121:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x033b A[Catch: all -> 0x039b, TryCatch #1 {all -> 0x039b, blocks: (B:8:0x0010, B:11:0x0023, B:15:0x002c, B:17:0x003a, B:18:0x0042, B:20:0x004a, B:21:0x0053, B:24:0x005a, B:26:0x0066, B:29:0x0072, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:37:0x0093, B:40:0x009e, B:42:0x00b2, B:45:0x00cc, B:48:0x00e5, B:50:0x00eb, B:54:0x00fc, B:56:0x0102, B:58:0x0108, B:60:0x010e, B:62:0x0114, B:64:0x0122, B:65:0x013c, B:67:0x0142, B:68:0x0147, B:70:0x0151, B:71:0x0155, B:73:0x015b, B:74:0x0165, B:80:0x0190, B:82:0x0196, B:88:0x01a2, B:90:0x01af, B:92:0x01bf, B:94:0x033b, B:96:0x0345, B:99:0x0350, B:101:0x0356, B:103:0x035c, B:105:0x0366, B:107:0x036c, B:108:0x037c), top: B:121:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ok(com.ss.android.socialbase.appdownloader.kf r23) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.s.ok(com.ss.android.socialbase.appdownloader.kf):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadTask downloadTask, int i4, boolean z3) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i4);
        }
        if (downloadInfo == null || !z3) {
            return;
        }
        downloadInfo.setSavePathRedirected(z3);
    }

    private List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list) {
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                if (blVar != null && !TextUtils.isEmpty(blVar.ok()) && !TextUtils.isEmpty(blVar.a())) {
                    if (blVar.ok().equals("User-Agent")) {
                        z3 = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.bl(blVar.ok(), blVar.a()));
                }
            }
        }
        if (!z3) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl("User-Agent", com.ss.android.socialbase.appdownloader.a.ok.ok));
        }
        return arrayList;
    }

    public String ok(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || bl.bl(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private ep ok(final com.ss.android.socialbase.appdownloader.bl.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new ep() { // from class: com.ss.android.socialbase.appdownloader.s.5
            @Override // com.ss.android.socialbase.downloader.depend.ep
            public void ok(int i4, DownloadInfo downloadInfo, String str, String str2) {
                if (i4 != 1 && i4 != 3) {
                    switch (i4) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            nVar.ok(i4, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            nVar.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), str);
                            return;
                        case 10:
                            nVar.ok(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                nVar.ok(i4, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public boolean ok(boolean z3) {
                return nVar.ok(z3);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public String ok() {
                return nVar.ok();
            }
        };
    }

    public DownloadInfo ok(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo ok2 = ok(context, str, p());
                if (ok2 == null) {
                    ok2 = ok(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (ok2 == null) {
                    ok2 = ok(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (ok2 == null) {
                    ok2 = ok(context, str, context.getFilesDir());
                }
                return (ok2 == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("get_download_info_by_list")) ? a(context, str) : ok2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo ok(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> ok(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void ok(com.ss.android.socialbase.appdownloader.bl.h hVar) {
        this.f49187t = hVar;
    }

    public void ok(com.ss.android.socialbase.downloader.downloader.td tdVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).setReserveWifiStatusListener(tdVar);
    }

    public void ok(fb fbVar) {
        this.zz = fbVar;
    }

    public void ok(fl flVar) {
        this.f49188u = flVar;
    }
}
