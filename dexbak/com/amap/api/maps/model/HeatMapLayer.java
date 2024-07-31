package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HeatMapLayer extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private HeatMapLayerOptions options;

    public HeatMapLayer(IGlOverlayLayer iGlOverlayLayer, HeatMapLayerOptions heatMapLayerOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = heatMapLayerOptions;
        m52073a();
    }

    /* renamed from: a */
    private void m52073a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof HeatMapLayer)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((HeatMapLayer) obj).getId().equals(getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public HeatMapItem getHeatMapItem(LatLng latLng) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                Object nativeProperties = iGlOverlayLayer.getNativeProperties(this.overlayName, "getHeatMapItem", new Object[]{latLng});
                if (nativeProperties instanceof HeatMapItem) {
                    return (HeatMapItem) nativeProperties;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public HeatMapLayerOptions getOptions() {
        try {
            return this.options;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                return heatMapLayerOptions.isVisible();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setOptions(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            this.options = heatMapLayerOptions;
            m52073a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.visible(z);
                m52073a();
            }
        } catch (Throwable unused) {
        }
    }

    public void setZIndex(float f) {
        try {
            HeatMapLayerOptions heatMapLayerOptions = this.options;
            if (heatMapLayerOptions != null) {
                heatMapLayerOptions.zIndex(f);
                m52073a();
            }
        } catch (Throwable unused) {
        }
    }
}
