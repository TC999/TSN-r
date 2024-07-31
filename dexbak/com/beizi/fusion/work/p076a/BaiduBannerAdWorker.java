package com.beizi.fusion.work.p076a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.BdAdManagerHolder;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.beizi.fusion.work.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduBannerAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11823n;

    /* renamed from: o */
    private String f11824o;

    /* renamed from: p */
    private long f11825p;

    /* renamed from: q */
    private long f11826q;

    /* renamed from: r */
    private float f11827r;

    /* renamed from: s */
    private float f11828s;

    /* renamed from: t */
    private ViewGroup f11829t;

    /* renamed from: u */
    private AdView f11830u;

    /* renamed from: v */
    private boolean f11831v;

    public BaiduBannerAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2, ViewGroup viewGroup) {
        this.f11823n = context;
        this.f11824o = str;
        this.f11825p = j;
        this.f11826q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f11827r = f;
        this.f11828s = f2;
        this.f11829t = viewGroup;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47904aG() {
        ViewGroup viewGroup;
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " BannerAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f11830u != null && (viewGroup = this.f11829t) != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f11829t.removeAllViews();
                }
                this.f11831v = true;
                this.f11829t.addView(this.f11830u, m47903aH());
                this.f11797d.m48726a(mo46059g(), (View) null);
                return;
            }
            this.f11797d.m48754a(10140);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* renamed from: aH */
    private ViewGroup.LayoutParams m47903aH() {
        if (this.f11827r <= 0.0f) {
            this.f11827r = C3138av.m48288j(this.f11823n);
        }
        if (this.f11828s <= 0.0f) {
            this.f11828s = Math.round(this.f11827r / 6.4f);
        }
        this.f11828s = (this.f11827r * 3.0f) / 20.0f;
        return new RelativeLayout.LayoutParams(C3138av.m48304a(this.f11823n, this.f11827r), C3138av.m48304a(this.f11823n, this.f11828s));
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
    }

    /* renamed from: b */
    public String m47902b() {
        return "1018";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BAIDU";
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
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.baidu.mobads.sdk.api.BDAdConfig")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduBannerAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                m47914u();
                this.f11795b.m48879v(String.valueOf(AdSettings.getSDKVersion()));
                m47929au();
                BdAdManagerHolder.m48656a(this.f11823n, this.f11801h);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11826q);
        long j = this.f11826q;
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
        Log.d("BeiZis", "showBaiduBanner showAd()");
        if (this.f11830u != null && (viewGroup = this.f11829t) != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11829t.removeAllViews();
            }
            this.f11831v = true;
            this.f11829t.addView(this.f11830u, m47903aH());
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
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        this.f11831v = false;
        AdView adView = new AdView(this.f11823n, this.f11802i);
        this.f11830u = adView;
        adView.setListener(new AdViewListener() { // from class: com.beizi.fusion.work.a.a.2

            /* renamed from: a */
            boolean f11833a = false;

            /* renamed from: b */
            boolean f11834b = false;

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdClick(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdClick()");
                if (((AdWorker) BaiduBannerAdWorker.this).f11797d != null && ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48700d(BaiduBannerAdWorker.this.mo46059g());
                }
                if (this.f11834b) {
                    return;
                }
                this.f11834b = true;
                BaiduBannerAdWorker.this.m47990E();
                BaiduBannerAdWorker.this.m47941ai();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdClose(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdClose()");
                if (((AdWorker) BaiduBannerAdWorker.this).f11797d != null && ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48704c(BaiduBannerAdWorker.this.m47902b());
                }
                BaiduBannerAdWorker.this.m47988G();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdFailed: " + str);
                BaiduBannerAdWorker.this.m47961a(str, 3793);
                if (BaiduBannerAdWorker.this.f11831v) {
                    return;
                }
                BaiduBannerAdWorker.this.mo46173m();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdReady(AdView adView2) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdReady()");
                ((AdWorker) BaiduBannerAdWorker.this).f11803j = AdStatus.ADLOAD;
                BaiduBannerAdWorker.this.m47910y();
                if (!BaiduBannerAdWorker.this.m47970Y()) {
                    BaiduBannerAdWorker.this.m47980O();
                } else {
                    BaiduBannerAdWorker.this.m47904aG();
                }
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdShow(JSONObject jSONObject) {
                Log.d("BeiZis", "showBaiduBanner Callback --> onAdShow()");
                ((AdWorker) BaiduBannerAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BaiduBannerAdWorker.this).f11797d != null && ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduBannerAdWorker.this).f11797d.m48710b(BaiduBannerAdWorker.this.mo46059g());
                }
                if (this.f11833a) {
                    return;
                }
                this.f11833a = true;
                BaiduBannerAdWorker.this.m47992C();
                BaiduBannerAdWorker.this.m47991D();
                BaiduBannerAdWorker.this.m47942ah();
            }

            @Override // com.baidu.mobads.sdk.api.AdViewListener
            public void onAdSwitch() {
            }
        });
        ViewGroup viewGroup = this.f11829t;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11829t.removeAllViews();
            }
            this.f11829t.addView(this.f11830u, m47903aH());
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        AdView adView = this.f11830u;
        if (adView != null) {
            adView.destroy();
        }
    }
}
