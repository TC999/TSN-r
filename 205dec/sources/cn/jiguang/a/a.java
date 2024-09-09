package cn.jiguang.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bk.f;
import cn.jiguang.bx.c;
import cn.jiguang.bx.e;
import cn.jiguang.cd.h;
import cn.jiguang.cd.i;
import cn.jiguang.cn.d;
import cn.jiguang.f.b;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.stub.StubApp;
import java.util.Date;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f2009a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b  reason: collision with root package name */
    public static String f2010b = "4.7.3";

    /* renamed from: c  reason: collision with root package name */
    public static int f2011c = 473;

    /* renamed from: d  reason: collision with root package name */
    public static String f2012d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f2013e;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f2014f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f2015g;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f2018j;

    /* renamed from: h  reason: collision with root package name */
    public static final Date f2016h = b.c();

    /* renamed from: i  reason: collision with root package name */
    public static final String f2017i = d.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* renamed from: k  reason: collision with root package name */
    private static ServiceConnection f2019k = new ServiceConnection() { // from class: cn.jiguang.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            cn.jiguang.bq.d.c("JCoreGobal", "action - onServiceConnected, ComponentName:" + componentName);
            try {
                cn.jiguang.bt.b.c(new cn.jiguang.cm.b("onServiceConnected-" + componentName) { // from class: cn.jiguang.a.a.1.1
                    @Override // cn.jiguang.cm.b
                    public void a() {
                        try {
                            cn.jiguang.bq.d.f("JCoreGobal", "Remote Service bind success.");
                            DataShare.init(IDataShare.Stub.asInterface(iBinder), cn.jiguang.bk.d.a(JConstants.getAppContext(null)));
                            a.c();
                        } catch (Throwable th) {
                            cn.jiguang.bq.d.l("JCoreGobal", "onServiceConnected run e:" + th);
                        }
                    }
                }, new int[0]);
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("JCoreGobal", "onServiceConnected e:" + th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            cn.jiguang.bq.d.c("JCoreGobal", "action - onServiceDisconnected, ComponentName:" + componentName);
            a.f2018j = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jiguang.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class C0046a extends cn.jiguang.cm.b {

        /* renamed from: a  reason: collision with root package name */
        Context f2022a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2023b;

        /* renamed from: c  reason: collision with root package name */
        String f2024c;

        /* renamed from: d  reason: collision with root package name */
        Bundle f2025d;

        C0046a(Context context, boolean z3, String str, Bundle bundle) {
            this.f2022a = context;
            this.f2023b = z3;
            this.f2024c = str;
            this.f2025d = bundle;
            this.f3462h = "JCoreGlobal";
        }

        private void a(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("is_auth")) {
                return;
            }
            boolean z3 = bundle.getBoolean("is_auth", true);
            boolean z4 = bundle.getBoolean("had_auth", true);
            cn.jiguang.bq.d.c("JCoreGobal", "setAuthFormBundle\uff1aauth=" + z3 + " hadAuth=" + z4);
            cn.jiguang.cn.a.a(z3, z4);
        }

        private Bundle b(Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("is_auth", cn.jiguang.cn.a.a());
            bundle.putBoolean("had_auth", cn.jiguang.cn.a.b());
            cn.jiguang.bq.d.c("JCoreGobal", "setAuthFormBundle addAuthToBundle hadAuth=" + cn.jiguang.cn.a.b() + " auth=" + cn.jiguang.cn.a.a());
            return bundle;
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            Context context;
            String str;
            Bundle bundle;
            String str2;
            try {
                a(this.f2025d);
                if (!cn.jiguang.cn.a.a()) {
                    cn.jiguang.bq.d.l("JCoreGobal", "user don't auth, so return init");
                } else if (!this.f2023b) {
                    if (a.a(this.f2022a)) {
                        this.f2025d = b(this.f2025d);
                        cn.jiguang.bk.d.a().a(this.f2022a, this.f2024c, this.f2025d);
                    }
                } else {
                    if (this.f2024c.equals("a5")) {
                        cn.jiguang.bx.b.a().a(this.f2022a, 2001, 1, "");
                        cn.jiguang.g.b.a(this.f2022a, cn.jiguang.g.a.L().a((cn.jiguang.g.a<Boolean>) Boolean.TRUE));
                        String string = this.f2025d.getString("appkey");
                        if (TextUtils.isEmpty(string)) {
                            cn.jiguang.bx.b.a().a(this.f2022a, 0, 10003, cn.jiguang.cc.d.a(10003));
                            return;
                        }
                        String b4 = cn.jiguang.bk.a.b(this.f2022a);
                        if (!TextUtils.isEmpty(b4) && !b4.equals(string)) {
                            cn.jiguang.bx.b.a().a(this.f2022a, 0, 10002, cn.jiguang.cc.d.a(10002));
                            return;
                        }
                        cn.jiguang.f.a.g(this.f2022a);
                        JConstants.APP_KEY = string;
                        if (c.a(this.f2022a)) {
                            str2 = "tcp_a24";
                        } else {
                            String b5 = cn.jiguang.d.a.b(this.f2022a);
                            if (!TextUtils.isEmpty(b5)) {
                                cn.jiguang.bx.b.a().a(this.f2022a, 2001, 0, b5);
                            }
                            str2 = "tcp_a1";
                        }
                        this.f2024c = str2;
                    } else if (this.f2024c.equals("tcp_a23")) {
                        cn.jiguang.bx.b.a().a(this.f2022a, 2000, 0, "success");
                    } else if (this.f2024c.equals("a6")) {
                        f.a(this.f2022a);
                    } else if (TextUtils.equals(this.f2024c, "a8")) {
                        Bundle bundle2 = this.f2025d;
                        if (bundle2 != null) {
                            cn.jiguang.cn.a.d(this.f2022a, bundle2.getBoolean("enable_auto_wakeup"));
                        }
                    } else if (TextUtils.equals(this.f2024c, "a11")) {
                        Bundle bundle3 = this.f2025d;
                        if (bundle3 != null) {
                            cn.jiguang.cn.a.f(this.f2022a, bundle3.getBoolean("enable_ci_priority"));
                            context = this.f2022a;
                            str = "action_ci_priority";
                            bundle = this.f2025d;
                            e.a(context, str, bundle);
                        }
                    } else if (TextUtils.equals(this.f2024c, "a9")) {
                        Bundle bundle4 = this.f2025d;
                        if (bundle4 != null) {
                            cn.jiguang.cn.a.e(this.f2022a, bundle4.getBoolean("enable_dy"));
                        }
                    } else {
                        if (this.f2024c.equals("a7")) {
                            context = this.f2022a;
                            str = "SYNC_COLLECT_CONFIG";
                            bundle = this.f2025d;
                        } else if (this.f2024c.equals("a10")) {
                            context = this.f2022a;
                            str = "GET_ANDROID_ID";
                            bundle = this.f2025d;
                        }
                        e.a(context, str, bundle);
                    }
                    int b6 = a.b(this.f2022a);
                    if (b6 == 0) {
                        cn.jiguang.bk.d.a().b(this.f2022a, this.f2024c, this.f2025d);
                    } else if (b6 > 0) {
                        cn.jiguang.bx.b.a().a(this.f2022a, 2002, b6, cn.jiguang.cc.d.a(b6));
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("JCoreGobal", "do action error: action" + this.f2024c + " bundle=" + this.f2025d);
                StringBuilder sb = new StringBuilder();
                sb.append("do action error:");
                sb.append(th.getMessage());
                cn.jiguang.bq.d.l("JCoreGobal", sb.toString());
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        try {
            String c4 = cn.jiguang.bk.d.c(context);
            cn.jiguang.bq.d.c("JCoreGobal", "serviceName is " + c4);
            if ((cn.jiguang.bk.c.a().e() || cn.jiguang.bk.c.a().d() || cn.jiguang.bk.c.a().f()) && TextUtils.isEmpty(c4)) {
                cn.jiguang.bq.d.n("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService. Otherwise no service");
                return;
            }
            String a4 = cn.jiguang.f.a.a(context);
            cn.jiguang.bq.d.c("JCoreGobal", "curProcessName is " + a4);
            if (!TextUtils.isEmpty(c4)) {
                String a5 = cn.jiguang.bk.d.a(context);
                cn.jiguang.bq.d.c("JCoreGobal", "curProcessName is " + a4 + ", remoteProcessName is " + a5);
                if (!TextUtils.isEmpty(c4) && context.getPackageName().equals(a4)) {
                    cn.jiguang.cm.d.a("SDK_INIT", new C0046a(context, false, str, bundle));
                    return;
                } else if (TextUtils.isEmpty(a4) || !a4.equals(a5)) {
                    return;
                }
            } else if (!context.getPackageName().equals(a4)) {
                return;
            }
            b(context, str, bundle);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JCoreGobal", "sendToServiceAction failed, " + th.getMessage());
        }
    }

    public static void a(Context context, boolean z3, long j4) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z3);
            bundle.putLong("delay_time", j4);
            a(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            cn.jiguang.bq.d.j("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static boolean a() {
        try {
            Class.forName("cn.jiguang.dy.b");
        } catch (Throwable unused) {
        }
        return true;
    }

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            Boolean bool = f2013e;
            if (bool != null) {
                return bool.booleanValue();
            } else if (context == null) {
                cn.jiguang.bq.d.m("JCoreGobal", "init failed,context is null");
                return false;
            } else {
                d(context);
                JConstants.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                cn.jiguang.bq.d.h("JCoreGobal", "main process init - jcore, SdkVersion:" + f2010b + ", build id:397 build type:release");
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                cn.jiguang.bk.c.a();
                String c4 = cn.jiguang.bk.d.c(origApplicationContext);
                if ((cn.jiguang.bk.c.a().e() || cn.jiguang.bk.c.a().d() || cn.jiguang.bk.c.a().f()) && TextUtils.isEmpty(c4)) {
                    f2013e = Boolean.FALSE;
                    cn.jiguang.bq.d.n("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService. Otherwise no service");
                    return false;
                }
                try {
                    cn.jiguang.b.a.a().b();
                } catch (Throwable unused) {
                }
                i.a(origApplicationContext);
                e(origApplicationContext);
                g(origApplicationContext);
                cn.jiguang.bm.e.b(origApplicationContext);
                Boolean bool2 = Boolean.TRUE;
                f2013e = bool2;
                return bool2.booleanValue();
            }
        }
    }

    public static synchronized int b(Context context) {
        synchronized (a.class) {
            Integer num = f2014f;
            if (num != null) {
                return num.intValue();
            } else if (context == null) {
                cn.jiguang.bq.d.m("JCoreGobal", "init failed, context is null");
                return 1000;
            } else {
                d(context);
                if (cn.jiguang.f.a.b(context)) {
                    c();
                }
                cn.jiguang.bq.d.h("JCoreGobal", "service process init - jcore, SdkVersion:" + f2010b + ", build id:397 build type:release");
                JConstants.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                int e4 = cn.jiguang.bk.a.e(origApplicationContext);
                if (e4 != 0) {
                    return e4;
                }
                int f4 = cn.jiguang.bk.a.f(origApplicationContext);
                if (f4 != 0) {
                    f2014f = -1;
                    return f4;
                }
                if (a()) {
                    JCoreInternalHelper.getInstance().onEvent(origApplicationContext, JConstants.SDK_TYPE, 65, true, "", null, 1);
                }
                cn.jiguang.bk.c.a();
                try {
                    JConstants.isCallInit.set(true);
                } catch (Throwable unused) {
                }
                f(origApplicationContext);
                f2014f = 0;
                i.a(origApplicationContext);
                h.a().b(origApplicationContext);
                cn.jiguang.b.a.a().e(origApplicationContext);
                e.a(origApplicationContext, "service_create", null);
                if (Build.VERSION.SDK_INT >= 21) {
                    cn.jiguang.by.a.a().a(origApplicationContext);
                }
                if (!((Boolean) cn.jiguang.g.b.a(origApplicationContext, cn.jiguang.g.a.ah())).booleanValue()) {
                    cn.jiguang.bq.a.b(origApplicationContext);
                }
                cn.jiguang.ck.a.a().a(origApplicationContext);
                cn.jiguang.cn.a.a(origApplicationContext);
                return f2014f.intValue();
            }
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        cn.jiguang.cm.d.a("SDK_SERVICE_INIT", new C0046a(context, true, str, bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        f2018j = true;
        cn.jiguang.d.a.a().sendCurrentState();
        cn.jiguang.bt.c.a().a(JConstants.getAppContext(null));
        Context context = JConstants.mApplicationContext;
        if (context != null) {
            JCoreManager.init(context);
        }
    }

    public static void c(Context context) {
        try {
            cn.jiguang.bq.d.f("JCoreGobal", "unRegisterCommonService start");
            context.unbindService(f2019k);
            String c4 = cn.jiguang.bk.d.c(context);
            if (TextUtils.isEmpty(c4)) {
                cn.jiguang.bq.d.f("JCoreGobal", "not found commonServiceClass\uff08JCommonService\uff09");
                return;
            }
            Intent intent = new Intent(JConstants.USER_SERVICE_ACTION);
            intent.setClassName(context, c4);
            intent.setPackage(context.getPackageName());
            context.stopService(intent);
            cn.jiguang.bq.d.f("JCoreGobal", "unRegisterCommonService end");
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JCoreGobal", "unregister service failed, " + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x00ac, TryCatch #0 {all -> 0x00ac, blocks: (B:5:0x000a, B:8:0x0022, B:10:0x0038, B:11:0x0053, B:14:0x0068, B:16:0x0078, B:18:0x008e, B:19:0x00a7, B:12:0x0057, B:13:0x005d), top: B:22:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.content.Context r11) {
        /*
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = "JCoreGobal"
            java.lang.String r1 = "setInternalDebug"
            cn.jiguang.bq.d.c(r0, r1)
            cn.jiguang.g.a r1 = cn.jiguang.g.a.au()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> Lac
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r2 = "setInternalDebug is expire!"
            java.lang.String r3 = "setInternalDebug open"
            java.lang.String r4 = "FUTURE_TASK"
            r5 = 0
            r6 = 1
            if (r1 != r6) goto L5d
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r1 = cn.jiguang.g.a.aw()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Throwable -> Lac
            long r9 = r1.longValue()     // Catch: java.lang.Throwable -> Lac
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto L57
            cn.jiguang.g.a[] r1 = new cn.jiguang.g.a[r6]     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r7 = cn.jiguang.g.a.au()     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r7 = r7.a(r8)     // Catch: java.lang.Throwable -> Lac
            r1[r5] = r7     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.bq.d.c(r0, r2)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a$2 r1 = new cn.jiguang.a.a$2     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
        L53:
            cn.jiguang.cm.d.a(r4, r1)     // Catch: java.lang.Throwable -> Lac
            goto L68
        L57:
            cn.jiguang.bq.d.c(r0, r3)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a.f2015g = r6     // Catch: java.lang.Throwable -> Lac
            goto L68
        L5d:
            java.lang.String r1 = "setInternalDebug close and delete log file"
            cn.jiguang.bq.d.c(r0, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.a.a$3 r1 = new cn.jiguang.a.a$3     // Catch: java.lang.Throwable -> Lac
            r1.<init>()     // Catch: java.lang.Throwable -> Lac
            goto L53
        L68:
            cn.jiguang.g.a r1 = cn.jiguang.g.a.av()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> Lac
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> Lac
            if (r1 != r6) goto Lac
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r1 = cn.jiguang.g.a.aw()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r1 = cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.Throwable -> Lac
            long r9 = r1.longValue()     // Catch: java.lang.Throwable -> Lac
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto La7
            cn.jiguang.g.a[] r1 = new cn.jiguang.g.a[r6]     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r3 = cn.jiguang.g.a.av()     // Catch: java.lang.Throwable -> Lac
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.a r3 = r3.a(r4)     // Catch: java.lang.Throwable -> Lac
            r1[r5] = r3     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.g.b.a(r11, r1)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r5     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.bq.d.c(r0, r2)     // Catch: java.lang.Throwable -> Lac
            goto Lac
        La7:
            cn.jiguang.bq.d.c(r0, r3)     // Catch: java.lang.Throwable -> Lac
            cn.jiguang.internal.JConstants.CMD_TO_PRINT_ALL_LOG = r6     // Catch: java.lang.Throwable -> Lac
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d(android.content.Context):void");
    }

    private static void e(Context context) {
        String c4 = cn.jiguang.bk.d.c(context);
        if (TextUtils.isEmpty(c4)) {
            cn.jiguang.bq.d.f("JCoreGobal", "not found commonServiceClass\uff08JCommonService\uff09");
            return;
        }
        try {
            context.startService(new Intent(StubApp.getOrigApplicationContext(context.getApplicationContext()), Class.forName(c4)));
            cn.jiguang.bq.d.c("JCoreGobal", "start common service");
        } catch (Throwable unused) {
        }
    }

    private static void f(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            PushReceiver pushReceiver = new PushReceiver();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            if (Build.VERSION.SDK_INT < 28) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            cn.jiguang.cn.e.a(context, pushReceiver, intentFilter, context.getPackageName() + f2009a, null);
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("JCoreGobal", "registerPushReceiver fail:" + th);
        }
    }

    private static void g(Context context) {
        String str;
        String c4 = cn.jiguang.bk.d.c(context);
        if (TextUtils.isEmpty(c4)) {
            cn.jiguang.bq.d.f("JCoreGobal", "not found commonServiceClass\uff08JCommonService\uff09");
        } else if (DataShare.isBinding()) {
            cn.jiguang.bq.d.c("JCoreGobal", "is binding service");
        } else {
            try {
                Intent intent = new Intent();
                intent.setClass(context, Class.forName(c4));
                if (context.bindService(intent, f2019k, 1)) {
                    cn.jiguang.bq.d.a("JCoreGobal", "Remote Service on binding...");
                    DataShare.setBinding();
                } else {
                    cn.jiguang.bq.d.a("JCoreGobal", "Remote Service bind failed");
                }
            } catch (SecurityException unused) {
                str = "Remote Service bind failed caused by SecurityException!";
                cn.jiguang.bq.d.j("JCoreGobal", str);
            } catch (Throwable th) {
                str = "Remote Service bind failed :" + th;
                cn.jiguang.bq.d.j("JCoreGobal", str);
            }
        }
    }
}
