package master.flame.danmaku.p621ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;
import java.util.Locale;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.DrawHelper;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.controller.IDanmakuViewController;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import p014a2.IRenderer;
import p025b2.SystemClock;

/* renamed from: master.flame.danmaku.ui.widget.DanmakuView */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuView extends View implements IDanmakuView, IDanmakuViewController {

    /* renamed from: v */
    public static final String f44058v = "DanmakuView";

    /* renamed from: w */
    private static final int f44059w = 50;

    /* renamed from: x */
    private static final int f44060x = 1000;

    /* renamed from: a */
    private DrawHandler.InterfaceC15331d f44061a;

    /* renamed from: b */
    private HandlerThread f44062b;

    /* renamed from: c */
    private DrawHandler f44063c;

    /* renamed from: d */
    private boolean f44064d;

    /* renamed from: e */
    private boolean f44065e;

    /* renamed from: f */
    private IDanmakuView.InterfaceC15340a f44066f;

    /* renamed from: g */
    private float f44067g;

    /* renamed from: h */
    private float f44068h;

    /* renamed from: i */
    private View.OnClickListener f44069i;

    /* renamed from: j */
    private DanmakuTouchHelper f44070j;

    /* renamed from: k */
    private boolean f44071k;

    /* renamed from: l */
    private boolean f44072l;

    /* renamed from: m */
    protected int f44073m;

    /* renamed from: n */
    private Object f44074n;

    /* renamed from: o */
    private boolean f44075o;

    /* renamed from: p */
    private boolean f44076p;

    /* renamed from: q */
    private long f44077q;

    /* renamed from: r */
    private LinkedList<Long> f44078r;

    /* renamed from: s */
    private boolean f44079s;

    /* renamed from: t */
    private int f44080t;

    /* renamed from: u */
    private Runnable f44081u;

    /* renamed from: master.flame.danmaku.ui.widget.DanmakuView$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class RunnableC15369a implements Runnable {
        RunnableC15369a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DanmakuView.this.f44063c == null) {
                return;
            }
            DanmakuView.m2914s(DanmakuView.this);
            if (DanmakuView.this.f44080t <= 4 && !DanmakuView.super.isShown()) {
                DanmakuView.this.f44063c.postDelayed(this, DanmakuView.this.f44080t * 100);
            } else {
                DanmakuView.this.f44063c.m3341U();
            }
        }
    }

    public DanmakuView(Context context) {
        super(context);
        this.f44065e = true;
        this.f44072l = true;
        this.f44073m = 0;
        this.f44074n = new Object();
        this.f44075o = false;
        this.f44076p = false;
        this.f44080t = 0;
        this.f44081u = new RunnableC15369a();
        m2910w();
    }

    /* renamed from: A */
    private void m2936A() {
        if (this.f44063c == null) {
            this.f44063c = new DrawHandler(m2911v(this.f44073m), this, this.f44072l);
        }
    }

    /* renamed from: C */
    private synchronized void m2934C() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            return;
        }
        this.f44063c = null;
        m2933D();
        if (drawHandler != null) {
            drawHandler.m3347O();
        }
        HandlerThread handlerThread = this.f44062b;
        this.f44062b = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    /* renamed from: D */
    private void m2933D() {
        synchronized (this.f44074n) {
            this.f44075o = true;
            this.f44074n.notifyAll();
        }
    }

    /* renamed from: s */
    static /* synthetic */ int m2914s(DanmakuView danmakuView) {
        int i = danmakuView.f44080t;
        danmakuView.f44080t = i + 1;
        return i;
    }

    /* renamed from: u */
    private float m2912u() {
        long m59951b = SystemClock.m59951b();
        this.f44078r.addLast(Long.valueOf(m59951b));
        Long peekFirst = this.f44078r.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (m59951b - peekFirst.longValue());
        if (this.f44078r.size() > 50) {
            this.f44078r.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f44078r.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    /* renamed from: w */
    private void m2910w() {
        this.f44077q = Thread.currentThread().getId();
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        DrawHelper.m3294f(true, false);
        this.f44070j = DanmakuTouchHelper.m2897j(this);
    }

    /* renamed from: x */
    private void m2909x() {
        DrawHandler drawHandler;
        if (this.f44072l) {
            m2907z();
            synchronized (this.f44074n) {
                while (!this.f44075o && this.f44063c != null) {
                    try {
                        this.f44074n.wait(200L);
                    } catch (InterruptedException unused) {
                        if (!this.f44072l || (drawHandler = this.f44063c) == null || drawHandler.m3353I()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                }
                this.f44075o = false;
            }
        }
    }

    /* renamed from: y */
    private void m2908y() {
        this.f44079s = true;
        m2909x();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: z */
    private void m2907z() {
        this.f44076p = true;
        postInvalidateOnAnimation();
    }

    /* renamed from: B */
    public void m2935B() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: a */
    public void mo2932a(BaseDanmaku baseDanmaku) {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3310t(baseDanmaku);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: b */
    public void mo2931b(BaseDanmaku baseDanmaku, boolean z) {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3355G(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: c */
    public void mo2930c(boolean z) {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3343S(z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public void clear() {
        if (mo2918o()) {
            if (this.f44072l && Thread.currentThread().getId() != this.f44077q) {
                m2908y();
                return;
            }
            this.f44079s = true;
            m2907z();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: d */
    public void mo2929d() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3342T();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: e */
    public boolean mo2928e() {
        return this.f44065e;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: f */
    public void mo2927f() {
        this.f44072l = false;
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3357E(false);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: g */
    public void mo2926g(boolean z) {
        this.f44071k = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public DanmakuContext getConfig() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            return null;
        }
        return drawHandler.m3304z();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public long getCurrentTime() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            return drawHandler.m3361A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakus getCurrentVisibleDanmakus() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            return drawHandler.m3360B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakuView.InterfaceC15340a getOnDanmakuClickListener() {
        return this.f44066f;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getXOff() {
        return this.f44067g;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getYOff() {
        return this.f44068h;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: h */
    public void mo2925h(Long l) {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3340V(l);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: i */
    public void mo2924i(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext) {
        m2936A();
        this.f44063c.m3338X(danmakuContext);
        this.f44063c.m3337Y(baseDanmakuParser);
        this.f44063c.m3339W(this.f44061a);
        this.f44063c.m3349M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    @SuppressLint({"NewApi"})
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPaused() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            return drawHandler.m3353I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPrepared() {
        DrawHandler drawHandler = this.f44063c;
        return drawHandler != null && drawHandler.m3354H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView
    public boolean isShown() {
        return this.f44072l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: j */
    public long mo2923j() {
        this.f44072l = false;
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            return 0L;
        }
        return drawHandler.m3357E(true);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: k */
    public void mo2922k(IDanmakuView.InterfaceC15340a interfaceC15340a, float f, float f2) {
        this.f44066f = interfaceC15340a;
        this.f44067g = f;
        this.f44068h = f2;
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: l */
    public long mo2921l() {
        if (this.f44064d) {
            if (isShown()) {
                long m59951b = SystemClock.m59951b();
                m2909x();
                return SystemClock.m59951b() - m59951b;
            }
            return -1L;
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: m */
    public void mo2920m(Long l) {
        this.f44072l = true;
        this.f44079s = false;
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3336Z(l);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: n */
    public void mo2919n() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3308v();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: o */
    public boolean mo2918o() {
        return this.f44064d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f44072l && !this.f44076p) {
            super.onDraw(canvas);
            return;
        }
        if (this.f44079s) {
            DrawHelper.m3299a(canvas);
            this.f44079s = false;
        } else {
            DrawHandler drawHandler = this.f44063c;
            if (drawHandler != null) {
                IRenderer.C0025c m3306x = drawHandler.m3306x(canvas);
                if (this.f44071k) {
                    if (this.f44078r == null) {
                        this.f44078r = new LinkedList<>();
                    }
                    DrawHelper.m3296d(canvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(m2912u()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(m3306x.f76r), Long.valueOf(m3306x.f77s)));
                }
            }
        }
        this.f44076p = false;
        m2933D();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3352J(i3 - i, i4 - i2);
        }
        this.f44064d = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean m2896k = this.f44070j.m2896k(motionEvent);
        return !m2896k ? super.onTouchEvent(motionEvent) : m2896k;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: p */
    public void mo2917p(boolean z) {
        this.f44065e = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void pause() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.removeCallbacks(this.f44081u);
            this.f44063c.m3350L();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f44078r;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void resume() {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null && drawHandler.m3354H()) {
            this.f44080t = 0;
            this.f44063c.post(this.f44081u);
        } else if (this.f44063c == null) {
            m2935B();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setCallback(DrawHandler.InterfaceC15331d interfaceC15331d) {
        this.f44061a = interfaceC15331d;
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler != null) {
            drawHandler.m3339W(interfaceC15331d);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setDrawingThreadType(int i) {
        this.f44073m = i;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setOnDanmakuClickListener(IDanmakuView.InterfaceC15340a interfaceC15340a) {
        this.f44066f = interfaceC15340a;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void show() {
        mo2920m(null);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start() {
        start(0L);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void stop() {
        m2934C();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void toggle() {
        if (this.f44064d) {
            DrawHandler drawHandler = this.f44063c;
            if (drawHandler == null) {
                start();
            } else if (drawHandler.m3353I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    /* renamed from: v */
    protected synchronized Looper m2911v(int i) {
        HandlerThread handlerThread = this.f44062b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f44062b = null;
        }
        if (i != 1) {
            int i2 = i != 2 ? i != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i2, i2);
            this.f44062b = handlerThread2;
            handlerThread2.start();
            return this.f44062b.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start(long j) {
        DrawHandler drawHandler = this.f44063c;
        if (drawHandler == null) {
            m2936A();
        } else {
            drawHandler.removeCallbacksAndMessages(null);
        }
        this.f44063c.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44065e = true;
        this.f44072l = true;
        this.f44073m = 0;
        this.f44074n = new Object();
        this.f44075o = false;
        this.f44076p = false;
        this.f44080t = 0;
        this.f44081u = new RunnableC15369a();
        m2910w();
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44065e = true;
        this.f44072l = true;
        this.f44073m = 0;
        this.f44074n = new Object();
        this.f44075o = false;
        this.f44076p = false;
        this.f44080t = 0;
        this.f44081u = new RunnableC15369a();
        m2910w();
    }
}
