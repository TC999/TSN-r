package master.flame.danmaku.danmaku.renderer.android;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import p025b2.DanmakuUtils;

/* renamed from: master.flame.danmaku.danmaku.renderer.android.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakusRetainer {

    /* renamed from: a */
    private InterfaceC15366e f43988a = null;

    /* renamed from: b */
    private InterfaceC15366e f43989b = null;

    /* renamed from: c */
    private InterfaceC15366e f43990c = null;

    /* renamed from: d */
    private InterfaceC15366e f43991d = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15361b extends C15365d {

        /* renamed from: d */
        protected C15362a f43992d;

        /* renamed from: e */
        protected Danmakus f43993e;

        /* compiled from: DanmakusRetainer.java */
        /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        protected class C15362a extends IDanmakus.AbstractC15349b<BaseDanmaku, C15367f> {

            /* renamed from: e */
            public IDisplayer f43994e;

            /* renamed from: f */
            int f43995f = 0;

            /* renamed from: g */
            public BaseDanmaku f43996g = null;

            /* renamed from: h */
            public BaseDanmaku f43997h = null;

            /* renamed from: i */
            public BaseDanmaku f43998i = null;

            /* renamed from: j */
            boolean f43999j = false;

            /* renamed from: k */
            float f44000k;

            protected C15362a() {
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: c */
            public void mo2955c() {
                this.f43995f = 0;
                this.f43997h = null;
                this.f43996g = null;
                this.f43999j = false;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                if (C15361b.this.f44003b) {
                    return 1;
                }
                this.f43995f++;
                if (baseDanmaku == this.f43998i) {
                    this.f43996g = null;
                    this.f43999j = false;
                    return 1;
                }
                if (this.f43997h == null) {
                    this.f43997h = baseDanmaku;
                    if (baseDanmaku.mo3000d() != this.f43994e.getHeight()) {
                        return 1;
                    }
                }
                if (this.f44000k < this.f43994e.mo3028r()) {
                    this.f43996g = null;
                    return 1;
                }
                IDisplayer iDisplayer = this.f43994e;
                BaseDanmaku baseDanmaku2 = this.f43998i;
                boolean m59957i = DanmakuUtils.m59957i(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku2.m3085f(), this.f43998i.m3083k().f43885a);
                this.f43999j = m59957i;
                if (!m59957i) {
                    this.f43996g = baseDanmaku;
                    return 1;
                }
                this.f44000k = (baseDanmaku.mo2996l() - this.f43994e.mo3031o()) - this.f43998i.f43875q;
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: f */
            public C15367f mo2954d() {
                C15367f c15367f = new C15367f();
                c15367f.f44016a = this.f43995f;
                c15367f.f44018c = this.f43997h;
                c15367f.f44021f = this.f43996g;
                c15367f.f44024i = this.f43999j;
                return c15367f;
            }
        }

        private C15361b() {
            super();
            this.f43992d = new C15362a();
            this.f43993e = new Danmakus(2);
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15363c, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15366e
        /* renamed from: a */
        public void mo2950a(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, InterfaceC15368g interfaceC15368g) {
            boolean z;
            boolean z2;
            BaseDanmaku baseDanmaku2;
            BaseDanmaku baseDanmaku3;
            int i;
            if (baseDanmaku.m3076s()) {
                return;
            }
            boolean mo3071v = baseDanmaku.mo3071v();
            float mo2996l = mo3071v ? baseDanmaku.mo2996l() : -1.0f;
            int i2 = 1;
            boolean z3 = false;
            boolean z4 = (mo3071v || this.f43993e.isEmpty()) ? false : true;
            if (mo2996l < iDisplayer.mo3028r()) {
                mo2996l = iDisplayer.getHeight() - baseDanmaku.f43875q;
            }
            BaseDanmaku baseDanmaku4 = null;
            if (mo3071v) {
                i2 = 0;
            } else {
                this.f44003b = false;
                C15362a c15362a = this.f43992d;
                c15362a.f44000k = mo2996l;
                c15362a.f43994e = iDisplayer;
                c15362a.f43998i = baseDanmaku;
                this.f43993e.mo3057a(c15362a);
                C15367f mo2954d = this.f43992d.mo2954d();
                float f = this.f43992d.f44000k;
                if (mo2954d != null) {
                    int i3 = mo2954d.f44016a;
                    BaseDanmaku baseDanmaku5 = mo2954d.f44018c;
                    BaseDanmaku baseDanmaku6 = mo2954d.f44021f;
                    boolean z5 = mo2954d.f44023h;
                    i = i3;
                    z2 = mo2954d.f44024i;
                    baseDanmaku2 = baseDanmaku5;
                    baseDanmaku3 = baseDanmaku6;
                    z = z5;
                } else {
                    z = mo3071v;
                    z2 = z4;
                    baseDanmaku2 = null;
                    baseDanmaku3 = null;
                    i = 0;
                }
                boolean mo2951b = mo2951b(false, baseDanmaku, iDisplayer, f, baseDanmaku2, null);
                if (mo2951b) {
                    mo2996l = iDisplayer.getHeight() - baseDanmaku.f43875q;
                    z3 = mo2951b;
                    mo3071v = z;
                    baseDanmaku4 = baseDanmaku3;
                    z4 = true;
                } else {
                    boolean z6 = f >= ((float) iDisplayer.mo3028r()) ? false : z2;
                    if (baseDanmaku3 != null) {
                        z3 = mo2951b;
                        z4 = z6;
                        mo3071v = z;
                        baseDanmaku4 = baseDanmaku3;
                        i2 = i - 1;
                        mo2996l = f;
                    } else {
                        z3 = mo2951b;
                        z4 = z6;
                        mo2996l = f;
                        i2 = i;
                        mo3071v = z;
                        baseDanmaku4 = baseDanmaku3;
                    }
                }
            }
            if (interfaceC15368g == null || !interfaceC15368g.mo2949a(baseDanmaku, mo2996l, i2, z4)) {
                if (z3) {
                    clear();
                }
                baseDanmaku.mo2995y(iDisplayer, baseDanmaku.mo2999g(), mo2996l);
                if (mo3071v) {
                    return;
                }
                this.f43993e.mo3051g(baseDanmaku4);
                this.f43993e.mo3049i(baseDanmaku);
            }
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15365d, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15363c
        /* renamed from: b */
        protected boolean mo2951b(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
            if (f >= iDisplayer.mo3028r()) {
                return (baseDanmaku2 == null || baseDanmaku2.mo3000d() == ((float) iDisplayer.getHeight())) ? false : true;
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15363c, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15366e
        public void clear() {
            this.f44003b = true;
            this.f43993e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15363c implements InterfaceC15366e {

        /* renamed from: a */
        protected Danmakus f44002a;

        /* renamed from: b */
        protected boolean f44003b;

        /* renamed from: c */
        protected C15364a f44004c;

        /* compiled from: DanmakusRetainer.java */
        /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        protected class C15364a extends IDanmakus.AbstractC15349b<BaseDanmaku, C15367f> {

            /* renamed from: e */
            public IDisplayer f44005e;

            /* renamed from: f */
            int f44006f = 0;

            /* renamed from: g */
            public BaseDanmaku f44007g = null;

            /* renamed from: h */
            public BaseDanmaku f44008h = null;

            /* renamed from: i */
            public BaseDanmaku f44009i = null;

            /* renamed from: j */
            public BaseDanmaku f44010j = null;

            /* renamed from: k */
            public BaseDanmaku f44011k = null;

            /* renamed from: l */
            boolean f44012l = false;

            /* renamed from: m */
            boolean f44013m = false;

            /* renamed from: n */
            boolean f44014n = false;

            protected C15364a() {
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: c */
            public void mo2955c() {
                this.f44006f = 0;
                this.f44010j = null;
                this.f44009i = null;
                this.f44008h = null;
                this.f44007g = null;
                this.f44014n = false;
                this.f44013m = false;
                this.f44012l = false;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                if (C15363c.this.f44003b) {
                    return 1;
                }
                this.f44006f++;
                BaseDanmaku baseDanmaku2 = this.f44011k;
                if (baseDanmaku == baseDanmaku2) {
                    this.f44007g = baseDanmaku;
                    this.f44009i = null;
                    this.f44013m = true;
                    this.f44014n = false;
                    return 1;
                }
                if (this.f44008h == null) {
                    this.f44008h = baseDanmaku;
                }
                if (baseDanmaku2.f43875q + baseDanmaku.mo2996l() > this.f44005e.getHeight()) {
                    this.f44012l = true;
                    return 1;
                }
                BaseDanmaku baseDanmaku3 = this.f44010j;
                if (baseDanmaku3 == null) {
                    this.f44010j = baseDanmaku;
                } else if (baseDanmaku3.mo2997i() >= baseDanmaku.mo2997i()) {
                    this.f44010j = baseDanmaku;
                }
                IDisplayer iDisplayer = this.f44005e;
                BaseDanmaku baseDanmaku4 = this.f44011k;
                boolean m59957i = DanmakuUtils.m59957i(iDisplayer, baseDanmaku, baseDanmaku4, baseDanmaku4.m3085f(), this.f44011k.m3083k().f43885a);
                this.f44014n = m59957i;
                if (!m59957i) {
                    this.f44007g = baseDanmaku;
                    return 1;
                }
                this.f44009i = baseDanmaku;
                return 0;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: f */
            public C15367f mo2954d() {
                C15367f c15367f = new C15367f();
                c15367f.f44016a = this.f44006f;
                c15367f.f44018c = this.f44008h;
                c15367f.f44017b = this.f44007g;
                c15367f.f44019d = this.f44009i;
                c15367f.f44020e = this.f44010j;
                c15367f.f44022g = this.f44012l;
                c15367f.f44023h = this.f44013m;
                c15367f.f44024i = this.f44014n;
                return c15367f;
            }
        }

        private C15363c() {
            this.f44002a = new Danmakus(1);
            this.f44003b = false;
            this.f44004c = new C15364a();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e2  */
        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15366e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo2950a(master.flame.danmaku.danmaku.model.BaseDanmaku r20, master.flame.danmaku.danmaku.model.IDisplayer r21, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15368g r22) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15363c.mo2950a(master.flame.danmaku.danmaku.model.d, master.flame.danmaku.danmaku.model.n, master.flame.danmaku.danmaku.renderer.android.b$g):void");
        }

        /* renamed from: b */
        protected boolean mo2951b(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
            if (f >= iDisplayer.mo3028r()) {
                return (baseDanmaku2 != null && baseDanmaku2.mo2996l() > 0.0f) || f + baseDanmaku.f43875q > ((float) iDisplayer.getHeight());
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15366e
        public void clear() {
            this.f44003b = true;
            this.f44002a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15365d extends C15363c {
        private C15365d() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.C15363c
        /* renamed from: b */
        protected boolean mo2951b(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
            return f + baseDanmaku.f43875q > ((float) iDisplayer.getHeight());
        }
    }

    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15366e {
        /* renamed from: a */
        void mo2950a(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, InterfaceC15368g interfaceC15368g);

        void clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15367f {

        /* renamed from: a */
        public int f44016a;

        /* renamed from: b */
        public BaseDanmaku f44017b;

        /* renamed from: c */
        public BaseDanmaku f44018c;

        /* renamed from: d */
        public BaseDanmaku f44019d;

        /* renamed from: e */
        public BaseDanmaku f44020e;

        /* renamed from: f */
        public BaseDanmaku f44021f;

        /* renamed from: g */
        public boolean f44022g;

        /* renamed from: h */
        public boolean f44023h;

        /* renamed from: i */
        public boolean f44024i;

        private C15367f() {
            this.f44016a = 0;
            this.f44017b = null;
            this.f44018c = null;
            this.f44019d = null;
            this.f44020e = null;
            this.f44021f = null;
            this.f44022g = false;
            this.f44023h = false;
            this.f44024i = false;
        }
    }

    /* compiled from: DanmakusRetainer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15368g {
        /* renamed from: a */
        boolean mo2949a(BaseDanmaku baseDanmaku, float f, int i, boolean z);
    }

    public DanmakusRetainer(boolean z) {
        m2961a(z);
    }

    /* renamed from: a */
    public void m2961a(boolean z) {
        this.f43988a = z ? new C15361b() : new C15363c();
        this.f43989b = z ? new C15361b() : new C15363c();
        if (this.f43990c == null) {
            this.f43990c = new C15365d();
        }
        if (this.f43991d == null) {
            this.f43991d = new C15361b();
        }
    }

    /* renamed from: b */
    public void m2960b() {
        InterfaceC15366e interfaceC15366e = this.f43988a;
        if (interfaceC15366e != null) {
            interfaceC15366e.clear();
        }
        InterfaceC15366e interfaceC15366e2 = this.f43989b;
        if (interfaceC15366e2 != null) {
            interfaceC15366e2.clear();
        }
        InterfaceC15366e interfaceC15366e3 = this.f43990c;
        if (interfaceC15366e3 != null) {
            interfaceC15366e3.clear();
        }
        InterfaceC15366e interfaceC15366e4 = this.f43991d;
        if (interfaceC15366e4 != null) {
            interfaceC15366e4.clear();
        }
    }

    /* renamed from: c */
    public void m2959c(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, InterfaceC15368g interfaceC15368g) {
        int type = baseDanmaku.getType();
        if (type == 1) {
            this.f43988a.mo2950a(baseDanmaku, iDisplayer, interfaceC15368g);
        } else if (type == 4) {
            this.f43991d.mo2950a(baseDanmaku, iDisplayer, interfaceC15368g);
        } else if (type == 5) {
            this.f43990c.mo2950a(baseDanmaku, iDisplayer, interfaceC15368g);
        } else if (type == 6) {
            this.f43989b.mo2950a(baseDanmaku, iDisplayer, interfaceC15368g);
        } else if (type != 7) {
        } else {
            baseDanmaku.mo2995y(iDisplayer, 0.0f, 0.0f);
        }
    }

    /* renamed from: d */
    public void m2958d() {
        m2960b();
    }
}
