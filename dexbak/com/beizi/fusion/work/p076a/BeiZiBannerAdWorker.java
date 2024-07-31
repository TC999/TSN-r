package com.beizi.fusion.work.p076a;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.DataConvertUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.AdListener;
import com.beizi.p051ad.AdRequest;
import com.beizi.p051ad.BannerAdView;
import com.beizi.p051ad.internal.animation.TransitionDirection;
import com.beizi.p051ad.internal.animation.TransitionType;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiBannerAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11836n;

    /* renamed from: o */
    private String f11837o;

    /* renamed from: p */
    private long f11838p;

    /* renamed from: q */
    private long f11839q;

    /* renamed from: r */
    private BannerAdView f11840r;

    /* renamed from: s */
    private ViewGroup f11841s;

    /* renamed from: t */
    private float f11842t;

    /* renamed from: u */
    private float f11843u;

    /* renamed from: v */
    private boolean f11844v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f11845w;

    /* renamed from: x */
    private AdSpacesBean.RenderViewBean f11846x;

    /* renamed from: y */
    private List<Pair<String, Integer>> f11847y;

    public BeiZiBannerAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2, ViewGroup viewGroup) {
        this.f11836n = context;
        this.f11837o = str;
        this.f11838p = j;
        this.f11839q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f11842t = f;
        this.f11843u = f2;
        this.f11841s = viewGroup;
        m47917r();
    }

    /* renamed from: aG */
    private ViewGroup.LayoutParams m47876aG() {
        if (this.f11842t <= 0.0f) {
            this.f11842t = C3138av.m48288j(this.f11836n);
        }
        if (this.f11843u <= 0.0f) {
            this.f11843u = Math.round(this.f11842t / 6.4f);
        }
        return new ViewGroup.LayoutParams(C3138av.m48304a(this.f11836n, this.f11842t), C3138av.m48304a(this.f11836n, this.f11843u));
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f11840r == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BEIZI";
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
        List<AdSpacesBean.RenderViewBean> renderView = this.f11798e.getRenderView();
        this.f11845w = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f11845w.get(0);
            this.f11846x = renderViewBean;
            this.f11847y = DataConvertUtil.m48220a(renderViewBean.getDpLinkUrlList());
        }
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.beizi.ad.BeiZi")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BeiZiBannerAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
                    return;
                }
                m47914u();
                selfAdManagerHolder.m48575a(this.f11836n, this.f11801h);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11839q);
        long j = this.f11839q;
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
    /* renamed from: f */
    public void mo46061f() {
        ViewGroup viewGroup;
        Log.d("BeiZis", "showBeiZiBannerAd showAd()");
        if (this.f11840r != null && (viewGroup = this.f11841s) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11841s.removeAllViews();
            }
            this.f11844v = true;
            this.f11841s.addView(this.f11840r, m47876aG());
            return;
        }
        m47927aw();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        BannerAdView bannerAdView = this.f11840r;
        if (bannerAdView == null) {
            return null;
        }
        return bannerAdView.getPrice();
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
        this.f11844v = false;
        this.f11840r = new BannerAdView(this.f11836n);
        final AdRequest build = new AdRequest.Builder().build();
        this.f11840r.setAdUnitId(this.f11802i);
        this.f11840r.setTransitionType(TransitionType.MOVEIN);
        this.f11840r.setTransitionDerection(TransitionDirection.LEFT);
        this.f11840r.setTransitionDuration(600);
        this.f11840r.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.a.b.2
            @Override // com.beizi.p051ad.AdListener
            public void onAdClicked() {
                if (BeiZiBannerAdWorker.this.f11840r != null) {
                    BeiZiBannerAdWorker.this.f11840r.setTouchAreaNormal();
                }
                Log.d("BeiZis", "showBeiZiBannerAd onADClicked()");
                if (((AdWorker) BeiZiBannerAdWorker.this).f11797d != null) {
                    ((AdWorker) BeiZiBannerAdWorker.this).f11797d.m48700d(BeiZiBannerAdWorker.this.mo46059g());
                }
                BeiZiBannerAdWorker.this.m47990E();
                BeiZiBannerAdWorker.this.m47941ai();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiBannerAd onADClosed()");
                if (((AdWorker) BeiZiBannerAdWorker.this).f11797d != null) {
                    ((AdWorker) BeiZiBannerAdWorker.this).f11797d.m48704c(BeiZiBannerAdWorker.this.mo46059g());
                }
                BeiZiBannerAdWorker.this.m47988G();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdFailedToLoad(int i) {
                Log.d("BeiZis", "showBeiZiBannerAd onError:" + i);
                BeiZiBannerAdWorker.this.m47961a(String.valueOf(i), i);
                if (BeiZiBannerAdWorker.this.f11844v) {
                    return;
                }
                BeiZiBannerAdWorker.this.mo46173m();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBeiZiBannerAd onADReceive()");
                ((AdWorker) BeiZiBannerAdWorker.this).f11803j = AdStatus.ADLOAD;
                if (BeiZiBannerAdWorker.this.f11840r.getPrice() != null) {
                    try {
                        BeiZiBannerAdWorker beiZiBannerAdWorker = BeiZiBannerAdWorker.this;
                        beiZiBannerAdWorker.m47967a(Double.parseDouble(beiZiBannerAdWorker.f11840r.getPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BeiZiBannerAdWorker.this.m47910y();
                if (BeiZiBannerAdWorker.this.m47970Y()) {
                    BeiZiBannerAdWorker.this.m47875b();
                } else {
                    BeiZiBannerAdWorker.this.m47980O();
                }
                if (BeiZiBannerAdWorker.this.f11840r == null || BeiZiBannerAdWorker.this.f11846x == null) {
                    return;
                }
                BeiZiBannerAdWorker.this.f11840r.setOrderOptimizeList(BeiZiBannerAdWorker.this.f11847y);
                BeiZiBannerAdWorker.this.f11840r.setAdOptimizePercent(BeiZiBannerAdWorker.this.f11846x.getOptimizePercent());
                BeiZiBannerAdWorker.this.f11840r.post(new Runnable() { // from class: com.beizi.fusion.work.a.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BeiZiBannerAdWorker.this.f11840r.optimizeClickArea(BeiZiBannerAdWorker.this.f11846x.getOptimizeSize(), BeiZiBannerAdWorker.this.f11840r, BeiZiBannerAdWorker.this.f11841s, BeiZiBannerAdWorker.this.f11846x.getDirection());
                    }
                });
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdRequest() {
                Log.d("BeiZis", "showBeiZiBannerAd onAdRequest()");
                BeiZiBannerAdWorker.this.m47912w();
            }

            @Override // com.beizi.p051ad.AdListener
            public void onAdShown() {
                Log.d("BeiZis", "showBeiZiBannerAd onADExposure()");
                ((AdWorker) BeiZiBannerAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BeiZiBannerAdWorker.this).f11797d != null) {
                    ((AdWorker) BeiZiBannerAdWorker.this).f11797d.m48710b(BeiZiBannerAdWorker.this.mo46059g());
                }
                BeiZiBannerAdWorker.this.m47992C();
                BeiZiBannerAdWorker.this.m47991D();
                BeiZiBannerAdWorker.this.m47942ah();
            }
        });
        this.f11840r.post(new Runnable() { // from class: com.beizi.fusion.work.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                BeiZiBannerAdWorker.this.f11840r.loadAd(build);
            }
        });
        ViewGroup viewGroup = this.f11841s;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11841s.removeAllViews();
            }
            this.f11841s.addView(this.f11840r, m47876aG());
        }
        this.f11840r.openAdInNativeBrowser(true);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        BannerAdView bannerAdView = this.f11840r;
        if (bannerAdView != null) {
            bannerAdView.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47875b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " BannerAdWorker:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f11840r != null && this.f11841s != null) {
                this.f11844v = true;
                this.f11797d.m48726a(mo46059g(), (View) null);
                return;
            }
            this.f11797d.m48754a(10140);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }
}
