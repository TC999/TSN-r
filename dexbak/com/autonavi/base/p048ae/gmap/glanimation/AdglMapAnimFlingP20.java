package com.autonavi.base.p048ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.p048ae.gmap.GLMapState;

/* renamed from: com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i) {
        reset();
        this.duration = i;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f = this.velocityScreenX;
        int i = this.duration;
        float f2 = (f * i) / 2000.0f;
        float f3 = (this.velocityScreenY * i) / 2000.0f;
        if (Math.abs(f2) != 0.0f && Math.abs(f3) != 0.0f) {
            this.isOver = false;
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((Point) obtain).x, ((Point) obtain).y);
            float mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double mapAngle = gLMapState.getMapAngle();
            Double.isNaN(mapAngle);
            double d = (mapAngle * 3.141592653589793d) / 180.0d;
            double d2 = ((Point) obtain).x;
            double d3 = mapLenWithWin;
            double d4 = f2;
            double cos = Math.cos(d);
            Double.isNaN(d4);
            double d5 = f3;
            double sin = Math.sin(d);
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d2);
            double d6 = d2 - (((cos * d4) - (sin * d5)) * d3);
            double d7 = ((Point) obtain).y;
            double sin2 = Math.sin(d);
            Double.isNaN(d4);
            double cos2 = Math.cos(d);
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d7);
            this.moveParam.setToValue(d6, d7 - (d3 * ((d4 * sin2) + (d5 * cos2))));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.p048ae.gmap.glanimation.AbstractAdglAnimation
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
        float f = ((float) uptimeMillis) / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        }
        if (f < 0.0f || f > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f);
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

    public void setPositionAndVelocity(float f, float f2) {
        this.moveParam = null;
        this.velocityScreenX = f;
        this.velocityScreenY = f2;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
