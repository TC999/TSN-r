package com.beizi.fusion.work.splash;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.ad.inter.listeners.AdListener;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HwSplashWorker extends AdWorker {

    /* renamed from: n */
    long f12757n;

    /* renamed from: o */
    private Context f12758o;

    /* renamed from: p */
    private String f12759p;

    /* renamed from: q */
    private long f12760q;

    /* renamed from: r */
    private ViewGroup f12761r;

    /* renamed from: s */
    private PPSSplashView f12762s;

    /* renamed from: t */
    private ViewGroup f12763t;

    public HwSplashWorker(Context context, String str, long j, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f12758o = context;
        this.f12759p = str;
        this.f12760q = j;
        this.f12761r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12763t = new SplashContainer(context);
        m47917r();
    }

    /* renamed from: aG */
    private void m46264aG() {
        ViewGroup viewGroup = this.f12761r;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = this.f12763t;
            if (viewGroup2 != null) {
                this.f12761r.addView(viewGroup2);
                return;
            } else {
                m47927aw();
                return;
            }
        }
        m47927aw();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "HUAWEI";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f12757n = System.currentTimeMillis();
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.huawei.openalliance.ad.views.PPSSplashView")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.h.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HwSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "HUAWEI sdk not import , will do nothing");
                    return;
                }
                m47914u();
                HiAd.getInstance(this.f12758o).initLog(true, 4);
                HiAd.getInstance(this.f12758o).enableUserInfo(true);
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, sleepTime);
            return;
        }
        BaseManager baseManager = this.f11797d;
        if (baseManager == null || baseManager.m48667t() >= 1 || this.f11797d.m48668s() == 2) {
            return;
        }
        mo46050l();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46264aG();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: k */
    public AdSpacesBean.BuyerBean mo46052k() {
        return this.f11798e;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: l */
    protected void mo46050l() {
        m47912w();
        m47943ag();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f11802i);
        AdSlotParam.Builder builder = new AdSlotParam.Builder();
        builder.setAdIds(arrayList).setDeviceType(4).setOrientation(1).setTest(false);
        PPSSplashView pPSSplashView = new PPSSplashView(this.f12758o);
        this.f12762s = pPSSplashView;
        pPSSplashView.setAdSlotParam(builder.build());
        this.f12762s.setAdListener(new AdListener() { // from class: com.beizi.fusion.work.splash.h.2
            public void onAdDismissed() {
                Log.d("BeiZis", "showHwSplash onAdDismissed()");
                HwSplashWorker.this.m47947ac();
                HwSplashWorker.this.m47988G();
            }

            public void onAdFailedToLoad(int i) {
                Log.d("BeiZis", "showHwSplash onAdFailedToLoad() " + i);
                HwSplashWorker.this.m47961a(String.valueOf(i), i);
            }

            public void onAdLoaded() {
                Log.d("BeiZis", "showHwSplash onAdLoaded()");
                HwSplashWorker.this.m47910y();
                ((AdWorker) HwSplashWorker.this).f11803j = AdStatus.ADLOAD;
                HwSplashWorker hwSplashWorker = HwSplashWorker.this;
                hwSplashWorker.f12763t = hwSplashWorker.f12762s;
                if (HwSplashWorker.this.m47970Y()) {
                    HwSplashWorker.this.m46263b();
                } else {
                    HwSplashWorker.this.m47980O();
                }
            }
        });
        this.f12762s.setAdActionListener(new AdActionListener() { // from class: com.beizi.fusion.work.splash.h.3
            public void onAdClick() {
                Log.d("BeiZis", "showHwSplash onAdClick()");
                HwSplashWorker.this.m47990E();
                if (((AdWorker) HwSplashWorker.this).f11797d != null) {
                    if (((AdWorker) HwSplashWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) HwSplashWorker.this).f11797d.m48700d(HwSplashWorker.this.mo46059g());
                    }
                    HwSplashWorker.this.m47941ai();
                }
            }

            public void onAdShowed() {
                Log.d("BeiZis", "showHwSplash onAdShowed()");
                HwSplashWorker.this.m47992C();
                ((AdWorker) HwSplashWorker.this).f11803j = AdStatus.ADSHOW;
                HwSplashWorker.this.mo47585ab();
                HwSplashWorker.this.m47991D();
                HwSplashWorker.this.m47942ah();
            }
        });
        this.f12762s.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46263b() {
        BaseManager baseManager = this.f11797d;
        if (baseManager == null) {
            return;
        }
        Map<String, AdWorker> m48669r = baseManager.m48669r();
        Log.d("BeiZis", mo46059g() + " splashWorkers:" + m48669r.toString());
        m47969Z();
        CompeteStatus competeStatus = this.f11800g;
        if (competeStatus == CompeteStatus.SUCCESS) {
            m47946ad();
        } else if (competeStatus == CompeteStatus.FAIL) {
            Log.d("BeiZis", "other worker shown," + mo46059g() + " remove");
        }
    }
}
