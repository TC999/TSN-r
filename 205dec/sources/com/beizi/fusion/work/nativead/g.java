package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.ak;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GdtNativeAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15882n;

    /* renamed from: o  reason: collision with root package name */
    private String f15883o;

    /* renamed from: p  reason: collision with root package name */
    private long f15884p;

    /* renamed from: q  reason: collision with root package name */
    private long f15885q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15886r;

    /* renamed from: s  reason: collision with root package name */
    private NativeExpressAD f15887s;

    /* renamed from: t  reason: collision with root package name */
    private NativeExpressADView f15888t;

    /* renamed from: u  reason: collision with root package name */
    private float f15889u;

    /* renamed from: v  reason: collision with root package name */
    private float f15890v;

    /* renamed from: w  reason: collision with root package name */
    private View f15891w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f15892x;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GdtNativeAdWorker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f15894a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15895b;

        private a() {
            this.f15894a = false;
            this.f15895b = false;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADClicked()");
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) g.this).f15367d.d(g.this.g());
            }
            if (this.f15895b) {
                return;
            }
            this.f15895b = true;
            g.this.E();
            g.this.ai();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADClosed()");
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) g.this).f15367d.b(g.this.g(), g.this.f15891w);
            }
            g.this.G();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADExposure()");
            ((com.beizi.fusion.work.a) g.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (((com.beizi.fusion.work.a) g.this).f15367d != null && ((com.beizi.fusion.work.a) g.this).f15367d.s() != 2) {
                ((com.beizi.fusion.work.a) g.this).f15367d.b(g.this.g());
            }
            if (this.f15894a) {
                return;
            }
            this.f15894a = true;
            g.this.az();
            g.this.C();
            g.this.D();
            g.this.ah();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onADLeftApplication()");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            Log.d("BeiZis", "showGdtNativeAd onADLoad()");
            ((com.beizi.fusion.work.a) g.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            g.this.y();
            if (list != null && list.size() != 0) {
                if (g.this.f15888t != null) {
                    g.this.f15888t.destroy();
                }
                g.this.f15888t = list.get(0);
                if (g.this.f15888t.getECPM() > 0) {
                    g gVar = g.this;
                    gVar.a(gVar.f15888t.getECPM());
                }
                if (v.f14982a) {
                    g.this.f15888t.setDownloadConfirmListener(v.f14983b);
                }
                if (g.this.f15888t.getBoundData().getAdPatternType() == 2) {
                    g.this.f15892x = true;
                    g.this.f15888t.setMediaListener(new NativeExpressMediaListener() { // from class: com.beizi.fusion.work.nativead.g.a.1
                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoCached(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoCached()");
                            g.this.aG();
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoComplete()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoError()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoInit(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoInit()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoLoading()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPageClose()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPageOpen()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoPause(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoPause()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoReady(NativeExpressADView nativeExpressADView, long j4) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoReady()");
                        }

                        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                        public void onVideoStart(NativeExpressADView nativeExpressADView) {
                            Log.d("BeiZis", "showGdtNativeAd onVideoStart()");
                        }
                    });
                    g.this.f15888t.preloadVideo();
                }
                g gVar2 = g.this;
                gVar2.f15891w = gVar2.f15888t;
                if (g.this.f15892x) {
                    return;
                }
                g.this.aG();
                return;
            }
            g.this.c(-991);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtNativeAd onError:" + adError.getErrorMsg());
            g.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onRenderFail()");
            g.this.a("sdk custom error ".concat("Render Fail"), 99991);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            Log.d("BeiZis", "showGdtNativeAd onRenderSuccess()");
        }
    }

    public g(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15882n = context;
        this.f15883o = str;
        this.f15884p = j4;
        this.f15885q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15889u = f4;
        this.f15890v = f5;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        NativeExpressADView nativeExpressADView = this.f15888t;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
        if (Y()) {
            b();
        } else {
            O();
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15888t == null) {
            return;
        }
        al();
        int a4 = ak.a(this.f15368e.getPriceDict(), this.f15888t.getECPMLevel());
        if (a4 == -1 || a4 == -2) {
            if (a4 == -2) {
                L();
                return;
            }
            return;
        }
        Log.d("BeiZisBid", "gdt realPrice = " + a4);
        a((double) a4);
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        NativeExpressADView nativeExpressADView = this.f15888t;
        if (nativeExpressADView == null || nativeExpressADView.getECPM() <= 0 || this.f15886r) {
            return;
        }
        this.f15886r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15888t.getECPM());
        NativeExpressADView nativeExpressADView2 = this.f15888t;
        k.a(nativeExpressADView2, nativeExpressADView2.getECPM());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a(AMPSConstants.CHANNEL_SDK_GDT_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15882n, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15885q);
        long j4 = this.f15885q;
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

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        NativeExpressADView nativeExpressADView = this.f15888t;
        if (nativeExpressADView != null) {
            int a4 = ak.a(this.f15368e.getPriceDict(), nativeExpressADView.getECPMLevel());
            if (a4 == -1 || a4 == -2) {
                return null;
            }
            return a4 + "";
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        if (this.f15889u <= 0.0f) {
            this.f15889u = -1.0f;
        }
        if (this.f15890v <= 0.0f) {
            this.f15890v = -2.0f;
        }
        this.f15892x = false;
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15887s = new NativeExpressAD(this.f15882n, new ADSize((int) this.f15889u, (int) this.f15890v), this.f15372i, new a(), aC());
        } else {
            this.f15887s = new NativeExpressAD(this.f15882n, new ADSize((int) this.f15889u, (int) this.f15890v), this.f15372i, new a());
        }
        this.f15887s.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
        this.f15887s.loadAD(1);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        NativeExpressADView nativeExpressADView = this.f15888t;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15891w;
    }

    private void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorker:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            if (this.f15888t != null) {
                this.f15367d.a(g(), this.f15888t);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        NativeExpressADView nativeExpressADView = this.f15888t;
        if (nativeExpressADView == null || nativeExpressADView.getECPM() <= 0 || this.f15886r) {
            return;
        }
        this.f15886r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15888t, i4 != 1 ? 10001 : 1);
    }
}
