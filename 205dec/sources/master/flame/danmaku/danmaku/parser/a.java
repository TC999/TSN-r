package master.flame.danmaku.danmaku.parser;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BaseDanmakuParser.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected b<?> f61236a;

    /* renamed from: b  reason: collision with root package name */
    protected f f61237b;

    /* renamed from: c  reason: collision with root package name */
    protected int f61238c;

    /* renamed from: d  reason: collision with root package name */
    protected int f61239d;

    /* renamed from: e  reason: collision with root package name */
    protected float f61240e;

    /* renamed from: f  reason: collision with root package name */
    protected float f61241f;

    /* renamed from: g  reason: collision with root package name */
    private m f61242g;

    /* renamed from: h  reason: collision with root package name */
    protected n f61243h;

    /* renamed from: i  reason: collision with root package name */
    protected DanmakuContext f61244i;

    /* renamed from: j  reason: collision with root package name */
    protected InterfaceC1240a f61245j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BaseDanmakuParser.java */
    /* renamed from: master.flame.danmaku.danmaku.parser.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface InterfaceC1240a {
        void b(d dVar);
    }

    public m a() {
        m mVar = this.f61242g;
        if (mVar != null) {
            return mVar;
        }
        this.f61244i.D.k();
        this.f61242g = f();
        h();
        this.f61244i.D.m();
        return this.f61242g;
    }

    public n b() {
        return this.f61243h;
    }

    public f c() {
        return this.f61237b;
    }

    protected float d() {
        return 1.0f / (this.f61240e - 0.6f);
    }

    public a e(b<?> bVar) {
        this.f61236a = bVar;
        return this;
    }

    protected abstract m f();

    public void g() {
        h();
    }

    protected void h() {
        b<?> bVar = this.f61236a;
        if (bVar != null) {
            bVar.release();
        }
        this.f61236a = null;
    }

    public a i(DanmakuContext danmakuContext) {
        DanmakuContext danmakuContext2 = this.f61244i;
        if (danmakuContext2 != null && danmakuContext2 != danmakuContext) {
            this.f61242g = null;
        }
        this.f61244i = danmakuContext;
        return this;
    }

    public a j(n nVar) {
        this.f61243h = nVar;
        this.f61238c = nVar.getWidth();
        this.f61239d = nVar.getHeight();
        this.f61240e = nVar.i();
        this.f61241f = nVar.f();
        this.f61244i.D.p(this.f61238c, this.f61239d, d());
        this.f61244i.D.m();
        return this;
    }

    public a k(InterfaceC1240a interfaceC1240a) {
        this.f61245j = interfaceC1240a;
        return this;
    }

    public a l(f fVar) {
        this.f61237b = fVar;
        return this;
    }
}
