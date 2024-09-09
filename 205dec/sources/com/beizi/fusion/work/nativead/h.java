package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.ak;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GdtNativeCustomWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class h extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15898n;

    /* renamed from: o  reason: collision with root package name */
    private String f15899o;

    /* renamed from: p  reason: collision with root package name */
    private long f15900p;

    /* renamed from: q  reason: collision with root package name */
    private long f15901q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15902r;

    /* renamed from: s  reason: collision with root package name */
    private NativeUnifiedAD f15903s;

    /* renamed from: t  reason: collision with root package name */
    private NativeUnifiedADData f15904t;

    /* renamed from: u  reason: collision with root package name */
    private float f15905u;

    /* renamed from: v  reason: collision with root package name */
    private float f15906v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f15907w;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GdtNativeCustomWorker.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements NativeADUnifiedListener {
        private a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            Log.d("BeiZis", "ShowGdtNativeCustom onADLoaded()");
            ((com.beizi.fusion.work.a) h.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            h.this.y();
            if (list == null || list.size() == 0) {
                h.this.c(-991);
                return;
            }
            h.this.f15904t = list.get(0);
            if (h.this.f15904t == null) {
                h.this.c(-991);
                return;
            }
            if (h.this.f15904t.getECPM() > 0) {
                h hVar = h.this;
                hVar.a(hVar.f15904t.getECPM());
            }
            if (v.f14982a) {
                h.this.f15904t.setDownloadConfirmListener(v.f14983b);
            }
            NativeADEventListener nativeADEventListener = new NativeADEventListener() { // from class: com.beizi.fusion.work.nativead.h.a.1

                /* renamed from: a  reason: collision with root package name */
                boolean f15910a = false;

                /* renamed from: b  reason: collision with root package name */
                boolean f15911b = false;

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADClicked()");
                    if (((com.beizi.fusion.work.a) h.this).f15367d != null && ((com.beizi.fusion.work.a) h.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) h.this).f15367d.d(h.this.g());
                    }
                    if (this.f15911b) {
                        return;
                    }
                    this.f15911b = true;
                    h.this.E();
                    h.this.ai();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADError: " + adError.getErrorMsg());
                    h.this.a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onExposed()");
                    ((com.beizi.fusion.work.a) h.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) h.this).f15367d != null && ((com.beizi.fusion.work.a) h.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) h.this).f15367d.b(h.this.g());
                    }
                    if (this.f15910a) {
                        return;
                    }
                    this.f15910a = true;
                    h.this.az();
                    h.this.C();
                    h.this.D();
                    h.this.ah();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADStatusChanged()");
                }
            };
            NativeADMediaListener nativeADMediaListener = new NativeADMediaListener() { // from class: com.beizi.fusion.work.nativead.h.a.2

                /* renamed from: a  reason: collision with root package name */
                boolean f15913a = false;

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoClicked()");
                    if (((com.beizi.fusion.work.a) h.this).f15367d != null && ((com.beizi.fusion.work.a) h.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) h.this).f15367d.d(h.this.g());
                    }
                    if (this.f15913a) {
                        return;
                    }
                    this.f15913a = true;
                    h.this.E();
                    h.this.ai();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoCompleted()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoError: " + adError.getErrorMsg());
                    h.this.a(adError.getErrorMsg(), adError.getErrorCode());
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoInit()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i4) {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoLoaded()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoLoading()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoPause()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoReady()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoResume()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoStart()");
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                    Log.d("BeiZis", "ShowGdtNativeCustom MediaView onVideoStop()");
                }
            };
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.h.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("BeiZis", "ShowGdtNativeCustom onADClosed()");
                    if (((com.beizi.fusion.work.a) h.this).f15367d != null && ((com.beizi.fusion.work.a) h.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) h.this).f15367d.b(h.this.g(), h.this.f15907w);
                    }
                    h.this.G();
                }
            };
            GdtNativeCustomLayout gdtNativeCustomLayout = new GdtNativeCustomLayout(h.this.f15898n);
            gdtNativeCustomLayout.onBindData(h.this.f15904t, h.this.f15905u, h.this.f15906v, nativeADEventListener, nativeADMediaListener, onClickListener);
            h.this.f15907w = gdtNativeCustomLayout;
            h.this.aG();
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "ShowGdtNativeCustom onNoAD: " + adError.getErrorMsg());
            h.this.a(adError.getErrorMsg(), adError.getErrorCode());
        }
    }

    public h(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15898n = context;
        this.f15899o = str;
        this.f15900p = j4;
        this.f15901q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15905u = f4;
        this.f15906v = f5;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        if (Y()) {
            b();
        } else {
            O();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        NativeUnifiedADData nativeUnifiedADData = this.f15904t;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15902r) {
            return;
        }
        this.f15902r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15904t.getECPM());
        NativeUnifiedADData nativeUnifiedADData2 = this.f15904t;
        k.a(nativeUnifiedADData2, nativeUnifiedADData2.getECPM());
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT;
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15904t == null) {
            return;
        }
        al();
        int a4 = ak.a(this.f15368e.getPriceDict(), this.f15904t.getECPMLevel());
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
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15898n, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15901q);
        long j4 = this.f15901q;
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
        NativeUnifiedADData nativeUnifiedADData = this.f15904t;
        if (nativeUnifiedADData != null) {
            int a4 = ak.a(this.f15368e.getPriceDict(), nativeUnifiedADData.getECPMLevel());
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
        if (this.f15905u <= 0.0f) {
            this.f15905u = av.j(this.f15898n);
        }
        if (this.f15906v <= 0.0f) {
            this.f15906v = 0.0f;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15903s = new NativeUnifiedAD(this.f15898n, this.f15372i, new a(), aC());
        } else {
            this.f15903s = new NativeUnifiedAD(this.f15898n, this.f15372i, new a());
        }
        this.f15903s.loadData(1);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        NativeUnifiedADData nativeUnifiedADData = this.f15904t;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void n() {
        NativeUnifiedADData nativeUnifiedADData = this.f15904t;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15907w;
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
            if (this.f15907w != null) {
                this.f15367d.a(g(), this.f15907w);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        NativeUnifiedADData nativeUnifiedADData = this.f15904t;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getECPM() <= 0 || this.f15902r) {
            return;
        }
        this.f15902r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15904t, i4 != 1 ? 10001 : 1);
    }
}
