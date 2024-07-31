package com.beizi.fusion.work.splash;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GmSplashWorker extends AdWorker {

    /* renamed from: A */
    private boolean f12733A;

    /* renamed from: B */
    private TTSplashAd.AdInteractionListener f12734B;

    /* renamed from: C */
    private boolean f12735C;

    /* renamed from: D */
    private int f12736D;

    /* renamed from: E */
    private int f12737E;

    /* renamed from: F */
    private long f12738F;

    /* renamed from: n */
    private Context f12739n;

    /* renamed from: o */
    private String f12740o;

    /* renamed from: p */
    private long f12741p;

    /* renamed from: q */
    private View f12742q;

    /* renamed from: r */
    private ViewGroup f12743r;

    /* renamed from: s */
    private ViewGroup f12744s;

    /* renamed from: t */
    private TTAdNative f12745t;

    /* renamed from: u */
    private TTSplashAd f12746u;

    /* renamed from: v */
    private List<AdSpacesBean.RenderViewBean> f12747v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12748w = new ArrayList();

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12749x = new ArrayList();

    /* renamed from: y */
    private float f12750y;

    /* renamed from: z */
    private float f12751z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GmSplashWorker.java */
    /* renamed from: com.beizi.fusion.work.splash.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3473a implements TTSplashAd.AdInteractionListener {

        /* renamed from: b */
        private boolean f12755b;

        /* renamed from: c */
        private boolean f12756c;

        private C3473a() {
            this.f12755b = false;
            this.f12756c = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            Log.d("BeiZis", "onAdClicked");
            if (((AdWorker) GmSplashWorker.this).f11797d != null && ((AdWorker) GmSplashWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GmSplashWorker.this).f11797d.m48700d(GmSplashWorker.this.mo46059g());
                ((AdWorker) GmSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) GmSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
            }
            if (this.f12756c) {
                return;
            }
            this.f12756c = true;
            GmSplashWorker.this.m47941ai();
            GmSplashWorker.this.m47990E();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            Log.d("BeiZis", "GmSplashWorker.onAdShow");
            ((AdWorker) GmSplashWorker.this).f11803j = AdStatus.ADSHOW;
            if (this.f12755b) {
                return;
            }
            this.f12755b = true;
            GmSplashWorker.this.mo47585ab();
            GmSplashWorker.this.m47992C();
            GmSplashWorker.this.m47991D();
            GmSplashWorker.this.m47942ah();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            Log.d("BeiZis", "onAdSkip");
            if (((AdWorker) GmSplashWorker.this).f11797d != null && ((AdWorker) GmSplashWorker.this).f11797d.m48668s() != 2) {
                GmSplashWorker.this.m47947ac();
            }
            GmSplashWorker.this.m47987H();
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            Log.d("BeiZis", "onAdTimeOver");
            if (((AdWorker) GmSplashWorker.this).f11797d != null && ((AdWorker) GmSplashWorker.this).f11797d.m48668s() != 2) {
                GmSplashWorker.this.m47947ac();
            }
            GmSplashWorker.this.m47987H();
        }
    }

    public GmSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i, int i2, BaseManager baseManager) {
        this.f12739n = context;
        this.f12740o = str;
        this.f12741p = j;
        this.f12742q = view;
        this.f12743r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12744s = new SplashContainer(context);
        this.f12747v = list;
        this.f12736D = i;
        this.f12737E = i2;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m46299aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", " GmSplashWorker.load():" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m47946ad();
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aH */
    private void m46298aH() {
        try {
            Log.d("BeiZis", "GmSplashWorker.finalShowAd()");
            TTSplashAd tTSplashAd = this.f12746u;
            if (tTSplashAd != null) {
                View splashView = tTSplashAd.getSplashView();
                this.f12743r.removeAllViews();
                this.f12743r.addView(splashView);
            } else {
                m47927aw();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        m46296b();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        TTSplashAd tTSplashAd = this.f12746u;
        if (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f12746u.getMediationManager().getShowEcpm() == null || this.f12746u.getMediationManager().getShowEcpm().getEcpm() == null || this.f12735C) {
            return;
        }
        this.f12735C = true;
        C3116af.m48496a("BeiZis", "channel == GroMore竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12746u.getMediationManager().getShowEcpm().getEcpm());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GM";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GmSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    C3116af.m48496a("BeiZis", "groMore sdk not import , will do nothing");
                    return;
                }
                m47914u();
                C3116af.m48496a("BeiZis", "requestAd() appId：" + this.f11801h + "  spaceId：" + this.f11802i);
                TTAdManagerHolder.m48587b(this, this.f12739n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48875x(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
        this.f12738F = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            this.f12738F = Math.max(this.f12738F, this.f11799f.getHotRequestDelay());
        }
        this.f12750y = C3138av.m48286l(this.f12739n);
        this.f12751z = C3138av.m48285m(this.f12739n);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", "GmSplashWorker.showAd()");
        m46298aH();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        TTSplashAd tTSplashAd = this.f12746u;
        return (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f12746u.getMediationManager().getShowEcpm() == null || this.f12746u.getMediationManager().getShowEcpm().getEcpm() == null) ? "" : this.f12746u.getMediationManager().getShowEcpm().getEcpm();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo46050l() {
        /*
            r7 = this;
            r7.m47912w()
            r7.m47943ag()
            android.content.Context r0 = r7.f12739n
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = 0
            int r3 = r7.f12736D     // Catch: java.lang.Exception -> L3c
            if (r3 != 0) goto L17
            float r0 = com.beizi.fusion.p072g.C3138av.m48288j(r0)     // Catch: java.lang.Exception -> L3c
            int r0 = (int) r0     // Catch: java.lang.Exception -> L3c
            r7.f12736D = r0     // Catch: java.lang.Exception -> L3c
        L17:
            int r0 = r7.f12737E     // Catch: java.lang.Exception -> L3c
            if (r0 != 0) goto L24
            android.content.Context r0 = r7.f12739n     // Catch: java.lang.Exception -> L3c
            float r0 = com.beizi.fusion.p072g.C3138av.m48287k(r0)     // Catch: java.lang.Exception -> L3c
            int r0 = (int) r0     // Catch: java.lang.Exception -> L3c
            r7.f12737E = r0     // Catch: java.lang.Exception -> L3c
        L24:
            android.content.Context r0 = r7.f12739n     // Catch: java.lang.Exception -> L3c
            int r3 = r7.f12737E     // Catch: java.lang.Exception -> L3c
            float r3 = (float) r3     // Catch: java.lang.Exception -> L3c
            int r0 = com.beizi.fusion.p072g.C3138av.m48304a(r0, r3)     // Catch: java.lang.Exception -> L3c
            android.content.Context r3 = r7.f12739n     // Catch: java.lang.Exception -> L37
            int r4 = r7.f12736D     // Catch: java.lang.Exception -> L37
            float r4 = (float) r4     // Catch: java.lang.Exception -> L37
            int r2 = com.beizi.fusion.p072g.C3138av.m48304a(r3, r4)     // Catch: java.lang.Exception -> L37
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
            r7.f12734B = r3
            com.beizi.fusion.work.splash.g$2 r3 = new com.beizi.fusion.work.splash.g$2
            r3.<init>()
            java.lang.String r4 = r7.f11802i
            if (r4 != 0) goto L54
            return
        L54:
            com.bytedance.sdk.openadsdk.TTAdManager r4 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            com.bytedance.sdk.openadsdk.TTAdNative r1 = r4.createAdNative(r1)
            r7.f12745t = r1
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$Builder r1 = new com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$Builder
            r1.<init>()
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot r1 = r1.build()
            com.bytedance.sdk.openadsdk.AdSlot$Builder r4 = new com.bytedance.sdk.openadsdk.AdSlot$Builder
            r4.<init>()
            java.lang.String r5 = r7.f11802i
            com.bytedance.sdk.openadsdk.AdSlot$Builder r4 = r4.setCodeId(r5)
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r4.setImageAcceptedSize(r2, r0)
            com.bytedance.sdk.openadsdk.AdSlot$Builder r0 = r0.setMediationAdSlot(r1)
            com.bytedance.sdk.openadsdk.AdSlot r0 = r0.build()
            com.bytedance.sdk.openadsdk.TTAdNative r1 = r7.f12745t     // Catch: java.lang.Exception -> L84
            r1.loadSplashAd(r0, r3)     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r0 = move-exception
            r0.printStackTrace()
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.splash.GmSplashWorker.mo46050l():void");
    }

    /* renamed from: b */
    public void m46296b() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12738F);
        long j = this.f12738F;
        if (j > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, j);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager == null || baseManager.m48667t() >= 1 || this.f11797d.m48668s() == 2) {
            return;
        }
        mo46050l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo46196a(Message message) {
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48905i(String.valueOf(message.obj));
            m47929au();
            m47993B();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        TTSplashAd tTSplashAd = this.f12746u;
        if (tTSplashAd == null || tTSplashAd.getMediationManager() == null || this.f12746u.getMediationManager().getShowEcpm() == null || this.f12746u.getMediationManager().getShowEcpm().getEcpm() == null || this.f12735C) {
            return;
        }
        this.f12735C = true;
        C3116af.m48496a("BeiZis", "channel == GroMore竞价失败:" + i);
    }
}
