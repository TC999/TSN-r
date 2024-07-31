package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C12808ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.at */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12848at {

    /* renamed from: D */
    private static C12848at f36610D = null;

    /* renamed from: a */
    public static int f36611a = 0;

    /* renamed from: b */
    public static boolean f36612b = false;

    /* renamed from: d */
    public static int f36613d = 2;

    /* renamed from: e */
    public static boolean f36614e = false;

    /* renamed from: f */
    public static int f36615f = 20480;

    /* renamed from: g */
    public static int f36616g = 3000;

    /* renamed from: h */
    public static int f36617h = 20480;

    /* renamed from: i */
    public static long f36618i = 209715200;

    /* renamed from: j */
    public static long f36619j = 604800000;

    /* renamed from: k */
    public static String f36620k = null;

    /* renamed from: l */
    public static boolean f36621l = false;

    /* renamed from: m */
    public static String f36622m = null;

    /* renamed from: n */
    public static int f36623n = 5000;

    /* renamed from: o */
    public static boolean f36624o = true;

    /* renamed from: p */
    public static boolean f36625p;

    /* renamed from: q */
    public static String f36626q;

    /* renamed from: r */
    public static String f36627r;

    /* renamed from: A */
    public Boolean f36628A;

    /* renamed from: B */
    public int f36629B = 31;

    /* renamed from: C */
    public boolean f36630C = false;

    /* renamed from: c */
    public final Context f36631c;

    /* renamed from: s */
    public final C12832as f36632s;

    /* renamed from: t */
    public final C12856av f36633t;

    /* renamed from: u */
    public final NativeCrashHandler f36634u;

    /* renamed from: v */
    public final C12803ac f36635v;

    /* renamed from: w */
    public final C12818ak f36636w;

    /* renamed from: x */
    public final C12859ay f36637x;

    /* renamed from: y */
    public BUGLY.C12768a f36638y;

    /* renamed from: z */
    public InterfaceC12857aw f36639z;

    private C12848at(Context context, C12818ak c12818ak, boolean z, BUGLY.C12768a c12768a) {
        f36611a = 1004;
        Context m15844a = C12828ap.m15844a(context);
        this.f36631c = m15844a;
        C12803ac m15950a = C12803ac.m15950a();
        this.f36635v = m15950a;
        this.f36636w = c12818ak;
        this.f36638y = c12768a;
        this.f36639z = null;
        C12832as c12832as = new C12832as(m15844a, C12814ai.m15913a(), C12920w.m15509a(), m15950a, c12768a);
        this.f36632s = c12832as;
        C12786aa m16009a = C12786aa.m16009a(m15844a);
        this.f36633t = new C12856av(m15844a, c12832as, m15950a, m16009a);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(m15844a, m16009a, c12832as, m15950a, c12818ak, z, null);
        this.f36634u = nativeCrashHandler;
        m16009a.f36412N = nativeCrashHandler;
        if (C12859ay.f36680f == null) {
            C12859ay.f36680f = new C12859ay(m15844a, m15950a, m16009a, c12818ak, c12832as);
        }
        this.f36637x = C12859ay.f36680f;
    }

    /* renamed from: c */
    public final synchronized void m15747c() {
        this.f36633t.m15725b();
        m15746d();
        m15743g();
    }

    /* renamed from: d */
    public final void m15746d() {
        this.f36634u.setUserOpened(false);
    }

    /* renamed from: e */
    public final void m15745e() {
        this.f36634u.setUserOpened(true);
    }

    /* renamed from: f */
    public final void m15744f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.f36637x.m15709b(true);
    }

    /* renamed from: g */
    public final void m15743g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.f36637x.m15709b(false);
    }

    /* renamed from: h */
    public final synchronized void m15742h() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    C12820al.m15878a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    C12828ap.m15822b(5000L);
                    i = i2;
                } catch (Throwable th) {
                    if (C12820al.m15877a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: i */
    public final boolean m15741i() {
        return this.f36637x.f36681a.get();
    }

    /* renamed from: j */
    public final boolean m15740j() {
        return (this.f36629B & 16) > 0;
    }

    /* renamed from: k */
    public final boolean m15739k() {
        return (this.f36629B & 8) > 0;
    }

    /* renamed from: a */
    public static synchronized C12848at m15753a(Context context, boolean z, BUGLY.C12768a c12768a) {
        C12848at c12848at;
        synchronized (C12848at.class) {
            if (f36610D == null) {
                f36610D = new C12848at(context, C12818ak.m15887a(), z, c12768a);
            }
            c12848at = f36610D;
        }
        return c12848at;
    }

    /* renamed from: b */
    public final synchronized void m15749b() {
        this.f36633t.m15733a();
        m15745e();
        m15744f();
    }

    /* renamed from: a */
    public static synchronized C12848at m15755a() {
        C12848at c12848at;
        synchronized (C12848at.class) {
            c12848at = f36610D;
        }
        return c12848at;
    }

    /* renamed from: a */
    public final synchronized void m15750a(boolean z, boolean z2, boolean z3) {
        this.f36634u.testNativeCrash(z, z2, z3);
    }

    /* renamed from: a */
    public final void m15752a(CrashDetailBean crashDetailBean) {
        this.f36632s.m15771b(crashDetailBean);
    }

    /* renamed from: a */
    public final void m15754a(long j) {
        C12818ak.m15887a().m15885a(new Thread() { // from class: com.tencent.bugly.proguard.at.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                ArrayList arrayList;
                if (!C12828ap.m15843a(C12848at.this.f36631c, "local_crash_lock")) {
                    C12820al.m15874c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                C12808ag m15914a = C12808ag.C12810a.m15914a();
                List<C12808ag.C12811b> m15923a = C12808ag.m15923a();
                if (m15923a != null && !m15923a.isEmpty()) {
                    C12820al.m15874c("sla load local data list size:%s", Integer.valueOf(m15923a.size()));
                    Iterator<C12808ag.C12811b> it = m15923a.iterator();
                    ArrayList arrayList2 = new ArrayList();
                    while (it.hasNext()) {
                        C12808ag.C12811b next = it.next();
                        if (next.f36496b < C12828ap.m15823b() - C2624bk.f8680d) {
                            C12820al.m15874c("sla local data is expired:%s", next.f36497c);
                            arrayList2.add(next);
                            it.remove();
                        }
                    }
                    C12808ag.m15916d(arrayList2);
                    m15914a.m15918b(m15923a);
                } else {
                    C12820al.m15874c("sla local data is null", new Object[0]);
                }
                List<CrashDetailBean> m15798a = C12832as.m15798a();
                if (m15798a != null && m15798a.size() > 0) {
                    C12820al.m15874c("Size of crash list: %s", Integer.valueOf(m15798a.size()));
                    int size = m15798a.size();
                    if (size > 20) {
                        ArrayList arrayList3 = new ArrayList();
                        Collections.sort(m15798a);
                        for (int i = 0; i < 20; i++) {
                            arrayList3.add(m15798a.get((size - 1) - i));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = m15798a;
                    }
                    C12848at.this.f36632s.m15778a(arrayList, 0L, false, false, false);
                } else {
                    C12820al.m15874c("no crash need to be uploaded at this start", new Object[0]);
                }
                C12828ap.m15821b(C12848at.this.f36631c, "local_crash_lock");
            }
        }, j);
    }
}
