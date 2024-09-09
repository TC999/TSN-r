package com.acse.ottn;

import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.service.C1391a;
import com.acse.ottn.util.HelpShopAppUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e2 {

    /* renamed from: c  reason: collision with root package name */
    public static View f5632c = null;

    /* renamed from: d  reason: collision with root package name */
    public static WindowManager f5633d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f5634e = "MainService";

    /* renamed from: f  reason: collision with root package name */
    public static e2 f5635f;

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f5636a;

    /* renamed from: b  reason: collision with root package name */
    public AccessiblityModel f5637b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends TypeToken<ShowWindowModel> {
        public a() {
        }
    }

    public static e2 a() {
        if (f5635f == null) {
            synchronized (e2.class) {
                if (f5635f == null) {
                    f5635f = new e2();
                }
            }
        }
        return f5635f;
    }

    public final Object b() throws ObjectStreamException {
        return f5635f;
    }

    public void b(Service service, AccessiblityModel accessiblityModel, C1391a.m0 m0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        String str = f5634e;
        z1.a(str, "\u5f00\u59cb\u663e\u793a\u5f39\u6846=" + accessiblityModel.toString());
        if (accessiblityModel.getData().getPackage_name().equals(n.a().D0)) {
            a(service, R.layout.video_aiqiyi_background);
            C1391a.b().d(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.a().f6036y0)) {
            a(service, R.layout.youku_background);
            C1391a.b().e(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.a().f6034x0)) {
            a(service, R.layout.tencent_background);
            C1391a.b().c(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        } else if (accessiblityModel.getData().getPackage_name().equals(n.a().f6014n0)) {
            a(service, R.layout.baidu_wnagpan_background);
            C1391a.b().a(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        } else if (!accessiblityModel.getData().getPackage_name().equals(n.a().E0) && !accessiblityModel.getData().getPackage_name().equals(n.a().G0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6028u0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6026t0)) {
            if (accessiblityModel.getData().getPackage_name().equals(n.a().f6018p0)) {
                a(service, R.layout.hxz_shop_big_background);
                C1391a.b().q(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = -1;
            } else if (accessiblityModel.getData().getPackage_name().equals(n.a().B0)) {
                z1.a(f5634e, "xbk\u5927\u56fe");
                a(accessiblityModel.getData().getPackage_name());
                a(service, R.layout.xbk_background);
                C1391a.b().n(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = -1;
            } else {
                z1.a(f5634e, "show setGoodData");
                a(service, accessiblityModel, m0Var);
            }
        } else {
            a(service, R.layout.video_taobao_main_background);
            C1391a.b().b(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        }
        String str2 = f5634e;
        z1.a(str2, "show view   CommonUtil.isShowConpunInfor= " + j0.f5763e);
        if (j0.f5763e) {
            try {
                z1.a(f5634e, "show view");
                f5633d.addView(f5632c, this.f5636a);
                if (accessiblityModel.getData().getPlay_audio() == 1) {
                    HelpShopAppUtil.playVideo(service);
                }
            } catch (Exception e4) {
                String str3 = f5634e;
                z1.a(str3, "\u6dfb\u52a0\u5931\u8d25 e=" + e4.getMessage());
            }
        }
    }

    public final void a(Service service, AccessiblityModel accessiblityModel, C1391a.m0 m0Var) {
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        j0.f5762d = a3.b(service).d();
        if (!TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) && "1".equals(accessiblityModel.getData().getCoupon_type())) {
            if (!accessiblityModel.getData().getPackage_name().equals(n.a().f6020q0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6022r0)) {
                if (accessiblityModel.getData().getPackage_name().equals(n.a().f6024s0)) {
                    if ("1".equals(accessiblityModel.getData().getPic_type())) {
                        z1.a(f5634e, "jd\u793c\u91d1\u5927\u56fe");
                        a(service, R.layout.jd_lijin_big_background);
                        C1391a.b().s(service, f5632c, accessiblityModel, m0Var);
                        this.f5636a.height = -1;
                        return;
                    }
                    z1.a(f5634e, "jd\u5927\u56fe");
                    a(accessiblityModel.getData().getPackage_name());
                    a(service, R.layout.jd_shop_big_background);
                    C1391a.b().r(service, f5632c, accessiblityModel, m0Var);
                    this.f5636a.height = -1;
                } else if (!accessiblityModel.getData().getPackage_name().equals(n.a().f6030v0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6038z0) && !accessiblityModel.getData().getPackage_name().equals(n.a().I)) {
                    if (!accessiblityModel.getData().getPackage_name().equals(n.a().A0) && !accessiblityModel.getData().getPackage_name().equals(n.a().C0)) {
                        if (accessiblityModel.getData().getPackage_name().equals(n.a().f6032w0)) {
                            z1.a(f5634e, "didi\u5927\u56fe");
                            a(accessiblityModel.getData().getPackage_name());
                            a(service, R.layout.didi_big_background);
                            this.f5636a.height = -1;
                            C1391a.b().f(service, f5632c, accessiblityModel, m0Var);
                            return;
                        }
                        return;
                    }
                    z1.a(f5634e, "eleme\u5927\u56fe");
                    a(accessiblityModel.getData().getPackage_name());
                    a(service, R.layout.eleme_shop_big_background);
                    C1391a.b().o(service, f5632c, accessiblityModel, m0Var);
                    this.f5636a.height = -1;
                } else {
                    z1.a(f5634e, "mt\u5927\u56fe");
                    a(accessiblityModel.getData().getPackage_name());
                    a(service, R.layout.meituan_big_background);
                    C1391a.b().i(service, f5632c, accessiblityModel, m0Var);
                    this.f5636a.height = -1;
                }
            } else if ("1".equals(accessiblityModel.getData().getPic_type())) {
                z1.a(f5634e, "taobao\u793c\u91d1\u5927\u56fe");
                a(service, R.layout.tb_lijin_big_background);
                C1391a.b().l(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = -1;
            } else {
                a(accessiblityModel.getData().getPackage_name());
                z1.a(f5634e, "\u6dd8\u5b9d\u5927\u56fe");
                a(service, R.layout.taobao_old_big_background);
                C1391a.b().j(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = -1;
            }
        } else if (!accessiblityModel.getData().getPackage_name().equals(n.a().f6020q0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6022r0)) {
            if (accessiblityModel.getData().getPackage_name().equals(n.a().f6024s0)) {
                z1.a(f5634e, "jd\u5c0f\u56fe");
                a(service, R.layout.jd_shop_smile_background);
                C1391a.b().t(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = s0.a((Context) service, 320.0f);
            } else if (!accessiblityModel.getData().getPackage_name().equals(n.a().f6030v0) && !accessiblityModel.getData().getPackage_name().equals(n.a().f6038z0) && !accessiblityModel.getData().getPackage_name().equals(n.a().I)) {
                if (!accessiblityModel.getData().getPackage_name().equals(n.a().A0) && !accessiblityModel.getData().getPackage_name().equals(n.a().C0)) {
                    if (accessiblityModel.getData().getPackage_name().equals(n.a().f6032w0)) {
                        z1.a(f5634e, "didi\u5c0f\u56fe");
                        a(service, R.layout.didi_smile_background);
                        C1391a.b().g(service, f5632c, accessiblityModel, m0Var);
                        this.f5636a.height = s0.a((Context) service, 320.0f);
                        return;
                    }
                    return;
                }
                z1.a(f5634e, "eleme\u5c0f\u56fe");
                a(service, R.layout.eleme_smile_background);
                C1391a.b().p(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = s0.a((Context) service, 320.0f);
            } else {
                z1.a(f5634e, "mt\u5c0f\u56fe");
                a(service, R.layout.meituan_smile_background);
                C1391a.b().h(service, f5632c, accessiblityModel, m0Var);
                this.f5636a.height = s0.a((Context) service, 320.0f);
            }
        } else if ("1".equals(accessiblityModel.getData().getPic_type())) {
            z1.a(f5634e, "taobao\u793c\u91d1\u56fe");
            a(service, R.layout.tb_lj_smile_background);
            C1391a.b().k(service, f5632c, accessiblityModel, m0Var);
            this.f5636a.height = -1;
        } else {
            z1.a(f5634e, "tb\u5c0f\u56fe");
            this.f5636a.height = s0.a((Context) service, 320.0f);
            a(service, R.layout.shop_smile_background);
            C1391a.b().m(service, f5632c, accessiblityModel, m0Var);
        }
    }

    public void b(Service service) {
        try {
            View view = f5632c;
            if (view != null) {
                view.setVisibility(8);
            }
            f5633d.removeView(f5632c);
            service.stopSelf();
        } catch (Exception e4) {
            String str = f5634e;
            z1.a(str, "dismiss e=" + e4.getMessage());
        }
    }

    public final void a(Service service, int i4) {
        z1.a(f5634e, "setLayoutView ");
        try {
            View inflate = LayoutInflater.from(service.getApplication()).inflate(i4, (ViewGroup) null);
            f5632c = inflate;
            inflate.measure(0, 0);
        } catch (Exception e4) {
            String str = f5634e;
            z1.a(str, "setLayoutView e = " + e4.getMessage());
        }
    }

    public final void a(String str) {
        ShowWindowModel showWindowModel;
        z1.b("ShopHelperService", "isShowBigPicture ");
        String d4 = g1.a() != null ? g1.a().d(str) : "";
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(d4) && d4 != null) {
            showWindowModel = (ShowWindowModel) gson.fromJson(d4, new a().getType());
        } else {
            showWindowModel = new ShowWindowModel();
        }
        showWindowModel.setAppName(str);
        String a4 = p0.d().a();
        if (showWindowModel.getShowBigWindowData().equals(a4)) {
            return;
        }
        showWindowModel.setShowBigWindowData(a4);
        String json = gson.toJson(showWindowModel);
        if (g1.a() != null) {
            g1.a().b(str, json);
        }
    }

    public void a(Service service) {
        this.f5636a = new WindowManager.LayoutParams();
        f5633d = (WindowManager) service.getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5636a.type = 2038;
        } else {
            this.f5636a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f5636a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.windowAnimations = 16973827;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
    }

    public void a(Service service, String str, C1391a.m0 m0Var) {
        z1.c(f5634e, "noShowCoupon ");
        try {
            f5633d.removeView(f5632c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(service, R.layout.coupon_no_showbackground);
            C1391a.b().a(f5632c, str, true, m0Var);
            WindowManager.LayoutParams layoutParams = this.f5636a;
            layoutParams.height = -2;
            f5633d.addView(f5632c, layoutParams);
        } catch (Exception e4) {
            String str2 = f5634e;
            z1.c(str2, "noShowCoupon e=" + e4.getMessage());
        }
    }
}
