package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean checkTerminated(boolean z3, boolean z4, Subscriber<?> subscriber, boolean z5, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.cancelled()) {
            simpleQueue.clear();
            return true;
        } else if (z3) {
            if (z5) {
                if (z4) {
                    Throwable error = queueDrain.error();
                    if (error != null) {
                        subscriber.onError(error);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable error2 = queueDrain.error();
            if (error2 != null) {
                simpleQueue.clear();
                subscriber.onError(error2);
                return true;
            } else if (z4) {
                subscriber.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T> SimpleQueue<T> createQueue(int i4) {
        if (i4 < 0) {
            return new SpscLinkedArrayQueue(-i4);
        }
        return new SpscArrayQueue(i4);
    }

    public static <T, U> void drainLoop(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z3, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int i4 = 1;
        while (!checkTerminated(observableQueueDrain.done(), simplePlainQueue.isEmpty(), observer, z3, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean done = observableQueueDrain.done();
                T poll = simplePlainQueue.poll();
                boolean z4 = poll == null;
                if (checkTerminated(done, z4, observer, z3, simplePlainQueue, disposable, observableQueueDrain)) {
                    return;
                }
                if (z4) {
                    i4 = observableQueueDrain.leave(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    observableQueueDrain.accept(observer, poll);
                }
            }
        }
    }

    public static <T, U> void drainMaxLoop(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean z3, Disposable disposable, QueueDrain<T, U> queueDrain) {
        int i4 = 1;
        while (true) {
            boolean done = queueDrain.done();
            T poll = simplePlainQueue.poll();
            boolean z4 = poll == null;
            if (checkTerminated(done, z4, subscriber, z3, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (z4) {
                i4 = queueDrain.leave(-i4);
                if (i4 == 0) {
                    return;
                }
            } else {
                long requested = queueDrain.requested();
                if (requested != 0) {
                    if (queueDrain.accept(subscriber, poll) && requested != Long.MAX_VALUE) {
                        queueDrain.produced(1L);
                    }
                } else {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            }
        }
    }

    static boolean isCancelled(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return true;
        }
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j4;
        long j5;
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (postCompleteDrain(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
        } else {
            do {
                j4 = atomicLong.get();
                if ((j4 & Long.MIN_VALUE) != 0) {
                    return;
                }
                j5 = j4 | Long.MIN_VALUE;
            } while (!atomicLong.compareAndSet(j4, j5));
            if (j4 != 0) {
                postCompleteDrain(j5, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }

    static <T> boolean postCompleteDrain(long j4, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j5 = j4 & Long.MIN_VALUE;
        while (true) {
            if (j5 != j4) {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(obj);
                j5++;
            } else if (isCancelled(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j4 = atomicLong.get();
                if (j4 == j5) {
                    long addAndGet = atomicLong.addAndGet(-(j5 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j4 = addAndGet;
                    j5 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean postCompleteRequest(long j4, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j5;
        do {
            j5 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j5, BackpressureHelper.addCap(Long.MAX_VALUE & j5, j4) | (j5 & Long.MIN_VALUE)));
        if (j5 == Long.MIN_VALUE) {
            postCompleteDrain(j4 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
            return true;
        }
        return false;
    }

    public static void request(Subscription subscription, int i4) {
        subscription.request(i4 < 0 ? Long.MAX_VALUE : i4);
    }

    public static <T, U> boolean checkTerminated(boolean z3, boolean z4, Observer<?> observer, boolean z5, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.cancelled()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (z3) {
            if (z5) {
                if (z4) {
                    disposable.dispose();
                    Throwable error = observableQueueDrain.error();
                    if (error != null) {
                        observer.onError(error);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable error2 = observableQueueDrain.error();
            if (error2 != null) {
                simpleQueue.clear();
                disposable.dispose();
                observer.onError(error2);
                return true;
            } else if (z4) {
                disposable.dispose();
                observer.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
