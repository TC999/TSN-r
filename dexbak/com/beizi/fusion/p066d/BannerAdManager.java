package com.beizi.fusion.p066d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p076a.BaiduBannerAdWorker;
import com.beizi.fusion.work.p076a.BeiZiBannerAdWorker;
import com.beizi.fusion.work.p076a.CsjBannerAdWorker;
import com.beizi.fusion.work.p076a.GdtBannerAdWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BannerAdManager extends BaseManager {

    /* renamed from: r */
    private float f11067r;

    /* renamed from: s */
    private float f11068s;

    /* renamed from: t */
    private ViewGroup f11069t;

    public BannerAdManager(Context context, String str, BaseAdListener baseAdListener, long j) {
        super(context, str, baseAdListener, j);
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        AppEventId.getInstance(BaseManager.f11070a).setAppBannerRequest(this.f11107m);
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("4");
        }
    }

    /* renamed from: b */
    public int m48771b() {
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

    /* renamed from: c */
    public void m48770c() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        AdWorker csjBannerAdWorker;
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
        }
        switch (c) {
            case 0:
                csjBannerAdWorker = new CsjBannerAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11068s, this.f11067r, this.f11069t);
                break;
            case 1:
                csjBannerAdWorker = new GdtBannerAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11068s, this.f11067r, this.f11069t);
                break;
            case 2:
                csjBannerAdWorker = new BaiduBannerAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11068s, this.f11067r, this.f11069t);
                break;
            default:
                csjBannerAdWorker = adWorker;
                break;
        }
        return (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new BeiZiBannerAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11068s, this.f11067r, this.f11069t) : csjBannerAdWorker;
    }

    /* renamed from: a */
    public void m48772a(float f, float f2, ViewGroup viewGroup) {
        this.f11068s = f;
        this.f11067r = f2;
        this.f11069t = viewGroup;
        m48751a((ViewGroup) null);
    }
}
