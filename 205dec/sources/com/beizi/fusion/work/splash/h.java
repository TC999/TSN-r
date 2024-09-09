package com.beizi.fusion.work.splash;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.ad.inter.listeners.AdListener;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.ArrayList;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HwSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class h extends com.beizi.fusion.work.a {

    /* renamed from: n  reason: collision with root package name */
    long f16109n;

    /* renamed from: o  reason: collision with root package name */
    private Context f16110o;

    /* renamed from: p  reason: collision with root package name */
    private String f16111p;

    /* renamed from: q  reason: collision with root package name */
    private long f16112q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16113r;

    /* renamed from: s  reason: collision with root package name */
    private PPSSplashView f16114s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f16115t;

    public h(Context context, String str, long j4, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar) {
        this.f16110o = context;
        this.f16111p = str;
        this.f16112q = j4;
        this.f16113r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16115t = new SplashContainer(context);
        r();
    }

    private void aG() {
        ViewGroup viewGroup = this.f16113r;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = this.f16115t;
            if (viewGroup2 != null) {
                this.f16113r.addView(viewGroup2);
                return;
            } else {
                aw();
                return;
            }
        }
        aw();
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
        this.f16109n = System.currentTimeMillis();
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
                if (!av.a("com.huawei.openalliance.ad.views.PPSSplashView")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "HUAWEI sdk not import , will do nothing");
                    return;
                }
                u();
                HiAd.getInstance(this.f16110o).initLog(true, 4);
                HiAd.getInstance(this.f16110o).enableUserInfo(true);
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
            return;
        }
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null || eVar.t() >= 1 || this.f15367d.s() == 2) {
            return;
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
        Log.d("BeiZis", g() + " out make show ad");
        aG();
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
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f15372i);
        AdSlotParam.Builder builder = new AdSlotParam.Builder();
        builder.setAdIds(arrayList).setDeviceType(4).setOrientation(1).setTest(false);
        PPSSplashView pPSSplashView = new PPSSplashView(this.f16110o);
        this.f16114s = pPSSplashView;
        pPSSplashView.setAdSlotParam(builder.build());
        this.f16114s.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.splash.h.2
            public void onAdDismissed() {
                Log.d("BeiZis", "showHwSplash onAdDismissed()");
                h.this.ac();
                h.this.G();
            }

            public void onAdFailedToLoad(int i4) {
                Log.d("BeiZis", "showHwSplash onAdFailedToLoad() " + i4);
                h.this.a(String.valueOf(i4), i4);
            }

            public void onAdLoaded() {
                Log.d("BeiZis", "showHwSplash onAdLoaded()");
                h.this.y();
                ((com.beizi.fusion.work.a) h.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                h hVar = h.this;
                hVar.f16115t = hVar.f16114s;
                if (h.this.Y()) {
                    h.this.b();
                } else {
                    h.this.O();
                }
            }
        });
        this.f16114s.setAdActionListener(new AdActionListener() { // from class: com.beizi.fusion.work.splash.h.3
            public void onAdClick() {
                Log.d("BeiZis", "showHwSplash onAdClick()");
                h.this.E();
                if (((com.beizi.fusion.work.a) h.this).f15367d != null) {
                    if (((com.beizi.fusion.work.a) h.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) h.this).f15367d.d(h.this.g());
                    }
                    h.this.ai();
                }
            }

            public void onAdShowed() {
                Log.d("BeiZis", "showHwSplash onAdShowed()");
                h.this.C();
                ((com.beizi.fusion.work.a) h.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                h.this.ab();
                h.this.D();
                h.this.ah();
            }
        });
        this.f16114s.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.beizi.fusion.d.e eVar = this.f15367d;
        if (eVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> r3 = eVar.r();
        Log.d("BeiZis", g() + " splashWorkers:" + r3.toString());
        Z();
        com.beizi.fusion.d.h hVar = this.f15370g;
        if (hVar == com.beizi.fusion.d.h.SUCCESS) {
            ad();
        } else if (hVar == com.beizi.fusion.d.h.FAIL) {
            Log.d("BeiZis", "other worker shown," + g() + " remove");
        }
    }
}
