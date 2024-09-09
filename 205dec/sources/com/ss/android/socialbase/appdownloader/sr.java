package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.xv.bk;
import com.ss.android.socialbase.downloader.depend.wv;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49198c = "sr";
    private static boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f49199f;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f49200r;

    /* renamed from: w  reason: collision with root package name */
    private static volatile sr f49201w;

    /* renamed from: a  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.xv.xv f49202a;
    private com.ss.android.socialbase.appdownloader.xv.sr bk;
    private bk fp;
    private y fz;
    private Future gd;
    private com.ss.android.socialbase.appdownloader.xv.f ia;

    /* renamed from: p  reason: collision with root package name */
    private int f49204p;

    /* renamed from: s  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.xv.p f49205s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.xv.ev f49206t;

    /* renamed from: u  reason: collision with root package name */
    private wv f49207u;
    private String xv;
    private com.ss.android.socialbase.appdownloader.xv.r ys;
    private DownloadReceiver ux = new DownloadReceiver();

    /* renamed from: k  reason: collision with root package name */
    private boolean f49203k = false;

    private sr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz() {
        synchronized (this.ux) {
            if (f49200r) {
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
                com.ss.android.socialbase.downloader.downloader.xv.gw().registerReceiver(this.ux, intentFilter);
                com.ss.android.socialbase.downloader.downloader.xv.gw().registerReceiver(this.ux, intentFilter2);
                f49200r = true;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String str = f49198c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "registerDownloadReceiver mIsRegistered:" + f49200r);
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            com.ss.android.socialbase.downloader.impls.s.c(new s.w() { // from class: com.ss.android.socialbase.appdownloader.sr.2
                @Override // com.ss.android.socialbase.downloader.impls.s.w
                public void c(DownloadInfo downloadInfo, long j4, boolean z3, int i4) {
                    RetryJobSchedulerService.c(downloadInfo, j4, z3, i4);
                }
            });
        }
    }

    public static sr p() {
        if (f49201w == null) {
            synchronized (sr.class) {
                if (f49201w == null) {
                    f49201w = new sr();
                }
            }
        }
        return f49201w;
    }

    private void u() {
        this.f49204p = com.ss.android.socialbase.downloader.r.c.xv().c("app_install_keep_receiver_time_s", 60);
        String str = f49198c;
        com.ss.android.socialbase.downloader.xv.c.w(str, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.f49204p);
        if (this.f49204p <= 0) {
            return;
        }
        Future future = this.gd;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.gd = com.ss.android.socialbase.downloader.downloader.xv.c(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.sr.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.xv.c.w(sr.f49198c, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                sr.this.a();
                sr.this.fz();
            }
        }, this.f49204p, TimeUnit.SECONDS);
    }

    public void a() {
        synchronized (this.ux) {
            try {
                if (f49200r) {
                    com.ss.android.socialbase.downloader.downloader.xv.gw().unregisterReceiver(this.ux);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            f49200r = false;
            ev = false;
        }
        com.ss.android.socialbase.downloader.xv.c.w(f49198c, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public bk bk() {
        return this.fp;
    }

    public File ev() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getGlobalSaveDir();
    }

    public boolean f() {
        return com.ss.android.socialbase.downloader.r.c.w().optInt("package_flag_config", 1) == 1;
    }

    public y fp() {
        return this.fz;
    }

    public String gd() {
        return this.xv;
    }

    public wv ia() {
        return this.f49207u;
    }

    public void k() {
        if (com.ss.android.socialbase.downloader.r.c.xv().c("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.xv.c.w(f49198c, "disable app install receiver");
            return;
        }
        synchronized (this.ux) {
            if (ev) {
                u();
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            com.ss.android.socialbase.downloader.downloader.xv.gw().registerReceiver(this.ux, intentFilter);
            ev = true;
            u();
            String str = f49198c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f49200r);
        }
    }

    public com.ss.android.socialbase.appdownloader.xv.p r() {
        return this.f49205s;
    }

    public String sr() {
        return this.sr;
    }

    public com.ss.android.socialbase.appdownloader.xv.r t() {
        return this.ys;
    }

    public com.ss.android.socialbase.appdownloader.xv.f ux() {
        return this.ia;
    }

    public com.ss.android.socialbase.appdownloader.xv.ev xv() {
        return this.f49206t;
    }

    public com.ss.android.socialbase.downloader.downloader.s ys() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getReserveWifiStatusListener();
    }

    private void xv(Context context) {
        if (context == null || f49199f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.ux.c("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.xv.c(context);
        com.ss.android.socialbase.downloader.downloader.xv.c(new com.ss.android.socialbase.appdownloader.sr.w());
        fz();
        i();
        f49199f = true;
    }

    public com.ss.android.socialbase.appdownloader.xv.sr w() {
        return this.bk;
    }

    public com.ss.android.socialbase.appdownloader.xv.xv c() {
        return this.f49202a;
    }

    public void w(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).setDefaultSavePath(str);
    }

    private DownloadInfo w(Context context, String str) {
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

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.sr = str;
    }

    public void c(com.ss.android.socialbase.appdownloader.xv.p pVar) {
        this.f49205s = pVar;
    }

    @Deprecated
    public void c(Context context, String str, com.ss.android.socialbase.appdownloader.xv.xv xvVar, com.ss.android.socialbase.appdownloader.xv.sr srVar, com.ss.android.socialbase.appdownloader.xv.ev evVar) {
        if (xvVar != null) {
            this.f49202a = xvVar;
        }
        if (srVar != null) {
            this.bk = srVar;
        }
        if (evVar != null) {
            this.f49206t = evVar;
        }
        xv(context);
    }

    public List<DownloadInfo> w(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public static boolean c(Context context, int i4) {
        return xv.c(context, i4, true) == 1;
    }

    public void c(Context context, int i4, int i5) {
        try {
            switch (i5) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i4);
                    break;
                case -3:
                    xv.c(context, i4, true);
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
    public int c(com.ss.android.socialbase.appdownloader.f r23) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.sr.c(com.ss.android.socialbase.appdownloader.f):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(DownloadTask downloadTask, int i4, boolean z3) {
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

    private List<com.ss.android.socialbase.downloader.model.xv> c(List<com.ss.android.socialbase.downloader.model.xv> list) {
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.xv xvVar : list) {
                if (xvVar != null && !TextUtils.isEmpty(xvVar.c()) && !TextUtils.isEmpty(xvVar.w())) {
                    if (xvVar.c().equals("User-Agent")) {
                        z3 = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.xv(xvVar.c(), xvVar.w()));
                }
            }
        }
        if (!z3) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.xv("User-Agent", com.ss.android.socialbase.appdownloader.w.c.f49249c));
        }
        return arrayList;
    }

    public String c(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || xv.xv(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private com.ss.android.socialbase.downloader.depend.n c(final com.ss.android.socialbase.appdownloader.xv.ux uxVar) {
        if (uxVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.n() { // from class: com.ss.android.socialbase.appdownloader.sr.5
            public void c(int i4, DownloadInfo downloadInfo, String str, String str2) {
                if (i4 != 1 && i4 != 3) {
                    switch (i4) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            uxVar.c(i4, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            uxVar.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), str);
                            return;
                        case 10:
                            uxVar.c(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                uxVar.c(i4, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            public boolean c(boolean z3) {
                return uxVar.c(z3);
            }

            public String c() {
                return uxVar.c();
            }
        };
    }

    public DownloadInfo c(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo c4 = c(context, str, ev());
                if (c4 == null) {
                    c4 = c(context, str, com.bytedance.sdk.openadsdk.api.plugin.w.c(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (c4 == null) {
                    c4 = c(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (c4 == null) {
                    c4 = c(context, str, com.bytedance.sdk.openadsdk.api.plugin.w.c(context));
                }
                return (c4 == null && com.ss.android.socialbase.downloader.r.c.xv().c("get_download_info_by_list")) ? w(context, str) : c4;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.xv.c.w(f49198c, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo c(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> c(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void c(com.ss.android.socialbase.appdownloader.xv.r rVar) {
        this.ys = rVar;
    }

    public void c(com.ss.android.socialbase.downloader.downloader.s sVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).setReserveWifiStatusListener(sVar);
    }

    public void c(y yVar) {
        this.fz = yVar;
    }

    public void c(wv wvVar) {
        this.f49207u = wvVar;
    }
}
