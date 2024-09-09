package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003l.ef;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.t8;
import com.amap.api.col.p0003l.y1;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapDelegateImp.java */
/* renamed from: com.amap.api.col.3l.p9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p9 implements y1.a, t8.a, IAMapDelegate, IAMapListener {
    private boolean A;
    private t0 A0;
    private boolean B;
    private t0 B0;
    private boolean C;
    private t0 C0;
    private boolean D;
    private t0 D0;
    private int E;
    private t0 E0;
    private boolean F;
    private t0 F0;
    private boolean G;
    private t0 G0;
    private Rect H;
    private t0 H0;
    private int I;
    private t0 I0;
    private MyTrafficStyle J;
    private t0 J0;
    private Thread K;
    private t0 K0;

    /* renamed from: L  reason: collision with root package name */
    private Thread f8648L;
    private t0 L0;
    private ea M;
    private t0 M0;
    private boolean N;
    private Runnable N0;
    private boolean O;
    private t0 O0;
    private int P;
    private com.autonavi.extra.b P0;
    private CustomRenderer Q;
    private String Q0;
    private int R;
    private String R0;
    private int S;
    private boolean S0;
    private List<com.amap.api.col.p0003l.d> T;
    private boolean T0;
    private w1 U;
    private int U0;
    private y1 V;
    private EAMapPlatformGestureInfo V0;
    r2 W;
    Point W0;
    private long X;
    private long X0;
    protected Context Y;
    protected String Y0;
    protected GLMapEngine Z;
    private com.amap.api.col.p0003l.x Z0;

    /* renamed from: a  reason: collision with root package name */
    private y9 f8649a;

    /* renamed from: a0  reason: collision with root package name */
    private GLMapRender f8650a0;

    /* renamed from: a1  reason: collision with root package name */
    float[] f8651a1;

    /* renamed from: b  reason: collision with root package name */
    private z9 f8652b;

    /* renamed from: b0  reason: collision with root package name */
    private ha f8653b0;

    /* renamed from: b1  reason: collision with root package name */
    float[] f8654b1;

    /* renamed from: c  reason: collision with root package name */
    private AMapGestureListener f8655c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f8656c0;

    /* renamed from: c1  reason: collision with root package name */
    float[] f8657c1;

    /* renamed from: d  reason: collision with root package name */
    private com.amap.api.col.p0003l.z f8658d;

    /* renamed from: d0  reason: collision with root package name */
    public int f8659d0;

    /* renamed from: d1  reason: collision with root package name */
    private IPoint[] f8660d1;

    /* renamed from: e  reason: collision with root package name */
    private UiSettings f8661e;

    /* renamed from: e0  reason: collision with root package name */
    public int f8662e0;

    /* renamed from: e1  reason: collision with root package name */
    float[] f8663e1;

    /* renamed from: f  reason: collision with root package name */
    private IProjectionDelegate f8664f;

    /* renamed from: f0  reason: collision with root package name */
    private float f8665f0;

    /* renamed from: f1  reason: collision with root package name */
    String f8666f1;

    /* renamed from: g  reason: collision with root package name */
    private final com.amap.api.col.p0003l.h f8667g;

    /* renamed from: g0  reason: collision with root package name */
    private float f8668g0;

    /* renamed from: g1  reason: collision with root package name */
    String f8669g1;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f8670h;

    /* renamed from: h0  reason: collision with root package name */
    private float f8671h0;

    /* renamed from: h1  reason: collision with root package name */
    int f8672h1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8673i;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f8674i0;

    /* renamed from: j  reason: collision with root package name */
    private final IGLSurfaceView f8675j;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f8676j0;

    /* renamed from: k  reason: collision with root package name */
    private h3 f8677k;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f8678k0;

    /* renamed from: l  reason: collision with root package name */
    private final IGlOverlayLayer f8679l;

    /* renamed from: l0  reason: collision with root package name */
    private volatile boolean f8680l0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8681m;

    /* renamed from: m0  reason: collision with root package name */
    private volatile boolean f8682m0;

    /* renamed from: n  reason: collision with root package name */
    private int f8683n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f8684n0;

    /* renamed from: o  reason: collision with root package name */
    private AtomicBoolean f8685o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f8686o0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8687p;

    /* renamed from: p0  reason: collision with root package name */
    private Lock f8688p0;

    /* renamed from: q  reason: collision with root package name */
    protected MapConfig f8689q;

    /* renamed from: q0  reason: collision with root package name */
    private int f8690q0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f8691r;

    /* renamed from: r0  reason: collision with root package name */
    private int f8692r0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8693s;

    /* renamed from: s0  reason: collision with root package name */
    private int f8694s0;

    /* renamed from: t  reason: collision with root package name */
    protected com.amap.api.col.p0003l.x f8695t;

    /* renamed from: t0  reason: collision with root package name */
    private u0 f8696t0;

    /* renamed from: u  reason: collision with root package name */
    private p1 f8697u;

    /* renamed from: u0  reason: collision with root package name */
    private u1 f8698u0;

    /* renamed from: v  reason: collision with root package name */
    private LocationSource f8699v;

    /* renamed from: v0  reason: collision with root package name */
    private AMap.OnMultiPointClickListener f8700v0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f8701w;

    /* renamed from: w0  reason: collision with root package name */
    private t8 f8702w0;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8703x;

    /* renamed from: x0  reason: collision with root package name */
    private long f8704x0;

    /* renamed from: y  reason: collision with root package name */
    private Marker f8705y;

    /* renamed from: y0  reason: collision with root package name */
    boolean f8706y0;

    /* renamed from: z  reason: collision with root package name */
    private GLTFOverlay f8707z;

    /* renamed from: z0  reason: collision with root package name */
    protected final Handler f8708z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double f8709a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f8710b;

        a(double d4, double d5) {
            this.f8709a = d4;
            this.f8710b = d5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 19;
            obtain.arg1 = (int) this.f8709a;
            obtain.arg2 = (int) this.f8710b;
            p9.this.f8708z0.sendMessage(obtain);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$a0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a0 implements Runnable {
        a0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (p9.this.f8696t0 != null) {
                p9.this.f8696t0.a(p9.this.Z0);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b extends t0 {
        b() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setTrafficEnabled(this.f8782b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$b0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (p9.this.f8679l != null) {
                    p9.this.f8679l.destroy();
                }
                p9 p9Var = p9.this;
                p9Var.destroySurface(p9Var.f8683n);
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ed f8715a;

        c(ed edVar) {
            this.f8715a = edVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (p9.this.f8687p) {
                return;
            }
            try {
                p9 p9Var = p9.this;
                com.amap.api.col.p0003l.x xVar = p9Var.f8695t;
                if (xVar != null) {
                    p9Var.setIndoorBuildingInfo(xVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f8715a.a();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$c0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CrossVectorOverlay f8717a;

        c0(CrossVectorOverlay crossVectorOverlay) {
            this.f8717a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            p9 p9Var = p9.this;
            GLMapEngine gLMapEngine = p9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(p9Var.f8683n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f8717a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8719a;

        d(int i4) {
            this.f8719a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine;
            if (!p9.this.f8680l0 || (gLMapEngine = p9.this.Z) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.f8719a, false);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$d0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class d0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RouteOverlayInner f8721a;

        d0(RouteOverlayInner routeOverlayInner) {
            this.f8721a = routeOverlayInner;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            p9 p9Var = p9.this;
            GLMapEngine gLMapEngine = p9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(p9Var.f8683n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f8721a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8723a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8724b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8725c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f8726d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ StyleItem[] f8727e;

        e(int i4, int i5, int i6, boolean z3, StyleItem[] styleItemArr) {
            this.f8723a = i4;
            this.f8724b = i5;
            this.f8725c = i6;
            this.f8726d = z3;
            this.f8727e = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.Z.setMapModeAndStyle(this.f8723a, this.f8724b, this.f8725c, this.f8726d, this.f8727e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$e0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class e0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseMapOverlay f8729a;

        e0(BaseMapOverlay baseMapOverlay) {
            this.f8729a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p9 p9Var = p9.this;
            p9Var.Z.getOverlayBundle(p9Var.f8683n).removeOverlay(this.f8729a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8731a;

        f(int i4) {
            this.f8731a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.Z.clearAllMessages(this.f8731a);
                p9.this.Z.clearAnimations(this.f8731a, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$f0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class f0 implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f8733a;

        f0(List list) {
            this.f8733a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() throws Exception {
            return Integer.valueOf(p9.this.Z.hideBuildings(this.f8733a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$g */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8735a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8736b;

        g(int i4, boolean z3) {
            this.f8735a = i4;
            this.f8736b = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.Z.setBuildingEnable(this.f8735a, this.f8736b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$g0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class g0 extends t0 {
        g0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setTrafficStyleWithTextureData(this.f8788h);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$h */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8739a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8740b;

        h(boolean z3, int i4) {
            this.f8739a = z3;
            this.f8740b = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine = p9.this.Z;
            if (gLMapEngine != null) {
                if (this.f8739a) {
                    gLMapEngine.setAllContentEnable(this.f8740b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.f8740b, false);
                }
                p9.this.Z.setSimple3DEnable(this.f8740b, false);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$h0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class h0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8742a;

        h0(int i4) {
            this.f8742a = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p9.this.Z.showHideBuildings(this.f8742a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$i */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8744a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8745b;

        i(boolean z3, int i4) {
            this.f8744a = z3;
            this.f8745b = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f8744a) {
                    p9.this.Z.setBuildingTextureEnable(this.f8745b, true);
                } else {
                    p9.this.Z.setBuildingTextureEnable(this.f8745b, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$i0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class i0 extends t0 {
        i0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            p9.this.setMapCustomEnable(this.f8782b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$j */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LatLngBounds.Builder f8748a;

        j(LatLngBounds.Builder builder) {
            this.f8748a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.moveCamera(com.amap.api.col.p0003l.m.i(this.f8748a.build(), 50));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$j0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class j0 extends t0 {
        j0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            p9.this.k(this.f8785e, this.f8782b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$k */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            el f4;
            if (message == null || p9.this.f8685o.get()) {
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
                        sb.append(g4.f7810b);
                    }
                    sb.append("]");
                    Log.w("amapsdk", sb.toString());
                } else if (i4 != 30) {
                    int i5 = 0;
                    switch (i4) {
                        case 10:
                            CameraPosition cameraPosition = (CameraPosition) message.obj;
                            List<AMap.OnCameraChangeListener> a4 = p9.this.f8652b.a(AMap.OnCameraChangeListener.class.hashCode());
                            if (cameraPosition != null && a4 != null && a4.size() > 0) {
                                synchronized (a4) {
                                    for (AMap.OnCameraChangeListener onCameraChangeListener : a4) {
                                        onCameraChangeListener.onCameraChange(cameraPosition);
                                    }
                                }
                            }
                            p9.this.f8689q.addChangedCounter();
                            return;
                        case 11:
                            CameraPosition cameraPosition2 = p9.this.getCameraPosition();
                            if (cameraPosition2 != null && p9.this.f8677k != null) {
                                p9.this.f8677k.p(cameraPosition2);
                            }
                            p9.this.C(cameraPosition2);
                            if (p9.this.f8678k0) {
                                p9.V(p9.this);
                                if (p9.this.f8679l != null) {
                                    p9.this.f8679l.setFlingState(false);
                                }
                                p9.this.x();
                            }
                            if (p9.this.D) {
                                p9.this.redrawInfoWindow();
                                p9.f0(p9.this);
                            }
                            p9.this.n(cameraPosition2);
                            return;
                        case 12:
                            if (p9.this.f8677k != null) {
                                p9.this.f8677k.o(Float.valueOf(p9.this.getZoomLevel()));
                                return;
                            }
                            return;
                        case 13:
                            if (p9.this.f8677k != null) {
                                p9.this.f8677k.h();
                                return;
                            }
                            return;
                        case 14:
                            List<AMap.OnMapTouchListener> a5 = p9.this.f8652b.a(AMap.OnMapTouchListener.class.hashCode());
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
                            if (bitmap != null && p9.this.f8677k != null) {
                                Canvas canvas = new Canvas(bitmap);
                                if (p9.this.F && (f4 = p9.this.f8677k.f()) != null) {
                                    f4.onDraw(canvas);
                                }
                                p9.this.f8677k.j(canvas);
                                List a6 = p9.this.f8652b.a(AMap.onMapPrintScreenListener.class.hashCode());
                                ArrayList arrayList = a6 != null ? new ArrayList(a6) : null;
                                List a7 = p9.this.f8652b.a(AMap.OnMapScreenShotListener.class.hashCode());
                                ArrayList arrayList2 = a7 != null ? new ArrayList(a7) : null;
                                p9.this.f8652b.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                p9.this.f8652b.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList != null && arrayList.size() > 0) {
                                    synchronized (arrayList) {
                                        for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                            ((AMap.onMapPrintScreenListener) arrayList.get(i7)).onMapPrint(new BitmapDrawable(p9.this.Y.getResources(), bitmap));
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
                            List a8 = p9.this.f8652b.a(AMap.onMapPrintScreenListener.class.hashCode());
                            ArrayList arrayList3 = a8 != null ? new ArrayList(a8) : null;
                            List a9 = p9.this.f8652b.a(AMap.OnMapScreenShotListener.class.hashCode());
                            ArrayList arrayList4 = a9 != null ? new ArrayList(a9) : null;
                            p9.this.f8652b.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            p9.this.f8652b.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
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
                            List a10 = p9.this.f8652b.a(AMap.OnMapLoadedListener.class.hashCode());
                            if (a10 != null) {
                                synchronized (a10) {
                                    while (i5 < a10.size()) {
                                        ((AMap.OnMapLoadedListener) a10.get(i5)).onMapLoaded();
                                        i5++;
                                    }
                                }
                            }
                            if (p9.this.f8677k != null) {
                                p9.this.f8677k.i();
                                return;
                            }
                            return;
                        case 17:
                            p9 p9Var = p9.this;
                            if (!p9Var.Z.isInMapAnimation(p9Var.f8683n) || p9.this.f8679l == null) {
                                return;
                            }
                            p9.this.f8679l.setFlingState(false);
                            return;
                        case 18:
                            if (p9.this.f8658d != null) {
                                p9.this.f8658d.r();
                                return;
                            }
                            return;
                        case 19:
                            List<AMap.OnMapClickListener> a11 = p9.this.f8652b.a(AMap.OnMapClickListener.class.hashCode());
                            if (a11 != null) {
                                DPoint obtain = DPoint.obtain();
                                p9.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
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
                            List a12 = p9.this.f8652b.a(AMap.OnPOIClickListener.class.hashCode());
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
                    GLMapEngine gLMapEngine = p9.this.Z;
                    if (gLMapEngine != null) {
                        gLMapEngine.triggerMainThread();
                    }
                }
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$k0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class k0 extends t0 {
        k0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setMapTextEnable(this.f8782b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$l */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            p9 p9Var = p9.this;
            if (p9Var.Z == null || p9Var.f8685o.get()) {
                return;
            }
            p9 p9Var2 = p9.this;
            p9Var2.Z.removeNativeAllOverlay(p9Var2.f8683n);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$l0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class l0 extends t0 {
        l0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setRoadArrowEnable(this.f8782b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$m */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class m extends t0 {
        m() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9 p9Var = p9.this;
                p9Var.setCenterToPixel(p9Var.f8692r0, p9.this.f8694s0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$m0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class m0 extends t0 {
        m0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setNaviLabelEnable(this.f8782b, this.f8786f, this.f8787g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$n */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8757a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8758b;

        n(boolean z3, boolean z4) {
            this.f8757a = z3;
            this.f8758b = z4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (p9.this.f8689q.isTrafficEnabled() != this.f8757a) {
                    p9.this.f8689q.setTrafficEnabled(this.f8758b);
                    p9.this.f8650a0.setTrafficMode(this.f8757a);
                    p9 p9Var = p9.this;
                    p9Var.Z.setTrafficEnable(p9Var.f8683n, this.f8757a);
                    p9.this.resetRenderTime();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$n0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class n0 extends t0 {
        n0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setTrafficStyleWithTexture(this.f8788h, this.f8789i);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$o */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8761a;

        o(boolean z3) {
            this.f8761a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f8761a) {
                p9.this.showIndoorSwitchControlsEnabled(true);
            } else if (p9.this.f8677k != null) {
                p9.this.f8677k.k(Boolean.FALSE);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$o0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class o0 extends t0 {
        o0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            p9.this.z(this.f8785e, this.f8782b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$p */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8764a;

        p(boolean z3) {
            this.f8764a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p9 p9Var = p9.this;
            GLMapEngine gLMapEngine = p9Var.Z;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(p9Var.f8683n, this.f8764a);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$p0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class p0 extends t0 {
        p0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setIndoorEnabled(this.f8782b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$q */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8767a;

        q(boolean z3) {
            this.f8767a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.Z.setLabelEnable(p9Var.f8683n, this.f8767a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$q0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class q0 implements Runnable {
        q0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            el f4;
            if (p9.this.f8677k == null || (f4 = p9.this.f8677k.f()) == null) {
                return;
            }
            f4.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$r */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8770a;

        r(boolean z3) {
            this.f8770a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.Z.setRoadArrowEnable(p9Var.f8683n, this.f8770a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$r0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class r0 extends t0 {
        r0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            p9.this.H(this.f8785e, this.f8782b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$s */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8773a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8774b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8775c;

        s(boolean z3, int i4, int i5) {
            this.f8773a = z3;
            this.f8774b = i4;
            this.f8775c = i5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.Z.setNaviLabelEnable(p9Var.f8683n, this.f8773a, this.f8774b, this.f8775c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$s0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class s0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MotionEvent f8777a;

        s0(MotionEvent motionEvent) {
            this.f8777a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.Z.addGestureSingleTapMessage(this.f8777a.getX(), this.f8777a.getY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$t */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8779a;

        t(boolean z3) {
            this.f8779a = z3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9.this.Z.setMapOpenLayerEnable(this.f8779a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$u */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f8790a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyTrafficStyle f8791b;

        u(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f8790a = bArr;
            this.f8791b = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.Z.setTrafficStyleWithTexture(p9Var.f8683n, this.f8790a, this.f8791b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$u0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class u0 {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.p9$u0$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ef f8794a;

            a(ef efVar) {
                this.f8794a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f8794a.j(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.p9$u0$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ef f8796a;

            b(ef efVar) {
                this.f8796a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f8796a.k(p9.this.f8695t.floor_names);
                    this.f8796a.i(p9.this.f8695t.activeFloorName);
                    if (this.f8796a.o()) {
                        return;
                    }
                    this.f8796a.j(true);
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
            MapConfig mapConfig = p9.this.f8689q;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            ef e4 = p9.this.f8677k.e();
            if (xVar == null) {
                try {
                    List a6 = p9.this.f8652b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
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
                com.amap.api.col.p0003l.x xVar4 = p9.this.f8695t;
                if (xVar4 != null) {
                    xVar4.f9380g = null;
                }
                if (e4.o()) {
                    p9.this.f8708z0.post(new a(e4));
                }
                MapConfig mapConfig2 = p9.this.f8689q;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? p9.this.f8689q.getMaxZoomLevel() : 20.0f;
                try {
                    if (!p9.this.f8667g.isZoomControlsEnabled() || (a4 = p9.this.f8652b.a(AMapWidgetListener.class.hashCode())) == null || a4.size() <= 0) {
                        return;
                    }
                    synchronized (a4) {
                        for (int i5 = 0; i5 < a4.size(); i5++) {
                            ((AMapWidgetListener) a4.get(i5)).invalidateZoomController(p9.this.f8689q.getSZ());
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
            if (xVar == null || (xVar3 = p9.this.f8695t) == null || xVar3.activeFloorIndex == xVar.activeFloorIndex || !e4.o()) {
                if (xVar != null && ((xVar2 = p9.this.f8695t) == null || !xVar2.poiid.equals(xVar.poiid) || p9.this.f8695t.f9380g == null)) {
                    p9 p9Var = p9.this;
                    p9Var.f8695t = xVar;
                    if (p9Var.f8689q != null) {
                        if (xVar.f9380g == null) {
                            xVar.f9380g = new Point();
                        }
                        DPoint mapGeoCenter = p9.this.f8689q.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = p9.this.f8695t.f9380g;
                            point.x = (int) mapGeoCenter.f11671x;
                            point.y = (int) mapGeoCenter.f11672y;
                        }
                    }
                }
                try {
                    List a7 = p9.this.f8652b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a7 != null && a7.size() > 0) {
                        synchronized (a7) {
                            for (int i7 = 0; i7 < a7.size(); i7++) {
                                ((AMap.OnIndoorBuildingActiveListener) a7.get(i7)).OnIndoorBuilding(xVar);
                            }
                        }
                    }
                    MapConfig mapConfig3 = p9.this.f8689q;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? p9.this.f8689q.getMaxZoomLevel() : 20.0f;
                    if (p9.this.f8667g.isZoomControlsEnabled() && (a5 = p9.this.f8652b.a(AMapWidgetListener.class.hashCode())) != null && a5.size() > 0) {
                        synchronized (a5) {
                            for (int i8 = 0; i8 < a5.size(); i8++) {
                                ((AMapWidgetListener) a5.get(i8)).invalidateZoomController(p9.this.f8689q.getSZ());
                            }
                        }
                    }
                    if (p9.this.f8667g.isIndoorSwitchEnabled()) {
                        if (!e4.o()) {
                            p9.this.f8667g.setIndoorSwitchEnabled(true);
                        }
                        p9.this.f8708z0.post(new b(e4));
                    } else if (!p9.this.f8667g.isIndoorSwitchEnabled() && e4.o()) {
                        p9.this.f8667g.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$v */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class v extends t0 {
        v() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                p9.this.setConstructingRoadEnable(this.f8782b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$v0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class v0 implements ef.d {
        private v0() {
        }

        @Override // com.amap.api.col.p0003l.ef.d
        public final void a(int i4) {
            p9 p9Var = p9.this;
            com.amap.api.col.p0003l.x xVar = p9Var.f8695t;
            if (xVar != null) {
                xVar.activeFloorIndex = xVar.floor_indexs[i4];
                xVar.activeFloorName = xVar.floor_names[i4];
                try {
                    p9Var.setIndoorBuildingInfo(xVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        }

        /* synthetic */ v0(p9 p9Var, byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$w */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f8800a;

        w(byte[] bArr) {
            this.f8800a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.Z.setTrafficStyleWithTextureData(p9Var.f8683n, this.f8800a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$w0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class w0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f8802a;

        /* renamed from: b  reason: collision with root package name */
        private AMap.OnCacheRemoveListener f8803b;

        public w0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f8802a = context;
            this.f8803b = onCacheRemoveListener;
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
                android.content.Context r2 = r6.f8802a     // Catch: java.lang.Throwable -> L66
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
                com.amap.api.col.3l.p9 r2 = com.amap.api.col.p0003l.p9.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.p9.W(r2)     // Catch: java.lang.Throwable -> L66
                if (r2 == 0) goto L53
                com.amap.api.col.3l.p9 r2 = com.amap.api.col.p0003l.p9.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.p9.W(r2)     // Catch: java.lang.Throwable -> L66
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L66
            L53:
                com.amap.api.col.3l.p9 r0 = com.amap.api.col.p0003l.p9.this     // Catch: java.lang.Throwable -> L61
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.Z     // Catch: java.lang.Throwable -> L61
                if (r0 == 0) goto L60
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f8803b     // Catch: java.lang.Throwable -> L61
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
                com.amap.api.col.p0003l.u5.p(r2, r3, r4)     // Catch: java.lang.Throwable -> L84
                com.amap.api.col.3l.p9 r1 = com.amap.api.col.p0003l.p9.this     // Catch: java.lang.Throwable -> L7f
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.Z     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L7e
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f8803b     // Catch: java.lang.Throwable -> L7f
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
                com.amap.api.col.3l.p9 r2 = com.amap.api.col.p0003l.p9.this     // Catch: java.lang.Throwable -> L93
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.Z     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f8803b     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L93
                goto L97
            L93:
                r1 = move-exception
                r1.printStackTrace()
            L97:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p9.w0.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$x */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                p9 p9Var = p9.this;
                p9Var.f8689q.setAnchorX(Math.max(0, Math.min(p9Var.f8692r0, p9.this.f8659d0)));
                p9 p9Var2 = p9.this;
                p9Var2.f8689q.setAnchorY(Math.max(0, Math.min(p9Var2.f8694s0, p9.this.f8662e0)));
                p9 p9Var3 = p9.this;
                p9Var3.Z.setProjectionCenter(p9Var3.f8683n, p9.this.f8689q.getAnchorX(), p9.this.f8689q.getAnchorY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$y */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class y extends t0 {
        y() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0003l.p9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            p9.this.g(this.f8785e, this.f8783c, this.f8784d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$z */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            p9 p9Var = p9.this;
            GLMapEngine gLMapEngine = p9Var.Z;
            if (gLMapEngine != null) {
                int i4 = p9Var.f8683n;
                com.amap.api.col.p0003l.x xVar = p9.this.f8695t;
                gLMapEngine.setIndoorBuildingToBeActive(i4, xVar.activeFloorName, xVar.activeFloorIndex, xVar.poiid);
            }
        }
    }

    public p9(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    private void B(MotionEvent motionEvent) {
        if (!this.f8703x || this.f8707z == null) {
            return;
        }
        int x3 = (int) motionEvent.getX();
        int y3 = (int) (motionEvent.getY() - 60.0f);
        if (this.f8707z.getLatlng() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x3, y3, obtain);
            LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
            obtain.recycle();
            this.f8707z.setLatLng(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(CameraPosition cameraPosition) {
        if (this.f8689q.getMapLanguage().equals("en")) {
            boolean J = J(cameraPosition);
            if (J != this.G) {
                this.G = J;
                z(this.f8683n, J);
            }
        } else if (this.G) {
        } else {
            this.G = true;
            z(this.f8683n, true);
        }
    }

    private void D(boolean z3) {
        this.f8674i0 = z3;
    }

    private float E() {
        if (this.f8689q != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private void G(int i4) {
        if (this.f8676j0) {
            this.f8676j0 = false;
        }
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        T(i4);
    }

    private void I(MotionEvent motionEvent) {
        queueEvent(new s0(motionEvent));
    }

    private boolean J(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            try {
                return !t2.c(mapConfig.getGeoRectangle().getClipRect());
            } catch (Throwable th) {
                th.printStackTrace();
                a3.D(th);
                return false;
            }
        }
        return false;
    }

    private void K() {
        if (this.f8680l0) {
            this.f8653b0.b();
            this.f8656c0 = true;
            this.f8676j0 = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    private void L(int i4) {
        T(i4);
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    private boolean M(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> a4 = this.f8652b.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a4 != null && a4.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
                obtain.recycle();
                Polyline hitOverlay = this.f8679l.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a4) {
                        for (AMap.OnPolylineClickListener onPolylineClickListener : a4) {
                            onPolylineClickListener.onPolylineClick(hitOverlay);
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void O() {
        this.f8656c0 = true;
        this.f8676j0 = false;
        if (this.B) {
            this.B = false;
        }
        if (this.A) {
            this.A = false;
        }
        if (this.C) {
            this.C = false;
        }
        try {
            if (this.f8701w) {
                List a4 = this.f8652b.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a4 != null && a4.size() > 0 && this.f8705y != null) {
                    synchronized (a4) {
                        for (int i4 = 0; i4 < a4.size(); i4++) {
                            ((AMap.OnMarkerDragListener) a4.get(i4)).onMarkerDragEnd(this.f8705y);
                        }
                    }
                    this.f8705y = null;
                }
                this.f8701w = false;
            }
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.f8703x) {
            if (this.f8707z != null) {
                this.f8707z = null;
            }
            this.f8703x = false;
        }
    }

    private void P(int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            if (i4 == 0) {
                if (h3Var.b()) {
                    this.f8677k.l(Boolean.FALSE);
                    this.f8677k.c();
                }
            } else if (h3Var.b()) {
            } else {
                this.f8677k.l(Boolean.TRUE);
                this.f8677k.c();
            }
        }
    }

    private boolean Q(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
        obtain.recycle();
        boolean z3 = true;
        BaseOverlay hitBaseOverlay = this.f8679l.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.f8679l.set2Top(marker.getId());
                List<AMap.OnMarkerClickListener> a4 = this.f8652b.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a4 != null && a4.size() > 0) {
                    synchronized (a4) {
                        if (a4.size() == 1) {
                            boolean onMarkerClick = ((AMap.OnMarkerClickListener) a4.get(0)).onMarkerClick(marker);
                            if (onMarkerClick) {
                                return true;
                            }
                            z3 = onMarkerClick;
                        } else {
                            boolean z4 = false;
                            for (AMap.OnMarkerClickListener onMarkerClickListener : a4) {
                                z4 |= onMarkerClickListener.onMarkerClick(marker);
                            }
                            if (z4) {
                                return true;
                            }
                            z3 = z4;
                        }
                    }
                }
                this.f8679l.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(com.amap.api.col.p0003l.m.e(obtain2));
                }
                return z3;
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    private void S() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.f8683n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.f8689q.setSX(((Point) obtain).x);
        this.f8689q.setSY(((Point) obtain).y);
        this.f8689q.setSZ(gLMapState.getMapZoomer());
        this.f8689q.setSC(gLMapState.getCameraDegree());
        this.f8689q.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    private void T(int i4) {
        queueEvent(new f(i4));
    }

    private boolean U(MotionEvent motionEvent) {
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.f8679l.getHitBaseOverlay(latLng, 3);
        if (hitBaseOverlay instanceof GLTFOverlay) {
            GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
            if (gLTFOverlay.isClickable()) {
                try {
                    this.f8679l.set2Top(gLTFOverlay.getId());
                    gLTFOverlay.tapClick();
                    return true;
                } catch (Throwable th) {
                    u5.p(th, "AMapDelegateImp", "onGLTFTap");
                    th.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    static /* synthetic */ boolean V(p9 p9Var) {
        p9Var.f8678k0 = false;
        return false;
    }

    private LatLng X() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f8689q.getSY(), 20);
            LatLng latLng = new LatLng(pixelsToLatLong.f11672y, pixelsToLatLong.f11671x, false);
            pixelsToLatLong.recycle();
            return latLng;
        }
        return null;
    }

    private boolean Y(int i4) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i4, 7);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        if (this.f8679l != null && this.f8700v0 != null) {
            DPoint obtain = DPoint.obtain();
            if (this.Z != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.f8679l.getMultiPointItem(new LatLng(obtain.f11672y, obtain.f11671x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.f8700v0.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private synchronized void a0() {
        synchronized (this.T) {
            int size = this.T.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.T.get(i4).a().recycle();
            }
            this.T.clear();
        }
    }

    private int b(int i4, Rect rect, int i5, int i6) {
        int i7;
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null || i4 < 0) {
            i7 = 0;
        } else {
            i7 = gLMapEngine.getEngineIDWithType(i4);
            if (!this.Z.isEngineCreated(i7)) {
                int i8 = this.Y.getResources().getDisplayMetrics().densityDpi;
                float f4 = this.Y.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f4);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = i7;
                mapViewInitParam.f12051x = rect.left;
                mapViewInitParam.f12052y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i5;
                mapViewInitParam.screenHeight = i6;
                mapViewInitParam.screenScale = f4;
                mapViewInitParam.textScale = this.f8671h0 * f4;
                mapViewInitParam.mapZoomScale = this.f8668g0;
                mapViewInitParam.taskThreadCount = 3;
                this.Z.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.Z.getMapState(i7);
                mapState.setMapZoomer(this.f8689q.getSZ());
                mapState.setCameraDegree(this.f8689q.getSC());
                mapState.setMapAngle(this.f8689q.getSR());
                mapState.setMapGeoCenter(this.f8689q.getSX(), this.f8689q.getSY());
                this.Z.setMapState(i7, mapState);
                this.f8668g0 = mapState.calMapZoomScalefactor(i5, i6, i8);
                this.Z.setOvelayBundle(i7, new GLOverlayBundle<>(i7, this));
            } else {
                h(i7, rect.left, rect.top, rect.width(), rect.height(), i5, i6);
            }
        }
        this.f8685o.set(false);
        return i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:21:0x0027, B:23:0x0039, B:25:0x003d, B:27:0x0043, B:29:0x0053, B:34:0x0072, B:28:0x0049, B:30:0x0059, B:32:0x0067, B:33:0x006d, B:20:0x0024), top: B:39:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:21:0x0027, B:23:0x0039, B:25:0x003d, B:27:0x0043, B:29:0x0053, B:34:0x0072, B:28:0x0049, B:30:0x0059, B:32:0x0067, B:33:0x006d, B:20:0x0024), top: B:39:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b0(int r6) {
        /*
            r5 = this;
            r5.I = r6
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            if (r6 != r2) goto Lb
        L8:
            r6 = 0
        L9:
            r0 = 0
            goto L27
        Lb:
            if (r6 != r1) goto L10
            r6 = 0
            r0 = 1
            goto L27
        L10:
            if (r6 != r0) goto L14
            r6 = 1
            goto L9
        L14:
            r4 = 4
            if (r6 != r4) goto L1a
            r6 = 0
        L18:
            r0 = 2
            goto L27
        L1a:
            r4 = 6
            if (r6 != r4) goto L1f
            r6 = 1
            goto L18
        L1f:
            r1 = 5
            if (r6 != r1) goto L24
            r6 = 0
            goto L27
        L24:
            r5.I = r2     // Catch: java.lang.Throwable -> L76
            goto L8
        L27:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f8689q     // Catch: java.lang.Throwable -> L76
            r1.setMapStyleMode(r0)     // Catch: java.lang.Throwable -> L76
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f8689q     // Catch: java.lang.Throwable -> L76
            r1.setMapStyleTime(r6)     // Catch: java.lang.Throwable -> L76
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f8689q     // Catch: java.lang.Throwable -> L76
            boolean r1 = r1.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L59
            com.amap.api.col.3l.t8 r1 = r5.f8702w0     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L49
            boolean r1 = r1.p()     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L49
            com.amap.api.col.3l.t8 r6 = r5.f8702w0     // Catch: java.lang.Throwable -> L76
            r6.q()     // Catch: java.lang.Throwable -> L76
            goto L53
        L49:
            int r1 = r5.f8683n     // Catch: java.lang.Throwable -> L76
            r5.g(r1, r0, r6)     // Catch: java.lang.Throwable -> L76
            com.autonavi.base.amap.mapcore.MapConfig r6 = r5.f8689q     // Catch: java.lang.Throwable -> L76
            r6.setCustomStyleEnable(r3)     // Catch: java.lang.Throwable -> L76
        L53:
            com.amap.api.col.3l.h r6 = r5.f8667g     // Catch: java.lang.Throwable -> L76
            r6.setLogoEnable(r2)     // Catch: java.lang.Throwable -> L76
            goto L72
        L59:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f8689q     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = r1.getMapLanguage()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "en"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L6d
            java.lang.String r1 = "zh_cn"
            r5.setMapLanguage(r1)     // Catch: java.lang.Throwable -> L76
        L6d:
            int r1 = r5.f8683n     // Catch: java.lang.Throwable -> L76
            r5.g(r1, r0, r6)     // Catch: java.lang.Throwable -> L76
        L72:
            r5.resetRenderTime()     // Catch: java.lang.Throwable -> L76
            return
        L76:
            r6 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.p0003l.u5.p(r6, r0, r1)
            r6.printStackTrace()
            com.amap.api.col.p0003l.a3.D(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p9.b0(int):void");
    }

    private boolean c0(MotionEvent motionEvent) throws RemoteException {
        try {
            List a4 = this.f8652b.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay f4 = this.f8658d.f(motionEvent);
            if (f4 != null && (f4 instanceof Marker)) {
                synchronized (a4) {
                    for (int i4 = 0; i4 < a4.size(); i4++) {
                        ((AMap.OnInfoWindowClickListener) a4.get(i4)).onInfoWindowClick((Marker) f4);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void e(double d4, double d5) {
        this.f8708z0.post(new a(d4, d5));
    }

    private void e0() {
        if (this.E > 0) {
            boolean canStopMapRender = this.Z.canStopMapRender(this.f8683n);
            if (!canStopMapRender) {
                int i4 = this.E - 1;
                this.E = i4;
                if (i4 > 0) {
                    this.Z.renderAMap();
                    return;
                }
            }
            this.E = 0;
            Message obtainMessage = this.f8708z0.obtainMessage(15, this.Z.getScreenShot(this.f8683n, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
        }
    }

    private void f(int i4) {
        int i5 = this.S;
        if (i5 != -1) {
            this.f8650a0.setRenderFps(i5);
            resetRenderTime();
        } else if (!this.Z.isInMapAction(i4) && !this.f8676j0) {
            if (this.Z.isInMapAnimation(i4)) {
                this.f8650a0.setRenderFps(30.0f);
                this.f8650a0.resetTickCount(15);
            } else if (this.f8679l.isGLTFAnimated()) {
                this.f8650a0.setRenderFps(30.0f);
                this.f8650a0.resetTickCount(15);
            } else {
                this.f8650a0.setRenderFps(15.0f);
            }
        } else {
            this.f8650a0.setRenderFps(40.0f);
        }
        if (this.f8689q.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            x();
            this.f8689q.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    static /* synthetic */ boolean f0(p9 p9Var) {
        p9Var.D = false;
        return false;
    }

    private void h(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i4, i5, i6, i7, i8, i9, i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x011d, code lost:
        r1 = r10.f8652b.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0127, code lost:
        if (r1 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012d, code lost:
        if (r1.size() <= 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012f, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0130, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0135, code lost:
        if (r2 >= r1.size()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0137, code lost:
        ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r1.get(r2)).invalidateCompassView();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0143, code lost:
        monitor-exit(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h0() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p9.h0():void");
    }

    private synchronized void i(int i4, int i5, int i6, boolean z3, StyleItem[] styleItemArr) {
        if (this.f8682m0 && this.f8680l0 && this.f8670h) {
            P(i6);
            queueEvent(new e(i4, i5, i6, z3, styleItemArr));
            return;
        }
        t0 t0Var = this.C0;
        t0Var.f8785e = i4;
        t0Var.f8783c = i5;
        t0Var.f8784d = i6;
        t0Var.f8781a = true;
    }

    private void j(int i4, int i5, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f8685o.get() || !this.f8680l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f8683n)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i4, i5, fPoint);
    }

    private void j0() {
        if (!this.f8693s) {
            this.f8708z0.sendEmptyMessage(16);
            this.f8693s = true;
            x();
        }
        long j4 = this.X0;
        if (j4 < 2) {
            this.X0 = j4 + 1;
            return;
        }
        ed d4 = this.f8677k.d();
        if (d4 == null || d4.getVisibility() == 8) {
            return;
        }
        x2.g(this.Y, System.currentTimeMillis() - this.f8704x0);
        this.f8708z0.post(new c(d4));
        this.Z.setStyleChangeGradualEnable(this.f8683n, true);
    }

    private void l(MotionEvent motionEvent) throws RemoteException {
        if (!this.f8701w || this.f8705y == null) {
            return;
        }
        int x3 = (int) motionEvent.getX();
        int y3 = (int) (motionEvent.getY() - 60.0f);
        if (this.f8705y.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x3, y3, obtain);
            LatLng latLng = new LatLng(obtain.f11672y, obtain.f11671x);
            obtain.recycle();
            this.f8705y.setPosition(latLng);
            try {
                List a4 = this.f8652b.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a4 == null || a4.size() <= 0) {
                    return;
                }
                synchronized (a4) {
                    for (int i4 = 0; i4 < a4.size(); i4++) {
                        ((AMap.OnMarkerDragListener) a4.get(i4)).onMarkerDrag(this.f8705y);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void l0() {
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void n0() {
        GLMapRender gLMapRender;
        if (!this.f8680l0 || (gLMapRender = this.f8650a0) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    private void o(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z3 = this.f8691r;
        abstractCameraUpdateMessage.isUseAnchor = z3;
        if (z3) {
            abstractCameraUpdateMessage.anchorX = this.f8689q.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f8689q.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f8689q;
    }

    private void o0() {
        if (this.N) {
            return;
        }
        try {
            this.K.setName("AuthThread");
            this.K.start();
            this.N = true;
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    private void p(GLMapState gLMapState, int i4, int i5, DPoint dPoint) {
        if (!this.f8680l0 || this.Z == null) {
            return;
        }
        Point point = new Point();
        gLMapState.screenToP20Point(i4, i5, point);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(point.x, point.y, 20);
        dPoint.f11671x = pixelsToLatLong.f11671x;
        dPoint.f11672y = pixelsToLatLong.f11672y;
        pixelsToLatLong.recycle();
    }

    private void q(boolean z3) {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            Object j4 = bVar.j();
            if (j4 != null && (j4 instanceof Boolean)) {
                MapConfig mapConfig = this.f8689q;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z3 && ((Boolean) j4).booleanValue());
                }
                if (z3 && ((Boolean) j4).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object j5 = this.P0.j();
            if (j5 != null && (j5 instanceof Boolean)) {
                this.f8677k.a(((Boolean) j5).booleanValue());
            }
            Object j6 = this.P0.j();
            if (j5 == null || !(j5 instanceof Integer)) {
                return;
            }
            this.P = ((Integer) j6).intValue();
        }
    }

    private void q0() {
        if (this.O) {
            return;
        }
        try {
            if (this.f8648L == null) {
                this.f8648L = new aa(this.Y, this);
            }
            this.f8648L.setName("AuthProThread");
            this.f8648L.start();
            this.O = true;
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    private void r(boolean z3, byte[] bArr, boolean z4) {
        e2 e2Var;
        try {
            this.f8689q.setCustomStyleEnable(z3);
            boolean z5 = false;
            if (this.f8689q.isHideLogoEnable()) {
                this.f8667g.setLogoEnable(!z3);
            }
            if (z3) {
                H(this.f8683n, true);
                c2 c2Var = new c2();
                MyTrafficStyle myTrafficStyle = this.J;
                if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                    c2Var.i(this.J.getTrafficRoadBackgroundColor());
                }
                if (this.f8689q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f8689q.getCustomTextureResourcePath())) {
                    z5 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    e2Var = c2Var.e(bArr, z5);
                    if (e2Var != null && (styleItemArr = e2Var.c()) != null) {
                        this.f8689q.setUseProFunction(true);
                    }
                } else {
                    e2Var = null;
                }
                if (styleItemArr == null && (e2Var = c2Var.d(this.f8689q.getCustomStylePath(), z5)) != null) {
                    styleItemArr = e2Var.c();
                }
                if (c2Var.a() != 0) {
                    this.f8689q.setCustomBackgroundColor(c2Var.a());
                }
                if (e2Var != null && e2Var.d() != null) {
                    if (this.V != null) {
                        this.V.d((String) e2Var.d());
                        this.V.c(e2Var);
                        this.V.b();
                        return;
                    }
                    return;
                }
                s(styleItemArr, z4);
                return;
            }
            H(this.f8683n, false);
            g(this.f8683n, this.f8689q.getMapStyleMode(), this.f8689q.getMapStyleTime());
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    private void s(StyleItem[] styleItemArr, boolean z3) {
        if (z3 || (styleItemArr != null && styleItemArr.length > 0)) {
            i(this.f8683n, 0, 0, true, styleItemArr);
            x2.j(this.Y, true);
            return;
        }
        x2.j(this.Y, false);
    }

    private boolean t(int i4, int i5) {
        AbstractCameraUpdateMessage d4;
        if (this.f8680l0 && ((int) E()) < this.f8689q.getMaxZoomLevel()) {
            try {
                if (!this.f8691r && !this.f8667g.isZoomInByScreenCenter()) {
                    Point point = this.W0;
                    point.x = i4;
                    point.y = i5;
                    d4 = com.amap.api.col.p0003l.m.d(1.0f, point);
                } else {
                    d4 = com.amap.api.col.p0003l.m.d(1.0f, null);
                }
                animateCamera(d4);
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
            return true;
        }
        return false;
    }

    private void t0() {
        try {
            LatLngBounds limitLatLngBounds = this.f8689q.getLimitLatLngBounds();
            if (this.Z != null && u(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.f8683n, this.Z.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.f8689q.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8689q.setLimitIPoints(null);
    }

    private static boolean u(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private boolean v(boolean z3, boolean z4) {
        if (z3) {
            if (this.T0) {
                h2.c("setCustomMapStyle \u548c setWorldVectorMapStyle \u4e0d\u80fd\u540c\u65f6\u4f7f\u7528\uff0csetCustomMapStyle\u5c06\u4e0d\u4f1a\u751f\u6548");
                return true;
            }
            this.S0 = true;
        }
        if (z4) {
            if (this.S0) {
                h2.c("setCustomMapStyle \u548c setWorldVectorMapStyle \u4e0d\u80fd\u540c\u65f6\u4f7f\u7528\uff0csetWorldVectorMapStyle\u5c06\u4e0d\u4f1a\u751f\u6548");
                return true;
            }
            this.T0 = true;
            return false;
        }
        return false;
    }

    private void v0() {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.b();
        }
    }

    private void x0() {
        u1 u1Var = this.f8698u0;
        if (u1Var != null) {
            u1Var.a();
            this.f8698u0 = null;
        }
    }

    private void y(int i4) {
        queueEvent(new d(i4));
    }

    public final void A(Size size) {
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.f8677k.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        D(true);
    }

    public final void H(int i4, boolean z3) {
        if (this.f8680l0 && this.f8682m0) {
            resetRenderTime();
            queueEvent(new i(z3, i4));
            return;
        }
        t0 t0Var = this.O0;
        t0Var.f8782b = z3;
        t0Var.f8781a = true;
        t0Var.f8785e = i4;
    }

    @Override // com.amap.api.col.p0003l.t8.a
    public final void a() {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z3) {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f8679l.createId("AMAP3DMODELTILE");
            AMap3DModelTileOverlay aMap3DModelTileOverlay = new AMap3DModelTileOverlay(this.f8679l, aMap3DModelTileOverlayOptions, createId);
            this.f8679l.addOverlayObject(createId, aMap3DModelTileOverlay, aMap3DModelTileOverlayOptions);
            return aMap3DModelTileOverlay;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m18clone = arcOptions.m18clone();
            String createId = this.f8679l.createId("ARC");
            Arc arc = new Arc(this.f8679l, m18clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m18clone) : arc;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            x2.u(this.Y);
            String createId = this.f8679l.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.f8679l, createId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e4) {
            e4.printStackTrace();
            a3.D(e4);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions m20clone = circleOptions.m20clone();
            String createId = this.f8679l.createId("CIRCLE");
            Circle circle = new Circle(this.f8679l, m20clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m20clone) : circle;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final l3 addContourLineOverlay(eo eoVar) {
        try {
            String createId = this.f8679l.createId("CONTOURLINE");
            l3 l3Var = new l3(this.f8679l, eoVar, createId);
            this.f8679l.addOverlayObject(createId, l3Var, eoVar);
            return l3Var;
        } catch (Exception e4) {
            a3.D(e4);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.f8683n, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new c0(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.f8679l.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.f8679l, gL3DModelOptions, createId);
        this.f8679l.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        try {
            if (ga.a().d() && !ga.a().c("feature_gltf")) {
                a3.D(new AMapException("GLTF\u529f\u80fd\u4e0d\u652f\u6301"));
                return null;
            }
            resetRenderTime();
            GLTFOverlayOptions m21clone = gLTFOverlayOptions.m21clone();
            String createId = this.f8679l.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.f8679l, m21clone, createId);
            this.f8679l.addOverlayObject(createId, gLTFOverlay, m21clone);
            return gLTFOverlay;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i4, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.f8680l0 || this.Z == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.f8691r;
            abstractGestureMapMessage.anchorX = this.f8689q.getAnchorX();
            abstractGestureMapMessage.anchorY = this.f8689q.getAnchorY();
            this.Z.addGestureMessage(i4, abstractGestureMapMessage, this.f8667g.isGestureScaleByMapCenter(), this.f8689q.getAnchorX(), this.f8689q.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions m22clone = groundOverlayOptions.m22clone();
            String createId = this.f8679l.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.f8679l, m22clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m22clone) : groundOverlay;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String createId = this.f8679l.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.f8679l.addOverlayObject(createId, new HeatMapGridLayer(this.f8679l, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.f8679l.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.f8679l.addOverlayObject(createId, new HeatMapLayer(this.f8679l, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            if (ga.a().d() && !ga.a().c("feature_mvt")) {
                a3.D(new AMapException("MVT\u529f\u80fd\u4e0d\u652f\u6301"));
                return null;
            }
            String createId = this.f8679l.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.f8679l, mVTTileOverlayOptions, createId);
            this.f8679l.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m24clone = markerOptions.m24clone();
            String createId = this.f8679l.createId("MARKER");
            Marker marker = new Marker(this.f8679l, m24clone, createId);
            this.f8679l.addOverlayObject(createId, marker, m24clone);
            return marker;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7207d;
            c3.f(str, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z3) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                MarkerOptions markerOptions = arrayList.get(i4);
                if (arrayList.get(i4) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z3 && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new j(builder), 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7207d;
            c3.i(str, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions m25clone = multiPointOverlayOptions.m25clone();
            String createId = this.f8679l.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.f8679l, m25clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m25clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        RouteOverlayInner routeOverlayInner = new RouteOverlayInner(this.f8683n, getContext(), this);
        queueEvent(new d0(routeOverlayInner));
        return new RouteOverlay(routeOverlayInner);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m26clone = navigateArrowOptions.m26clone();
            String createId = this.f8679l.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.f8679l, m26clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m26clone) : navigateArrow;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i4, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i4)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.Z.addOverlayTexture(i4, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            x2.n(this.Y);
            String createId = this.f8679l.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.f8679l.addOverlayObject(createId, new ParticleOverlay(this.f8679l, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            a3.D(th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions m27clone = polygonOptions.m27clone();
            String createId = this.f8679l.createId("POLYGON");
            Polygon polygon = new Polygon(this.f8679l, m27clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m27clone) : polygon;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7207d;
            c3.g(str, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.f8679l.createId("POLYLINE");
            Polyline polyline = (Polyline) this.f8679l.addOverlayObject(createId, new Polyline(this.f8679l, polylineOptions, createId), polylineOptions);
            c3.m(b3.f7207d, "addPolyline ".concat(String.valueOf(createId)));
            return polyline;
        } catch (Throwable th) {
            a3.D(th);
            String str = b3.f7207d;
            c3.h(str, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.e(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f8679l.createId("TEXT");
            TextOptions m28clone = textOptions.m28clone();
            MarkerOptions b4 = s1.b(m28clone);
            Marker marker = new Marker(this.f8679l, b4, createId);
            marker.setObject(m28clone.getObject());
            this.f8679l.addOverlayObject(createId, marker, b4);
            return new Text(marker, m28clone);
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                x2.c(this.Y);
            }
            String createId = this.f8679l.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.f8679l, tileOverlayOptions, createId);
            this.f8679l.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i4, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.Z;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i4) || this.Z.isInMapAnimation(i4)))) {
            int i5 = this.S;
            if (i5 != -1) {
                this.f8650a0.setRenderFps(i5);
            } else {
                this.f8650a0.setRenderFps(15.0f);
            }
            if (this.f8665f0 != mapZoomer) {
                this.f8665f0 = mapZoomer;
            }
        }
        if (this.f8686o0) {
            return;
        }
        this.f8686o0 = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i4, GLMapState gLMapState) {
        h0();
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.U0 = this.f8679l.draw(1, this.P, this.f8706y0) ? this.U0 : this.U0 + 1;
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i4, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f8679l.draw(2, this.P, this.f8706y0);
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.Q;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j4, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j4, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i4, GLMapState gLMapState) {
        h0();
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.U0 = this.f8679l.draw(0, this.P, this.f8706y0) ? this.U0 : this.U0 + 1;
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final Size c(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.f8677k.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        D(false);
        return size2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i4, int i5, int i6, int i7, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i4 == i5 && i5 == i6 && i6 == i7 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng != null && latLng2 != null && this.f8680l0 && !this.f8685o.get()) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(this.f8683n, this.Z.getNativeInstance());
            Pair<Float, IPoint> r3 = a3.r(mapConfig, i4, i5, i6, i7, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            if (r3 != null) {
                DPoint obtain = DPoint.obtain();
                Object obj = r3.second;
                GLMapState.geo2LonLat(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y, obtain);
                Pair<Float, LatLng> pair = new Pair<>(r3.first, new LatLng(obtain.f11672y, obtain.f11671x));
                obtain.recycle();
                return pair;
            }
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain2.f11672y, obtain2.f11671x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        com.amap.api.col.p0003l.x xVar;
        if (getZoomLevel() < 17.0f || (xVar = this.f8695t) == null || xVar.f9380g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.f8695t.f9380g;
        j(point.x, point.y, obtain);
        return this.H.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(this.f8683n);
            return true;
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.f8679l.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(String str, boolean z3, int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.n(str, Boolean.valueOf(z3), Integer.valueOf(i4));
        }
        com.amap.api.col.p0003l.h hVar = this.f8667g;
        if (hVar != null) {
            hVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i4, boolean z3) {
        if (this.f8685o.get()) {
            return;
        }
        try {
            List a4 = this.f8652b.a(AMapWidgetListener.class.hashCode());
            if (a4 == null || a4.size() <= 0) {
                return;
            }
            this.f8677k.l(Boolean.valueOf(!z3));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i4, int i5) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            this.f8659d0 = i4;
            this.f8662e0 = i5;
            mapConfig.setMapWidth(i4);
            this.f8689q.setMapHeight(i5);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i4, GL10 gl10, int i5, int i6) {
        WindowManager windowManager;
        String str = b3.f7206c;
        c3.e(str, "changeSurface " + i5 + " " + i6);
        this.f8686o0 = false;
        if (!this.f8680l0) {
            createSurface(i4, gl10, null);
        }
        ha haVar = this.f8653b0;
        if (haVar != null && this.Y != null && ((this.f8659d0 != haVar.g() || this.f8662e0 != this.f8653b0.j()) && (windowManager = (WindowManager) this.Y.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f8653b0.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.f8659d0 = i5;
        this.f8662e0 = i6;
        this.H = new Rect(0, 0, i5, i6);
        this.f8683n = b(i4, new Rect(0, 0, this.f8659d0, this.f8662e0), this.f8659d0, this.f8662e0);
        c3.e(b3.f7206c, "create engine with frame complete");
        if (!this.f8682m0) {
            MapConfig mapConfig = this.f8689q;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.f8668g0);
                this.f8689q.setMapWidth(i5);
                this.f8689q.setMapHeight(i6);
            }
            this.Z.setIndoorEnable(this.f8683n, false);
            this.Z.setSimple3DEnable(this.f8683n, false);
            this.Z.setStyleChangeGradualEnable(this.f8683n, false);
            this.Z.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.Y, initParam);
            this.Z.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.f8682m0 = true;
        }
        if (!this.f8691r) {
            this.f8689q.setAnchorX(i5 >> 1);
            this.f8689q.setAnchorY(i6 >> 1);
        } else {
            this.f8689q.setAnchorX(Math.max(1, Math.min(this.f8692r0, i5 - 1)));
            this.f8689q.setAnchorY(Math.max(1, Math.min(this.f8694s0, i6 - 1)));
        }
        this.Z.setProjectionCenter(this.f8683n, this.f8689q.getAnchorX(), this.f8689q.getAnchorY());
        this.f8670h = true;
        t0 t0Var = this.L0;
        if (t0Var.f8781a) {
            t0Var.run();
        }
        t0 t0Var2 = this.C0;
        if (t0Var2.f8781a) {
            t0Var2.run();
        }
        t0 t0Var3 = this.D0;
        if (t0Var3.f8781a) {
            t0Var3.run();
        }
        t0 t0Var4 = this.A0;
        if (t0Var4.f8781a) {
            t0Var4.run();
        }
        t0 t0Var5 = this.E0;
        if (t0Var5.f8781a) {
            t0Var5.run();
        }
        t0 t0Var6 = this.O0;
        if (t0Var6.f8781a) {
            t0Var6.run();
        }
        t0 t0Var7 = this.F0;
        if (t0Var7.f8781a) {
            t0Var7.run();
        }
        t0 t0Var8 = this.G0;
        if (t0Var8.f8781a) {
            t0Var8.run();
        }
        t0 t0Var9 = this.H0;
        if (t0Var9.f8781a) {
            t0Var9.run();
        }
        t0 t0Var10 = this.M0;
        if (t0Var10.f8781a) {
            t0Var10.run();
        }
        t0 t0Var11 = this.B0;
        if (t0Var11.f8781a) {
            t0Var11.run();
        }
        t0 t0Var12 = this.I0;
        if (t0Var12.f8781a) {
            t0Var12.run();
        }
        t0 t0Var13 = this.J0;
        if (t0Var13 != null) {
            t0Var13.run();
        }
        t0 t0Var14 = this.K0;
        if (t0Var14 != null) {
            t0Var14.run();
        }
        CustomRenderer customRenderer = this.Q;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i5, i6);
        }
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.f8708z0;
        if (handler != null) {
            handler.post(this.N0);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.f8689q == null || this.f8685o.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.f8689q.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds != null) {
                IPoint[] limitIPoints = this.f8689q.getLimitIPoints();
                if (limitIPoints == null) {
                    IPoint obtain = IPoint.obtain();
                    LatLng latLng = limitLatLngBounds.northeast;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                    IPoint obtain2 = IPoint.obtain();
                    LatLng latLng2 = limitLatLngBounds.southwest;
                    GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                    IPoint[] iPointArr = {obtain, obtain2};
                    this.f8689q.setLimitIPoints(iPointArr);
                    limitIPoints = iPointArr;
                }
                float j4 = a3.j(this.f8689q, ((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, getMapWidth(), getMapHeight());
                float mapZoomer = iGLMapState.getMapZoomer();
                if (this.f8689q.isSetLimitZoomLevel()) {
                    float maxZoomLevel = this.f8689q.getMaxZoomLevel();
                    float minZoomLevel = this.f8689q.getMinZoomLevel();
                    float max = Math.max(j4, Math.min(mapZoomer, maxZoomLevel));
                    if (j4 <= maxZoomLevel) {
                        maxZoomLevel = max;
                    }
                    j4 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                } else if (j4 <= 0.0f || mapZoomer >= j4) {
                    j4 = mapZoomer;
                }
                iGLMapState.setMapZoomer(j4);
                IPoint obtain3 = IPoint.obtain();
                iGLMapState.getMapGeoCenter(obtain3);
                int[] U = a3.U(((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, this.f8689q, iGLMapState, ((Point) obtain3).x, ((Point) obtain3).y);
                iGLMapState.setMapGeoCenter(U[0], U[1]);
                obtain3.recycle();
            } else if (this.f8689q.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.f8689q.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f8689q.getMaxZoomLevel())));
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f4) throws RemoteException {
        return a3.h(this.f8689q, f4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "clear");
            a3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.f8679l.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i4) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.f8683n, i4);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.f8679l;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int createOverlayTexture(int i4, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i4, bitmap);
        } catch (Throwable th) {
            a3.D(th);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f A[Catch: all -> 0x008e, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0017, B:10:0x002e, B:18:0x00c7, B:20:0x00d7, B:21:0x00da, B:23:0x00e0, B:25:0x00e4, B:26:0x00f2, B:28:0x00f6, B:29:0x00f9, B:31:0x00fd, B:32:0x0100, B:9:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:38:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7 A[Catch: all -> 0x0107, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0017, B:10:0x002e, B:18:0x00c7, B:20:0x00d7, B:21:0x00da, B:23:0x00e0, B:25:0x00e4, B:26:0x00f2, B:28:0x00f6, B:29:0x00f9, B:31:0x00fd, B:32:0x0100, B:9:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:38:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6 A[Catch: all -> 0x0107, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0017, B:10:0x002e, B:18:0x00c7, B:20:0x00d7, B:21:0x00da, B:23:0x00e0, B:25:0x00e4, B:26:0x00f2, B:28:0x00f6, B:29:0x00f9, B:31:0x00fd, B:32:0x0100, B:9:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:38:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd A[Catch: all -> 0x0107, TryCatch #2 {, blocks: (B:3:0x0001, B:8:0x0017, B:10:0x002e, B:18:0x00c7, B:20:0x00d7, B:21:0x00da, B:23:0x00e0, B:25:0x00e4, B:26:0x00f2, B:28:0x00f6, B:29:0x00f9, B:31:0x00fd, B:32:0x0100, B:9:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:38:0x0001 }] */
    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void createSurface(int r4, javax.microedition.khronos.opengles.GL10 r5, javax.microedition.khronos.egl.EGLConfig r6) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.p9.createSurface(int, javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.f8685o.set(true);
        c3.e(b3.f7206c, "destroy map");
        try {
            LocationSource locationSource = this.f8699v;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.f8699v = null;
            this.f8696t0 = null;
            GLMapRender gLMapRender = this.f8650a0;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            a0();
            Thread thread = this.K;
            if (thread != null) {
                thread.interrupt();
                this.K = null;
            }
            Thread thread2 = this.f8648L;
            if (thread2 != null) {
                thread2.interrupt();
                this.f8648L = null;
            }
            ea eaVar = this.M;
            if (eaVar != null) {
                eaVar.c();
                this.M = null;
            }
            w1 w1Var = this.U;
            if (w1Var != null) {
                w1Var.a();
                this.U = null;
            }
            y1 y1Var = this.V;
            if (y1Var != null) {
                y1Var.b(null);
                this.V.a();
                this.V = null;
            }
            o2.f();
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                queueEvent(new b0());
                int i4 = 0;
                while (this.Z != null) {
                    int i5 = i4 + 1;
                    if (i4 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e4) {
                        a3.D(e4);
                    }
                    i4 = i5;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.f8675j;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    a3.D(e5);
                }
            }
            h3 h3Var = this.f8677k;
            if (h3Var != null) {
                h3Var.g();
                this.f8677k = null;
            }
            p1 p1Var = this.f8697u;
            if (p1Var != null) {
                p1Var.n();
                this.f8697u = null;
            }
            this.f8699v = null;
            this.f8649a = null;
            v0();
            this.J = null;
            c3.a();
            u5.m();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "destroy");
            a3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i4) {
        this.f8688p0.lock();
        try {
            if (this.f8680l0) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                x0();
                GLMapEngine gLMapEngine = this.Z;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.f8683n) != null) {
                        this.Z.getOverlayBundle(this.f8683n).removeAll(true);
                    }
                    this.Z.destroyAMapEngine();
                    this.Z = null;
                    int i5 = this.U0;
                    if (i5 > 0) {
                        x2.d(this.Y, i5);
                    }
                    c3.e(b3.f7206c, "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.P0;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.f8680l0 = false;
            this.f8682m0 = false;
            this.f8686o0 = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        if (this.f8685o.get() || this.Z == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        f(this.f8683n);
        this.Z.renderAMap();
        this.Z.pushRendererState();
        this.f8708z0.sendEmptyMessage(30);
        t8 t8Var = this.f8702w0;
        if (t8Var != null) {
            t8Var.a();
        }
        e0();
        j0();
        if (!this.f8684n0) {
            this.f8684n0 = true;
        }
        this.Z.popRendererState();
        if (r2.b()) {
            try {
                if (this.f8675j instanceof com.amap.api.col.p0003l.o) {
                    if (this.W == null) {
                        this.W = new r2();
                    }
                    this.W.i();
                    if (!this.W.j() || this.W.h()) {
                        return;
                    }
                    if (this.W.c(((com.amap.api.col.p0003l.o) this.f8675j).getBitmap())) {
                        if (r2.e()) {
                            removecache();
                        }
                        if (r2.g()) {
                            r2.k();
                        }
                        c3.l(b3.f7210g, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    public final synchronized void g(int i4, int i5, int i6) {
        i(i4, i5, i6, false, null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i4, int i5, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i4, i5, 20);
        dPoint.f11671x = pixelsToLatLong.f11671x;
        dPoint.f11672y = pixelsToLatLong.f11672y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i4, int i5, FPoint fPoint) {
        double d4;
        double d5;
        double sx = this.f8689q.getSX();
        Double.isNaN(i4);
        ((PointF) fPoint).x = (int) (d4 - sx);
        double sy = this.f8689q.getSY();
        Double.isNaN(i5);
        ((PointF) fPoint).y = (int) (d5 - sy);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.P0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f8664f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f8661e == null) {
            this.f8661e = new UiSettings(this.f8667g);
        }
        return this.f8661e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.f8683n);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i4) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.f8691r);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final CameraPosition getCameraPositionPrj(boolean z3) {
        LatLng X;
        try {
            if (this.f8689q == null) {
                return null;
            }
            if (this.f8680l0 && !this.f8687p && this.Z != null) {
                if (z3) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng(this.f8689q.getAnchorX(), this.f8689q.getAnchorY(), obtain);
                    X = new LatLng(obtain.f11672y, obtain.f11671x, false);
                    obtain.recycle();
                } else {
                    X = X();
                }
                return CameraPosition.builder().target(X).bearing(this.f8689q.getSR()).tilt(this.f8689q.getSC()).zoom(this.f8689q.getSZ()).build();
            }
            DPoint obtain2 = DPoint.obtain();
            geo2Latlng((int) this.f8689q.getSX(), (int) this.f8689q.getSY(), obtain2);
            LatLng latLng = new LatLng(obtain2.f11672y, obtain2.f11671x);
            obtain2.recycle();
            return CameraPosition.builder().target(latLng).bearing(this.f8689q.getSR()).tilt(this.f8689q.getSC()).zoom(this.f8689q.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Context getContext() {
        return this.Y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.P0;
            if (bVar != null) {
                Object j4 = bVar.j();
                return j4 instanceof String ? (String) j4 : "";
            }
            return "";
        } catch (Throwable th) {
            a3.D(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final t8 getCustomStyleManager() {
        return this.f8702w0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return this.f8683n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.f8651a1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapEngine getGLMapEngine() {
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final View getGLMapView() {
        IGLSurfaceView iGLSurfaceView = this.f8675j;
        if (iGLSurfaceView instanceof View) {
            return (View) iGLSurfaceView;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i4, IPoint iPoint) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.f8689q.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.f8679l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.f8683n);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.col.p0003l.z getInfoWindowDelegate() {
        return this.f8658d;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d4, double d5, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d4, d5, obtain);
        geo2Map(((Point) obtain).x, ((Point) obtain).y, fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d4, double d5, IPoint iPoint) {
        if (this.f8685o.get() || !this.f8680l0 || this.Z == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d4, d5, 20);
            FPoint obtain = FPoint.obtain();
            j(latLongToPixels.x, latLongToPixels.y, obtain);
            if (((PointF) obtain).x == -10000.0f && ((PointF) obtain).y == -10000.0f) {
                GLMapState gLMapState = (GLMapState) this.Z.getNewMapState(this.f8683n);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) obtain).x;
            ((Point) iPoint).y = (int) ((PointF) obtain).y;
            obtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.f8689q.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i4 = 0; i4 < 4; i4++) {
                    GLMapState.geo2LonLat(((Point) clipRect[i4]).x, ((Point) clipRect[i4]).y, dPointArr[i4]);
                }
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            return h3Var.a(i4);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.f8667g.getLogoPosition();
        } catch (RemoteException e4) {
            u5.p(e4, "AMapDelegateImp", "getLogoPosition");
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.f8708z0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i4) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final LatLngBounds getMapBounds(LatLng latLng, float f4, float f5, float f6) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.f8685o.get()) {
            return null;
        }
        float h4 = a3.h(this.f8689q, f4);
        GLMapState gLMapState = new GLMapState(this.f8683n, this.Z.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f6);
            gLMapState.setMapAngle(f5);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
            gLMapState.setMapZoomer(h4);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        p(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.f11672y, obtain2.f11671x, false);
        p(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f11672y, obtain2.f11671x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final MapConfig getMapConfig() {
        return this.f8689q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        x2.q(this.Y);
        String b4 = q2.b(this.Y, "approval_number", "mc", "");
        return !TextUtils.isEmpty(b4) ? b4 : "GS (2023)551\u53f7 | GS (2023)2175\u53f7";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.f8662e0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f8652b.e(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), onmapprintscreenlistener);
            this.E = 20;
            this.F = true;
            resetRenderTime();
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.f8683n);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!a3.I(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        if (this.f8685o.get()) {
            return new ArrayList();
        }
        return this.f8679l.getMapScreenMarkers();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z3) {
        try {
            this.f8652b.e(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), onMapScreenShotListener);
            this.E = 20;
            this.F = z3;
            resetRenderTime();
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.P;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.f8659d0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.f8668g0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.R;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f8689q;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            a3.D(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f8689q;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            a3.D(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.f8699v != null) {
            return this.f8649a.f9555b;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        p1 p1Var = this.f8697u;
        if (p1Var != null) {
            return p1Var.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.f8683n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.f8683n);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a4 = this.f8652b.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a4 == null && a4.size() != 0) {
                return (AMap.OnCameraChangeListener) a4.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i4, int i5, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f8685o.get() || !this.f8680l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f8683n)) == null) {
            return;
        }
        mapState.screenToP20Point(i4, i5, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i4, int i5, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f8685o.get() || !this.f8680l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f8683n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i4, i5, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) obtain).x, ((Point) obtain).y, 20);
        dPoint.f11671x = pixelsToLatLong.f11671x;
        dPoint.f11672y = pixelsToLatLong.f11672y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i4) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f8664f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.f8657c1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Rect getRect() {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.f8675j.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        x2.r(this.Y);
        String b4 = q2.b(this.Y, "approval_number", "si", "");
        return !TextUtils.isEmpty(b4) ? b4 : "GS (2023)4047\u53f7";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "getScalePerPixel");
            a3.D(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.f8689q.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getTerrainApprovalNumber() {
        x2.s(this.Y);
        String b4 = q2.b(this.Y, "approval_number", "te", "");
        return !TextUtils.isEmpty(b4) ? b4 : "GS(2021)6352\u53f7";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IUiSettingsDelegate getUiSettings() {
        return this.f8667g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i4) {
        GLMapState gLMapState = new GLMapState(this.f8683n, this.Z.getNativeInstance());
        gLMapState.setMapZoomer(i4);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            return h3Var.j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.f8654b1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Point getWaterMarkerPositon() {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            return h3Var.a();
        }
        return new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapLanguage() {
        return this.Q0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapStyle() {
        return this.R0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return E();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng != null && latLng2 != null && this.f8680l0 && !this.f8685o.get()) {
                Pair<Float, IPoint> r3 = a3.r(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
                if (r3 != null) {
                    return ((Float) r3.first).floatValue();
                }
                GLMapState gLMapState = new GLMapState(this.f8683n, this.Z.getNativeInstance());
                float mapZoomer = gLMapState.getMapZoomer();
                gLMapState.recycle();
                return mapZoomer;
            }
            return mapConfig.getSZ();
        } catch (Throwable th) {
            a3.D(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int hideBuildings(List<LatLng> list) {
        if (this.Z == null) {
            return -1;
        }
        FutureTask futureTask = new FutureTask(new f0(list));
        queueEvent(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
            return -1;
        } catch (ExecutionException e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        com.amap.api.col.p0003l.z zVar = this.f8658d;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f8689q.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i4) {
        return Y(i4);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i4) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.f8693s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.f8681m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f8689q.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.f8691r;
    }

    public final void k(int i4, boolean z3) {
        if (this.f8680l0 && this.f8682m0) {
            resetRenderTime();
            queueEvent(new g(i4, z3));
            return;
        }
        t0 t0Var = this.E0;
        t0Var.f8782b = z3;
        t0Var.f8781a = true;
        t0Var.f8785e = i4;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d4, double d5, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d4, d5, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z3) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z3);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f4, float f5, IPoint iPoint) {
        double d4 = f4;
        double sx = this.f8689q.getSX();
        Double.isNaN(d4);
        ((Point) iPoint).x = (int) (d4 + sx);
        double d5 = f5;
        double sy = this.f8689q.getSY();
        Double.isNaN(d5);
        ((Point) iPoint).y = (int) (d5 + sy);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    protected final void n(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.f8676j0 && this.Z.getAnimateionsCount() == 0 && this.Z.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f8655c;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.f8675j.isEnabled()) {
                    try {
                        List<AMap.OnCameraChangeListener> a4 = this.f8652b.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (a4 != null && a4.size() != 0) {
                            if (cameraPosition == null) {
                                cameraPosition = getCameraPosition();
                            }
                            synchronized (a4) {
                                for (AMap.OnCameraChangeListener onCameraChangeListener : a4) {
                                    onCameraChangeListener.onCameraChangeFinish(cameraPosition);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.f8689q.resetChangedCounter();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        z9 z9Var = this.f8652b;
        if (z9Var == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : z9Var.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.f8687p = true;
        G(this.f8683n);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.f8687p = false;
        L(this.f8683n);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message obtainMessage = this.f8708z0.obtainMessage();
        obtainMessage.what = 11;
        this.f8708z0.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i4, MotionEvent motionEvent) {
        if (this.f8680l0) {
            t((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.f8679l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.D = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i4, byte[] bArr) {
        com.amap.api.col.p0003l.x xVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    xVar = new com.amap.api.col.p0003l.x();
                    byte b4 = bArr[0];
                    xVar.f9374a = new String(bArr, 1, b4, "utf-8");
                    int i5 = b4 + 1;
                    int i6 = i5 + 1;
                    byte b5 = bArr[i5];
                    xVar.f9375b = new String(bArr, i6, b5, "utf-8");
                    int i7 = i6 + b5;
                    int i8 = i7 + 1;
                    byte b6 = bArr[i7];
                    xVar.activeFloorName = new String(bArr, i8, b6, "utf-8");
                    int i9 = i8 + b6;
                    xVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i9);
                    int i10 = i9 + 4;
                    int i11 = i10 + 1;
                    byte b7 = bArr[i10];
                    xVar.poiid = new String(bArr, i11, b7, "utf-8");
                    int i12 = i11 + b7;
                    int i13 = i12 + 1;
                    byte b8 = bArr[i12];
                    xVar.f9381h = new String(bArr, i13, b8, "utf-8");
                    int i14 = i13 + b8;
                    int i15 = GLConvertUtil.getInt(bArr, i14);
                    xVar.f9376c = i15;
                    int i16 = i14 + 4;
                    xVar.floor_indexs = new int[i15];
                    xVar.floor_names = new String[i15];
                    xVar.f9377d = new String[i15];
                    for (int i17 = 0; i17 < xVar.f9376c; i17++) {
                        xVar.floor_indexs[i17] = GLConvertUtil.getInt(bArr, i16);
                        int i18 = i16 + 4;
                        int i19 = i18 + 1;
                        byte b9 = bArr[i18];
                        if (b9 > 0) {
                            xVar.floor_names[i17] = new String(bArr, i19, b9, "utf-8");
                            i19 += b9;
                        }
                        i16 = i19 + 1;
                        byte b10 = bArr[i19];
                        if (b10 > 0) {
                            xVar.f9377d[i17] = new String(bArr, i16, b10, "utf-8");
                            i16 += b10;
                        }
                    }
                    int i20 = GLConvertUtil.getInt(bArr, i16);
                    xVar.f9378e = i20;
                    int i21 = i16 + 4;
                    if (i20 > 0) {
                        xVar.f9379f = new int[i20];
                        for (int i22 = 0; i22 < xVar.f9378e; i22++) {
                            xVar.f9379f[i22] = GLConvertUtil.getInt(bArr, i21);
                            i21 += 4;
                        }
                    }
                    this.Z0 = xVar;
                    post(new a0());
                }
            } catch (Throwable th) {
                a3.D(th);
                th.printStackTrace();
                return;
            }
        }
        xVar = null;
        this.Z0 = xVar;
        post(new a0());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i4, MotionEvent motionEvent) {
        int i5 = 0;
        try {
            this.A = false;
            y(i4);
            BaseOverlay hitBaseOverlay = this.f8679l.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.f8705y = (Marker) hitBaseOverlay;
            }
            BaseOverlay hitBaseOverlay2 = this.f8679l.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.f8707z = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.f8705y;
            if (marker != null && marker.isDraggable()) {
                LatLng position = this.f8705y.getPosition();
                if (position != null) {
                    IPoint obtain = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain);
                    ((Point) obtain).y -= 60;
                    DPoint obtain2 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain).x, ((Point) obtain).y, obtain2);
                    this.f8705y.setPosition(new LatLng(obtain2.f11672y, obtain2.f11671x));
                    this.f8679l.set2Top(this.f8705y.getId());
                    List a4 = this.f8652b.a(AMap.OnMarkerDragListener.class.hashCode());
                    if (a4 != null && a4.size() > 0) {
                        synchronized (a4) {
                            while (i5 < a4.size()) {
                                ((AMap.OnMarkerDragListener) a4.get(i5)).onMarkerDragStart(this.f8705y);
                                i5++;
                            }
                        }
                    }
                    this.f8701w = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
            } else {
                GLTFOverlay gLTFOverlay = this.f8707z;
                if (gLTFOverlay != null && gLTFOverlay.isDraggable()) {
                    LatLng latlng = this.f8707z.getLatlng();
                    if (latlng != null) {
                        IPoint obtain3 = IPoint.obtain();
                        getLatLng2Pixel(latlng.latitude, latlng.longitude, obtain3);
                        ((Point) obtain3).y -= 60;
                        DPoint obtain4 = DPoint.obtain();
                        getPixel2LatLng(((Point) obtain3).x, ((Point) obtain3).y, obtain4);
                        this.f8707z.setLatLng(new LatLng(obtain4.f11672y, obtain4.f11671x));
                        this.f8679l.set2Top(this.f8707z.getId());
                        this.f8703x = true;
                        obtain3.recycle();
                        obtain4.recycle();
                    }
                } else {
                    List a5 = this.f8652b.a(AMap.OnMapLongClickListener.class.hashCode());
                    if (a5 != null && a5.size() > 0) {
                        DPoint obtain5 = DPoint.obtain();
                        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain5);
                        synchronized (a5) {
                            while (i5 < a5.size()) {
                                ((AMap.OnMapLongClickListener) a5.get(i5)).onMapLongClick(new LatLng(obtain5.f11672y, obtain5.f11671x));
                                i5++;
                            }
                        }
                        this.B = true;
                        obtain5.recycle();
                    }
                }
            }
            this.f8650a0.resetTickCount(30);
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapBlankClick(double d4, double d5) {
        e(d4, d5);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapPOIClick(MapPoi mapPoi) {
        List a4;
        MapConfig mapConfig = this.f8689q;
        if (mapConfig == null || !mapConfig.isTouchPoiEnable() || (a4 = this.f8652b.a(AMap.OnPOIClickListener.class.hashCode())) == null || a4.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.f8708z0.sendMessage(obtain);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        S();
        IGlOverlayLayer iGlOverlayLayer = this.f8679l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.f8650a0.setRenderFps(15.0f);
            this.f8675j.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.f8679l;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            p1 p1Var = this.f8697u;
            if (p1Var != null) {
                p1Var.k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i4, MotionEvent motionEvent) {
        if (this.f8680l0) {
            try {
                y(i4);
                if (c0(motionEvent) || Q(motionEvent) || Z(motionEvent)) {
                    return true;
                }
                M(motionEvent);
                if (U(motionEvent)) {
                    return true;
                }
                I(motionEvent);
                return true;
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "onSingleTapUp");
                th.printStackTrace();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00aa -> B:56:0x00ad). Please submit an issue!!! */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8687p && this.f8680l0 && this.f8674i0) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.V0;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            getEngineIDWithGestureInfo(this.V0);
            l0();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                n0();
                K();
            } else if (action == 1) {
                O();
            }
            if (motionEvent.getAction() == 2 && this.f8701w) {
                try {
                    l(motionEvent);
                } catch (Throwable th) {
                    u5.p(th, "AMapDelegateImp", "onDragMarker");
                    th.printStackTrace();
                }
                return true;
            } else if (motionEvent.getAction() == 2 && this.f8703x) {
                try {
                    B(motionEvent);
                } catch (Throwable th2) {
                    u5.p(th2, "AMapDelegateImp", "onDragGLTF");
                    th2.printStackTrace();
                }
                return true;
            } else {
                if (this.f8656c0) {
                    try {
                        List a4 = this.f8652b.a(AMap.SignleClickInterceptorListener.class.hashCode());
                        if (a4 != null && a4.size() > 0) {
                            if (!((AMap.SignleClickInterceptorListener) a4.get(0)).isInterceptorSignleClick(motionEvent)) {
                                this.f8653b0.e(motionEvent);
                            }
                        } else {
                            this.f8653b0.e(motionEvent);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                try {
                    List a5 = this.f8652b.a(AMap.OnMapTouchListener.class.hashCode());
                    if (a5 != null && a5.size() > 0) {
                        this.f8708z0.removeMessages(14);
                        Message obtainMessage = this.f8708z0.obtainMessage();
                        obtainMessage.what = 14;
                        obtainMessage.obj = MotionEvent.obtain(motionEvent);
                        obtainMessage.sendToTarget();
                    }
                } catch (Throwable unused) {
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void pixel2Map(int i4, int i5, PointF pointF) {
        if (!this.f8680l0 || this.f8687p || this.Z == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i4, i5, obtain);
        pointF.x = ((Point) obtain).x - ((float) this.f8689q.getSX());
        pointF.y = ((Point) obtain).y - ((float) this.f8689q.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.f8675j;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        try {
            long id = Thread.currentThread().getId();
            if (id != -1 && id == this.X) {
                runnable.run();
            } else if (this.Z != null) {
                this.f8675j.queueEvent(runnable);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (!this.f8685o.get() && this.f8680l0) {
            this.f8708z0.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        t8 t8Var = this.f8702w0;
        if (t8Var != null) {
            t8Var.j();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.Z != null) {
            queueEvent(new e0(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(String str) {
        try {
            this.f8679l.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.f8679l.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.f(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.f8675j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        List a4;
        this.f8689q.resetMinMaxZoomPreference();
        try {
            if (!this.f8667g.isZoomControlsEnabled() || !this.f8689q.isNeedUpdateZoomControllerState() || (a4 = this.f8652b.a(AMapWidgetListener.class.hashCode())) == null || a4.size() <= 0) {
                return;
            }
            synchronized (a4) {
                for (int i4 = 0; i4 < a4.size(); i4++) {
                    ((AMapWidgetListener) a4.get(i4)).invalidateZoomController(this.f8689q.getSZ());
                }
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f8650a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z3) throws RemoteException {
        try {
            G(this.f8683n);
            k(this.f8683n, z3);
            L(this.f8683n);
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        ha haVar = this.f8653b0;
        if (haVar != null) {
            this.f8655c = aMapGestureListener;
            haVar.d(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i4, int i5) throws RemoteException {
        this.f8691r = true;
        this.f8692r0 = i4;
        this.f8694s0 = i5;
        if (this.f8682m0 && this.f8680l0) {
            if (this.f8689q.getAnchorX() == this.f8692r0 && this.f8689q.getAnchorY() == this.f8694s0) {
                return;
            }
            this.f8689q.setAnchorX(this.f8692r0);
            this.f8689q.setAnchorY(this.f8694s0);
            queueEvent(new x());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(boolean z3) {
        try {
            if (this.f8680l0 && this.f8682m0) {
                resetRenderTime();
                queueEvent(new t(z3));
                return;
            }
            t0 t0Var = this.I0;
            t0Var.f8782b = z3;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (v(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    q0();
                }
                this.f8702w0.n();
                this.f8702w0.d(customMapStyleOptions);
                com.autonavi.extra.b bVar = this.P0;
                if (bVar != null) {
                    bVar.i();
                }
            } catch (Throwable th) {
                a3.D(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f8689q.getCustomStyleID())) {
            return;
        }
        this.f8689q.setCustomStyleID(str);
        this.f8673i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f8689q.getCustomStylePath())) {
            return;
        }
        this.f8689q.setCustomStylePath(str);
        this.f8673i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.Q = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8689q.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i4, int i5) {
        if (this.f8690q0 == 0 || i5 != 5) {
            this.f8690q0 = i5;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z3) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z3);
            if (this.f8689q.isCustomStyleEnable()) {
                this.f8667g.setLogoEnable(!z3);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.f8685o.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f8695t = (com.amap.api.col.p0003l.x) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new z());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(boolean z3) throws RemoteException {
        List a4;
        try {
            if (this.f8680l0 && !this.f8685o.get()) {
                this.f8689q.setIndoorEnable(z3);
                resetRenderTime();
                if (z3) {
                    GLMapEngine gLMapEngine = this.Z;
                    if (gLMapEngine != null) {
                        gLMapEngine.setIndoorEnable(this.f8683n, true);
                    }
                } else {
                    GLMapEngine gLMapEngine2 = this.Z;
                    if (gLMapEngine2 != null) {
                        gLMapEngine2.setIndoorEnable(this.f8683n, false);
                    }
                    MapConfig mapConfig = this.f8689q;
                    mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.f8689q.getMaxZoomLevel() : 20.0f;
                    try {
                        if (this.f8667g.isZoomControlsEnabled() && (a4 = this.f8652b.a(AMapWidgetListener.class.hashCode())) != null && a4.size() > 0) {
                            synchronized (a4) {
                                for (int i4 = 0; i4 < a4.size(); i4++) {
                                    ((AMapWidgetListener) a4.get(i4)).invalidateZoomController(this.f8689q.getSZ());
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                x2.p(this.Y, z3);
                if (this.f8667g.isIndoorSwitchEnabled()) {
                    this.f8708z0.post(new o(z3));
                    return;
                }
                return;
            }
            t0 t0Var = this.M0;
            t0Var.f8782b = z3;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        com.amap.api.col.p0003l.z zVar;
        if (this.f8685o.get() || (zVar = this.f8658d) == null) {
            return;
        }
        zVar.i(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(boolean z3) throws RemoteException {
        queueEvent(new p(z3));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.f8685o.get()) {
                return;
            }
            LocationSource locationSource2 = this.f8699v;
            if (locationSource2 != null && (locationSource2 instanceof com.amap.api.col.p0003l.a0)) {
                locationSource2.deactivate();
            }
            this.f8699v = locationSource;
            if (locationSource != null) {
                this.f8677k.m(Boolean.TRUE);
            } else {
                this.f8677k.m(Boolean.FALSE);
            }
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.a(Integer.valueOf(i4));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.c(Integer.valueOf(i4));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i4, float f4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.q(Integer.valueOf(i4), Float.valueOf(f4));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i4) {
        h3 h3Var = this.f8677k;
        if (h3Var != null) {
            h3Var.h(Integer.valueOf(i4));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z3, boolean z4) {
        w1 w1Var;
        if (this.f8680l0 && !this.f8685o.get()) {
            boolean z5 = z4 ? z4 : false;
            if (TextUtils.isEmpty(this.f8689q.getCustomStylePath()) && TextUtils.isEmpty(this.f8689q.getCustomStyleID())) {
                return;
            }
            if (z3) {
                try {
                    if (this.f8689q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f8689q.getCustomStyleID()) && (w1Var = this.U) != null) {
                        w1Var.b(this.f8689q.getCustomStyleID());
                        this.U.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    a3.D(th);
                    return;
                }
            }
            if (z4 || this.f8673i || (this.f8689q.isCustomStyleEnable() ^ z3)) {
                r(z3, null, z5);
            }
            this.f8673i = false;
            return;
        }
        t0 t0Var = this.D0;
        t0Var.f8781a = true;
        t0Var.f8782b = z3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z3) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z3);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.f8689q) == null || mapConfig.isCustomStyleEnable() || this.f8689q.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.f8689q.setMapLanguage("zh_cn");
            this.P = 0;
        } else {
            if (this.I != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    a3.D(th);
                    th.printStackTrace();
                }
            }
            this.f8689q.setMapLanguage("en");
            this.P = -10000;
        }
        try {
            C(getCameraPosition());
        } catch (Throwable th2) {
            a3.D(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f8689q.setLimitLatLngBounds(latLngBounds);
            t0();
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(boolean z3) throws RemoteException {
        try {
            if (this.f8680l0 && this.f8682m0) {
                resetRenderTime();
                queueEvent(new q(z3));
                return;
            }
            t0 t0Var = this.F0;
            t0Var.f8782b = z3;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i4) throws RemoteException {
        this.P = i4;
        this.f8706y0 = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i4) throws RemoteException {
        MapConfig mapConfig;
        if (i4 != this.I || ((mapConfig = this.f8689q) != null && mapConfig.isCustomStyleEnable())) {
            this.I = i4;
            b0(i4);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            z9 z9Var = this.f8652b;
            if (z9Var != null) {
                z9Var.c(AMapWidgetListener.class.hashCode(), aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i4, int i5, int i6, int i7, int i8, long j4) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f4) {
        this.f8689q.setMaxZoomLevel(f4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f4) {
        this.f8689q.setMinZoomLevel(f4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z3) throws RemoteException {
        if (this.f8685o.get()) {
            return;
        }
        try {
            h3 h3Var = this.f8677k;
            if (h3Var != null) {
                LocationSource locationSource = this.f8699v;
                if (locationSource == null) {
                    h3Var.m(Boolean.FALSE);
                } else if (z3) {
                    locationSource.activate(this.f8649a);
                    this.f8677k.m(Boolean.TRUE);
                    if (this.f8697u == null) {
                        this.f8697u = new p1(this, this.Y);
                    }
                } else {
                    p1 p1Var = this.f8697u;
                    if (p1Var != null) {
                        p1Var.n();
                        this.f8697u = null;
                    }
                    this.f8699v.deactivate();
                }
            }
            if (!z3) {
                this.f8667g.setMyLocationButtonEnabled(z3);
            }
            this.f8681m = z3;
            resetRenderTime();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f4) throws RemoteException {
        try {
            p1 p1Var = this.f8697u;
            if (p1Var != null) {
                p1Var.b(f4);
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f8685o.get()) {
            return;
        }
        try {
            if (this.f8697u == null) {
                this.f8697u = new p1(this, this.Y);
            }
            if (this.f8697u != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                LocationSource locationSource = this.f8699v;
                if (locationSource != null && (locationSource instanceof com.amap.api.col.p0003l.a0)) {
                    ((com.amap.api.col.p0003l.a0) locationSource).d(myLocationStyle.getInterval());
                    ((com.amap.api.col.p0003l.a0) this.f8699v).c(myLocationStyle.getMyLocationType());
                }
                this.f8697u.h(myLocationStyle);
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i4) throws RemoteException {
        try {
            p1 p1Var = this.f8697u;
            if (p1Var == null || p1Var.a() == null) {
                return;
            }
            this.f8697u.a().myLocationType(i4);
            setMyLocationStyle(this.f8697u.a());
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(boolean z3, int i4, int i5) throws RemoteException {
        try {
            if (this.f8680l0 && this.f8682m0) {
                resetRenderTime();
                queueEvent(new s(z3, i4, i5));
                return;
            }
            t0 t0Var = this.H0;
            t0Var.f8782b = z3;
            t0Var.f8786f = i4;
            t0Var.f8787g = i5;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnIndoorBuildingActiveListener.class.hashCode(), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMapLoadedListener.class.hashCode(), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.f8700v0 = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnPOIClickListener.class.hashCode(), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        z9 z9Var = this.f8652b;
        if (z9Var != null) {
            z9Var.c(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i4) {
        try {
            if (i4 == -1) {
                this.S = i4;
            } else {
                this.S = Math.max(10, Math.min(i4, 40));
            }
            x2.t(this.Y);
        } catch (Throwable th) {
            a3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i4) {
        try {
            IGLSurfaceView iGLSurfaceView = this.f8675j;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i4);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(boolean z3) throws RemoteException {
        try {
            if (this.f8680l0 && this.f8682m0) {
                resetRenderTime();
                queueEvent(new r(z3));
                return;
            }
            t0 t0Var = this.G0;
            t0Var.f8782b = z3;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z3) {
        if (z3) {
            return;
        }
        try {
            if (this.S == -1) {
                n0();
            }
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setTerrainAuth(boolean z3) {
        GLMapEngine gLMapEngine;
        if (this.f8685o.get() || (gLMapEngine = this.Z) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z3) {
        MapConfig mapConfig = this.f8689q;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z3);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(boolean z3) throws RemoteException {
        try {
            if (this.f8680l0 && !this.f8685o.get()) {
                queueEvent(new n(z3, z3));
                return;
            }
            t0 t0Var = this.A0;
            t0Var.f8782b = z3;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (this.f8685o.get()) {
            return;
        }
        try {
            if (this.f8680l0 && this.f8682m0 && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new u(bArr, myTrafficStyle));
                return;
            }
            t0 t0Var = this.K0;
            t0Var.f8788h = bArr;
            t0Var.f8789i = myTrafficStyle;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Exception e4) {
            a3.D(e4);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.f8685o.get()) {
            return;
        }
        try {
            if (this.f8680l0 && this.f8682m0 && bArr != null) {
                resetRenderTime();
                queueEvent(new w(bArr));
                return;
            }
            t0 t0Var = this.J0;
            t0Var.f8788h = bArr;
            t0Var.f8781a = true;
            t0Var.f8785e = this.f8683n;
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i4) {
        IGLSurfaceView iGLSurfaceView = this.f8675j;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(String str) {
        if (v(false, true) || TextUtils.isEmpty(str) || this.f8689q == null || this.R0.equals(str)) {
            return;
        }
        this.R0 = str;
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z3) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i4) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.e(Integer.valueOf(i4));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f4) {
        this.f8668g0 = f4;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z3) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.b(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void showHideBuildings(int i4) {
        if (this.Z == null) {
            return;
        }
        queueEvent(new h0(i4));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z3) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.s(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        com.amap.api.col.p0003l.z zVar;
        if (baseOverlayImp == null || (zVar = this.f8658d) == null) {
            return;
        }
        try {
            zVar.k(baseOverlayImp);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z3) {
        if (this.f8685o.get()) {
            return;
        }
        this.f8677k.f(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z3) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.d(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f8681m && this.f8699v != null) {
                if (this.f8697u == null) {
                    this.f8697u = new p1(this, this.Y);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.f8697u.e(location);
                }
                List a4 = this.f8652b.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (a4 != null && a4.size() > 0) {
                    synchronized (a4) {
                        for (int i4 = 0; i4 < a4.size(); i4++) {
                            ((AMap.OnMyLocationChangeListener) a4.get(i4)).onMyLocationChange(location);
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            p1 p1Var = this.f8697u;
            if (p1Var != null) {
                p1Var.n();
            }
            this.f8697u = null;
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z3) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.i(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z3) {
        h3 h3Var;
        if (this.f8685o.get() || (h3Var = this.f8677k) == null) {
            return;
        }
        h3Var.r(Boolean.valueOf(z3));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i4) {
        GLMapEngine gLMapEngine;
        if (!this.f8680l0 || this.f8687p || (gLMapEngine = this.Z) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.f8683n).getGLUnitWithWin(i4);
    }

    final void x() {
        this.f8708z0.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void z(int i4, boolean z3) {
        if (this.f8680l0 && this.f8682m0) {
            resetRenderTime();
            queueEvent(new h(z3, i4));
            return;
        }
        t0 t0Var = this.L0;
        t0Var.f8782b = z3;
        t0Var.f8781a = true;
        t0Var.f8785e = i4;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i4) {
        if (this.f8680l0 && ((int) E()) > this.f8689q.getMinZoomLevel()) {
            try {
                animateCamera(com.amap.api.col.p0003l.m.l());
            } catch (Throwable th) {
                u5.p(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public p9(IGLSurfaceView iGLSurfaceView, Context context, boolean z3) {
        this.f8649a = null;
        this.f8652b = new z9();
        this.f8670h = false;
        this.f8673i = false;
        this.f8681m = false;
        this.f8685o = new AtomicBoolean(false);
        this.f8687p = false;
        this.f8689q = new MapConfig(true);
        this.f8691r = false;
        this.f8693s = false;
        this.f8701w = false;
        this.f8703x = false;
        this.f8705y = null;
        this.f8707z = null;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = true;
        this.G = true;
        this.H = new Rect();
        this.I = 1;
        this.J = null;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.R = -1;
        this.S = -1;
        this.T = new ArrayList();
        this.W = null;
        this.X = -1L;
        this.f8656c0 = false;
        this.f8665f0 = 0.0f;
        this.f8668g0 = 1.0f;
        this.f8671h0 = 1.0f;
        this.f8674i0 = true;
        this.f8676j0 = false;
        this.f8678k0 = false;
        this.f8680l0 = false;
        this.f8682m0 = false;
        this.f8684n0 = false;
        this.f8686o0 = false;
        this.f8688p0 = new ReentrantLock();
        this.f8690q0 = 0;
        this.f8706y0 = true;
        this.f8708z0 = new k(Looper.getMainLooper());
        this.A0 = new b();
        this.B0 = new m();
        this.C0 = new y();
        this.D0 = new i0();
        this.E0 = new j0();
        this.F0 = new k0();
        this.G0 = new l0();
        this.H0 = new m0();
        this.I0 = new v();
        this.J0 = new g0();
        this.K0 = new n0();
        this.L0 = new o0();
        this.M0 = new p0();
        this.N0 = new q0();
        this.O0 = new r0();
        this.Q0 = "";
        this.R0 = "";
        this.S0 = false;
        this.T0 = false;
        this.U0 = 0;
        this.V0 = new EAMapPlatformGestureInfo();
        this.W0 = new Point();
        this.X0 = 0L;
        this.Y0 = null;
        this.Z0 = null;
        this.f8651a1 = new float[16];
        this.f8654b1 = new float[16];
        this.f8657c1 = new float[16];
        this.f8660d1 = null;
        this.f8663e1 = new float[12];
        this.f8666f1 = "precision highp float;\nattribute vec3 aVertex;//\u9876\u70b9\u6570\u7ec4,\u4e09\u7ef4\u5750\u6807\nuniform mat4 aMVPMatrix;//mvp\u77e9\u9635\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f8669g1 = "//\u6709\u989c\u8272 \u6ca1\u6709\u7eb9\u7406\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f8672h1 = -1;
        this.Y = context;
        n4 a4 = ft.a(context, a3.s());
        ft.c cVar = a4.f8385a;
        ft.c cVar2 = ft.c.SuccessCode;
        if (cVar == cVar2) {
            c3.d(context);
            c3.e(b3.f7206c, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.P0 = bVar;
        bVar.a();
        this.P0.b();
        u5.h(this.Y);
        o2.a().b(this.Y);
        fa.f7731b = e4.g(context);
        g2.a(this.Y);
        this.f8653b0 = new ha(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f8650a0 = gLMapRender;
        this.f8675j = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        com.amap.api.col.p0003l.b bVar2 = new com.amap.api.col.p0003l.b(this, this.Y);
        this.f8679l = bVar2;
        this.Z = new GLMapEngine(this.Y, this);
        this.f8677k = new eh(this.Y, this, bVar2);
        this.f8667g = new com.amap.api.col.p0003l.h(this);
        this.f8677k.g(new v0(this, (byte) 0));
        this.f8696t0 = new u0();
        iGLSurfaceView.setRenderMode(0);
        this.f8650a0.setRenderFps(15.0f);
        this.Z.setMapListener(this);
        this.f8664f = new com.amap.api.col.p0003l.e(this);
        this.f8649a = new y9(this);
        com.amap.api.col.p0003l.z zVar = new com.amap.api.col.p0003l.z(this.Y);
        this.f8658d = zVar;
        zVar.l(this.f8677k);
        this.f8658d.s(new r1(bVar2, context));
        this.K = new ca(this.Y, this);
        this.f8699v = new com.amap.api.col.p0003l.a0(this.Y);
        this.U = new w1(this.Y, this);
        y1 y1Var = new y1(this.Y);
        this.V = y1Var;
        y1Var.b(this);
        q(z3);
        MapConfig mapConfig = this.f8689q;
        t8 t8Var = new t8(this, this.Y, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.f8702w0 = t8Var;
        t8Var.c(this);
        if (a4.f8385a != cVar2) {
            this.f8689q.setMapEnable(false);
        }
        this.f8683n = this.Z.getEngineIDWithType(1);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j4, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.f8685o.get() || this.Z == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j4;
        if (!this.f8687p && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.Z.interruptAnimation();
                resetRenderTime();
                o(abstractCameraUpdateMessage);
                this.Z.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                a3.D(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            a3.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f8708z0 == null || this.Z == null) {
            return;
        }
        try {
            w0 w0Var = new w0(this.Y, onCacheRemoveListener);
            this.f8708z0.removeCallbacks(w0Var);
            this.f8708z0.post(w0Var);
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            a3.D(th);
        }
    }

    @Override // com.amap.api.col.p0003l.y1.a
    public final void a(String str, e2 e2Var) {
        setCustomTextureResourcePath(str);
        if (!this.f8689q.isCustomStyleEnable() || e2Var == null) {
            return;
        }
        s(e2Var.c(), false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.Z == null || this.f8685o.get()) {
            return;
        }
        try {
            if (this.f8687p && this.Z.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage o4 = com.amap.api.col.p0003l.m.o();
                o4.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                o4.geoPoint = new DPoint(this.f8689q.getSX(), this.f8689q.getSY());
                o4.zoom = this.f8689q.getSZ();
                o4.bearing = this.f8689q.getSR();
                o4.tilt = this.f8689q.getSC();
                this.Z.addMessage(abstractCameraUpdateMessage, false);
                while (this.Z.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.Z.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(o4);
                    }
                }
                abstractCameraUpdateMessage = o4;
            }
        } catch (Throwable th) {
            a3.D(th);
        }
        resetRenderTime();
        this.Z.clearAnimations(this.f8683n, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        o(abstractCameraUpdateMessage);
        this.Z.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        com.amap.api.col.p0003l.z zVar;
        if (this.f8685o.get() || (zVar = this.f8658d) == null) {
            return;
        }
        zVar.h(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        com.amap.api.col.p0003l.z zVar;
        if (baseOverlay == null || (zVar = this.f8658d) == null) {
            return;
        }
        try {
            zVar.j(baseOverlay);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.p9$t0 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class t0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f8781a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8782b;

        /* renamed from: c  reason: collision with root package name */
        int f8783c;

        /* renamed from: d  reason: collision with root package name */
        int f8784d;

        /* renamed from: e  reason: collision with root package name */
        int f8785e;

        /* renamed from: f  reason: collision with root package name */
        int f8786f;

        /* renamed from: g  reason: collision with root package name */
        int f8787g;

        /* renamed from: h  reason: collision with root package name */
        byte[] f8788h;

        /* renamed from: i  reason: collision with root package name */
        MyTrafficStyle f8789i;

        private t0() {
            this.f8781a = false;
            this.f8782b = false;
            this.f8786f = 0;
            this.f8787g = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8781a = false;
        }

        /* synthetic */ t0(byte b4) {
            this();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z3) throws RemoteException {
        try {
            hideInfoWindow();
            String str = null;
            String str2 = "";
            p1 p1Var = this.f8697u;
            if (p1Var != null) {
                if (z3) {
                    str = p1Var.p();
                    str2 = this.f8697u.q();
                } else {
                    p1Var.r();
                }
            }
            this.f8679l.clear(str, str2);
            queueEvent(new l());
            resetRenderTime();
        } catch (Throwable th) {
            u5.p(th, "AMapDelegateImp", "clear");
            a3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z3, byte[] bArr) {
        r(z3, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z3) {
        if (z3) {
            q0();
        }
        setMapCustomEnable(z3, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.X = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            a3.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i4, int i5) {
        try {
            changeSurface(1, gl10, i4, i5);
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }
}
