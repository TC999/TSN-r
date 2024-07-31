package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.ccg.CcgConstant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.InlineMarker;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/Lock;", "Lkotlin/Function0;", CcgConstant.f38549t, "b", "(Ljava/util/concurrent/locks/Lock;Ll1/a;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "a", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Ll1/a;)Ljava/lang/Object;", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "LocksKt")
/* renamed from: kotlin.concurrent.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Locks {
    @InlineOnly
    /* renamed from: a */
    private static final <T> T m8705a(ReentrantReadWriteLock reentrantReadWriteLock, InterfaceC15269a<? extends T> interfaceC15269a) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            readLock.unlock();
            InlineMarker.m8229c(1);
        }
    }

    @InlineOnly
    /* renamed from: b */
    private static final <T> T m8704b(Lock lock, InterfaceC15269a<? extends T> interfaceC15269a) {
        lock.lock();
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            lock.unlock();
            InlineMarker.m8229c(1);
        }
    }

    @InlineOnly
    /* renamed from: c */
    private static final <T> T m8703c(ReentrantReadWriteLock reentrantReadWriteLock, InterfaceC15269a<? extends T> interfaceC15269a) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return interfaceC15269a.invoke();
        } finally {
            InlineMarker.m8228d(1);
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
            InlineMarker.m8229c(1);
        }
    }
}
