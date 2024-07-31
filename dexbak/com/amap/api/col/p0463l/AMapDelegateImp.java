package com.amap.api.col.p0463l;

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
import com.amap.api.col.p0463l.AMapCustomStyleManager;
import com.amap.api.col.p0463l.CustomStyleTextureTask;
import com.amap.api.col.p0463l.IndoorFloorSwitchView;
import com.amap.api.col.p0463l.Privacy;
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
import com.autonavi.base.p048ae.gmap.AMapAppRequestParam;
import com.autonavi.base.p048ae.gmap.GLMapEngine;
import com.autonavi.base.p048ae.gmap.GLMapRender;
import com.autonavi.base.p048ae.gmap.GLMapState;
import com.autonavi.base.p048ae.gmap.MapPoi;
import com.autonavi.base.p048ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.p048ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.p048ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.p048ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.p048ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.p048ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.p048ae.gmap.gloverlay.RouteOverlayInner;
import com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.p048ae.gmap.style.StyleItem;
import com.autonavi.extra.AMapExtraInterfaceManager;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UMCommonContent;
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

/* renamed from: com.amap.api.col.3l.o9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapDelegateImp implements CustomStyleTextureTask.InterfaceC2006a, AMapCustomStyleManager.InterfaceC1942a, IAMapDelegate, IAMapListener {

    /* renamed from: A */
    private boolean f4809A;

    /* renamed from: A0 */
    private AbstractRunnableC1909t0 f4810A0;

    /* renamed from: B */
    private boolean f4811B;

    /* renamed from: B0 */
    private AbstractRunnableC1909t0 f4812B0;

    /* renamed from: C */
    private boolean f4813C;

    /* renamed from: C0 */
    private AbstractRunnableC1909t0 f4814C0;

    /* renamed from: D */
    private boolean f4815D;

    /* renamed from: D0 */
    private AbstractRunnableC1909t0 f4816D0;

    /* renamed from: E */
    private int f4817E;

    /* renamed from: E0 */
    private AbstractRunnableC1909t0 f4818E0;

    /* renamed from: F */
    private boolean f4819F;

    /* renamed from: F0 */
    private AbstractRunnableC1909t0 f4820F0;

    /* renamed from: G */
    private boolean f4821G;

    /* renamed from: G0 */
    private AbstractRunnableC1909t0 f4822G0;

    /* renamed from: H */
    private Rect f4823H;

    /* renamed from: H0 */
    private AbstractRunnableC1909t0 f4824H0;

    /* renamed from: I */
    private int f4825I;

    /* renamed from: I0 */
    private AbstractRunnableC1909t0 f4826I0;

    /* renamed from: J */
    private MyTrafficStyle f4827J;

    /* renamed from: J0 */
    private AbstractRunnableC1909t0 f4828J0;

    /* renamed from: K */
    private Thread f4829K;

    /* renamed from: K0 */
    private AbstractRunnableC1909t0 f4830K0;

    /* renamed from: L */
    private Thread f4831L;

    /* renamed from: L0 */
    private AbstractRunnableC1909t0 f4832L0;

    /* renamed from: M */
    private AuthTerrainTask f4833M;

    /* renamed from: M0 */
    private AbstractRunnableC1909t0 f4834M0;

    /* renamed from: N */
    private boolean f4835N;

    /* renamed from: N0 */
    private Runnable f4836N0;

    /* renamed from: O */
    private boolean f4837O;

    /* renamed from: O0 */
    private AbstractRunnableC1909t0 f4838O0;

    /* renamed from: P */
    private int f4839P;

    /* renamed from: P0 */
    private AMapExtraInterfaceManager f4840P0;

    /* renamed from: Q */
    private CustomRenderer f4841Q;

    /* renamed from: Q0 */
    private String f4842Q0;

    /* renamed from: R */
    private int f4843R;

    /* renamed from: R0 */
    private String f4844R0;

    /* renamed from: S */
    private int f4845S;

    /* renamed from: S0 */
    private boolean f4846S0;

    /* renamed from: T */
    private List<OverlayTextureItem> f4847T;

    /* renamed from: T0 */
    private boolean f4848T0;

    /* renamed from: U */
    private CustomStyleTask f4849U;

    /* renamed from: U0 */
    private int f4850U0;

    /* renamed from: V */
    private CustomStyleTextureTask f4851V;

    /* renamed from: V0 */
    private EAMapPlatformGestureInfo f4852V0;

    /* renamed from: W */
    PureScreenCheckTool f4853W;

    /* renamed from: W0 */
    Point f4854W0;

    /* renamed from: X */
    private long f4855X;

    /* renamed from: X0 */
    private long f4856X0;

    /* renamed from: Y */
    protected Context f4857Y;

    /* renamed from: Y0 */
    protected String f4858Y0;

    /* renamed from: Z */
    protected GLMapEngine f4859Z;

    /* renamed from: Z0 */
    private IndoorBuilding f4860Z0;

    /* renamed from: a */
    private AMapOnLocationChangedListener f4861a;

    /* renamed from: a0 */
    private GLMapRender f4862a0;

    /* renamed from: a1 */
    float[] f4863a1;

    /* renamed from: b */
    private AmapDelegateListenerManager f4864b;

    /* renamed from: b0 */
    private GlMapGestureDetector f4865b0;

    /* renamed from: b1 */
    float[] f4866b1;

    /* renamed from: c */
    private AMapGestureListener f4867c;

    /* renamed from: c0 */
    private boolean f4868c0;

    /* renamed from: c1 */
    float[] f4869c1;

    /* renamed from: d */
    private InfoWindowDelegate f4870d;

    /* renamed from: d0 */
    public int f4871d0;

    /* renamed from: d1 */
    private IPoint[] f4872d1;

    /* renamed from: e */
    private UiSettings f4873e;

    /* renamed from: e0 */
    public int f4874e0;

    /* renamed from: e1 */
    float[] f4875e1;

    /* renamed from: f */
    private IProjectionDelegate f4876f;

    /* renamed from: f0 */
    private float f4877f0;

    /* renamed from: f1 */
    String f4878f1;

    /* renamed from: g */
    private final UiSettingsDelegateImp f4879g;

    /* renamed from: g0 */
    private float f4880g0;

    /* renamed from: g1 */
    String f4881g1;

    /* renamed from: h */
    protected boolean f4882h;

    /* renamed from: h0 */
    private float f4883h0;

    /* renamed from: h1 */
    int f4884h1;

    /* renamed from: i */
    private boolean f4885i;

    /* renamed from: i0 */
    private boolean f4886i0;

    /* renamed from: j */
    private final IGLSurfaceView f4887j;

    /* renamed from: j0 */
    private boolean f4888j0;

    /* renamed from: k */
    private MapOverlayViewGroupBase f4889k;

    /* renamed from: k0 */
    private boolean f4890k0;

    /* renamed from: l */
    private final IGlOverlayLayer f4891l;

    /* renamed from: l0 */
    private volatile boolean f4892l0;

    /* renamed from: m */
    private boolean f4893m;

    /* renamed from: m0 */
    private volatile boolean f4894m0;

    /* renamed from: n */
    private int f4895n;

    /* renamed from: n0 */
    private boolean f4896n0;

    /* renamed from: o */
    private AtomicBoolean f4897o;

    /* renamed from: o0 */
    private boolean f4898o0;

    /* renamed from: p */
    private boolean f4899p;

    /* renamed from: p0 */
    private Lock f4900p0;

    /* renamed from: q */
    protected MapConfig f4901q;

    /* renamed from: q0 */
    private int f4902q0;

    /* renamed from: r */
    private boolean f4903r;

    /* renamed from: r0 */
    private int f4904r0;

    /* renamed from: s */
    private boolean f4905s;

    /* renamed from: s0 */
    private int f4906s0;

    /* renamed from: t */
    protected IndoorBuilding f4907t;

    /* renamed from: t0 */
    private C1911u0 f4908t0;

    /* renamed from: u */
    private MyLocationOverlay f4909u;

    /* renamed from: u0 */
    private GlShaderManager f4910u0;

    /* renamed from: v */
    private LocationSource f4911v;

    /* renamed from: v0 */
    private AMap.OnMultiPointClickListener f4912v0;

    /* renamed from: w */
    private boolean f4913w;

    /* renamed from: w0 */
    private AMapCustomStyleManager f4914w0;

    /* renamed from: x */
    private boolean f4915x;

    /* renamed from: x0 */
    private long f4916x0;

    /* renamed from: y */
    private Marker f4917y;

    /* renamed from: y0 */
    boolean f4918y0;

    /* renamed from: z */
    private GLTFOverlay f4919z;

    /* renamed from: z0 */
    protected final Handler f4920z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1870a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ double f4921a;

        /* renamed from: b */
        final /* synthetic */ double f4922b;

        RunnableC1870a(double d, double d2) {
            this.f4921a = d;
            this.f4922b = d2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 19;
            obtain.arg1 = (int) this.f4921a;
            obtain.arg2 = (int) this.f4922b;
            AMapDelegateImp.this.f4920z0.sendMessage(obtain);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$a0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1871a0 implements Runnable {
        RunnableC1871a0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AMapDelegateImp.this.f4908t0 != null) {
                AMapDelegateImp.this.f4908t0.m54276a(AMapDelegateImp.this.f4860Z0);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1872b extends AbstractRunnableC1909t0 {
        C1872b() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setTrafficEnabled(this.f4994b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$b0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1873b0 implements Runnable {
        RunnableC1873b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AMapDelegateImp.this.f4891l != null) {
                    AMapDelegateImp.this.f4891l.destroy();
                }
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.destroySurface(aMapDelegateImp.f4895n);
            } catch (Throwable th) {
                th.printStackTrace();
                C1732a3.m55741D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1874c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ BlankView f4927a;

        RunnableC1874c(BlankView blankView) {
            this.f4927a = blankView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AMapDelegateImp.this.f4899p) {
                return;
            }
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                IndoorBuilding indoorBuilding = aMapDelegateImp.f4907t;
                if (indoorBuilding != null) {
                    aMapDelegateImp.setIndoorBuildingInfo(indoorBuilding);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f4927a.m55191a();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$c0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1875c0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CrossVectorOverlay f4929a;

        RunnableC1875c0(CrossVectorOverlay crossVectorOverlay) {
            this.f4929a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            GLMapEngine gLMapEngine = aMapDelegateImp.f4859Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(aMapDelegateImp.f4895n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f4929a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1876d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4931a;

        RunnableC1876d(int i) {
            this.f4931a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine;
            if (!AMapDelegateImp.this.f4892l0 || (gLMapEngine = AMapDelegateImp.this.f4859Z) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.f4931a, false);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$d0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1877d0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RouteOverlayInner f4933a;

        RunnableC1877d0(RouteOverlayInner routeOverlayInner) {
            this.f4933a = routeOverlayInner;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            GLMapEngine gLMapEngine = aMapDelegateImp.f4859Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(aMapDelegateImp.f4895n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f4933a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1878e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4935a;

        /* renamed from: b */
        final /* synthetic */ int f4936b;

        /* renamed from: c */
        final /* synthetic */ int f4937c;

        /* renamed from: d */
        final /* synthetic */ boolean f4938d;

        /* renamed from: e */
        final /* synthetic */ StyleItem[] f4939e;

        RunnableC1878e(int i, int i2, int i3, boolean z, StyleItem[] styleItemArr) {
            this.f4935a = i;
            this.f4936b = i2;
            this.f4937c = i3;
            this.f4938d = z;
            this.f4939e = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.f4859Z.setMapModeAndStyle(this.f4935a, this.f4936b, this.f4937c, this.f4938d, this.f4939e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$e0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1879e0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ BaseMapOverlay f4941a;

        RunnableC1879e0(BaseMapOverlay baseMapOverlay) {
            this.f4941a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            aMapDelegateImp.f4859Z.getOverlayBundle(aMapDelegateImp.f4895n).removeOverlay(this.f4941a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1880f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4943a;

        RunnableC1880f(int i) {
            this.f4943a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.f4859Z.clearAllMessages(this.f4943a);
                AMapDelegateImp.this.f4859Z.clearAnimations(this.f4943a, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$f0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class CallableC1881f0 implements Callable<Integer> {

        /* renamed from: a */
        final /* synthetic */ List f4945a;

        CallableC1881f0(List list) {
            this.f4945a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() throws Exception {
            return Integer.valueOf(AMapDelegateImp.this.f4859Z.hideBuildings(this.f4945a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1882g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4947a;

        /* renamed from: b */
        final /* synthetic */ boolean f4948b;

        RunnableC1882g(int i, boolean z) {
            this.f4947a = i;
            this.f4948b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.f4859Z.setBuildingEnable(this.f4947a, this.f4948b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$g0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1883g0 extends AbstractRunnableC1909t0 {
        C1883g0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setTrafficStyleWithTextureData(this.f5000h);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1884h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4951a;

        /* renamed from: b */
        final /* synthetic */ int f4952b;

        RunnableC1884h(boolean z, int i) {
            this.f4951a = z;
            this.f4952b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine = AMapDelegateImp.this.f4859Z;
            if (gLMapEngine != null) {
                if (this.f4951a) {
                    gLMapEngine.setAllContentEnable(this.f4952b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.f4952b, false);
                }
                AMapDelegateImp.this.f4859Z.setSimple3DEnable(this.f4952b, false);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$h0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1885h0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4954a;

        RunnableC1885h0(int i) {
            this.f4954a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AMapDelegateImp.this.f4859Z.showHideBuildings(this.f4954a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1886i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4956a;

        /* renamed from: b */
        final /* synthetic */ int f4957b;

        RunnableC1886i(boolean z, int i) {
            this.f4956a = z;
            this.f4957b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f4956a) {
                    AMapDelegateImp.this.f4859Z.setBuildingTextureEnable(this.f4957b, true);
                } else {
                    AMapDelegateImp.this.f4859Z.setBuildingTextureEnable(this.f4957b, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$i0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1887i0 extends AbstractRunnableC1909t0 {
        C1887i0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            AMapDelegateImp.this.setMapCustomEnable(this.f4994b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1888j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LatLngBounds.Builder f4960a;

        RunnableC1888j(LatLngBounds.Builder builder) {
            this.f4960a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.moveCamera(CameraUpdateFactoryDelegate.m54546i(this.f4960a.build(), 50));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$j0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1889j0 extends AbstractRunnableC1909t0 {
        C1889j0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            AMapDelegateImp.this.m54308k(this.f4997e, this.f4994b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$k */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class HandlerC1890k extends Handler {
        HandlerC1890k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            WaterMarkerView mo54840f;
            if (message == null || AMapDelegateImp.this.f4897o.get()) {
                return;
            }
            try {
                int i = message.what;
                if (i == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Key验证失败：[");
                    Object obj = message.obj;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(AuthConfigManager.f4098b);
                    }
                    sb.append("]");
                    Log.w("amapsdk", sb.toString());
                } else if (i != 30) {
                    int i2 = 0;
                    switch (i) {
                        case 10:
                            CameraPosition cameraPosition = (CameraPosition) message.obj;
                            List<AMap.OnCameraChangeListener> m53384a = AMapDelegateImp.this.f4864b.m53384a(AMap.OnCameraChangeListener.class.hashCode());
                            if (cameraPosition != null && m53384a != null && m53384a.size() > 0) {
                                synchronized (m53384a) {
                                    for (AMap.OnCameraChangeListener onCameraChangeListener : m53384a) {
                                        onCameraChangeListener.onCameraChange(cameraPosition);
                                    }
                                }
                            }
                            AMapDelegateImp.this.f4901q.addChangedCounter();
                            return;
                        case 11:
                            CameraPosition cameraPosition2 = AMapDelegateImp.this.getCameraPosition();
                            if (cameraPosition2 != null && AMapDelegateImp.this.f4889k != null) {
                                AMapDelegateImp.this.f4889k.mo54825p(cameraPosition2);
                            }
                            AMapDelegateImp.this.m54351C(cameraPosition2);
                            if (AMapDelegateImp.this.f4890k0) {
                                AMapDelegateImp.m54332V(AMapDelegateImp.this);
                                if (AMapDelegateImp.this.f4891l != null) {
                                    AMapDelegateImp.this.f4891l.setFlingState(false);
                                }
                                AMapDelegateImp.this.m54282x();
                            }
                            if (AMapDelegateImp.this.f4815D) {
                                AMapDelegateImp.this.redrawInfoWindow();
                                AMapDelegateImp.m54317f0(AMapDelegateImp.this);
                            }
                            AMapDelegateImp.this.m54302n(cameraPosition2);
                            return;
                        case 12:
                            if (AMapDelegateImp.this.f4889k != null) {
                                AMapDelegateImp.this.f4889k.mo54826o(Float.valueOf(AMapDelegateImp.this.getZoomLevel()));
                                return;
                            }
                            return;
                        case 13:
                            if (AMapDelegateImp.this.f4889k != null) {
                                AMapDelegateImp.this.f4889k.mo54836h();
                                return;
                            }
                            return;
                        case 14:
                            List<AMap.OnMapTouchListener> m53384a2 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnMapTouchListener.class.hashCode());
                            if (m53384a2 == null || m53384a2.size() <= 0) {
                                return;
                            }
                            synchronized (m53384a2) {
                                for (AMap.OnMapTouchListener onMapTouchListener : m53384a2) {
                                    onMapTouchListener.onTouch((MotionEvent) message.obj);
                                }
                            }
                            return;
                        case 15:
                            Bitmap bitmap = (Bitmap) message.obj;
                            int i3 = message.arg1;
                            if (bitmap != null && AMapDelegateImp.this.f4889k != null) {
                                Canvas canvas = new Canvas(bitmap);
                                if (AMapDelegateImp.this.f4819F && (mo54840f = AMapDelegateImp.this.f4889k.mo54840f()) != null) {
                                    mo54840f.onDraw(canvas);
                                }
                                AMapDelegateImp.this.f4889k.mo54831j(canvas);
                                List m53384a3 = AMapDelegateImp.this.f4864b.m53384a(AMap.onMapPrintScreenListener.class.hashCode());
                                ArrayList arrayList = m53384a3 != null ? new ArrayList(m53384a3) : null;
                                List m53384a4 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnMapScreenShotListener.class.hashCode());
                                ArrayList arrayList2 = m53384a4 != null ? new ArrayList(m53384a4) : null;
                                AMapDelegateImp.this.f4864b.m53381d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                AMapDelegateImp.this.f4864b.m53381d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList != null && arrayList.size() > 0) {
                                    synchronized (arrayList) {
                                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                            ((AMap.onMapPrintScreenListener) arrayList.get(i4)).onMapPrint(new BitmapDrawable(AMapDelegateImp.this.f4857Y.getResources(), bitmap));
                                        }
                                    }
                                }
                                if (arrayList2 == null || arrayList2.size() <= 0) {
                                    return;
                                }
                                synchronized (arrayList2) {
                                    while (i2 < arrayList2.size()) {
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(bitmap);
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(bitmap, i3);
                                        i2++;
                                    }
                                }
                                return;
                            }
                            List m53384a5 = AMapDelegateImp.this.f4864b.m53384a(AMap.onMapPrintScreenListener.class.hashCode());
                            ArrayList arrayList3 = m53384a5 != null ? new ArrayList(m53384a5) : null;
                            List m53384a6 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnMapScreenShotListener.class.hashCode());
                            ArrayList arrayList4 = m53384a6 != null ? new ArrayList(m53384a6) : null;
                            AMapDelegateImp.this.f4864b.m53381d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            AMapDelegateImp.this.f4864b.m53381d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                synchronized (arrayList3) {
                                    for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                                        ((AMap.onMapPrintScreenListener) arrayList3.get(i5)).onMapPrint(null);
                                    }
                                }
                            }
                            if (arrayList4 == null || arrayList4.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList4) {
                                while (i2 < arrayList4.size()) {
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(null);
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(null, i3);
                                    i2++;
                                }
                            }
                            return;
                        case 16:
                            List m53384a7 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnMapLoadedListener.class.hashCode());
                            if (m53384a7 != null) {
                                synchronized (m53384a7) {
                                    while (i2 < m53384a7.size()) {
                                        ((AMap.OnMapLoadedListener) m53384a7.get(i2)).onMapLoaded();
                                        i2++;
                                    }
                                }
                            }
                            if (AMapDelegateImp.this.f4889k != null) {
                                AMapDelegateImp.this.f4889k.mo54834i();
                                return;
                            }
                            return;
                        case 17:
                            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                            if (!aMapDelegateImp.f4859Z.isInMapAnimation(aMapDelegateImp.f4895n) || AMapDelegateImp.this.f4891l == null) {
                                return;
                            }
                            AMapDelegateImp.this.f4891l.setFlingState(false);
                            return;
                        case 18:
                            if (AMapDelegateImp.this.f4870d != null) {
                                AMapDelegateImp.this.f4870d.m53361r();
                                return;
                            }
                            return;
                        case 19:
                            List<AMap.OnMapClickListener> m53384a8 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnMapClickListener.class.hashCode());
                            if (m53384a8 != null) {
                                DPoint obtain = DPoint.obtain();
                                AMapDelegateImp.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                synchronized (m53384a8) {
                                    for (AMap.OnMapClickListener onMapClickListener : m53384a8) {
                                        onMapClickListener.onMapClick(new LatLng(obtain.f7978y, obtain.f7977x));
                                    }
                                }
                                obtain.recycle();
                                return;
                            }
                            return;
                        case 20:
                            List m53384a9 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnPOIClickListener.class.hashCode());
                            if (m53384a9 == null || m53384a9.size() <= 0) {
                                return;
                            }
                            synchronized (m53384a9) {
                                while (i2 < m53384a9.size()) {
                                    ((AMap.OnPOIClickListener) m53384a9.get(i2)).onPOIClick((Poi) message.obj);
                                    i2++;
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    GLMapEngine gLMapEngine = AMapDelegateImp.this.f4859Z;
                    if (gLMapEngine != null) {
                        gLMapEngine.triggerMainThread();
                    }
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$k0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1891k0 extends AbstractRunnableC1909t0 {
        C1891k0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setMapTextEnable(this.f4994b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$l */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1892l implements Runnable {
        RunnableC1892l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            if (aMapDelegateImp.f4859Z == null || aMapDelegateImp.f4897o.get()) {
                return;
            }
            AMapDelegateImp aMapDelegateImp2 = AMapDelegateImp.this;
            aMapDelegateImp2.f4859Z.removeNativeAllOverlay(aMapDelegateImp2.f4895n);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$l0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1893l0 extends AbstractRunnableC1909t0 {
        C1893l0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setRoadArrowEnable(this.f4994b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$m */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1894m extends AbstractRunnableC1909t0 {
        C1894m() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.setCenterToPixel(aMapDelegateImp.f4904r0, AMapDelegateImp.this.f4906s0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$m0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1895m0 extends AbstractRunnableC1909t0 {
        C1895m0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setNaviLabelEnable(this.f4994b, this.f4998f, this.f4999g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$n */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1896n implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4969a;

        /* renamed from: b */
        final /* synthetic */ boolean f4970b;

        RunnableC1896n(boolean z, boolean z2) {
            this.f4969a = z;
            this.f4970b = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AMapDelegateImp.this.f4901q.isTrafficEnabled() != this.f4969a) {
                    AMapDelegateImp.this.f4901q.setTrafficEnabled(this.f4970b);
                    AMapDelegateImp.this.f4862a0.setTrafficMode(this.f4969a);
                    AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                    aMapDelegateImp.f4859Z.setTrafficEnable(aMapDelegateImp.f4895n, this.f4969a);
                    AMapDelegateImp.this.resetRenderTime();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C1732a3.m55741D(th);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$n0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1897n0 extends AbstractRunnableC1909t0 {
        C1897n0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setTrafficStyleWithTexture(this.f5000h, this.f5001i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$o */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1898o implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4973a;

        RunnableC1898o(boolean z) {
            this.f4973a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f4973a) {
                AMapDelegateImp.this.showIndoorSwitchControlsEnabled(true);
            } else if (AMapDelegateImp.this.f4889k != null) {
                AMapDelegateImp.this.f4889k.mo54830k(Boolean.FALSE);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$o0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1899o0 extends AbstractRunnableC1909t0 {
        C1899o0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            AMapDelegateImp.this.m54278z(this.f4997e, this.f4994b);
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$p */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1900p implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4976a;

        RunnableC1900p(boolean z) {
            this.f4976a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            GLMapEngine gLMapEngine = aMapDelegateImp.f4859Z;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(aMapDelegateImp.f4895n, this.f4976a);
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$p0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1901p0 extends AbstractRunnableC1909t0 {
        C1901p0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setIndoorEnabled(this.f4994b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$q */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1902q implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4979a;

        RunnableC1902q(boolean z) {
            this.f4979a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4859Z.setLabelEnable(aMapDelegateImp.f4895n, this.f4979a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$q0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1903q0 implements Runnable {
        RunnableC1903q0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WaterMarkerView mo54840f;
            if (AMapDelegateImp.this.f4889k == null || (mo54840f = AMapDelegateImp.this.f4889k.mo54840f()) == null) {
                return;
            }
            mo54840f.m55120l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$r */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1904r implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4982a;

        RunnableC1904r(boolean z) {
            this.f4982a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4859Z.setRoadArrowEnable(aMapDelegateImp.f4895n, this.f4982a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$r0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1905r0 extends AbstractRunnableC1909t0 {
        C1905r0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            AMapDelegateImp.this.m54346H(this.f4997e, this.f4994b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$s */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1906s implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4985a;

        /* renamed from: b */
        final /* synthetic */ int f4986b;

        /* renamed from: c */
        final /* synthetic */ int f4987c;

        RunnableC1906s(boolean z, int i, int i2) {
            this.f4985a = z;
            this.f4986b = i;
            this.f4987c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4859Z.setNaviLabelEnable(aMapDelegateImp.f4895n, this.f4985a, this.f4986b, this.f4987c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$s0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1907s0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ MotionEvent f4989a;

        RunnableC1907s0(MotionEvent motionEvent) {
            this.f4989a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.f4859Z.addGestureSingleTapMessage(this.f4989a.getX(), this.f4989a.getY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$t */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1908t implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f4991a;

        RunnableC1908t(boolean z) {
            this.f4991a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp.this.f4859Z.setMapOpenLayerEnable(this.f4991a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$u */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1910u implements Runnable {

        /* renamed from: a */
        final /* synthetic */ byte[] f5002a;

        /* renamed from: b */
        final /* synthetic */ MyTrafficStyle f5003b;

        RunnableC1910u(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f5002a = bArr;
            this.f5003b = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4859Z.setTrafficStyleWithTexture(aMapDelegateImp.f4895n, this.f5002a, this.f5003b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$u0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C1911u0 {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.o9$u0$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public final class RunnableC1912a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ IndoorFloorSwitchView f5006a;

            RunnableC1912a(IndoorFloorSwitchView indoorFloorSwitchView) {
                this.f5006a = indoorFloorSwitchView;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5006a.m55173j(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AMapDelegateImp.java */
        /* renamed from: com.amap.api.col.3l.o9$u0$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public final class RunnableC1913b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ IndoorFloorSwitchView f5008a;

            RunnableC1913b(IndoorFloorSwitchView indoorFloorSwitchView) {
                this.f5008a = indoorFloorSwitchView;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f5008a.m55172k(AMapDelegateImp.this.f4907t.floor_names);
                    this.f5008a.m55174i(AMapDelegateImp.this.f4907t.activeFloorName);
                    if (this.f5008a.m55168o()) {
                        return;
                    }
                    this.f5008a.m55173j(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        C1911u0() {
        }

        /* renamed from: a */
        public final void m54276a(IndoorBuilding indoorBuilding) {
            List m53384a;
            List m53384a2;
            IndoorBuilding indoorBuilding2;
            IndoorBuilding indoorBuilding3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = AMapDelegateImp.this.f4901q;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            IndoorFloorSwitchView mo54842e = AMapDelegateImp.this.f4889k.mo54842e();
            if (indoorBuilding == null) {
                try {
                    List m53384a3 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (m53384a3 != null && m53384a3.size() > 0) {
                        synchronized (m53384a3) {
                            for (int i = 0; i < m53384a3.size(); i++) {
                                ((AMap.OnIndoorBuildingActiveListener) m53384a3.get(i)).OnIndoorBuilding(indoorBuilding);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                IndoorBuilding indoorBuilding4 = AMapDelegateImp.this.f4907t;
                if (indoorBuilding4 != null) {
                    indoorBuilding4.f5649g = null;
                }
                if (mo54842e.m55168o()) {
                    AMapDelegateImp.this.f4920z0.post(new RunnableC1912a(mo54842e));
                }
                MapConfig mapConfig2 = AMapDelegateImp.this.f4901q;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? AMapDelegateImp.this.f4901q.getMaxZoomLevel() : 20.0f;
                try {
                    if (!AMapDelegateImp.this.f4879g.isZoomControlsEnabled() || (m53384a = AMapDelegateImp.this.f4864b.m53384a(AMapWidgetListener.class.hashCode())) == null || m53384a.size() <= 0) {
                        return;
                    }
                    synchronized (m53384a) {
                        for (int i2 = 0; i2 < m53384a.size(); i2++) {
                            ((AMapWidgetListener) m53384a.get(i2)).invalidateZoomController(AMapDelegateImp.this.f4901q.getSZ());
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (indoorBuilding != null && (iArr = indoorBuilding.floor_indexs) != null && (strArr = indoorBuilding.floor_names) != null && iArr.length == strArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = indoorBuilding.floor_indexs;
                    if (i3 >= iArr2.length) {
                        break;
                    } else if (indoorBuilding.activeFloorIndex == iArr2[i3]) {
                        indoorBuilding.activeFloorName = indoorBuilding.floor_names[i3];
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (indoorBuilding == null || (indoorBuilding3 = AMapDelegateImp.this.f4907t) == null || indoorBuilding3.activeFloorIndex == indoorBuilding.activeFloorIndex || !mo54842e.m55168o()) {
                if (indoorBuilding != null && ((indoorBuilding2 = AMapDelegateImp.this.f4907t) == null || !indoorBuilding2.poiid.equals(indoorBuilding.poiid) || AMapDelegateImp.this.f4907t.f5649g == null)) {
                    AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                    aMapDelegateImp.f4907t = indoorBuilding;
                    if (aMapDelegateImp.f4901q != null) {
                        if (indoorBuilding.f5649g == null) {
                            indoorBuilding.f5649g = new Point();
                        }
                        DPoint mapGeoCenter = AMapDelegateImp.this.f4901q.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = AMapDelegateImp.this.f4907t.f5649g;
                            point.x = (int) mapGeoCenter.f7977x;
                            point.y = (int) mapGeoCenter.f7978y;
                        }
                    }
                }
                try {
                    List m53384a4 = AMapDelegateImp.this.f4864b.m53384a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (m53384a4 != null && m53384a4.size() > 0) {
                        synchronized (m53384a4) {
                            for (int i4 = 0; i4 < m53384a4.size(); i4++) {
                                ((AMap.OnIndoorBuildingActiveListener) m53384a4.get(i4)).OnIndoorBuilding(indoorBuilding);
                            }
                        }
                    }
                    MapConfig mapConfig3 = AMapDelegateImp.this.f4901q;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? AMapDelegateImp.this.f4901q.getMaxZoomLevel() : 20.0f;
                    if (AMapDelegateImp.this.f4879g.isZoomControlsEnabled() && (m53384a2 = AMapDelegateImp.this.f4864b.m53384a(AMapWidgetListener.class.hashCode())) != null && m53384a2.size() > 0) {
                        synchronized (m53384a2) {
                            for (int i5 = 0; i5 < m53384a2.size(); i5++) {
                                ((AMapWidgetListener) m53384a2.get(i5)).invalidateZoomController(AMapDelegateImp.this.f4901q.getSZ());
                            }
                        }
                    }
                    if (AMapDelegateImp.this.f4879g.isIndoorSwitchEnabled()) {
                        if (!mo54842e.m55168o()) {
                            AMapDelegateImp.this.f4879g.setIndoorSwitchEnabled(true);
                        }
                        AMapDelegateImp.this.f4920z0.post(new RunnableC1913b(mo54842e));
                    } else if (!AMapDelegateImp.this.f4879g.isIndoorSwitchEnabled() && mo54842e.m55168o()) {
                        AMapDelegateImp.this.f4879g.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$v */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1914v extends AbstractRunnableC1909t0 {
        C1914v() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                AMapDelegateImp.this.setConstructingRoadEnable(this.f4994b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$v0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C1915v0 implements IndoorFloorSwitchView.InterfaceC1789d {
        private C1915v0() {
        }

        @Override // com.amap.api.col.p0463l.IndoorFloorSwitchView.InterfaceC1789d
        /* renamed from: a */
        public final void mo54275a(int i) {
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            IndoorBuilding indoorBuilding = aMapDelegateImp.f4907t;
            if (indoorBuilding != null) {
                indoorBuilding.activeFloorIndex = indoorBuilding.floor_indexs[i];
                indoorBuilding.activeFloorName = indoorBuilding.floor_names[i];
                try {
                    aMapDelegateImp.setIndoorBuildingInfo(indoorBuilding);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        /* synthetic */ C1915v0(AMapDelegateImp aMapDelegateImp, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$w */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1916w implements Runnable {

        /* renamed from: a */
        final /* synthetic */ byte[] f5012a;

        RunnableC1916w(byte[] bArr) {
            this.f5012a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4859Z.setTrafficStyleWithTextureData(aMapDelegateImp.f4895n, this.f5012a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$w0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC1917w0 implements Runnable {

        /* renamed from: a */
        private Context f5014a;

        /* renamed from: b */
        private AMap.OnCacheRemoveListener f5015b;

        public RunnableC1917w0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f5014a = context;
            this.f5015b = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof RunnableC1917w0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
            if (com.amap.api.col.p0463l.C1732a3.m55701i0(r2) != false) goto L11;
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
                android.content.Context r2 = r6.f5014a     // Catch: java.lang.Throwable -> L66
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L66
                android.content.Context r2 = com.stub.StubApp.getOrigApplicationContext(r2)     // Catch: java.lang.Throwable -> L66
                java.lang.String r3 = com.amap.api.col.p0463l.C1732a3.m55707f0(r2)     // Catch: java.lang.Throwable -> L66
                java.lang.String r4 = com.amap.api.col.p0463l.C1732a3.m55688v(r2)     // Catch: java.lang.Throwable -> L66
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
                boolean r2 = com.amap.api.col.p0463l.C1732a3.m55701i0(r2)     // Catch: java.lang.Throwable -> L34
                if (r2 == 0) goto L41
                goto L42
            L41:
                r1 = 0
            L42:
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0463l.AMapDelegateImp.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0463l.AMapDelegateImp.m54331W(r2)     // Catch: java.lang.Throwable -> L66
                if (r2 == 0) goto L53
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0463l.AMapDelegateImp.this     // Catch: java.lang.Throwable -> L66
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0463l.AMapDelegateImp.m54331W(r2)     // Catch: java.lang.Throwable -> L66
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L66
            L53:
                com.amap.api.col.3l.o9 r0 = com.amap.api.col.p0463l.AMapDelegateImp.this     // Catch: java.lang.Throwable -> L61
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.f4859Z     // Catch: java.lang.Throwable -> L61
                if (r0 == 0) goto L60
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f5015b     // Catch: java.lang.Throwable -> L61
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
                com.amap.api.col.p0463l.C1732a3.m55741D(r2)     // Catch: java.lang.Throwable -> L84
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.p0463l.SDKLogHandler.m53863p(r2, r3, r4)     // Catch: java.lang.Throwable -> L84
                com.amap.api.col.3l.o9 r1 = com.amap.api.col.p0463l.AMapDelegateImp.this     // Catch: java.lang.Throwable -> L7f
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.f4859Z     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L7e
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f5015b     // Catch: java.lang.Throwable -> L7f
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
                com.amap.api.col.3l.o9 r2 = com.amap.api.col.p0463l.AMapDelegateImp.this     // Catch: java.lang.Throwable -> L93
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.f4859Z     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f5015b     // Catch: java.lang.Throwable -> L93
                if (r2 == 0) goto L97
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L93
                goto L97
            L93:
                r1 = move-exception
                r1.printStackTrace()
            L97:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AMapDelegateImp.RunnableC1917w0.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$x */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1918x implements Runnable {
        RunnableC1918x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
                aMapDelegateImp.f4901q.setAnchorX(Math.max(0, Math.min(aMapDelegateImp.f4904r0, AMapDelegateImp.this.f4871d0)));
                AMapDelegateImp aMapDelegateImp2 = AMapDelegateImp.this;
                aMapDelegateImp2.f4901q.setAnchorY(Math.max(0, Math.min(aMapDelegateImp2.f4906s0, AMapDelegateImp.this.f4874e0)));
                AMapDelegateImp aMapDelegateImp3 = AMapDelegateImp.this;
                aMapDelegateImp3.f4859Z.setProjectionCenter(aMapDelegateImp3.f4895n, AMapDelegateImp.this.f4901q.getAnchorX(), AMapDelegateImp.this.f4901q.getAnchorY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$y */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1919y extends AbstractRunnableC1909t0 {
        C1919y() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.p0463l.AMapDelegateImp.AbstractRunnableC1909t0, java.lang.Runnable
        public final void run() {
            super.run();
            AMapDelegateImp.this.m54316g(this.f4997e, this.f4995c, this.f4996d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$z */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1920z implements Runnable {
        RunnableC1920z() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AMapDelegateImp aMapDelegateImp = AMapDelegateImp.this;
            GLMapEngine gLMapEngine = aMapDelegateImp.f4859Z;
            if (gLMapEngine != null) {
                int i = aMapDelegateImp.f4895n;
                IndoorBuilding indoorBuilding = AMapDelegateImp.this.f4907t;
                gLMapEngine.setIndoorBuildingToBeActive(i, indoorBuilding.activeFloorName, indoorBuilding.activeFloorIndex, indoorBuilding.poiid);
            }
        }
    }

    public AMapDelegateImp(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    /* renamed from: B */
    private void m54352B(MotionEvent motionEvent) {
        if (!this.f4915x || this.f4919z == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        if (this.f4919z.getLatlng() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x, y, obtain);
            LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
            obtain.recycle();
            this.f4919z.setLatLng(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m54351C(CameraPosition cameraPosition) {
        if (this.f4901q.getMapLanguage().equals("en")) {
            boolean m54344J = m54344J(cameraPosition);
            if (m54344J != this.f4821G) {
                this.f4821G = m54344J;
                m54278z(this.f4895n, m54344J);
            }
        } else if (this.f4821G) {
        } else {
            this.f4821G = true;
            m54278z(this.f4895n, true);
        }
    }

    /* renamed from: D */
    private void m54350D(boolean z) {
        this.f4886i0 = z;
    }

    /* renamed from: E */
    private float m54349E() {
        if (this.f4901q != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    /* renamed from: G */
    private void m54347G(int i) {
        if (this.f4888j0) {
            this.f4888j0 = false;
        }
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        m54334T(i);
    }

    /* renamed from: I */
    private void m54345I(MotionEvent motionEvent) {
        queueEvent(new RunnableC1907s0(motionEvent));
    }

    /* renamed from: J */
    private boolean m54344J(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            try {
                return !RegionUtil.m53890c(mapConfig.getGeoRectangle().getClipRect());
            } catch (Throwable th) {
                th.printStackTrace();
                C1732a3.m55741D(th);
                return false;
            }
        }
        return false;
    }

    /* renamed from: K */
    private void m54343K() {
        if (this.f4892l0) {
            this.f4865b0.m54894b();
            this.f4868c0 = true;
            this.f4888j0 = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    /* renamed from: L */
    private void m54342L(int i) {
        m54334T(i);
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    /* renamed from: M */
    private boolean m54341M(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> m53384a = this.f4864b.m53384a(AMap.OnPolylineClickListener.class.hashCode());
            if (m53384a != null && m53384a.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
                obtain.recycle();
                Polyline hitOverlay = this.f4891l.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (m53384a) {
                        for (AMap.OnPolylineClickListener onPolylineClickListener : m53384a) {
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

    /* renamed from: O */
    private void m54339O() {
        this.f4868c0 = true;
        this.f4888j0 = false;
        if (this.f4811B) {
            this.f4811B = false;
        }
        if (this.f4809A) {
            this.f4809A = false;
        }
        if (this.f4813C) {
            this.f4813C = false;
        }
        try {
            if (this.f4913w) {
                List m53384a = this.f4864b.m53384a(AMap.OnMarkerDragListener.class.hashCode());
                if (m53384a != null && m53384a.size() > 0 && this.f4917y != null) {
                    synchronized (m53384a) {
                        for (int i = 0; i < m53384a.size(); i++) {
                            ((AMap.OnMarkerDragListener) m53384a.get(i)).onMarkerDragEnd(this.f4917y);
                        }
                    }
                    this.f4917y = null;
                }
                this.f4913w = false;
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.f4915x) {
            if (this.f4919z != null) {
                this.f4919z = null;
            }
            this.f4915x = false;
        }
    }

    /* renamed from: P */
    private void m54338P(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            if (i == 0) {
                if (mapOverlayViewGroupBase.mo54848b()) {
                    this.f4889k.mo54829l(Boolean.FALSE);
                    this.f4889k.mo54846c();
                }
            } else if (mapOverlayViewGroupBase.mo54848b()) {
            } else {
                this.f4889k.mo54829l(Boolean.TRUE);
                this.f4889k.mo54846c();
            }
        }
    }

    /* renamed from: Q */
    private boolean m54337Q(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
        obtain.recycle();
        boolean z = true;
        BaseOverlay hitBaseOverlay = this.f4891l.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.f4891l.set2Top(marker.getId());
                List<AMap.OnMarkerClickListener> m53384a = this.f4864b.m53384a(AMap.OnMarkerClickListener.class.hashCode());
                if (m53384a != null && m53384a.size() > 0) {
                    synchronized (m53384a) {
                        if (m53384a.size() == 1) {
                            boolean onMarkerClick = ((AMap.OnMarkerClickListener) m53384a.get(0)).onMarkerClick(marker);
                            if (onMarkerClick) {
                                return true;
                            }
                            z = onMarkerClick;
                        } else {
                            boolean z2 = false;
                            for (AMap.OnMarkerClickListener onMarkerClickListener : m53384a) {
                                z2 |= onMarkerClickListener.onMarkerClick(marker);
                            }
                            if (z2) {
                                return true;
                            }
                            z = z2;
                        }
                    }
                }
                this.f4891l.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(CameraUpdateFactoryDelegate.m54550e(obtain2));
                }
                return z;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: S */
    private void m54335S() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.f4895n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.f4901q.setSX(((Point) obtain).x);
        this.f4901q.setSY(((Point) obtain).y);
        this.f4901q.setSZ(gLMapState.getMapZoomer());
        this.f4901q.setSC(gLMapState.getCameraDegree());
        this.f4901q.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    /* renamed from: T */
    private void m54334T(int i) {
        queueEvent(new RunnableC1880f(i));
    }

    /* renamed from: U */
    private boolean m54333U(MotionEvent motionEvent) {
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.f4891l.getHitBaseOverlay(latLng, 3);
        if (hitBaseOverlay instanceof GLTFOverlay) {
            GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
            if (gLTFOverlay.isClickable()) {
                try {
                    this.f4891l.set2Top(gLTFOverlay.getId());
                    gLTFOverlay.tapClick();
                    return true;
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "AMapDelegateImp", "onGLTFTap");
                    th.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: V */
    static /* synthetic */ boolean m54332V(AMapDelegateImp aMapDelegateImp) {
        aMapDelegateImp.f4890k0 = false;
        return false;
    }

    /* renamed from: X */
    private LatLng m54330X() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f4901q.getSY(), 20);
            LatLng latLng = new LatLng(pixelsToLatLong.f7978y, pixelsToLatLong.f7977x, false);
            pixelsToLatLong.recycle();
            return latLng;
        }
        return null;
    }

    /* renamed from: Y */
    private boolean m54329Y(int i) {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i, 7);
        }
        return false;
    }

    /* renamed from: Z */
    private boolean m54328Z(MotionEvent motionEvent) {
        if (this.f4891l != null && this.f4912v0 != null) {
            DPoint obtain = DPoint.obtain();
            if (this.f4859Z != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.f4891l.getMultiPointItem(new LatLng(obtain.f7978y, obtain.f7977x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.f4912v0.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    /* renamed from: a0 */
    private synchronized void m54327a0() {
        synchronized (this.f4847T) {
            int size = this.f4847T.size();
            for (int i = 0; i < size; i++) {
                this.f4847T.get(i).m55423a().recycle();
            }
            this.f4847T.clear();
        }
    }

    /* renamed from: b */
    private int m54326b(int i, Rect rect, int i2, int i3) {
        int i4;
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine == null || i < 0) {
            i4 = 0;
        } else {
            i4 = gLMapEngine.getEngineIDWithType(i);
            if (!this.f4859Z.isEngineCreated(i4)) {
                int i5 = this.f4857Y.getResources().getDisplayMetrics().densityDpi;
                float f = this.f4857Y.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = i4;
                mapViewInitParam.f8413x = rect.left;
                mapViewInitParam.f8414y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i2;
                mapViewInitParam.screenHeight = i3;
                mapViewInitParam.screenScale = f;
                mapViewInitParam.textScale = this.f4883h0 * f;
                mapViewInitParam.mapZoomScale = this.f4880g0;
                mapViewInitParam.taskThreadCount = 3;
                this.f4859Z.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.f4859Z.getMapState(i4);
                mapState.setMapZoomer(this.f4901q.getSZ());
                mapState.setCameraDegree(this.f4901q.getSC());
                mapState.setMapAngle(this.f4901q.getSR());
                mapState.setMapGeoCenter(this.f4901q.getSX(), this.f4901q.getSY());
                this.f4859Z.setMapState(i4, mapState);
                this.f4880g0 = mapState.calMapZoomScalefactor(i2, i3, i5);
                this.f4859Z.setOvelayBundle(i4, new GLOverlayBundle<>(i4, this));
            } else {
                m54314h(i4, rect.left, rect.top, rect.width(), rect.height(), i2, i3);
            }
        }
        this.f4897o.set(false);
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039 A[Catch: all -> 0x0075, TryCatch #0 {all -> 0x0075, blocks: (B:21:0x0027, B:23:0x0039, B:25:0x003d, B:27:0x0043, B:29:0x0053, B:34:0x0071, B:28:0x0049, B:30:0x0059, B:32:0x0067, B:33:0x006c, B:20:0x0024), top: B:39:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059 A[Catch: all -> 0x0075, TryCatch #0 {all -> 0x0075, blocks: (B:21:0x0027, B:23:0x0039, B:25:0x003d, B:27:0x0043, B:29:0x0053, B:34:0x0071, B:28:0x0049, B:30:0x0059, B:32:0x0067, B:33:0x006c, B:20:0x0024), top: B:39:0x0024 }] */
    /* renamed from: b0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54325b0(int r6) {
        /*
            r5 = this;
            r5.f4825I = r6
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
            r5.f4825I = r2     // Catch: java.lang.Throwable -> L75
            goto L8
        L27:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f4901q     // Catch: java.lang.Throwable -> L75
            r1.setMapStyleMode(r0)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f4901q     // Catch: java.lang.Throwable -> L75
            r1.setMapStyleTime(r6)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f4901q     // Catch: java.lang.Throwable -> L75
            boolean r1 = r1.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L59
            com.amap.api.col.3l.s8 r1 = r5.f4914w0     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L49
            boolean r1 = r1.m53911p()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L49
            com.amap.api.col.3l.s8 r6 = r5.f4914w0     // Catch: java.lang.Throwable -> L75
            r6.m53910q()     // Catch: java.lang.Throwable -> L75
            goto L53
        L49:
            int r1 = r5.f4895n     // Catch: java.lang.Throwable -> L75
            r5.m54316g(r1, r0, r6)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r6 = r5.f4901q     // Catch: java.lang.Throwable -> L75
            r6.setCustomStyleEnable(r3)     // Catch: java.lang.Throwable -> L75
        L53:
            com.amap.api.col.3l.h r6 = r5.f4879g     // Catch: java.lang.Throwable -> L75
            r6.setLogoEnable(r2)     // Catch: java.lang.Throwable -> L75
            goto L71
        L59:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f4901q     // Catch: java.lang.Throwable -> L75
            java.lang.String r1 = r1.getMapLanguage()     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "en"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L6c
            java.lang.String r1 = "zh_cn"
            r5.setMapLanguage(r1)     // Catch: java.lang.Throwable -> L75
        L6c:
            int r1 = r5.f4895n     // Catch: java.lang.Throwable -> L75
            r5.m54316g(r1, r0, r6)     // Catch: java.lang.Throwable -> L75
        L71:
            r5.resetRenderTime()     // Catch: java.lang.Throwable -> L75
            return
        L75:
            r6 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.p0463l.SDKLogHandler.m53863p(r6, r0, r1)
            r6.printStackTrace()
            com.amap.api.col.p0463l.C1732a3.m55741D(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AMapDelegateImp.m54325b0(int):void");
    }

    /* renamed from: c0 */
    private boolean m54323c0(MotionEvent motionEvent) throws RemoteException {
        try {
            List m53384a = this.f4864b.m53384a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay m53373f = this.f4870d.m53373f(motionEvent);
            if (m53373f != null && (m53373f instanceof Marker)) {
                synchronized (m53384a) {
                    for (int i = 0; i < m53384a.size(); i++) {
                        ((AMap.OnInfoWindowClickListener) m53384a.get(i)).onInfoWindowClick((Marker) m53373f);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: e */
    private void m54320e(double d, double d2) {
        this.f4920z0.post(new RunnableC1870a(d, d2));
    }

    /* renamed from: e0 */
    private void m54319e0() {
        if (this.f4817E > 0) {
            boolean canStopMapRender = this.f4859Z.canStopMapRender(this.f4895n);
            if (!canStopMapRender) {
                int i = this.f4817E - 1;
                this.f4817E = i;
                if (i > 0) {
                    this.f4859Z.renderAMap();
                    return;
                }
            }
            this.f4817E = 0;
            Message obtainMessage = this.f4920z0.obtainMessage(15, this.f4859Z.getScreenShot(this.f4895n, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
        }
    }

    /* renamed from: f */
    private void m54318f(int i) {
        int i2 = this.f4845S;
        if (i2 != -1) {
            this.f4862a0.setRenderFps(i2);
            resetRenderTime();
        } else if (!this.f4859Z.isInMapAction(i) && !this.f4888j0) {
            if (this.f4859Z.isInMapAnimation(i)) {
                this.f4862a0.setRenderFps(30.0f);
                this.f4862a0.resetTickCount(15);
            } else if (this.f4891l.isGLTFAnimated()) {
                this.f4862a0.setRenderFps(30.0f);
                this.f4862a0.resetTickCount(15);
            } else {
                this.f4862a0.setRenderFps(15.0f);
            }
        } else {
            this.f4862a0.setRenderFps(40.0f);
        }
        if (this.f4901q.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            m54282x();
            this.f4901q.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    /* renamed from: f0 */
    static /* synthetic */ boolean m54317f0(AMapDelegateImp aMapDelegateImp) {
        aMapDelegateImp.f4815D = false;
        return false;
    }

    /* renamed from: h */
    private void m54314h(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i, i2, i3, i4, i5, i6, i7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x011d, code lost:
        r1 = r10.f4864b.m53384a(com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener.class.hashCode());
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
        ((com.autonavi.base.p048ae.gmap.listener.AMapWidgetListener) r1.get(r2)).invalidateCompassView();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0143, code lost:
        monitor-exit(r1);
     */
    /* renamed from: h0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54313h0() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AMapDelegateImp.m54313h0():void");
    }

    /* renamed from: i */
    private synchronized void m54312i(int i, int i2, int i3, boolean z, StyleItem[] styleItemArr) {
        if (this.f4894m0 && this.f4892l0 && this.f4882h) {
            m54338P(i3);
            queueEvent(new RunnableC1878e(i, i2, i3, z, styleItemArr));
            return;
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4814C0;
        abstractRunnableC1909t0.f4997e = i;
        abstractRunnableC1909t0.f4995c = i2;
        abstractRunnableC1909t0.f4996d = i3;
        abstractRunnableC1909t0.f4993a = true;
    }

    /* renamed from: j */
    private void m54310j(int i, int i2, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f4897o.get() || !this.f4892l0 || (gLMapEngine = this.f4859Z) == null || (mapState = gLMapEngine.getMapState(this.f4895n)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i, i2, fPoint);
    }

    /* renamed from: j0 */
    private void m54309j0() {
        if (!this.f4905s) {
            this.f4920z0.sendEmptyMessage(16);
            this.f4905s = true;
            m54282x();
        }
        long j = this.f4856X0;
        if (j < 2) {
            this.f4856X0 = j + 1;
            return;
        }
        BlankView mo54844d = this.f4889k.mo54844d();
        if (mo54844d == null || mo54844d.getVisibility() == 8) {
            return;
        }
        StatisticsUtil.m53554g(this.f4857Y, System.currentTimeMillis() - this.f4916x0);
        this.f4920z0.post(new RunnableC1874c(mo54844d));
        this.f4859Z.setStyleChangeGradualEnable(this.f4895n, true);
    }

    /* renamed from: l */
    private void m54306l(MotionEvent motionEvent) throws RemoteException {
        if (!this.f4913w || this.f4917y == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        if (this.f4917y.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x, y, obtain);
            LatLng latLng = new LatLng(obtain.f7978y, obtain.f7977x);
            obtain.recycle();
            this.f4917y.setPosition(latLng);
            try {
                List m53384a = this.f4864b.m53384a(AMap.OnMarkerDragListener.class.hashCode());
                if (m53384a == null || m53384a.size() <= 0) {
                    return;
                }
                synchronized (m53384a) {
                    for (int i = 0; i < m53384a.size(); i++) {
                        ((AMap.OnMarkerDragListener) m53384a.get(i)).onMarkerDrag(this.f4917y);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: l0 */
    private void m54305l0() {
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    /* renamed from: n0 */
    private void m54301n0() {
        GLMapRender gLMapRender;
        if (!this.f4892l0 || (gLMapRender = this.f4862a0) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    /* renamed from: o */
    private void m54300o(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z = this.f4903r;
        abstractCameraUpdateMessage.isUseAnchor = z;
        if (z) {
            abstractCameraUpdateMessage.anchorX = this.f4901q.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f4901q.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f4901q;
    }

    /* renamed from: o0 */
    private void m54299o0() {
        if (this.f4835N) {
            return;
        }
        try {
            this.f4829K.setName("AuthThread");
            this.f4829K.start();
            this.f4835N = true;
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: p */
    private void m54298p(GLMapState gLMapState, int i, int i2, DPoint dPoint) {
        if (!this.f4892l0 || this.f4859Z == null) {
            return;
        }
        Point point = new Point();
        gLMapState.screenToP20Point(i, i2, point);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(point.x, point.y, 20);
        dPoint.f7977x = pixelsToLatLong.f7977x;
        dPoint.f7978y = pixelsToLatLong.f7978y;
        pixelsToLatLong.recycle();
    }

    /* renamed from: q */
    private void m54296q(boolean z) {
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            Object m51136j = aMapExtraInterfaceManager.m51136j();
            if (m51136j != null && (m51136j instanceof Boolean)) {
                MapConfig mapConfig = this.f4901q;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z && ((Boolean) m51136j).booleanValue());
                }
                if (z && ((Boolean) m51136j).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object m51136j2 = this.f4840P0.m51136j();
            if (m51136j2 != null && (m51136j2 instanceof Boolean)) {
                this.f4889k.mo54849a(((Boolean) m51136j2).booleanValue());
            }
            Object m51136j3 = this.f4840P0.m51136j();
            if (m51136j2 == null || !(m51136j2 instanceof Integer)) {
                return;
            }
            this.f4839P = ((Integer) m51136j3).intValue();
        }
    }

    /* renamed from: q0 */
    private void m54295q0() {
        if (this.f4837O) {
            return;
        }
        try {
            if (this.f4831L == null) {
                this.f4831L = new AuthProTask(this.f4857Y, this);
            }
            this.f4831L.setName("AuthProThread");
            this.f4831L.start();
            this.f4837O = true;
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: r */
    private void m54294r(boolean z, byte[] bArr, boolean z2) {
        StyleParserResult styleParserResult;
        try {
            this.f4901q.setCustomStyleEnable(z);
            boolean z3 = false;
            if (this.f4901q.isHideLogoEnable()) {
                this.f4879g.setLogoEnable(!z);
            }
            if (z) {
                m54346H(this.f4895n, true);
                StyleParser styleParser = new StyleParser();
                MyTrafficStyle myTrafficStyle = this.f4827J;
                if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                    styleParser.m55507i(this.f4827J.getTrafficRoadBackgroundColor());
                }
                if (this.f4901q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f4901q.getCustomTextureResourcePath())) {
                    z3 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    styleParserResult = styleParser.m55511e(bArr, z3);
                    if (styleParserResult != null && (styleItemArr = styleParserResult.m55251c()) != null) {
                        this.f4901q.setUseProFunction(true);
                    }
                } else {
                    styleParserResult = null;
                }
                if (styleItemArr == null && (styleParserResult = styleParser.m55512d(this.f4901q.getCustomStylePath(), z3)) != null) {
                    styleItemArr = styleParserResult.m55251c();
                }
                if (styleParser.m55515a() != 0) {
                    this.f4901q.setCustomBackgroundColor(styleParser.m55515a());
                }
                if (styleParserResult != null && styleParserResult.m55250d() != null) {
                    if (this.f4851V != null) {
                        this.f4851V.m53409d((String) styleParserResult.m55250d());
                        this.f4851V.m53410c(styleParserResult);
                        this.f4851V.m53412b();
                        return;
                    }
                    return;
                }
                m54292s(styleItemArr, z2);
                return;
            }
            m54346H(this.f4895n, false);
            m54316g(this.f4895n, this.f4901q.getMapStyleMode(), this.f4901q.getMapStyleTime());
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: s */
    private void m54292s(StyleItem[] styleItemArr, boolean z) {
        if (z || (styleItemArr != null && styleItemArr.length > 0)) {
            m54312i(this.f4895n, 0, 0, true, styleItemArr);
            StatisticsUtil.m53551j(this.f4857Y, true);
            return;
        }
        StatisticsUtil.m53551j(this.f4857Y, false);
    }

    /* renamed from: t */
    private boolean m54290t(int i, int i2) {
        AbstractCameraUpdateMessage m54551d;
        if (this.f4892l0 && ((int) m54349E()) < this.f4901q.getMaxZoomLevel()) {
            try {
                if (!this.f4903r && !this.f4879g.isZoomInByScreenCenter()) {
                    Point point = this.f4854W0;
                    point.x = i;
                    point.y = i2;
                    m54551d = CameraUpdateFactoryDelegate.m54551d(1.0f, point);
                } else {
                    m54551d = CameraUpdateFactoryDelegate.m54551d(1.0f, null);
                }
                animateCamera(m54551d);
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
            return true;
        }
        return false;
    }

    /* renamed from: t0 */
    private void m54289t0() {
        try {
            LatLngBounds limitLatLngBounds = this.f4901q.getLimitLatLngBounds();
            if (this.f4859Z != null && m54288u(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.f4895n, this.f4859Z.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.f4901q.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f4901q.setLimitIPoints(null);
    }

    /* renamed from: u */
    private static boolean m54288u(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    /* renamed from: v */
    private boolean m54286v(boolean z, boolean z2) {
        if (z) {
            if (this.f4848T0) {
                AuthLogUtil.m54855c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.f4846S0 = true;
        }
        if (z2) {
            if (this.f4846S0) {
                AuthLogUtil.m54855c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
                return true;
            }
            this.f4848T0 = true;
            return false;
        }
        return false;
    }

    /* renamed from: v0 */
    private void m54285v0() {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53383b();
        }
    }

    /* renamed from: x0 */
    private void m54281x0() {
        GlShaderManager glShaderManager = this.f4910u0;
        if (glShaderManager != null) {
            glShaderManager.m53807a();
            this.f4910u0 = null;
        }
    }

    /* renamed from: y */
    private void m54280y(int i) {
        queueEvent(new RunnableC1876d(i));
    }

    /* renamed from: A */
    public final void m54353A(Size size) {
        m54314h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.f4889k.mo54840f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        m54350D(true);
    }

    /* renamed from: H */
    public final void m54346H(int i, boolean z) {
        if (this.f4892l0 && this.f4894m0) {
            resetRenderTime();
            queueEvent(new RunnableC1886i(z, i));
            return;
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4838O0;
        abstractRunnableC1909t0.f4994b = z;
        abstractRunnableC1909t0.f4993a = true;
        abstractRunnableC1909t0.f4997e = i;
    }

    @Override // com.amap.api.col.p0463l.AMapCustomStyleManager.InterfaceC1942a
    /* renamed from: a */
    public final void mo53905a() {
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            aMapExtraInterfaceManager.m51137i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z) {
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            aMapExtraInterfaceManager.m51137i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f4891l.createId("AMAP3DMODELTILE");
            AMap3DModelTileOverlay aMap3DModelTileOverlay = new AMap3DModelTileOverlay(this.f4891l, aMap3DModelTileOverlayOptions, createId);
            this.f4891l.addOverlayObject(createId, aMap3DModelTileOverlay, aMap3DModelTileOverlayOptions);
            return aMap3DModelTileOverlay;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m60097clone = arcOptions.m60097clone();
            String createId = this.f4891l.createId("ARC");
            Arc arc = new Arc(this.f4891l, m60097clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m60097clone) : arc;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            StatisticsUtil.m53540u(this.f4857Y);
            String createId = this.f4891l.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.f4891l, createId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e) {
            e.printStackTrace();
            C1732a3.m55741D(e);
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
            CircleOptions m60099clone = circleOptions.m60099clone();
            String createId = this.f4891l.createId("CIRCLE");
            Circle circle = new Circle(this.f4891l, m60099clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m60099clone) : circle;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ContourLineOverlay addContourLineOverlay(ContourLineOptions contourLineOptions) {
        try {
            String createId = this.f4891l.createId("CONTOURLINE");
            ContourLineOverlay contourLineOverlay = new ContourLineOverlay(this.f4891l, contourLineOptions, createId);
            this.f4891l.addOverlayObject(createId, contourLineOverlay, contourLineOptions);
            return contourLineOverlay;
        } catch (Exception e) {
            C1732a3.m55741D(e);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.f4895n, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new RunnableC1875c0(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.f4891l.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.f4891l, gL3DModelOptions, createId);
        this.f4891l.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        try {
            if (FeatureManager.m55016a().m55013d() && !FeatureManager.m55016a().m55014c("feature_gltf")) {
                C1732a3.m55741D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
                return null;
            }
            resetRenderTime();
            GLTFOverlayOptions m60100clone = gLTFOverlayOptions.m60100clone();
            String createId = this.f4891l.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.f4891l, m60100clone, createId);
            this.f4891l.addOverlayObject(createId, gLTFOverlay, m60100clone);
            return gLTFOverlay;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.f4892l0 || this.f4859Z == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.f4903r;
            abstractGestureMapMessage.anchorX = this.f4901q.getAnchorX();
            abstractGestureMapMessage.anchorY = this.f4901q.getAnchorY();
            this.f4859Z.addGestureMessage(i, abstractGestureMapMessage, this.f4879g.isGestureScaleByMapCenter(), this.f4901q.getAnchorX(), this.f4901q.getAnchorY());
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
            GroundOverlayOptions m60101clone = groundOverlayOptions.m60101clone();
            String createId = this.f4891l.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.f4891l, m60101clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m60101clone) : groundOverlay;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
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
            String createId = this.f4891l.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.f4891l.addOverlayObject(createId, new HeatMapGridLayer(this.f4891l, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
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
            String createId = this.f4891l.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.f4891l.addOverlayObject(createId, new HeatMapLayer(this.f4891l, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            if (FeatureManager.m55016a().m55013d() && !FeatureManager.m55016a().m55014c("feature_mvt")) {
                C1732a3.m55741D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
                return null;
            }
            String createId = this.f4891l.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.f4891l, mVTTileOverlayOptions, createId);
            this.f4891l.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m60103clone = markerOptions.m60103clone();
            String createId = this.f4891l.createId("MARKER");
            Marker marker = new Marker(this.f4891l, m60103clone, createId);
            this.f4891l.addOverlayObject(createId, marker, m60103clone);
            return marker;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3646d;
            LinkLogManager.m55488f(str, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i = 0; i < arrayList.size(); i++) {
                MarkerOptions markerOptions = arrayList.get(i);
                if (arrayList.get(i) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new RunnableC1888j(builder), 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3646d;
            LinkLogManager.m55485i(str, "addMarkers failed " + th.getMessage(), arrayList);
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
            MultiPointOverlayOptions m60104clone = multiPointOverlayOptions.m60104clone();
            String createId = this.f4891l.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.f4891l, m60104clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m60104clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        RouteOverlayInner routeOverlayInner = new RouteOverlayInner(this.f4895n, getContext(), this);
        queueEvent(new RunnableC1877d0(routeOverlayInner));
        return new RouteOverlay(routeOverlayInner);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m60105clone = navigateArrowOptions.m60105clone();
            String createId = this.f4891l.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.f4891l, m60105clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m60105clone) : navigateArrow;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.f4859Z;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.f4859Z.addOverlayTexture(i, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            StatisticsUtil.m53547n(this.f4857Y);
            String createId = this.f4891l.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.f4891l.addOverlayObject(createId, new ParticleOverlay(this.f4891l, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
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
            PolygonOptions m60106clone = polygonOptions.m60106clone();
            String createId = this.f4891l.createId("POLYGON");
            Polygon polygon = new Polygon(this.f4891l, m60106clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m60106clone) : polygon;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3646d;
            LinkLogManager.m55487g(str, "addPolygon failed " + th.getMessage(), polygonOptions);
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
            String createId = this.f4891l.createId("POLYLINE");
            Polyline polyline = (Polyline) this.f4891l.addOverlayObject(createId, new Polyline(this.f4891l, polylineOptions, createId), polylineOptions);
            LinkLogManager.m55481m(LinkLogConfig.f3646d, "addPolyline ".concat(String.valueOf(createId)));
            return polyline;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            String str = LinkLogConfig.f3646d;
            LinkLogManager.m55486h(str, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53380e(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f4891l.createId("TEXT");
            TextOptions m60107clone = textOptions.m60107clone();
            MarkerOptions m54011b = OverlayFormatter.m54011b(m60107clone);
            Marker marker = new Marker(this.f4891l, m54011b, createId);
            marker.setObject(m60107clone.getObject());
            this.f4891l.addOverlayObject(createId, marker, m54011b);
            return new Text(marker, m60107clone);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                StatisticsUtil.m53558c(this.f4857Y);
            }
            String createId = this.f4891l.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.f4891l, tileOverlayOptions, createId);
            this.f4891l.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f4859Z;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i) || this.f4859Z.isInMapAnimation(i)))) {
            int i2 = this.f4845S;
            if (i2 != -1) {
                this.f4862a0.setRenderFps(i2);
            } else {
                this.f4862a0.setRenderFps(15.0f);
            }
            if (this.f4877f0 != mapZoomer) {
                this.f4877f0 = mapZoomer;
            }
        }
        if (this.f4898o0) {
            return;
        }
        this.f4898o0 = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i, GLMapState gLMapState) {
        m54313h0();
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            aMapExtraInterfaceManager.m51141e();
        }
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f4850U0 = this.f4891l.draw(1, this.f4839P, this.f4918y0) ? this.f4850U0 : this.f4850U0 + 1;
        GLMapEngine gLMapEngine2 = this.f4859Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f4891l.draw(2, this.f4839P, this.f4918y0);
        GLMapEngine gLMapEngine2 = this.f4859Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.f4841Q;
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
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i, GLMapState gLMapState) {
        m54313h0();
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f4850U0 = this.f4891l.draw(0, this.f4839P, this.f4918y0) ? this.f4850U0 : this.f4850U0 + 1;
        GLMapEngine gLMapEngine2 = this.f4859Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    /* renamed from: c */
    public final Size m54324c(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        m54314h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.f4889k.mo54840f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        m54350D(false);
        return size2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i == i2 && i2 == i3 && i3 == i4 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng != null && latLng2 != null && this.f4892l0 && !this.f4897o.get()) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(this.f4895n, this.f4859Z.getNativeInstance());
            Pair<Float, IPoint> m55692r = C1732a3.m55692r(mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            if (m55692r != null) {
                DPoint obtain = DPoint.obtain();
                Object obj = m55692r.second;
                GLMapState.geo2LonLat(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y, obtain);
                Pair<Float, LatLng> pair = new Pair<>(m55692r.first, new LatLng(obtain.f7978y, obtain.f7977x));
                obtain.recycle();
                return pair;
            }
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain2.f7978y, obtain2.f7977x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        IndoorBuilding indoorBuilding;
        if (getZoomLevel() < 17.0f || (indoorBuilding = this.f4907t) == null || indoorBuilding.f5649g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.f4907t.f5649g;
        m54310j(point.x, point.y, obtain);
        return this.f4823H.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(this.f4895n);
            return true;
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.f4891l.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(String str, boolean z, int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54827n(str, Boolean.valueOf(z), Integer.valueOf(i));
        }
        UiSettingsDelegateImp uiSettingsDelegateImp = this.f4879g;
        if (uiSettingsDelegateImp != null) {
            uiSettingsDelegateImp.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i, boolean z) {
        if (this.f4897o.get()) {
            return;
        }
        try {
            List m53384a = this.f4864b.m53384a(AMapWidgetListener.class.hashCode());
            if (m53384a == null || m53384a.size() <= 0) {
                return;
            }
            this.f4889k.mo54829l(Boolean.valueOf(!z));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i, int i2) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            this.f4871d0 = i;
            this.f4874e0 = i2;
            mapConfig.setMapWidth(i);
            this.f4901q.setMapHeight(i2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i, GL10 gl10, int i2, int i3) {
        WindowManager windowManager;
        String str = LinkLogConfig.f3645c;
        LinkLogManager.m55489e(str, "changeSurface " + i2 + " " + i3);
        this.f4898o0 = false;
        if (!this.f4892l0) {
            createSurface(i, gl10, null);
        }
        GlMapGestureDetector glMapGestureDetector = this.f4865b0;
        if (glMapGestureDetector != null && this.f4857Y != null && ((this.f4871d0 != glMapGestureDetector.m54889g() || this.f4874e0 != this.f4865b0.m54886j()) && (windowManager = (WindowManager) this.f4857Y.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f4865b0.m54893c(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.f4871d0 = i2;
        this.f4874e0 = i3;
        this.f4823H = new Rect(0, 0, i2, i3);
        this.f4895n = m54326b(i, new Rect(0, 0, this.f4871d0, this.f4874e0), this.f4871d0, this.f4874e0);
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "create engine with frame complete");
        if (!this.f4894m0) {
            MapConfig mapConfig = this.f4901q;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.f4880g0);
                this.f4901q.setMapWidth(i2);
                this.f4901q.setMapHeight(i3);
            }
            this.f4859Z.setIndoorEnable(this.f4895n, false);
            this.f4859Z.setSimple3DEnable(this.f4895n, false);
            this.f4859Z.setStyleChangeGradualEnable(this.f4895n, false);
            this.f4859Z.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.f4857Y, initParam);
            this.f4859Z.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.f4894m0 = true;
        }
        if (!this.f4903r) {
            this.f4901q.setAnchorX(i2 >> 1);
            this.f4901q.setAnchorY(i3 >> 1);
        } else {
            this.f4901q.setAnchorX(Math.max(1, Math.min(this.f4904r0, i2 - 1)));
            this.f4901q.setAnchorY(Math.max(1, Math.min(this.f4906s0, i3 - 1)));
        }
        this.f4859Z.setProjectionCenter(this.f4895n, this.f4901q.getAnchorX(), this.f4901q.getAnchorY());
        this.f4882h = true;
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4832L0;
        if (abstractRunnableC1909t0.f4993a) {
            abstractRunnableC1909t0.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t02 = this.f4814C0;
        if (abstractRunnableC1909t02.f4993a) {
            abstractRunnableC1909t02.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t03 = this.f4816D0;
        if (abstractRunnableC1909t03.f4993a) {
            abstractRunnableC1909t03.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t04 = this.f4810A0;
        if (abstractRunnableC1909t04.f4993a) {
            abstractRunnableC1909t04.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t05 = this.f4818E0;
        if (abstractRunnableC1909t05.f4993a) {
            abstractRunnableC1909t05.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t06 = this.f4838O0;
        if (abstractRunnableC1909t06.f4993a) {
            abstractRunnableC1909t06.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t07 = this.f4820F0;
        if (abstractRunnableC1909t07.f4993a) {
            abstractRunnableC1909t07.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t08 = this.f4822G0;
        if (abstractRunnableC1909t08.f4993a) {
            abstractRunnableC1909t08.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t09 = this.f4824H0;
        if (abstractRunnableC1909t09.f4993a) {
            abstractRunnableC1909t09.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t010 = this.f4834M0;
        if (abstractRunnableC1909t010.f4993a) {
            abstractRunnableC1909t010.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t011 = this.f4812B0;
        if (abstractRunnableC1909t011.f4993a) {
            abstractRunnableC1909t011.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t012 = this.f4826I0;
        if (abstractRunnableC1909t012.f4993a) {
            abstractRunnableC1909t012.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t013 = this.f4828J0;
        if (abstractRunnableC1909t013 != null) {
            abstractRunnableC1909t013.run();
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t014 = this.f4830K0;
        if (abstractRunnableC1909t014 != null) {
            abstractRunnableC1909t014.run();
        }
        CustomRenderer customRenderer = this.f4841Q;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i2, i3);
        }
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            aMapExtraInterfaceManager.m51142d();
        }
        Handler handler = this.f4920z0;
        if (handler != null) {
            handler.post(this.f4836N0);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.f4901q == null || this.f4897o.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.f4901q.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds != null) {
                IPoint[] limitIPoints = this.f4901q.getLimitIPoints();
                if (limitIPoints == null) {
                    IPoint obtain = IPoint.obtain();
                    LatLng latLng = limitLatLngBounds.northeast;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                    IPoint obtain2 = IPoint.obtain();
                    LatLng latLng2 = limitLatLngBounds.southwest;
                    GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                    IPoint[] iPointArr = {obtain, obtain2};
                    this.f4901q.setLimitIPoints(iPointArr);
                    limitIPoints = iPointArr;
                }
                float m55700j = C1732a3.m55700j(this.f4901q, ((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, getMapWidth(), getMapHeight());
                float mapZoomer = iGLMapState.getMapZoomer();
                if (this.f4901q.isSetLimitZoomLevel()) {
                    float maxZoomLevel = this.f4901q.getMaxZoomLevel();
                    float minZoomLevel = this.f4901q.getMinZoomLevel();
                    float max = Math.max(m55700j, Math.min(mapZoomer, maxZoomLevel));
                    if (m55700j <= maxZoomLevel) {
                        maxZoomLevel = max;
                    }
                    m55700j = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                } else if (m55700j <= 0.0f || mapZoomer >= m55700j) {
                    m55700j = mapZoomer;
                }
                iGLMapState.setMapZoomer(m55700j);
                IPoint obtain3 = IPoint.obtain();
                iGLMapState.getMapGeoCenter(obtain3);
                int[] m55724U = C1732a3.m55724U(((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, this.f4901q, iGLMapState, ((Point) obtain3).x, ((Point) obtain3).y);
                iGLMapState.setMapGeoCenter(m55724U[0], m55724U[1]);
                obtain3.recycle();
            } else if (this.f4901q.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.f4901q.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f4901q.getMaxZoomLevel())));
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f) throws RemoteException {
        return C1732a3.m55704h(this.f4901q, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "clear");
            C1732a3.m55741D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.f4891l.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i) {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.f4895n, i);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.f4891l;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int createOverlayTexture(int i, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.f4859Z;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i, bitmap);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.AMapDelegateImp.createSurface(int, javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.f4897o.set(true);
        LinkLogManager.m55489e(LinkLogConfig.f3645c, "destroy map");
        try {
            LocationSource locationSource = this.f4911v;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.f4911v = null;
            this.f4908t0 = null;
            GLMapRender gLMapRender = this.f4862a0;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            m54327a0();
            Thread thread = this.f4829K;
            if (thread != null) {
                thread.interrupt();
                this.f4829K = null;
            }
            Thread thread2 = this.f4831L;
            if (thread2 != null) {
                thread2.interrupt();
                this.f4831L = null;
            }
            AuthTerrainTask authTerrainTask = this.f4833M;
            if (authTerrainTask != null) {
                authTerrainTask.m55263c();
                this.f4833M = null;
            }
            CustomStyleTask customStyleTask = this.f4849U;
            if (customStyleTask != null) {
                customStyleTask.m53611a();
                this.f4849U = null;
            }
            CustomStyleTextureTask customStyleTextureTask = this.f4851V;
            if (customStyleTextureTask != null) {
                customStyleTextureTask.m53411b(null);
                this.f4851V.m53414a();
                this.f4851V = null;
            }
            InfoCollectUtils.m54406f();
            GLMapEngine gLMapEngine = this.f4859Z;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                queueEvent(new RunnableC1873b0());
                int i = 0;
                while (this.f4859Z != null) {
                    int i2 = i + 1;
                    if (i >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e) {
                        C1732a3.m55741D(e);
                    }
                    i = i2;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.f4887j;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C1732a3.m55741D(e2);
                }
            }
            MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
            if (mapOverlayViewGroupBase != null) {
                mapOverlayViewGroupBase.mo54838g();
                this.f4889k = null;
            }
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay != null) {
                myLocationOverlay.m54233n();
                this.f4909u = null;
            }
            this.f4911v = null;
            this.f4861a = null;
            m54285v0();
            this.f4827J = null;
            LinkLogManager.m55493a();
            SDKLogHandler.m53866m();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "destroy");
            C1732a3.m55741D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i) {
        this.f4900p0.lock();
        try {
            if (this.f4892l0) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                m54281x0();
                GLMapEngine gLMapEngine = this.f4859Z;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.f4895n) != null) {
                        this.f4859Z.getOverlayBundle(this.f4895n).removeAll(true);
                    }
                    this.f4859Z.destroyAMapEngine();
                    this.f4859Z = null;
                    int i2 = this.f4850U0;
                    if (i2 > 0) {
                        StatisticsUtil.m53557d(this.f4857Y, i2);
                    }
                    LinkLogManager.m55489e(LinkLogConfig.f3645c, "destroy engine complete");
                }
                AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
                if (aMapExtraInterfaceManager != null) {
                    aMapExtraInterfaceManager.m51140f();
                }
            }
            this.f4892l0 = false;
            this.f4894m0 = false;
            this.f4898o0 = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        if (this.f4897o.get() || this.f4859Z == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        m54318f(this.f4895n);
        this.f4859Z.renderAMap();
        this.f4859Z.pushRendererState();
        this.f4920z0.sendEmptyMessage(30);
        AMapCustomStyleManager aMapCustomStyleManager = this.f4914w0;
        if (aMapCustomStyleManager != null) {
            aMapCustomStyleManager.m53925a();
        }
        m54319e0();
        m54309j0();
        if (!this.f4896n0) {
            this.f4896n0 = true;
        }
        this.f4859Z.popRendererState();
        if (PureScreenCheckTool.m54071b()) {
            try {
                if (this.f4887j instanceof AMapGLTextureView) {
                    if (this.f4853W == null) {
                        this.f4853W = new PureScreenCheckTool();
                    }
                    this.f4853W.m54064i();
                    if (!this.f4853W.m54063j() || this.f4853W.m54065h()) {
                        return;
                    }
                    if (this.f4853W.m54070c(((AMapGLTextureView) this.f4887j).getBitmap())) {
                        if (PureScreenCheckTool.m54068e()) {
                            removecache();
                        }
                        if (PureScreenCheckTool.m54066g()) {
                            PureScreenCheckTool.m54062k();
                        }
                        LinkLogManager.m55482l(LinkLogConfig.f3649g, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    /* renamed from: g */
    public final synchronized void m54316g(int i, int i2, int i3) {
        m54312i(i, i2, i3, false, null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.f7977x = pixelsToLatLong.f7977x;
        dPoint.f7978y = pixelsToLatLong.f7978y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i, int i2, FPoint fPoint) {
        double d;
        double d2;
        double sx = this.f4901q.getSX();
        Double.isNaN(i);
        ((PointF) fPoint).x = (int) (d - sx);
        double sy = this.f4901q.getSY();
        Double.isNaN(i2);
        ((PointF) fPoint).y = (int) (d2 - sy);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMapExtraInterfaceManager getAMapExtraInterfaceManager() {
        return this.f4840P0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f4876f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f4873e == null) {
            this.f4873e = new UiSettings(this.f4879g);
        }
        return this.f4873e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.f4895n);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.f4903r);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final CameraPosition getCameraPositionPrj(boolean z) {
        LatLng m54330X;
        try {
            if (this.f4901q == null) {
                return null;
            }
            if (this.f4892l0 && !this.f4899p && this.f4859Z != null) {
                if (z) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng(this.f4901q.getAnchorX(), this.f4901q.getAnchorY(), obtain);
                    m54330X = new LatLng(obtain.f7978y, obtain.f7977x, false);
                    obtain.recycle();
                } else {
                    m54330X = m54330X();
                }
                return CameraPosition.builder().target(m54330X).bearing(this.f4901q.getSR()).tilt(this.f4901q.getSC()).zoom(this.f4901q.getSZ()).build();
            }
            DPoint obtain2 = DPoint.obtain();
            geo2Latlng((int) this.f4901q.getSX(), (int) this.f4901q.getSY(), obtain2);
            LatLng latLng = new LatLng(obtain2.f7978y, obtain2.f7977x);
            obtain2.recycle();
            return CameraPosition.builder().target(latLng).bearing(this.f4901q.getSR()).tilt(this.f4901q.getSC()).zoom(this.f4901q.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Context getContext() {
        return this.f4857Y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getCurrentWorldVectorMapStyle() {
        try {
            AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
            if (aMapExtraInterfaceManager != null) {
                Object m51136j = aMapExtraInterfaceManager.m51136j();
                return m51136j instanceof String ? (String) m51136j : "";
            }
            return "";
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMapCustomStyleManager getCustomStyleManager() {
        return this.f4914w0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return this.f4895n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.f4863a1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapEngine getGLMapEngine() {
        return this.f4859Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final View getGLMapView() {
        IGLSurfaceView iGLSurfaceView = this.f4887j;
        if (iGLSurfaceView instanceof View) {
            return (View) iGLSurfaceView;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i, IPoint iPoint) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.f4901q.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.f4891l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.f4895n);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final InfoWindowDelegate getInfoWindowDelegate() {
        return this.f4870d;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d, double d2, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d, d2, obtain);
        geo2Map(((Point) obtain).x, ((Point) obtain).y, fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d, double d2, IPoint iPoint) {
        if (this.f4897o.get() || !this.f4892l0 || this.f4859Z == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d, d2, 20);
            FPoint obtain = FPoint.obtain();
            m54310j(latLongToPixels.x, latLongToPixels.y, obtain);
            if (((PointF) obtain).x == -10000.0f && ((PointF) obtain).y == -10000.0f) {
                GLMapState gLMapState = (GLMapState) this.f4859Z.getNewMapState(this.f4895n);
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
            Rectangle geoRectangle = this.f4901q.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i = 0; i < 4; i++) {
                    GLMapState.geo2LonLat(((Point) clipRect[i]).x, ((Point) clipRect[i]).y, dPointArr[i]);
                }
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            return mapOverlayViewGroupBase.mo54851a(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.f4879g.getLogoPosition();
        } catch (RemoteException e) {
            SDKLogHandler.m53863p(e, "AMapDelegateImp", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.f4920z0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final LatLngBounds getMapBounds(LatLng latLng, float f, float f2, float f3) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.f4897o.get()) {
            return null;
        }
        float m55704h = C1732a3.m55704h(this.f4901q, f);
        GLMapState gLMapState = new GLMapState(this.f4895n, this.f4859Z.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f3);
            gLMapState.setMapAngle(f2);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
            gLMapState.setMapZoomer(m55704h);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        m54298p(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.f7978y, obtain2.f7977x, false);
        m54298p(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f7978y, obtain2.f7977x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final MapConfig getMapConfig() {
        return this.f4901q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        StatisticsUtil.m53544q(this.f4857Y);
        String m54147b = PreferenceTools.m54147b(this.f4857Y, "approval_number", UMCommonContent.f37744A, "");
        return !TextUtils.isEmpty(m54147b) ? m54147b : "GS (2023)551号 | GS (2023)2175号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.f4874e0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f4864b.m53380e(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), onmapprintscreenlistener);
            this.f4817E = 20;
            this.f4819F = true;
            resetRenderTime();
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.f4895n);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!C1732a3.m55736I(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        if (this.f4897o.get()) {
            return new ArrayList();
        }
        return this.f4891l.getMapScreenMarkers();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z) {
        try {
            this.f4864b.m53380e(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), onMapScreenShotListener);
            this.f4817E = 20;
            this.f4819F = z;
            resetRenderTime();
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.f4839P;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.f4825I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.f4871d0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.f4880g0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.f4843R;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f4901q;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f4901q;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.f4911v != null) {
            return this.f4861a.f5713b;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        MyLocationOverlay myLocationOverlay = this.f4909u;
        if (myLocationOverlay != null) {
            return myLocationOverlay.m54246a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.f4895n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f4859Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.f4895n);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List m53384a = this.f4864b.m53384a(AMap.OnCameraChangeListener.class.hashCode());
            if (m53384a == null && m53384a.size() != 0) {
                return (AMap.OnCameraChangeListener) m53384a.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i, int i2, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f4897o.get() || !this.f4892l0 || (gLMapEngine = this.f4859Z) == null || (mapState = gLMapEngine.getMapState(this.f4895n)) == null) {
            return;
        }
        mapState.screenToP20Point(i, i2, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i, int i2, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f4897o.get() || !this.f4892l0 || (gLMapEngine = this.f4859Z) == null || (mapState = gLMapEngine.getMapState(this.f4895n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i, i2, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) obtain).x, ((Point) obtain).y, 20);
        dPoint.f7977x = pixelsToLatLong.f7977x;
        dPoint.f7978y = pixelsToLatLong.f7978y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f4876f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.f4869c1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Rect getRect() {
        return this.f4823H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.f4887j.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        StatisticsUtil.m53543r(this.f4857Y);
        String m54147b = PreferenceTools.m54147b(this.f4857Y, "approval_number", "si", "");
        return !TextUtils.isEmpty(m54147b) ? m54147b : "GS (2023)4047号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "getScalePerPixel");
            C1732a3.m55741D(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.f4901q.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getTerrainApprovalNumber() {
        StatisticsUtil.m53542s(this.f4857Y);
        String m54147b = PreferenceTools.m54147b(this.f4857Y, "approval_number", "te", "");
        return !TextUtils.isEmpty(m54147b) ? m54147b : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IUiSettingsDelegate getUiSettings() {
        return this.f4879g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i) {
        GLMapState gLMapState = new GLMapState(this.f4895n, this.f4859Z.getNativeInstance());
        gLMapState.setMapZoomer(i);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            return mapOverlayViewGroupBase.mo54832j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.f4866b1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Point getWaterMarkerPositon() {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            return mapOverlayViewGroupBase.mo54852a();
        }
        return new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapLanguage() {
        return this.f4842Q0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapStyle() {
        return this.f4844R0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return m54349E();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng != null && latLng2 != null && this.f4892l0 && !this.f4897o.get()) {
                Pair<Float, IPoint> m55692r = C1732a3.m55692r(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
                if (m55692r != null) {
                    return ((Float) m55692r.first).floatValue();
                }
                GLMapState gLMapState = new GLMapState(this.f4895n, this.f4859Z.getNativeInstance());
                float mapZoomer = gLMapState.getMapZoomer();
                gLMapState.recycle();
                return mapZoomer;
            }
            return mapConfig.getSZ();
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int hideBuildings(List<LatLng> list) {
        if (this.f4859Z == null) {
            return -1;
        }
        FutureTask futureTask = new FutureTask(new CallableC1881f0(list));
        queueEvent(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        InfoWindowDelegate infoWindowDelegate = this.f4870d;
        if (infoWindowDelegate != null) {
            infoWindowDelegate.m53356w();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f4901q.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i) {
        return m54329Y(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.f4905s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.f4893m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f4901q.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.f4903r;
    }

    /* renamed from: k */
    public final void m54308k(int i, boolean z) {
        if (this.f4892l0 && this.f4894m0) {
            resetRenderTime();
            queueEvent(new RunnableC1882g(i, z));
            return;
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4818E0;
        abstractRunnableC1909t0.f4994b = z;
        abstractRunnableC1909t0.f4993a = true;
        abstractRunnableC1909t0.f4997e = i;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d, double d2, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d, d2, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f, float f2, IPoint iPoint) {
        double d = f;
        double sx = this.f4901q.getSX();
        Double.isNaN(d);
        ((Point) iPoint).x = (int) (d + sx);
        double d2 = f2;
        double sy = this.f4901q.getSY();
        Double.isNaN(d2);
        ((Point) iPoint).y = (int) (d2 + sy);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    /* renamed from: n */
    protected final void m54302n(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.f4888j0 && this.f4859Z.getAnimateionsCount() == 0 && this.f4859Z.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f4867c;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.f4887j.isEnabled()) {
                    try {
                        List<AMap.OnCameraChangeListener> m53384a = this.f4864b.m53384a(AMap.OnCameraChangeListener.class.hashCode());
                        if (m53384a != null && m53384a.size() != 0) {
                            if (cameraPosition == null) {
                                cameraPosition = getCameraPosition();
                            }
                            synchronized (m53384a) {
                                for (AMap.OnCameraChangeListener onCameraChangeListener : m53384a) {
                                    onCameraChangeListener.onCameraChangeFinish(cameraPosition);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.f4901q.resetChangedCounter();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : amapDelegateListenerManager.m53384a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.f4899p = true;
        m54347G(this.f4895n);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.f4899p = false;
        m54342L(this.f4895n);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message obtainMessage = this.f4920z0.obtainMessage();
        obtainMessage.what = 11;
        this.f4920z0.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i, MotionEvent motionEvent) {
        if (this.f4892l0) {
            m54290t((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.f4891l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.f4815D = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i, byte[] bArr) {
        IndoorBuilding indoorBuilding;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    indoorBuilding = new IndoorBuilding();
                    byte b = bArr[0];
                    indoorBuilding.f5643a = new String(bArr, 1, b, "utf-8");
                    int i2 = b + 1;
                    int i3 = i2 + 1;
                    byte b2 = bArr[i2];
                    indoorBuilding.f5644b = new String(bArr, i3, b2, "utf-8");
                    int i4 = i3 + b2;
                    int i5 = i4 + 1;
                    byte b3 = bArr[i4];
                    indoorBuilding.activeFloorName = new String(bArr, i5, b3, "utf-8");
                    int i6 = i5 + b3;
                    indoorBuilding.activeFloorIndex = GLConvertUtil.getInt(bArr, i6);
                    int i7 = i6 + 4;
                    int i8 = i7 + 1;
                    byte b4 = bArr[i7];
                    indoorBuilding.poiid = new String(bArr, i8, b4, "utf-8");
                    int i9 = i8 + b4;
                    int i10 = i9 + 1;
                    byte b5 = bArr[i9];
                    indoorBuilding.f5650h = new String(bArr, i10, b5, "utf-8");
                    int i11 = i10 + b5;
                    int i12 = GLConvertUtil.getInt(bArr, i11);
                    indoorBuilding.f5645c = i12;
                    int i13 = i11 + 4;
                    indoorBuilding.floor_indexs = new int[i12];
                    indoorBuilding.floor_names = new String[i12];
                    indoorBuilding.f5646d = new String[i12];
                    for (int i14 = 0; i14 < indoorBuilding.f5645c; i14++) {
                        indoorBuilding.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i13);
                        int i15 = i13 + 4;
                        int i16 = i15 + 1;
                        byte b6 = bArr[i15];
                        if (b6 > 0) {
                            indoorBuilding.floor_names[i14] = new String(bArr, i16, b6, "utf-8");
                            i16 += b6;
                        }
                        i13 = i16 + 1;
                        byte b7 = bArr[i16];
                        if (b7 > 0) {
                            indoorBuilding.f5646d[i14] = new String(bArr, i13, b7, "utf-8");
                            i13 += b7;
                        }
                    }
                    int i17 = GLConvertUtil.getInt(bArr, i13);
                    indoorBuilding.f5647e = i17;
                    int i18 = i13 + 4;
                    if (i17 > 0) {
                        indoorBuilding.f5648f = new int[i17];
                        for (int i19 = 0; i19 < indoorBuilding.f5647e; i19++) {
                            indoorBuilding.f5648f[i19] = GLConvertUtil.getInt(bArr, i18);
                            i18 += 4;
                        }
                    }
                    this.f4860Z0 = indoorBuilding;
                    post(new RunnableC1871a0());
                }
            } catch (Throwable th) {
                C1732a3.m55741D(th);
                th.printStackTrace();
                return;
            }
        }
        indoorBuilding = null;
        this.f4860Z0 = indoorBuilding;
        post(new RunnableC1871a0());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i, MotionEvent motionEvent) {
        int i2 = 0;
        try {
            this.f4809A = false;
            m54280y(i);
            BaseOverlay hitBaseOverlay = this.f4891l.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.f4917y = (Marker) hitBaseOverlay;
            }
            BaseOverlay hitBaseOverlay2 = this.f4891l.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.f4919z = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.f4917y;
            if (marker != null && marker.isDraggable()) {
                LatLng position = this.f4917y.getPosition();
                if (position != null) {
                    IPoint obtain = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain);
                    ((Point) obtain).y -= 60;
                    DPoint obtain2 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain).x, ((Point) obtain).y, obtain2);
                    this.f4917y.setPosition(new LatLng(obtain2.f7978y, obtain2.f7977x));
                    this.f4891l.set2Top(this.f4917y.getId());
                    List m53384a = this.f4864b.m53384a(AMap.OnMarkerDragListener.class.hashCode());
                    if (m53384a != null && m53384a.size() > 0) {
                        synchronized (m53384a) {
                            while (i2 < m53384a.size()) {
                                ((AMap.OnMarkerDragListener) m53384a.get(i2)).onMarkerDragStart(this.f4917y);
                                i2++;
                            }
                        }
                    }
                    this.f4913w = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
            } else {
                GLTFOverlay gLTFOverlay = this.f4919z;
                if (gLTFOverlay != null && gLTFOverlay.isDraggable()) {
                    LatLng latlng = this.f4919z.getLatlng();
                    if (latlng != null) {
                        IPoint obtain3 = IPoint.obtain();
                        getLatLng2Pixel(latlng.latitude, latlng.longitude, obtain3);
                        ((Point) obtain3).y -= 60;
                        DPoint obtain4 = DPoint.obtain();
                        getPixel2LatLng(((Point) obtain3).x, ((Point) obtain3).y, obtain4);
                        this.f4919z.setLatLng(new LatLng(obtain4.f7978y, obtain4.f7977x));
                        this.f4891l.set2Top(this.f4919z.getId());
                        this.f4915x = true;
                        obtain3.recycle();
                        obtain4.recycle();
                    }
                } else {
                    List m53384a2 = this.f4864b.m53384a(AMap.OnMapLongClickListener.class.hashCode());
                    if (m53384a2 != null && m53384a2.size() > 0) {
                        DPoint obtain5 = DPoint.obtain();
                        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain5);
                        synchronized (m53384a2) {
                            while (i2 < m53384a2.size()) {
                                ((AMap.OnMapLongClickListener) m53384a2.get(i2)).onMapLongClick(new LatLng(obtain5.f7978y, obtain5.f7977x));
                                i2++;
                            }
                        }
                        this.f4811B = true;
                        obtain5.recycle();
                    }
                }
            }
            this.f4862a0.resetTickCount(30);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapBlankClick(double d, double d2) {
        m54320e(d, d2);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapPOIClick(MapPoi mapPoi) {
        List m53384a;
        MapConfig mapConfig = this.f4901q;
        if (mapConfig == null || !mapConfig.isTouchPoiEnable() || (m53384a = this.f4864b.m53384a(AMap.OnPOIClickListener.class.hashCode())) == null || m53384a.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.f4920z0.sendMessage(obtain);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        m54335S();
        IGlOverlayLayer iGlOverlayLayer = this.f4891l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.f4862a0.setRenderFps(15.0f);
            this.f4887j.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.f4891l;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay != null) {
                myLocationOverlay.m54236k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i, MotionEvent motionEvent) {
        if (this.f4892l0) {
            try {
                m54280y(i);
                if (m54323c0(motionEvent) || m54337Q(motionEvent) || m54328Z(motionEvent)) {
                    return true;
                }
                m54341M(motionEvent);
                if (m54333U(motionEvent)) {
                    return true;
                }
                m54345I(motionEvent);
                return true;
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "onSingleTapUp");
                th.printStackTrace();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00aa -> B:56:0x00ad). Please submit an issue!!! */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4899p && this.f4892l0 && this.f4886i0) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f4852V0;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            getEngineIDWithGestureInfo(this.f4852V0);
            m54305l0();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                m54301n0();
                m54343K();
            } else if (action == 1) {
                m54339O();
            }
            if (motionEvent.getAction() == 2 && this.f4913w) {
                try {
                    m54306l(motionEvent);
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "AMapDelegateImp", "onDragMarker");
                    th.printStackTrace();
                }
                return true;
            } else if (motionEvent.getAction() == 2 && this.f4915x) {
                try {
                    m54352B(motionEvent);
                } catch (Throwable th2) {
                    SDKLogHandler.m53863p(th2, "AMapDelegateImp", "onDragGLTF");
                    th2.printStackTrace();
                }
                return true;
            } else {
                if (this.f4868c0) {
                    try {
                        List m53384a = this.f4864b.m53384a(AMap.SignleClickInterceptorListener.class.hashCode());
                        if (m53384a != null && m53384a.size() > 0) {
                            if (!((AMap.SignleClickInterceptorListener) m53384a.get(0)).isInterceptorSignleClick(motionEvent)) {
                                this.f4865b0.m54891e(motionEvent);
                            }
                        } else {
                            this.f4865b0.m54891e(motionEvent);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                try {
                    List m53384a2 = this.f4864b.m53384a(AMap.OnMapTouchListener.class.hashCode());
                    if (m53384a2 != null && m53384a2.size() > 0) {
                        this.f4920z0.removeMessages(14);
                        Message obtainMessage = this.f4920z0.obtainMessage();
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
    public final void pixel2Map(int i, int i2, PointF pointF) {
        if (!this.f4892l0 || this.f4899p || this.f4859Z == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i, i2, obtain);
        pointF.x = ((Point) obtain).x - ((float) this.f4901q.getSX());
        pointF.y = ((Point) obtain).y - ((float) this.f4901q.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.f4887j;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        try {
            long id = Thread.currentThread().getId();
            if (id != -1 && id == this.f4855X) {
                runnable.run();
            } else if (this.f4859Z != null) {
                this.f4887j.queueEvent(runnable);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (!this.f4897o.get() && this.f4892l0) {
            this.f4920z0.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54846c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        AMapCustomStyleManager aMapCustomStyleManager = this.f4914w0;
        if (aMapCustomStyleManager != null) {
            aMapCustomStyleManager.m53917j();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.f4859Z != null) {
            queueEvent(new RunnableC1879e0(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(String str) {
        try {
            this.f4891l.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.f4891l.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53379f(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
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
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.f4887j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        List m53384a;
        this.f4901q.resetMinMaxZoomPreference();
        try {
            if (!this.f4879g.isZoomControlsEnabled() || !this.f4901q.isNeedUpdateZoomControllerState() || (m53384a = this.f4864b.m53384a(AMapWidgetListener.class.hashCode())) == null || m53384a.size() <= 0) {
                return;
            }
            synchronized (m53384a) {
                for (int i = 0; i < m53384a.size(); i++) {
                    ((AMapWidgetListener) m53384a.get(i)).invalidateZoomController(this.f4901q.getSZ());
                }
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f4862a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z) throws RemoteException {
        try {
            m54347G(this.f4895n);
            m54308k(this.f4895n, z);
            m54342L(this.f4895n);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        GlMapGestureDetector glMapGestureDetector = this.f4865b0;
        if (glMapGestureDetector != null) {
            this.f4867c = aMapGestureListener;
            glMapGestureDetector.m54892d(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i, int i2) throws RemoteException {
        this.f4903r = true;
        this.f4904r0 = i;
        this.f4906s0 = i2;
        if (this.f4894m0 && this.f4892l0) {
            if (this.f4901q.getAnchorX() == this.f4904r0 && this.f4901q.getAnchorY() == this.f4906s0) {
                return;
            }
            this.f4901q.setAnchorX(this.f4904r0);
            this.f4901q.setAnchorY(this.f4906s0);
            queueEvent(new RunnableC1918x());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(boolean z) {
        try {
            if (this.f4892l0 && this.f4894m0) {
                resetRenderTime();
                queueEvent(new RunnableC1908t(z));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4826I0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (m54286v(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    m54295q0();
                }
                this.f4914w0.m53913n();
                this.f4914w0.m53923d(customMapStyleOptions);
                AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
                if (aMapExtraInterfaceManager != null) {
                    aMapExtraInterfaceManager.m51137i();
                }
            } catch (Throwable th) {
                C1732a3.m55741D(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f4901q.getCustomStyleID())) {
            return;
        }
        this.f4901q.setCustomStyleID(str);
        this.f4885i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f4901q.getCustomStylePath())) {
            return;
        }
        this.f4901q.setCustomStylePath(str);
        this.f4885i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.f4841Q = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4901q.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i, int i2) {
        if (this.f4902q0 == 0 || i2 != 5) {
            this.f4902q0 = i2;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z);
            if (this.f4901q.isCustomStyleEnable()) {
                this.f4879g.setLogoEnable(!z);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.f4897o.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f4907t = (IndoorBuilding) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new RunnableC1920z());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(boolean z) throws RemoteException {
        List m53384a;
        try {
            if (this.f4892l0 && !this.f4897o.get()) {
                this.f4901q.setIndoorEnable(z);
                resetRenderTime();
                if (z) {
                    GLMapEngine gLMapEngine = this.f4859Z;
                    if (gLMapEngine != null) {
                        gLMapEngine.setIndoorEnable(this.f4895n, true);
                    }
                } else {
                    GLMapEngine gLMapEngine2 = this.f4859Z;
                    if (gLMapEngine2 != null) {
                        gLMapEngine2.setIndoorEnable(this.f4895n, false);
                    }
                    MapConfig mapConfig = this.f4901q;
                    mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.f4901q.getMaxZoomLevel() : 20.0f;
                    try {
                        if (this.f4879g.isZoomControlsEnabled() && (m53384a = this.f4864b.m53384a(AMapWidgetListener.class.hashCode())) != null && m53384a.size() > 0) {
                            synchronized (m53384a) {
                                for (int i = 0; i < m53384a.size(); i++) {
                                    ((AMapWidgetListener) m53384a.get(i)).invalidateZoomController(this.f4901q.getSZ());
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                StatisticsUtil.m53545p(this.f4857Y, z);
                if (this.f4879g.isIndoorSwitchEnabled()) {
                    this.f4920z0.post(new RunnableC1898o(z));
                    return;
                }
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4834M0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        InfoWindowDelegate infoWindowDelegate;
        if (this.f4897o.get() || (infoWindowDelegate = this.f4870d) == null) {
            return;
        }
        infoWindowDelegate.m53370i(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(boolean z) throws RemoteException {
        queueEvent(new RunnableC1900p(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.f4897o.get()) {
                return;
            }
            LocationSource locationSource2 = this.f4911v;
            if (locationSource2 != null && (locationSource2 instanceof AMapReflectionLocationSource)) {
                locationSource2.deactivate();
            }
            this.f4911v = locationSource;
            if (locationSource != null) {
                this.f4889k.mo54828m(Boolean.TRUE);
            } else {
                this.f4889k.mo54828m(Boolean.FALSE);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54850a(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54845c(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i, float f) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54824q(Integer.valueOf(i), Float.valueOf(f));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
        if (mapOverlayViewGroupBase != null) {
            mapOverlayViewGroupBase.mo54835h(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z, boolean z2) {
        CustomStyleTask customStyleTask;
        if (this.f4892l0 && !this.f4897o.get()) {
            boolean z3 = z2 ? z2 : false;
            if (TextUtils.isEmpty(this.f4901q.getCustomStylePath()) && TextUtils.isEmpty(this.f4901q.getCustomStyleID())) {
                return;
            }
            if (z) {
                try {
                    if (this.f4901q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f4901q.getCustomStyleID()) && (customStyleTask = this.f4849U) != null) {
                        customStyleTask.m53609b(this.f4901q.getCustomStyleID());
                        this.f4849U.m53610b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    C1732a3.m55741D(th);
                    return;
                }
            }
            if (z2 || this.f4885i || (this.f4901q.isCustomStyleEnable() ^ z)) {
                m54294r(z, null, z3);
            }
            this.f4885i = false;
            return;
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4816D0;
        abstractRunnableC1909t0.f4993a = true;
        abstractRunnableC1909t0.f4994b = z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.f4901q) == null || mapConfig.isCustomStyleEnable() || this.f4901q.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.f4901q.setMapLanguage("zh_cn");
            this.f4839P = 0;
        } else {
            if (this.f4825I != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    C1732a3.m55741D(th);
                    th.printStackTrace();
                }
            }
            this.f4901q.setMapLanguage("en");
            this.f4839P = -10000;
        }
        try {
            m54351C(getCameraPosition());
        } catch (Throwable th2) {
            C1732a3.m55741D(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f4901q.setLimitLatLngBounds(latLngBounds);
            m54289t0();
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(boolean z) throws RemoteException {
        try {
            if (this.f4892l0 && this.f4894m0) {
                resetRenderTime();
                queueEvent(new RunnableC1902q(z));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4820F0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i) throws RemoteException {
        this.f4839P = i;
        this.f4918y0 = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i) throws RemoteException {
        MapConfig mapConfig;
        if (i != this.f4825I || ((mapConfig = this.f4901q) != null && mapConfig.isCustomStyleEnable())) {
            this.f4825I = i;
            m54325b0(i);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
            if (amapDelegateListenerManager != null) {
                amapDelegateListenerManager.m53382c(AMapWidgetListener.class.hashCode(), aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f) {
        this.f4901q.setMaxZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f) {
        this.f4901q.setMinZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        if (this.f4897o.get()) {
            return;
        }
        try {
            MapOverlayViewGroupBase mapOverlayViewGroupBase = this.f4889k;
            if (mapOverlayViewGroupBase != null) {
                LocationSource locationSource = this.f4911v;
                if (locationSource == null) {
                    mapOverlayViewGroupBase.mo54828m(Boolean.FALSE);
                } else if (z) {
                    locationSource.activate(this.f4861a);
                    this.f4889k.mo54828m(Boolean.TRUE);
                    if (this.f4909u == null) {
                        this.f4909u = new MyLocationOverlay(this, this.f4857Y);
                    }
                } else {
                    MyLocationOverlay myLocationOverlay = this.f4909u;
                    if (myLocationOverlay != null) {
                        myLocationOverlay.m54233n();
                        this.f4909u = null;
                    }
                    this.f4911v.deactivate();
                }
            }
            if (!z) {
                this.f4879g.setMyLocationButtonEnabled(z);
            }
            this.f4893m = z;
            resetRenderTime();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f) throws RemoteException {
        try {
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay != null) {
                myLocationOverlay.m54245b(f);
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f4897o.get()) {
            return;
        }
        try {
            if (this.f4909u == null) {
                this.f4909u = new MyLocationOverlay(this, this.f4857Y);
            }
            if (this.f4909u != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                LocationSource locationSource = this.f4911v;
                if (locationSource != null && (locationSource instanceof AMapReflectionLocationSource)) {
                    ((AMapReflectionLocationSource) locationSource).m55775d(myLocationStyle.getInterval());
                    ((AMapReflectionLocationSource) this.f4911v).m55776c(myLocationStyle.getMyLocationType());
                }
                this.f4909u.m54239h(myLocationStyle);
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i) throws RemoteException {
        try {
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay == null || myLocationOverlay.m54246a() == null) {
                return;
            }
            this.f4909u.m54246a().myLocationType(i);
            setMyLocationStyle(this.f4909u.m54246a());
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(boolean z, int i, int i2) throws RemoteException {
        try {
            if (this.f4892l0 && this.f4894m0) {
                resetRenderTime();
                queueEvent(new RunnableC1906s(z, i, i2));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4824H0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4998f = i;
            abstractRunnableC1909t0.f4999g = i2;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnIndoorBuildingActiveListener.class.hashCode(), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMapLoadedListener.class.hashCode(), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.f4912v0 = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnPOIClickListener.class.hashCode(), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f4864b;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.m53382c(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i) {
        try {
            if (i == -1) {
                this.f4845S = i;
            } else {
                this.f4845S = Math.max(10, Math.min(i, 40));
            }
            StatisticsUtil.m53541t(this.f4857Y);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i) {
        try {
            IGLSurfaceView iGLSurfaceView = this.f4887j;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(boolean z) throws RemoteException {
        try {
            if (this.f4892l0 && this.f4894m0) {
                resetRenderTime();
                queueEvent(new RunnableC1904r(z));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4822G0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z) {
        if (z) {
            return;
        }
        try {
            if (this.f4845S == -1) {
                m54301n0();
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setTerrainAuth(boolean z) {
        GLMapEngine gLMapEngine;
        if (this.f4897o.get() || (gLMapEngine = this.f4859Z) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z) {
        MapConfig mapConfig = this.f4901q;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(boolean z) throws RemoteException {
        try {
            if (this.f4892l0 && !this.f4897o.get()) {
                queueEvent(new RunnableC1896n(z, z));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4810A0;
            abstractRunnableC1909t0.f4994b = z;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (this.f4897o.get()) {
            return;
        }
        try {
            if (this.f4892l0 && this.f4894m0 && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new RunnableC1910u(bArr, myTrafficStyle));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4830K0;
            abstractRunnableC1909t0.f5000h = bArr;
            abstractRunnableC1909t0.f5001i = myTrafficStyle;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Exception e) {
            C1732a3.m55741D(e);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.f4897o.get()) {
            return;
        }
        try {
            if (this.f4892l0 && this.f4894m0 && bArr != null) {
                resetRenderTime();
                queueEvent(new RunnableC1916w(bArr));
                return;
            }
            AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4828J0;
            abstractRunnableC1909t0.f5000h = bArr;
            abstractRunnableC1909t0.f4993a = true;
            abstractRunnableC1909t0.f4997e = this.f4895n;
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i) {
        IGLSurfaceView iGLSurfaceView = this.f4887j;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(String str) {
        if (m54286v(false, true) || TextUtils.isEmpty(str) || this.f4901q == null || this.f4844R0.equals(str)) {
            return;
        }
        this.f4844R0 = str;
        AMapExtraInterfaceManager aMapExtraInterfaceManager = this.f4840P0;
        if (aMapExtraInterfaceManager != null) {
            aMapExtraInterfaceManager.m51137i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54841e(Integer.valueOf(i));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f) {
        this.f4880g0 = f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54847b(Boolean.valueOf(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void showHideBuildings(int i) {
        if (this.f4859Z == null) {
            return;
        }
        queueEvent(new RunnableC1885h0(i));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54822s(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        InfoWindowDelegate infoWindowDelegate;
        if (baseOverlayImp == null || (infoWindowDelegate = this.f4870d) == null) {
            return;
        }
        try {
            infoWindowDelegate.m53368k(baseOverlayImp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z) {
        if (this.f4897o.get()) {
            return;
        }
        this.f4889k.mo54839f(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54843d(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f4893m && this.f4911v != null) {
                if (this.f4909u == null) {
                    this.f4909u = new MyLocationOverlay(this, this.f4857Y);
                }
                if (location.getLongitude() != Utils.DOUBLE_EPSILON && location.getLatitude() != Utils.DOUBLE_EPSILON) {
                    this.f4909u.m54242e(location);
                }
                List m53384a = this.f4864b.m53384a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (m53384a != null && m53384a.size() > 0) {
                    synchronized (m53384a) {
                        for (int i = 0; i < m53384a.size(); i++) {
                            ((AMap.OnMyLocationChangeListener) m53384a.get(i)).onMyLocationChange(location);
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay != null) {
                myLocationOverlay.m54233n();
            }
            this.f4909u = null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54833i(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z) {
        MapOverlayViewGroupBase mapOverlayViewGroupBase;
        if (this.f4897o.get() || (mapOverlayViewGroupBase = this.f4889k) == null) {
            return;
        }
        mapOverlayViewGroupBase.mo54823r(Boolean.valueOf(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.f4859Z;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i) {
        GLMapEngine gLMapEngine;
        if (!this.f4892l0 || this.f4899p || (gLMapEngine = this.f4859Z) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.f4895n).getGLUnitWithWin(i);
    }

    /* renamed from: x */
    final void m54282x() {
        this.f4920z0.obtainMessage(17, 1, 0).sendToTarget();
    }

    /* renamed from: z */
    public final void m54278z(int i, boolean z) {
        if (this.f4892l0 && this.f4894m0) {
            resetRenderTime();
            queueEvent(new RunnableC1884h(z, i));
            return;
        }
        AbstractRunnableC1909t0 abstractRunnableC1909t0 = this.f4832L0;
        abstractRunnableC1909t0.f4994b = z;
        abstractRunnableC1909t0.f4993a = true;
        abstractRunnableC1909t0.f4997e = i;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i) {
        if (this.f4892l0 && ((int) m54349E()) > this.f4901q.getMinZoomLevel()) {
            try {
                animateCamera(CameraUpdateFactoryDelegate.m54543l());
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public AMapDelegateImp(IGLSurfaceView iGLSurfaceView, Context context, boolean z) {
        this.f4861a = null;
        this.f4864b = new AmapDelegateListenerManager();
        this.f4882h = false;
        this.f4885i = false;
        this.f4893m = false;
        this.f4897o = new AtomicBoolean(false);
        this.f4899p = false;
        this.f4901q = new MapConfig(true);
        this.f4903r = false;
        this.f4905s = false;
        this.f4913w = false;
        this.f4915x = false;
        this.f4917y = null;
        this.f4919z = null;
        this.f4809A = false;
        this.f4811B = false;
        this.f4813C = false;
        this.f4815D = false;
        this.f4817E = 0;
        this.f4819F = true;
        this.f4821G = true;
        this.f4823H = new Rect();
        this.f4825I = 1;
        this.f4827J = null;
        this.f4835N = false;
        this.f4837O = false;
        this.f4839P = 0;
        this.f4843R = -1;
        this.f4845S = -1;
        this.f4847T = new ArrayList();
        this.f4853W = null;
        this.f4855X = -1L;
        this.f4868c0 = false;
        this.f4877f0 = 0.0f;
        this.f4880g0 = 1.0f;
        this.f4883h0 = 1.0f;
        this.f4886i0 = true;
        this.f4888j0 = false;
        this.f4890k0 = false;
        this.f4892l0 = false;
        this.f4894m0 = false;
        this.f4896n0 = false;
        this.f4898o0 = false;
        this.f4900p0 = new ReentrantLock();
        this.f4902q0 = 0;
        this.f4918y0 = true;
        this.f4920z0 = new HandlerC1890k(Looper.getMainLooper());
        this.f4810A0 = new C1872b();
        this.f4812B0 = new C1894m();
        this.f4814C0 = new C1919y();
        this.f4816D0 = new C1887i0();
        this.f4818E0 = new C1889j0();
        this.f4820F0 = new C1891k0();
        this.f4822G0 = new C1893l0();
        this.f4824H0 = new C1895m0();
        this.f4826I0 = new C1914v();
        this.f4828J0 = new C1883g0();
        this.f4830K0 = new C1897n0();
        this.f4832L0 = new C1899o0();
        this.f4834M0 = new C1901p0();
        this.f4836N0 = new RunnableC1903q0();
        this.f4838O0 = new C1905r0();
        this.f4842Q0 = "";
        this.f4844R0 = "";
        this.f4846S0 = false;
        this.f4848T0 = false;
        this.f4850U0 = 0;
        this.f4852V0 = new EAMapPlatformGestureInfo();
        this.f4854W0 = new Point();
        this.f4856X0 = 0L;
        this.f4858Y0 = null;
        this.f4860Z0 = null;
        this.f4863a1 = new float[16];
        this.f4866b1 = new float[16];
        this.f4869c1 = new float[16];
        this.f4872d1 = null;
        this.f4875e1 = new float[12];
        this.f4878f1 = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f4881g1 = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f4884h1 = -1;
        this.f4857Y = context;
        PrivacyError m54995a = Privacy.m54995a(context, C1732a3.m55691s());
        Privacy.EnumC1812c enumC1812c = m54995a.f4676a;
        Privacy.EnumC1812c enumC1812c2 = Privacy.EnumC1812c.SuccessCode;
        if (enumC1812c == enumC1812c2) {
            LinkLogManager.m55490d(context);
            LinkLogManager.m55489e(LinkLogConfig.f3645c, "init map delegate");
        }
        AMapExtraInterfaceManager aMapExtraInterfaceManager = new AMapExtraInterfaceManager();
        this.f4840P0 = aMapExtraInterfaceManager;
        aMapExtraInterfaceManager.m51145a();
        this.f4840P0.m51144b();
        SDKLogHandler.m53871h(this.f4857Y);
        InfoCollectUtils.m54411a().m54410b(this.f4857Y);
        ConfigableConst.f3942b = C1780e4.m55243g(context);
        AndroidAssets.m54940a(this.f4857Y);
        this.f4865b0 = new GlMapGestureDetector(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f4862a0 = gLMapRender;
        this.f4887j = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        GlOverlayLayer glOverlayLayer = new GlOverlayLayer(this, this.f4857Y);
        this.f4891l = glOverlayLayer;
        this.f4859Z = new GLMapEngine(this.f4857Y, this);
        this.f4889k = new MapOverlayViewGroup(this.f4857Y, this, glOverlayLayer);
        this.f4879g = new UiSettingsDelegateImp(this);
        this.f4889k.mo54837g(new C1915v0(this, (byte) 0));
        this.f4908t0 = new C1911u0();
        iGLSurfaceView.setRenderMode(0);
        this.f4862a0.setRenderFps(15.0f);
        this.f4859Z.setMapListener(this);
        this.f4876f = new ProjectionDelegateImp(this);
        this.f4861a = new AMapOnLocationChangedListener(this);
        InfoWindowDelegate infoWindowDelegate = new InfoWindowDelegate(this.f4857Y);
        this.f4870d = infoWindowDelegate;
        infoWindowDelegate.m53367l(this.f4889k);
        this.f4870d.m53360s(new NativePopupOverlay(glOverlayLayer, context));
        this.f4829K = new AuthTask(this.f4857Y, this);
        this.f4911v = new AMapReflectionLocationSource(this.f4857Y);
        this.f4849U = new CustomStyleTask(this.f4857Y, this);
        CustomStyleTextureTask customStyleTextureTask = new CustomStyleTextureTask(this.f4857Y);
        this.f4851V = customStyleTextureTask;
        customStyleTextureTask.m53411b(this);
        m54296q(z);
        MapConfig mapConfig = this.f4901q;
        AMapCustomStyleManager aMapCustomStyleManager = new AMapCustomStyleManager(this, this.f4857Y, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.f4914w0 = aMapCustomStyleManager;
        aMapCustomStyleManager.m53924c(this);
        if (m54995a.f4676a != enumC1812c2) {
            this.f4901q.setMapEnable(false);
        }
        this.f4895n = this.f4859Z.getEngineIDWithType(1);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.f4897o.get() || this.f4859Z == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j;
        if (!this.f4899p && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.f4859Z.interruptAnimation();
                resetRenderTime();
                m54300o(abstractCameraUpdateMessage);
                this.f4859Z.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                C1732a3.m55741D(th);
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
            C1732a3.m55741D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f4920z0 == null || this.f4859Z == null) {
            return;
        }
        try {
            RunnableC1917w0 runnableC1917w0 = new RunnableC1917w0(this.f4857Y, onCacheRemoveListener);
            this.f4920z0.removeCallbacks(runnableC1917w0);
            this.f4920z0.post(runnableC1917w0);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }

    @Override // com.amap.api.col.p0463l.CustomStyleTextureTask.InterfaceC2006a
    /* renamed from: a */
    public final void mo53407a(String str, StyleParserResult styleParserResult) {
        setCustomTextureResourcePath(str);
        if (!this.f4901q.isCustomStyleEnable() || styleParserResult == null) {
            return;
        }
        m54292s(styleParserResult.m55251c(), false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.f4859Z == null || this.f4897o.get()) {
            return;
        }
        try {
            if (this.f4899p && this.f4859Z.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage m54540o = CameraUpdateFactoryDelegate.m54540o();
                m54540o.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                m54540o.geoPoint = new DPoint(this.f4901q.getSX(), this.f4901q.getSY());
                m54540o.zoom = this.f4901q.getSZ();
                m54540o.bearing = this.f4901q.getSR();
                m54540o.tilt = this.f4901q.getSC();
                this.f4859Z.addMessage(abstractCameraUpdateMessage, false);
                while (this.f4859Z.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.f4859Z.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(m54540o);
                    }
                }
                abstractCameraUpdateMessage = m54540o;
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
        resetRenderTime();
        this.f4859Z.clearAnimations(this.f4895n, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        m54300o(abstractCameraUpdateMessage);
        this.f4859Z.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        InfoWindowDelegate infoWindowDelegate;
        if (this.f4897o.get() || (infoWindowDelegate = this.f4870d) == null) {
            return;
        }
        infoWindowDelegate.m53371h(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        InfoWindowDelegate infoWindowDelegate;
        if (baseOverlay == null || (infoWindowDelegate = this.f4870d) == null) {
            return;
        }
        try {
            infoWindowDelegate.m53369j(baseOverlay);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AMapDelegateImp.java */
    /* renamed from: com.amap.api.col.3l.o9$t0 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractRunnableC1909t0 implements Runnable {

        /* renamed from: a */
        boolean f4993a;

        /* renamed from: b */
        boolean f4994b;

        /* renamed from: c */
        int f4995c;

        /* renamed from: d */
        int f4996d;

        /* renamed from: e */
        int f4997e;

        /* renamed from: f */
        int f4998f;

        /* renamed from: g */
        int f4999g;

        /* renamed from: h */
        byte[] f5000h;

        /* renamed from: i */
        MyTrafficStyle f5001i;

        private AbstractRunnableC1909t0() {
            this.f4993a = false;
            this.f4994b = false;
            this.f4998f = 0;
            this.f4999g = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4993a = false;
        }

        /* synthetic */ AbstractRunnableC1909t0(byte b) {
            this();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z) throws RemoteException {
        try {
            hideInfoWindow();
            String str = null;
            String str2 = "";
            MyLocationOverlay myLocationOverlay = this.f4909u;
            if (myLocationOverlay != null) {
                if (z) {
                    str = myLocationOverlay.m54231p();
                    str2 = this.f4909u.m54230q();
                } else {
                    myLocationOverlay.m54229r();
                }
            }
            this.f4891l.clear(str, str2);
            queueEvent(new RunnableC1892l());
            resetRenderTime();
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMapDelegateImp", "clear");
            C1732a3.m55741D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z, byte[] bArr) {
        m54294r(z, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z) {
        if (z) {
            m54295q0();
        }
        setMapCustomEnable(z, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.f4855X = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            C1732a3.m55741D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i, int i2) {
        try {
            changeSurface(1, gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
        }
    }
}
