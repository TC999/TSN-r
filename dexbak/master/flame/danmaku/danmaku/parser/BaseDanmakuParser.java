package master.flame.danmaku.danmaku.parser;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;

/* renamed from: master.flame.danmaku.danmaku.parser.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class BaseDanmakuParser {

    /* renamed from: a */
    protected IDataSource<?> f43961a;

    /* renamed from: b */
    protected DanmakuTimer f43962b;

    /* renamed from: c */
    protected int f43963c;

    /* renamed from: d */
    protected int f43964d;

    /* renamed from: e */
    protected float f43965e;

    /* renamed from: f */
    protected float f43966f;

    /* renamed from: g */
    private IDanmakus f43967g;

    /* renamed from: h */
    protected IDisplayer f43968h;

    /* renamed from: i */
    protected DanmakuContext f43969i;

    /* renamed from: j */
    protected InterfaceC15357a f43970j;

    /* compiled from: BaseDanmakuParser.java */
    /* renamed from: master.flame.danmaku.danmaku.parser.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15357a {
        /* renamed from: b */
        void mo2977b(BaseDanmaku baseDanmaku);
    }

    /* renamed from: a */
    public IDanmakus m2989a() {
        IDanmakus iDanmakus = this.f43967g;
        if (iDanmakus != null) {
            return iDanmakus;
        }
        this.f43969i.f43693D.m3148k();
        this.f43967g = m2984f();
        m2982h();
        this.f43969i.f43693D.m3146m();
        return this.f43967g;
    }

    /* renamed from: b */
    public IDisplayer m2988b() {
        return this.f43968h;
    }

    /* renamed from: c */
    public DanmakuTimer m2987c() {
        return this.f43962b;
    }

    /* renamed from: d */
    protected float m2986d() {
        return 1.0f / (this.f43965e - 0.6f);
    }

    /* renamed from: e */
    public BaseDanmakuParser m2985e(IDataSource<?> iDataSource) {
        this.f43961a = iDataSource;
        return this;
    }

    /* renamed from: f */
    protected abstract IDanmakus m2984f();

    /* renamed from: g */
    public void m2983g() {
        m2982h();
    }

    /* renamed from: h */
    protected void m2982h() {
        IDataSource<?> iDataSource = this.f43961a;
        if (iDataSource != null) {
            iDataSource.release();
        }
        this.f43961a = null;
    }

    /* renamed from: i */
    public BaseDanmakuParser m2981i(DanmakuContext danmakuContext) {
        DanmakuContext danmakuContext2 = this.f43969i;
        if (danmakuContext2 != null && danmakuContext2 != danmakuContext) {
            this.f43967g = null;
        }
        this.f43969i = danmakuContext;
        return this;
    }

    /* renamed from: j */
    public BaseDanmakuParser m2980j(IDisplayer iDisplayer) {
        this.f43968h = iDisplayer;
        this.f43963c = iDisplayer.getWidth();
        this.f43964d = iDisplayer.getHeight();
        this.f43965e = iDisplayer.mo3037i();
        this.f43966f = iDisplayer.mo3040f();
        this.f43969i.f43693D.m3143p(this.f43963c, this.f43964d, m2986d());
        this.f43969i.f43693D.m3146m();
        return this;
    }

    /* renamed from: k */
    public BaseDanmakuParser m2979k(InterfaceC15357a interfaceC15357a) {
        this.f43970j = interfaceC15357a;
        return this;
    }

    /* renamed from: l */
    public BaseDanmakuParser m2978l(DanmakuTimer danmakuTimer) {
        this.f43962b = danmakuTimer;
        return this;
    }
}
