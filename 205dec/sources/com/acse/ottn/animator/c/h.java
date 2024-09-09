package com.acse.ottn.animator.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1361a;
import com.acse.ottn.animator.a.L;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h extends com.acse.ottn.animator.c.b {

    /* renamed from: b  reason: collision with root package name */
    private static final int f5013b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f5014c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f5015d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f5016e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f5017f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final int f5018g = 16;

    /* renamed from: h  reason: collision with root package name */
    private static final int f5019h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static final int f5020i = 64;

    /* renamed from: j  reason: collision with root package name */
    private static final int f5021j = 128;

    /* renamed from: k  reason: collision with root package name */
    private static final int f5022k = 256;

    /* renamed from: l  reason: collision with root package name */
    private static final int f5023l = 512;

    /* renamed from: m  reason: collision with root package name */
    private static final int f5024m = 511;

    /* renamed from: n  reason: collision with root package name */
    private final com.acse.ottn.animator.c.a.a f5025n;

    /* renamed from: o  reason: collision with root package name */
    private final WeakReference<View> f5026o;

    /* renamed from: p  reason: collision with root package name */
    private long f5027p;

    /* renamed from: t  reason: collision with root package name */
    private Interpolator f5031t;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5028q = false;

    /* renamed from: r  reason: collision with root package name */
    private long f5029r = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f5030s = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f5032u = false;

    /* renamed from: v  reason: collision with root package name */
    private AbstractC1361a.InterfaceC0082a f5033v = null;

    /* renamed from: w  reason: collision with root package name */
    private a f5034w = new a(this, null);

    /* renamed from: x  reason: collision with root package name */
    ArrayList<b> f5035x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private Runnable f5036y = new g(this);

    /* renamed from: z  reason: collision with root package name */
    private HashMap<AbstractC1361a, c> f5037z = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements AbstractC1361a.InterfaceC0082a, L.b {
        private a() {
        }

        /* synthetic */ a(h hVar, g gVar) {
            this();
        }

        @Override // com.acse.ottn.animator.a.L.b
        public void a(L l4) {
            View view;
            float r3 = l4.r();
            c cVar = (c) h.this.f5037z.get(l4);
            if ((cVar.f5042a & 511) != 0 && (view = (View) h.this.f5026o.get()) != null) {
                view.invalidate();
            }
            ArrayList<b> arrayList = cVar.f5043b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    b bVar = arrayList.get(i4);
                    h.this.c(bVar.f5039a, bVar.f5040b + (bVar.f5041c * r3));
                }
            }
            View view2 = (View) h.this.f5026o.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void a(AbstractC1361a abstractC1361a) {
            if (h.this.f5033v != null) {
                h.this.f5033v.a(abstractC1361a);
            }
            h.this.f5037z.remove(abstractC1361a);
            if (h.this.f5037z.isEmpty()) {
                h.this.f5033v = null;
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void b(AbstractC1361a abstractC1361a) {
            if (h.this.f5033v != null) {
                h.this.f5033v.b(abstractC1361a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void c(AbstractC1361a abstractC1361a) {
            if (h.this.f5033v != null) {
                h.this.f5033v.c(abstractC1361a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void d(AbstractC1361a abstractC1361a) {
            if (h.this.f5033v != null) {
                h.this.f5033v.d(abstractC1361a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f5039a;

        /* renamed from: b  reason: collision with root package name */
        float f5040b;

        /* renamed from: c  reason: collision with root package name */
        float f5041c;

        b(int i4, float f4, float f5) {
            this.f5039a = i4;
            this.f5040b = f4;
            this.f5041c = f5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        int f5042a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f5043b;

        c(int i4, ArrayList<b> arrayList) {
            this.f5042a = i4;
            this.f5043b = arrayList;
        }

        boolean a(int i4) {
            ArrayList<b> arrayList;
            if ((this.f5042a & i4) != 0 && (arrayList = this.f5043b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f5043b.get(i5).f5039a == i4) {
                        this.f5043b.remove(i5);
                        this.f5042a = (i4 ^ (-1)) & this.f5042a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view) {
        this.f5026o = new WeakReference<>(view);
        this.f5025n = com.acse.ottn.animator.c.a.a.a(view);
    }

    private float a(int i4) {
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
                                            return this.f5025n.a();
                                        }
                                        return this.f5025n.n();
                                    }
                                    return this.f5025n.m();
                                }
                                return this.f5025n.f();
                            }
                            return this.f5025n.e();
                        }
                        return this.f5025n.d();
                    }
                    return this.f5025n.h();
                }
                return this.f5025n.g();
            }
            return this.f5025n.l();
        }
        return this.f5025n.k();
    }

    private void a(int i4, float f4) {
        float a4 = a(i4);
        a(i4, a4, f4 - a4);
    }

    private void a(int i4, float f4, float f5) {
        if (this.f5037z.size() > 0) {
            AbstractC1361a abstractC1361a = null;
            Iterator<AbstractC1361a> it = this.f5037z.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1361a next = it.next();
                c cVar = this.f5037z.get(next);
                if (cVar.a(i4) && cVar.f5042a == 0) {
                    abstractC1361a = next;
                    break;
                }
            }
            if (abstractC1361a != null) {
                abstractC1361a.cancel();
            }
        }
        this.f5035x.add(new b(i4, f4, f5));
        View view = this.f5026o.get();
        if (view != null) {
            view.removeCallbacks(this.f5036y);
            view.post(this.f5036y);
        }
    }

    private void b(int i4, float f4) {
        a(i4, a(i4), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, float f4) {
        if (i4 == 1) {
            this.f5025n.i(f4);
        } else if (i4 == 2) {
            this.f5025n.j(f4);
        } else if (i4 == 4) {
            this.f5025n.g(f4);
        } else if (i4 == 8) {
            this.f5025n.h(f4);
        } else if (i4 == 16) {
            this.f5025n.d(f4);
        } else if (i4 == 32) {
            this.f5025n.e(f4);
        } else if (i4 == 64) {
            this.f5025n.f(f4);
        } else if (i4 == 128) {
            this.f5025n.k(f4);
        } else if (i4 == 256) {
            this.f5025n.l(f4);
        } else if (i4 != 512) {
        } else {
            this.f5025n.a(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        L a4 = L.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f5035x.clone();
        this.f5035x.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((b) arrayList.get(i5)).f5039a;
        }
        this.f5037z.put(a4, new c(i4, arrayList));
        a4.a((L.b) this.f5034w);
        a4.a((AbstractC1361a.InterfaceC0082a) this.f5034w);
        if (this.f5030s) {
            a4.b(this.f5029r);
        }
        if (this.f5028q) {
            a4.a(this.f5027p);
        }
        if (this.f5032u) {
            a4.a(this.f5031t);
        }
        a4.j();
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(float f4) {
        a(512, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(long j4) {
        if (j4 >= 0) {
            this.f5028q = true;
            this.f5027p = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(Interpolator interpolator) {
        this.f5032u = true;
        this.f5031t = interpolator;
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(AbstractC1361a.InterfaceC0082a interfaceC0082a) {
        this.f5033v = interfaceC0082a;
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public void a() {
        if (this.f5037z.size() > 0) {
            for (AbstractC1361a abstractC1361a : ((HashMap) this.f5037z.clone()).keySet()) {
                abstractC1361a.cancel();
            }
        }
        this.f5035x.clear();
        View view = this.f5026o.get();
        if (view != null) {
            view.removeCallbacks(this.f5036y);
        }
    }

    @Override // com.acse.ottn.animator.c.b
    public long b() {
        return this.f5028q ? this.f5027p : new L().b();
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b b(float f4) {
        b(512, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b b(long j4) {
        if (j4 >= 0) {
            this.f5030s = true;
            this.f5029r = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.animator.c.b
    public long c() {
        if (this.f5030s) {
            return this.f5029r;
        }
        return 0L;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b c(float f4) {
        a(16, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b d(float f4) {
        b(16, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public void d() {
        e();
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b e(float f4) {
        a(32, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b f(float f4) {
        b(32, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b g(float f4) {
        a(64, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b h(float f4) {
        b(64, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b i(float f4) {
        a(4, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b j(float f4) {
        b(4, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b k(float f4) {
        a(8, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b l(float f4) {
        b(8, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b m(float f4) {
        a(1, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b n(float f4) {
        b(1, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b o(float f4) {
        a(2, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b p(float f4) {
        b(2, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b q(float f4) {
        a(128, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b r(float f4) {
        b(128, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b s(float f4) {
        a(256, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b t(float f4) {
        b(256, f4);
        return this;
    }
}
