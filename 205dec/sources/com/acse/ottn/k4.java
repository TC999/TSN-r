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
public class k4 extends j4 {

    /* renamed from: n  reason: collision with root package name */
    public static final int f5810n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static final int f5811o = 1;

    /* renamed from: p  reason: collision with root package name */
    public static final int f5812p = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final int f5813q = 4;

    /* renamed from: r  reason: collision with root package name */
    public static final int f5814r = 8;

    /* renamed from: s  reason: collision with root package name */
    public static final int f5815s = 16;

    /* renamed from: t  reason: collision with root package name */
    public static final int f5816t = 32;

    /* renamed from: u  reason: collision with root package name */
    public static final int f5817u = 64;

    /* renamed from: v  reason: collision with root package name */
    public static final int f5818v = 128;

    /* renamed from: w  reason: collision with root package name */
    public static final int f5819w = 256;

    /* renamed from: x  reason: collision with root package name */
    public static final int f5820x = 512;

    /* renamed from: y  reason: collision with root package name */
    public static final int f5821y = 511;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f5822b;

    /* renamed from: c  reason: collision with root package name */
    public long f5823c;

    /* renamed from: g  reason: collision with root package name */
    public Interpolator f5827g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5824d = false;

    /* renamed from: e  reason: collision with root package name */
    public long f5825e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5826f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5828h = false;

    /* renamed from: i  reason: collision with root package name */
    public i.a f5829i = null;

    /* renamed from: j  reason: collision with root package name */
    public b f5830j = new b(this, null);

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<c> f5831k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public Runnable f5832l = new a();

    /* renamed from: m  reason: collision with root package name */
    public HashMap<i, d> f5833m = new HashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k4.this.e();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements i.a, g4.g {
        public b() {
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (k4.this.f5829i != null) {
                k4.this.f5829i.a(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (k4.this.f5829i != null) {
                k4.this.f5829i.b(iVar);
            }
            k4.this.f5833m.remove(iVar);
            if (k4.this.f5833m.isEmpty()) {
                k4.this.f5829i = null;
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
            if (k4.this.f5829i != null) {
                k4.this.f5829i.c(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            if (k4.this.f5829i != null) {
                k4.this.f5829i.d(iVar);
            }
        }

        public /* synthetic */ b(k4 k4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.g4.g
        public void a(g4 g4Var) {
            View view;
            float u3 = g4Var.u();
            d dVar = (d) k4.this.f5833m.get(g4Var);
            if ((dVar.f5839a & 511) != 0 && (view = (View) k4.this.f5822b.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f5840b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    c cVar = arrayList.get(i4);
                    k4.this.c(cVar.f5836a, cVar.f5837b + (cVar.f5838c * u3));
                }
            }
            View view2 = (View) k4.this.f5822b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f5836a;

        /* renamed from: b  reason: collision with root package name */
        public float f5837b;

        /* renamed from: c  reason: collision with root package name */
        public float f5838c;

        public c(int i4, float f4, float f5) {
            this.f5836a = i4;
            this.f5837b = f4;
            this.f5838c = f5;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f5839a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c> f5840b;

        public d(int i4, ArrayList<c> arrayList) {
            this.f5839a = i4;
            this.f5840b = arrayList;
        }

        public boolean a(int i4) {
            ArrayList<c> arrayList;
            if ((this.f5839a & i4) != 0 && (arrayList = this.f5840b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f5840b.get(i5).f5836a == i4) {
                        this.f5840b.remove(i5);
                        this.f5839a = (i4 ^ (-1)) & this.f5839a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public k4(View view) {
        this.f5822b = new WeakReference<>(view);
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
        if (this.f5824d) {
            return this.f5823c;
        }
        return new g4().c();
    }

    @Override // com.acse.ottn.j4
    public long c() {
        if (this.f5826f) {
            return this.f5825e;
        }
        return 0L;
    }

    @Override // com.acse.ottn.j4
    public void d() {
        e();
    }

    public final void e() {
        g4 a4 = g4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f5831k.clone();
        this.f5831k.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((c) arrayList.get(i5)).f5836a;
        }
        this.f5833m.put(a4, new d(i4, arrayList));
        a4.a((g4.g) this.f5830j);
        a4.a((i.a) this.f5830j);
        if (this.f5826f) {
            a4.b(this.f5825e);
        }
        if (this.f5824d) {
            a4.a(this.f5823c);
        }
        if (this.f5828h) {
            a4.a(this.f5827g);
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
            this.f5824d = true;
            this.f5823c = j4;
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
            this.f5826f = true;
            this.f5825e = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    public final void c(int i4, float f4) {
        View view = this.f5822b.get();
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

    @Override // com.acse.ottn.j4
    public j4 a(Interpolator interpolator) {
        this.f5828h = true;
        this.f5827g = interpolator;
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 b(float f4) {
        b(512, f4);
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 a(i.a aVar) {
        this.f5829i = aVar;
        return this;
    }

    public final void b(int i4, float f4) {
        a(i4, a(i4), f4);
    }

    @Override // com.acse.ottn.j4
    public void a() {
        if (this.f5833m.size() > 0) {
            for (i iVar : ((HashMap) this.f5833m.clone()).keySet()) {
                iVar.cancel();
            }
        }
        this.f5831k.clear();
        View view = this.f5822b.get();
        if (view != null) {
            view.removeCallbacks(this.f5832l);
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
        if (this.f5833m.size() > 0) {
            i iVar = null;
            Iterator<i> it = this.f5833m.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                d dVar = this.f5833m.get(next);
                if (dVar.a(i4) && dVar.f5839a == 0) {
                    iVar = next;
                    break;
                }
            }
            if (iVar != null) {
                iVar.cancel();
            }
        }
        this.f5831k.add(new c(i4, f4, f5));
        View view = this.f5822b.get();
        if (view != null) {
            view.removeCallbacks(this.f5832l);
            view.post(this.f5832l);
        }
    }

    public final float a(int i4) {
        View view = this.f5822b.get();
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
}
