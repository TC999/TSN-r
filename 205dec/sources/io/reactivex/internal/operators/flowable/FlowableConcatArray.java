package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {
    final boolean delayError;
    final Publisher<? extends T>[] sources;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final Subscriber<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final Publisher<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z3, Subscriber<? super T> subscriber) {
            this.actual = subscriber;
            this.sources = publisherArr;
            this.delayError = z3;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.sources;
                int length = publisherArr.length;
                int i4 = this.index;
                while (i4 != length) {
                    Publisher<? extends T> publisher = publisherArr[i4];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.delayError) {
                            List list = this.errors;
                            if (list == null) {
                                list = new ArrayList((length - i4) + 1);
                                this.errors = list;
                            }
                            list.add(nullPointerException);
                            i4++;
                        } else {
                            this.actual.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j4 = this.produced;
                        if (j4 != 0) {
                            this.produced = 0L;
                            produced(j4);
                        }
                        publisher.subscribe(this);
                        i4++;
                        this.index = i4;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.errors;
                if (list2 != null) {
                    if (list2.size() == 1) {
                        this.actual.onError(list2.get(0));
                        return;
                    } else {
                        this.actual.onError(new CompositeException(list2));
                        return;
                    }
                }
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.delayError) {
                List list = this.errors;
                if (list == null) {
                    list = new ArrayList((this.sources.length - this.index) + 1);
                    this.errors = list;
                }
                list.add(th);
                onComplete();
                return;
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t3) {
            this.produced++;
            this.actual.onNext(t3);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z3) {
        this.sources = publisherArr;
        this.delayError = z3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.sources, this.delayError, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
