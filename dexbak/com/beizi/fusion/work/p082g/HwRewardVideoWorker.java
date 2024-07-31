package com.beizi.fusion.work.p082g;

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
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.RewardAdLoader;
import com.huawei.openalliance.ad.inter.data.IRewardAd;
import com.huawei.openalliance.ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.ad.inter.listeners.RewardAdListener;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.g.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HwRewardVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12045n;

    /* renamed from: o */
    private String f12046o;

    /* renamed from: p */
    private long f12047p;

    /* renamed from: q */
    private long f12048q;

    /* renamed from: r */
    private RewardAdLoader f12049r;

    /* renamed from: s */
    private List<IRewardAd> f12050s;

    public HwRewardVideoWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12045n = context;
        this.f12046o = str;
        this.f12047p = j;
        this.f12048q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47398aG() {
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

    /* renamed from: b */
    public String m47397b() {
        return "1020";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "HUAWEI";
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
                if (!C3138av.m48301a("com.huawei.openalliance.ad.inter.RewardAdLoader")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HwRewardVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "HUAWEI sdk not import , will do nothing");
                    return;
                }
                m47914u();
                HiAd.getInstance(this.f12045n).initLog(true, 4);
                HiAd.getInstance(this.f12045n).enableUserInfo(true);
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12048q);
        long j = this.f12048q;
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
        RewardAdLoader rewardAdLoader = new RewardAdLoader(this.f12045n, new String[]{this.f11802i});
        this.f12049r = rewardAdLoader;
        rewardAdLoader.setListener(new RewardAdListener() { // from class: com.beizi.fusion.work.g.d.2
            public void onAdFailed(int i) {
                Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdFailed: errorCode = " + i);
                HwRewardVideoWorker.this.m47961a(String.valueOf(i), i);
            }

            public void onAdsLoaded(Map<String, List<IRewardAd>> map) {
                Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdsLoaded()");
                ((AdWorker) HwRewardVideoWorker.this).f11803j = AdStatus.ADLOAD;
                HwRewardVideoWorker.this.m47910y();
                if (map == null && map.isEmpty()) {
                    HwRewardVideoWorker.this.m47921c(-991);
                    return;
                }
                HwRewardVideoWorker hwRewardVideoWorker = HwRewardVideoWorker.this;
                hwRewardVideoWorker.f12050s = map.get(((AdWorker) hwRewardVideoWorker).f11802i);
                if (HwRewardVideoWorker.this.m47970Y()) {
                    HwRewardVideoWorker.this.m47398aG();
                } else {
                    HwRewardVideoWorker.this.m47980O();
                }
            }
        });
        this.f12049r.loadAds(4, false);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        List<IRewardAd> list = this.f12050s;
        if (list != null && !list.isEmpty()) {
            IRewardAd iRewardAd = this.f12050s.get(0);
            if (iRewardAd == null) {
                BaseManager baseManager = this.f11797d;
                if (baseManager != null) {
                    baseManager.m48754a(10140);
                    return;
                }
                return;
            } else if (!iRewardAd.isExpired() && iRewardAd.isValid()) {
                iRewardAd.setMute(true);
                iRewardAd.show(this.f12045n, new IRewardAdStatusListener() { // from class: com.beizi.fusion.work.g.d.3

                    /* renamed from: a */
                    boolean f12053a = false;

                    /* renamed from: b */
                    boolean f12054b = false;

                    public void onAdClicked() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdClicked()");
                        if (((AdWorker) HwRewardVideoWorker.this).f11797d != null && ((AdWorker) HwRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) HwRewardVideoWorker.this).f11797d.m48700d(HwRewardVideoWorker.this.mo46059g());
                        }
                        if (this.f12054b) {
                            return;
                        }
                        this.f12054b = true;
                        HwRewardVideoWorker.this.m47990E();
                        HwRewardVideoWorker.this.m47941ai();
                    }

                    public void onAdClosed() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdClosed()");
                        if (((AdWorker) HwRewardVideoWorker.this).f11797d != null && ((AdWorker) HwRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) HwRewardVideoWorker.this).f11797d.m48704c(HwRewardVideoWorker.this.m47397b());
                        }
                        HwRewardVideoWorker.this.m47988G();
                    }

                    public void onAdCompleted() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdCompleted()");
                        if (((AdWorker) HwRewardVideoWorker.this).f11797d != null) {
                            ((AdWorker) HwRewardVideoWorker.this).f11797d.m48676l();
                        }
                    }

                    public void onAdError(int i, int i2) {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdError: code = " + i + " ，extra= " + i2);
                        HwRewardVideoWorker.this.m47961a(String.valueOf(i), i2);
                    }

                    public void onAdShown() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdShown()");
                        ((AdWorker) HwRewardVideoWorker.this).f11803j = AdStatus.ADSHOW;
                        if (((AdWorker) HwRewardVideoWorker.this).f11797d != null && ((AdWorker) HwRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) HwRewardVideoWorker.this).f11797d.m48710b(HwRewardVideoWorker.this.mo46059g());
                        }
                        if (this.f12053a) {
                            return;
                        }
                        this.f12053a = true;
                        HwRewardVideoWorker.this.m47992C();
                        HwRewardVideoWorker.this.m47991D();
                        HwRewardVideoWorker.this.m47942ah();
                    }

                    public void onRewarded() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onRewarded()");
                        if (((AdWorker) HwRewardVideoWorker.this).f11797d != null) {
                            HwRewardVideoWorker.this.m47985J();
                            ((AdWorker) HwRewardVideoWorker.this).f11797d.m48679k();
                        }
                    }
                });
                return;
            } else {
                BaseManager baseManager2 = this.f11797d;
                if (baseManager2 != null) {
                    baseManager2.m48754a(10140);
                    return;
                }
                return;
            }
        }
        BaseManager baseManager3 = this.f11797d;
        if (baseManager3 != null) {
            baseManager3.m48754a(10140);
        }
    }
}
