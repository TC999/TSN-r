package com.amap.api.maps.model;

import android.util.Pair;
import com.amap.api.col.p0463l.GLRouteOverlayData;
import com.amap.api.col.p0463l.GLRouteProperty;
import com.autonavi.base.p048ae.gmap.gloverlay.IRouteOverlayInner;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteOverlay {
    private IRouteOverlayInner mBaseRouteOverlay;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum MapRouteScene {
        NORMAL,
        CHARGE,
        LIMIT,
        CIMMUTE,
        WRONG,
        SHARE,
        HD
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class RouteOverlayHighLightParam {
        public int arrowColorNormal;
        public int borderColorHightLight;
        public int borderColorNormal;
        public int fillColorHightLight;
        public int fillColorNormal;
    }

    public RouteOverlay(IRouteOverlayInner iRouteOverlayInner) {
        this.mBaseRouteOverlay = iRouteOverlayInner;
    }

    public void addRouteItem(int i, GLRouteProperty[] gLRoutePropertyArr, boolean z, GLRouteOverlayData gLRouteOverlayData, int[] iArr) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteItem(i, gLRoutePropertyArr, z ? 1 : 0, gLRouteOverlayData, iArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pair<Float, Float> getDisplayRange() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return null;
            }
            return iRouteOverlayInner.getDisplayRange();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getOverlayPriority() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.getOverlayProperty();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.isVisible();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.removeRouteName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrow3DTexture(bitmapDescriptor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrowFlow(boolean z) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrowFlow(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCar2DPosition(int i, float f) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setCar2DPosition(i, f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDisplayRange(float f, float f2) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setDisplayRange(f, f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighlightParam(RouteOverlayHighLightParam routeOverlayHighLightParam) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightParam(routeOverlayHighLightParam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHighlightType(int i) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightType(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLine2DWidth(int i, int i2) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLine2DWidth(i, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLineWidthScale(float f) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLineWidthScale(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOverlayPriority(int i) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setOverlayProperty(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRouteItemParam(GLRouteProperty gLRouteProperty) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setRouteItemParam(gLRouteProperty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSelectStatus(boolean z) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setSelectStatus(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setShowArrow(boolean z) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowArrow(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowNaviRouteNameCountMap(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setVisible(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
