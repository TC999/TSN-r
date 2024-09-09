package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
final class UnsafeAtomicIntegerFieldUpdater<T> extends AtomicIntegerFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicIntegerFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean compareAndSet(T t3, int i4, int i5) {
        return this.unsafe.compareAndSwapInt(t3, this.offset, i4, i5);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public int get(T t3) {
        return this.unsafe.getIntVolatile(t3, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void lazySet(T t3, int i4) {
        this.unsafe.putOrderedInt(t3, this.offset, i4);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void set(T t3, int i4) {
        this.unsafe.putIntVolatile(t3, this.offset, i4);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean weakCompareAndSet(T t3, int i4, int i5) {
        return this.unsafe.compareAndSwapInt(t3, this.offset, i4, i5);
    }
}
