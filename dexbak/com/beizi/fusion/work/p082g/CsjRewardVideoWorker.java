package com.beizi.fusion.work.p082g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.g.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjRewardVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12020n;

    /* renamed from: o */
    private String f12021o;

    /* renamed from: p */
    private long f12022p;

    /* renamed from: q */
    private long f12023q;

    /* renamed from: r */
    private TTRewardVideoAd f12024r;

    /* renamed from: s */
    private TTAdNative f12025s;

    /* renamed from: t */
    private String f12026t;

    /* renamed from: u */
    private String f12027u;

    public CsjRewardVideoWorker(Context context, String str, String str2, String str3, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12020n = context;
        this.f12021o = str;
        this.f12022p = j;
        this.f12023q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12026t = str2;
        this.f12027u = str3;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47465aG() {
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
    /* renamed from: ay */
    public void mo46297ay() {
        m47913v();
        mo46389e();
    }

    /* renamed from: b */
    public String m47464b() {
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CsjRewardVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                m47914u();
                TTAdManagerHolder.m48592a(this, this.f12020n, this.f11801h, this.f11798e.getDirectDownload());
                this.f11795b.m48883t(TTAdSdk.getAdManager().getSDKVersion());
                m47929au();
            }
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: e */
    public void mo46389e() {
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12023q);
        long j = this.f12023q;
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
        this.f12025s = TTAdManagerHolder.m48594a().createAdNative(this.f12020n);
        this.f12025s.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.f11802i).setSupportDeepLink(true).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(this.f12026t).setMediaExtra(this.f12027u).setOrientation(1).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.beizi.fusion.work.g.b.2
            /* renamed from: a */
            private void m47435a() {
                CsjRewardVideoWorker.this.f12024r.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.beizi.fusion.work.g.b.2.1

                    /* renamed from: a */
                    boolean f12030a = false;

                    /* renamed from: b */
                    boolean f12031b = false;

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdClose()");
                        if (((AdWorker) CsjRewardVideoWorker.this).f11797d != null && ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48704c(CsjRewardVideoWorker.this.m47464b());
                        }
                        CsjRewardVideoWorker.this.m47988G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdShow()");
                        ((AdWorker) CsjRewardVideoWorker.this).f11803j = AdStatus.ADSHOW;
                        if (((AdWorker) CsjRewardVideoWorker.this).f11797d != null && ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48710b(CsjRewardVideoWorker.this.mo46059g());
                        }
                        if (this.f12030a) {
                            return;
                        }
                        this.f12030a = true;
                        CsjRewardVideoWorker.this.m47992C();
                        CsjRewardVideoWorker.this.m47991D();
                        CsjRewardVideoWorker.this.m47942ah();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdVideoBarClick()");
                        if (((AdWorker) CsjRewardVideoWorker.this).f11797d != null && ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48700d(CsjRewardVideoWorker.this.mo46059g());
                        }
                        if (this.f12031b) {
                            return;
                        }
                        this.f12031b = true;
                        CsjRewardVideoWorker.this.m47990E();
                        CsjRewardVideoWorker.this.m47941ai();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean z, int i, Bundle bundle) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVerify() result== " + ("verify:" + z));
                        if (z && ((AdWorker) CsjRewardVideoWorker.this).f11797d != null) {
                            CsjRewardVideoWorker.this.m47985J();
                            ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48679k();
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        CsjRewardVideoWorker.this.m47961a(str2, i2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Log.e("BeiZis", "showCsjRewardedVideo Callback --> onSkippedVideo()");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onVideoComplete()");
                        if (((AdWorker) CsjRewardVideoWorker.this).f11797d != null) {
                            ((AdWorker) CsjRewardVideoWorker.this).f11797d.m48676l();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onVideoError()");
                        CsjRewardVideoWorker.this.m47961a("sdk custom error ".concat("onVideoError"), 99991);
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onError:" + str);
                CsjRewardVideoWorker.this.m47961a(str, i);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVideoAdLoad()");
                ((AdWorker) CsjRewardVideoWorker.this).f11803j = AdStatus.ADLOAD;
                CsjRewardVideoWorker.this.m47910y();
                if (tTRewardVideoAd == null) {
                    CsjRewardVideoWorker.this.m47921c(-991);
                    return;
                }
                CsjRewardVideoWorker.this.f12024r = tTRewardVideoAd;
                m47435a();
                if (CsjRewardVideoWorker.this.m47970Y()) {
                    CsjRewardVideoWorker.this.m47465aG();
                } else {
                    CsjRewardVideoWorker.this.m47980O();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVideoCached()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd = this.f12024r;
        if (tTRewardVideoAd != null && activity != null) {
            tTRewardVideoAd.showRewardVideoAd(activity);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }
}
