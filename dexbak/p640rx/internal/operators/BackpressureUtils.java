package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Subscriber;
import p640rx.functions.Func1;
import p640rx.internal.util.UtilityFunctions;

/* renamed from: rx.internal.operators.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BackpressureUtils {

    /* renamed from: a */
    static final long f44874a = Long.MIN_VALUE;

    /* renamed from: b */
    static final long f44875b = Long.MAX_VALUE;

    private BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static long m1336a(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    /* renamed from: b */
    public static long m1335b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, m1336a(j2, j)));
        return j2;
    }

    /* renamed from: c */
    public static long m1334c(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j2 == 0 || j3 / j2 == j) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: d */
    public static <T> void m1333d(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super T> subscriber) {
        m1332e(atomicLong, queue, subscriber, UtilityFunctions.m803c());
    }

    /* renamed from: e */
    public static <T, R> void m1332e(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j;
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j, Long.MIN_VALUE | j));
        if (j != 0) {
            m1331f(atomicLong, queue, subscriber, func1);
        }
    }

    /* renamed from: f */
    static <T, R> void m1331f(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j = atomicLong.get();
        if (j == Long.MAX_VALUE) {
            while (!subscriber.isUnsubscribed()) {
                Object poll = queue.poll();
                if (poll == null) {
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onNext((R) func1.call(poll));
            }
            return;
        }
        do {
            long j2 = Long.MIN_VALUE;
            while (true) {
                if (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    Object poll2 = queue.poll();
                    if (poll2 == null) {
                        subscriber.onCompleted();
                        return;
                    } else {
                        subscriber.onNext((R) func1.call(poll2));
                        j2++;
                    }
                } else {
                    if (j2 == j) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (queue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    j = atomicLong.get();
                    if (j == j2) {
                        j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    }
                }
            }
        } while (j != Long.MIN_VALUE);
    }

    /* renamed from: g */
    public static <T> boolean m1330g(AtomicLong atomicLong, long j, Queue<T> queue, Subscriber<? super T> subscriber) {
        return m1329h(atomicLong, j, queue, subscriber, UtilityFunctions.m803c());
    }

    /* renamed from: h */
    public static <T, R> boolean m1329h(AtomicLong atomicLong, long j, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j2;
        long j3;
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        } else if (j == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        } else {
            while (true) {
                j2 = atomicLong.get();
                j3 = j2 & Long.MIN_VALUE;
                if (atomicLong.compareAndSet(j2, m1336a(Long.MAX_VALUE & j2, j) | j3)) {
                    break;
                }
            }
            if (j2 != Long.MIN_VALUE) {
                return j3 == 0;
            }
            m1331f(atomicLong, queue, subscriber, func1);
            return false;
        }
    }

    /* renamed from: i */
    public static long m1328i(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException("More produced than requested: " + j3);
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    /* renamed from: j */
    public static boolean m1327j(long j) {
        if (j >= 0) {
            return j != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }
}
