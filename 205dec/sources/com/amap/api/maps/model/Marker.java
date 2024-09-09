package com.amap.api.maps.model;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Marker extends BasePointOverlay {
    private IPoint geoPoint;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable;
    private boolean isInfoWindowEnable;
    private boolean isRemoved;
    private boolean isUseAnimation;
    private Animation mCurAnimation;
    private Animation.AnimationListener mCurAnimationListener;
    private a mCurInnerAnimationListener;
    private Object object;
    private MarkerOptions options;
    private LatLng viewModeLatLng;
    private DPoint viewModeLatLngDp;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private final a8 f10741b;

        /* renamed from: c  reason: collision with root package name */
        private final a8 f10742c;

        /* synthetic */ a(Marker marker, Animation.AnimationListener animationListener, byte b4) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            y2.a().b(this.f10742c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            y2.a().b(this.f10741b);
        }

        private a(final Animation.AnimationListener animationListener) {
            this.f10741b = new a8() { // from class: com.amap.api.maps.model.Marker.a.1
                @Override // com.amap.api.col.p0003l.a8
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f10742c = new a8() { // from class: com.amap.api.maps.model.Marker.a.2
                @Override // com.amap.api.col.p0003l.a8
                public final void runTask() {
                    try {
                        Animation.AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }
    }

    public Marker(IGlOverlayLayer iGlOverlayLayer, MarkerOptions markerOptions, String str) {
        super(str);
        this.isRemoved = false;
        this.viewModeLatLngDp = new DPoint();
        this.viewModeLatLng = null;
        this.isUseAnimation = false;
        this.mCurAnimation = null;
        this.mCurAnimationListener = null;
        this.mCurInnerAnimationListener = null;
        this.isClickable = true;
        this.isInfoWindowEnable = true;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = markerOptions;
    }

    private Object a(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void destroy() {
        try {
            remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Marker)) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null && markerOptions.equals(((Marker) obj).options)) {
                    if (this.overlayName.equals(((Marker) obj).overlayName)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final float getAlpha() {
        Object a4;
        if (this.options != null) {
            if (this.isUseAnimation && (a4 = a("getAlpha", null)) != null) {
                return ((Double) a4).floatValue();
            }
            return this.options.getAlpha();
        }
        return 1.0f;
    }

    public final float getAltitude() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getAltitude();
            }
            return 0.0f;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0f;
        }
    }

    public final float getAnchorU() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public final float getAnchorV() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public final int getDisplayLevel() {
        return 5;
    }

    public final IPoint getGeoPoint() {
        if (this.geoPoint == null) {
            this.geoPoint = new IPoint();
        }
        LatLng position = getPosition();
        if (position != null) {
            VirtualEarthProjection.latLongToPixels(position.latitude, position.longitude, 20, this.geoPoint);
        }
        return this.geoPoint;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.options.getIcons();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final Object getObject() {
        return this.object;
    }

    public final MarkerOptions getOptions() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions;
        }
        return null;
    }

    public final int getPeriod() {
        try {
            return this.options.getPeriod();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final LatLng getPosition() {
        Object a4;
        try {
            if (this.options != null) {
                if (isViewMode()) {
                    this.glOverlayLayerRef.get().getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);
                    LatLng latLng = this.viewModeLatLng;
                    if (latLng != null) {
                        double d4 = latLng.latitude;
                        DPoint dPoint = this.viewModeLatLngDp;
                        if (d4 == dPoint.f11672y && latLng.longitude == dPoint.f11671x) {
                            return latLng;
                        }
                    }
                    DPoint dPoint2 = this.viewModeLatLngDp;
                    return new LatLng(dPoint2.f11672y, dPoint2.f11671x);
                } else if (this.isUseAnimation && (a4 = a("getPosition", null)) != null) {
                    return (LatLng) a4;
                } else {
                    return this.options.getPosition();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final float getRotateAngle() {
        if (this.options != null) {
            if (this.isUseAnimation) {
                Object a4 = a("getRotateAngle", null);
                Log.e("mapcore", "getRotateAngle ".concat(String.valueOf(a4)));
                if (a4 != null) {
                    return ((Double) a4).floatValue();
                }
            }
            return this.options.getRotateAngle();
        }
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getSnippet() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final String getTitle() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public final int hashCode() {
        if (this.options != null) {
            String str = this.overlayName;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
        }
        return super.hashCode();
    }

    public final void hideInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.hideInfoWindow(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isClickable() {
        Object a4 = a("isClickable", null);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return this.isClickable;
    }

    public final boolean isDraggable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    public final boolean isFlat() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isInfoWindowEnable();
        }
        return this.isInfoWindowEnable;
    }

    public final boolean isInfoWindowShown() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return false;
        }
        Object a4 = a("isInfoWindowShown", null);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return false;
    }

    public final boolean isPerspective() {
        return false;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isViewMode() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean isVisible() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void remove() {
        try {
            if (isInfoWindowShown()) {
                hideInfoWindow();
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            this.isRemoved = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlpha(float f4) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.alpha(f4);
            a();
        }
    }

    public final void setAltitude(float f4) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.altitude(f4);
                a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void setAnchor(float f4, float f5) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f4, f5);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                Animation.AnimationListener animationListener = this.mCurAnimationListener;
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.mCurAnimation = animation;
        this.isUseAnimation = animation != null;
        a("setAnimation", new Object[]{animation});
        if (animation != null) {
            animation.resetUpdateFlags();
        }
    }

    public final void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mCurAnimationListener = animationListener;
        a aVar = new a(this, animationListener, (byte) 0);
        this.mCurInnerAnimationListener = aVar;
        if (this.mCurAnimation != null) {
            a("setAnimationListener", new Object[]{aVar});
        }
    }

    public final void setAutoOverturnInfoWindow(boolean z3) {
    }

    public final void setBelowMaskLayer(boolean z3) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.belowMaskLayer(z3);
            a();
        }
    }

    public final void setClickable(boolean z3) {
        this.isClickable = z3;
        a("setClickable", new Object[]{Boolean.valueOf(z3)});
    }

    public final void setDisplayLevel(int i4) {
    }

    public final void setDraggable(boolean z3) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFixingPointEnable(boolean z3) {
    }

    public final void setFlat(boolean z3) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.setFlat(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setGeoPoint(IPoint iPoint) {
        this.geoPoint = iPoint;
        if (iPoint != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            LatLng latLng = new LatLng(pixelsToLatLong.f11672y, pixelsToLatLong.f11671x, false);
            pixelsToLatLong.recycle();
            this.options.position(latLng);
            a();
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.options.icons(arrayList);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowEnable(boolean z3) {
        this.isInfoWindowEnable = z3;
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z3);
            a();
        }
    }

    public final void setMarkerOptions(MarkerOptions markerOptions) {
        this.options = markerOptions;
        a();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setObject(Object obj) {
        this.object = obj;
    }

    public final void setPeriod(int i4) {
        try {
            this.options.period(i4);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPerspective(boolean z3) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setPosition(LatLng latLng) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPositionByPixels(int i4, int i5) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.setScreenPosition(i4, i5);
            a();
        }
    }

    public final void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setRotateAngle(float f4) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateAngleNotUpdate(float f4) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setSnippet(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setTitle(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setToTop() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.set2Top(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void setVisible(boolean z3) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f4) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f4);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final void showInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.showInfoWindow(this.overlayName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public final boolean startAnimation() {
        Object a4 = a("startAnimation", null);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }
}
