package f3;

import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* compiled from: IRenderer.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f54673a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f54674b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f54675c = 2;

    /* compiled from: IRenderer.java */
    /* renamed from: f3.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class C1077a {

        /* renamed from: a  reason: collision with root package name */
        public final float[] f54676a = new float[4];

        /* renamed from: b  reason: collision with root package name */
        private int f54677b;

        /* renamed from: c  reason: collision with root package name */
        private int f54678c;

        public void a() {
            c(this.f54678c, this.f54677b, 0.0f, 0.0f);
        }

        public void b() {
            c(0.0f, 0.0f, this.f54678c, this.f54677b);
        }

        public void c(float f4, float f5, float f6, float f7) {
            float[] fArr = this.f54676a;
            fArr[0] = f4;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = f7;
        }

        public void d(int i4, int i5) {
            this.f54678c = i4;
            this.f54677b = i5;
        }
    }

    /* compiled from: IRenderer.java */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface b {
        void a(d dVar);
    }

    /* compiled from: IRenderer.java */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: v  reason: collision with root package name */
        public static final int f54679v = -1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f54680a;

        /* renamed from: c  reason: collision with root package name */
        public int f54682c;

        /* renamed from: d  reason: collision with root package name */
        public int f54683d;

        /* renamed from: e  reason: collision with root package name */
        public d f54684e;

        /* renamed from: f  reason: collision with root package name */
        public int f54685f;

        /* renamed from: g  reason: collision with root package name */
        public int f54686g;

        /* renamed from: h  reason: collision with root package name */
        public int f54687h;

        /* renamed from: i  reason: collision with root package name */
        public int f54688i;

        /* renamed from: j  reason: collision with root package name */
        public int f54689j;

        /* renamed from: k  reason: collision with root package name */
        public int f54690k;

        /* renamed from: l  reason: collision with root package name */
        public int f54691l;

        /* renamed from: m  reason: collision with root package name */
        public long f54692m;

        /* renamed from: n  reason: collision with root package name */
        public long f54693n;

        /* renamed from: o  reason: collision with root package name */
        public long f54694o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f54695p;

        /* renamed from: q  reason: collision with root package name */
        public long f54696q;

        /* renamed from: r  reason: collision with root package name */
        public long f54697r;

        /* renamed from: s  reason: collision with root package name */
        public long f54698s;

        /* renamed from: u  reason: collision with root package name */
        private boolean f54700u;

        /* renamed from: b  reason: collision with root package name */
        public f f54681b = new f();

        /* renamed from: t  reason: collision with root package name */
        private m f54699t = new e(4);

        public int a(int i4, int i5) {
            if (i4 == 1) {
                int i6 = this.f54685f + i5;
                this.f54685f = i6;
                return i6;
            } else if (i4 == 4) {
                int i7 = this.f54688i + i5;
                this.f54688i = i7;
                return i7;
            } else if (i4 == 5) {
                int i8 = this.f54687h + i5;
                this.f54687h = i8;
                return i8;
            } else if (i4 == 6) {
                int i9 = this.f54686g + i5;
                this.f54686g = i9;
                return i9;
            } else if (i4 != 7) {
                return 0;
            } else {
                int i10 = this.f54689j + i5;
                this.f54689j = i10;
                return i10;
            }
        }

        public int b(int i4) {
            int i5 = this.f54690k + i4;
            this.f54690k = i5;
            return i5;
        }

        public void c(d dVar) {
            if (this.f54700u) {
                return;
            }
            this.f54699t.i(dVar);
        }

        public m d() {
            m mVar;
            this.f54700u = true;
            synchronized (this) {
                mVar = this.f54699t;
                this.f54699t = new e(4);
            }
            this.f54700u = false;
            return mVar;
        }

        public void e() {
            this.f54691l = this.f54690k;
            this.f54690k = 0;
            this.f54689j = 0;
            this.f54688i = 0;
            this.f54687h = 0;
            this.f54686g = 0;
            this.f54685f = 0;
            this.f54692m = 0L;
            this.f54694o = 0L;
            this.f54693n = 0L;
            this.f54696q = 0L;
            this.f54695p = false;
            synchronized (this) {
                this.f54699t.clear();
            }
        }

        public void f(c cVar) {
            if (cVar == null) {
                return;
            }
            this.f54691l = cVar.f54691l;
            this.f54685f = cVar.f54685f;
            this.f54686g = cVar.f54686g;
            this.f54687h = cVar.f54687h;
            this.f54688i = cVar.f54688i;
            this.f54689j = cVar.f54689j;
            this.f54690k = cVar.f54690k;
            this.f54692m = cVar.f54692m;
            this.f54693n = cVar.f54693n;
            this.f54694o = cVar.f54694o;
            this.f54695p = cVar.f54695p;
            this.f54696q = cVar.f54696q;
            this.f54697r = cVar.f54697r;
            this.f54698s = cVar.f54698s;
        }
    }

    void a(n nVar, m mVar, long j4, c cVar);

    void b(boolean z3);

    void c(b bVar);

    void clear();

    void d(k kVar);

    void e(boolean z3);

    void f();

    void g();

    void release();
}
