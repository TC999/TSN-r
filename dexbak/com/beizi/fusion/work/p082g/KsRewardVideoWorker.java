package com.beizi.fusion.work.p082g;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.AdShowObserver;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.KsAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.g.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsRewardVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12056n;

    /* renamed from: o */
    private String f12057o;

    /* renamed from: p */
    private long f12058p;

    /* renamed from: q */
    private long f12059q;

    /* renamed from: r */
    private KsRewardVideoAd f12060r;

    /* renamed from: s */
    private String f12061s;

    /* renamed from: t */
    private String f12062t;

    public KsRewardVideoWorker(Context context, String str, String str2, String str3, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12056n = context;
        this.f12057o = str;
        this.f12058p = j;
        this.f12059q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12061s = str2;
        this.f12062t = str3;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47363aG() {
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
    public String m47362b() {
        return "1019";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "KUAISHOU";
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
                if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsRewardVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f12056n, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12059q);
        long j = this.f12059q;
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
        if (this.f12060r == null) {
            return null;
        }
        return this.f12060r.getECPM() + "";
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
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.f11802i));
        HashMap hashMap = new HashMap();
        hashMap.put("thirdUserId", this.f12061s);
        hashMap.put("extraData", this.f12062t);
        builder.rewardCallbackExtraData(hashMap);
        KsScene build = builder.build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsRewardedVideo onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadRewardVideoAd(build, new KsLoadManager.RewardVideoAdListener() { // from class: com.beizi.fusion.work.g.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsRewardedVideo Callback --> onError: code = " + i + " ，message= " + str);
                KsRewardVideoWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardVideoAdLoad()");
                ((AdWorker) KsRewardVideoWorker.this).f11803j = AdStatus.ADLOAD;
                KsRewardVideoWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsRewardVideoWorker.this.m47921c(-991);
                    return;
                }
                KsRewardVideoWorker.this.f12060r = list.get(0);
                if (KsRewardVideoWorker.this.f12060r != null) {
                    KsRewardVideoWorker ksRewardVideoWorker = KsRewardVideoWorker.this;
                    ksRewardVideoWorker.m47967a(ksRewardVideoWorker.f12060r.getECPM());
                }
                if (KsRewardVideoWorker.this.m47970Y()) {
                    KsRewardVideoWorker.this.m47363aG();
                } else {
                    KsRewardVideoWorker.this.m47980O();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.f12060r;
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable() && activity != null) {
            this.f12060r.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.beizi.fusion.work.g.e.3

                /* renamed from: a */
                boolean f12065a = false;

                /* renamed from: b */
                boolean f12066b = false;

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onAdClicked()");
                    if (((AdWorker) KsRewardVideoWorker.this).f11797d != null && ((AdWorker) KsRewardVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsRewardVideoWorker.this).f11797d.m48700d(KsRewardVideoWorker.this.mo46059g());
                    }
                    if (this.f12066b) {
                        return;
                    }
                    this.f12066b = true;
                    KsRewardVideoWorker.this.m47990E();
                    KsRewardVideoWorker.this.m47941ai();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onExtraRewardVerify()i:" + i);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onPageDismiss()");
                    if (((AdWorker) KsRewardVideoWorker.this).f11797d != null && ((AdWorker) KsRewardVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsRewardVideoWorker.this).f11797d.m48704c(KsRewardVideoWorker.this.m47362b());
                    }
                    KsRewardVideoWorker.this.m47988G();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i, int i2) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardStepVerify()i:" + i + " i1:" + i2);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardVerify()");
                    if (((AdWorker) KsRewardVideoWorker.this).f11797d != null) {
                        KsRewardVideoWorker.this.m47985J();
                        ((AdWorker) KsRewardVideoWorker.this).f11797d.m48679k();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayEnd()");
                    if (((AdWorker) KsRewardVideoWorker.this).f11797d != null) {
                        ((AdWorker) KsRewardVideoWorker.this).f11797d.m48676l();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayError: code = " + i + " ，extra= " + i2);
                    KsRewardVideoWorker.this.m47961a(String.valueOf(i2), i);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayStart()");
                    ((AdWorker) KsRewardVideoWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) KsRewardVideoWorker.this).f11797d != null && ((AdWorker) KsRewardVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsRewardVideoWorker.this).f11797d.m48710b(KsRewardVideoWorker.this.mo46059g());
                    }
                    if (this.f12065a) {
                        return;
                    }
                    this.f12065a = true;
                    KsRewardVideoWorker.this.m47992C();
                    KsRewardVideoWorker.this.m47991D();
                    KsRewardVideoWorker.this.m47942ah();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoSkipToEnd()");
                }
            });
            this.f12060r.showRewardVideoAd(activity, null);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }
}
