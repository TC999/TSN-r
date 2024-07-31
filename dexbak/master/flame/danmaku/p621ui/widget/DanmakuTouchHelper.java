package master.flame.danmaku.p621ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.Danmakus;

/* renamed from: master.flame.danmaku.ui.widget.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuTouchHelper {

    /* renamed from: a */
    private final GestureDetector f44083a;

    /* renamed from: b */
    private IDanmakuView f44084b;

    /* renamed from: c */
    private RectF f44085c;

    /* renamed from: d */
    private float f44086d;

    /* renamed from: e */
    private float f44087e;

    /* renamed from: f */
    private final GestureDetector.OnGestureListener f44088f;

    /* compiled from: DanmakuTouchHelper.java */
    /* renamed from: master.flame.danmaku.ui.widget.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15370a extends GestureDetector.SimpleOnGestureListener {
        C15370a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (DanmakuTouchHelper.this.f44084b == null || DanmakuTouchHelper.this.f44084b.getOnDanmakuClickListener() == null) {
                return false;
            }
            DanmakuTouchHelper danmakuTouchHelper = DanmakuTouchHelper.this;
            danmakuTouchHelper.f44086d = danmakuTouchHelper.f44084b.getXOff();
            DanmakuTouchHelper danmakuTouchHelper2 = DanmakuTouchHelper.this;
            danmakuTouchHelper2.f44087e = danmakuTouchHelper2.f44084b.getYOff();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (DanmakuTouchHelper.this.f44084b.getOnDanmakuClickListener() == null) {
                return;
            }
            DanmakuTouchHelper danmakuTouchHelper = DanmakuTouchHelper.this;
            danmakuTouchHelper.f44086d = danmakuTouchHelper.f44084b.getXOff();
            DanmakuTouchHelper danmakuTouchHelper2 = DanmakuTouchHelper.this;
            danmakuTouchHelper2.f44087e = danmakuTouchHelper2.f44084b.getYOff();
            IDanmakus m2893n = DanmakuTouchHelper.this.m2893n(motionEvent.getX(), motionEvent.getY());
            if (m2893n == null || m2893n.isEmpty()) {
                return;
            }
            DanmakuTouchHelper.this.m2895l(m2893n, true);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IDanmakus m2893n = DanmakuTouchHelper.this.m2893n(motionEvent.getX(), motionEvent.getY());
            boolean z = false;
            if (m2893n != null && !m2893n.isEmpty()) {
                z = DanmakuTouchHelper.this.m2895l(m2893n, false);
            }
            return !z ? DanmakuTouchHelper.this.m2894m() : z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DanmakuTouchHelper.java */
    /* renamed from: master.flame.danmaku.ui.widget.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15371b extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        final /* synthetic */ float f44090e;

        /* renamed from: f */
        final /* synthetic */ float f44091f;

        /* renamed from: g */
        final /* synthetic */ IDanmakus f44092g;

        C15371b(float f, float f2, IDanmakus iDanmakus) {
            this.f44090e = f;
            this.f44091f = f2;
            this.f44092g = iDanmakus;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            if (baseDanmaku != null) {
                DanmakuTouchHelper.this.f44085c.set(baseDanmaku.mo2999g(), baseDanmaku.mo2996l(), baseDanmaku.mo2997i(), baseDanmaku.mo3000d());
                if (DanmakuTouchHelper.this.f44085c.intersect(this.f44090e - DanmakuTouchHelper.this.f44086d, this.f44091f - DanmakuTouchHelper.this.f44087e, this.f44090e + DanmakuTouchHelper.this.f44086d, this.f44091f + DanmakuTouchHelper.this.f44087e)) {
                    this.f44092g.mo3049i(baseDanmaku);
                    return 0;
                }
                return 0;
            }
            return 0;
        }
    }

    private DanmakuTouchHelper(IDanmakuView iDanmakuView) {
        C15370a c15370a = new C15370a();
        this.f44088f = c15370a;
        this.f44084b = iDanmakuView;
        this.f44085c = new RectF();
        this.f44083a = new GestureDetector(((View) iDanmakuView).getContext(), c15370a);
    }

    /* renamed from: j */
    public static synchronized DanmakuTouchHelper m2897j(IDanmakuView iDanmakuView) {
        DanmakuTouchHelper danmakuTouchHelper;
        synchronized (DanmakuTouchHelper.class) {
            danmakuTouchHelper = new DanmakuTouchHelper(iDanmakuView);
        }
        return danmakuTouchHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m2895l(IDanmakus iDanmakus, boolean z) {
        IDanmakuView.InterfaceC15340a onDanmakuClickListener = this.f44084b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            if (z) {
                return onDanmakuClickListener.m3277c(iDanmakus);
            }
            return onDanmakuClickListener.m3279a(iDanmakus);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public boolean m2894m() {
        IDanmakuView.InterfaceC15340a onDanmakuClickListener = this.f44084b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.m3278b(this.f44084b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public IDanmakus m2893n(float f, float f2) {
        Danmakus danmakus = new Danmakus();
        this.f44085c.setEmpty();
        IDanmakus currentVisibleDanmakus = this.f44084b.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.mo3057a(new C15371b(f, f2, danmakus));
        }
        return danmakus;
    }

    /* renamed from: k */
    public boolean m2896k(MotionEvent motionEvent) {
        return this.f44083a.onTouchEvent(motionEvent);
    }
}
