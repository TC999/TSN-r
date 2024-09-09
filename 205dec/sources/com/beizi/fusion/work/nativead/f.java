package com.beizi.fusion.work.nativead;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CsjNativeAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15867n;

    /* renamed from: o  reason: collision with root package name */
    private String f15868o;

    /* renamed from: p  reason: collision with root package name */
    private long f15869p;

    /* renamed from: q  reason: collision with root package name */
    private long f15870q;

    /* renamed from: r  reason: collision with root package name */
    private TTAdNative f15871r;

    /* renamed from: s  reason: collision with root package name */
    private TTNativeExpressAd f15872s;

    /* renamed from: t  reason: collision with root package name */
    private float f15873t;

    /* renamed from: u  reason: collision with root package name */
    private float f15874u;

    /* renamed from: v  reason: collision with root package name */
    private View f15875v;

    public f(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        this.f15867n = context;
        this.f15868o = str;
        this.f15869p = j4;
        this.f15870q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15873t = f4;
        this.f15874u = f5;
        r();
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ;
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
                if (!av.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.nativead.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f15867n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15870q);
        long j4 = this.f15870q;
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
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        if (av()) {
            return;
        }
        this.f15871r = u.a().createAdNative(this.f15867n);
        if (this.f15873t <= 0.0f) {
            this.f15873t = av.j(this.f15867n);
        }
        if (this.f15874u <= 0.0f) {
            this.f15874u = 0.0f;
        }
        this.f15871r.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.f15873t, this.f15874u).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.nativead.f.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onError:" + str);
                f.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onNativeExpressAdLoad()");
                ((com.beizi.fusion.work.a) f.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                f.this.y();
                if (list == null || list.size() == 0) {
                    f.this.c(-991);
                    return;
                }
                f.this.f15872s = list.get(0);
                f fVar = f.this;
                fVar.a(fVar.f15872s);
                f.this.f15872s.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        TTNativeExpressAd tTNativeExpressAd = this.f15872s;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15875v;
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
            if (this.f15872s != null && this.f15875v != null) {
                this.f15367d.a(g(), this.f15875v);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.nativead.f.3

            /* renamed from: a  reason: collision with root package name */
            boolean f15878a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15879b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) f.this).f15367d != null && ((com.beizi.fusion.work.a) f.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) f.this).f15367d.d(f.this.g());
                }
                if (this.f15879b) {
                    return;
                }
                this.f15879b = true;
                f.this.E();
                f.this.ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) f.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) f.this).f15367d != null && ((com.beizi.fusion.work.a) f.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) f.this).f15367d.b(f.this.g());
                }
                if (this.f15878a) {
                    return;
                }
                this.f15878a = true;
                f.this.C();
                f.this.D();
                f.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onRenderFail()");
                f.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                Log.d("BeiZis", "showCsjNativeAd Callback --> onRenderSuccess()");
                f.this.f15875v = view;
                if (f.this.Y()) {
                    f.this.b();
                } else {
                    f.this.O();
                }
            }
        });
        b(tTNativeExpressAd);
    }

    private void b(TTNativeExpressAd tTNativeExpressAd) {
        try {
            tTNativeExpressAd.setDislikeCallback((Activity) this.f15867n, new TTAdDislike.DislikeInteractionCallback() { // from class: com.beizi.fusion.work.nativead.f.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i4, String str, boolean z3) {
                    Log.d("BeiZis", "showCsjNativeAd Callback --> onSelected()");
                    if (((com.beizi.fusion.work.a) f.this).f15367d != null && ((com.beizi.fusion.work.a) f.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) f.this).f15367d.b(f.this.g(), f.this.f15875v);
                    }
                    f.this.G();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
        } catch (Exception unused) {
        }
    }
}
