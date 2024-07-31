package com.iab.omid.library.mmadbridge.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7085a;
import com.iab.omid.library.mmadbridge.p203c.C7096b;
import com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7104d;
import com.iab.omid.library.mmadbridge.p204d.C7106f;
import com.iab.omid.library.mmadbridge.walking.C7119b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p626o0.C15395a;

/* renamed from: com.iab.omid.library.mmadbridge.walking.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7113a implements InterfaceC7094a.InterfaceC7095a {

    /* renamed from: i */
    private static C7113a f24282i = new C7113a();

    /* renamed from: j */
    private static Handler f24283j = new Handler(Looper.getMainLooper());

    /* renamed from: k */
    private static Handler f24284k = null;

    /* renamed from: l */
    private static final Runnable f24285l = new RunnableC7115b();

    /* renamed from: m */
    private static final Runnable f24286m = new RunnableC7116c();

    /* renamed from: b */
    private int f24288b;

    /* renamed from: h */
    private long f24294h;

    /* renamed from: a */
    private List<InterfaceC7118e> f24287a = new ArrayList();

    /* renamed from: c */
    private boolean f24289c = false;

    /* renamed from: d */
    private final List<C15395a> f24290d = new ArrayList();

    /* renamed from: f */
    private C7119b f24292f = new C7119b();

    /* renamed from: e */
    private C7096b f24291e = new C7096b();

    /* renamed from: g */
    private C7130d f24293g = new C7130d(new C7119b.C7125d());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class RunnableC7114a implements Runnable {
        RunnableC7114a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7113a.this.f24293g.m34570a();
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class RunnableC7115b implements Runnable {
        RunnableC7115b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7113a.m34608q().m34607r();
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class RunnableC7116c implements Runnable {
        RunnableC7116c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7113a.f24284k != null) {
                C7113a.f24284k.post(C7113a.f24285l);
                C7113a.f24284k.postDelayed(C7113a.f24286m, 200L);
            }
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7117d extends InterfaceC7118e {
        /* renamed from: a */
        void m34601a(int i, long j);
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.a$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7118e {
        /* renamed from: b */
        void m34600b(int i, long j);
    }

    C7113a() {
    }

    /* renamed from: d */
    private void m34621d(long j) {
        if (this.f24287a.size() > 0) {
            for (InterfaceC7118e interfaceC7118e : this.f24287a) {
                interfaceC7118e.m34600b(this.f24288b, TimeUnit.NANOSECONDS.toMillis(j));
                if (interfaceC7118e instanceof InterfaceC7117d) {
                    ((InterfaceC7117d) interfaceC7118e).m34601a(this.f24288b, j);
                }
            }
        }
    }

    /* renamed from: e */
    private void m34620e(View view, InterfaceC7094a interfaceC7094a, JSONObject jSONObject, EnumC7129c enumC7129c, boolean z) {
        interfaceC7094a.mo34707a(view, jSONObject, this, enumC7129c == EnumC7129c.PARENT_VIEW, z);
    }

    /* renamed from: f */
    private void m34619f(String str, View view, JSONObject jSONObject) {
        InterfaceC7094a m34710b = this.f24291e.m34710b();
        String m34598b = this.f24292f.m34598b(str);
        if (m34598b != null) {
            JSONObject mo34708a = m34710b.mo34708a(view);
            C7101b.m34689g(mo34708a, str);
            C7101b.m34684l(mo34708a, m34598b);
            C7101b.m34687i(jSONObject, mo34708a);
        }
    }

    /* renamed from: g */
    private boolean m34618g(View view, JSONObject jSONObject) {
        String m34599a = this.f24292f.m34599a(view);
        if (m34599a != null) {
            C7101b.m34689g(jSONObject, m34599a);
            C7101b.m34690f(jSONObject, Boolean.valueOf(this.f24292f.m34588l(view)));
            this.f24292f.m34586n();
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private boolean m34614k(View view, JSONObject jSONObject) {
        C7119b.C7120a m34593g = this.f24292f.m34593g(view);
        if (m34593g != null) {
            C7101b.m34691e(jSONObject, m34593g);
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public static C7113a m34608q() {
        return f24282i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m34607r() {
        m34606s();
        m34612m();
        m34605t();
    }

    /* renamed from: s */
    private void m34606s() {
        this.f24288b = 0;
        this.f24290d.clear();
        this.f24289c = false;
        Iterator<C7081h> it = C7085a.m34757a().m34753e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().m34790r()) {
                this.f24289c = true;
                break;
            }
        }
        this.f24294h = C7104d.m34675a();
    }

    /* renamed from: t */
    private void m34605t() {
        m34621d(C7104d.m34675a() - this.f24294h);
    }

    /* renamed from: u */
    private void m34604u() {
        if (f24284k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f24284k = handler;
            handler.post(f24285l);
            f24284k.postDelayed(f24286m, 200L);
        }
    }

    /* renamed from: v */
    private void m34603v() {
        Handler handler = f24284k;
        if (handler != null) {
            handler.removeCallbacks(f24286m);
            f24284k = null;
        }
    }

    @Override // com.iab.omid.library.mmadbridge.p203c.InterfaceC7094a.InterfaceC7095a
    /* renamed from: a */
    public void mo34624a(View view, InterfaceC7094a interfaceC7094a, JSONObject jSONObject, boolean z) {
        EnumC7129c m34591i;
        if (C7106f.m34658d(view) && (m34591i = this.f24292f.m34591i(view)) != EnumC7129c.UNDERLYING_VIEW) {
            JSONObject mo34708a = interfaceC7094a.mo34708a(view);
            C7101b.m34687i(jSONObject, mo34708a);
            if (!m34618g(view, mo34708a)) {
                boolean z2 = z || m34614k(view, mo34708a);
                if (this.f24289c && m34591i == EnumC7129c.OBSTRUCTION_VIEW && !z2) {
                    this.f24290d.add(new C15395a(view));
                }
                m34620e(view, interfaceC7094a, mo34708a, m34591i, z2);
            }
            this.f24288b++;
        }
    }

    /* renamed from: c */
    public void m34622c() {
        m34604u();
    }

    /* renamed from: h */
    public void m34617h(InterfaceC7118e interfaceC7118e) {
        if (this.f24287a.contains(interfaceC7118e)) {
            return;
        }
        this.f24287a.add(interfaceC7118e);
    }

    /* renamed from: i */
    public void m34616i() {
        m34613l();
        this.f24287a.clear();
        f24283j.post(new RunnableC7114a());
    }

    /* renamed from: l */
    public void m34613l() {
        m34603v();
    }

    @VisibleForTesting
    /* renamed from: m */
    void m34612m() {
        this.f24292f.m34590j();
        long m34675a = C7104d.m34675a();
        InterfaceC7094a m34711a = this.f24291e.m34711a();
        if (this.f24292f.m34592h().size() > 0) {
            Iterator<String> it = this.f24292f.m34592h().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject mo34708a = m34711a.mo34708a(null);
                m34619f(next, this.f24292f.m34594f(next), mo34708a);
                C7101b.m34692d(mo34708a);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.f24293g.m34566c(mo34708a, hashSet, m34675a);
            }
        }
        if (this.f24292f.m34597c().size() > 0) {
            JSONObject mo34708a2 = m34711a.mo34708a(null);
            m34620e(null, m34711a, mo34708a2, EnumC7129c.PARENT_VIEW, false);
            C7101b.m34692d(mo34708a2);
            this.f24293g.m34567b(mo34708a2, this.f24292f.m34597c(), m34675a);
            if (this.f24289c) {
                for (C7081h c7081h : C7085a.m34757a().m34753e()) {
                    c7081h.m34793o(this.f24290d);
                }
            }
        } else {
            this.f24293g.m34570a();
        }
        this.f24292f.m34589k();
    }

    /* renamed from: w */
    public void m34602w(InterfaceC7118e interfaceC7118e) {
        if (this.f24287a.contains(interfaceC7118e)) {
            this.f24287a.remove(interfaceC7118e);
        }
    }
}
