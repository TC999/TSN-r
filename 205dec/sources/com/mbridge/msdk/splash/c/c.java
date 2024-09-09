package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.i;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.splash.a.c;
import com.mbridge.msdk.splash.c.a;
import com.mbridge.msdk.splash.c.e;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SplashLoadManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f40549a = "SplashLoadManager";

    /* renamed from: b  reason: collision with root package name */
    private String f40550b;

    /* renamed from: c  reason: collision with root package name */
    private String f40551c;

    /* renamed from: d  reason: collision with root package name */
    private long f40552d;

    /* renamed from: e  reason: collision with root package name */
    private long f40553e;

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.splash.b.b f40554f;

    /* renamed from: h  reason: collision with root package name */
    private MBSplashView f40556h;

    /* renamed from: i  reason: collision with root package name */
    private com.mbridge.msdk.c.d f40557i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f40558j;

    /* renamed from: k  reason: collision with root package name */
    private int f40559k;

    /* renamed from: l  reason: collision with root package name */
    private int f40560l;

    /* renamed from: m  reason: collision with root package name */
    private int f40561m;

    /* renamed from: n  reason: collision with root package name */
    private String f40562n;

    /* renamed from: o  reason: collision with root package name */
    private int f40563o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f40564p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f40565q;

    /* renamed from: r  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f40566r;

    /* renamed from: s  reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f40567s;

    /* renamed from: t  reason: collision with root package name */
    private String f40568t;

    /* renamed from: u  reason: collision with root package name */
    private int f40569u;

    /* renamed from: w  reason: collision with root package name */
    private int f40571w;

    /* renamed from: v  reason: collision with root package name */
    private String f40570v = "";

    /* renamed from: x  reason: collision with root package name */
    private Handler f40572x = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 == 1) {
                Object obj = message.obj;
                int i5 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    c.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i5);
                }
            } else if (i4 == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    c.this.a(obj2.toString(), c.this.f40562n, c.this.f40563o);
                }
            } else if (i4 != 3) {
            } else {
                Object obj3 = message.obj;
                if (obj3 instanceof CampaignEx) {
                    c cVar = c.this;
                    cVar.b((CampaignEx) obj3, cVar.f40563o);
                }
            }
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private Runnable f40573y = new Runnable() { // from class: com.mbridge.msdk.splash.c.c.2
        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            cVar.a("load timeout", cVar.f40562n, c.this.f40563o);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private Context f40555g = com.mbridge.msdk.foundation.controller.a.f().j();

    public c(String str, String str2, long j4) {
        this.f40551c = str;
        this.f40550b = str2;
        this.f40553e = j4;
    }

    private void d() {
        this.f40572x.removeCallbacks(this.f40573y);
    }

    private void d(final CampaignEx campaignEx, final int i4) {
        b.a(this.f40556h, campaignEx, new com.mbridge.msdk.splash.view.nativeview.a() { // from class: com.mbridge.msdk.splash.c.c.5
            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void a() {
                if (campaignEx.isDynamicView() && c.this.f40556h != null) {
                    c.this.f40556h.setImageReady(true);
                    c.b(c.this, campaignEx, i4);
                }
                c.this.b(campaignEx, i4);
            }

            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void b() {
                if (!campaignEx.isDynamicView() || c.this.f40556h == null) {
                    return;
                }
                c.this.f40556h.setImageReady(false);
                c cVar = c.this;
                cVar.a("Image resource load faile", cVar.f40562n, i4);
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
        a("file:////" + r6.getAbsolutePath(), r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
        a("html file write failed", r8.f40562n, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.c.c.e(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    private void f(final CampaignEx campaignEx, final int i4) {
        if (campaignEx.isDynamicView()) {
            i.a(campaignEx.getAdZip());
            return;
        }
        this.f40567s = new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.splash.c.c.6
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str, String str2) {
                c cVar = c.this;
                cVar.a(str, cVar.f40562n, i4);
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = str;
                c.this.f40572x.sendMessage(obtain);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = campaignEx;
                obtain.arg1 = i4;
                c.this.f40572x.sendMessage(obtain);
            }
        };
        H5DownLoadManager.getInstance().downloadH5Res(campaignEx.getAdZip(), this.f40567s);
    }

    private void g(final CampaignEx campaignEx, int i4) {
        this.f40566r = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.c.9
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str) {
                c.this.f40556h.setVideoReady(true);
                x.a(c.f40549a, "========VIDEO SUC");
                Message obtain = Message.obtain();
                obtain.obj = campaignEx;
                obtain.what = 3;
                c.this.f40572x.sendMessage(obtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str, String str2) {
                c.this.f40556h.setVideoReady(false);
                x.a(c.f40549a, "========VIDEO FAI");
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                c.this.f40572x.sendMessage(obtain);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f40555g, this.f40550b, arrayList, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, this.f40566r);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().a(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, this.f40550b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f40550b);
            return;
        }
        this.f40556h.setVideoReady(true);
        b(campaignEx, i4);
    }

    public final void b(int i4) {
        this.f40571w = i4;
    }

    private void c(CampaignEx campaignEx, int i4) {
        this.f40556h.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            f(campaignEx, i4);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            e(campaignEx, i4);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            g(campaignEx, i4);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        d(campaignEx, i4);
    }

    public final void b() {
        if (this.f40554f != null) {
            this.f40554f = null;
        }
        if (this.f40566r != null) {
            this.f40566r = null;
        }
        if (this.f40567s != null) {
            this.f40567s = null;
        }
    }

    public final void a(com.mbridge.msdk.c.d dVar) {
        this.f40557i = dVar;
    }

    public final void a(MBSplashView mBSplashView) {
        this.f40556h = mBSplashView;
    }

    public final void a(boolean z3) {
        this.f40558j = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i4) {
        if (!b.a(this.f40556h, campaignEx) || this.f40565q) {
            return;
        }
        d();
        if (this.f40564p) {
            b.a(campaignEx, this.f40550b);
        }
        this.f40565q = true;
        com.mbridge.msdk.splash.b.b bVar = this.f40554f;
        if (bVar != null) {
            bVar.a(campaignEx, i4);
        }
    }

    public final void a(int i4) {
        this.f40559k = i4;
    }

    public final void a(int i4, int i5) {
        this.f40561m = i4;
        this.f40560l = i5;
    }

    public final String a() {
        return this.f40570v;
    }

    static /* synthetic */ void c(c cVar, CampaignEx campaignEx, int i4) {
        if (cVar.f40556h.isH5Ready()) {
            return;
        }
        cVar.f40556h.setH5Ready(true);
        cVar.b(campaignEx, i4);
    }

    public final void a(String str, int i4) {
        this.f40565q = false;
        this.f40562n = str;
        this.f40563o = i4;
        CampaignEx a4 = b.a(this.f40556h, this.f40551c, this.f40550b, str, this.f40558j, this.f40559k, false, false);
        long timestamp = a4 != null ? a4.getTimestamp() : 0L;
        if (this.f40557i.n() == 1 && i4 != 1 && a4 != null) {
            a(a4, i4);
            return;
        }
        this.f40564p = true;
        if (i4 == 1) {
            List<Integer> s3 = this.f40557i.s();
            if (s3 != null && s3.size() > 0) {
                this.f40552d = s3.get(0).intValue() * 1000;
            } else {
                this.f40552d = PolicyConfig.mServerBusyRetryBaseInternal;
            }
        } else {
            long j4 = this.f40553e;
            if (j4 <= 0) {
                this.f40552d = this.f40557i.o();
            } else {
                this.f40552d = j4;
            }
        }
        if (this.f40557i != null && timestamp > 0 && TextUtils.isEmpty(str)) {
            if (System.currentTimeMillis() - timestamp > this.f40557i.x() * 1000) {
                a(this.f40552d);
                a(this.f40555g, str, i4);
                return;
            }
            a(a4, i4);
            return;
        }
        a(this.f40552d);
        a(this.f40555g, str, i4);
    }

    private void b(String str, int i4) {
        if (this.f40565q) {
            return;
        }
        d();
        x.d(f40549a, "real failed ");
        this.f40565q = true;
        com.mbridge.msdk.splash.b.b bVar = this.f40554f;
        if (bVar != null) {
            bVar.a(str, i4);
        }
    }

    static /* synthetic */ void b(c cVar, final CampaignEx campaignEx, final int i4) {
        if (campaignEx.isDynamicView()) {
            c.a aVar = new c.a();
            aVar.b(cVar.f40550b).a(cVar.f40551c).a(cVar.f40558j).a(campaignEx).a(cVar.f40559k).h(cVar.f40571w);
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
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                x.d(f40549a, th.getMessage());
            }
            a.C0762a.a().a(cVar.f40556h, new com.mbridge.msdk.splash.a.c(aVar), new com.mbridge.msdk.splash.b.a() { // from class: com.mbridge.msdk.splash.c.c.7
                @Override // com.mbridge.msdk.splash.b.a
                public final void a(View view) {
                    if (c.this.f40556h != null) {
                        c.this.f40556h.setDynamicView(true);
                        c.this.f40556h.setSplashNativeView(view);
                        c.this.b(campaignEx, i4);
                    }
                }

                @Override // com.mbridge.msdk.splash.b.a
                public final void a(String str) {
                    c cVar2 = c.this;
                    cVar2.a(str, cVar2.f40562n, i4);
                }
            });
        }
    }

    private void a(long j4) {
        this.f40572x.postDelayed(this.f40573y, j4);
    }

    private void a(Context context, final String str, final int i4) {
        try {
            if (context == null) {
                a("Context is null", str, i4);
            } else if (ag.a(this.f40550b)) {
                a("UnitId is null", str, i4);
            } else {
                x.b(f40549a, "load \u5f00\u59cb\u51c6\u5907\u8bf7\u6c42\u53c2\u6570");
                com.mbridge.msdk.foundation.same.net.g.d a4 = a(i4, this.f40568t);
                if (a4 == null) {
                    x.b(f40549a, "load \u8bf7\u6c42\u53c2\u6570\u4e3a\u7a7a load\u5931\u8d25");
                    a("Load param is null", str, i4);
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    a4.a("token", str);
                }
                String g4 = ac.g(this.f40550b);
                if (!TextUtils.isEmpty(g4)) {
                    a4.a("j", g4);
                }
                com.mbridge.msdk.splash.f.b bVar = new com.mbridge.msdk.splash.f.b(context);
                com.mbridge.msdk.splash.f.a aVar = new com.mbridge.msdk.splash.f.a(i4) { // from class: com.mbridge.msdk.splash.c.c.3
                    @Override // com.mbridge.msdk.splash.f.a
                    public final void a(CampaignUnit campaignUnit, int i5) {
                        try {
                            x.b(c.f40549a, "onLoadCompaginSuccess \u6570\u636e\u521a\u8bf7\u6c42\u56de\u6765");
                            c cVar = c.this;
                            c.a(cVar, campaignUnit, i5, cVar.f40550b, str);
                            c.this.f40570v = campaignUnit.getRequestId();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            String str2 = c.f40549a;
                            x.b(str2, "onLoadCompaginSuccess \u6570\u636e\u521a\u8bf7\u6c42\u5931\u8d25\uff1a " + e4.getMessage());
                            c.this.a("Exception after load success", str, i5);
                            c.this.f40569u = 0;
                        }
                    }

                    @Override // com.mbridge.msdk.splash.f.a
                    public final void a(int i5, String str2) {
                        x.d(c.f40549a, str2);
                        String str3 = c.f40549a;
                        x.b(str3, "onLoadCompaginFailed load failed errorCode:" + i5 + " msg:" + str2);
                        c.this.a(str2, str, i4);
                        c.this.f40569u = 0;
                    }
                };
                aVar.a(str);
                aVar.f39551d = this.f40550b;
                aVar.f39552e = this.f40551c;
                aVar.f39553f = MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT;
                bVar.a(1, a4, aVar, str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            a("Load exception", str, i4);
            this.f40569u = 0;
        }
    }

    private com.mbridge.msdk.foundation.same.net.g.d a(int i4, String str) {
        String k4 = com.mbridge.msdk.foundation.controller.a.f().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.a.f().k() + com.mbridge.msdk.foundation.controller.a.f().l());
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        String a4 = com.mbridge.msdk.foundation.same.a.d.a(this.f40550b, "splash");
        String a5 = com.mbridge.msdk.splash.a.a.a.a(this.f40555g, this.f40550b);
        String b4 = ac.b(this.f40555g, this.f40550b);
        String a6 = com.mbridge.msdk.splash.a.a.a.a();
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "app_id", k4);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f40550b);
        if (!TextUtils.isEmpty(this.f40551c)) {
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.f40551c);
        }
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "req_type", i4 + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_num", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "tnum", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ttc_ids", a5);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f39595b, a4);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f39596c, b4);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "install_ids", a6);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f39594a, str);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_type", MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "offset", this.f40569u + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "unit_size", this.f40561m + "x" + this.f40560l);
        return dVar;
    }

    public final void a(com.mbridge.msdk.splash.b.b bVar) {
        this.f40554f = bVar;
    }

    private void a(CampaignEx campaignEx, int i4) {
        MBSplashView mBSplashView = this.f40556h;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            d(campaignEx, i4);
        }
        if (b.a(this.f40556h, campaignEx)) {
            b(campaignEx, i4);
        } else {
            c(campaignEx, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i4) {
        if (this.f40564p) {
            this.f40564p = false;
            a(str, i4, str2);
            return;
        }
        b(str, i4);
    }

    private void a(String str, int i4, String str2) {
        CampaignEx a4 = b.a(this.f40556h, this.f40551c, this.f40550b, str2, this.f40558j, this.f40559k, true, false);
        if (a4 != null) {
            x.d(f40549a, "load failed cache ");
            a(a4, i4);
            return;
        }
        b(str, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final CampaignEx campaignEx, final int i4) {
        e.c cVar = new e.c();
        cVar.c(this.f40550b);
        cVar.b(this.f40551c);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(this.f40558j);
        cVar.a(this.f40559k);
        e.a.a().a(this.f40556h, cVar, new e.b() { // from class: com.mbridge.msdk.splash.c.c.8
            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a() {
                if (campaignEx.isHasMBTplMark()) {
                    return;
                }
                c.c(c.this, campaignEx, i4);
            }

            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a(String str2) {
                c.a(c.this, str2, i4);
            }

            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a(int i5) {
                if (i5 == 1) {
                    c.c(c.this, campaignEx, i4);
                } else {
                    c.a(c.this, "readyState 2", i4);
                }
            }
        });
    }

    static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit, int i4, String str, String str2) {
        ArrayList arrayList;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            final CampaignEx campaignEx = campaignUnit.getAds().get(0);
            campaignEx.setCampaignUnitId(cVar.f40550b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    l.a(com.mbridge.msdk.foundation.db.i.a(c.this.f40555g)).b();
                    h.a(c.this.f40555g, campaignEx);
                }
            }).start();
            cVar.f40568t = campaignUnit.getSessionId();
            if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
                if (ac.b(campaignEx)) {
                    campaignEx.setRtinsType(ac.c(cVar.f40555g, campaignEx.getPackageName()) ? 1 : 2);
                }
                if (campaignEx.getWtick() != 1 && ac.c(cVar.f40555g, campaignEx.getPackageName())) {
                    if (ac.b(campaignEx)) {
                        arrayList.add(campaignEx);
                    } else {
                        ac.a(cVar.f40550b, campaignEx, com.mbridge.msdk.foundation.same.a.D);
                    }
                } else {
                    arrayList.add(campaignEx);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            try {
                int i5 = cVar.f40569u + 1;
                cVar.f40569u = i5;
                com.mbridge.msdk.c.d dVar = cVar.f40557i;
                if (dVar == null || i5 > dVar.v()) {
                    x.b(f40549a, "onload \u91cd\u7f6eoffset\u4e3a0");
                    cVar.f40569u = 0;
                }
                String str3 = f40549a;
                x.b(str3, "onload \u7b97\u51fa \u4e0b\u6b21\u7684offset\u662f:" + cVar.f40569u);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String str4 = f40549a;
            x.b(str4, "onload load\u6210\u529f size:" + arrayList.size());
            CampaignEx campaignEx2 = (CampaignEx) arrayList.get(0);
            if (TextUtils.isEmpty(campaignEx2.getAdZip()) && (TextUtils.isEmpty(campaignEx2.getAdHtml()) || !campaignEx2.getAdHtml().contains("<MBTPLMARK>"))) {
                campaignEx2.setHasMBTplMark(false);
                campaignEx2.setIsMraid(true);
            } else {
                campaignEx2.setHasMBTplMark(true);
                campaignEx2.setIsMraid(false);
            }
            cVar.a(campaignEx2, i4);
            return;
        }
        x.b(f40549a, "onload load\u5931\u8d25 \u8fd4\u56de\u7684compaign\u6ca1\u6709\u53ef\u4ee5\u7528\u7684");
        cVar.a("invalid  campaign", str2, i4);
    }

    static /* synthetic */ void a(c cVar, String str, int i4) {
        cVar.a(str, cVar.f40562n, i4);
    }
}
