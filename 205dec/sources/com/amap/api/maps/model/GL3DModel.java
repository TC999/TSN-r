package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GL3DModel extends BasePointOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private Object object;
    private GL3DModelOptions options;

    public GL3DModel(IGlOverlayLayer iGlOverlayLayer, GL3DModelOptions gL3DModelOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = gL3DModelOptions;
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

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        remove();
    }

    public double getAltitude() {
        try {
            return this.options.getAltitude();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0d;
        }
    }

    public float getAngle() {
        try {
            return this.options.getAngle();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.overlayName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            return this.options.getLatLng();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        try {
            return getAngle();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getSnippet() : "";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getTitle() : "";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public int getZIndex() {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions == null) {
            return 0;
        }
        return gL3DModelOptions.getZIndex();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.options.isVisible();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAltitude(double d4) {
        try {
            this.options.setAltitude(d4);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setAngle(float f4) {
        try {
            this.options.angle(f4);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        try {
            a("setAnimation", new Object[]{animation});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
    }

    public void setModelFixedLength(int i4) {
        try {
            this.options.setModelFixedLength(i4);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        try {
            this.object = obj;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.options.position(latLng);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f4) {
        try {
            setAngle(f4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.snippet(str);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.title(str);
            a();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z3) {
        try {
            this.options.setVisible(z3);
            a();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setZIndex(int i4) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.setzIndex(i4);
            a();
        }
    }

    public void setZoomLimit(float f4) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
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
    public boolean startAnimation() {
        Object a4 = a("startAnimation", null);
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return false;
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
}
