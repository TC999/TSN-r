package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Arc extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ArcOptions options;

    public Arc(IGlOverlayLayer iGlOverlayLayer, ArcOptions arcOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = arcOptions;
    }

    /* renamed from: a */
    private void m52096a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Arc)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((Arc) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getStrokeColor() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final float getStrokeWidth() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getZIndex() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final boolean isVisible() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeColor(int i) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeColor(i);
                m52096a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeWidth(f);
                m52096a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.visible(z);
                m52096a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.zIndex(f);
                m52096a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
