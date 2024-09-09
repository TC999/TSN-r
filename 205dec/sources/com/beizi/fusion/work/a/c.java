package com.beizi.fusion.work.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjBannerAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15423n;

    /* renamed from: o  reason: collision with root package name */
    private String f15424o;

    /* renamed from: p  reason: collision with root package name */
    private long f15425p;

    /* renamed from: q  reason: collision with root package name */
    private long f15426q;

    /* renamed from: r  reason: collision with root package name */
    private TTAdNative f15427r;

    /* renamed from: s  reason: collision with root package name */
    private TTNativeExpressAd f15428s;

    /* renamed from: t  reason: collision with root package name */
    private View f15429t;

    /* renamed from: u  reason: collision with root package name */
    private float f15430u;

    /* renamed from: v  reason: collision with root package name */
    private float f15431v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f15432w;

    public c(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar, float f4, float f5, ViewGroup viewGroup) {
        this.f15423n = context;
        this.f15424o = str;
        this.f15425p = j4;
        this.f15426q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15430u = f4;
        this.f15431v = f5;
        this.f15432w = viewGroup;
        r();
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
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
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        com.beizi.fusion.b.d dVar = this.f15364a;
        if (dVar != null) {
            com.beizi.fusion.b.b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f15423n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15426q);
        long j4 = this.f15426q;
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
    public void f() {
        Log.d("BeiZis", "showCsjBannerAd showAd()");
        ViewGroup viewGroup = this.f15432w;
        if (viewGroup != null && this.f15429t != null) {
            if (viewGroup.getChildCount() > 0) {
                this.f15432w.removeAllViews();
            }
            this.f15432w.addView(this.f15429t);
            return;
        }
        aw();
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
        if (this.f15430u <= 0.0f) {
            this.f15430u = aw.j(this.f15423n);
        }
        if (this.f15431v <= 0.0f) {
            this.f15431v = Math.round(this.f15430u / 6.4f);
        }
        if (av()) {
            return;
        }
        this.f15427r = u.a().createAdNative((Activity) this.f15423n);
        this.f15427r.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(this.f15430u, this.f15431v).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.a.c.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onError:" + str);
                c.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onNativeExpressAdLoad()");
                ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                c.this.y();
                if (list == null || list.size() == 0) {
                    c.this.c(-991);
                    return;
                }
                c.this.f15428s = list.get(0);
                c.this.f15428s.setSlideIntervalTime(30000);
                c cVar = c.this;
                cVar.a(cVar.f15428s);
                c.this.f15428s.render();
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        TTNativeExpressAd tTNativeExpressAd = this.f15428s;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " BannerAdWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            ViewGroup viewGroup = this.f15432w;
            if (viewGroup != null && this.f15429t != null) {
                if (viewGroup.getChildCount() > 0) {
                    this.f15432w.removeAllViews();
                }
                this.f15432w.addView(this.f15429t);
                this.f15367d.a(g(), (View) null);
                return;
            }
            this.f15367d.a(10140);
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.a.c.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) c.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) c.this).f15367d.d(c.this.g());
                }
                c.this.E();
                c.this.ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) c.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) c.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) c.this).f15367d.b(c.this.g());
                }
                c.this.C();
                c.this.D();
                c.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onRenderFail()");
                c.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                Log.d("BeiZis", "showCsjBannerAd Callback --> onRenderSuccess() width== " + f4 + ", height== " + f5);
                c.this.f15429t = view;
                if (c.this.Y()) {
                    c.this.b();
                } else {
                    c.this.O();
                }
            }
        });
        b(tTNativeExpressAd);
    }

    private void b(TTNativeExpressAd tTNativeExpressAd) {
        try {
            tTNativeExpressAd.setDislikeCallback((Activity) this.f15423n, new TTAdDislike.DislikeInteractionCallback() { // from class: com.beizi.fusion.work.a.c.4
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i4, String str, boolean z3) {
                    Log.d("BeiZis", "showCsjBannerAd Callback --> onSelected()");
                    if (((com.beizi.fusion.work.a) c.this).f15367d != null) {
                        ((com.beizi.fusion.work.a) c.this).f15367d.c(c.this.g());
                    }
                    c.this.G();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
        } catch (Exception unused) {
        }
    }
}
