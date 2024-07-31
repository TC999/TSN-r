package com.acse.ottn.util;

import android.content.Intent;
import android.text.TextUtils;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.ExcessService;
import com.acse.ottn.service.WebViewService;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* renamed from: com.acse.ottn.util.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1707x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1709y f3385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1707x(C1709y c1709y) {
        this.f3385a = c1709y;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Intent intent;
        String str12;
        AccessiblityModel accessiblityModel = this.f3385a.f3387a;
        if (accessiblityModel == null || accessiblityModel.getData() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f3385a.f3387a.getData().getDiscount())) {
            C1661ba.m56097a().m56092a("click_state", true);
        }
        str = C1617A.f3113e;
        C1694ra.m55917a(str, "couponCountDown couponModel.getRed_package() =" + this.f3385a.f3387a.getRed_package());
        if (this.f3385a.f3387a.getRed_package() == 1) {
            if (TextUtils.isEmpty(this.f3385a.f3387a.getData().getPresent_price())) {
                str9 = C1617A.f3113e;
                str10 = "packageName is null";
            } else if ("0".equals(C1688oa.m55939a().m55935a(this.f3385a.f3387a.getData().getPresent_price()).getVersion())) {
                str12 = C1617A.f3113e;
                C1694ra.m55917a(str12, "current phone have not app");
                return;
            } else {
                str9 = C1617A.f3113e;
                str10 = "current phone have app";
            }
            C1694ra.m55917a(str9, str10);
            if (!"1".equals(this.f3385a.f3387a.getData().getAuto_open_coupon())) {
                if (!"5".equals(this.f3385a.f3387a.getData().getAuto_open_coupon())) {
                    if ("3".equals(this.f3385a.f3387a.getData().getAuto_open_coupon())) {
                        C1632Ha.m56256b().m56258a();
                        intent = new Intent(this.f3385a.f3388b, ExcessService.class);
                        intent.putExtra("password", this.f3385a.f3387a.getData().getTkl_turn_url());
                        intent.putExtra("deeplink", this.f3385a.f3387a.getData().getSpop_deeplink());
                        intent.putExtra("link", this.f3385a.f3387a.getData().getSpop_link());
                        intent.putExtra("name", this.f3385a.f3387a.getData().getPackage_name());
                        intent.putExtra(RtspHeaders.Values.TIME, this.f3385a.f3387a.getData().getCoupon_load_time());
                        intent.putExtra("origin_url", this.f3385a.f3387a.getData().getOrigin_url());
                        intent.addFlags(268435456);
                    } else if ("4".equals(this.f3385a.f3387a.getData().getAuto_open_coupon())) {
                        intent = new Intent(this.f3385a.f3388b, WebViewService.class);
                        intent.putExtra("url", this.f3385a.f3387a.getData().getOrigin_url());
                        intent.putExtra("shortLink", this.f3385a.f3387a.getData().getTkl_turn_url());
                    } else if (!"8888".equals(this.f3385a.f3387a.getData().getAuto_open_coupon())) {
                        return;
                    } else {
                        str11 = C1617A.f3113e;
                        C1694ra.m55917a(str11, "couponCountDown showFloatWindow 8888");
                        this.f3385a.f3387a.getData().setPackage_name(C1631H.m56262a().f3166Fa);
                    }
                    this.f3385a.f3388b.startService(intent);
                    return;
                }
                C1631H m56262a = C1631H.m56262a();
                C1709y c1709y = this.f3385a;
                m56262a.m56260a(c1709y.f3388b, c1709y.f3387a.getData().getTkl_turn_url());
            }
            C1632Ha m56256b = C1632Ha.m56256b();
            C1709y c1709y2 = this.f3385a;
            m56256b.m56255b(c1709y2.f3388b, c1709y2.f3387a);
            return;
        }
        str2 = C1617A.f3113e;
        C1694ra.m55917a(str2, "couponCountDown packageName =" + this.f3385a.f3389c.f3118j);
        str3 = C1617A.f3113e;
        C1694ra.m55917a(str3, "couponCountDown couponModel.getGenuine_packagename() =" + this.f3385a.f3387a.getGenuine_packagename());
        if (this.f3385a.f3387a.getGenuine_packagename() == null || !"com.jingdong.app.mallm".equals(this.f3385a.f3387a.getGenuine_packagename())) {
            C1709y c1709y3 = this.f3385a;
            if (c1709y3.f3389c.f3118j != null && c1709y3.f3387a.getGenuine_packagename() != null) {
                C1709y c1709y4 = this.f3385a;
                if (c1709y4.f3389c.f3118j.equals(c1709y4.f3387a.getGenuine_packagename())) {
                    if (C1661ba.m56097a() == null) {
                        return;
                    }
                    String m56086d = C1661ba.m56097a().m56086d("currentActivity");
                    str6 = C1617A.f3113e;
                    C1694ra.m55917a(str6, "couponCountDown currentViewClassName =" + m56086d);
                    if ("com.taobao.taobaom".equals(this.f3385a.f3389c.f3118j)) {
                        if (!m56086d.equals(C1631H.m56262a().f3198d) && !m56086d.equals(C1631H.m56262a().f3200e) && !m56086d.equals(C1631H.m56262a().f3202f) && !m56086d.equals(C1631H.m56262a().f3204g)) {
                            str4 = C1617A.f3113e;
                            str5 = "couponCountDown mt_ele 1 ";
                            C1694ra.m55917a(str4, str5);
                            C1623D.m56293c().m56295a(this.f3385a.f3387a);
                            return;
                        }
                        str7 = C1617A.f3113e;
                        str8 = "couponCountDown showFloatWindow taobao";
                    }
                }
            }
            str4 = C1617A.f3113e;
            str5 = "couponCountDown mt_ele 2";
            C1694ra.m55917a(str4, str5);
            C1623D.m56293c().m56295a(this.f3385a.f3387a);
            return;
        }
        str7 = C1617A.f3113e;
        str8 = "couponCountDown showFloatWindow";
        C1694ra.m55917a(str7, str8);
        C1709y c1709y5 = this.f3385a;
        c1709y5.f3389c.m56329b(c1709y5.f3388b, c1709y5.f3387a);
    }
}
