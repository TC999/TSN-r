package com.beizi.fusion.p066d;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.nativead.BaiduNativeAdWorker;
import com.beizi.fusion.work.nativead.BeiZiNativeLTRPWorker;
import com.beizi.fusion.work.nativead.BeiZiNativeTPBTWorker;
import com.beizi.fusion.work.nativead.BeiZiNativeWorker;
import com.beizi.fusion.work.nativead.CsjNativeAdWorker;
import com.beizi.fusion.work.nativead.GdtNativeAdWorker;
import com.beizi.fusion.work.nativead.GdtNativeCustomWorker;
import com.beizi.fusion.work.nativead.KsNativeAdWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeAdManager extends BaseManager {

    /* renamed from: r */
    private float f11153r;

    /* renamed from: s */
    private float f11154s;

    /* renamed from: t */
    private int f11155t;

    public NativeAdManager(Context context, String str, BaseAdListener baseAdListener, long j, int i) {
        super(context, str, baseAdListener, j);
        this.f11155t = i;
    }

    /* renamed from: B */
    public void m48619B() {
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
    public int m48617b() {
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
    public void m48616c() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        AdWorker csjNativeAdWorker;
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
                csjNativeAdWorker = new CsjNativeAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
                break;
            case 1:
                if (this.f11155t == 3) {
                    csjNativeAdWorker = new GdtNativeCustomWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
                    break;
                } else {
                    csjNativeAdWorker = new GdtNativeAdWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
                    break;
                }
            case 2:
                csjNativeAdWorker = new BaiduNativeAdWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
                break;
            case 3:
                csjNativeAdWorker = new KsNativeAdWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
                break;
            default:
                csjNativeAdWorker = adWorker;
                break;
        }
        if (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) {
            int i = this.f11155t;
            if (i == 4) {
                return new BeiZiNativeLTRPWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
            }
            if (i == 5) {
                return new BeiZiNativeTPBTWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
            }
            return new BeiZiNativeWorker(this.f11096b, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this, this.f11153r, this.f11154s);
        }
        return csjNativeAdWorker;
    }

    /* renamed from: a */
    public void m48618a(float f, float f2) {
        this.f11153r = f;
        this.f11154s = f2;
        m48751a((ViewGroup) null);
    }
}
