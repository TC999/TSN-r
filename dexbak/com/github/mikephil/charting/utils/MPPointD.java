package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;

    /* renamed from: x */
    public double f23781x;

    /* renamed from: y */
    public double f23782y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    private MPPointD(double d, double d2) {
        this.f23781x = d;
        this.f23782y = d2;
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = pool.get();
        mPPointD.f23781x = d;
        mPPointD.f23782y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle((ObjectPool<MPPointD>) mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        pool.recycle(list);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
    }

    public String toString() {
        return "MPPointD, x: " + this.f23781x + ", y: " + this.f23782y;
    }
}
