package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.col.p0463l.IndoorFloorSwitchView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.p048ae.gmap.GLMapState;
import com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener;

/* renamed from: com.amap.api.col.3l.eh */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class MapOverlayViewGroup extends ViewGroup implements MapOverlayViewGroupBase {

    /* renamed from: a */
    private IAMapDelegate f3994a;

    /* renamed from: b */
    private IGlOverlayLayer f3995b;

    /* renamed from: c */
    private Context f3996c;

    /* renamed from: d */
    private WaterMarkerView f3997d;

    /* renamed from: e */
    private LocationView f3998e;

    /* renamed from: f */
    private CompassView f3999f;

    /* renamed from: g */
    private ScaleView f4000g;

    /* renamed from: h */
    private BlankView f4001h;

    /* renamed from: i */
    private IndoorFloorSwitchView f4002i;

    /* renamed from: j */
    private ZoomControllerView f4003j;

    /* renamed from: k */
    private View f4004k;

    /* renamed from: l */
    private BasePointOverlay f4005l;

    /* renamed from: m */
    private Drawable f4006m;

    /* renamed from: n */
    private boolean f4007n;

    /* renamed from: o */
    private View f4008o;

    /* renamed from: p */
    private boolean f4009p;

    /* renamed from: q */
    MethodCallHelper f4010q;

    /* renamed from: r */
    private boolean f4011r;

    /* renamed from: s */
    private boolean f4012s;

    /* renamed from: t */
    InfoWindowDelegate f4013t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1791a implements AMapWidgetListener {

        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1792a implements Runnable {
            RunnableC1792a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MapOverlayViewGroup.this.f4000g.m55132e();
            }
        }

        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1793b implements Runnable {
            RunnableC1793b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MapOverlayViewGroup.this.f3999f.m55187c();
            }
        }

        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$c */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        final class RunnableC1794c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ float f4017a;

            RunnableC1794c(float f) {
                this.f4017a = f;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MapOverlayViewGroup.this.f4003j.m54682c(this.f4017a);
            }
        }

        C1791a() {
        }

        @Override // com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener
        public final void invalidateCompassView() {
            if (MapOverlayViewGroup.this.f3999f == null) {
                return;
            }
            MapOverlayViewGroup.this.f3999f.post(new RunnableC1793b());
        }

        @Override // com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener
        public final void invalidateScaleView() {
            if (MapOverlayViewGroup.this.f4000g == null) {
                return;
            }
            MapOverlayViewGroup.this.f4000g.post(new RunnableC1792a());
        }

        @Override // com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener
        public final void invalidateZoomController(float f) {
            if (MapOverlayViewGroup.this.f4003j == null) {
                return;
            }
            MapOverlayViewGroup.this.f4003j.post(new RunnableC1794c(f));
        }

        @Override // com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener
        public final void setFrontViewVisibility(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class RunnableC1795b implements Runnable {
        RunnableC1795b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MapOverlayViewGroup.this.f4004k != null) {
                MapOverlayViewGroup.this.f4004k.clearFocus();
                MapOverlayViewGroup mapOverlayViewGroup = MapOverlayViewGroup.this;
                mapOverlayViewGroup.removeView(mapOverlayViewGroup.f4004k);
                C1732a3.m55742C(MapOverlayViewGroup.this.f4004k.getBackground());
                C1732a3.m55742C(MapOverlayViewGroup.this.f4006m);
                MapOverlayViewGroup.m55146F(MapOverlayViewGroup.this);
            }
        }
    }

    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1796c extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public FPoint f4020a;

        /* renamed from: b */
        public boolean f4021b;

        /* renamed from: c */
        public int f4022c;

        /* renamed from: d */
        public int f4023d;

        /* renamed from: e */
        public int f4024e;

        public C1796c(FPoint fPoint, int i) {
            this(-2, -2, ((PointF) fPoint).x, ((PointF) fPoint).y, 0, 0, i);
        }

        public C1796c(int i, int i2, float f, float f2, int i3, int i4, int i5) {
            super(i, i2);
            FPoint fPoint = new FPoint();
            this.f4020a = fPoint;
            this.f4021b = false;
            ((PointF) fPoint).x = f;
            ((PointF) fPoint).y = f2;
            this.f4022c = i3;
            this.f4023d = i4;
            this.f4024e = i5;
        }
    }

    public MapOverlayViewGroup(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.f4006m = null;
        int i = 1;
        this.f4007n = true;
        this.f4011r = true;
        this.f4012s = true;
        try {
            this.f3995b = iGlOverlayLayer;
            this.f3994a = iAMapDelegate;
            this.f3996c = context;
            this.f4010q = new MethodCallHelper();
            this.f4001h = new BlankView(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f3994a.getGLMapView() != null) {
                addView(this.f3994a.getGLMapView(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.f4001h, i, layoutParams);
            if (this.f4011r) {
                return;
            }
            m55141v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: A */
    private void m55151A(View view, C1796c c1796c) {
        int[] iArr = new int[2];
        m55138y(view, ((ViewGroup.LayoutParams) c1796c).width, ((ViewGroup.LayoutParams) c1796c).height, iArr);
        if (view instanceof ZoomControllerView) {
            m55139x(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), c1796c.f4024e);
        } else if (view instanceof LocationView) {
            m55139x(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c1796c.f4024e);
        } else if (view instanceof CompassView) {
            m55139x(view, iArr[0], iArr[1], 0, 0, c1796c.f4024e);
        } else if (c1796c.f4020a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f3994a.getMapConfig();
            GLMapState mapProjection = this.f3994a.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = c1796c.f4020a;
                ((Point) obtain).x = (int) ((PointF) fPoint).x;
                ((Point) obtain).y = (int) ((PointF) fPoint).y;
            }
            int i = ((Point) obtain).x + c1796c.f4022c;
            ((Point) obtain).x = i;
            int i2 = ((Point) obtain).y + c1796c.f4023d;
            ((Point) obtain).y = i2;
            m55139x(view, iArr[0], iArr[1], i, i2, c1796c.f4024e);
            obtain.recycle();
        }
    }

    /* renamed from: F */
    static /* synthetic */ View m55146F(MapOverlayViewGroup mapOverlayViewGroup) {
        mapOverlayViewGroup.f4004k = null;
        return null;
    }

    /* renamed from: G */
    private void m55145G() {
        ScaleView scaleView = this.f4000g;
        if (scaleView == null) {
            this.f4010q.m54729b(this, new Object[0]);
        } else if (scaleView == null || scaleView.getVisibility() != 0) {
        } else {
            this.f4000g.postInvalidate();
        }
    }

    /* renamed from: H */
    private void m55144H() {
        ZoomControllerView zoomControllerView = this.f4003j;
        if (zoomControllerView != null) {
            zoomControllerView.m54683b();
        }
        ScaleView scaleView = this.f4000g;
        if (scaleView != null) {
            scaleView.m55136a();
        }
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView != null) {
            waterMarkerView.m55130b();
        }
        LocationView locationView = this.f3998e;
        if (locationView != null) {
            locationView.m55153a();
        }
        CompassView compassView = this.f3999f;
        if (compassView != null) {
            compassView.m55189a();
        }
        IndoorFloorSwitchView indoorFloorSwitchView = this.f4002i;
        if (indoorFloorSwitchView != null) {
            indoorFloorSwitchView.m55178e();
        }
    }

    /* renamed from: t */
    private View m55143t(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f4006m == null) {
                    this.f4006m = NinePatchTool.m54218c(this.f3996c, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.f4009p) {
                    view = this.f4013t.m53375d(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.f4013t.m53363p(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            view3 = view;
                            SDKLogHandler.m53863p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f4008o = view;
                    this.f4009p = false;
                } else {
                    view = this.f4008o;
                }
                if (view != null) {
                    view3 = view;
                } else if (!this.f4013t.m53365n()) {
                    return null;
                } else {
                    view3 = this.f4013t.m53375d(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.f4006m);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.f4006m == null) {
                    this.f4006m = NinePatchTool.m54218c(this.f3996c, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                SDKLogHandler.m53863p(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.f4009p) {
                    view2 = this.f4013t.m53375d(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.f4013t.m53363p(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            view3 = view2;
                            SDKLogHandler.m53863p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f4008o = view2;
                    this.f4009p = false;
                } else {
                    view2 = this.f4008o;
                }
                if (view2 != null) {
                    view3 = view2;
                } else if (!this.f4013t.m53365n()) {
                    return null;
                } else {
                    view3 = this.f4013t.m53375d(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.f4006m);
                }
                return view3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view3;
    }

    /* renamed from: v */
    private void m55141v(Context context) {
        WaterMarkerView waterMarkerView = new WaterMarkerView(context);
        this.f3997d = waterMarkerView;
        waterMarkerView.m55118n(this.f4012s);
        this.f4000g = new ScaleView(context, this.f3994a);
        this.f4002i = new IndoorFloorSwitchView(context);
        this.f4003j = new ZoomControllerView(context, this.f3994a);
        this.f3998e = new LocationView(context, this.f3994a);
        this.f3999f = new CompassView(context, this.f3994a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f3997d, layoutParams);
        addView(this.f4000g, layoutParams);
        addView(this.f4002i, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f4003j, new C1796c(new FPoint(0.0f, 0.0f), 83));
        addView(this.f3998e, new C1796c(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f3999f, new C1796c(FPoint.obtain(0.0f, 0.0f), 51));
        this.f3999f.setVisibility(8);
        this.f3994a.setMapWidgetListener(new C1791a());
        try {
            if (this.f3994a.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f3998e.setVisibility(8);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    /* renamed from: w */
    private void m55140w(View view, int i, int i2, int i3, int i4) throws RemoteException {
        int i5;
        int i6;
        if (view == null) {
            return;
        }
        View view2 = this.f4004k;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f4004k);
        }
        this.f4004k = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f4004k.setDrawingCacheEnabled(true);
        this.f4004k.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i7 = layoutParams.width;
            i6 = layoutParams.height;
            i5 = i7;
        } else {
            i5 = -2;
            i6 = -2;
        }
        addView(this.f4004k, new C1796c(i5, i6, i, i2, i3, i4, 81));
    }

    /* renamed from: x */
    private void m55139x(View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i5 & 7;
        int i8 = i5 & 112;
        if (i7 == 5) {
            i3 -= i;
        } else if (i7 == 1) {
            i3 -= i / 2;
        }
        if (i8 == 80) {
            i4 -= i2;
        } else {
            if (i8 == 17) {
                i6 = i2 / 2;
            } else if (i8 == 16) {
                i4 /= 2;
                i6 = i2 / 2;
            }
            i4 -= i6;
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
        if (view instanceof IGLSurfaceView) {
            this.f3994a.changeSize(i, i2);
        }
    }

    /* renamed from: y */
    private void m55138y(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    /* renamed from: z */
    private void m55137z(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        m55138y(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof IndoorFloorSwitchView) {
            m55139x(view, iArr[0], iArr[1], 20, (this.f3994a.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            m55139x(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: a */
    public final void mo54850a(Integer num) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, num);
        } else if (waterMarkerView != null) {
            waterMarkerView.m55123i(num.intValue());
            m55145G();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: b */
    public final void mo54847b(Boolean bool) {
        CompassView compassView = this.f3999f;
        if (compassView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            compassView.m55188b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: c */
    public final void mo54845c(Integer num) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, num);
        } else if (waterMarkerView != null) {
            waterMarkerView.m55119m(num.intValue());
            m55145G();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: d */
    public final void mo54843d(Boolean bool) {
        if (this.f3998e == null) {
            this.f4010q.m54729b(this, bool);
        } else if (bool.booleanValue()) {
            this.f3998e.setVisibility(0);
        } else {
            this.f3998e.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: e */
    public final void mo54841e(Integer num) {
        ZoomControllerView zoomControllerView = this.f4003j;
        if (zoomControllerView == null) {
            this.f4010q.m54729b(this, num);
        } else if (zoomControllerView != null) {
            zoomControllerView.m54681d(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: f */
    public final void mo54839f(Boolean bool) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            waterMarkerView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: g */
    public final void mo54838g() {
        hideInfoWindow();
        C1732a3.m55742C(this.f4006m);
        m55144H();
        removeAllViews();
        this.f4008o = null;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: h */
    public final void mo54835h(Integer num) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, num);
        } else if (waterMarkerView != null) {
            waterMarkerView.m55129c(num.intValue());
            this.f3997d.postInvalidate();
            m55145G();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f3994a;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f3994a.getMainHandler().post(new RunnableC1795b());
            BasePointOverlay basePointOverlay = this.f4005l;
            if (basePointOverlay != null) {
                this.f3995b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f4005l = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: i */
    public final void mo54833i(Boolean bool) {
        ScaleView scaleView = this.f4000g;
        if (scaleView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            scaleView.m55133d(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: j */
    public final View mo54832j() {
        return this;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: j */
    public final void mo54831j(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f4004k;
        if (view == null || this.f4005l == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f4004k.getLeft(), this.f4004k.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: k */
    public final void mo54830k(Boolean bool) {
        IndoorFloorSwitchView indoorFloorSwitchView = this.f4002i;
        if (indoorFloorSwitchView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            indoorFloorSwitchView.m55173j(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: l */
    public final void mo54829l(Boolean bool) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, bool);
        } else if (waterMarkerView != null && bool.booleanValue()) {
            this.f3997d.m55126f(true);
        } else {
            WaterMarkerView waterMarkerView2 = this.f3997d;
            if (waterMarkerView2 != null) {
                waterMarkerView2.m55126f(false);
            }
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: m */
    public final void mo54828m(Boolean bool) {
        LocationView locationView = this.f3998e;
        if (locationView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            locationView.m55152b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: n */
    public final void mo54827n(String str, Boolean bool, Integer num) {
        if (this.f3997d == null) {
            this.f4010q.m54729b(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.f3997d.m55122j(bool.booleanValue());
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.f3997d.m55127e(str, num.intValue());
            this.f3997d.m55116p(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: o */
    public final void mo54826o(Float f) {
        ZoomControllerView zoomControllerView = this.f4003j;
        if (zoomControllerView == null) {
            this.f4010q.m54729b(this, f);
        } else if (zoomControllerView != null) {
            zoomControllerView.m54682c(f.floatValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f4004k == null || this.f4005l == null || !C1732a3.m55735J(new Rect(this.f4004k.getLeft(), this.f4004k.getTop(), this.f4004k.getRight(), this.f4004k.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof C1796c) {
                        m55151A(childAt, (C1796c) childAt.getLayoutParams());
                    } else {
                        m55137z(childAt, childAt.getLayoutParams());
                    }
                }
            }
            WaterMarkerView waterMarkerView = this.f3997d;
            if (waterMarkerView != null) {
                waterMarkerView.m55120l();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: p */
    public final void mo54825p(CameraPosition cameraPosition) {
        if (this.f3997d == null) {
            this.f4010q.m54729b(this, cameraPosition);
        } else if (this.f3994a.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!RegionUtil.m53892a(latLng.latitude, latLng.longitude)) {
                    this.f3997d.setVisibility(8);
                    return;
                }
            }
            if (this.f3994a.getMaskLayerType() == -1) {
                this.f3997d.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: q */
    public final void mo54824q(Integer num, Float f) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, num, f);
        } else if (waterMarkerView != null) {
            waterMarkerView.m55128d(num.intValue(), f.floatValue());
            m55145G();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: r */
    public final void mo54823r(Boolean bool) {
        ZoomControllerView zoomControllerView = this.f4003j;
        if (zoomControllerView == null) {
            this.f4010q.m54729b(this, bool);
        } else {
            zoomControllerView.m54680e(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f4005l;
            if (basePointOverlay != null && this.f3995b.checkInBounds(basePointOverlay.getId())) {
                if (this.f4007n) {
                    FPoint obtain = FPoint.obtain();
                    this.f3995b.getMarkerInfoWindowOffset(this.f4005l.getId(), obtain);
                    int i = (int) ((PointF) obtain).x;
                    int i2 = (int) (((PointF) obtain).y + 2.0f);
                    obtain.recycle();
                    View m55143t = m55143t(this.f4005l);
                    if (m55143t == null) {
                        View view = this.f4004k;
                        if (view == null || view.getVisibility() != 0) {
                            return;
                        }
                        hideInfoWindow();
                        return;
                    }
                    FPoint obtain2 = FPoint.obtain();
                    this.f3995b.getOverlayScreenPos(this.f4005l.getId(), obtain2);
                    m55140w(m55143t, (int) ((PointF) obtain2).x, (int) ((PointF) obtain2).y, i, i2);
                    View view2 = this.f4004k;
                    if (view2 != null) {
                        C1796c c1796c = (C1796c) view2.getLayoutParams();
                        if (c1796c != null) {
                            c1796c.f4020a = FPoint.obtain(((PointF) obtain2).x, ((PointF) obtain2).y);
                            c1796c.f4022c = i;
                            c1796c.f4023d = i2;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.f4013t.m53365n()) {
                            this.f4013t.m53366m(this.f4005l.getTitle(), this.f4005l.getSnippet());
                        }
                        if (this.f4004k.getVisibility() == 8) {
                            this.f4004k.setVisibility(0);
                        }
                    }
                    obtain2.recycle();
                    return;
                }
                return;
            }
            View view3 = this.f4004k;
            if (view3 == null || view3.getVisibility() != 0) {
                return;
            }
            this.f4004k.setVisibility(8);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "MapOverlayViewGroup", "redrawInfoWindow");
            C1732a3.m55741D(th);
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: s */
    public final void mo54822s(Boolean bool) {
        IndoorFloorSwitchView indoorFloorSwitchView = this.f4002i;
        if (indoorFloorSwitchView == null) {
            this.f4010q.m54729b(this, bool);
        } else if (indoorFloorSwitchView != null && bool.booleanValue() && this.f3994a.canShowIndoorSwitch()) {
            this.f4002i.m55173j(true);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(InfoWindowDelegate infoWindowDelegate) {
        this.f4013t = infoWindowDelegate;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            InfoWindowDelegate infoWindowDelegate = this.f4013t;
            if (!(infoWindowDelegate != null && infoWindowDelegate.m53365n() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f4005l;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f4013t != null) {
                    this.f4005l = basePointOverlay;
                    this.f4009p = true;
                    this.f3995b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: b */
    public final boolean mo54848b() {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView != null) {
            return waterMarkerView.m55115q();
        }
        return false;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: e */
    public final IndoorFloorSwitchView mo54842e() {
        return this.f4002i;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: f */
    public final WaterMarkerView mo54840f() {
        return this.f3997d;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: i */
    public final void mo54834i() {
        Context context;
        if (!this.f4011r || (context = this.f3996c) == null) {
            return;
        }
        m55141v(context);
        MethodCallHelper methodCallHelper = this.f4010q;
        if (methodCallHelper != null) {
            methodCallHelper.m54730a();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: a */
    public final float mo54851a(int i) {
        if (this.f3997d != null) {
            m55145G();
            return this.f3997d.m55117o(i);
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: c */
    public final void mo54846c() {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            this.f4010q.m54729b(this, new Object[0]);
        } else if (waterMarkerView != null) {
            waterMarkerView.m55120l();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: d */
    public final BlankView mo54844d() {
        return this.f4001h;
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: g */
    public final void mo54837g(IndoorFloorSwitchView.InterfaceC1789d interfaceC1789d) {
        IndoorFloorSwitchView indoorFloorSwitchView = this.f4002i;
        if (indoorFloorSwitchView == null) {
            this.f4010q.m54729b(this, interfaceC1789d);
        } else {
            indoorFloorSwitchView.m55175h(interfaceC1789d);
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: h */
    public final void mo54836h() {
        CompassView compassView = this.f3999f;
        if (compassView == null) {
            this.f4010q.m54729b(this, new Object[0]);
        } else {
            compassView.m55187c();
        }
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: a */
    public final Point mo54852a() {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView == null) {
            return null;
        }
        return waterMarkerView.m55124h();
    }

    @Override // com.amap.api.col.p0463l.MapOverlayViewGroupBase
    /* renamed from: a */
    public final void mo54849a(boolean z) {
        WaterMarkerView waterMarkerView = this.f3997d;
        if (waterMarkerView != null) {
            waterMarkerView.m55118n(z);
        }
        this.f4012s = z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            InfoWindowDelegate infoWindowDelegate = this.f4013t;
            if (!(infoWindowDelegate != null && infoWindowDelegate.m53365n() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f4005l;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f4013t != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f4009p = true;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
