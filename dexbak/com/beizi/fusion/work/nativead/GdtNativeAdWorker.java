package com.beizi.fusion.work.nativead;

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
import com.p518qq.p519e.ads.nativ.ADSize;
import com.p518qq.p519e.ads.nativ.NativeExpressAD;
import com.p518qq.p519e.ads.nativ.NativeExpressADView;
import com.p518qq.p519e.ads.nativ.NativeExpressMediaListener;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.nativead.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12419n;

    /* renamed from: o */
    private String f12420o;

    /* renamed from: p */
    private long f12421p;

    /* renamed from: q */
    private long f12422q;

    /* renamed from: r */
    private boolean f12423r;

    /* renamed from: s */
    private NativeExpressAD f12424s;

    /* renamed from: t */
    private NativeExpressADView f12425t;

    /* renamed from: u */
    private float f12426u;

    /* renamed from: v */
    private float f12427v;

    /* renamed from: w */
    private View f12428w;

    /* renamed from: x */
    private boolean f12429x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtNativeAdWorker.java */
    /* renamed from: com.beizi.fusion.work.nativead.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3420a implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a */
        boolean f12431a;

        /* renamed from: b */
        boolean f12432b;

        private C3420a() {
            this.f12431a = false;
            this.f12432b = false;
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADClicked()");
            if (((AdWorker) GdtNativeAdWorker.this).f11797d != null && ((AdWorker) GdtNativeAdWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtNativeAdWorker.this).f11797d.m48700d(GdtNativeAdWorker.this.mo46059g());
            }
            if (this.f12432b) {
                return;
            }
            this.f12432b = true;
            GdtNativeAdWorker.this.m47990E();
            GdtNativeAdWorker.this.m47941ai();
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADClosed()");
            if (((AdWorker) GdtNativeAdWorker.this).f11797d != null && ((AdWorker) GdtNativeAdWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtNativeAdWorker.this).f11797d.m48709b(GdtNativeAdWorker.this.mo46059g(), GdtNativeAdWorker.this.f12428w);
            }
            GdtNativeAdWorker.this.m47988G();
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADExposure()");
            ((AdWorker) GdtNativeAdWorker.this).f11803j = AdStatus.ADSHOW;
            if (((AdWorker) GdtNativeAdWorker.this).f11797d != null && ((AdWorker) GdtNativeAdWorker.this).f11797d.m48668s() != 2) {
                ((AdWorker) GdtNativeAdWorker.this).f11797d.m48710b(GdtNativeAdWorker.this.mo46059g());
            }
            if (this.f12431a) {
                return;
            }
            this.f12431a = true;
            GdtNativeAdWorker.this.mo46072az();
            GdtNativeAdWorker.this.m47992C();
            GdtNativeAdWorker.this.m47991D();
            GdtNativeAdWorker.this.m47942ah();
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADLeftApplication()");
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            Log.d("BeiZis", "showGdtNativeAd onADLoad()");
            ((AdWorker) GdtNativeAdWorker.this).f11803j = AdStatus.ADLOAD;
            GdtNativeAdWorker.this.m47910y();
            if (list != null && list.size() != 0) {
                if (GdtNativeAdWorker.this.f12425t != null) {
                    GdtNativeAdWorker.this.f12425t.destroy();
                }
                GdtNativeAdWorker.this.f12425t = list.get(0);
                if (GdtNativeAdWorker.this.f12425t.getECPM() > 0) {
                    GdtNativeAdWorker gdtNativeAdWorker = GdtNativeAdWorker.this;
                    gdtNativeAdWorker.m47967a(gdtNativeAdWorker.f12425t.getECPM());
                }
                if (DownloadConfirmHelper.f11427a) {
                    GdtNativeAdWorker.this.f12425t.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
                }
                if (GdtNativeAdWorker.this.f12425t.getBoundData().getAdPatternType() == 2) {
                    GdtNativeAdWorker.this.f12429x = true;
                    GdtNativeAdWorker.this.f12425t.setMediaListener(new NativeExpressMediaListener() { // from class: com.beizi.fusion.work.nativead.g.a.1
                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoCached(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoCached()");
                            GdtNativeAdWorker.this.m46754aG();
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoComplete()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoError()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoInit(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoInit()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoLoading()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPageClose()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPageOpen()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPause(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPause()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoReady()");
                        }

                        @Override // com.p518qq.p519e.ads.nativ.NativeExpressMediaListener
                        public void onVideoStart(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoStart()");
                        }
                    });
                    GdtNativeAdWorker.this.f12425t.preloadVideo();
                }
                GdtNativeAdWorker gdtNativeAdWorker2 = GdtNativeAdWorker.this;
                gdtNativeAdWorker2.f12428w = gdtNativeAdWorker2.f12425t;
                if (GdtNativeAdWorker.this.f12429x) {
                    return;
                }
                GdtNativeAdWorker.this.m46754aG();
                return;
            }
            GdtNativeAdWorker.this.m47921c(-991);
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtNativeAd onError:" + adError.getErrorMsg());
            GdtNativeAdWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onRenderFail()");
            GdtNativeAdWorker.this.m47961a("sdk custom error ".concat("Render Fail"), 99991);
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onRenderSuccess()");
        }
    }

    public GdtNativeAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12419n = context;
        this.f12420o = str;
        this.f12421p = j;
        this.f12422q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12426u = f;
        this.f12427v = f2;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m46754aG() {
        NativeExpressADView nativeExpressADView = this.f12425t;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
        if (m47970Y()) {
            m46753b();
        } else {
            m47980O();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12425t == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12425t.getECPMLevel());
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
        NativeExpressADView nativeExpressADView = this.f12425t;
        if (nativeExpressADView == null || nativeExpressADView.getECPM() <= 0 || this.f12423r) {
            return;
        }
        this.f12423r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12425t.getECPM());
        NativeExpressADView nativeExpressADView2 = this.f12425t;
        GDTAdManagerHolder.m48636a(nativeExpressADView2, nativeExpressADView2.getECPM());
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtNativeAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12419n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12422q);
        long j = this.f12422q;
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
        NativeExpressADView nativeExpressADView = this.f12425t;
        if (nativeExpressADView != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), nativeExpressADView.getECPMLevel());
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
        if (this.f12426u <= 0.0f) {
            this.f12426u = -1.0f;
        }
        if (this.f12427v <= 0.0f) {
            this.f12427v = -2.0f;
        }
        this.f12429x = false;
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12424s = new NativeExpressAD(this.f12419n, new ADSize((int) this.f12426u, (int) this.f12427v), this.f11802i, new C3420a(), m47957aC());
        } else {
            this.f12424s = new NativeExpressAD(this.f12419n, new ADSize((int) this.f12426u, (int) this.f12427v), this.f11802i, new C3420a());
        }
        this.f12424s.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
        this.f12424s.loadAD(1);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeExpressADView nativeExpressADView = this.f12425t;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12428w;
    }

    /* renamed from: b */
    private void m46753b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12425t != null) {
                this.f11797d.m48726a(mo46059g(), this.f12425t);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        NativeExpressADView nativeExpressADView = this.f12425t;
        if (nativeExpressADView == null || nativeExpressADView.getECPM() <= 0 || this.f12423r) {
            return;
        }
        this.f12423r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12425t, i != 1 ? 10001 : 1);
    }
}
