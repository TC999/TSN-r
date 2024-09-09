package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        protected abstract Poolable instantiate();
    }

    private ObjectPool(int i4, T t3) {
        if (i4 > 0) {
            this.desiredCapacity = i4;
            this.objects = new Object[i4];
            this.objectsPointer = 0;
            this.modelObject = t3;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool create(int i4, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i4, poolable);
            int i5 = ids;
            objectPool.poolId = i5;
            ids = i5 + 1;
        }
        return objectPool;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void resizePool() {
        int i4 = this.desiredCapacity;
        int i5 = i4 * 2;
        this.desiredCapacity = i5;
        Object[] objArr = new Object[i5];
        for (int i6 = 0; i6 < i4; i6++) {
            objArr[i6] = this.objects[i6];
        }
        this.objects = objArr;
    }

    public synchronized T get() {
        T t3;
        if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
            refillPool();
        }
        Object[] objArr = this.objects;
        int i4 = this.objectsPointer;
        t3 = (T) objArr[i4];
        t3.currentOwnerId = Poolable.NO_OWNER;
        this.objectsPointer = i4 - 1;
        return t3;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }

    public int getPoolId() {
        return this.poolId;
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    public synchronized void recycle(T t3) {
        int i4 = t3.currentOwnerId;
        if (i4 != Poolable.NO_OWNER) {
            if (i4 == this.poolId) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t3.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        int i5 = this.objectsPointer + 1;
        this.objectsPointer = i5;
        if (i5 >= this.objects.length) {
            resizePool();
        }
        t3.currentOwnerId = this.poolId;
        this.objects[this.objectsPointer] = t3;
    }

    public void setReplenishPercentage(float f4) {
        if (f4 > 1.0f) {
            f4 = 1.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.replenishPercentage = f4;
    }

    private void refillPool(float f4) {
        int i4 = this.desiredCapacity;
        int i5 = (int) (i4 * f4);
        if (i5 < 1) {
            i4 = 1;
        } else if (i5 <= i4) {
            i4 = i5;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            this.objects[i6] = this.modelObject.instantiate();
        }
        this.objectsPointer = i4 - 1;
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            resizePool();
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            T t3 = list.get(i4);
            int i5 = t3.currentOwnerId;
            if (i5 != Poolable.NO_OWNER) {
                if (i5 == this.poolId) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t3.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            t3.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer + 1 + i4] = t3;
        }
        this.objectsPointer += size;
    }
}
