package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;

    /* renamed from: x  reason: collision with root package name */
    public double f37330x;

    /* renamed from: y  reason: collision with root package name */
    public double f37331y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    private MPPointD(double d4, double d5) {
        this.f37330x = d4;
        this.f37331y = d5;
    }

    public static MPPointD getInstance(double d4, double d5) {
        MPPointD mPPointD = pool.get();
        mPPointD.f37330x = d4;
        mPPointD.f37331y = d5;
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
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f37330x + ", y: " + this.f37331y;
    }
}
