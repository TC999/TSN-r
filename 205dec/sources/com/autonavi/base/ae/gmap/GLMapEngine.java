package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.f3;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback {
    private Context context;
    private int mEngineID;
    private IAMapDelegate mGlMapView;
    private IAMapListener mMapListener;
    boolean mRequestDestroy;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private long mNativeMapengineInstance = 0;
    private final List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
    private final List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
    private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
    boolean isMoveCameraStep = false;
    boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private GLMapState copyGLMapState = null;
    private Lock mLock = new ReentrantLock();
    private Object mutLock = new Object();
    private NetworkState mNetworkState = null;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    boolean isNetworkConnected = false;
    private AtomicInteger mRequestID = new AtomicInteger(1);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class InitParam {
        public String mRootPath = "";
        public String mConfigPath = "";
        public String mConfigContent = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mIntersectionResPath = "";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;

        /* renamed from: x  reason: collision with root package name */
        public int f12051x;

        /* renamed from: y  reason: collision with root package name */
        public int f12052y;
    }

    public GLMapEngine(Context context, IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.3
            @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
            public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
            }
        });
        this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        this.mEngineID = GLEngineIDController.getController().generate();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:12|(2:13|14)|16|17|18|19|(4:24|(1:26)|27|(1:31)(2:29|30))(1:23)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float adapterDpiScale(android.util.DisplayMetrics r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = getEMUI()
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L87
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L87
            java.lang.String r2 = "EmotionUI_8"
            int r2 = r0.indexOf(r2)
            r3 = -1
            if (r2 != r3) goto L1f
            java.lang.String r2 = "EmotionUI_9"
            int r0 = r0.indexOf(r2)
            if (r0 == r3) goto L87
        L1f:
            if (r11 <= 0) goto L87
            r0 = 1
            r2 = 0
            java.lang.Class<android.util.DisplayMetrics> r3 = android.util.DisplayMetrics.class
            java.lang.String r4 = "noncompatWidthPixels"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            r3.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            int r3 = r3.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            goto L3d
        L33:
            r3 = move-exception
            r3.printStackTrace()
            goto L3c
        L38:
            r3 = move-exception
            r3.printStackTrace()
        L3c:
            r3 = 0
        L3d:
            java.lang.Class<android.util.DisplayMetrics> r4 = android.util.DisplayMetrics.class
            java.lang.String r5 = "noncompatHeightPixels"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            r4.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            int r4 = r4.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            goto L57
        L4d:
            r4 = move-exception
            r4.printStackTrace()
            goto L56
        L52:
            r4 = move-exception
            r4.printStackTrace()
        L56:
            r4 = 0
        L57:
            java.lang.Class<android.util.DisplayMetrics> r5 = android.util.DisplayMetrics.class
            java.lang.String r6 = "noncompatDensityDpi"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            r5.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            int r2 = r5.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            goto L70
        L67:
            r8 = move-exception
            r8.printStackTrace()
            goto L70
        L6c:
            r8 = move-exception
            r8.printStackTrace()
        L70:
            if (r2 > r11) goto L76
            if (r3 > r9) goto L76
            if (r4 <= r10) goto L87
        L76:
            float r8 = (float) r2
            float r9 = (float) r11
            float r8 = r8 / r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L81
            r8 = 1073741824(0x40000000, float:2.0)
        L81:
            int r9 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r9 >= 0) goto L86
            goto L87
        L86:
            r1 = r8
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.adapterDpiScale(android.util.DisplayMetrics, int, int, int):float");
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onCancel();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onFinish();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i4 = this.mapGestureCount - 1;
        this.mapGestureCount = i4;
        if (i4 == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            remove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
        }
        if (remove != null) {
            remove.generateMapAnimation(this);
        }
    }

    public static native void nativeAddGestureSingleTapMessage(int i4, long j4, float f4, float f5);

    protected static native String nativeAddNativeOverlay(int i4, long j4, int i5, int i6);

    private static native boolean nativeAddOverlayTexture(int i4, long j4, int i5, int i6, float f4, float f5, Bitmap bitmap, boolean z3, boolean z4);

    private static native void nativeCancelDownLoad(long j4);

    private static native boolean nativeCheckCustomStyleData(int i4, long j4, byte[] bArr);

    private static native void nativeCreateAMapEngineWithFrame(long j4, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f4, float f5, float f6, int i11);

    private static native long nativeCreateAMapInstance(float f4, float f5, float f6, int i4);

    protected static native long nativeCreateOverlay(int i4, long j4, int i5);

    private static native int nativeCreateTextureFromImage(int i4, long j4, Bitmap bitmap);

    private static native void nativeDestroy(long j4);

    private static native void nativeDestroyCurrentState(long j4, long j5);

    protected static native void nativeDestroyOverlay(int i4, long j4);

    private static native void nativeFailedDownLoad(long j4, int i4);

    private static native void nativeFinishDownLoad(long j4);

    private static native void nativeGetCurTileIDs(int i4, long j4, int[] iArr, int i5);

    private static native long nativeGetCurrentMapState(int i4, long j4);

    private static native long nativeGetGlOverlayMgrPtr(int i4, long j4);

    public static native String nativeGetMapEngineVersion(int i4);

    private static native int[] nativeGetMapModeState(int i4, long j4, boolean z3);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i4, long j4);

    public static native int[] nativeGetScreenShot(int i4, long j4, int i5, int i6, int i7, int i8);

    private static native boolean nativeGetSrvViewStateBoolValue(int i4, long j4, int i5);

    public static native int nativeHideBuildings(int i4, long j4, LatLng[] latLngArr);

    private static native void nativeInitAMapEngineCallback(long j4, Object obj);

    private static native void nativeInitContourLineOptions(long j4, boolean z3);

    private static native void nativeInitOpenLayer(int i4, long j4, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4, String str5, String str6, int i4);

    private static native boolean nativeIsEngineCreated(long j4, int i4);

    public static native void nativeMainThreadTrigger(int i4, long j4);

    private static native void nativePopRenderState(int i4, long j4);

    private static native void nativePostRenderAMap(long j4, int i4);

    private static native void nativePushRendererState(int i4, long j4);

    private static native void nativeReceiveNetData(byte[] bArr, long j4, int i4);

    protected static native void nativeRemoveNativeAllOverlay(int i4, long j4);

    protected static native void nativeRemoveNativeOverlay(int i4, long j4, String str);

    private static native void nativeRenderAMap(long j4, int i4);

    private static native void nativeSetAllContentEnable(int i4, long j4, boolean z3);

    private static native void nativeSetBuildingEnable(int i4, long j4, boolean z3);

    private static native void nativeSetBuildingTextureEnable(int i4, long j4, boolean z3);

    private static native void nativeSetCustomStyleData(int i4, long j4, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i4, long j4, byte[] bArr);

    private static native void nativeSetCustomThirdLayerStyle(int i4, long j4, String str);

    private static native void nativeSetHighlightSubwayEnable(int i4, long j4, boolean z3);

    private static native void nativeSetIndoorBuildingToBeActive(int i4, long j4, String str, int i5, String str2);

    private static native void nativeSetIndoorEnable(int i4, long j4, boolean z3);

    private static native void nativeSetLabelEnable(int i4, long j4, boolean z3);

    private static native boolean nativeSetMapModeAndStyle(int i4, long j4, int[] iArr);

    private static native void nativeSetNaviLabelEnable(int i4, long j4, boolean z3, int i5, int i6);

    private static native void nativeSetNetStatus(long j4, int i4);

    private static native void nativeSetOfflineDataEnable(int i4, long j4, boolean z3);

    private static native void nativeSetOpenLayerEnable(int i4, long j4, boolean z3);

    private static native void nativeSetParameter(int i4, long j4, int i5, int i6, int i7, int i8, int i9);

    private static native void nativeSetProjectionCenter(int i4, long j4, float f4, float f5);

    private static native void nativeSetRenderListenerStatus(int i4, long j4);

    private static native void nativeSetRoadArrowEnable(int i4, long j4, boolean z3);

    private static native void nativeSetServiceViewRect(int i4, long j4, int i5, int i6, int i7, int i8, int i9, int i10);

    private static native void nativeSetSetBackgroundTexture(int i4, long j4, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i4, long j4, boolean z3);

    private static native void nativeSetSkyTexture(int i4, long j4, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i4, long j4, int i5, boolean z3);

    private static native void nativeSetStyleChangeGradualEnable(int i4, long j4, boolean z3);

    public static native void nativeSetTerrainAuth(int i4, long j4, boolean z3);

    private static native void nativeSetTrafficEnable(int i4, long j4, boolean z3);

    private static native void nativeSetTrafficTexture(int i4, long j4, byte[] bArr, long j5, int i5, int i6, int i7, int i8, int i9);

    private static native void nativeSetTrafficTextureAllInOne(int i4, long j4, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i4, long j4, String str);

    public static native void nativeShowHideBuildings(int i4, long j4, int i5);

    protected static native void nativeUpdateNativeArrowOverlay(int i4, long j4, String str, int[] iArr, int[] iArr2, int i5, int i6, int i7, float f4, boolean z3, int i8, int i9, int i10);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() > 0) {
                gLMapState.recalculate();
                this.mapAnimationMgr.doAnimations(gLMapState);
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r2.width != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r2.height != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        r2.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        r3 = r2.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        if (r3 != 100) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (r3 != 101) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        r2.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
        if (r3 != 102) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r0 = r5.mGestureMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L10
            boolean r6 = r5.isGestureStep
            if (r6 == 0) goto Lf
            r5.isGestureStep = r1
        Lf:
            return r1
        L10:
            r0 = 1
            r5.isGestureStep = r0
            if (r6 != 0) goto L16
            return r1
        L16:
            r2 = 0
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList
            monitor-enter(r3)
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r4 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L73
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L73
            if (r4 <= 0) goto L2a
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L73
            java.lang.Object r2 = r2.remove(r1)     // Catch: java.lang.Throwable -> L73
            com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage r2 = (com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage) r2     // Catch: java.lang.Throwable -> L73
        L2a:
            if (r2 != 0) goto L39
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r6 = r5.mGestureEndMessageList
            int r6 = r6.size()
            if (r6 <= 0) goto L38
            r5.recycleMessage()
        L38:
            return r0
        L39:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            int r3 = r2.width
            if (r3 != 0) goto L46
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapWidth()
            r2.width = r3
        L46:
            int r3 = r2.height
            if (r3 != 0) goto L52
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapHeight()
            r2.height = r3
        L52:
            int r3 = r2.getMapGestureState()
            r4 = 100
            if (r3 != r4) goto L5e
            r5.gestureBegin()
            goto L6d
        L5e:
            r4 = 101(0x65, float:1.42E-43)
            if (r3 != r4) goto L66
            r2.runCameraUpdate(r6)
            goto L6d
        L66:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L6d
            r5.gestureEnd()
        L6d:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureEndMessageList
            r3.add(r2)
            goto L16
        L73:
            r6 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            goto L77
        L76:
            throw r6
        L77:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processGestureMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r1.setCameraDegree(com.amap.api.col.p0003l.a3.i(r6.mGlMapView.getMapConfig(), r1.getCameraDegree(), r1.getMapZoomer()));
        setMapState(r6.mEngineID, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processMessage() {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.mEngineID     // Catch: java.lang.Exception -> L61
            com.autonavi.amap.api.mapcore.IGLMapState r1 = r6.getNewMapState(r1)     // Catch: java.lang.Exception -> L61
            com.autonavi.base.ae.gmap.GLMapState r1 = (com.autonavi.base.ae.gmap.GLMapState) r1     // Catch: java.lang.Exception -> L61
            boolean r2 = r6.processGestureMessage(r1)     // Catch: java.lang.Exception -> L61
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r6.mGestureMessageList     // Catch: java.lang.Exception -> L61
            int r3 = r3.size()     // Catch: java.lang.Exception -> L61
            r4 = 1
            if (r3 > 0) goto L23
            if (r2 != 0) goto L21
            boolean r2 = r6.processStateMapMessage(r1)     // Catch: java.lang.Exception -> L61
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L34
        L21:
            r2 = 1
            goto L34
        L23:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r3 = r6.mStateMessageList     // Catch: java.lang.Exception -> L61
            monitor-enter(r3)     // Catch: java.lang.Exception -> L61
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L5e
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L5e
            if (r5 <= 0) goto L33
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L5e
            r5.clear()     // Catch: java.lang.Throwable -> L5e
        L33:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5e
        L34:
            if (r2 != 0) goto L3e
            boolean r2 = r6.processAnimations(r1)     // Catch: java.lang.Exception -> L61
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r4 = 0
        L3e:
            if (r4 == 0) goto L5a
            float r2 = r1.getCameraDegree()     // Catch: java.lang.Exception -> L61
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r6.mGlMapView     // Catch: java.lang.Exception -> L61
            com.autonavi.base.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch: java.lang.Exception -> L61
            float r5 = r1.getMapZoomer()     // Catch: java.lang.Exception -> L61
            float r2 = com.amap.api.col.p0003l.a3.i(r3, r2, r5)     // Catch: java.lang.Exception -> L61
            r1.setCameraDegree(r2)     // Catch: java.lang.Exception -> L61
            int r2 = r6.mEngineID     // Catch: java.lang.Exception -> L61
            r6.setMapState(r2, r1)     // Catch: java.lang.Exception -> L61
        L5a:
            r1.recycle()     // Catch: java.lang.Exception -> L61
            return r4
        L5e:
            r1 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5e
            throw r1     // Catch: java.lang.Exception -> L61
        L61:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                remove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                if (remove == null) {
                    return true;
                }
            }
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void OnIndoorBuildingActivity(int i4, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i4, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i4, AbstractGestureMapMessage abstractGestureMapMessage, boolean z3, int i5, int i6) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z3;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGestureSingleTapMessage(float f4, float f5) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, f4, f5);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i4, int i5, float f4, int i6, int i7, int i8, int i9, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i5);
        adglMapAnimGroup.setToCameraDegree(i7, 0);
        adglMapAnimGroup.setToMapAngle(i6, 0);
        adglMapAnimGroup.setToMapLevel(f4, 0);
        adglMapAnimGroup.setToMapCenterGeo(i8, i9, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z3) {
        if (z3) {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
            return;
        }
        synchronized (this.mStateMessageList) {
            this.mStateMessageList.add(abstractCameraUpdateMessage);
        }
    }

    public String addNativeOverlay(int i4, int i5, int i6) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            String nativeAddNativeOverlay = nativeAddNativeOverlay(i4, j4, i5, i6);
            if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
                return null;
            }
            return nativeAddNativeOverlay;
        }
        return null;
    }

    public void addOverlayTexture(int i4, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i4, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public boolean canStopMapRender(int i4) {
        return this.isEngineRenderComplete;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void cancelRequireMapData(Object obj) {
        if (obj == null || !(obj instanceof AMapLoader)) {
            return;
        }
        ((AMapLoader) obj).doCancel();
    }

    public void changeSurface(int i4, int i5) {
    }

    public boolean checkCustomStyleData(int i4, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeCheckCustomStyleData(i4, j4, bArr);
    }

    public void clearAllMessages(int i4) {
    }

    public void clearAnimations(int i4, boolean z3) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.f12051x, mapViewInitParam.f12052y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, FileUtil.uncompressToByteArray(FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public boolean createAMapInstance(InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i4 = displayMetrics.densityDpi;
            float f4 = displayMetrics.density;
            float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i4);
            this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
            int i5 = MapsInitializer.isTerrainEnable() ? 1 : 0;
            nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath, "http://mpsapi.amap.com/", "http://m5.amap.com/", i4);
            InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
            long nativeCreateAMapInstance = nativeCreateAMapInstance(i4, f4, adapterDpiScale, i5);
            this.mNativeMapengineInstance = nativeCreateAMapInstance;
            if (nativeCreateAMapInstance == 0) {
                return false;
            }
            if (MapsInitializer.isTerrainEnable()) {
                nativeInitContourLineOptions(this.mNativeMapengineInstance, MapsInitializer.isContourLineEnable());
            }
            nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
            if (!NetworkProxyManager.getInstance().isReady()) {
                NetworkProxyManager.getInstance().initContext(this.context);
                NetworkProxyManager.getInstance().init();
            }
            NetworkProxyManager.getInstance().notifyMapEngineCreated(this.mEngineID, this);
            return true;
        }
    }

    public long createOverlay(int i4, int i5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeCreateOverlay(i4, j4, i5);
        }
        return 0L;
    }

    public int createOverlayTexture(int i4, Bitmap bitmap) {
        if (this.mNativeMapengineInstance == 0 || bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return nativeCreateTextureFromImage(i4, this.mNativeMapengineInstance, bitmap);
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    this.mLock.lock();
                    GLMapState gLMapState = this.copyGLMapState;
                    if (gLMapState != null) {
                        gLMapState.recycle();
                    }
                    this.mLock.unlock();
                    nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                    nativeDestroy(this.mNativeMapengineInstance);
                }
                this.mNativeMapengineInstance = 0L;
                NetworkProxyManager.getInstance().notifyMapEngineDestroyed(this.mEngineID);
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            y2.c();
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
        }
    }

    public void destroyOverlay(int i4, long j4) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i4, j4);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(this.mEngineID, j4);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i4, int[] iArr) {
        if (iArr != null) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                iArr[i5] = 0;
            }
            nativeGetCurTileIDs(i4, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i4) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i4) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetGlOverlayMgrPtr(i4, j4);
        }
        return 0L;
    }

    public boolean getIsProcessBuildingMark(int i4) {
        return false;
    }

    public int[] getMapModeState(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeGetMapModeState(i4, j4, z3);
            return null;
        }
        return null;
    }

    public GLMapState getMapState(int i4) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i4, j4);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(i4, this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i4) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i4) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetNativeMapController(i4, j4);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i4) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                return new GLMapState(i4, j4);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i4) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i4, int i5, int i6, int i7, int i8) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return a3.p(nativeGetScreenShot(i4, j4, i5, i6, i7, i8), i7 - i5, i8 - i6, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i4, int i5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetSrvViewStateBoolValue(i4, j4, i5);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            if (this.mStateMessageList.size() == 0) {
                return null;
            }
            return this.mStateMessageList.remove(0);
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public int hideBuildings(List<LatLng> list) {
        if (this.mNativeMapengineInstance == 0) {
            return -1;
        }
        LatLng[] latLngArr = new LatLng[list.size()];
        list.toArray(latLngArr);
        return nativeHideBuildings(this.mEngineID, this.mNativeMapengineInstance, latLngArr);
    }

    public void initMapOpenLayer(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j4, str.getBytes());
    }

    public void initNativeTexture(int i4) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap2 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            Bitmap bitmap3 = fromAsset3 != null ? fromAsset3.getBitmap() : null;
            addOverlayTexture(i4, bitmap, 111, 4);
            addOverlayTexture(i4, bitmap2, 222, 4);
            addOverlayTexture(i4, bitmap3, 333, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (Throwable th) {
                u5.p(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i4) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeIsEngineCreated(j4, i4);
        }
        return false;
    }

    public boolean isInMapAction(int i4) {
        return false;
    }

    public boolean isInMapAnimation(int i4) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.onAMapAppResourceRequest(aMapAppRequestParam);
        }
    }

    public void onClearCache(int i4) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapBlandClick(double d4, double d5) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapBlankClick(d4, d5);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapPOIClick(MapPoi mapPoi) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapPOIClick(mapPoi);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapRender(int i4, int i5) {
        try {
            if (i5 == 5) {
                IAMapListener iAMapListener = this.mMapListener;
                if (iAMapListener != null) {
                    iAMapListener.beforeDrawLabel(i4, getMapState(i4));
                }
            } else if (i5 == 6) {
                IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.afterDrawLabel(i4, getMapState(i4));
                }
            } else if (i5 != 7) {
                if (i5 != 13) {
                    return;
                }
                this.isEngineRenderComplete = true;
            } else {
                IAMapListener iAMapListener3 = this.mMapListener;
                if (iAMapListener3 != null) {
                    iAMapListener3.afterRendererOver(i4, getMapState(i4));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void popRendererState() {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativePopRenderState(this.mEngineID, j4);
        }
    }

    public void pushRendererState() {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativePushRendererState(this.mEngineID, j4);
        }
    }

    public void putResourceData(int i4, byte[] bArr) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i4, String str, int i5) {
    }

    public void removeNativeAllOverlay(int i4) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeRemoveNativeAllOverlay(i4, j4);
        }
    }

    public void removeNativeOverlay(int i4, String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i4, j4, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharBitmap(int i4, int i5, int i6) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i5, i6);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharsWidths(int i4, int[] iArr, int i5, int i6) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i4, int i5, int i6) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireMapResource(int i4, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String concat = "map_assets/".concat(str);
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    bArr = this.mGlMapView.getCustomStyleManager().i(str);
                    if (bArr != null) {
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, concat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = a3.S(bArr, customBackgroundColor);
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, concat);
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    public void setAllContentEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            if (z3) {
                nativeSetAllContentEnable(i4, j4, true);
            } else {
                nativeSetAllContentEnable(i4, j4, false);
            }
            setSimple3DEnable(i4, false);
        }
    }

    public void setBackgroundTexture(int i4, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSetBackgroundTexture(i4, j4, bArr);
        }
    }

    public void setBuildingEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetBuildingEnable(i4, j4, z3);
        }
    }

    public void setBuildingTextureEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetBuildingTextureEnable(i4, j4, z3);
        }
    }

    public void setCustomStyleData(int i4, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomStyleData(i4, j4, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i4, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomStyleTexture(i4, j4, bArr);
        }
    }

    public void setCustomThirdLayerStyle(int i4, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomThirdLayerStyle(this.mEngineID, j4, str);
        }
    }

    public void setHighlightSubwayEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetHighlightSubwayEnable(i4, j4, z3);
        }
    }

    public void setIndoorBuildingToBeActive(int i4, String str, int i5, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetIndoorBuildingToBeActive(i4, j4, str, i5, str2);
        }
    }

    public void setIndoorEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetIndoorEnable(i4, j4, z3);
        }
    }

    public void setLabelEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetLabelEnable(i4, j4, z3);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public boolean setMapModeAndStyle(int i4, int i5, int i6, boolean z3, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i4, i5, i6);
        if (styleItemArr != null && z3) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                Context context = this.context;
                setBackgroundTexture(i4, a3.S(FileUtil.readFileContentsFromAssets(context, "map_custom" + File.separator + "custom_bktile.data"), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i4, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i5 == 0 && i6 == 0) {
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder("map_assets");
            String str = File.separator;
            sb.append(str);
            sb.append("bktile.data");
            setBackgroundTexture(i4, FileUtil.readFileContentsFromAssets(context2, sb.toString()));
            Context context3 = this.context;
            setCustomStyleTexture(i4, FileUtil.readFileContentsFromAssets(context3, "map_assets" + str + "icons_5_21_1680057953.data"));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j4, z3);
        }
    }

    public void setMapState(int i4, GLMapState gLMapState) {
        setMapState(i4, gLMapState, true);
    }

    public boolean setNativeMapModeAndStyle(int i4, int i5, int i6) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i4, j4, new int[]{i5, i6});
    }

    public void setNaviLabelEnable(int i4, boolean z3, int i5, int i6) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetNaviLabelEnable(i4, j4, z3, i5, i6);
        }
    }

    public void setNetStatus(boolean z3) {
        if (this.mRequestDestroy) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetNetStatus(j4, z3 ? 1 : 0);
    }

    public void setOfflineDataEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetOfflineDataEnable(i4, j4, z3);
        }
    }

    public void setOvelayBundle(int i4, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                nativeSetParameter(i4, j4, i5, i6, i7, i8, i9);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i4, int i5, int i6) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetProjectionCenter(i4, j4, i5, i6);
        }
    }

    public void setRoadArrowEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetRoadArrowEnable(i4, j4, z3);
        }
    }

    public void setServiceViewRect(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        nativeSetServiceViewRect(i4, this.mNativeMapengineInstance, i5, i6, i7, i8, i9, i10);
    }

    public void setSimple3DEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSimple3DEnable(i4, j4, z3);
        }
    }

    public void setSkyTexture(int i4, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSkyTexture(i4, j4, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i4, int i5, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSrvViewStateBoolValue(i4, j4, i5, z3);
        }
    }

    public void setStyleChangeGradualEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetStyleChangeGradualEnable(i4, j4, z3);
        }
    }

    public void setTerrainAuth(boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetTerrainAuth(this.mEngineID, j4, z3);
    }

    public void setTrafficEnable(int i4, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetTrafficEnable(i4, j4, z3);
        }
    }

    public void setTrafficStyleWithTexture(int i4, byte[] bArr, MyTrafficStyle myTrafficStyle) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || myTrafficStyle == null) {
            return;
        }
        nativeSetTrafficTexture(i4, j4, bArr, bArr.length, myTrafficStyle.getExtremelySmoothColor(), myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
    }

    public void setTrafficStyleWithTextureData(int i4, byte[] bArr) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i4, j4, bArr);
    }

    public void setVectorOverlayPath(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j4, str);
    }

    public void showHideBuildings(int i4) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeShowHideBuildings(this.mEngineID, j4, i4);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i4, Point point, float f4, float f5) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i4, true);
            GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            if ((abs > abs2 ? abs : abs2) > 12000.0f) {
                if (abs > abs2) {
                    f4 = f4 > 0.0f ? 12000.0f : -12000.0f;
                    f5 = (12000.0f / abs) * f5;
                } else {
                    float f6 = (12000.0f / abs2) * f4;
                    if (f5 > 0.0f) {
                        f4 = f6;
                        f5 = 12000.0f;
                    } else {
                        f4 = f6;
                        f5 = -12000.0f;
                    }
                }
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                AdglMapAnimFlingP20 adglMapAnimFlingP20 = new AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f4, f5);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f4, f5);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPivotZoomRotateAnim(int i4, Point point, float f4, int i5, int i6) {
    }

    public void triggerMainThread() {
        nativeMainThreadTrigger(this.mEngineID, this.mNativeMapengineInstance);
    }

    public void updateNativeArrowOverlay(int i4, String str, int[] iArr, int[] iArr2, int i5, int i6, int i7, float f4, int i8, int i9, int i10, boolean z3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i4, j4, str, iArr, iArr2, i5, i6, i7, f4, z3, i8, i9, i10);
    }

    public void clearAnimations(int i4, boolean z3, int i5) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void setMapState(int i4, GLMapState gLMapState, boolean z3) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z3 && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i4, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void addOverlayTexture(int i4, Bitmap bitmap, int i5, int i6) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i5;
        gLTextureProperty.mAnchor = i6;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i4, gLTextureProperty);
    }
}
