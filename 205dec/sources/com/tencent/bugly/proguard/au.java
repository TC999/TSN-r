package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class au {

    /* renamed from: a  reason: collision with root package name */
    private static au f51021a;

    /* renamed from: b  reason: collision with root package name */
    private ac f51022b;

    /* renamed from: c  reason: collision with root package name */
    private aa f51023c;

    /* renamed from: d  reason: collision with root package name */
    private as f51024d;

    /* renamed from: e  reason: collision with root package name */
    private Context f51025e;

    private au(Context context) {
        at a4 = at.a();
        if (a4 == null) {
            return;
        }
        this.f51022b = ac.a();
        this.f51023c = aa.a(context);
        this.f51024d = a4.f51002s;
        this.f51025e = context;
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                au.a(au.this);
            }
        });
    }

    public static au a(Context context) {
        if (f51021a == null) {
            f51021a = new au(context);
        }
        return f51021a;
    }

    public static void a(final Thread thread, final int i4, final String str, final String str2, final String str3, final Map<String, String> map) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.au.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (au.f51021a != null) {
                        au.a(au.f51021a, thread, i4, str, str2, str3, map);
                    } else {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }

    static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.f51023c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(au auVar, Thread thread, int i4, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i4 == 4) {
            str4 = "Unity";
        } else if (i4 == 5 || i4 == 6) {
            str4 = "Cocos";
        } else if (i4 != 8) {
            al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i4));
            return;
        } else {
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.f51022b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c4 = auVar.f51022b.c();
            if (!c4.f50746f && auVar.f51022b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                String a4 = ap.a();
                String str7 = auVar.f51023c.f50825d;
                String name = currentThread.getName();
                as.a(str4, a4, str7, name, str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i4 != 5 && i4 != 6) {
                if (i4 == 8 && !c4.f50752l) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c4.f50751k) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i5 = i4 != 8 ? i4 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.f51023c.k();
            crashDetailBean.G = auVar.f51023c.j();
            crashDetailBean.H = auVar.f51023c.l();
            crashDetailBean.I = ab.b(auVar.f51025e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f50766b = i5;
            crashDetailBean.f50769e = auVar.f51023c.g();
            aa aaVar = auVar.f51023c;
            crashDetailBean.f50770f = aaVar.f50836o;
            crashDetailBean.f50771g = aaVar.q();
            crashDetailBean.f50777m = auVar.f51023c.f();
            crashDetailBean.f50778n = String.valueOf(str);
            crashDetailBean.f50779o = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f50780p = str5;
            crashDetailBean.f50781q = str6;
            crashDetailBean.f50782r = System.currentTimeMillis();
            crashDetailBean.f50785u = ap.c(crashDetailBean.f50781q.getBytes());
            crashDetailBean.f50790z = ap.a(auVar.f51023c.Q, at.f50990h);
            crashDetailBean.A = auVar.f51023c.f50825d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.f50764L = auVar.f51023c.s();
            crashDetailBean.f50772h = auVar.f51023c.p();
            aa aaVar2 = auVar.f51023c;
            crashDetailBean.Q = aaVar2.f50822a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = auVar.f51023c.z();
            aa aaVar3 = auVar.f51023c;
            crashDetailBean.V = aaVar3.f50845x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = auVar.f51023c.y();
            crashDetailBean.f50789y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            String a5 = ap.a();
            String str8 = auVar.f51023c.f50825d;
            String name2 = currentThread.getName();
            as.a(str4, a5, str8, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.f51024d.a(crashDetailBean, !at.a().C)) {
                auVar.f51024d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
