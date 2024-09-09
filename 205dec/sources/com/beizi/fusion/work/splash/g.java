package com.beizi.fusion.work.splash;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GmSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g extends com.beizi.fusion.work.a {
    private boolean A;
    private TTSplashAd.AdInteractionListener B;
    private boolean C;
    private int D;
    private int E;
    private long F;

    /* renamed from: n  reason: collision with root package name */
    private Context f16091n;

    /* renamed from: o  reason: collision with root package name */
    private String f16092o;

    /* renamed from: p  reason: collision with root package name */
    private long f16093p;

    /* renamed from: q  reason: collision with root package name */
    private View f16094q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16095r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f16096s;

    /* renamed from: t  reason: collision with root package name */
    private TTAdNative f16097t;

    /* renamed from: u  reason: collision with root package name */
    private TTSplashAd f16098u;

    /* renamed from: v  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16099v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16100w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16101x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private float f16102y;

    /* renamed from: z  reason: collision with root package name */
    private float f16103z;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GmSplashWorker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements TTSplashAd.AdInteractionListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f16107b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16108c;

        private a() {
            this.f16107b = false;
            this.f16108c = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i4) {
            Log.d("BeiZis", "onAdClicked");
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) g.this).f15367d.d(g.this.g());
                ((com.beizi.fusion.work.a) g.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) g.this).f15375l + 5000) - System.currentTimeMillis());
            }
            if (this.f16108c) {
                return;
            }
            this.f16108c = true;
            g.this.ai();
            g.this.E();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i4) {
            Log.d("BeiZis", "GmSplashWorker.onAdShow");
            ((com.beizi.fusion.work.a) g.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (this.f16107b) {
                return;
            }
            this.f16107b = true;
            g.this.ab();
            g.this.C();
            g.this.D();
            g.this.ah();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            Log.d("BeiZis", "onAdSkip");
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                g.this.ac();
            }
            g.this.H();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            Log.d("BeiZis", "onAdTimeOver");
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                g.this.ac();
            }
            g.this.H();
        }
    }

    public g(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i4, int i5, com.beizi.fusion.d.e eVar) {
        this.f16091n = context;
        this.f16092o = str;
        this.f16093p = j4;
        this.f16094q = view;
        this.f16095r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16096s = new SplashContainer(context);
        this.f16099v = list;
        this.D = i4;
        this.E = i5;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", " GmSplashWorker.load():" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            ad();
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void aH() {
        try {
            Log.d("BeiZis", "GmSplashWorker.finalShowAd()");
            TTSplashAd tTSplashAd = this.f16098u;
            if (tTSplashAd != null) {
                View splashView = tTSplashAd.getSplashView();
                this.f16095r.removeAllViews();
                this.f16095r.addView(splashView);
            } else {
                aw();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        b();
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        TTSplashAd tTSplashAd = this.f16098u;
        if (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f16098u.getMediationManager().getShowEcpm() == null || this.f16098u.getMediationManager().getShowEcpm().getEcpm() == null || this.C) {
            return;
        }
        this.C = true;
        af.a("BeiZis", "channel == GroMore\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f16098u.getMediationManager().getShowEcpm().getEcpm());
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GM;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.c(10151);
                        }
                    }, 10L);
                    af.a("BeiZis", "groMore sdk not import , will do nothing");
                    return;
                }
                u();
                af.a("BeiZis", "requestAd() appId\uff1a" + this.f15371h + "  spaceId\uff1a" + this.f15372i);
                u.b(this, this.f16091n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.x(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
        this.F = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            this.F = Math.max(this.F, this.f15369f.getHotRequestDelay());
        }
        this.f16102y = av.l(this.f16091n);
        this.f16103z = av.m(this.f16091n);
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", "GmSplashWorker.showAd()");
        aH();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        TTSplashAd tTSplashAd = this.f16098u;
        return (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f16098u.getMediationManager().getShowEcpm() == null || this.f16098u.getMediationManager().getShowEcpm().getEcpm() == null) ? "" : this.f16098u.getMediationManager().getShowEcpm().getEcpm();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void l() {
        /*
            r7 = this;
            r7.w()
            r7.ag()
            android.content.Context r0 = r7.f16091n
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = 0
            int r3 = r7.D     // Catch: java.lang.Exception -> L3c
            if (r3 != 0) goto L17
            float r0 = com.beizi.fusion.g.av.j(r0)     // Catch: java.lang.Exception -> L3c
            int r0 = (int) r0     // Catch: java.lang.Exception -> L3c
            r7.D = r0     // Catch: java.lang.Exception -> L3c
        L17:
            int r0 = r7.E     // Catch: java.lang.Exception -> L3c
            if (r0 != 0) goto L24
            android.content.Context r0 = r7.f16091n     // Catch: java.lang.Exception -> L3c
            float r0 = com.beizi.fusion.g.av.k(r0)     // Catch: java.lang.Exception -> L3c
            int r0 = (int) r0     // Catch: java.lang.Exception -> L3c
            r7.E = r0     // Catch: java.lang.Exception -> L3c
        L24:
            android.content.Context r0 = r7.f16091n     // Catch: java.lang.Exception -> L3c
            int r3 = r7.E     // Catch: java.lang.Exception -> L3c
            float r3 = (float) r3     // Catch: java.lang.Exception -> L3c
            int r0 = com.beizi.fusion.g.av.a(r0, r3)     // Catch: java.lang.Exception -> L3c
            android.content.Context r3 = r7.f16091n     // Catch: java.lang.Exception -> L37
            int r4 = r7.D     // Catch: java.lang.Exception -> L37
            float r4 = (float) r4     // Catch: java.lang.Exception -> L37
            int r2 = com.beizi.fusion.g.av.a(r3, r4)     // Catch: java.lang.Exception -> L37
            goto L42
        L37:
            r3 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L3e
        L3c:
            r0 = move-exception
            r3 = 0
        L3e:
            r0.printStackTrace()
            r0 = r3
        L42:
            com.beizi.fusion.work.splash.g$a r3 = new com.beizi.fusion.work.splash.g$a
            r4 = 0
            r3.<init>()
            r7.B = r3
            com.beizi.fusion.work.splash.g$2 r3 = new com.beizi.fusion.work.splash.g$2
            r3.<init>()
            java.lang.String r4 = r7.f15372i
            if (r4 != 0) goto L54
            return
        L54:
            com.bytedance.sdk.openadsdk.TTAdManager r4 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            com.bytedance.sdk.openadsdk.TTAdNative r1 = r4.createAdNative(r1)
            r7.f16097t = r1
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$Builder r1 = new com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$Builder
            r1.<init>()
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot r1 = r1.build()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r4 = new com.bytedance.sdk.openadsdk.AdSlot$Builder
            r4.<init>()
            java.lang.String r5 = r7.f15372i
            com.bytedance.sdk.openadsdk.AdSlot$Builder r4 = r4.setCodeId(r5)
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r4.setImageAcceptedSize(r2, r0)
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setMediationAdSlot(r1)
            com.bytedance.sdk.openadsdk.AdSlot r0 = r0.build()
            com.bytedance.sdk.openadsdk.TTAdNative r1 = r7.f16097t     // Catch: java.lang.Exception -> L84
            r1.loadSplashAd(r0, r3)     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r0 = move-exception
            r0.printStackTrace()
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.g.l():void");
    }

    public void b() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.F);
        long j4 = this.F;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void a(Message message) {
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.i(String.valueOf(message.obj));
            au();
            B();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        TTSplashAd tTSplashAd = this.f16098u;
        if (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f16098u.getMediationManager().getShowEcpm() == null || this.f16098u.getMediationManager().getShowEcpm().getEcpm() == null || this.C) {
            return;
        }
        this.C = true;
        af.a("BeiZis", "channel == GroMore\u7ade\u4ef7\u5931\u8d25:" + i4);
    }
}
