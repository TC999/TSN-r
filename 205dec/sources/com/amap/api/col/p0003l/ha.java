package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0003l.s;
import com.amap.api.col.p0003l.t;
import com.amap.api.col.p0003l.v;
import com.amap.api.col.p0003l.w;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: GlMapGestureDetector.java */
/* renamed from: com.amap.api.col.3l.ha  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ha {

    /* renamed from: a  reason: collision with root package name */
    IAMapDelegate f8030a;

    /* renamed from: b  reason: collision with root package name */
    Context f8031b;

    /* renamed from: c  reason: collision with root package name */
    GestureDetector f8032c;

    /* renamed from: d  reason: collision with root package name */
    private v f8033d;

    /* renamed from: e  reason: collision with root package name */
    private t f8034e;

    /* renamed from: f  reason: collision with root package name */
    private s f8035f;

    /* renamed from: g  reason: collision with root package name */
    private w f8036g;

    /* renamed from: q  reason: collision with root package name */
    private int f8046q;

    /* renamed from: r  reason: collision with root package name */
    private int f8047r;

    /* renamed from: s  reason: collision with root package name */
    public AMapGestureListener f8048s;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8037h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f8038i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f8039j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f8040k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f8041l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f8042m = 0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8043n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8044o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8045p = true;

    /* renamed from: t  reason: collision with root package name */
    private Handler f8049t = new Handler(Looper.getMainLooper());

    public ha(IAMapDelegate iAMapDelegate) {
        this.f8031b = iAMapDelegate.getContext();
        this.f8030a = iAMapDelegate;
        a aVar = new a(this, (byte) 0);
        GestureDetector gestureDetector = new GestureDetector(this.f8031b, aVar, this.f8049t);
        this.f8032c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.f8033d = new v(this.f8031b, new d(this, (byte) 0));
        this.f8034e = new t(this.f8031b, new c(this, (byte) 0));
        this.f8035f = new s(this.f8031b, new b(this, (byte) 0));
        this.f8036g = new w(this.f8031b, new e(this, (byte) 0));
    }

    static /* synthetic */ int o(ha haVar) {
        int i4 = haVar.f8039j;
        haVar.f8039j = i4 + 1;
        return i4;
    }

    static /* synthetic */ int p(ha haVar) {
        int i4 = haVar.f8040k;
        haVar.f8040k = i4 + 1;
        return i4;
    }

    static /* synthetic */ int t(ha haVar) {
        int i4 = haVar.f8038i;
        haVar.f8038i = i4 + 1;
        return i4;
    }

    static /* synthetic */ int u(ha haVar) {
        int i4 = haVar.f8041l;
        haVar.f8041l = i4 + 1;
        return i4;
    }

    static /* synthetic */ boolean v(ha haVar) {
        haVar.f8045p = true;
        return true;
    }

    public final void b() {
        this.f8038i = 0;
        this.f8040k = 0;
        this.f8039j = 0;
        this.f8041l = 0;
        this.f8042m = 0;
    }

    public final void c(int i4, int i5) {
        this.f8046q = i4;
        this.f8047r = i5;
        v vVar = this.f8033d;
        if (vVar != null) {
            vVar.d(i4, i5);
        }
        t tVar = this.f8034e;
        if (tVar != null) {
            tVar.b(i4, i5);
        }
        s sVar = this.f8035f;
        if (sVar != null) {
            sVar.b(i4, i5);
        }
        w wVar = this.f8036g;
        if (wVar != null) {
            wVar.b(i4, i5);
        }
    }

    public final void d(AMapGestureListener aMapGestureListener) {
        this.f8048s = aMapGestureListener;
    }

    public final boolean e(MotionEvent motionEvent) {
        if (this.f8042m < motionEvent.getPointerCount()) {
            this.f8042m = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f8044o = false;
            this.f8045p = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f8044o = true;
        }
        if (this.f8043n && this.f8042m >= 2) {
            this.f8043n = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f8030a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f8030a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f8048s != null) {
                if (motionEvent.getAction() == 0) {
                    this.f8048s.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f8048s.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f8032c.onTouchEvent(motionEvent);
            this.f8035f.h(motionEvent, iArr[0], iArr[1]);
            if (!this.f8037h || this.f8041l <= 0) {
                this.f8036g.h(motionEvent, iArr[0], iArr[1]);
                if (!this.f8043n) {
                    this.f8033d.e(motionEvent);
                    this.f8034e.h(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int g() {
        return this.f8046q;
    }

    public final int j() {
        return this.f8047r;
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ha$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class b implements s.a {

        /* renamed from: a  reason: collision with root package name */
        private EAMapPlatformGestureInfo f8055a;

        private b() {
            this.f8055a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final void a(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8055a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ha.this.f8030a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8055a);
                    if (ha.this.f8030a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (ha.this.f8030a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && ha.this.f8041l > 0) {
                        ha.this.f8030a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    ha.this.f8037h = false;
                    IAMapDelegate iAMapDelegate = ha.this.f8030a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final boolean b(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8055a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z3 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ha.this.f8030a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8055a);
                    if (!ha.this.f8030a.isLockMapCameraDegree(engineIDWithGestureInfo) && ha.this.f8040k <= 3) {
                        float f4 = sVar.n().x;
                        float f5 = sVar.n().y;
                        if (!ha.this.f8037h) {
                            PointF k4 = sVar.k(0);
                            PointF k5 = sVar.k(1);
                            float f6 = k4.y;
                            if ((f6 > 10.0f && k5.y > 10.0f) || (f6 < -10.0f && k5.y < -10.0f)) {
                                z3 = true;
                            }
                            if (z3 && Math.abs(f5) > 10.0f && Math.abs(f4) < 10.0f) {
                                ha.this.f8037h = true;
                            }
                        }
                        if (ha.this.f8037h) {
                            ha.this.f8037h = true;
                            float f7 = f5 / 6.0f;
                            if (Math.abs(f7) > 1.0f) {
                                ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f7));
                                ha.u(ha.this);
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final boolean c(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8055a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ha.this.f8030a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8055a);
                    if (ha.this.f8030a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    IAMapDelegate iAMapDelegate = ha.this.f8030a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ b(ha haVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ha$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class c implements t.a {

        /* renamed from: a  reason: collision with root package name */
        private EAMapPlatformGestureInfo f8057a;

        private c() {
            this.f8057a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final boolean a(t tVar) {
            try {
                if (ha.this.f8030a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8057a;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                    ha.this.f8030a.addGestureMapMessage(ha.this.f8030a.getEngineIDWithGestureInfo(this.f8057a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, tVar.i().getX(), tVar.i().getY()));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final void b(t tVar) {
            try {
                if (ha.this.f8030a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8057a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8057a);
                    if (ha.this.f8038i > 0) {
                        ha.this.f8030a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, tVar.i().getX(), tVar.i().getY()));
                }
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final boolean c(t tVar) {
            if (ha.this.f8037h) {
                return true;
            }
            try {
                if (ha.this.f8030a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!ha.this.f8044o) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8057a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                        int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8057a);
                        PointF j4 = tVar.j();
                        float f4 = ha.this.f8038i == 0 ? 4.0f : 1.0f;
                        if (Math.abs(j4.x) <= f4 && Math.abs(j4.y) <= f4) {
                            return false;
                        }
                        if (ha.this.f8038i == 0) {
                            ha.this.f8030a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, j4.x, j4.y, tVar.i().getX(), tVar.i().getY()));
                        ha.t(ha.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ c(ha haVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ha$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class e extends w.b {

        /* renamed from: a  reason: collision with root package name */
        EAMapPlatformGestureInfo f8069a;

        private e() {
            this.f8069a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.w.b, com.amap.api.col.p0003l.w.a
        public final void a(w wVar) {
            try {
                if (ha.this.f8030a.getUiSettings().isZoomGesturesEnabled() && Math.abs(wVar.n()) <= 10.0f && Math.abs(wVar.o()) <= 10.0f && wVar.f() < 200) {
                    ha.v(ha.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8069a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{wVar.i().getX(), wVar.i().getY()};
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8069a);
                    ha.this.f8030a.setGestureStatus(engineIDWithGestureInfo, 4);
                    ha.this.f8030a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        /* synthetic */ e(ha haVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ha$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private int f8050a;

        /* renamed from: b  reason: collision with root package name */
        float f8051b;

        /* renamed from: c  reason: collision with root package name */
        private EAMapPlatformGestureInfo f8052c;

        /* renamed from: d  reason: collision with root package name */
        long f8053d;

        private a() {
            this.f8050a = 0;
            this.f8051b = 0.0f;
            this.f8052c = new EAMapPlatformGestureInfo();
            this.f8053d = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            ha.this.f8032c.setIsLongpressEnabled(false);
            this.f8050a = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = ha.this.f8048s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f8050a < motionEvent.getPointerCount()) {
                this.f8050a = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f8050a == 1) {
                try {
                    if (!ha.this.f8030a.getUiSettings().isZoomGesturesEnabled()) {
                        ha.this.f8032c.setIsLongpressEnabled(true);
                        return false;
                    }
                } catch (Throwable th) {
                    u5.p(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                if (action == 0) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8052c;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 9;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c);
                    this.f8051b = motionEvent.getY();
                    ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.f8053d = SystemClock.uptimeMillis();
                    return true;
                } else if (action == 2) {
                    ha.this.f8043n = true;
                    float y3 = this.f8051b - motionEvent.getY();
                    if (Math.abs(y3) >= 20.0f) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f8052c;
                        eAMapPlatformGestureInfo2.mGestureState = 2;
                        eAMapPlatformGestureInfo2.mGestureType = 9;
                        eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                        ha.this.f8030a.addGestureMapMessage(ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c), ScaleGestureMapMessage.obtain(101, (y3 * 4.0f) / ha.this.f8030a.getMapHeight(), 0, 0));
                        this.f8051b = motionEvent.getY();
                        return true;
                    }
                    return true;
                } else {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f8052c;
                    eAMapPlatformGestureInfo3.mGestureState = 3;
                    eAMapPlatformGestureInfo3.mGestureType = 9;
                    eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo2 = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c);
                    ha.this.f8032c.setIsLongpressEnabled(true);
                    ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action == 1) {
                        ha.this.f8030a.setGestureStatus(engineIDWithGestureInfo2, 3);
                        long uptimeMillis = SystemClock.uptimeMillis() - this.f8053d;
                        if (ha.this.f8043n && uptimeMillis >= 200) {
                            ha.this.f8043n = false;
                            return true;
                        }
                        return ha.this.f8030a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                    ha.this.f8043n = false;
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            ha.this.f8043n = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            AMapGestureListener aMapGestureListener = ha.this.f8048s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f4, f5);
            }
            try {
                if (ha.this.f8030a.getUiSettings().isScrollGesturesEnabled() && ha.this.f8041l <= 0 && ha.this.f8039j <= 0 && ha.this.f8040k == 0 && !ha.this.f8045p) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8052c;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c);
                    ha.this.f8030a.onFling();
                    ha.this.f8030a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f4, f5);
                }
                return true;
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (ha.this.f8042m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8052c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ha.this.f8030a.onLongPress(ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c), motionEvent);
                AMapGestureListener aMapGestureListener = ha.this.f8048s;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            AMapGestureListener aMapGestureListener = ha.this.f8048s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onScroll(f4, f5);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8052c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ha.this.f8030a.getGLMapEngine().clearAnimations(ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ha.this.f8042m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8052c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 8;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8052c);
                AMapGestureListener aMapGestureListener = ha.this.f8048s;
                if (aMapGestureListener != null) {
                    try {
                        aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return ha.this.f8030a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        /* synthetic */ a(ha haVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ha$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class d extends v.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8059a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8060b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8061c;

        /* renamed from: d  reason: collision with root package name */
        private Point f8062d;

        /* renamed from: e  reason: collision with root package name */
        private float[] f8063e;

        /* renamed from: f  reason: collision with root package name */
        private float f8064f;

        /* renamed from: g  reason: collision with root package name */
        private float[] f8065g;

        /* renamed from: h  reason: collision with root package name */
        private float f8066h;

        /* renamed from: i  reason: collision with root package name */
        private EAMapPlatformGestureInfo f8067i;

        private d() {
            this.f8059a = false;
            this.f8060b = false;
            this.f8061c = false;
            this.f8062d = new Point();
            this.f8063e = new float[10];
            this.f8064f = 0.0f;
            this.f8065g = new float[10];
            this.f8066h = 0.0f;
            this.f8067i = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00f3 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fc A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0124 A[Catch: all -> 0x019c, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x016b A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        @Override // com.amap.api.col.p0003l.v.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean d(com.amap.api.col.p0003l.v r18) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ha.d.d(com.amap.api.col.3l.v):boolean");
        }

        @Override // com.amap.api.col.p0003l.v.a
        public final boolean e(v vVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8067i;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{vVar.c().getX(), vVar.c().getY()};
            int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8067i);
            int f4 = (int) vVar.f();
            int i4 = (int) vVar.i();
            this.f8061c = false;
            Point point = this.f8062d;
            point.x = f4;
            point.y = i4;
            this.f8059a = false;
            this.f8060b = false;
            ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, f4, i4));
            try {
                if (ha.this.f8030a.getUiSettings().isRotateGesturesEnabled() && !ha.this.f8030a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = ha.this.f8030a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), f4, i4));
                }
            } catch (Throwable th) {
                u5.p(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.p0003l.v.a
        public final void f(v vVar) {
            float f4;
            float f5;
            float f6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f8067i;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z3 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{vVar.c().getX(), vVar.c().getY()};
            int engineIDWithGestureInfo = ha.this.f8030a.getEngineIDWithGestureInfo(this.f8067i);
            this.f8061c = false;
            ha.this.f8030a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (ha.this.f8039j > 0) {
                int i4 = ha.this.f8039j > 10 ? 10 : ha.this.f8039j;
                float f7 = 0.0f;
                for (int i5 = 0; i5 < 10; i5++) {
                    float[] fArr = this.f8063e;
                    f7 += fArr[i5];
                    fArr[i5] = 0.0f;
                }
                float f8 = f7 / i4;
                if (0.004f <= f8) {
                    float f9 = f8 * 300.0f;
                    if (f9 >= 1.5f) {
                        f9 = 1.5f;
                    }
                    if (this.f8064f < 0.0f) {
                        f9 = -f9;
                    }
                    f6 = ha.this.f8030a.getPreciseLevel(engineIDWithGestureInfo) + f9;
                } else {
                    f6 = -9999.0f;
                }
                this.f8064f = 0.0f;
                f4 = f6;
            } else {
                f4 = -9999.0f;
            }
            if (ha.this.f8030a.isLockMapAngle(engineIDWithGestureInfo)) {
                f5 = -9999.0f;
            } else {
                try {
                    if (ha.this.f8030a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = ha.this.f8030a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    u5.p(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (ha.this.f8040k > 0) {
                    ha.this.f8030a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i6 = ha.this.f8040k > 10 ? 10 : ha.this.f8040k;
                    float f10 = 0.0f;
                    for (int i7 = 0; i7 < 10; i7++) {
                        float[] fArr2 = this.f8065g;
                        f10 += fArr2[i7];
                        fArr2[i7] = 0.0f;
                    }
                    float f11 = f10 / i6;
                    if (0.1f <= f11) {
                        float f12 = f11 * 200.0f;
                        int mapAngle = ((int) ha.this.f8030a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f12 >= 60.0f) {
                            f12 = 60.0f;
                        }
                        if (this.f8066h < 0.0f) {
                            f12 = -f12;
                        }
                        f5 = ((int) (mapAngle + f12)) % 360;
                        this.f8064f = 0.0f;
                    }
                }
                f5 = -9999.0f;
                this.f8064f = 0.0f;
            }
            if ((f4 == -9999.0f && f5 == -9999.0f) ? true : true) {
                ha.this.f8030a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f8062d, f4, (int) f5, 500);
            }
        }

        /* synthetic */ d(ha haVar, byte b4) {
            this();
        }
    }
}
