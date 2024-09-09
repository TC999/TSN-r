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
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaiduSplashWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a extends com.beizi.fusion.work.a {
    private float A;

    /* renamed from: n  reason: collision with root package name */
    private Context f15929n;

    /* renamed from: o  reason: collision with root package name */
    private String f15930o;

    /* renamed from: p  reason: collision with root package name */
    private long f15931p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f15932q;

    /* renamed from: r  reason: collision with root package name */
    private View f15933r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f15934s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f15935t;

    /* renamed from: u  reason: collision with root package name */
    private SplashAd f15936u;

    /* renamed from: v  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15937v;

    /* renamed from: w  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15938w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private List<AdSpacesBean.RenderViewBean> f15939x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private boolean f15940y;

    /* renamed from: z  reason: collision with root package name */
    private float f15941z;

    public a(Context context, String str, long j4, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.d.e eVar) {
        this.f15929n = context;
        this.f15930o = str;
        this.f15931p = j4;
        this.f15933r = view;
        this.f15934s = viewGroup;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        this.f15935t = new SplashContainer(context);
        this.f15937v = list;
        r();
    }

    private void aG() {
        ViewGroup viewGroup;
        SplashAd splashAd = this.f15936u;
        if (splashAd != null && (viewGroup = this.f15934s) != null) {
            splashAd.show(viewGroup);
        } else {
            aw();
        }
    }

    private void aH() {
        for (int i4 = 0; i4 < this.f15937v.size(); i4++) {
            AdSpacesBean.RenderViewBean renderViewBean = this.f15937v.get(i4);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.f15939x.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.f15938w.add(renderViewBean);
            }
        }
        if (this.f15938w.size() > 0) {
            Collections.sort(this.f15938w, new Comparator<AdSpacesBean.RenderViewBean>() { // from class: com.beizi.fusion.work.splash.a.3
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
        if (!z() || this.f15936u == null) {
            return;
        }
        al();
    }

    @Override // com.beizi.fusion.work.a
    public void az() {
        SplashAd splashAd;
        if (!an() || (splashAd = this.f15936u) == null || TextUtils.isEmpty(splashAd.getECPMLevel()) || this.f15932q) {
            return;
        }
        this.f15932q = true;
        af.a("BeiZis", "showBdSplash channel == Baidu\u7ade\u4ef7\u6210\u529f");
        af.a("BeiZis", "showBdSplash channel == sendWinNoticeECPM:" + this.f15936u.getECPMLevel());
        SplashAd splashAd2 = this.f15936u;
        splashAd2.biddingSuccess(splashAd2.getECPMLevel());
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "BAIDU";
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
                if (!av.a(AMPSConstants.CHANNEL_SDK_BAIDU_CLASSNAME)) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.splash.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(10151);
                        }
                    }, 10L);
                    Log.e("BeiZis", "BAIDU sdk not import , will do nothing");
                    return;
                }
                u();
                this.f15365b.v(String.valueOf(AdSettings.getSDKVersion()));
                au();
                com.beizi.fusion.d.f.a(this.f15929n, this.f15371h);
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        if (this.f15367d.v()) {
            sleepTime = Math.max(sleepTime, this.f15369f.getHotRequestDelay());
        }
        List<AdSpacesBean.RenderViewBean> list = this.f15937v;
        boolean z3 = list != null && list.size() > 0;
        this.f15940y = z3;
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
        this.f15941z = av.l(this.f15929n);
        this.A = av.m(this.f15929n);
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
        SplashAd splashAd;
        if (an() && (splashAd = this.f15936u) != null) {
            return splashAd.getECPMLevel();
        }
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean k() {
        return this.f15368e;
    }

    @Override // com.beizi.fusion.work.a
    protected void l() {
        w();
        ag();
        SplashAd splashAd = new SplashAd((Activity) this.f15929n, this.f15372i, new RequestParameters.Builder().addExtra("fetchAd", "false").addExtra("shake_logo_size", "80").addExtra("displayDownloadInfo", "true").addExtra("use_dialog_frame", "false").addExtra("timeout", String.valueOf(this.f15931p)).build(), new SplashInteractionListener() { // from class: com.beizi.fusion.work.splash.a.2

            /* renamed from: a  reason: collision with root package name */
            boolean f15943a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f15944b = false;

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                Log.d("BeiZis", "showBdSplash onADLoaded()");
                try {
                    if (a.this.f15936u != null && !TextUtils.isEmpty(a.this.f15936u.getECPMLevel())) {
                        Log.d("BeiZis", "showBdSplash getECPMLevel:" + a.this.f15936u.getECPMLevel());
                        a aVar = a.this;
                        aVar.a(Double.parseDouble(aVar.f15936u.getECPMLevel()));
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADLOAD;
                a.this.y();
                if (a.this.Y()) {
                    a.this.b();
                } else {
                    a.this.O();
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
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                    ((com.beizi.fusion.work.a) a.this).f15376m.sendEmptyMessageDelayed(2, (((com.beizi.fusion.work.a) a.this).f15375l + 5000) - System.currentTimeMillis());
                }
                if (this.f15944b) {
                    return;
                }
                this.f15944b = true;
                a.this.E();
                a.this.ai();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                Log.d("BeiZis", "showBdSplash onAdDismissed()");
                if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                    a.this.ac();
                }
                a.this.G();
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str) {
                Log.d("BeiZis", "showBdSplash onAdFailed:" + str);
                a.this.a(str, 3793);
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
                Log.d("BeiZis", "showBdSplash onAdPresent()");
                ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                if (this.f15943a) {
                    return;
                }
                this.f15943a = true;
                a.this.az();
                a.this.ab();
                a.this.C();
                a.this.D();
                a.this.ah();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                Log.d("BeiZis", "showBdSplash onLpClosed()");
            }
        });
        this.f15936u = splashAd;
        splashAd.load();
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

    @Override // com.beizi.fusion.work.a
    public void d(int i4) {
        SplashAd splashAd = this.f15936u;
        if (splashAd == null || TextUtils.isEmpty(splashAd.getECPMLevel()) || this.f15932q) {
            return;
        }
        this.f15932q = true;
        af.a("BeiZis", "showBdSplash channel == Baidu\u7ade\u4ef7\u5931\u8d25:" + i4);
        this.f15936u.biddingFail(i4 != 1 ? i4 != 2 ? "900" : "100" : "203");
    }
}
