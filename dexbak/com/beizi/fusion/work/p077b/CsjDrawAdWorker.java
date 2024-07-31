package com.beizi.fusion.work.p077b;

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
import com.beizi.fusion.p072g.AdViewSizeUtils;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.b.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjDrawAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11881n;

    /* renamed from: o */
    private String f11882o;

    /* renamed from: p */
    private long f11883p;

    /* renamed from: q */
    private long f11884q;

    /* renamed from: r */
    private TTAdNative f11885r;

    /* renamed from: s */
    private View f11886s;

    public CsjDrawAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11881n = context;
        this.f11882o = str;
        this.f11883p = j;
        this.f11884q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
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
    /* renamed from: m */
    public void mo46173m() {
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjDrawAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f11881n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11884q);
        long j = this.f11884q;
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
        this.f11885r = TTAdManagerHolder.m48594a().createAdNative(this.f11881n);
        this.f11885r.loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(AdViewSizeUtils.m48515a(this.f11881n), 0.0f).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.b.a.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onError code=" + i + " , message=" + str);
                CsjDrawAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onNativeExpressAdLoad()");
                ((AdWorker) CsjDrawAdWorker.this).f11803j = AdStatus.ADLOAD;
                CsjDrawAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    CsjDrawAdWorker.this.m47921c(-991);
                } else {
                    CsjDrawAdWorker.this.m47792a(list);
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f11886s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47791b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " DrawAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f11886s != null) {
                this.f11797d.m48726a(mo46059g(), this.f11886s);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m47792a(List<TTNativeExpressAd> list) {
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.beizi.fusion.work.b.a.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onClickRetry()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdComplete()");
                if (((AdWorker) CsjDrawAdWorker.this).f11797d != null) {
                    ((AdWorker) CsjDrawAdWorker.this).f11797d.m48676l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdContinuePlay()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdPaused()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdStartPlay()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i, int i2) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoError() errorCode=" + i + ", extraCode=" + i2);
                CsjDrawAdWorker.this.m47961a(String.valueOf(i2), i);
                if (((AdWorker) CsjDrawAdWorker.this).f11797d != null) {
                    ((AdWorker) CsjDrawAdWorker.this).f11797d.m48674m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoLoad()");
            }
        });
        tTNativeExpressAd.setCanInterruptVideoPlay(true);
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.b.a.4

            /* renamed from: a */
            boolean f11890a = false;

            /* renamed from: b */
            boolean f11891b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onAdClicked()");
                if (((AdWorker) CsjDrawAdWorker.this).f11797d != null && ((AdWorker) CsjDrawAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjDrawAdWorker.this).f11797d.m48700d(CsjDrawAdWorker.this.mo46059g());
                }
                if (this.f11891b) {
                    return;
                }
                this.f11891b = true;
                CsjDrawAdWorker.this.m47990E();
                CsjDrawAdWorker.this.m47941ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onAdShow()");
                ((AdWorker) CsjDrawAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) CsjDrawAdWorker.this).f11797d != null && ((AdWorker) CsjDrawAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) CsjDrawAdWorker.this).f11797d.m48710b(CsjDrawAdWorker.this.mo46059g());
                }
                if (this.f11890a) {
                    return;
                }
                this.f11890a = true;
                CsjDrawAdWorker.this.m47992C();
                CsjDrawAdWorker.this.m47991D();
                CsjDrawAdWorker.this.m47942ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onRenderFail() code=" + i + ", error=" + str);
                CsjDrawAdWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onRenderSuccess()");
                CsjDrawAdWorker.this.f11886s = view;
                if (CsjDrawAdWorker.this.m47970Y()) {
                    CsjDrawAdWorker.this.m47791b();
                } else {
                    CsjDrawAdWorker.this.m47980O();
                }
            }
        });
        tTNativeExpressAd.render();
    }
}
