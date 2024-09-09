package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();
    private final int id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractConstant(int i4, String str) {
        this.id = i4;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((AbstractConstant<T>) obj);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.id;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    public final String toString() {
        return name();
    }

    public final int compareTo(T t3) {
        if (this == t3) {
            return 0;
        }
        int hashCode = hashCode() - t3.hashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        long j4 = this.uniquifier;
        long j5 = t3.uniquifier;
        if (j4 < j5) {
            return -1;
        }
        if (j4 > j5) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
