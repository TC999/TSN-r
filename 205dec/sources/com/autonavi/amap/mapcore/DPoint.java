package com.autonavi.amap.mapcore;

import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x  reason: collision with root package name */
    public double f11671x;

    /* renamed from: y  reason: collision with root package name */
    public double f11672y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    private void set(double d4, double d5) {
        this.f11671x = d4;
        this.f11672y = d5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return Double.doubleToLongBits(this.f11671x) == Double.doubleToLongBits(dPoint.f11671x) && Double.doubleToLongBits(this.f11672y) == Double.doubleToLongBits(dPoint.f11672y);
        }
        return false;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint(double d4, double d5) {
        this.f11671x = d4;
        this.f11672y = d5;
    }

    public static DPoint obtain(double d4, double d5) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d4, d5);
        }
        acquire.set(d4, d5);
        return acquire;
    }
}
