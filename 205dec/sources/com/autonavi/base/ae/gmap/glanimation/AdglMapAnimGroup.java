package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomStartParam = null;
    AbstractAdglAnimationParam1V zoomEndParam = null;
    AbstractAdglAnimationParam2V moveParam = null;
    AbstractAdglAnimationParam1V rotateMapParam = null;
    AbstractAdglAnimationParam1V rotateCameraParam = null;

    public AdglMapAnimGroup(int i4) {
        reset();
        this.duration = i4;
    }

    public static boolean checkLevel(float f4) {
        return f4 >= 3.0f && f4 <= 20.0f;
    }

    private void initZoomEndParam(float f4, float f5, int i4) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i4, 1.0f);
        this.zoomEndParam.setToValue(f5);
        this.zoomEndParam.setFromValue(f4);
    }

    private void initZoomStartParam(float f4, int i4) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i4, 1.0f);
        this.zoomStartParam.setToValue(f4);
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (this.needZoom) {
            if (this.zoomStartParam == null) {
                this.hasCheckParams = true;
                return;
            }
            float mapZoomer = gLMapState.getMapZoomer();
            this.zoomStartParam.setFromValue(mapZoomer);
            if (this.hasMidZoom) {
                float toValue = this.zoomStartParam.getToValue() - mapZoomer;
                float fromValue = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                if (Math.abs(toValue) >= 1.0E-6d && Math.abs(fromValue) >= 1.0E-6d) {
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam.needToCaculate();
                } else {
                    this.hasMidZoom = false;
                    this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam = null;
                }
            }
            if (!this.hasMidZoom && Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6d) {
                this.needZoom = false;
            }
            if (this.needZoom) {
                if (this.hasMidZoom) {
                    int i4 = (this.duration - this.midZoomDuration) >> 1;
                    this.startZoomDuration = i4;
                    this.endZoomDuration = i4;
                } else {
                    this.startZoomDuration = this.duration;
                }
            }
        }
        if (this.needMove && this.moveParam != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            int i5 = ((Point) obtain).x;
            int i6 = ((Point) obtain).y;
            obtain.recycle();
            this.moveParam.setFromValue(i5, i6);
            this.needMove = this.moveParam.needToCaculate();
        }
        if (this.needRotateMap && this.rotateMapParam != null) {
            float mapAngle = gLMapState.getMapAngle();
            float toValue2 = this.rotateMapParam.getToValue();
            if (mapAngle > 180.0f && toValue2 == 0.0f) {
                toValue2 = 360.0f;
            }
            float f4 = ((int) toValue2) - ((int) mapAngle);
            if (f4 > 180.0f) {
                toValue2 -= 360.0f;
            } else if (f4 < -180.0f) {
                toValue2 += 360.0f;
            }
            this.rotateMapParam.setFromValue(mapAngle);
            this.rotateMapParam.setToValue(toValue2);
            this.needRotateMap = this.rotateMapParam.needToCaculate();
        }
        if (this.needRotateCamera && this.rotateCameraParam != null) {
            this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
            this.needRotateCamera = this.rotateCameraParam.needToCaculate();
        }
        if (!this.needMove && !this.needZoom && !this.needRotateMap && !this.needRotateCamera) {
            this.isOver = true;
        } else {
            this.isOver = false;
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        float curValue;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        int i4 = this.duration;
        if (i4 == 0.0f) {
            this.isOver = true;
            return;
        }
        float f4 = ((float) uptimeMillis) / i4;
        if (f4 > 1.0f) {
            this.isOver = true;
            f4 = 1.0f;
        } else if (f4 < 0.0f) {
            this.isOver = true;
            return;
        }
        if (this.needZoom) {
            gLMapState.getMapZoomer();
            if (this.hasMidZoom) {
                long j4 = this.offsetTime;
                int i5 = this.startZoomDuration;
                if (j4 <= i5) {
                    this.zoomStartParam.setNormalizedTime(((float) j4) / i5);
                    curValue = this.zoomStartParam.getCurValue();
                } else {
                    int i6 = this.midZoomDuration;
                    if (j4 <= i5 + i6) {
                        curValue = this.zoomStartParam.getToValue();
                    } else {
                        this.zoomEndParam.setNormalizedTime(((float) ((j4 - i5) - i6)) / this.endZoomDuration);
                        curValue = this.zoomEndParam.getCurValue();
                    }
                }
                if (this.isOver) {
                    curValue = this.zoomEndParam.getToValue();
                }
            } else {
                this.zoomStartParam.setNormalizedTime(f4);
                curValue = this.zoomStartParam.getCurValue();
            }
            gLMapState.setMapZoomer(curValue);
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null && this.needMove) {
            abstractAdglAnimationParam2V.setNormalizedTime(f4);
            int fromXValue = (int) this.moveParam.getFromXValue();
            int fromYValue = (int) this.moveParam.getFromYValue();
            float curMult = this.moveParam.getCurMult();
            gLMapState.setMapGeoCenter(fromXValue + ((int) ((((int) this.moveParam.getToXValue()) - fromXValue) * curMult)), fromYValue + ((int) ((((int) this.moveParam.getToYValue()) - fromYValue) * curMult)));
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null && this.needRotateMap) {
            abstractAdglAnimationParam1V.setNormalizedTime(f4);
            gLMapState.setMapAngle((int) this.rotateMapParam.getCurValue());
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V2 == null || !this.needRotateCamera) {
            return;
        }
        abstractAdglAnimationParam1V2.setNormalizedTime(f4);
        gLMapState.setCameraDegree((int) this.rotateCameraParam.getCurValue());
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomStartParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
    }

    public void setDuration(int i4) {
        this.duration = i4;
    }

    public void setToCameraDegree(float f4, int i4) {
        this.needRotateCamera = false;
        if (f4 > 80.0f || f4 < 0.0f) {
            return;
        }
        this.needRotateCamera = true;
        if (this.rotateCameraParam == null) {
            this.rotateCameraParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(i4, 1.0f);
        this.rotateCameraParam.setToValue(f4);
    }

    public void setToMapAngle(float f4, int i4) {
        float f5 = f4 % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i4, 1.0f);
        this.rotateMapParam.setToValue(f5);
    }

    public void setToMapCenterGeo(int i4, int i5, int i6) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.needMove = true;
        if (this.moveParam == null) {
            this.moveParam = new AbstractAdglAnimationParam2V();
        }
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(i6, 1.0f);
        this.moveParam.setToValue(i4, i5);
    }

    public void setToMapLevel(float f4, int i4) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f4)) {
            initZoomStartParam(f4, i4);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }

    public void setToMapLevel(float f4, float f5, int i4) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i4 > 0 && i4 < this.duration) {
            this.midZoomDuration = i4;
        }
        if (checkLevel(f4) && checkLevel(f5)) {
            this.hasMidZoom = true;
            initZoomStartParam(f5, 0);
            initZoomEndParam(f5, f4, 0);
        } else if (checkLevel(f4)) {
            this.hasMidZoom = false;
            initZoomStartParam(f4, 0);
        } else if (checkLevel(f5)) {
            this.hasMidZoom = false;
            initZoomStartParam(f5, 0);
        } else {
            this.needZoom = false;
        }
    }
}
