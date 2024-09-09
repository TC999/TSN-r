package master.flame.danmaku.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
public class DanmakuView extends View implements f, g {

    /* renamed from: v  reason: collision with root package name */
    public static final String f61333v = "DanmakuView";

    /* renamed from: w  reason: collision with root package name */
    private static final int f61334w = 50;

    /* renamed from: x  reason: collision with root package name */
    private static final int f61335x = 1000;

    /* renamed from: a  reason: collision with root package name */
    private c.d f61336a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f61337b;

    /* renamed from: c  reason: collision with root package name */
    private c f61338c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61339d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f61340e;

    /* renamed from: f  reason: collision with root package name */
    private f.a f61341f;

    /* renamed from: g  reason: collision with root package name */
    private float f61342g;

    /* renamed from: h  reason: collision with root package name */
    private float f61343h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnClickListener f61344i;

    /* renamed from: j  reason: collision with root package name */
    private master.flame.danmaku.ui.widget.a f61345j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f61346k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f61347l;

    /* renamed from: m  reason: collision with root package name */
    protected int f61348m;

    /* renamed from: n  reason: collision with root package name */
    private Object f61349n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f61350o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f61351p;

    /* renamed from: q  reason: collision with root package name */
    private long f61352q;

    /* renamed from: r  reason: collision with root package name */
    private LinkedList<Long> f61353r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f61354s;

    /* renamed from: t  reason: collision with root package name */
    private int f61355t;

    /* renamed from: u  reason: collision with root package name */
    private Runnable f61356u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DanmakuView.this.f61338c == null) {
                return;
            }
            DanmakuView.s(DanmakuView.this);
            if (DanmakuView.this.f61355t <= 4 && !DanmakuView.super.isShown()) {
                DanmakuView.this.f61338c.postDelayed(this, DanmakuView.this.f61355t * 100);
            } else {
                DanmakuView.this.f61338c.U();
            }
        }
    }

    public DanmakuView(Context context) {
        super(context);
        this.f61340e = true;
        this.f61347l = true;
        this.f61348m = 0;
        this.f61349n = new Object();
        this.f61350o = false;
        this.f61351p = false;
        this.f61355t = 0;
        this.f61356u = new a();
        w();
    }

    private void A() {
        if (this.f61338c == null) {
            this.f61338c = new c(v(this.f61348m), this, this.f61347l);
        }
    }

    private synchronized void C() {
        c cVar = this.f61338c;
        if (cVar == null) {
            return;
        }
        this.f61338c = null;
        D();
        if (cVar != null) {
            cVar.O();
        }
        HandlerThread handlerThread = this.f61337b;
        this.f61337b = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    private void D() {
        synchronized (this.f61349n) {
            this.f61350o = true;
            this.f61349n.notifyAll();
        }
    }

    static /* synthetic */ int s(DanmakuView danmakuView) {
        int i4 = danmakuView.f61355t;
        danmakuView.f61355t = i4 + 1;
        return i4;
    }

    private float u() {
        long b4 = g3.c.b();
        this.f61353r.addLast(Long.valueOf(b4));
        Long peekFirst = this.f61353r.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (b4 - peekFirst.longValue());
        if (this.f61353r.size() > 50) {
            this.f61353r.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f61353r.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    private void w() {
        this.f61352q = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        d.f(true, false);
        this.f61345j = master.flame.danmaku.ui.widget.a.j(this);
    }

    private void x() {
        c cVar;
        if (this.f61347l) {
            z();
            synchronized (this.f61349n) {
                while (!this.f61350o && this.f61338c != null) {
                    try {
                        this.f61349n.wait(200L);
                    } catch (InterruptedException unused) {
                        if (!this.f61347l || (cVar = this.f61338c) == null || cVar.I()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.f61350o = false;
            }
        }
    }

    private void y() {
        this.f61354s = true;
        x();
    }

    @SuppressLint({"NewApi"})
    private void z() {
        this.f61351p = true;
        postInvalidateOnAnimation();
    }

    public void B() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.f
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.G(dVar, z3);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z3) {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.S(z3);
        }
    }

    @Override // master.flame.danmaku.controller.g
    public void clear() {
        if (o()) {
            if (this.f61347l && Thread.currentThread().getId() != this.f61352q) {
                y();
                return;
            }
            this.f61354s = true;
            z();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void d() {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean e() {
        return this.f61340e;
    }

    @Override // master.flame.danmaku.controller.f
    public void f() {
        this.f61347l = false;
        c cVar = this.f61338c;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // master.flame.danmaku.controller.f
    public void g(boolean z3) {
        this.f61346k = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f61338c;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f61338c;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f61338c;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f61341f;
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f61342g;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f61343h;
    }

    @Override // master.flame.danmaku.controller.f
    public void h(Long l4) {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.V(l4);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void i(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        A();
        this.f61338c.X(danmakuContext);
        this.f61338c.Y(aVar);
        this.f61338c.W(this.f61336a);
        this.f61338c.M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f61338c;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f61338c;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f61347l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public long j() {
        this.f61347l = false;
        c cVar = this.f61338c;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void k(f.a aVar, float f4, float f5) {
        this.f61341f = aVar;
        this.f61342g = f4;
        this.f61343h = f5;
    }

    @Override // master.flame.danmaku.controller.g
    public long l() {
        if (this.f61339d) {
            if (isShown()) {
                long b4 = g3.c.b();
                x();
                return g3.c.b() - b4;
            }
            return -1L;
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public void m(Long l4) {
        this.f61347l = true;
        this.f61354s = false;
        c cVar = this.f61338c;
        if (cVar == null) {
            return;
        }
        cVar.Z(l4);
    }

    @Override // master.flame.danmaku.controller.f
    public void n() {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean o() {
        return this.f61339d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f61347l && !this.f61351p) {
            super.onDraw(canvas);
            return;
        }
        if (this.f61354s) {
            d.a(canvas);
            this.f61354s = false;
        } else {
            c cVar = this.f61338c;
            if (cVar != null) {
                a.c x3 = cVar.x(canvas);
                if (this.f61346k) {
                    if (this.f61353r == null) {
                        this.f61353r = new LinkedList<>();
                    }
                    d.d(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(u()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x3.f54697r), Long.valueOf(x3.f54698s)));
                }
            }
        }
        this.f61351p = false;
        D();
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.J(i6 - i4, i7 - i5);
        }
        this.f61339d = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k4 = this.f61345j.k(motionEvent);
        return !k4 ? super.onTouchEvent(motionEvent) : k4;
    }

    @Override // master.flame.danmaku.controller.f
    public void p(boolean z3) {
        this.f61340e = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.removeCallbacks(this.f61356u);
            this.f61338c.L();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f61353r;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f61338c;
        if (cVar != null && cVar.H()) {
            this.f61355t = 0;
            this.f61338c.post(this.f61356u);
        } else if (this.f61338c == null) {
            B();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f61336a = dVar;
        c cVar = this.f61338c;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i4) {
        this.f61348m = i4;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f61341f = aVar;
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
        C();
    }

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f61339d) {
            c cVar = this.f61338c;
            if (cVar == null) {
                start();
            } else if (cVar.I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    protected synchronized Looper v(int i4) {
        HandlerThread handlerThread = this.f61337b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f61337b = null;
        }
        if (i4 != 1) {
            int i5 = i4 != 2 ? i4 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i5, i5);
            this.f61337b = handlerThread2;
            handlerThread2.start();
            return this.f61337b.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.f
    public void start(long j4) {
        c cVar = this.f61338c;
        if (cVar == null) {
            A();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f61338c.obtainMessage(1, Long.valueOf(j4)).sendToTarget();
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61340e = true;
        this.f61347l = true;
        this.f61348m = 0;
        this.f61349n = new Object();
        this.f61350o = false;
        this.f61351p = false;
        this.f61355t = 0;
        this.f61356u = new a();
        w();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f61340e = true;
        this.f61347l = true;
        this.f61348m = 0;
        this.f61349n = new Object();
        this.f61350o = false;
        this.f61351p = false;
        this.f61355t = 0;
        this.f61356u = new a();
        w();
    }
}
