package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLTFOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private GLTFOverlayOptions mOptions;

    public GLTFOverlay(IGlOverlayLayer iGlOverlayLayer, GLTFOverlayOptions gLTFOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mOptions = gLTFOverlayOptions;
    }

    private Object a(String str) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                return iGlOverlayLayer.getNativeProperties(this.overlayName, str, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int getCurrentAnimationIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.getCurrentAnimationIndex();
            return -1;
        }
        return -1;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public BitmapDescriptor getInfoWindowView() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getInfoWindowView();
        }
        return null;
    }

    public LatLng getLatlng() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getLatLng();
        }
        return null;
    }

    public GLTFOverlayOptions getOptions() {
        return this.mOptions.m21clone();
    }

    public float getZIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getZIndex();
        }
        return 0.0f;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isAnimated() {
        Object a4 = a("isAnimated");
        if (a4 instanceof Boolean) {
            return ((Boolean) a4).booleanValue();
        }
        return false;
    }

    public boolean isClickable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isDraggable();
        }
        return true;
    }

    public boolean isInfoWindowShow() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isInfoWindowShow();
        }
        return false;
    }

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

    public void setClickable(boolean z3) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setClickable(z3);
        }
    }

    public void setCurrentAnimationIndex(int i4) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setCurrentAnimationIndex(i4);
            a();
        }
    }

    public void setDraggable(boolean z3) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setDraggable(z3);
        }
    }

    public void setInfoWindowView(BitmapDescriptor bitmapDescriptor) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.infoWindowView(bitmapDescriptor);
            a();
        }
    }

    public void setLatLng(LatLng latLng) {
        try {
            GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
            if (gLTFOverlayOptions != null) {
                gLTFOverlayOptions.latLng(latLng);
                a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setZIndex(float f4) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setZIndex(f4);
            a();
        }
    }

    public void tapClick() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.tapClick();
        }
        try {
            a("tapClick");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mOptions);
        } catch (Throwable unused) {
        }
    }
}
