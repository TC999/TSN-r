package master.flame.danmaku.controller;

import android.graphics.Canvas;
import master.flame.danmaku.controller.IDrawTask;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.renderer.android.DanmakuRenderer;
import p014a2.IRenderer;
import p025b2.SystemClock;

/* renamed from: master.flame.danmaku.controller.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DrawTask implements IDrawTask {

    /* renamed from: w */
    static final /* synthetic */ boolean f43649w = false;

    /* renamed from: c */
    protected final DanmakuContext f43650c;

    /* renamed from: d */
    protected final AbsDisplayer f43651d;

    /* renamed from: e */
    protected IDanmakus f43652e;

    /* renamed from: f */
    protected BaseDanmakuParser f43653f;

    /* renamed from: g */
    IDrawTask.InterfaceC15341a f43654g;

    /* renamed from: h */
    final IRenderer f43655h;

    /* renamed from: i */
    DanmakuTimer f43656i;

    /* renamed from: k */
    protected boolean f43658k;

    /* renamed from: n */
    protected boolean f43661n;

    /* renamed from: o */
    private long f43662o;

    /* renamed from: p */
    private long f43663p;

    /* renamed from: q */
    protected int f43664q;

    /* renamed from: r */
    private boolean f43665r;

    /* renamed from: s */
    private BaseDanmaku f43666s;

    /* renamed from: u */
    private IDanmakus f43668u;

    /* renamed from: j */
    private IDanmakus f43657j = new Danmakus(4);

    /* renamed from: l */
    private long f43659l = 0;

    /* renamed from: m */
    private final IRenderer.C0025c f43660m = new IRenderer.C0025c();

    /* renamed from: t */
    private Danmakus f43667t = new Danmakus(4);

    /* renamed from: v */
    private DanmakuContext.InterfaceC15342a f43669v = new C15333a();

    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15333a implements DanmakuContext.InterfaceC15342a {
        C15333a() {
        }

        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.InterfaceC15342a
        /* renamed from: a */
        public boolean mo3201a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return DrawTask.this.mo3287t(danmakuContext, danmakuConfigTag, objArr);
        }
    }

    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15334b implements IRenderer.InterfaceC0024b {
        C15334b() {
        }

        @Override // p014a2.IRenderer.InterfaceC0024b
        /* renamed from: a */
        public void mo3284a(BaseDanmaku baseDanmaku) {
            IDrawTask.InterfaceC15341a interfaceC15341a = DrawTask.this.f43654g;
            if (interfaceC15341a != null) {
                interfaceC15341a.mo3263a(baseDanmaku);
            }
        }
    }

    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15335c extends IDanmakus.AbstractC15350c<BaseDanmaku> {
        C15335c() {
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            if (baseDanmaku.f43884z) {
                DrawTask.this.mo3286u(baseDanmaku);
                return 2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15336d extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        long f43673e = SystemClock.m59951b();

        /* renamed from: f */
        final /* synthetic */ int f43674f;

        C15336d(int i) {
            this.f43674f = i;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            boolean m3073w = baseDanmaku.m3073w();
            if (SystemClock.m59951b() - this.f43673e <= this.f43674f && m3073w) {
                DrawTask.this.f43652e.mo3051g(baseDanmaku);
                DrawTask.this.mo3286u(baseDanmaku);
                return 2;
            }
            return 1;
        }
    }

    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15337e extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        final /* synthetic */ IDanmakus f43676e;

        C15337e(IDanmakus iDanmakus) {
            this.f43676e = iDanmakus;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            if (!baseDanmaku.mo3071v() || baseDanmaku.m3076s()) {
                return 0;
            }
            this.f43676e.mo3049i(baseDanmaku);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15338f implements BaseDanmakuParser.InterfaceC15357a {
        C15338f() {
        }

        @Override // master.flame.danmaku.danmaku.parser.BaseDanmakuParser.InterfaceC15357a
        /* renamed from: b */
        public void mo2977b(BaseDanmaku baseDanmaku) {
            IDrawTask.InterfaceC15341a interfaceC15341a = DrawTask.this.f43654g;
            if (interfaceC15341a != null) {
                interfaceC15341a.mo3262b(baseDanmaku);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawTask.java */
    /* renamed from: master.flame.danmaku.controller.e$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15339g extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        final /* synthetic */ long f43679e;

        C15339g(long j) {
            this.f43679e = j;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            if (baseDanmaku.m3076s()) {
                return 2;
            }
            baseDanmaku.m3092E(this.f43679e + baseDanmaku.f43860b);
            return baseDanmaku.f43860b == 0 ? 2 : 0;
        }
    }

    public DrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.InterfaceC15341a interfaceC15341a) {
        if (danmakuContext != null) {
            this.f43650c = danmakuContext;
            this.f43651d = danmakuContext.m3221g();
            this.f43654g = interfaceC15341a;
            DanmakuRenderer danmakuRenderer = new DanmakuRenderer(danmakuContext);
            this.f43655h = danmakuRenderer;
            danmakuRenderer.mo2970g(new C15334b());
            danmakuRenderer.mo2973d(danmakuContext.m3210r() || danmakuContext.m3211q());
            mo3289r(danmakuTimer);
            Boolean valueOf = Boolean.valueOf(danmakuContext.m3212p());
            if (valueOf != null) {
                if (valueOf.booleanValue()) {
                    danmakuContext.f43692C.m3388f(DanmakuFilters.f43572w);
                    return;
                } else {
                    danmakuContext.f43692C.m3383k(DanmakuFilters.f43572w);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    /* renamed from: n */
    private void m3293n(IRenderer.C0025c c0025c, IDanmakus iDanmakus, IDanmakus iDanmakus2) {
        c0025c.m60038e();
        c0025c.f60b.update(SystemClock.m59951b());
        c0025c.f61c = 0;
        c0025c.f62d = (iDanmakus != null ? iDanmakus.size() : 0) + (iDanmakus2 != null ? iDanmakus2.size() : 0);
    }

    /* renamed from: p */
    private void m3291p(IRenderer.C0025c c0025c) {
        boolean z = c0025c.f69k == 0;
        c0025c.f74p = z;
        if (z) {
            c0025c.f72n = -1L;
        }
        BaseDanmaku baseDanmaku = c0025c.f63e;
        c0025c.f63e = null;
        c0025c.f73o = baseDanmaku != null ? baseDanmaku.m3088b() : -1L;
        c0025c.f71m = c0025c.f60b.update(SystemClock.m59951b());
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: a */
    public synchronized void mo3276a(BaseDanmaku baseDanmaku) {
        boolean mo3049i;
        IDrawTask.InterfaceC15341a interfaceC15341a;
        boolean mo3049i2;
        if (this.f43652e == null) {
            return;
        }
        if (baseDanmaku.f43884z) {
            this.f43667t.mo3049i(baseDanmaku);
            m3285v(10);
        }
        baseDanmaku.f43877s = this.f43652e.size();
        boolean z = true;
        if (this.f43662o <= baseDanmaku.m3088b() && baseDanmaku.m3088b() <= this.f43663p) {
            synchronized (this.f43657j) {
                mo3049i2 = this.f43657j.mo3049i(baseDanmaku);
            }
            z = mo3049i2;
        } else if (baseDanmaku.f43884z) {
            z = false;
        }
        synchronized (this.f43652e) {
            mo3049i = this.f43652e.mo3049i(baseDanmaku);
        }
        if (!z || !mo3049i) {
            this.f43663p = 0L;
            this.f43662o = 0L;
        }
        if (mo3049i && (interfaceC15341a = this.f43654g) != null) {
            interfaceC15341a.mo3262b(baseDanmaku);
        }
        BaseDanmaku baseDanmaku2 = this.f43666s;
        if (baseDanmaku2 == null || (baseDanmaku2 != null && baseDanmaku.m3088b() > this.f43666s.m3088b())) {
            this.f43666s = baseDanmaku;
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: b */
    public void mo3275b(BaseDanmaku baseDanmaku, boolean z) {
        this.f43650c.m3221g().mo3100w().mo3121a(baseDanmaku);
        int i = baseDanmaku.f43857J | 2;
        baseDanmaku.f43857J = i;
        if (z) {
            baseDanmaku.f43874p = -1.0f;
            baseDanmaku.f43875q = -1.0f;
            baseDanmaku.f43857J = i | 1;
            baseDanmaku.f43880v++;
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: c */
    public synchronized void mo3274c(boolean z) {
        IDanmakus iDanmakus = this.f43652e;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            synchronized (this.f43652e) {
                if (!z) {
                    long j = this.f43656i.f43885a;
                    long j2 = this.f43650c.f43693D.f43792e;
                    IDanmakus mo3054d = this.f43652e.mo3054d((j - j2) - 100, j + j2);
                    if (mo3054d != null) {
                        this.f43657j = mo3054d;
                    }
                }
                this.f43652e.clear();
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: d */
    public synchronized void mo3273d() {
        IDanmakus iDanmakus = this.f43657j;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            synchronized (this.f43657j) {
                this.f43657j.mo3057a(new C15335c());
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: e */
    public IDanmakus mo3272e(long j) {
        IDanmakus iDanmakus;
        long j2 = this.f43650c.f43693D.f43792e;
        long j3 = (j - j2) - 100;
        long j4 = j + j2;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                iDanmakus = null;
                break;
            }
            try {
                iDanmakus = this.f43652e.mo3054d(j3, j4);
                break;
            } catch (Exception unused) {
                i = i2;
            }
        }
        Danmakus danmakus = new Danmakus();
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            iDanmakus.mo3057a(new C15337e(danmakus));
        }
        return danmakus;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: f */
    public void mo3271f() {
        this.f43663p = 0L;
        this.f43662o = 0L;
        this.f43665r = false;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: g */
    public void mo3270g(BaseDanmakuParser baseDanmakuParser) {
        this.f43653f = baseDanmakuParser;
        this.f43661n = false;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: h */
    public void mo3269h() {
        this.f43658k = true;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: i */
    public void mo3268i() {
        this.f43650c.m3229X();
        IRenderer iRenderer = this.f43655h;
        if (iRenderer != null) {
            iRenderer.release();
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: j */
    public synchronized IRenderer.C0025c mo3267j(AbsDisplayer absDisplayer) {
        return m3292o(absDisplayer, this.f43656i);
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: k */
    public void mo3266k(long j) {
        reset();
        this.f43650c.f43691B.m3059g();
        this.f43650c.f43691B.m3063c();
        this.f43659l = j;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: l */
    public void mo3265l() {
        this.f43665r = true;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    /* renamed from: m */
    public void mo3264m(long j, long j2, long j3) {
        IDanmakus m60039d = this.f43660m.m60039d();
        this.f43668u = m60039d;
        m60039d.mo3057a(new C15339g(j3));
        this.f43659l = j2;
    }

    /* renamed from: o */
    protected IRenderer.C0025c m3292o(AbsDisplayer absDisplayer, DanmakuTimer danmakuTimer) {
        long j;
        IDanmakus iDanmakus;
        IDanmakus iDanmakus2;
        if (this.f43658k) {
            this.f43655h.mo2972e();
            this.f43658k = false;
        }
        if (this.f43652e != null) {
            DrawHelper.m3299a((Canvas) absDisplayer.mo3099x());
            if (this.f43665r) {
                return this.f43660m;
            }
            IRenderer.C0025c c0025c = this.f43660m;
            long j2 = danmakuTimer.f43885a;
            long j3 = this.f43650c.f43693D.f43792e;
            long j4 = (j2 - j3) - 100;
            long j5 = j3 + j2;
            IDanmakus iDanmakus3 = this.f43657j;
            long j6 = this.f43662o;
            if (j6 <= j4) {
                j = this.f43663p;
                if (j2 <= j) {
                    iDanmakus = iDanmakus3;
                    iDanmakus2 = this.f43668u;
                    m3293n(c0025c, iDanmakus2, iDanmakus);
                    if (iDanmakus2 != null && !iDanmakus2.isEmpty()) {
                        IRenderer.C0025c c0025c2 = this.f43660m;
                        c0025c2.f59a = true;
                        this.f43655h.mo2976a(absDisplayer, iDanmakus2, 0L, c0025c2);
                    }
                    this.f43660m.f59a = false;
                    if (iDanmakus == null && !iDanmakus.isEmpty()) {
                        this.f43655h.mo2976a(this.f43651d, iDanmakus, this.f43659l, c0025c);
                        m3291p(c0025c);
                        if (c0025c.f74p) {
                            BaseDanmaku baseDanmaku = this.f43666s;
                            if (baseDanmaku != null && baseDanmaku.m3073w()) {
                                this.f43666s = null;
                                IDrawTask.InterfaceC15341a interfaceC15341a = this.f43654g;
                                if (interfaceC15341a != null) {
                                    interfaceC15341a.mo3260d();
                                }
                            }
                            if (c0025c.f72n == -1) {
                                c0025c.f72n = j6;
                            }
                            if (c0025c.f73o == -1) {
                                c0025c.f73o = j;
                            }
                        }
                        return c0025c;
                    }
                    c0025c.f74p = true;
                    c0025c.f72n = j6;
                    c0025c.f73o = j;
                    return c0025c;
                }
            }
            IDanmakus mo3052f = this.f43652e.mo3052f(j4, j5);
            if (mo3052f != null) {
                this.f43657j = mo3052f;
            }
            this.f43662o = j4;
            this.f43663p = j5;
            j = j5;
            j6 = j4;
            iDanmakus = mo3052f;
            iDanmakus2 = this.f43668u;
            m3293n(c0025c, iDanmakus2, iDanmakus);
            if (iDanmakus2 != null) {
                IRenderer.C0025c c0025c22 = this.f43660m;
                c0025c22.f59a = true;
                this.f43655h.mo2976a(absDisplayer, iDanmakus2, 0L, c0025c22);
            }
            this.f43660m.f59a = false;
            if (iDanmakus == null) {
            }
            c0025c.f74p = true;
            c0025c.f72n = j6;
            c0025c.f73o = j;
            return c0025c;
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void onPlayStateChanged(int i) {
        this.f43664q = i;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void prepare() {
        m3288s(this.f43653f);
        this.f43663p = 0L;
        this.f43662o = 0L;
        IDrawTask.InterfaceC15341a interfaceC15341a = this.f43654g;
        if (interfaceC15341a != null) {
            interfaceC15341a.mo3261c();
            this.f43661n = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q */
    public boolean m3290q(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        Boolean bool;
        boolean z = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.f43650c.f43692C.m3388f(DanmakuFilters.f43572w);
                    return true;
                }
                this.f43650c.f43692C.m3383k(DanmakuFilters.f43572w);
                return true;
            }
        } else if (!DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
            if (!DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) && (bool = (Boolean) objArr[0]) != null) {
                    IRenderer iRenderer = this.f43655h;
                    if (iRenderer != null) {
                        iRenderer.mo2975b(bool.booleanValue());
                        return true;
                    }
                    return true;
                }
            } else {
                IRenderer iRenderer2 = this.f43655h;
                if (iRenderer2 != null) {
                    iRenderer2.mo2973d((this.f43650c.m3210r() || this.f43650c.m3211q()) ? true : true);
                    return true;
                }
                return true;
            }
        } else {
            mo3269h();
        }
        return false;
    }

    /* renamed from: r */
    protected void mo3289r(DanmakuTimer danmakuTimer) {
        this.f43656i = danmakuTimer;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void reset() {
        if (this.f43657j != null) {
            this.f43657j = new Danmakus();
        }
        IRenderer iRenderer = this.f43655h;
        if (iRenderer != null) {
            iRenderer.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public void m3288s(BaseDanmakuParser baseDanmakuParser) {
        this.f43652e = baseDanmakuParser.m2981i(this.f43650c).m2980j(this.f43651d).m2978l(this.f43656i).m2979k(new C15338f()).m2989a();
        this.f43650c.f43691B.m3065a();
        IDanmakus iDanmakus = this.f43652e;
        if (iDanmakus != null) {
            this.f43666s = iDanmakus.last();
        }
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void seek(long j) {
        BaseDanmaku last;
        reset();
        this.f43650c.f43691B.m3059g();
        this.f43650c.f43691B.m3063c();
        this.f43650c.f43691B.m3060f();
        this.f43650c.f43691B.m3061e();
        this.f43668u = new Danmakus(4);
        if (j < 1000) {
            j = 0;
        }
        this.f43659l = j;
        this.f43660m.m60038e();
        this.f43660m.f73o = this.f43659l;
        this.f43663p = 0L;
        this.f43662o = 0L;
        IDanmakus iDanmakus = this.f43652e;
        if (iDanmakus == null || (last = iDanmakus.last()) == null || last.m3073w()) {
            return;
        }
        this.f43666s = last;
    }

    @Override // master.flame.danmaku.controller.IDrawTask
    public void start() {
        this.f43650c.m3207u(this.f43669v);
    }

    /* renamed from: t */
    public boolean mo3287t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean m3290q = m3290q(danmakuContext, danmakuConfigTag, objArr);
        IDrawTask.InterfaceC15341a interfaceC15341a = this.f43654g;
        if (interfaceC15341a != null) {
            interfaceC15341a.mo3259e();
        }
        return m3290q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public void mo3286u(BaseDanmaku baseDanmaku) {
    }

    /* renamed from: v */
    protected synchronized void m3285v(int i) {
        IDanmakus iDanmakus = this.f43652e;
        if (iDanmakus != null && !iDanmakus.isEmpty() && !this.f43667t.isEmpty()) {
            this.f43667t.mo3057a(new C15336d(i));
        }
    }
}
