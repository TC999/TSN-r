package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        protected abstract Poolable instantiate();
    }

    private ObjectPool(int i, T t) {
        if (i > 0) {
            this.desiredCapacity = i;
            this.objects = new Object[i];
            this.objectsPointer = 0;
            this.modelObject = t;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool create(int i, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i, poolable);
            int i2 = ids;
            objectPool.poolId = i2;
            ids = i2 + 1;
        }
        return objectPool;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void resizePool() {
        int i = this.desiredCapacity;
        int i2 = i * 2;
        this.desiredCapacity = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.objects[i3];
        }
        this.objects = objArr;
    }

    public synchronized T get() {
        T t;
        if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
            refillPool();
        }
        Object[] objArr = this.objects;
        int i = this.objectsPointer;
        t = (T) objArr[i];
        t.currentOwnerId = Poolable.NO_OWNER;
        this.objectsPointer = i - 1;
        return t;
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

    public synchronized void recycle(T t) {
        int i = t.currentOwnerId;
        if (i != Poolable.NO_OWNER) {
            if (i == this.poolId) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        int i2 = this.objectsPointer + 1;
        this.objectsPointer = i2;
        if (i2 >= this.objects.length) {
            resizePool();
        }
        t.currentOwnerId = this.poolId;
        this.objects[this.objectsPointer] = t;
    }

    public void setReplenishPercentage(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.replenishPercentage = f;
    }

    private void refillPool(float f) {
        int i = this.desiredCapacity;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.objects[i3] = this.modelObject.instantiate();
        }
        this.objectsPointer = i - 1;
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            resizePool();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            int i2 = t.currentOwnerId;
            if (i2 != Poolable.NO_OWNER) {
                if (i2 == this.poolId) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            t.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer + 1 + i] = t;
        }
        this.objectsPointer += size;
    }
}
