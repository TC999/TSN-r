package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
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
import com.mbridge.msdk.foundation.entity.VideoBean;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.VideoDao;
import com.mbridge.msdk.foundation.p472db.VideoReportDataDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.p490d.ReportRequest;
import com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler;
import com.mbridge.msdk.foundation.tools.SameFileMD5;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameOptimizedController;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.videocommon.listener.VideoDownloadListener;
import com.mbridge.msdk.videocommon.p512a.VideoCampaignCache;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.mbridge.msdk.videocommon.download.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CampaignDownLoadTask implements Serializable {

    /* renamed from: A */
    private boolean f32279A;

    /* renamed from: B */
    private int f32280B;

    /* renamed from: C */
    private File f32281C;

    /* renamed from: E */
    private int f32283E;

    /* renamed from: F */
    private int f32284F;

    /* renamed from: G */
    private int f32285G;

    /* renamed from: H */
    private boolean f32286H;

    /* renamed from: b */
    private int f32292b;

    /* renamed from: c */
    private int f32293c;

    /* renamed from: e */
    private volatile int f32295e;

    /* renamed from: g */
    private VideoDownloadListener f32297g;

    /* renamed from: h */
    private VideoDownloadListener f32298h;

    /* renamed from: i */
    private CampaignEx f32299i;

    /* renamed from: j */
    private String f32300j;

    /* renamed from: k */
    private Context f32301k;

    /* renamed from: l */
    private long f32302l;

    /* renamed from: m */
    private String f32303m;

    /* renamed from: n */
    private String f32304n;

    /* renamed from: o */
    private long f32305o;

    /* renamed from: p */
    private String f32306p;

    /* renamed from: r */
    private long f32308r;

    /* renamed from: u */
    private VideoDao f32311u;

    /* renamed from: w */
    private String f32313w;

    /* renamed from: x */
    private DownloadRequest f32314x;

    /* renamed from: y */
    private DownloadMessage f32315y;

    /* renamed from: z */
    private int f32316z;

    /* renamed from: a */
    private boolean f32291a = false;

    /* renamed from: d */
    private boolean f32294d = false;

    /* renamed from: f */
    private CopyOnWriteArrayList<DownLoadTaskSelfProgressListener> f32296f = new CopyOnWriteArrayList<>();

    /* renamed from: q */
    private boolean f32307q = false;

    /* renamed from: s */
    private int f32309s = 100;

    /* renamed from: t */
    private boolean f32310t = false;

    /* renamed from: v */
    private boolean f32312v = false;

    /* renamed from: D */
    private int f32282D = 1;

    /* renamed from: I */
    private OnDownloadStateListener f32287I = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            try {
                SameLogTool.m21733d("CampaignDownLoadTask", "onDownloadComplete callback : " + CampaignDownLoadTask.this.f32305o + "    " + CampaignDownLoadTask.this.f32302l);
                if (CampaignDownLoadTask.this.f32311u == null) {
                    CampaignDownLoadTask.this.f32311u = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
                }
                CampaignDownLoadTask.this.f32311u.m22660a(CampaignDownLoadTask.this.f32303m, CampaignDownLoadTask.this.f32305o, 5);
                String videoMD5Value = CampaignDownLoadTask.this.f32299i.getVideoMD5Value();
                if (!TextUtils.isEmpty(videoMD5Value)) {
                    if (videoMD5Value.equals(SameFileMD5.m21760a(new File(CampaignDownLoadTask.this.f32306p)))) {
                        CampaignDownLoadTask campaignDownLoadTask = CampaignDownLoadTask.this;
                        campaignDownLoadTask.m20740a(campaignDownLoadTask.f32305o, true);
                        CampaignDownLoadTask campaignDownLoadTask2 = CampaignDownLoadTask.this;
                        campaignDownLoadTask2.m20714c(campaignDownLoadTask2.m20706f(3));
                        return;
                    }
                    CampaignDownLoadTask.this.m20729a("Video download complete but MD5 check failed");
                } else {
                    CampaignDownLoadTask campaignDownLoadTask3 = CampaignDownLoadTask.this;
                    campaignDownLoadTask3.m20740a(campaignDownLoadTask3.f32305o, false);
                    CampaignDownLoadTask campaignDownLoadTask4 = CampaignDownLoadTask.this;
                    campaignDownLoadTask4.m20714c(campaignDownLoadTask4.m20706f(3));
                }
                try {
                    if (downloadMessage.getFrom() != 1 || CampaignDownLoadTask.this.f32299i == null || TextUtils.isEmpty(CampaignDownLoadTask.this.f32300j) || TextUtils.isEmpty(CampaignDownLoadTask.this.f32303m)) {
                        return;
                    }
                    ThreadPoolUtils.m22308b().execute(new RunnableC11728a(CampaignDownLoadTask.this.f32299i.getId(), CampaignDownLoadTask.this.f32303m, CampaignDownLoadTask.this.f32300j, CampaignDownLoadTask.this.f32305o, CampaignDownLoadTask.this.f32299i.getRequestId(), CampaignDownLoadTask.this.f32299i.getRequestIdNotice()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                SameLogTool.m21733d("CampaignDownLoadTask", e2.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (CampaignDownLoadTask.this.f32314x == null || CampaignDownLoadTask.this.f32314x.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            CampaignDownLoadTask.this.f32289K = true;
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            CampaignDownLoadTask.this.m20684r();
            CampaignDownLoadTask.this.m20742a(3, message);
            CampaignDownLoadTask.this.m20729a(message);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            CampaignDownLoadTask.this.f32295e = 1;
            if (CampaignDownLoadTask.this.f32311u == null) {
                CampaignDownLoadTask.this.f32311u = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            }
            CampaignDownLoadTask.this.f32311u.m22663a(CampaignDownLoadTask.this.f32299i, CampaignDownLoadTask.this.f32302l, CampaignDownLoadTask.this.f32306p, CampaignDownLoadTask.this.f32295e);
        }
    };

    /* renamed from: J */
    private volatile boolean f32288J = false;

    /* renamed from: K */
    private volatile boolean f32289K = false;

    /* renamed from: L */
    private OnProgressStateListener f32290L = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                CampaignDownLoadTask.this.f32305o = downloadProgress.getCurrent();
                CampaignDownLoadTask.this.f32302l = downloadProgress.getTotal();
                CampaignDownLoadTask.this.f32316z = downloadProgress.getCurrentDownloadRate();
                if (CampaignDownLoadTask.this.f32309s != 100 && downloadProgress.getCurrentDownloadRate() >= CampaignDownLoadTask.this.f32309s) {
                    SameLogTool.m21733d("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate & ctnType = " + CampaignDownLoadTask.this.f32309s + " " + CampaignDownLoadTask.this.f32293c + " " + CampaignDownLoadTask.this.f32282D);
                    if (CampaignDownLoadTask.this.f32294d) {
                        return;
                    }
                    CampaignDownLoadTask.this.f32294d = true;
                    if (!CampaignDownLoadTask.this.f32279A) {
                        CampaignDownLoadTask campaignDownLoadTask = CampaignDownLoadTask.this;
                        campaignDownLoadTask.m20714c(campaignDownLoadTask.m20706f(1));
                        CampaignDownLoadTask.this.m20740a(downloadProgress.getCurrent(), false);
                    }
                    if (CampaignDownLoadTask.this.f32314x == null || CampaignDownLoadTask.this.f32282D != 2 || CampaignDownLoadTask.this.f32279A) {
                        return;
                    }
                    CampaignDownLoadTask.this.f32314x.cancel(downloadMessage);
                }
            } catch (Exception e) {
                SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
            }
        }
    };

    /* compiled from: CampaignDownLoadTask.java */
    /* renamed from: com.mbridge.msdk.videocommon.download.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class RunnableC11728a implements Runnable {

        /* renamed from: a */
        private final String f32319a;

        /* renamed from: b */
        private final String f32320b;

        /* renamed from: c */
        private final String f32321c;

        /* renamed from: d */
        private final long f32322d;

        /* renamed from: e */
        private final String f32323e;

        /* renamed from: f */
        private String f32324f;

        public RunnableC11728a(String str, String str2, String str3, long j, String str4, String str5) {
            this.f32319a = str;
            this.f32320b = str2;
            this.f32321c = str3;
            this.f32322d = j;
            this.f32323e = str4;
            this.f32324f = str5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb;
            CommonRequestParams m22062a;
            if (TextUtils.isEmpty(this.f32321c) || TextUtils.isEmpty(this.f32320b) || TextUtils.isEmpty(this.f32319a) || TextUtils.isEmpty(this.f32323e) || TextUtils.isEmpty(this.f32324f) || this.f32322d <= 0) {
                return;
            }
            try {
                sb = new StringBuilder("key=2000110&");
                sb.append("unit_id=");
                sb.append(this.f32321c);
                sb.append("&");
                sb.append("video_url=");
                sb.append(this.f32320b);
                sb.append("&");
                sb.append("c_id=");
                sb.append(this.f32319a);
                sb.append("&");
                sb.append("r_id=");
                sb.append(this.f32323e);
                sb.append("&");
                sb.append("r_id_n=");
                sb.append(this.f32324f);
                sb.append("&");
                sb.append("video_size=");
                sb.append(this.f32322d);
            } catch (Exception unused) {
                sb = null;
            }
            if (MBBatchReportManager.m22142a().m22135c()) {
                if (sb != null) {
                    MBBatchReportManager.m22142a().m22139a(sb.toString());
                }
            } else if (sb == null || (m22062a = C11385e.m22062a(sb.toString(), MBSDKContext.m22865f().m22861j(), this.f32321c)) == null) {
            } else {
                try {
                    new ReportRequest(MBSDKContext.m22865f().m22861j()).m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a, new ReportResponseHandler() { // from class: com.mbridge.msdk.videocommon.download.a.a.1
                        @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                        /* renamed from: a */
                        public final void mo20683a(String str) {
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.p490d.ReportResponseHandler
                        /* renamed from: b */
                        public final void mo20682b(String str) {
                        }
                    });
                } catch (Exception unused2) {
                }
            }
        }
    }

    public CampaignDownLoadTask(Context context, CampaignEx campaignEx, String str, int i) {
        File file;
        this.f32292b = 1;
        this.f32295e = 0;
        this.f32305o = 0L;
        this.f32286H = false;
        if (context == null && campaignEx == null) {
            return;
        }
        Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
        if (m23241g != null) {
            this.f32286H = m23241g.m23289r();
        }
        this.f32283E = CommonConst.f30575P;
        this.f32284F = CommonConst.f30576Q;
        this.f32285G = CommonConst.f30574O;
        this.f32308r = System.currentTimeMillis();
        this.f32301k = MBSDKContext.m22865f().m22861j();
        this.f32299i = campaignEx;
        this.f32300j = str;
        this.f32292b = i;
        if (campaignEx != null) {
            this.f32303m = campaignEx.getVideoUrlEncode();
        }
        this.f32313w = SameFileTool.m21744d(this.f32303m);
        this.f32304n = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_VC) + File.separator;
        this.f32306p = this.f32304n + this.f32313w;
        SameLogTool.m21736b("CampaignDownLoadTask", this.f32299i.getAppName() + " videoLocalPath:" + this.f32306p + " videoUrl: " + this.f32299i.getVideoUrlEncode() + " " + this.f32309s);
        try {
            if (TextUtils.isEmpty(this.f32303m)) {
                return;
            }
            File file2 = null;
            if (!TextUtils.isEmpty(this.f32304n)) {
                file2 = new File(this.f32304n);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null && file2.exists() && ((file = this.f32281C) == null || !file.exists())) {
                File file3 = new File(file2 + "/.nomedia");
                this.f32281C = file3;
                if (!file3.exists()) {
                    this.f32281C.createNewFile();
                }
            }
            VideoDao m22664a = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            VideoBean m22659a = m22664a.m22659a(this.f32303m, "");
            if (m22659a != null) {
                this.f32305o = m22659a.m22456b();
                if (this.f32295e != 2) {
                    this.f32295e = m22659a.m22451d();
                }
                if (this.f32295e == 1) {
                    this.f32295e = 2;
                }
                this.f32302l = m22659a.m22452c();
                if (m22659a.m22460a() > 0) {
                    this.f32308r = m22659a.m22460a();
                }
                if (this.f32295e == 5) {
                    if (Objects.exists(new File(this.f32304n + this.f32313w), this.f32304n, this.f32313w)) {
                        this.f32306p = this.f32304n + this.f32313w;
                    } else {
                        m20685q();
                    }
                } else if (this.f32295e != 0) {
                    this.f32306p = this.f32304n + this.f32313w;
                }
            } else {
                m22664a.m22661a(this.f32303m, this.f32308r);
            }
            String str2 = this.f32303m;
            if (TextUtils.isEmpty(str2)) {
                this.f32298h.mo20640a("VideoUrl is NULL, Please check it.", "");
            } else if (this.f32295e == 1) {
                SameLogTool.m21738a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
            } else if (this.f32295e == 5 && Utils.getDownloadRate(this.f32302l, this.f32305o) >= this.f32309s) {
                SameLogTool.m21738a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                VideoDownloadListener videoDownloadListener = this.f32297g;
                if (videoDownloadListener != null) {
                    videoDownloadListener.mo20641a(this.f32303m);
                }
                VideoDownloadListener videoDownloadListener2 = this.f32298h;
                if (videoDownloadListener2 != null) {
                    videoDownloadListener2.mo20641a(this.f32303m);
                }
                try {
                    File file4 = new File(this.f32306p);
                    if (Objects.exists(file4, this.f32304n, this.f32313w) && file4.isFile()) {
                        file4.setLastModified(System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
                }
            } else if (this.f32292b == 3) {
                SameLogTool.m21738a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                m20740a(0L, false);
            } else {
                if (this.f32299i.getReady_rate() == 0) {
                    VideoDownloadListener videoDownloadListener3 = this.f32297g;
                    if (videoDownloadListener3 != null) {
                        videoDownloadListener3.mo20641a(this.f32303m);
                    }
                    VideoDownloadListener videoDownloadListener4 = this.f32298h;
                    if (videoDownloadListener4 != null) {
                        videoDownloadListener4.mo20641a(this.f32303m);
                    }
                }
                this.f32315y = new DownloadMessage(new Object(), str2, this.f32313w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                this.f32314x = MBDownloadManager.getInstance().download(this.f32315y).withReadTimeout(this.f32283E).withConnectTimeout(this.f32285G).withWriteTimeout(this.f32284F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f32304n).withDownloadStateListener(this.f32287I).withProgressStateListener(this.f32290L).with("do_us_fi_re", Boolean.toString(this.f32286H)).build();
            }
        } catch (Exception e2) {
            SameLogTool.m21736b("CampaignDownLoadTask", e2.getMessage());
        }
    }

    /* renamed from: q */
    private void m20685q() {
        if (this.f32311u == null) {
            this.f32311u = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        try {
            try {
                this.f32311u.m22658b(this.f32303m);
                if (!SameOptimizedController.m21727a().m21724a("r_d_v_b_l", true)) {
                    File file = new File(this.f32306p);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            } finally {
                this.f32295e = 0;
            }
        } catch (Throwable unused) {
            SameLogTool.m21733d("CampaignDownLoadTask", "del DB or file failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m20684r() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.reward.a.a");
            cls.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls.newInstance(), this.f32300j, this.f32299i);
            Class<?> cls2 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            cls2.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(cls2.newInstance(), this.f32300j, this.f32299i);
        } catch (Exception e) {
            SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
        }
    }

    /* renamed from: p */
    public final boolean m20686p() {
        if (SameOptimizedController.m21727a().m21724a("c_f_w_i_v", true)) {
            if (this.f32288J) {
                return this.f32288J;
            }
            try {
                this.f32288J = Objects.exists(new File(this.f32306p), this.f32304n, this.f32313w);
                return this.f32288J;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: d */
    public final String m20713d() {
        return this.f32306p;
    }

    /* renamed from: e */
    public final long m20710e() {
        return this.f32302l;
    }

    /* renamed from: f */
    public final int m20707f() {
        return this.f32295e;
    }

    /* renamed from: g */
    public final CampaignEx m20704g() {
        return this.f32299i;
    }

    /* renamed from: h */
    public final long m20702h() {
        return this.f32305o;
    }

    /* renamed from: i */
    public final void m20700i() {
        SameLogTool.m21733d("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.f32303m)) {
                return;
            }
            if (this.f32303m != null) {
                SameLogTool.m21733d("CampaignDownLoadTask", new URL(this.f32303m).getPath());
            }
            if (this.f32309s == 0 && this.f32282D == 2) {
                SameLogTool.m21733d("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            DownloadRequest downloadRequest = this.f32314x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            VideoDownloadListener videoDownloadListener = this.f32297g;
            if (videoDownloadListener != null) {
                videoDownloadListener.mo20640a("VideoUrl is not illegal, Please check it.", "");
            }
            VideoDownloadListener videoDownloadListener2 = this.f32298h;
            if (videoDownloadListener2 != null) {
                videoDownloadListener2.mo20640a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    /* renamed from: j */
    public final void m20698j() {
        try {
            this.f32279A = true;
            if (this.f32282D == 1) {
                SameLogTool.m21733d("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.f32282D);
                return;
            }
            SameLogTool.m21733d("CampaignDownLoadTask", "resume()");
            if (this.f32315y == null) {
                this.f32315y = new DownloadMessage(new Object(), this.f32303m, this.f32313w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            DownloadRequest build = MBDownloadManager.getInstance().download(this.f32315y).withReadTimeout(this.f32283E).withConnectTimeout(this.f32285G).withWriteTimeout(this.f32284F).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f32304n).withDownloadStateListener(this.f32287I).withProgressStateListener(this.f32290L).with("do_us_fi_re", Boolean.toString(this.f32286H)).build();
            this.f32314x = build;
            build.start();
            m20714c(m20706f(2));
        } catch (Exception e) {
            SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
        }
    }

    /* renamed from: k */
    public final String m20696k() {
        String str = "";
        if (this.f32292b == 3) {
            return "";
        }
        String str2 = this.f32304n + this.f32313w;
        File file = new File(str2);
        try {
            if (!Objects.exists(file, this.f32304n, this.f32313w)) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.f32306p = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.f32295e == 5 && !TextUtils.isEmpty(str)) {
            m20685q();
        }
        return str;
    }

    /* renamed from: l */
    public final void m20694l() {
        if (this.f32296f != null) {
            this.f32296f = null;
        }
    }

    /* renamed from: m */
    public final void m20692m() {
        CampaignEx campaignEx;
        try {
            try {
                m20685q();
                campaignEx = this.f32299i;
            } catch (Exception unused) {
                SameLogTool.m21733d("CampaignDownLoadTask", "del file is failed");
            }
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                VideoCampaignCache m20904a = VideoCampaignCache.m20904a();
                if (m20904a != null) {
                    m20904a.m20902a(this.f32299i);
                }
            }
        } finally {
            this.f32295e = 0;
        }
    }

    /* renamed from: n */
    public final String m20690n() {
        try {
            File file = new File(this.f32306p);
            if (Objects.exists(file, this.f32304n, this.f32313w) && file.isFile()) {
                return this.f32306p;
            }
        } catch (Exception e) {
            SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
        }
        return this.f32303m;
    }

    /* renamed from: o */
    public final boolean m20688o() {
        if (SameOptimizedController.m21727a().m21724a("c_f_w_i_v", true)) {
            return this.f32289K;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m20706f(int i) {
        if (this.f32299i == null || TextUtils.isEmpty(this.f32300j) || TextUtils.isEmpty(this.f32299i.getRequestId()) || TextUtils.isEmpty(this.f32299i.getVideoUrlEncode())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.f32300j + "&rid=" + this.f32299i.getRequestId() + "&rid_n=" + this.f32299i.getRequestIdNotice() + "&package_name=" + MBSDKContext.m22865f().m22869d() + "&app_id=" + MBSDKContext.m22865f().m22860k() + "&video_url=" + URLEncoder.encode(this.f32299i.getVideoUrlEncode()) + "&process_size=" + this.f32305o + "&file_size=" + this.f32302l + "&ready_rate=" + this.f32309s + "&cd_rate=" + this.f32293c + "&cid=" + this.f32299i.getId() + "&type=" + this.f32295e + "&video_download_status=" + i;
    }

    /* renamed from: c */
    public final long m20718c() {
        return this.f32308r;
    }

    /* renamed from: d */
    public final void m20712d(int i) {
        this.f32280B = i;
    }

    /* renamed from: e */
    public final void m20709e(int i) {
        this.f32282D = i;
    }

    /* renamed from: c */
    public final void m20717c(int i) {
        this.f32309s = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m20714c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(str);
                return;
            }
            ReportRequest reportRequest = new ReportRequest(MBSDKContext.m22865f().m22861j());
            CommonRequestParams m22062a = C11385e.m22062a(str, MBSDKContext.m22865f().m22861j(), this.f32300j);
            CampaignEx campaignEx = this.f32299i;
            if (campaignEx != null && campaignEx.getAdType() != 42) {
                m22062a.m22222a("r_stid", RewardSettingManager.m20835a().m20827b().m20850b());
            }
            reportRequest.m22227c(0, RequestUrlUtil.m22248a().f30791a, m22062a, null);
        } catch (Exception e) {
            SameLogTool.m21733d("CampaignDownLoadTask", e.getMessage());
        }
    }

    /* renamed from: b */
    public final void m20726b(int i) {
        this.f32293c = i;
    }

    /* renamed from: b */
    public final boolean m20727b() {
        return this.f32312v;
    }

    /* renamed from: b */
    public final void m20719b(boolean z) {
        this.f32307q = z;
    }

    /* renamed from: a */
    public final String m20745a() {
        return this.f32303m;
    }

    /* renamed from: b */
    public final void m20720b(String str) {
        m20684r();
        m20742a(2, str);
        this.f32295e = 4;
    }

    /* renamed from: a */
    public final void m20744a(int i) {
        this.f32292b = i;
    }

    /* renamed from: a */
    public final void m20728a(boolean z) {
        this.f32312v = z;
    }

    /* renamed from: a */
    public final void m20743a(int i, int i2) {
        this.f32295e = i;
        if (this.f32311u == null) {
            this.f32311u = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        this.f32311u.m22660a(this.f32303m, i2, i);
    }

    /* renamed from: b */
    public final void m20721b(VideoDownloadListener videoDownloadListener) {
        this.f32298h = videoDownloadListener;
    }

    /* renamed from: a */
    public final void m20739a(CampaignEx campaignEx) {
        this.f32299i = campaignEx;
    }

    /* renamed from: a */
    public final void m20740a(long j, boolean z) {
        VideoDao videoDao;
        SameLogTool.m21733d("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.f32305o + "  progressSize " + j + "  " + this.f32316z + "%   FileSize : " + this.f32302l + "  " + this.f32299i.getAppName());
        if (this.f32309s == 100 && this.f32292b != 3 && j != this.f32302l && !z) {
            File file = new File(this.f32306p);
            long length = Objects.exists(file, this.f32304n, this.f32313w) ? file.length() : 0L;
            SameLogTool.m21733d("CampaignDownLoadTask", "progressSize = " + j + " fileSize = " + this.f32302l + " " + z + " absFileSize = " + length);
            m20729a("File size is not match witch download size.");
            return;
        }
        this.f32295e = 5;
        m20742a(1, "");
        long j2 = this.f32302l;
        if (j2 != 0 && (videoDao = this.f32311u) != null) {
            videoDao.m22657b(this.f32303m, j2);
        }
        this.f32291a = false;
        m20741a(j, this.f32295e);
    }

    /* renamed from: a */
    public final void m20729a(String str) {
        VideoDownloadListener videoDownloadListener = this.f32297g;
        if (videoDownloadListener != null) {
            videoDownloadListener.mo20640a(str, this.f32303m);
        }
        VideoDownloadListener videoDownloadListener2 = this.f32298h;
        if (videoDownloadListener2 != null) {
            videoDownloadListener2.mo20640a(str, this.f32303m);
        }
        SameLogTool.m21733d("CampaignDownLoadTask", "Video download stop : " + str);
        CampaignEx campaignEx = this.f32299i;
        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.f32299i.getRsIgnoreCheckRule().size() > 0 && this.f32299i.getRsIgnoreCheckRule().contains(0)) {
            SameLogTool.m21736b("CampaignDownLoadTask", "Is not check video download status");
        } else if (this.f32295e == 4 || this.f32295e == 2 || this.f32295e == 5) {
        } else {
            this.f32295e = 4;
            m20741a(this.f32305o, this.f32295e);
        }
    }

    /* renamed from: a */
    public final void m20731a(DownLoadTaskSelfProgressListener downLoadTaskSelfProgressListener) {
        CopyOnWriteArrayList<DownLoadTaskSelfProgressListener> copyOnWriteArrayList = this.f32296f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(downLoadTaskSelfProgressListener);
        }
    }

    /* renamed from: a */
    public final void m20730a(VideoDownloadListener videoDownloadListener) {
        this.f32297g = videoDownloadListener;
    }

    /* renamed from: a */
    private void m20741a(long j, int i) {
        this.f32305o = j;
        int i2 = this.f32309s;
        if (100 * j >= i2 * this.f32302l && !this.f32310t && i != 4) {
            if (i2 == 100 && i != 5) {
                this.f32295e = 5;
                return;
            }
            this.f32310t = true;
            SameLogTool.m21733d("CampaignDownLoadTask", "UpdateListener : state: " + i + " progress : " + j);
            String m20696k = m20696k();
            if (TextUtils.isEmpty(m20696k)) {
                VideoDownloadListener videoDownloadListener = this.f32297g;
                if (videoDownloadListener != null) {
                    videoDownloadListener.mo20641a(this.f32303m);
                }
                VideoDownloadListener videoDownloadListener2 = this.f32298h;
                if (videoDownloadListener2 != null) {
                    videoDownloadListener2.mo20641a(this.f32303m);
                }
            } else {
                VideoDownloadListener videoDownloadListener3 = this.f32297g;
                if (videoDownloadListener3 != null) {
                    videoDownloadListener3.mo20640a("file is not effective " + m20696k, this.f32303m);
                }
                VideoDownloadListener videoDownloadListener4 = this.f32298h;
                if (videoDownloadListener4 != null) {
                    videoDownloadListener4.mo20640a("file is not effective " + m20696k, this.f32303m);
                }
            }
        }
        if (!this.f32291a && j > 0) {
            this.f32291a = true;
            if (this.f32311u == null) {
                this.f32311u = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            }
            this.f32311u.m22660a(this.f32303m, j, this.f32295e);
        }
        CopyOnWriteArrayList<DownLoadTaskSelfProgressListener> copyOnWriteArrayList = this.f32296f;
        if (copyOnWriteArrayList != null) {
            Iterator<DownLoadTaskSelfProgressListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                DownLoadTaskSelfProgressListener next = it.next();
                if (next != null) {
                    next.mo20642a(j, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m20742a(int i, String str) {
        VideoReportDataDao m22654a = VideoReportDataDao.m22654a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        VideoReportData videoReportData = new VideoReportData(this.f32301k, this.f32299i, i, Long.toString(this.f32308r != 0 ? System.currentTimeMillis() - this.f32308r : 0L), this.f32302l, this.f32280B);
        videoReportData.m22404n(this.f32299i.getId());
        videoReportData.m22427e(this.f32299i.getVideoUrlEncode());
        videoReportData.m22400p(str);
        videoReportData.m22410k(this.f32299i.getRequestId());
        videoReportData.m22408l(this.f32299i.getRequestIdNotice());
        videoReportData.m22406m(this.f32300j);
        m22654a.m22653a(videoReportData);
    }
}
