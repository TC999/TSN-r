package com.beizi.fusion.work.interstitial;

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
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.interstitial.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjFullScreenVideoInterstitialWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12190n;

    /* renamed from: o */
    private String f12191o;

    /* renamed from: p */
    private long f12192p;

    /* renamed from: q */
    private long f12193q;

    /* renamed from: r */
    private TTFullScreenVideoAd f12194r;

    /* renamed from: s */
    private TTAdNative f12195s;

    public CsjFullScreenVideoInterstitialWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12190n = context;
        this.f12191o = str;
        this.f12192p = j;
        this.f12193q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47166aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + "CsjFullScreenVideoInterstitialWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            BaseManager baseManager2 = this.f11797d;
            if (baseManager2 != null) {
                baseManager2.m48726a(mo46059g(), (View) null);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    /* renamed from: b */
    public String m47165b() {
        return "1013";
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjFullScreenVideoInterstitialWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f12190n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12193q);
        long j = this.f12193q;
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
        this.f12195s = TTAdManagerHolder.m48594a().createAdNative(this.f12190n);
        this.f12195s.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f11802i).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).setAdLoadType(TTAdLoadType.PRELOAD).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.interstitial.b.2
            /* renamed from: a */
            private void m47143a() {
                CsjFullScreenVideoInterstitialWorker.this.f12194r.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.beizi.fusion.work.interstitial.b.2.1

                    /* renamed from: a */
                    boolean f12198a = false;

                    /* renamed from: b */
                    boolean f12199b = false;

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdClose");
                        if (((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d != null && ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48704c(CsjFullScreenVideoInterstitialWorker.this.m47165b());
                        }
                        CsjFullScreenVideoInterstitialWorker.this.m47988G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdShow");
                        ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11803j = AdStatus.ADSHOW;
                        if (((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d != null && ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48710b(CsjFullScreenVideoInterstitialWorker.this.mo46059g());
                        }
                        if (this.f12198a) {
                            return;
                        }
                        this.f12198a = true;
                        CsjFullScreenVideoInterstitialWorker.this.m47992C();
                        CsjFullScreenVideoInterstitialWorker.this.m47991D();
                        CsjFullScreenVideoInterstitialWorker.this.m47942ah();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdVideoBarClick");
                        if (((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d != null && ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11797d.m48700d(CsjFullScreenVideoInterstitialWorker.this.mo46059g());
                        }
                        if (this.f12199b) {
                            return;
                        }
                        this.f12199b = true;
                        CsjFullScreenVideoInterstitialWorker.this.m47990E();
                        CsjFullScreenVideoInterstitialWorker.this.m47941ai();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onSkippedVideo");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onVideoComplete");
                    }
                });
                CsjFullScreenVideoInterstitialWorker.this.f12194r.setDownloadListener(new TTAppDownloadListener() { // from class: com.beizi.fusion.work.interstitial.b.2.2
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long j, long j2, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long j, long j2, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long j, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long j, long j2, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String str, String str2) {
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onError:" + str);
                CsjFullScreenVideoInterstitialWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onFullScreenVideoAdLoad");
                ((AdWorker) CsjFullScreenVideoInterstitialWorker.this).f11803j = AdStatus.ADLOAD;
                CsjFullScreenVideoInterstitialWorker.this.m47910y();
                if (tTFullScreenVideoAd == null) {
                    CsjFullScreenVideoInterstitialWorker.this.m47921c(-991);
                    return;
                }
                CsjFullScreenVideoInterstitialWorker.this.f12194r = tTFullScreenVideoAd;
                m47143a();
                if (!CsjFullScreenVideoInterstitialWorker.this.m47970Y()) {
                    CsjFullScreenVideoInterstitialWorker.this.m47980O();
                } else {
                    CsjFullScreenVideoInterstitialWorker.this.m47166aG();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onFullScreenVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        if (this.f12194r != null) {
            this.f12194r = null;
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.f12194r;
        if (tTFullScreenVideoAd != null && activity != null) {
            tTFullScreenVideoAd.showFullScreenVideoAd(activity, TTAdConstant.RitScenes.GAME_GIFT_BONUS, null);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }
}
