package com.beizi.fusion.d;

import android.app.Activity;
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
/* compiled from: UnifiedCustomAdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class v extends e {

    /* renamed from: r  reason: collision with root package name */
    private int f14683r;

    public v(Context context, String str, com.beizi.fusion.a aVar, long j4, int i4) {
        super(context, str, aVar, j4);
        this.f14683r = i4;
    }

    public void B() {
        n();
    }

    public void C() {
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

    public void b() {
        a((ViewGroup) null);
    }

    public boolean c() {
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
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                aVar = new com.beizi.fusion.work.h.c(this.f14613b, sleepTime, buyerBean, forwardBean, this, this.f14683r);
                break;
            case 1:
                aVar = new com.beizi.fusion.work.h.d(this.f14613b, sleepTime, buyerBean, forwardBean, this, this.f14683r);
                break;
            case 2:
                aVar = new com.beizi.fusion.work.h.e(this.f14613b, sleepTime, buyerBean, forwardBean, this, this.f14683r);
                break;
        }
        return (av.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.h.b(this.f14613b, sleepTime, buyerBean, forwardBean, this, this.f14683r) : aVar;
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f14620i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
