package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class UnsafeAtomicLongFieldUpdater<T> extends AtomicLongFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeAtomicLongFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean compareAndSet(T t, long j, long j2) {
        return this.unsafe.compareAndSwapLong(t, this.offset, j, j2);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public long get(T t) {
        return this.unsafe.getLongVolatile(t, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void lazySet(T t, long j) {
        this.unsafe.putOrderedLong(t, this.offset, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void set(T t, long j) {
        this.unsafe.putLongVolatile(t, this.offset, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean weakCompareAndSet(T t, long j, long j2) {
        return this.unsafe.compareAndSwapLong(t, this.offset, j, j2);
    }
}
