package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.github.mikephil.charting.utils.Utils;
import java.util.concurrent.atomic.AtomicInteger;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: sX */
    private double f8423sX = 2.21010267E8d;
    @JBindingInclude

    /* renamed from: sY */
    private double f8424sY = 1.01697799E8d;
    private DPoint mapGeoCenter = new DPoint(this.f8423sX, this.f8424sY);
    @JBindingInclude

    /* renamed from: sZ */
    private float f8425sZ = 10.0f;
    @JBindingInclude

    /* renamed from: sC */
    private float f8421sC = 0.0f;
    @JBindingInclude

    /* renamed from: sR */
    private float f8422sR = 0.0f;
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

    public MapConfig(boolean z) {
        this.lastMapconfig = null;
        if (z) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(Utils.DOUBLE_EPSILON);
            this.lastMapconfig.setSY(Utils.DOUBLE_EPSILON);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        float f;
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.f8423sX - sx) + Math.abs(this.f8424sY - sy);
        this.changeRatio = this.changeRatio == Utils.DOUBLE_EPSILON ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.f8425sZ ? 1.0d : Math.abs(sz - f));
        float f2 = this.f8421sC;
        float abs = sc == f2 ? 1.0f : Math.abs(sc - f2);
        float f3 = this.f8422sR;
        float abs2 = sr != f3 ? Math.abs(sr - f3) : 1.0f;
        double d = this.changeRatio;
        double d2 = abs;
        Double.isNaN(d2);
        this.changeRatio = d * d2;
        double d3 = this.changeRatio;
        double d4 = abs2;
        Double.isNaN(d4);
        this.changeRatio = d3 * d4;
        this.changeGridRatio = Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        this.changeGridRatio = this.changeGridRatio != Utils.DOUBLE_EPSILON ? this.changeGridRatio * 2.0d : 1.0d;
        double d5 = this.changeGridRatio;
        Double.isNaN(d2);
        this.changeGridRatio = d5 * d2;
        double d6 = this.changeGridRatio;
        Double.isNaN(d4);
        this.changeGridRatio = d6 * d4;
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
        return this.f8421sC;
    }

    public float getSR() {
        return this.f8422sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.f8423sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.f8424sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.f8425sZ;
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
            double d = this.f8423sX;
            boolean z = true;
            boolean z2 = sx != d;
            this.isCenterChanged = z2;
            double d2 = this.f8424sY;
            if (sy != d2) {
                z2 = true;
            }
            this.isCenterChanged = z2;
            float f = this.f8425sZ;
            boolean z3 = sz != f;
            this.isZoomChanged = z3;
            if (z3) {
                float f2 = this.minZoomLevel;
                if (sz > f2 && f > f2) {
                    float f3 = this.maxZoomLevel;
                    if (sz < f3 && f < f3) {
                        this.isNeedUpdateZoomControllerState = false;
                    }
                }
                this.isNeedUpdateZoomControllerState = true;
            }
            boolean z4 = sc != this.f8421sC;
            this.isTiltChanged = z4;
            boolean z5 = sr != this.f8422sR;
            this.isBearingChanged = z5;
            if (!z2 && !z3 && !z4 && !z5 && !this.isNeedUpdateMapRectNextFrame) {
                z = false;
            }
            if (z) {
                this.isNeedUpdateMapRectNextFrame = false;
                int i = (20 - ((int) f)) + 8;
                setGridXY(((int) d) >> i, ((int) d2) >> i);
                changeRatio();
            }
            return z;
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
    public void setAbroadEnable(boolean z) {
        this.isAbroadEnable = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i) {
        this.abroadState = i;
    }

    public void setAnchorX(int i) {
        this.anchorX = i;
    }

    public void setAnchorY(int i) {
        this.anchorY = i;
    }

    public void setBuildingEnable(boolean z) {
        this.isBuildingEnable = z;
    }

    public void setCustomBackgroundColor(int i) {
        this.customBackgroundColor = i;
    }

    public void setCustomStyleEnable(boolean z) {
        this.isCustomStyleEnabled = z;
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

    protected void setGridXY(int i, int i2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i;
        this.gridY = i2;
    }

    public void setHideLogoEnble(boolean z) {
        this.isHideLogoEnable = z;
    }

    public void setIndoorEnable(boolean z) {
        this.isIndoorEnable = z;
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

    public void setMapEnable(boolean z) {
        this.mapEnable = z;
    }

    public void setMapHeight(int i) {
        this.mapHeight = i;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i) {
        this.mMapStyleMode = i;
    }

    public void setMapStyleTime(int i) {
        this.mMapStyleTime = i;
    }

    public void setMapTextEnable(boolean z) {
        this.isMapTextEnable = z;
    }

    public void setMapWidth(int i) {
        this.mapWidth = i;
    }

    public void setMapZoomScale(float f) {
        this.mapZoomScale = f;
    }

    public void setMaxZoomLevel(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f < getMinZoomLevel()) {
            f = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f;
    }

    public void setMinZoomLevel(float f) {
        if (f < 3.0f) {
            f = 3.0f;
        }
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f > getMaxZoomLevel()) {
            f = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f;
    }

    public void setProFunctionAuthEnable(boolean z) {
        this.isProFunctionAuthEnable = z;
    }

    public void setSC(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.f8421sC);
        }
        this.f8421sC = f;
    }

    public void setSR(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.f8422sR);
        }
        this.f8422sR = f;
    }

    public void setSX(double d) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.f8423sX);
        }
        this.f8423sX = d;
        this.mapGeoCenter.f7977x = d;
    }

    public void setSY(double d) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.f8424sY);
        }
        this.f8424sY = d;
        this.mapGeoCenter.f7977x = d;
    }

    public void setSZ(float f) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.f8425sZ);
        }
        this.f8425sZ = f;
    }

    public void setSkyHeight(float f) {
        this.skyHeight = f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z) {
        this.isTerrainEnable = z;
    }

    public void setTouchPoiEnable(boolean z) {
        this.isTouchPoiEnable = z;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public void setUseProFunction(boolean z) {
        this.isUseProFunction = z;
    }

    public void setWorldMapEnable(boolean z) {
        this.isWorldMapEnable = z;
    }

    public String toString() {
        return " sX: " + this.f8423sX + " sY: " + this.f8424sY + " sZ: " + this.f8425sZ + " sC: " + this.f8421sC + " sR: " + this.f8422sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z) {
        this.isNeedUpdateMapRectNextFrame = z;
    }
}
