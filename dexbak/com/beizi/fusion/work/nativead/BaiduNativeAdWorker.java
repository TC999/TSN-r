package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
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
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.nativead.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduNativeAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12267n;

    /* renamed from: o */
    private String f12268o;

    /* renamed from: p */
    private long f12269p;

    /* renamed from: q */
    private long f12270q;

    /* renamed from: r */
    private boolean f12271r;

    /* renamed from: s */
    private BaiduNativeManager f12272s;

    /* renamed from: t */
    private ExpressResponse f12273t;

    /* renamed from: u */
    private float f12274u;

    /* renamed from: v */
    private float f12275v;

    /* renamed from: w */
    private View f12276w;

    public BaiduNativeAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12267n = context;
        this.f12268o = str;
        this.f12269p = j;
        this.f12270q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12274u = f;
        this.f12275v = f2;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47009aG() {
        ExpressResponse expressResponse = this.f12273t;
        if (expressResponse != null) {
            expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.beizi.fusion.work.nativead.a.3

                /* renamed from: a */
                boolean f12279a = false;

                /* renamed from: b */
                boolean f12280b = false;

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdClick()");
                    if (((AdWorker) BaiduNativeAdWorker.this).f11797d != null && ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48700d(BaiduNativeAdWorker.this.mo46059g());
                    }
                    if (this.f12280b) {
                        return;
                    }
                    this.f12280b = true;
                    BaiduNativeAdWorker.this.m47990E();
                    BaiduNativeAdWorker.this.m47941ai();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdExposed()");
                    ((AdWorker) BaiduNativeAdWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) BaiduNativeAdWorker.this).f11797d != null && ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48710b(BaiduNativeAdWorker.this.mo46059g());
                    }
                    if (this.f12279a) {
                        return;
                    }
                    this.f12279a = true;
                    BaiduNativeAdWorker.this.mo46072az();
                    BaiduNativeAdWorker.this.m47992C();
                    BaiduNativeAdWorker.this.m47991D();
                    BaiduNativeAdWorker.this.m47942ah();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdRenderFail() error:" + str + ";code:" + i);
                    BaiduNativeAdWorker.this.m47961a(str, i);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f, float f2) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdRenderSuccess()");
                    BaiduNativeAdWorker baiduNativeAdWorker = BaiduNativeAdWorker.this;
                    baiduNativeAdWorker.f12276w = baiduNativeAdWorker.f12273t.getExpressAdView();
                    if (BaiduNativeAdWorker.this.m47970Y()) {
                        BaiduNativeAdWorker.this.m47008b();
                    } else {
                        BaiduNativeAdWorker.this.m47980O();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onAdUnionClick()");
                }
            });
            this.f12273t.setAdPrivacyListener(new ExpressResponse.ExpressAdDownloadWindowListener() { // from class: com.beizi.fusion.work.nativead.a.4
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void adDownloadWindowClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> adDownloadWindowClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void adDownloadWindowShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> adDownloadWindowShow()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADFunctionClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADFunctionClick()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPermissionClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPermissionClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPermissionShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPermissionShow()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener
                public void onADPrivacyClick() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onADPrivacyClick()");
                }
            });
            this.f12273t.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.beizi.fusion.work.nativead.a.5
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeItemClick(String str) {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeItemClick()");
                    Log.d("BeiZis", "showCsjNativeAd Callback --> onSelected()");
                    if (((AdWorker) BaiduNativeAdWorker.this).f11797d != null && ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) BaiduNativeAdWorker.this).f11797d.m48709b(BaiduNativeAdWorker.this.mo46059g(), BaiduNativeAdWorker.this.f12276w);
                    }
                    BaiduNativeAdWorker.this.m47988G();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowClose() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeWindowClose()");
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowShow() {
                    Log.d("BeiZis", "showBdNativeAd Callback --> onDislikeWindowShow()");
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12273t == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        ExpressResponse expressResponse;
        if (!m47936an() || (expressResponse = this.f12273t) == null || TextUtils.isEmpty(expressResponse.getECPMLevel()) || this.f12271r) {
            return;
        }
        this.f12271r = true;
        C3116af.m48496a("BeiZis", "showBdNativeAd channel == Baidu竞价成功");
        C3116af.m48496a("BeiZis", "showBdNativeAd channel == sendWinNoticeECPM:" + this.f12273t.getECPMLevel());
        ExpressResponse expressResponse2 = this.f12273t;
        expressResponse2.biddingSuccess(expressResponse2.getECPMLevel());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BAIDU";
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
                if (!C3138av.m48301a("com.baidu.mobads.sdk.api.BDAdConfig")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNativeAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                m47914u();
                this.f11795b.m48879v(String.valueOf(AdSettings.getSDKVersion()));
                m47929au();
                BdAdManagerHolder.m48656a(this.f12267n, this.f11801h);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12270q);
        long j = this.f12270q;
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
    /* renamed from: j */
    public String mo46054j() {
        if (m47936an() && this.f12273t != null) {
            return this.f12273t.getECPMLevel() + "";
        }
        return null;
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
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(StubApp.getOrigApplicationContext(this.f12267n.getApplicationContext()), this.f11802i);
        this.f12272s = baiduNativeManager;
        baiduNativeManager.loadExpressAd(null, new BaiduNativeManager.ExpressAdListener() { // from class: com.beizi.fusion.work.nativead.a.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onLpClosed() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onLpClosed()");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeFail(int i, String str) {
                Log.d("BeiZis", "showBdNativeAd Callback --> onNativeFail() code:" + i + " message:" + str);
                BaiduNativeAdWorker.this.m47961a(str, i);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNativeLoad(List<ExpressResponse> list) {
                Log.d("BeiZis", "showBdNativeAd Callback --> onNativeLoad()");
                ((AdWorker) BaiduNativeAdWorker.this).f11803j = AdStatus.ADLOAD;
                BaiduNativeAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    BaiduNativeAdWorker.this.m47921c(-991);
                    return;
                }
                BaiduNativeAdWorker.this.f12273t = list.get(0);
                try {
                    if (BaiduNativeAdWorker.this.f12273t != null && !TextUtils.isEmpty(BaiduNativeAdWorker.this.f12273t.getECPMLevel())) {
                        Log.d("BeiZis", "showBdNativeAd getECPMLevel:" + BaiduNativeAdWorker.this.f12273t.getECPMLevel());
                        BaiduNativeAdWorker baiduNativeAdWorker = BaiduNativeAdWorker.this;
                        baiduNativeAdWorker.m47967a(Double.parseDouble(baiduNativeAdWorker.f12273t.getECPMLevel()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BaiduNativeAdWorker.this.m47009aG();
                BaiduNativeAdWorker.this.f12273t.render();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onNoAd(int i, String str) {
                Log.d("BeiZis", "showBdNativeAd  Callback --> onNoAd() code:" + i + " message:" + str);
                BaiduNativeAdWorker.this.m47961a(str, i);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadFailed() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onVideoDownloadFailed()");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadSuccess() {
                Log.d("BeiZis", "showBdNativeAd Callback --> onVideoDownloadSuccess()");
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12276w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47008b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12273t != null && this.f12276w != null) {
                this.f11797d.m48726a(mo46059g(), this.f12276w);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        ExpressResponse expressResponse = this.f12273t;
        if (expressResponse == null || TextUtils.isEmpty(expressResponse.getECPMLevel()) || this.f12271r) {
            return;
        }
        this.f12271r = true;
        C3116af.m48496a("BeiZis", "showBdNativeAd channel == Baidu竞价失败:" + i);
        this.f12273t.biddingFail(i != 1 ? i != 2 ? "900" : "100" : "203");
    }
}
