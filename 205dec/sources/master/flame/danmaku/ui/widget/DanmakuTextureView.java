package master.flame.danmaku.ui.widget;

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
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DanmakuTextureView extends TextureView implements f, g, TextureView.SurfaceTextureListener {

    /* renamed from: n  reason: collision with root package name */
    public static final String f61317n = "DanmakuTextureView";

    /* renamed from: o  reason: collision with root package name */
    private static final int f61318o = 50;

    /* renamed from: p  reason: collision with root package name */
    private static final int f61319p = 1000;

    /* renamed from: a  reason: collision with root package name */
    private c.d f61320a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f61321b;

    /* renamed from: c  reason: collision with root package name */
    private c f61322c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61323d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f61324e;

    /* renamed from: f  reason: collision with root package name */
    private f.a f61325f;

    /* renamed from: g  reason: collision with root package name */
    private float f61326g;

    /* renamed from: h  reason: collision with root package name */
    private float f61327h;

    /* renamed from: i  reason: collision with root package name */
    private a f61328i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f61329j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f61330k;

    /* renamed from: l  reason: collision with root package name */
    protected int f61331l;

    /* renamed from: m  reason: collision with root package name */
    private LinkedList<Long> f61332m;

    public DanmakuTextureView(Context context) {
        super(context);
        this.f61324e = true;
        this.f61330k = true;
        this.f61331l = 0;
        s();
    }

    private float q() {
        long b4 = g3.c.b();
        this.f61332m.addLast(Long.valueOf(b4));
        Long peekFirst = this.f61332m.peekFirst();
        if (peekFirst == null) {
            return 0.0f;
        }
        float longValue = (float) (b4 - peekFirst.longValue());
        if (this.f61332m.size() > 50) {
            this.f61332m.removeFirst();
        }
        if (longValue > 0.0f) {
            return (this.f61332m.size() * 1000) / longValue;
        }
        return 0.0f;
    }

    @TargetApi(11)
    private void s() {
        setLayerType(2, null);
        setOpaque(false);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        setSurfaceTextureListener(this);
        d.f(true, true);
        this.f61328i = a.j(this);
    }

    private void t() {
        if (this.f61322c == null) {
            this.f61322c = new c(r(this.f61331l), this, this.f61330k);
        }
    }

    private synchronized void v() {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.O();
            this.f61322c = null;
        }
        HandlerThread handlerThread = this.f61321b;
        this.f61321b = null;
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
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.t(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.G(dVar, z3);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void c(boolean z3) {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.S(z3);
        }
    }

    @Override // master.flame.danmaku.controller.g
    public synchronized void clear() {
        if (o()) {
            Canvas lockCanvas = lockCanvas();
            if (lockCanvas != null) {
                d.a(lockCanvas);
                unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void d() {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.T();
        }
    }

    @Override // master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean e() {
        return this.f61324e;
    }

    @Override // master.flame.danmaku.controller.f
    public void f() {
        this.f61330k = false;
        c cVar = this.f61322c;
        if (cVar == null) {
            return;
        }
        cVar.E(false);
    }

    @Override // master.flame.danmaku.controller.f
    public void g(boolean z3) {
        this.f61329j = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public DanmakuContext getConfig() {
        c cVar = this.f61322c;
        if (cVar == null) {
            return null;
        }
        return cVar.z();
    }

    @Override // master.flame.danmaku.controller.f
    public long getCurrentTime() {
        c cVar = this.f61322c;
        if (cVar != null) {
            return cVar.A();
        }
        return 0L;
    }

    @Override // master.flame.danmaku.controller.f
    public m getCurrentVisibleDanmakus() {
        c cVar = this.f61322c;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    @Override // master.flame.danmaku.controller.f
    public f.a getOnDanmakuClickListener() {
        return this.f61325f;
    }

    @Override // master.flame.danmaku.controller.f
    public View getView() {
        return this;
    }

    @Override // master.flame.danmaku.controller.f
    public float getXOff() {
        return this.f61326g;
    }

    @Override // master.flame.danmaku.controller.f
    public float getYOff() {
        return this.f61327h;
    }

    @Override // master.flame.danmaku.controller.f
    public void h(Long l4) {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.V(l4);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void i(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext) {
        t();
        this.f61322c.X(danmakuContext);
        this.f61322c.Y(aVar);
        this.f61322c.W(this.f61320a);
        this.f61322c.M();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f, master.flame.danmaku.controller.g
    public boolean isHardwareAccelerated() {
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPaused() {
        c cVar = this.f61322c;
        if (cVar != null) {
            return cVar.I();
        }
        return false;
    }

    @Override // master.flame.danmaku.controller.f
    public boolean isPrepared() {
        c cVar = this.f61322c;
        return cVar != null && cVar.H();
    }

    @Override // android.view.View, master.flame.danmaku.controller.f
    public boolean isShown() {
        return this.f61330k && super.isShown();
    }

    @Override // master.flame.danmaku.controller.f
    public long j() {
        this.f61330k = false;
        c cVar = this.f61322c;
        if (cVar == null) {
            return 0L;
        }
        return cVar.E(true);
    }

    @Override // master.flame.danmaku.controller.f
    public void k(f.a aVar, float f4, float f5) {
        this.f61325f = aVar;
        this.f61326g = f4;
        this.f61327h = f5;
    }

    @Override // master.flame.danmaku.controller.g
    public synchronized long l() {
        if (this.f61323d) {
            long b4 = g3.c.b();
            if (isShown()) {
                Canvas lockCanvas = lockCanvas();
                if (lockCanvas != null) {
                    c cVar = this.f61322c;
                    if (cVar != null) {
                        a.c x3 = cVar.x(lockCanvas);
                        if (this.f61329j) {
                            if (this.f61332m == null) {
                                this.f61332m = new LinkedList<>();
                            }
                            g3.c.b();
                            d.d(lockCanvas, String.format(Locale.getDefault(), "fps %.2f,time:%d s,cache:%d,miss:%d", Float.valueOf(q()), Long.valueOf(getCurrentTime() / 1000), Long.valueOf(x3.f54697r), Long.valueOf(x3.f54698s)));
                        }
                    }
                    if (this.f61323d) {
                        unlockCanvasAndPost(lockCanvas);
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
        this.f61330k = true;
        c cVar = this.f61322c;
        if (cVar == null) {
            return;
        }
        cVar.Z(l4);
    }

    @Override // master.flame.danmaku.controller.f
    public void n() {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // master.flame.danmaku.controller.g
    public boolean o() {
        return this.f61323d;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.f61323d = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f61323d = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.J(i4, i5);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean k4 = this.f61328i.k(motionEvent);
        return !k4 ? super.onTouchEvent(motionEvent) : k4;
    }

    @Override // master.flame.danmaku.controller.f
    public void p(boolean z3) {
        this.f61324e = z3;
    }

    @Override // master.flame.danmaku.controller.f
    public void pause() {
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.L();
        }
    }

    protected synchronized Looper r(int i4) {
        HandlerThread handlerThread = this.f61321b;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f61321b = null;
        }
        if (i4 != 1) {
            int i5 = i4 != 2 ? i4 != 3 ? 0 : 19 : -8;
            HandlerThread handlerThread2 = new HandlerThread("DFM Handler Thread #" + i5, i5);
            this.f61321b = handlerThread2;
            handlerThread2.start();
            return this.f61321b.getLooper();
        }
        return Looper.getMainLooper();
    }

    @Override // master.flame.danmaku.controller.f
    public void release() {
        stop();
        LinkedList<Long> linkedList = this.f61332m;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void resume() {
        c cVar = this.f61322c;
        if (cVar != null && cVar.H()) {
            this.f61322c.U();
        } else if (this.f61322c == null) {
            u();
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setCallback(c.d dVar) {
        this.f61320a = dVar;
        c cVar = this.f61322c;
        if (cVar != null) {
            cVar.W(dVar);
        }
    }

    @Override // master.flame.danmaku.controller.f
    public void setDrawingThreadType(int i4) {
        this.f61331l = i4;
    }

    @Override // master.flame.danmaku.controller.f
    public void setOnDanmakuClickListener(f.a aVar) {
        this.f61325f = aVar;
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

    @Override // master.flame.danmaku.controller.f
    public void toggle() {
        if (this.f61323d) {
            c cVar = this.f61322c;
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
        c cVar = this.f61322c;
        if (cVar == null) {
            t();
        } else {
            cVar.removeCallbacksAndMessages(null);
        }
        this.f61322c.obtainMessage(1, Long.valueOf(j4)).sendToTarget();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61324e = true;
        this.f61330k = true;
        this.f61331l = 0;
        s();
    }

    public DanmakuTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f61324e = true;
        this.f61330k = true;
        this.f61331l = 0;
        s();
    }
}
