package com.beizi.fusion.work.nativead;

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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.nativead.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class KsNativeAdWorker extends AdWorker implements AdShowObserver {

    /* renamed from: n */
    private Context f12453n;

    /* renamed from: o */
    private String f12454o;

    /* renamed from: p */
    private long f12455p;

    /* renamed from: q */
    private long f12456q;

    /* renamed from: r */
    private KsFeedAd f12457r;

    /* renamed from: s */
    private float f12458s;

    /* renamed from: t */
    private float f12459t;

    /* renamed from: u */
    private View f12460u;

    public KsNativeAdWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        this.f12453n = context;
        this.f12454o = str;
        this.f12455p = j;
        this.f12456q = j2;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12458s = f;
        this.f12459t = f2;
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
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KsNativeAdWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                m47914u();
                KsAdManagerHolder.m48622a(this.f12453n, this.f11801h);
                this.f11795b.m48881u(KsAdSDK.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + this.f12456q);
        long j = this.f12456q;
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
        if (this.f12457r == null) {
            return null;
        }
        return this.f12457r.getECPM() + "";
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
        if (this.f12458s <= 0.0f) {
            this.f12458s = C3138av.m48288j(this.f12453n);
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f11802i)).width(C3138av.m48304a(this.f12453n, this.f12458s)).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsNativeAd onError:渠道广告请求对象为空");
            m47961a("渠道广告请求异常", 10160);
            return;
        }
        if ("S2S".equalsIgnoreCase(this.f11798e.getBidType())) {
            build.setBidResponse(m47957aC());
        }
        loadManager.loadConfigFeedAd(build, new KsLoadManager.FeedAdListener() { // from class: com.beizi.fusion.work.nativead.i.2
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i, String str) {
                Log.d("BeiZis", "showKsNativeAd Callback --> onError: code = " + i + " ，message= " + str);
                KsNativeAdWorker.this.m47961a(str, i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                Log.d("BeiZis", "showKsNativeAd Callback --> onFeedAdLoad()");
                ((AdWorker) KsNativeAdWorker.this).f11803j = AdStatus.ADLOAD;
                KsNativeAdWorker.this.m47910y();
                if (list == null || list.size() == 0) {
                    KsNativeAdWorker.this.m47921c(-991);
                    return;
                }
                KsNativeAdWorker.this.m46684a(list);
                if (!KsNativeAdWorker.this.m47970Y()) {
                    KsNativeAdWorker.this.m47980O();
                } else {
                    KsNativeAdWorker.this.m46683b();
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: o */
    public View mo46446o() {
        return this.f12460u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46683b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " NativeAdWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            if (this.f12457r != null && this.f12460u != null) {
                this.f11797d.m48726a(mo46059g(), this.f12460u);
            } else {
                this.f11797d.m48754a(10140);
            }
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46684a(List<KsFeedAd> list) {
        KsFeedAd ksFeedAd = list.get(0);
        this.f12457r = ksFeedAd;
        if (ksFeedAd == null) {
            return;
        }
        m47967a(ksFeedAd.getECPM());
        this.f12457r.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build());
        this.f12457r.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.beizi.fusion.work.nativead.i.3

            /* renamed from: a */
            boolean f12463a = false;

            /* renamed from: b */
            boolean f12464b = false;

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onAdClicked()");
                if (((AdWorker) KsNativeAdWorker.this).f11797d != null && ((AdWorker) KsNativeAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsNativeAdWorker.this).f11797d.m48700d(KsNativeAdWorker.this.mo46059g());
                }
                if (this.f12464b) {
                    return;
                }
                this.f12464b = true;
                KsNativeAdWorker.this.m47990E();
                KsNativeAdWorker.this.m47941ai();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onAdShow()");
                ((AdWorker) KsNativeAdWorker.this).f11803j = AdStatus.ADSHOW;
                if (((AdWorker) KsNativeAdWorker.this).f11797d != null && ((AdWorker) KsNativeAdWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) KsNativeAdWorker.this).f11797d.m48710b(KsNativeAdWorker.this.mo46059g());
                }
                if (this.f12463a) {
                    return;
                }
                this.f12463a = true;
                KsNativeAdWorker.this.m47992C();
                KsNativeAdWorker.this.m47991D();
                KsNativeAdWorker.this.m47942ah();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onDislikeClicked()");
                if (((AdWorker) KsNativeAdWorker.this).f11797d != null) {
                    ((AdWorker) KsNativeAdWorker.this).f11797d.m48709b(KsNativeAdWorker.this.mo46059g(), KsNativeAdWorker.this.f12460u);
                }
                KsNativeAdWorker.this.m47988G();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onDownloadTipsDialogDismiss()");
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onDownloadTipsDialogShow()");
            }
        });
        this.f12460u = this.f12457r.getFeedView(this.f12453n);
    }
}
