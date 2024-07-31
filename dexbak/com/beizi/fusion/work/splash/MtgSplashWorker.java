package com.beizi.fusion.work.splash;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.MBridgeSDKManager;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
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

/* renamed from: com.beizi.fusion.work.splash.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MtgSplashWorker extends AdWorker {

    /* renamed from: A */
    private String f12878A;

    /* renamed from: B */
    private boolean f12879B = false;

    /* renamed from: C */
    private boolean f12880C = false;

    /* renamed from: D */
    private boolean f12881D = false;

    /* renamed from: E */
    private boolean f12882E = false;

    /* renamed from: n */
    private BidResponsed f12883n;

    /* renamed from: o */
    private long f12884o;

    /* renamed from: p */
    private Context f12885p;

    /* renamed from: q */
    private String f12886q;

    /* renamed from: r */
    private long f12887r;

    /* renamed from: s */
    private ViewGroup f12888s;

    /* renamed from: t */
    private long f12889t;

    /* renamed from: u */
    private MBSplashHandler f12890u;

    /* renamed from: v */
    private BidManager f12891v;

    /* renamed from: w */
    private String f12892w;

    /* renamed from: x */
    private String f12893x;

    /* renamed from: y */
    private String f12894y;

    /* renamed from: z */
    private String f12895z;

    public MtgSplashWorker(Context context, String str, long j, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12885p = context;
        this.f12886q = str;
        this.f12887r = j;
        this.f12888s = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* renamed from: aH */
    private void m46079aH() {
        if (this.f12881D) {
            this.f11806m.sendEmptyMessageDelayed(1, this.f12889t);
            return;
        }
        m47914u();
        MBridgeSDKManager.m48989a().m48987a(this.f12885p, this.f12878A, this.f12895z, false, null, new MBridgeSDKManager.InterfaceC3040c() { // from class: com.beizi.fusion.work.splash.l.2
            @Override // com.beizi.fusion.MBridgeSDKManager.InterfaceC3040c
            /* renamed from: a */
            public void mo46033a(String str, String str2) {
                C3116af.m48495b("BeiZis", "MTG onInitSuccess");
                MtgSplashWorker.this.m47913v();
                if (MtgSplashWorker.this.f12885p instanceof Activity) {
                    MtgSplashWorker mtgSplashWorker = MtgSplashWorker.this;
                    mtgSplashWorker.m46070b((Activity) mtgSplashWorker.f12885p);
                    if (MtgSplashWorker.this.m47937am()) {
                        MtgSplashWorker mtgSplashWorker2 = MtgSplashWorker.this;
                        mtgSplashWorker2.m46081a(mtgSplashWorker2.f12893x, MtgSplashWorker.this.f12894y);
                    }
                }
                if (MtgSplashWorker.this.f12889t > 0) {
                    ((AdWorker) MtgSplashWorker.this).f11806m.sendEmptyMessageDelayed(1, MtgSplashWorker.this.f12889t);
                } else if (((AdWorker) MtgSplashWorker.this).f11797d == null || ((AdWorker) MtgSplashWorker.this).f11797d.m48667t() >= 1 || ((AdWorker) MtgSplashWorker.this).f11797d.m48668s() == 2) {
                } else {
                    MtgSplashWorker.this.mo46050l();
                }
            }

            @Override // com.beizi.fusion.MBridgeSDKManager.InterfaceC3040c
            /* renamed from: a */
            public void mo46034a(String str) {
                C3116af.m48495b("BeiZis", "MTG onInitFail");
                if (MtgSplashWorker.this.mo46073aa()) {
                    MtgSplashWorker.this.m47966a(3);
                    MtgSplashWorker.this.m47983L();
                    return;
                }
                MtgSplashWorker.this.m47926ax();
            }
        });
        this.f11795b.m48871z(MBConfiguration.SDK_VERSION);
        m47929au();
        this.f12881D = true;
    }

    /* renamed from: aI */
    private void m46078aI() {
        BidManager bidManager = this.f12891v;
        if (bidManager != null) {
            bidManager.setBidListener(new BidListennning() { // from class: com.beizi.fusion.work.splash.l.5
                @Override // com.mbridge.msdk.mbbid.out.BidListennning
                public void onFailed(String str) {
                    Log.d("BeiZis", "bid onFailed showMtgSplash onError:" + str);
                    MtgSplashWorker.this.m47966a(3);
                    MtgSplashWorker.this.m47983L();
                }

                @Override // com.mbridge.msdk.mbbid.out.BidListennning
                public void onSuccessed(BidResponsed bidResponsed) {
                    MtgSplashWorker.this.f12883n = bidResponsed;
                    MtgSplashWorker.this.f12892w = bidResponsed.getBidToken();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSuccessed: token ");
                    sb.append(MtgSplashWorker.this.f12892w);
                    sb.append(",mbSplashHandler != null ? ");
                    sb.append(MtgSplashWorker.this.f12890u != null);
                    C3116af.m48495b("BeiZis", sb.toString());
                    MtgSplashWorker.this.m46074aM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aJ */
    public void m46077aJ() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m47946ad();
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aK */
    private void m46076aK() {
        C3116af.m48495b("BeiZis", "enter finalShowAd");
        if (this.f12890u != null) {
            C3116af.m48495b("BeiZis", "finalShowAd isAdReady = " + this.f12890u.isReady(this.f12892w));
        }
        if (this.f12890u != null && m46075aL()) {
            ViewGroup viewGroup = this.f12888s;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                if (m47937am()) {
                    this.f12890u.show(this.f12888s, this.f12892w);
                    return;
                } else {
                    this.f12890u.show(this.f12888s);
                    return;
                }
            }
            m47927aw();
            return;
        }
        m47927aw();
    }

    /* renamed from: aL */
    private boolean m46075aL() {
        String str;
        if (this.f12890u == null) {
            return false;
        }
        if (m47937am() && (str = this.f12892w) != null) {
            return this.f12890u.isReady(str);
        }
        return this.f12890u.isReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aM */
    public void m46074aM() {
        double parseDouble;
        if (!m47909z() || this.f12883n == null) {
            return;
        }
        this.f11803j = AdStatus.ADLOAD;
        m47966a(2);
        if (this.f12883n.getPrice() != null) {
            try {
                if ("0".compareTo(this.f12883n.getPrice()) < 0) {
                    if ("USD".equalsIgnoreCase(this.f12883n.getCur())) {
                        parseDouble = Double.parseDouble(this.f12883n.getPrice()) * 6.400000095367432d;
                    } else {
                        parseDouble = Double.parseDouble(this.f12883n.getPrice());
                    }
                    double d = parseDouble * 100.0d;
                    C3116af.m48496a("BeiZisBid", "mtg splash price = " + d + ",currency = " + this.f12883n.getCur());
                    m47967a(d);
                }
                m47958aB();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        m47984K();
        mo46050l();
    }

    /* renamed from: aG */
    public void m46080aG() {
        MBSplashHandler mBSplashHandler = this.f12890u;
        if (mBSplashHandler == null || this.f12882E) {
            return;
        }
        mBSplashHandler.setSplashLoadListener(new MBSplashLoadListener() { // from class: com.beizi.fusion.work.splash.l.3
            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z) {
                C3116af.m48495b("BeiZis", "isSupportZoomOut: " + z + " ids" + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i) {
                Log.d("BeiZis", "onLoadFailed showMtgSplash onError:" + str);
                MtgSplashWorker.this.m47961a(str, 10132);
            }

            @Override // com.mbridge.msdk.out.MBSplashLoadListener
            public void onLoadSuccessed(MBridgeIds mBridgeIds, int i) {
                Log.d("BeiZis", "showMtgSplash onSplashAdLoad()");
                C3116af.m48496a("BeiZis", "showMtgSplash req to load time = " + (System.currentTimeMillis() - MtgSplashWorker.this.f12884o));
                ((AdWorker) MtgSplashWorker.this).f11803j = AdStatus.ADLOAD;
                MtgSplashWorker.this.m47938al();
                MtgSplashWorker.this.m47910y();
                if (MtgSplashWorker.this.m47970Y()) {
                    MtgSplashWorker.this.m46077aJ();
                } else {
                    MtgSplashWorker.this.m47980O();
                }
            }
        });
        this.f12890u.setSplashShowListener(new MBSplashShowListener() { // from class: com.beizi.fusion.work.splash.l.4
            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdClicked(MBridgeIds mBridgeIds) {
                Log.d("BeiZis", "showMtgSplash onAdClick()");
                MtgSplashWorker.this.m47990E();
                if (((AdWorker) MtgSplashWorker.this).f11797d != null) {
                    if (((AdWorker) MtgSplashWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) MtgSplashWorker.this).f11797d.m48700d(MtgSplashWorker.this.mo46059g());
                    }
                    MtgSplashWorker.this.m47941ai();
                }
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdTick(MBridgeIds mBridgeIds, long j) {
                C3116af.m48495b("BeiZis", "onAdTick: " + j + " " + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onDismiss(MBridgeIds mBridgeIds, int i) {
                Log.d("BeiZis", "showMtgSplash onAdTimeOver()");
                if (((AdWorker) MtgSplashWorker.this).f11797d != null && ((AdWorker) MtgSplashWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) MtgSplashWorker.this).f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.l.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MtgSplashWorker.this.m47947ac();
                        }
                    }, 200L);
                }
                MtgSplashWorker.this.m47988G();
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowFailed(MBridgeIds mBridgeIds, String str) {
                Log.d("BeiZis", "onShowFailed showMtgSplash onError:" + str);
                MtgSplashWorker.this.m47961a(str, 10132);
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowSuccessed(MBridgeIds mBridgeIds) {
                Log.d("BeiZis", "showMtgSplash onAdShow()");
                ((AdWorker) MtgSplashWorker.this).f11803j = AdStatus.ADSHOW;
                MtgSplashWorker.this.mo47585ab();
                MtgSplashWorker.this.m47992C();
                MtgSplashWorker.this.m47991D();
                MtgSplashWorker.this.m47942ah();
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayFinish(MBridgeIds mBridgeIds) {
                C3116af.m48495b("BeiZis", "onZoomOutPlayFinish: " + mBridgeIds.toString());
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayStart(MBridgeIds mBridgeIds) {
                C3116af.m48495b("BeiZis", "onZoomOutPlayStart: " + mBridgeIds.toString());
            }
        });
        this.f12882E = true;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: aa */
    protected boolean mo46073aa() {
        return true;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        if (this.f12880C) {
            return;
        }
        C3116af.m48495b("BeiZis", "enter sendWinNotice");
        BidResponsed bidResponsed = this.f12883n;
        if (bidResponsed != null) {
            bidResponsed.sendWinNotice(this.f12885p);
            this.f12880C = true;
        }
        super.mo46072az();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "MTG";
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
        this.f12884o = System.currentTimeMillis();
        try {
            this.f12893x = this.f11802i.split("_")[0];
            this.f12894y = this.f11802i.split("_")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f12895z = this.f11801h.split("_")[0];
            this.f12878A = this.f11801h.split("_")[1];
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        C3116af.m48495b("BeiZis", "mtg placementId = " + this.f12893x + ",adUnitId = " + this.f12894y + ",mtgAppId = " + this.f12895z + ",mtgAppKey = " + this.f12878A);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.mbridge.msdk.MBridgeSDK")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.l.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MtgSplashWorker.this.mo46073aa()) {
                                MtgSplashWorker.this.m47966a(3);
                                MtgSplashWorker.this.m47983L();
                                return;
                            }
                            MtgSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "MTG sdk not import , will do nothing");
                    return;
                }
                m46079aH();
            }
        }
        this.f12889t = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            this.f12889t = Math.max(this.f12889t, this.f11799f.getHotRequestDelay());
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46076aK();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        double parseDouble;
        BidResponsed bidResponsed = this.f12883n;
        if (bidResponsed == null || "0".compareTo(bidResponsed.getPrice()) >= 0) {
            return null;
        }
        if ("USD".equalsIgnoreCase(this.f12883n.getCur())) {
            parseDouble = Double.parseDouble(this.f12883n.getPrice()) * 6.400000095367432d;
        } else {
            parseDouble = Double.parseDouble(this.f12883n.getPrice());
        }
        return (parseDouble * 100.0d) + "";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        if (m47937am()) {
            if (this.f12883n != null) {
                m46080aG();
                C3116af.m48495b("BeiZis", "mtg bid second step mbSplashHandler = " + this.f12890u + ",token = " + this.f12892w);
                mo46072az();
                if (this.f12890u != null) {
                    m47912w();
                    m47943ag();
                    this.f12890u.preLoadByToken(this.f12892w);
                    return;
                }
                return;
            }
            C3116af.m48495b("BeiZis", "mtg bid first step");
            m46078aI();
            m46071b();
            return;
        }
        m47912w();
        m47943ag();
        m46080aG();
        this.f12890u.preLoad();
    }

    /* renamed from: b */
    public void m46070b(Activity activity) {
        try {
            MBSplashHandler mBSplashHandler = new MBSplashHandler(activity, this.f12893x, this.f12894y);
            this.f12890u = mBSplashHandler;
            mBSplashHandler.setLoadTimeOut(this.f12887r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m46081a(String str, String str2) {
        this.f12891v = new BidManager(new SplashBidRequestParams(str, str2, true, 2, 30, 30));
    }

    /* renamed from: b */
    public void m46071b() {
        BidManager bidManager = this.f12891v;
        if (bidManager != null) {
            bidManager.bid();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        BidResponsed bidResponsed;
        if (this.f12879B) {
            return;
        }
        C3116af.m48495b("BeiZis", "enter sendLoseNotice state = " + i);
        if (i == 1) {
            BidResponsed bidResponsed2 = this.f12883n;
            if (bidResponsed2 != null) {
                bidResponsed2.sendLossNotice(this.f12885p, BidLossCode.bidPriceNotHighest());
                this.f12879B = true;
            }
        } else if (i == 2) {
            BidResponsed bidResponsed3 = this.f12883n;
            if (bidResponsed3 != null) {
                bidResponsed3.sendLossNotice(this.f12885p, BidLossCode.bidTimeOut());
                this.f12879B = true;
            }
        } else if (i == 3 && (bidResponsed = this.f12883n) != null) {
            bidResponsed.sendLossNotice(this.f12885p, BidLossCode.bidWinButNotShow());
            this.f12879B = true;
        }
        super.mo46064d(i);
    }
}
