package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.p0463l.AMapDelegateImp;
import com.amap.api.col.p0463l.ContourLineOptions;
import com.amap.api.col.p0463l.ContourLineOverlay;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BasePointOverlay;
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
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.p048ae.gmap.AMapAppRequestParam;
import com.autonavi.base.p048ae.gmap.GLMapState;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMap {
    public static final String CHINESE = "zh_cn";
    private static final String CLASSNAME = "AMap";
    public static final String CUSTOM = "custom";
    public static final String ENGLISH = "en";
    public static final String LOCAL = "local";
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_BUS = 5;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NAVI_NIGHT = 6;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MASK_LAYER_NONE = -1;
    public static final int MASK_LAYER_UNDER_LINE = 1;
    public static final int MASK_LAYER_UNDER_MARKER = 0;
    public static final String STYLE_CHINESE = "style_zh_cn";
    private final IAMap mapDelegate;
    private MyTrafficStyle myTrafficStyle;
    private Projection projection;
    private UiSettings uiSettings;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface AMapAppResourceRequestListener {
        void onRequest(AMapAppRequestParam aMapAppRequestParam);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface ImageInfoWindowAdapter extends InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface MultiPositionInfoWindowAdapter extends InfoWindowAdapter {
        View getInfoWindowClick(Marker marker);

        View getOverturnInfoWindow(Marker marker);

        View getOverturnInfoWindowClick(Marker marker);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(IndoorBuildingInfo indoorBuildingInfo);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);

        void onMapScreenShot(Bitmap bitmap, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapSnapshotListener {
        void onFinish();

        void onMapTile(Rect rect, Bitmap bitmap, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMultiPointClickListener {
        boolean onPointClick(MultiPointItem multiPointItem);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnPOIClickListener {
        void onPOIClick(Poi poi);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface SignleClickInterceptorListener {
        boolean isInterceptorSignleClick(MotionEvent motionEvent);
    }

    /* renamed from: com.amap.api.maps.AMap$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2255a {

        /* renamed from: b */
        private Size f6996b;

        /* renamed from: c */
        private CameraPosition f6997c;

        /* renamed from: d */
        private int f6998d;

        private C2255a() {
        }

        /* renamed from: a */
        public final void m52118a(Size size) {
            this.f6998d = AMap.this.getUiSettings().getLogoPosition();
            AMap.this.getUiSettings().setLogoPosition(2);
            this.f6997c = CameraPosition.builder(AMap.this.getCameraPosition()).build();
            if (AMap.this.mapDelegate instanceof AMapDelegateImp) {
                this.f6996b = ((AMapDelegateImp) AMap.this.mapDelegate).m54324c(size);
            }
        }

        /* synthetic */ C2255a(AMap aMap, byte b) {
            this();
        }

        /* renamed from: a */
        public final void m52119a() {
            if (AMap.this.mapDelegate instanceof AMapDelegateImp) {
                ((AMapDelegateImp) AMap.this.mapDelegate).m54353A(this.f6996b);
            }
            AMap.this.animateCamera(CameraUpdateFactory.newCameraPosition(this.f6997c));
            AMap.this.getUiSettings().setLogoPosition(this.f6998d);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface onMapPrintScreenListener {
        void onMapPrint(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AMap(IAMap iAMap) {
        this.mapDelegate = iAMap;
    }

    @Deprecated
    public static String getVersion() {
        return "10.0.600";
    }

    public final void accelerateNetworkInChinese(boolean z) {
        try {
            IAMap iAMap = this.mapDelegate;
            if (iAMap != null) {
                iAMap.accelerateNetworkInChinese(z);
            }
        } catch (Throwable unused) {
        }
    }

    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) {
        try {
            return this.mapDelegate.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void addAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.addAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Arc addArc(ArcOptions arcOptions) {
        try {
            return this.mapDelegate.addArc(arcOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final BuildingOverlay addBuildingOverlay() {
        try {
            return this.mapDelegate.addBuildingOverlay();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return this.mapDelegate.addCircle(circleOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ContourLineOverlay addContourLineOverlay(ContourLineOptions contourLineOptions) {
        try {
            return this.mapDelegate.addContourLineOverlay(contourLineOptions);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final CrossOverlay addCrossOverlay(CrossOverlayOptions crossOverlayOptions) {
        try {
            return this.mapDelegate.addCrossVector(crossOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GL3DModel addGL3DModel(GL3DModelOptions gL3DModelOptions) {
        try {
            return this.mapDelegate.addGLModel(gL3DModelOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) {
        try {
            return this.mapDelegate.addGLTFOverlay(gLTFOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return this.mapDelegate.addGroundOverlay(groundOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapGridLayer(heatMapGridLayerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapLayer(heatMapLayerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) {
        try {
            return this.mapDelegate.addMVTTileOverlay(mVTTileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.mapDelegate.addMarker(markerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) {
        try {
            return this.mapDelegate.addMarkers(arrayList, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) {
        try {
            return this.mapDelegate.addMultiPointOverlay(multiPointOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        try {
            return this.mapDelegate.addNavigateArrow(navigateArrowOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.addOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.addOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.addOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.addOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.addOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.addOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.addOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.addOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.addOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.addOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            return this.mapDelegate.addParticleOverlay(particleOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return this.mapDelegate.addPolygon(polygonOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return this.mapDelegate.addPolyline(polylineOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final RouteOverlay addRouteOverlay() {
        return this.mapDelegate.addNaviRouteOverlay();
    }

    public final void addSignleClickInterceptorListener(SignleClickInterceptorListener signleClickInterceptorListener) {
        try {
            this.mapDelegate.addSignleClickInterceptorListener(signleClickInterceptorListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Text addText(TextOptions textOptions) {
        try {
            return this.mapDelegate.addText(textOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return this.mapDelegate.addTileOverlay(tileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.animateCamera(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.calculateZoomToSpanLevel(i, i2, i3, i4, latLng, latLng2);
    }

    public final void clear() {
        try {
            this.mapDelegate.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.mapDelegate.getCameraPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String getCurrentStyle() {
        try {
            IAMap iAMap = this.mapDelegate;
            return iAMap != null ? iAMap.getCurrentWorldVectorMapStyle() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return this.mapDelegate.getInfoWindowAnimationManager();
    }

    public final String getMapContentApprovalNumber() {
        try {
            return this.mapDelegate.getMapContentApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapPrintScreen(onMapPrintScreenListener onmapprintscreenlistener) {
        this.mapDelegate.getMapPrintScreen(onmapprintscreenlistener);
    }

    public final void getMapRegionSnapshot(LatLng latLng, LatLng latLng2, Size size, final OnMapSnapshotListener onMapSnapshotListener) {
        IAMap iAMap = this.mapDelegate;
        if ((iAMap instanceof AMapDelegateImp) && ((AMapDelegateImp) iAMap).getMapConfig().isTerrainEnable()) {
            onMapSnapshotListener.onFinish();
            return;
        }
        C2256b c2256b = new C2256b(latLng, latLng2, size);
        final C2255a c2255a = new C2255a(this, (byte) 0);
        c2255a.m52118a(c2256b.m52112c());
        m52125a(c2256b, onMapSnapshotListener, new Runnable() { // from class: com.amap.api.maps.AMap.1
            @Override // java.lang.Runnable
            public final void run() {
                c2255a.m52119a();
                onMapSnapshotListener.onFinish();
            }
        });
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            List<Marker> mapScreenMarkers = this.mapDelegate.getMapScreenMarkers();
            return mapScreenMarkers == null ? new ArrayList() : mapScreenMarkers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.mapDelegate.getMapScreenShot(onMapScreenShotListener, true);
    }

    public final int getMapTextZIndex() {
        try {
            return this.mapDelegate.getMapTextZIndex();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getMapType() {
        try {
            return this.mapDelegate.getMapType();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.getMinZoomLevel();
    }

    public final Location getMyLocation() {
        try {
            return this.mapDelegate.getMyLocation();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MyLocationStyle getMyLocationStyle() {
        try {
            return this.mapDelegate.getMyLocationStyle();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MyTrafficStyle getMyTrafficStyle() {
        return this.myTrafficStyle;
    }

    public final long getNativeMapController() {
        try {
            return this.mapDelegate.getNativeMapController();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public final int getNativeMapEngineID() {
        try {
            return this.mapDelegate.getNativeEngineID();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final void getP20MapCenter(IPoint iPoint) {
        if (iPoint == null) {
            try {
                iPoint = new IPoint();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        ((Point) iPoint).x = this.mapDelegate.getSX();
        ((Point) iPoint).y = this.mapDelegate.getSY();
    }

    public final Projection getProjection() {
        try {
            if (this.projection == null) {
                this.projection = this.mapDelegate.getAMapProjection();
            }
            return this.projection;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getProjectionMatrix() {
        return this.mapDelegate.getProjectionMatrix();
    }

    public final String getSatelliteImageApprovalNumber() {
        try {
            return this.mapDelegate.getSatelliteImageApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getScalePerPixel() {
        try {
            return this.mapDelegate.getScalePerPixel();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final String getTerrainApprovalNumber() {
        try {
            return this.mapDelegate.getTerrainApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.uiSettings == null) {
                this.uiSettings = this.mapDelegate.getAMapUiSettings();
            }
            return this.uiSettings;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getViewMatrix() {
        return this.mapDelegate.getViewMatrix();
    }

    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.getZoomToSpanLevel(latLng, latLng2);
    }

    public final int hideBuildings(List<LatLng> list) {
        try {
            return this.mapDelegate.hideBuildings(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.mapDelegate.isMyLocationEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isTouchPoiEnable() {
        try {
            return this.mapDelegate.isTouchPoiEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.mapDelegate.isTrafficEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.moveCamera(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void reloadMap() {
        this.mapDelegate.reloadMap();
    }

    public final void removeAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.removeAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.removeOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.removeOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.removeOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.removeOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.removeOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.removeOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.removeOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.removeOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.removeOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.removeOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.removeOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeSignleClickInterceptorListener(SignleClickInterceptorListener signleClickInterceptorListener) {
        try {
            this.mapDelegate.removeSignleClickInterceptorListener(signleClickInterceptorListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void removecache() {
        try {
            this.mapDelegate.removecache();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void resetMinMaxZoomPreference() {
        this.mapDelegate.resetMinMaxZoomPreference();
    }

    public final void runOnDrawFrame() {
        this.mapDelegate.setRunLowFrame(false);
    }

    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        this.mapDelegate.setAMapGestureListener(aMapGestureListener);
    }

    public final void setCommonInfoWindowAdapter(CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(commonInfoWindowAdapter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setConstructingRoadEnable(boolean z) {
        try {
            this.mapDelegate.setConstructingRoadEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions);
    }

    public final void setCustomMapStyleID(String str) {
        Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
    }

    public final void setCustomMapStylePath(String str) {
        Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.mapDelegate.setCustomRenderer(customRenderer);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomTextureResourcePath(String str) {
        Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
    }

    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) {
        try {
            this.mapDelegate.setIndoorBuildingInfo(indoorBuildingInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(infoWindowAdapter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLoadOfflineData(boolean z) {
        try {
            this.mapDelegate.setLoadOfflineData(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.mapDelegate.setLocationSource(locationSource);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapCustomEnable(boolean z) {
        Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
    }

    public final void setMapLanguage(String str) {
        try {
            this.mapDelegate.setMapLanguage(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.mapDelegate.setMapStatusLimits(latLngBounds);
            moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapTextZIndex(int i) {
        try {
            this.mapDelegate.setMapTextZIndex(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapType(int i) {
        try {
            this.mapDelegate.setMapType(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j) {
        this.mapDelegate.setMaskLayerParams(i, i2, i3, i4, i5, j);
    }

    public final void setMaxZoomLevel(float f) {
        this.mapDelegate.setMaxZoomLevel(f);
    }

    public final void setMinZoomLevel(float f) {
        this.mapDelegate.setMinZoomLevel(f);
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.mapDelegate.setMyLocationEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f) {
        try {
            this.mapDelegate.setMyLocationRotateAngle(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.mapDelegate.setMyLocationStyle(myLocationStyle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationType(int i) {
        try {
            this.mapDelegate.setMyLocationType(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        try {
            this.myTrafficStyle = myTrafficStyle;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setNaviLabelEnable(boolean z, int i, int i2) {
        try {
            this.mapDelegate.setNaviLabelEnable(z, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.setOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.setOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.setOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.setOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.setOnMaploadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.setOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.setOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.setOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.setOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        try {
            this.mapDelegate.setOnMultiPointClickListener(onMultiPointClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.setOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.setOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.setOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPointToCenter(int i, int i2) {
        try {
            this.mapDelegate.setCenterToPixel(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRenderFps(int i) {
        this.mapDelegate.setRenderFps(i);
    }

    public final void setRenderMode(int i) {
        this.mapDelegate.setRenderMode(i);
    }

    public final void setRoadArrowEnable(boolean z) {
        try {
            this.mapDelegate.setRoadArrowEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTouchPoiEnable(boolean z) {
        try {
            this.mapDelegate.setTouchPoiEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.mapDelegate.setTrafficEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (bArr == null || myTrafficStyle == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTexture(bArr, myTrafficStyle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTextureData(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setWorldVectorMapStyle(String str) {
        try {
            this.mapDelegate.setWorldVectorMapStyle(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showBuildings(boolean z) {
        try {
            this.mapDelegate.set3DBuildingEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showHideBuildings(int i) {
        try {
            this.mapDelegate.showHideBuildings(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void showIndoorMap(boolean z) {
        try {
            this.mapDelegate.setIndoorEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMapText(boolean z) {
        try {
            this.mapDelegate.setMapTextEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void stopAnimation() {
        try {
            this.mapDelegate.stopAnimation();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m52125a(C2256b c2256b, OnMapSnapshotListener onMapSnapshotListener, final Runnable runnable) {
        final RunnableC22482 runnableC22482 = new RunnableC22482(onMapSnapshotListener, c2256b, runnable);
        animateCamera(c2256b.m52117a(), new CancelableCallback() { // from class: com.amap.api.maps.AMap.3
            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onCancel() {
                runnable.run();
            }

            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onFinish() {
                runnableC22482.run();
            }
        });
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.mapDelegate.animateCameraWithCallback(cameraUpdate, cancelableCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clear(boolean z) {
        try {
            this.mapDelegate.clear(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.mapDelegate.removecache(onCacheRemoveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.maps.AMap$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2256b {

        /* renamed from: b */
        private SizeF f7000b;

        /* renamed from: c */
        private RectF f7001c;

        /* renamed from: d */
        private double f7002d;

        /* renamed from: e */
        private LatLng f7003e;

        /* renamed from: f */
        private LatLng f7004f;

        /* renamed from: i */
        private IPoint f7007i;

        /* renamed from: j */
        private int f7008j;

        /* renamed from: k */
        private int f7009k;

        /* renamed from: g */
        private IPoint f7005g = new IPoint();

        /* renamed from: h */
        private IPoint f7006h = new IPoint();

        /* renamed from: l */
        private int f7010l = 0;

        public C2256b(LatLng latLng, LatLng latLng2, Size size) {
            this.f7008j = 0;
            this.f7009k = 0;
            this.f7000b = new SizeF(size.getWidth(), size.getHeight());
            this.f7003e = latLng;
            this.f7004f = latLng2;
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.f7005g);
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, this.f7006h);
            this.f7007i = m52116a(Utils.DOUBLE_EPSILON, this.f7000b.getHeight());
            this.f7008j = ((int) this.f7000b.getWidth()) / 4096;
            if (this.f7000b.getWidth() % 4096.0f > 0.0f) {
                this.f7008j++;
            }
            this.f7009k = ((int) this.f7000b.getHeight()) / 4096;
            if (this.f7000b.getHeight() % 4096.0f > 0.0f) {
                this.f7009k++;
            }
            this.f7001c = new RectF(0.0f, 0.0f, this.f7000b.getWidth() / this.f7008j, this.f7000b.getHeight() / this.f7009k);
            IPoint iPoint = this.f7006h;
            int i = ((Point) iPoint).y;
            IPoint iPoint2 = this.f7005g;
            double d = i - ((Point) iPoint2).y;
            double d2 = ((Point) iPoint).x - ((Point) iPoint2).x;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.f7002d = Math.atan(d / d2);
        }

        /* renamed from: a */
        private IPoint m52116a(double d, double d2) {
            double sin = Math.sin(this.f7002d);
            double cos = Math.cos(this.f7002d);
            double distance = this.f7005g.distance(this.f7006h);
            double width = this.f7000b.getWidth();
            Double.isNaN(width);
            double d3 = distance / width;
            IPoint iPoint = this.f7005g;
            double d4 = ((Point) iPoint).x;
            Double.isNaN(d4);
            double d5 = ((Point) iPoint).y;
            Double.isNaN(d5);
            return new IPoint((int) ((((d * cos) - (d2 * sin)) * d3) + d4), (int) ((d3 * ((cos * d2) + (sin * d))) + d5));
        }

        /* renamed from: b */
        private LatLng m52113b(double d, double d2) {
            IPoint m52116a = m52116a(d, d2);
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(((Point) m52116a).x, ((Point) m52116a).y, dPoint);
            return new LatLng(dPoint.f7978y, dPoint.f7977x);
        }

        /* renamed from: c */
        public final Size m52112c() {
            return new Size((int) this.f7001c.width(), (int) this.f7001c.height());
        }

        /* renamed from: d */
        public final boolean m52111d() {
            RectF rectF = this.f7001c;
            if (rectF.right + rectF.width() <= this.f7000b.getWidth()) {
                RectF rectF2 = this.f7001c;
                rectF2.offset(rectF2.width(), 0.0f);
            } else {
                RectF rectF3 = this.f7001c;
                if (rectF3.bottom + rectF3.height() > this.f7000b.getHeight()) {
                    return false;
                }
                RectF rectF4 = this.f7001c;
                rectF4.offset(-rectF4.left, rectF4.height());
            }
            this.f7010l++;
            return true;
        }

        /* renamed from: e */
        public final boolean m52110e() {
            return this.f7010l == (this.f7008j * this.f7009k) - 1;
        }

        /* renamed from: a */
        private static LatLng m52115a(long j, long j2) {
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(j, j2, dPoint);
            return new LatLng(dPoint.f7978y, dPoint.f7977x);
        }

        /* renamed from: b */
        public final Rect m52114b() {
            RectF rectF = this.f7001c;
            return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }

        /* renamed from: a */
        public final CameraUpdate m52117a() {
            int i = this.f7010l;
            if (i == 0) {
                return CameraUpdateFactory.newCameraPosition(new CameraPosition(m52113b(this.f7001c.centerX(), this.f7001c.centerY()), AMap.this.getZoomToSpanLevel(m52115a(0L, ((long) this.f7005g.distance(this.f7006h)) / this.f7008j), m52115a(((long) this.f7007i.distance(this.f7005g)) / this.f7009k, 0L)), 0.0f, (float) ((this.f7002d * 180.0d) / 3.141592653589793d)));
            }
            int i2 = this.f7008j;
            if ((i - 1) / i2 < i / i2) {
                return CameraUpdateFactory.scrollBy((-this.f7001c.width()) * (this.f7008j - 1), this.f7001c.height());
            }
            return CameraUpdateFactory.scrollBy(this.f7001c.width(), 0.0f);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (j <= 0) {
            try {
                Log.w(CLASSNAME, "durationMs must be positive");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.mapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, j, cancelableCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.maps.AMap$2 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC22482 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ OnMapSnapshotListener f6980a;

        /* renamed from: b */
        final /* synthetic */ C2256b f6981b;

        /* renamed from: c */
        final /* synthetic */ Runnable f6982c;

        RunnableC22482(OnMapSnapshotListener onMapSnapshotListener, C2256b c2256b, Runnable runnable) {
            this.f6980a = onMapSnapshotListener;
            this.f6981b = c2256b;
            this.f6982c = runnable;
        }

        /* renamed from: a */
        private ViewGroup m52122a() {
            if (AMap.this.mapDelegate instanceof AMapDelegateImp) {
                ViewGroup viewGroup = (ViewGroup) ((AMapDelegateImp) AMap.this.mapDelegate).getGLMapView().getParent();
                FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                frameLayout.setBackgroundColor(-1);
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                int width = viewGroup.getWidth() / 20;
                frameLayout.setPadding(width, width, width, width);
                viewGroup.addView(frameLayout);
                return frameLayout;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final ViewGroup m52122a = m52122a();
            m52120a(m52122a, new Runnable() { // from class: com.amap.api.maps.AMap.2.3
                @Override // java.lang.Runnable
                public final void run() {
                    AMap.this.mapDelegate.getMapScreenShot(new OnMapScreenShotListener() { // from class: com.amap.api.maps.AMap.2.3.1
                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap) {
                        }

                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap, int i) {
                            RunnableC22523 runnableC22523 = RunnableC22523.this;
                            RunnableC22482.this.m52121a(m52122a, bitmap);
                            RunnableC22482 runnableC22482 = RunnableC22482.this;
                            runnableC22482.f6980a.onMapTile(runnableC22482.f6981b.m52114b(), bitmap, i);
                            if (RunnableC22482.this.f6981b.m52111d()) {
                                RunnableC22482 runnableC224822 = RunnableC22482.this;
                                AMap.this.m52125a(runnableC224822.f6981b, runnableC224822.f6980a, runnableC224822.f6982c);
                                return;
                            }
                            RunnableC22482.this.f6982c.run();
                        }
                    }, RunnableC22482.this.f6981b.m52110e());
                }
            });
        }

        /* renamed from: a */
        private void m52120a(ViewGroup viewGroup, final Runnable runnable) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f);
            double width = viewGroup2.getWidth();
            Double.isNaN(width);
            double height = viewGroup2.getHeight();
            Double.isNaN(height);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) (width * 0.05d), 0.0f, (float) (height * 0.75d));
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setDuration(600L);
            animationSet.setFillAfter(true);
            animationSet.setInterpolator(new DecelerateInterpolator());
            viewGroup.startAnimation(animationSet);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.maps.AMap.2.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    runnable.run();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }
            });
        }

        /* renamed from: a */
        final void m52121a(final ViewGroup viewGroup, Bitmap bitmap) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 0.2f, 0.2f, 0.2f);
            double width = viewGroup.getWidth();
            Double.isNaN(width);
            double width2 = viewGroup.getWidth();
            Double.isNaN(width2);
            double height = viewGroup.getHeight();
            Double.isNaN(height);
            double height2 = viewGroup.getHeight();
            Double.isNaN(height2);
            TranslateAnimation translateAnimation = new TranslateAnimation((float) (width * 0.05d), -((float) (width2 * 0.5d)), (float) (height * 0.75d), (float) (height2 * 0.75d));
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setStartOffset(1500L);
            animationSet.setDuration(200L);
            animationSet.setFillBefore(true);
            animationSet.setFillAfter(true);
            animationSet.setInterpolator(new AccelerateInterpolator());
            viewGroup.startAnimation(animationSet);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.maps.AMap.2.2
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amap.api.maps.AMap.2.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }
            });
        }
    }
}
