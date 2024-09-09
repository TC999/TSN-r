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
import com.amap.api.col.p0003l.eo;
import com.amap.api.col.p0003l.l3;
import com.amap.api.col.p0003l.p9;
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
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface AMapAppResourceRequestListener {
        void onRequest(AMapAppRequestParam aMapAppRequestParam);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface ImageInfoWindowAdapter extends InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface MultiPositionInfoWindowAdapter extends InfoWindowAdapter {
        View getInfoWindowClick(Marker marker);

        View getOverturnInfoWindow(Marker marker);

        View getOverturnInfoWindowClick(Marker marker);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(IndoorBuildingInfo indoorBuildingInfo);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);

        void onMapScreenShot(Bitmap bitmap, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapSnapshotListener {
        void onFinish();

        void onMapTile(Rect rect, Bitmap bitmap, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMultiPointClickListener {
        boolean onPointClick(MultiPointItem multiPointItem);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnPOIClickListener {
        void onPOIClick(Poi poi);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface SignleClickInterceptorListener {
        boolean isInterceptorSignleClick(MotionEvent motionEvent);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a {

        /* renamed from: b  reason: collision with root package name */
        private Size f10700b;

        /* renamed from: c  reason: collision with root package name */
        private CameraPosition f10701c;

        /* renamed from: d  reason: collision with root package name */
        private int f10702d;

        private a() {
        }

        public final void a(Size size) {
            this.f10702d = AMap.this.getUiSettings().getLogoPosition();
            AMap.this.getUiSettings().setLogoPosition(2);
            this.f10701c = CameraPosition.builder(AMap.this.getCameraPosition()).build();
            if (AMap.this.mapDelegate instanceof p9) {
                this.f10700b = ((p9) AMap.this.mapDelegate).c(size);
            }
        }

        /* synthetic */ a(AMap aMap, byte b4) {
            this();
        }

        public final void a() {
            if (AMap.this.mapDelegate instanceof p9) {
                ((p9) AMap.this.mapDelegate).A(this.f10700b);
            }
            AMap.this.animateCamera(CameraUpdateFactory.newCameraPosition(this.f10701c));
            AMap.this.getUiSettings().setLogoPosition(this.f10702d);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public final void accelerateNetworkInChinese(boolean z3) {
        try {
            IAMap iAMap = this.mapDelegate;
            if (iAMap != null) {
                iAMap.accelerateNetworkInChinese(z3);
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
        } catch (Exception e4) {
            e4.printStackTrace();
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

    public final l3 addContourLineOverlay(eo eoVar) {
        try {
            return this.mapDelegate.addContourLineOverlay(eoVar);
        } catch (Exception e4) {
            e4.printStackTrace();
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

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z3) {
        try {
            return this.mapDelegate.addMarkers(arrayList, z3);
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
        } catch (Exception e4) {
            e4.printStackTrace();
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

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i4, int i5, int i6, int i7, LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.calculateZoomToSpanLevel(i4, i5, i6, i7, latLng, latLng2);
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
        if ((iAMap instanceof p9) && ((p9) iAMap).getMapConfig().isTerrainEnable()) {
            onMapSnapshotListener.onFinish();
            return;
        }
        b bVar = new b(latLng, latLng2, size);
        final a aVar = new a(this, (byte) 0);
        aVar.a(bVar.c());
        a(bVar, onMapSnapshotListener, new Runnable() { // from class: com.amap.api.maps.AMap.1
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a();
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
        } catch (Exception e4) {
            e4.printStackTrace();
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
        } catch (Exception e4) {
            e4.printStackTrace();
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
        } catch (Exception e4) {
            e4.printStackTrace();
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

    public final void setConstructingRoadEnable(boolean z3) {
        try {
            this.mapDelegate.setConstructingRoadEnable(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions);
    }

    public final void setCustomMapStyleID(String str) {
        Log.e("amap", "\u8be5\u65b9\u6cd5\u5df2\u65e0\u6548\uff0c\u8bf7\u5230\u5b98\u7f51(lbs.amap.com)\u66f4\u65b0\u65b0\u7248\u6837\u5f0f\u6587\u4ef6\u5e76\u4f7f\u7528setCustomMapStyleOptions");
    }

    public final void setCustomMapStylePath(String str) {
        Log.e("amap", "\u8be5\u65b9\u6cd5\u5df2\u65e0\u6548\uff0c\u8bf7\u5230\u5b98\u7f51(lbs.amap.com)\u66f4\u65b0\u65b0\u7248\u6837\u5f0f\u6587\u4ef6\u5e76\u4f7f\u7528setCustomMapStyleOptions");
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.mapDelegate.setCustomRenderer(customRenderer);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomTextureResourcePath(String str) {
        Log.e("amap", "\u8be5\u65b9\u6cd5\u5df2\u65e0\u6548\uff0c\u8bf7\u5230\u5b98\u7f51(lbs.amap.com)\u66f4\u65b0\u65b0\u7248\u6837\u5f0f\u6587\u4ef6\u5e76\u4f7f\u7528setCustomMapStyleOptions");
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

    public final void setLoadOfflineData(boolean z3) {
        try {
            this.mapDelegate.setLoadOfflineData(z3);
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

    public final void setMapCustomEnable(boolean z3) {
        Log.e("amap", "\u8be5\u65b9\u6cd5\u5df2\u65e0\u6548\uff0c\u8bf7\u5230\u5b98\u7f51(lbs.amap.com)\u66f4\u65b0\u65b0\u7248\u6837\u5f0f\u6587\u4ef6\u5e76\u4f7f\u7528setCustomMapStyleOptions");
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

    public final void setMapTextZIndex(int i4) {
        try {
            this.mapDelegate.setMapTextZIndex(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapType(int i4) {
        try {
            this.mapDelegate.setMapType(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMaskLayerParams(int i4, int i5, int i6, int i7, int i8, long j4) {
        this.mapDelegate.setMaskLayerParams(i4, i5, i6, i7, i8, j4);
    }

    public final void setMaxZoomLevel(float f4) {
        this.mapDelegate.setMaxZoomLevel(f4);
    }

    public final void setMinZoomLevel(float f4) {
        this.mapDelegate.setMinZoomLevel(f4);
    }

    public final void setMyLocationEnabled(boolean z3) {
        try {
            this.mapDelegate.setMyLocationEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f4) {
        try {
            this.mapDelegate.setMyLocationRotateAngle(f4);
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

    public final void setMyLocationType(int i4) {
        try {
            this.mapDelegate.setMyLocationType(i4);
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

    public final void setNaviLabelEnable(boolean z3, int i4, int i5) {
        try {
            this.mapDelegate.setNaviLabelEnable(z3, i4, i5);
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

    public final void setPointToCenter(int i4, int i5) {
        try {
            this.mapDelegate.setCenterToPixel(i4, i5);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRenderFps(int i4) {
        this.mapDelegate.setRenderFps(i4);
    }

    public final void setRenderMode(int i4) {
        this.mapDelegate.setRenderMode(i4);
    }

    public final void setRoadArrowEnable(boolean z3) {
        try {
            this.mapDelegate.setRoadArrowEnable(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTouchPoiEnable(boolean z3) {
        try {
            this.mapDelegate.setTouchPoiEnable(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficEnabled(boolean z3) {
        try {
            this.mapDelegate.setTrafficEnabled(z3);
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

    public final void showBuildings(boolean z3) {
        try {
            this.mapDelegate.set3DBuildingEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showHideBuildings(int i4) {
        try {
            this.mapDelegate.showHideBuildings(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void showIndoorMap(boolean z3) {
        try {
            this.mapDelegate.setIndoorEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMapText(boolean z3) {
        try {
            this.mapDelegate.setMapTextEnable(z3);
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
    public void a(b bVar, OnMapSnapshotListener onMapSnapshotListener, final Runnable runnable) {
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(onMapSnapshotListener, bVar, runnable);
        animateCamera(bVar.a(), new CancelableCallback() { // from class: com.amap.api.maps.AMap.3
            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onCancel() {
                runnable.run();
            }

            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onFinish() {
                anonymousClass2.run();
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

    public final void clear(boolean z3) {
        try {
            this.mapDelegate.clear(z3);
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        private SizeF f10704b;

        /* renamed from: c  reason: collision with root package name */
        private RectF f10705c;

        /* renamed from: d  reason: collision with root package name */
        private double f10706d;

        /* renamed from: e  reason: collision with root package name */
        private LatLng f10707e;

        /* renamed from: f  reason: collision with root package name */
        private LatLng f10708f;

        /* renamed from: i  reason: collision with root package name */
        private IPoint f10711i;

        /* renamed from: j  reason: collision with root package name */
        private int f10712j;

        /* renamed from: k  reason: collision with root package name */
        private int f10713k;

        /* renamed from: g  reason: collision with root package name */
        private IPoint f10709g = new IPoint();

        /* renamed from: h  reason: collision with root package name */
        private IPoint f10710h = new IPoint();

        /* renamed from: l  reason: collision with root package name */
        private int f10714l = 0;

        public b(LatLng latLng, LatLng latLng2, Size size) {
            this.f10712j = 0;
            this.f10713k = 0;
            this.f10704b = new SizeF(size.getWidth(), size.getHeight());
            this.f10707e = latLng;
            this.f10708f = latLng2;
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.f10709g);
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, this.f10710h);
            this.f10711i = a(0.0d, this.f10704b.getHeight());
            this.f10712j = ((int) this.f10704b.getWidth()) / 4096;
            if (this.f10704b.getWidth() % 4096.0f > 0.0f) {
                this.f10712j++;
            }
            this.f10713k = ((int) this.f10704b.getHeight()) / 4096;
            if (this.f10704b.getHeight() % 4096.0f > 0.0f) {
                this.f10713k++;
            }
            this.f10705c = new RectF(0.0f, 0.0f, this.f10704b.getWidth() / this.f10712j, this.f10704b.getHeight() / this.f10713k);
            IPoint iPoint = this.f10710h;
            int i4 = ((Point) iPoint).y;
            IPoint iPoint2 = this.f10709g;
            double d4 = i4 - ((Point) iPoint2).y;
            double d5 = ((Point) iPoint).x - ((Point) iPoint2).x;
            Double.isNaN(d4);
            Double.isNaN(d5);
            this.f10706d = Math.atan(d4 / d5);
        }

        private IPoint a(double d4, double d5) {
            double sin = Math.sin(this.f10706d);
            double cos = Math.cos(this.f10706d);
            double distance = this.f10709g.distance(this.f10710h);
            double width = this.f10704b.getWidth();
            Double.isNaN(width);
            double d6 = distance / width;
            IPoint iPoint = this.f10709g;
            double d7 = ((Point) iPoint).x;
            Double.isNaN(d7);
            double d8 = ((Point) iPoint).y;
            Double.isNaN(d8);
            return new IPoint((int) ((((d4 * cos) - (d5 * sin)) * d6) + d7), (int) ((d6 * ((cos * d5) + (sin * d4))) + d8));
        }

        private LatLng b(double d4, double d5) {
            IPoint a4 = a(d4, d5);
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(((Point) a4).x, ((Point) a4).y, dPoint);
            return new LatLng(dPoint.f11672y, dPoint.f11671x);
        }

        public final Size c() {
            return new Size((int) this.f10705c.width(), (int) this.f10705c.height());
        }

        public final boolean d() {
            RectF rectF = this.f10705c;
            if (rectF.right + rectF.width() <= this.f10704b.getWidth()) {
                RectF rectF2 = this.f10705c;
                rectF2.offset(rectF2.width(), 0.0f);
            } else {
                RectF rectF3 = this.f10705c;
                if (rectF3.bottom + rectF3.height() > this.f10704b.getHeight()) {
                    return false;
                }
                RectF rectF4 = this.f10705c;
                rectF4.offset(-rectF4.left, rectF4.height());
            }
            this.f10714l++;
            return true;
        }

        public final boolean e() {
            return this.f10714l == (this.f10712j * this.f10713k) - 1;
        }

        private static LatLng a(long j4, long j5) {
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(j4, j5, dPoint);
            return new LatLng(dPoint.f11672y, dPoint.f11671x);
        }

        public final Rect b() {
            RectF rectF = this.f10705c;
            return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }

        public final CameraUpdate a() {
            int i4 = this.f10714l;
            if (i4 == 0) {
                return CameraUpdateFactory.newCameraPosition(new CameraPosition(b(this.f10705c.centerX(), this.f10705c.centerY()), AMap.this.getZoomToSpanLevel(a(0L, ((long) this.f10709g.distance(this.f10710h)) / this.f10712j), a(((long) this.f10711i.distance(this.f10709g)) / this.f10713k, 0L)), 0.0f, (float) ((this.f10706d * 180.0d) / 3.141592653589793d)));
            }
            int i5 = this.f10712j;
            if ((i4 - 1) / i5 < i4 / i5) {
                return CameraUpdateFactory.scrollBy((-this.f10705c.width()) * (this.f10712j - 1), this.f10705c.height());
            }
            return CameraUpdateFactory.scrollBy(this.f10705c.width(), 0.0f);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j4, CancelableCallback cancelableCallback) {
        if (j4 <= 0) {
            try {
                Log.w("AMap", "durationMs must be positive");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.mapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, j4, cancelableCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.amap.api.maps.AMap$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnMapSnapshotListener f10684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f10685b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Runnable f10686c;

        AnonymousClass2(OnMapSnapshotListener onMapSnapshotListener, b bVar, Runnable runnable) {
            this.f10684a = onMapSnapshotListener;
            this.f10685b = bVar;
            this.f10686c = runnable;
        }

        private ViewGroup a() {
            if (AMap.this.mapDelegate instanceof p9) {
                ViewGroup viewGroup = (ViewGroup) ((p9) AMap.this.mapDelegate).getGLMapView().getParent();
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
            final ViewGroup a4 = a();
            a(a4, new Runnable() { // from class: com.amap.api.maps.AMap.2.3
                @Override // java.lang.Runnable
                public final void run() {
                    AMap.this.mapDelegate.getMapScreenShot(new OnMapScreenShotListener() { // from class: com.amap.api.maps.AMap.2.3.1
                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap) {
                        }

                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap, int i4) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AnonymousClass2.this.a(a4, bitmap);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            anonymousClass2.f10684a.onMapTile(anonymousClass2.f10685b.b(), bitmap, i4);
                            if (AnonymousClass2.this.f10685b.d()) {
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                AMap.this.a(anonymousClass22.f10685b, anonymousClass22.f10684a, anonymousClass22.f10686c);
                                return;
                            }
                            AnonymousClass2.this.f10686c.run();
                        }
                    }, AnonymousClass2.this.f10685b.e());
                }
            });
        }

        private void a(ViewGroup viewGroup, final Runnable runnable) {
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

        final void a(final ViewGroup viewGroup, Bitmap bitmap) {
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
