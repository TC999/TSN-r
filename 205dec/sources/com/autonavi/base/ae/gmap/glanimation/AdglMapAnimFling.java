package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    public AdglMapAnimFling(int i4, int i5, int i6) {
        this.screenCenterX = i5;
        this.screenCenterY = i6;
        this.lastMoveX = i5;
        this.lastMoveY = i6;
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
        float f4 = this.velocityX;
        int i4 = this.duration;
        int i5 = (int) ((f4 * i4) / 2000.0f);
        int i6 = (int) ((this.velocityY * i4) / 2000.0f);
        if (Math.abs(i5) != 0 && Math.abs(i6) != 0) {
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - i5, this.screenCenterY - i6);
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void commitAnimationold(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f4 = this.velocityX;
        float f5 = this.velocityY;
        float sqrt = ((float) Math.sqrt((f4 * f4) + (f5 * f5))) / 1000.0f;
        if (sqrt >= 0.1f) {
            float f6 = sqrt * 0.02f;
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - (this.velocityX * f6), this.screenCenterY - (this.velocityY * f6));
            this.needMove = this.moveParam.needToCaculate();
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
        int curXValue = (int) this.moveParam.getCurXValue();
        int curYValue = (int) this.moveParam.getCurYValue();
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point((this.screenCenterX + curXValue) - this.lastMoveX, (this.screenCenterY + curYValue) - this.lastMoveY, obtain);
        gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        this.lastMoveX = curXValue;
        this.lastMoveY = curYValue;
        obtain.recycle();
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f4, float f5) {
        this.moveParam = null;
        this.velocityX = f4;
        this.velocityY = f5;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
