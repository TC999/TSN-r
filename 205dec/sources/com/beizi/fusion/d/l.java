package com.beizi.fusion.d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.g.av;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InterstitialAdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l extends e {

    /* renamed from: r  reason: collision with root package name */
    private int f14665r;

    /* renamed from: s  reason: collision with root package name */
    private int f14666s;

    public l(Context context, String str, com.beizi.fusion.a aVar, long j4, int i4) {
        super(context, str, aVar, j4);
        this.f14666s = i4;
    }

    public int B() {
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

    public void C() {
        n();
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("3");
        }
    }

    public void b(int i4) {
        this.f14665r = i4;
    }

    public void c() {
        a((ViewGroup) null);
    }

    public boolean b() {
        return this.f14623l;
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        String adType = buyerBean.getAdType();
        long sleepTime = forwardBean.getSleepTime();
        com.beizi.fusion.work.a aVar2 = (av.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.interstitial.a(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this) : aVar;
        if ("NATIVE".equalsIgnoreCase(adType)) {
            str.hashCode();
            if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT)) {
                return new com.beizi.fusion.work.interstitial.d(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
            }
            return !str.equals("KUAISHOU") ? aVar2 : new com.beizi.fusion.work.interstitial.e(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
        }
        str.hashCode();
        if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
            return new com.beizi.fusion.work.interstitial.b(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
        }
        return !str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT) ? aVar2 : new com.beizi.fusion.work.interstitial.c(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f14620i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
