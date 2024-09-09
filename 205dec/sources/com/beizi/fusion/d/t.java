package com.beizi.fusion.d;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SplashManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t extends e {

    /* renamed from: r  reason: collision with root package name */
    private int f14678r;

    /* renamed from: s  reason: collision with root package name */
    private int f14679s;

    public t(Context context, String str, View view, com.beizi.fusion.a aVar, long j4) {
        super(context, str, aVar, j4);
        this.f14618g = view;
    }

    public void B() {
        com.beizi.fusion.work.a aVar;
        if (this.f14626o || (aVar = this.f14620i) == null || this.f14625n) {
            return;
        }
        aVar.aF();
        this.f14620i.f();
        this.f14625n = true;
    }

    public int C() {
        String j4;
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar == null || (j4 = aVar.j()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(j4);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public void D() {
        com.beizi.fusion.g.h.b().c().execute(new Runnable() { // from class: com.beizi.fusion.d.t.1
            @Override // java.lang.Runnable
            public void run() {
                com.beizi.fusion.b.c.a(e.f14610a).b(new com.beizi.fusion.b.b(b.f14592b, "", "200.500", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
        });
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        AppEventId.getInstance(e.f14610a).setAppSplashRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("2");
        }
    }

    public int b() {
        return this.f14678r;
    }

    public int c() {
        return this.f14679s;
    }

    public void b(int i4) {
        this.f14678r = i4;
    }

    public void c(int i4) {
        this.f14679s = i4;
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        com.beizi.fusion.work.a jVar;
        com.beizi.fusion.work.a bVar = (av.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.splash.b(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, this) : aVar;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -2130632690:
                if (str.equals("INMOBI")) {
                    c4 = 0;
                    break;
                }
                break;
            case -2114267227:
                if (str.equals("JADYUN")) {
                    c4 = 1;
                    break;
                }
                break;
            case 2278:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GM)) {
                    c4 = 2;
                    break;
                }
                break;
            case 67034:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
                    c4 = 3;
                    break;
                }
                break;
            case 70423:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT)) {
                    c4 = 4;
                    break;
                }
                break;
            case 76672:
                if (str.equals("MTG")) {
                    c4 = 5;
                    break;
                }
                break;
            case 62961147:
                if (str.equals("BAIDU")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1780672330:
                if (str.equals("CSJ_NST")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new com.beizi.fusion.work.splash.i(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, this);
            case 1:
                jVar = new com.beizi.fusion.work.splash.j(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, b(), c(), this);
                break;
            case 2:
                jVar = new com.beizi.fusion.work.splash.g(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, b(), c(), this);
                break;
            case 3:
                jVar = new com.beizi.fusion.work.splash.e(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, b(), c(), this);
                break;
            case 4:
                return new com.beizi.fusion.work.splash.f(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, this);
            case 5:
                return new com.beizi.fusion.work.splash.l(this.f14613b, this.f14616e, this.f14617f, this.f14615d, buyerBean, forwardBean, this);
            case 6:
                return new com.beizi.fusion.work.splash.a(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, this);
            case 7:
                return new com.beizi.fusion.work.splash.d(this.f14613b, this.f14616e, this.f14617f, this.f14618g, this.f14615d, buyerBean, forwardBean, list, this);
            case '\b':
                return new com.beizi.fusion.work.splash.k(this.f14613b, this.f14616e, this.f14617f, this.f14615d, buyerBean, forwardBean, list, this);
            case '\t':
                return new com.beizi.fusion.work.splash.h(this.f14613b, this.f14616e, this.f14617f, this.f14615d, buyerBean, forwardBean, this);
            default:
                return bVar;
        }
        return jVar;
    }

    public void a(Context context) {
        try {
            com.beizi.fusion.work.a aVar = this.f14620i;
            if (aVar != null) {
                aVar.a(context);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
