package master.flame.danmaku.p621ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
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

@SuppressLint({"NewApi"})
/* renamed from: master.flame.danmaku.ui.widget.DanmakuTextureView */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuTextureView extends TextureView implements IDanmakuView, IDanmakuViewController, TextureView.SurfaceTextureListener {

    /* renamed from: n */
    public static final String f44042n = "DanmakuTextureView";

    /* renamed from: o */
    private static final int f44043o = 50;

    /* renamed from: p */
    private static final int f44044p = 1000;

    /* renamed from: a */
    private DrawHandler.InterfaceC15331d f44045a;

    /* renamed from: b */
    private HandlerThread f44046b;

    /* renamed from: c */
    private DrawHandler f44047c;

    /* renamed from: d */
    private boolean f44048d;

    /* renamed from: e */
    private boolean f44049e;

    /* renamed from: f */
    private IDanmakuView.InterfaceC15340a f44050f;

    /* renamed from: g */
    private float f44051g;

    /* renamed from: h */
    private float f44052h;

    /* renamed from: i */
    private DanmakuTouchHelper f44053i;

    /* renamed from: j */
    private boolean f44054j;

    /* renamed from: k */
    private boolean f44055k;

    /* renamed from: l */
    protected int f44056l;

    /* renamed from: m */
    private LinkedList<Long> f44057m;

    public DanmakuTextureView(Context context) {
        super(context);
        this.f44049e = true;
        this.f44055k = true;
        this.f44056l = 0;
        m2940s();
    }

    /* renamed from: q */
    private float m2942q() {
        long m59951b = SystemClock.m59951b();
        this.f44057m.addLast(Long.valueOf(m59951b));
        Long peekFirst = this.f44057m.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (m59951b - peekFirst.longValue());
        if (this.f44057m.size() > 50) {
            this.f44057m.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f44057m.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    @TargetApi(11)
    /* renamed from: s */
    private void m2940s() {
        setLayerType(2, null);
        setOpaque(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        setSurfaceTextureListener(this);
        DrawHelper.m3294f(true, true);
        this.f44053i = DanmakuTouchHelper.m2897j(this);
    }

    /* renamed from: t */
    private void m2939t() {
        if (this.f44047c == null) {
            this.f44047c = new DrawHandler(m2941r(this.f44056l), this, this.f44055k);
        }
    }

    /* renamed from: v */
    private synchronized void m2937v() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3347O();
            this.f44047c = null;
        }
        HandlerThread handlerThread = this.f44046b;
        this.f44046b = null;
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
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3310t(baseDanmaku);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: b */
    public void mo2931b(BaseDanmaku baseDanmaku, boolean z) {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3355G(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: c */
    public void mo2930c(boolean z) {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3343S(z);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    public synchronized void clear() {
        if (mo2918o()) {
            Canvas lockCanvas = lockCanvas();
            if (lockCanvas != null) {
                DrawHelper.m3299a(lockCanvas);
                unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: d */
    public void mo2929d() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3342T();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: e */
    public boolean mo2928e() {
        return this.f44049e;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: f */
    public void mo2927f() {
        this.f44055k = false;
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3357E(false);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: g */
    public void mo2926g(boolean z) {
        this.f44054j = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public DanmakuContext getConfig() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler == null) {
            return null;
        }
        return drawHandler.m3304z();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public long getCurrentTime() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            return drawHandler.m3361A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakus getCurrentVisibleDanmakus() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            return drawHandler.m3360B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public IDanmakuView.InterfaceC15340a getOnDanmakuClickListener() {
        return this.f44050f;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getXOff() {
        return this.f44051g;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public float getYOff() {
        return this.f44052h;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: h */
    public void mo2925h(Long l) {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3340V(l);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: i */
    public void mo2924i(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext) {
        m2939t();
        this.f44047c.m3338X(danmakuContext);
        this.f44047c.m3337Y(baseDanmakuParser);
        this.f44047c.m3339W(this.f44045a);
        this.f44047c.m3349M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView, master.flame.danmaku.controller.IDanmakuViewController
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPaused() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            return drawHandler.m3353I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public boolean isPrepared() {
        DrawHandler drawHandler = this.f44047c;
        return drawHandler != null && drawHandler.m3354H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.IDanmakuView
    public boolean isShown() {
        return this.f44055k && super.isShown();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: j */
    public long mo2923j() {
        this.f44055k = false;
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler == null) {
            return 0L;
        }
        return drawHandler.m3357E(true);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: k */
    public void mo2922k(IDanmakuView.InterfaceC15340a interfaceC15340a, float f, float f2) {
        this.f44050f = interfaceC15340a;
        this.f44051g = f;
        this.f44052h = f2;
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: l */
    public synchronized long mo2921l() {
        if (this.f44048d) {
            long m59951b = SystemClock.m59951b();
            if (isShown()) {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    DrawHandler drawHandler = this.f44047c;
                    if (drawHandler != null) {
                        IRenderer.C0025c m3306x = drawHandler.m3306x(lockCanvas);
                        if (this.f44054j) {
                            if (this.f44057m == null) {
                                this.f44057m = new LinkedList<>();
                            }
                            SystemClock.m59951b();
                            DrawHelper.m3296d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(m2942q()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(m3306x.f76r), Long.valueOf(m3306x.f77s)));
                        }
                    }
                    if (this.f44048d) {
                        unlockCanvasAndPost(lockCanvas);
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
        this.f44055k = true;
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler == null) {
            return;
        }
        drawHandler.m3336Z(l);
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: n */
    public void mo2919n() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3308v();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuViewController
    /* renamed from: o */
    public boolean mo2918o() {
        return this.f44048d;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f44048d = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f44048d = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3352J(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean m2896k = this.f44053i.m2896k(motionEvent);
        return !m2896k ? super.onTouchEvent(motionEvent) : m2896k;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    /* renamed from: p */
    public void mo2917p(boolean z) {
        this.f44049e = z;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void pause() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3350L();
        }
    }

    /* renamed from: r */
    protected synchronized Looper m2941r(int i) {
        HandlerThread handlerThread = this.f44046b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f44046b = null;
        }
        if (i != 1) {
            int i2 = i != 2 ? i != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i2, i2);
            this.f44046b = handlerThread2;
            handlerThread2.start();
            return this.f44046b.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f44057m;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void resume() {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null && drawHandler.m3354H()) {
            this.f44047c.m3341U();
        } else if (this.f44047c == null) {
            m2938u();
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setCallback(DrawHandler.InterfaceC15331d interfaceC15331d) {
        this.f44045a = interfaceC15331d;
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler != null) {
            drawHandler.m3339W(interfaceC15331d);
        }
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setDrawingThreadType(int i) {
        this.f44056l = i;
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void setOnDanmakuClickListener(IDanmakuView.InterfaceC15340a interfaceC15340a) {
        this.f44050f = interfaceC15340a;
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
        m2937v();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void toggle() {
        if (this.f44048d) {
            DrawHandler drawHandler = this.f44047c;
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
    public void m2938u() {
        stop();
        start();
    }

    @Override // master.flame.danmaku.controller.IDanmakuView
    public void start(long j) {
        DrawHandler drawHandler = this.f44047c;
        if (drawHandler == null) {
            m2939t();
        } else {
            drawHandler.removeCallbacksAndMessages(null);
        }
        this.f44047c.obtainMessage(1, Long.valueOf(j)).sendToTarget();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44049e = true;
        this.f44055k = true;
        this.f44056l = 0;
        m2940s();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44049e = true;
        this.f44055k = true;
        this.f44056l = 0;
        m2940s();
    }
}
