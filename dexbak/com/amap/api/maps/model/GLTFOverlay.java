package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLTFOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private GLTFOverlayOptions mOptions;

    public GLTFOverlay(IGlOverlayLayer iGlOverlayLayer, GLTFOverlayOptions gLTFOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mOptions = gLTFOverlayOptions;
    }

    /* renamed from: a */
    private Object m52084a(String str) {
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
        return this.mOptions.m60100clone();
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
        Object m52084a = m52084a("isAnimated");
        if (m52084a instanceof Boolean) {
            return ((Boolean) m52084a).booleanValue();
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

    public void setClickable(boolean z) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setClickable(z);
        }
    }

    public void setCurrentAnimationIndex(int i) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setCurrentAnimationIndex(i);
            m52085a();
        }
    }

    public void setDraggable(boolean z) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setDraggable(z);
        }
    }

    public void setInfoWindowView(BitmapDescriptor bitmapDescriptor) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.infoWindowView(bitmapDescriptor);
            m52085a();
        }
    }

    public void setLatLng(LatLng latLng) {
        try {
            GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
            if (gLTFOverlayOptions != null) {
                gLTFOverlayOptions.latLng(latLng);
                m52085a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setZIndex(f);
            m52085a();
        }
    }

    public void tapClick() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.tapClick();
        }
        try {
            m52084a("tapClick");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m52085a() {
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
