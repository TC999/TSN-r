package com.beizi.fusion.work.nativead;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
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

/* renamed from: com.beizi.fusion.work.nativead.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjNativeAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12404n;

    /* renamed from: o */
    private String f12405o;

    /* renamed from: p */
    private long f12406p;

    /* renamed from: q */
    private long f12407q;

    /* renamed from: r */
    private TTAdNative f12408r;

    /* renamed from: s */
    private TTNativeExpressAd f12409s;

    /* renamed from: t */
    private float f12410t;

    /* renamed from: u */
    private float f12411u;

    /* renamed from: v */
    private View f12412v;

    public CsjNativeAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12404n = context;
        this.f12405o = str;
        this.f12406p = j;
        this.f12407q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12410t = f;
        this.f12411u = f2;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
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
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjNativeAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f12404n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12407q);
        long j = this.f12407q;
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
        if (m47928av()) {
            return;
        }
        this.f12408r = TTAdManagerHolder.m48594a().createAdNative(this.f12404n);
        if (this.f12410t <= 0.0f) {
            this.f12410t = C3138av.m48288j(this.f12404n);
        }
        if (this.f12411u <= 0.0f) {
            this.f12411u = 0.0f;
        }
        this.f12408r.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.f12410t, this.f12411u).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.nativead.f.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onError:" + str);
                CsjNativeAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onNativeExpressAdLoad()");
                ((AdWorker) CsjNativeAdWorker.this).f11803j = AdStatus.ADLOAD;
                CsjNativeAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjNativeAdWorker.this.m47921c(-991);
                    return;
                }
                CsjNativeAdWorker.this.f12409s = list.get(0);
                CsjNativeAdWorker csjNativeAdWorker = CsjNativeAdWorker.this;
                csjNativeAdWorker.m46789a(csjNativeAdWorker.f12409s);
                CsjNativeAdWorker.this.f12409s.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        TTNativeExpressAd tTNativeExpressAd = this.f12409s;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12412v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46788b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12409s != null && this.f12412v != null) {
                this.f11797d.m48726a(mo46059g(), this.f12412v);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46789a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.nativead.f.3

            /* renamed from: a */
            boolean f12415a = false;

            /* renamed from: b */
            boolean f12416b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onAdClicked()");
                if (((AdWorker) CsjNativeAdWorker.this).f11797d != null && ((AdWorker) CsjNativeAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjNativeAdWorker.this).f11797d.m48700d(CsjNativeAdWorker.this.mo46059g());
                }
                if (this.f12416b) {
                    return;
                }
                this.f12416b = true;
                CsjNativeAdWorker.this.m47990E();
                CsjNativeAdWorker.this.m47941ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onAdShow()");
                ((AdWorker) CsjNativeAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) CsjNativeAdWorker.this).f11797d != null && ((AdWorker) CsjNativeAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjNativeAdWorker.this).f11797d.m48710b(CsjNativeAdWorker.this.mo46059g());
                }
                if (this.f12415a) {
                    return;
                }
                this.f12415a = true;
                CsjNativeAdWorker.this.m47992C();
                CsjNativeAdWorker.this.m47991D();
                CsjNativeAdWorker.this.m47942ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onRenderFail()");
                CsjNativeAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onRenderSuccess()");
                CsjNativeAdWorker.this.f12412v = view;
                if (CsjNativeAdWorker.this.m47970Y()) {
                    CsjNativeAdWorker.this.m46788b();
                } else {
                    CsjNativeAdWorker.this.m47980O();
                }
            }
        });
        m46782b(tTNativeExpressAd);
    }

    /* renamed from: b */
    private void m46782b(TTNativeExpressAd tTNativeExpressAd) {
        try {
            tTNativeExpressAd.setDislikeCallback((Activity) this.f12404n, new TTAdDislike.DislikeInteractionCallback() { // from class: com.beizi.fusion.work.nativead.f.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    Log.d("BeiZis", "showCsjNativeAd Callback --> onSelected()");
                    if (((AdWorker) CsjNativeAdWorker.this).f11797d != null && ((AdWorker) CsjNativeAdWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) CsjNativeAdWorker.this).f11797d.m48709b(CsjNativeAdWorker.this.mo46059g(), CsjNativeAdWorker.this.f12412v);
                    }
                    CsjNativeAdWorker.this.m47988G();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
        } catch (Exception unused) {
        }
    }
}
