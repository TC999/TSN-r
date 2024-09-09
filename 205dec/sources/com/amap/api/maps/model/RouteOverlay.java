package com.amap.api.maps.model;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteOverlay {
    private IRouteOverlayInner mBaseRouteOverlay;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum MapRouteScene {
        NORMAL,
        CHARGE,
        LIMIT,
        CIMMUTE,
        WRONG,
        SHARE,
        HD
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public void addRouteItem(int i4, er[] erVarArr, boolean z3, eq eqVar, int[] iArr) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteItem(i4, erVarArr, z3 ? 1 : 0, eqVar, iArr);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void addRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteName();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public Pair<Float, Float> getDisplayRange() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return null;
            }
            return iRouteOverlayInner.getDisplayRange();
        } catch (Exception e4) {
            e4.printStackTrace();
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
        } catch (Exception e4) {
            e4.printStackTrace();
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
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.remove();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void removeRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.removeRouteName();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrow3DTexture(bitmapDescriptor);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setArrowFlow(boolean z3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrowFlow(z3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setCar2DPosition(int i4, float f4) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setCar2DPosition(i4, f4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setDisplayRange(float f4, float f5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setDisplayRange(f4, f5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setHighlightParam(RouteOverlayHighLightParam routeOverlayHighLightParam) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightParam(routeOverlayHighLightParam);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setHighlightType(int i4) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightType(i4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setLine2DWidth(int i4, int i5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLine2DWidth(i4, i5);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setLineWidthScale(float f4) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLineWidthScale(f4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setOverlayPriority(int i4) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setOverlayProperty(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setRouteItemParam(er erVar) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setRouteItemParam(erVar);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setSelectStatus(boolean z3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setSelectStatus(z3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setShowArrow(boolean z3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowArrow(z3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowNaviRouteNameCountMap(map);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setVisible(boolean z3) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setVisible(z3);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
