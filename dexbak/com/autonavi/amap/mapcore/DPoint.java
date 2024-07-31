package com.autonavi.amap.mapcore;

import com.autonavi.base.p048ae.gmap.maploader.Pools;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x */
    public double f7977x;

    /* renamed from: y */
    public double f7978y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
        return acquire;
    }

    private void set(double d, double d2) {
        this.f7977x = d;
        this.f7978y = d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return Double.doubleToLongBits(this.f7977x) == Double.doubleToLongBits(dPoint.f7977x) && Double.doubleToLongBits(this.f7978y) == Double.doubleToLongBits(dPoint.f7978y);
        }
        return false;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint(double d, double d2) {
        this.f7977x = d;
        this.f7978y = d2;
    }

    public static DPoint obtain(double d, double d2) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d, d2);
        }
        acquire.set(d, d2);
        return acquire;
    }
}
