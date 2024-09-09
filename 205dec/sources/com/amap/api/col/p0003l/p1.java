package com.amap.api.col.p0003l;

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
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MyLocationOverlay.java */
/* renamed from: com.amap.api.col.3l.p1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p1 {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f8593a;

    /* renamed from: b  reason: collision with root package name */
    private Marker f8594b;

    /* renamed from: c  reason: collision with root package name */
    private Circle f8595c;

    /* renamed from: e  reason: collision with root package name */
    private LatLng f8597e;

    /* renamed from: f  reason: collision with root package name */
    private double f8598f;

    /* renamed from: g  reason: collision with root package name */
    private Context f8599g;

    /* renamed from: h  reason: collision with root package name */
    private f f8600h;

    /* renamed from: q  reason: collision with root package name */
    ValueAnimator f8609q;

    /* renamed from: d  reason: collision with root package name */
    private MyLocationStyle f8596d = new MyLocationStyle();

    /* renamed from: i  reason: collision with root package name */
    private int f8601i = 4;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8602j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8603k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8604l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8605m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8606n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8607o = false;

    /* renamed from: p  reason: collision with root package name */
    c f8608p = null;

    /* renamed from: r  reason: collision with root package name */
    Animator.AnimatorListener f8610r = new a();

    /* renamed from: s  reason: collision with root package name */
    ValueAnimator.AnimatorUpdateListener f8611s = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            p1.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (p1.this.f8595c != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    p1.this.f8595c.setCenter(latLng);
                    p1.this.f8594b.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MyLocationOverlay.java */
    /* renamed from: com.amap.api.col.3l.p1$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f4, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d4 = latLng.latitude;
            double d5 = f4;
            Double.isNaN(d5);
            double d6 = latLng.longitude;
            Double.isNaN(d5);
            return new LatLng(d4 + ((latLng2.latitude - d4) * d5), d6 + (d5 * (latLng2.longitude - d6)));
        }
    }

    public p1(IAMapDelegate iAMapDelegate, Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8599g = origApplicationContext;
        this.f8593a = iAMapDelegate;
        this.f8600h = new f(origApplicationContext, iAMapDelegate);
        d(4, true);
    }

    private void c(int i4) {
        d(i4, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r4 != 7) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r4, boolean r5) {
        /*
            r3 = this;
            r3.f8601i = r4
            r0 = 0
            r3.f8602j = r0
            r3.f8604l = r0
            r3.f8603k = r0
            r3.f8606n = r0
            r3.f8607o = r0
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
            r3.f8606n = r1
            r3.f8605m = r0
            goto L3c
        L25:
            r3.f8603k = r1
            r3.f8606n = r1
            r3.f8605m = r0
            goto L3c
        L2c:
            r3.f8603k = r1
        L2e:
            r3.f8607o = r1
            goto L3c
        L31:
            r3.f8603k = r1
            r3.f8605m = r1
            goto L3c
        L36:
            r3.f8603k = r1
            r3.f8604l = r1
            r3.f8605m = r1
        L3c:
            boolean r4 = r3.f8606n
            if (r4 != 0) goto L56
            boolean r4 = r3.f8607o
            if (r4 == 0) goto L45
            goto L56
        L45:
            com.amap.api.maps.model.Marker r4 = r3.f8594b
            if (r4 == 0) goto L4c
            r4.setFlat(r0)
        L4c:
            r3.u()
            r3.t()
            r3.s()
            goto L88
        L56:
            boolean r4 = r3.f8607o
            if (r4 == 0) goto L77
            com.amap.api.col.3l.f r4 = r3.f8600h
            r4.f(r1)
            if (r5 != 0) goto L71
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r3.f8593a     // Catch: java.lang.Throwable -> L6d
            r5 = 1099431936(0x41880000, float:17.0)
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r5 = com.amap.api.col.p0003l.m.b(r5)     // Catch: java.lang.Throwable -> L6d
            r4.moveCamera(r5)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r4 = move-exception
            r4.printStackTrace()
        L71:
            r4 = 1110704128(0x42340000, float:45.0)
            r3.l(r4)
            goto L7c
        L77:
            com.amap.api.col.3l.f r4 = r3.f8600h
            r4.f(r0)
        L7c:
            com.amap.api.col.3l.f r4 = r3.f8600h
            r4.d()
            com.amap.api.maps.model.Marker r4 = r3.f8594b
            if (r4 == 0) goto L88
            r4.setFlat(r1)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p1.d(int, boolean):void");
    }

    private void g(LatLng latLng) {
        LatLng position = this.f8594b.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.f8608p == null) {
            this.f8608p = new c();
        }
        ValueAnimator valueAnimator = this.f8609q;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new c(), position, latLng);
            this.f8609q = ofObject;
            ofObject.addListener(this.f8610r);
            this.f8609q.addUpdateListener(this.f8611s);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.f8609q.setEvaluator(this.f8608p);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.f8609q.setDuration(1L);
        } else {
            this.f8609q.setDuration(1000L);
        }
        this.f8609q.start();
    }

    private void i(boolean z3) {
        Circle circle = this.f8595c;
        if (circle != null && circle.isVisible() != z3) {
            this.f8595c.setVisible(z3);
        }
        Marker marker = this.f8594b;
        if (marker == null || marker.isVisible() == z3) {
            return;
        }
        this.f8594b.setVisible(z3);
    }

    private void l(float f4) {
        IAMapDelegate iAMapDelegate = this.f8593a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(m.p(f4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void o(float f4) {
        if (this.f8605m) {
            float f5 = f4 % 360.0f;
            if (f5 > 180.0f) {
                f5 -= 360.0f;
            } else if (f5 < -180.0f) {
                f5 += 360.0f;
            }
            Marker marker = this.f8594b;
            if (marker != null) {
                marker.setRotateAngle(-f5);
            }
        }
    }

    private void s() {
        this.f8600h.h();
    }

    private void t() {
        l(0.0f);
    }

    private void u() {
        v();
    }

    private void v() {
        IAMapDelegate iAMapDelegate = this.f8593a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(m.q(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f8597e != null && this.f8603k) {
            if (this.f8604l && this.f8602j) {
                return;
            }
            this.f8602j = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.f8597e;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.f8593a.animateCamera(m.e(obtain));
            } catch (Throwable th) {
                u5.p(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void x() {
        MyLocationStyle myLocationStyle = this.f8596d;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f8596d = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.f8596d.getMyLocationIcon().getBitmap() == null) {
            this.f8596d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        z();
    }

    private void y() {
        Circle circle = this.f8595c;
        if (circle != null) {
            try {
                this.f8593a.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                u5.p(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f8595c = null;
        }
        Marker marker = this.f8594b;
        if (marker != null) {
            marker.remove();
            this.f8594b = null;
            this.f8600h.e(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0115 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0017, B:7:0x001c, B:9:0x002a, B:10:0x0035, B:12:0x0043, B:13:0x004e, B:15:0x005c, B:16:0x0067, B:18:0x006b, B:19:0x0070, B:20:0x007c, B:22:0x0081, B:23:0x0092, B:25:0x0096, B:27:0x00a4, B:30:0x00c5, B:32:0x00cd, B:35:0x00da, B:37:0x00e2, B:39:0x00fa, B:41:0x0111, B:43:0x0115, B:40:0x0106, B:29:0x00b4, B:44:0x011f), top: B:49:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p1.z():void");
    }

    public final MyLocationStyle a() {
        return this.f8596d;
    }

    public final void b(float f4) {
        Marker marker = this.f8594b;
        if (marker != null) {
            marker.setRotateAngle(f4);
        }
    }

    public final void e(Location location) {
        if (location == null) {
            return;
        }
        i(this.f8596d.isMyLocationShowing());
        if (this.f8596d.isMyLocationShowing()) {
            this.f8597e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f8598f = location.getAccuracy();
            if (this.f8594b == null && this.f8595c == null) {
                x();
            }
            Circle circle = this.f8595c;
            if (circle != null) {
                try {
                    double d4 = this.f8598f;
                    if (d4 != -1.0d) {
                        circle.setRadius(d4);
                    }
                } catch (Throwable th) {
                    u5.p(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            o(location.getBearing());
            if (!this.f8597e.equals(this.f8594b.getPosition())) {
                g(this.f8597e);
            } else {
                w();
            }
        }
    }

    public final void h(MyLocationStyle myLocationStyle) {
        try {
            this.f8596d = myLocationStyle;
            i(myLocationStyle.isMyLocationShowing());
            if (!this.f8596d.isMyLocationShowing()) {
                this.f8600h.f(false);
                this.f8601i = this.f8596d.getMyLocationType();
                return;
            }
            x();
            Marker marker = this.f8594b;
            if (marker == null && this.f8595c == null) {
                return;
            }
            this.f8600h.e(marker);
            c(this.f8596d.getMyLocationType());
        } catch (Throwable th) {
            u5.p(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void k() {
        f fVar;
        if (this.f8601i != 3 || (fVar = this.f8600h) == null) {
            return;
        }
        fVar.d();
    }

    public final void n() throws RemoteException {
        y();
        if (this.f8600h != null) {
            s();
            this.f8600h = null;
        }
    }

    public final String p() {
        Marker marker = this.f8594b;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String q() throws RemoteException {
        Circle circle = this.f8595c;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void r() {
        this.f8595c = null;
        this.f8594b = null;
    }
}
