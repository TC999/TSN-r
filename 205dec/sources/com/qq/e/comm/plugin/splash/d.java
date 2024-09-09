package com.qq.e.comm.plugin.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.util.l1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private h f46047a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.splash.r.b f46048b;

    /* renamed from: c  reason: collision with root package name */
    private a f46049c;

    private void a(h hVar, com.qq.e.comm.plugin.splash.r.b bVar) {
        if (hVar == null || bVar == null) {
            return;
        }
        n.d(hVar);
        bVar.a(0);
    }

    private boolean a(int i4, h hVar) {
        return i4 == 2;
    }

    private int c(com.qq.e.comm.plugin.splash.r.a aVar) {
        int i4 = aVar.f46175a.f44109f;
        if (i4 != 0) {
            return i4;
        }
        int i5 = aVar.f46176b;
        if (i5 == 8) {
            return 11;
        }
        return i5 == 10 ? 12 : -999;
    }

    public void b(com.qq.e.comm.plugin.splash.r.a aVar) {
        if (b() || aVar == null) {
            return;
        }
        if (aVar.f46175a.f44109f == 0 && aVar.f46176b == 0) {
            return;
        }
        int i4 = aVar.f46176b;
        if (a(i4, this.f46047a)) {
            a(this.f46047a, this.f46048b);
        } else if (aVar.f46175a.f44109f != 0) {
            a(aVar, this.f46047a, this.f46049c);
        } else if (i4 == 1 || i4 == 8 || i4 == 10 || i4 == 4 || i4 == 5) {
            a(aVar, this.f46047a, this.f46049c);
        }
    }

    public boolean a(com.qq.e.comm.plugin.splash.r.a aVar) {
        if (aVar != null) {
            if ((aVar.f46175a.f44109f == 0 && aVar.f46176b == 0) || b() || o.b()) {
                return false;
            }
            if (aVar.f46175a.f44109f != 0) {
                return true;
            }
            int i4 = aVar.f46176b;
            if (a(i4, this.f46047a)) {
                return true;
            }
            n.b(this.f46047a.c(), i4);
            return i4 == 10;
        }
        return false;
    }

    private void a(com.qq.e.comm.plugin.splash.r.a aVar, h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        if (aVar == null || hVar == null || bVar == null) {
            return;
        }
        n.c(this.f46047a);
        boolean c4 = j.c(hVar.f46091c);
        int c5 = c(aVar);
        c0 b4 = hVar.b();
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(hVar.f46112x);
        if (d4 != null) {
            d4.b(aVar.f46175a.f44106c);
            d4.a(c5);
            d4.e(41);
            d4.f(hVar.f46111w.get().booleanValue() ? 1 : 2);
            d4.d(aVar.f46175a.f44110g);
            com.qq.e.comm.plugin.i.f fVar = aVar.f46175a;
            int i4 = fVar.f44110g;
            if (2 == i4) {
                d4.a(fVar.f44111h);
            } else if (5 == i4) {
                d4.a(fVar.f44112i, fVar.f44113j);
            }
            d4.a(b4.e1());
            d4.a(aVar.f46175a.f44117n);
            d4.a(aVar.f46175a.f44118o);
            d4.b(aVar.f46175a.f44119p);
        }
        String a5 = a4.a(hVar.f46112x);
        com.qq.e.comm.plugin.i.g.a(new h.b(b4).a(a5).a(c5).c(c4).e(aVar.f46175a.f44116m).b(aVar.f46175a.f44110g).c(aVar.f46175a.f44106c).e(aVar.f46175a.f44114k).a(aVar.f46175a.f44115l).a(), bVar);
        l1.a(hVar.f46112x, b4, a5);
        ADListener aDListener = hVar.f46100l;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(105, new Object[0]));
        }
        n.a(hVar, aVar);
    }

    public void b(h hVar, com.qq.e.comm.plugin.splash.r.b bVar) {
        this.f46047a = hVar;
        this.f46048b = bVar;
        ViewGroup viewGroup = hVar.f46107s;
        Context a4 = viewGroup != null ? com.qq.e.comm.plugin.util.k.a(viewGroup.getContext()) : null;
        if (a4 == null) {
            a4 = com.qq.e.comm.plugin.util.k.a(hVar.f46089a);
        }
        if (a4 == null) {
            a4 = hVar.f46089a;
        }
        a aVar = new a(a4);
        this.f46049c = aVar;
        aVar.f46051e = bVar;
        o.c();
        this.f46049c.a(hVar.b());
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a extends com.qq.e.comm.plugin.i.d0.d {

        /* renamed from: d  reason: collision with root package name */
        com.qq.e.comm.plugin.r0.d f46050d;

        /* renamed from: e  reason: collision with root package name */
        com.qq.e.comm.plugin.splash.r.b f46051e;

        /* renamed from: f  reason: collision with root package name */
        h f46052f;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.splash.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0891a implements com.qq.e.comm.plugin.i.d0.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f46053a;

            C0891a(com.qq.e.comm.plugin.i.d0.c cVar) {
                this.f46053a = cVar;
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void a(boolean z3) {
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void b(boolean z3) {
                this.f46053a.b(z3);
                com.qq.e.comm.plugin.splash.r.b bVar = a.this.f46051e;
                if (bVar == null || z3) {
                    return;
                }
                bVar.a(0);
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void onCancel() {
                this.f46053a.onCancel();
                com.qq.e.comm.plugin.splash.r.b bVar = a.this.f46051e;
                if (bVar != null) {
                    bVar.a(0);
                }
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public boolean onConfirm() {
                return this.f46053a.onConfirm();
            }
        }

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class b implements com.qq.e.comm.plugin.i.d0.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f46055a;

            b(com.qq.e.comm.plugin.i.d0.c cVar) {
                this.f46055a = cVar;
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void a(boolean z3) {
                com.qq.e.comm.plugin.splash.r.b bVar;
                if (!z3 || (bVar = a.this.f46051e) == null) {
                    return;
                }
                bVar.o();
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void b(boolean z3) {
                this.f46055a.b(z3);
                com.qq.e.comm.plugin.splash.r.b bVar = a.this.f46051e;
                if (bVar == null || z3) {
                    return;
                }
                bVar.p();
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public void onCancel() {
                this.f46055a.onCancel();
                com.qq.e.comm.plugin.splash.r.b bVar = a.this.f46051e;
                if (bVar != null) {
                    bVar.p();
                }
            }

            @Override // com.qq.e.comm.plugin.i.d0.c
            public boolean onConfirm() {
                boolean onConfirm = this.f46055a.onConfirm();
                com.qq.e.comm.plugin.splash.r.b bVar = a.this.f46051e;
                if (bVar != null) {
                    bVar.a(0);
                }
                return onConfirm;
            }
        }

        public a(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(String str, com.qq.e.comm.plugin.i.d0.c cVar) {
            Activity b4;
            if (this.f46051e == null || (b4 = com.qq.e.comm.plugin.util.k.b(this.f44096a.get())) == null) {
                return;
            }
            com.qq.e.comm.plugin.r0.d dVar = new com.qq.e.comm.plugin.r0.d(b4, str, new C0891a(cVar));
            this.f46050d = dVar;
            dVar.c();
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void c() {
            com.qq.e.comm.plugin.splash.r.b bVar = this.f46051e;
            if (bVar != null) {
                bVar.a(30);
            }
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(com.qq.e.comm.plugin.g0.e eVar, DownloadConfirmListener downloadConfirmListener, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
            super.a(eVar, downloadConfirmListener, new b(cVar), i4);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(com.qq.e.comm.plugin.g0.b bVar) {
            super.a(bVar);
            com.qq.e.comm.plugin.splash.r.b bVar2 = this.f46051e;
            if (bVar2 != null) {
                bVar2.a(0);
            }
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(boolean z3) {
            super.a(z3);
            com.qq.e.comm.plugin.splash.r.b bVar = this.f46051e;
            if (bVar != null) {
                bVar.a(30);
            }
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public boolean a(String str, com.qq.e.comm.plugin.g0.e eVar) {
            boolean a4 = super.a(str, eVar);
            com.qq.e.comm.plugin.splash.r.b bVar = this.f46051e;
            if (bVar != null) {
                bVar.a(30);
            }
            return a4;
        }
    }

    public boolean b() {
        return this.f46047a == null || this.f46048b == null;
    }

    public void a() {
        a aVar = this.f46049c;
        if (aVar != null) {
            com.qq.e.comm.plugin.r0.d dVar = aVar.f46050d;
            if (dVar != null) {
                dVar.a();
                this.f46049c.f46050d = null;
            }
            a aVar2 = this.f46049c;
            aVar2.f46051e = null;
            aVar2.f46052f = null;
            this.f46049c = null;
        }
        this.f46048b = null;
        this.f46047a = null;
    }
}
