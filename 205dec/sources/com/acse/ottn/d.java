package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.i2;
import com.acse.ottn.l0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.service.CircleFlowService;
import com.acse.ottn.service.ExcessService;
import com.acse.ottn.service.LjFirstService;
import com.acse.ottn.service.MainService;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.service.WebViewService;
import com.acse.ottn.util.HelpShopAppUtil;
import com.google.gson.Gson;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.TreeMap;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: u  reason: collision with root package name */
    public static d f5364u = null;

    /* renamed from: v  reason: collision with root package name */
    public static TimerTask f5365v = null;

    /* renamed from: w  reason: collision with root package name */
    public static TimerTask f5366w = null;

    /* renamed from: x  reason: collision with root package name */
    public static d2 f5367x = null;

    /* renamed from: y  reason: collision with root package name */
    public static String f5368y = "acse_ShopHelperService";

    /* renamed from: f  reason: collision with root package name */
    public String f5374f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f5375g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f5376h;

    /* renamed from: k  reason: collision with root package name */
    public TimerTask f5379k;

    /* renamed from: l  reason: collision with root package name */
    public AccessibilityService f5380l;

    /* renamed from: n  reason: collision with root package name */
    public Intent f5382n;

    /* renamed from: r  reason: collision with root package name */
    public String f5386r;

    /* renamed from: s  reason: collision with root package name */
    public String f5387s;

    /* renamed from: a  reason: collision with root package name */
    public int f5369a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f5370b = 10069;

    /* renamed from: c  reason: collision with root package name */
    public int f5371c = 10070;

    /* renamed from: d  reason: collision with root package name */
    public int f5372d = 10067;

    /* renamed from: e  reason: collision with root package name */
    public int f5373e = 10065;

    /* renamed from: i  reason: collision with root package name */
    public int f5377i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f5378j = 0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5381m = true;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5383o = false;

    /* renamed from: p  reason: collision with root package name */
    public String f5384p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f5385q = "";

    /* renamed from: t  reason: collision with root package name */
    public Handler f5388t = new i(Looper.getMainLooper());

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PageSettingTypeModel f5489a;

        public c(PageSettingTypeModel pageSettingTypeModel) {
            this.f5489a = pageSettingTypeModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.f5765g = false;
            d dVar = d.this;
            List<String> list = dVar.f5375g;
            String package_name = this.f5489a.getPackage_name();
            d dVar2 = d.this;
            dVar.a(list, package_name, dVar2.f5374f, dVar2.f5386r);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5499b;

        public e(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
            this.f5498a = accessibilityService;
            this.f5499b = accessiblityModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j0.f5764f) {
                if (d.this.f5382n != null) {
                    z1.a(d.f5368y, "showFloatWindow stop floatIntent");
                    this.f5498a.stopService(d.this.f5382n);
                    d.this.f5382n = null;
                }
                d.this.f5382n = new Intent(this.f5498a, CircleFlowService.class);
                d.this.f5382n.putExtra("model", this.f5499b);
                this.f5498a.startService(d.this.f5382n);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Consumer<AccessiblityModel> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5504a;

        public f(String str) {
            this.f5504a = str;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            String str = d.f5368y;
            z1.a(str, "\u8bf7\u6c42\u6210\u529f string =" + accessiblityModel.toString());
            String str2 = d.f5368y;
            Log.d(str2, "\u7ed3\u679c  getTitle=" + accessiblityModel.toString());
            d.this.a(accessiblityModel, this.f5504a);
            List<String> list = d.this.f5375g;
            if (list != null) {
                list.removeAll(list);
                d.this.f5375g = new ArrayList();
                d.this.f5377i = 0;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements Consumer<Throwable> {
        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String str = d.f5368y;
            z1.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
            List<String> list = d.this.f5375g;
            if (list != null) {
                list.removeAll(list);
                d.this.f5375g = new ArrayList();
                d.this.f5377i = 0;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f5513a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5514b;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AccessiblityModel accessiblityModel = h.this.f5513a;
                if (accessiblityModel == null || accessiblityModel.getData() == null) {
                    return;
                }
                if (TextUtils.isEmpty(h.this.f5513a.getData().getDiscount())) {
                    g1.a().a("click_state", true);
                }
                String str = d.f5368y;
                z1.a(str, "couponCountDown couponModel.getRed_package() =" + h.this.f5513a.getRed_package());
                if (h.this.f5513a.getRed_package() != 1) {
                    String str2 = d.f5368y;
                    z1.a(str2, "couponCountDown couponModel.getGenuine_packagename() =" + h.this.f5513a.getGenuine_packagename());
                    if (h.this.f5513a.getGenuine_packagename() != null && "com.jingdong.app.mallm".equals(h.this.f5513a.getGenuine_packagename())) {
                        z1.a(d.f5368y, "couponCountDown showFloatWindow");
                        h hVar = h.this;
                        d.this.b(hVar.f5514b, hVar.f5513a);
                        return;
                    }
                    h hVar2 = h.this;
                    if (d.this.f5374f != null && hVar2.f5513a.getGenuine_packagename() != null) {
                        h hVar3 = h.this;
                        if (d.this.f5374f.equals(hVar3.f5513a.getGenuine_packagename())) {
                            if (g1.a() != null) {
                                String d4 = g1.a().d("currentActivity");
                                String str3 = d.f5368y;
                                z1.a(str3, "couponCountDown currentViewClassName =" + d4);
                                if ("com.taobao.taobaom".equals(d.this.f5374f)) {
                                    if (d4.equals(n.a().f5989b) || d4.equals(n.a().f5991c) || d4.equals(n.a().f5993d) || d4.equals(n.a().f5995e) || d4.equals(n.a().f5997f)) {
                                        z1.a(d.f5368y, "couponCountDown showFloatWindow taobao");
                                        h hVar4 = h.this;
                                        d.this.b(hVar4.f5514b, hVar4.f5513a);
                                        return;
                                    }
                                    z1.a(d.f5368y, "couponCountDown mt_ele 1 ");
                                    com.acse.ottn.e.c().a(h.this.f5513a);
                                    return;
                                }
                                h hVar5 = h.this;
                                d.this.b(hVar5.f5514b, hVar5.f5513a);
                                return;
                            }
                            return;
                        }
                    }
                    z1.a(d.f5368y, "couponCountDown mt_ele 2");
                    com.acse.ottn.e.c().a(h.this.f5513a);
                    return;
                }
                if (TextUtils.isEmpty(h.this.f5513a.getData().getPresent_price())) {
                    z1.a(d.f5368y, "packageName is null");
                } else if ("0".equals(p1.a().a(h.this.f5513a.getData().getPresent_price()).getVersion())) {
                    z1.a(d.f5368y, "current phone have not app");
                    return;
                } else {
                    z1.a(d.f5368y, "current phone have app");
                }
                if ("1".equals(h.this.f5513a.getData().getAuto_open_coupon())) {
                    a4 b4 = a4.b();
                    h hVar6 = h.this;
                    b4.b(hVar6.f5514b, hVar6.f5513a);
                } else if ("5".equals(h.this.f5513a.getData().getAuto_open_coupon())) {
                    n a4 = n.a();
                    h hVar7 = h.this;
                    a4.a(hVar7.f5514b, hVar7.f5513a.getData().getTkl_turn_url());
                    a4 b5 = a4.b();
                    h hVar8 = h.this;
                    b5.b(hVar8.f5514b, hVar8.f5513a);
                } else if ("3".equals(h.this.f5513a.getData().getAuto_open_coupon())) {
                    a4.b().a();
                    Intent intent = new Intent(h.this.f5514b, ExcessService.class);
                    intent.putExtra("password", h.this.f5513a.getData().getTkl_turn_url());
                    intent.putExtra("deeplink", h.this.f5513a.getData().getSpop_deeplink());
                    intent.putExtra("link", h.this.f5513a.getData().getSpop_link());
                    intent.putExtra("name", h.this.f5513a.getData().getPackage_name());
                    intent.putExtra("time", h.this.f5513a.getData().getCoupon_load_time());
                    intent.putExtra("origin_url", h.this.f5513a.getData().getOrigin_url());
                    intent.addFlags(268435456);
                    h.this.f5514b.startService(intent);
                } else if ("4".equals(h.this.f5513a.getData().getAuto_open_coupon())) {
                    Intent intent2 = new Intent(h.this.f5514b, WebViewService.class);
                    intent2.putExtra("url", h.this.f5513a.getData().getOrigin_url());
                    intent2.putExtra("shortLink", h.this.f5513a.getData().getTkl_turn_url());
                    h.this.f5514b.startService(intent2);
                } else if (AMPSConstants.ChannelName.CHANNEL_NAME_ASNP.equals(h.this.f5513a.getData().getAuto_open_coupon())) {
                    z1.a(d.f5368y, "couponCountDown showFloatWindow 8888");
                    h.this.f5513a.getData().setPackage_name(n.a().E0);
                    h hVar9 = h.this;
                    d.this.b(hVar9.f5514b, hVar9.f5513a);
                }
            }
        }

        public h(AccessiblityModel accessiblityModel, AccessibilityService accessibilityService) {
            this.f5513a = accessiblityModel;
            this.f5514b = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            } catch (Throwable th) {
                String str = d.f5368y;
                Log.d(str, "couponCountDown e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            d.this.f5381m = true;
            try {
                if (message.what != d.this.f5372d) {
                    if (message.what == d.this.f5373e) {
                        z1.a(d.f5368y, "\u5f53\u524d\u72b6\u6001 =adRequestCode");
                        j0.f5763e = true;
                        String string = message.getData().getString("coupon_packagename");
                        String string2 = message.getData().getString("genuine_packagename");
                        PageSettingTypeModel c4 = q0.a().c(string);
                        if (c4 == null) {
                            return;
                        }
                        if (c4.getRead_type().equals("0")) {
                            d.this.a((List<String>) null, c4.getPackage_name(), string2, "");
                        } else if (c4.getRead_type().equals("1") && d.this.a(string) && d.this.b(string2)) {
                            d.b().e(ShopHelperService.mService);
                            j0.f5765g = true;
                            d.this.a(c4, string2);
                        }
                    } else if (message.what == d.this.f5371c) {
                        d.this.c();
                    } else if (message.what == d.this.f5370b) {
                        z1.c("samon-->", "\u5f00\u59cb\u83b7\u53d6\u9875\u9762\u4fe1\u606f");
                        String string3 = message.getData().getString("coupon_packagename");
                        String string4 = message.getData().getString("genuine_packagename");
                        j0.f5765g = true;
                        d.this.b(string3, string4);
                    }
                } else {
                    String string5 = message.getData().getString("coupon_packagename");
                    String string6 = message.getData().getString("genuine_packagename");
                    j0.f5763e = true;
                    d.this.a((List<String>) null, string5, string6, "");
                }
            } catch (Throwable th) {
                String str = d.f5368y;
                z1.a(str, "mHandler =" + th.getMessage());
            }
        }
    }

    public void g(AccessibilityService accessibilityService) {
        q2.c().a(accessibilityService);
        this.f5380l = accessibilityService;
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: com.acse.ottn.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0087a implements Runnable {

            /* renamed from: com.acse.ottn.d$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class C0088a implements i2.c {
                public C0088a() {
                }

                @Override // com.acse.ottn.i2.c
                public void a() {
                    com.acse.ottn.e.c().b();
                }
            }

            public RunnableC0087a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (p0.d().c(p0.d().a()) + (HelpShopAppUtil.getInstance().createRandomNumber().longValue() * 1000) > System.currentTimeMillis()) {
                    TimerTask timerTask = d.f5366w;
                    if (timerTask != null) {
                        timerTask.cancel();
                        d.f5366w = null;
                        return;
                    }
                    return;
                }
                c4.r();
                c4.q();
                i2.a().b("heart_beat", null, new C0088a());
                if (!g1.a().a("accessiblity_lists")) {
                    com.acse.ottn.b.d().c();
                    g1.a().a("accessiblity_lists", true);
                }
                z1.b(d.f5368y, "\u5fc3\u8df3 \u5012\u8ba1\u65f6\u8bbe\u7f6e\u4f4dfalse");
                a3.b(HelpShopAppUtil.getContext()).a(false);
                i0.a(HelpShopAppUtil.getContext());
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0087a(), 0L);
            } catch (Throwable th) {
                Log.d(d.f5368y, th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(d.f5368y, "\u7ed3\u675f\u4e86");
            TimerTask timerTask = d.f5366w;
            if (timerTask != null) {
                timerTask.cancel();
                d.f5366w = null;
            }
        }
    }

    public final void c() {
        TimerTask timerTask = f5365v;
        if (timerTask != null) {
            timerTask.cancel();
            f5365v = null;
        }
        List<String> list = this.f5376h;
        if (list != null) {
            list.removeAll(list);
            this.f5376h.clear();
        }
        this.f5378j = 0;
        this.f5387s = "";
        f5365v = l0.a().b(360, 120, new C0089d());
    }

    public final Object d() throws ObjectStreamException {
        return f5364u;
    }

    public final void e() {
        if (f5366w != null) {
            return;
        }
        if (p0.d().a().equals(g1.a() != null ? g1.a().d("appHeartbeat") : "")) {
            return;
        }
        f5366w = l0.a().b(20000, 10000, new a());
    }

    public void f(AccessibilityService accessibilityService) {
        z1.a(f5368y, "onStopService");
        Intent intent = this.f5382n;
        if (intent != null) {
            accessibilityService.stopService(intent);
            this.f5382n = null;
        }
    }

    public static d b() {
        if (f5364u == null) {
            synchronized (d.class) {
                if (f5364u == null) {
                    f5364u = new d();
                }
            }
        }
        return f5364u;
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        z1.a(f5368y, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public void e(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        z1.a(f5368y, "initReadPageInfo");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 90;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public final boolean b(String str, int i4) {
        if (i4 == 0) {
            i4 = 500;
        }
        g1 a4 = g1.a();
        Long c4 = a4.c("coupon_" + str);
        String str2 = f5368y;
        z1.b(str2, "controlCouponShow appPageName =" + (System.currentTimeMillis() - c4.longValue()));
        if (System.currentTimeMillis() - c4.longValue() < i4) {
            z1.a(f5368y, "controlCouponShow return false ");
            return false;
        }
        g1 a5 = g1.a();
        a5.a("coupon_" + str, System.currentTimeMillis());
        z1.a(f5368y, "controlCouponShow return true");
        return true;
    }

    public final void c(String str, String str2, int i4, int i5) {
        try {
            Message message = new Message();
            message.what = i4;
            Bundle bundle = new Bundle();
            bundle.putString("coupon_packagename", str);
            bundle.putString("genuine_packagename", str2);
            message.setData(bundle);
            this.f5388t.sendMessageDelayed(message, i5);
        } catch (Throwable th) {
            String str3 = f5368y;
            Log.d(str3, "sendMessage =" + th.getMessage());
        }
    }

    /* renamed from: com.acse.ottn.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0089d implements l0.d {
        public C0089d() {
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                d dVar = d.this;
                if (dVar.f5376h != null) {
                    String str = d.f5368y;
                    z1.a(str, "millisUntilFinished=" + j4 + "    getTbTitle=" + d.this.f5376h.toString());
                } else {
                    dVar.f5376h = new ArrayList();
                }
                d.this.f5378j = 0;
                String b4 = q0.a().b(d.this.f5376h);
                if (!TextUtils.isEmpty(b4)) {
                    TimerTask timerTask = d.f5365v;
                    if (timerTask != null) {
                        timerTask.cancel();
                        d.f5365v = null;
                    }
                    String str2 = d.f5368y;
                    Log.d(str2, "\u62ff\u5230\u6807\u9898 getTitle=" + b4);
                    d.this.f5387s = b4;
                    return;
                }
                d dVar2 = d.this;
                dVar2.b(dVar2.f5380l);
            } catch (Throwable th) {
                String str3 = d.f5368y;
                z1.a(str3, "getTitle=" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            d.this.f5378j = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6 A[Catch: all -> 0x09bf, TryCatch #0 {all -> 0x09bf, blocks: (B:9:0x001b, B:11:0x0031, B:28:0x00dc, B:31:0x0113, B:33:0x0136, B:35:0x013c, B:37:0x0142, B:38:0x0147, B:40:0x0159, B:41:0x015e, B:192:0x03a9, B:357:0x0925, B:385:0x09bb, B:360:0x092d, B:363:0x0939, B:365:0x0947, B:367:0x0958, B:369:0x0964, B:371:0x0970, B:372:0x0978, B:193:0x03af, B:195:0x03b9, B:196:0x03c5, B:198:0x03cf, B:199:0x03db, B:200:0x03ed, B:202:0x03f5, B:204:0x03fd, B:205:0x0416, B:207:0x041e, B:209:0x0426, B:210:0x043f, B:212:0x0447, B:214:0x044f, B:215:0x0467, B:217:0x046f, B:219:0x0477, B:220:0x048f, B:222:0x0497, B:224:0x049f, B:225:0x04b1, B:227:0x04b9, B:229:0x04c1, B:230:0x04d9, B:232:0x04e1, B:234:0x04e9, B:235:0x0501, B:237:0x0509, B:239:0x0511, B:241:0x051d, B:244:0x0549, B:245:0x054e, B:247:0x0556, B:249:0x055e, B:250:0x0576, B:252:0x0582, B:254:0x058a, B:256:0x0592, B:257:0x05a8, B:259:0x05b0, B:261:0x05b8, B:262:0x05d1, B:264:0x05d9, B:266:0x05e1, B:267:0x05f7, B:269:0x05ff, B:271:0x0607, B:272:0x061f, B:274:0x0627, B:276:0x062f, B:277:0x0647, B:279:0x064f, B:281:0x0657, B:282:0x0670, B:284:0x0678, B:286:0x0680, B:287:0x0699, B:289:0x06a1, B:291:0x06a9, B:294:0x06bf, B:295:0x06c4, B:297:0x06cc, B:299:0x06d4, B:300:0x06ed, B:302:0x06f5, B:304:0x06fd, B:305:0x0715, B:307:0x071d, B:309:0x0725, B:310:0x073d, B:312:0x0745, B:314:0x074d, B:315:0x0765, B:317:0x076d, B:319:0x0775, B:320:0x078e, B:322:0x0796, B:324:0x079e, B:325:0x07b6, B:327:0x07be, B:329:0x07c6, B:330:0x07de, B:332:0x07e6, B:334:0x07ee, B:335:0x07ff, B:337:0x0807, B:339:0x080f, B:341:0x0819, B:342:0x0822, B:345:0x084d, B:346:0x0852, B:348:0x085c, B:349:0x0866, B:351:0x08e7, B:353:0x08ef, B:356:0x0920, B:43:0x0163, B:46:0x016f, B:49:0x017a, B:52:0x0186, B:55:0x0192, B:58:0x019e, B:61:0x01aa, B:64:0x01b6, B:67:0x01c2, B:70:0x01ce, B:73:0x01d9, B:76:0x01e5, B:79:0x01f1, B:82:0x01fd, B:85:0x0209, B:88:0x0215, B:91:0x0221, B:94:0x022d, B:97:0x0239, B:100:0x0245, B:103:0x0250, B:106:0x025c, B:109:0x0268, B:112:0x0274, B:115:0x0280, B:118:0x028c, B:121:0x0298, B:124:0x02a3, B:127:0x02af, B:130:0x02bb, B:133:0x02c7, B:136:0x02d3, B:139:0x02df, B:142:0x02eb, B:145:0x02f7, B:148:0x0303, B:151:0x030f, B:154:0x031a, B:157:0x0325, B:160:0x0331, B:163:0x033c, B:166:0x0347, B:169:0x0352, B:172:0x035d, B:175:0x0367, B:178:0x0372, B:181:0x037d, B:184:0x0388, B:187:0x0393, B:373:0x097e, B:376:0x0989, B:379:0x0994, B:381:0x09a0, B:383:0x09ae, B:384:0x09b6, B:13:0x003d, B:16:0x0043, B:18:0x0060, B:22:0x00a6, B:25:0x00c6, B:27:0x00d5, B:19:0x007d, B:21:0x0089), top: B:390:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.accessibilityservice.AccessibilityService r11, android.view.accessibility.AccessibilityEvent r12) {
        /*
            Method dump skipped, instructions count: 2810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityEvent):void");
    }

    public final boolean b(String str) {
        String a4 = p0.d().a();
        g1 a5 = g1.a();
        if (a4.equals(a5.d("samon_" + str))) {
            String str2 = f5368y;
            z1.a(str2, "the day not requst packageName =" + str);
            return false;
        }
        return true;
    }

    public void b(String str, String str2, int i4, int i5) {
        z1.a(f5368y, "onSelectActivity");
        j0.f5763e = true;
        this.f5374f = str2;
        c(str, str2, i4, i5);
    }

    public void c(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        z1.a(f5368y, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = accessibilityServiceInfo.flags | 16 | 8 | 64;
        accessibilityServiceInfo.notificationTimeout = 300L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    @SuppressLint({"NewApi"})
    public final void b(AccessibilityService accessibilityService) {
        List<String> list = this.f5376h;
        if (list != null) {
            list.removeAll(list);
            this.f5376h = null;
        }
        try {
            this.f5376h = new ArrayList();
            this.f5378j = 0;
            a(accessibilityService.getRootInActiveWindow());
        } catch (Throwable th) {
            List<String> list2 = this.f5376h;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f5376h.clear();
                this.f5378j = 0;
                Log.d(f5368y, th.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PageSettingTypeModel f5409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5410b;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j0.f5765g || "1".equals(g1.a().a("read_timeout", "0"))) {
                    j0.f5765g = false;
                    if (b.this.f5409a.getPackage_name().equals(n.a().f6020q0)) {
                        d.this.f5386r = "0";
                    }
                    b bVar = b.this;
                    d dVar = d.this;
                    List<String> list = dVar.f5375g;
                    String package_name = bVar.f5409a.getPackage_name();
                    b bVar2 = b.this;
                    dVar.a(list, package_name, bVar2.f5410b, d.this.f5386r);
                }
            }
        }

        public b(PageSettingTypeModel pageSettingTypeModel, String str) {
            this.f5409a = pageSettingTypeModel;
            this.f5410b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.c("samon-->", "time2=" + System.currentTimeMillis());
            try {
                d dVar = d.this;
                if (dVar.f5375g != null) {
                    z1.a(d.f5368y, d.this.f5375g.toString());
                } else {
                    dVar.f5377i = 0;
                    dVar.f5375g = new ArrayList();
                }
                if (d.this.f5375g.size() > 0) {
                    d dVar2 = d.this;
                    dVar2.f5375g.add(dVar2.f5387s);
                }
                if (q0.a().a(d.this.f5375g, this.f5409a.getRead_length())) {
                    if (this.f5409a.getPackage_name().equals(n.a().f6020q0) && TextUtils.isEmpty(q0.a().b(d.this.f5375g))) {
                        if (!TextUtils.isEmpty(d.b().f5384p) || !"1".equals(g1.a().d("ocr_screen_state"))) {
                            d.this.a(this.f5409a);
                            return;
                        }
                        d dVar3 = d.this;
                        dVar3.a(dVar3.f5380l, this.f5409a);
                        return;
                    }
                    d.this.a(this.f5409a);
                } else if (this.f5409a.getPackage_name().equals(n.a().f6020q0) && "1".equals(g1.a().d("ocr_screen_state")) && !TextUtils.isEmpty(d.b().f5384p)) {
                    z1.c("samon-->", "time4=" + System.currentTimeMillis());
                    d.this.a(this.f5409a);
                } else {
                    z1.c("samon-->", "time5=" + System.currentTimeMillis());
                    d dVar4 = d.this;
                    dVar4.a(dVar4.f5380l, this.f5409a);
                }
            } catch (Throwable th) {
                String str = d.f5368y;
                Log.d(str, "gainContent=" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask timerTask = d.f5365v;
            if (timerTask != null) {
                timerTask.cancel();
                d.f5365v = null;
            }
            z1.a(d.f5368y, "gainContent finish");
            List<String> list = d.this.f5375g;
            if (list == null || list.size() < 6) {
                return;
            }
            d.this.f5386r = "";
            String str = d.f5368y;
            z1.a(str, "model.getPackage_name() =" + this.f5409a.getPackage_name() + "   model.getIs_click_jd_title()=" + this.f5409a.getIs_click_jd_title());
            if (this.f5409a.getPackage_name().equals(n.a().f6024s0) && this.f5409a.getIs_click_jd_title().equals("0")) {
                String d4 = g1.a().d("jd_view_id");
                String str2 = d.f5368y;
                z1.a(str2, "jd id =" + d4);
                if (!TextUtils.isEmpty(d4)) {
                    d dVar = d.this;
                    dVar.f5386r = dVar.b(dVar.f5380l, d4);
                    if (!TextUtils.isEmpty(d.this.f5386r)) {
                        d dVar2 = d.this;
                        dVar2.f5375g.add(dVar2.f5386r);
                    }
                }
            }
            z1.a(d.f5368y, d.this.f5375g.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }
    }

    public final void b(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        z1.a(f5368y, "showFloatWindow");
        if (accessiblityModel == null) {
            return;
        }
        String str = f5368y;
        z1.a(str, "showFloatWindow packageName is model = " + accessiblityModel.getData().getAuto_open_coupon());
        if (this.f5382n != null) {
            z1.a(f5368y, "showFloatWindow stop floatIntent");
            accessibilityService.stopService(this.f5382n);
            this.f5382n = null;
        }
        if ("2".equals(accessiblityModel.getData().getPic_type())) {
            w1.b().a(accessiblityModel);
            j0.f5764f = true;
            if (accessiblityModel.getData().getSecond_price() != 0) {
                Intent intent = new Intent(accessibilityService, LjFirstService.class);
                this.f5382n = intent;
                intent.putExtra("model", accessiblityModel);
                accessibilityService.startService(this.f5382n);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new e(accessibilityService, accessiblityModel), accessiblityModel.getData().getSecond_price() == 0 ? 0L : accessiblityModel.getData().getSecond_price() + 400);
        } else if ("3".equals(accessiblityModel.getData().getPic_type())) {
            Intent intent2 = new Intent(accessibilityService, CircleFlowService.class);
            this.f5382n = intent2;
            intent2.putExtra("model", accessiblityModel);
            accessibilityService.startService(this.f5382n);
        } else {
            z1.a(f5368y, "showFloatWindow start");
            Intent intent3 = new Intent(accessibilityService, MainService.class);
            this.f5382n = intent3;
            intent3.putExtra("model", accessiblityModel);
            accessibilityService.startService(this.f5382n);
        }
    }

    public final String b(AccessibilityService accessibilityService, String str) {
        String str2 = f5368y;
        z1.a(str2, "getJDtitle jd id is " + str);
        AccessibilityNodeInfo f4 = com.acse.ottn.b.d().f(accessibilityService, str);
        if (f4 != null && f4.getText() != null) {
            z1.a(f5368y, "nodeInfo.getText()!=null ");
            String trim = f4.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() > 10) {
                com.acse.ottn.b.d().g(f4);
                AccessibilityNodeInfo f5 = com.acse.ottn.b.d().f(accessibilityService, str);
                if (f5 == null && f4.getText() == null) {
                    return "";
                }
                String trim2 = f5.getText().toString().trim();
                if (trim.contains(trim2) || trim2.contains(trim)) {
                    return trim.length() > trim2.length() ? trim : trim2;
                }
                String str3 = f5368y;
                z1.a(str3, "getJDtitle jd id is error=" + str);
                g1.a().b("jd_view_id", "");
            }
        }
        return "";
    }

    public final void b(String str, String str2) {
        z1.a("samon-->", "\u83b7\u53d6\u65b0\u5947");
        AdPackageModel b4 = q0.a().b();
        String str3 = f5368y;
        z1.a(str3, "AdPackageModel.toString() =" + b4.toString());
        PageSettingTypeModel pageSettingTypeModel = new PageSettingTypeModel();
        pageSettingTypeModel.setPackage_name(str);
        pageSettingTypeModel.setIs_click_jd_title(b4.getIs_click_jd_title());
        pageSettingTypeModel.setRead_time(b4.getReadpage_time());
        pageSettingTypeModel.setRead_description(b4.getRead_description());
        if (n.a().f6020q0.equals(str)) {
            pageSettingTypeModel.setRead_length(b4.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(b4.getTb_readpage_type());
        } else if (n.a().f6024s0.equals(str)) {
            pageSettingTypeModel.setRead_type(b4.getJd_readpage_type());
            pageSettingTypeModel.setRead_length(b4.getJd_readpage_size());
        } else if (n.a().f6026t0.equals(str)) {
            pageSettingTypeModel.setRead_length(b4.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(b4.getTb_readpage_type());
        } else if (n.a().f6022r0.equals(str)) {
            pageSettingTypeModel.setRead_length(b4.getTb_readpage_size());
            pageSettingTypeModel.setRead_type(b4.getTb_readpage_type());
        }
        a(pageSettingTypeModel, str2);
    }

    public final boolean a(String str, int i4) {
        return b(str, i4);
    }

    public final boolean a(String str) {
        return b(str, 0);
    }

    public void a(String str, String str2, int i4, int i5) {
        z1.a(f5368y, "onAdCallBack");
        this.f5374f = str2;
        j0.f5763e = true;
        if (this.f5381m) {
            this.f5381m = false;
            c(str, str2, i4, i5);
        }
    }

    public void a(String str, String str2) {
        z1.a(f5368y, "onNoSelectActivity");
        if (str.toLowerCase().contains("android.widget")) {
            return;
        }
        this.f5374f = str2;
    }

    @SuppressLint({"NewApi"})
    public final void a(AccessibilityService accessibilityService, PageSettingTypeModel pageSettingTypeModel) {
        List<String> list = this.f5375g;
        if (list != null) {
            list.removeAll(list);
            this.f5375g = null;
        }
        try {
            this.f5375g = new ArrayList();
            this.f5377i = 0;
            a(accessibilityService.getRootInActiveWindow(), pageSettingTypeModel);
        } catch (Throwable th) {
            List<String> list2 = this.f5375g;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f5375g.clear();
                this.f5377i = 0;
                Log.d(f5368y, th.getMessage());
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, PageSettingTypeModel pageSettingTypeModel) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i4) != null) {
                            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                            if (n.a().f6020q0.equals(pageSettingTypeModel.getPackage_name()) && "android.widget.LinearLayout".equals(child.getClassName()) && child.isLongClickable()) {
                                z1.c("samon-->", "\u627e\u5230\u6807\u9898title= ");
                                if ("1".equals(g1.a().d("ocr_screen_state"))) {
                                    z1.c("samon-->", "\u5141\u8bb8\u622a\u56fe= ");
                                    q2.c().a(accessibilityNodeInfo);
                                }
                            }
                            a(child, pageSettingTypeModel);
                        }
                    } catch (Throwable th) {
                        Log.d(f5368y, th.getMessage());
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            z1.c("samon-->", "\u627e\u5230\u6807\u9898title= in.getClassName()=" + trim);
            this.f5377i = q0.a().a(trim, this.f5377i);
            if (q0.a().a(this.f5377i) && this.f5375g.size() < 300) {
                this.f5375g.add(trim);
                return;
            }
            List<String> list = this.f5375g;
            if (list != null) {
                list.removeAll(list);
                this.f5375g.clear();
                this.f5377i = 0;
            }
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            if ("1".equals(pageSettingTypeModel.getRead_description())) {
                this.f5377i = q0.a().a(charSequence, this.f5377i);
                if (q0.a().a(this.f5377i) && this.f5375g.size() < 300) {
                    this.f5375g.add(charSequence);
                    return;
                }
                List<String> list2 = this.f5375g;
                if (list2 != null) {
                    list2.removeAll(list2);
                    this.f5375g.clear();
                    this.f5377i = 0;
                }
            } else if (charSequence.contains("\u6708\u9500") || charSequence.contains("\u5df2\u552e") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("\uffe5") || charSequence.contains("\u00a5")) {
                this.f5377i = q0.a().a(charSequence, this.f5377i);
                if (q0.a().a(this.f5377i) && this.f5375g.size() < 300) {
                    this.f5375g.add(charSequence);
                    return;
                }
                List<String> list3 = this.f5375g;
                if (list3 != null) {
                    list3.removeAll(list3);
                    this.f5375g.clear();
                    this.f5377i = 0;
                }
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i4) != null) {
                            a(accessibilityNodeInfo.getChild(i4));
                        }
                    } catch (Throwable th) {
                        Log.d(f5368y, th.getMessage());
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            this.f5378j = q0.a().a(trim, this.f5378j);
            if (q0.a().a(this.f5378j) && this.f5376h.size() < 300) {
                if (trim.length() > 10) {
                    this.f5376h.add(trim);
                    return;
                }
                return;
            }
            List<String> list = this.f5376h;
            if (list != null) {
                list.removeAll(list);
                this.f5376h.clear();
                this.f5378j = 0;
            }
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            this.f5378j = q0.a().a(charSequence, this.f5378j);
            if (q0.a().a(this.f5378j) && this.f5376h.size() < 300) {
                if (charSequence.length() > 10) {
                    this.f5376h.add(charSequence);
                    return;
                }
                return;
            }
            List<String> list2 = this.f5376h;
            if (list2 != null) {
                list2.removeAll(list2);
                this.f5376h.clear();
                this.f5378j = 0;
            }
        }
    }

    public final void a(PageSettingTypeModel pageSettingTypeModel, String str) {
        TimerTask timerTask = f5365v;
        if (timerTask != null) {
            timerTask.cancel();
            f5365v = null;
        }
        this.f5383o = false;
        List<String> list = this.f5375g;
        if (list != null) {
            list.removeAll(list);
            this.f5375g.clear();
        }
        this.f5377i = 0;
        this.f5375g = new ArrayList();
        z1.c("samon-->", "time1=" + System.currentTimeMillis());
        f5365v = l0.a().b(pageSettingTypeModel.getRead_time(), 400, new b(pageSettingTypeModel, str));
    }

    public final void a(PageSettingTypeModel pageSettingTypeModel) {
        TimerTask timerTask = f5365v;
        if (timerTask != null) {
            timerTask.cancel();
            f5365v = null;
        }
        if (this.f5375g.size() > 0 && pageSettingTypeModel.getPackage_name().equals(n.a().f6020q0)) {
            this.f5386r = this.f5387s;
        } else {
            this.f5386r = "";
        }
        if (pageSettingTypeModel.getPackage_name().equals(n.a().f6024s0) && pageSettingTypeModel.getIs_click_jd_title().equals("0")) {
            String d4 = g1.a().d("jd_view_id");
            String str = f5368y;
            z1.a(str, "jd id =" + d4);
            if (!TextUtils.isEmpty(d4)) {
                String b4 = b(this.f5380l, d4);
                this.f5386r = b4;
                if (!TextUtils.isEmpty(b4)) {
                    this.f5375g.add(this.f5386r);
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new c(pageSettingTypeModel), 0L);
    }

    public final void a(List<String> list, String str, String str2, String str3) {
        if (!com.acse.ottn.b.d().b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (list != null) {
            if (!a(str2 + "_request", 500)) {
                return;
            }
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("app", str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("title", str3);
        treeMap.put("tb_title_pic", b().f5384p);
        treeMap.put("tb_title_pic_by", b().f5385q);
        treeMap.put("new_version", j0.f5769k);
        treeMap.put("coupon_type", q0.a().h(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put("device_brand", c4.b());
        treeMap.put("is_snt", j0.f5769k);
        treeMap.put("version", j0.f5782x);
        if (list != null) {
            String str4 = f5368y;
            z1.a(str4, "getCouponInfo string =" + gson.toJson(list));
        }
        new e1().a(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new f(str), new g());
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        z1.a(f5368y, "couponCountDown ");
        TimerTask timerTask = this.f5379k;
        if (timerTask != null) {
            timerTask.cancel();
            this.f5379k = null;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
            b().a(this.f5380l, accessiblityModel.getData().getSpop_describe());
        }
        this.f5379k = l0.a().b(accessiblityModel.getData().getShow_coupon_time(), 1000, new h(accessiblityModel, accessibilityService));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.accessibilityservice.AccessibilityService r8) {
        /*
            r7 = this;
            java.lang.String r0 = "battery_white"
            com.acse.ottn.d2 r1 = new com.acse.ottn.d2
            r1.<init>(r8)
            com.acse.ottn.d.f5367x = r1
            r1.a()
            com.acse.ottn.g1 r1 = com.acse.ottn.g1.a()     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L13
            return
        L13:
            com.acse.ottn.g1 r1 = com.acse.ottn.g1.a()     // Catch: java.lang.Throwable -> L99
            boolean r1 = r1.a(r0)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L30
            java.lang.String r8 = com.acse.ottn.d.f5368y     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "\u6ca1\u6709\u6253\u5f00"
            com.acse.ottn.z1.a(r8, r1)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.i2 r8 = com.acse.ottn.i2.a()     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "system_open_accessiblity"
            r8.a(r1)     // Catch: java.lang.Throwable -> L99
            return
        L30:
            com.acse.ottn.i2 r1 = com.acse.ottn.i2.a()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "user_open_accessiblity"
            r1.a(r2)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            r1.e(r8)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            r2 = 100
            r1.a(r2)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            r1.e(r8)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528"
            android.view.accessibility.AccessibilityNodeInfo r1 = r1.j(r8, r4)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r4 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = "\u5df2\u5b89\u88c5\u7684\u670d\u52a1"
            android.view.accessibility.AccessibilityNodeInfo r4 = r4.j(r8, r5)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r5 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = "\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1"
            android.view.accessibility.AccessibilityNodeInfo r5 = r5.j(r8, r6)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L82
            if (r4 != 0) goto L82
            if (r5 == 0) goto L79
            goto L82
        L79:
            java.lang.String r8 = com.acse.ottn.d.f5368y     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "\u90fd\u6ca1\u6709\u627e\u5230"
            com.acse.ottn.z1.a(r8, r1)     // Catch: java.lang.Throwable -> L99
            goto L9a
        L82:
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            r1.a(r2)     // Catch: java.lang.Throwable -> L99
            com.acse.ottn.b r1 = com.acse.ottn.b.d()     // Catch: java.lang.Throwable -> L99
            r1.e(r8)     // Catch: java.lang.Throwable -> L99
            java.lang.String r8 = com.acse.ottn.d.f5368y     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "\u627e\u5230"
            com.acse.ottn.z1.a(r8, r1)     // Catch: java.lang.Throwable -> L99
            goto L9a
        L99:
        L9a:
            com.acse.ottn.g1 r8 = com.acse.ottn.g1.a()
            if (r8 == 0) goto La8
            com.acse.ottn.g1 r8 = com.acse.ottn.g1.a()
            r1 = 0
            r8.a(r0, r1)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a(android.accessibilityservice.AccessibilityService):void");
    }

    public void a(AccessibilityService accessibilityService, String str) {
        if (str.length() < 10) {
            return;
        }
        String str2 = f5368y;
        z1.a(str2, "getJDTitleId = " + str);
        try {
            AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(accessibilityService, str, true);
            if (a4 != null) {
                String viewIdResourceName = Build.VERSION.SDK_INT >= 18 ? a4.getViewIdResourceName() : "";
                String str3 = f5368y;
                z1.a(str3, "getJDTitleId jd id is " + viewIdResourceName);
                if (TextUtils.isEmpty(viewIdResourceName)) {
                    return;
                }
                g1.a().b("jd_view_id", viewIdResourceName);
                return;
            }
            z1.a(f5368y, "nodeInfo = null");
        } catch (Throwable th) {
            String str4 = f5368y;
            z1.a(str4, "getViewId Throwable e =" + th.getMessage());
        }
    }

    public void a(AccessiblityModel accessiblityModel, String str) {
        q2.c().a();
        if (1 == accessiblityModel.getR()) {
            if (str.equals(n.a().I)) {
                accessiblityModel.getData().setPackage_name(n.a().I);
            }
            if (!TextUtils.isEmpty(accessiblityModel.getData().getFirst_price())) {
                g1.a().b("ocr_screen_state", accessiblityModel.getData().getFirst_price());
            }
            a(this.f5380l, accessiblityModel);
            if ("1".equals(accessiblityModel.getToast_status())) {
                g1 a4 = g1.a();
                a4.b("samon_" + accessiblityModel.getGenuine_packagename(), p0.d().a());
            } else if ("0".equals(accessiblityModel.getToast_status())) {
                g1 a5 = g1.a();
                a5.b("samon_" + str, p0.d().a());
            }
        } else if (accessiblityModel.getR() == 0) {
            if ("1".equals(accessiblityModel.getScrolled_screen())) {
                g1.a().b("scroll_state", accessiblityModel.getScrolled_screen());
                g1.a().b("goods_info", accessiblityModel.getProduct_info());
            }
            if (!TextUtils.isEmpty(accessiblityModel.getData().getFirst_price())) {
                g1.a().b("ocr_screen_state", accessiblityModel.getData().getFirst_price());
            }
            if (accessiblityModel.getData() != null && !TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
                b().a(this.f5380l, accessiblityModel.getData().getSpop_describe());
            }
        }
        if ("1".equals(accessiblityModel.getReset_heartbeat())) {
            g1.a().b("appHeartbeat", "");
        }
    }
}
