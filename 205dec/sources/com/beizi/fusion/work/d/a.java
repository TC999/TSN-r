package com.beizi.fusion.work.d;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.beizi.fusion.b.b;
import com.beizi.fusion.b.d;
import com.beizi.fusion.d.e;
import com.beizi.fusion.g.af;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;
import com.xyz.newad.hudong.ADInit;
import com.xyz.newad.hudong.widgets.FloatListener;
import com.xyz.newad.hudong.widgets.floating.FloatAD;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FinalLinkNativeFloatWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.beizi.fusion.work.a {

    /* renamed from: n  reason: collision with root package name */
    private Context f15515n;

    /* renamed from: o  reason: collision with root package name */
    private String f15516o;

    /* renamed from: p  reason: collision with root package name */
    private long f15517p;

    public a(Context context, String str, long j4, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, e eVar) {
        this.f15515n = context;
        this.f15516o = str;
        this.f15517p = j4;
        this.f15368e = buyerBean;
        this.f15367d = eVar;
        this.f15369f = forwardBean;
        r();
    }

    @Override // com.beizi.fusion.work.a
    public void f() {
    }

    @Override // com.beizi.fusion.work.a
    public String g() {
        return "FinalLink";
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f15367d == null) {
            return;
        }
        this.f15371h = this.f15368e.getAppId();
        this.f15372i = this.f15368e.getSpaceId();
        this.f15366c = this.f15368e.getBuyerSpaceUuId();
        String str = (String) au.b(this.f15515n, "__OAID__", "");
        af.b("BeiZis", "AdWorker chanel = " + this.f15366c);
        d dVar = this.f15364a;
        if (dVar != null) {
            b a4 = dVar.a().a(this.f15366c);
            this.f15365b = a4;
            if (a4 != null) {
                s();
                if (!aw.a("com.xyz.newad.hudong.ADInit")) {
                    t();
                    this.f15376m.postDelayed(new Runnable() { // from class: com.beizi.fusion.work.d.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.c(10151);
                        }
                    }, 10L);
                    Log.d("BeiZis", "FinalLink sdk not import , will do nothing");
                    return;
                }
                u();
                ADInit.getInstance().init(this.f15515n, this.f15371h);
                ADInit.getInstance().setOaid(str);
                v();
            }
        }
        long sleepTime = this.f15369f.getSleepTime();
        Log.d("BeiZis", g() + ":requestAd:" + this.f15371h + "====" + this.f15372i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.f15376m.sendEmptyMessageDelayed(1, sleepTime);
            return;
        }
        e eVar = this.f15367d;
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
        if (this.f15515n instanceof Activity) {
            FloatAD.get().finish((Activity) this.f15515n);
            Z();
            FloatAD.get().show((Activity) this.f15515n, this.f15372i, new FloatListener() { // from class: com.beizi.fusion.work.d.a.2
                public void onClick() {
                    Log.d("BeiZis", "NativeFloat Ad onClick");
                    a.this.E();
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null) {
                        if (((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                            ((com.beizi.fusion.work.a) a.this).f15367d.d(a.this.g());
                        }
                        a.this.ai();
                    }
                }

                public void onClose() {
                    Log.d("BeiZis", "NativeFloat Ad onClose");
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        a.this.ac();
                    }
                    a.this.G();
                }

                public void onDismiss() {
                    Log.d("BeiZis", "NativeFloat Ad onDismiss");
                }

                public void onFail() {
                    Log.d("BeiZis", "NativeFloat Ad onFail");
                    a.this.a("\u83b7\u53d6\u5e7f\u544a\u5931\u8d25", 10140);
                }

                public void onInvisible() {
                }

                public void onShow() {
                    Log.d("BeiZis", "NativeFloat Ad onShow");
                    a.this.ad();
                    a.this.y();
                    a.this.M();
                    ((com.beizi.fusion.work.a) a.this).f15373j = com.beizi.fusion.f.a.ADSHOW;
                    if (((com.beizi.fusion.work.a) a.this).f15367d != null && ((com.beizi.fusion.work.a) a.this).f15367d.s() != 2) {
                        ((com.beizi.fusion.work.a) a.this).f15367d.b(a.this.g());
                    }
                    a.this.C();
                    a.this.D();
                    a.this.ah();
                }

                public void onVisible() {
                }
            });
            return;
        }
        Log.e("BeiZis", "NativeFloat Ad needs an Activity Context to show!");
    }

    @Override // com.beizi.fusion.work.a
    public void m() {
        if (this.f15515n instanceof Activity) {
            FloatAD.get().finish((Activity) this.f15515n);
        }
    }
}
