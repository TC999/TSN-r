package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.s;
import com.mbridge.msdk.foundation.db.t;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.o;
import com.mbridge.msdk.foundation.entity.p;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CampaignDownLoadTask.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a implements Serializable {
    private boolean A;
    private int B;
    private File C;
    private int E;
    private int F;
    private int G;
    private boolean H;

    /* renamed from: b  reason: collision with root package name */
    private int f41003b;

    /* renamed from: c  reason: collision with root package name */
    private int f41004c;

    /* renamed from: e  reason: collision with root package name */
    private volatile int f41006e;

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f41008g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f41009h;

    /* renamed from: i  reason: collision with root package name */
    private CampaignEx f41010i;

    /* renamed from: j  reason: collision with root package name */
    private String f41011j;

    /* renamed from: k  reason: collision with root package name */
    private Context f41012k;

    /* renamed from: l  reason: collision with root package name */
    private long f41013l;

    /* renamed from: m  reason: collision with root package name */
    private String f41014m;

    /* renamed from: n  reason: collision with root package name */
    private String f41015n;

    /* renamed from: o  reason: collision with root package name */
    private long f41016o;

    /* renamed from: p  reason: collision with root package name */
    private String f41017p;

    /* renamed from: r  reason: collision with root package name */
    private long f41019r;

    /* renamed from: u  reason: collision with root package name */
    private s f41022u;

    /* renamed from: w  reason: collision with root package name */
    private String f41024w;

    /* renamed from: x  reason: collision with root package name */
    private DownloadRequest f41025x;

    /* renamed from: y  reason: collision with root package name */
    private DownloadMessage f41026y;

    /* renamed from: z  reason: collision with root package name */
    private int f41027z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f41002a = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41005d = false;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<c> f41007f = new CopyOnWriteArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    private boolean f41018q = false;

    /* renamed from: s  reason: collision with root package name */
    private int f41020s = 100;

    /* renamed from: t  reason: collision with root package name */
    private boolean f41021t = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f41023v = false;
    private int D = 1;
    private OnDownloadStateListener I = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                x.d("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.f41016o + "    " + a.this.f41013l);
                if (a.this.f41022u == null) {
                    a.this.f41022u = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
                }
                a.this.f41022u.a(a.this.f41014m, a.this.f41016o, 5);
                String videoMD5Value = a.this.f41010i.getVideoMD5Value();
                if (!TextUtils.isEmpty(videoMD5Value)) {
                    if (videoMD5Value.equals(u.a(new File(a.this.f41017p)))) {
                        a aVar = a.this;
                        aVar.a(aVar.f41016o, true);
                        a aVar2 = a.this;
                        aVar2.c(aVar2.f(3));
                        return;
                    }
                    a.this.a("Video download complete but MD5 check failed");
                } else {
                    a aVar3 = a.this;
                    aVar3.a(aVar3.f41016o, false);
                    a aVar4 = a.this;
                    aVar4.c(aVar4.f(3));
                }
                try {
                    if (downloadMessage.getFrom() != 1 || a.this.f41010i == null || TextUtils.isEmpty(a.this.f41011j) || TextUtils.isEmpty(a.this.f41014m)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new RunnableC0768a(a.this.f41010i.getId(), a.this.f41014m, a.this.f41011j, a.this.f41016o, a.this.f41010i.getRequestId(), a.this.f41010i.getRequestIdNotice()));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                x.d("CampaignDownLoadTask", e5.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.f41025x == null || a.this.f41025x.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            a.this.K = true;
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            a.this.r();
            a.this.a(3, message);
            a.this.a(message);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.f41006e = 1;
            if (a.this.f41022u == null) {
                a.this.f41022u = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            }
            a.this.f41022u.a(a.this.f41010i, a.this.f41013l, a.this.f41017p, a.this.f41006e);
        }
    };
    private volatile boolean J = false;
    private volatile boolean K = false;

    /* renamed from: L  reason: collision with root package name */
    private OnProgressStateListener f41001L = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                a.this.f41016o = downloadProgress.getCurrent();
                a.this.f41013l = downloadProgress.getTotal();
                a.this.f41027z = downloadProgress.getCurrentDownloadRate();
                if (a.this.f41020s != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.f41020s) {
                    x.d("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate & ctnType = " + a.this.f41020s + " " + a.this.f41004c + " " + a.this.D);
                    if (a.this.f41005d) {
                        return;
                    }
                    a.this.f41005d = true;
                    if (!a.this.A) {
                        a aVar = a.this;
                        aVar.c(aVar.f(1));
                        a.this.a(downloadProgress.getCurrent(), false);
                    }
                    if (a.this.f41025x == null || a.this.D != 2 || a.this.A) {
                        return;
                    }
                    a.this.f41025x.cancel(downloadMessage);
                }
            } catch (Exception e4) {
                x.d("CampaignDownLoadTask", e4.getMessage());
            }
        }
    };

    /* compiled from: CampaignDownLoadTask.java */
    /* renamed from: com.mbridge.msdk.videocommon.download.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class RunnableC0768a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f41030a;

        /* renamed from: b  reason: collision with root package name */
        private final String f41031b;

        /* renamed from: c  reason: collision with root package name */
        private final String f41032c;

        /* renamed from: d  reason: collision with root package name */
        private final long f41033d;

        /* renamed from: e  reason: collision with root package name */
        private final String f41034e;

        /* renamed from: f  reason: collision with root package name */
        private String f41035f;

        public RunnableC0768a(String str, String str2, String str3, long j4, String str4, String str5) {
            this.f41030a = str;
            this.f41031b = str2;
            this.f41032c = str3;
            this.f41033d = j4;
            this.f41034e = str4;
            this.f41035f = str5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb;
            com.mbridge.msdk.foundation.same.net.g.d a4;
            if (TextUtils.isEmpty(this.f41032c) || TextUtils.isEmpty(this.f41031b) || TextUtils.isEmpty(this.f41030a) || TextUtils.isEmpty(this.f41034e) || TextUtils.isEmpty(this.f41035f) || this.f41033d <= 0) {
                return;
            }
            try {
                sb = new StringBuilder("key=2000110&");
                sb.append("unit_id=");
                sb.append(this.f41032c);
                sb.append("&");
                sb.append("video_url=");
                sb.append(this.f41031b);
                sb.append("&");
                sb.append("c_id=");
                sb.append(this.f41030a);
                sb.append("&");
                sb.append("r_id=");
                sb.append(this.f41034e);
                sb.append("&");
                sb.append("r_id_n=");
                sb.append(this.f41035f);
                sb.append("&");
                sb.append("video_size=");
                sb.append(this.f41033d);
            } catch (Exception unused) {
                sb = null;
            }
            if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                if (sb != null) {
                    com.mbridge.msdk.foundation.same.report.b.a().a(sb.toString());
                }
            } else if (sb == null || (a4 = e.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.f().j(), this.f41032c)) == null) {
            } else {
                try {
                    new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j()).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a4, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.videocommon.download.a.a.1
                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void a(String str) {
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.d.b
                        public final void b(String str) {
                        }
                    });
                } catch (Exception unused2) {
                }
            }
        }
    }

    public a(Context context, CampaignEx campaignEx, String str, int i4) {
        File file;
        this.f41003b = 1;
        this.f41006e = 0;
        this.f41016o = 0L;
        this.H = false;
        if (context == null && campaignEx == null) {
            return;
        }
        com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
        if (g4 != null) {
            this.H = g4.r();
        }
        this.E = com.mbridge.msdk.foundation.same.a.P;
        this.F = com.mbridge.msdk.foundation.same.a.Q;
        this.G = com.mbridge.msdk.foundation.same.a.O;
        this.f41019r = System.currentTimeMillis();
        this.f41012k = com.mbridge.msdk.foundation.controller.a.f().j();
        this.f41010i = campaignEx;
        this.f41011j = str;
        this.f41003b = i4;
        if (campaignEx != null) {
            this.f41014m = campaignEx.getVideoUrlEncode();
        }
        this.f41024w = v.d(this.f41014m);
        this.f41015n = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.f41017p = this.f41015n + this.f41024w;
        x.b("CampaignDownLoadTask", this.f41010i.getAppName() + " videoLocalPath:" + this.f41017p + " videoUrl: " + this.f41010i.getVideoUrlEncode() + " " + this.f41020s);
        try {
            if (TextUtils.isEmpty(this.f41014m)) {
                return;
            }
            File file2 = null;
            if (!TextUtils.isEmpty(this.f41015n)) {
                file2 = new File(this.f41015n);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null && file2.exists() && ((file = this.C) == null || !file.exists())) {
                File file3 = new File(file2 + "/.nomedia");
                this.C = file3;
                if (!file3.exists()) {
                    this.C.createNewFile();
                }
            }
            s a4 = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            o a5 = a4.a(this.f41014m, "");
            if (a5 != null) {
                this.f41016o = a5.b();
                if (this.f41006e != 2) {
                    this.f41006e = a5.d();
                }
                if (this.f41006e == 1) {
                    this.f41006e = 2;
                }
                this.f41013l = a5.c();
                if (a5.a() > 0) {
                    this.f41019r = a5.a();
                }
                if (this.f41006e == 5) {
                    if (Objects.exists(new File(this.f41015n + this.f41024w), this.f41015n, this.f41024w)) {
                        this.f41017p = this.f41015n + this.f41024w;
                    } else {
                        q();
                    }
                } else if (this.f41006e != 0) {
                    this.f41017p = this.f41015n + this.f41024w;
                }
            } else {
                a4.a(this.f41014m, this.f41019r);
            }
            String str2 = this.f41014m;
            if (TextUtils.isEmpty(str2)) {
                this.f41009h.a("VideoUrl is NULL, Please check it.", "");
            } else if (this.f41006e == 1) {
                x.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
            } else if (this.f41006e == 5 && Utils.getDownloadRate(this.f41013l, this.f41016o) >= this.f41020s) {
                x.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar = this.f41008g;
                if (aVar != null) {
                    aVar.a(this.f41014m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f41009h;
                if (aVar2 != null) {
                    aVar2.a(this.f41014m);
                }
                try {
                    File file4 = new File(this.f41017p);
                    if (Objects.exists(file4, this.f41015n, this.f41024w) && file4.isFile()) {
                        file4.setLastModified(System.currentTimeMillis());
                    }
                } catch (Exception e4) {
                    x.d("CampaignDownLoadTask", e4.getMessage());
                }
            } else if (this.f41003b == 3) {
                x.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                a(0L, false);
            } else {
                if (this.f41010i.getReady_rate() == 0) {
                    com.mbridge.msdk.videocommon.listener.a aVar3 = this.f41008g;
                    if (aVar3 != null) {
                        aVar3.a(this.f41014m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.f41009h;
                    if (aVar4 != null) {
                        aVar4.a(this.f41014m);
                    }
                }
                this.f41026y = new DownloadMessage(new Object(), str2, this.f41024w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                this.f41025x = MBDownloadManager.getInstance().download(this.f41026y).withReadTimeout(this.E).withConnectTimeout(this.G).withWriteTimeout(this.F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f41015n).withDownloadStateListener(this.I).withProgressStateListener(this.f41001L).with("do_us_fi_re", Boolean.toString(this.H)).build();
            }
        } catch (Exception e5) {
            x.b("CampaignDownLoadTask", e5.getMessage());
        }
    }

    private void q() {
        if (this.f41022u == null) {
            this.f41022u = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        try {
            try {
                this.f41022u.b(this.f41014m);
                if (!z.a().a("r_d_v_b_l", true)) {
                    File file = new File(this.f41017p);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            } finally {
                this.f41006e = 0;
            }
        } catch (Throwable unused) {
            x.d("CampaignDownLoadTask", "del DB or file failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.reward.a.a");
            cls.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls.newInstance(), this.f41011j, this.f41010i);
            Class<?> cls2 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            cls2.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls2.newInstance(), this.f41011j, this.f41010i);
        } catch (Exception e4) {
            x.d("CampaignDownLoadTask", e4.getMessage());
        }
    }

    public final boolean p() {
        if (z.a().a("c_f_w_i_v", true)) {
            if (this.J) {
                return this.J;
            }
            try {
                this.J = Objects.exists(new File(this.f41017p), this.f41015n, this.f41024w);
                return this.J;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public final String d() {
        return this.f41017p;
    }

    public final long e() {
        return this.f41013l;
    }

    public final int f() {
        return this.f41006e;
    }

    public final CampaignEx g() {
        return this.f41010i;
    }

    public final long h() {
        return this.f41016o;
    }

    public final void i() {
        x.d("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.f41014m)) {
                return;
            }
            if (this.f41014m != null) {
                x.d("CampaignDownLoadTask", new URL(this.f41014m).getPath());
            }
            if (this.f41020s == 0 && this.D == 2) {
                x.d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            DownloadRequest downloadRequest = this.f41025x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f41008g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.f41009h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void j() {
        try {
            this.A = true;
            if (this.D == 1) {
                x.d("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.D);
                return;
            }
            x.d("CampaignDownLoadTask", "resume()");
            if (this.f41026y == null) {
                this.f41026y = new DownloadMessage(new Object(), this.f41014m, this.f41024w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            DownloadRequest build = MBDownloadManager.getInstance().download(this.f41026y).withReadTimeout(this.E).withConnectTimeout(this.G).withWriteTimeout(this.F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f41015n).withDownloadStateListener(this.I).withProgressStateListener(this.f41001L).with("do_us_fi_re", Boolean.toString(this.H)).build();
            this.f41025x = build;
            build.start();
            c(f(2));
        } catch (Exception e4) {
            x.d("CampaignDownLoadTask", e4.getMessage());
        }
    }

    public final String k() {
        String str = "";
        if (this.f41003b == 3) {
            return "";
        }
        String str2 = this.f41015n + this.f41024w;
        File file = new File(str2);
        try {
            if (!Objects.exists(file, this.f41015n, this.f41024w)) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.f41017p = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            x.d("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.f41006e == 5 && !TextUtils.isEmpty(str)) {
            q();
        }
        return str;
    }

    public final void l() {
        if (this.f41007f != null) {
            this.f41007f = null;
        }
    }

    public final void m() {
        CampaignEx campaignEx;
        try {
            try {
                q();
                campaignEx = this.f41010i;
            } catch (Exception unused) {
                x.d("CampaignDownLoadTask", "del file is failed");
            }
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a a4 = com.mbridge.msdk.videocommon.a.a.a();
                if (a4 != null) {
                    a4.a(this.f41010i);
                }
            }
        } finally {
            this.f41006e = 0;
        }
    }

    public final String n() {
        try {
            File file = new File(this.f41017p);
            if (Objects.exists(file, this.f41015n, this.f41024w) && file.isFile()) {
                return this.f41017p;
            }
        } catch (Exception e4) {
            x.d("CampaignDownLoadTask", e4.getMessage());
        }
        return this.f41014m;
    }

    public final boolean o() {
        if (z.a().a("c_f_w_i_v", true)) {
            return this.K;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(int i4) {
        if (this.f41010i == null || TextUtils.isEmpty(this.f41011j) || TextUtils.isEmpty(this.f41010i.getRequestId()) || TextUtils.isEmpty(this.f41010i.getVideoUrlEncode())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.f41011j + "&rid=" + this.f41010i.getRequestId() + "&rid_n=" + this.f41010i.getRequestIdNotice() + "&package_name=" + com.mbridge.msdk.foundation.controller.a.f().d() + "&app_id=" + com.mbridge.msdk.foundation.controller.a.f().k() + "&video_url=" + URLEncoder.encode(this.f41010i.getVideoUrlEncode()) + "&process_size=" + this.f41016o + "&file_size=" + this.f41013l + "&ready_rate=" + this.f41020s + "&cd_rate=" + this.f41004c + "&cid=" + this.f41010i.getId() + "&type=" + this.f41006e + "&video_download_status=" + i4;
    }

    public final long c() {
        return this.f41019r;
    }

    public final void d(int i4) {
        this.B = i4;
    }

    public final void e(int i4) {
        this.D = i4;
    }

    public final void c(int i4) {
        this.f41020s = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                com.mbridge.msdk.foundation.same.report.b.a().a(str);
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j());
            com.mbridge.msdk.foundation.same.net.g.d a4 = e.a(str, com.mbridge.msdk.foundation.controller.a.f().j(), this.f41011j);
            CampaignEx campaignEx = this.f41010i;
            if (campaignEx != null && campaignEx.getAdType() != 42) {
                a4.a("r_stid", com.mbridge.msdk.videocommon.d.b.a().b().b());
            }
            aVar.c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, a4, null);
        } catch (Exception e4) {
            x.d("CampaignDownLoadTask", e4.getMessage());
        }
    }

    public final void b(int i4) {
        this.f41004c = i4;
    }

    public final boolean b() {
        return this.f41023v;
    }

    public final void b(boolean z3) {
        this.f41018q = z3;
    }

    public final String a() {
        return this.f41014m;
    }

    public final void b(String str) {
        r();
        a(2, str);
        this.f41006e = 4;
    }

    public final void a(int i4) {
        this.f41003b = i4;
    }

    public final void a(boolean z3) {
        this.f41023v = z3;
    }

    public final void a(int i4, int i5) {
        this.f41006e = i4;
        if (this.f41022u == null) {
            this.f41022u = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        this.f41022u.a(this.f41014m, i5, i4);
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f41009h = aVar;
    }

    public final void a(CampaignEx campaignEx) {
        this.f41010i = campaignEx;
    }

    public final void a(long j4, boolean z3) {
        s sVar;
        x.d("CampaignDownLoadTask", "setStateToDone \u4e0b\u8f7d\u5b8c\u6210  \uff1a mProgressSize" + this.f41016o + "  progressSize " + j4 + "  " + this.f41027z + "%   FileSize : " + this.f41013l + "  " + this.f41010i.getAppName());
        if (this.f41020s == 100 && this.f41003b != 3 && j4 != this.f41013l && !z3) {
            File file = new File(this.f41017p);
            long length = Objects.exists(file, this.f41015n, this.f41024w) ? file.length() : 0L;
            x.d("CampaignDownLoadTask", "progressSize = " + j4 + " fileSize = " + this.f41013l + " " + z3 + " absFileSize = " + length);
            a("File size is not match witch download size.");
            return;
        }
        this.f41006e = 5;
        a(1, "");
        long j5 = this.f41013l;
        if (j5 != 0 && (sVar = this.f41022u) != null) {
            sVar.b(this.f41014m, j5);
        }
        this.f41002a = false;
        a(j4, this.f41006e);
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.f41008g;
        if (aVar != null) {
            aVar.a(str, this.f41014m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.f41009h;
        if (aVar2 != null) {
            aVar2.a(str, this.f41014m);
        }
        x.d("CampaignDownLoadTask", "Video download stop : " + str);
        CampaignEx campaignEx = this.f41010i;
        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.f41010i.getRsIgnoreCheckRule().size() > 0 && this.f41010i.getRsIgnoreCheckRule().contains(0)) {
            x.b("CampaignDownLoadTask", "Is not check video download status");
        } else if (this.f41006e == 4 || this.f41006e == 2 || this.f41006e == 5) {
        } else {
            this.f41006e = 4;
            a(this.f41016o, this.f41006e);
        }
    }

    public final void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f41007f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f41008g = aVar;
    }

    private void a(long j4, int i4) {
        this.f41016o = j4;
        int i5 = this.f41020s;
        if (100 * j4 >= i5 * this.f41013l && !this.f41021t && i4 != 4) {
            if (i5 == 100 && i4 != 5) {
                this.f41006e = 5;
                return;
            }
            this.f41021t = true;
            x.d("CampaignDownLoadTask", "UpdateListener : state: " + i4 + " progress : " + j4);
            String k4 = k();
            if (TextUtils.isEmpty(k4)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.f41008g;
                if (aVar != null) {
                    aVar.a(this.f41014m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f41009h;
                if (aVar2 != null) {
                    aVar2.a(this.f41014m);
                }
            } else {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f41008g;
                if (aVar3 != null) {
                    aVar3.a("file is not effective " + k4, this.f41014m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.f41009h;
                if (aVar4 != null) {
                    aVar4.a("file is not effective " + k4, this.f41014m);
                }
            }
        }
        if (!this.f41002a && j4 > 0) {
            this.f41002a = true;
            if (this.f41022u == null) {
                this.f41022u = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            }
            this.f41022u.a(this.f41014m, j4, this.f41006e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f41007f;
        if (copyOnWriteArrayList != null) {
            Iterator<c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.a(j4, i4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, String str) {
        t a4 = t.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        p pVar = new p(this.f41012k, this.f41010i, i4, Long.toString(this.f41019r != 0 ? System.currentTimeMillis() - this.f41019r : 0L), this.f41013l, this.B);
        pVar.n(this.f41010i.getId());
        pVar.e(this.f41010i.getVideoUrlEncode());
        pVar.p(str);
        pVar.k(this.f41010i.getRequestId());
        pVar.l(this.f41010i.getRequestIdNotice());
        pVar.m(this.f41011j);
        a4.a(pVar);
    }
}
