package com.p521ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.p541a.C12292ok;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12298h;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12300k;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12301kf;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12302n;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12304p;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12309z;
import com.p521ss.android.socialbase.appdownloader.p547s.C12367a;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12429fb;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12431fl;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12518td;
import com.p521ss.android.socialbase.downloader.impls.C12565td;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.ss.android.socialbase.appdownloader.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12361s {

    /* renamed from: a */
    private static volatile C12361s f34830a = null;

    /* renamed from: h */
    private static boolean f34831h = false;

    /* renamed from: kf */
    private static boolean f34832kf = false;

    /* renamed from: ok */
    private static final String f34833ok = "s";

    /* renamed from: p */
    private static boolean f34834p;

    /* renamed from: bl */
    private String f34835bl;

    /* renamed from: i */
    private InterfaceC12309z f34836i;

    /* renamed from: j */
    private InterfaceC12297bl f34837j;

    /* renamed from: k */
    private int f34838k;

    /* renamed from: q */
    private Future f34840q;

    /* renamed from: rh */
    private InterfaceC12304p f34842rh;

    /* renamed from: s */
    private String f34843s;

    /* renamed from: t */
    private InterfaceC12298h f34844t;

    /* renamed from: td */
    private InterfaceC12300k f34845td;

    /* renamed from: u */
    private InterfaceC12431fl f34846u;

    /* renamed from: x */
    private InterfaceC12301kf f34847x;

    /* renamed from: z */
    private InterfaceC12308s f34848z;

    /* renamed from: zz */
    private InterfaceC12429fb f34849zz;

    /* renamed from: n */
    private DownloadReceiver f34839n = new DownloadReceiver();

    /* renamed from: r */
    private boolean f34841r = false;

    private C12361s() {
    }

    /* renamed from: io */
    private void m18070io() {
        if (Build.VERSION.SDK_INT >= 21) {
            C12565td.m17399ok(new C12565td.InterfaceC12570a() { // from class: com.ss.android.socialbase.appdownloader.s.2
                @Override // com.p521ss.android.socialbase.downloader.impls.C12565td.InterfaceC12570a
                /* renamed from: ok */
                public void mo17386ok(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.m18483ok(downloadInfo, j, z, i);
                }
            });
        }
    }

    /* renamed from: k */
    public static C12361s m18068k() {
        if (f34830a == null) {
            synchronized (C12361s.class) {
                if (f34830a == null) {
                    f34830a = new C12361s();
                }
            }
        }
        return f34830a;
    }

    /* renamed from: u */
    private void m18038u() {
        this.f34838k = C12534ok.m17605bl().m17607a("app_install_keep_receiver_time_s");
        String str = f34833ok;
        C12409ok.m17904a(str, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.f34838k);
        if (this.f34838k <= 0) {
            return;
        }
        Future future = this.f34840q;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f34840q = C12490bl.m17778ok(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.1
            @Override // java.lang.Runnable
            public void run() {
                C12409ok.m17904a(C12361s.f34833ok, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                C12361s.this.m18069j();
                C12361s.this.m18035zz();
            }
        }, this.f34838k, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zz */
    public void m18035zz() {
        synchronized (this.f34839n) {
            if (f34831h) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(IDataSource.f43973c);
                C12490bl.m17807l().registerReceiver(this.f34839n, intentFilter);
                C12490bl.m17807l().registerReceiver(this.f34839n, intentFilter2);
                f34831h = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = f34833ok;
            C12409ok.m17904a(str, "registerDownloadReceiver mIsRegistered:" + f34831h);
        }
    }

    /* renamed from: bl */
    public InterfaceC12304p m18074bl() {
        return this.f34842rh;
    }

    /* renamed from: h */
    public InterfaceC12300k m18072h() {
        return this.f34845td;
    }

    /* renamed from: i */
    public InterfaceC12429fb m18071i() {
        return this.f34849zz;
    }

    /* renamed from: j */
    public void m18069j() {
        synchronized (this.f34839n) {
            try {
                if (f34831h) {
                    C12490bl.m17807l().unregisterReceiver(this.f34839n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f34831h = false;
            f34834p = false;
        }
        C12409ok.m17904a(f34833ok, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    /* renamed from: kf */
    public boolean m18067kf() {
        return C12534ok.m17610a().optInt("package_flag_config", 1) == 1;
    }

    /* renamed from: n */
    public InterfaceC12301kf m18066n() {
        return this.f34847x;
    }

    /* renamed from: p */
    public File m18045p() {
        return Downloader.getInstance(C12490bl.m17807l()).getGlobalSaveDir();
    }

    /* renamed from: q */
    public String m18044q() {
        return this.f34835bl;
    }

    /* renamed from: r */
    public void m18043r() {
        if (C12534ok.m17605bl().m17593ok("enable_app_install_receiver", 1) <= 0) {
            C12409ok.m17904a(f34833ok, "disable app install receiver");
            return;
        }
        synchronized (this.f34839n) {
            if (f34834p) {
                m18038u();
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            C12490bl.m17807l().registerReceiver(this.f34839n, intentFilter);
            f34834p = true;
            m18038u();
            String str = f34833ok;
            C12409ok.m17904a(str, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f34831h);
        }
    }

    /* renamed from: rh */
    public InterfaceC12298h m18042rh() {
        return this.f34844t;
    }

    /* renamed from: s */
    public String m18041s() {
        return this.f34843s;
    }

    /* renamed from: t */
    public InterfaceC12518td m18040t() {
        return Downloader.getInstance(C12490bl.m17807l()).getReserveWifiStatusListener();
    }

    /* renamed from: x */
    public InterfaceC12431fl m18037x() {
        return this.f34846u;
    }

    /* renamed from: z */
    public InterfaceC12309z m18036z() {
        return this.f34836i;
    }

    /* renamed from: bl */
    private void m18073bl(Context context) {
        if (context == null || f34832kf) {
            return;
        }
        C12415n.m17887ok("application/vnd.android.package-archive");
        C12490bl.m17799ok(context);
        C12490bl.m17790ok(new C12367a());
        m18035zz();
        m18070io();
        f34832kf = true;
    }

    /* renamed from: a */
    public InterfaceC12308s m18079a() {
        return this.f34848z;
    }

    /* renamed from: a */
    public void m18075a(String str) {
        Downloader.getInstance(C12490bl.m17807l()).setDefaultSavePath(str);
    }

    /* renamed from: ok */
    public InterfaceC12297bl m18065ok() {
        return this.f34837j;
    }

    /* renamed from: a */
    private DownloadInfo m18077a(Context context, String str) {
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

    /* renamed from: ok */
    public void m18048ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34843s = str;
    }

    /* renamed from: ok */
    public void m18057ok(InterfaceC12300k interfaceC12300k) {
        this.f34845td = interfaceC12300k;
    }

    /* renamed from: a */
    public List<DownloadInfo> m18078a(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    @Deprecated
    /* renamed from: ok */
    public void m18060ok(Context context, String str, InterfaceC12297bl interfaceC12297bl, InterfaceC12308s interfaceC12308s, InterfaceC12304p interfaceC12304p) {
        if (interfaceC12297bl != null) {
            this.f34837j = interfaceC12297bl;
        }
        if (interfaceC12308s != null) {
            this.f34848z = interfaceC12308s;
        }
        if (interfaceC12304p != null) {
            this.f34842rh = interfaceC12304p;
        }
        m18073bl(context);
    }

    /* renamed from: ok */
    public static boolean m18063ok(Context context, int i) {
        return C12293bl.m18422ok(context, i, true) == 1;
    }

    /* renamed from: ok */
    public void m18062ok(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    C12293bl.m18422ok(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
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
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m18055ok(com.p521ss.android.socialbase.appdownloader.C12312kf r23) {
        /*
            Method dump skipped, instructions count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.C12361s.m18055ok(com.ss.android.socialbase.appdownloader.kf):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18049ok(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    /* renamed from: ok */
    private List<C12601bl> m18046ok(List<C12601bl> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (C12601bl c12601bl : list) {
                if (c12601bl != null && !TextUtils.isEmpty(c12601bl.m16999ok()) && !TextUtils.isEmpty(c12601bl.m17000a())) {
                    if (c12601bl.m16999ok().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new C12601bl(c12601bl.m16999ok(), c12601bl.m17000a()));
                }
            }
        }
        if (!z) {
            arrayList.add(new C12601bl("User-Agent", C12292ok.f34656ok));
        }
        return arrayList;
    }

    /* renamed from: ok */
    public String m18047ok(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || C12293bl.m18434bl(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    /* renamed from: ok */
    private InterfaceC12427ep m18056ok(final InterfaceC12302n interfaceC12302n) {
        if (interfaceC12302n == null) {
            return null;
        }
        return new InterfaceC12427ep() { // from class: com.ss.android.socialbase.appdownloader.s.5
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public void mo16630ok(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            interfaceC12302n.m18396ok(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            interfaceC12302n.m18395ok(C12490bl.m17807l(), str);
                            return;
                        case 10:
                            interfaceC12302n.m18394ok(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                interfaceC12302n.m18397ok(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public boolean mo16629ok(boolean z) {
                return interfaceC12302n.m18393ok(z);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public String mo16631ok() {
                return interfaceC12302n.m18398ok();
            }
        };
    }

    /* renamed from: ok */
    public DownloadInfo m18061ok(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo m18059ok = m18059ok(context, str, m18045p());
                if (m18059ok == null) {
                    m18059ok = m18059ok(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (m18059ok == null) {
                    m18059ok = m18059ok(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (m18059ok == null) {
                    m18059ok = m18059ok(context, str, context.getFilesDir());
                }
                return (m18059ok == null && C12534ok.m17605bl().m17595ok("get_download_info_by_list")) ? m18077a(context, str) : m18059ok;
            } catch (Throwable th) {
                C12409ok.m17904a(f34833ok, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    /* renamed from: ok */
    private DownloadInfo m18059ok(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    /* renamed from: ok */
    public List<DownloadInfo> m18064ok(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    /* renamed from: ok */
    public void m18058ok(InterfaceC12298h interfaceC12298h) {
        this.f34844t = interfaceC12298h;
    }

    /* renamed from: ok */
    public void m18050ok(InterfaceC12518td interfaceC12518td) {
        Downloader.getInstance(C12490bl.m17807l()).setReserveWifiStatusListener(interfaceC12518td);
    }

    /* renamed from: ok */
    public void m18052ok(InterfaceC12429fb interfaceC12429fb) {
        this.f34849zz = interfaceC12429fb;
    }

    /* renamed from: ok */
    public void m18051ok(InterfaceC12431fl interfaceC12431fl) {
        this.f34846u = interfaceC12431fl;
    }
}
