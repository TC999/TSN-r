package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.work.AdWorker;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialAD;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.interstitial.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtInterstitialWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12202n;

    /* renamed from: o */
    private String f12203o;

    /* renamed from: p */
    private long f12204p;

    /* renamed from: q */
    private long f12205q;

    /* renamed from: r */
    private boolean f12206r;

    /* renamed from: s */
    private UnifiedInterstitialAD f12207s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtInterstitialWorker.java */
    /* renamed from: com.beizi.fusion.work.interstitial.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3367a implements UnifiedInterstitialADListener {

        /* renamed from: a */
        boolean f12209a;

        /* renamed from: b */
        boolean f12210b;

        private C3367a() {
            this.f12209a = false;
            this.f12210b = false;
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtInterstitialAd onADClicked()");
            if (((AdWorker) GdtInterstitialWorker.this).f11797d != null && ((AdWorker) GdtInterstitialWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtInterstitialWorker.this).f11797d.m48700d(GdtInterstitialWorker.this.mo46059g());
            }
            if (this.f12210b) {
                return;
            }
            this.f12210b = true;
            GdtInterstitialWorker.this.m47990E();
            GdtInterstitialWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            Log.d("BeiZis", "showGdtInterstitialAd onADClosed()");
            if (((AdWorker) GdtInterstitialWorker.this).f11797d != null && ((AdWorker) GdtInterstitialWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtInterstitialWorker.this).f11797d.m48704c(GdtInterstitialWorker.this.mo46059g());
            }
            GdtInterstitialWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtInterstitialAd onADExposure()");
            ((AdWorker) GdtInterstitialWorker.this).f11803j = AdStatus.ADSHOW;
            if (((AdWorker) GdtInterstitialWorker.this).f11797d != null && ((AdWorker) GdtInterstitialWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtInterstitialWorker.this).f11797d.m48710b(GdtInterstitialWorker.this.mo46059g());
            }
            if (this.f12209a) {
                return;
            }
            this.f12209a = true;
            GdtInterstitialWorker.this.mo46072az();
            GdtInterstitialWorker.this.m47992C();
            GdtInterstitialWorker.this.m47991D();
            GdtInterstitialWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            Log.d("BeiZis", "showGdtInterstitialAd onADLeftApplication()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            Log.d("BeiZis", "showGdtInterstitialAd onADOpened()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            Log.d("BeiZis", "showGdtInterstitialAd onADReceive()");
            if (GdtInterstitialWorker.this.f12207s != null) {
                if (DownloadConfirmHelper.f11427a) {
                    GdtInterstitialWorker.this.f12207s.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
                }
                if (GdtInterstitialWorker.this.f12207s.getAdPatternType() == 2) {
                    GdtInterstitialWorker.this.f12207s.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.beizi.fusion.work.interstitial.c.a.1
                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoComplete() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoComplete()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoError(AdError adError) {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoError()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoInit() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoInit()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoLoading() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoLoading()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoPageClose() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoPageClose()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoPageOpen() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoPageOpen()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoPause() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoPause()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoReady(long j) {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoReady()");
                        }

                        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialMediaListener
                        public void onVideoStart() {
                            Log.d("BeiZis", "showGdtInterstitialAd onVideoStart()");
                        }
                    });
                }
            }
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtInterstitialAd onNoAD:" + adError.getErrorMsg());
            GdtInterstitialWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            Log.d("BeiZis", "showGdtInterstitialAd onRenderFail()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            Log.d("BeiZis", "showGdtInterstitialAd onRenderSuccess()");
            if (GdtInterstitialWorker.this.f12207s.getECPM() > 0) {
                GdtInterstitialWorker gdtInterstitialWorker = GdtInterstitialWorker.this;
                gdtInterstitialWorker.m47967a(gdtInterstitialWorker.f12207s.getECPM());
            }
            ((AdWorker) GdtInterstitialWorker.this).f11803j = AdStatus.ADLOAD;
            GdtInterstitialWorker.this.m47910y();
            if (GdtInterstitialWorker.this.m47970Y()) {
                GdtInterstitialWorker.this.m47137b();
            } else {
                GdtInterstitialWorker.this.m47980O();
            }
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            Log.d("BeiZis", "showGdtInterstitialAd onVideoCached()");
        }
    }

    public GdtInterstitialWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12202n = context;
        this.f12203o = str;
        this.f12204p = j;
        this.f12205q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12207s == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12207s.getECPMLevel());
        if (m48440a == -1 || m48440a == -2) {
            if (m48440a == -2) {
                m47983L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + m48440a);
        m47967a((double) m48440a);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f12207s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f12206r) {
            return;
        }
        this.f12206r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12207s.getECPM());
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.f12207s;
        GDTAdManagerHolder.m48636a(unifiedInterstitialAD2, unifiedInterstitialAD2.getECPM());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
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
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.qq.e.ads.interstitial2.UnifiedInterstitialAD")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtInterstitialWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12202n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12205q);
        long j = this.f12205q;
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

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f12207s;
        if (unifiedInterstitialAD != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), unifiedInterstitialAD.getECPMLevel());
            if (m48440a == -1 || m48440a == -2) {
                return null;
            }
            return m48440a + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        Activity activity = (Activity) this.f12202n;
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12207s = new UnifiedInterstitialAD(activity, this.f11802i, new C3367a(), null, m47957aC());
        } else {
            this.f12207s = new UnifiedInterstitialAD(activity, this.f11802i, new C3367a());
        }
        this.f12207s.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(true).build());
        this.f12207s.loadAD();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f12207s;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47137b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " InterstitialWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            BaseManager baseManager2 = this.f11797d;
            if (baseManager2 != null) {
                baseManager2.m48726a(mo46059g(), (View) null);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f12207s;
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid()) {
            this.f12207s.show();
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f12207s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f12206r) {
            return;
        }
        this.f12206r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12207s, i != 1 ? 10001 : 1);
    }
}
