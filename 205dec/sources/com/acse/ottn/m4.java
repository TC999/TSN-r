package com.acse.ottn;

import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.g4;
import com.acse.ottn.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m4 extends j4 {

    /* renamed from: o  reason: collision with root package name */
    public static final int f5947o = 0;

    /* renamed from: p  reason: collision with root package name */
    public static final int f5948p = 1;

    /* renamed from: q  reason: collision with root package name */
    public static final int f5949q = 2;

    /* renamed from: r  reason: collision with root package name */
    public static final int f5950r = 4;

    /* renamed from: s  reason: collision with root package name */
    public static final int f5951s = 8;

    /* renamed from: t  reason: collision with root package name */
    public static final int f5952t = 16;

    /* renamed from: u  reason: collision with root package name */
    public static final int f5953u = 32;

    /* renamed from: v  reason: collision with root package name */
    public static final int f5954v = 64;

    /* renamed from: w  reason: collision with root package name */
    public static final int f5955w = 128;

    /* renamed from: x  reason: collision with root package name */
    public static final int f5956x = 256;

    /* renamed from: y  reason: collision with root package name */
    public static final int f5957y = 512;

    /* renamed from: z  reason: collision with root package name */
    public static final int f5958z = 511;

    /* renamed from: b  reason: collision with root package name */
    public final l f5959b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<View> f5960c;

    /* renamed from: d  reason: collision with root package name */
    public long f5961d;

    /* renamed from: h  reason: collision with root package name */
    public Interpolator f5965h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5962e = false;

    /* renamed from: f  reason: collision with root package name */
    public long f5963f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5964g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5966i = false;

    /* renamed from: j  reason: collision with root package name */
    public i.a f5967j = null;

    /* renamed from: k  reason: collision with root package name */
    public b f5968k = new b(this, null);

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<c> f5969l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public Runnable f5970m = new a();

    /* renamed from: n  reason: collision with root package name */
    public HashMap<i, d> f5971n = new HashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m4.this.e();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements i.a, g4.g {
        public b() {
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (m4.this.f5967j != null) {
                m4.this.f5967j.a(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (m4.this.f5967j != null) {
                m4.this.f5967j.b(iVar);
            }
            m4.this.f5971n.remove(iVar);
            if (m4.this.f5971n.isEmpty()) {
                m4.this.f5967j = null;
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
            if (m4.this.f5967j != null) {
                m4.this.f5967j.c(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            if (m4.this.f5967j != null) {
                m4.this.f5967j.d(iVar);
            }
        }

        public /* synthetic */ b(m4 m4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.g4.g
        public void a(g4 g4Var) {
            View view;
            float u3 = g4Var.u();
            d dVar = (d) m4.this.f5971n.get(g4Var);
            if ((dVar.f5977a & 511) != 0 && (view = (View) m4.this.f5960c.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f5978b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    c cVar = arrayList.get(i4);
                    m4.this.c(cVar.f5974a, cVar.f5975b + (cVar.f5976c * u3));
                }
            }
            View view2 = (View) m4.this.f5960c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f5974a;

        /* renamed from: b  reason: collision with root package name */
        public float f5975b;

        /* renamed from: c  reason: collision with root package name */
        public float f5976c;

        public c(int i4, float f4, float f5) {
            this.f5974a = i4;
            this.f5975b = f4;
            this.f5976c = f5;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f5977a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c> f5978b;

        public d(int i4, ArrayList<c> arrayList) {
            this.f5977a = i4;
            this.f5978b = arrayList;
        }

        public boolean a(int i4) {
            ArrayList<c> arrayList;
            if ((this.f5977a & i4) != 0 && (arrayList = this.f5978b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f5978b.get(i5).f5974a == i4) {
                        this.f5978b.remove(i5);
                        this.f5977a = (i4 ^ (-1)) & this.f5977a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public m4(View view) {
        this.f5960c = new WeakReference<>(view);
        this.f5959b = l.a(view);
    }

    @Override // com.acse.ottn.j4
    public j4 e(float f4) {
        a(32, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 f(float f4) {
        b(32, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 g(float f4) {
        a(64, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 h(float f4) {
        b(64, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 i(float f4) {
        a(4, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 j(float f4) {
        b(4, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 k(float f4) {
        a(8, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 l(float f4) {
        b(8, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 m(float f4) {
        a(1, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 n(float f4) {
        b(1, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 o(float f4) {
        a(2, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 p(float f4) {
        b(2, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 q(float f4) {
        a(128, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 r(float f4) {
        b(128, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 s(float f4) {
        a(256, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 t(float f4) {
        b(256, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public long b() {
        if (this.f5962e) {
            return this.f5961d;
        }
        return new g4().c();
    }

    @Override // com.acse.ottn.j4
    public long c() {
        if (this.f5964g) {
            return this.f5963f;
        }
        return 0L;
    }

    @Override // com.acse.ottn.j4
    public void d() {
        e();
    }

    public final void e() {
        g4 a4 = g4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f5969l.clone();
        this.f5969l.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((c) arrayList.get(i5)).f5974a;
        }
        this.f5971n.put(a4, new d(i4, arrayList));
        a4.a((g4.g) this.f5968k);
        a4.a((i.a) this.f5968k);
        if (this.f5964g) {
            a4.b(this.f5963f);
        }
        if (this.f5962e) {
            a4.a(this.f5961d);
        }
        if (this.f5966i) {
            a4.a(this.f5965h);
        }
        a4.k();
    }

    @Override // com.acse.ottn.j4
    public j4 d(float f4) {
        b(16, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 a(long j4) {
        if (j4 >= 0) {
            this.f5962e = true;
            this.f5961d = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.j4
    public j4 c(float f4) {
        a(16, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 b(long j4) {
        if (j4 >= 0) {
            this.f5964g = true;
            this.f5963f = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    public final void c(int i4, float f4) {
        if (i4 == 1) {
            this.f5959b.i(f4);
        } else if (i4 == 2) {
            this.f5959b.j(f4);
        } else if (i4 == 4) {
            this.f5959b.g(f4);
        } else if (i4 == 8) {
            this.f5959b.h(f4);
        } else if (i4 == 16) {
            this.f5959b.d(f4);
        } else if (i4 == 32) {
            this.f5959b.e(f4);
        } else if (i4 == 64) {
            this.f5959b.f(f4);
        } else if (i4 == 128) {
            this.f5959b.k(f4);
        } else if (i4 == 256) {
            this.f5959b.l(f4);
        } else if (i4 != 512) {
        } else {
            this.f5959b.a(f4);
        }
    }

    @Override // com.acse.ottn.j4
    public j4 a(Interpolator interpolator) {
        this.f5966i = true;
        this.f5965h = interpolator;
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 b(float f4) {
        b(512, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 a(i.a aVar) {
        this.f5967j = aVar;
        return this;
    }

    public final void b(int i4, float f4) {
        a(i4, a(i4), f4);
    }

    @Override // com.acse.ottn.j4
    public void a() {
        if (this.f5971n.size() > 0) {
            for (i iVar : ((HashMap) this.f5971n.clone()).keySet()) {
                iVar.cancel();
            }
        }
        this.f5969l.clear();
        View view = this.f5960c.get();
        if (view != null) {
            view.removeCallbacks(this.f5970m);
        }
    }

    @Override // com.acse.ottn.j4
    public j4 a(float f4) {
        a(512, f4);
        return this;
    }

    public final void a(int i4, float f4) {
        float a4 = a(i4);
        a(i4, a4, f4 - a4);
    }

    public final void a(int i4, float f4, float f5) {
        if (this.f5971n.size() > 0) {
            i iVar = null;
            Iterator<i> it = this.f5971n.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                d dVar = this.f5971n.get(next);
                if (dVar.a(i4) && dVar.f5977a == 0) {
                    iVar = next;
                    break;
                }
            }
            if (iVar != null) {
                iVar.cancel();
            }
        }
        this.f5969l.add(new c(i4, f4, f5));
        View view = this.f5960c.get();
        if (view != null) {
            view.removeCallbacks(this.f5970m);
            view.post(this.f5970m);
        }
    }

    public final float a(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 16) {
                            if (i4 != 32) {
                                if (i4 != 64) {
                                    if (i4 != 128) {
                                        if (i4 != 256) {
                                            if (i4 != 512) {
                                                return 0.0f;
                                            }
                                            return this.f5959b.a();
                                        }
                                        return this.f5959b.n();
                                    }
                                    return this.f5959b.m();
                                }
                                return this.f5959b.f();
                            }
                            return this.f5959b.e();
                        }
                        return this.f5959b.d();
                    }
                    return this.f5959b.h();
                }
                return this.f5959b.g();
            }
            return this.f5959b.l();
        }
        return this.f5959b.k();
    }
}
