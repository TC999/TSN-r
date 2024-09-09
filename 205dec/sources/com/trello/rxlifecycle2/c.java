package com.trello.rxlifecycle2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.reactivestreams.Publisher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LifecycleTransformer.java */
@ParametersAreNonnullByDefault
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class c<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    /* renamed from: a  reason: collision with root package name */
    final Observable<?> f52385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Observable<?> observable) {
        x0.a.a(observable, "observable == null");
        this.f52385a = observable;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        return observable.takeUntil(this.f52385a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f52385a.equals(((c) obj).f52385a);
    }

    public int hashCode() {
        return this.f52385a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f52385a + '}';
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return flowable.takeUntil(this.f52385a.toFlowable(BackpressureStrategy.LATEST));
    }

    @Override // io.reactivex.SingleTransformer
    public SingleSource<T> apply(Single<T> single) {
        return single.takeUntil(this.f52385a.firstOrError());
    }

    @Override // io.reactivex.MaybeTransformer
    public MaybeSource<T> apply(Maybe<T> maybe) {
        return maybe.takeUntil(this.f52385a.firstElement());
    }

    @Override // io.reactivex.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        return Completable.ambArray(completable, this.f52385a.flatMapCompletable(a.f52370c));
    }
}
