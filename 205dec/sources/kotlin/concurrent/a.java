package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Locks.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\t\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\n"}, d2 = {"T", "Ljava/util/concurrent/locks/Lock;", "Lkotlin/Function0;", "action", "b", "(Ljava/util/concurrent/locks/Lock;Ld2/a;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "a", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Ld2/a;)Ljava/lang/Object;", "c", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "LocksKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @InlineOnly
    private static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, d2.a<? extends T> action) {
        f0.p(reentrantReadWriteLock, "<this>");
        f0.p(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return action.invoke();
        } finally {
            c0.d(1);
            readLock.unlock();
            c0.c(1);
        }
    }

    @InlineOnly
    private static final <T> T b(Lock lock, d2.a<? extends T> action) {
        f0.p(lock, "<this>");
        f0.p(action, "action");
        lock.lock();
        try {
            return action.invoke();
        } finally {
            c0.d(1);
            lock.unlock();
            c0.c(1);
        }
    }

    @InlineOnly
    private static final <T> T c(ReentrantReadWriteLock reentrantReadWriteLock, d2.a<? extends T> action) {
        f0.p(reentrantReadWriteLock, "<this>");
        f0.p(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i4 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i5 = 0;
        while (i5 < readHoldCount) {
            i5++;
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return action.invoke();
        } finally {
            c0.d(1);
            while (i4 < readHoldCount) {
                i4++;
                readLock.lock();
            }
            writeLock.unlock();
            c0.c(1);
        }
    }
}
