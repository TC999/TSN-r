package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.col.p0003l.ef;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.Poi;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpRequest.java */
/* renamed from: com.amap.api.col.3l.o9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o9 {

    /* renamed from: a  reason: collision with root package name */
    public String f8469a;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f8472d;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f8470b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    boolean f8471c = true;

    /* renamed from: e  reason: collision with root package name */
    public int f8473e = 10000;

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double f8474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f8475b;

        a(double d4, double d5) {
            this.f8474a = d4;
            this.f8475b = d5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 19;
            obtain.arg1 = (int) this.f8474a;
            obtain.arg2 = (int) this.f8475b;
            o9.this.z0.sendMessage(obtain);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$a0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a0 implements Runnable {
        a0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (o9.u0(o9.this) != null) {
                o9.u0(o9.this).a(o9.w0(o9.this));
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class b extends t0 {
        b() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setTrafficEnabled(this.f8547b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$b0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (o9.W(o9.this) != null) {
                    o9.W(o9.this).destroy();
                }
                o9 o9Var = o9.this;
                o9Var.destroySurface(o9.g0(o9Var));
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ed f8480a;

        c(ed edVar) {
            this.f8480a = edVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (o9.p0(o9.this)) {
                return;
            }
            try {
                o9 o9Var = o9.this;
                com.amap.api.col.p0003l.x xVar = o9Var.t;
                if (xVar != null) {
                    o9Var.setIndoorBuildingInfo(xVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f8480a.a();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$c0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CrossVectorOverlay f8482a;

        c0(CrossVectorOverlay crossVectorOverlay) {
            this.f8482a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            o9 o9Var = o9.this;
            GLMapEngine gLMapEngine = o9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(o9.g0(o9Var))) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f8482a);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$d */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8484a;

        d(int i4) {
            this.f8484a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine;
            if (!o9.r0(o9.this) || (gLMapEngine = o9.this.Z) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.f8484a, false);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$d0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class d0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteOverlayInner f8486a;

        d0(RouteOverlayInner routeOverlayInner) {
            this.f8486a = routeOverlayInner;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            o9 o9Var = o9.this;
            GLMapEngine gLMapEngine = o9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(o9.g0(o9Var))) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f8486a);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$e */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8488a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8489b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8490c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f8491d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ StyleItem[] f8492e;

        e(int i4, int i5, int i6, boolean z3, StyleItem[] styleItemArr) {
            this.f8488a = i4;
            this.f8489b = i5;
            this.f8490c = i6;
            this.f8491d = z3;
            this.f8492e = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.Z.setMapModeAndStyle(this.f8488a, this.f8489b, this.f8490c, this.f8491d, this.f8492e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$e0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class e0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseMapOverlay f8494a;

        e0(BaseMapOverlay baseMapOverlay) {
            this.f8494a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o9 o9Var = o9.this;
            o9Var.Z.getOverlayBundle(o9.g0(o9Var)).removeOverlay(this.f8494a);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$f */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8496a;

        f(int i4) {
            this.f8496a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.Z.clearAllMessages(this.f8496a);
                o9.this.Z.clearAnimations(this.f8496a, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$f0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class f0 implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f8498a;

        f0(List list) {
            this.f8498a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() throws Exception {
            return Integer.valueOf(o9.this.Z.hideBuildings(this.f8498a));
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$g */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8501b;

        g(int i4, boolean z3) {
            this.f8500a = i4;
            this.f8501b = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.Z.setBuildingEnable(this.f8500a, this.f8501b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$g0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class g0 extends t0 {
        g0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setTrafficStyleWithTextureData(this.f8553h);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$h */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8504a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8505b;

        h(boolean z3, int i4) {
            this.f8504a = z3;
            this.f8505b = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine = o9.this.Z;
            if (gLMapEngine != null) {
                if (this.f8504a) {
                    gLMapEngine.setAllContentEnable(this.f8505b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.f8505b, false);
                }
                o9.this.Z.setSimple3DEnable(this.f8505b, false);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$h0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class h0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8507a;

        h0(int i4) {
            this.f8507a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o9.this.Z.showHideBuildings(this.f8507a);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$i */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8509a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8510b;

        i(boolean z3, int i4) {
            this.f8509a = z3;
            this.f8510b = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f8509a) {
                    o9.this.Z.setBuildingTextureEnable(this.f8510b, true);
                } else {
                    o9.this.Z.setBuildingTextureEnable(this.f8510b, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$i0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class i0 extends t0 {
        i0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            o9.this.setMapCustomEnable(this.f8547b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$j */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LatLngBounds.Builder f8513a;

        j(LatLngBounds.Builder builder) {
            this.f8513a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.moveCamera(com.amap.api.col.p0003l.m.i(this.f8513a.build(), 50));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$j0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class j0 extends t0 {
        j0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            o9.this.k(this.f8550e, this.f8547b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$k */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            el f4;
            if (message == null || o9.d(o9.this).get()) {
                return;
            }
            try {
                int i4 = message.what;
                if (i4 == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Key\u9a8c\u8bc1\u5931\u8d25\uff1a[");
                    Object obj = message.obj;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(f4.b);
                    }
                    sb.append("]");
                    Log.w("amapsdk", sb.toString());
                } else if (i4 != 30) {
                    int i5 = 0;
                    switch (i4) {
                        case 10:
                            CameraPosition cameraPosition = (CameraPosition) message.obj;
                            List<AMap.OnCameraChangeListener> a4 = o9.w(o9.this).a(AMap.OnCameraChangeListener.class.hashCode());
                            if (cameraPosition != null && a4 != null && a4.size() > 0) {
                                synchronized (a4) {
                                    for (AMap.OnCameraChangeListener onCameraChangeListener : a4) {
                                        onCameraChangeListener.onCameraChange(cameraPosition);
                                    }
                                }
                            }
                            o9.this.q.addChangedCounter();
                            return;
                        case 11:
                            CameraPosition cameraPosition2 = o9.this.getCameraPosition();
                            if (cameraPosition2 != null && o9.F(o9.this) != null) {
                                o9.F(o9.this).p(cameraPosition2);
                            }
                            o9.m(o9.this, cameraPosition2);
                            if (o9.R(o9.this)) {
                                o9.V(o9.this);
                                if (o9.W(o9.this) != null) {
                                    o9.W(o9.this).setFlingState(false);
                                }
                                o9.this.x();
                            }
                            if (o9.d0(o9.this)) {
                                o9.this.redrawInfoWindow();
                                o9.f0(o9.this);
                            }
                            o9.this.n(cameraPosition2);
                            return;
                        case 12:
                            if (o9.F(o9.this) != null) {
                                o9.F(o9.this).o(Float.valueOf(o9.this.getZoomLevel()));
                                return;
                            }
                            return;
                        case 13:
                            if (o9.F(o9.this) != null) {
                                o9.F(o9.this).h();
                                return;
                            }
                            return;
                        case 14:
                            List<AMap.OnMapTouchListener> a5 = o9.w(o9.this).a(AMap.OnMapTouchListener.class.hashCode());
                            if (a5 == null || a5.size() <= 0) {
                                return;
                            }
                            synchronized (a5) {
                                for (AMap.OnMapTouchListener onMapTouchListener : a5) {
                                    onMapTouchListener.onTouch((MotionEvent) message.obj);
                                }
                            }
                            return;
                        case 15:
                            Bitmap bitmap = (Bitmap) message.obj;
                            int i6 = message.arg1;
                            if (bitmap != null && o9.F(o9.this) != null) {
                                Canvas canvas = new Canvas(bitmap);
                                if (o9.N(o9.this) && (f4 = o9.F(o9.this).f()) != null) {
                                    f4.onDraw(canvas);
                                }
                                o9.F(o9.this).j(canvas);
                                List a6 = o9.w(o9.this).a(AMap.onMapPrintScreenListener.class.hashCode());
                                ArrayList arrayList = a6 != null ? new ArrayList(a6) : null;
                                List a7 = o9.w(o9.this).a(AMap.OnMapScreenShotListener.class.hashCode());
                                ArrayList arrayList2 = a7 != null ? new ArrayList(a7) : null;
                                o9.w(o9.this).d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                o9.w(o9.this).d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList != null && arrayList.size() > 0) {
                                    synchronized (arrayList) {
                                        for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                            ((AMap.onMapPrintScreenListener) arrayList.get(i7)).onMapPrint(new BitmapDrawable(o9.this.Y.getResources(), bitmap));
                                        }
                                    }
                                }
                                if (arrayList2 == null || arrayList2.size() <= 0) {
                                    return;
                                }
                                synchronized (arrayList2) {
                                    while (i5 < arrayList2.size()) {
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i5)).onMapScreenShot(bitmap);
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i5)).onMapScreenShot(bitmap, i6);
                                        i5++;
                                    }
                                }
                                return;
                            }
                            List a8 = o9.w(o9.this).a(AMap.onMapPrintScreenListener.class.hashCode());
                            ArrayList arrayList3 = a8 != null ? new ArrayList(a8) : null;
                            List a9 = o9.w(o9.this).a(AMap.OnMapScreenShotListener.class.hashCode());
                            ArrayList arrayList4 = a9 != null ? new ArrayList(a9) : null;
                            o9.w(o9.this).d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            o9.w(o9.this).d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                synchronized (arrayList3) {
                                    for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                                        ((AMap.onMapPrintScreenListener) arrayList3.get(i8)).onMapPrint(null);
                                    }
                                }
                            }
                            if (arrayList4 == null || arrayList4.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList4) {
                                while (i5 < arrayList4.size()) {
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i5)).onMapScreenShot(null);
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i5)).onMapScreenShot(null, i6);
                                    i5++;
                                }
                            }
                            return;
                        case 16:
                            List a10 = o9.w(o9.this).a(AMap.OnMapLoadedListener.class.hashCode());
                            if (a10 != null) {
                                synchronized (a10) {
                                    while (i5 < a10.size()) {
                                        ((AMap.OnMapLoadedListener) a10.get(i5)).onMapLoaded();
                                        i5++;
                                    }
                                }
                            }
                            if (o9.F(o9.this) != null) {
                                o9.F(o9.this).i();
                                return;
                            }
                            return;
                        case 17:
                            o9 o9Var = o9.this;
                            if (!o9Var.Z.isInMapAnimation(o9.g0(o9Var)) || o9.W(o9.this) == null) {
                                return;
                            }
                            o9.W(o9.this).setFlingState(false);
                            return;
                        case 18:
                            if (o9.i0(o9.this) != null) {
                                o9.i0(o9.this).r();
                                return;
                            }
                            return;
                        case 19:
                            List<AMap.OnMapClickListener> a11 = o9.w(o9.this).a(AMap.OnMapClickListener.class.hashCode());
                            if (a11 != null) {
                                DPoint obtain = DPoint.obtain();
                                o9.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                synchronized (a11) {
                                    for (AMap.OnMapClickListener onMapClickListener : a11) {
                                        onMapClickListener.onMapClick(new LatLng(obtain.f11672y, obtain.f11671x));
                                    }
                                }
                                obtain.recycle();
                                return;
                            }
                            return;
                        case 20:
                            List a12 = o9.w(o9.this).a(AMap.OnPOIClickListener.class.hashCode());
                            if (a12 == null || a12.size() <= 0) {
                                return;
                            }
                            synchronized (a12) {
                                while (i5 < a12.size()) {
                                    ((AMap.OnPOIClickListener) a12.get(i5)).onPOIClick((Poi) message.obj);
                                    i5++;
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    GLMapEngine gLMapEngine = o9.this.Z;
                    if (gLMapEngine != null) {
                        gLMapEngine.triggerMainThread();
                    }
                }
            } catch (Throwable th) {
                t5.p(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$k0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class k0 extends t0 {
        k0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setMapTextEnable(this.f8547b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$l */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o9 o9Var = o9.this;
            if (o9Var.Z == null || o9.d(o9Var).get()) {
                return;
            }
            o9 o9Var2 = o9.this;
            o9Var2.Z.removeNativeAllOverlay(o9.g0(o9Var2));
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$l0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class l0 extends t0 {
        l0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setRoadArrowEnable(this.f8547b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$m */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class m extends t0 {
        m() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9 o9Var = o9.this;
                o9Var.setCenterToPixel(o9.k0(o9Var), o9.m0(o9.this));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$m0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class m0 extends t0 {
        m0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setNaviLabelEnable(this.f8547b, this.f8551f, this.f8552g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$n */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8523b;

        n(boolean z3, boolean z4) {
            this.f8522a = z3;
            this.f8523b = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (o9.this.q.isTrafficEnabled() != this.f8522a) {
                    o9.this.q.setTrafficEnabled(this.f8523b);
                    o9.s0(o9.this).setTrafficMode(this.f8522a);
                    o9 o9Var = o9.this;
                    o9Var.Z.setTrafficEnable(o9.g0(o9Var), this.f8522a);
                    o9.this.resetRenderTime();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$n0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class n0 extends t0 {
        n0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setTrafficStyleWithTexture(this.f8553h, this.f8554i);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$o */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8526a;

        o(boolean z3) {
            this.f8526a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f8526a) {
                o9.this.showIndoorSwitchControlsEnabled(true);
            } else if (o9.F(o9.this) != null) {
                o9.F(o9.this).k(Boolean.FALSE);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$o0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class o0 extends t0 {
        o0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            o9.this.z(this.f8550e, this.f8547b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$p */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8529a;

        p(boolean z3) {
            this.f8529a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o9 o9Var = o9.this;
            GLMapEngine gLMapEngine = o9Var.Z;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(o9.g0(o9Var), this.f8529a);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$p0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class p0 extends t0 {
        p0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setIndoorEnabled(this.f8547b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$q */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8532a;

        q(boolean z3) {
            this.f8532a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.Z.setLabelEnable(o9.g0(o9Var), this.f8532a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$q0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class q0 implements Runnable {
        q0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            el f4;
            if (o9.F(o9.this) == null || (f4 = o9.F(o9.this).f()) == null) {
                return;
            }
            f4.l();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$r */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8535a;

        r(boolean z3) {
            this.f8535a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.Z.setRoadArrowEnable(o9.g0(o9Var), this.f8535a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$r0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class r0 extends t0 {
        r0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            o9.this.H(this.f8550e, this.f8547b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$s */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8539b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8540c;

        s(boolean z3, int i4, int i5) {
            this.f8538a = z3;
            this.f8539b = i4;
            this.f8540c = i5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.Z.setNaviLabelEnable(o9.g0(o9Var), this.f8538a, this.f8539b, this.f8540c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$s0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class s0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MotionEvent f8542a;

        s0(MotionEvent motionEvent) {
            this.f8542a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.Z.addGestureSingleTapMessage(this.f8542a.getX(), this.f8542a.getY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$t */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8544a;

        t(boolean z3) {
            this.f8544a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9.this.Z.setMapOpenLayerEnable(this.f8544a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$u */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f8555a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyTrafficStyle f8556b;

        u(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f8555a = bArr;
            this.f8556b = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.Z.setTrafficStyleWithTexture(o9.g0(o9Var), this.f8555a, this.f8556b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$u0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class u0 {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.o9$u0$a */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ef f8559a;

            a(ef efVar) {
                this.f8559a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f8559a.j(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.o9$u0$b */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ef f8561a;

            b(ef efVar) {
                this.f8561a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f8561a.k(o9.this.t.floor_names);
                    this.f8561a.i(o9.this.t.activeFloorName);
                    if (this.f8561a.o()) {
                        return;
                    }
                    this.f8561a.j(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        u0() {
        }

        public final void a(com.amap.api.col.p0003l.x xVar) {
            List a4;
            List a5;
            com.amap.api.col.p0003l.x xVar2;
            com.amap.api.col.p0003l.x xVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = o9.this.q;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            ef e4 = o9.F(o9.this).e();
            if (xVar == null) {
                try {
                    List a6 = o9.w(o9.this).a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a6 != null && a6.size() > 0) {
                        synchronized (a6) {
                            for (int i4 = 0; i4 < a6.size(); i4++) {
                                ((AMap.OnIndoorBuildingActiveListener) a6.get(i4)).OnIndoorBuilding(xVar);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                com.amap.api.col.p0003l.x xVar4 = o9.this.t;
                if (xVar4 != null) {
                    xVar4.f9380g = null;
                }
                if (e4.o()) {
                    o9.this.z0.post(new a(e4));
                }
                MapConfig mapConfig2 = o9.this.q;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? o9.this.q.getMaxZoomLevel() : 20.0f;
                try {
                    if (!o9.y0(o9.this).isZoomControlsEnabled() || (a4 = o9.w(o9.this).a(AMapWidgetListener.class.hashCode())) == null || a4.size() <= 0) {
                        return;
                    }
                    synchronized (a4) {
                        for (int i5 = 0; i5 < a4.size(); i5++) {
                            ((AMapWidgetListener) a4.get(i5)).invalidateZoomController(o9.this.q.getSZ());
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (xVar != null && (iArr = xVar.floor_indexs) != null && (strArr = xVar.floor_names) != null && iArr.length == strArr.length) {
                int i6 = 0;
                while (true) {
                    int[] iArr2 = xVar.floor_indexs;
                    if (i6 >= iArr2.length) {
                        break;
                    } else if (xVar.activeFloorIndex == iArr2[i6]) {
                        xVar.activeFloorName = xVar.floor_names[i6];
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            if (xVar == null || (xVar3 = o9.this.t) == null || xVar3.activeFloorIndex == xVar.activeFloorIndex || !e4.o()) {
                if (xVar != null && ((xVar2 = o9.this.t) == null || !xVar2.poiid.equals(xVar.poiid) || o9.this.t.f9380g == null)) {
                    o9 o9Var = o9.this;
                    o9Var.t = xVar;
                    if (o9Var.q != null) {
                        if (xVar.f9380g == null) {
                            xVar.f9380g = new Point();
                        }
                        DPoint mapGeoCenter = o9.this.q.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = o9.this.t.f9380g;
                            point.x = (int) mapGeoCenter.f11671x;
                            point.y = (int) mapGeoCenter.f11672y;
                        }
                    }
                }
                try {
                    List a7 = o9.w(o9.this).a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a7 != null && a7.size() > 0) {
                        synchronized (a7) {
                            for (int i7 = 0; i7 < a7.size(); i7++) {
                                ((AMap.OnIndoorBuildingActiveListener) a7.get(i7)).OnIndoorBuilding(xVar);
                            }
                        }
                    }
                    MapConfig mapConfig3 = o9.this.q;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? o9.this.q.getMaxZoomLevel() : 20.0f;
                    if (o9.y0(o9.this).isZoomControlsEnabled() && (a5 = o9.w(o9.this).a(AMapWidgetListener.class.hashCode())) != null && a5.size() > 0) {
                        synchronized (a5) {
                            for (int i8 = 0; i8 < a5.size(); i8++) {
                                ((AMapWidgetListener) a5.get(i8)).invalidateZoomController(o9.this.q.getSZ());
                            }
                        }
                    }
                    if (o9.y0(o9.this).isIndoorSwitchEnabled()) {
                        if (!e4.o()) {
                            o9.y0(o9.this).setIndoorSwitchEnabled(true);
                        }
                        o9.this.z0.post(new b(e4));
                    } else if (!o9.y0(o9.this).isIndoorSwitchEnabled() && e4.o()) {
                        o9.y0(o9.this).setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$v */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class v extends t0 {
        v() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                o9.this.setConstructingRoadEnable(this.f8547b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$v0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class v0 implements ef.d {
        private v0() {
        }

        @Override // com.amap.api.col.p0003l.ef.d
        public final void a(int i4) {
            o9 o9Var = o9.this;
            com.amap.api.col.p0003l.x xVar = o9Var.t;
            if (xVar != null) {
                xVar.activeFloorIndex = xVar.floor_indexs[i4];
                xVar.activeFloorName = xVar.floor_names[i4];
                try {
                    o9Var.setIndoorBuildingInfo(xVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        }

        /* synthetic */ v0(o9 o9Var, byte b4) {
            this();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$w */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f8565a;

        w(byte[] bArr) {
            this.f8565a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.Z.setTrafficStyleWithTextureData(o9.g0(o9Var), this.f8565a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$w0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class w0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f8567a;

        /* renamed from: b  reason: collision with root package name */
        private AMap.OnCacheRemoveListener f8568b;

        public w0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f8567a = context;
            this.f8568b = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof w0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
            if (com.amap.api.col.p0003l.a3.i0(r2) != false) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #3 {all -> 0x0034, blocks: (B:9:0x0027, B:16:0x003a), top: B:59:0x0027 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #4 {all -> 0x0066, blocks: (B:3:0x0002, B:5:0x001f, B:20:0x0042, B:22:0x004a), top: B:61:0x0002 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.f8567a     // Catch: java.lang.Throwable -> L66
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L66
                android.content.Context r2 = com.stub.StubApp.getOrigApplicationContext(r2)     // Catch: java.lang.Throwable -> L66
                java.lang.String r3 = com.amap.api.col.p0003l.a3.f0(r2)     // Catch: java.lang.Throwable -> L66
                java.lang.String r4 = com.amap.api.col.p0003l.a3.v(r2)     // Catch: java.lang.Throwable -> L66
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L66
                r5.<init>(r3)     // Catch: java.lang.Throwable -> L66
                boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L66
                if (r3 == 0) goto L24
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L66
                goto L25
            L24:
                r3 = 1
            L25:
                if (r3 == 0) goto L37
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L34
                r5.<init>(r4)     // Catch: java.lang.Throwable -> L34
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L34
                if (r3 == 0) goto L37
                r3 = 1
                goto L38
            L34:
                r2 = move-exception
                r1 = r3
                goto L67
            L37:
                r3 = 0
            L38:
                if (r3 == 0) goto L41
                boolean r2 = com.amap.api.col.p0003l.a3.i0(r2)     // Catch: java.lang.Throwable -> L34
                if (r2 == 0) goto L41
                goto L42
            L41:
                r1 = 0
            L42:
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0003l.o9.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.o9.W(r2)     // Catch: java.lang.Throwable -> L66
                if (r2 == 0) goto L53
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0003l.o9.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.o9.W(r2)     // Catch: java.lang.Throwable -> L66
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L66
            L53:
                com.amap.api.col.3l.o9 r0 = com.amap.api.col.p0003l.o9.this     // Catch: java.lang.Throwable -> L61
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.Z     // Catch: java.lang.Throwable -> L61
                if (r0 == 0) goto L60
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f8568b     // Catch: java.lang.Throwable -> L61
                if (r0 == 0) goto L60
                r0.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L61
            L60:
                return
            L61:
                r0 = move-exception
                r0.printStackTrace()
                return
            L66:
                r2 = move-exception
            L67:
                com.amap.api.col.p0003l.a3.D(r2)     // Catch: java.lang.Throwable -> L84
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.p0003l.t5.p(r2, r3, r4)     // Catch: java.lang.Throwable -> L84
                com.amap.api.col.3l.o9 r1 = com.amap.api.col.p0003l.o9.this     // Catch: java.lang.Throwable -> L7f
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.Z     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L7e
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f8568b     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L7e
                r1.onRemoveCacheFinish(r0)     // Catch: java.lang.Throwable -> L7f
            L7e:
                return
            L7f:
                r0 = move-exception
                r0.printStackTrace()
                return
            L84:
                r0 = move-exception
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0003l.o9.this     // Catch: java.lang.Throwable -> L93
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.Z     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f8568b     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L93
                goto L97
            L93:
                r1 = move-exception
                r1.printStackTrace()
            L97:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.o9.w0.run():void");
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$x */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o9 o9Var = o9.this;
                o9Var.q.setAnchorX(Math.max(0, Math.min(o9.k0(o9Var), o9.this.d0)));
                o9 o9Var2 = o9.this;
                o9Var2.q.setAnchorY(Math.max(0, Math.min(o9.m0(o9Var2), o9.this.e0)));
                o9 o9Var3 = o9.this;
                o9Var3.Z.setProjectionCenter(o9.g0(o9Var3), o9.this.q.getAnchorX(), o9.this.q.getAnchorY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$y */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class y extends t0 {
        y() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.o9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            o9.this.g(this.f8550e, this.f8548c, this.f8549d);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$z */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o9 o9Var = o9.this;
            GLMapEngine gLMapEngine = o9Var.Z;
            if (gLMapEngine != null) {
                int g02 = o9.g0(o9Var);
                com.amap.api.col.p0003l.x xVar = o9.this.t;
                gLMapEngine.setIndoorBuildingToBeActive(g02, xVar.activeFloorName, xVar.activeFloorIndex, xVar.poiid);
            }
        }
    }

    public static String a() {
        return "lc_" + ((int) l9.a());
    }

    public static String b() {
        return l9.g() + "*" + l9.m();
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$t0 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static abstract class t0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f8546a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8547b;

        /* renamed from: c  reason: collision with root package name */
        int f8548c;

        /* renamed from: d  reason: collision with root package name */
        int f8549d;

        /* renamed from: e  reason: collision with root package name */
        int f8550e;

        /* renamed from: f  reason: collision with root package name */
        int f8551f;

        /* renamed from: g  reason: collision with root package name */
        int f8552g;

        /* renamed from: h  reason: collision with root package name */
        byte[] f8553h;

        /* renamed from: i  reason: collision with root package name */
        MyTrafficStyle f8554i;

        private t0() {
            this.f8546a = false;
            this.f8547b = false;
            this.f8551f = 0;
            this.f8552g = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8546a = false;
        }

        /* synthetic */ t0(byte b4) {
            this();
        }
    }
}
