package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.ad.AdListener;
import com.beizi.ad.AdRequest;
import com.beizi.ad.InterstitialAd;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.au;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiInterstitialWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: o  reason: collision with root package name */
    private Context f15697o;

    /* renamed from: p  reason: collision with root package name */
    private String f15698p;

    /* renamed from: q  reason: collision with root package name */
    private long f15699q;

    /* renamed from: r  reason: collision with root package name */
    private long f15700r;

    /* renamed from: s  reason: collision with root package name */
    private InterstitialAd f15701s;

    /* renamed from: t  reason: collision with root package name */
    private AdSpacesBean.UniteControlBean f15702t;

    /* renamed from: u  reason: collision with root package name */
    private int f15703u;

    /* renamed from: n  reason: collision with root package name */
    protected String f15696n = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15704v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f15705w = false;

    public a(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15697o = context;
        this.f15698p = str;
        this.f15699q = j4;
        this.f15700r = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", "splashWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            this.f15367d.a(g(), (View) null);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        aI();
        aJ();
        aK();
        aL();
        aM();
    }

    private void aI() {
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = this.f15368e.getRegionalClickView();
        if (regionalClickView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a4 = a(regionalClickView.getOrderData(), this.f15701s.getAdId());
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = null;
        if (a4 != null && a4.getRegionalClickView() != null) {
            regionalClickViewBean = a4.getRegionalClickView();
        }
        if (regionalClickViewBean != null) {
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.J(regionalClickViewBean.getRegionalClickUuid());
                au();
                return;
            }
            return;
        }
        com.beizi.fusion.b.b bVar2 = this.f15365b;
        if (bVar2 != null) {
            bVar2.J(regionalClickView.getRegionalClickUuid());
            au();
        }
    }

    private void aJ() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = this.f15368e.getFullScreenClick();
        if (fullScreenClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b4 = b(fullScreenClick.getOrderData(), this.f15701s.getAdId());
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean = null;
        if (b4 != null && b4.getFullScreenClick() != null) {
            fullScreenClickBean = b4.getFullScreenClick();
        }
        if (fullScreenClickBean != null) {
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.I(fullScreenClickBean.getFullScreenClickUuid());
                au();
                return;
            }
            return;
        }
        com.beizi.fusion.b.b bVar2 = this.f15365b;
        if (bVar2 != null) {
            bVar2.I(fullScreenClick.getFullScreenClickUuid());
            au();
        }
    }

    private void aK() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f15368e.getShakeView();
        if (shakeView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean c4 = c(shakeView.getOrderData(), this.f15701s.getAdId());
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = null;
        if (c4 != null && c4.getShakeView() != null) {
            shakeViewBean = c4.getShakeView();
        }
        if (shakeViewBean != null) {
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.G(shakeViewBean.getShakeViewUuid());
                au();
                return;
            }
            return;
        }
        com.beizi.fusion.b.b bVar2 = this.f15365b;
        if (bVar2 != null) {
            bVar2.G(shakeView.getShakeViewUuid());
            au();
        }
    }

    private void aL() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = this.f15368e.getScrollClick();
        if (scrollClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d4 = d(scrollClick.getOrderData(), this.f15701s.getAdId());
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = null;
        if (d4 != null && d4.getScrollClick() != null) {
            scrollClickBean = d4.getScrollClick();
        }
        if (scrollClickBean != null) {
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.F(scrollClickBean.getScrollClickUuid());
                au();
                return;
            }
            return;
        }
        com.beizi.fusion.b.b bVar2 = this.f15365b;
        if (bVar2 != null) {
            bVar2.F(scrollClick.getScrollClickUuid());
            au();
        }
    }

    private void aM() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f15368e.getEulerAngleRule();
        if (eulerAngleRule == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean e4 = e(eulerAngleRule.getOrderData(), this.f15701s.getAdId());
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = null;
        if (e4 != null && e4.getEulerAngleRule() != null) {
            eulerAngleViewBean = e4.getEulerAngleRule();
        }
        if (eulerAngleViewBean != null) {
            com.beizi.fusion.b.b bVar = this.f15365b;
            if (bVar != null) {
                bVar.R(eulerAngleViewBean.getEulerAngleUuid());
                au();
                return;
            }
            return;
        }
        com.beizi.fusion.b.b bVar2 = this.f15365b;
        if (bVar2 != null) {
            bVar2.R(eulerAngleRule.getEulerAngleUuid());
            au();
        }
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean c(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean e(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        InterstitialAd interstitialAd;
        if (z() && (interstitialAd = this.f15701s) != null && interstitialAd.isLoaded()) {
            al();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
        r6.f15705w = com.beizi.fusion.g.am.a(java.lang.Integer.parseInt(r3.getRate()));
     */
    @Override // com.beizi.fusion.work.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.interstitial.a.d():void");
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        InterstitialAd interstitialAd = this.f15701s;
        if (interstitialAd == null) {
            return null;
        }
        return interstitialAd.getPrice();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        InterstitialAd interstitialAd = new InterstitialAd(this.f15697o, false);
        this.f15701s = interstitialAd;
        interstitialAd.setAdUnitId(this.f15372i);
        this.f15701s.setAdBuyerBean(this.f15368e);
        this.f15701s.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.interstitial.a.2
            @Override // com.beizi.ad.AdListener
            public void onAdClicked() {
                super.onAdClicked();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdClick()");
                if (a.this.f15704v && ((com.beizi.fusion.work.a) a.this).f15368e != null) {
                    ((com.beizi.fusion.work.a) a.this).f15365b.P(((com.beizi.fusion.work.a) a.this).f15368e.getCallBackStrategyUuid());
                    a.this.au();
                }
                a.this.F();
                if (!a.this.f15704v || a.this.f15705w) {
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                    }
                    a.this.E();
                    a.this.ai();
                }
            }

            @Override // com.beizi.ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdClosed()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.c(a.this.g());
                }
                a.this.G();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdComplainResult(String str) {
                super.onAdComplainResult(str);
                try {
                    au.a(a.this.f15697o, a.this.f15696n, Long.valueOf(System.currentTimeMillis()));
                    ((com.beizi.fusion.work.a) a.this).f15365b.S(str);
                    a.this.au();
                    a.this.I();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.beizi.ad.AdListener
            public void onAdFailedToLoad(int i4) {
                super.onAdFailedToLoad(i4);
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdFailedToLoad: " + i4);
                a.this.a(String.valueOf(i4), i4);
            }

            @Override // com.beizi.ad.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdLoaded()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                if (a.this.f15701s.getPrice() != null) {
                    try {
                        a aVar = a.this;
                        aVar.a(Double.parseDouble(aVar.f15701s.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                a.this.y();
                if (a.this.Y()) {
                    a.this.aG();
                } else {
                    a.this.O();
                }
                a.this.aH();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdShown() {
                super.onAdShown();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdShown()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                    a.this.ah();
                }
                a.this.C();
                a.this.U();
                a.this.D();
            }
        });
        AdRequest build = new AdRequest.Builder().build();
        this.f15701s.openAdInNativeBrowser(true);
        this.f15701s.loadAd(build);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        InterstitialAd interstitialAd = this.f15701s;
        if (interstitialAd != null) {
            interstitialAd.cancel();
        }
    }

    private boolean b() {
        try {
            AdSpacesBean.UniteControlBean uniteControlBean = this.f15702t;
            if (uniteControlBean == null) {
                return true;
            }
            int random = uniteControlBean.getRandom();
            long duration = this.f15702t.getDuration();
            long longValue = ((Long) au.b(this.f15697o, "uniteTime", 0L)).longValue();
            if (longValue <= 0 || duration <= 0 || System.currentTimeMillis() - longValue >= duration) {
                return true;
            }
            return random >= this.f15703u || random == 100;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        Log.d("BeiZis", g() + " out make show ad");
        try {
            if (!b()) {
                a(String.valueOf(10170), 10170);
                return;
            }
            InterstitialAd interstitialAd = this.f15701s;
            if (interstitialAd == null || !interstitialAd.isLoaded()) {
                return;
            }
            this.f15701s.show(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean d(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }
}
