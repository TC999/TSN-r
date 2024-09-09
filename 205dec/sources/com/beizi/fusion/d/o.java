package com.beizi.fusion.d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeAdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o extends e {

    /* renamed from: r  reason: collision with root package name */
    private float f14670r;

    /* renamed from: s  reason: collision with root package name */
    private float f14671s;

    /* renamed from: t  reason: collision with root package name */
    private int f14672t;

    public o(Context context, String str, com.beizi.fusion.a aVar, long j4, int i4) {
        super(context, str, aVar, j4);
        this.f14672t = i4;
    }

    public void B() {
        o();
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        AppEventId.getInstance(e.f14610a).setAppNativeRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("5");
        }
    }

    public int b() {
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

    public void c() {
        n();
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        com.beizi.fusion.work.a fVar;
        long sleepTime = forwardBean.getSleepTime();
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 67034:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
                    c4 = 0;
                    break;
                }
                break;
            case 70423:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT)) {
                    c4 = 1;
                    break;
                }
                break;
            case 62961147:
                if (str.equals("BAIDU")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                fVar = new com.beizi.fusion.work.nativead.f(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
                break;
            case 1:
                if (this.f14672t == 3) {
                    fVar = new com.beizi.fusion.work.nativead.h(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
                    break;
                } else {
                    fVar = new com.beizi.fusion.work.nativead.g(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
                    break;
                }
            case 2:
                fVar = new com.beizi.fusion.work.nativead.a(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
                break;
            case 3:
                fVar = new com.beizi.fusion.work.nativead.i(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
                break;
            default:
                fVar = aVar;
                break;
        }
        if (av.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) {
            int i4 = this.f14672t;
            if (i4 == 4) {
                return new com.beizi.fusion.work.nativead.c(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
            }
            if (i4 == 5) {
                return new com.beizi.fusion.work.nativead.d(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
            }
            return new com.beizi.fusion.work.nativead.e(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14670r, this.f14671s);
        }
        return fVar;
    }

    public void a(float f4, float f5) {
        this.f14670r = f4;
        this.f14671s = f5;
        a((ViewGroup) null);
    }
}
