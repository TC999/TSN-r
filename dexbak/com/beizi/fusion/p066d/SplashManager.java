package com.beizi.fusion.p066d;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.StringUtil;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.splash.BaiduSplashWorker;
import com.beizi.fusion.work.splash.BeiZiSplashWorker;
import com.beizi.fusion.work.splash.CsjNSTWorker;
import com.beizi.fusion.work.splash.CsjSplashWorker;
import com.beizi.fusion.work.splash.GdtSplashWorker;
import com.beizi.fusion.work.splash.GmSplashWorker;
import com.beizi.fusion.work.splash.HwSplashWorker;
import com.beizi.fusion.work.splash.InmobiSplashWorker;
import com.beizi.fusion.work.splash.JadYunSplashWorker;
import com.beizi.fusion.work.splash.KsSplashWorker;
import com.beizi.fusion.work.splash.MtgSplashWorker;
import java.util.List;

/* renamed from: com.beizi.fusion.d.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SplashManager extends BaseManager {

    /* renamed from: r */
    private int f11160r;

    /* renamed from: s */
    private int f11161s;

    public SplashManager(Context context, String str, View view, BaseAdListener baseAdListener, long j) {
        super(context, str, baseAdListener, j);
        this.f11101g = view;
    }

    /* renamed from: B */
    public void m48601B() {
        AdWorker adWorker;
        if (this.f11109o || (adWorker = this.f11103i) == null || this.f11108n) {
            return;
        }
        adWorker.m47955aF();
        this.f11103i.mo46061f();
        this.f11108n = true;
    }

    /* renamed from: C */
    public int m48600C() {
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

    /* renamed from: D */
    public void m48599D() {
        C3145h.m48264b().m48263c().execute(new Runnable() { // from class: com.beizi.fusion.d.t.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.m48869a(BaseManager.f11070a).m48862b(new EventBean(AdManager.f11053b, "", "200.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
        });
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        AppEventId.getInstance(BaseManager.f11070a).setAppSplashRequest(this.f11107m);
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d("2");
        }
    }

    /* renamed from: b */
    public int m48598b() {
        return this.f11160r;
    }

    /* renamed from: c */
    public int m48596c() {
        return this.f11161s;
    }

    /* renamed from: b */
    public void m48597b(int i) {
        this.f11160r = i;
    }

    /* renamed from: c */
    public void m48595c(int i) {
        this.f11161s = i;
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        AdWorker jadYunSplashWorker;
        AdWorker beiZiSplashWorker = (StringUtil.m48307b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new BeiZiSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, this) : adWorker;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2130632690:
                if (str.equals("INMOBI")) {
                    c = 0;
                    break;
                }
                break;
            case -2114267227:
                if (str.equals("JADYUN")) {
                    c = 1;
                    break;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    c = 2;
                    break;
                }
                break;
            case 67034:
                if (str.equals("CSJ")) {
                    c = 3;
                    break;
                }
                break;
            case 70423:
                if (str.equals("GDT")) {
                    c = 4;
                    break;
                }
                break;
            case 76672:
                if (str.equals("MTG")) {
                    c = 5;
                    break;
                }
                break;
            case 62961147:
                if (str.equals("BAIDU")) {
                    c = 6;
                    break;
                }
                break;
            case 1780672330:
                if (str.equals("CSJ_NST")) {
                    c = 7;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c = '\b';
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new InmobiSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, this);
            case 1:
                jadYunSplashWorker = new JadYunSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, m48598b(), m48596c(), this);
                break;
            case 2:
                jadYunSplashWorker = new GmSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, m48598b(), m48596c(), this);
                break;
            case 3:
                jadYunSplashWorker = new CsjSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, m48598b(), m48596c(), this);
                break;
            case 4:
                return new GdtSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, this);
            case 5:
                return new MtgSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11098d, buyerBean, forwardBean, this);
            case 6:
                return new BaiduSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, this);
            case 7:
                return new CsjNSTWorker(this.f11096b, this.f11099e, this.f11100f, this.f11101g, this.f11098d, buyerBean, forwardBean, list, this);
            case '\b':
                return new KsSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11098d, buyerBean, forwardBean, list, this);
            case '\t':
                return new HwSplashWorker(this.f11096b, this.f11099e, this.f11100f, this.f11098d, buyerBean, forwardBean, this);
            default:
                return beiZiSplashWorker;
        }
        return jadYunSplashWorker;
    }
}
