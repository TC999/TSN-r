package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003l.t8;
import com.amap.api.col.p0003l.z;
import com.amap.api.maps.AMap;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int i4, AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i4, GLTextureProperty gLTextureProperty);

    void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j4, AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String str, boolean z3, int i4);

    void changeMapLogo(int i4, boolean z3);

    void changeSize(int i4, int i5);

    void changeSurface(int i4, GL10 gl10, int i5, int i6);

    float checkZoomLevel(float f4) throws RemoteException;

    void clearTileCache();

    String createId(String str);

    int createOverlayTexture(int i4, Bitmap bitmap);

    void createSurface(int i4, GL10 gl10, EGLConfig eGLConfig);

    void geo2Latlng(int i4, int i5, DPoint dPoint);

    void geo2Map(int i4, int i5, FPoint fPoint);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int i4);

    CameraPosition getCameraPositionPrj(boolean z3);

    Context getContext();

    t8 getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int i4, IPoint iPoint);

    IGlOverlayLayer getGlOverlayLayer();

    z getInfoWindowDelegate();

    void getLatLng2Map(double d4, double d5, FPoint fPoint);

    void getLatLng2Pixel(double d4, double d5, IPoint iPoint);

    float getLogoMarginRate(int i4);

    int getLogoPosition();

    float getMapAngle(int i4);

    LatLngBounds getMapBounds(LatLng latLng, float f4, float f5, float f6);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int i4, int i5, IPoint iPoint);

    void getPixel2LatLng(int i4, int i5, DPoint dPoint);

    float getPreciseLevel(int i4);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i4);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i4);

    boolean isLockMapCameraDegree(int i4);

    boolean isUseAnchor();

    void latlon2Geo(double d4, double d5, IPoint iPoint);

    void map2Geo(float f4, float f5, IPoint iPoint);

    void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    boolean onDoubleTap(int i4, MotionEvent motionEvent);

    void onLongPress(int i4, MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i4, MotionEvent motionEvent);

    void pixel2Map(int i4, int i5, PointF pointF);

    void post(Runnable runnable);

    void redrawInfoWindow();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(String str);

    boolean removeGLOverlay(String str) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z3, byte[] bArr);

    void setGestureStatus(int i4, int i5);

    void setHideLogoEnble(boolean z3);

    void setLogoBottomMargin(int i4);

    void setLogoLeftMargin(int i4);

    void setLogoMarginRate(int i4, float f4);

    void setLogoPosition(int i4);

    void setMapCustomEnable(boolean z3, boolean z4);

    void setMapEnable(boolean z3);

    void setMapWidgetListener(AMapWidgetListener aMapWidgetListener);

    void setTerrainAuth(boolean z3);

    void setZoomPosition(int i4);

    void showCompassEnabled(boolean z3);

    void showIndoorSwitchControlsEnabled(boolean z3);

    void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;

    void showLogoEnabled(boolean z3);

    void showMyLocationButtonEnabled(boolean z3);

    void showMyLocationOverlay(Location location) throws RemoteException;

    void showScaleEnabled(boolean z3);

    void showZoomControlsEnabled(boolean z3);

    float toMapLenWithWin(int i4);

    void zoomOut(int i4);
}
