package master.flame.danmaku.danmaku.renderer.android;

import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakusRetainer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private e f61263a = null;

    /* renamed from: b  reason: collision with root package name */
    private e f61264b = null;

    /* renamed from: c  reason: collision with root package name */
    private e f61265c = null;

    /* renamed from: d  reason: collision with root package name */
    private e f61266d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1242b extends d {

        /* renamed from: d  reason: collision with root package name */
        protected a f61267d;

        /* renamed from: e  reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.android.e f61268e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: DanmakusRetainer.java */
        /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        protected class a extends m.b<master.flame.danmaku.danmaku.model.d, f> {

            /* renamed from: e  reason: collision with root package name */
            public n f61269e;

            /* renamed from: f  reason: collision with root package name */
            int f61270f = 0;

            /* renamed from: g  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61271g = null;

            /* renamed from: h  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61272h = null;

            /* renamed from: i  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61273i = null;

            /* renamed from: j  reason: collision with root package name */
            boolean f61274j = false;

            /* renamed from: k  reason: collision with root package name */
            float f61275k;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            public void c() {
                this.f61270f = 0;
                this.f61272h = null;
                this.f61271g = null;
                this.f61274j = false;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (C1242b.this.f61278b) {
                    return 1;
                }
                this.f61270f++;
                if (dVar == this.f61273i) {
                    this.f61271g = null;
                    this.f61274j = false;
                    return 1;
                }
                if (this.f61272h == null) {
                    this.f61272h = dVar;
                    if (dVar.d() != this.f61269e.getHeight()) {
                        return 1;
                    }
                }
                if (this.f61275k < this.f61269e.r()) {
                    this.f61271g = null;
                    return 1;
                }
                n nVar = this.f61269e;
                master.flame.danmaku.danmaku.model.d dVar2 = this.f61273i;
                boolean i4 = g3.a.i(nVar, dVar, dVar2, dVar2.f(), this.f61273i.k().f61172a);
                this.f61274j = i4;
                if (!i4) {
                    this.f61271g = dVar;
                    return 1;
                }
                this.f61275k = (dVar.l() - this.f61269e.o()) - this.f61273i.f61162q;
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f */
            public f d() {
                f fVar = new f();
                fVar.f61291a = this.f61270f;
                fVar.f61293c = this.f61272h;
                fVar.f61296f = this.f61271g;
                fVar.f61299i = this.f61274j;
                return fVar;
            }
        }

        private C1242b() {
            super();
            this.f61267d = new a();
            this.f61268e = new master.flame.danmaku.danmaku.model.android.e(2);
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c, master.flame.danmaku.danmaku.renderer.android.b.e
        public void a(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar) {
            boolean z3;
            boolean z4;
            master.flame.danmaku.danmaku.model.d dVar2;
            master.flame.danmaku.danmaku.model.d dVar3;
            int i4;
            if (dVar.s()) {
                return;
            }
            boolean v3 = dVar.v();
            float l4 = v3 ? dVar.l() : -1.0f;
            int i5 = 1;
            boolean z5 = false;
            boolean z6 = (v3 || this.f61268e.isEmpty()) ? false : true;
            if (l4 < nVar.r()) {
                l4 = nVar.getHeight() - dVar.f61162q;
            }
            master.flame.danmaku.danmaku.model.d dVar4 = null;
            if (v3) {
                i5 = 0;
            } else {
                this.f61278b = false;
                a aVar = this.f61267d;
                aVar.f61275k = l4;
                aVar.f61269e = nVar;
                aVar.f61273i = dVar;
                this.f61268e.a(aVar);
                f d4 = this.f61267d.d();
                float f4 = this.f61267d.f61275k;
                if (d4 != null) {
                    int i6 = d4.f61291a;
                    master.flame.danmaku.danmaku.model.d dVar5 = d4.f61293c;
                    master.flame.danmaku.danmaku.model.d dVar6 = d4.f61296f;
                    boolean z7 = d4.f61298h;
                    i4 = i6;
                    z4 = d4.f61299i;
                    dVar2 = dVar5;
                    dVar3 = dVar6;
                    z3 = z7;
                } else {
                    z3 = v3;
                    z4 = z6;
                    dVar2 = null;
                    dVar3 = null;
                    i4 = 0;
                }
                boolean b4 = b(false, dVar, nVar, f4, dVar2, null);
                if (b4) {
                    l4 = nVar.getHeight() - dVar.f61162q;
                    z5 = b4;
                    v3 = z3;
                    dVar4 = dVar3;
                    z6 = true;
                } else {
                    boolean z8 = f4 >= ((float) nVar.r()) ? false : z4;
                    if (dVar3 != null) {
                        z5 = b4;
                        z6 = z8;
                        v3 = z3;
                        dVar4 = dVar3;
                        i5 = i4 - 1;
                        l4 = f4;
                    } else {
                        z5 = b4;
                        z6 = z8;
                        l4 = f4;
                        i5 = i4;
                        v3 = z3;
                        dVar4 = dVar3;
                    }
                }
            }
            if (gVar == null || !gVar.a(dVar, l4, i5, z6)) {
                if (z5) {
                    clear();
                }
                dVar.y(nVar, dVar.g(), l4);
                if (v3) {
                    return;
                }
                this.f61268e.g(dVar4);
                this.f61268e.i(dVar);
            }
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.d, master.flame.danmaku.danmaku.renderer.android.b.c
        protected boolean b(boolean z3, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f4, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            if (f4 >= nVar.r()) {
                return (dVar2 == null || dVar2.d() == ((float) nVar.getHeight())) ? false : true;
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c, master.flame.danmaku.danmaku.renderer.android.b.e
        public void clear() {
            this.f61278b = true;
            this.f61268e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements e {

        /* renamed from: a  reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.android.e f61277a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f61278b;

        /* renamed from: c  reason: collision with root package name */
        protected a f61279c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: DanmakusRetainer.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        protected class a extends m.b<master.flame.danmaku.danmaku.model.d, f> {

            /* renamed from: e  reason: collision with root package name */
            public n f61280e;

            /* renamed from: f  reason: collision with root package name */
            int f61281f = 0;

            /* renamed from: g  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61282g = null;

            /* renamed from: h  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61283h = null;

            /* renamed from: i  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61284i = null;

            /* renamed from: j  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61285j = null;

            /* renamed from: k  reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f61286k = null;

            /* renamed from: l  reason: collision with root package name */
            boolean f61287l = false;

            /* renamed from: m  reason: collision with root package name */
            boolean f61288m = false;

            /* renamed from: n  reason: collision with root package name */
            boolean f61289n = false;

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            public void c() {
                this.f61281f = 0;
                this.f61285j = null;
                this.f61284i = null;
                this.f61283h = null;
                this.f61282g = null;
                this.f61289n = false;
                this.f61288m = false;
                this.f61287l = false;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (c.this.f61278b) {
                    return 1;
                }
                this.f61281f++;
                master.flame.danmaku.danmaku.model.d dVar2 = this.f61286k;
                if (dVar == dVar2) {
                    this.f61282g = dVar;
                    this.f61284i = null;
                    this.f61288m = true;
                    this.f61289n = false;
                    return 1;
                }
                if (this.f61283h == null) {
                    this.f61283h = dVar;
                }
                if (dVar2.f61162q + dVar.l() > this.f61280e.getHeight()) {
                    this.f61287l = true;
                    return 1;
                }
                master.flame.danmaku.danmaku.model.d dVar3 = this.f61285j;
                if (dVar3 == null) {
                    this.f61285j = dVar;
                } else if (dVar3.i() >= dVar.i()) {
                    this.f61285j = dVar;
                }
                n nVar = this.f61280e;
                master.flame.danmaku.danmaku.model.d dVar4 = this.f61286k;
                boolean i4 = g3.a.i(nVar, dVar, dVar4, dVar4.f(), this.f61286k.k().f61172a);
                this.f61289n = i4;
                if (!i4) {
                    this.f61282g = dVar;
                    return 1;
                }
                this.f61284i = dVar;
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f */
            public f d() {
                f fVar = new f();
                fVar.f61291a = this.f61281f;
                fVar.f61293c = this.f61283h;
                fVar.f61292b = this.f61282g;
                fVar.f61294d = this.f61284i;
                fVar.f61295e = this.f61285j;
                fVar.f61297g = this.f61287l;
                fVar.f61298h = this.f61288m;
                fVar.f61299i = this.f61289n;
                return fVar;
            }
        }

        private c() {
            this.f61277a = new master.flame.danmaku.danmaku.model.android.e(1);
            this.f61278b = false;
            this.f61279c = new a();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e2  */
        @Override // master.flame.danmaku.danmaku.renderer.android.b.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(master.flame.danmaku.danmaku.model.d r20, master.flame.danmaku.danmaku.model.n r21, master.flame.danmaku.danmaku.renderer.android.b.g r22) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.danmaku.renderer.android.b.c.a(master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.n, master.flame.danmaku.danmaku.renderer.android.b$g):void");
        }

        protected boolean b(boolean z3, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f4, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            if (f4 >= nVar.r()) {
                return (dVar2 != null && dVar2.l() > 0.0f) || f4 + dVar.f61162q > ((float) nVar.getHeight());
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.e
        public void clear() {
            this.f61278b = true;
            this.f61277a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d extends c {
        private d() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c
        protected boolean b(boolean z3, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f4, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f4 + dVar.f61162q > ((float) nVar.getHeight());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface e {
        void a(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar);

        void clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f61291a;

        /* renamed from: b  reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f61292b;

        /* renamed from: c  reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f61293c;

        /* renamed from: d  reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f61294d;

        /* renamed from: e  reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f61295e;

        /* renamed from: f  reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f61296f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f61297g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61298h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f61299i;

        private f() {
            this.f61291a = 0;
            this.f61292b = null;
            this.f61293c = null;
            this.f61294d = null;
            this.f61295e = null;
            this.f61296f = null;
            this.f61297g = false;
            this.f61298h = false;
            this.f61299i = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakusRetainer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface g {
        boolean a(master.flame.danmaku.danmaku.model.d dVar, float f4, int i4, boolean z3);
    }

    public b(boolean z3) {
        a(z3);
    }

    public void a(boolean z3) {
        this.f61263a = z3 ? new C1242b() : new c();
        this.f61264b = z3 ? new C1242b() : new c();
        if (this.f61265c == null) {
            this.f61265c = new d();
        }
        if (this.f61266d == null) {
            this.f61266d = new C1242b();
        }
    }

    public void b() {
        e eVar = this.f61263a;
        if (eVar != null) {
            eVar.clear();
        }
        e eVar2 = this.f61264b;
        if (eVar2 != null) {
            eVar2.clear();
        }
        e eVar3 = this.f61265c;
        if (eVar3 != null) {
            eVar3.clear();
        }
        e eVar4 = this.f61266d;
        if (eVar4 != null) {
            eVar4.clear();
        }
    }

    public void c(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar) {
        int type = dVar.getType();
        if (type == 1) {
            this.f61263a.a(dVar, nVar, gVar);
        } else if (type == 4) {
            this.f61266d.a(dVar, nVar, gVar);
        } else if (type == 5) {
            this.f61265c.a(dVar, nVar, gVar);
        } else if (type == 6) {
            this.f61264b.a(dVar, nVar, gVar);
        } else if (type != 7) {
        } else {
            dVar.y(nVar, 0.0f, 0.0f);
        }
    }

    public void d() {
        b();
    }
}
