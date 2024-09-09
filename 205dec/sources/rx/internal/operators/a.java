package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BackpressureUtils.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final long f62305a = Long.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    static final long f62306b = Long.MAX_VALUE;

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(long j4, long j5) {
        long j6 = j4 + j5;
        if (j6 < 0) {
            return Long.MAX_VALUE;
        }
        return j6;
    }

    public static long b(AtomicLong atomicLong, long j4) {
        long j5;
        do {
            j5 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j5, a(j5, j4)));
        return j5;
    }

    public static long c(long j4, long j5) {
        long j6 = j4 * j5;
        if (((j4 | j5) >>> 31) == 0 || j5 == 0 || j6 / j5 == j4) {
            return j6;
        }
        return Long.MAX_VALUE;
    }

    public static <T> void d(AtomicLong atomicLong, Queue<T> queue, rx.l<? super T> lVar) {
        e(atomicLong, queue, lVar, rx.internal.util.n.c());
    }

    public static <T, R> void e(AtomicLong atomicLong, Queue<T> queue, rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
        long j4;
        do {
            j4 = atomicLong.get();
            if ((j4 & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j4, Long.MIN_VALUE | j4));
        if (j4 != 0) {
            f(atomicLong, queue, lVar, pVar);
        }
    }

    static <T, R> void f(AtomicLong atomicLong, Queue<T> queue, rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
        long j4 = atomicLong.get();
        if (j4 == Long.MAX_VALUE) {
            while (!lVar.isUnsubscribed()) {
                Object poll = queue.poll();
                if (poll == null) {
                    lVar.onCompleted();
                    return;
                }
                lVar.onNext((R) pVar.call(poll));
            }
            return;
        }
        do {
            long j5 = Long.MIN_VALUE;
            while (true) {
                if (j5 != j4) {
                    if (lVar.isUnsubscribed()) {
                        return;
                    }
                    Object poll2 = queue.poll();
                    if (poll2 == null) {
                        lVar.onCompleted();
                        return;
                    } else {
                        lVar.onNext((R) pVar.call(poll2));
                        j5++;
                    }
                } else {
                    if (j5 == j4) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        if (queue.isEmpty()) {
                            lVar.onCompleted();
                            return;
                        }
                    }
                    j4 = atomicLong.get();
                    if (j4 == j5) {
                        j4 = atomicLong.addAndGet(-(j5 & Long.MAX_VALUE));
                    }
                }
            }
        } while (j4 != Long.MIN_VALUE);
    }

    public static <T> boolean g(AtomicLong atomicLong, long j4, Queue<T> queue, rx.l<? super T> lVar) {
        return h(atomicLong, j4, queue, lVar, rx.internal.util.n.c());
    }

    public static <T, R> boolean h(AtomicLong atomicLong, long j4, Queue<T> queue, rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar) {
        long j5;
        long j6;
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        } else if (j4 == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        } else {
            while (true) {
                j5 = atomicLong.get();
                j6 = j5 & Long.MIN_VALUE;
                if (atomicLong.compareAndSet(j5, a(Long.MAX_VALUE & j5, j4) | j6)) {
                    break;
                }
            }
            if (j5 != Long.MIN_VALUE) {
                return j6 == 0;
            }
            f(atomicLong, queue, lVar, pVar);
            return false;
        }
    }

    public static long i(AtomicLong atomicLong, long j4) {
        long j5;
        long j6;
        do {
            j5 = atomicLong.get();
            if (j5 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j6 = j5 - j4;
            if (j6 < 0) {
                throw new IllegalStateException("More produced than requested: " + j6);
            }
        } while (!atomicLong.compareAndSet(j5, j6));
        return j6;
    }

    public static boolean j(long j4) {
        if (j4 >= 0) {
            return j4 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j4);
    }
}
