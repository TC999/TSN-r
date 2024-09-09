package com.beizi.fusion.work.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsFullScreenVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15505n;

    /* renamed from: o  reason: collision with root package name */
    private String f15506o;

    /* renamed from: p  reason: collision with root package name */
    private long f15507p;

    /* renamed from: q  reason: collision with root package name */
    private long f15508q;

    /* renamed from: r  reason: collision with root package name */
    private KsFullScreenVideoAd f15509r;

    public d(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15505n = context;
        this.f15506o = str;
        this.f15507p = j4;
        this.f15508q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " FullScreenVideoWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            e eVar2 = this.f15367d;
            if (eVar2 != null) {
                eVar2.a(g(), (View) null);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    public String b() {
        return AMPSConstants.ChannelName.CHANNEL_NAME_KS;
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "KUAISHOU";
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
                if (!aw.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.c.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f15505n, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15508q);
        long j4 = this.f15508q;
        if (j4 > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, j4);
            return;
        }
        e eVar = this.f15367d;
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
        if (this.f15509r == null) {
            return null;
        }
        return this.f15509r.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsFullScreenVideo onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadFullScreenVideoAd(build, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.c.d.2
            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsFullScreenVideo Callback --> onError: code = " + i4 + " \uff0cmessage= " + str);
                d.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                Log.d("BeiZis", "showKsFullScreenVideo Callback --> onFullScreenVideoAdLoad()");
                ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                d.this.y();
                if (list == null || list.size() == 0) {
                    d.this.c(-991);
                    return;
                }
                d.this.f15509r = list.get(0);
                if (d.this.f15509r != null) {
                    d dVar = d.this;
                    dVar.a(dVar.f15509r.getECPM());
                }
                if (d.this.Y()) {
                    d.this.aG();
                } else {
                    d.this.O();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f15509r;
        if (ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable() && activity != null) {
            this.f15509r.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.beizi.fusion.work.c.d.3

                /* renamed from: a  reason: collision with root package name */
                boolean f15512a = false;

                /* renamed from: b  reason: collision with root package name */
                boolean f15513b = false;

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onAdClicked() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onAdClicked()");
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
                    }
                    if (this.f15513b) {
                        return;
                    }
                    this.f15513b = true;
                    d.this.E();
                    d.this.ai();
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onPageDismiss() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onPageDismiss()");
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.b());
                    }
                    d.this.G();
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
                public void onVideoPlayError(int i4, int i5) {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onVideoPlayError: code = " + i4 + " \uff0cextra= " + i5);
                    d.this.a(String.valueOf(i5), i4);
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayStart() {
                    Log.d("BeiZis", "showKsFullScreenVideo Callback --> onVideoPlayStart()");
                    ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) d.this).f15367d.b(d.this.g());
                    }
                    if (this.f15512a) {
                        return;
                    }
                    this.f15512a = true;
                    d.this.C();
                    d.this.D();
                    d.this.ah();
                }
            });
            this.f15509r.showFullScreenVideoAd(activity, null);
            return;
        }
        e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }
}