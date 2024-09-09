package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FPoint extends PointF {
    private static final Pools.SynchronizedPool<FPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public FPoint() {
    }

    public static FPoint obtain() {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint();
        }
        acquire.set(0.0f, 0.0f);
        return acquire;
    }

    @Override // android.graphics.PointF
    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        return fPoint != null && ((PointF) this).x == ((PointF) fPoint).x && ((PointF) this).y == ((PointF) fPoint).y;
    }

    @Override // android.graphics.PointF
    public int hashCode() {
        Float.floatToIntBits(((PointF) this).x);
        return Float.floatToIntBits(((PointF) this).y) * 37;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public FPoint(float f4, float f5) {
        ((PointF) this).x = f4;
        ((PointF) this).y = f5;
    }

    public static FPoint obtain(float f4, float f5) {
        FPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new FPoint(f4, f5);
        }
        acquire.set(f4, f5);
        return acquire;
    }
}
