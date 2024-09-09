package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BaseDanmaku.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d {

    /* renamed from: L  reason: collision with root package name */
    public static final String f61145L = "/n";
    public static final int M = 1;
    public static final int N = 6;
    public static final int O = 5;
    public static final int P = 4;
    public static final int Q = 7;
    public static final int R = 0;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 1;
    public static final int V = 2;
    public boolean A;
    public String C;
    public boolean D;
    protected f E;

    /* renamed from: a  reason: collision with root package name */
    private long f61146a;

    /* renamed from: b  reason: collision with root package name */
    public long f61147b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f61148c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f61149d;

    /* renamed from: e  reason: collision with root package name */
    public Object f61150e;

    /* renamed from: f  reason: collision with root package name */
    public Object f61151f;

    /* renamed from: g  reason: collision with root package name */
    public int f61152g;

    /* renamed from: h  reason: collision with root package name */
    public float f61153h;

    /* renamed from: i  reason: collision with root package name */
    public float f61154i;

    /* renamed from: j  reason: collision with root package name */
    public int f61155j;

    /* renamed from: r  reason: collision with root package name */
    public g f61163r;

    /* renamed from: s  reason: collision with root package name */
    public int f61164s;

    /* renamed from: t  reason: collision with root package name */
    public int f61165t;

    /* renamed from: y  reason: collision with root package name */
    public o<?> f61170y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f61171z;

    /* renamed from: k  reason: collision with root package name */
    public int f61156k = 0;

    /* renamed from: l  reason: collision with root package name */
    public float f61157l = -1.0f;

    /* renamed from: m  reason: collision with root package name */
    public int f61158m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f61159n = 0;

    /* renamed from: o  reason: collision with root package name */
    public byte f61160o = 0;

    /* renamed from: p  reason: collision with root package name */
    public float f61161p = -1.0f;

    /* renamed from: q  reason: collision with root package name */
    public float f61162q = -1.0f;

    /* renamed from: u  reason: collision with root package name */
    private int f61166u = 0;

    /* renamed from: v  reason: collision with root package name */
    public int f61167v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f61168w = 0;

    /* renamed from: x  reason: collision with root package name */
    public int f61169x = -1;
    public int B = 0;
    protected int F = c.f61143a;
    public int G = 0;
    public int H = -1;
    public j I = null;
    public int J = 0;
    public int K = -1;

    public void A(n nVar, boolean z3) {
        nVar.s(this, z3);
        this.f61169x = this.I.f61184f;
    }

    public void B(g gVar) {
        this.f61163r = gVar;
    }

    public void C(Object obj) {
        this.f61151f = obj;
    }

    public void D(long j4) {
        this.f61146a = j4;
        this.f61147b = 0L;
    }

    public void E(long j4) {
        this.f61147b = j4;
        this.f61168w = this.I.f61183e;
    }

    public void F(f fVar) {
        this.E = fVar;
    }

    public void G(boolean z3) {
        if (z3) {
            this.f61166u = this.I.f61180b;
            this.f61165t = 1;
            return;
        }
        this.f61165t = 0;
    }

    public int a(n nVar) {
        return nVar.l(this);
    }

    public long b() {
        j jVar = this.I;
        if (jVar != null && jVar.f61183e == this.f61168w) {
            return this.f61146a + this.f61147b;
        }
        this.f61147b = 0L;
        return this.f61146a;
    }

    public int c() {
        return this.F;
    }

    public abstract float d();

    public o<?> e() {
        return this.f61170y;
    }

    public long f() {
        return this.f61163r.f61176c;
    }

    public abstract float g();

    public abstract int getType();

    public abstract float[] h(n nVar, long j4);

    public abstract float i();

    public long j() {
        return this.f61146a;
    }

    public f k() {
        return this.E;
    }

    public abstract float l();

    public boolean m() {
        if (this.H != this.I.f61181c) {
            this.G = 0;
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.H == this.I.f61181c && this.G != 0;
    }

    public boolean o(int i4) {
        return this.H == this.I.f61181c && (this.G & i4) == i4;
    }

    public boolean p() {
        f fVar = this.E;
        return fVar == null || fVar.f61172a < b();
    }

    public boolean q() {
        return this.f61161p > -1.0f && this.f61162q > -1.0f && this.f61167v == this.I.f61179a;
    }

    public boolean r() {
        j jVar = this.I;
        if (jVar != null && jVar.f61183e == this.f61168w) {
            return this.f61147b != 0;
        }
        this.f61147b = 0L;
        return false;
    }

    public boolean s() {
        f fVar = this.E;
        return fVar == null || t(fVar.f61172a);
    }

    public boolean t(long j4) {
        long b4 = j4 - b();
        return b4 <= 0 || b4 >= this.f61163r.f61176c;
    }

    public boolean u() {
        return this.f61169x == this.I.f61184f;
    }

    public boolean v() {
        return this.f61165t == 1 && this.f61166u == this.I.f61180b;
    }

    public boolean w() {
        f fVar = this.E;
        return fVar == null || x(fVar.f61172a);
    }

    public boolean x(long j4) {
        return j4 - b() >= this.f61163r.f61176c;
    }

    public abstract void y(n nVar, float f4, float f5);

    public void z(n nVar, boolean z3) {
        nVar.j(this, z3);
        this.f61167v = this.I.f61179a;
    }
}
