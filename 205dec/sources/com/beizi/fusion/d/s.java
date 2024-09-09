package com.beizi.fusion.d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RewardedVideoManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class s extends e {

    /* renamed from: r  reason: collision with root package name */
    private int f14675r;

    /* renamed from: s  reason: collision with root package name */
    private String f14676s;

    /* renamed from: t  reason: collision with root package name */
    private String f14677t;

    public s(Context context, String str, com.beizi.fusion.a aVar, long j4, int i4) {
        super(context, str, aVar, j4);
        this.f14675r = i4;
    }

    public boolean B() {
        return this.f14623l;
    }

    public void C() {
        a((ViewGroup) null);
    }

    public int D() {
        String j4;
        com.beizi.fusion.work.a aVar = this.f14620i;
        if (aVar == null || (j4 = aVar.j()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(j4);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public void E() {
        n();
    }

    @Override // com.beizi.fusion.d.e
    protected void a() {
        AppEventId.getInstance(e.f14610a).setAppRewardedVideoRequest(this.f14624m);
        com.beizi.fusion.b.b bVar = this.f14614c;
        if (bVar != null) {
            bVar.d("1");
        }
    }

    public String b() {
        return this.f14676s;
    }

    public String c() {
        return this.f14677t;
    }

    public void g(String str) {
        this.f14676s = str;
    }

    public void h(String str) {
        this.f14677t = str;
    }

    @Override // com.beizi.fusion.d.e
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        com.beizi.fusion.work.a aVar2;
        long sleepTime = forwardBean.getSleepTime();
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 67034:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ)) {
                    c4 = 0;
                    break;
                }
                break;
            case 70423:
                if (str.equals(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT)) {
                    c4 = 1;
                    break;
                }
                break;
            case 62961147:
                if (str.equals("BAIDU")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1921014029:
                if (str.equals("KUAISHOU")) {
                    c4 = 3;
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new com.beizi.fusion.work.g.b(e.f14610a, this.f14616e, b(), c(), this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 1:
                return new com.beizi.fusion.work.g.c(e.f14610a, this.f14616e, b(), c(), this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 2:
                aVar2 = new com.beizi.fusion.work.g.a(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
                break;
            case 3:
                return new com.beizi.fusion.work.g.e(e.f14610a, this.f14616e, b(), c(), this.f14617f, sleepTime, buyerBean, forwardBean, this);
            case 4:
                aVar2 = new com.beizi.fusion.work.g.d(e.f14610a, this.f14616e, this.f14617f, sleepTime, buyerBean, forwardBean, this);
                break;
            default:
                return aVar;
        }
        return aVar2;
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f14620i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
