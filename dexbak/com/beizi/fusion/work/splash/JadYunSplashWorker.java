package com.beizi.fusion.work.splash;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.ObserverAdStatus;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p066d.CompeteStatus;
import com.beizi.fusion.p066d.JadYunAdManagerHolder;
import com.beizi.fusion.p071f.AdStatus;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.work.AdWorker;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.fusion.work.splash.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class JadYunSplashWorker extends AdWorker {

    /* renamed from: A */
    private int f12814A;

    /* renamed from: B */
    private int f12815B;

    /* renamed from: n */
    private Context f12816n;

    /* renamed from: o */
    private String f12817o;

    /* renamed from: p */
    private long f12818p;

    /* renamed from: q */
    private View f12819q;

    /* renamed from: r */
    private ViewGroup f12820r;

    /* renamed from: s */
    private View f12821s;

    /* renamed from: t */
    private JADSplash f12822t;

    /* renamed from: u */
    private List<AdSpacesBean.RenderViewBean> f12823u;

    /* renamed from: v */
    private List<AdSpacesBean.RenderViewBean> f12824v = new ArrayList();

    /* renamed from: w */
    private List<AdSpacesBean.RenderViewBean> f12825w = new ArrayList();

    /* renamed from: x */
    private boolean f12826x;

    /* renamed from: y */
    private float f12827y;

    /* renamed from: z */
    private float f12828z;

    public JadYunSplashWorker(Context context, String str, long j, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i, int i2, BaseManager baseManager) {
        this.f12816n = context;
        this.f12817o = str;
        this.f12818p = j;
        this.f12819q = view;
        this.f12820r = viewGroup;
        this.f11798e = buyerBean;
        this.f11797d = baseManager;
        this.f11799f = forwardBean;
        this.f12823u = list;
        this.f12814A = i;
        this.f12815B = i2;
        m47917r();
    }

    /* renamed from: aG */
    private void m46189aG() {
        ViewGroup viewGroup;
        if (this.f12822t != null && (viewGroup = this.f12820r) != null && this.f12821s != null) {
            viewGroup.removeAllViews();
            this.f12820r.addView(this.f12821s);
            return;
        }
        m47927aw();
    }

    /* renamed from: aH */
    private void m46188aH() {
        for (int i = 0; i < this.f12823u.size(); i++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f12823u.get(i);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f12825w.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f12824v.add(renderViewBean);
            }
        }
        if (this.f12824v.size() > 0) {
            Collections.sort(this.f12824v, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.j.3
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
        if (!m47909z() || this.f12822t == null) {
            return;
        }
        m47938al();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: g */
    public String mo46059g() {
        return "JADYUN";
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
                if (!C3138av.m48301a("com.jd.ad.sdk.bl.initsdk.JADYunSdk")) {
                    m47915t();
                    this.f11806m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.j.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JadYunSplashWorker.this.m47921c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "JD sdk not import , will do nothing");
                    return;
                }
                m47914u();
                JadYunAdManagerHolder.m48624a(this.f12816n, this.f11801h);
                this.f11795b.m48873y(JADYunSdk.getSDKVersion());
                m47929au();
                m47913v();
            }
        }
        long sleepTime = this.f11799f.getSleepTime();
        if (this.f11797d.m48665v()) {
            sleepTime = Math.max(sleepTime, this.f11799f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f12823u;
        boolean z = list != null && list.size() > 0;
        this.f12826x = z;
        if (z) {
            m46188aH();
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
        this.f12827y = C3138av.m48286l(this.f12816n);
        this.f12828z = C3138av.m48285m(this.f12816n);
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: f */
    public void mo46061f() {
        Log.d("BeiZis", mo46059g() + " out make show ad");
        m46189aG();
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: i */
    public AdStatus mo46056i() {
        return this.f11803j;
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: j */
    public String mo46054j() {
        JADSplash jADSplash = this.f12822t;
        if (jADSplash == null || jADSplash.getJADExtra() == null || this.f12822t.getJADExtra().getPrice() <= 0) {
            return null;
        }
        return this.f12822t.getJADExtra().getPrice() + "";
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
        if (this.f12814A == 0) {
            this.f12814A = (int) C3138av.m48288j(this.f12816n);
        }
        if (this.f12815B == 0) {
            this.f12815B = (int) C3138av.m48287k(this.f12816n);
        }
        JADSplash jADSplash = new JADSplash(this.f12816n, new JADSlot.Builder().setSlotID(this.f11802i).setSize(this.f12814A, this.f12815B).setTolerateTime(Math.round(((float) this.f12818p) / 1000.0f)).setSkipTime(5).setSplashClickAreaType(0).build());
        this.f12822t = jADSplash;
        jADSplash.loadAd(new JADSplashListener() { // from class: com.beizi.fusion.work.splash.j.2

            /* renamed from: a */
            boolean f12830a = false;

            /* renamed from: b */
            boolean f12831b = false;

            public void onClick() {
                Log.d("BeiZis", "showJadYunSplash onClick()");
                if (((AdWorker) JadYunSplashWorker.this).f11797d != null && ((AdWorker) JadYunSplashWorker.this).f11797d.m48668s() != 2) {
                    ((AdWorker) JadYunSplashWorker.this).f11797d.m48700d(JadYunSplashWorker.this.mo46059g());
                    ((AdWorker) JadYunSplashWorker.this).f11806m.sendEmptyMessageDelayed(2, (((AdWorker) JadYunSplashWorker.this).f11805l + 5000) - System.currentTimeMillis());
                }
                if (this.f12831b) {
                    return;
                }
                this.f12831b = true;
                JadYunSplashWorker.this.m47990E();
                JadYunSplashWorker.this.m47941ai();
            }

            public void onClose() {
                Log.d("BeiZis", "showJadYunSplash onClose()");
                if (((AdWorker) JadYunSplashWorker.this).f11797d != null && ((AdWorker) JadYunSplashWorker.this).f11797d.m48668s() != 2) {
                    JadYunSplashWorker.this.m47947ac();
                }
                JadYunSplashWorker.this.m47988G();
            }

            public void onExposure() {
                Log.d("BeiZis", "showJadYunSplash onExposure()");
                ((AdWorker) JadYunSplashWorker.this).f11803j = AdStatus.ADSHOW;
                if (this.f12830a) {
                    return;
                }
                this.f12830a = true;
                JadYunSplashWorker.this.mo46072az();
                JadYunSplashWorker.this.mo47585ab();
                JadYunSplashWorker.this.m47992C();
                JadYunSplashWorker.this.m47991D();
                JadYunSplashWorker.this.m47942ah();
            }

            public void onLoadFailure(int i, String str) {
                Log.d("BeiZis", "showJadYunSplash onLoadFailure code:" + i + ";message:" + str);
                JadYunSplashWorker.this.m47961a(str, i);
                JadYunSplashWorker.this.mo46173m();
            }

            public void onLoadSuccess() {
                Log.d("BeiZis", "showJadYunSplash onLoadSuccess()");
                if (JadYunSplashWorker.this.f12822t != null && JadYunSplashWorker.this.f12822t.getJADExtra() != null) {
                    Log.d("BeiZis", "showJadYunSplash getECPMLevel:" + JadYunSplashWorker.this.f12822t.getJADExtra().getPrice());
                    JadYunSplashWorker jadYunSplashWorker = JadYunSplashWorker.this;
                    jadYunSplashWorker.m47967a((double) jadYunSplashWorker.f12822t.getJADExtra().getPrice());
                }
                ((AdWorker) JadYunSplashWorker.this).f11803j = AdStatus.ADLOAD;
                JadYunSplashWorker.this.m47910y();
            }

            public void onRenderFailure(int i, String str) {
                Log.d("BeiZis", "showJadYunSplash onRenderFailure code:" + i + ";message:" + str);
                JadYunSplashWorker.this.m47961a(str, i);
                JadYunSplashWorker.this.mo46173m();
            }

            public void onRenderSuccess(View view) {
                Log.d("BeiZis", "showJadYunSplash onRenderSuccess()");
                JadYunSplashWorker.this.f12821s = view;
                if (JadYunSplashWorker.this.m47970Y()) {
                    JadYunSplashWorker.this.m46187b();
                } else {
                    JadYunSplashWorker.this.m47980O();
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.AdWorker
    /* renamed from: m */
    public void mo46173m() {
        JADSplash jADSplash = this.f12822t;
        if (jADSplash != null) {
            jADSplash.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46187b() {
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
}
