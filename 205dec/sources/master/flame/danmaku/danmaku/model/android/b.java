package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import master.flame.danmaku.danmaku.model.android.a;
import master.flame.danmaku.danmaku.model.o;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BaseCacheStuffer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f61073a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BaseCacheStuffer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a {
        public abstract void a(master.flame.danmaku.danmaku.model.d dVar, boolean z3);

        public abstract void b(master.flame.danmaku.danmaku.model.d dVar);
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
    }

    public abstract void b();

    public boolean c(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5, Paint paint, TextPaint textPaint) {
        g gVar;
        o<?> e4 = dVar.e();
        if (e4 == null || (gVar = (g) e4.get()) == null) {
            return false;
        }
        return gVar.b(canvas, f4, f5, paint);
    }

    public abstract void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5, boolean z3, a.C1239a c1239a);

    public abstract void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z3);

    public void f(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        a aVar = this.f61073a;
        if (aVar != null) {
            aVar.a(dVar, z3);
        }
    }

    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        a aVar = this.f61073a;
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public void h(a aVar) {
        this.f61073a = aVar;
    }
}
