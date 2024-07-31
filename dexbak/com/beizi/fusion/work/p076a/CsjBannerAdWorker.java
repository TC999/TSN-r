package com.beizi.fusion.work.p076a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.TTAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjBannerAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11853n;

    /* renamed from: o */
    private String f11854o;

    /* renamed from: p */
    private long f11855p;

    /* renamed from: q */
    private long f11856q;

    /* renamed from: r */
    private TTAdNative f11857r;

    /* renamed from: s */
    private TTNativeExpressAd f11858s;

    /* renamed from: t */
    private View f11859t;

    /* renamed from: u */
    private float f11860u;

    /* renamed from: v */
    private float f11861v;

    /* renamed from: w */
    private ViewGroup f11862w;

    public CsjBannerAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2, ViewGroup viewGroup) {
        this.f11853n = context;
        this.f11854o = str;
        this.f11855p = j;
        this.f11856q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f11860u = f;
        this.f11861v = f2;
        this.f11862w = viewGroup;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "CSJ";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjBannerAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f11853n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11856q);
        long j = this.f11856q;
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
        Log.d("BeiZis", "showCsjBannerAd showAd()");
        ViewGroup viewGroup = this.f11862w;
        if (viewGroup != null && this.f11859t != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f11862w.removeAllViews();
            }
            this.f11862w.addView(this.f11859t);
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
        if (this.f11860u <= 0.0f) {
            this.f11860u = C3138av.m48288j(this.f11853n);
        }
        if (this.f11861v <= 0.0f) {
            this.f11861v = Math.round(this.f11860u / 6.4f);
        }
        if (m47928av()) {
            return;
        }
        this.f11857r = TTAdManagerHolder.m48594a().createAdNative((Activity) this.f11853n);
        this.f11857r.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.f11860u, this.f11861v).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.a.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onError:" + str);
                CsjBannerAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onNativeExpressAdLoad()");
                ((AdWorker) CsjBannerAdWorker.this).f11803j = AdStatus.ADLOAD;
                CsjBannerAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjBannerAdWorker.this.m47921c(-991);
                    return;
                }
                CsjBannerAdWorker.this.f11858s = list.get(0);
                CsjBannerAdWorker.this.f11858s.setSlideIntervalTime(30000);
                CsjBannerAdWorker csjBannerAdWorker = CsjBannerAdWorker.this;
                csjBannerAdWorker.m47846a(csjBannerAdWorker.f11858s);
                CsjBannerAdWorker.this.f11858s.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        TTNativeExpressAd tTNativeExpressAd = this.f11858s;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47845b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " BannerAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            ViewGroup viewGroup = this.f11862w;
            if (viewGroup != null && this.f11859t != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f11862w.removeAllViews();
                }
                this.f11862w.addView(this.f11859t);
                this.f11797d.m48726a(mo46059g(), (View) null);
                return;
            }
            this.f11797d.m48754a(10140);
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m47846a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.a.c.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onAdClicked()");
                if (((AdWorker) CsjBannerAdWorker.this).f11797d != null) {
                    ((AdWorker) CsjBannerAdWorker.this).f11797d.m48700d(CsjBannerAdWorker.this.mo46059g());
                }
                CsjBannerAdWorker.this.m47990E();
                CsjBannerAdWorker.this.m47941ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onAdShow()");
                ((AdWorker) CsjBannerAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) CsjBannerAdWorker.this).f11797d != null) {
                    ((AdWorker) CsjBannerAdWorker.this).f11797d.m48710b(CsjBannerAdWorker.this.mo46059g());
                }
                CsjBannerAdWorker.this.m47992C();
                CsjBannerAdWorker.this.m47991D();
                CsjBannerAdWorker.this.m47942ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onRenderFail()");
                CsjBannerAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onRenderSuccess() width== " + f + ", height== " + f2);
                CsjBannerAdWorker.this.f11859t = view;
                if (CsjBannerAdWorker.this.m47970Y()) {
                    CsjBannerAdWorker.this.m47845b();
                } else {
                    CsjBannerAdWorker.this.m47980O();
                }
            }
        });
        m47839b(tTNativeExpressAd);
    }

    /* renamed from: b */
    private void m47839b(TTNativeExpressAd tTNativeExpressAd) {
        try {
            tTNativeExpressAd.setDislikeCallback((Activity) this.f11853n, new TTAdDislike.DislikeInteractionCallback() { // from class: com.beizi.fusion.work.a.c.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    Log.d("BeiZis", "showCsjBannerAd Callback --> onSelected()");
                    if (((AdWorker) CsjBannerAdWorker.this).f11797d != null) {
                        ((AdWorker) CsjBannerAdWorker.this).f11797d.m48704c(CsjBannerAdWorker.this.mo46059g());
                    }
                    CsjBannerAdWorker.this.m47988G();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
        } catch (Exception unused) {
        }
    }
}
