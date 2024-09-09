package com.beizi.fusion.work.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.u;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CsjRewardVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15581n;

    /* renamed from: o  reason: collision with root package name */
    private String f15582o;

    /* renamed from: p  reason: collision with root package name */
    private long f15583p;

    /* renamed from: q  reason: collision with root package name */
    private long f15584q;

    /* renamed from: r  reason: collision with root package name */
    private TTRewardVideoAd f15585r;

    /* renamed from: s  reason: collision with root package name */
    private TTAdNative f15586s;

    /* renamed from: t  reason: collision with root package name */
    private String f15587t;

    /* renamed from: u  reason: collision with root package name */
    private String f15588u;

    public b(Context context, String str, String str2, String str3, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15581n = context;
        this.f15582o = str;
        this.f15583p = j4;
        this.f15584q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15587t = str2;
        this.f15588u = str3;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " RewardVideoWorkers:" + r3.toString());
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
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "CSJ sdk not import , will do nothing");
                    return;
                }
                u();
                u.a(this, this.f15581n, this.f15371h, this.f15368e.getDirectDownload());
                this.f15365b.t(TTAdSdk.getAdManager().getSDKVersion());
                au();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15584q);
        long j4 = this.f15584q;
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
        this.f15586s = u.a().createAdNative(this.f15581n);
        this.f15586s.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.f15372i).setSupportDeepLink(true).setExpressViewAcceptedSize(500.0f, 500.0f).setUserID(this.f15587t).setMediaExtra(this.f15588u).setOrientation(1).build(), new TTAdNative.RewardVideoAdListener() { // from class: com.beizi.fusion.work.g.b.2
            private void a() {
                b.this.f15585r.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.beizi.fusion.work.g.b.2.1

                    /* renamed from: a  reason: collision with root package name */
                    boolean f15591a = false;

                    /* renamed from: b  reason: collision with root package name */
                    boolean f15592b = false;

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdClose()");
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.c(b.this.b());
                        }
                        b.this.G();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdShow()");
                        ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.b(b.this.g());
                        }
                        if (this.f15591a) {
                            return;
                        }
                        this.f15591a = true;
                        b.this.C();
                        b.this.D();
                        b.this.ah();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onAdVideoBarClick()");
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null && ((com.beizi.fusion.work.a) b.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.d(b.this.g());
                        }
                        if (this.f15592b) {
                            return;
                        }
                        this.f15592b = true;
                        b.this.E();
                        b.this.ai();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean z3, int i4, Bundle bundle) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z3, int i4, String str, int i5, String str2) {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVerify() result== " + ("verify:" + z3));
                        if (z3 && ((com.beizi.fusion.work.a) b.this).f15367d != null) {
                            b.this.J();
                            ((com.beizi.fusion.work.a) b.this).f15367d.k();
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        b.this.a(str2, i5);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Log.e("BeiZis", "showCsjRewardedVideo Callback --> onSkippedVideo()");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onVideoComplete()");
                        if (((com.beizi.fusion.work.a) b.this).f15367d != null) {
                            ((com.beizi.fusion.work.a) b.this).f15367d.l();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Log.d("BeiZis", "showCsjRewardedVideo Callback --> onVideoError()");
                        b.this.a("sdk custom error ".concat("onVideoError"), 99991);
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onError:" + str);
                b.this.a(str, i4);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVideoAdLoad()");
                ((com.beizi.fusion.work.a) b.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                b.this.y();
                if (tTRewardVideoAd == null) {
                    b.this.c(-991);
                    return;
                }
                b.this.f15585r = tTRewardVideoAd;
                a();
                if (b.this.Y()) {
                    b.this.aG();
                } else {
                    b.this.O();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Log.d("BeiZis", "showCsjRewardedVideo Callback --> onRewardVideoCached()");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd = this.f15585r;
        if (tTRewardVideoAd != null && activity != null) {
            tTRewardVideoAd.showRewardVideoAd(activity);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }
}
