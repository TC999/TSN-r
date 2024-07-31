package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0463l.HoverGestureDetectorAbstract;
import com.amap.api.col.p0463l.MoveGestureDetector;
import com.amap.api.col.p0463l.ScaleRotateGestureDetector;
import com.amap.api.col.p0463l.ZoomOutGestureDetectorAbstract;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.p048ae.gmap.gesture.EAMapPlatformGestureInfo;

/* renamed from: com.amap.api.col.3l.ga */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GlMapGestureDetector {

    /* renamed from: a */
    IAMapDelegate f4307a;

    /* renamed from: b */
    Context f4308b;

    /* renamed from: c */
    GestureDetector f4309c;

    /* renamed from: d */
    private ScaleRotateGestureDetector f4310d;

    /* renamed from: e */
    private MoveGestureDetector f4311e;

    /* renamed from: f */
    private HoverGestureDetectorAbstract f4312f;

    /* renamed from: g */
    private ZoomOutGestureDetectorAbstract f4313g;

    /* renamed from: q */
    private int f4323q;

    /* renamed from: r */
    private int f4324r;

    /* renamed from: s */
    public AMapGestureListener f4325s;

    /* renamed from: h */
    private boolean f4314h = false;

    /* renamed from: i */
    private int f4315i = 0;

    /* renamed from: j */
    private int f4316j = 0;

    /* renamed from: k */
    private int f4317k = 0;

    /* renamed from: l */
    private int f4318l = 0;

    /* renamed from: m */
    private int f4319m = 0;

    /* renamed from: n */
    private boolean f4320n = false;

    /* renamed from: o */
    private boolean f4321o = false;

    /* renamed from: p */
    private boolean f4322p = true;

    /* renamed from: t */
    private Handler f4326t = new Handler(Looper.getMainLooper());

    public GlMapGestureDetector(IAMapDelegate iAMapDelegate) {
        this.f4308b = iAMapDelegate.getContext();
        this.f4307a = iAMapDelegate;
        GestureDetector$OnDoubleTapListenerC1823a gestureDetector$OnDoubleTapListenerC1823a = new GestureDetector$OnDoubleTapListenerC1823a(this, (byte) 0);
        GestureDetector gestureDetector = new GestureDetector(this.f4308b, gestureDetector$OnDoubleTapListenerC1823a, this.f4326t);
        this.f4309c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(gestureDetector$OnDoubleTapListenerC1823a);
        this.f4310d = new ScaleRotateGestureDetector(this.f4308b, new C1826d(this, (byte) 0));
        this.f4311e = new MoveGestureDetector(this.f4308b, new C1825c(this, (byte) 0));
        this.f4312f = new HoverGestureDetectorAbstract(this.f4308b, new C1824b(this, (byte) 0));
        this.f4313g = new ZoomOutGestureDetectorAbstract(this.f4308b, new C1827e(this, (byte) 0));
    }

    /* renamed from: o */
    static /* synthetic */ int m54881o(GlMapGestureDetector glMapGestureDetector) {
        int i = glMapGestureDetector.f4316j;
        glMapGestureDetector.f4316j = i + 1;
        return i;
    }

    /* renamed from: p */
    static /* synthetic */ int m54880p(GlMapGestureDetector glMapGestureDetector) {
        int i = glMapGestureDetector.f4317k;
        glMapGestureDetector.f4317k = i + 1;
        return i;
    }

    /* renamed from: t */
    static /* synthetic */ int m54876t(GlMapGestureDetector glMapGestureDetector) {
        int i = glMapGestureDetector.f4315i;
        glMapGestureDetector.f4315i = i + 1;
        return i;
    }

    /* renamed from: u */
    static /* synthetic */ int m54875u(GlMapGestureDetector glMapGestureDetector) {
        int i = glMapGestureDetector.f4318l;
        glMapGestureDetector.f4318l = i + 1;
        return i;
    }

    /* renamed from: v */
    static /* synthetic */ boolean m54874v(GlMapGestureDetector glMapGestureDetector) {
        glMapGestureDetector.f4322p = true;
        return true;
    }

    /* renamed from: b */
    public final void m54894b() {
        this.f4315i = 0;
        this.f4317k = 0;
        this.f4316j = 0;
        this.f4318l = 0;
        this.f4319m = 0;
    }

    /* renamed from: c */
    public final void m54893c(int i, int i2) {
        this.f4323q = i;
        this.f4324r = i2;
        ScaleRotateGestureDetector scaleRotateGestureDetector = this.f4310d;
        if (scaleRotateGestureDetector != null) {
            scaleRotateGestureDetector.m53827d(i, i2);
        }
        MoveGestureDetector moveGestureDetector = this.f4311e;
        if (moveGestureDetector != null) {
            moveGestureDetector.m54091b(i, i2);
        }
        HoverGestureDetectorAbstract hoverGestureDetectorAbstract = this.f4312f;
        if (hoverGestureDetectorAbstract != null) {
            hoverGestureDetectorAbstract.m54091b(i, i2);
        }
        ZoomOutGestureDetectorAbstract zoomOutGestureDetectorAbstract = this.f4313g;
        if (zoomOutGestureDetectorAbstract != null) {
            zoomOutGestureDetectorAbstract.m54091b(i, i2);
        }
    }

    /* renamed from: d */
    public final void m54892d(AMapGestureListener aMapGestureListener) {
        this.f4325s = aMapGestureListener;
    }

    /* renamed from: e */
    public final boolean m54891e(MotionEvent motionEvent) {
        if (this.f4319m < motionEvent.getPointerCount()) {
            this.f4319m = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f4321o = false;
            this.f4322p = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f4321o = true;
        }
        if (this.f4320n && this.f4319m >= 2) {
            this.f4320n = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f4307a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f4307a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f4325s != null) {
                if (motionEvent.getAction() == 0) {
                    this.f4325s.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f4325s.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f4309c.onTouchEvent(motionEvent);
            this.f4312f.m54088h(motionEvent, iArr[0], iArr[1]);
            if (!this.f4314h || this.f4318l <= 0) {
                this.f4313g.m54088h(motionEvent, iArr[0], iArr[1]);
                if (!this.f4320n) {
                    this.f4310d.m53826e(motionEvent);
                    this.f4311e.m54088h(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: g */
    public final int m54889g() {
        return this.f4323q;
    }

    /* renamed from: j */
    public final int m54886j() {
        return this.f4324r;
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1824b implements HoverGestureDetectorAbstract.InterfaceC1935a {

        /* renamed from: a */
        private EAMapPlatformGestureInfo f4332a;

        private C1824b() {
            this.f4332a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0463l.HoverGestureDetectorAbstract.InterfaceC1935a
        /* renamed from: a */
        public final void mo54017a(HoverGestureDetectorAbstract hoverGestureDetectorAbstract) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4332a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{hoverGestureDetectorAbstract.m54087i().getX(), hoverGestureDetectorAbstract.m54087i().getY()};
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4332a);
                    if (GlMapGestureDetector.this.f4307a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (GlMapGestureDetector.this.f4307a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && GlMapGestureDetector.this.f4318l > 0) {
                        GlMapGestureDetector.this.f4307a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    GlMapGestureDetector.this.f4314h = false;
                    IAMapDelegate iAMapDelegate = GlMapGestureDetector.this.f4307a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0463l.HoverGestureDetectorAbstract.InterfaceC1935a
        /* renamed from: b */
        public final boolean mo54016b(HoverGestureDetectorAbstract hoverGestureDetectorAbstract) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4332a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{hoverGestureDetectorAbstract.m54087i().getX(), hoverGestureDetectorAbstract.m54087i().getY()};
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4332a);
                    if (!GlMapGestureDetector.this.f4307a.isLockMapCameraDegree(engineIDWithGestureInfo) && GlMapGestureDetector.this.f4317k <= 3) {
                        float f = hoverGestureDetectorAbstract.m54018n().x;
                        float f2 = hoverGestureDetectorAbstract.m54018n().y;
                        if (!GlMapGestureDetector.this.f4314h) {
                            PointF m54158k = hoverGestureDetectorAbstract.m54158k(0);
                            PointF m54158k2 = hoverGestureDetectorAbstract.m54158k(1);
                            float f3 = m54158k.y;
                            if ((f3 > 10.0f && m54158k2.y > 10.0f) || (f3 < -10.0f && m54158k2.y < -10.0f)) {
                                z = true;
                            }
                            if (z && Math.abs(f2) > 10.0f && Math.abs(f) < 10.0f) {
                                GlMapGestureDetector.this.f4314h = true;
                            }
                        }
                        if (GlMapGestureDetector.this.f4314h) {
                            GlMapGestureDetector.this.f4314h = true;
                            float f4 = f2 / 6.0f;
                            if (Math.abs(f4) > 1.0f) {
                                GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f4));
                                GlMapGestureDetector.m54875u(GlMapGestureDetector.this);
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0463l.HoverGestureDetectorAbstract.InterfaceC1935a
        /* renamed from: c */
        public final boolean mo54015c(HoverGestureDetectorAbstract hoverGestureDetectorAbstract) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4332a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{hoverGestureDetectorAbstract.m54087i().getX(), hoverGestureDetectorAbstract.m54087i().getY()};
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4332a);
                    if (GlMapGestureDetector.this.f4307a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    IAMapDelegate iAMapDelegate = GlMapGestureDetector.this.f4307a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ C1824b(GlMapGestureDetector glMapGestureDetector, byte b) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1825c implements MoveGestureDetector.InterfaceC1943a {

        /* renamed from: a */
        private EAMapPlatformGestureInfo f4334a;

        private C1825c() {
            this.f4334a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0463l.MoveGestureDetector.InterfaceC1943a
        /* renamed from: a */
        public final boolean mo53901a(MoveGestureDetector moveGestureDetector) {
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4334a;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()};
                    GlMapGestureDetector.this.f4307a.addGestureMapMessage(GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4334a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0463l.MoveGestureDetector.InterfaceC1943a
        /* renamed from: b */
        public final void mo53900b(MoveGestureDetector moveGestureDetector) {
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4334a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()};
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4334a);
                    if (GlMapGestureDetector.this.f4315i > 0) {
                        GlMapGestureDetector.this.f4307a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()));
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0463l.MoveGestureDetector.InterfaceC1943a
        /* renamed from: c */
        public final boolean mo53899c(MoveGestureDetector moveGestureDetector) {
            if (GlMapGestureDetector.this.f4314h) {
                return true;
            }
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!GlMapGestureDetector.this.f4321o) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4334a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()};
                        int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4334a);
                        PointF m53902j = moveGestureDetector.m53902j();
                        float f = GlMapGestureDetector.this.f4315i == 0 ? 4.0f : 1.0f;
                        if (Math.abs(m53902j.x) <= f && Math.abs(m53902j.y) <= f) {
                            return false;
                        }
                        if (GlMapGestureDetector.this.f4315i == 0) {
                            GlMapGestureDetector.this.f4307a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, m53902j.x, m53902j.y, moveGestureDetector.m54087i().getX(), moveGestureDetector.m54087i().getY()));
                        GlMapGestureDetector.m54876t(GlMapGestureDetector.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ C1825c(GlMapGestureDetector glMapGestureDetector, byte b) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1827e extends ZoomOutGestureDetectorAbstract.C1976b {

        /* renamed from: a */
        EAMapPlatformGestureInfo f4346a;

        private C1827e() {
            this.f4346a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0463l.ZoomOutGestureDetectorAbstract.C1976b, com.amap.api.col.p0463l.ZoomOutGestureDetectorAbstract.InterfaceC1975a
        /* renamed from: a */
        public final void mo53624a(ZoomOutGestureDetectorAbstract zoomOutGestureDetectorAbstract) {
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isZoomGesturesEnabled() && Math.abs(zoomOutGestureDetectorAbstract.m53626n()) <= 10.0f && Math.abs(zoomOutGestureDetectorAbstract.m53625o()) <= 10.0f && zoomOutGestureDetectorAbstract.m54090f() < 200) {
                    GlMapGestureDetector.m54874v(GlMapGestureDetector.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4346a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{zoomOutGestureDetectorAbstract.m54087i().getX(), zoomOutGestureDetectorAbstract.m54087i().getY()};
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4346a);
                    GlMapGestureDetector.this.f4307a.setGestureStatus(engineIDWithGestureInfo, 4);
                    GlMapGestureDetector.this.f4307a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        /* synthetic */ C1827e(GlMapGestureDetector glMapGestureDetector, byte b) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class GestureDetector$OnDoubleTapListenerC1823a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a */
        private int f4327a;

        /* renamed from: b */
        float f4328b;

        /* renamed from: c */
        private EAMapPlatformGestureInfo f4329c;

        /* renamed from: d */
        long f4330d;

        private GestureDetector$OnDoubleTapListenerC1823a() {
            this.f4327a = 0;
            this.f4328b = 0.0f;
            this.f4329c = new EAMapPlatformGestureInfo();
            this.f4330d = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            GlMapGestureDetector.this.f4309c.setIsLongpressEnabled(false);
            this.f4327a = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = GlMapGestureDetector.this.f4325s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f4327a < motionEvent.getPointerCount()) {
                this.f4327a = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f4327a == 1) {
                try {
                    if (!GlMapGestureDetector.this.f4307a.getUiSettings().isZoomGesturesEnabled()) {
                        GlMapGestureDetector.this.f4309c.setIsLongpressEnabled(true);
                        return false;
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                if (action == 0) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4329c;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 9;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c);
                    this.f4328b = motionEvent.getY();
                    GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.f4330d = SystemClock.uptimeMillis();
                    return true;
                } else if (action == 2) {
                    GlMapGestureDetector.this.f4320n = true;
                    float y = this.f4328b - motionEvent.getY();
                    if (Math.abs(y) >= 20.0f) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f4329c;
                        eAMapPlatformGestureInfo2.mGestureState = 2;
                        eAMapPlatformGestureInfo2.mGestureType = 9;
                        eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                        GlMapGestureDetector.this.f4307a.addGestureMapMessage(GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c), ScaleGestureMapMessage.obtain(101, (y * 4.0f) / GlMapGestureDetector.this.f4307a.getMapHeight(), 0, 0));
                        this.f4328b = motionEvent.getY();
                        return true;
                    }
                    return true;
                } else {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f4329c;
                    eAMapPlatformGestureInfo3.mGestureState = 3;
                    eAMapPlatformGestureInfo3.mGestureType = 9;
                    eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo2 = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c);
                    GlMapGestureDetector.this.f4309c.setIsLongpressEnabled(true);
                    GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action == 1) {
                        GlMapGestureDetector.this.f4307a.setGestureStatus(engineIDWithGestureInfo2, 3);
                        long uptimeMillis = SystemClock.uptimeMillis() - this.f4330d;
                        if (GlMapGestureDetector.this.f4320n && uptimeMillis >= 200) {
                            GlMapGestureDetector.this.f4320n = false;
                            return true;
                        }
                        return GlMapGestureDetector.this.f4307a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                    GlMapGestureDetector.this.f4320n = false;
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            GlMapGestureDetector.this.f4320n = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = GlMapGestureDetector.this.f4325s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isScrollGesturesEnabled() && GlMapGestureDetector.this.f4318l <= 0 && GlMapGestureDetector.this.f4316j <= 0 && GlMapGestureDetector.this.f4317k == 0 && !GlMapGestureDetector.this.f4322p) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4329c;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c);
                    GlMapGestureDetector.this.f4307a.onFling();
                    GlMapGestureDetector.this.f4307a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (GlMapGestureDetector.this.f4319m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4329c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                GlMapGestureDetector.this.f4307a.onLongPress(GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c), motionEvent);
                AMapGestureListener aMapGestureListener = GlMapGestureDetector.this.f4325s;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = GlMapGestureDetector.this.f4325s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onScroll(f, f2);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4329c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                GlMapGestureDetector.this.f4307a.getGLMapEngine().clearAnimations(GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (GlMapGestureDetector.this.f4319m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4329c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 8;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4329c);
                AMapGestureListener aMapGestureListener = GlMapGestureDetector.this.f4325s;
                if (aMapGestureListener != null) {
                    try {
                        aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return GlMapGestureDetector.this.f4307a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        /* synthetic */ GestureDetector$OnDoubleTapListenerC1823a(GlMapGestureDetector glMapGestureDetector, byte b) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1826d extends ScaleRotateGestureDetector.AbstractC1966a {

        /* renamed from: a */
        private boolean f4336a;

        /* renamed from: b */
        private boolean f4337b;

        /* renamed from: c */
        private boolean f4338c;

        /* renamed from: d */
        private Point f4339d;

        /* renamed from: e */
        private float[] f4340e;

        /* renamed from: f */
        private float f4341f;

        /* renamed from: g */
        private float[] f4342g;

        /* renamed from: h */
        private float f4343h;

        /* renamed from: i */
        private EAMapPlatformGestureInfo f4344i;

        private C1826d() {
            this.f4336a = false;
            this.f4337b = false;
            this.f4338c = false;
            this.f4339d = new Point();
            this.f4340e = new float[10];
            this.f4341f = 0.0f;
            this.f4342g = new float[10];
            this.f4343h = 0.0f;
            this.f4344i = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00f3 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fc A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0124 A[Catch: all -> 0x019c, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x016b A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        @Override // com.amap.api.col.p0463l.ScaleRotateGestureDetector.AbstractC1966a
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean mo53675d(com.amap.api.col.p0463l.ScaleRotateGestureDetector r18) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.GlMapGestureDetector.C1826d.mo53675d(com.amap.api.col.3l.v):boolean");
        }

        @Override // com.amap.api.col.p0463l.ScaleRotateGestureDetector.AbstractC1966a
        /* renamed from: e */
        public final boolean mo53674e(ScaleRotateGestureDetector scaleRotateGestureDetector) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4344i;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{scaleRotateGestureDetector.m53828c().getX(), scaleRotateGestureDetector.m53828c().getY()};
            int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4344i);
            int m53825f = (int) scaleRotateGestureDetector.m53825f();
            int m53822i = (int) scaleRotateGestureDetector.m53822i();
            this.f4338c = false;
            Point point = this.f4339d;
            point.x = m53825f;
            point.y = m53822i;
            this.f4336a = false;
            this.f4337b = false;
            GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, m53825f, m53822i));
            try {
                if (GlMapGestureDetector.this.f4307a.getUiSettings().isRotateGesturesEnabled() && !GlMapGestureDetector.this.f4307a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = GlMapGestureDetector.this.f4307a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), m53825f, m53822i));
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.p0463l.ScaleRotateGestureDetector.AbstractC1966a
        /* renamed from: f */
        public final void mo53673f(ScaleRotateGestureDetector scaleRotateGestureDetector) {
            float f;
            float f2;
            float f3;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4344i;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{scaleRotateGestureDetector.m53828c().getX(), scaleRotateGestureDetector.m53828c().getY()};
            int engineIDWithGestureInfo = GlMapGestureDetector.this.f4307a.getEngineIDWithGestureInfo(this.f4344i);
            this.f4338c = false;
            GlMapGestureDetector.this.f4307a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (GlMapGestureDetector.this.f4316j > 0) {
                int i = GlMapGestureDetector.this.f4316j > 10 ? 10 : GlMapGestureDetector.this.f4316j;
                float f4 = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    float[] fArr = this.f4340e;
                    f4 += fArr[i2];
                    fArr[i2] = 0.0f;
                }
                float f5 = f4 / i;
                if (0.004f <= f5) {
                    float f6 = f5 * 300.0f;
                    if (f6 >= 1.5f) {
                        f6 = 1.5f;
                    }
                    if (this.f4341f < 0.0f) {
                        f6 = -f6;
                    }
                    f3 = GlMapGestureDetector.this.f4307a.getPreciseLevel(engineIDWithGestureInfo) + f6;
                } else {
                    f3 = -9999.0f;
                }
                this.f4341f = 0.0f;
                f = f3;
            } else {
                f = -9999.0f;
            }
            if (GlMapGestureDetector.this.f4307a.isLockMapAngle(engineIDWithGestureInfo)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (GlMapGestureDetector.this.f4307a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = GlMapGestureDetector.this.f4307a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (GlMapGestureDetector.this.f4317k > 0) {
                    GlMapGestureDetector.this.f4307a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i3 = GlMapGestureDetector.this.f4317k > 10 ? 10 : GlMapGestureDetector.this.f4317k;
                    float f7 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        float[] fArr2 = this.f4342g;
                        f7 += fArr2[i4];
                        fArr2[i4] = 0.0f;
                    }
                    float f8 = f7 / i3;
                    if (0.1f <= f8) {
                        float f9 = f8 * 200.0f;
                        int mapAngle = ((int) GlMapGestureDetector.this.f4307a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f9 >= 60.0f) {
                            f9 = 60.0f;
                        }
                        if (this.f4343h < 0.0f) {
                            f9 = -f9;
                        }
                        f2 = ((int) (mapAngle + f9)) % 360;
                        this.f4341f = 0.0f;
                    }
                }
                f2 = -9999.0f;
                this.f4341f = 0.0f;
            }
            if ((f == -9999.0f && f2 == -9999.0f) ? true : true) {
                GlMapGestureDetector.this.f4307a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f4339d, f, (int) f2, 500);
            }
        }

        /* synthetic */ C1826d(GlMapGestureDetector glMapGestureDetector, byte b) {
            this();
        }
    }
}
