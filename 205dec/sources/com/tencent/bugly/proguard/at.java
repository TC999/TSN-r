package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class at {
    private static at D = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f50984a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50985b = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f50986d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f50987e = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f50988f = 20480;

    /* renamed from: g  reason: collision with root package name */
    public static int f50989g = 3000;

    /* renamed from: h  reason: collision with root package name */
    public static int f50990h = 20480;

    /* renamed from: i  reason: collision with root package name */
    public static long f50991i = 209715200;

    /* renamed from: j  reason: collision with root package name */
    public static long f50992j = 604800000;

    /* renamed from: k  reason: collision with root package name */
    public static String f50993k = null;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f50994l = false;

    /* renamed from: m  reason: collision with root package name */
    public static String f50995m = null;

    /* renamed from: n  reason: collision with root package name */
    public static int f50996n = 5000;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f50997o = true;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f50998p;

    /* renamed from: q  reason: collision with root package name */
    public static String f50999q;

    /* renamed from: r  reason: collision with root package name */
    public static String f51000r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;

    /* renamed from: c  reason: collision with root package name */
    public final Context f51001c;

    /* renamed from: s  reason: collision with root package name */
    public final as f51002s;

    /* renamed from: t  reason: collision with root package name */
    public final av f51003t;

    /* renamed from: u  reason: collision with root package name */
    public final NativeCrashHandler f51004u;

    /* renamed from: v  reason: collision with root package name */
    public final ac f51005v;

    /* renamed from: w  reason: collision with root package name */
    public final ak f51006w;

    /* renamed from: x  reason: collision with root package name */
    public final ay f51007x;

    /* renamed from: y  reason: collision with root package name */
    public BuglyStrategy.a f51008y;

    /* renamed from: z  reason: collision with root package name */
    public aw f51009z;

    private at(Context context, ak akVar, boolean z3, BuglyStrategy.a aVar) {
        f50984a = 1004;
        Context a4 = ap.a(context);
        this.f51001c = a4;
        ac a5 = ac.a();
        this.f51005v = a5;
        this.f51006w = akVar;
        this.f51008y = aVar;
        this.f51009z = null;
        as asVar = new as(a4, ai.a(), w.a(), a5, aVar);
        this.f51002s = asVar;
        aa a6 = aa.a(a4);
        this.f51003t = new av(a4, asVar, a5, a6);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a4, a6, asVar, a5, akVar, z3, null);
        this.f51004u = nativeCrashHandler;
        a6.N = nativeCrashHandler;
        if (ay.f51050f == null) {
            ay.f51050f = new ay(a4, a5, a6, akVar, asVar);
        }
        this.f51007x = ay.f51050f;
    }

    public final synchronized void c() {
        this.f51003t.b();
        d();
        g();
    }

    public final void d() {
        this.f51004u.setUserOpened(false);
    }

    public final void e() {
        this.f51004u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.f51007x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.at.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.f51007x.b(false);
    }

    public final synchronized void h() {
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i4 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i5));
                    ap.b(5000L);
                    i4 = i5;
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean i() {
        return this.f51007x.f51051a.get();
    }

    public final boolean j() {
        return (this.B & 16) > 0;
    }

    public final boolean k() {
        return (this.B & 8) > 0;
    }

    public static synchronized at a(Context context, boolean z3, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            if (D == null) {
                D = new at(context, ak.a(), z3, aVar);
            }
            atVar = D;
        }
        return atVar;
    }

    public final synchronized void b() {
        this.f51003t.a();
        e();
        f();
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            atVar = D;
        }
        return atVar;
    }

    public final synchronized void a(boolean z3, boolean z4, boolean z5) {
        this.f51004u.testNativeCrash(z3, z4, z5);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f51002s.b(crashDetailBean);
    }

    public final void a(long j4) {
        ak.a().a(new Thread() { // from class: com.tencent.bugly.proguard.at.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                ArrayList arrayList;
                if (!ap.a(at.this.f51001c, "local_crash_lock")) {
                    al.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                ag a4 = ag.a.a();
                List<ag.b> a5 = ag.a();
                if (a5 != null && !a5.isEmpty()) {
                    al.c("sla load local data list size:%s", Integer.valueOf(a5.size()));
                    Iterator<ag.b> it = a5.iterator();
                    ArrayList arrayList2 = new ArrayList();
                    while (it.hasNext()) {
                        ag.b next = it.next();
                        if (next.f50870b < ap.b() - 604800000) {
                            al.c("sla local data is expired:%s", next.f50871c);
                            arrayList2.add(next);
                            it.remove();
                        }
                    }
                    ag.d(arrayList2);
                    a4.b(a5);
                } else {
                    al.c("sla local data is null", new Object[0]);
                }
                List<CrashDetailBean> a6 = as.a();
                if (a6 != null && a6.size() > 0) {
                    al.c("Size of crash list: %s", Integer.valueOf(a6.size()));
                    int size = a6.size();
                    if (size > 20) {
                        ArrayList arrayList3 = new ArrayList();
                        Collections.sort(a6);
                        for (int i4 = 0; i4 < 20; i4++) {
                            arrayList3.add(a6.get((size - 1) - i4));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = a6;
                    }
                    at.this.f51002s.a(arrayList, 0L, false, false, false);
                } else {
                    al.c("no crash need to be uploaded at this start", new Object[0]);
                }
                ap.b(at.this.f51001c, "local_crash_lock");
            }
        }, j4);
    }
}
