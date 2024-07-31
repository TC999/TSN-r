package com.beizi.fusion.p066d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.interstitial.BeiZiInterstitialWorker;
import com.beizi.fusion.work.interstitial.CsjFullScreenVideoInterstitialWorker;
import com.beizi.fusion.work.interstitial.GdtInterstitialWorker;
import com.beizi.fusion.work.interstitial.GdtNativeInterstitialWorker;
import com.beizi.fusion.work.interstitial.KsNativeInterstitialWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InterstitialAdManager extends BaseManager {

    /* renamed from: r */
    private int f11148r;

    /* renamed from: s */
    private int f11149s;

    public InterstitialAdManager(Context context, String str, BaseAdListener baseAdListener, long j, int i) {
        super(context, str, baseAdListener, j);
        this.f11149s = i;
    }

    /* renamed from: B */
    public int m48631B() {
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
    public void m48630C() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("3");
        }
    }

    /* renamed from: b */
    public void m48627b(int i) {
        this.f11148r = i;
    }

    /* renamed from: c */
    public void m48626c() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: b */
    public boolean m48628b() {
        return this.f11106l;
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        String adType = buyerBean.getAdType();
        long sleepTime = forwardBean.getSleepTime();
        AdWorker beiZiInterstitialWorker = (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new BeiZiInterstitialWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this) : adWorker;
        if ("NATIVE".equalsIgnoreCase(adType)) {
            str.hashCode();
            if (str.equals("GDT")) {
                return new GdtNativeInterstitialWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
            }
            return !str.equals("KUAISHOU") ? beiZiInterstitialWorker : new KsNativeInterstitialWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
        }
        str.hashCode();
        if (str.equals("CSJ")) {
            return new CsjFullScreenVideoInterstitialWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
        }
        return !str.equals("GDT") ? beiZiInterstitialWorker : new GdtInterstitialWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
    }

    /* renamed from: a */
    public void m48629a(Activity activity) {
        AdWorker adWorker;
        if (activity == null || (adWorker = this.f11103i) == null) {
            return;
        }
        adWorker.mo47063a(activity);
    }
}
