package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C12906r;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12912s {

    /* renamed from: a */
    public static boolean f36910a = false;

    /* renamed from: b */
    public static C12906r f36911b = null;

    /* renamed from: c */
    private static int f36912c = 10;

    /* renamed from: d */
    private static long f36913d = 300000;

    /* renamed from: e */
    private static long f36914e = 30000;

    /* renamed from: f */
    private static long f36915f = 0;

    /* renamed from: g */
    private static int f36916g = 0;

    /* renamed from: h */
    private static long f36917h = 0;

    /* renamed from: i */
    private static long f36918i = 0;

    /* renamed from: j */
    private static long f36919j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f36920k = null;

    /* renamed from: l */
    private static Class<?> f36921l = null;

    /* renamed from: m */
    private static boolean f36922m = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.s$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12914a implements Application.ActivityLifecycleCallbacks {
        C12914a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (C12912s.f36921l == null || C12912s.f36921l.getName().equals(name)) {
                C12820al.m15874c(">>> %s onCreated <<<", name);
                C12786aa m16005b = C12786aa.m16005b();
                if (m16005b != null) {
                    m16005b.f36410L.add(C12912s.m15540a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (C12912s.f36921l == null || C12912s.f36921l.getName().equals(name)) {
                C12820al.m15874c(">>> %s onDestroyed <<<", name);
                C12786aa m16005b = C12786aa.m16005b();
                if (m16005b != null) {
                    m16005b.f36410L.add(C12912s.m15540a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (C12912s.f36921l == null || C12912s.f36921l.getName().equals(name)) {
                C12820al.m15874c(">>> %s onPaused <<<", name);
                C12786aa m16005b = C12786aa.m16005b();
                if (m16005b == null) {
                    return;
                }
                m16005b.f36410L.add(C12912s.m15540a(name, "onPaused"));
                long currentTimeMillis = System.currentTimeMillis();
                m16005b.f36399A = currentTimeMillis;
                m16005b.f36400B = currentTimeMillis - m16005b.f36473z;
                long unused = C12912s.f36917h = currentTimeMillis;
                if (m16005b.f36400B < 0) {
                    m16005b.f36400B = 0L;
                }
                m16005b.f36472y = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (C12912s.f36921l == null || C12912s.f36921l.getName().equals(name)) {
                C12820al.m15874c(">>> %s onResumed <<<", name);
                C12786aa m16005b = C12786aa.m16005b();
                if (m16005b == null) {
                    return;
                }
                m16005b.f36410L.add(C12912s.m15540a(name, "onResumed"));
                m16005b.f36472y = name;
                long currentTimeMillis = System.currentTimeMillis();
                m16005b.f36473z = currentTimeMillis;
                m16005b.f36401C = currentTimeMillis - C12912s.f36918i;
                long j = m16005b.f36473z - C12912s.f36917h;
                if (j > (C12912s.f36915f > 0 ? C12912s.f36915f : C12912s.f36914e)) {
                    m16005b.m16002c();
                    C12912s.m15530g();
                    C12820al.m15878a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j / 1000), Long.valueOf(C12912s.f36914e / 1000));
                    if (C12912s.f36916g % C12912s.f36912c == 0) {
                        C12912s.f36911b.m15565a(4, C12912s.f36922m);
                        return;
                    }
                    C12912s.f36911b.m15565a(4, false);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - C12912s.f36919j > C12912s.f36913d) {
                        long unused = C12912s.f36919j = currentTimeMillis2;
                        C12820al.m15878a("add a timer to upload hot start user info", new Object[0]);
                        if (C12912s.f36922m) {
                            C12818ak.m15887a().m15885a(new C12906r.RunnableC12909a(null, true), C12912s.f36913d);
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
            C12820al.m15874c(">>> %s onStart <<<", activity.getClass().getName());
            C12786aa.m16005b().m16010a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            C12820al.m15874c(">>> %s onStop <<<", activity.getClass().getName());
            C12786aa.m16005b().m16010a(activity.hashCode(), false);
        }
    }

    /* renamed from: a */
    public static void m15542a(final Context context, final BUGLY bugly) {
        long j;
        if (f36910a) {
            return;
        }
        f36922m = C12786aa.m16009a(context).f36453f;
        f36911b = new C12906r(context, f36922m);
        f36910a = true;
        if (bugly != null) {
            f36921l = bugly.getUserInfoActivity();
            j = bugly.getAppReportDelay();
        } else {
            j = 0;
        }
        if (j <= 0) {
            m15534c(context, bugly);
        } else {
            C12818ak.m15887a().m15885a(new Runnable() { // from class: com.tencent.bugly.proguard.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    C12912s.m15534c(context, bugly);
                }
            }, j);
        }
    }

    /* renamed from: g */
    static /* synthetic */ int m15530g() {
        int i = f36916g;
        f36916g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m15534c(android.content.Context r12, com.tencent.bugly.BUGLY r13) {
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
            com.tencent.bugly.proguard.aa r13 = com.tencent.bugly.proguard.C12786aa.m16009a(r12)
            java.lang.String r2 = r13.f36451d
            java.util.List r2 = com.tencent.bugly.proguard.C12906r.m15557a(r2)
            if (r2 == 0) goto L58
            r3 = 0
        L1e:
            int r4 = r2.size()
            if (r3 >= r4) goto L58
            java.lang.Object r4 = r2.get(r3)
            com.tencent.bugly.crashreport.biz.UserInfoBean r4 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r4
            java.lang.String r5 = r4.f36282n
            java.lang.String r6 = r13.f36462o
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L55
            int r5 = r4.f36270b
            if (r5 != r0) goto L55
            long r5 = com.tencent.bugly.proguard.C12828ap.m15823b()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L58
            long r9 = r4.f36273e
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 < 0) goto L55
            long r2 = r4.f36274f
            int r13 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r13 > 0) goto L53
            com.tencent.bugly.proguard.r r13 = com.tencent.bugly.proguard.C12912s.f36911b
            r13.m15552b()
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
            com.tencent.bugly.proguard.aa r2 = com.tencent.bugly.proguard.C12786aa.m16005b()
            if (r2 == 0) goto L6c
            boolean r3 = com.tencent.bugly.proguard.C12924z.m15479a()
            if (r3 == 0) goto L6c
            r2.m16010a(r1, r0)
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
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.proguard.C12912s.f36920k     // Catch: java.lang.Exception -> L99
            if (r12 != 0) goto L93
            com.tencent.bugly.proguard.s$a r12 = new com.tencent.bugly.proguard.s$a     // Catch: java.lang.Exception -> L99
            r12.<init>()     // Catch: java.lang.Exception -> L99
            com.tencent.bugly.proguard.C12912s.f36920k = r12     // Catch: java.lang.Exception -> L99
        L93:
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.proguard.C12912s.f36920k     // Catch: java.lang.Exception -> L99
            r13.registerActivityLifecycleCallbacks(r12)     // Catch: java.lang.Exception -> L99
            goto La3
        L99:
            r12 = move-exception
            boolean r13 = com.tencent.bugly.proguard.C12820al.m15877a(r12)
            if (r13 != 0) goto La3
            r12.printStackTrace()
        La3:
            boolean r12 = com.tencent.bugly.proguard.C12912s.f36922m
            if (r12 == 0) goto Lc6
            long r12 = java.lang.System.currentTimeMillis()
            com.tencent.bugly.proguard.C12912s.f36918i = r12
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.C12912s.f36911b
            r12.m15565a(r0, r1)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "[session] launch app, new start"
            com.tencent.bugly.proguard.C12820al.m15878a(r13, r12)
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.C12912s.f36911b
            r12.m15566a()
            com.tencent.bugly.proguard.r r12 = com.tencent.bugly.proguard.C12912s.f36911b
            r0 = 21600000(0x1499700, double:1.0671818E-316)
            r12.m15564a(r0)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12912s.m15534c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    /* renamed from: a */
    public static void m15544a(long j) {
        if (j < 0) {
            j = C12803ac.m15950a().m15941c().f36306p;
        }
        f36915f = j;
    }

    /* renamed from: a */
    public static void m15541a(StrategyBean strategyBean, boolean z) {
        C12906r c12906r = f36911b;
        if (c12906r != null && !z) {
            c12906r.m15552b();
        }
        if (strategyBean == null) {
            return;
        }
        long j = strategyBean.f36306p;
        if (j > 0) {
            f36914e = j;
        }
        int i = strategyBean.f36311u;
        if (i > 0) {
            f36912c = i;
        }
        long j2 = strategyBean.f36312v;
        if (j2 > 0) {
            f36913d = j2;
        }
    }

    /* renamed from: a */
    public static void m15545a() {
        C12906r c12906r = f36911b;
        if (c12906r != null) {
            c12906r.m15565a(2, false);
        }
    }

    /* renamed from: a */
    public static void m15543a(Context context) {
        if (!f36910a || context == null) {
            return;
        }
        Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f36920k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e) {
                if (!C12820al.m15877a(e)) {
                    e.printStackTrace();
                }
            }
        }
        f36910a = false;
    }

    /* renamed from: a */
    static /* synthetic */ String m15540a(String str, String str2) {
        return C12828ap.m15848a() + "  " + str + "  " + str2 + ShellAdbUtils.f33810d;
    }
}
