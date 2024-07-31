package com.beizi.fusion.work.p078c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
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

/* renamed from: com.beizi.fusion.work.c.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduFullScreenVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11903n;

    /* renamed from: o */
    private String f11904o;

    /* renamed from: p */
    private long f11905p;

    /* renamed from: q */
    private long f11906q;

    /* renamed from: r */
    private FullScreenVideoAd f11907r;

    /* renamed from: s */
    private boolean f11908s;

    public BaiduFullScreenVideoWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11903n = context;
        this.f11904o = str;
        this.f11905p = j;
        this.f11906q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47736aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " FullScreenVideoWorkers:" + m48669r.toString());
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
    /* renamed from: az */
    public void mo46072az() {
        FullScreenVideoAd fullScreenVideoAd;
        if (!m47936an() || (fullScreenVideoAd = this.f11907r) == null || TextUtils.isEmpty(fullScreenVideoAd.getECPMLevel()) || this.f11908s) {
            return;
        }
        this.f11908s = true;
        C3116af.m48496a("BeiZis", "showBdFullScreenVideo channel == Baidu竞价成功");
        C3116af.m48496a("BeiZis", "showBdFullScreenVideo channel == sendWinNoticeECPM:" + this.f11907r.getECPMLevel());
        FullScreenVideoAd fullScreenVideoAd2 = this.f11907r;
        fullScreenVideoAd2.biddingSuccess(fullScreenVideoAd2.getECPMLevel());
    }

    /* renamed from: b */
    public String m47735b() {
        return "1018";
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduFullScreenVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                m47914u();
                this.f11795b.m48879v(String.valueOf(AdSettings.getSDKVersion()));
                m47929au();
                BdAdManagerHolder.m48656a(this.f11903n, this.f11801h);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11906q);
        long j = this.f11906q;
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
        FullScreenVideoAd fullScreenVideoAd;
        if (m47936an() && (fullScreenVideoAd = this.f11907r) != null) {
            return fullScreenVideoAd.getECPMLevel();
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
        FullScreenVideoAd fullScreenVideoAd = new FullScreenVideoAd(this.f11903n, this.f11802i, new FullScreenVideoAd.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.c.a.2

            /* renamed from: a */
            boolean f11910a = false;

            /* renamed from: b */
            boolean f11911b = false;

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdClick()");
                if (((AdWorker) BaiduFullScreenVideoWorker.this).f11797d != null && ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48700d(BaiduFullScreenVideoWorker.this.mo46059g());
                }
                if (this.f11911b) {
                    return;
                }
                this.f11911b = true;
                BaiduFullScreenVideoWorker.this.m47990E();
                BaiduFullScreenVideoWorker.this.m47941ai();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float f) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdClose()");
                if (((AdWorker) BaiduFullScreenVideoWorker.this).f11797d != null && ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48704c(BaiduFullScreenVideoWorker.this.m47735b());
                }
                BaiduFullScreenVideoWorker.this.m47988G();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdFailed: " + str);
                BaiduFullScreenVideoWorker.this.m47961a(str, 3793);
            }

            @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdLoaded()");
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdShow()");
                ((AdWorker) BaiduFullScreenVideoWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BaiduFullScreenVideoWorker.this).f11797d != null && ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduFullScreenVideoWorker.this).f11797d.m48710b(BaiduFullScreenVideoWorker.this.mo46059g());
                }
                if (this.f11910a) {
                    return;
                }
                this.f11910a = true;
                BaiduFullScreenVideoWorker.this.m47992C();
                BaiduFullScreenVideoWorker.this.mo46072az();
                BaiduFullScreenVideoWorker.this.m47991D();
                BaiduFullScreenVideoWorker.this.m47942ah();
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float f) {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onAdSkip()");
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadFailed() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onVideoDownloadFailed()");
                BaiduFullScreenVideoWorker.this.m47961a("sdk custom error ".concat("onVideoDownloadFailed"), 99991);
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadSuccess() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> onVideoDownloadSuccess()");
                ((AdWorker) BaiduFullScreenVideoWorker.this).f11803j = AdStatus.ADLOAD;
                BaiduFullScreenVideoWorker.this.m47910y();
                if (BaiduFullScreenVideoWorker.this.m47970Y()) {
                    BaiduFullScreenVideoWorker.this.m47736aG();
                } else {
                    BaiduFullScreenVideoWorker.this.m47980O();
                }
            }

            @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void playCompletion() {
                Log.d("BeiZis", "showBdFullScreenVideo Callback --> playCompletion()");
            }
        }, false);
        this.f11907r = fullScreenVideoAd;
        fullScreenVideoAd.setAppSid(this.f11801h);
        this.f11907r.load();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        FullScreenVideoAd fullScreenVideoAd = this.f11907r;
        if (fullScreenVideoAd != null && fullScreenVideoAd.isReady()) {
            this.f11907r.show();
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        FullScreenVideoAd fullScreenVideoAd = this.f11907r;
        if (fullScreenVideoAd == null || TextUtils.isEmpty(fullScreenVideoAd.getECPMLevel()) || this.f11908s) {
            return;
        }
        this.f11908s = true;
        C3116af.m48496a("BeiZis", "showBdFullScreenVideo channel == Baidu竞价失败:" + i);
        this.f11907r.biddingFail(i != 1 ? i != 2 ? "900" : "100" : "203");
    }
}
