package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class BaseDanmaku {

    /* renamed from: L */
    public static final String f43837L = "/n";

    /* renamed from: M */
    public static final int f43838M = 1;

    /* renamed from: N */
    public static final int f43839N = 6;

    /* renamed from: O */
    public static final int f43840O = 5;

    /* renamed from: P */
    public static final int f43841P = 4;

    /* renamed from: Q */
    public static final int f43842Q = 7;

    /* renamed from: R */
    public static final int f43843R = 0;

    /* renamed from: S */
    public static final int f43844S = 0;

    /* renamed from: T */
    public static final int f43845T = 1;

    /* renamed from: U */
    public static final int f43846U = 1;

    /* renamed from: V */
    public static final int f43847V = 2;

    /* renamed from: A */
    public boolean f43848A;

    /* renamed from: C */
    public String f43850C;

    /* renamed from: D */
    public boolean f43851D;

    /* renamed from: E */
    protected DanmakuTimer f43852E;

    /* renamed from: a */
    private long f43859a;

    /* renamed from: b */
    public long f43860b;

    /* renamed from: c */
    public CharSequence f43861c;

    /* renamed from: d */
    public String[] f43862d;

    /* renamed from: e */
    public Object f43863e;

    /* renamed from: f */
    public Object f43864f;

    /* renamed from: g */
    public int f43865g;

    /* renamed from: h */
    public float f43866h;

    /* renamed from: i */
    public float f43867i;

    /* renamed from: j */
    public int f43868j;

    /* renamed from: r */
    public C15347g f43876r;

    /* renamed from: s */
    public int f43877s;

    /* renamed from: t */
    public int f43878t;

    /* renamed from: y */
    public IDrawingCache<?> f43883y;

    /* renamed from: z */
    public boolean f43884z;

    /* renamed from: k */
    public int f43869k = 0;

    /* renamed from: l */
    public float f43870l = -1.0f;

    /* renamed from: m */
    public int f43871m = 0;

    /* renamed from: n */
    public int f43872n = 0;

    /* renamed from: o */
    public byte f43873o = 0;

    /* renamed from: p */
    public float f43874p = -1.0f;

    /* renamed from: q */
    public float f43875q = -1.0f;

    /* renamed from: u */
    private int f43879u = 0;

    /* renamed from: v */
    public int f43880v = 0;

    /* renamed from: w */
    public int f43881w = 0;

    /* renamed from: x */
    public int f43882x = -1;

    /* renamed from: B */
    public int f43849B = 0;

    /* renamed from: F */
    protected int f43853F = AlphaValue.f43835a;

    /* renamed from: G */
    public int f43854G = 0;

    /* renamed from: H */
    public int f43855H = -1;

    /* renamed from: I */
    public GlobalFlagValues f43856I = null;

    /* renamed from: J */
    public int f43857J = 0;

    /* renamed from: K */
    public int f43858K = -1;

    /* renamed from: A */
    public void m3096A(IDisplayer iDisplayer, boolean z) {
        iDisplayer.mo3027s(this, z);
        this.f43882x = this.f43856I.f43901f;
    }

    /* renamed from: B */
    public void m3095B(C15347g c15347g) {
        this.f43876r = c15347g;
    }

    /* renamed from: C */
    public void m3094C(Object obj) {
        this.f43864f = obj;
    }

    /* renamed from: D */
    public void m3093D(long j) {
        this.f43859a = j;
        this.f43860b = 0L;
    }

    /* renamed from: E */
    public void m3092E(long j) {
        this.f43860b = j;
        this.f43881w = this.f43856I.f43900e;
    }

    /* renamed from: F */
    public void m3091F(DanmakuTimer danmakuTimer) {
        this.f43852E = danmakuTimer;
    }

    /* renamed from: G */
    public void m3090G(boolean z) {
        if (z) {
            this.f43879u = this.f43856I.f43897b;
            this.f43878t = 1;
            return;
        }
        this.f43878t = 0;
    }

    /* renamed from: a */
    public int m3089a(IDisplayer iDisplayer) {
        return iDisplayer.mo3034l(this);
    }

    /* renamed from: b */
    public long m3088b() {
        GlobalFlagValues globalFlagValues = this.f43856I;
        if (globalFlagValues != null && globalFlagValues.f43900e == this.f43881w) {
            return this.f43859a + this.f43860b;
        }
        this.f43860b = 0L;
        return this.f43859a;
    }

    /* renamed from: c */
    public int m3087c() {
        return this.f43853F;
    }

    /* renamed from: d */
    public abstract float mo3000d();

    /* renamed from: e */
    public IDrawingCache<?> m3086e() {
        return this.f43883y;
    }

    /* renamed from: f */
    public long m3085f() {
        return this.f43876r.f43889c;
    }

    /* renamed from: g */
    public abstract float mo2999g();

    public abstract int getType();

    /* renamed from: h */
    public abstract float[] mo2998h(IDisplayer iDisplayer, long j);

    /* renamed from: i */
    public abstract float mo2997i();

    /* renamed from: j */
    public long m3084j() {
        return this.f43859a;
    }

    /* renamed from: k */
    public DanmakuTimer m3083k() {
        return this.f43852E;
    }

    /* renamed from: l */
    public abstract float mo2996l();

    /* renamed from: m */
    public boolean m3082m() {
        if (this.f43855H != this.f43856I.f43898c) {
            this.f43854G = 0;
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public boolean m3081n() {
        return this.f43855H == this.f43856I.f43898c && this.f43854G != 0;
    }

    /* renamed from: o */
    public boolean m3080o(int i) {
        return this.f43855H == this.f43856I.f43898c && (this.f43854G & i) == i;
    }

    /* renamed from: p */
    public boolean m3079p() {
        DanmakuTimer danmakuTimer = this.f43852E;
        return danmakuTimer == null || danmakuTimer.f43885a < m3088b();
    }

    /* renamed from: q */
    public boolean m3078q() {
        return this.f43874p > -1.0f && this.f43875q > -1.0f && this.f43880v == this.f43856I.f43896a;
    }

    /* renamed from: r */
    public boolean m3077r() {
        GlobalFlagValues globalFlagValues = this.f43856I;
        if (globalFlagValues != null && globalFlagValues.f43900e == this.f43881w) {
            return this.f43860b != 0;
        }
        this.f43860b = 0L;
        return false;
    }

    /* renamed from: s */
    public boolean m3076s() {
        DanmakuTimer danmakuTimer = this.f43852E;
        return danmakuTimer == null || m3075t(danmakuTimer.f43885a);
    }

    /* renamed from: t */
    public boolean m3075t(long j) {
        long m3088b = j - m3088b();
        return m3088b <= 0 || m3088b >= this.f43876r.f43889c;
    }

    /* renamed from: u */
    public boolean m3074u() {
        return this.f43882x == this.f43856I.f43901f;
    }

    /* renamed from: v */
    public boolean mo3071v() {
        return this.f43878t == 1 && this.f43879u == this.f43856I.f43897b;
    }

    /* renamed from: w */
    public boolean m3073w() {
        DanmakuTimer danmakuTimer = this.f43852E;
        return danmakuTimer == null || m3072x(danmakuTimer.f43885a);
    }

    /* renamed from: x */
    public boolean m3072x(long j) {
        return j - m3088b() >= this.f43876r.f43889c;
    }

    /* renamed from: y */
    public abstract void mo2995y(IDisplayer iDisplayer, float f, float f2);

    /* renamed from: z */
    public void mo3006z(IDisplayer iDisplayer, boolean z) {
        iDisplayer.mo3036j(this, z);
        this.f43880v = this.f43856I.f43896a;
    }
}
