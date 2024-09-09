package com.beizi.fusion.work.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.k;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.al;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.n;
import com.beizi.fusion.g.v;
import com.beizi.fusion.model.AdSpacesBean;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GdtBannerAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15437n;

    /* renamed from: o  reason: collision with root package name */
    private String f15438o;

    /* renamed from: p  reason: collision with root package name */
    private long f15439p;

    /* renamed from: q  reason: collision with root package name */
    private long f15440q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f15441r;

    /* renamed from: s  reason: collision with root package name */
    private UnifiedBannerView f15442s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f15443t;

    /* renamed from: u  reason: collision with root package name */
    private float f15444u;

    /* renamed from: v  reason: collision with root package name */
    private float f15445v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f15446w;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GdtBannerAdWorker.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements UnifiedBannerADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f15448a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15449b;

        private a() {
            this.f15448a = false;
            this.f15449b = false;
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            Log.d("BeiZis", "showGdtBannerAd onADClicked()");
            if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
            }
            if (this.f15449b) {
                return;
            }
            this.f15449b = true;
            d.this.E();
            d.this.ai();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            Log.d("BeiZis", "showGdtBannerAd onADClosed()");
            if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.g());
            }
            d.this.G();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            Log.d("BeiZis", "showGdtBannerAd onADExposure()");
            ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
            if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                ((com.beizi.fusion.work.a) d.this).f15367d.b(d.this.g());
            }
            if (this.f15448a) {
                return;
            }
            this.f15448a = true;
            d.this.az();
            d.this.C();
            d.this.D();
            d.this.ah();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            Log.d("BeiZis", "showGdtBannerAd onADLeftApplication()");
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            Log.d("BeiZis", "showGdtBannerAd onADReceive()");
            if (d.this.f15442s.getECPM() > 0) {
                d dVar = d.this;
                dVar.a(dVar.f15442s.getECPM());
            }
            if (v.f14982a) {
                d.this.f15442s.setDownloadConfirmListener(v.f14983b);
            }
            ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
            d.this.y();
            if (!d.this.Y()) {
                d.this.O();
            } else {
                d.this.b();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            Log.d("BeiZis", "showGdtBannerAd onError:" + adError.getErrorMsg());
            d.this.a(adError.getErrorMsg(), adError.getErrorCode());
            if (d.this.f15446w) {
                return;
            }
            d.this.m();
        }
    }

    public d(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar, float f4, float f5, ViewGroup viewGroup) {
        this.f15437n = context;
        this.f15438o = str;
        this.f15439p = j4;
        this.f15440q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15444u = f4;
        this.f15445v = f5;
        this.f15443t = viewGroup;
        r();
    }

    private ViewGroup.LayoutParams aG() {
        if (this.f15444u <= 0.0f) {
            this.f15444u = aw.j(this.f15437n);
        }
        if (this.f15445v <= 0.0f) {
            this.f15445v = Math.round(this.f15444u / 6.4f);
        }
        return new ViewGroup.LayoutParams(aw.a(this.f15437n, this.f15444u), aw.a(this.f15437n, this.f15445v));
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15442s == null) {
            return;
        }
        al();
        int a4 = al.a(this.f15368e.getPriceDict(), this.f15442s.getECPMLevel());
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
        UnifiedBannerView unifiedBannerView = this.f15442s;
        if (unifiedBannerView == null || unifiedBannerView.getECPM() <= 0 || this.f15441r) {
            return;
        }
        this.f15441r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "channel == sendWinNoticeECPM" + this.f15442s.getECPM());
        UnifiedBannerView unifiedBannerView2 = this.f15442s;
        k.a(unifiedBannerView2, unifiedBannerView2.getECPM());
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
                if (!aw.a("com.qq.e.ads.banner2.UnifiedBannerView")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "GDT sdk not import , will do nothing");
                    return;
                }
                u();
                k.a(this.f15437n, this.f15371h);
                this.f15365b.s(SDKStatus.getIntegrationSDKVersion());
                au();
                v();
            }
        }
        v.f14982a = !n.a(this.f15368e.getDirectDownload());
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15440q);
        long j4 = this.f15440q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        ViewGroup viewGroup;
        Log.d("BeiZis", "showGdtBannerAd showAd()");
        if (this.f15442s != null && (viewGroup = this.f15443t) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15443t.removeAllViews();
            }
            this.f15446w = true;
            this.f15443t.addView(this.f15442s, aG());
            return;
        }
        aw();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        UnifiedBannerView unifiedBannerView = this.f15442s;
        if (unifiedBannerView != null) {
            int a4 = al.a(this.f15368e.getPriceDict(), unifiedBannerView.getECPMLevel());
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
        this.f15446w = false;
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            this.f15442s = new UnifiedBannerView((Activity) this.f15437n, this.f15372i, new a(), null, aC());
        } else {
            this.f15442s = new UnifiedBannerView((Activity) this.f15437n, this.f15372i, new a());
        }
        this.f15442s.loadAD();
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        UnifiedBannerView unifiedBannerView = this.f15442s;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ViewGroup viewGroup;
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " BannerAdWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15442s != null && (viewGroup = this.f15443t) != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f15443t.removeAllViews();
                }
                this.f15446w = true;
                this.f15443t.addView(this.f15442s, aG());
                this.f15367d.a(g(), (View) null);
                return;
            }
            this.f15367d.a(10140);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        UnifiedBannerView unifiedBannerView = this.f15442s;
        if (unifiedBannerView == null || unifiedBannerView.getECPM() <= 0 || this.f15441r) {
            return;
        }
        this.f15441r = true;
        af.a("BeiZis", "channel == GDT\u7ade\u4ef7\u5931\u8d25:" + i4);
        k.b(this.f15442s, i4 != 1 ? 10001 : 1);
    }
}
