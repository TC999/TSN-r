package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private NavigateArrowOptions options;

    public NavigateArrow(IGlOverlayLayer iGlOverlayLayer, NavigateArrowOptions navigateArrowOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavigateArrow)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((NavigateArrow) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public int getSideColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getSideColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getTopColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean is3DModel() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.is3DModel();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
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

    public void set3DModel(boolean z3) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.set3DModel(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.setPoints(list);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i4) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.sideColor(i4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i4) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.topColor(i4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z3) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.visible(z3);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f4) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.width(f4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f4) {
        try {
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                navigateArrowOptions.zIndex(f4);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
