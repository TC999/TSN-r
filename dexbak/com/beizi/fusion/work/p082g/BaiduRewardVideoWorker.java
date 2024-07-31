package com.beizi.fusion.work.p082g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.RewardVideoAd;
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

/* renamed from: com.beizi.fusion.work.g.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduRewardVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12010n;

    /* renamed from: o */
    private String f12011o;

    /* renamed from: p */
    private long f12012p;

    /* renamed from: q */
    private long f12013q;

    /* renamed from: r */
    private RewardVideoAd f12014r;

    /* renamed from: s */
    private boolean f12015s;

    public BaiduRewardVideoWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12010n = context;
        this.f12011o = str;
        this.f12012p = j;
        this.f12013q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47497aG() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " RewardVideoWorkers:" + m48669r.toString());
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
        RewardVideoAd rewardVideoAd;
        if (!m47936an() || (rewardVideoAd = this.f12014r) == null || TextUtils.isEmpty(rewardVideoAd.getECPMLevel()) || this.f12015s) {
            return;
        }
        this.f12015s = true;
        C3116af.m48496a("BeiZis", "showBdRewardVideo channel == Baidu竞价成功");
        C3116af.m48496a("BeiZis", "showBdRewardVideo channel == sendWinNoticeECPM:" + this.f12014r.getECPMLevel());
        RewardVideoAd rewardVideoAd2 = this.f12014r;
        rewardVideoAd2.biddingSuccess(rewardVideoAd2.getECPMLevel());
    }

    /* renamed from: b */
    public String m47496b() {
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduRewardVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                m47914u();
                this.f11795b.m48879v(String.valueOf(AdSettings.getSDKVersion()));
                BdAdManagerHolder.m48656a(this.f12010n, this.f11801h);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12013q);
        long j = this.f12013q;
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
        RewardVideoAd rewardVideoAd;
        if (m47936an() && (rewardVideoAd = this.f12014r) != null) {
            return rewardVideoAd.getECPMLevel();
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
        RewardVideoAd rewardVideoAd = new RewardVideoAd(this.f12010n, this.f11802i, new RewardVideoAd.RewardVideoAdListener() { // from class: com.beizi.fusion.work.g.a.2

            /* renamed from: a */
            boolean f12017a = false;

            /* renamed from: b */
            boolean f12018b = false;

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClick() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdClick()");
                if (((AdWorker) BaiduRewardVideoWorker.this).f11797d != null && ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48700d(BaiduRewardVideoWorker.this.mo46059g());
                }
                if (this.f12018b) {
                    return;
                }
                this.f12018b = true;
                BaiduRewardVideoWorker.this.m47990E();
                BaiduRewardVideoWorker.this.m47941ai();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdClose(float f) {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdClose()");
                if (((AdWorker) BaiduRewardVideoWorker.this).f11797d != null && ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48704c(BaiduRewardVideoWorker.this.m47496b());
                }
                BaiduRewardVideoWorker.this.m47988G();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdFailed: " + str);
                BaiduRewardVideoWorker.this.m47961a(str, 3793);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdLoaded() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdLoaded()");
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdShow() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdShow()");
                ((AdWorker) BaiduRewardVideoWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) BaiduRewardVideoWorker.this).f11797d != null && ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48710b(BaiduRewardVideoWorker.this.mo46059g());
                }
                if (this.f12017a) {
                    return;
                }
                this.f12017a = true;
                BaiduRewardVideoWorker.this.m47992C();
                BaiduRewardVideoWorker.this.mo46072az();
                BaiduRewardVideoWorker.this.m47991D();
                BaiduRewardVideoWorker.this.m47942ah();
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onAdSkip(float f) {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onAdSkip():" + f);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
            public void onRewardVerify(boolean z) {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onRewardVerify():" + z);
                if (z) {
                    BaiduRewardVideoWorker.this.m47985J();
                    if (((AdWorker) BaiduRewardVideoWorker.this).f11797d != null) {
                        ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48679k();
                    }
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadFailed() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onVideoDownloadFailed()");
                BaiduRewardVideoWorker.this.m47961a("sdk custom error ".concat("onVideoDownloadFailed"), 99991);
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void onVideoDownloadSuccess() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> onVideoDownloadSuccess()");
                ((AdWorker) BaiduRewardVideoWorker.this).f11803j = AdStatus.ADLOAD;
                BaiduRewardVideoWorker.this.m47910y();
                if (BaiduRewardVideoWorker.this.m47970Y()) {
                    BaiduRewardVideoWorker.this.m47497aG();
                } else {
                    BaiduRewardVideoWorker.this.m47980O();
                }
            }

            @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
            public void playCompletion() {
                Log.d("BeiZis", "showBdRewardedVideo Callback --> playCompletion()");
                if (((AdWorker) BaiduRewardVideoWorker.this).f11797d != null) {
                    ((AdWorker) BaiduRewardVideoWorker.this).f11797d.m48676l();
                }
            }
        }, false);
        this.f12014r = rewardVideoAd;
        rewardVideoAd.setAppSid(this.f11801h);
        this.f12014r.load();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        RewardVideoAd rewardVideoAd = this.f12014r;
        if (rewardVideoAd != null && rewardVideoAd.isReady()) {
            this.f12014r.show();
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
        RewardVideoAd rewardVideoAd = this.f12014r;
        if (rewardVideoAd == null || TextUtils.isEmpty(rewardVideoAd.getECPMLevel()) || this.f12015s) {
            return;
        }
        this.f12015s = true;
        C3116af.m48496a("BeiZis", "showBdRewardVideo channel == Baidu竞价失败:" + i);
        this.f12014r.biddingFail(i != 1 ? i != 2 ? "900" : "100" : "203");
    }
}
