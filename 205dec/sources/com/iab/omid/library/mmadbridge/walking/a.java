package com.iab.omid.library.mmadbridge.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.c.a;
import com.iab.omid.library.mmadbridge.d.f;
import com.iab.omid.library.mmadbridge.walking.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements a.InterfaceC0547a {

    /* renamed from: i  reason: collision with root package name */
    private static a f37764i = new a();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f37765j = new Handler(Looper.getMainLooper());

    /* renamed from: k  reason: collision with root package name */
    private static Handler f37766k = null;

    /* renamed from: l  reason: collision with root package name */
    private static final Runnable f37767l = new b();

    /* renamed from: m  reason: collision with root package name */
    private static final Runnable f37768m = new c();

    /* renamed from: b  reason: collision with root package name */
    private int f37770b;

    /* renamed from: h  reason: collision with root package name */
    private long f37776h;

    /* renamed from: a  reason: collision with root package name */
    private List<e> f37769a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f37771c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<o0.a> f37772d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.walking.b f37774f = new com.iab.omid.library.mmadbridge.walking.b();

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.c.b f37773e = new com.iab.omid.library.mmadbridge.c.b();

    /* renamed from: g  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.walking.d f37775g = new com.iab.omid.library.mmadbridge.walking.d(new b.d());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class RunnableC0549a implements Runnable {
        RunnableC0549a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f37775g.a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.q().r();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f37766k != null) {
                a.f37766k.post(a.f37767l);
                a.f37766k.postDelayed(a.f37768m, 200L);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface d extends e {
        void a(int i4, long j4);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface e {
        void b(int i4, long j4);
    }

    a() {
    }

    private void d(long j4) {
        if (this.f37769a.size() > 0) {
            for (e eVar : this.f37769a) {
                eVar.b(this.f37770b, TimeUnit.NANOSECONDS.toMillis(j4));
                if (eVar instanceof d) {
                    ((d) eVar).a(this.f37770b, j4);
                }
            }
        }
    }

    private void e(View view, com.iab.omid.library.mmadbridge.c.a aVar, JSONObject jSONObject, com.iab.omid.library.mmadbridge.walking.c cVar, boolean z3) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, z3);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.mmadbridge.c.a b4 = this.f37773e.b();
        String b5 = this.f37774f.b(str);
        if (b5 != null) {
            JSONObject a4 = b4.a(view);
            com.iab.omid.library.mmadbridge.d.b.g(a4, str);
            com.iab.omid.library.mmadbridge.d.b.l(a4, b5);
            com.iab.omid.library.mmadbridge.d.b.i(jSONObject, a4);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        String a4 = this.f37774f.a(view);
        if (a4 != null) {
            com.iab.omid.library.mmadbridge.d.b.g(jSONObject, a4);
            com.iab.omid.library.mmadbridge.d.b.f(jSONObject, Boolean.valueOf(this.f37774f.l(view)));
            this.f37774f.n();
            return true;
        }
        return false;
    }

    private boolean k(View view, JSONObject jSONObject) {
        b.a g4 = this.f37774f.g(view);
        if (g4 != null) {
            com.iab.omid.library.mmadbridge.d.b.e(jSONObject, g4);
            return true;
        }
        return false;
    }

    public static a q() {
        return f37764i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        s();
        m();
        t();
    }

    private void s() {
        this.f37770b = 0;
        this.f37772d.clear();
        this.f37771c = false;
        Iterator<h> it = com.iab.omid.library.mmadbridge.b.a.a().e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().r()) {
                this.f37771c = true;
                break;
            }
        }
        this.f37776h = com.iab.omid.library.mmadbridge.d.d.a();
    }

    private void t() {
        d(com.iab.omid.library.mmadbridge.d.d.a() - this.f37776h);
    }

    private void u() {
        if (f37766k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f37766k = handler;
            handler.post(f37767l);
            f37766k.postDelayed(f37768m, 200L);
        }
    }

    private void v() {
        Handler handler = f37766k;
        if (handler != null) {
            handler.removeCallbacks(f37768m);
            f37766k = null;
        }
    }

    @Override // com.iab.omid.library.mmadbridge.c.a.InterfaceC0547a
    public void a(View view, com.iab.omid.library.mmadbridge.c.a aVar, JSONObject jSONObject, boolean z3) {
        com.iab.omid.library.mmadbridge.walking.c i4;
        if (f.d(view) && (i4 = this.f37774f.i(view)) != com.iab.omid.library.mmadbridge.walking.c.UNDERLYING_VIEW) {
            JSONObject a4 = aVar.a(view);
            com.iab.omid.library.mmadbridge.d.b.i(jSONObject, a4);
            if (!g(view, a4)) {
                boolean z4 = z3 || k(view, a4);
                if (this.f37771c && i4 == com.iab.omid.library.mmadbridge.walking.c.OBSTRUCTION_VIEW && !z4) {
                    this.f37772d.add(new o0.a(view));
                }
                e(view, aVar, a4, i4, z4);
            }
            this.f37770b++;
        }
    }

    public void c() {
        u();
    }

    public void h(e eVar) {
        if (this.f37769a.contains(eVar)) {
            return;
        }
        this.f37769a.add(eVar);
    }

    public void i() {
        l();
        this.f37769a.clear();
        f37765j.post(new RunnableC0549a());
    }

    public void l() {
        v();
    }

    @VisibleForTesting
    void m() {
        this.f37774f.j();
        long a4 = com.iab.omid.library.mmadbridge.d.d.a();
        com.iab.omid.library.mmadbridge.c.a a5 = this.f37773e.a();
        if (this.f37774f.h().size() > 0) {
            Iterator<String> it = this.f37774f.h().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a6 = a5.a(null);
                f(next, this.f37774f.f(next), a6);
                com.iab.omid.library.mmadbridge.d.b.d(a6);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.f37775g.c(a6, hashSet, a4);
            }
        }
        if (this.f37774f.c().size() > 0) {
            JSONObject a7 = a5.a(null);
            e(null, a5, a7, com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.mmadbridge.d.b.d(a7);
            this.f37775g.b(a7, this.f37774f.c(), a4);
            if (this.f37771c) {
                for (h hVar : com.iab.omid.library.mmadbridge.b.a.a().e()) {
                    hVar.o(this.f37772d);
                }
            }
        } else {
            this.f37775g.a();
        }
        this.f37774f.k();
    }

    public void w(e eVar) {
        if (this.f37769a.contains(eVar)) {
            this.f37769a.remove(eVar);
        }
    }
}
