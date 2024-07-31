package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class UnsafeAtomicIntegerFieldUpdater<T> extends AtomicIntegerFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeAtomicIntegerFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean compareAndSet(T t, int i, int i2) {
        return this.unsafe.compareAndSwapInt(t, this.offset, i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public int get(T t) {
        return this.unsafe.getIntVolatile(t, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void lazySet(T t, int i) {
        this.unsafe.putOrderedInt(t, this.offset, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void set(T t, int i) {
        this.unsafe.putIntVolatile(t, this.offset, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean weakCompareAndSet(T t, int i, int i2) {
        return this.unsafe.compareAndSwapInt(t, this.offset, i, i2);
    }
}
