package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.AdMobClickListener;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SDKController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: j  reason: collision with root package name */
    private static b f39114j;

    /* renamed from: k  reason: collision with root package name */
    private Context f39124k;

    /* renamed from: l  reason: collision with root package name */
    private String f39125l;

    /* renamed from: m  reason: collision with root package name */
    private String f39126m;

    /* renamed from: n  reason: collision with root package name */
    private String f39127n;

    /* renamed from: o  reason: collision with root package name */
    private String f39128o;

    /* renamed from: p  reason: collision with root package name */
    private String f39129p;

    /* renamed from: r  reason: collision with root package name */
    private com.mbridge.msdk.b.a f39131r;

    /* renamed from: s  reason: collision with root package name */
    private String f39132s;

    /* renamed from: u  reason: collision with root package name */
    private FastKV f39134u;

    /* renamed from: v  reason: collision with root package name */
    private Map<String, Object> f39135v;

    /* renamed from: w  reason: collision with root package name */
    private int f39136w;

    /* renamed from: x  reason: collision with root package name */
    private AdMobClickListener f39137x;

    /* renamed from: q  reason: collision with root package name */
    private boolean f39130q = false;

    /* renamed from: a  reason: collision with root package name */
    public final int f39115a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final int f39116b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f39117c = 3;

    /* renamed from: d  reason: collision with root package name */
    public final int f39118d = 4;

    /* renamed from: e  reason: collision with root package name */
    public final int f39119e = 5;

    /* renamed from: f  reason: collision with root package name */
    public final int f39120f = 6;

    /* renamed from: g  reason: collision with root package name */
    public final int f39121g = 7;

    /* renamed from: h  reason: collision with root package name */
    public final int f39122h = 8;

    /* renamed from: t  reason: collision with root package name */
    private AtomicBoolean f39133t = null;

    /* renamed from: i  reason: collision with root package name */
    Handler f39123i = new Handler() { // from class: com.mbridge.msdk.foundation.controller.b.4
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            List list;
            List<n> list2;
            try {
                switch (message.what) {
                    case 2:
                        Object obj = message.obj;
                        if (!(obj instanceof List) || (list = (List) obj) == null || list.size() <= 0) {
                            return;
                        }
                        d dVar = new d(b.this.f39124k, 0);
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            n nVar = (n) list.get(i4);
                            Boolean bool = Boolean.FALSE;
                            if (i4 == list.size() - 1) {
                                bool = Boolean.TRUE;
                            }
                            dVar.a(nVar, bool);
                        }
                        return;
                    case 3:
                        File file = (File) message.obj;
                        if (file != null) {
                            String a4 = v.a(file);
                            if (TextUtils.isEmpty(a4)) {
                                return;
                            }
                            String[] split = a4.split("====");
                            if (split.length > 0) {
                                new d(b.this.f39124k).a(split[0], file);
                                return;
                            }
                            return;
                        }
                        return;
                    case 4:
                        String str = (String) message.obj;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                            com.mbridge.msdk.foundation.same.report.b.a().a(str);
                            return;
                        } else {
                            new d(b.this.f39124k, 0).a("click_duration", str, (String) null, (Frame) null);
                            return;
                        }
                    case 5:
                        String str2 = (String) message.obj;
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                            com.mbridge.msdk.foundation.same.report.b.a().a(str2);
                            return;
                        } else {
                            new d(b.this.f39124k, 0).a("load_duration", str2, (String) null, (Frame) null);
                            return;
                        }
                    case 6:
                        Object obj2 = message.obj;
                        if (obj2 == null || !(obj2 instanceof String)) {
                            return;
                        }
                        String str3 = (String) obj2;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                            com.mbridge.msdk.foundation.same.report.b.a().a(str3);
                            return;
                        } else {
                            new d(b.this.f39124k, 0).a("device_data", str3, (String) null, (Frame) null);
                            return;
                        }
                    case 7:
                        Object obj3 = message.obj;
                        if (obj3 == null || !(obj3 instanceof List) || (list2 = (List) obj3) == null || list2.size() <= 0 || !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_applist")) {
                            return;
                        }
                        ae.a(b.this.f39124k, "mbridge_setting_campaign_time", new Long(System.currentTimeMillis()));
                        for (n nVar2 : list2) {
                            new d(b.this.f39124k, 0).a(nVar2);
                        }
                        return;
                    case 8:
                        Object obj4 = message.obj;
                        if (obj4 == null || !(obj4 instanceof String)) {
                            return;
                        }
                        String str4 = (String) obj4;
                        if (ag.b(str4)) {
                            if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                                com.mbridge.msdk.foundation.same.report.b.a().a(str4);
                                return;
                            } else {
                                new d(b.this.f39124k, 0).a(str4);
                                return;
                            }
                        }
                        return;
                    case 9:
                        if (((com.mbridge.msdk.c.a) message.obj).K() == 1) {
                            com.mbridge.msdk.foundation.same.report.b.a.a(b.this.f39124k).a();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception unused) {
                x.d("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            com.mbridge.msdk.e.b.class.getDeclaredMethod(CampaignEx.JSON_NATIVE_VIDEO_START, new Class[0]).invoke(com.mbridge.msdk.e.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            x.b("SDKController", th.getMessage(), th);
        }
    }

    public final boolean d() {
        Context context = this.f39124k;
        if (context != null && this.f39133t == null) {
            int i4 = context.getSharedPreferences("mb_optimization_setting", 0).getInt("use_thread_pool", 0);
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            this.f39133t = atomicBoolean;
            atomicBoolean.set(i4 == 0);
        }
        AtomicBoolean atomicBoolean2 = this.f39133t;
        if (atomicBoolean2 != null) {
            return atomicBoolean2.get();
        }
        return true;
    }

    public static b a() {
        if (f39114j == null) {
            synchronized (b.class) {
                if (f39114j == null) {
                    f39114j = new b();
                }
            }
        }
        return f39114j;
    }

    public final void b() {
        Handler handler = this.f39123i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void c() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.5
            /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:10:0x002c, B:12:0x0032, B:13:0x0046, B:15:0x005c, B:16:0x0074, B:18:0x007e, B:20:0x0084, B:22:0x008a, B:23:0x0093, B:25:0x0099, B:28:0x00b7, B:30:0x01ca, B:32:0x01d1, B:33:0x01d6, B:29:0x0159, B:34:0x01f5, B:35:0x01f9, B:36:0x0208, B:38:0x021b, B:40:0x0221, B:42:0x0228, B:44:0x0230, B:5:0x000e, B:7:0x001c), top: B:48:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: Exception -> 0x025c, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:10:0x002c, B:12:0x0032, B:13:0x0046, B:15:0x005c, B:16:0x0074, B:18:0x007e, B:20:0x0084, B:22:0x008a, B:23:0x0093, B:25:0x0099, B:28:0x00b7, B:30:0x01ca, B:32:0x01d1, B:33:0x01d6, B:29:0x0159, B:34:0x01f5, B:35:0x01f9, B:36:0x0208, B:38:0x021b, B:40:0x0221, B:42:0x0228, B:44:0x0230, B:5:0x000e, B:7:0x001c), top: B:48:0x0000 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 612
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.b.AnonymousClass5.run():void");
            }
        }).start();
    }

    static /* synthetic */ void d(b bVar) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(bVar.f39127n);
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            long longValue = ((Long) ae.b(bVar.f39124k, "mbridge_setting_campaign_time", new Long(0L))).longValue();
            if (longValue <= 0 || longValue + (b4.N() * 1000) <= currentTimeMillis) {
                if (b4.M() <= 0) {
                    q.a(i.a(a.f().j())).b();
                    return;
                }
                List<n> c4 = q.a(i.a(bVar.f39124k)).c();
                if (c4 == null || c4.size() <= 0) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.obj = c4;
                obtain.what = 7;
                bVar.f39123i.sendMessage(obtain);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(Map map, final Context context) {
        String str;
        List<com.mbridge.msdk.foundation.entity.b> n4;
        Object newInstance;
        Object newInstance2;
        String str2 = "";
        if (context != null) {
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                this.f39127n = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
            }
            this.f39124k = StubApp.getOrigApplicationContext(context.getApplicationContext());
            a.f().b(this.f39124k);
            try {
                String str3 = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                if (!TextUtils.isEmpty(str3)) {
                    com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, str3);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                com.mbridge.msdk.foundation.same.net.n.a(this.f39124k);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT < 26) {
                com.mbridge.msdk.d.b.a(context).a(30000, this.f39127n);
            }
            if (this.f39130q) {
                com.mbridge.msdk.rover.b a4 = com.mbridge.msdk.rover.b.a();
                a4.a(context);
                a4.b();
                new d(context).a();
                return;
            }
            t.C(context);
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                this.f39127n = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                this.f39128o = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                this.f39129p = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
            }
            if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                this.f39132s = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
            }
            if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                this.f39126m = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
            }
            try {
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(a.f().k());
                if (b4 != null && (n4 = b4.n()) != null && n4.size() > 0) {
                    for (com.mbridge.msdk.foundation.entity.b bVar : n4) {
                        if (bVar.a() == 287) {
                            Class<?> cls = Class.forName("com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler");
                            if (this.f39124k != null && (newInstance = cls.getConstructor(String.class, String.class).newInstance("", bVar.b())) != null) {
                                cls.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance, new Object[0]);
                            }
                        } else if (bVar.a() == 94 && (newInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", bVar.b())) != null) {
                            MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance2, new Object[0]);
                        }
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
            a.f().c(this.f39127n);
            a.f().d(this.f39128o);
            a.f().e(this.f39129p);
            a.f().b(this.f39125l);
            a.f().a(this.f39132s);
            a.f().a(new a.b() { // from class: com.mbridge.msdk.foundation.controller.b.6
                @Override // com.mbridge.msdk.foundation.controller.a.b
                public final void a() {
                    b.d(b.this);
                }
            }, this.f39123i);
            Context origApplicationContext = StubApp.getOrigApplicationContext(this.f39124k.getApplicationContext());
            try {
                com.iab.omid.library.mmadbridge.a.a(origApplicationContext);
                if (!com.iab.omid.library.mmadbridge.a.c()) {
                    new d(origApplicationContext, 0).a("", "", "", "", "activate om failed");
                }
            } catch (IllegalArgumentException e5) {
                x.b("SDKController", e5.getMessage(), e5);
            }
            x.b("SDKController", "facebook = " + this.f39125l + "appId = " + this.f39127n + "appKey = " + this.f39128o);
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(this.f39124k.getApplicationContext());
            try {
                if (d() && this.f39134u == null) {
                    try {
                        this.f39134u = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), s.b("H+tU+FeXHM==")).build();
                    } catch (Exception unused2) {
                        this.f39134u = null;
                    }
                }
                FastKV fastKV = this.f39134u;
                if (fastKV != null) {
                    String string = fastKV.getString(s.b("H+tU+bfPhM=="), "");
                    String string2 = this.f39134u.getString(s.b("H+tU+Fz8"), "");
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                        com.mbridge.msdk.foundation.same.a.f39391s = com.mbridge.msdk.foundation.a.a.a.a().b("b");
                        com.mbridge.msdk.foundation.same.a.f39392t = com.mbridge.msdk.foundation.a.a.a.a().b("c");
                    }
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                            this.f39134u.putString(s.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f39391s);
                            this.f39134u.putString(s.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f39392t);
                        }
                    } else {
                        com.mbridge.msdk.foundation.same.a.f39391s = string;
                        com.mbridge.msdk.foundation.same.a.f39392t = string2;
                        com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.f39391s);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f39392t);
                    }
                } else {
                    SharedPreferences sharedPreferences = origApplicationContext2.getSharedPreferences(s.b("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        str2 = sharedPreferences.getString(s.b("H+tU+bfPhM=="), "");
                        str = sharedPreferences.getString(s.b("H+tU+Fz8"), "");
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                        com.mbridge.msdk.foundation.same.a.f39391s = com.mbridge.msdk.foundation.a.a.a.a().b("b");
                        com.mbridge.msdk.foundation.same.a.f39392t = com.mbridge.msdk.foundation.a.a.a.a().b("c");
                    }
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                        if ((!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) && sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(s.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f39391s);
                            edit.putString(s.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f39392t);
                            edit.apply();
                        }
                    } else {
                        com.mbridge.msdk.foundation.same.a.f39391s = str2;
                        com.mbridge.msdk.foundation.same.a.f39392t = str;
                        com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.f39391s);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f39392t);
                    }
                }
            } catch (Throwable th3) {
                x.b("SDKController", th3.getMessage(), th3);
            }
            try {
                if (MBridgeConstans.INIT_UA_IN) {
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Looper.prepare();
                            b.this.e();
                            b bVar2 = b.this;
                            b.a(bVar2, bVar2.f39127n);
                            Looper.loop();
                        }
                    });
                } else if (Looper.myLooper() == Looper.getMainLooper()) {
                    com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            Looper.prepare();
                            b.this.e();
                            Looper.loop();
                        }
                    });
                } else {
                    e();
                }
            } catch (Exception unused3) {
                x.d("SDKController", "get app setting failed");
            }
            c();
            aa.a(this.f39124k);
            this.f39130q = true;
            com.mbridge.msdk.rover.b a5 = com.mbridge.msdk.rover.b.a();
            a5.a(context);
            a5.b();
            long a6 = com.mbridge.msdk.c.b.a().g(this.f39127n).a();
            if (a6 != 1300) {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.B(context);
                    }
                }, a6);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bd -> B:40:0x00c0). Please submit an issue!!! */
    public final void a(Map<String, Object> map, int i4) {
        Map<String, Object> map2;
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            x.d("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f39135v = map;
        this.f39136w = i4;
        a.f().k();
        if (map != null) {
            if (this.f39131r == null) {
                this.f39131r = new com.mbridge.msdk.b.a();
            }
            try {
                map2 = this.f39135v;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (map2 != null && map2.size() > 0 && this.f39135v.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                int intValue = ((Integer) this.f39135v.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                if (intValue == 0) {
                    Map<String, Object> map3 = this.f39135v;
                    int i5 = this.f39136w;
                    AdMobClickListener adMobClickListener = this.f39137x;
                    try {
                        Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.e.a");
                        cls.getMethod("preload", Map.class, Integer.TYPE, AdMobClickListener.class).invoke(cls.newInstance(), map3, Integer.valueOf(i5), adMobClickListener);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } else if (3 == intValue) {
                    Map<String, Object> map4 = this.f39135v;
                    try {
                        Class<?> cls2 = Class.forName("com.mbridge.msdk.appwall.service.HandlerProvider");
                        cls2.getMethod("preload", Map.class).invoke(cls2.newInstance(), map4);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                } else if (1 != intValue && 2 != intValue) {
                    x.d("SDKController", "unknow layout type in preload");
                }
                e4.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        if (com.mbridge.msdk.c.b.a() == null) {
            return;
        }
        com.mbridge.msdk.c.b a4 = com.mbridge.msdk.c.b.a();
        if (a4 != null) {
            com.mbridge.msdk.c.a b4 = a4.b(str);
            if (b4 != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = b4.aM();
                MBridgeConstans.OMID_JS_H5_URL = b4.aL();
                if (!TextUtils.isEmpty(b4.al())) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().f39566c = b4.al();
                    com.mbridge.msdk.foundation.same.net.f.d.a().e();
                }
                if (!TextUtils.isEmpty(b4.am())) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().f39567d = b4.am();
                    com.mbridge.msdk.foundation.same.net.f.d.a().f();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = "https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js";
                MBridgeConstans.OMID_JS_H5_URL = "https://mtg-native.rayjump.com/omsdk/omsdkjs_common_js.txt";
            }
        }
        if (com.mbridge.msdk.c.b.a().a(str) && com.mbridge.msdk.c.b.a().a(str, 1, (String) null)) {
            new com.mbridge.msdk.c.c().a(bVar.f39124k, str, bVar.f39128o);
        } else {
            new d(bVar.f39124k).a();
        }
    }
}
