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
/* compiled from: BannerAdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d extends e {

    /* renamed from: r  reason: collision with root package name */
    private float f14607r;

    /* renamed from: s  reason: collision with root package name */
    private float f14608s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f14609t;

    public d(Context context, String str, com.beizi.fusion.a aVar, long j4) {
        super(context, str, aVar, j4);
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        AppEventId.getInstance(e.f14610a).setAppBannerRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("4");
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
        com.beizi.fusion.work.a cVar;
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
        }
        switch (c4) {
            case 0:
                cVar = new com.beizi.fusion.work.a.c(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14608s, this.f14607r, this.f14609t);
                break;
            case 1:
                cVar = new com.beizi.fusion.work.a.d(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14608s, this.f14607r, this.f14609t);
                break;
            case 2:
                cVar = new com.beizi.fusion.work.a.a(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14608s, this.f14607r, this.f14609t);
                break;
            default:
                cVar = aVar;
                break;
        }
        return (av.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.a.b(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this, this.f14608s, this.f14607r, this.f14609t) : cVar;
    }

    public void a(float f4, float f5, ViewGroup viewGroup) {
        this.f14608s = f4;
        this.f14607r = f5;
        this.f14609t = viewGroup;
        a((ViewGroup) null);
    }
}
