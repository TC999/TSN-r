package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class UnsafeAtomicReferenceFieldUpdater<U, M> extends AtomicReferenceFieldUpdater<U, M> {
    private final long offset;
    private final Unsafe unsafe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeAtomicReferenceFieldUpdater(Unsafe unsafe, Class<? super U> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isVolatile(declaredField.getModifiers())) {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(declaredField);
            return;
        }
        throw new IllegalArgumentException("Must be volatile");
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean compareAndSet(U u, M m, M m2) {
        return C14084a.m12679a(this.unsafe, u, this.offset, m, m2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public M get(U u) {
        return (M) this.unsafe.getObjectVolatile(u, this.offset);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void lazySet(U u, M m) {
        this.unsafe.putOrderedObject(u, this.offset, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void set(U u, M m) {
        this.unsafe.putObjectVolatile(u, this.offset, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean weakCompareAndSet(U u, M m, M m2) {
        return C14084a.m12679a(this.unsafe, u, this.offset, m, m2);
    }
}
