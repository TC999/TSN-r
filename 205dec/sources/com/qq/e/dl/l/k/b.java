package com.qq.e.dl.l.k;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b<T extends View> extends a {

    /* renamed from: g  reason: collision with root package name */
    protected final T f47188g;

    public b(h hVar, T t3) {
        super(hVar);
        this.f47188g = t3;
    }

    @Override // com.qq.e.dl.l.k.c
    public int a() {
        return this.f47188g.getMeasuredHeight();
    }

    @Override // com.qq.e.dl.l.k.c
    public void b() {
        com.qq.e.dl.l.c n4 = this.f47182a.n();
        if (n4.f()) {
            this.f47188g.setPadding(n4.c(), n4.e(), n4.d(), n4.b());
            n4.a();
        }
        d o4 = this.f47182a.o();
        if (o4 == null || this.f47188g.getLayoutParams() == null) {
            return;
        }
        com.qq.e.dl.l.b j4 = this.f47182a.j();
        if (j4.p()) {
            this.f47188g.setLayoutParams(o4.a(j4));
            j4.a();
        }
    }

    @Override // com.qq.e.dl.l.k.c
    public int c() {
        return this.f47188g.getMeasuredWidth();
    }

    @Override // com.qq.e.dl.l.k.c
    public void a(int i4, int i5) {
        this.f47188g.measure(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z3) {
        T t3 = this.f47188g;
        if (t3 instanceof ViewGroup) {
            ((ViewGroup) t3).setClipChildren(z3);
        }
    }

    @Override // com.qq.e.dl.l.k.c
    public void a(int i4, int i5, int i6, int i7) {
        this.f47188g.layout(i4, i5, i6, i7);
    }
}
