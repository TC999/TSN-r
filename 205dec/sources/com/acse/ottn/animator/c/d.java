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
public class d extends com.acse.ottn.animator.c.b {

    /* renamed from: b  reason: collision with root package name */
    private static final int f4978b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4979c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f4980d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f4981e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f4982f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final int f4983g = 16;

    /* renamed from: h  reason: collision with root package name */
    private static final int f4984h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static final int f4985i = 64;

    /* renamed from: j  reason: collision with root package name */
    private static final int f4986j = 128;

    /* renamed from: k  reason: collision with root package name */
    private static final int f4987k = 256;

    /* renamed from: l  reason: collision with root package name */
    private static final int f4988l = 512;

    /* renamed from: m  reason: collision with root package name */
    private static final int f4989m = 511;

    /* renamed from: n  reason: collision with root package name */
    private final WeakReference<View> f4990n;

    /* renamed from: o  reason: collision with root package name */
    private long f4991o;

    /* renamed from: s  reason: collision with root package name */
    private Interpolator f4995s;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4992p = false;

    /* renamed from: q  reason: collision with root package name */
    private long f4993q = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4994r = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4996t = false;

    /* renamed from: u  reason: collision with root package name */
    private AbstractC1361a.InterfaceC0082a f4997u = null;

    /* renamed from: v  reason: collision with root package name */
    private a f4998v = new a(this, null);

    /* renamed from: w  reason: collision with root package name */
    ArrayList<b> f4999w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private Runnable f5000x = new com.acse.ottn.animator.c.c(this);

    /* renamed from: y  reason: collision with root package name */
    private HashMap<AbstractC1361a, c> f5001y = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements AbstractC1361a.InterfaceC0082a, L.b {
        private a() {
        }

        /* synthetic */ a(d dVar, com.acse.ottn.animator.c.c cVar) {
            this();
        }

        @Override // com.acse.ottn.animator.a.L.b
        public void a(L l4) {
            View view;
            float r3 = l4.r();
            c cVar = (c) d.this.f5001y.get(l4);
            if ((cVar.f5006a & 511) != 0 && (view = (View) d.this.f4990n.get()) != null) {
                view.invalidate();
            }
            ArrayList<b> arrayList = cVar.f5007b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    b bVar = arrayList.get(i4);
                    d.this.c(bVar.f5003a, bVar.f5004b + (bVar.f5005c * r3));
                }
            }
            View view2 = (View) d.this.f4990n.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void a(AbstractC1361a abstractC1361a) {
            if (d.this.f4997u != null) {
                d.this.f4997u.a(abstractC1361a);
            }
            d.this.f5001y.remove(abstractC1361a);
            if (d.this.f5001y.isEmpty()) {
                d.this.f4997u = null;
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void b(AbstractC1361a abstractC1361a) {
            if (d.this.f4997u != null) {
                d.this.f4997u.b(abstractC1361a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void c(AbstractC1361a abstractC1361a) {
            if (d.this.f4997u != null) {
                d.this.f4997u.c(abstractC1361a);
            }
        }

        @Override // com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
        public void d(AbstractC1361a abstractC1361a) {
            if (d.this.f4997u != null) {
                d.this.f4997u.d(abstractC1361a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f5003a;

        /* renamed from: b  reason: collision with root package name */
        float f5004b;

        /* renamed from: c  reason: collision with root package name */
        float f5005c;

        b(int i4, float f4, float f5) {
            this.f5003a = i4;
            this.f5004b = f4;
            this.f5005c = f5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        int f5006a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f5007b;

        c(int i4, ArrayList<b> arrayList) {
            this.f5006a = i4;
            this.f5007b = arrayList;
        }

        boolean a(int i4) {
            ArrayList<b> arrayList;
            if ((this.f5006a & i4) != 0 && (arrayList = this.f5007b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f5007b.get(i5).f5003a == i4) {
                        this.f5007b.remove(i5);
                        this.f5006a = (i4 ^ (-1)) & this.f5006a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.f4990n = new WeakReference<>(view);
    }

    private float a(int i4) {
        View view = this.f4990n.get();
        if (view != null) {
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
                                                return view.getAlpha();
                                            }
                                            return view.getY();
                                        }
                                        return view.getX();
                                    }
                                    return view.getRotationY();
                                }
                                return view.getRotationX();
                            }
                            return view.getRotation();
                        }
                        return view.getScaleY();
                    }
                    return view.getScaleX();
                }
                return view.getTranslationY();
            }
            return view.getTranslationX();
        }
        return 0.0f;
    }

    private void a(int i4, float f4) {
        float a4 = a(i4);
        a(i4, a4, f4 - a4);
    }

    private void a(int i4, float f4, float f5) {
        if (this.f5001y.size() > 0) {
            AbstractC1361a abstractC1361a = null;
            Iterator<AbstractC1361a> it = this.f5001y.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC1361a next = it.next();
                c cVar = this.f5001y.get(next);
                if (cVar.a(i4) && cVar.f5006a == 0) {
                    abstractC1361a = next;
                    break;
                }
            }
            if (abstractC1361a != null) {
                abstractC1361a.cancel();
            }
        }
        this.f4999w.add(new b(i4, f4, f5));
        View view = this.f4990n.get();
        if (view != null) {
            view.removeCallbacks(this.f5000x);
            view.post(this.f5000x);
        }
    }

    private void b(int i4, float f4) {
        a(i4, a(i4), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, float f4) {
        View view = this.f4990n.get();
        if (view != null) {
            if (i4 == 1) {
                view.setTranslationX(f4);
            } else if (i4 == 2) {
                view.setTranslationY(f4);
            } else if (i4 == 4) {
                view.setScaleX(f4);
            } else if (i4 == 8) {
                view.setScaleY(f4);
            } else if (i4 == 16) {
                view.setRotation(f4);
            } else if (i4 == 32) {
                view.setRotationX(f4);
            } else if (i4 == 64) {
                view.setRotationY(f4);
            } else if (i4 == 128) {
                view.setX(f4);
            } else if (i4 == 256) {
                view.setY(f4);
            } else if (i4 != 512) {
            } else {
                view.setAlpha(f4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        L a4 = L.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f4999w.clone();
        this.f4999w.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((b) arrayList.get(i5)).f5003a;
        }
        this.f5001y.put(a4, new c(i4, arrayList));
        a4.a((L.b) this.f4998v);
        a4.a((AbstractC1361a.InterfaceC0082a) this.f4998v);
        if (this.f4994r) {
            a4.b(this.f4993q);
        }
        if (this.f4992p) {
            a4.a(this.f4991o);
        }
        if (this.f4996t) {
            a4.a(this.f4995s);
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
            this.f4992p = true;
            this.f4991o = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(Interpolator interpolator) {
        this.f4996t = true;
        this.f4995s = interpolator;
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b a(AbstractC1361a.InterfaceC0082a interfaceC0082a) {
        this.f4997u = interfaceC0082a;
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public void a() {
        if (this.f5001y.size() > 0) {
            for (AbstractC1361a abstractC1361a : ((HashMap) this.f5001y.clone()).keySet()) {
                abstractC1361a.cancel();
            }
        }
        this.f4999w.clear();
        View view = this.f4990n.get();
        if (view != null) {
            view.removeCallbacks(this.f5000x);
        }
    }

    @Override // com.acse.ottn.animator.c.b
    public long b() {
        return this.f4992p ? this.f4991o : new L().b();
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b b(float f4) {
        b(512, f4);
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public com.acse.ottn.animator.c.b b(long j4) {
        if (j4 >= 0) {
            this.f4994r = true;
            this.f4993q = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.acse.ottn.animator.c.b
    public long c() {
        if (this.f4994r) {
            return this.f4993q;
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
