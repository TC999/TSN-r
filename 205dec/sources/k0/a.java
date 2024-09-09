package k0;

import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Callbacks.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private d f55225a;

    /* renamed from: b  reason: collision with root package name */
    private c f55226b;

    /* renamed from: c  reason: collision with root package name */
    private g f55227c;

    /* renamed from: d  reason: collision with root package name */
    private i f55228d;

    /* renamed from: e  reason: collision with root package name */
    private f f55229e;

    /* renamed from: f  reason: collision with root package name */
    private h f55230f;

    /* renamed from: g  reason: collision with root package name */
    private b f55231g;

    /* renamed from: h  reason: collision with root package name */
    private b f55232h;

    /* renamed from: i  reason: collision with root package name */
    private j f55233i;

    /* renamed from: j  reason: collision with root package name */
    private e f55234j;

    /* renamed from: k  reason: collision with root package name */
    private j0.b f55235k;

    public void a(l0.a aVar) {
        j0.b bVar = this.f55235k;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public void b(int i4) {
        d dVar = this.f55225a;
        if (dVar != null) {
            dVar.a(i4);
        }
    }

    public void c(MotionEvent motionEvent) {
        e eVar = this.f55234j;
        if (eVar != null) {
            eVar.onLongPress(motionEvent);
        }
    }

    public void d(int i4, int i5) {
        f fVar = this.f55229e;
        if (fVar != null) {
            fVar.a(i4, i5);
        }
    }

    public boolean e(int i4, Throwable th) {
        g gVar = this.f55227c;
        if (gVar != null) {
            gVar.a(i4, th);
            return true;
        }
        return false;
    }

    public void f(int i4, float f4) {
        h hVar = this.f55230f;
        if (hVar != null) {
            hVar.a(i4, f4);
        }
    }

    public void g(int i4) {
        i iVar = this.f55228d;
        if (iVar != null) {
            iVar.a(i4);
        }
    }

    public boolean h(MotionEvent motionEvent) {
        j jVar = this.f55233i;
        return jVar != null && jVar.a(motionEvent);
    }

    public b i() {
        return this.f55231g;
    }

    public b j() {
        return this.f55232h;
    }

    public c k() {
        return this.f55226b;
    }

    public void l(j0.b bVar) {
        this.f55235k = bVar;
    }

    public void m(b bVar) {
        this.f55231g = bVar;
    }

    public void n(b bVar) {
        this.f55232h = bVar;
    }

    public void o(c cVar) {
        this.f55226b = cVar;
    }

    public void p(d dVar) {
        this.f55225a = dVar;
    }

    public void q(e eVar) {
        this.f55234j = eVar;
    }

    public void r(f fVar) {
        this.f55229e = fVar;
    }

    public void s(g gVar) {
        this.f55227c = gVar;
    }

    public void t(h hVar) {
        this.f55230f = hVar;
    }

    public void u(i iVar) {
        this.f55228d = iVar;
    }

    public void v(j jVar) {
        this.f55233i = jVar;
    }
}
