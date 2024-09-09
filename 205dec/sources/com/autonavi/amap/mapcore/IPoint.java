package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public double distance(IPoint iPoint) {
        return Math.sqrt(Math.pow(((Point) iPoint).x - ((Point) this).x, 2.0d) + Math.pow(((Point) iPoint).y - ((Point) this).y, 2.0d));
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public IPoint(int i4, int i5) {
        ((Point) this).x = i4;
        ((Point) this).y = i5;
    }

    public static IPoint obtain(int i4, int i5) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i4, i5);
        }
        acquire.set(i4, i5);
        return acquire;
    }
}
