package master.flame.danmaku.p621ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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

/* renamed from: master.flame.danmaku.ui.widget.DanmakuSurfaceView */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuSurfaceView extends SurfaceView implements IDanmakuView, IDanmakuViewController, SurfaceHolder.Callback {

    /* renamed from: o */
    public static final String f44025o = "DanmakuSurfaceView";

    /* renamed from: p */
    private static final int f44026p = 50;

    /* renamed from: q */
    private static final int f44027q = 1000;

    /* renamed from: a */
    private DrawHandler.InterfaceC15331d f44028a;

    /* renamed from: b */
    private SurfaceHolder f44029b;

    /* renamed from: c */
    private HandlerThread f44030c;

    /* renamed from: d */
    private DrawHandler f44031d;

    /* renamed from: e */
    private boolean f44032e;

    /* renamed from: f */
    private boolean f44033f;

    /* renamed from: g */
    private IDanmakuView.InterfaceC15340a f44034g;

    /* renamed from: h */
    private float f44035h;

    /* renamed from: i */
    private float f44036i;

    /* renamed from: j */
    private DanmakuTouchHelper f44037j;

    /* renamed from: k */
    private boolean f44038k;

    /* renamed from: l */
    private boolean f44039l;

    /* renamed from: m */
    protected int f44040m;

    /* renamed from: n */
    private LinkedList<Long> f44041n;

    public DanmakuSurfaceView(Context context) {
        super(context);
        this.f44033f = true;
        this.f44039l = true;
        this.f44040m = 0;
        m2946s();
    }

    /* renamed from: q */
    private float m2948q() {
        long m59951b = SystemClock.m59951b();
        this.f44041n.addLast(Long.valueOf(m59951b));
        Long peekFirst = this.f44041n.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (m59951b - peekFirst.longValue());
        if (this.f44041n.size() > 50) {
            this.f44041n.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f44041n.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    /* renamed from: s */
    private void m2946s() {
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        SurfaceHolder holder = getHolder();
        this.f44029b = holder;
        holder.addCallback(this);
        this.f44029b.setFormat(-2);
        DrawHelper.m3294f(true, true);
        this.f44037j = DanmakuTouchHelper.m2897j(this);
    }

    /* renamed from: t */
    private void m2945t() {
        if (this.f44031d == null) {
            this.f44031d = new DrawHandler(m2947r(this.f44040m), this, this.f44039l);
        }
    }

    /* renamed from: v */
    private synchronized void m2943v() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3347O();
            this.f44031d = null;
        }
        HandlerThread handlerThread = this.f44030c;
        this.f44030c = null;
        if (handlerThread != null) {
            try {
                handlerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handlerThread.quit();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: a */
    public void mo2932a(BaseDanmaku baseDanmaku) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3310t(baseDanmaku);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: b */
    public void mo2931b(BaseDanmaku baseDanmaku, boolean z) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3355G(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: c */
    public void mo2930c(boolean z) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3343S(z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public void clear() {
        Canvas lockCanvas;
        if (mo2918o() && (lockCanvas = this.f44029b.lockCanvas()) != null) {
            DrawHelper.m3299a(lockCanvas);
            this.f44029b.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: d */
    public void mo2929d() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3342T();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: e */
    public boolean mo2928e() {
        return this.f44033f;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: f */
    public void mo2927f() {
        this.f44039l = false;
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3357E(false);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: g */
    public void mo2926g(boolean z) {
        this.f44038k = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public DanmakuContext getConfig() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler == null) {
            return null;
        }
        return drawHandler.m3304z();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public long getCurrentTime() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            return drawHandler.m3361A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakus getCurrentVisibleDanmakus() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            return drawHandler.m3360B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakuView.InterfaceC15340a getOnDanmakuClickListener() {
        return this.f44034g;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getXOff() {
        return this.f44035h;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getYOff() {
        return this.f44036i;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: h */
    public void mo2925h(Long l) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3340V(l);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: i */
    public void mo2924i(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext) {
        m2945t();
        this.f44031d.m3338X(danmakuContext);
        this.f44031d.m3337Y(baseDanmakuParser);
        this.f44031d.m3339W(this.f44028a);
        this.f44031d.m3349M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPaused() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            return drawHandler.m3353I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPrepared() {
        DrawHandler drawHandler = this.f44031d;
        return drawHandler != null && drawHandler.m3354H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView
    public boolean isShown() {
        return this.f44039l && super.isShown();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: j */
    public long mo2923j() {
        this.f44039l = false;
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler == null) {
            return 0L;
        }
        return drawHandler.m3357E(true);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: k */
    public void mo2922k(IDanmakuView.InterfaceC15340a interfaceC15340a, float f, float f2) {
        this.f44034g = interfaceC15340a;
        this.f44035h = f;
        this.f44036i = f2;
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: l */
    public long mo2921l() {
        if (this.f44032e) {
            if (isShown()) {
                long m59951b = SystemClock.m59951b();
                Canvas lockCanvas = this.f44029b.lockCanvas();
                if (lockCanvas != null) {
                    DrawHandler drawHandler = this.f44031d;
                    if (drawHandler != null) {
                        IRenderer.C0025c m3306x = drawHandler.m3306x(lockCanvas);
                        if (this.f44038k) {
                            if (this.f44041n == null) {
                                this.f44041n = new LinkedList<>();
                            }
                            SystemClock.m59951b();
                            DrawHelper.m3296d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(m2948q()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(m3306x.f76r), Long.valueOf(m3306x.f77s)));
                        }
                    }
                    if (this.f44032e) {
                        this.f44029b.unlockCanvasAndPost(lockCanvas);
                    }
                }
                return SystemClock.m59951b() - m59951b;
            }
            return -1L;
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: m */
    public void mo2920m(Long l) {
        this.f44039l = true;
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3336Z(l);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: n */
    public void mo2919n() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3308v();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: o */
    public boolean mo2918o() {
        return this.f44032e;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean m2896k = this.f44037j.m2896k(motionEvent);
        return !m2896k ? super.onTouchEvent(motionEvent) : m2896k;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: p */
    public void mo2917p(boolean z) {
        this.f44033f = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void pause() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3350L();
        }
    }

    /* renamed from: r */
    protected synchronized Looper m2947r(int i) {
        HandlerThread handlerThread = this.f44030c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f44030c = null;
        }
        if (i != 1) {
            int i2 = i != 2 ? i != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i2, i2);
            this.f44030c = handlerThread2;
            handlerThread2.start();
            return this.f44030c.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f44041n;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void resume() {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null && drawHandler.m3354H()) {
            this.f44031d.m3341U();
        } else if (this.f44031d == null) {
            m2944u();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setCallback(DrawHandler.InterfaceC15331d interfaceC15331d) {
        this.f44028a = interfaceC15331d;
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3339W(interfaceC15331d);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setDrawingThreadType(int i) {
        this.f44040m = i;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setOnDanmakuClickListener(IDanmakuView.InterfaceC15340a interfaceC15340a) {
        this.f44034g = interfaceC15340a;
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
        m2943v();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler != null) {
            drawHandler.m3352J(i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f44032e = true;
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            DrawHelper.m3299a(lockCanvas);
            surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f44032e = false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void toggle() {
        if (this.f44032e) {
            DrawHandler drawHandler = this.f44031d;
            if (drawHandler == null) {
                start();
            } else if (drawHandler.m3353I()) {
                resume();
            } else {
                pause();
            }
        }
    }

    /* renamed from: u */
    public void m2944u() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start(long j) {
        DrawHandler drawHandler = this.f44031d;
        if (drawHandler == null) {
            m2945t();
        } else {
            drawHandler.removeCallbacksAndMessages(null);
        }
        this.f44031d.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44033f = true;
        this.f44039l = true;
        this.f44040m = 0;
        m2946s();
    }

    public DanmakuSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44033f = true;
        this.f44039l = true;
        this.f44040m = 0;
        m2946s();
    }
}
