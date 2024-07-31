package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDrawingCache;
import master.flame.danmaku.danmaku.model.android.AndroidDisplayer;

/* renamed from: master.flame.danmaku.danmaku.model.android.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class BaseCacheStuffer {

    /* renamed from: a */
    protected AbstractC15344a f43765a;

    /* compiled from: BaseCacheStuffer.java */
    /* renamed from: master.flame.danmaku.danmaku.model.android.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15344a {
        /* renamed from: a */
        public abstract void m3160a(BaseDanmaku baseDanmaku, boolean z);

        /* renamed from: b */
        public abstract void m3159b(BaseDanmaku baseDanmaku);
    }

    /* renamed from: a */
    public void mo3121a(BaseDanmaku baseDanmaku) {
    }

    /* renamed from: b */
    public abstract void mo3118b();

    /* renamed from: c */
    public boolean m3163c(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, Paint paint, TextPaint textPaint) {
        DrawingCacheHolder drawingCacheHolder;
        IDrawingCache<?> m3086e = baseDanmaku.m3086e();
        if (m3086e == null || (drawingCacheHolder = (DrawingCacheHolder) m3086e.get()) == null) {
            return false;
        }
        return drawingCacheHolder.m3133b(canvas, f, f2, paint);
    }

    /* renamed from: d */
    public abstract void mo3117d(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.C15343a c15343a);

    /* renamed from: e */
    public abstract void mo3116e(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z);

    /* renamed from: f */
    public void m3162f(BaseDanmaku baseDanmaku, boolean z) {
        AbstractC15344a abstractC15344a = this.f43765a;
        if (abstractC15344a != null) {
            abstractC15344a.m3160a(baseDanmaku, z);
        }
    }

    /* renamed from: g */
    public void mo3115g(BaseDanmaku baseDanmaku) {
        AbstractC15344a abstractC15344a = this.f43765a;
        if (abstractC15344a != null) {
            abstractC15344a.m3159b(baseDanmaku);
        }
    }

    /* renamed from: h */
    public void m3161h(AbstractC15344a abstractC15344a) {
        this.f43765a = abstractC15344a;
    }
}
