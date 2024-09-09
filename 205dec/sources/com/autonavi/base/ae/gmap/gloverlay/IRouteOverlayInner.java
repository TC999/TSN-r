package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IRouteOverlayInner {
    void addRouteItem(int i4, er[] erVarArr, int i5, eq eqVar, int[] iArr);

    void addRouteName();

    Pair<Float, Float> getDisplayRange();

    int getOverlayProperty();

    boolean isVisible();

    void remove();

    void removeRouteName();

    void setArrow3DTexture(BitmapDescriptor bitmapDescriptor);

    void setArrowFlow(boolean z3);

    void setCar2DPosition(int i4, float f4);

    void setCar3DPosition(int i4, float f4);

    void setDisplayRange(float f4, float f5);

    void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam);

    void setHighlightType(int i4);

    void setLine2DWidth(int i4, int i5);

    void setLineWidthScale(float f4);

    void setOverlayProperty(int i4);

    void setRouteItemParam(er erVar);

    void setSelectStatus(boolean z3);

    void setShowArrow(boolean z3);

    void setShowNaviRouteNameCountMap(Map<Integer, Integer> map);

    void setVisible(boolean z3);
}
