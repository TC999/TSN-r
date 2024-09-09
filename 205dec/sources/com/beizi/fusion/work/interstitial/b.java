package com.beizi.fusion.work.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjFullScreenVideoInterstitialWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15708n;

    /* renamed from: o  reason: collision with root package name */
    private String f15709o;

    /* renamed from: p  reason: collision with root package name */
    private long f15710p;

    /* renamed from: q  reason: collision with root package name */
    private long f15711q;

    /* renamed from: r  reason: collision with root package name */
    private TTFullScreenVideoAd f15712r;

    /* renamed from: s  reason: collision with root package name */
    private TTAdNative f15713s;

    public b(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15708n = context;
        this.f15709o = str;
        this.f15710p = j4;
        this.f15711q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + "CsjFullScreenVideoInterstitialWorkers:" + r3.toString());
        Z();
        h hVar = this.f15370g;
        if (hVar == h.SUCCESS) {
            com.beizi.fusion.d.e eVar2 = this.f15367d;
            if (eVar2 != null) {
                eVar2.a(g(), (View) null);
            }
        } else if (hVar == h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }

    @Override // com.beizi.fusion.work.a
    public void ay() {
        v();
        e();
    }

    public String b() {
        return AMPSConstants.ChannelName.CHANNEL_NAME_CSJ;
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
                if (!aw.a("com.bytedance.sdk.openadsdk.TTAdNative")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.interstitial.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f15708n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15711q);
        long j4 = this.f15711q;
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
        this.f15713s = u.a().createAdNative(this.f15708n);
        this.f15713s.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f15372i).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).setAdLoadType(TTAdLoadType.PRELOAD).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.beizi.fusion.work.interstitial.b.2
            private void a() {
                b.this.f15712r.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.beizi.fusion.work.interstitial.b.2.1

                    /* renamed from: a  reason: collision with root package name */
                    boolean f15716a = false;

                    /* renamed from: b  reason: collision with root package name */
                    boolean f15717b = false;

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdClose() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdClose");
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.c(b.this.b());
                        }
                        b.this.G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdShow() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdShow");
                        ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                        }
                        if (this.f15716a) {
                            return;
                        }
                        this.f15716a = true;
                        b.this.C();
                        b.this.D();
                        b.this.ah();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onAdVideoBarClick() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onAdVideoBarClick");
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.d(b.this.g());
                        }
                        if (this.f15717b) {
                            return;
                        }
                        this.f15717b = true;
                        b.this.E();
                        b.this.ai();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onSkippedVideo() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onSkippedVideo");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                    public void onVideoComplete() {
                        Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onVideoComplete");
                    }
                });
                b.this.f15712r.setDownloadListener(new TTAppDownloadListener() { // from class: com.beizi.fusion.work.interstitial.b.2.2
                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadActive(long j4, long j5, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFailed(long j4, long j5, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadFinished(long j4, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onDownloadPaused(long j4, long j5, String str, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onIdle() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                    public void onInstalled(String str, String str2) {
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onError:" + str);
                b.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onFullScreenVideoAdLoad");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                b.this.y();
                if (tTFullScreenVideoAd == null) {
                    b.this.c(-991);
                    return;
                }
                b.this.f15712r = tTFullScreenVideoAd;
                a();
                if (!b.this.Y()) {
                    b.this.O();
                } else {
                    b.this.aG();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
                Log.d("BeiZis", "showCsjFullScreenVideoInterstitial Callback --> onFullScreenVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        if (this.f15712r != null) {
            this.f15712r = null;
        }
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.f15712r;
        if (tTFullScreenVideoAd != null && activity != null) {
            tTFullScreenVideoAd.showFullScreenVideoAd(activity, TTAdConstant.RitScenes.GAME_GIFT_BONUS, null);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }
}
