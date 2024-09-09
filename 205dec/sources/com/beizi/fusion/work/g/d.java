package com.beizi.fusion.work.g;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.beizi.fusion.d.h;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.RewardAdLoader;
import com.huawei.openalliance.ad.inter.data.IRewardAd;
import com.huawei.openalliance.ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.ad.inter.listeners.RewardAdListener;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HwRewardVideoWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends com.beizi.fusion.work.a implements com.beizi.fusion.d.c {

    /* renamed from: n  reason: collision with root package name */
    private Context f15606n;

    /* renamed from: o  reason: collision with root package name */
    private String f15607o;

    /* renamed from: p  reason: collision with root package name */
    private long f15608p;

    /* renamed from: q  reason: collision with root package name */
    private long f15609q;

    /* renamed from: r  reason: collision with root package name */
    private RewardAdLoader f15610r;

    /* renamed from: s  reason: collision with root package name */
    private List<IRewardAd> f15611s;

    public d(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f15606n = context;
        this.f15607o = str;
        this.f15608p = j4;
        this.f15609q = j5;
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
        return AMPSConstants.ChannelName.CHANNEL_NAME_HW;
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "HUAWEI";
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
                if (!aw.a("com.huawei.openalliance.ad.inter.RewardAdLoader")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.g.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "HUAWEI sdk not import , will do nothing");
                    return;
                }
                u();
                HiAd.getInstance(this.f15606n).initLog(true, 4);
                HiAd.getInstance(this.f15606n).enableUserInfo(true);
                v();
            }
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + this.f15609q);
        long j4 = this.f15609q;
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
        RewardAdLoader rewardAdLoader = new RewardAdLoader(this.f15606n, new String[]{this.f15372i});
        this.f15610r = rewardAdLoader;
        rewardAdLoader.setListener(new RewardAdListener() { // from class: com.beizi.fusion.work.g.d.2
            public void onAdFailed(int i4) {
                Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdFailed: errorCode = " + i4);
                d.this.a(String.valueOf(i4), i4);
            }

            public void onAdsLoaded(Map<String, List<IRewardAd>> map) {
                Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdsLoaded()");
                ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                d.this.y();
                if (map == null && map.isEmpty()) {
                    d.this.c(-991);
                    return;
                }
                d dVar = d.this;
                dVar.f15611s = map.get(((com.beizi.fusion.work.a) dVar).f15372i);
                if (d.this.Y()) {
                    d.this.aG();
                } else {
                    d.this.O();
                }
            }
        });
        this.f15610r.loadAds(4, false);
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        List<IRewardAd> list = this.f15611s;
        if (list != null && !list.isEmpty()) {
            IRewardAd iRewardAd = this.f15611s.get(0);
            if (iRewardAd == null) {
                com.beizi.fusion.d.e eVar = this.f15367d;
                if (eVar != null) {
                    eVar.a(10140);
                    return;
                }
                return;
            } else if (!iRewardAd.isExpired() && iRewardAd.isValid()) {
                iRewardAd.setMute(true);
                iRewardAd.show(this.f15606n, new IRewardAdStatusListener() { // from class: com.beizi.fusion.work.g.d.3

                    /* renamed from: a  reason: collision with root package name */
                    boolean f15614a = false;

                    /* renamed from: b  reason: collision with root package name */
                    boolean f15615b = false;

                    public void onAdClicked() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdClicked()");
                        if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) d.this).f15367d.d(d.this.g());
                        }
                        if (this.f15615b) {
                            return;
                        }
                        this.f15615b = true;
                        d.this.E();
                        d.this.ai();
                    }

                    public void onAdClosed() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdClosed()");
                        if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) d.this).f15367d.c(d.this.b());
                        }
                        d.this.G();
                    }

                    public void onAdCompleted() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdCompleted()");
                        if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                            ((com.beizi.fusion.work.a) d.this).f15367d.l();
                        }
                    }

                    public void onAdError(int i4, int i5) {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdError: code = " + i4 + " \uff0cextra= " + i5);
                        d.this.a(String.valueOf(i4), i5);
                    }

                    public void onAdShown() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onAdShown()");
                        ((com.beizi.fusion.work.a) d.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                        if (((com.beizi.fusion.work.a) d.this).f15367d != null && ((com.beizi.fusion.work.a) d.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) d.this).f15367d.b(d.this.g());
                        }
                        if (this.f15614a) {
                            return;
                        }
                        this.f15614a = true;
                        d.this.C();
                        d.this.D();
                        d.this.ah();
                    }

                    public void onRewarded() {
                        Log.d("BeiZis", "showHwRewardedVideo Callback --> onRewarded()");
                        if (((com.beizi.fusion.work.a) d.this).f15367d != null) {
                            d.this.J();
                            ((com.beizi.fusion.work.a) d.this).f15367d.k();
                        }
                    }
                });
                return;
            } else {
                com.beizi.fusion.d.e eVar2 = this.f15367d;
                if (eVar2 != null) {
                    eVar2.a(10140);
                    return;
                }
                return;
            }
        }
        com.beizi.fusion.d.e eVar3 = this.f15367d;
        if (eVar3 != null) {
            eVar3.a(10140);
        }
    }
}
