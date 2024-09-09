package com.beizi.fusion.work.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.b.d;
import com.beizi.fusion.d.c;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsDrawAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends com.beizi.fusion.work.a implements c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15463n;

    /* renamed from: o  reason: collision with root package name */
    private String f15464o;

    /* renamed from: p  reason: collision with root package name */
    private long f15465p;

    /* renamed from: q  reason: collision with root package name */
    private long f15466q;

    /* renamed from: r  reason: collision with root package name */
    private View f15467r;

    public b(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15463n = context;
        this.f15464o = str;
        this.f15465p = j4;
        this.f15466q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
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
        d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a(AMPSConstants.CHANNEL_SDK_KS_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "Ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f15463n, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15466q);
        long j4 = this.f15466q;
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
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        KsScene build = new KsScene.Builder(Long.parseLong(this.f15372i)).adNum(1).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsDrawAd onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadDrawAd(build, new KsLoadManager.DrawAdListener() { // from class: com.beizi.fusion.work.b.b.2
            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                Log.d("BeiZis", "showKsDrawAd Callback --> onDrawAdLoad()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                b.this.y();
                if (list == null || list.size() == 0) {
                    b.this.c(-991);
                    return;
                }
                b.this.a(list);
                if (!b.this.Y()) {
                    b.this.O();
                } else {
                    b.this.b();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsDrawAd Callback --> onError code=" + i4 + " , message=" + str);
                b.this.a(str, i4);
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15467r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " DrawAdWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            if (this.f15467r != null) {
                this.f15367d.a(g(), this.f15467r);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<KsDrawAd> list) {
        KsDrawAd ksDrawAd = list.get(0);
        if (ksDrawAd == null) {
            return;
        }
        a(ksDrawAd.getECPM());
        ksDrawAd.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.beizi.fusion.work.b.b.3

            /* renamed from: a  reason: collision with root package name */
            boolean f15470a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15471b = false;

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.d(b.this.g());
                }
                if (this.f15471b) {
                    return;
                }
                this.f15471b = true;
                b.this.E();
                b.this.ai();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                }
                if (this.f15470a) {
                    return;
                }
                this.f15470a = true;
                b.this.C();
                b.this.D();
                b.this.ah();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayEnd()");
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.l();
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
                Log.d("BeiZis", "showKsDrawAd Callback --> onVideoPlayError()");
                b.this.a("sdk custom error ".concat("onVideoPlayError"), 99991);
                if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) b.this).f15367d.m();
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
        this.f15467r = ksDrawAd.getDrawView(this.f15463n);
    }
}
