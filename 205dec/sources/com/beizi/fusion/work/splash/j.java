package com.beizi.fusion.work.splash;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.d.m;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: JadYunSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class j extends com.beizi.fusion.work.a {
    private int A;
    private int B;

    /* renamed from: n  reason: collision with root package name */
    private Context f16141n;

    /* renamed from: o  reason: collision with root package name */
    private String f16142o;

    /* renamed from: p  reason: collision with root package name */
    private long f16143p;

    /* renamed from: q  reason: collision with root package name */
    private View f16144q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f16145r;

    /* renamed from: s  reason: collision with root package name */
    private View f16146s;

    /* renamed from: t  reason: collision with root package name */
    private JADSplash f16147t;

    /* renamed from: u  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16148u;

    /* renamed from: v  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16149v = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f16150w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private boolean f16151x;

    /* renamed from: y  reason: collision with root package name */
    private float f16152y;

    /* renamed from: z  reason: collision with root package name */
    private float f16153z;

    public j(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, int i4, int i5, com.beizi.fusion.d.e eVar) {
        this.f16141n = context;
        this.f16142o = str;
        this.f16143p = j4;
        this.f16144q = view;
        this.f16145r = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f16148u = list;
        this.A = i4;
        this.B = i5;
        r();
    }

    private void aG() {
        ViewGroup viewGroup;
        if (this.f16147t != null && (viewGroup = this.f16145r) != null && this.f16146s != null) {
            viewGroup.removeAllViews();
            this.f16145r.addView(this.f16146s);
            return;
        }
        aw();
    }

    private void aH() {
        for (int i4 = 0; i4 < this.f16148u.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f16148u.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f16150w.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f16149v.add(renderViewBean);
            }
        }
        if (this.f16149v.size() > 0) {
            Collections.sort(this.f16149v, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.j.3
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(AdSpacesBean.RenderViewBean renderViewBean2, AdSpacesBean.RenderViewBean renderViewBean3) {
                    return renderViewBean3.getLevel() - renderViewBean2.getLevel();
                }
            });
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void A() {
        if (!z() || this.f16147t == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "JADYUN";
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
                if (!av.a("com.jd.ad.sdk.bl.initsdk.JADYunSdk")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.j.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "JD sdk not import , will do nothing");
                    return;
                }
                u();
                m.a(this.f16141n, this.f15371h);
                this.f15365b.y(JADYunSdk.getSDKVersion());
                au();
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f16148u;
        boolean z3 = list != null && list.size() > 0;
        this.f16151x = z3;
        if (z3) {
            aH();
        }
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            com.beizi.fusion.d.e eVar = this.f15367d;
            if (eVar != null && eVar.t() < 1 && this.f15367d.s() != 2) {
                l();
            }
        }
        this.f16152y = av.l(this.f16141n);
        this.f16153z = av.m(this.f16141n);
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
    public String j() {
        JADSplash jADSplash = this.f16147t;
        if (jADSplash == null || jADSplash.getJADExtra() == null || this.f16147t.getJADExtra().getPrice() <= 0) {
            return null;
        }
        return this.f16147t.getJADExtra().getPrice() + "";
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        if (this.A == 0) {
            this.A = (int) av.j(this.f16141n);
        }
        if (this.B == 0) {
            this.B = (int) av.k(this.f16141n);
        }
        JADSplash jADSplash = new JADSplash(this.f16141n, new JADSlot.Builder().setSlotID(this.f15372i).setSize(this.A, this.B).setTolerateTime(Math.round(((float) this.f16143p) / 1000.0f)).setSkipTime(5).setSplashClickAreaType(0).build());
        this.f16147t = jADSplash;
        jADSplash.loadAd(new JADSplashListener() { // from class: com.beizi.fusion.work.splash.j.2

            /* renamed from: a  reason: collision with root package name */
            boolean f16155a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f16156b = false;

            public void onClick() {
                Log.d("BeiZis", "showJadYunSplash onClick()");
                if (((com.beizi.fusion.work.a) j.this).f15367d != null && ((com.beizi.fusion.work.a) j.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) j.this).f15367d.d(j.this.g());
                    ((com.beizi.fusion.work.a) j.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) j.this).f15375l + 5000) - System.currentTimeMillis());
                }
                if (this.f16156b) {
                    return;
                }
                this.f16156b = true;
                j.this.E();
                j.this.ai();
            }

            public void onClose() {
                Log.d("BeiZis", "showJadYunSplash onClose()");
                if (((com.beizi.fusion.work.a) j.this).f15367d != null && ((com.beizi.fusion.work.a) j.this).f15367d.s() != 2) {
                    j.this.ac();
                }
                j.this.G();
            }

            public void onExposure() {
                Log.d("BeiZis", "showJadYunSplash onExposure()");
                ((com.beizi.fusion.work.a) j.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (this.f16155a) {
                    return;
                }
                this.f16155a = true;
                j.this.az();
                j.this.ab();
                j.this.C();
                j.this.D();
                j.this.ah();
            }

            public void onLoadFailure(int i4, String str) {
                Log.d("BeiZis", "showJadYunSplash onLoadFailure code:" + i4 + ";message:" + str);
                j.this.a(str, i4);
                j.this.m();
            }

            public void onLoadSuccess() {
                Log.d("BeiZis", "showJadYunSplash onLoadSuccess()");
                if (j.this.f16147t != null && j.this.f16147t.getJADExtra() != null) {
                    Log.d("BeiZis", "showJadYunSplash getECPMLevel:" + j.this.f16147t.getJADExtra().getPrice());
                    j jVar = j.this;
                    jVar.a((double) jVar.f16147t.getJADExtra().getPrice());
                }
                ((com.beizi.fusion.work.a) j.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                j.this.y();
            }

            public void onRenderFailure(int i4, String str) {
                Log.d("BeiZis", "showJadYunSplash onRenderFailure code:" + i4 + ";message:" + str);
                j.this.a(str, i4);
                j.this.m();
            }

            public void onRenderSuccess(View view) {
                Log.d("BeiZis", "showJadYunSplash onRenderSuccess()");
                j.this.f16146s = view;
                if (j.this.Y()) {
                    j.this.b();
                } else {
                    j.this.O();
                }
            }
        });
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        JADSplash jADSplash = this.f16147t;
        if (jADSplash != null) {
            jADSplash.destroy();
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.fusion.work.a
    public void a(Message message) {
        com.beizi.fusion.b.b bVar = this.f15365b;
        if (bVar != null) {
            bVar.i(String.valueOf(message.obj));
            au();
            B();
        }
    }
}
