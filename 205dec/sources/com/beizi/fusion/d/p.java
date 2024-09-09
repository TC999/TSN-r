package com.beizi.fusion.d;

import android.content.Context;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeFloatManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class p extends e {
    public p(Context context, String str, com.beizi.fusion.a aVar, long j4) {
        super(context, str, aVar, j4);
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        AppEventId.getInstance(e.f14610a).setAppSplashRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("9");
        }
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        str.hashCode();
        return !str.equals("FinalLink") ? aVar : new com.beizi.fusion.work.d.a(this.f14613b, this.f14616e, this.f14617f, buyerBean, forwardBean, this);
    }
}
