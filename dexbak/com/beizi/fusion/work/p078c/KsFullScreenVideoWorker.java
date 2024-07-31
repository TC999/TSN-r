package com.beizi.fusion.work.p078c;

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
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.c.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsFullScreenVideoWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11935n;

    /* renamed from: o */
    private String f11936o;

    /* renamed from: p */
    private long f11937p;

    /* renamed from: q */
    private long f11938q;

    /* renamed from: r */
    private KsFullScreenVideoAd f11939r;

    public KsFullScreenVideoWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11935n = context;
        this.f11936o = str;
        this.f11937p = j;
        this.f11938q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m47653aG() {
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

    /* renamed from: b */
    public String m47652b() {
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsFullScreenVideoWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f11935n, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11938q);
        long j = this.f11938q;
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
        if (this.f11939r == null) {
            return null;
        }
        return this.f11939r.getECPM() + "";
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
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsFullScreenVideo onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadFullScreenVideoAd(build, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.c.d.2
            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsFullScreenVideo Callback --> onError: code = " + i + " ，message= " + str);
                KsFullScreenVideoWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                Log.d("BeiZis", "showKsFullScreenVideo Callback --> onFullScreenVideoAdLoad()");
                ((AdWorker) KsFullScreenVideoWorker.this).f11803j = AdStatus.ADLOAD;
                KsFullScreenVideoWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsFullScreenVideoWorker.this.m47921c(-991);
                    return;
                }
                KsFullScreenVideoWorker.this.f11939r = list.get(0);
                if (KsFullScreenVideoWorker.this.f11939r != null) {
                    KsFullScreenVideoWorker ksFullScreenVideoWorker = KsFullScreenVideoWorker.this;
                    ksFullScreenVideoWorker.m47967a(ksFullScreenVideoWorker.f11939r.getECPM());
                }
                if (KsFullScreenVideoWorker.this.m47970Y()) {
                    KsFullScreenVideoWorker.this.m47653aG();
                } else {
                    KsFullScreenVideoWorker.this.m47980O();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo47063a(Activity activity) {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f11939r;
        if (ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable() && activity != null) {
            this.f11939r.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.beizi.fusion.work.c.d.3

                /* renamed from: a */
                boolean f11942a = false;

                /* renamed from: b */
                boolean f11943b = false;

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onAdClicked() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onAdClicked()");
                    if (((AdWorker) KsFullScreenVideoWorker.this).f11797d != null && ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48700d(KsFullScreenVideoWorker.this.mo46059g());
                    }
                    if (this.f11943b) {
                        return;
                    }
                    this.f11943b = true;
                    KsFullScreenVideoWorker.this.m47990E();
                    KsFullScreenVideoWorker.this.m47941ai();
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onPageDismiss() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onPageDismiss()");
                    if (((AdWorker) KsFullScreenVideoWorker.this).f11797d != null && ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48704c(KsFullScreenVideoWorker.this.m47652b());
                    }
                    KsFullScreenVideoWorker.this.m47988G();
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onSkippedVideo() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onSkippedVideo");
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayEnd() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onVideoPlayEnd()");
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onVideoPlayError: code = " + i + " ，extra= " + i2);
                    KsFullScreenVideoWorker.this.m47961a(String.valueOf(i2), i);
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayStart() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onVideoPlayStart()");
                    ((AdWorker) KsFullScreenVideoWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) KsFullScreenVideoWorker.this).f11797d != null && ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) KsFullScreenVideoWorker.this).f11797d.m48710b(KsFullScreenVideoWorker.this.mo46059g());
                    }
                    if (this.f11942a) {
                        return;
                    }
                    this.f11942a = true;
                    KsFullScreenVideoWorker.this.m47992C();
                    KsFullScreenVideoWorker.this.m47991D();
                    KsFullScreenVideoWorker.this.m47942ah();
                }
            });
            this.f11939r.showFullScreenVideoAd(activity, null);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager != null) {
            baseManager.m48754a(10140);
        }
    }
}
