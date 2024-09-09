package com.beizi.fusion.d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FullScreenVideoManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class j extends e {

    /* renamed from: r  reason: collision with root package name */
    private int f14663r;

    public j(Context context, String str, com.beizi.fusion.a aVar, long j4) {
        super(context, str, aVar, j4);
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
        AppEventId.getInstance(e.f14610a).setAppFullScreenVideoRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("6");
        }
    }

    public void b(int i4) {
        this.f14663r = i4;
    }

    public void c() {
        a((ViewGroup) null);
    }

    public boolean b() {
        return this.f14623l;
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
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
                return new com.beizi.fusion.work.c.b(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 1:
                return new com.beizi.fusion.work.c.c(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 2:
                return new com.beizi.fusion.work.c.a(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 3:
                return new com.beizi.fusion.work.c.d(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
            default:
                return aVar;
        }
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f14620i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
