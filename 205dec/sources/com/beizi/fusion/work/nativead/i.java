package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: KsNativeAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15916n;

    /* renamed from: o  reason: collision with root package name */
    private String f15917o;

    /* renamed from: p  reason: collision with root package name */
    private long f15918p;

    /* renamed from: q  reason: collision with root package name */
    private long f15919q;

    /* renamed from: r  reason: collision with root package name */
    private KsFeedAd f15920r;

    /* renamed from: s  reason: collision with root package name */
    private float f15921s;

    /* renamed from: t  reason: collision with root package name */
    private float f15922t;

    /* renamed from: u  reason: collision with root package name */
    private View f15923u;

    public i(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15916n = context;
        this.f15917o = str;
        this.f15918p = j4;
        this.f15919q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15921s = f4;
        this.f15922t = f5;
        r();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "KUAISHOU";
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!av.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f15916n, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15919q);
        long j4 = this.f15919q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.f.a i() {
        return this.f15373j;
    }

    @Override // com.beizi.fusion.work.a
    public String j() {
        if (this.f15920r == null) {
            return null;
        }
        return this.f15920r.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        if (this.f15921s <= 0.0f) {
            this.f15921s = av.j(this.f15916n);
        }
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).width(av.a(this.f15916n, this.f15921s)).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsNativeAd onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadConfigFeedAd(build, new KsLoadManager.FeedAdListener() { // from class: com.beizi.fusion.work.nativead.i.2
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsNativeAd Callback --> onError: code = " + i4 + " \uff0cmessage= " + str);
                i.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                Log.d("BeiZis", "showKsNativeAd Callback --> onFeedAdLoad()");
                ((com.beizi.fusion.work.a) i.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                i.this.y();
                if (list == null || list.size() == 0) {
                    i.this.c(-991);
                    return;
                }
                i.this.a(list);
                if (!i.this.Y()) {
                    i.this.O();
                } else {
                    i.this.b();
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15923u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " NativeAdWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            if (this.f15920r != null && this.f15923u != null) {
                this.f15367d.a(g(), this.f15923u);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<KsFeedAd> list) {
        KsFeedAd ksFeedAd = list.get(0);
        this.f15920r = ksFeedAd;
        if (ksFeedAd == null) {
            return;
        }
        a(ksFeedAd.getECPM());
        this.f15920r.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build());
        this.f15920r.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.beizi.fusion.work.nativead.i.3

            /* renamed from: a  reason: collision with root package name */
            boolean f15926a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15927b = false;

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) i.this).f15367d != null && ((com.beizi.fusion.work.a) i.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) i.this).f15367d.d(i.this.g());
                }
                if (this.f15927b) {
                    return;
                }
                this.f15927b = true;
                i.this.E();
                i.this.ai();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) i.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) i.this).f15367d != null && ((com.beizi.fusion.work.a) i.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) i.this).f15367d.b(i.this.g());
                }
                if (this.f15926a) {
                    return;
                }
                this.f15926a = true;
                i.this.C();
                i.this.D();
                i.this.ah();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                Log.d("BeiZis", "showKsNativeAd Callback --> onDislikeClicked()");
                if (((com.beizi.fusion.work.a) i.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) i.this).f15367d.b(i.this.g(), i.this.f15923u);
                }
                i.this.G();
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
        this.f15923u = this.f15920r.getFeedView(this.f15916n);
    }
}
