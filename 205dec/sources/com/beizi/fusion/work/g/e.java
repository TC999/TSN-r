package com.beizi.fusion.work.g;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.d.h;
import com.beizi.fusion.d.n;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: KsRewardVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15617n;

    /* renamed from: o  reason: collision with root package name */
    private String f15618o;

    /* renamed from: p  reason: collision with root package name */
    private long f15619p;

    /* renamed from: q  reason: collision with root package name */
    private long f15620q;

    /* renamed from: r  reason: collision with root package name */
    private KsRewardVideoAd f15621r;

    /* renamed from: s  reason: collision with root package name */
    private String f15622s;

    /* renamed from: t  reason: collision with root package name */
    private String f15623t;

    public e(Context context, String str, String str2, String str3, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15617n = context;
        this.f15618o = str;
        this.f15619p = j4;
        this.f15620q = j5;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15622s = str2;
        this.f15623t = str3;
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
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "ks sdk not import , will do nothing");
                    return;
                }
                u();
                n.a(this.f15617n, this.f15371h);
                this.f15365b.u(KsAdSDK.getSDKVersion());
                au();
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15620q);
        long j4 = this.f15620q;
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
        if (this.f15621r == null) {
            return null;
        }
        return this.f15621r.getECPM() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.f15372i));
        HashMap hashMap = new HashMap();
        hashMap.put("thirdUserId", this.f15622s);
        hashMap.put("extraData", this.f15623t);
        builder.rewardCallbackExtraData(hashMap);
        KsScene build = builder.build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager == null) {
            Log.d("BeiZis", "showKsRewardedVideo onError:\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5bf9\u8c61\u4e3a\u7a7a");
            a("\u6e20\u9053\u5e7f\u544a\u8bf7\u6c42\u5f02\u5e38", 10160);
            return;
        }
        if (AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(this.f15368e.getBidType())) {
            build.setBidResponse(aC());
        }
        loadManager.loadRewardVideoAd(build, new KsLoadManager.RewardVideoAdListener() { // from class: com.beizi.fusion.work.g.e.2
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i4, String str) {
                Log.d("BeiZis", "showKsRewardedVideo Callback --> onError: code = " + i4 + " \uff0cmessage= " + str);
                e.this.a(str, i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardVideoAdLoad()");
                ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                e.this.y();
                if (list == null || list.size() == 0) {
                    e.this.c(-991);
                    return;
                }
                e.this.f15621r = list.get(0);
                if (e.this.f15621r != null) {
                    e eVar = e.this;
                    eVar.a(eVar.f15621r.getECPM());
                }
                if (e.this.Y()) {
                    e.this.aG();
                } else {
                    e.this.O();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.f15621r;
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable() && activity != null) {
            this.f15621r.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.beizi.fusion.work.g.e.3

                /* renamed from: a  reason: collision with root package name */
                boolean f15626a = false;

                /* renamed from: b  reason: collision with root package name */
                boolean f15627b = false;

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onAdClicked()");
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) e.this).f15367d.d(e.this.g());
                    }
                    if (this.f15627b) {
                        return;
                    }
                    this.f15627b = true;
                    e.this.E();
                    e.this.ai();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i4) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onExtraRewardVerify()i:" + i4);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onPageDismiss()");
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) e.this).f15367d.c(e.this.b());
                    }
                    e.this.G();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i4, int i5) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardStepVerify()i:" + i4 + " i1:" + i5);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onRewardVerify()");
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null) {
                        e.this.J();
                        ((com.beizi.fusion.work.a) e.this).f15367d.k();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayEnd()");
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null) {
                        ((com.beizi.fusion.work.a) e.this).f15367d.l();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i4, int i5) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayError: code = " + i4 + " \uff0cextra= " + i5);
                    e.this.a(String.valueOf(i5), i4);
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoPlayStart()");
                    ((com.beizi.fusion.work.a) e.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) e.this).f15367d != null && ((com.beizi.fusion.work.a) e.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) e.this).f15367d.b(e.this.g());
                    }
                    if (this.f15626a) {
                        return;
                    }
                    this.f15626a = true;
                    e.this.C();
                    e.this.D();
                    e.this.ah();
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j4) {
                    Log.d("BeiZis", "showKsRewardedVideo Callback --> onVideoSkipToEnd()");
                }
            });
            this.f15621r.showRewardVideoAd(activity, null);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar != null) {
            eVar.a(10140);
        }
    }
}
