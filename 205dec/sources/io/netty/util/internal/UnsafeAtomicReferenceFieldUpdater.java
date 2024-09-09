package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
final class UnsafeAtomicReferenceFieldUpdater<U, M> extends AtomicReferenceFieldUpdater<U, M> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicReferenceFieldUpdater(Unsafe unsafe, Class<? super U> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean compareAndSet(U u3, M m4, M m5) {
        return a.a(this.unsafe, u3, this.offset, m4, m5);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public M get(U u3) {
        return (M) this.unsafe.getObjectVolatile(u3, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void lazySet(U u3, M m4) {
        this.unsafe.putOrderedObject(u3, this.offset, m4);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void set(U u3, M m4) {
        this.unsafe.putObjectVolatile(u3, this.offset, m4);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean weakCompareAndSet(U u3, M m4, M m5) {
        return a.a(this.unsafe, u3, this.offset, m4, m5);
    }
}
