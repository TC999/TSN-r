package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BaseRouteOverlay extends GLOverlay implements IRouteOverlayInner {
    public BaseRouteOverlay(final int i4, IAMapDelegate iAMapDelegate, int i5) {
        super(i4, iAMapDelegate, i5);
        IAMapDelegate iAMapDelegate2 = this.mGLMapView;
        if (iAMapDelegate2 == null || iAMapDelegate2.getGLMapEngine() == null) {
            return;
        }
        this.mGLMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.BaseRouteOverlay.1
            @Override // java.lang.Runnable
            public void run() {
                BaseRouteOverlay baseRouteOverlay = BaseRouteOverlay.this;
                baseRouteOverlay.mNativeInstance = baseRouteOverlay.mGLMapView.getGLMapEngine().createOverlay(i4, GLOverlay.EAMapOverlayTpye.AMAPROUTE_OVERLAY.getId());
            }
        });
    }

    private static native void nativeAddRouteItem(long j4, int i4, er[] erVarArr, int i5, eq eqVar, int[] iArr);

    private static native void nativeAddRouteName(long j4);

    private static native void nativeRemoveRouteName(long j4, long j5);

    private static native void nativeSetArrow3DTexture(long j4, int i4);

    private static native void nativeSetArrowFlow(long j4, boolean z3);

    private static native void nativeSetCar2DPosition(long j4, int i4, float f4);

    private static native void nativeSetCar3DPosition(long j4, int i4, float f4);

    private static native void nativeSetHighlightParam(long j4, int[] iArr);

    private static native void nativeSetHighlightType(long j4, int i4);

    private static native void nativeSetLine2DWidth(long j4, int i4, int i5);

    private static native void nativeSetLineWidthScale(long j4, float f4);

    private static native void nativeSetRouteItemParam(long j4, er erVar);

    private static native void nativeSetSelectStatus(long j4, boolean z3);

    private static native void nativeSetShowArrow(long j4, boolean z3);

    private static native void nativeSetShowNaviRouteNameCountMap(long j4, int[] iArr, int[] iArr2);

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteItem(int i4, er[] erVarArr, int i5, eq eqVar, int[] iArr) {
        int createOverlayTexture;
        int createOverlayTexture2;
        int createOverlayTexture3;
        if (this.mNativeInstance == 0) {
            return;
        }
        for (int i6 = 0; i6 < erVarArr.length; i6++) {
            if (erVarArr[i6] == null) {
                return;
            }
            er erVar = erVarArr[i6];
            BitmapDescriptor bitmapDescriptor = erVar.f7647a;
            if (bitmapDescriptor != null && (createOverlayTexture3 = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor.getBitmap())) >= 0) {
                erVar.f7648b = createOverlayTexture3;
            }
            BitmapDescriptor bitmapDescriptor2 = erVar.f7649c;
            if (bitmapDescriptor2 != null && (createOverlayTexture2 = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor2.getBitmap())) >= 0) {
                erVar.f7650d = createOverlayTexture2;
            }
            BitmapDescriptor bitmapDescriptor3 = erVar.f7651e;
            if (bitmapDescriptor3 != null && (createOverlayTexture = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor3.getBitmap())) >= 0) {
                erVar.f7652f = createOverlayTexture;
            }
        }
        nativeAddRouteItem(this.mNativeInstance, i4, erVarArr, i5, eqVar, iArr);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteName() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeAddRouteName(j4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public Pair<Float, Float> getDisplayRange() {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public int getOverlayProperty() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        long j4 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j4);
        super.releaseInstance();
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void remove() {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void removeRouteName() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveRouteName(j4, this.mGLMapView.getGLMapEngine().getNativeInstance());
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        int createOverlayTexture;
        if (this.mNativeInstance == 0 || bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || (createOverlayTexture = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor.getBitmap())) < 0) {
            return;
        }
        nativeSetArrow3DTexture(this.mNativeInstance, createOverlayTexture);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrowFlow(boolean z3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetArrowFlow(j4, z3);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar2DPosition(int i4, float f4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetCar2DPosition(j4, i4, f4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar3DPosition(int i4, float f4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetCar3DPosition(j4, i4, f4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setDisplayRange(float f4, float f5) {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetHighlightParam(j4, new int[]{routeOverlayHighLightParam.fillColorHightLight, routeOverlayHighLightParam.borderColorHightLight, routeOverlayHighLightParam.fillColorNormal, routeOverlayHighLightParam.borderColorNormal, routeOverlayHighLightParam.arrowColorNormal});
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightType(int i4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetHighlightType(j4, i4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLine2DWidth(int i4, int i5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetLine2DWidth(j4, i4, i5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLineWidthScale(float f4) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetLineWidthScale(j4, f4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setOverlayProperty(int i4) {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setRouteItemParam(er erVar) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetRouteItemParam(j4, erVar);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setSelectStatus(boolean z3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetSelectStatus(j4, z3);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowArrow(boolean z3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetShowArrow(j4, z3);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        if (this.mNativeInstance == 0) {
            return;
        }
        int[] iArr = new int[map.size()];
        int[] iArr2 = new int[map.size()];
        int i4 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            iArr[i4] = entry.getKey().intValue();
            iArr2[i4] = entry.getValue().intValue();
            i4++;
        }
        nativeSetShowNaviRouteNameCountMap(this.mNativeInstance, iArr, iArr2);
    }
}
