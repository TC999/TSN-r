package com.beizi.fusion.d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DrawAdManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class i extends e {
    public i(Context context, String str, com.beizi.fusion.a aVar, long j4) {
        super(context, str, aVar, j4);
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("7");
        }
    }

    public void b() {
        a((ViewGroup) null);
    }

    public void c() {
        n();
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        long sleepTime = forwardBean.getSleepTime();
        str.hashCode();
        if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
            return new com.beizi.fusion.work.b.a(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
        }
        return !str.equals("KUAISHOU") ? aVar : new com.beizi.fusion.work.b.b(this.f14613b, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
    }
}
