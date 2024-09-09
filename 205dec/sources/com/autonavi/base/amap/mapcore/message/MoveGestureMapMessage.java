package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    public MoveGestureMapMessage(int i4, float f4, float f5) {
        super(i4);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f4;
        this.touchDeltaY = f5;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i4, float f4, float f5, float f6, float f7) {
        MoveGestureMapMessage acquire;
        synchronized (MoveGestureMapMessage.class) {
            acquire = M_POOL.acquire();
            if (acquire == null) {
                acquire = new MoveGestureMapMessage(i4, f4, f5);
            } else {
                acquire.reset();
                acquire.setParams(i4, f4, f5);
            }
            acquire.touchX = (int) f6;
            acquire.touchY = (int) f7;
        }
        return acquire;
    }

    private void setParams(int i4, float f4, float f5) {
        setState(i4);
        this.touchDeltaX = f4;
        this.touchDeltaY = f5;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        int i4 = this.touchX - ((int) this.touchDeltaX);
        int i5 = this.touchY - ((int) this.touchDeltaY);
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, obtain);
        IPoint obtain2 = IPoint.obtain();
        win2geo(gLMapState, i4, i5, obtain2);
        IPoint obtain3 = IPoint.obtain();
        gLMapState.getMapGeoCenter(obtain3);
        gLMapState.setMapGeoCenter(((Point) obtain3).x + (((Point) obtain2).x - ((Point) obtain).x), ((Point) obtain3).y + (((Point) obtain2).y - ((Point) obtain).y));
        gLMapState.recalculate();
        obtain3.recycle();
        obtain.recycle();
        obtain2.recycle();
    }
}
