package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.IDrawingCache;
import master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c;

/* renamed from: master.flame.danmaku.danmaku.model.android.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DrawingCache implements IDrawingCache<DrawingCacheHolder>, InterfaceC15354c<DrawingCache> {

    /* renamed from: c */
    private DrawingCache f43815c;

    /* renamed from: d */
    private boolean f43816d;

    /* renamed from: b */
    private int f43814b = 0;

    /* renamed from: e */
    private int f43817e = 0;

    /* renamed from: a */
    private final DrawingCacheHolder f43813a = new DrawingCacheHolder();

    @Override // master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c
    /* renamed from: a */
    public void mo3019a(boolean z) {
        this.f43816d = z;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: b */
    public int mo3025b() {
        return this.f43813a.f43823f;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c
    /* renamed from: d */
    public boolean mo3017d() {
        return this.f43816d;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public void destroy() {
        DrawingCacheHolder drawingCacheHolder = this.f43813a;
        if (drawingCacheHolder != null) {
            drawingCacheHolder.m3129f();
        }
        this.f43814b = 0;
        this.f43817e = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: e */
    public synchronized void mo3024e() {
        this.f43817e--;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: f */
    public void mo3023f(int i, int i2, int i3, boolean z, int i4) {
        this.f43813a.m3134a(i, i2, i3, z, i4);
        this.f43814b = this.f43813a.f43819b.getRowBytes() * this.f43813a.f43819b.getHeight();
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: g */
    public int mo3022g() {
        return this.f43813a.f43822e;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: h */
    public void mo3021h() {
        this.f43813a.m3132c();
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public synchronized boolean hasReferences() {
        return this.f43817e > 0;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: j */
    public synchronized void mo3020j() {
        this.f43817e++;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    /* renamed from: k */
    public DrawingCacheHolder get() {
        DrawingCacheHolder drawingCacheHolder = this.f43813a;
        if (drawingCacheHolder.f43819b == null) {
            return null;
        }
        return drawingCacheHolder;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c
    /* renamed from: l */
    public DrawingCache mo3018c() {
        return this.f43815c;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.InterfaceC15354c
    /* renamed from: m */
    public void mo3016i(DrawingCache drawingCache) {
        this.f43815c = drawingCache;
    }

    @Override // master.flame.danmaku.danmaku.model.IDrawingCache
    public int size() {
        return this.f43814b;
    }
}
