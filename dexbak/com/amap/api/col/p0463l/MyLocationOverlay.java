package com.amap.api.col.p0463l;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.p048ae.gmap.GLMapState;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.p1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MyLocationOverlay {

    /* renamed from: a */
    private IAMapDelegate f5040a;

    /* renamed from: b */
    private Marker f5041b;

    /* renamed from: c */
    private Circle f5042c;

    /* renamed from: e */
    private LatLng f5044e;

    /* renamed from: f */
    private double f5045f;

    /* renamed from: g */
    private Context f5046g;

    /* renamed from: h */
    private SensorEventHelper f5047h;

    /* renamed from: q */
    ValueAnimator f5056q;

    /* renamed from: d */
    private MyLocationStyle f5043d = new MyLocationStyle();

    /* renamed from: i */
    private int f5048i = 4;

    /* renamed from: j */
    private boolean f5049j = false;

    /* renamed from: k */
    private boolean f5050k = false;

    /* renamed from: l */
    private boolean f5051l = false;

    /* renamed from: m */
    private boolean f5052m = false;

    /* renamed from: n */
    private boolean f5053n = false;

    /* renamed from: o */
    private boolean f5054o = false;

    /* renamed from: p */
    C1923c f5055p = null;

    /* renamed from: r */
    Animator.AnimatorListener f5057r = new C1921a();

    /* renamed from: s */
    ValueAnimator.AnimatorUpdateListener f5058s = new C1922b();

    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1921a implements Animator.AnimatorListener {
        C1921a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            MyLocationOverlay.this.m54224w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1922b implements ValueAnimator.AnimatorUpdateListener {
        C1922b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (MyLocationOverlay.this.f5042c != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    MyLocationOverlay.this.f5042c.setCenter(latLng);
                    MyLocationOverlay.this.f5041b.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1923c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            Double.isNaN(d2);
            double d3 = latLng.longitude;
            Double.isNaN(d2);
            return new LatLng(d + ((latLng2.latitude - d) * d2), d3 + (d2 * (latLng2.longitude - d3)));
        }
    }

    public MyLocationOverlay(IAMapDelegate iAMapDelegate, Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f5046g = origApplicationContext;
        this.f5040a = iAMapDelegate;
        this.f5047h = new SensorEventHelper(origApplicationContext, iAMapDelegate);
        m54243d(4, true);
    }

    /* renamed from: c */
    private void m54244c(int i) {
        m54243d(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r4 != 7) goto L14;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54243d(int r4, boolean r5) {
        /*
            r3 = this;
            r3.f5048i = r4
            r0 = 0
            r3.f5049j = r0
            r3.f5051l = r0
            r3.f5050k = r0
            r3.f5053n = r0
            r3.f5054o = r0
            r1 = 1
            if (r4 == r1) goto L36
            r2 = 2
            if (r4 == r2) goto L31
            r2 = 3
            if (r4 == r2) goto L2c
            r2 = 4
            if (r4 == r2) goto L25
            r2 = 5
            if (r4 == r2) goto L20
            r2 = 7
            if (r4 == r2) goto L2e
            goto L3c
        L20:
            r3.f5053n = r1
            r3.f5052m = r0
            goto L3c
        L25:
            r3.f5050k = r1
            r3.f5053n = r1
            r3.f5052m = r0
            goto L3c
        L2c:
            r3.f5050k = r1
        L2e:
            r3.f5054o = r1
            goto L3c
        L31:
            r3.f5050k = r1
            r3.f5052m = r1
            goto L3c
        L36:
            r3.f5050k = r1
            r3.f5051l = r1
            r3.f5052m = r1
        L3c:
            boolean r4 = r3.f5053n
            if (r4 != 0) goto L56
            boolean r4 = r3.f5054o
            if (r4 == 0) goto L45
            goto L56
        L45:
            com.amap.api.maps.model.Marker r4 = r3.f5041b
            if (r4 == 0) goto L4c
            r4.setFlat(r0)
        L4c:
            r3.m54226u()
            r3.m54227t()
            r3.m54228s()
            goto L88
        L56:
            boolean r4 = r3.f5054o
            if (r4 == 0) goto L77
            com.amap.api.col.3l.f r4 = r3.f5047h
            r4.m55103f(r1)
            if (r5 != 0) goto L71
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r3.f5040a     // Catch: java.lang.Throwable -> L6d
            r5 = 1099431936(0x41880000, float:17.0)
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r5 = com.amap.api.col.p0463l.CameraUpdateFactoryDelegate.m54553b(r5)     // Catch: java.lang.Throwable -> L6d
            r4.moveCamera(r5)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r4 = move-exception
            r4.printStackTrace()
        L71:
            r4 = 1110704128(0x42340000, float:45.0)
            r3.m54235l(r4)
            goto L7c
        L77:
            com.amap.api.col.3l.f r4 = r3.f5047h
            r4.m55103f(r0)
        L7c:
            com.amap.api.col.3l.f r4 = r3.f5047h
            r4.m55105d()
            com.amap.api.maps.model.Marker r4 = r3.f5041b
            if (r4 == 0) goto L88
            r4.setFlat(r1)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.MyLocationOverlay.m54243d(int, boolean):void");
    }

    /* renamed from: g */
    private void m54240g(LatLng latLng) {
        LatLng position = this.f5041b.getPosition();
        if (position == null) {
            position = new LatLng(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
        }
        if (this.f5055p == null) {
            this.f5055p = new C1923c();
        }
        ValueAnimator valueAnimator = this.f5056q;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new C1923c(), position, latLng);
            this.f5056q = ofObject;
            ofObject.addListener(this.f5057r);
            this.f5056q.addUpdateListener(this.f5058s);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.f5056q.setEvaluator(this.f5055p);
        }
        if (position.latitude == Utils.DOUBLE_EPSILON && position.longitude == Utils.DOUBLE_EPSILON) {
            this.f5056q.setDuration(1L);
        } else {
            this.f5056q.setDuration(1000L);
        }
        this.f5056q.start();
    }

    /* renamed from: i */
    private void m54238i(boolean z) {
        Circle circle = this.f5042c;
        if (circle != null && circle.isVisible() != z) {
            this.f5042c.setVisible(z);
        }
        Marker marker = this.f5041b;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f5041b.setVisible(z);
    }

    /* renamed from: l */
    private void m54235l(float f) {
        IAMapDelegate iAMapDelegate = this.f5040a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(CameraUpdateFactoryDelegate.m54539p(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: o */
    private void m54232o(float f) {
        if (this.f5052m) {
            float f2 = f % 360.0f;
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            } else if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            Marker marker = this.f5041b;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    /* renamed from: s */
    private void m54228s() {
        this.f5047h.m55101h();
    }

    /* renamed from: t */
    private void m54227t() {
        m54235l(0.0f);
    }

    /* renamed from: u */
    private void m54226u() {
        m54225v();
    }

    /* renamed from: v */
    private void m54225v() {
        IAMapDelegate iAMapDelegate = this.f5040a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(CameraUpdateFactoryDelegate.m54538q(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m54224w() {
        if (this.f5044e != null && this.f5050k) {
            if (this.f5051l && this.f5049j) {
                return;
            }
            this.f5049j = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.f5044e;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.f5040a.animateCamera(CameraUpdateFactoryDelegate.m54550e(obtain));
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: x */
    private void m54223x() {
        MyLocationStyle myLocationStyle = this.f5043d;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f5043d = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.f5043d.getMyLocationIcon().getBitmap() == null) {
            this.f5043d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        m54221z();
    }

    /* renamed from: y */
    private void m54222y() {
        Circle circle = this.f5042c;
        if (circle != null) {
            try {
                this.f5040a.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f5042c = null;
        }
        Marker marker = this.f5041b;
        if (marker != null) {
            marker.remove();
            this.f5041b = null;
            this.f5047h.m55104e(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0115 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0017, B:7:0x001c, B:9:0x002a, B:10:0x0035, B:12:0x0043, B:13:0x004e, B:15:0x005c, B:16:0x0067, B:18:0x006b, B:19:0x0070, B:20:0x007c, B:22:0x0081, B:23:0x0092, B:25:0x0096, B:27:0x00a4, B:30:0x00c5, B:32:0x00cd, B:35:0x00da, B:37:0x00e2, B:39:0x00fa, B:41:0x0111, B:43:0x0115, B:40:0x0106, B:29:0x00b4, B:44:0x011f), top: B:49:0x0000 }] */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54221z() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.MyLocationOverlay.m54221z():void");
    }

    /* renamed from: a */
    public final MyLocationStyle m54246a() {
        return this.f5043d;
    }

    /* renamed from: b */
    public final void m54245b(float f) {
        Marker marker = this.f5041b;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    /* renamed from: e */
    public final void m54242e(Location location) {
        if (location == null) {
            return;
        }
        m54238i(this.f5043d.isMyLocationShowing());
        if (this.f5043d.isMyLocationShowing()) {
            this.f5044e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f5045f = location.getAccuracy();
            if (this.f5041b == null && this.f5042c == null) {
                m54223x();
            }
            Circle circle = this.f5042c;
            if (circle != null) {
                try {
                    double d = this.f5045f;
                    if (d != -1.0d) {
                        circle.setRadius(d);
                    }
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            m54232o(location.getBearing());
            if (!this.f5044e.equals(this.f5041b.getPosition())) {
                m54240g(this.f5044e);
            } else {
                m54224w();
            }
        }
    }

    /* renamed from: h */
    public final void m54239h(MyLocationStyle myLocationStyle) {
        try {
            this.f5043d = myLocationStyle;
            m54238i(myLocationStyle.isMyLocationShowing());
            if (!this.f5043d.isMyLocationShowing()) {
                this.f5047h.m55103f(false);
                this.f5048i = this.f5043d.getMyLocationType();
                return;
            }
            m54223x();
            Marker marker = this.f5041b;
            if (marker == null && this.f5042c == null) {
                return;
            }
            this.f5047h.m55104e(marker);
            m54244c(this.f5043d.getMyLocationType());
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: k */
    public final void m54236k() {
        SensorEventHelper sensorEventHelper;
        if (this.f5048i != 3 || (sensorEventHelper = this.f5047h) == null) {
            return;
        }
        sensorEventHelper.m55105d();
    }

    /* renamed from: n */
    public final void m54233n() throws RemoteException {
        m54222y();
        if (this.f5047h != null) {
            m54228s();
            this.f5047h = null;
        }
    }

    /* renamed from: p */
    public final String m54231p() {
        Marker marker = this.f5041b;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    /* renamed from: q */
    public final String m54230q() throws RemoteException {
        Circle circle = this.f5042c;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    /* renamed from: r */
    public final void m54229r() {
        this.f5042c = null;
        this.f5041b = null;
    }
}
