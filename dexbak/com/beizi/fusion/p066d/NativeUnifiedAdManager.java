package com.beizi.fusion.p066d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p081f.BeiZiNativeUnifiedWorker;
import com.beizi.fusion.work.p081f.CsjNativeUnifiedWorker;
import com.beizi.fusion.work.p081f.GdtNativeUnifiedWorker;
import com.beizi.fusion.work.p081f.KsNativeUnifiedWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeUnifiedAdManager extends BaseManager {

    /* renamed from: r */
    private int f11156r;

    public NativeUnifiedAdManager(Context context, String str, BaseAdListener baseAdListener, long j, int i) {
        super(context, str, baseAdListener, j);
        this.f11156r = i;
    }

    /* renamed from: B */
    public int m48615B() {
        String mo46054j;
        AdWorker adWorker = this.f11103i;
        if (adWorker == null || (mo46054j = adWorker.mo46054j()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(mo46054j);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: C */
    public void m48614C() {
        m48673n();
    }

    /* renamed from: D */
    public void m48613D() {
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
    public void m48612b() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: c */
    public boolean m48611c() {
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
                adWorker = new CsjNativeUnifiedWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11156r);
                break;
            case 1:
                adWorker = new GdtNativeUnifiedWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11156r);
                break;
            case 2:
                adWorker = new KsNativeUnifiedWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11156r);
                break;
        }
        return (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new BeiZiNativeUnifiedWorker(this.f11096b, sleepTime, buyerBean, forwardBean, this, this.f11156r) : adWorker;
    }
}
