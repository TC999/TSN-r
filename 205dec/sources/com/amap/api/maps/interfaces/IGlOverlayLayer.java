package com.amap.api.maps.interfaces;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IGlOverlayLayer {
    boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng);

    boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng);

    BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions);

    void changeOverlayIndex();

    boolean checkInBounds(String str);

    void clear(String... strArr);

    void clearOverlayByType(String str);

    void clearTileCache();

    String createId(String str);

    void destroy();

    boolean draw(int i4, int i5, boolean z3);

    int getCurrentParticleNum(String str);

    BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i4);

    BaseOverlay getHitBaseOverlay(LatLng latLng, int i4);

    Polyline getHitOverlay(LatLng latLng, int i4);

    IAMapDelegate getMap();

    List<Marker> getMapScreenMarkers();

    void getMarkerInfoWindowOffset(String str, FPoint fPoint);

    MultiPointItem getMultiPointItem(LatLng latLng);

    Object getNativeProperties(String str, String str2, Object[] objArr);

    LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng);

    void getOverlayScreenPos(String str, FPoint fPoint);

    void hideInfoWindow(String str);

    boolean isGLTFAnimated();

    void onCreateAMapInstance();

    boolean removeOverlay(String str) throws RemoteException;

    boolean removeOverlay(String str, boolean z3) throws RemoteException;

    void set2Top(String str);

    void setFlingState(boolean z3);

    void setRunLowFrame(boolean z3);

    void showInfoWindow(String str);

    void updateOption(String str, BaseOptions baseOptions);
}
