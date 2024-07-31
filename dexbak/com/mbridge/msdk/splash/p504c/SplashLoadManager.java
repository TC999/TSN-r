package com.mbridge.msdk.splash.p504c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.p485f.HttpUtils;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.DomainSameTool;
import com.mbridge.msdk.foundation.tools.DynamicViewResourceManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.splash.p501a.ViewRenderParam;
import com.mbridge.msdk.splash.p501a.p502a.SplashUtils;
import com.mbridge.msdk.splash.p503b.NativeViewRenderStatusListener;
import com.mbridge.msdk.splash.p503b.SplashLoadListener;
import com.mbridge.msdk.splash.p504c.NativeViewRenderManager;
import com.mbridge.msdk.splash.p504c.WebViewRenderManager;
import com.mbridge.msdk.splash.p507f.SplashLoadResponseHandler;
import com.mbridge.msdk.splash.p507f.SplashMBLoadRequest;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.nativeview.SplashImageLoadListener;
import com.mbridge.msdk.videocommon.download.DownLoadManager;
import com.mbridge.msdk.videocommon.listener.VideoDownloadListener;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.mbridge.msdk.splash.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashLoadManager {

    /* renamed from: a */
    private static String f31777a = "SplashLoadManager";

    /* renamed from: b */
    private String f31778b;

    /* renamed from: c */
    private String f31779c;

    /* renamed from: d */
    private long f31780d;

    /* renamed from: e */
    private long f31781e;

    /* renamed from: f */
    private SplashLoadListener f31782f;

    /* renamed from: h */
    private MBSplashView f31784h;

    /* renamed from: i */
    private UnitSetting f31785i;

    /* renamed from: j */
    private boolean f31786j;

    /* renamed from: k */
    private int f31787k;

    /* renamed from: l */
    private int f31788l;

    /* renamed from: m */
    private int f31789m;

    /* renamed from: n */
    private String f31790n;

    /* renamed from: o */
    private int f31791o;

    /* renamed from: p */
    private boolean f31792p;

    /* renamed from: q */
    private volatile boolean f31793q;

    /* renamed from: r */
    private VideoDownloadListener f31794r;

    /* renamed from: s */
    private H5DownLoadManager.ZipDownloadListener f31795s;

    /* renamed from: t */
    private String f31796t;

    /* renamed from: u */
    private int f31797u;

    /* renamed from: w */
    private int f31799w;

    /* renamed from: v */
    private String f31798v = "";

    /* renamed from: x */
    private Handler f31800x = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    SplashLoadManager.this.m21204a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i2);
                }
            } else if (i == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    SplashLoadManager.this.m21203a(obj2.toString(), SplashLoadManager.this.f31790n, SplashLoadManager.this.f31791o);
                }
            } else if (i != 3) {
            } else {
                Object obj3 = message.obj;
                if (obj3 instanceof CampaignEx) {
                    SplashLoadManager splashLoadManager = SplashLoadManager.this;
                    splashLoadManager.m21199b((CampaignEx) obj3, splashLoadManager.f31791o);
                }
            }
        }
    };

    /* renamed from: y */
    private Runnable f31801y = new Runnable() { // from class: com.mbridge.msdk.splash.c.c.2
        @Override // java.lang.Runnable
        public final void run() {
            SplashLoadManager splashLoadManager = SplashLoadManager.this;
            splashLoadManager.m21203a("load timeout", splashLoadManager.f31790n, SplashLoadManager.this.f31791o);
        }
    };

    /* renamed from: g */
    private Context f31783g = MBSDKContext.m22865f().m22861j();

    public SplashLoadManager(String str, String str2, long j) {
        this.f31779c = str;
        this.f31778b = str2;
        this.f31781e = j;
    }

    /* renamed from: d */
    private void m21191d() {
        this.f31800x.removeCallbacks(this.f31801y);
    }

    /* renamed from: d */
    private void m21190d(final CampaignEx campaignEx, final int i) {
        ResManager.m21232a(this.f31784h, campaignEx, new SplashImageLoadListener() { // from class: com.mbridge.msdk.splash.c.c.5
            @Override // com.mbridge.msdk.splash.view.nativeview.SplashImageLoadListener
            /* renamed from: a */
            public final void mo20943a() {
                if (campaignEx.isDynamicView() && SplashLoadManager.this.f31784h != null) {
                    SplashLoadManager.this.f31784h.setImageReady(true);
                    SplashLoadManager.m21197b(SplashLoadManager.this, campaignEx, i);
                }
                SplashLoadManager.this.m21199b(campaignEx, i);
            }

            @Override // com.mbridge.msdk.splash.view.nativeview.SplashImageLoadListener
            /* renamed from: b */
            public final void mo20942b() {
                if (!campaignEx.isDynamicView() || SplashLoadManager.this.f31784h == null) {
                    return;
                }
                SplashLoadManager.this.f31784h.setImageReady(false);
                SplashLoadManager splashLoadManager = SplashLoadManager.this;
                splashLoadManager.m21203a("Image resource load faile", splashLoadManager.f31790n, i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
        if (r2 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        if (r2 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
        if (r6.exists() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        if (r6.isFile() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
        if (r6.canRead() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cd, code lost:
        r9.setAdHtml(r6.getAbsolutePath());
        m21204a("file:////" + r6.getAbsolutePath(), r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
        m21203a("html file write failed", r8.f31790n, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m21188e(com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.p504c.SplashLoadManager.m21188e(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    /* renamed from: f */
    private void m21186f(final CampaignEx campaignEx, final int i) {
        if (campaignEx.isDynamicView()) {
            DynamicViewResourceManager.m21868a(campaignEx.getAdZip());
            return;
        }
        this.f31795s = new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.splash.c.c.6
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str, String str2) {
                SplashLoadManager splashLoadManager = SplashLoadManager.this;
                splashLoadManager.m21203a(str, splashLoadManager.f31790n, i);
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = str;
                SplashLoadManager.this.f31800x.sendMessage(obtain);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = campaignEx;
                obtain.arg1 = i;
                SplashLoadManager.this.f31800x.sendMessage(obtain);
            }
        };
        H5DownLoadManager.getInstance().downloadH5Res(campaignEx.getAdZip(), this.f31795s);
    }

    /* renamed from: g */
    private void m21184g(final CampaignEx campaignEx, int i) {
        this.f31794r = new VideoDownloadListener() { // from class: com.mbridge.msdk.splash.c.c.9
            @Override // com.mbridge.msdk.videocommon.listener.VideoDownloadListener
            /* renamed from: a */
            public final void mo20641a(String str) {
                SplashLoadManager.this.f31784h.setVideoReady(true);
                SameLogTool.m21738a(SplashLoadManager.f31777a, "========VIDEO SUC");
                Message obtain = Message.obtain();
                obtain.obj = campaignEx;
                obtain.what = 3;
                SplashLoadManager.this.f31800x.sendMessage(obtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.VideoDownloadListener
            /* renamed from: a */
            public final void mo20640a(String str, String str2) {
                SplashLoadManager.this.f31784h.setVideoReady(false);
                SameLogTool.m21738a(SplashLoadManager.f31777a, "========VIDEO FAI");
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                SplashLoadManager.this.f31800x.sendMessage(obtain);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        DownLoadManager.getInstance().createUnitCache(this.f31783g, this.f31778b, arrayList, 297, this.f31794r);
        if (!DownLoadManager.getInstance().m20680a(297, this.f31778b, campaignEx.isBidCampaign())) {
            DownLoadManager.getInstance().load(this.f31778b);
            return;
        }
        this.f31784h.setVideoReady(true);
        m21199b(campaignEx, i);
    }

    /* renamed from: b */
    public final void m21200b(int i) {
        this.f31799w = i;
    }

    /* renamed from: c */
    private void m21194c(CampaignEx campaignEx, int i) {
        this.f31784h.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            m21186f(campaignEx, i);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            m21188e(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            m21184g(campaignEx, i);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        m21190d(campaignEx, i);
    }

    /* renamed from: b */
    public final void m21201b() {
        if (this.f31782f != null) {
            this.f31782f = null;
        }
        if (this.f31794r != null) {
            this.f31794r = null;
        }
        if (this.f31795s != null) {
            this.f31795s = null;
        }
    }

    /* renamed from: a */
    public final void m21217a(UnitSetting unitSetting) {
        this.f31785i = unitSetting;
    }

    /* renamed from: a */
    public final void m21207a(MBSplashView mBSplashView) {
        this.f31784h = mBSplashView;
    }

    /* renamed from: a */
    public final void m21202a(boolean z) {
        this.f31786j = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m21199b(CampaignEx campaignEx, int i) {
        if (!ResManager.m21233a(this.f31784h, campaignEx) || this.f31793q) {
            return;
        }
        m21191d();
        if (this.f31792p) {
            ResManager.m21234a(campaignEx, this.f31778b);
        }
        this.f31793q = true;
        SplashLoadListener splashLoadListener = this.f31782f;
        if (splashLoadListener != null) {
            splashLoadListener.mo21112a(campaignEx, i);
        }
    }

    /* renamed from: a */
    public final void m21222a(int i) {
        this.f31787k = i;
    }

    /* renamed from: a */
    public final void m21221a(int i, int i2) {
        this.f31789m = i;
        this.f31788l = i2;
    }

    /* renamed from: a */
    public final String m21223a() {
        return this.f31798v;
    }

    /* renamed from: c */
    static /* synthetic */ void m21192c(SplashLoadManager splashLoadManager, CampaignEx campaignEx, int i) {
        if (splashLoadManager.f31784h.isH5Ready()) {
            return;
        }
        splashLoadManager.f31784h.setH5Ready(true);
        splashLoadManager.m21199b(campaignEx, i);
    }

    /* renamed from: a */
    public final void m21206a(String str, int i) {
        this.f31793q = false;
        this.f31790n = str;
        this.f31791o = i;
        CampaignEx m21228a = ResManager.m21228a(this.f31784h, this.f31779c, this.f31778b, str, this.f31786j, this.f31787k, false, false);
        long timestamp = m21228a != null ? m21228a.getTimestamp() : 0L;
        if (this.f31785i.m23183n() == 1 && i != 1 && m21228a != null) {
            m21216a(m21228a, i);
            return;
        }
        this.f31792p = true;
        if (i == 1) {
            List<Integer> m23178s = this.f31785i.m23178s();
            if (m23178s != null && m23178s.size() > 0) {
                this.f31780d = m23178s.get(0).intValue() * 1000;
            } else {
                this.f31780d = 30000L;
            }
        } else {
            long j = this.f31781e;
            if (j <= 0) {
                this.f31780d = this.f31785i.m23182o();
            } else {
                this.f31780d = j;
            }
        }
        if (this.f31785i != null && timestamp > 0 && TextUtils.isEmpty(str)) {
            if (System.currentTimeMillis() - timestamp > this.f31785i.m23173x() * 1000) {
                m21219a(this.f31780d);
                m21218a(this.f31783g, str, i);
                return;
            }
            m21216a(m21228a, i);
            return;
        }
        m21219a(this.f31780d);
        m21218a(this.f31783g, str, i);
    }

    /* renamed from: b */
    private void m21196b(String str, int i) {
        if (this.f31793q) {
            return;
        }
        m21191d();
        SameLogTool.m21733d(f31777a, "real failed ");
        this.f31793q = true;
        SplashLoadListener splashLoadListener = this.f31782f;
        if (splashLoadListener != null) {
            splashLoadListener.mo21109a(str, i);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m21197b(SplashLoadManager splashLoadManager, final CampaignEx campaignEx, final int i) {
        if (campaignEx.isDynamicView()) {
            ViewRenderParam.C11568a c11568a = new ViewRenderParam.C11568a();
            c11568a.m21261b(splashLoadManager.f31778b).m21265a(splashLoadManager.f31779c).m21264a(splashLoadManager.f31786j).m21267a(campaignEx).m21268a(splashLoadManager.f31787k).m21250h(splashLoadManager.f31799w);
            try {
                if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
                    Uri parse = Uri.parse(campaignEx.getAdZip());
                    String queryParameter = parse.getQueryParameter("hdbtn");
                    String queryParameter2 = parse.getQueryParameter("alecfc");
                    String queryParameter3 = parse.getQueryParameter("hdinfo");
                    String queryParameter4 = parse.getQueryParameter("shake_show");
                    String queryParameter5 = parse.getQueryParameter("shake_strength");
                    String queryParameter6 = parse.getQueryParameter("shake_time");
                    String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        c11568a.m21263b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        c11568a.m21260c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        c11568a.m21258d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        c11568a.m21256e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        c11568a.m21254f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        c11568a.m21252g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        c11568a.m21248i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(f31777a, th.getMessage());
            }
            NativeViewRenderManager.C11574a.m21237a().m21238a(splashLoadManager.f31784h, new ViewRenderParam(c11568a), new NativeViewRenderStatusListener() { // from class: com.mbridge.msdk.splash.c.c.7
                @Override // com.mbridge.msdk.splash.p503b.NativeViewRenderStatusListener
                /* renamed from: a */
                public final void mo21182a(View view) {
                    if (SplashLoadManager.this.f31784h != null) {
                        SplashLoadManager.this.f31784h.setDynamicView(true);
                        SplashLoadManager.this.f31784h.setSplashNativeView(view);
                        SplashLoadManager.this.m21199b(campaignEx, i);
                    }
                }

                @Override // com.mbridge.msdk.splash.p503b.NativeViewRenderStatusListener
                /* renamed from: a */
                public final void mo21181a(String str) {
                    SplashLoadManager splashLoadManager2 = SplashLoadManager.this;
                    splashLoadManager2.m21203a(str, splashLoadManager2.f31790n, i);
                }
            });
        }
    }

    /* renamed from: a */
    private void m21219a(long j) {
        this.f31800x.postDelayed(this.f31801y, j);
    }

    /* renamed from: a */
    private void m21218a(Context context, final String str, final int i) {
        try {
            if (context == null) {
                m21203a("Context is null", str, i);
            } else if (StringUtils.m21957a(this.f31778b)) {
                m21203a("UnitId is null", str, i);
            } else {
                SameLogTool.m21736b(f31777a, "load 开始准备请求参数");
                CommonRequestParams m21220a = m21220a(i, this.f31796t);
                if (m21220a == null) {
                    SameLogTool.m21736b(f31777a, "load 请求参数为空 load失败");
                    m21203a("Load param is null", str, i);
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    m21220a.m22222a(BidResponsed.KEY_TOKEN, str);
                }
                String m21979g = SameTool.m21979g(this.f31778b);
                if (!TextUtils.isEmpty(m21979g)) {
                    m21220a.m22222a("j", m21979g);
                }
                SplashMBLoadRequest splashMBLoadRequest = new SplashMBLoadRequest(context);
                SplashLoadResponseHandler splashLoadResponseHandler = new SplashLoadResponseHandler(i) { // from class: com.mbridge.msdk.splash.c.c.3
                    @Override // com.mbridge.msdk.splash.p507f.SplashLoadResponseHandler
                    /* renamed from: a */
                    public final void mo21054a(CampaignUnit campaignUnit, int i2) {
                        try {
                            SameLogTool.m21736b(SplashLoadManager.f31777a, "onLoadCompaginSuccess 数据刚请求回来");
                            SplashLoadManager splashLoadManager = SplashLoadManager.this;
                            SplashLoadManager.m21212a(splashLoadManager, campaignUnit, i2, splashLoadManager.f31778b, str);
                            SplashLoadManager.this.f31798v = campaignUnit.getRequestId();
                        } catch (Exception e) {
                            e.printStackTrace();
                            String str2 = SplashLoadManager.f31777a;
                            SameLogTool.m21736b(str2, "onLoadCompaginSuccess 数据刚请求失败： " + e.getMessage());
                            SplashLoadManager.this.m21203a("Exception after load success", str, i2);
                            SplashLoadManager.this.f31797u = 0;
                        }
                    }

                    @Override // com.mbridge.msdk.splash.p507f.SplashLoadResponseHandler
                    /* renamed from: a */
                    public final void mo21055a(int i2, String str2) {
                        SameLogTool.m21733d(SplashLoadManager.f31777a, str2);
                        String str3 = SplashLoadManager.f31777a;
                        SameLogTool.m21736b(str3, "onLoadCompaginFailed load failed errorCode:" + i2 + " msg:" + str2);
                        SplashLoadManager.this.m21203a(str2, str, i);
                        SplashLoadManager.this.f31797u = 0;
                    }
                };
                splashLoadResponseHandler.m21049a(str);
                splashLoadResponseHandler.f30757d = this.f31778b;
                splashLoadResponseHandler.f30758e = this.f31779c;
                splashLoadResponseHandler.f30759f = 297;
                splashMBLoadRequest.m22236a(1, m21220a, splashLoadResponseHandler, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            m21203a("Load exception", str, i);
            this.f31797u = 0;
        }
    }

    /* renamed from: a */
    private CommonRequestParams m21220a(int i, String str) {
        String m22860k = MBSDKContext.m22865f().m22860k();
        String md5 = SameMD5.getMD5(MBSDKContext.m22865f().m22860k() + MBSDKContext.m22865f().m22859l());
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        String m22374a = StaticDataPoll.m22374a(this.f31778b, MediationConstant.RIT_TYPE_SPLASH);
        String m21295a = SplashUtils.m21295a(this.f31783g, this.f31778b);
        String m22000b = SameTool.m22000b(this.f31783g, this.f31778b);
        String m21297a = SplashUtils.m21297a();
        HttpUtils.m22258a(commonRequestParams, "app_id", m22860k);
        HttpUtils.m22258a(commonRequestParams, MBridgeConstans.PROPERTIES_UNIT_ID, this.f31778b);
        if (!TextUtils.isEmpty(this.f31779c)) {
            HttpUtils.m22258a(commonRequestParams, MBridgeConstans.PLACEMENT_ID, this.f31779c);
        }
        HttpUtils.m22258a(commonRequestParams, "sign", md5);
        HttpUtils.m22258a(commonRequestParams, "req_type", i + "");
        HttpUtils.m22258a(commonRequestParams, "ad_num", "1");
        HttpUtils.m22258a(commonRequestParams, "tnum", "1");
        HttpUtils.m22258a(commonRequestParams, "only_impression", "1");
        HttpUtils.m22258a(commonRequestParams, "ping_mode", "1");
        HttpUtils.m22258a(commonRequestParams, "ttc_ids", m21295a);
        HttpUtils.m22258a(commonRequestParams, CommonRequestParams.f30822b, m22374a);
        HttpUtils.m22258a(commonRequestParams, CommonRequestParams.f30823c, m22000b);
        HttpUtils.m22258a(commonRequestParams, "install_ids", m21297a);
        HttpUtils.m22258a(commonRequestParams, CommonRequestParams.f30821a, str);
        HttpUtils.m22258a(commonRequestParams, "ad_type", "297");
        HttpUtils.m22258a(commonRequestParams, IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, this.f31797u + "");
        HttpUtils.m22258a(commonRequestParams, "unit_size", this.f31789m + "x" + this.f31788l);
        return commonRequestParams;
    }

    /* renamed from: a */
    public final void m21215a(SplashLoadListener splashLoadListener) {
        this.f31782f = splashLoadListener;
    }

    /* renamed from: a */
    private void m21216a(CampaignEx campaignEx, int i) {
        MBSplashView mBSplashView = this.f31784h;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            m21190d(campaignEx, i);
        }
        if (ResManager.m21233a(this.f31784h, campaignEx)) {
            m21199b(campaignEx, i);
        } else {
            m21194c(campaignEx, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21203a(String str, String str2, int i) {
        if (this.f31792p) {
            this.f31792p = false;
            m21205a(str, i, str2);
            return;
        }
        m21196b(str, i);
    }

    /* renamed from: a */
    private void m21205a(String str, int i, String str2) {
        CampaignEx m21228a = ResManager.m21228a(this.f31784h, this.f31779c, this.f31778b, str2, this.f31786j, this.f31787k, true, false);
        if (m21228a != null) {
            SameLogTool.m21733d(f31777a, "load failed cache ");
            m21216a(m21228a, i);
            return;
        }
        m21196b(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m21204a(String str, final CampaignEx campaignEx, final int i) {
        WebViewRenderManager.C11597c c11597c = new WebViewRenderManager.C11597c();
        c11597c.m21124c(this.f31778b);
        c11597c.m21126b(this.f31779c);
        c11597c.m21130a(campaignEx);
        c11597c.m21129a(str);
        c11597c.m21128a(this.f31786j);
        c11597c.m21131a(this.f31787k);
        WebViewRenderManager.C11595a.m21136a().m21141a(this.f31784h, c11597c, new WebViewRenderManager.InterfaceC11596b() { // from class: com.mbridge.msdk.splash.c.c.8
            @Override // com.mbridge.msdk.splash.p504c.WebViewRenderManager.InterfaceC11596b
            /* renamed from: a */
            public final void mo21135a() {
                if (campaignEx.isHasMBTplMark()) {
                    return;
                }
                SplashLoadManager.m21192c(SplashLoadManager.this, campaignEx, i);
            }

            @Override // com.mbridge.msdk.splash.p504c.WebViewRenderManager.InterfaceC11596b
            /* renamed from: a */
            public final void mo21133a(String str2) {
                SplashLoadManager.m21210a(SplashLoadManager.this, str2, i);
            }

            @Override // com.mbridge.msdk.splash.p504c.WebViewRenderManager.InterfaceC11596b
            /* renamed from: a */
            public final void mo21134a(int i2) {
                if (i2 == 1) {
                    SplashLoadManager.m21192c(SplashLoadManager.this, campaignEx, i);
                } else {
                    SplashLoadManager.m21210a(SplashLoadManager.this, "readyState 2", i);
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m21212a(SplashLoadManager splashLoadManager, CampaignUnit campaignUnit, int i, String str, String str2) {
        ArrayList arrayList;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            final CampaignEx campaignEx = campaignUnit.getAds().get(0);
            campaignEx.setCampaignUnitId(splashLoadManager.f31778b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(SplashLoadManager.this.f31783g)).m22700b();
                    DomainSameTool.m21872a(SplashLoadManager.this.f31783g, campaignEx);
                }
            }).start();
            splashLoadManager.f31796t = campaignUnit.getSessionId();
            if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
                if (SameTool.m21999b(campaignEx)) {
                    campaignEx.setRtinsType(SameTool.m21992c(splashLoadManager.f31783g, campaignEx.getPackageName()) ? 1 : 2);
                }
                if (campaignEx.getWtick() != 1 && SameTool.m21992c(splashLoadManager.f31783g, campaignEx.getPackageName())) {
                    if (SameTool.m21999b(campaignEx)) {
                        arrayList.add(campaignEx);
                    } else {
                        SameTool.m22009a(splashLoadManager.f31778b, campaignEx, CommonConst.f30563D);
                    }
                } else {
                    arrayList.add(campaignEx);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            try {
                int i2 = splashLoadManager.f31797u + 1;
                splashLoadManager.f31797u = i2;
                UnitSetting unitSetting = splashLoadManager.f31785i;
                if (unitSetting == null || i2 > unitSetting.m23175v()) {
                    SameLogTool.m21736b(f31777a, "onload 重置offset为0");
                    splashLoadManager.f31797u = 0;
                }
                String str3 = f31777a;
                SameLogTool.m21736b(str3, "onload 算出 下次的offset是:" + splashLoadManager.f31797u);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str4 = f31777a;
            SameLogTool.m21736b(str4, "onload load成功 size:" + arrayList.size());
            CampaignEx campaignEx2 = (CampaignEx) arrayList.get(0);
            if (TextUtils.isEmpty(campaignEx2.getAdZip()) && (TextUtils.isEmpty(campaignEx2.getAdHtml()) || !campaignEx2.getAdHtml().contains("<MBTPLMARK>"))) {
                campaignEx2.setHasMBTplMark(false);
                campaignEx2.setIsMraid(true);
            } else {
                campaignEx2.setHasMBTplMark(true);
                campaignEx2.setIsMraid(false);
            }
            splashLoadManager.m21216a(campaignEx2, i);
            return;
        }
        SameLogTool.m21736b(f31777a, "onload load失败 返回的compaign没有可以用的");
        splashLoadManager.m21203a("invalid  campaign", str2, i);
    }

    /* renamed from: a */
    static /* synthetic */ void m21210a(SplashLoadManager splashLoadManager, String str, int i) {
        splashLoadManager.m21203a(str, splashLoadManager.f31790n, i);
    }
}
