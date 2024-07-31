package com.beizi.fusion.p066d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p083h.BeiZiUnifiedCustomWorker;
import com.beizi.fusion.work.p083h.CsjUnifiedCustomWorker;
import com.beizi.fusion.work.p083h.GdtUnifiedCustomWorker;
import com.beizi.fusion.work.p083h.KsUnifiedCustomWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UnifiedCustomAdManager extends BaseManager {

    /* renamed from: r */
    private int f11165r;

    public UnifiedCustomAdManager(Context context, String str, BaseAdListener baseAdListener, long j, int i) {
        super(context, str, baseAdListener, j);
        this.f11165r = i;
    }

    /* renamed from: B */
    public void m48584B() {
        m48673n();
    }

    /* renamed from: C */
    public void m48583C() {
        m48672o();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        AppEventId.getInstance(BaseManager.f11070a).setAppNativeRequest(this.f11107m);
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("5");
        }
    }

    /* renamed from: b */
    public void m48579b() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: c */
    public boolean m48578c() {
        return this.f11106l;
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        long sleepTime = forwardBean.getSleepTime();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 67034:
                if (str.equals("CSJ")) {
                    c = 0;
                    break;
                }
                break;
            case 70423:
                if (str.equals("GDT")) {
                    c = 1;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                adWorker = new CsjUnifiedCustomWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11165r);
                break;
            case 1:
                adWorker = new GdtUnifiedCustomWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11165r);
                break;
            case 2:
                adWorker = new KsUnifiedCustomWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11165r);
                break;
        }
        return (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new BeiZiUnifiedCustomWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11165r) : adWorker;
    }

    /* renamed from: a */
    public void m48581a(Activity activity) {
        AdWorker adWorker;
        if (activity == null || (adWorker = this.f11103i) == null) {
            return;
        }
        adWorker.mo47063a(activity);
    }
}
