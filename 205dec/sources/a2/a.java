package a2;

import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IRenderer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f105a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f106b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f107c = 2;

    /* compiled from: IRenderer.java */
    /* renamed from: a2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C0007a {

        /* renamed from: a  reason: collision with root package name */
        public final float[] f108a = new float[4];

        /* renamed from: b  reason: collision with root package name */
        private int f109b;

        /* renamed from: c  reason: collision with root package name */
        private int f110c;

        public void a() {
            c(this.f110c, this.f109b, 0.0f, 0.0f);
        }

        public void b() {
            c(0.0f, 0.0f, this.f110c, this.f109b);
        }

        public void c(float f4, float f5, float f6, float f7) {
            float[] fArr = this.f108a;
            fArr[0] = f4;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = f7;
        }

        public void d(int i4, int i5) {
            this.f110c = i4;
            this.f109b = i5;
        }
    }

    /* compiled from: IRenderer.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface b {
        void a(d dVar);
    }

    /* compiled from: IRenderer.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c {

        /* renamed from: v  reason: collision with root package name */
        public static final int f111v = -1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f112a;

        /* renamed from: c  reason: collision with root package name */
        public int f114c;

        /* renamed from: d  reason: collision with root package name */
        public int f115d;

        /* renamed from: e  reason: collision with root package name */
        public d f116e;

        /* renamed from: f  reason: collision with root package name */
        public int f117f;

        /* renamed from: g  reason: collision with root package name */
        public int f118g;

        /* renamed from: h  reason: collision with root package name */
        public int f119h;

        /* renamed from: i  reason: collision with root package name */
        public int f120i;

        /* renamed from: j  reason: collision with root package name */
        public int f121j;

        /* renamed from: k  reason: collision with root package name */
        public int f122k;

        /* renamed from: l  reason: collision with root package name */
        public int f123l;

        /* renamed from: m  reason: collision with root package name */
        public long f124m;

        /* renamed from: n  reason: collision with root package name */
        public long f125n;

        /* renamed from: o  reason: collision with root package name */
        public long f126o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f127p;

        /* renamed from: q  reason: collision with root package name */
        public long f128q;

        /* renamed from: r  reason: collision with root package name */
        public long f129r;

        /* renamed from: s  reason: collision with root package name */
        public long f130s;

        /* renamed from: u  reason: collision with root package name */
        private boolean f132u;

        /* renamed from: b  reason: collision with root package name */
        public f f113b = new f();

        /* renamed from: t  reason: collision with root package name */
        private m f131t = new e(4);

        public int a(int i4, int i5) {
            if (i4 == 1) {
                int i6 = this.f117f + i5;
                this.f117f = i6;
                return i6;
            } else if (i4 == 4) {
                int i7 = this.f120i + i5;
                this.f120i = i7;
                return i7;
            } else if (i4 == 5) {
                int i8 = this.f119h + i5;
                this.f119h = i8;
                return i8;
            } else if (i4 == 6) {
                int i9 = this.f118g + i5;
                this.f118g = i9;
                return i9;
            } else if (i4 != 7) {
                return 0;
            } else {
                int i10 = this.f121j + i5;
                this.f121j = i10;
                return i10;
            }
        }

        public int b(int i4) {
            int i5 = this.f122k + i4;
            this.f122k = i5;
            return i5;
        }

        public void c(d dVar) {
            if (this.f132u) {
                return;
            }
            this.f131t.i(dVar);
        }

        public m d() {
            m mVar;
            this.f132u = true;
            synchronized (this) {
                mVar = this.f131t;
                this.f131t = new e(4);
            }
            this.f132u = false;
            return mVar;
        }

        public void e() {
            this.f123l = this.f122k;
            this.f122k = 0;
            this.f121j = 0;
            this.f120i = 0;
            this.f119h = 0;
            this.f118g = 0;
            this.f117f = 0;
            this.f124m = 0L;
            this.f126o = 0L;
            this.f125n = 0L;
            this.f128q = 0L;
            this.f127p = false;
            synchronized (this) {
                this.f131t.clear();
            }
        }

        public void f(c cVar) {
            if (cVar == null) {
                return;
            }
            this.f123l = cVar.f123l;
            this.f117f = cVar.f117f;
            this.f118g = cVar.f118g;
            this.f119h = cVar.f119h;
            this.f120i = cVar.f120i;
            this.f121j = cVar.f121j;
            this.f122k = cVar.f122k;
            this.f124m = cVar.f124m;
            this.f125n = cVar.f125n;
            this.f126o = cVar.f126o;
            this.f127p = cVar.f127p;
            this.f128q = cVar.f128q;
            this.f129r = cVar.f129r;
            this.f130s = cVar.f130s;
        }
    }

    void a(n nVar, m mVar, long j4, c cVar);

    void b(boolean z3);

    void c(k kVar);

    void clear();

    void d(boolean z3);

    void e();

    void f();

    void g(b bVar);

    void release();
}
