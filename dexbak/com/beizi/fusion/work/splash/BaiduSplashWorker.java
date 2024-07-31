package com.beizi.fusion.work.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.BdAdManagerHolder;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduSplashWorker extends AdWorker {

    /* renamed from: A */
    private float f12466A;

    /* renamed from: n */
    private Context f12467n;

    /* renamed from: o */
    private String f12468o;

    /* renamed from: p */
    private long f12469p;

    /* renamed from: q */
    private boolean f12470q;

    /* renamed from: r */
    private View f12471r;

    /* renamed from: s */
    private ViewGroup f12472s;

    /* renamed from: t */
    private ViewGroup f12473t;

    /* renamed from: u */
    private SplashAd f12474u;

    /* renamed from: v */
    private List<AdSpacesBean.RenderViewBean> f12475v;

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12476w = new ArrayList();

    /* renamed from: x */
    private List<AdSpacesBean.RenderViewBean> f12477x = new ArrayList();

    /* renamed from: y */
    private boolean f12478y;

    /* renamed from: z */
    private float f12479z;

    public BaiduSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, BaseManager baseManager) {
        this.f12467n = context;
        this.f12468o = str;
        this.f12469p = j;
        this.f12471r = view;
        this.f12472s = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12473t = new SplashContainer(context);
        this.f12475v = list;
        m47917r();
    }

    /* renamed from: aG */
    private void m46657aG() {
        ViewGroup viewGroup;
        SplashAd splashAd = this.f12474u;
        if (splashAd != null && (viewGroup = this.f12472s) != null) {
            splashAd.show(viewGroup);
        } else {
            m47927aw();
        }
    }

    /* renamed from: aH */
    private void m46656aH() {
        for (int i = 0; i < this.f12475v.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12475v.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12477x.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12476w.add(renderViewBean);
            }
        }
        if (this.f12476w.size() > 0) {
            Collections.sort(this.f12476w, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.a.3
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean2, AdSpacesBean.RenderViewBean renderViewBean3) {
                    return renderViewBean3.getLevel() - renderViewBean2.getLevel();
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: A */
    protected void mo46197A() {
        if (!m47909z() || this.f12474u == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: az */
    public void mo46072az() {
        SplashAd splashAd;
        if (!m47936an() || (splashAd = this.f12474u) == null || TextUtils.isEmpty(splashAd.getECPMLevel()) || this.f12470q) {
            return;
        }
        this.f12470q = true;
        C3116af.m48496a("BeiZis", "showBdSplash channel == Baidu竞价成功");
        C3116af.m48496a("BeiZis", "showBdSplash channel == sendWinNoticeECPM:" + this.f12474u.getECPMLevel());
        SplashAd splashAd2 = this.f12474u;
        splashAd2.biddingSuccess(splashAd2.getECPMLevel());
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "BAIDU";
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
        C3116af.m48495b("BeiZis", "AdWorker chanel = " + this.f11796c);
        ObserverAdStatus observerAdStatus = this.f11794a;
        if (observerAdStatus != null) {
            EventBean m48977a = observerAdStatus.m48860a().m48977a(this.f11796c);
            this.f11795b = m48977a;
            if (m48977a != null) {
                m47916s();
                if (!C3138av.m48301a("com.baidu.mobads.sdk.api.BDAdConfig")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                m47914u();
                this.f11795b.m48879v(String.valueOf(AdSettings.getSDKVersion()));
                m47929au();
                BdAdManagerHolder.m48656a(this.f12467n, this.f11801h);
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12475v;
        boolean z = list != null && list.size() > 0;
        this.f12478y = z;
        if (z) {
            m46656aH();
        }
        Log.d("BeiZis", mo46059g() + ":requestAd:" + this.f11801h + "====" + this.f11802i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f11806m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            BaseManager baseManager = this.f11797d;
            if (baseManager != null && baseManager.m48667t() < 1 && this.f11797d.m48668s() != 2) {
                mo46050l();
            }
        }
        this.f12479z = C3138av.m48286l(this.f12467n);
        this.f12466A = C3138av.m48285m(this.f12467n);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46657aG();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        SplashAd splashAd;
        if (m47936an() && (splashAd = this.f12474u) != null) {
            return splashAd.getECPMLevel();
        }
        return null;
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
        SplashAd splashAd = new SplashAd((Activity) this.f12467n, this.f11802i, new RequestParameters.Builder().addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_SHAKE_LOGO_SIZE, "80").addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true").addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "false").addExtra("timeout", String.valueOf(this.f12469p)).build(), new SplashInteractionListener() { // from class: com.beizi.fusion.work.splash.a.2

            /* renamed from: a */
            boolean f12481a = false;

            /* renamed from: b */
            boolean f12482b = false;

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                Log.d("BeiZis", "showBdSplash onADLoaded()");
                try {
                    if (BaiduSplashWorker.this.f12474u != null && !TextUtils.isEmpty(BaiduSplashWorker.this.f12474u.getECPMLevel())) {
                        Log.d("BeiZis", "showBdSplash getECPMLevel:" + BaiduSplashWorker.this.f12474u.getECPMLevel());
                        BaiduSplashWorker baiduSplashWorker = BaiduSplashWorker.this;
                        baiduSplashWorker.m47967a(Double.parseDouble(baiduSplashWorker.f12474u.getECPMLevel()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ((AdWorker) BaiduSplashWorker.this).f11803j = AdStatus.ADLOAD;
                BaiduSplashWorker.this.m47910y();
                if (BaiduSplashWorker.this.m47970Y()) {
                    BaiduSplashWorker.this.m46655b();
                } else {
                    BaiduSplashWorker.this.m47980O();
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
                Log.d("BeiZis", "showBdSplash onAdCacheFailed()");
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
                Log.d("BeiZis", "showBdSplash onAdCacheSuccess()");
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
                Log.d("BeiZis", "showBdSplash onAdClick()");
                if (((AdWorker) BaiduSplashWorker.this).f11797d != null && ((AdWorker) BaiduSplashWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) BaiduSplashWorker.this).f11797d.m48700d(BaiduSplashWorker.this.mo46059g());
                    ((AdWorker) BaiduSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) BaiduSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
                }
                if (this.f12482b) {
                    return;
                }
                this.f12482b = true;
                BaiduSplashWorker.this.m47990E();
                BaiduSplashWorker.this.m47941ai();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                Log.d("BeiZis", "showBdSplash onAdDismissed()");
                if (((AdWorker) BaiduSplashWorker.this).f11797d != null && ((AdWorker) BaiduSplashWorker.this).f11797d.m48668s() != 2) {
                    BaiduSplashWorker.this.m47947ac();
                }
                BaiduSplashWorker.this.m47988G();
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBdSplash onAdFailed:" + str);
                BaiduSplashWorker.this.m47961a(str, 3793);
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
                Log.d("BeiZis", "showBdSplash onAdPresent()");
                ((AdWorker) BaiduSplashWorker.this).f11803j = AdStatus.ADSHOW;
                if (this.f12481a) {
                    return;
                }
                this.f12481a = true;
                BaiduSplashWorker.this.mo46072az();
                BaiduSplashWorker.this.mo47585ab();
                BaiduSplashWorker.this.m47992C();
                BaiduSplashWorker.this.m47991D();
                BaiduSplashWorker.this.m47942ah();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                Log.d("BeiZis", "showBdSplash onLpClosed()");
            }
        });
        this.f12474u = splashAd;
        splashAd.load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46655b() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: a */
    public void mo46196a(Message message) {
        EventBean eventBean = this.f11795b;
        if (eventBean != null) {
            eventBean.m48905i(String.valueOf(message.obj));
            m47929au();
            m47993B();
        }
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: d */
    public void mo46064d(int i) {
        SplashAd splashAd = this.f12474u;
        if (splashAd == null || TextUtils.isEmpty(splashAd.getECPMLevel()) || this.f12470q) {
            return;
        }
        this.f12470q = true;
        C3116af.m48496a("BeiZis", "showBdSplash channel == Baidu竞价失败:" + i);
        this.f12474u.biddingFail(i != 1 ? i != 2 ? "900" : "100" : "203");
    }
}
