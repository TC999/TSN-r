package com.beizi.fusion.p066d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p078c.BaiduFullScreenVideoWorker;
import com.beizi.fusion.work.p078c.CsjFullScreenVideoWorker;
import com.beizi.fusion.work.p078c.GdtFullScreenVideoWorker;
import com.beizi.fusion.work.p078c.KsFullScreenVideoWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FullScreenVideoManager extends BaseManager {

    /* renamed from: r */
    private int f11146r;

    public FullScreenVideoManager(Context context, String str, BaseAdListener baseAdListener, long j) {
        super(context, str, baseAdListener, j);
    }

    /* renamed from: B */
    public int m48644B() {
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
    public void m48643C() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        AppEventId.getInstance(BaseManager.f11070a).setAppFullScreenVideoRequest(this.f11107m);
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("6");
        }
    }

    /* renamed from: b */
    public void m48640b(int i) {
        this.f11146r = i;
    }

    /* renamed from: c */
    public void m48639c() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: b */
    public boolean m48641b() {
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
            case 62961147:
                if (str.equals("BAIDU")) {
                    c = 2;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new CsjFullScreenVideoWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 1:
                return new GdtFullScreenVideoWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 2:
                return new BaiduFullScreenVideoWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 3:
                return new KsFullScreenVideoWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
            default:
                return adWorker;
        }
    }

    /* renamed from: a */
    public void m48642a(Activity activity) {
        AdWorker adWorker;
        if (activity == null || (adWorker = this.f11103i) == null) {
            return;
        }
        adWorker.mo47063a(activity);
    }
}
