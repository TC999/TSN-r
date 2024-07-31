package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.acse.ottn.C1239R;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.ShowWindowModel;
import com.acse.ottn.p030a.C1249a;
import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1618Aa;
import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1650T;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1654X;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.ExecutorC1627F;
import com.acse.ottn.util.HelpShopAppUtil;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.google.gson.Gson;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.TreeMap;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MainService extends Service implements C1586Y.InterfaceC1587a {

    /* renamed from: a */
    private static View f2997a = null;

    /* renamed from: b */
    private static WindowManager f2998b = null;

    /* renamed from: c */
    private static String f2999c = "MainService";

    /* renamed from: d */
    private WindowManager.LayoutParams f3000d;

    /* renamed from: e */
    private AccessiblityModel f3001e;

    static {
        StubApp.interface11(4507);
    }

    /* renamed from: a */
    private static int m56419a(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    private void m56420a(int i) {
        C1694ra.m55917a(f2999c, "setLayoutView ");
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            f2997a = inflate;
            inflate.measure(0, 0);
        } catch (Exception e) {
            String str = f2999c;
            C1694ra.m55917a(str, "setLayoutView e = " + e.getMessage());
        }
    }

    /* renamed from: a */
    private void m56417a(AccessiblityModel accessiblityModel) {
        C1694ra.m55917a(f2999c, "setGoodData");
        if (accessiblityModel == null || accessiblityModel.getData() == null || TextUtils.isEmpty(accessiblityModel.getData().getPackage_name())) {
            return;
        }
        CommonUtil.isShwoToast = C1618Aa.m56307b(this).m56303d();
        if (TextUtils.isEmpty(accessiblityModel.getData().getCoupon_type()) || !"1".equals(accessiblityModel.getData().getCoupon_type())) {
            if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3227ra) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3229sa)) {
                C1694ra.m55917a(f2999c, "tb小图");
                this.f3000d.height = C1654X.m56117a((Context) this, 320.0f);
                m56420a(C1239R.C1244layout.shop_smile_background);
                C1586Y.m56383b().m56367l(this, f2997a, accessiblityModel, this);
                return;
            }
            if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3231ta)) {
                C1694ra.m55917a(f2999c, "jd小图");
                m56420a(C1239R.C1244layout.jd_shop_smile_background);
                C1586Y.m56383b().m56360s(this, f2997a, accessiblityModel, this);
            } else if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3237wa) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3156Aa) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3173J)) {
                C1694ra.m55917a(f2999c, "mt小图");
                m56420a(C1239R.C1244layout.meituan_smile_background);
                C1586Y.m56383b().m56371h(this, f2997a, accessiblityModel, this);
            } else if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3158Ba) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3162Da)) {
                C1694ra.m55917a(f2999c, "eleme小图");
                m56420a(C1239R.C1244layout.eleme_smile_background);
                C1586Y.m56383b().m56364o(this, f2997a, accessiblityModel, this);
            } else if (!accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3239xa)) {
                return;
            } else {
                C1694ra.m55917a(f2999c, "didi小图");
                m56420a(C1239R.C1244layout.didi_smile_background);
                C1586Y.m56383b().m56372g(this, f2997a, accessiblityModel, this);
            }
            this.f3000d.height = C1654X.m56117a((Context) this, 320.0f);
            return;
        }
        if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3227ra) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3229sa)) {
            if ("1".equals(accessiblityModel.getData().getPic_type())) {
                C1694ra.m55917a(f2999c, "taobao礼金大图");
                m56420a(C1239R.C1244layout.tb_lijin_big_background);
                C1586Y.m56383b().m56368k(this, f2997a, accessiblityModel, this);
            } else {
                m56411c(accessiblityModel.getData().getPackage_name());
                C1694ra.m55917a(f2999c, "淘宝大图");
                m56420a(C1239R.C1244layout.taobao_old_big_background);
                C1586Y.m56383b().m56369j(this, f2997a, accessiblityModel, this);
            }
        } else if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3231ta)) {
            if ("1".equals(accessiblityModel.getData().getPic_type())) {
                C1694ra.m55917a(f2999c, "jd礼金大图");
                m56420a(C1239R.C1244layout.jd_lijin_big_background);
                C1586Y.m56383b().m56361r(this, f2997a, accessiblityModel, this);
            } else {
                C1694ra.m55917a(f2999c, "jd大图");
                m56411c(accessiblityModel.getData().getPackage_name());
                m56420a(C1239R.C1244layout.jd_shop_big_background);
                C1586Y.m56383b().m56362q(this, f2997a, accessiblityModel, this);
            }
        } else if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3237wa) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3156Aa) || accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3173J)) {
            C1694ra.m55917a(f2999c, "mt大图");
            m56411c(accessiblityModel.getData().getPackage_name());
            m56420a(C1239R.C1244layout.meituan_big_background);
            C1586Y.m56383b().m56370i(this, f2997a, accessiblityModel, this);
        } else if (!accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3158Ba) && !accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3162Da)) {
            if (accessiblityModel.getData().getPackage_name().equals(C1631H.m56262a().f3239xa)) {
                C1694ra.m55917a(f2999c, "didi大图");
                m56411c(accessiblityModel.getData().getPackage_name());
                m56420a(C1239R.C1244layout.didi_big_background);
                this.f3000d.height = -1;
                C1586Y.m56383b().m56373f(this, f2997a, accessiblityModel, this);
                return;
            }
            return;
        } else {
            C1694ra.m55917a(f2999c, "eleme大图");
            m56411c(accessiblityModel.getData().getPackage_name());
            m56420a(C1239R.C1244layout.eleme_shop_big_background);
            C1586Y.m56383b().m56365n(this, f2997a, accessiblityModel, this);
        }
        this.f3000d.height = -1;
    }

    /* renamed from: c */
    private void m56411c(String str) {
        C1694ra.m55915b("ShopHelperService", "isShowBigPicture ");
        String m56086d = C1661ba.m56097a() != null ? C1661ba.m56097a().m56086d(str) : "";
        Gson gson = new Gson();
        ShowWindowModel showWindowModel = (TextUtils.isEmpty(m56086d) || m56086d == null) ? new ShowWindowModel() : (ShowWindowModel) gson.fromJson(m56086d, new C1596f(this).getType());
        showWindowModel.setAppName(str);
        String m56161a = C1650T.m56150d().m56161a();
        if (showWindowModel.getShowBigWindowData().equals(m56161a)) {
            return;
        }
        showWindowModel.setShowBigWindowData(m56161a);
        String json = gson.toJson(showWindowModel);
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56088b(str, json);
        }
    }

    /* renamed from: d */
    public static void m56410d() {
    }

    /* renamed from: d */
    private void m56409d(String str) {
        TreeMap treeMap = new TreeMap();
        new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", "coupon");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new C1249a().m57368i(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1594d(this, str), new C1595e(this));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: e */
    private void m56408e() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f3000d = new WindowManager.LayoutParams();
        f2998b = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f3000d;
            i = 2038;
        } else {
            layoutParams = this.f3000d;
            i = 2002;
        }
        layoutParams.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f3000d;
        layoutParams2.format = 1;
        layoutParams2.flags = 8;
        layoutParams2.windowAnimations = 16973827;
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m56407e(String str) {
        C1694ra.m55914c(f2999c, "noShowCoupon ");
        try {
            f2998b.removeView(f2997a);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            m56420a(C1239R.C1244layout.coupon_no_showbackground);
            C1586Y.m56383b().m56390a(f2997a, str, this);
            WindowManager.LayoutParams layoutParams = this.f3000d;
            layoutParams.height = -2;
            f2998b.addView(f2997a, layoutParams);
        } catch (Exception e) {
            String str2 = f2999c;
            C1694ra.m55914c(str2, "noShowCoupon e=" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.service.C1586Y.InterfaceC1587a
    /* renamed from: a */
    public void mo56359a() {
        m56412c();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m56418a(android.content.Context r4, com.acse.ottn.model.AccessiblityModel r5) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.service.MainService.m56418a(android.content.Context, com.acse.ottn.model.AccessiblityModel):void");
    }

    @Override // com.acse.ottn.service.C1586Y.InterfaceC1587a
    /* renamed from: a */
    public void mo56358a(String str) {
        m56409d(str);
    }

    /* renamed from: b */
    public void m56413b(String str) {
        Observable.create(new C1599i(this, str)).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1597g(this), new C1598h(this));
    }

    /* renamed from: c */
    public void m56412c() {
        try {
            View view = f2997a;
            if (view != null) {
                view.setVisibility(8);
            }
            f2998b.removeView(f2997a);
            stopSelf();
        } catch (Exception e) {
            String str = f2999c;
            C1694ra.m55917a(str, "dismiss e=" + e.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1694ra.m55914c(f2999c, "MainService Created");
        m56408e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            C1694ra.m55914c(f2999c, "onDestroy ");
            C1586Y.m56383b();
            C1586Y.m56378c();
            m56412c();
        } catch (Exception e) {
            String str = f2999c;
            C1694ra.m55914c(str, "onDestroy e=" + e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(C2624bk.f8685i);
            this.f3001e = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                if (!TextUtils.isEmpty(this.f3001e.getData().getTkl_url())) {
                    try {
                        C1694ra.m55917a("samon-->code", this.f3001e.getData().getTkl_url());
                        m56413b(this.f3001e.getData().getTkl_url());
                    } catch (Exception unused) {
                        C1694ra.m55915b(f2999c, "request code fail ");
                    }
                }
                m56418a(this, this.f3001e);
            }
        } catch (Exception e) {
            String str = f2999c;
            C1694ra.m55917a(str, "Exception =" + e.getMessage());
        }
        return super.onStartCommand(intent, i, i2);
    }
}
