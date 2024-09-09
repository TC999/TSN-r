package com.acse.ottn.util;

import android.content.Intent;
import android.text.TextUtils;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.ExcessService;
import com.acse.ottn.service.WebViewService;
import xyz.adscope.amps.common.AMPSConstants;

/* renamed from: com.acse.ottn.util.x  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1452x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1453y f6895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1452x(C1453y c1453y) {
        this.f6895a = c1453y;
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
        AccessiblityModel accessiblityModel = this.f6895a.f6897a;
        if (accessiblityModel == null || accessiblityModel.getData() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f6895a.f6897a.getData().getDiscount())) {
            C1419ba.a().a("click_state", true);
        }
        str = A.f6686e;
        ra.a(str, "couponCountDown couponModel.getRed_package() =" + this.f6895a.f6897a.getRed_package());
        if (this.f6895a.f6897a.getRed_package() == 1) {
            if (TextUtils.isEmpty(this.f6895a.f6897a.getData().getPresent_price())) {
                str9 = A.f6686e;
                str10 = "packageName is null";
            } else if ("0".equals(oa.a().a(this.f6895a.f6897a.getData().getPresent_price()).getVersion())) {
                str12 = A.f6686e;
                ra.a(str12, "current phone have not app");
                return;
            } else {
                str9 = A.f6686e;
                str10 = "current phone have app";
            }
            ra.a(str9, str10);
            if (!"1".equals(this.f6895a.f6897a.getData().getAuto_open_coupon())) {
                if (!"5".equals(this.f6895a.f6897a.getData().getAuto_open_coupon())) {
                    if ("3".equals(this.f6895a.f6897a.getData().getAuto_open_coupon())) {
                        Ha.b().a();
                        intent = new Intent(this.f6895a.f6898b, ExcessService.class);
                        intent.putExtra("password", this.f6895a.f6897a.getData().getTkl_turn_url());
                        intent.putExtra("deeplink", this.f6895a.f6897a.getData().getSpop_deeplink());
                        intent.putExtra("link", this.f6895a.f6897a.getData().getSpop_link());
                        intent.putExtra("name", this.f6895a.f6897a.getData().getPackage_name());
                        intent.putExtra("time", this.f6895a.f6897a.getData().getCoupon_load_time());
                        intent.putExtra("origin_url", this.f6895a.f6897a.getData().getOrigin_url());
                        intent.addFlags(268435456);
                    } else if ("4".equals(this.f6895a.f6897a.getData().getAuto_open_coupon())) {
                        intent = new Intent(this.f6895a.f6898b, WebViewService.class);
                        intent.putExtra("url", this.f6895a.f6897a.getData().getOrigin_url());
                        intent.putExtra("shortLink", this.f6895a.f6897a.getData().getTkl_turn_url());
                    } else if (!AMPSConstants.ChannelName.CHANNEL_NAME_ASNP.equals(this.f6895a.f6897a.getData().getAuto_open_coupon())) {
                        return;
                    } else {
                        str11 = A.f6686e;
                        ra.a(str11, "couponCountDown showFloatWindow 8888");
                        this.f6895a.f6897a.getData().setPackage_name(H.a().Fa);
                    }
                    this.f6895a.f6898b.startService(intent);
                    return;
                }
                H a4 = H.a();
                C1453y c1453y = this.f6895a;
                a4.a(c1453y.f6898b, c1453y.f6897a.getData().getTkl_turn_url());
            }
            Ha b4 = Ha.b();
            C1453y c1453y2 = this.f6895a;
            b4.b(c1453y2.f6898b, c1453y2.f6897a);
            return;
        }
        str2 = A.f6686e;
        ra.a(str2, "couponCountDown packageName =" + this.f6895a.f6899c.f6691j);
        str3 = A.f6686e;
        ra.a(str3, "couponCountDown couponModel.getGenuine_packagename() =" + this.f6895a.f6897a.getGenuine_packagename());
        if (this.f6895a.f6897a.getGenuine_packagename() == null || !"com.jingdong.app.mallm".equals(this.f6895a.f6897a.getGenuine_packagename())) {
            C1453y c1453y3 = this.f6895a;
            if (c1453y3.f6899c.f6691j != null && c1453y3.f6897a.getGenuine_packagename() != null) {
                C1453y c1453y4 = this.f6895a;
                if (c1453y4.f6899c.f6691j.equals(c1453y4.f6897a.getGenuine_packagename())) {
                    if (C1419ba.a() == null) {
                        return;
                    }
                    String d4 = C1419ba.a().d("currentActivity");
                    str6 = A.f6686e;
                    ra.a(str6, "couponCountDown currentViewClassName =" + d4);
                    if ("com.taobao.taobaom".equals(this.f6895a.f6899c.f6691j)) {
                        if (!d4.equals(H.a().f6730d) && !d4.equals(H.a().f6731e) && !d4.equals(H.a().f6732f) && !d4.equals(H.a().f6733g)) {
                            str4 = A.f6686e;
                            str5 = "couponCountDown mt_ele 1 ";
                            ra.a(str4, str5);
                            D.c().a(this.f6895a.f6897a);
                            return;
                        }
                        str7 = A.f6686e;
                        str8 = "couponCountDown showFloatWindow taobao";
                    }
                }
            }
            str4 = A.f6686e;
            str5 = "couponCountDown mt_ele 2";
            ra.a(str4, str5);
            D.c().a(this.f6895a.f6897a);
            return;
        }
        str7 = A.f6686e;
        str8 = "couponCountDown showFloatWindow";
        ra.a(str7, str8);
        C1453y c1453y5 = this.f6895a;
        c1453y5.f6899c.b(c1453y5.f6898b, c1453y5.f6897a);
    }
}
