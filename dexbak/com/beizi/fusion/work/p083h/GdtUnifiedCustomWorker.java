package com.beizi.fusion.work.p083h;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.GDTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.BeiZiImageUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.CheckDirectDownload;
import com.beizi.fusion.p072g.DownloadConfirmHelper;
import com.beizi.fusion.p072g.PriceUtil;
import com.beizi.fusion.work.AdWorker;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.nativ.MediaView;
import com.p518qq.p519e.ads.nativ.NativeADEventListener;
import com.p518qq.p519e.ads.nativ.NativeADMediaListener;
import com.p518qq.p519e.ads.nativ.NativeADUnifiedListener;
import com.p518qq.p519e.ads.nativ.NativeUnifiedAD;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADData;
import com.p518qq.p519e.ads.nativ.widget.NativeAdContainer;
import com.p518qq.p519e.comm.managers.status.SDKStatus;
import com.p518qq.p519e.comm.util.AdError;
import java.util.List;

/* renamed from: com.beizi.fusion.work.h.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GdtUnifiedCustomWorker extends BaseUnifiedCustomWorker {

    /* renamed from: W */
    private boolean f12144W;

    /* renamed from: X */
    private FrameLayout f12145X;

    /* renamed from: Y */
    private NativeAdContainer f12146Y;

    /* renamed from: Z */
    private NativeUnifiedAD f12147Z;

    /* renamed from: aa */
    private NativeUnifiedADData f12148aa;

    /* compiled from: GdtUnifiedCustomWorker.java */
    /* renamed from: com.beizi.fusion.work.h.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3346a implements NativeADUnifiedListener {
        private C3346a() {
        }

        @Override // com.p518qq.p519e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtUnifiedCustomAd onADLoaded()");
            ((AdWorker) GdtUnifiedCustomWorker.this).f11803j = AdStatus.ADLOAD;
            GdtUnifiedCustomWorker.this.m47910y();
            if (list == null || list.size() == 0) {
                GdtUnifiedCustomWorker.this.m47921c(-991);
                return;
            }
            GdtUnifiedCustomWorker.this.f12148aa = list.get(0);
            if (GdtUnifiedCustomWorker.this.f12148aa != null) {
                if (GdtUnifiedCustomWorker.this.f12148aa.getECPM() > 0) {
                    GdtUnifiedCustomWorker gdtUnifiedCustomWorker = GdtUnifiedCustomWorker.this;
                    gdtUnifiedCustomWorker.m47967a(gdtUnifiedCustomWorker.f12148aa.getECPM());
                }
                if (DownloadConfirmHelper.f11427a) {
                    GdtUnifiedCustomWorker.this.f12148aa.setDownloadConfirmListener(DownloadConfirmHelper.f11428b);
                }
                GdtUnifiedCustomWorker.this.m47268b();
                GdtUnifiedCustomWorker.this.mo47240aX();
                GdtUnifiedCustomWorker.this.m47325aM();
                return;
            }
            GdtUnifiedCustomWorker.this.m47921c(-991);
        }

        @Override // com.p518qq.p519e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtUnifiedCustomAd onNoAD: " + adError.getErrorMsg());
            GdtUnifiedCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public GdtUnifiedCustomWorker(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, int i) {
        super(context, j, buyerBean, forwardBean, baseManager, i);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12148aa == null) {
            return;
        }
        m47938al();
        int m48440a = PriceUtil.m48440a(this.f11798e.getPriceDict(), this.f12148aa.getECPMLevel());
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

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aG */
    public int mo47251aG() {
        return C3025R.C3029layout.gdt_layout_unified_view;
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aH */
    public void mo47250aH() {
        super.mo47250aH();
        this.f12146Y = (NativeAdContainer) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.native_ad_container);
        this.f12145X = (FrameLayout) ((BaseUnifiedCustomWorker) this).f12091o.findViewById(C3025R.C3028id.fl_logo);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aI */
    public void mo47249aI() {
        if (!C3138av.m48301a("com.qq.e.comm.managers.GDTAdSdk")) {
            m47915t();
            this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.d.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtUnifiedCustomWorker.this.m47921c(10151);
                }
            }, 10L);
            Log.e("BeiZis", "GDT sdk not import , will do nothing");
            return;
        }
        m47914u();
        GDTAdManagerHolder.m48638a(this.f12081N, this.f11801h);
        this.f11795b.m48885s(SDKStatus.getIntegrationSDKVersion());
        m47929au();
        m47913v();
        DownloadConfirmHelper.f11427a = !CheckDirectDownload.m48236a(this.f11798e.getDirectDownload());
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + ((BaseUnifiedCustomWorker) this).f12075H);
        long j = ((BaseUnifiedCustomWorker) this).f12075H;
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

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aJ */
    public void mo47248aJ() {
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            this.f12147Z = new NativeUnifiedAD(this.f12081N, this.f11802i, new C3346a(), m47957aC());
        } else {
            this.f12147Z = new NativeUnifiedAD(this.f12081N, this.f11802i, new C3346a());
        }
        this.f12147Z.loadData(1);
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aO */
    public void mo47247aO() {
        m47322aY();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aR */
    public void mo47245aR() {
        if (this.f12148aa.getAdPatternType() != 2) {
            BeiZiImageUtils.m48258a(this.f12081N).m48255a(this.f12148aa.getImgUrl(), new BeiZiImageUtils.InterfaceC3151a() { // from class: com.beizi.fusion.work.h.d.4
                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47232a() {
                }

                @Override // com.beizi.fusion.p072g.BeiZiImageUtils.InterfaceC3151a
                /* renamed from: a */
                public void mo47231a(Bitmap bitmap) {
                    ((BaseUnifiedCustomWorker) GdtUnifiedCustomWorker.this).f12101y.setImageBitmap(bitmap);
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aS */
    public String mo47244aS() {
        return this.f12148aa.getTitle();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aT */
    public String mo47243aT() {
        return this.f12148aa.getDesc();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aU */
    public String mo47242aU() {
        return this.f12148aa.getIconUrl();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aV */
    public String mo47241aV() {
        return this.f12148aa.getButtonText();
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: aX */
    public void mo47240aX() {
        if (this.f12147Z == null) {
            m47921c(-991);
        } else {
            m47324aN();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        NativeUnifiedADData nativeUnifiedADData = this.f12148aa;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12144W) {
            return;
        }
        this.f12144W = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价成功");
        C3116af.m48496a("BeiZis", "channel == sendWinNoticeECPM" + this.f12148aa.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f12148aa;
        GDTAdManagerHolder.m48636a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "GDT";
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker, com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        NativeUnifiedADData nativeUnifiedADData = this.f12148aa;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        NativeUnifiedADData nativeUnifiedADData = this.f12148aa;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f12144W) {
            return;
        }
        this.f12144W = true;
        C3116af.m48496a("BeiZis", "channel == GDT竞价失败:" + i);
        GDTAdManagerHolder.m48634b(this.f12148aa, i != 1 ? 10001 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47268b() {
        final NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: com.beizi.fusion.work.h.d.2
            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoClicked()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoCompleted()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoError: " + adError.getErrorMsg());
                GdtUnifiedCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoInit()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoLoaded()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoLoading()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoPause()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoReady()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoResume()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoStart()");
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd MediaView onVideoStop()");
            }
        };
        this.f12148aa.setNativeAdEventListener(new NativeADEventListener() { // from class: com.beizi.fusion.work.h.d.3
            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                GdtUnifiedCustomWorker.this.m47327aK();
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd onADError: " + adError.getErrorMsg());
                GdtUnifiedCustomWorker.this.m47961a(adError.getErrorMsg(), adError.getErrorCode());
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                GdtUnifiedCustomWorker.this.m47326aL();
                if (GdtUnifiedCustomWorker.this.f12148aa.getAdPatternType() == 2) {
                    VideoOption.Builder builder = new VideoOption.Builder();
                    builder.setAutoPlayPolicy(1);
                    builder.setEnableDetailPage(false);
                    builder.setEnableUserControl(true);
                    GdtUnifiedCustomWorker.this.f12148aa.bindMediaView((MediaView) ((BaseUnifiedCustomWorker) GdtUnifiedCustomWorker.this).f12096t, builder.build(), nativeADMediaListener);
                }
            }

            @Override // com.p518qq.p519e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
                Log.d("BeiZis", "ShowGdtUnifiedCustomAd onADStatusChanged()");
            }
        });
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: a */
    public void mo47252a(final List<View> list) {
        this.f12145X.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.work.h.d.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.work.h.d.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((BaseUnifiedCustomWorker) GdtUnifiedCustomWorker.this).f12093q != null) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C3138av.m48304a(GdtUnifiedCustomWorker.this.f12081N, 46.0f), C3138av.m48304a(GdtUnifiedCustomWorker.this.f12081N, 14.0f));
                            int[] iArr = new int[2];
                            GdtUnifiedCustomWorker.this.f12145X.getLocationInWindow(iArr);
                            int[] iArr2 = new int[2];
                            ((BaseUnifiedCustomWorker) GdtUnifiedCustomWorker.this).f12093q.getLocationInWindow(iArr2);
                            layoutParams.leftMargin = iArr[0];
                            layoutParams.topMargin = (iArr[1] - iArr2[1]) + ((BaseUnifiedCustomWorker) GdtUnifiedCustomWorker.this).f12093q.getTop();
                            NativeUnifiedADData nativeUnifiedADData = GdtUnifiedCustomWorker.this.f12148aa;
                            GdtUnifiedCustomWorker gdtUnifiedCustomWorker = GdtUnifiedCustomWorker.this;
                            nativeUnifiedADData.bindAdToView(gdtUnifiedCustomWorker.f12081N, gdtUnifiedCustomWorker.f12146Y, layoutParams, list);
                        }
                    }
                }, ((AdWorker) GdtUnifiedCustomWorker.this).f11804k != 2 ? 500L : 0L);
            }
        });
    }

    @Override // com.beizi.fusion.work.p083h.BaseUnifiedCustomWorker
    /* renamed from: b */
    public void mo47236b(boolean z) {
        m47322aY();
    }
}
