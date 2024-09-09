package com.qq.e.comm.plugin.e.i;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.e.g;
import com.qq.e.comm.plugin.e.h;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.rewardvideo.l;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o2;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.plugin.util.p0;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements d {

    /* renamed from: g  reason: collision with root package name */
    private static final String f42724g = "a";

    /* renamed from: h  reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, WeakReference<View>> f42725h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicBoolean f42726i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f42727j;

    /* renamed from: k  reason: collision with root package name */
    private static final long f42728k;

    /* renamed from: l  reason: collision with root package name */
    private static final g f42729l;

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f42730a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.e.c f42731b = new com.qq.e.comm.plugin.e.c();

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.e.c f42732c = new com.qq.e.comm.plugin.e.c();

    /* renamed from: d  reason: collision with root package name */
    private final f f42733d;

    /* renamed from: e  reason: collision with root package name */
    private final e f42734e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.e.l.c f42735f;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class C0805a implements p.h {
        C0805a() {
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            if (a.f42725h.isEmpty()) {
                return false;
            }
            a.j();
            return false;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e();
        }
    }

    static {
        f42727j = com.qq.e.comm.plugin.d0.a.d().f().a("asdcvcr", 1) == 1;
        f42728k = com.qq.e.comm.plugin.d0.a.d().f().a("asdcvt", 10) * 100;
        f42729l = new h(com.qq.e.comm.plugin.d0.a.d().a());
        p.b().a(new C0805a());
    }

    public a(int i4, View view, com.qq.e.comm.plugin.g0.e eVar) {
        this.f42730a = eVar;
        f42725h.put(Integer.valueOf(i4), new WeakReference<>(view));
        j();
        this.f42733d = new f(view, eVar, this, 0);
        this.f42734e = new e(view.getContext(), this);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        if (i()) {
            if (!f42729l.b()) {
                f42729l.start();
            }
        } else if (f42729l.b()) {
            f42729l.stop();
        }
        if (p.b().c() && !f42725h.isEmpty()) {
            p0.a(new c(), f42728k);
        } else {
            f42726i.set(false);
        }
    }

    private static boolean i() {
        d1.a(f42724g, "checking visibility");
        for (Map.Entry<Integer, WeakReference<View>> entry : f42725h.entrySet()) {
            Integer key = entry.getKey();
            View view = entry.getValue().get();
            if (view != null) {
                if (o2.a(view.getContext(), view, 1, true) && (!f42727j || !((Boolean) o2.a(view, 100).first).booleanValue())) {
                    return true;
                }
            } else {
                f42725h.remove(key);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        if (p.b().c() && f42726i.compareAndSet(false, true)) {
            p0.a((Runnable) new b());
        }
    }

    public void a(int i4) {
        this.f42732c.Y = String.valueOf(i4);
    }

    public void f(int i4) {
        this.f42732c.f42662c0 = String.valueOf(i4);
    }

    public com.qq.e.comm.plugin.g0.e g() {
        return this.f42730a;
    }

    public com.qq.e.comm.plugin.e.c h() {
        return this.f42732c;
    }

    private void f() {
        y i02 = this.f42730a.i0();
        if (i02 != null) {
            this.f42732c.N0 = i02.q();
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f42732c.I0 = jSONArray.toString();
        }
    }

    public void b(int i4) {
        if (i4 == -999) {
            this.f42732c.Z = String.valueOf(-999);
        } else if (i4 > 0) {
            this.f42732c.Z = String.valueOf(i4);
        } else {
            this.f42732c.Z = "";
        }
    }

    public void c(int i4) {
        this.f42732c.O0 = i4 == 0 ? "" : String.valueOf(i4);
    }

    public void d(int i4) {
        this.f42732c.f42668f0 = String.valueOf(i4);
    }

    public void g(int i4) {
        f42725h.remove(Integer.valueOf(i4));
    }

    public void a(long j4) {
        if (j4 <= 0) {
            this.f42732c.J0 = String.valueOf(-999);
            return;
        }
        this.f42732c.J0 = String.valueOf(j4);
    }

    public void a(float[] fArr) {
        if (fArr != null && fArr.length >= 3) {
            com.qq.e.comm.plugin.e.c cVar = this.f42732c;
            cVar.f42670g0 = ((int) (fArr[0] * 100.0f)) + "," + ((int) (fArr[1] * 100.0f)) + "," + ((int) (fArr[2] * 100.0f));
            return;
        }
        this.f42732c.f42670g0 = String.valueOf(-999);
    }

    public void b(boolean z3) {
        this.f42732c.K0 = z3 ? "1" : "-1";
    }

    public void b(String str) {
        try {
            this.f42735f = (com.qq.e.comm.plugin.e.l.c) Class.forName("com.qq.e.comm.plugin.e.d").newInstance();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.qq.e.comm.plugin.e.l.c cVar = this.f42735f;
        if (cVar != null) {
            cVar.a(str, this.f42731b, com.qq.e.comm.plugin.e.b.f42654a);
        }
    }

    public void a(int[] iArr, long j4) {
        if (iArr != null && iArr.length == 3) {
            this.f42732c.f42672h0 = String.valueOf(iArr[0]);
            this.f42732c.f42674i0 = String.valueOf(iArr[1]);
            this.f42732c.f42676j0 = String.valueOf(iArr[2]);
        }
        this.f42732c.f42678k0 = String.valueOf(j4);
    }

    public void e(int i4) {
        this.f42732c.f42660b0 = String.valueOf(i4);
    }

    public void a(boolean z3) {
        this.f42732c.f42680l0 = z3 ? "1" : "0";
    }

    public void a(MotionEvent motionEvent, boolean z3) {
        a(motionEvent, z3, 0, 0);
    }

    public void a(MotionEvent motionEvent, boolean z3, int i4, int i5) {
        this.f42733d.a(motionEvent, z3, this.f42731b, i4, i5);
        this.f42734e.a(motionEvent, z3, this.f42731b, i4, i5);
    }

    public void a(String str) {
        com.qq.e.comm.plugin.e.c cVar = this.f42732c;
        if (str == null) {
            str = "";
        }
        cVar.H0 = str;
    }

    @Override // com.qq.e.comm.plugin.e.i.d
    public com.qq.e.comm.plugin.e.c a() {
        y i02;
        String G0 = this.f42730a.G0();
        if (!TextUtils.isEmpty(G0)) {
            com.qq.e.comm.plugin.e.c cVar = this.f42731b;
            cVar.W = G0;
            cVar.X = String.valueOf(this.f42730a.H0());
            Set<String> a4 = com.qq.e.comm.plugin.dl.c.a(this.f42730a);
            this.f42731b.f42658a0 = a4.isEmpty() ? "0" : "1";
        }
        this.f42731b.f42662c0 = String.valueOf(TextUtils.isEmpty(this.f42730a.L0()) ? 2 : 1);
        this.f42731b.f42680l0 = String.valueOf(this.f42730a.e1() ? 1 : 0);
        com.qq.e.comm.plugin.b.g o4 = this.f42730a.o();
        if (!o4.j() && (!o4.g() || !this.f42730a.h1())) {
            this.f42731b.f42682m0 = "0";
        } else {
            this.f42731b.f42682m0 = "1";
        }
        if (o4.j() && (i02 = this.f42730a.i0()) != null) {
            int p3 = i02.p();
            this.f42731b.P0 = String.valueOf(p3);
            this.f42731b.O0 = l.d(p3) ? "1" : "-1";
        }
        int[] a5 = f42729l.a();
        if (a5 != null) {
            this.f42731b.N = String.valueOf(a5[0]);
            this.f42731b.O = String.valueOf(a5[1]);
        }
        this.f42732c.f42666e0 = "1";
        this.f42731b.f42699v = String.valueOf(this.f42730a.u0());
        return this.f42731b;
    }
}
