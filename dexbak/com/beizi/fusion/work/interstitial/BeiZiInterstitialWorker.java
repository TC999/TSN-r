package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.AdListener;
import com.beizi.p051ad.AdRequest;
import com.beizi.p051ad.InterstitialAd;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.interstitial.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiInterstitialWorker extends AdWorker implements AdShowObserver {

    /* renamed from: o */
    private Context f12179o;

    /* renamed from: p */
    private String f12180p;

    /* renamed from: q */
    private long f12181q;

    /* renamed from: r */
    private long f12182r;

    /* renamed from: s */
    private InterstitialAd f12183s;

    /* renamed from: t */
    private AdSpacesBean.UniteControlBean f12184t;

    /* renamed from: u */
    private int f12185u;

    /* renamed from: n */
    protected String f12178n = null;

    /* renamed from: v */
    private boolean f12186v = false;

    /* renamed from: w */
    private boolean f12187w = false;

    public BeiZiInterstitialWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12179o = context;
        this.f12180p = str;
        this.f12181q = j;
        this.f12182r = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47209aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", "splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            this.f11797d.m48726a(mo46059g(), (View) null);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH */
    public void m47208aH() {
        m47207aI();
        m47206aJ();
        m47205aK();
        m47204aL();
        m47203aM();
    }

    /* renamed from: aI */
    private void m47207aI() {
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = this.f11798e.getRegionalClickView();
        if (regionalClickView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m47210a = m47210a(regionalClickView.getOrderData(), this.f12183s.getAdId());
        AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = null;
        if (m47210a != null && m47210a.getRegionalClickView() != null) {
            regionalClickViewBean = m47210a.getRegionalClickView();
        }
        if (regionalClickViewBean != null) {
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48948J(regionalClickViewBean.getRegionalClickUuid());
                m47929au();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f11795b;
        if (eventBean2 != null) {
            eventBean2.m48948J(regionalClickView.getRegionalClickUuid());
            m47929au();
        }
    }

    /* renamed from: aJ */
    private void m47206aJ() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = this.f11798e.getFullScreenClick();
        if (fullScreenClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m47199b = m47199b(fullScreenClick.getOrderData(), this.f12183s.getAdId());
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean = null;
        if (m47199b != null && m47199b.getFullScreenClick() != null) {
            fullScreenClickBean = m47199b.getFullScreenClick();
        }
        if (fullScreenClickBean != null) {
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48950I(fullScreenClickBean.getFullScreenClickUuid());
                m47929au();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f11795b;
        if (eventBean2 != null) {
            eventBean2.m48950I(fullScreenClick.getFullScreenClickUuid());
            m47929au();
        }
    }

    /* renamed from: aK */
    private void m47205aK() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.f11798e.getShakeView();
        if (shakeView == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47197c = m47197c(shakeView.getOrderData(), this.f12183s.getAdId());
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = null;
        if (m47197c != null && m47197c.getShakeView() != null) {
            shakeViewBean = m47197c.getShakeView();
        }
        if (shakeViewBean != null) {
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48954G(shakeViewBean.getShakeViewUuid());
                m47929au();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f11795b;
        if (eventBean2 != null) {
            eventBean2.m48954G(shakeView.getShakeViewUuid());
            m47929au();
        }
    }

    /* renamed from: aL */
    private void m47204aL() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick = this.f11798e.getScrollClick();
        if (scrollClick == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m47195d = m47195d(scrollClick.getOrderData(), this.f12183s.getAdId());
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = null;
        if (m47195d != null && m47195d.getScrollClick() != null) {
            scrollClickBean = m47195d.getScrollClick();
        }
        if (scrollClickBean != null) {
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48956F(scrollClickBean.getScrollClickUuid());
                m47929au();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f11795b;
        if (eventBean2 != null) {
            eventBean2.m48956F(scrollClick.getScrollClickUuid());
            m47929au();
        }
    }

    /* renamed from: aM */
    private void m47203aM() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.f11798e.getEulerAngleRule();
        if (eulerAngleRule == null) {
            return;
        }
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m47193e = m47193e(eulerAngleRule.getOrderData(), this.f12183s.getAdId());
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = null;
        if (m47193e != null && m47193e.getEulerAngleRule() != null) {
            eulerAngleViewBean = m47193e.getEulerAngleRule();
        }
        if (eulerAngleViewBean != null) {
            EventBean eventBean = this.f11795b;
            if (eventBean != null) {
                eventBean.m48932R(eulerAngleViewBean.getEulerAngleUuid());
                m47929au();
                return;
            }
            return;
        }
        EventBean eventBean2 = this.f11795b;
        if (eventBean2 != null) {
            eventBean2.m48932R(eulerAngleRule.getEulerAngleUuid());
            m47929au();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
    }

    /* renamed from: c */
    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean m47197c(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
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

    /* renamed from: e */
    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean m47193e(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
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

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        InterstitialAd interstitialAd;
        if (m47909z() && (interstitialAd = this.f12183s) != null && interstitialAd.isLoaded()) {
            m47938al();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
        r6.f12187w = com.beizi.fusion.p072g.RandomUtils.m48438a(java.lang.Integer.parseInt(r3.getRate()));
     */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo46065d() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.interstitial.BeiZiInterstitialWorker.mo46065d():void");
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        InterstitialAd interstitialAd = this.f12183s;
        if (interstitialAd == null) {
            return null;
        }
        return interstitialAd.getPrice();
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
        InterstitialAd interstitialAd = new InterstitialAd(this.f12179o, false);
        this.f12183s = interstitialAd;
        interstitialAd.setAdUnitId(this.f11802i);
        this.f12183s.setAdBuyerBean(this.f11798e);
        this.f12183s.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.interstitial.a.2
            @Override // com.beizi.p051ad.AdListener
            public void onAdClicked() {
                super.onAdClicked();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdClick()");
                if (BeiZiInterstitialWorker.this.f12186v && ((AdWorker) BeiZiInterstitialWorker.this).f11798e != null) {
                    ((AdWorker) BeiZiInterstitialWorker.this).f11795b.m48936P(((AdWorker) BeiZiInterstitialWorker.this).f11798e.getCallBackStrategyUuid());
                    BeiZiInterstitialWorker.this.m47929au();
                }
                BeiZiInterstitialWorker.this.m47989F();
                if (!BeiZiInterstitialWorker.this.f12186v || BeiZiInterstitialWorker.this.f12187w) {
                    if (((AdWorker) BeiZiInterstitialWorker.this).f11797d != null && ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48700d(BeiZiInterstitialWorker.this.mo46059g());
                    }
                    BeiZiInterstitialWorker.this.m47990E();
                    BeiZiInterstitialWorker.this.m47941ai();
                }
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdClosed()");
                if (((AdWorker) BeiZiInterstitialWorker.this).f11797d != null && ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48704c(BeiZiInterstitialWorker.this.mo46059g());
                }
                BeiZiInterstitialWorker.this.m47988G();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdComplainResult(String str) {
                super.onAdComplainResult(str);
                try {
                    C3137at.m48315a(BeiZiInterstitialWorker.this.f12179o, BeiZiInterstitialWorker.this.f12178n, Long.valueOf(System.currentTimeMillis()));
                    ((AdWorker) BeiZiInterstitialWorker.this).f11795b.m48930S(str);
                    BeiZiInterstitialWorker.this.m47929au();
                    BeiZiInterstitialWorker.this.m47986I();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdFailedToLoad: " + i);
                BeiZiInterstitialWorker.this.m47961a(String.valueOf(i), i);
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdLoaded()");
                ((AdWorker) BeiZiInterstitialWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiInterstitialWorker.this.f12183s.getPrice() != null) {
                    try {
                        BeiZiInterstitialWorker beiZiInterstitialWorker = BeiZiInterstitialWorker.this;
                        beiZiInterstitialWorker.m47967a(Double.parseDouble(beiZiInterstitialWorker.f12183s.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiInterstitialWorker.this.m47910y();
                if (BeiZiInterstitialWorker.this.m47970Y()) {
                    BeiZiInterstitialWorker.this.m47209aG();
                } else {
                    BeiZiInterstitialWorker.this.m47980O();
                }
                BeiZiInterstitialWorker.this.m47208aH();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdShown() {
                super.onAdShown();
                Log.d("BeiZis", "showBeiZiInterstitialAd onAdShown()");
                ((AdWorker) BeiZiInterstitialWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BeiZiInterstitialWorker.this).f11797d != null && ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BeiZiInterstitialWorker.this).f11797d.m48710b(BeiZiInterstitialWorker.this.mo46059g());
                    BeiZiInterstitialWorker.this.m47942ah();
                }
                BeiZiInterstitialWorker.this.m47992C();
                BeiZiInterstitialWorker.this.m47974U();
                BeiZiInterstitialWorker.this.m47991D();
            }
        });
        AdRequest build = new AdRequest.Builder().build();
        this.f12183s.openAdInNativeBrowser(true);
        this.f12183s.loadAd(build);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        InterstitialAd interstitialAd = this.f12183s;
        if (interstitialAd != null) {
            interstitialAd.cancel();
        }
    }

    /* renamed from: b */
    private boolean m47202b() {
        try {
            AdSpacesBean.UniteControlBean uniteControlBean = this.f12184t;
            if (uniteControlBean == null) {
                return true;
            }
            int random = uniteControlBean.getRandom();
            long duration = this.f12184t.getDuration();
            long longValue = ((Long) C3137at.m48313b(this.f12179o, "uniteTime", 0L)).longValue();
            if (longValue <= 0 || duration <= 0 || System.currentTimeMillis() - longValue >= duration) {
                return true;
            }
            return random >= this.f12185u || random == 100;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        try {
            if (!m47202b()) {
                m47961a(String.valueOf(10170), 10170);
                return;
            }
            InterstitialAd interstitialAd = this.f12183s;
            if (interstitialAd == null || !interstitialAd.isLoaded()) {
                return;
            }
            this.f12183s.show(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean m47199b(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
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

    /* renamed from: a */
    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean m47210a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
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

    /* renamed from: d */
    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean m47195d(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
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
