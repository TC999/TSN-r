package com.qq.e.dl.l.k;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    protected final h f47182a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f47183b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f47184c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47185d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f47186e;

    /* renamed from: f  reason: collision with root package name */
    private int f47187f;

    public a(h hVar) {
        this.f47182a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroup.LayoutParams a(com.qq.e.dl.l.b bVar) {
        return null;
    }

    protected void a(h hVar) {
    }

    public void a(boolean z3) {
        this.f47184c = z3;
    }

    public void b(boolean z3) {
        this.f47185d = z3;
    }

    public Pair<Integer, Integer> c(int i4, int i5) {
        int i6;
        int i7;
        Boolean bool = this.f47183b;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue()) {
            if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
                int size = View.MeasureSpec.getSize(i5);
                int k4 = this.f47182a.k();
                if (size != k4) {
                    double b4 = k4 * this.f47182a.j().b();
                    Double.isNaN(b4);
                    i7 = View.MeasureSpec.makeMeasureSpec((int) (b4 + 0.5d), 1073741824);
                    i6 = View.MeasureSpec.makeMeasureSpec(k4, Integer.MIN_VALUE);
                }
            }
            return null;
        }
        if (View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE) {
            int size2 = View.MeasureSpec.getSize(i4);
            int l4 = this.f47182a.l();
            if (size2 != l4) {
                double b5 = l4 / this.f47182a.j().b();
                Double.isNaN(b5);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (b5 + 0.5d), 1073741824);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(l4, Integer.MIN_VALUE);
                i6 = makeMeasureSpec;
                i7 = makeMeasureSpec2;
            }
        }
        return null;
        return new Pair<>(Integer.valueOf(i7), Integer.valueOf(i6));
    }

    public Pair<Integer, Integer> d(int i4, int i5) {
        com.qq.e.dl.l.b j4 = this.f47182a.j();
        float b4 = j4.b();
        if (b4 > 0.0f) {
            if (j4.o() == 0 && j4.d() != 0) {
                double size = b4 * View.MeasureSpec.getSize(i5);
                Double.isNaN(size);
                i4 = View.MeasureSpec.makeMeasureSpec((int) (size + 0.5d), 1073741824);
                this.f47183b = Boolean.TRUE;
            } else if (j4.o() != 0 && j4.d() == 0) {
                double size2 = View.MeasureSpec.getSize(i4) / b4;
                Double.isNaN(size2);
                i5 = View.MeasureSpec.makeMeasureSpec((int) (size2 + 0.5d), 1073741824);
                this.f47183b = Boolean.FALSE;
            }
        }
        if (this.f47184c && (this.f47182a instanceof d)) {
            e(i4, i5);
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i5));
    }

    protected void e(int i4, int i5) {
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        if (this.f47186e == size && this.f47187f == size2) {
            return;
        }
        this.f47186e = size;
        this.f47187f = size2;
        d dVar = (d) this.f47182a;
        int w3 = dVar.w();
        for (int i6 = 0; i6 < w3; i6++) {
            dVar.i(i6).i().b(size, size2);
        }
    }

    public void b(h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.m() != null) {
            a(hVar);
        } else if (hVar instanceof d) {
            d dVar = (d) hVar;
            int w3 = dVar.w();
            for (int i4 = 0; i4 < w3; i4++) {
                b(dVar.i(i4));
            }
        }
    }

    public void b(int i4, int i5) {
        if (this.f47185d) {
            com.qq.e.dl.l.b j4 = this.f47182a.j();
            View m4 = this.f47182a.m();
            if (m4 == null) {
                return;
            }
            if (j4.a(i4, i5)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) m4.getLayoutParams();
                marginLayoutParams.width = j4.o();
                marginLayoutParams.height = j4.d();
                marginLayoutParams.leftMargin = j4.f();
                marginLayoutParams.rightMargin = j4.g();
                marginLayoutParams.topMargin = j4.h();
                marginLayoutParams.bottomMargin = j4.e();
            }
            com.qq.e.dl.l.c n4 = this.f47182a.n();
            if (n4.a(i4, i5)) {
                m4.setPadding(n4.c(), n4.e(), n4.d(), n4.b());
            }
            this.f47182a.c();
        }
    }

    public boolean d() {
        return this.f47185d;
    }
}
