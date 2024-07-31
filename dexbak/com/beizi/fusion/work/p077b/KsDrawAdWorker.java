package com.beizi.fusion.work.p077b;

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
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.b.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsDrawAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f11893n;

    /* renamed from: o */
    private String f11894o;

    /* renamed from: p */
    private long f11895p;

    /* renamed from: q */
    private long f11896q;

    /* renamed from: r */
    private View f11897r;

    public KsDrawAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11893n = context;
        this.f11894o = str;
        this.f11895p = j;
        this.f11896q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
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
                if (!C3138av.m48301a("com.kwad.sdk.api.KsAdSDK")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsDrawAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f11893n, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f11896q);
        long j = this.f11896q;
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
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsDrawAd onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadDrawAd(build, new KsLoadManager.DrawAdListener() { // from class: com.beizi.fusion.work.b.b.2
            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                Log.d("BeiZis", "showKsDrawAd Callback --> onDrawAdLoad()");
                ((AdWorker) KsDrawAdWorker.this).f11803j = AdStatus.ADLOAD;
                KsDrawAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsDrawAdWorker.this.m47921c(-991);
                    return;
                }
                KsDrawAdWorker.this.m47763a(list);
                if (!KsDrawAdWorker.this.m47970Y()) {
                    KsDrawAdWorker.this.m47980O();
                } else {
                    KsDrawAdWorker.this.m47762b();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsDrawAd Callback --> onError code=" + i + " , message=" + str);
                KsDrawAdWorker.this.m47961a(str, i);
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f11897r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m47762b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " DrawAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f11897r != null) {
                this.f11797d.m48726a(mo46059g(), this.f11897r);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m47763a(List<KsDrawAd> list) {
        KsDrawAd ksDrawAd = list.get(0);
        if (ksDrawAd == null) {
            return;
        }
        m47967a(ksDrawAd.getECPM());
        ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.beizi.fusion.work.b.b.3

            /* renamed from: a */
            boolean f11900a = false;

            /* renamed from: b */
            boolean f11901b = false;

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onAdClicked()");
                if (((AdWorker) KsDrawAdWorker.this).f11797d != null && ((AdWorker) KsDrawAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsDrawAdWorker.this).f11797d.m48700d(KsDrawAdWorker.this.mo46059g());
                }
                if (this.f11901b) {
                    return;
                }
                this.f11901b = true;
                KsDrawAdWorker.this.m47990E();
                KsDrawAdWorker.this.m47941ai();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onAdShow()");
                ((AdWorker) KsDrawAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) KsDrawAdWorker.this).f11797d != null && ((AdWorker) KsDrawAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsDrawAdWorker.this).f11797d.m48710b(KsDrawAdWorker.this.mo46059g());
                }
                if (this.f11900a) {
                    return;
                }
                this.f11900a = true;
                KsDrawAdWorker.this.m47992C();
                KsDrawAdWorker.this.m47991D();
                KsDrawAdWorker.this.m47942ah();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayEnd()");
                if (((AdWorker) KsDrawAdWorker.this).f11797d != null) {
                    ((AdWorker) KsDrawAdWorker.this).f11797d.m48676l();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayError()");
                KsDrawAdWorker.this.m47961a("sdk custom error ".concat("onVideoPlayError"), 99991);
                if (((AdWorker) KsDrawAdWorker.this).f11797d != null) {
                    ((AdWorker) KsDrawAdWorker.this).f11797d.m48674m();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayPause() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayPause()");
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayResume() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayResume()");
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayStart() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayStart()");
            }
        });
        this.f11897r = ksDrawAd.getDrawView(this.f11893n);
    }
}
