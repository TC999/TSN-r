package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MapConfig implements IMapConfig, Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_MAINTHREAD_TRIGGER = 30;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private String customTextureResourcePath;
    private boolean isSetLimitZoomLevel;
    MapConfig lastMapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;
    @JBindingInclude
    private int mapHeight;
    @JBindingInclude
    private float mapPerPixelUnitLength;
    @JBindingInclude
    private int mapWidth;
    private float skyHeight;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    private FPoint[] mapRect = null;
    @JBindingInclude
    private Rectangle geoRectangle = new Rectangle();
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isCustomStyleEnabled = false;
    @JBindingInclude
    private double sX = 2.21010267E8d;
    @JBindingInclude
    private double sY = 1.01697799E8d;
    private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);
    @JBindingInclude
    private float sZ = 10.0f;
    @JBindingInclude
    private float sC = 0.0f;
    @JBindingInclude
    private float sR = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private int mMapStyleMode = 0;
    private int mMapStyleTime = 0;
    private int anchorX = 0;
    private String mMapLanguage = "zh_cn";
    private boolean isHideLogoEnable = false;
    private boolean isWorldMapEnable = false;
    private boolean isTouchPoiEnable = true;
    private int abroadState = 1;
    private boolean isAbroadEnable = false;
    private boolean isTerrainEnable = false;
    @JBindingInclude
    float[] viewMatrix = new float[16];
    @JBindingInclude
    float[] projectionMatrix = new float[16];
    @JBindingInclude
    float[] mvpMatrix = new float[16];
    @JBindingInclude
    private int[] tilsIDs = new int[100];
    private boolean mapEnable = true;
    private int anchorY = 0;
    private boolean isProFunctionAuthEnable = true;
    private boolean isUseProFunction = false;
    private int customBackgroundColor = -1;
    private float mapZoomScale = 1.0f;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int gridX = 0;
    private int gridY = 0;

    public MapConfig(boolean z3) {
        this.lastMapconfig = null;
        if (z3) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(0.0d);
            this.lastMapconfig.setSY(0.0d);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        float f4;
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sX - sx) + Math.abs(this.sY - sy);
        this.changeRatio = this.changeRatio == 0.0d ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.sZ ? 1.0d : Math.abs(sz - f4));
        float f5 = this.sC;
        float abs = sc == f5 ? 1.0f : Math.abs(sc - f5);
        float f6 = this.sR;
        float abs2 = sr != f6 ? Math.abs(sr - f6) : 1.0f;
        double d4 = this.changeRatio;
        double d5 = abs;
        Double.isNaN(d5);
        this.changeRatio = d4 * d5;
        double d6 = this.changeRatio;
        double d7 = abs2;
        Double.isNaN(d7);
        this.changeRatio = d6 * d7;
        this.changeGridRatio = Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        this.changeGridRatio = this.changeGridRatio != 0.0d ? this.changeGridRatio * 2.0d : 1.0d;
        double d8 = this.changeGridRatio;
        Double.isNaN(d5);
        this.changeGridRatio = d8 * d5;
        double d9 = this.changeGridRatio;
        Double.isNaN(d7);
        this.changeGridRatio = d9 * d7;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    protected int getGridX() {
        return this.gridX;
    }

    protected int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            double sx = mapConfig.getSX();
            double sy = this.lastMapconfig.getSY();
            float sz = this.lastMapconfig.getSZ();
            float sc = this.lastMapconfig.getSC();
            float sr = this.lastMapconfig.getSR();
            double d4 = this.sX;
            boolean z3 = true;
            boolean z4 = sx != d4;
            this.isCenterChanged = z4;
            double d5 = this.sY;
            if (sy != d5) {
                z4 = true;
            }
            this.isCenterChanged = z4;
            float f4 = this.sZ;
            boolean z5 = sz != f4;
            this.isZoomChanged = z5;
            if (z5) {
                float f5 = this.minZoomLevel;
                if (sz > f5 && f4 > f5) {
                    float f6 = this.maxZoomLevel;
                    if (sz < f6 && f4 < f6) {
                        this.isNeedUpdateZoomControllerState = false;
                    }
                }
                this.isNeedUpdateZoomControllerState = true;
            }
            boolean z6 = sc != this.sC;
            this.isTiltChanged = z6;
            boolean z7 = sr != this.sR;
            this.isBearingChanged = z7;
            if (!z4 && !z5 && !z6 && !z7 && !this.isNeedUpdateMapRectNextFrame) {
                z3 = false;
            }
            if (z3) {
                this.isNeedUpdateMapRectNextFrame = false;
                int i4 = (20 - ((int) f4)) + 8;
                setGridXY(((int) d4) >> i4, ((int) d5) >> i4);
                changeRatio();
            }
            return z3;
        }
        return false;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean z3) {
        this.isAbroadEnable = z3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i4) {
        this.abroadState = i4;
    }

    public void setAnchorX(int i4) {
        this.anchorX = i4;
    }

    public void setAnchorY(int i4) {
        this.anchorY = i4;
    }

    public void setBuildingEnable(boolean z3) {
        this.isBuildingEnable = z3;
    }

    public void setCustomBackgroundColor(int i4) {
        this.customBackgroundColor = i4;
    }

    public void setCustomStyleEnable(boolean z3) {
        this.isCustomStyleEnabled = z3;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    protected void setGridXY(int i4, int i5) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i4;
        this.gridY = i5;
    }

    public void setHideLogoEnble(boolean z3) {
        this.isHideLogoEnable = z3;
    }

    public void setIndoorEnable(boolean z3) {
        this.isIndoorEnable = z3;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z3) {
        this.mapEnable = z3;
    }

    public void setMapHeight(int i4) {
        this.mapHeight = i4;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i4) {
        this.mMapStyleMode = i4;
    }

    public void setMapStyleTime(int i4) {
        this.mMapStyleTime = i4;
    }

    public void setMapTextEnable(boolean z3) {
        this.isMapTextEnable = z3;
    }

    public void setMapWidth(int i4) {
        this.mapWidth = i4;
    }

    public void setMapZoomScale(float f4) {
        this.mapZoomScale = f4;
    }

    public void setMaxZoomLevel(float f4) {
        if (f4 > 20.0f) {
            f4 = 20.0f;
        }
        if (f4 < 3.0f) {
            f4 = 3.0f;
        }
        if (f4 < getMinZoomLevel()) {
            f4 = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f4;
    }

    public void setMinZoomLevel(float f4) {
        if (f4 < 3.0f) {
            f4 = 3.0f;
        }
        if (f4 > 20.0f) {
            f4 = 20.0f;
        }
        if (f4 > getMaxZoomLevel()) {
            f4 = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f4;
    }

    public void setProFunctionAuthEnable(boolean z3) {
        this.isProFunctionAuthEnable = z3;
    }

    public void setSC(float f4) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f4;
    }

    public void setSR(float f4) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f4;
    }

    public void setSX(double d4) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d4;
        this.mapGeoCenter.f11671x = d4;
    }

    public void setSY(double d4) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d4;
        this.mapGeoCenter.f11671x = d4;
    }

    public void setSZ(float f4) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f4;
    }

    public void setSkyHeight(float f4) {
        this.skyHeight = f4;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z3) {
        this.isTerrainEnable = z3;
    }

    public void setTouchPoiEnable(boolean z3) {
        this.isTouchPoiEnable = z3;
    }

    public void setTrafficEnabled(boolean z3) {
        this.isTrafficEnabled = z3;
    }

    public void setUseProFunction(boolean z3) {
        this.isUseProFunction = z3;
    }

    public void setWorldMapEnable(boolean z3) {
        this.isWorldMapEnable = z3;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z3) {
        this.isNeedUpdateMapRectNextFrame = z3;
    }
}
