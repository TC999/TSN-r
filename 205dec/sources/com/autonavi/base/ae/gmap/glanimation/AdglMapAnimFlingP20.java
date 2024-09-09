package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i4) {
        reset();
        this.duration = i4;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f4 = this.velocityScreenX;
        int i4 = this.duration;
        float f5 = (f4 * i4) / 2000.0f;
        float f6 = (this.velocityScreenY * i4) / 2000.0f;
        if (Math.abs(f5) != 0.0f && Math.abs(f6) != 0.0f) {
            this.isOver = false;
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((Point) obtain).x, ((Point) obtain).y);
            float mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double mapAngle = gLMapState.getMapAngle();
            Double.isNaN(mapAngle);
            double d4 = (mapAngle * 3.141592653589793d) / 180.0d;
            double d5 = ((Point) obtain).x;
            double d6 = mapLenWithWin;
            double d7 = f5;
            double cos = Math.cos(d4);
            Double.isNaN(d7);
            double d8 = f6;
            double sin = Math.sin(d4);
            Double.isNaN(d8);
            Double.isNaN(d6);
            Double.isNaN(d5);
            double d9 = d5 - (((cos * d7) - (sin * d8)) * d6);
            double d10 = ((Point) obtain).y;
            double sin2 = Math.sin(d4);
            Double.isNaN(d7);
            double cos2 = Math.cos(d4);
            Double.isNaN(d8);
            Double.isNaN(d6);
            Double.isNaN(d10);
            this.moveParam.setToValue(d9, d10 - (d6 * ((d7 * sin2) + (d8 * cos2))));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
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
        float f4 = ((float) uptimeMillis) / this.duration;
        if (f4 > 1.0f) {
            this.isOver = true;
            f4 = 1.0f;
        }
        if (f4 < 0.0f || f4 > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f4);
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f4, float f5) {
        this.moveParam = null;
        this.velocityScreenX = f4;
        this.velocityScreenY = f5;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
