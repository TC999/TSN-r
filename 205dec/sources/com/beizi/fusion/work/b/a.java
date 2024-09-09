package com.beizi.fusion.work.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.b.d;
import com.beizi.fusion.d.c;
import com.beizi.fusion.d.e;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjDrawAdWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a implements c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15451n;

    /* renamed from: o  reason: collision with root package name */
    private String f15452o;

    /* renamed from: p  reason: collision with root package name */
    private long f15453p;

    /* renamed from: q  reason: collision with root package name */
    private long f15454q;

    /* renamed from: r  reason: collision with root package name */
    private TTAdNative f15455r;

    /* renamed from: s  reason: collision with root package name */
    private View f15456s;

    public a(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15451n = context;
        this.f15452o = str;
        this.f15453p = j4;
        this.f15454q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
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
                if (!aw.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.b.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f15451n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15454q);
        long j4 = this.f15454q;
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
        if (av()) {
            return;
        }
        this.f15455r = u.a().createAdNative(this.f15451n);
        this.f15455r.loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(com.beizi.fusion.g.a.a(this.f15451n), 0.0f).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.beizi.fusion.work.b.a.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onError code=" + i4 + " , message=" + str);
                a.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onNativeExpressAdLoad()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                a.this.y();
                if (list == null || list.size() == 0) {
                    a.this.c(-991);
                } else {
                    a.this.a(list);
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f15456s;
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
            if (this.f15456s != null) {
                this.f15367d.a(g(), this.f15456s);
            } else {
                this.f15367d.a(10140);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<TTNativeExpressAd> list) {
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.beizi.fusion.work.b.a.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onClickRetry()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onProgressUpdate(long j4, long j5) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdComplete() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdComplete()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdContinuePlay() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdContinuePlay()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdPaused() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdPaused()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoAdStartPlay() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoAdStartPlay()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoError(int i4, int i5) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoError() errorCode=" + i4 + ", extraCode=" + i5);
                a.this.a(String.valueOf(i5), i4);
                if (((com.beizi.fusion.work.a) a.this).f15367d != null) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onVideoLoad()");
            }
        });
        tTNativeExpressAd.setCanInterruptVideoPlay(true);
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.beizi.fusion.work.b.a.4

            /* renamed from: a  reason: collision with root package name */
            boolean f15460a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15461b = false;

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i4) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onAdClicked()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                }
                if (this.f15461b) {
                    return;
                }
                this.f15461b = true;
                a.this.E();
                a.this.ai();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i4) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onAdShow()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                }
                if (this.f15460a) {
                    return;
                }
                this.f15460a = true;
                a.this.C();
                a.this.D();
                a.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i4) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onRenderFail() code=" + i4 + ", error=" + str);
                a.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f4, float f5) {
                Log.d("BeiZis", "showCsjDrawAd Callback --> onRenderSuccess()");
                a.this.f15456s = view;
                if (a.this.Y()) {
                    a.this.b();
                } else {
                    a.this.O();
                }
            }
        });
        tTNativeExpressAd.render();
    }
}
