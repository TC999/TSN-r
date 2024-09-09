package com.autonavi.base.amap.mapcore.message;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;

    public HoverGestureMapMessage(int i4, float f4) {
        super(i4);
        this.angleDelta = f4;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i4, float f4) {
        HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new HoverGestureMapMessage(i4, f4);
        } else {
            acquire.reset();
        }
        acquire.setParams(i4, f4);
        return acquire;
    }

    private void setParams(int i4, float f4) {
        setState(i4);
        this.angleDelta = f4;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        if (cameraDegree < 0.0f) {
            cameraDegree = 0.0f;
        } else if (cameraDegree > 80.0f) {
            cameraDegree = 80.0f;
        } else if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
            cameraDegree = 40.0f;
        }
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
