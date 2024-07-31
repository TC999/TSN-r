package com.beizi.fusion.work.p078c;

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
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.c.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtFullScreenVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11925n;

    /* renamed from: o */
    private String f11926o;

    /* renamed from: p */
    private long f11927p;

    /* renamed from: q */
    private long f11928q;

    /* renamed from: r */
    private boolean f11929r;

    /* renamed from: s */
    private UnifiedInterstitialAD f11930s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtFullScreenVideoWorker.java */
    /* renamed from: com.beizi.fusion.work.c.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3280a implements UnifiedInterstitialADListener {

        /* renamed from: a */
        boolean f11932a;

        /* renamed from: b */
        boolean f11933b;

        private C3280a() {
            this.f11932a = false;
            this.f11933b = false;
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADClicked()");
            if (((AdWorker) GdtFullScreenVideoWorker.this).f11797d != null && ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48700d(GdtFullScreenVideoWorker.this.mo46059g());
            }
            if (this.f11933b) {
                return;
            }
            this.f11933b = true;
            GdtFullScreenVideoWorker.this.m47990E();
            GdtFullScreenVideoWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADClosed()");
            if (((AdWorker) GdtFullScreenVideoWorker.this).f11797d != null && ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48704c(GdtFullScreenVideoWorker.this.mo46059g());
            }
            GdtFullScreenVideoWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADExposure()");
            ((AdWorker) GdtFullScreenVideoWorker.this).f11803j = AdStatus.ADSHOW;
            if (((AdWorker) GdtFullScreenVideoWorker.this).f11797d != null && ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtFullScreenVideoWorker.this).f11797d.m48710b(GdtFullScreenVideoWorker.this.mo46059g());
            }
            if (this.f11932a) {
                return;
            }
            this.f11932a = true;
            GdtFullScreenVideoWorker.this.mo46072az();
            GdtFullScreenVideoWorker.this.m47992C();
            GdtFullScreenVideoWorker.this.m47991D();
            GdtFullScreenVideoWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADLeftApplication()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADOpened()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            Log.d("BeiZis", "showGdtFullScreenVideo onADReceive()");
            if (GdtFullScreenVideoWorker.this.f11930s.getECPM() > 0) {
                GdtFullScreenVideoWorker gdtFullScreenVideoWorker = GdtFullScreenVideoWorker.this;
                gdtFullScreenVideoWorker.m47967a(gdtFullScreenVideoWorker.f11930s.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtFullScreenVideoWorker.this.f11930s.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            ((AdWorker) GdtFullScreenVideoWorker.this).f11803j = AdStatus.ADLOAD;
            GdtFullScreenVideoWorker.this.m47910y();
            if (GdtFullScreenVideoWorker.this.m47970Y()) {
                GdtFullScreenVideoWorker.this.m47680b();
            } else {
                GdtFullScreenVideoWorker.this.m47980O();
            }
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtFullScreenVideo onError:" + adError.getErrorMsg());
            GdtFullScreenVideoWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            Log.d("BeiZis", "showGdtFullScreenVideo onRenderFail()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            Log.d("BeiZis", "showGdtFullScreenVideo onRenderSuccess()");
        }

        @Override // com.p518qq.p519e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            Log.d("BeiZis", "showGdtFullScreenVideo onVideoCached()");
        }
    }

    public GdtFullScreenVideoWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11925n = context;
        this.f11926o = str;
        this.f11927p = j;
        this.f11928q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f11930s == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f11930s.getECPMLevel());
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
        UnifiedInterstitialAD unifiedInterstitialAD = this.f11930s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f11929r) {
            return;
        }
        this.f11929r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f11930s.getECPM());
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.f11930s;
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
                if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtFullScreenVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f11925n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11928q);
        long j = this.f11928q;
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
        UnifiedInterstitialAD unifiedInterstitialAD = this.f11930s;
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
        Activity activity = (Activity) this.f11925n;
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f11930s = new UnifiedInterstitialAD(activity, this.f11802i, new C3280a(), null, m47957aC());
        } else {
            this.f11930s = new UnifiedInterstitialAD(activity, this.f11802i, new C3280a());
        }
        this.f11930s.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(true).build());
        this.f11930s.loadFullScreenAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47680b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " FullScreenVideoWorkers:" + m48669r.toString());
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
        UnifiedInterstitialAD unifiedInterstitialAD = this.f11930s;
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid() && activity != null) {
            this.f11930s.showFullScreenAD(activity);
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
        UnifiedInterstitialAD unifiedInterstitialAD = this.f11930s;
        if (unifiedInterstitialAD == null || unifiedInterstitialAD.getECPM() <= 0 || this.f11929r) {
            return;
        }
        this.f11929r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f11930s, i != 1 ? 10001 : 1);
    }
}
