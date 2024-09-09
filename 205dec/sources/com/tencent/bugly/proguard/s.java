package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.r;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51276a = false;

    /* renamed from: b  reason: collision with root package name */
    public static r f51277b = null;

    /* renamed from: c  reason: collision with root package name */
    private static int f51278c = 10;

    /* renamed from: d  reason: collision with root package name */
    private static long f51279d = 300000;

    /* renamed from: e  reason: collision with root package name */
    private static long f51280e = 30000;

    /* renamed from: f  reason: collision with root package name */
    private static long f51281f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static int f51282g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static long f51283h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static long f51284i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static long f51285j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f51286k = null;

    /* renamed from: l  reason: collision with root package name */
    private static Class<?> f51287l = null;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f51288m = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (s.f51287l == null || s.f51287l.getName().equals(name)) {
                al.c(">>> %s onCreated <<<", name);
                aa b4 = aa.b();
                if (b4 != null) {
                    b4.f50821L.add(s.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f51287l == null || s.f51287l.getName().equals(name)) {
                al.c(">>> %s onDestroyed <<<", name);
                aa b4 = aa.b();
                if (b4 != null) {
                    b4.f50821L.add(s.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f51287l == null || s.f51287l.getName().equals(name)) {
                al.c(">>> %s onPaused <<<", name);
                aa b4 = aa.b();
                if (b4 == null) {
                    return;
                }
                b4.f50821L.add(s.a(name, "onPaused"));
                long currentTimeMillis = System.currentTimeMillis();
                b4.A = currentTimeMillis;
                b4.B = currentTimeMillis - b4.f50847z;
                long unused = s.f51283h = currentTimeMillis;
                if (b4.B < 0) {
                    b4.B = 0L;
                }
                b4.f50846y = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f51287l == null || s.f51287l.getName().equals(name)) {
                al.c(">>> %s onResumed <<<", name);
                aa b4 = aa.b();
                if (b4 == null) {
                    return;
                }
                b4.f50821L.add(s.a(name, "onResumed"));
                b4.f50846y = name;
                long currentTimeMillis = System.currentTimeMillis();
                b4.f50847z = currentTimeMillis;
                b4.C = currentTimeMillis - s.f51284i;
                long j4 = b4.f50847z - s.f51283h;
                if (j4 > (s.f51281f > 0 ? s.f51281f : s.f51280e)) {
                    b4.c();
                    s.g();
                    al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j4 / 1000), Long.valueOf(s.f51280e / 1000));
                    if (s.f51282g % s.f51278c == 0) {
                        s.f51277b.a(4, s.f51288m);
                        return;
                    }
                    s.f51277b.a(4, false);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - s.f51285j > s.f51279d) {
                        long unused = s.f51285j = currentTimeMillis2;
                        al.a("add a timer to upload hot start user info", new Object[0]);
                        if (s.f51288m) {
                            ak.a().a(new r.a(null, true), s.f51279d);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            al.c(">>> %s onStart <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            al.c(">>> %s onStop <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), false);
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j4;
        if (f51276a) {
            return;
        }
        f51288m = aa.a(context).f50827f;
        f51277b = new r(context, f51288m);
        f51276a = true;
        if (buglyStrategy != null) {
            f51287l = buglyStrategy.getUserInfoActivity();
            j4 = buglyStrategy.getAppReportDelay();
        } else {
            j4 = 0;
        }
        if (j4 <= 0) {
            c(context, buglyStrategy);
        } else {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    s.c(context, buglyStrategy);
                }
            }, j4);
        }
    }

    static /* synthetic */ int g() {
        int i4 = f51282g;
        f51282g = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r12, com.tencent.bugly.BuglyStrategy r13) {
        /*
            r0 = 1
            r1 = 0
            if (r13 == 0) goto Ld
            boolean r2 = r13.recordUserInfoOnceADay()
            boolean r13 = r13.isEnableUserInfo()
            goto Lf
        Ld:
            r13 = 1
            r2 = 0
        Lf:
            if (r2 == 0) goto L5d
            com.tencent.bugly.proguard.aa r13 = com.tencent.bugly.proguard.aa.a(r12)
            java.lang.String r2 = r13.f50825d
            java.util.List r2 = com.tencent.bugly.proguard.r.a(r2)
            if (r2 == 0) goto L58
            r3 = 0
        L1e:
            int r4 = r2.size()
            if (r3 >= r4) goto L58
            java.lang.Object r4 = r2.get(r3)
            com.tencent.bugly.crashreport.biz.UserInfoBean r4 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r4
            java.lang.String r5 = r4.f50732n
            java.lang.String r6 = r13.f50836o
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L55
            int r5 = r4.f50720b
            if (r5 != r0) goto L55
            long r5 = com.tencent.bugly.proguard.ap.b()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L58
            long r9 = r4.f50723e
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 < 0) goto L55
            long r2 = r4.f50724f
            int r13 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r13 > 0) goto L53
            com.tencent.bugly.proguard.r r13 = com.tencent.bugly.proguard.s.f51277b
            r13.b()
        L53:
            r13 = 0
            goto L59
        L55:
            int r3 = r3 + 1
            goto L1e
        L58:
            r13 = 1
        L59:
            if (r13 != 0) goto L5c
            return
        L5c:
            r13 = 0
        L5d:
            com.tencent.bugly.proguard.aa r2 = com.tencent.bugly.proguard.aa.b()
            if (r2 == 0) goto L6c
            boolean r3 = com.tencent.bugly.proguard.z.a()
            if (r3 == 0) goto L6c
            r2.a(r1, r0)
        L6c:
            if (r13 == 0) goto La3
            r13 = 0
            android.content.Context r2 = r12.getApplicationContext()
            android.content.Context r2 = com.stub.StubApp.getOrigApplicationContext(r2)
            boolean r2 = r2 instanceof android.app.Application
            if (r2 == 0) goto L86
            android.content.Context r12 = r12.getApplicationContext()
            android.content.Context r12 = com.stub.StubApp.getOrigApplicationContext(r12)
            r13 = r12
            android.app.Application r13 = (android.app.Application) r13
        L86:
            if (r13 == 0) goto La3
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.proguard.s.f51286k     // Catch: java.lang.Exception -> L99
            if (r12 != 0) goto L93
            com.tencent.bugly.proguard.s$a r12 = new com.tencent.bugly.proguard.s$a     // Catch: java.lang.Exception -> L99
            r12.<init>()     // Catch: java.lang.Exception -> L99
            com.tencent.bugly.proguard.s.f51286k = r12     // Catch: java.lang.Exception -> L99
        L93:
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.proguard.s.f51286k     // Catch: java.lang.Exception -> L99
            r13.registerActivityLifecycleCallbacks(r12)     // Catch: java.lang.Exception -> L99
            goto La3
        L99:
            r12 = move-exception
            boolean r13 = com.tencent.bugly.proguard.al.a(r12)
            if (r13 != 0) goto La3
            r12.printStackTrace()
        La3:
            boolean r12 = com.tencent.bugly.proguard.s.f51288m
            if (r12 == 0) goto Lc6
            long r12 = java.lang.System.currentTimeMillis()
            com.tencent.bugly.proguard.s.f51284i = r12
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.s.f51277b
            r12.a(r0, r1)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "[session] launch app, new start"
            com.tencent.bugly.proguard.al.a(r13, r12)
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.s.f51277b
            r12.a()
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.s.f51277b
            r0 = 21600000(0x1499700, double:1.0671818E-316)
            r12.a(r0)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.s.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public static void a(long j4) {
        if (j4 < 0) {
            j4 = ac.a().c().f50756p;
        }
        f51281f = j4;
    }

    public static void a(StrategyBean strategyBean, boolean z3) {
        r rVar = f51277b;
        if (rVar != null && !z3) {
            rVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j4 = strategyBean.f50756p;
        if (j4 > 0) {
            f51280e = j4;
        }
        int i4 = strategyBean.f50761u;
        if (i4 > 0) {
            f51278c = i4;
        }
        long j5 = strategyBean.f50762v;
        if (j5 > 0) {
            f51279d = j5;
        }
    }

    public static void a() {
        r rVar = f51277b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(Context context) {
        if (!f51276a || context == null) {
            return;
        }
        Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f51286k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e4) {
                if (!al.a(e4)) {
                    e4.printStackTrace();
                }
            }
        }
        f51276a = false;
    }

    static /* synthetic */ String a(String str, String str2) {
        return ap.a() + "  " + str + "  " + str2 + "\n";
    }
}
