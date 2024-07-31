package com.beizi.fusion.work.p076a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
import com.p518qq.p519e.ads.banner2.UnifiedBannerADListener;
import com.p518qq.p519e.ads.banner2.UnifiedBannerView;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtBannerAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11867n;

    /* renamed from: o */
    private String f11868o;

    /* renamed from: p */
    private long f11869p;

    /* renamed from: q */
    private long f11870q;

    /* renamed from: r */
    private boolean f11871r;

    /* renamed from: s */
    private UnifiedBannerView f11872s;

    /* renamed from: t */
    private ViewGroup f11873t;

    /* renamed from: u */
    private float f11874u;

    /* renamed from: v */
    private float f11875v;

    /* renamed from: w */
    private boolean f11876w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtBannerAdWorker.java */
    /* renamed from: com.beizi.fusion.work.a.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3265a implements UnifiedBannerADListener {

        /* renamed from: a */
        boolean f11878a;

        /* renamed from: b */
        boolean f11879b;

        private C3265a() {
            this.f11878a = false;
            this.f11879b = false;
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtBannerAd onADClicked()");
            if (((AdWorker) GdtBannerAdWorker.this).f11797d != null) {
                ((AdWorker) GdtBannerAdWorker.this).f11797d.m48700d(GdtBannerAdWorker.this.mo46059g());
            }
            if (this.f11879b) {
                return;
            }
            this.f11879b = true;
            GdtBannerAdWorker.this.m47990E();
            GdtBannerAdWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Log.d("BeiZis", "showGdtBannerAd onADClosed()");
            if (((AdWorker) GdtBannerAdWorker.this).f11797d != null) {
                ((AdWorker) GdtBannerAdWorker.this).f11797d.m48704c(GdtBannerAdWorker.this.mo46059g());
            }
            GdtBannerAdWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtBannerAd onADExposure()");
            ((AdWorker) GdtBannerAdWorker.this).f11803j = AdStatus.ADSHOW;
            if (((AdWorker) GdtBannerAdWorker.this).f11797d != null) {
                ((AdWorker) GdtBannerAdWorker.this).f11797d.m48710b(GdtBannerAdWorker.this.mo46059g());
            }
            if (this.f11878a) {
                return;
            }
            this.f11878a = true;
            GdtBannerAdWorker.this.mo46072az();
            GdtBannerAdWorker.this.m47992C();
            GdtBannerAdWorker.this.m47991D();
            GdtBannerAdWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Log.d("BeiZis", "showGdtBannerAd onADLeftApplication()");
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Log.d("BeiZis", "showGdtBannerAd onADReceive()");
            if (GdtBannerAdWorker.this.f11872s.getECPM() > 0) {
                GdtBannerAdWorker gdtBannerAdWorker = GdtBannerAdWorker.this;
                gdtBannerAdWorker.m47967a(gdtBannerAdWorker.f11872s.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtBannerAdWorker.this.f11872s.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            ((AdWorker) GdtBannerAdWorker.this).f11803j = AdStatus.ADLOAD;
            GdtBannerAdWorker.this.m47910y();
            if (!GdtBannerAdWorker.this.m47970Y()) {
                GdtBannerAdWorker.this.m47980O();
            } else {
                GdtBannerAdWorker.this.m47817b();
            }
        }

        @Override // com.p518qq.p519e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtBannerAd onError:" + adError.getErrorMsg());
            GdtBannerAdWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            if (GdtBannerAdWorker.this.f11876w) {
                return;
            }
            GdtBannerAdWorker.this.mo46173m();
        }
    }

    public GdtBannerAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2, ViewGroup viewGroup) {
        this.f11867n = context;
        this.f11868o = str;
        this.f11869p = j;
        this.f11870q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f11874u = f;
        this.f11875v = f2;
        this.f11873t = viewGroup;
        m47917r();
    }

    /* renamed from: aG */
    private ViewGroup.LayoutParams m47818aG() {
        if (this.f11874u <= 0.0f) {
            this.f11874u = C3138av.m48288j(this.f11867n);
        }
        if (this.f11875v <= 0.0f) {
            this.f11875v = Math.round(this.f11874u / 6.4f);
        }
        return new ViewGroup.LayoutParams(C3138av.m48304a(this.f11867n, this.f11874u), C3138av.m48304a(this.f11867n, this.f11875v));
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f11872s == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f11872s.getECPMLevel());
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
        UnifiedBannerView unifiedBannerView = this.f11872s;
        if (unifiedBannerView == null || unifiedBannerView.getECPM() <= 0 || this.f11871r) {
            return;
        }
        this.f11871r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f11872s.getECPM());
        UnifiedBannerView unifiedBannerView2 = this.f11872s;
        GDTAdManagerHolder.m48636a(unifiedBannerView2, unifiedBannerView2.getECPM());
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
                if (!C3138av.m48301a("com.qq.e.ads.banner2.UnifiedBannerView")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtBannerAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f11867n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11870q);
        long j = this.f11870q;
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
    /* renamed from: f */
    public void mo46061f() {
        ViewGroup viewGroup;
        Log.d("BeiZis", "showGdtBannerAd showAd()");
        if (this.f11872s != null && (viewGroup = this.f11873t) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11873t.removeAllViews();
            }
            this.f11876w = true;
            this.f11873t.addView(this.f11872s, m47818aG());
            return;
        }
        m47927aw();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        UnifiedBannerView unifiedBannerView = this.f11872s;
        if (unifiedBannerView != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), unifiedBannerView.getECPMLevel());
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
        this.f11876w = false;
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f11872s = new UnifiedBannerView((Activity) this.f11867n, this.f11802i, new C3265a(), null, m47957aC());
        } else {
            this.f11872s = new UnifiedBannerView((Activity) this.f11867n, this.f11802i, new C3265a());
        }
        this.f11872s.loadAD();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        UnifiedBannerView unifiedBannerView = this.f11872s;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47817b() {
        ViewGroup viewGroup;
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " BannerAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f11872s != null && (viewGroup = this.f11873t) != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f11873t.removeAllViews();
                }
                this.f11876w = true;
                this.f11873t.addView(this.f11872s, m47818aG());
                this.f11797d.m48726a(mo46059g(), (View) null);
                return;
            }
            this.f11797d.m48754a(10140);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        UnifiedBannerView unifiedBannerView = this.f11872s;
        if (unifiedBannerView == null || unifiedBannerView.getECPM() <= 0 || this.f11871r) {
            return;
        }
        this.f11871r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f11872s, i != 1 ? 10001 : 1);
    }
}
