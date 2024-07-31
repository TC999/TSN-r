package com.beizi.fusion.p066d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p077b.CsjDrawAdWorker;
import com.beizi.fusion.work.p077b.KsDrawAdWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawAdManager extends BaseManager {
    public DrawAdManager(Context context, String str, BaseAdListener baseAdListener, long j) {
        super(context, str, baseAdListener, j);
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("7");
        }
    }

    /* renamed from: b */
    public void m48646b() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: c */
    public void m48645c() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        long sleepTime = forwardBean.getSleepTime();
        str.hashCode();
        if (str.equals("CSJ")) {
            return new CsjDrawAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
        }
        return !str.equals("KUAISHOU") ? adWorker : new KsDrawAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
    }
}
