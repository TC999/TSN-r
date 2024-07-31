package com.beizi.fusion.p066d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p082g.BaiduRewardVideoWorker;
import com.beizi.fusion.work.p082g.CsjRewardVideoWorker;
import com.beizi.fusion.work.p082g.GdtRewardVideoWorker;
import com.beizi.fusion.work.p082g.HwRewardVideoWorker;
import com.beizi.fusion.work.p082g.KsRewardVideoWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RewardedVideoManager extends BaseManager {

    /* renamed from: r */
    private int f11157r;

    /* renamed from: s */
    private String f11158s;

    /* renamed from: t */
    private String f11159t;

    public RewardedVideoManager(Context context, String str, BaseAdListener baseAdListener, long j, int i) {
        super(context, str, baseAdListener, j);
        this.f11157r = i;
    }

    /* renamed from: B */
    public boolean m48610B() {
        return this.f11106l;
    }

    /* renamed from: C */
    public void m48609C() {
        m48751a((ViewGroup) null);
    }

    /* renamed from: D */
    public int m48608D() {
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

    /* renamed from: E */
    public void m48607E() {
        m48673n();
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        AppEventId.getInstance(BaseManager.f11070a).setAppRewardedVideoRequest(this.f11107m);
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("1");
        }
    }

    /* renamed from: b */
    public String m48605b() {
        return this.f11158s;
    }

    /* renamed from: c */
    public String m48604c() {
        return this.f11159t;
    }

    /* renamed from: g */
    public void m48603g(String str) {
        this.f11158s = str;
    }

    /* renamed from: h */
    public void m48602h(String str) {
        this.f11159t = str;
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        AdWorker baiduRewardVideoWorker;
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
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new CsjRewardVideoWorker(BaseManager.f11070a, this.f11099e, m48605b(), m48604c(), this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 1:
                return new GdtRewardVideoWorker(BaseManager.f11070a, this.f11099e, m48605b(), m48604c(), this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 2:
                baiduRewardVideoWorker = new BaiduRewardVideoWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
                break;
            case 3:
                return new KsRewardVideoWorker(BaseManager.f11070a, this.f11099e, m48605b(), m48604c(), this.f11100f, sleepTime, buyerBean, forwardBean, this);
            case 4:
                baiduRewardVideoWorker = new HwRewardVideoWorker(BaseManager.f11070a, this.f11099e, this.f11100f, sleepTime, buyerBean, forwardBean, this);
                break;
            default:
                return adWorker;
        }
        return baiduRewardVideoWorker;
    }

    /* renamed from: a */
    public void m48606a(Activity activity) {
        AdWorker adWorker;
        if (activity == null || (adWorker = this.f11103i) == null) {
            return;
        }
        adWorker.mo47063a(activity);
    }
}
