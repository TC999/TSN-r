package master.flame.danmaku.danmaku.renderer.android;

import master.flame.danmaku.controller.DanmakuFilters;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.ICacheManager;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.IDrawingCache;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer;
import p014a2.IRenderer;
import p014a2.Renderer;

/* renamed from: master.flame.danmaku.danmaku.renderer.android.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuRenderer extends Renderer {

    /* renamed from: d */
    private DanmakuTimer f43974d;

    /* renamed from: e */
    private final DanmakuContext f43975e;

    /* renamed from: f */
    private DanmakusRetainer.InterfaceC15368g f43976f;

    /* renamed from: h */
    private final DanmakusRetainer f43978h;

    /* renamed from: i */
    private ICacheManager f43979i;

    /* renamed from: j */
    private IRenderer.InterfaceC0024b f43980j;

    /* renamed from: g */
    private final DanmakusRetainer.InterfaceC15368g f43977g = new C15358a();

    /* renamed from: k */
    private C15359b f43981k = new C15359b(this, null);

    /* compiled from: DanmakuRenderer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15358a implements DanmakusRetainer.InterfaceC15368g {
        C15358a() {
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.InterfaceC15368g
        /* renamed from: a */
        public boolean mo2949a(BaseDanmaku baseDanmaku, float f, int i, boolean z) {
            if (baseDanmaku.f43873o == 0 && DanmakuRenderer.this.f43975e.f43692C.m3391c(baseDanmaku, i, 0, DanmakuRenderer.this.f43974d, z, DanmakuRenderer.this.f43975e)) {
                baseDanmaku.m3090G(false);
                return true;
            }
            return false;
        }
    }

    /* compiled from: DanmakuRenderer.java */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private class C15359b extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        private BaseDanmaku f43983e;

        /* renamed from: f */
        public IDisplayer f43984f;

        /* renamed from: g */
        public IRenderer.C0025c f43985g;

        /* renamed from: h */
        public long f43986h;

        private C15359b() {
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: b */
        public void mo2963b() {
            this.f43985g.f63e = this.f43983e;
            super.mo2963b();
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            this.f43983e = baseDanmaku;
            if (baseDanmaku.m3073w()) {
                this.f43984f.mo3032n(baseDanmaku);
                return this.f43985g.f59a ? 2 : 0;
            } else if (this.f43985g.f59a || !baseDanmaku.m3077r()) {
                if (!baseDanmaku.m3082m()) {
                    DanmakuFilters danmakuFilters = DanmakuRenderer.this.f43975e.f43692C;
                    IRenderer.C0025c c0025c = this.f43985g;
                    danmakuFilters.m3392b(baseDanmaku, c0025c.f61c, c0025c.f62d, c0025c.f60b, false, DanmakuRenderer.this.f43975e);
                }
                if (baseDanmaku.m3088b() >= this.f43986h && (baseDanmaku.f43873o != 0 || !baseDanmaku.m3081n())) {
                    if (baseDanmaku.m3079p()) {
                        IDrawingCache<?> m3086e = baseDanmaku.m3086e();
                        if (DanmakuRenderer.this.f43979i != null && (m3086e == null || m3086e.get() == null)) {
                            DanmakuRenderer.this.f43979i.mo3058a(baseDanmaku);
                        }
                        return 1;
                    }
                    if (baseDanmaku.getType() == 1) {
                        this.f43985g.f61c++;
                    }
                    if (!baseDanmaku.m3078q()) {
                        baseDanmaku.mo3006z(this.f43984f, false);
                    }
                    if (!baseDanmaku.m3074u()) {
                        baseDanmaku.m3096A(this.f43984f, false);
                    }
                    DanmakuRenderer.this.f43978h.m2959c(baseDanmaku, this.f43984f, DanmakuRenderer.this.f43976f);
                    if (!baseDanmaku.mo3071v() || (baseDanmaku.f43862d == null && baseDanmaku.mo3000d() > this.f43984f.getHeight())) {
                        return 0;
                    }
                    int m3089a = baseDanmaku.m3089a(this.f43984f);
                    if (m3089a == 1) {
                        this.f43985g.f76r++;
                    } else if (m3089a == 2) {
                        this.f43985g.f77s++;
                        if (DanmakuRenderer.this.f43979i != null) {
                            DanmakuRenderer.this.f43979i.mo3058a(baseDanmaku);
                        }
                    }
                    this.f43985g.m60042a(baseDanmaku.getType(), 1);
                    this.f43985g.m60041b(1);
                    this.f43985g.m60040c(baseDanmaku);
                    if (DanmakuRenderer.this.f43980j != null && baseDanmaku.f43858K != DanmakuRenderer.this.f43975e.f43691B.f43899d) {
                        baseDanmaku.f43858K = DanmakuRenderer.this.f43975e.f43691B.f43899d;
                        DanmakuRenderer.this.f43980j.mo3284a(baseDanmaku);
                    }
                }
                return 0;
            } else {
                return 0;
            }
        }

        /* synthetic */ C15359b(DanmakuRenderer danmakuRenderer, C15358a c15358a) {
            this();
        }
    }

    public DanmakuRenderer(DanmakuContext danmakuContext) {
        this.f43975e = danmakuContext;
        this.f43978h = new DanmakusRetainer(danmakuContext.m3213o());
    }

    @Override // p014a2.IRenderer
    /* renamed from: a */
    public void mo2976a(IDisplayer iDisplayer, IDanmakus iDanmakus, long j, IRenderer.C0025c c0025c) {
        this.f43974d = c0025c.f60b;
        C15359b c15359b = this.f43981k;
        c15359b.f43984f = iDisplayer;
        c15359b.f43985g = c0025c;
        c15359b.f43986h = j;
        iDanmakus.mo3057a(c15359b);
    }

    @Override // p014a2.IRenderer
    /* renamed from: b */
    public void mo2975b(boolean z) {
        DanmakusRetainer danmakusRetainer = this.f43978h;
        if (danmakusRetainer != null) {
            danmakusRetainer.m2961a(z);
        }
    }

    @Override // p014a2.IRenderer
    /* renamed from: c */
    public void mo2974c(ICacheManager iCacheManager) {
        this.f43979i = iCacheManager;
    }

    @Override // p014a2.IRenderer
    public void clear() {
        mo2972e();
        this.f43975e.f43692C.m3393a();
    }

    @Override // p014a2.IRenderer
    /* renamed from: d */
    public void mo2973d(boolean z) {
        this.f43976f = z ? this.f43977g : null;
    }

    @Override // p014a2.IRenderer
    /* renamed from: e */
    public void mo2972e() {
        this.f43978h.m2960b();
    }

    @Override // p014a2.IRenderer
    /* renamed from: f */
    public void mo2971f() {
        this.f43980j = null;
    }

    @Override // p014a2.IRenderer
    /* renamed from: g */
    public void mo2970g(IRenderer.InterfaceC0024b interfaceC0024b) {
        this.f43980j = interfaceC0024b;
    }

    @Override // p014a2.IRenderer
    public void release() {
        this.f43978h.m2958d();
        this.f43975e.f43692C.m3393a();
    }
}
