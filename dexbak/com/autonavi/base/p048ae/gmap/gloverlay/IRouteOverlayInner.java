package com.autonavi.base.p048ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0463l.GLRouteOverlayData;
import com.amap.api.col.p0463l.GLRouteProperty;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import java.util.Map;

/* renamed from: com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IRouteOverlayInner {
    void addRouteItem(int i, GLRouteProperty[] gLRoutePropertyArr, int i2, GLRouteOverlayData gLRouteOverlayData, int[] iArr);

    void addRouteName();

    Pair<Float, Float> getDisplayRange();

    int getOverlayProperty();

    boolean isVisible();

    void remove();

    void removeRouteName();

    void setArrow3DTexture(BitmapDescriptor bitmapDescriptor);

    void setArrowFlow(boolean z);

    void setCar2DPosition(int i, float f);

    void setCar3DPosition(int i, float f);

    void setDisplayRange(float f, float f2);

    void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam);

    void setHighlightType(int i);

    void setLine2DWidth(int i, int i2);

    void setLineWidthScale(float f);

    void setOverlayProperty(int i);

    void setRouteItemParam(GLRouteProperty gLRouteProperty);

    void setSelectStatus(boolean z);

    void setShowArrow(boolean z);

    void setShowNaviRouteNameCountMap(Map<Integer, Integer> map);

    void setVisible(boolean z);
}
