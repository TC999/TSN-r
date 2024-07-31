package com.autonavi.base.p048ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import com.amap.api.col.p0463l.GLRouteOverlayData;
import com.amap.api.col.p0463l.GLRouteProperty;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.Map;

/* renamed from: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteOverlayInner extends BaseMapOverlay<BaseRouteOverlay, Object> implements IRouteOverlayInner {
    private float maxDisplayLevel;
    private float minDisplayLevel;
    private int property;

    public RouteOverlayInner(int i, Context context, IAMap iAMap) {
        super(i, context, iAMap);
        this.minDisplayLevel = 3.0f;
        this.maxDisplayLevel = 20.0f;
        this.property = 1;
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.BaseMapOverlay
    public void addItem(Object obj) {
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteItem(final int i, final GLRouteProperty[] gLRoutePropertyArr, final int i2, final GLRouteOverlayData gLRouteOverlayData, final int[] iArr) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.1
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).addRouteItem(i, gLRoutePropertyArr, i2, gLRouteOverlayData, iArr);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteName() {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.4
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).addRouteName();
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public Pair<Float, Float> getDisplayRange() {
        return new Pair<>(Float.valueOf(this.minDisplayLevel), Float.valueOf(this.maxDisplayLevel));
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public int getOverlayProperty() {
        return this.property;
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.BaseMapOverlay
    protected void iniGLOverlay() {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.17
                @Override // java.lang.Runnable
                public void run() {
                    RouteOverlayInner routeOverlayInner = RouteOverlayInner.this;
                    routeOverlayInner.mGLOverlay = new BaseRouteOverlay(routeOverlayInner.mEngineID, routeOverlayInner.mMapView, hashCode());
                    ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setMinDisplayLevel(3.0f);
                    ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setMaxDisplayLevel(20.0f);
                    ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setOverlayPriorityOnly(1);
                }
            });
        }
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void remove() {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.16
            @Override // java.lang.Runnable
            public void run() {
                RouteOverlayInner.this.releaseInstance();
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void removeRouteName() {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.5
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).removeRouteName();
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.BaseMapOverlay
    public void resumeMarker(Bitmap bitmap) {
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrow3DTexture(final BitmapDescriptor bitmapDescriptor) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.9
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setArrow3DTexture(bitmapDescriptor);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrowFlow(final boolean z) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.15
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setArrowFlow(z);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar2DPosition(final int i, final float f) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.2
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setCar2DPosition(i, f);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar3DPosition(final int i, final float f) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.3
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setCar3DPosition(i, f);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setDisplayRange(final float f, final float f2) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        this.minDisplayLevel = f;
        this.maxDisplayLevel = f2;
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.19
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setMinDisplayLevel(f);
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setMaxDisplayLevel(f2);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightParam(final RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.12
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setHighlightParam(routeOverlayHighLightParam);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightType(final int i) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.11
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setHighlightType(i);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setLine2DWidth(final int i, final int i2) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.7
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setLine2DWidth(i, i2);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setLineWidthScale(final float f) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.6
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setLineWidthScale(f);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setOverlayProperty(final int i) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        this.property = i;
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.20
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setOverlayPriorityOnly(i);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setRouteItemParam(final GLRouteProperty gLRouteProperty) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.10
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setRouteItemParam(gLRouteProperty);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setSelectStatus(final boolean z) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.13
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setSelectStatus(z);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowArrow(final boolean z) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.8
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setShowArrow(z);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowNaviRouteNameCountMap(final Map<Integer, Integer> map) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.14
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setShowNaviRouteNameCountMap(map);
            }
        });
    }

    @Override // com.autonavi.base.p048ae.gmap.gloverlay.BaseMapOverlay, com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setVisible(final boolean z) {
        IAMapDelegate iAMapDelegate = this.mMapView;
        if (iAMapDelegate == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner.18
            @Override // java.lang.Runnable
            public void run() {
                ((BaseRouteOverlay) RouteOverlayInner.this.mGLOverlay).setVisible(z);
            }
        });
    }
}
