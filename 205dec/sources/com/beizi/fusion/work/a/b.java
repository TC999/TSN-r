package com.beizi.fusion.work.a;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.ad.AdListener;
import com.beizi.ad.AdRequest;
import com.beizi.ad.BannerAdView;
import com.beizi.ad.internal.animation.TransitionDirection;
import com.beizi.ad.internal.animation.TransitionType;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.s;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiBannerAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15406n;

    /* renamed from: o  reason: collision with root package name */
    private String f15407o;

    /* renamed from: p  reason: collision with root package name */
    private long f15408p;

    /* renamed from: q  reason: collision with root package name */
    private long f15409q;

    /* renamed from: r  reason: collision with root package name */
    private BannerAdView f15410r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f15411s;

    /* renamed from: t  reason: collision with root package name */
    private float f15412t;

    /* renamed from: u  reason: collision with root package name */
    private float f15413u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15414v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15415w;

    /* renamed from: x  reason: collision with root package name */
    private AdSpacesBean.RenderViewBean f15416x;

    /* renamed from: y  reason: collision with root package name */
    private List<Pair<String, Integer>> f15417y;

    public b(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar, float f4, float f5, ViewGroup viewGroup) {
        this.f15406n = context;
        this.f15407o = str;
        this.f15408p = j4;
        this.f15409q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15412t = f4;
        this.f15413u = f5;
        this.f15411s = viewGroup;
        r();
    }

    private ViewGroup.LayoutParams aG() {
        if (this.f15412t <= 0.0f) {
            this.f15412t = aw.j(this.f15406n);
        }
        if (this.f15413u <= 0.0f) {
            this.f15413u = Math.round(this.f15412t / 6.4f);
        }
        return new ViewGroup.LayoutParams(aw.a(this.f15406n, this.f15412t), aw.a(this.f15406n, this.f15413u));
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f15410r == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.f15368e.getRenderView();
        this.f15415w = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f15415w.get(0);
            this.f15416x = renderViewBean;
            this.f15417y = s.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a("com.beizi.ad.BeiZi")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BeiZi sdk not import , will do nothing");
                    return;
                }
                u();
                w.a(this.f15406n, this.f15371h);
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15409q);
        long j4 = this.f15409q;
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
        Log.d("BeiZis", "showBeiZiBannerAd showAd()");
        if (this.f15410r != null && (viewGroup = this.f15411s) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15411s.removeAllViews();
            }
            this.f15414v = true;
            this.f15411s.addView(this.f15410r, aG());
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
        BannerAdView bannerAdView = this.f15410r;
        if (bannerAdView == null) {
            return null;
        }
        return bannerAdView.getPrice();
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        this.f15414v = false;
        this.f15410r = new BannerAdView(this.f15406n);
        final AdRequest build = new AdRequest.Builder().build();
        this.f15410r.setAdUnitId(this.f15372i);
        this.f15410r.setTransitionType(TransitionType.MOVEIN);
        this.f15410r.setTransitionDerection(TransitionDirection.LEFT);
        this.f15410r.setTransitionDuration(600);
        this.f15410r.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.a.b.2
            @Override // com.beizi.ad.AdListener
            public void onAdClicked() {
                if (b.this.f15410r != null) {
                    b.this.f15410r.setTouchAreaNormal();
                }
                Log.d("BeiZis", "showBeiZiBannerAd onADClicked()");
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.d(b.this.g());
                }
                b.this.E();
                b.this.ai();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdClosed() {
                Log.d("BeiZis", "showBeiZiBannerAd onADClosed()");
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.c(b.this.g());
                }
                b.this.G();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdFailedToLoad(int i4) {
                Log.d("BeiZis", "showBeiZiBannerAd onError:" + i4);
                b.this.a(String.valueOf(i4), i4);
                if (b.this.f15414v) {
                    return;
                }
                b.this.m();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBeiZiBannerAd onADReceive()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                if (b.this.f15410r.getPrice() != null) {
                    try {
                        b bVar = b.this;
                        bVar.a(Double.parseDouble(bVar.f15410r.getPrice()));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                b.this.y();
                if (b.this.Y()) {
                    b.this.b();
                } else {
                    b.this.O();
                }
                if (b.this.f15410r == null || b.this.f15416x == null) {
                    return;
                }
                b.this.f15410r.setOrderOptimizeList(b.this.f15417y);
                b.this.f15410r.setAdOptimizePercent(b.this.f15416x.getOptimizePercent());
                b.this.f15410r.post(new Runnable() { // from class: com.beizi.fusion.work.a.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f15410r.optimizeClickArea(b.this.f15416x.getOptimizeSize(), b.this.f15410r, b.this.f15411s, b.this.f15416x.getDirection());
                    }
                });
            }

            @Override // com.beizi.ad.AdListener
            public void onAdRequest() {
                Log.d("BeiZis", "showBeiZiBannerAd onAdRequest()");
                b.this.w();
            }

            @Override // com.beizi.ad.AdListener
            public void onAdShown() {
                Log.d("BeiZis", "showBeiZiBannerAd onADExposure()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                }
                b.this.C();
                b.this.D();
                b.this.ah();
            }
        });
        this.f15410r.post(new Runnable() { // from class: com.beizi.fusion.work.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.f15410r.loadAd(build);
            }
        });
        ViewGroup viewGroup = this.f15411s;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15411s.removeAllViews();
            }
            this.f15411s.addView(this.f15410r, aG());
        }
        this.f15410r.openAdInNativeBrowser(true);
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        BannerAdView bannerAdView = this.f15410r;
        if (bannerAdView != null) {
            bannerAdView.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " BannerAdWorker:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15410r != null && this.f15411s != null) {
                this.f15414v = true;
                this.f15367d.a(g(), (View) null);
                return;
            }
            this.f15367d.a(10140);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }
}
