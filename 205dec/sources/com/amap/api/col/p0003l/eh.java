package com.amap.api.col.p0003l;

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
import com.amap.api.col.p0003l.ef;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MapOverlayViewGroup.java */
/* renamed from: com.amap.api.col.3l.eh  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class eh extends ViewGroup implements h3 {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f7572a;

    /* renamed from: b  reason: collision with root package name */
    private IGlOverlayLayer f7573b;

    /* renamed from: c  reason: collision with root package name */
    private Context f7574c;

    /* renamed from: d  reason: collision with root package name */
    private el f7575d;

    /* renamed from: e  reason: collision with root package name */
    private eg f7576e;

    /* renamed from: f  reason: collision with root package name */
    private ee f7577f;

    /* renamed from: g  reason: collision with root package name */
    private ek f7578g;

    /* renamed from: h  reason: collision with root package name */
    private ed f7579h;

    /* renamed from: i  reason: collision with root package name */
    private ef f7580i;

    /* renamed from: j  reason: collision with root package name */
    private j3 f7581j;

    /* renamed from: k  reason: collision with root package name */
    private View f7582k;

    /* renamed from: l  reason: collision with root package name */
    private BasePointOverlay f7583l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f7584m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f7585n;

    /* renamed from: o  reason: collision with root package name */
    private View f7586o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7587p;

    /* renamed from: q  reason: collision with root package name */
    i3 f7588q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7589r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7590s;

    /* renamed from: t  reason: collision with root package name */
    z f7591t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements AMapWidgetListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class RunnableC0103a implements Runnable {
            RunnableC0103a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f7578g.e();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f7577f.c();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: MapOverlayViewGroup.java */
        /* renamed from: com.amap.api.col.3l.eh$a$c */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ float f7595a;

            c(float f4) {
                this.f7595a = f4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f7581j.c(this.f7595a);
            }
        }

        a() {
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateCompassView() {
            if (eh.this.f7577f == null) {
                return;
            }
            eh.this.f7577f.post(new b());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateScaleView() {
            if (eh.this.f7578g == null) {
                return;
            }
            eh.this.f7578g.post(new RunnableC0103a());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateZoomController(float f4) {
            if (eh.this.f7581j == null) {
                return;
            }
            eh.this.f7581j.post(new c(f4));
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void setFrontViewVisibility(boolean z3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (eh.this.f7582k != null) {
                eh.this.f7582k.clearFocus();
                eh ehVar = eh.this;
                ehVar.removeView(ehVar.f7582k);
                a3.C(eh.this.f7582k.getBackground());
                a3.C(eh.this.f7584m);
                eh.F(eh.this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: MapOverlayViewGroup.java */
    /* renamed from: com.amap.api.col.3l.eh$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public FPoint f7598a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7599b;

        /* renamed from: c  reason: collision with root package name */
        public int f7600c;

        /* renamed from: d  reason: collision with root package name */
        public int f7601d;

        /* renamed from: e  reason: collision with root package name */
        public int f7602e;

        public c(FPoint fPoint, int i4) {
            this(-2, -2, ((PointF) fPoint).x, ((PointF) fPoint).y, 0, 0, i4);
        }

        public c(int i4, int i5, float f4, float f5, int i6, int i7, int i8) {
            super(i4, i5);
            FPoint fPoint = new FPoint();
            this.f7598a = fPoint;
            this.f7599b = false;
            ((PointF) fPoint).x = f4;
            ((PointF) fPoint).y = f5;
            this.f7600c = i6;
            this.f7601d = i7;
            this.f7602e = i8;
        }
    }

    public eh(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.f7584m = null;
        int i4 = 1;
        this.f7585n = true;
        this.f7589r = true;
        this.f7590s = true;
        try {
            this.f7573b = iGlOverlayLayer;
            this.f7572a = iAMapDelegate;
            this.f7574c = context;
            this.f7588q = new i3();
            this.f7579h = new ed(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f7572a.getGLMapView() != null) {
                addView(this.f7572a.getGLMapView(), 0, layoutParams);
            } else {
                i4 = 0;
            }
            addView(this.f7579h, i4, layoutParams);
            if (this.f7589r) {
                return;
            }
            v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    private void A(View view, c cVar) {
        int[] iArr = new int[2];
        y(view, ((ViewGroup.LayoutParams) cVar).width, ((ViewGroup.LayoutParams) cVar).height, iArr);
        if (view instanceof j3) {
            x(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), cVar.f7602e);
        } else if (view instanceof eg) {
            x(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], cVar.f7602e);
        } else if (view instanceof ee) {
            x(view, iArr[0], iArr[1], 0, 0, cVar.f7602e);
        } else if (cVar.f7598a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f7572a.getMapConfig();
            GLMapState mapProjection = this.f7572a.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = cVar.f7598a;
                ((Point) obtain).x = (int) ((PointF) fPoint).x;
                ((Point) obtain).y = (int) ((PointF) fPoint).y;
            }
            int i4 = ((Point) obtain).x + cVar.f7600c;
            ((Point) obtain).x = i4;
            int i5 = ((Point) obtain).y + cVar.f7601d;
            ((Point) obtain).y = i5;
            x(view, iArr[0], iArr[1], i4, i5, cVar.f7602e);
            obtain.recycle();
        }
    }

    static /* synthetic */ View F(eh ehVar) {
        ehVar.f7582k = null;
        return null;
    }

    private void G() {
        ek ekVar = this.f7578g;
        if (ekVar == null) {
            this.f7588q.b(this, new Object[0]);
        } else if (ekVar == null || ekVar.getVisibility() != 0) {
        } else {
            this.f7578g.postInvalidate();
        }
    }

    private void H() {
        j3 j3Var = this.f7581j;
        if (j3Var != null) {
            j3Var.b();
        }
        ek ekVar = this.f7578g;
        if (ekVar != null) {
            ekVar.a();
        }
        el elVar = this.f7575d;
        if (elVar != null) {
            elVar.b();
        }
        eg egVar = this.f7576e;
        if (egVar != null) {
            egVar.a();
        }
        ee eeVar = this.f7577f;
        if (eeVar != null) {
            eeVar.a();
        }
        ef efVar = this.f7580i;
        if (efVar != null) {
            efVar.e();
        }
    }

    private View t(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f7584m == null) {
                    this.f7584m = p2.c(this.f7574c, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                u5.p(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.f7587p) {
                    view = this.f7591t.d(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.f7591t.p(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            view3 = view;
                            u5.p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f7586o = view;
                    this.f7587p = false;
                } else {
                    view = this.f7586o;
                }
                if (view != null) {
                    view3 = view;
                } else if (!this.f7591t.n()) {
                    return null;
                } else {
                    view3 = this.f7591t.d(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.f7584m);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.f7584m == null) {
                    this.f7584m = p2.c(this.f7574c, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                u5.p(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.f7587p) {
                    view2 = this.f7591t.d(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.f7591t.p(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            view3 = view2;
                            u5.p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f7586o = view2;
                    this.f7587p = false;
                } else {
                    view2 = this.f7586o;
                }
                if (view2 != null) {
                    view3 = view2;
                } else if (!this.f7591t.n()) {
                    return null;
                } else {
                    view3 = this.f7591t.d(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.f7584m);
                }
                return view3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view3;
    }

    private void v(Context context) {
        el elVar = new el(context);
        this.f7575d = elVar;
        elVar.n(this.f7590s);
        this.f7578g = new ek(context, this.f7572a);
        this.f7580i = new ef(context);
        this.f7581j = new j3(context, this.f7572a);
        this.f7576e = new eg(context, this.f7572a);
        this.f7577f = new ee(context, this.f7572a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f7575d, layoutParams);
        addView(this.f7578g, layoutParams);
        addView(this.f7580i, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f7581j, new c(new FPoint(0.0f, 0.0f), 83));
        addView(this.f7576e, new c(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f7577f, new c(FPoint.obtain(0.0f, 0.0f), 51));
        this.f7577f.setVisibility(8);
        this.f7572a.setMapWidgetListener(new a());
        try {
            if (this.f7572a.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f7576e.setVisibility(8);
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void w(View view, int i4, int i5, int i6, int i7) throws RemoteException {
        int i8;
        int i9;
        if (view == null) {
            return;
        }
        View view2 = this.f7582k;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f7582k);
        }
        this.f7582k = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f7582k.setDrawingCacheEnabled(true);
        this.f7582k.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i10 = layoutParams.width;
            i9 = layoutParams.height;
            i8 = i10;
        } else {
            i8 = -2;
            i9 = -2;
        }
        addView(this.f7582k, new c(i8, i9, i4, i5, i6, i7, 81));
    }

    private void x(View view, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10 = i8 & 7;
        int i11 = i8 & 112;
        if (i10 == 5) {
            i6 -= i4;
        } else if (i10 == 1) {
            i6 -= i4 / 2;
        }
        if (i11 == 80) {
            i7 -= i5;
        } else {
            if (i11 == 17) {
                i9 = i5 / 2;
            } else if (i11 == 16) {
                i7 /= 2;
                i9 = i5 / 2;
            }
            i7 -= i9;
        }
        view.layout(i6, i7, i6 + i4, i7 + i5);
        if (view instanceof IGLSurfaceView) {
            this.f7572a.changeSize(i4, i5);
        }
    }

    private void y(View view, int i4, int i5, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i4 <= 0 || i5 <= 0) {
            view.measure(0, 0);
        }
        if (i4 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i4 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i4;
        }
        if (i5 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i5 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i5;
        }
    }

    private void z(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        y(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ef) {
            x(view, iArr[0], iArr[1], 20, (this.f7572a.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            x(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void a(Integer num) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, num);
        } else if (elVar != null) {
            elVar.i(num.intValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void b(Boolean bool) {
        ee eeVar = this.f7577f;
        if (eeVar == null) {
            this.f7588q.b(this, bool);
        } else {
            eeVar.b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void c(Integer num) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, num);
        } else if (elVar != null) {
            elVar.m(num.intValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void d(Boolean bool) {
        if (this.f7576e == null) {
            this.f7588q.b(this, bool);
        } else if (bool.booleanValue()) {
            this.f7576e.setVisibility(0);
        } else {
            this.f7576e.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void e(Integer num) {
        j3 j3Var = this.f7581j;
        if (j3Var == null) {
            this.f7588q.b(this, num);
        } else if (j3Var != null) {
            j3Var.d(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void f(Boolean bool) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, bool);
        } else {
            elVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void g() {
        hideInfoWindow();
        a3.C(this.f7584m);
        H();
        removeAllViews();
        this.f7586o = null;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void h(Integer num) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, num);
        } else if (elVar != null) {
            elVar.c(num.intValue());
            this.f7575d.postInvalidate();
            G();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f7572a;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f7572a.getMainHandler().post(new b());
            BasePointOverlay basePointOverlay = this.f7583l;
            if (basePointOverlay != null) {
                this.f7573b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f7583l = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void i(Boolean bool) {
        ek ekVar = this.f7578g;
        if (ekVar == null) {
            this.f7588q.b(this, bool);
        } else {
            ekVar.d(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final View j() {
        return this;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void j(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f7582k;
        if (view == null || this.f7583l == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f7582k.getLeft(), this.f7582k.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void k(Boolean bool) {
        ef efVar = this.f7580i;
        if (efVar == null) {
            this.f7588q.b(this, bool);
        } else {
            efVar.j(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void l(Boolean bool) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, bool);
        } else if (elVar != null && bool.booleanValue()) {
            this.f7575d.f(true);
        } else {
            el elVar2 = this.f7575d;
            if (elVar2 != null) {
                elVar2.f(false);
            }
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void m(Boolean bool) {
        eg egVar = this.f7576e;
        if (egVar == null) {
            this.f7588q.b(this, bool);
        } else {
            egVar.b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void n(String str, Boolean bool, Integer num) {
        if (this.f7575d == null) {
            this.f7588q.b(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.f7575d.j(bool.booleanValue());
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.f7575d.e(str, num.intValue());
            this.f7575d.p(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void o(Float f4) {
        j3 j3Var = this.f7581j;
        if (j3Var == null) {
            this.f7588q.b(this, f4);
        } else if (j3Var != null) {
            j3Var.c(f4.floatValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f7582k == null || this.f7583l == null || !a3.J(new Rect(this.f7582k.getLeft(), this.f7582k.getTop(), this.f7582k.getRight(), this.f7582k.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        try {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof c) {
                        A(childAt, (c) childAt.getLayoutParams());
                    } else {
                        z(childAt, childAt.getLayoutParams());
                    }
                }
            }
            el elVar = this.f7575d;
            if (elVar != null) {
                elVar.l();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void p(CameraPosition cameraPosition) {
        if (this.f7575d == null) {
            this.f7588q.b(this, cameraPosition);
        } else if (this.f7572a.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!t2.a(latLng.latitude, latLng.longitude)) {
                    this.f7575d.setVisibility(8);
                    return;
                }
            }
            if (this.f7572a.getMaskLayerType() == -1) {
                this.f7575d.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void q(Integer num, Float f4) {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, num, f4);
        } else if (elVar != null) {
            elVar.d(num.intValue(), f4.floatValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void r(Boolean bool) {
        j3 j3Var = this.f7581j;
        if (j3Var == null) {
            this.f7588q.b(this, bool);
        } else {
            j3Var.e(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f7583l;
            if (basePointOverlay != null && this.f7573b.checkInBounds(basePointOverlay.getId())) {
                if (this.f7585n) {
                    FPoint obtain = FPoint.obtain();
                    this.f7573b.getMarkerInfoWindowOffset(this.f7583l.getId(), obtain);
                    int i4 = (int) ((PointF) obtain).x;
                    int i5 = (int) (((PointF) obtain).y + 2.0f);
                    obtain.recycle();
                    View t3 = t(this.f7583l);
                    if (t3 == null) {
                        View view = this.f7582k;
                        if (view == null || view.getVisibility() != 0) {
                            return;
                        }
                        hideInfoWindow();
                        return;
                    }
                    FPoint obtain2 = FPoint.obtain();
                    this.f7573b.getOverlayScreenPos(this.f7583l.getId(), obtain2);
                    w(t3, (int) ((PointF) obtain2).x, (int) ((PointF) obtain2).y, i4, i5);
                    View view2 = this.f7582k;
                    if (view2 != null) {
                        c cVar = (c) view2.getLayoutParams();
                        if (cVar != null) {
                            cVar.f7598a = FPoint.obtain(((PointF) obtain2).x, ((PointF) obtain2).y);
                            cVar.f7600c = i4;
                            cVar.f7601d = i5;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.f7591t.n()) {
                            this.f7591t.m(this.f7583l.getTitle(), this.f7583l.getSnippet());
                        }
                        if (this.f7582k.getVisibility() == 8) {
                            this.f7582k.setVisibility(0);
                        }
                    }
                    obtain2.recycle();
                    return;
                }
                return;
            }
            View view3 = this.f7582k;
            if (view3 == null || view3.getVisibility() != 0) {
                return;
            }
            this.f7582k.setVisibility(8);
        } catch (Throwable th) {
            u5.p(th, "MapOverlayViewGroup", "redrawInfoWindow");
            a3.D(th);
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void s(Boolean bool) {
        ef efVar = this.f7580i;
        if (efVar == null) {
            this.f7588q.b(this, bool);
        } else if (efVar != null && bool.booleanValue() && this.f7572a.canShowIndoorSwitch()) {
            this.f7580i.j(true);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(z zVar) {
        this.f7591t = zVar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            z zVar = this.f7591t;
            if (!(zVar != null && zVar.n() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f7583l;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f7591t != null) {
                    this.f7583l = basePointOverlay;
                    this.f7587p = true;
                    this.f7573b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final boolean b() {
        el elVar = this.f7575d;
        if (elVar != null) {
            return elVar.q();
        }
        return false;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final ef e() {
        return this.f7580i;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final el f() {
        return this.f7575d;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void i() {
        Context context;
        if (!this.f7589r || (context = this.f7574c) == null) {
            return;
        }
        v(context);
        i3 i3Var = this.f7588q;
        if (i3Var != null) {
            i3Var.a();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final float a(int i4) {
        if (this.f7575d != null) {
            G();
            return this.f7575d.o(i4);
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void c() {
        el elVar = this.f7575d;
        if (elVar == null) {
            this.f7588q.b(this, new Object[0]);
        } else if (elVar != null) {
            elVar.l();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final ed d() {
        return this.f7579h;
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void g(ef.d dVar) {
        ef efVar = this.f7580i;
        if (efVar == null) {
            this.f7588q.b(this, dVar);
        } else {
            efVar.h(dVar);
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void h() {
        ee eeVar = this.f7577f;
        if (eeVar == null) {
            this.f7588q.b(this, new Object[0]);
        } else {
            eeVar.c();
        }
    }

    @Override // com.amap.api.col.p0003l.h3
    public final Point a() {
        el elVar = this.f7575d;
        if (elVar == null) {
            return null;
        }
        return elVar.h();
    }

    @Override // com.amap.api.col.p0003l.h3
    public final void a(boolean z3) {
        el elVar = this.f7575d;
        if (elVar != null) {
            elVar.n(z3);
        }
        this.f7590s = z3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            z zVar = this.f7591t;
            if (!(zVar != null && zVar.n() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f7583l;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f7591t != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f7587p = true;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
