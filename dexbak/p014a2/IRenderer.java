package p014a2;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.ICacheManager;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.Danmakus;

/* renamed from: a2.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IRenderer {

    /* renamed from: a */
    public static final int f52a = 0;

    /* renamed from: b */
    public static final int f53b = 1;

    /* renamed from: c */
    public static final int f54c = 2;

    /* compiled from: IRenderer.java */
    /* renamed from: a2.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C0023a {

        /* renamed from: a */
        public final float[] f55a = new float[4];

        /* renamed from: b */
        private int f56b;

        /* renamed from: c */
        private int f57c;

        /* renamed from: a */
        public void m60046a() {
            m60044c(this.f57c, this.f56b, 0.0f, 0.0f);
        }

        /* renamed from: b */
        public void m60045b() {
            m60044c(0.0f, 0.0f, this.f57c, this.f56b);
        }

        /* renamed from: c */
        public void m60044c(float f, float f2, float f3, float f4) {
            float[] fArr = this.f55a;
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
        }

        /* renamed from: d */
        public void m60043d(int i, int i2) {
            this.f57c = i;
            this.f56b = i2;
        }
    }

    /* compiled from: IRenderer.java */
    /* renamed from: a2.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC0024b {
        /* renamed from: a */
        void mo3284a(BaseDanmaku baseDanmaku);
    }

    /* compiled from: IRenderer.java */
    /* renamed from: a2.a$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C0025c {

        /* renamed from: v */
        public static final int f58v = -1;

        /* renamed from: a */
        public boolean f59a;

        /* renamed from: c */
        public int f61c;

        /* renamed from: d */
        public int f62d;

        /* renamed from: e */
        public BaseDanmaku f63e;

        /* renamed from: f */
        public int f64f;

        /* renamed from: g */
        public int f65g;

        /* renamed from: h */
        public int f66h;

        /* renamed from: i */
        public int f67i;

        /* renamed from: j */
        public int f68j;

        /* renamed from: k */
        public int f69k;

        /* renamed from: l */
        public int f70l;

        /* renamed from: m */
        public long f71m;

        /* renamed from: n */
        public long f72n;

        /* renamed from: o */
        public long f73o;

        /* renamed from: p */
        public boolean f74p;

        /* renamed from: q */
        public long f75q;

        /* renamed from: r */
        public long f76r;

        /* renamed from: s */
        public long f77s;

        /* renamed from: u */
        private boolean f79u;

        /* renamed from: b */
        public DanmakuTimer f60b = new DanmakuTimer();

        /* renamed from: t */
        private IDanmakus f78t = new Danmakus(4);

        /* renamed from: a */
        public int m60042a(int i, int i2) {
            if (i == 1) {
                int i3 = this.f64f + i2;
                this.f64f = i3;
                return i3;
            } else if (i == 4) {
                int i4 = this.f67i + i2;
                this.f67i = i4;
                return i4;
            } else if (i == 5) {
                int i5 = this.f66h + i2;
                this.f66h = i5;
                return i5;
            } else if (i == 6) {
                int i6 = this.f65g + i2;
                this.f65g = i6;
                return i6;
            } else if (i != 7) {
                return 0;
            } else {
                int i7 = this.f68j + i2;
                this.f68j = i7;
                return i7;
            }
        }

        /* renamed from: b */
        public int m60041b(int i) {
            int i2 = this.f69k + i;
            this.f69k = i2;
            return i2;
        }

        /* renamed from: c */
        public void m60040c(BaseDanmaku baseDanmaku) {
            if (this.f79u) {
                return;
            }
            this.f78t.mo3049i(baseDanmaku);
        }

        /* renamed from: d */
        public IDanmakus m60039d() {
            IDanmakus iDanmakus;
            this.f79u = true;
            synchronized (this) {
                iDanmakus = this.f78t;
                this.f78t = new Danmakus(4);
            }
            this.f79u = false;
            return iDanmakus;
        }

        /* renamed from: e */
        public void m60038e() {
            this.f70l = this.f69k;
            this.f69k = 0;
            this.f68j = 0;
            this.f67i = 0;
            this.f66h = 0;
            this.f65g = 0;
            this.f64f = 0;
            this.f71m = 0L;
            this.f73o = 0L;
            this.f72n = 0L;
            this.f75q = 0L;
            this.f74p = false;
            synchronized (this) {
                this.f78t.clear();
            }
        }

        /* renamed from: f */
        public void m60037f(C0025c c0025c) {
            if (c0025c == null) {
                return;
            }
            this.f70l = c0025c.f70l;
            this.f64f = c0025c.f64f;
            this.f65g = c0025c.f65g;
            this.f66h = c0025c.f66h;
            this.f67i = c0025c.f67i;
            this.f68j = c0025c.f68j;
            this.f69k = c0025c.f69k;
            this.f71m = c0025c.f71m;
            this.f72n = c0025c.f72n;
            this.f73o = c0025c.f73o;
            this.f74p = c0025c.f74p;
            this.f75q = c0025c.f75q;
            this.f76r = c0025c.f76r;
            this.f77s = c0025c.f77s;
        }
    }

    /* renamed from: a */
    void mo2976a(IDisplayer iDisplayer, IDanmakus iDanmakus, long j, C0025c c0025c);

    /* renamed from: b */
    void mo2975b(boolean z);

    /* renamed from: c */
    void mo2974c(ICacheManager iCacheManager);

    void clear();

    /* renamed from: d */
    void mo2973d(boolean z);

    /* renamed from: e */
    void mo2972e();

    /* renamed from: f */
    void mo2971f();

    /* renamed from: g */
    void mo2970g(InterfaceC0024b interfaceC0024b);

    void release();
}
