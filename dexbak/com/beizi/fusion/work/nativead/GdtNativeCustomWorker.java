package com.beizi.fusion.work.nativead;

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
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeADUnifiedListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedAD;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.nativead.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtNativeCustomWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12435n;

    /* renamed from: o */
    private String f12436o;

    /* renamed from: p */
    private long f12437p;

    /* renamed from: q */
    private long f12438q;

    /* renamed from: r */
    private boolean f12439r;

    /* renamed from: s */
    private NativeUnifiedAD f12440s;

    /* renamed from: t */
    private NativeUnifiedADData f12441t;

    /* renamed from: u */
    private float f12442u;

    /* renamed from: v */
    private float f12443v;

    /* renamed from: w */
    private ViewGroup f12444w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GdtNativeCustomWorker.java */
    /* renamed from: com.beizi.fusion.work.nativead.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3423a implements NativeADUnifiedListener {
        private C3423a() {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtNativeCustom onADLoaded()");
            ((AdWorker) GdtNativeCustomWorker.this).f11803j = AdStatus.ADLOAD;
            GdtNativeCustomWorker.this.m47910y();
            if (list == null || list.size() == 0) {
                GdtNativeCustomWorker.this.m47921c(-991);
                return;
            }
            GdtNativeCustomWorker.this.f12441t = list.get(0);
            if (GdtNativeCustomWorker.this.f12441t == null) {
                GdtNativeCustomWorker.this.m47921c(-991);
                return;
            }
            if (GdtNativeCustomWorker.this.f12441t.getECPM() > 0) {
                GdtNativeCustomWorker gdtNativeCustomWorker = GdtNativeCustomWorker.this;
                gdtNativeCustomWorker.m47967a(gdtNativeCustomWorker.f12441t.getECPM());
            }
            if (DownloadConfirmHelper.f11427a) {
                GdtNativeCustomWorker.this.f12441t.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
            }
            NativeADEventListener nativeADEventListener = new NativeADEventListener() { // from class: com.beizi.fusion.work.nativead.h.a.1

                /* renamed from: a */
                boolean f12447a = false;

                /* renamed from: b */
                boolean f12448b = false;

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADClicked()");
                    if (((AdWorker) GdtNativeCustomWorker.this).f11797d != null && ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48700d(GdtNativeCustomWorker.this.mo46059g());
                    }
                    if (this.f12448b) {
                        return;
                    }
                    this.f12448b = true;
                    GdtNativeCustomWorker.this.m47990E();
                    GdtNativeCustomWorker.this.m47941ai();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADError: " + adError.getErrorMsg());
                    GdtNativeCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onExposed()");
                    ((AdWorker) GdtNativeCustomWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) GdtNativeCustomWorker.this).f11797d != null && ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48710b(GdtNativeCustomWorker.this.mo46059g());
                    }
                    if (this.f12447a) {
                        return;
                    }
                    this.f12447a = true;
                    GdtNativeCustomWorker.this.mo46072az();
                    GdtNativeCustomWorker.this.m47992C();
                    GdtNativeCustomWorker.this.m47991D();
                    GdtNativeCustomWorker.this.m47942ah();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADStatusChanged()");
                }
            };
            NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: com.beizi.fusion.work.nativead.h.a.2

                /* renamed from: a */
                boolean f12450a = false;

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoClicked()");
                    if (((AdWorker) GdtNativeCustomWorker.this).f11797d != null && ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48700d(GdtNativeCustomWorker.this.mo46059g());
                    }
                    if (this.f12450a) {
                        return;
                    }
                    this.f12450a = true;
                    GdtNativeCustomWorker.this.m47990E();
                    GdtNativeCustomWorker.this.m47941ai();
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoCompleted()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoError: " + adError.getErrorMsg());
                    GdtNativeCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoInit()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i) {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoLoaded()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoLoading()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoPause()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoReady()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoResume()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoStart()");
                }

                @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoStop()");
                }
            };
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.h.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADClosed()");
                    if (((AdWorker) GdtNativeCustomWorker.this).f11797d != null && ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) GdtNativeCustomWorker.this).f11797d.m48709b(GdtNativeCustomWorker.this.mo46059g(), GdtNativeCustomWorker.this.f12444w);
                    }
                    GdtNativeCustomWorker.this.m47988G();
                }
            };
            GdtNativeCustomLayout gdtNativeCustomLayout = new GdtNativeCustomLayout(GdtNativeCustomWorker.this.f12435n);
            gdtNativeCustomLayout.onBindData(GdtNativeCustomWorker.this.f12441t, GdtNativeCustomWorker.this.f12442u, GdtNativeCustomWorker.this.f12443v, nativeADEventListener, nativeADMediaListener, onClickListener);
            GdtNativeCustomWorker.this.f12444w = gdtNativeCustomLayout;
            GdtNativeCustomWorker.this.m46722aG();
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtNativeCustom onNoAD: " + adError.getErrorMsg());
            GdtNativeCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public GdtNativeCustomWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12435n = context;
        this.f12436o = str;
        this.f12437p = j;
        this.f12438q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12442u = f;
        this.f12443v = f2;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m46722aG() {
        if (m47970Y()) {
            m46721b();
        } else {
            m47980O();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        NativeUnifiedADData nativeUnifiedADData = this.f12441t;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12439r) {
            return;
        }
        this.f12439r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12441t.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f12441t;
        GDTAdManagerHolder.m48636a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
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
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12441t == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12441t.getECPMLevel());
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtNativeCustomWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                m47914u();
                GDTAdManagerHolder.m48638a(this.f12435n, this.f11801h);
                this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
                m47929au();
                m47913v();
            }
        }
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12438q);
        long j = this.f12438q;
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
        NativeUnifiedADData nativeUnifiedADData = this.f12441t;
        if (nativeUnifiedADData != null) {
            int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
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
        if (this.f12442u <= 0.0f) {
            this.f12442u = C3138av.m48288j(this.f12435n);
        }
        if (this.f12443v <= 0.0f) {
            this.f12443v = 0.0f;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12440s = new NativeUnifiedAD(this.f12435n, this.f11802i, new C3423a(), m47957aC());
        } else {
            this.f12440s = new NativeUnifiedAD(this.f12435n, this.f11802i, new C3423a());
        }
        this.f12440s.loadData(1);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeUnifiedADData nativeUnifiedADData = this.f12441t;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: n */
    public void mo46703n() {
        NativeUnifiedADData nativeUnifiedADData = this.f12441t;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12444w;
    }

    /* renamed from: b */
    private void m46721b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12444w != null) {
                this.f11797d.m48726a(mo46059g(), this.f12444w);
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
        NativeUnifiedADData nativeUnifiedADData = this.f12441t;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12439r) {
            return;
        }
        this.f12439r = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12441t, i != 1 ? 10001 : 1);
    }
}
