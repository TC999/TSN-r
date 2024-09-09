package com.beizi.fusion.work.splash;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.b;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidLossCode;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.mbbid.out.SplashBidRequestParams;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.out.MBSplashHandler;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MtgSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l extends com.beizi.fusion.work.a {
    private String A;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;

    /* renamed from: n  reason: collision with root package name */
    private BidResponsed f16184n;

    /* renamed from: o  reason: collision with root package name */
    private long f16185o;

    /* renamed from: p  reason: collision with root package name */
    private Context f16186p;

    /* renamed from: q  reason: collision with root package name */
    private String f16187q;

    /* renamed from: r  reason: collision with root package name */
    private long f16188r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f16189s;

    /* renamed from: t  reason: collision with root package name */
    private long f16190t;

    /* renamed from: u  reason: collision with root package name */
    private MBSplashHandler f16191u;

    /* renamed from: v  reason: collision with root package name */
    private BidManager f16192v;

    /* renamed from: w  reason: collision with root package name */
    private String f16193w;

    /* renamed from: x  reason: collision with root package name */
    private String f16194x;

    /* renamed from: y  reason: collision with root package name */
    private String f16195y;

    /* renamed from: z  reason: collision with root package name */
    private String f16196z;

    public l(Context context, String str, long j4, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f16186p = context;
        this.f16187q = str;
        this.f16188r = j4;
        this.f16189s = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    private void aH() {
        if (this.D) {
            this.f15376m.sendEmptyMessageDelayed(1, this.f16190t);
            return;
        }
        u();
        com.beizi.fusion.b.a().a(this.f16186p, this.A, this.f16196z, false, null, new b.c() { // from class: com.beizi.fusion.work.splash.l.2
            @Override // com.beizi.fusion.b.c
            public void a(String str, String str2) {
                af.b("BeiZis", "MTG onInitSuccess");
                l.this.v();
                if (l.this.f16186p instanceof Activity) {
                    l lVar = l.this;
                    lVar.b((Activity) lVar.f16186p);
                    if (l.this.am()) {
                        l lVar2 = l.this;
                        lVar2.a(lVar2.f16194x, l.this.f16195y);
                    }
                }
                if (l.this.f16190t > 0) {
                    ((com.beizi.fusion.work.a) l.this).f15376m.sendEmptyMessageDelayed(1, l.this.f16190t);
                } else if (((com.beizi.fusion.work.a) l.this).f15367d == null || ((com.beizi.fusion.work.a) l.this).f15367d.t() >= 1 || ((com.beizi.fusion.work.a) l.this).f15367d.s() == 2) {
                } else {
                    l.this.l();
                }
            }

            @Override // com.beizi.fusion.b.c
            public void a(String str) {
                af.b("BeiZis", "MTG onInitFail");
                if (l.this.aa()) {
                    l.this.a(3);
                    l.this.L();
                    return;
                }
                l.this.ax();
            }
        });
        this.f15365b.z(MBConfiguration.SDK_VERSION);
        au();
        this.D = true;
    }

    private void aI() {
        BidManager bidManager = this.f16192v;
        if (bidManager != null) {
            bidManager.setBidListener(new BidListennning() { // from class: com.beizi.fusion.work.splash.l.5
                @Override // com.mbridge.msdk.mbbid.out.BidListennning
                public void onFailed(String str) {
                    Log.d("BeiZis", "bid onFailed showMtgSplash onError:" + str);
                    l.this.a(3);
                    l.this.L();
                }

                @Override // com.mbridge.msdk.mbbid.out.BidListennning
                public void onSuccessed(BidResponsed bidResponsed) {
                    l.this.f16184n = bidResponsed;
                    l.this.f16193w = bidResponsed.getBidToken();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSuccessed: token ");
                    sb.append(l.this.f16193w);
                    sb.append(",mbSplashHandler != null ? ");
                    sb.append(l.this.f16191u != null);
                    af.b("BeiZis", sb.toString());
                    l.this.aM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            ad();
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    private void aK() {
        af.b("BeiZis", "enter finalShowAd");
        if (this.f16191u != null) {
            af.b("BeiZis", "finalShowAd isAdReady = " + this.f16191u.isReady(this.f16193w));
        }
        if (this.f16191u != null && aL()) {
            ViewGroup viewGroup = this.f16189s;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                if (am()) {
                    this.f16191u.show(this.f16189s, this.f16193w);
                    return;
                } else {
                    this.f16191u.show(this.f16189s);
                    return;
                }
            }
            aw();
            return;
        }
        aw();
    }

    private boolean aL() {
        String str;
        if (this.f16191u == null) {
            return false;
        }
        if (am() && (str = this.f16193w) != null) {
            return this.f16191u.isReady(str);
        }
        return this.f16191u.isReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM() {
        double parseDouble;
        if (!z() || this.f16184n == null) {
            return;
        }
        this.f15373j = com.beizi.fusion.f.a.ADLOAD;
        a(2);
        if (this.f16184n.getPrice() != null) {
            try {
                if ("0".compareTo(this.f16184n.getPrice()) < 0) {
                    if ("USD".equalsIgnoreCase(this.f16184n.getCur())) {
                        parseDouble = Double.parseDouble(this.f16184n.getPrice()) * 6.400000095367432d;
                    } else {
                        parseDouble = Double.parseDouble(this.f16184n.getPrice());
                    }
                    double d4 = parseDouble * 100.0d;
                    af.a("BeiZisBid", "mtg splash price = " + d4 + ",currency = " + this.f16184n.getCur());
                    a(d4);
                }
                aB();
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
        }
        K();
        l();
    }

    public void aG() {
        MBSplashHandler mBSplashHandler = this.f16191u;
        if (mBSplashHandler == null || this.E) {
            return;
        }
        mBSplashHandler.setSplashLoadListener(new MBSplashLoadListener() { // from class: com.beizi.fusion.work.splash.l.3
            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z3) {
                af.b("BeiZis", "isSupportZoomOut: " + z3 + " ids" + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i4) {
                Log.d("BeiZis", "onLoadFailed showMtgSplash onError:" + str);
                l.this.a(str, 10132);
            }

            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void onLoadSuccessed(MBridgeIds mBridgeIds, int i4) {
                Log.d("BeiZis", "showMtgSplash onSplashAdLoad()");
                af.a("BeiZis", "showMtgSplash req to load time = " + (System.currentTimeMillis() - l.this.f16185o));
                ((com.beizi.fusion.work.a) l.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                l.this.al();
                l.this.y();
                if (l.this.Y()) {
                    l.this.aJ();
                } else {
                    l.this.O();
                }
            }
        });
        this.f16191u.setSplashShowListener(new MBSplashShowListener() { // from class: com.beizi.fusion.work.splash.l.4
            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdClicked(MBridgeIds mBridgeIds) {
                Log.d("BeiZis", "showMtgSplash onAdClick()");
                l.this.E();
                if (((com.beizi.fusion.work.a) l.this).f15367d != null) {
                    if (((com.beizi.fusion.work.a) l.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) l.this).f15367d.d(l.this.g());
                    }
                    l.this.ai();
                }
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdTick(MBridgeIds mBridgeIds, long j4) {
                af.b("BeiZis", "onAdTick: " + j4 + " " + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onDismiss(MBridgeIds mBridgeIds, int i4) {
                Log.d("BeiZis", "showMtgSplash onAdTimeOver()");
                if (((com.beizi.fusion.work.a) l.this).f15367d != null && ((com.beizi.fusion.work.a) l.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) l.this).f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.l.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            l.this.ac();
                        }
                    }, 200L);
                }
                l.this.G();
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowFailed(MBridgeIds mBridgeIds, String str) {
                Log.d("BeiZis", "onShowFailed showMtgSplash onError:" + str);
                l.this.a(str, 10132);
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowSuccessed(MBridgeIds mBridgeIds) {
                Log.d("BeiZis", "showMtgSplash onAdShow()");
                ((com.beizi.fusion.work.a) l.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                l.this.ab();
                l.this.C();
                l.this.D();
                l.this.ah();
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayFinish(MBridgeIds mBridgeIds) {
                af.b("BeiZis", "onZoomOutPlayFinish: " + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayStart(MBridgeIds mBridgeIds) {
                af.b("BeiZis", "onZoomOutPlayStart: " + mBridgeIds.toString());
            }
        });
        this.E = true;
    }

    @Override // com.beizi.fusion.work.a
    protected boolean aa() {
        return true;
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        if (this.C) {
            return;
        }
        af.b("BeiZis", "enter sendWinNotice");
        BidResponsed bidResponsed = this.f16184n;
        if (bidResponsed != null) {
            bidResponsed.sendWinNotice(this.f16186p);
            this.C = true;
        }
        super.az();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "MTG";
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        this.f16185o = System.currentTimeMillis();
        try {
            this.f16194x = this.f15372i.split("_")[0];
            this.f16195y = this.f15372i.split("_")[1];
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            this.f16196z = this.f15371h.split("_")[0];
            this.A = this.f15371h.split("_")[1];
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        af.b("BeiZis", "mtg placementId = " + this.f16194x + ",adUnitId = " + this.f16195y + ",mtgAppId = " + this.f16196z + ",mtgAppKey = " + this.A);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a("com.mbridge.msdk.MBridgeSDK")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.l.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (l.this.aa()) {
                                l.this.a(3);
                                l.this.L();
                                return;
                            }
                            l.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "MTG sdk not import , will do nothing");
                    return;
                }
                aH();
            }
        }
        this.f16190t = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            this.f16190t = Math.max(this.f16190t, this.f15369f.getHotRequestDelay());
        }
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", g() + " out make show ad");
        aK();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        double parseDouble;
        BidResponsed bidResponsed = this.f16184n;
        if (bidResponsed == null || "0".compareTo(bidResponsed.getPrice()) >= 0) {
            return null;
        }
        if ("USD".equalsIgnoreCase(this.f16184n.getCur())) {
            parseDouble = Double.parseDouble(this.f16184n.getPrice()) * 6.400000095367432d;
        } else {
            parseDouble = Double.parseDouble(this.f16184n.getPrice());
        }
        return (parseDouble * 100.0d) + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        if (am()) {
            if (this.f16184n != null) {
                aG();
                af.b("BeiZis", "mtg bid second step mbSplashHandler = " + this.f16191u + ",token = " + this.f16193w);
                az();
                if (this.f16191u != null) {
                    w();
                    ag();
                    this.f16191u.preLoadByToken(this.f16193w);
                    return;
                }
                return;
            }
            af.b("BeiZis", "mtg bid first step");
            aI();
            b();
            return;
        }
        w();
        ag();
        aG();
        this.f16191u.preLoad();
    }

    public void b(Activity activity) {
        try {
            MBSplashHandler mBSplashHandler = new MBSplashHandler(activity, this.f16194x, this.f16195y);
            this.f16191u = mBSplashHandler;
            mBSplashHandler.setLoadTimeOut(this.f16188r);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f16192v = new BidManager(new SplashBidRequestParams(str, str2, true, 2, 30, 30));
    }

    public void b() {
        BidManager bidManager = this.f16192v;
        if (bidManager != null) {
            bidManager.bid();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        BidResponsed bidResponsed;
        if (this.B) {
            return;
        }
        af.b("BeiZis", "enter sendLoseNotice state = " + i4);
        if (i4 == 1) {
            BidResponsed bidResponsed2 = this.f16184n;
            if (bidResponsed2 != null) {
                bidResponsed2.sendLossNotice(this.f16186p, BidLossCode.bidPriceNotHighest());
                this.B = true;
            }
        } else if (i4 == 2) {
            BidResponsed bidResponsed3 = this.f16184n;
            if (bidResponsed3 != null) {
                bidResponsed3.sendLossNotice(this.f16186p, BidLossCode.bidTimeOut());
                this.B = true;
            }
        } else if (i4 == 3 && (bidResponsed = this.f16184n) != null) {
            bidResponsed.sendLossNotice(this.f16186p, BidLossCode.bidWinButNotShow());
            this.B = true;
        }
        super.d(i4);
    }
}
