package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
final class UnsafeAtomicLongFieldUpdater<T> extends AtomicLongFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicLongFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean compareAndSet(T t3, long j4, long j5) {
        return this.unsafe.compareAndSwapLong(t3, this.offset, j4, j5);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public long get(T t3) {
        return this.unsafe.getLongVolatile(t3, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void lazySet(T t3, long j4) {
        this.unsafe.putOrderedLong(t3, this.offset, j4);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void set(T t3, long j4) {
        this.unsafe.putLongVolatile(t3, this.offset, j4);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean weakCompareAndSet(T t3, long j4, long j5) {
        return this.unsafe.compareAndSwapLong(t3, this.offset, j4, j5);
    }
}
