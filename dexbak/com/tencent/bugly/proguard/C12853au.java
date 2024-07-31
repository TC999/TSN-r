package com.tencent.bugly.proguard;

import android.content.Context;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.au */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12853au {

    /* renamed from: a */
    private static C12853au f36651a;

    /* renamed from: b */
    private C12803ac f36652b;

    /* renamed from: c */
    private C12786aa f36653c;

    /* renamed from: d */
    private C12832as f36654d;

    /* renamed from: e */
    private Context f36655e;

    private C12853au(Context context) {
        C12848at m15755a = C12848at.m15755a();
        if (m15755a == null) {
            return;
        }
        this.f36652b = C12803ac.m15950a();
        this.f36653c = C12786aa.m16009a(context);
        this.f36654d = m15755a.f36632s;
        this.f36655e = context;
        C12818ak.m15887a().m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                C12853au.m15736a(C12853au.this);
            }
        });
    }

    /* renamed from: a */
    public static C12853au m15737a(Context context) {
        if (f36651a == null) {
            f36651a = new C12853au(context);
        }
        return f36651a;
    }

    /* renamed from: a */
    public static void m15734a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        C12818ak.m15887a().m15886a(new Runnable() { // from class: com.tencent.bugly.proguard.au.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (C12853au.f36651a != null) {
                        C12853au.m15735a(C12853au.f36651a, thread, i, str, str2, str3, map);
                    } else {
                        C12820al.m15872e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!C12820al.m15875b(th)) {
                        th.printStackTrace();
                    }
                    C12820al.m15872e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m15736a(C12853au c12853au) {
        C12820al.m15874c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            c12853au.f36653c.getClass();
            C12828ap.m15836a(cls, "sdkPackageName", "com.tencent.bugly");
            C12820al.m15874c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C12820al.m15878a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m15735a(C12853au c12853au, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else if (i != 8) {
            C12820al.m15873d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        C12820al.m15872e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!c12853au.f36652b.m15943b()) {
                C12820al.m15873d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean m15941c = c12853au.f36652b.m15941c();
            if (!m15941c.f36296f && c12853au.f36652b.m15943b()) {
                C12820al.m15872e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                String m15848a = C12828ap.m15848a();
                String str7 = c12853au.f36653c.f36451d;
                String name = currentThread.getName();
                C12832as.m15786a(str4, m15848a, str7, name, str + ShellAdbUtils.f33810d + str2 + ShellAdbUtils.f33810d + str3, null);
                C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i != 5 && i != 6) {
                if (i == 8 && !m15941c.f36302l) {
                    C12820al.m15872e("[ExtraCrashManager] %s report is disabled.", str4);
                    C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!m15941c.f36301k) {
                C12820al.m15872e("[ExtraCrashManager] %s report is disabled.", str4);
                C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i2 = i != 8 ? i : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f36316C = C12787ab.m15961j();
            crashDetailBean.f36317D = C12787ab.m15965f();
            crashDetailBean.f36318E = C12787ab.m15959l();
            crashDetailBean.f36319F = c12853au.f36653c.m15989k();
            crashDetailBean.f36320G = c12853au.f36653c.m15990j();
            crashDetailBean.f36321H = c12853au.f36653c.m15988l();
            crashDetailBean.f36322I = C12787ab.m15970b(c12853au.f36655e);
            crashDetailBean.f36323J = C12787ab.m15964g();
            crashDetailBean.f36324K = C12787ab.m15963h();
            crashDetailBean.f36342b = i2;
            crashDetailBean.f36345e = c12853au.f36653c.m15994g();
            C12786aa c12786aa = c12853au.f36653c;
            crashDetailBean.f36346f = c12786aa.f36462o;
            crashDetailBean.f36347g = c12786aa.m15983q();
            crashDetailBean.f36353m = c12853au.f36653c.m15996f();
            crashDetailBean.f36354n = String.valueOf(str);
            crashDetailBean.f36355o = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split(ShellAdbUtils.f33810d);
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f36356p = str5;
            crashDetailBean.f36357q = str6;
            crashDetailBean.f36358r = System.currentTimeMillis();
            crashDetailBean.f36361u = C12828ap.m15810c(crashDetailBean.f36357q.getBytes());
            crashDetailBean.f36366z = C12828ap.m15826a(c12853au.f36653c.f36415Q, C12848at.f36617h);
            crashDetailBean.f36314A = c12853au.f36653c.f36451d;
            crashDetailBean.f36315B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.f36325L = c12853au.f36653c.m15981s();
            crashDetailBean.f36348h = c12853au.f36653c.m15984p();
            C12786aa c12786aa2 = c12853au.f36653c;
            crashDetailBean.f36330Q = c12786aa2.f36424a;
            crashDetailBean.f36331R = c12786aa2.m16011a();
            crashDetailBean.f36334U = c12853au.f36653c.m15974z();
            C12786aa c12786aa3 = c12853au.f36653c;
            crashDetailBean.f36335V = c12786aa3.f36471x;
            crashDetailBean.f36336W = c12786aa3.m15980t();
            crashDetailBean.f36337X = c12853au.f36653c.m15975y();
            crashDetailBean.f36365y = C12824ao.m15864a();
            if (crashDetailBean.f36332S == null) {
                crashDetailBean.f36332S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f36332S.putAll(map);
            }
            String m15848a2 = C12828ap.m15848a();
            String str8 = c12853au.f36653c.f36451d;
            String name2 = currentThread.getName();
            C12832as.m15786a(str4, m15848a2, str8, name2, str + ShellAdbUtils.f33810d + str2 + ShellAdbUtils.f33810d + str3, crashDetailBean);
            if (!c12853au.f36654d.m15789a(crashDetailBean, !C12848at.m15755a().f36630C)) {
                c12853au.f36654d.m15768b(crashDetailBean, false);
            }
            C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
                C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C12820al.m15872e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
