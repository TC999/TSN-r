package master.flame.danmaku.ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.controller.f;
import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakuTouchHelper.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetector f61358a;

    /* renamed from: b  reason: collision with root package name */
    private f f61359b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f61360c;

    /* renamed from: d  reason: collision with root package name */
    private float f61361d;

    /* renamed from: e  reason: collision with root package name */
    private float f61362e;

    /* renamed from: f  reason: collision with root package name */
    private final GestureDetector.OnGestureListener f61363f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuTouchHelper.java */
    /* renamed from: master.flame.danmaku.ui.widget.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class C1243a extends GestureDetector.SimpleOnGestureListener {
        C1243a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (a.this.f61359b == null || a.this.f61359b.getOnDanmakuClickListener() == null) {
                return false;
            }
            a aVar = a.this;
            aVar.f61361d = aVar.f61359b.getXOff();
            a aVar2 = a.this;
            aVar2.f61362e = aVar2.f61359b.getYOff();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (a.this.f61359b.getOnDanmakuClickListener() == null) {
                return;
            }
            a aVar = a.this;
            aVar.f61361d = aVar.f61359b.getXOff();
            a aVar2 = a.this;
            aVar2.f61362e = aVar2.f61359b.getYOff();
            m n4 = a.this.n(motionEvent.getX(), motionEvent.getY());
            if (n4 == null || n4.isEmpty()) {
                return;
            }
            a.this.l(n4, true);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            m n4 = a.this.n(motionEvent.getX(), motionEvent.getY());
            boolean z3 = false;
            if (n4 != null && !n4.isEmpty()) {
                z3 = a.this.l(n4, false);
            }
            return !z3 ? a.this.m() : z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuTouchHelper.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends m.c<d> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f61365e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f61366f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ m f61367g;

        b(float f4, float f5, m mVar) {
            this.f61365e = f4;
            this.f61366f = f5;
            this.f61367g = mVar;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(d dVar) {
            if (dVar != null) {
                a.this.f61360c.set(dVar.g(), dVar.l(), dVar.i(), dVar.d());
                if (a.this.f61360c.intersect(this.f61365e - a.this.f61361d, this.f61366f - a.this.f61362e, this.f61365e + a.this.f61361d, this.f61366f + a.this.f61362e)) {
                    this.f61367g.i(dVar);
                    return 0;
                }
                return 0;
            }
            return 0;
        }
    }

    private a(f fVar) {
        C1243a c1243a = new C1243a();
        this.f61363f = c1243a;
        this.f61359b = fVar;
        this.f61360c = new RectF();
        this.f61358a = new GestureDetector(((View) fVar).getContext(), c1243a);
    }

    public static synchronized a j(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(m mVar, boolean z3) {
        f.a onDanmakuClickListener = this.f61359b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            if (z3) {
                return onDanmakuClickListener.c(mVar);
            }
            return onDanmakuClickListener.a(mVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        f.a onDanmakuClickListener = this.f61359b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.b(this.f61359b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m n(float f4, float f5) {
        e eVar = new e();
        this.f61360c.setEmpty();
        m currentVisibleDanmakus = this.f61359b.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new b(f4, f5, eVar));
        }
        return eVar;
    }

    public boolean k(MotionEvent motionEvent) {
        return this.f61358a.onTouchEvent(motionEvent);
    }
}
