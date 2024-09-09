package master.flame.danmaku.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import f3.a;
import java.util.LinkedList;
import java.util.Locale;
import master.flame.danmaku.controller.c;
import master.flame.danmaku.controller.d;
import master.flame.danmaku.controller.f;
import master.flame.danmaku.controller.g;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DanmakuSurfaceView extends SurfaceView implements f, g, SurfaceHolder.Callback {

    /* renamed from: o  reason: collision with root package name */
    public static final String f61300o = "DanmakuSurfaceView";

    /* renamed from: p  reason: collision with root package name */
    private static final int f61301p = 50;

    /* renamed from: q  reason: collision with root package name */
    private static final int f61302q = 1000;

    /* renamed from: a  reason: collision with root package name */
    private c.d f61303a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceHolder f61304b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f61305c;

    /* renamed from: d  reason: collision with root package name */
    private c f61306d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f61307e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f61308f;

    /* renamed from: g  reason: collision with root package name */
    private f.a f61309g;

    /* renamed from: h  reason: collision with root package name */
    private float f61310h;

    /* renamed from: i  reason: collision with root package name */
    private float f61311i;

    /* renamed from: j  reason: collision with root package name */
    private a f61312j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f61313k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f61314l;

    /* renamed from: m  reason: collision with root package name */
    protected int f61315m;

    /* renamed from: n  reason: collision with root package name */
    private LinkedList<Long> f61316n;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.f61308f = true;
        this.f61314l = true;
        this.f61315m = 0;
        s();
    }

    private float q() {
        long b4 = g3.c.b();
        this.f61316n.addLast(Long.valueOf(b4));
        Long peekFirst = this.f61316n.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (b4 - peekFirst.longValue());
        if (this.f61316n.size() > 50) {
            this.f61316n.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f61316n.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    private void s() {
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        SurfaceHolder holder = getHolder();
        this.f61304b = holder;
        holder.addCallback(this);
        this.f61304b.setFormat(-2);
        d.f(true, true);
        this.f61312j = a.j(this);
    }

    private void t() {
        if (this.f61306d == null) {
            this.f61306d = new c(r(this.f61315m), this, this.f61314l);
        }
    }

    private synchronized void v() {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.O();
            this.f61306d = null;
        }
        HandlerThread handlerThread = this.f61305c;
        this.f61305c = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.G(dVar, z3);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z3) {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.S(z3);
        }
    }

    @Override // master.flame.danmaku.controller.g
    public void clear() {
        Canvas lockCanvas;
        if (o() && (lockCanvas = this.f61304b.lockCanvas()) != null) {
            d.a(lockCanvas);
            this.f61304b.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void d() {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean e() {
        return this.f61308f;
    }

    @Override // master.flame.danmaku.controller.f
    public void f() {
        this.f61314l = false;
        c cVar = this.f61306d;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // master.flame.danmaku.controller.f
    public void g(boolean z3) {
        this.f61313k = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f61306d;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f61306d;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f61306d;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f61309g;
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f61310h;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f61311i;
    }

    @Override // master.flame.danmaku.controller.f
    public void h(Long l4) {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.V(l4);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void i(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        t();
        this.f61306d.X(danmakuContext);
        this.f61306d.Y(aVar);
        this.f61306d.W(this.f61303a);
        this.f61306d.M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f61306d;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f61306d;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f61314l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public long j() {
        this.f61314l = false;
        c cVar = this.f61306d;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void k(f.a aVar, float f4, float f5) {
        this.f61309g = aVar;
        this.f61310h = f4;
        this.f61311i = f5;
    }

    @Override // master.flame.danmaku.controller.g
    public long l() {
        if (this.f61307e) {
            if (isShown()) {
                long b4 = g3.c.b();
                Canvas lockCanvas = this.f61304b.lockCanvas();
                if (lockCanvas != null) {
                    c cVar = this.f61306d;
                    if (cVar != null) {
                        a.c x3 = cVar.x(lockCanvas);
                        if (this.f61313k) {
                            if (this.f61316n == null) {
                                this.f61316n = new LinkedList<>();
                            }
                            g3.c.b();
                            d.d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(q()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x3.f54697r), Long.valueOf(x3.f54698s)));
                        }
                    }
                    if (this.f61307e) {
                        this.f61304b.unlockCanvasAndPost(lockCanvas);
                    }
                }
                return g3.c.b() - b4;
            }
            return -1L;
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public void m(Long l4) {
        this.f61314l = true;
        c cVar = this.f61306d;
        if (cVar == null) {
            return;
        }
        cVar.Z(l4);
    }

    @Override // master.flame.danmaku.controller.f
    public void n() {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean o() {
        return this.f61307e;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k4 = this.f61312j.k(motionEvent);
        return !k4 ? super.onTouchEvent(motionEvent) : k4;
    }

    @Override // master.flame.danmaku.controller.f
    public void p(boolean z3) {
        this.f61308f = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.L();
        }
    }

    protected synchronized Looper r(int i4) {
        HandlerThread handlerThread = this.f61305c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f61305c = null;
        }
        if (i4 != 1) {
            int i5 = i4 != 2 ? i4 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i5, i5);
            this.f61305c = handlerThread2;
            handlerThread2.start();
            return this.f61305c.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f61316n;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f61306d;
        if (cVar != null && cVar.H()) {
            this.f61306d.U();
        } else if (this.f61306d == null) {
            u();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f61303a = dVar;
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i4) {
        this.f61315m = i4;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f61309g = aVar;
    }

    @Override // master.flame.danmaku.controller.f
    public void show() {
        m(null);
    }

    @Override // master.flame.danmaku.controller.f
    public void start() {
        start(0L);
    }

    @Override // master.flame.danmaku.controller.f
    public void stop() {
        v();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        c cVar = this.f61306d;
        if (cVar != null) {
            cVar.J(i5, i6);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f61307e = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            d.a(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f61307e = false;
    }

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f61307e) {
            c cVar = this.f61306d;
            if (cVar == null) {
                start();
            } else if (cVar.I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void u() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.f
    public void start(long j4) {
        c cVar = this.f61306d;
        if (cVar == null) {
            t();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f61306d.obtainMessage(1, Long.valueOf(j4)).sendToTarget();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61308f = true;
        this.f61314l = true;
        this.f61315m = 0;
        s();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f61308f = true;
        this.f61314l = true;
        this.f61315m = 0;
        s();
    }
}
