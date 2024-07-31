package com.beizi.fusion.work.p079d;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.xyz.newad.hudong.ADInit;
import com.xyz.newad.hudong.widgets.FloatListener;
import com.xyz.newad.hudong.widgets.floating.FloatAD;

/* renamed from: com.beizi.fusion.work.d.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FinalLinkNativeFloatWorker extends AdWorker {

    /* renamed from: n */
    private Context f11945n;

    /* renamed from: o */
    private String f11946o;

    /* renamed from: p */
    private long f11947p;

    public FinalLinkNativeFloatWorker(Context context, String str, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager) {
        this.f11945n = context;
        this.f11946o = str;
        this.f11947p = j;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        m47917r();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "FinalLink";
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46065d() {
        if (this.f11797d == null) {
            return;
        }
        this.f11801h = this.f11798e.getAppId();
        this.f11802i = this.f11798e.getSpaceId();
        this.f11796c = this.f11798e.getBuyerSpaceUuId();
        String str = (String) C3137at.m48313b(this.f11945n, "__OAID__", "");
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.xyz.newad.hudong.ADInit")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.d.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FinalLinkNativeFloatWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.d("BeiZis", "FinalLink sdk not import , will do nothing");
                    return;
                }
                m47914u();
                ADInit.getInstance().init(this.f11945n, this.f11801h);
                ADInit.getInstance().setOaid(str);
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
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
        if (this.f11945n instanceof Activity) {
            FloatAD.get().finish((Activity) this.f11945n);
            m47969Z();
            FloatAD.get().show((Activity) this.f11945n, this.f11802i, new FloatListener() { // from class: com.beizi.fusion.work.d.a.2
                public void onClick() {
                    Log.d("BeiZis", "NativeFloat Ad onClick");
                    FinalLinkNativeFloatWorker.this.m47990E();
                    if (((AdWorker) FinalLinkNativeFloatWorker.this).f11797d != null) {
                        if (((AdWorker) FinalLinkNativeFloatWorker.this).f11797d.m48668s() != 2) {
                            ((AdWorker) FinalLinkNativeFloatWorker.this).f11797d.m48700d(FinalLinkNativeFloatWorker.this.mo46059g());
                        }
                        FinalLinkNativeFloatWorker.this.m47941ai();
                    }
                }

                public void onClose() {
                    Log.d("BeiZis", "NativeFloat Ad onClose");
                    if (((AdWorker) FinalLinkNativeFloatWorker.this).f11797d != null && ((AdWorker) FinalLinkNativeFloatWorker.this).f11797d.m48668s() != 2) {
                        FinalLinkNativeFloatWorker.this.m47947ac();
                    }
                    FinalLinkNativeFloatWorker.this.m47988G();
                }

                public void onDismiss() {
                    Log.d("BeiZis", "NativeFloat Ad onDismiss");
                }

                public void onFail() {
                    Log.d("BeiZis", "NativeFloat Ad onFail");
                    FinalLinkNativeFloatWorker.this.m47961a("获取广告失败", 10140);
                }

                public void onInvisible() {
                }

                public void onShow() {
                    Log.d("BeiZis", "NativeFloat Ad onShow");
                    FinalLinkNativeFloatWorker.this.m47946ad();
                    FinalLinkNativeFloatWorker.this.m47910y();
                    FinalLinkNativeFloatWorker.this.m47982M();
                    ((AdWorker) FinalLinkNativeFloatWorker.this).f11803j = AdStatus.ADSHOW;
                    if (((AdWorker) FinalLinkNativeFloatWorker.this).f11797d != null && ((AdWorker) FinalLinkNativeFloatWorker.this).f11797d.m48668s() != 2) {
                        ((AdWorker) FinalLinkNativeFloatWorker.this).f11797d.m48710b(FinalLinkNativeFloatWorker.this.mo46059g());
                    }
                    FinalLinkNativeFloatWorker.this.m47992C();
                    FinalLinkNativeFloatWorker.this.m47991D();
                    FinalLinkNativeFloatWorker.this.m47942ah();
                }

                public void onVisible() {
                }
            });
            return;
        }
        Log.e("BeiZis", "NativeFloat Ad needs an Activity Context to show!");
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        if (this.f11945n instanceof Activity) {
            FloatAD.get().finish((Activity) this.f11945n);
        }
    }
}
